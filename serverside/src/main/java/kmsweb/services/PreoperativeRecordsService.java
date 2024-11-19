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
import kmsweb.repositories.PreoperativeRecordsRepository;
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
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.repositories.CoTreatingDoctorRepository;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.entities.RoomFacilityEntity;
import kmsweb.repositories.RoomFacilityRepository;
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
public class PreoperativeRecordsService extends AbstractService<PreoperativeRecordsEntity, PreoperativeRecordsRepository, PreoperativeRecordsEntityAudit> {

	private final String[] referenceNamesInPreoperativeRecordsEntity = {
		"additionalAnesthesiologists",
		"additionalSurgeryNurses",
		"bedFacilities",
		"coTreatingAnesthesiologists",
		"coTreatingSurgeons",
		"anesthesiaMedicalTranscriber",
		"anesthesiologist",
		"anesthesiologyNurse",
		"preSurgeryICD10",
		"preSurgeryICD9CM",
		"operatingTheaterMedicalExaminationRecord",
		"preoperativeRooms",
		"surgeon",
		"surgicalMedicalTranscriber",
		"surgicalNurse",
	};

	private final BedFacilityRepository bedFacilityRepository;

	private final CoTreatingDoctorRepository coTreatingDoctorRepository;

	private final DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	private final OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	private final RoomFacilityRepository roomFacilityRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PreoperativeRecordsService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BedFacilityRepository bedFacilityRepository,
		CoTreatingDoctorRepository coTreatingDoctorRepository,
		DiagnosesAndProceduresRepository diagnosesAndProceduresRepository,
		OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository,
		RoomFacilityRepository roomFacilityRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PreoperativeRecordsRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bedFacilityRepository = bedFacilityRepository;

		this.coTreatingDoctorRepository = coTreatingDoctorRepository;

		this.diagnosesAndProceduresRepository = diagnosesAndProceduresRepository;

		this.operatingTheaterMedicalExaminationRecordRepository = operatingTheaterMedicalExaminationRecordRepository;

