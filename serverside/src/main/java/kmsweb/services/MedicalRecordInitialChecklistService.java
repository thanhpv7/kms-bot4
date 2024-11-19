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
import kmsweb.repositories.MedicalRecordInitialChecklistRepository;
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
public class MedicalRecordInitialChecklistService extends AbstractService<MedicalRecordInitialChecklistEntity, MedicalRecordInitialChecklistRepository, MedicalRecordInitialChecklistEntityAudit> {

	private final String[] referenceNamesInMedicalRecordInitialChecklistEntity = {
		"medicalExaminationRecord",
	};

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public MedicalRecordInitialChecklistService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		MedicalRecordInitialChecklistRepository repository
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
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
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
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Out Vital Sign.
	 *
	 * @param outVitalSign the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Vital Sign
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOutVitalSign(Boolean outVitalSign)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutVitalSign here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutVitalSign here] end
	{
		// % protected region % [Add any additional logic for findByOutVitalSign before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutVitalSign before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOutVitalSign(outVitalSign));

		// % protected region % [Add any additional logic for findByOutVitalSign before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutVitalSign before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Out Anamnesis.
	 *
	 * @param outAnamnesis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Anamnesis
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOutAnamnesis(Boolean outAnamnesis)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutAnamnesis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutAnamnesis here] end
	{
		// % protected region % [Add any additional logic for findByOutAnamnesis before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutAnamnesis before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOutAnamnesis(outAnamnesis));

		// % protected region % [Add any additional logic for findByOutAnamnesis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutAnamnesis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Out Physical Examination.
	 *
	 * @param outPhysicalExamination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Physical Examination
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOutPhysicalExamination(Boolean outPhysicalExamination)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutPhysicalExamination here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutPhysicalExamination here] end
	{
		// % protected region % [Add any additional logic for findByOutPhysicalExamination before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutPhysicalExamination before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOutPhysicalExamination(outPhysicalExamination));

		// % protected region % [Add any additional logic for findByOutPhysicalExamination before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutPhysicalExamination before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Out Diagnosis.
	 *
	 * @param outDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Diagnosis
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOutDiagnosis(Boolean outDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByOutDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutDiagnosis before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOutDiagnosis(outDiagnosis));

		// % protected region % [Add any additional logic for findByOutDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Out Dismissal Type.
	 *
	 * @param outDismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Dismissal Type
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOutDismissalType(Boolean outDismissalType)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutDismissalType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutDismissalType here] end
	{
		// % protected region % [Add any additional logic for findByOutDismissalType before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutDismissalType before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOutDismissalType(outDismissalType));

		// % protected region % [Add any additional logic for findByOutDismissalType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutDismissalType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Vital Sign.
	 *
	 * @param inpVitalSign the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Vital Sign
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpVitalSign(Boolean inpVitalSign)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpVitalSign here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpVitalSign here] end
	{
		// % protected region % [Add any additional logic for findByInpVitalSign before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpVitalSign before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpVitalSign(inpVitalSign));

		// % protected region % [Add any additional logic for findByInpVitalSign before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpVitalSign before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Doctor Notes.
	 *
	 * @param inpDailyCareDoctorNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Doctor Notes
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpDailyCareDoctorNotes(Boolean inpDailyCareDoctorNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareDoctorNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareDoctorNotes here] end
	{
		// % protected region % [Add any additional logic for findByInpDailyCareDoctorNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareDoctorNotes before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpDailyCareDoctorNotes(inpDailyCareDoctorNotes));

		// % protected region % [Add any additional logic for findByInpDailyCareDoctorNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareDoctorNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Doctor Notes NA.
	 *
	 * @param inpDailyCareDoctorNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Doctor Notes NA
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpDailyCareDoctorNotesNA(Boolean inpDailyCareDoctorNotesNA)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareDoctorNotesNA here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareDoctorNotesNA here] end
	{
		// % protected region % [Add any additional logic for findByInpDailyCareDoctorNotesNA before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareDoctorNotesNA before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpDailyCareDoctorNotesNA(inpDailyCareDoctorNotesNA));

		// % protected region % [Add any additional logic for findByInpDailyCareDoctorNotesNA before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareDoctorNotesNA before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Nursing Notes.
	 *
	 * @param inpDailyCareNursingNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Nursing Notes
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpDailyCareNursingNotes(Boolean inpDailyCareNursingNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareNursingNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareNursingNotes here] end
	{
		// % protected region % [Add any additional logic for findByInpDailyCareNursingNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareNursingNotes before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpDailyCareNursingNotes(inpDailyCareNursingNotes));

		// % protected region % [Add any additional logic for findByInpDailyCareNursingNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareNursingNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Nursing Notes NA.
	 *
	 * @param inpDailyCareNursingNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Nursing Notes NA
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpDailyCareNursingNotesNA(Boolean inpDailyCareNursingNotesNA)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareNursingNotesNA here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareNursingNotesNA here] end
	{
		// % protected region % [Add any additional logic for findByInpDailyCareNursingNotesNA before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareNursingNotesNA before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpDailyCareNursingNotesNA(inpDailyCareNursingNotesNA));

		// % protected region % [Add any additional logic for findByInpDailyCareNursingNotesNA before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareNursingNotesNA before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Progress Notes.
	 *
	 * @param inpDailyCareProgressNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Progress Notes
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpDailyCareProgressNotes(Boolean inpDailyCareProgressNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareProgressNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareProgressNotes here] end
	{
		// % protected region % [Add any additional logic for findByInpDailyCareProgressNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareProgressNotes before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpDailyCareProgressNotes(inpDailyCareProgressNotes));

		// % protected region % [Add any additional logic for findByInpDailyCareProgressNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareProgressNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Progress Notes NA.
	 *
	 * @param inpDailyCareProgressNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Progress Notes NA
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpDailyCareProgressNotesNA(Boolean inpDailyCareProgressNotesNA)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareProgressNotesNA here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDailyCareProgressNotesNA here] end
	{
		// % protected region % [Add any additional logic for findByInpDailyCareProgressNotesNA before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareProgressNotesNA before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpDailyCareProgressNotesNA(inpDailyCareProgressNotesNA));

		// % protected region % [Add any additional logic for findByInpDailyCareProgressNotesNA before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpDailyCareProgressNotesNA before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Dismissal Diagnosis.
	 *
	 * @param inpDismissalDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Dismissal Diagnosis
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpDismissalDiagnosis(Boolean inpDismissalDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDismissalDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDismissalDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByInpDismissalDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpDismissalDiagnosis before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpDismissalDiagnosis(inpDismissalDiagnosis));

		// % protected region % [Add any additional logic for findByInpDismissalDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpDismissalDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Dismissal Type.
	 *
	 * @param inpDismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Dismissal Type
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpDismissalType(Boolean inpDismissalType)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDismissalType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDismissalType here] end
	{
		// % protected region % [Add any additional logic for findByInpDismissalType before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpDismissalType before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpDismissalType(inpDismissalType));

		// % protected region % [Add any additional logic for findByInpDismissalType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpDismissalType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inp Dismissal Condition.
	 *
	 * @param inpDismissalCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Dismissal Condition
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByInpDismissalCondition(Boolean inpDismissalCondition)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDismissalCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpDismissalCondition here] end
	{
		// % protected region % [Add any additional logic for findByInpDismissalCondition before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpDismissalCondition before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByInpDismissalCondition(inpDismissalCondition));

		// % protected region % [Add any additional logic for findByInpDismissalCondition before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpDismissalCondition before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DR Admission Diagnosis.
	 *
	 * @param drAdmissionDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Admission Diagnosis
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDrAdmissionDiagnosis(Boolean drAdmissionDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrAdmissionDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrAdmissionDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByDrAdmissionDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrAdmissionDiagnosis before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDrAdmissionDiagnosis(drAdmissionDiagnosis));

		// % protected region % [Add any additional logic for findByDrAdmissionDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrAdmissionDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Doctor Notes.
	 *
	 * @param drObservationDoctorNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Doctor Notes
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDrObservationDoctorNotes(Boolean drObservationDoctorNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationDoctorNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationDoctorNotes here] end
	{
		// % protected region % [Add any additional logic for findByDrObservationDoctorNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrObservationDoctorNotes before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDrObservationDoctorNotes(drObservationDoctorNotes));

		// % protected region % [Add any additional logic for findByDrObservationDoctorNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrObservationDoctorNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Doctor Notes NA.
	 *
	 * @param drObservationDoctorNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Doctor Notes NA
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDrObservationDoctorNotesNA(Boolean drObservationDoctorNotesNA)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationDoctorNotesNA here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationDoctorNotesNA here] end
	{
		// % protected region % [Add any additional logic for findByDrObservationDoctorNotesNA before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrObservationDoctorNotesNA before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDrObservationDoctorNotesNA(drObservationDoctorNotesNA));

		// % protected region % [Add any additional logic for findByDrObservationDoctorNotesNA before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrObservationDoctorNotesNA before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Nursing Notes.
	 *
	 * @param drObservationNursingNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Nursing Notes
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDrObservationNursingNotes(Boolean drObservationNursingNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationNursingNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationNursingNotes here] end
	{
		// % protected region % [Add any additional logic for findByDrObservationNursingNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrObservationNursingNotes before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDrObservationNursingNotes(drObservationNursingNotes));

		// % protected region % [Add any additional logic for findByDrObservationNursingNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrObservationNursingNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Nursing Notes NA.
	 *
	 * @param drObservationNursingNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Nursing Notes NA
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDrObservationNursingNotesNA(Boolean drObservationNursingNotesNA)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationNursingNotesNA here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationNursingNotesNA here] end
	{
		// % protected region % [Add any additional logic for findByDrObservationNursingNotesNA before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrObservationNursingNotesNA before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDrObservationNursingNotesNA(drObservationNursingNotesNA));

		// % protected region % [Add any additional logic for findByDrObservationNursingNotesNA before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrObservationNursingNotesNA before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Progress Notes.
	 *
	 * @param drObservationProgressNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Progress Notes
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDrObservationProgressNotes(Boolean drObservationProgressNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationProgressNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationProgressNotes here] end
	{
		// % protected region % [Add any additional logic for findByDrObservationProgressNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrObservationProgressNotes before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDrObservationProgressNotes(drObservationProgressNotes));

		// % protected region % [Add any additional logic for findByDrObservationProgressNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrObservationProgressNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Progress Notes NA.
	 *
	 * @param drObservationProgressNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Progress Notes NA
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDrObservationProgressNotesNA(Boolean drObservationProgressNotesNA)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationProgressNotesNA here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrObservationProgressNotesNA here] end
	{
		// % protected region % [Add any additional logic for findByDrObservationProgressNotesNA before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrObservationProgressNotesNA before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDrObservationProgressNotesNA(drObservationProgressNotesNA));

		// % protected region % [Add any additional logic for findByDrObservationProgressNotesNA before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrObservationProgressNotesNA before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DR Dismissal Diagnosis.
	 *
	 * @param drDismissalDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Dismissal Diagnosis
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDrDismissalDiagnosis(Boolean drDismissalDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrDismissalDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrDismissalDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByDrDismissalDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrDismissalDiagnosis before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDrDismissalDiagnosis(drDismissalDiagnosis));

		// % protected region % [Add any additional logic for findByDrDismissalDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrDismissalDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DR Dismissal Type.
	 *
	 * @param drDismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Dismissal Type
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDrDismissalType(Boolean drDismissalType)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrDismissalType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrDismissalType here] end
	{
		// % protected region % [Add any additional logic for findByDrDismissalType before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrDismissalType before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDrDismissalType(drDismissalType));

		// % protected region % [Add any additional logic for findByDrDismissalType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrDismissalType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute OT Pre Operative Diagnosis.
	 *
	 * @param otPreOperativeDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Pre Operative Diagnosis
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOtPreOperativeDiagnosis(Boolean otPreOperativeDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPreOperativeDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPreOperativeDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByOtPreOperativeDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtPreOperativeDiagnosis before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOtPreOperativeDiagnosis(otPreOperativeDiagnosis));

		// % protected region % [Add any additional logic for findByOtPreOperativeDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtPreOperativeDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute OT Pre Operative Notes Surgery.
	 *
	 * @param otPreOperativeNotesSurgery the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Pre Operative Notes Surgery
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOtPreOperativeNotesSurgery(Boolean otPreOperativeNotesSurgery)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPreOperativeNotesSurgery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPreOperativeNotesSurgery here] end
	{
		// % protected region % [Add any additional logic for findByOtPreOperativeNotesSurgery before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtPreOperativeNotesSurgery before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOtPreOperativeNotesSurgery(otPreOperativeNotesSurgery));

		// % protected region % [Add any additional logic for findByOtPreOperativeNotesSurgery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtPreOperativeNotesSurgery before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute OT Pre Operative Notes Anaesthesiology.
	 *
	 * @param otPreOperativeNotesAnaesthesiology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Pre Operative Notes Anaesthesiology
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOtPreOperativeNotesAnaesthesiology(Boolean otPreOperativeNotesAnaesthesiology)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPreOperativeNotesAnaesthesiology here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPreOperativeNotesAnaesthesiology here] end
	{
		// % protected region % [Add any additional logic for findByOtPreOperativeNotesAnaesthesiology before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtPreOperativeNotesAnaesthesiology before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOtPreOperativeNotesAnaesthesiology(otPreOperativeNotesAnaesthesiology));

		// % protected region % [Add any additional logic for findByOtPreOperativeNotesAnaesthesiology before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtPreOperativeNotesAnaesthesiology before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute OT Intra Operative Notes Surgery.
	 *
	 * @param otIntraOperativeNotesSurgery the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Intra Operative Notes Surgery
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOtIntraOperativeNotesSurgery(Boolean otIntraOperativeNotesSurgery)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtIntraOperativeNotesSurgery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtIntraOperativeNotesSurgery here] end
	{
		// % protected region % [Add any additional logic for findByOtIntraOperativeNotesSurgery before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtIntraOperativeNotesSurgery before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOtIntraOperativeNotesSurgery(otIntraOperativeNotesSurgery));

		// % protected region % [Add any additional logic for findByOtIntraOperativeNotesSurgery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtIntraOperativeNotesSurgery before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute OT Intra Operative Notes Anaesthesiology.
	 *
	 * @param otIntraOperativeNotesAnaesthesiology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Intra Operative Notes Anaesthesiology
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOtIntraOperativeNotesAnaesthesiology(Boolean otIntraOperativeNotesAnaesthesiology)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtIntraOperativeNotesAnaesthesiology here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtIntraOperativeNotesAnaesthesiology here] end
	{
		// % protected region % [Add any additional logic for findByOtIntraOperativeNotesAnaesthesiology before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtIntraOperativeNotesAnaesthesiology before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOtIntraOperativeNotesAnaesthesiology(otIntraOperativeNotesAnaesthesiology));

		// % protected region % [Add any additional logic for findByOtIntraOperativeNotesAnaesthesiology before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtIntraOperativeNotesAnaesthesiology before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute OT Post Operative Notes Surgery.
	 *
	 * @param otPostOperativeNotesSurgery the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Post Operative Notes Surgery
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOtPostOperativeNotesSurgery(Boolean otPostOperativeNotesSurgery)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPostOperativeNotesSurgery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPostOperativeNotesSurgery here] end
	{
		// % protected region % [Add any additional logic for findByOtPostOperativeNotesSurgery before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtPostOperativeNotesSurgery before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOtPostOperativeNotesSurgery(otPostOperativeNotesSurgery));

		// % protected region % [Add any additional logic for findByOtPostOperativeNotesSurgery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtPostOperativeNotesSurgery before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute OT Post Operative Notes Anaesthesiology.
	 *
	 * @param otPostOperativeNotesAnaesthesiology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Post Operative Notes Anaesthesiology
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOtPostOperativeNotesAnaesthesiology(Boolean otPostOperativeNotesAnaesthesiology)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPostOperativeNotesAnaesthesiology here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPostOperativeNotesAnaesthesiology here] end
	{
		// % protected region % [Add any additional logic for findByOtPostOperativeNotesAnaesthesiology before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtPostOperativeNotesAnaesthesiology before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOtPostOperativeNotesAnaesthesiology(otPostOperativeNotesAnaesthesiology));

		// % protected region % [Add any additional logic for findByOtPostOperativeNotesAnaesthesiology before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtPostOperativeNotesAnaesthesiology before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute OT Post Operative Diagnosis.
	 *
	 * @param otPostOperativeDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Post Operative Diagnosis
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOtPostOperativeDiagnosis(Boolean otPostOperativeDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPostOperativeDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtPostOperativeDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByOtPostOperativeDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtPostOperativeDiagnosis before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOtPostOperativeDiagnosis(otPostOperativeDiagnosis));

		// % protected region % [Add any additional logic for findByOtPostOperativeDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtPostOperativeDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute OT Dismissal Type.
	 *
	 * @param otDismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Dismissal Type
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByOtDismissalType(Boolean otDismissalType)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtDismissalType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtDismissalType here] end
	{
		// % protected region % [Add any additional logic for findByOtDismissalType before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtDismissalType before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByOtDismissalType(otDismissalType));

		// % protected region % [Add any additional logic for findByOtDismissalType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtDismissalType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DS Responsible Staff.
	 *
	 * @param dsResponsibleStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DS Responsible Staff
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDsResponsibleStaff(Boolean dsResponsibleStaff)
	// % protected region % [Add any throwables, implementations, or extensions for findByDsResponsibleStaff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDsResponsibleStaff here] end
	{
		// % protected region % [Add any additional logic for findByDsResponsibleStaff before the main body here] off begin
		// % protected region % [Add any additional logic for findByDsResponsibleStaff before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDsResponsibleStaff(dsResponsibleStaff));

		// % protected region % [Add any additional logic for findByDsResponsibleStaff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDsResponsibleStaff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute DS Interpretation.
	 *
	 * @param dsInterpretation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DS Interpretation
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByDsInterpretation(Boolean dsInterpretation)
	// % protected region % [Add any throwables, implementations, or extensions for findByDsInterpretation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDsInterpretation here] end
	{
		// % protected region % [Add any additional logic for findByDsInterpretation before the main body here] off begin
		// % protected region % [Add any additional logic for findByDsInterpretation before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByDsInterpretation(dsInterpretation));

		// % protected region % [Add any additional logic for findByDsInterpretation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDsInterpretation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<MedicalRecordInitialChecklistEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<MedicalRecordInitialChecklistEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<MedicalRecordInitialChecklistEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'create')")
	public MedicalRecordInitialChecklistEntity create(MedicalRecordInitialChecklistEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		MedicalRecordInitialChecklistEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'create')")
	public MedicalRecordInitialChecklistEntity create(MedicalRecordInitialChecklistEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		MedicalRecordInitialChecklistEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		MedicalRecordInitialChecklistEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'create')")
	public List<MedicalRecordInitialChecklistEntity> createAll(Iterable<MedicalRecordInitialChecklistEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<MedicalRecordInitialChecklistEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<MedicalRecordInitialChecklistEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'update')")
	public MedicalRecordInitialChecklistEntity update(MedicalRecordInitialChecklistEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		MedicalRecordInitialChecklistEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'update')")
	public MedicalRecordInitialChecklistEntity update(MedicalRecordInitialChecklistEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		MedicalRecordInitialChecklistEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		MedicalRecordInitialChecklistEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'update')")
	public List<MedicalRecordInitialChecklistEntity> updateAll(Iterable<MedicalRecordInitialChecklistEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<MedicalRecordInitialChecklistEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<MedicalRecordInitialChecklistEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'create') or hasPermission('MedicalRecordInitialChecklistEntity', 'update')")
	public MedicalRecordInitialChecklistEntity save(MedicalRecordInitialChecklistEntity entity) throws ConstraintViolationException
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

		MedicalRecordInitialChecklistEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'create') or hasPermission('MedicalRecordInitialChecklistEntity', 'update')")
	public List<MedicalRecordInitialChecklistEntity> saveAll(Iterable<MedicalRecordInitialChecklistEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<MedicalRecordInitialChecklistEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	public List<MedicalRecordInitialChecklistEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	public List<MedicalRecordInitialChecklistEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(MedicalRecordInitialChecklistEntity.class);

		// % protected region % [Add any additional processing before converting to a list of MedicalRecordInitialChecklistEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicalRecordInitialChecklistEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('MedicalRecordInitialChecklistEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicalRecordInitialChecklistEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of MedicalRecordInitialChecklistEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicalRecordInitialChecklistEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(MedicalRecordInitialChecklistEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of MedicalRecordInitialChecklistEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of MedicalRecordInitialChecklistEntityAudits
	 */
	private List<MedicalRecordInitialChecklistEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<MedicalRecordInitialChecklistEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param medicalRecordInitialChecklist medicalRecordInitialChecklist to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private MedicalRecordInitialChecklistEntity updateAuditData(MedicalRecordInitialChecklistEntity medicalRecordInitialChecklist)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return medicalRecordInitialChecklist;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private MedicalRecordInitialChecklistEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		MedicalRecordInitialChecklistEntity entityAtRevision = updateAuditData((MedicalRecordInitialChecklistEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new MedicalRecordInitialChecklistEntityAudit(
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

		QMedicalRecordInitialChecklistEntity entity = QMedicalRecordInitialChecklistEntity.medicalRecordInitialChecklistEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Medical Record Initial Checklist here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Medical Record Initial Checklist here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Medical Record Initial Checklist here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Medical Record Initial Checklist here] end

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
	public MedicalRecordInitialChecklistEntity updateOldData(MedicalRecordInitialChecklistEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public MedicalRecordInitialChecklistEntity updateOldData(MedicalRecordInitialChecklistEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		MedicalRecordInitialChecklistEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInMedicalRecordInitialChecklistEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOutVitalSign() == null) {
			entityToUpdate.setOutVitalSign(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOutAnamnesis() == null) {
			entityToUpdate.setOutAnamnesis(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOutPhysicalExamination() == null) {
			entityToUpdate.setOutPhysicalExamination(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOutDiagnosis() == null) {
			entityToUpdate.setOutDiagnosis(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOutDismissalType() == null) {
			entityToUpdate.setOutDismissalType(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOutDismissalDateAndTime() == null) {
			entityToUpdate.setOutDismissalDateAndTime(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpVitalSign() == null) {
			entityToUpdate.setInpVitalSign(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDailyCareDoctorNotes() == null) {
			entityToUpdate.setInpDailyCareDoctorNotes(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDailyCareDoctorNotesNA() == null) {
			entityToUpdate.setInpDailyCareDoctorNotesNA(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDailyCareNursingNotes() == null) {
			entityToUpdate.setInpDailyCareNursingNotes(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDailyCareNursingNotesNA() == null) {
			entityToUpdate.setInpDailyCareNursingNotesNA(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDailyCareProgressNotes() == null) {
			entityToUpdate.setInpDailyCareProgressNotes(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDailyCareProgressNotesNA() == null) {
			entityToUpdate.setInpDailyCareProgressNotesNA(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDismissalDiagnosis() == null) {
			entityToUpdate.setInpDismissalDiagnosis(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDismissalType() == null) {
			entityToUpdate.setInpDismissalType(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDismissalDateAndTime() == null) {
			entityToUpdate.setInpDismissalDateAndTime(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInpDismissalCondition() == null) {
			entityToUpdate.setInpDismissalCondition(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrAdmissionDiagnosis() == null) {
			entityToUpdate.setDrAdmissionDiagnosis(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrObservationDoctorNotes() == null) {
			entityToUpdate.setDrObservationDoctorNotes(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrObservationDoctorNotesNA() == null) {
			entityToUpdate.setDrObservationDoctorNotesNA(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrObservationNursingNotes() == null) {
			entityToUpdate.setDrObservationNursingNotes(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrObservationNursingNotesNA() == null) {
			entityToUpdate.setDrObservationNursingNotesNA(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrObservationProgressNotes() == null) {
			entityToUpdate.setDrObservationProgressNotes(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrObservationProgressNotesNA() == null) {
			entityToUpdate.setDrObservationProgressNotesNA(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrDismissalDiagnosis() == null) {
			entityToUpdate.setDrDismissalDiagnosis(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrDismissalType() == null) {
			entityToUpdate.setDrDismissalType(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDrDismissalDateAndTime() == null) {
			entityToUpdate.setDrDismissalDateAndTime(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtPreOperativeDiagnosis() == null) {
			entityToUpdate.setOtPreOperativeDiagnosis(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtPreOperativeNotesSurgery() == null) {
			entityToUpdate.setOtPreOperativeNotesSurgery(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtPreOperativeNotesAnaesthesiology() == null) {
			entityToUpdate.setOtPreOperativeNotesAnaesthesiology(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtIntraOperativeNotesSurgery() == null) {
			entityToUpdate.setOtIntraOperativeNotesSurgery(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtIntraOperativeNotesAnaesthesiology() == null) {
			entityToUpdate.setOtIntraOperativeNotesAnaesthesiology(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtPostOperativeNotesSurgery() == null) {
			entityToUpdate.setOtPostOperativeNotesSurgery(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtPostOperativeNotesAnaesthesiology() == null) {
			entityToUpdate.setOtPostOperativeNotesAnaesthesiology(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtPostOperativeDiagnosis() == null) {
			entityToUpdate.setOtPostOperativeDiagnosis(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtDismissalType() == null) {
			entityToUpdate.setOtDismissalType(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOtDismissalDateAndTime() == null) {
			entityToUpdate.setOtDismissalDateAndTime(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDsResponsibleStaff() == null) {
			entityToUpdate.setDsResponsibleStaff(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDsInterpretation() == null) {
			entityToUpdate.setDsInterpretation(false);
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
				entityToUpdate.getMedicalExaminationRecord().unsetMedicalRecordInitialChecklist();
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
	public void validateEntity(MedicalRecordInitialChecklistEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<MedicalRecordInitialChecklistEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the MedicalRecordInitialChecklistEntity.
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

	public Set<String> validateEntityRelations(MedicalRecordInitialChecklistEntity entity)
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