		this.roomFacilityRepository = roomFacilityRepository;

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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByStartDateTime(OffsetDateTime startDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDateTime here] end
	{
		// % protected region % [Add any additional logic for findByStartDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByStartDateTime before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByStartDateTime(startDateTime));

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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByEndDateTime(OffsetDateTime endDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDateTime here] end
	{
		// % protected region % [Add any additional logic for findByEndDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByEndDateTime before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByEndDateTime(endDateTime));

		// % protected region % [Add any additional logic for findByEndDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEndDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Physical Status Evaluation.
	 *
	 * @param physicalStatusEvaluation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physical Status Evaluation
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByPhysicalStatusEvaluation(String physicalStatusEvaluation)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicalStatusEvaluation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicalStatusEvaluation here] end
	{
		// % protected region % [Add any additional logic for findByPhysicalStatusEvaluation before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhysicalStatusEvaluation before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByPhysicalStatusEvaluation(physicalStatusEvaluation));

		// % protected region % [Add any additional logic for findByPhysicalStatusEvaluation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhysicalStatusEvaluation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Risk.
	 *
	 * @param surgeryRisk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Risk
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findBySurgeryRisk(String surgeryRisk)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryRisk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryRisk here] end
	{
		// % protected region % [Add any additional logic for findBySurgeryRisk before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurgeryRisk before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findBySurgeryRisk(surgeryRisk));

		// % protected region % [Add any additional logic for findBySurgeryRisk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurgeryRisk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Psychological State.
	 *
	 * @param psychologicalState the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Psychological State
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByPsychologicalState(String psychologicalState)
	// % protected region % [Add any throwables, implementations, or extensions for findByPsychologicalState here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPsychologicalState here] end
	{
		// % protected region % [Add any additional logic for findByPsychologicalState before the main body here] off begin
		// % protected region % [Add any additional logic for findByPsychologicalState before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByPsychologicalState(psychologicalState));

		// % protected region % [Add any additional logic for findByPsychologicalState before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPsychologicalState before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Surgery Risk.
	 *
	 * @param anesthesiaSurgeryRisk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Surgery Risk
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByAnesthesiaSurgeryRisk(String anesthesiaSurgeryRisk)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaSurgeryRisk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaSurgeryRisk here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaSurgeryRisk before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaSurgeryRisk before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaSurgeryRisk(anesthesiaSurgeryRisk));

		// % protected region % [Add any additional logic for findByAnesthesiaSurgeryRisk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaSurgeryRisk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Preoperative Evaluation.
	 *
	 * @param preoperativeEvaluation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Preoperative Evaluation
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByPreoperativeEvaluation(String preoperativeEvaluation)
	// % protected region % [Add any throwables, implementations, or extensions for findByPreoperativeEvaluation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPreoperativeEvaluation here] end
	{
		// % protected region % [Add any additional logic for findByPreoperativeEvaluation before the main body here] off begin
		// % protected region % [Add any additional logic for findByPreoperativeEvaluation before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByPreoperativeEvaluation(preoperativeEvaluation));

		// % protected region % [Add any additional logic for findByPreoperativeEvaluation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPreoperativeEvaluation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Notes.
	 *
	 * @param anesthesiaNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Notes
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByAnesthesiaNotes(String anesthesiaNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaNotes here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaNotes before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaNotes(anesthesiaNotes));

		// % protected region % [Add any additional logic for findByAnesthesiaNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surgical Specialty.
	 *
	 * @param surgicalSpecialty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgical Specialty
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findBySurgicalSpecialty(String surgicalSpecialty)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgicalSpecialty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgicalSpecialty here] end
	{
		// % protected region % [Add any additional logic for findBySurgicalSpecialty before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurgicalSpecialty before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findBySurgicalSpecialty(surgicalSpecialty));

		// % protected region % [Add any additional logic for findBySurgicalSpecialty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurgicalSpecialty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Antibiotic Prophylaxis Given.
	 *
	 * @param antibioticProphylaxisGiven the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Antibiotic Prophylaxis Given
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByAntibioticProphylaxisGiven(String antibioticProphylaxisGiven)
	// % protected region % [Add any throwables, implementations, or extensions for findByAntibioticProphylaxisGiven here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAntibioticProphylaxisGiven here] end
	{
		// % protected region % [Add any additional logic for findByAntibioticProphylaxisGiven before the main body here] off begin
		// % protected region % [Add any additional logic for findByAntibioticProphylaxisGiven before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAntibioticProphylaxisGiven(antibioticProphylaxisGiven));

		// % protected region % [Add any additional logic for findByAntibioticProphylaxisGiven before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAntibioticProphylaxisGiven before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Type.
	 *
	 * @param surgeryType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Type
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findBySurgeryType(String surgeryType)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryType here] end
	{
		// % protected region % [Add any additional logic for findBySurgeryType before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurgeryType before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findBySurgeryType(surgeryType));

		// % protected region % [Add any additional logic for findBySurgeryType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurgeryType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Class.
	 *
	 * @param surgeryClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Class
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findBySurgeryClass(String surgeryClass)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryClass here] end
	{
		// % protected region % [Add any additional logic for findBySurgeryClass before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurgeryClass before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findBySurgeryClass(surgeryClass));

		// % protected region % [Add any additional logic for findBySurgeryClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurgeryClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surgical Surgery Risk.
	 *
	 * @param surgicalSurgeryRisk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgical Surgery Risk
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findBySurgicalSurgeryRisk(String surgicalSurgeryRisk)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgicalSurgeryRisk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgicalSurgeryRisk here] end
	{
		// % protected region % [Add any additional logic for findBySurgicalSurgeryRisk before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurgicalSurgeryRisk before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findBySurgicalSurgeryRisk(surgicalSurgeryRisk));

		// % protected region % [Add any additional logic for findBySurgicalSurgeryRisk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurgicalSurgeryRisk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Physical Status Classification.
	 *
	 * @param physicalStatusClassification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physical Status Classification
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByPhysicalStatusClassification(String physicalStatusClassification)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicalStatusClassification here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicalStatusClassification here] end
	{
		// % protected region % [Add any additional logic for findByPhysicalStatusClassification before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhysicalStatusClassification before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByPhysicalStatusClassification(physicalStatusClassification));

		// % protected region % [Add any additional logic for findByPhysicalStatusClassification before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhysicalStatusClassification before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pre Surgery Diagnosis.
	 *
	 * @param preSurgeryDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pre Surgery Diagnosis
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByPreSurgeryDiagnosis(String preSurgeryDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByPreSurgeryDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPreSurgeryDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByPreSurgeryDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByPreSurgeryDiagnosis before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByPreSurgeryDiagnosis(preSurgeryDiagnosis));

		// % protected region % [Add any additional logic for findByPreSurgeryDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPreSurgeryDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Preoperative Instructions.
	 *
	 * @param preoperativeInstructions the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Preoperative Instructions
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByPreoperativeInstructions(String preoperativeInstructions)
	// % protected region % [Add any throwables, implementations, or extensions for findByPreoperativeInstructions here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPreoperativeInstructions here] end
	{
		// % protected region % [Add any additional logic for findByPreoperativeInstructions before the main body here] off begin
		// % protected region % [Add any additional logic for findByPreoperativeInstructions before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByPreoperativeInstructions(preoperativeInstructions));

		// % protected region % [Add any additional logic for findByPreoperativeInstructions before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPreoperativeInstructions before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Preoperative Surgical Notes.
	 *
	 * @param preoperativeSurgicalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Preoperative Surgical Notes
	 */
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findByPreoperativeSurgicalNotes(String preoperativeSurgicalNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByPreoperativeSurgicalNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPreoperativeSurgicalNotes here] end
	{
		// % protected region % [Add any additional logic for findByPreoperativeSurgicalNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByPreoperativeSurgicalNotes before the main body here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByPreoperativeSurgicalNotes(preoperativeSurgicalNotes));

		// % protected region % [Add any additional logic for findByPreoperativeSurgicalNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPreoperativeSurgicalNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PreoperativeRecordsEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PreoperativeRecordsEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PreoperativeRecordsEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'create')")
	public PreoperativeRecordsEntity create(PreoperativeRecordsEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PreoperativeRecordsEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'create')")
	public PreoperativeRecordsEntity create(PreoperativeRecordsEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PreoperativeRecordsEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PreoperativeRecordsEntity newEntity;

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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'create')")
	public List<PreoperativeRecordsEntity> createAll(Iterable<PreoperativeRecordsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PreoperativeRecordsEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PreoperativeRecordsEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'update')")
	public PreoperativeRecordsEntity update(PreoperativeRecordsEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PreoperativeRecordsEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'update')")
	public PreoperativeRecordsEntity update(PreoperativeRecordsEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PreoperativeRecordsEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PreoperativeRecordsEntity newEntity;

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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'update')")
	public List<PreoperativeRecordsEntity> updateAll(Iterable<PreoperativeRecordsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PreoperativeRecordsEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PreoperativeRecordsEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'create') or hasPermission('PreoperativeRecordsEntity', 'update')")
	public PreoperativeRecordsEntity save(PreoperativeRecordsEntity entity) throws ConstraintViolationException
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

		PreoperativeRecordsEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'create') or hasPermission('PreoperativeRecordsEntity', 'update')")
	public List<PreoperativeRecordsEntity> saveAll(Iterable<PreoperativeRecordsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PreoperativeRecordsEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public List<PreoperativeRecordsEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public List<PreoperativeRecordsEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PreoperativeRecordsEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PreoperativeRecordsEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PreoperativeRecordsEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PreoperativeRecordsEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PreoperativeRecordsEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PreoperativeRecordsEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PreoperativeRecordsEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PreoperativeRecordsEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PreoperativeRecordsEntityAudits
	 */
	private List<PreoperativeRecordsEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PreoperativeRecordsEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param preoperativeRecords preoperativeRecords to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PreoperativeRecordsEntity updateAuditData(PreoperativeRecordsEntity preoperativeRecords)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return preoperativeRecords;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PreoperativeRecordsEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PreoperativeRecordsEntity entityAtRevision = updateAuditData((PreoperativeRecordsEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PreoperativeRecordsEntityAudit(
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

		QPreoperativeRecordsEntity entity = QPreoperativeRecordsEntity.preoperativeRecordsEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Preoperative Records here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Preoperative Records here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.operatingTheaterMedicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Preoperative Records here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Preoperative Records here] end

				break;
			case "anesthesiaMedicalTranscriberId":
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesia Medical Transcriber to Anesthesia Medical Transcriber here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesia Medical Transcriber to Anesthesia Medical Transcriber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.anesthesiaMedicalTranscriber.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesia Medical Transcriber to Anesthesia Medical Transcriber here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesia Medical Transcriber to Anesthesia Medical Transcriber here] end

				break;
			case "anesthesiologistId":
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesiologist to Anesthesiologist here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesiologist to Anesthesiologist here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.anesthesiologist.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesiologist to Anesthesiologist here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesiologist to Anesthesiologist here] end

				break;
			case "anesthesiologyNurseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesiology Nurse to Anesthesiology Nurse here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesiology Nurse to Anesthesiology Nurse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.anesthesiologyNurse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesiology Nurse to Anesthesiology Nurse here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesiology Nurse to Anesthesiology Nurse here] end

				break;
			case "preSurgeryICD10Id":
				// % protected region % [Add any additional logic before the query parameters of relation from Pre Surgery ICD 10 to Pre Surgery ICD 10 here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Pre Surgery ICD 10 to Pre Surgery ICD 10 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.preSurgeryICD10.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Pre Surgery ICD 10 to Pre Surgery ICD 10 here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Pre Surgery ICD 10 to Pre Surgery ICD 10 here] end

				break;
			case "preSurgeryICD9CMId":
				// % protected region % [Add any additional logic before the query parameters of relation from Pre Surgery ICD 9 CM to Pre Surgery ICD 9 CM here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Pre Surgery ICD 9 CM to Pre Surgery ICD 9 CM here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.preSurgeryICD9CM.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Pre Surgery ICD 9 CM to Pre Surgery ICD 9 CM here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Pre Surgery ICD 9 CM to Pre Surgery ICD 9 CM here] end

				break;
			case "preoperativeRoomsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Preoperative Rooms to Preoperative Rooms here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Preoperative Rooms to Preoperative Rooms here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.preoperativeRooms.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Preoperative Rooms to Preoperative Rooms here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Preoperative Rooms to Preoperative Rooms here] end

				break;
			case "surgeonId":
				// % protected region % [Add any additional logic before the query parameters of relation from Surgeon to Surgeon here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Surgeon to Surgeon here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.surgeon.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Surgeon to Surgeon here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Surgeon to Surgeon here] end

				break;
			case "surgicalMedicalTranscriberId":
				// % protected region % [Add any additional logic before the query parameters of relation from Surgical Medical Transcriber to Surgical Medical Transcriber here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Surgical Medical Transcriber to Surgical Medical Transcriber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.surgicalMedicalTranscriber.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Surgical Medical Transcriber to Surgical Medical Transcriber here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Surgical Medical Transcriber to Surgical Medical Transcriber here] end

				break;
			case "surgicalNurseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Surgical Nurse to Surgical Nurse here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Surgical Nurse to Surgical Nurse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.surgicalNurse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Surgical Nurse to Surgical Nurse here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Surgical Nurse to Surgical Nurse here] end

				break;
			case "additionalAnesthesiologistsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Anesthesiologist to Additional Anesthesiologists here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Anesthesiologist to Additional Anesthesiologists here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.additionalAnesthesiologists.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Additional Anesthesiologist to Additional Anesthesiologists here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Additional Anesthesiologist to Additional Anesthesiologists here] end

				break;
			case "additionalSurgeryNursesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Surgery Nurse to Additional Surgery Nurses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Surgery Nurse to Additional Surgery Nurses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.additionalSurgeryNurses.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Additional Surgery Nurse to Additional Surgery Nurses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Additional Surgery Nurse to Additional Surgery Nurses here] end

				break;
			case "bedFacilitiesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Preoperative Records to Bed Facilities here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Preoperative Records to Bed Facilities here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bedFacilities.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Preoperative Records to Bed Facilities here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Preoperative Records to Bed Facilities here] end

				break;
			case "coTreatingAnesthesiologistsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Co Treating Anesthesiologist to Co Treating Anesthesiologists here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Co Treating Anesthesiologist to Co Treating Anesthesiologists here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.coTreatingAnesthesiologists.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Co Treating Anesthesiologist to Co Treating Anesthesiologists here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Co Treating Anesthesiologist to Co Treating Anesthesiologists here] end

				break;
			case "coTreatingSurgeonsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Co Treating Surgeon to Co Treating Surgeons here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Co Treating Surgeon to Co Treating Surgeons here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.coTreatingSurgeons.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Co Treating Surgeon to Co Treating Surgeons here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Co Treating Surgeon to Co Treating Surgeons here] end

				break;
			case "physicalStatusEvaluation":
				// % protected region % [Add any additional logic before the query parameters of physicalStatusEvaluation here] off begin
				// % protected region % [Add any additional logic before the query parameters of physicalStatusEvaluation here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.physicalStatusEvaluation, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of physicalStatusEvaluation here] off begin
				// % protected region % [Add any additional logic after the query parameters of physicalStatusEvaluation here] end

				break;
			case "surgeryRisk":
				// % protected region % [Add any additional logic before the query parameters of surgeryRisk here] off begin
				// % protected region % [Add any additional logic before the query parameters of surgeryRisk here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.surgeryRisk, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of surgeryRisk here] off begin
				// % protected region % [Add any additional logic after the query parameters of surgeryRisk here] end

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
	public PreoperativeRecordsEntity updateOldData(PreoperativeRecordsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PreoperativeRecordsEntity updateOldData(PreoperativeRecordsEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PreoperativeRecordsEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPreoperativeRecordsEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
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
				entityToUpdate.getOperatingTheaterMedicalExaminationRecord().unsetPreoperativeRecords();
			}
		}

		// Incoming One to Many reference
		if (entity.getAnesthesiaMedicalTranscriber() == null && entity.getAnesthesiaMedicalTranscriberId() == null) {
			entityToUpdate.unsetAnesthesiaMedicalTranscriber();
		} else if (entity.getAnesthesiaMedicalTranscriberId() != null && entity.getAnesthesiaMedicalTranscriber() == null) {
			Optional<StaffEntity> anesthesiaMedicalTranscriberEntity = this.staffRepository.findById(entity.getAnesthesiaMedicalTranscriberId());
			entityToUpdate.setAnesthesiaMedicalTranscriber(anesthesiaMedicalTranscriberEntity.orElseThrow());
		}
		if (persistRelations && entity.getAnesthesiaMedicalTranscriber() != null) {
			entityToUpdate.setAnesthesiaMedicalTranscriber(entity.getAnesthesiaMedicalTranscriber(), false);
			if (entityToUpdate.getAnesthesiaMedicalTranscriberId() != null) {
				this.staffRepository.save(entityToUpdate.getAnesthesiaMedicalTranscriber());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAnesthesiaMedicalTranscriber().unsetAnesthesiaMedicalTranscriber();
			}
		}

		// Incoming One to Many reference
		if (entity.getAnesthesiologist() == null && entity.getAnesthesiologistId() == null) {
			entityToUpdate.unsetAnesthesiologist();
		} else if (entity.getAnesthesiologistId() != null && entity.getAnesthesiologist() == null) {
			Optional<StaffEntity> anesthesiologistEntity = this.staffRepository.findById(entity.getAnesthesiologistId());
			entityToUpdate.setAnesthesiologist(anesthesiologistEntity.orElseThrow());
		}
		if (persistRelations && entity.getAnesthesiologist() != null) {
			entityToUpdate.setAnesthesiologist(entity.getAnesthesiologist(), false);
			if (entityToUpdate.getAnesthesiologistId() != null) {
				this.staffRepository.save(entityToUpdate.getAnesthesiologist());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAnesthesiologist().unsetAnesthesiologist();
			}
		}

		// Incoming One to Many reference
		if (entity.getAnesthesiologyNurse() == null && entity.getAnesthesiologyNurseId() == null) {
			entityToUpdate.unsetAnesthesiologyNurse();
		} else if (entity.getAnesthesiologyNurseId() != null && entity.getAnesthesiologyNurse() == null) {
			Optional<StaffEntity> anesthesiologyNurseEntity = this.staffRepository.findById(entity.getAnesthesiologyNurseId());
			entityToUpdate.setAnesthesiologyNurse(anesthesiologyNurseEntity.orElseThrow());
		}
		if (persistRelations && entity.getAnesthesiologyNurse() != null) {
			entityToUpdate.setAnesthesiologyNurse(entity.getAnesthesiologyNurse(), false);
			if (entityToUpdate.getAnesthesiologyNurseId() != null) {
				this.staffRepository.save(entityToUpdate.getAnesthesiologyNurse());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAnesthesiologyNurse().unsetAnesthesiologyNurse();
			}
		}

		// Incoming One to Many reference
		if (entity.getPreSurgeryICD10() == null && entity.getPreSurgeryICD10Id() == null) {
			entityToUpdate.unsetPreSurgeryICD10();
		} else if (entity.getPreSurgeryICD10Id() != null && entity.getPreSurgeryICD10() == null) {
			Optional<DiagnosesAndProceduresEntity> preSurgeryICD10Entity = this.diagnosesAndProceduresRepository.findById(entity.getPreSurgeryICD10Id());
			entityToUpdate.setPreSurgeryICD10(preSurgeryICD10Entity.orElseThrow());
		}
		if (persistRelations && entity.getPreSurgeryICD10() != null) {
			entityToUpdate.setPreSurgeryICD10(entity.getPreSurgeryICD10(), false);
			if (entityToUpdate.getPreSurgeryICD10Id() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getPreSurgeryICD10());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPreSurgeryICD10().unsetPreSurgeryICD10();
			}
		}

		// Incoming One to Many reference
		if (entity.getPreSurgeryICD9CM() == null && entity.getPreSurgeryICD9CMId() == null) {
			entityToUpdate.unsetPreSurgeryICD9CM();
		} else if (entity.getPreSurgeryICD9CMId() != null && entity.getPreSurgeryICD9CM() == null) {
			Optional<DiagnosesAndProceduresEntity> preSurgeryICD9CMEntity = this.diagnosesAndProceduresRepository.findById(entity.getPreSurgeryICD9CMId());
			entityToUpdate.setPreSurgeryICD9CM(preSurgeryICD9CMEntity.orElseThrow());
		}
		if (persistRelations && entity.getPreSurgeryICD9CM() != null) {
			entityToUpdate.setPreSurgeryICD9CM(entity.getPreSurgeryICD9CM(), false);
			if (entityToUpdate.getPreSurgeryICD9CMId() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getPreSurgeryICD9CM());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPreSurgeryICD9CM().unsetPreSurgeryICD9CM();
			}
		}

		// Incoming One to Many reference
		if (entity.getPreoperativeRooms() == null && entity.getPreoperativeRoomsId() == null) {
			entityToUpdate.unsetPreoperativeRooms();
		} else if (entity.getPreoperativeRoomsId() != null && entity.getPreoperativeRooms() == null) {
			Optional<RoomFacilityEntity> preoperativeRoomsEntity = this.roomFacilityRepository.findById(entity.getPreoperativeRoomsId());
			entityToUpdate.setPreoperativeRooms(preoperativeRoomsEntity.orElseThrow());
		}
		if (persistRelations && entity.getPreoperativeRooms() != null) {
			entityToUpdate.setPreoperativeRooms(entity.getPreoperativeRooms(), false);
			if (entityToUpdate.getPreoperativeRoomsId() != null) {
				this.roomFacilityRepository.save(entityToUpdate.getPreoperativeRooms());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPreoperativeRooms().unsetPreoperativeRooms();
			}
		}

		// Incoming One to Many reference
		if (entity.getSurgeon() == null && entity.getSurgeonId() == null) {
			entityToUpdate.unsetSurgeon();
		} else if (entity.getSurgeonId() != null && entity.getSurgeon() == null) {
			Optional<StaffEntity> surgeonEntity = this.staffRepository.findById(entity.getSurgeonId());
			entityToUpdate.setSurgeon(surgeonEntity.orElseThrow());
		}
		if (persistRelations && entity.getSurgeon() != null) {
			entityToUpdate.setSurgeon(entity.getSurgeon(), false);
			if (entityToUpdate.getSurgeonId() != null) {
				this.staffRepository.save(entityToUpdate.getSurgeon());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSurgeon().unsetSurgeon();
			}
		}

		// Incoming One to Many reference
		if (entity.getSurgicalMedicalTranscriber() == null && entity.getSurgicalMedicalTranscriberId() == null) {
			entityToUpdate.unsetSurgicalMedicalTranscriber();
		} else if (entity.getSurgicalMedicalTranscriberId() != null && entity.getSurgicalMedicalTranscriber() == null) {
			Optional<StaffEntity> surgicalMedicalTranscriberEntity = this.staffRepository.findById(entity.getSurgicalMedicalTranscriberId());
			entityToUpdate.setSurgicalMedicalTranscriber(surgicalMedicalTranscriberEntity.orElseThrow());
		}
		if (persistRelations && entity.getSurgicalMedicalTranscriber() != null) {
			entityToUpdate.setSurgicalMedicalTranscriber(entity.getSurgicalMedicalTranscriber(), false);
			if (entityToUpdate.getSurgicalMedicalTranscriberId() != null) {
				this.staffRepository.save(entityToUpdate.getSurgicalMedicalTranscriber());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSurgicalMedicalTranscriber().unsetSurgicalMedicalTranscriber();
			}
		}

		// Incoming One to Many reference
		if (entity.getSurgicalNurse() == null && entity.getSurgicalNurseId() == null) {
			entityToUpdate.unsetSurgicalNurse();
		} else if (entity.getSurgicalNurseId() != null && entity.getSurgicalNurse() == null) {
			Optional<StaffEntity> surgicalNurseEntity = this.staffRepository.findById(entity.getSurgicalNurseId());
			entityToUpdate.setSurgicalNurse(surgicalNurseEntity.orElseThrow());
		}
		if (persistRelations && entity.getSurgicalNurse() != null) {
			entityToUpdate.setSurgicalNurse(entity.getSurgicalNurse(), false);
			if (entityToUpdate.getSurgicalNurseId() != null) {
				this.staffRepository.save(entityToUpdate.getSurgicalNurse());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSurgicalNurse().unsetSurgicalNurse();
			}
		}

		// Outgoing one to many reference
		if (entity.getAdditionalAnesthesiologistsIds().isEmpty() && entity.getAdditionalAnesthesiologists().isEmpty()) {
			entityToUpdate.setAdditionalAnesthesiologists(new HashSet<>());
		} else if (!entity.getAdditionalAnesthesiologistsIds().isEmpty() && entity.getAdditionalAnesthesiologists().isEmpty()) {
			Iterable<CoTreatingDoctorEntity> additionalAnesthesiologistsEntities =
					this.coTreatingDoctorRepository.findAllById(entity.getAdditionalAnesthesiologistsIds());
			entityToUpdate.setAdditionalAnesthesiologists(Sets.newHashSet(additionalAnesthesiologistsEntities));
		}
		if (persistRelations && !entity.getAdditionalAnesthesiologists().isEmpty()) {
			Set<CoTreatingDoctorEntity> updatedEntities = new HashSet<>();
			entity.getAdditionalAnesthesiologists().forEach(model -> {
				if (model.getId() != null) {
					model = this.coTreatingDoctorRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAdditionalAnesthesiologists(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getAdditionalSurgeryNursesIds().isEmpty() && entity.getAdditionalSurgeryNurses().isEmpty()) {
			entityToUpdate.setAdditionalSurgeryNurses(new HashSet<>());
		} else if (!entity.getAdditionalSurgeryNursesIds().isEmpty() && entity.getAdditionalSurgeryNurses().isEmpty()) {
			Iterable<CoTreatingDoctorEntity> additionalSurgeryNursesEntities =
					this.coTreatingDoctorRepository.findAllById(entity.getAdditionalSurgeryNursesIds());
			entityToUpdate.setAdditionalSurgeryNurses(Sets.newHashSet(additionalSurgeryNursesEntities));
		}
		if (persistRelations && !entity.getAdditionalSurgeryNurses().isEmpty()) {
			Set<CoTreatingDoctorEntity> updatedEntities = new HashSet<>();
			entity.getAdditionalSurgeryNurses().forEach(model -> {
				if (model.getId() != null) {
					model = this.coTreatingDoctorRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAdditionalSurgeryNurses(updatedEntities);
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

		// Outgoing one to many reference
		if (entity.getCoTreatingAnesthesiologistsIds().isEmpty() && entity.getCoTreatingAnesthesiologists().isEmpty()) {
			entityToUpdate.setCoTreatingAnesthesiologists(new HashSet<>());
		} else if (!entity.getCoTreatingAnesthesiologistsIds().isEmpty() && entity.getCoTreatingAnesthesiologists().isEmpty()) {
			Iterable<CoTreatingDoctorEntity> coTreatingAnesthesiologistsEntities =
					this.coTreatingDoctorRepository.findAllById(entity.getCoTreatingAnesthesiologistsIds());
			entityToUpdate.setCoTreatingAnesthesiologists(Sets.newHashSet(coTreatingAnesthesiologistsEntities));
		}
		if (persistRelations && !entity.getCoTreatingAnesthesiologists().isEmpty()) {
			Set<CoTreatingDoctorEntity> updatedEntities = new HashSet<>();
			entity.getCoTreatingAnesthesiologists().forEach(model -> {
				if (model.getId() != null) {
					model = this.coTreatingDoctorRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCoTreatingAnesthesiologists(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getCoTreatingSurgeonsIds().isEmpty() && entity.getCoTreatingSurgeons().isEmpty()) {
			entityToUpdate.setCoTreatingSurgeons(new HashSet<>());
		} else if (!entity.getCoTreatingSurgeonsIds().isEmpty() && entity.getCoTreatingSurgeons().isEmpty()) {
			Iterable<CoTreatingDoctorEntity> coTreatingSurgeonsEntities =
					this.coTreatingDoctorRepository.findAllById(entity.getCoTreatingSurgeonsIds());
			entityToUpdate.setCoTreatingSurgeons(Sets.newHashSet(coTreatingSurgeonsEntities));
		}
		if (persistRelations && !entity.getCoTreatingSurgeons().isEmpty()) {
			Set<CoTreatingDoctorEntity> updatedEntities = new HashSet<>();
			entity.getCoTreatingSurgeons().forEach(model -> {
				if (model.getId() != null) {
					model = this.coTreatingDoctorRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCoTreatingSurgeons(updatedEntities);
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
	public void validateEntity(PreoperativeRecordsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PreoperativeRecordsEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PreoperativeRecordsEntity.
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

	public Set<String> validateEntityRelations(PreoperativeRecordsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getAnesthesiaMedicalTranscriberId() != null && this.staffRepository.findById(entity.getAnesthesiaMedicalTranscriberId()).isEmpty()) {
			errors.add("The UUID " + entity.getAnesthesiaMedicalTranscriberId() + " is not associated with a Staff Entity");
		}

		if (entity.getAnesthesiologistId() != null && this.staffRepository.findById(entity.getAnesthesiologistId()).isEmpty()) {
			errors.add("The UUID " + entity.getAnesthesiologistId() + " is not associated with a Staff Entity");
		}

		if (entity.getAnesthesiologyNurseId() != null && this.staffRepository.findById(entity.getAnesthesiologyNurseId()).isEmpty()) {
			errors.add("The UUID " + entity.getAnesthesiologyNurseId() + " is not associated with a Staff Entity");
		}

		if (entity.getPreSurgeryICD10Id() != null && this.diagnosesAndProceduresRepository.findById(entity.getPreSurgeryICD10Id()).isEmpty()) {
			errors.add("The UUID " + entity.getPreSurgeryICD10Id() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getPreSurgeryICD9CMId() != null && this.diagnosesAndProceduresRepository.findById(entity.getPreSurgeryICD9CMId()).isEmpty()) {
			errors.add("The UUID " + entity.getPreSurgeryICD9CMId() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getOperatingTheaterMedicalExaminationRecordId() != null && this.operatingTheaterMedicalExaminationRecordRepository.findById(entity.getOperatingTheaterMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getOperatingTheaterMedicalExaminationRecordId() + " is not associated with a Operating Theater Medical Examination Record Entity");
		}

		if (entity.getPreoperativeRoomsId() != null && this.roomFacilityRepository.findById(entity.getPreoperativeRoomsId()).isEmpty()) {
			errors.add("The UUID " + entity.getPreoperativeRoomsId() + " is not associated with a Room Facility Entity");
		}

		if (entity.getSurgeonId() != null && this.staffRepository.findById(entity.getSurgeonId()).isEmpty()) {
			errors.add("The UUID " + entity.getSurgeonId() + " is not associated with a Staff Entity");
		}

		if (entity.getSurgicalMedicalTranscriberId() != null && this.staffRepository.findById(entity.getSurgicalMedicalTranscriberId()).isEmpty()) {
			errors.add("The UUID " + entity.getSurgicalMedicalTranscriberId() + " is not associated with a Staff Entity");
		}

		if (entity.getSurgicalNurseId() != null && this.staffRepository.findById(entity.getSurgicalNurseId()).isEmpty()) {
			errors.add("The UUID " + entity.getSurgicalNurseId() + " is not associated with a Staff Entity");
		}

		for (UUID id : entity.getAdditionalAnesthesiologistsIds()) {
			if (this.coTreatingDoctorRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Co Treating Doctor Entity");
			}
		}

		for (UUID id : entity.getAdditionalSurgeryNursesIds()) {
			if (this.coTreatingDoctorRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Co Treating Doctor Entity");
			}
		}

		for (UUID id : entity.getBedFacilitiesIds()) {
			if (this.bedFacilityRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Bed Facility Entity");
			}
		}

		for (UUID id : entity.getCoTreatingAnesthesiologistsIds()) {
			if (this.coTreatingDoctorRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Co Treating Doctor Entity");
			}
		}

		for (UUID id : entity.getCoTreatingSurgeonsIds()) {
			if (this.coTreatingDoctorRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Co Treating Doctor Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
