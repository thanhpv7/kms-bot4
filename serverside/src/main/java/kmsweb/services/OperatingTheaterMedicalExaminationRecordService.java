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
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
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
import kmsweb.entities.DiagnosisNandaEntity;
import kmsweb.repositories.DiagnosisNandaRepository;
import kmsweb.entities.IntraoperativeRecordsEntity;
import kmsweb.repositories.IntraoperativeRecordsRepository;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.entities.PostOperativeDetailsEntity;
import kmsweb.repositories.PostOperativeDetailsRepository;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.repositories.PreoperativeRecordsRepository;
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
public class OperatingTheaterMedicalExaminationRecordService extends AbstractService<OperatingTheaterMedicalExaminationRecordEntity, OperatingTheaterMedicalExaminationRecordRepository, OperatingTheaterMedicalExaminationRecordEntityAudit> {

	private final String[] referenceNamesInOperatingTheaterMedicalExaminationRecordEntity = {
		"intraoperativeRecords",
		"postOperativeDetails",
		"preoperativeRecords",
		"nursingAnesthesiaDetail",
		"nursingDetailSurgicalNursings",
		"nursingDetailsAnesthesiaNursings",
		"nursingSurgicalDetail",
		"medicalExaminationRecord",
	};

	private final DiagnosisNandaRepository diagnosisNandaRepository;

	private final IntraoperativeRecordsRepository intraoperativeRecordsRepository;

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private final PostOperativeDetailsRepository postOperativeDetailsRepository;

	private final PreoperativeRecordsRepository preoperativeRecordsRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public OperatingTheaterMedicalExaminationRecordService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		DiagnosisNandaRepository diagnosisNandaRepository,
		IntraoperativeRecordsRepository intraoperativeRecordsRepository,
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		PostOperativeDetailsRepository postOperativeDetailsRepository,
		PreoperativeRecordsRepository preoperativeRecordsRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		OperatingTheaterMedicalExaminationRecordRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.diagnosisNandaRepository = diagnosisNandaRepository;

		this.intraoperativeRecordsRepository = intraoperativeRecordsRepository;

		this.medicalExaminationRecordRepository = medicalExaminationRecordRepository;

		this.postOperativeDetailsRepository = postOperativeDetailsRepository;

		this.preoperativeRecordsRepository = preoperativeRecordsRepository;

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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Has Confirmed Identity.
	 *
	 * @param hasConfirmedIdentity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Confirmed Identity
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByHasConfirmedIdentity(Boolean hasConfirmedIdentity)
	// % protected region % [Add any throwables, implementations, or extensions for findByHasConfirmedIdentity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHasConfirmedIdentity here] end
	{
		// % protected region % [Add any additional logic for findByHasConfirmedIdentity before the main body here] off begin
		// % protected region % [Add any additional logic for findByHasConfirmedIdentity before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHasConfirmedIdentity(hasConfirmedIdentity));

		// % protected region % [Add any additional logic for findByHasConfirmedIdentity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHasConfirmedIdentity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Safety Check Completed.
	 *
	 * @param anesthesiaSafetyCheckCompleted the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Safety Check Completed
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByAnesthesiaSafetyCheckCompleted(Boolean anesthesiaSafetyCheckCompleted)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaSafetyCheckCompleted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaSafetyCheckCompleted here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaSafetyCheckCompleted before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaSafetyCheckCompleted before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByAnesthesiaSafetyCheckCompleted(anesthesiaSafetyCheckCompleted));

		// % protected region % [Add any additional logic for findByAnesthesiaSafetyCheckCompleted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaSafetyCheckCompleted before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Oxymeter Functioning.
	 *
	 * @param pulseOxymeterFunctioning the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Oxymeter Functioning
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByPulseOxymeterFunctioning(Boolean pulseOxymeterFunctioning)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseOxymeterFunctioning here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseOxymeterFunctioning here] end
	{
		// % protected region % [Add any additional logic for findByPulseOxymeterFunctioning before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulseOxymeterFunctioning before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPulseOxymeterFunctioning(pulseOxymeterFunctioning));

		// % protected region % [Add any additional logic for findByPulseOxymeterFunctioning before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPulseOxymeterFunctioning before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Site Marked.
	 *
	 * @param siteMarked the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Site Marked
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findBySiteMarked(String siteMarked)
	// % protected region % [Add any throwables, implementations, or extensions for findBySiteMarked here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySiteMarked here] end
	{
		// % protected region % [Add any additional logic for findBySiteMarked before the main body here] off begin
		// % protected region % [Add any additional logic for findBySiteMarked before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findBySiteMarked(siteMarked));

		// % protected region % [Add any additional logic for findBySiteMarked before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySiteMarked before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Has Known Allergy.
	 *
	 * @param hasKnownAllergy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Known Allergy
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByHasKnownAllergy(String hasKnownAllergy)
	// % protected region % [Add any throwables, implementations, or extensions for findByHasKnownAllergy here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHasKnownAllergy here] end
	{
		// % protected region % [Add any additional logic for findByHasKnownAllergy before the main body here] off begin
		// % protected region % [Add any additional logic for findByHasKnownAllergy before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHasKnownAllergy(hasKnownAllergy));

		// % protected region % [Add any additional logic for findByHasKnownAllergy before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHasKnownAllergy before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Has Difficult Airway Risk.
	 *
	 * @param hasDifficultAirwayRisk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Difficult Airway Risk
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByHasDifficultAirwayRisk(String hasDifficultAirwayRisk)
	// % protected region % [Add any throwables, implementations, or extensions for findByHasDifficultAirwayRisk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHasDifficultAirwayRisk here] end
	{
		// % protected region % [Add any additional logic for findByHasDifficultAirwayRisk before the main body here] off begin
		// % protected region % [Add any additional logic for findByHasDifficultAirwayRisk before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHasDifficultAirwayRisk(hasDifficultAirwayRisk));

		// % protected region % [Add any additional logic for findByHasDifficultAirwayRisk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHasDifficultAirwayRisk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Has Risk Of Blood Loss.
	 *
	 * @param hasRiskOfBloodLoss the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Risk Of Blood Loss
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByHasRiskOfBloodLoss(String hasRiskOfBloodLoss)
	// % protected region % [Add any throwables, implementations, or extensions for findByHasRiskOfBloodLoss here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHasRiskOfBloodLoss here] end
	{
		// % protected region % [Add any additional logic for findByHasRiskOfBloodLoss before the main body here] off begin
		// % protected region % [Add any additional logic for findByHasRiskOfBloodLoss before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHasRiskOfBloodLoss(hasRiskOfBloodLoss));

		// % protected region % [Add any additional logic for findByHasRiskOfBloodLoss before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHasRiskOfBloodLoss before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Team Member Introduced.
	 *
	 * @param teamMemberIntroduced the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Team Member Introduced
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByTeamMemberIntroduced(Boolean teamMemberIntroduced)
	// % protected region % [Add any throwables, implementations, or extensions for findByTeamMemberIntroduced here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTeamMemberIntroduced here] end
	{
		// % protected region % [Add any additional logic for findByTeamMemberIntroduced before the main body here] off begin
		// % protected region % [Add any additional logic for findByTeamMemberIntroduced before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTeamMemberIntroduced(teamMemberIntroduced));

		// % protected region % [Add any additional logic for findByTeamMemberIntroduced before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTeamMemberIntroduced before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Professional Confirmed Patient.
	 *
	 * @param professionalConfirmedPatient the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Professional Confirmed Patient
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByProfessionalConfirmedPatient(Boolean professionalConfirmedPatient)
	// % protected region % [Add any throwables, implementations, or extensions for findByProfessionalConfirmedPatient here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProfessionalConfirmedPatient here] end
	{
		// % protected region % [Add any additional logic for findByProfessionalConfirmedPatient before the main body here] off begin
		// % protected region % [Add any additional logic for findByProfessionalConfirmedPatient before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByProfessionalConfirmedPatient(professionalConfirmedPatient));

		// % protected region % [Add any additional logic for findByProfessionalConfirmedPatient before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProfessionalConfirmedPatient before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Antibiotic Prophylaxis Given.
	 *
	 * @param antibioticProphylaxisGiven the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Antibiotic Prophylaxis Given
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByAntibioticProphylaxisGiven(String antibioticProphylaxisGiven)
	// % protected region % [Add any throwables, implementations, or extensions for findByAntibioticProphylaxisGiven here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAntibioticProphylaxisGiven here] end
	{
		// % protected region % [Add any additional logic for findByAntibioticProphylaxisGiven before the main body here] off begin
		// % protected region % [Add any additional logic for findByAntibioticProphylaxisGiven before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByAntibioticProphylaxisGiven(antibioticProphylaxisGiven));

		// % protected region % [Add any additional logic for findByAntibioticProphylaxisGiven before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAntibioticProphylaxisGiven before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Essential Imaging Displayed.
	 *
	 * @param essentialImagingDisplayed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Essential Imaging Displayed
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByEssentialImagingDisplayed(String essentialImagingDisplayed)
	// % protected region % [Add any throwables, implementations, or extensions for findByEssentialImagingDisplayed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEssentialImagingDisplayed here] end
	{
		// % protected region % [Add any additional logic for findByEssentialImagingDisplayed before the main body here] off begin
		// % protected region % [Add any additional logic for findByEssentialImagingDisplayed before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByEssentialImagingDisplayed(essentialImagingDisplayed));

		// % protected region % [Add any additional logic for findByEssentialImagingDisplayed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEssentialImagingDisplayed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Whare Are Critical Steps.
	 *
	 * @param whareAreCriticalSteps the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Whare Are Critical Steps
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByWhareAreCriticalSteps(Boolean whareAreCriticalSteps)
	// % protected region % [Add any throwables, implementations, or extensions for findByWhareAreCriticalSteps here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWhareAreCriticalSteps here] end
	{
		// % protected region % [Add any additional logic for findByWhareAreCriticalSteps before the main body here] off begin
		// % protected region % [Add any additional logic for findByWhareAreCriticalSteps before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByWhareAreCriticalSteps(whareAreCriticalSteps));

		// % protected region % [Add any additional logic for findByWhareAreCriticalSteps before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWhareAreCriticalSteps before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute How Long Case Take.
	 *
	 * @param howLongCaseTake the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute How Long Case Take
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByHowLongCaseTake(Boolean howLongCaseTake)
	// % protected region % [Add any throwables, implementations, or extensions for findByHowLongCaseTake here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHowLongCaseTake here] end
	{
		// % protected region % [Add any additional logic for findByHowLongCaseTake before the main body here] off begin
		// % protected region % [Add any additional logic for findByHowLongCaseTake before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHowLongCaseTake(howLongCaseTake));

		// % protected region % [Add any additional logic for findByHowLongCaseTake before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHowLongCaseTake before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute What Is Anticipated Blood Loss.
	 *
	 * @param whatIsAnticipatedBloodLoss the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute What Is Anticipated Blood Loss
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByWhatIsAnticipatedBloodLoss(Boolean whatIsAnticipatedBloodLoss)
	// % protected region % [Add any throwables, implementations, or extensions for findByWhatIsAnticipatedBloodLoss here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWhatIsAnticipatedBloodLoss here] end
	{
		// % protected region % [Add any additional logic for findByWhatIsAnticipatedBloodLoss before the main body here] off begin
		// % protected region % [Add any additional logic for findByWhatIsAnticipatedBloodLoss before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByWhatIsAnticipatedBloodLoss(whatIsAnticipatedBloodLoss));

		// % protected region % [Add any additional logic for findByWhatIsAnticipatedBloodLoss before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWhatIsAnticipatedBloodLoss before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Any Patient Specific Concerns.
	 *
	 * @param anyPatientSpecificConcerns the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Any Patient Specific Concerns
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByAnyPatientSpecificConcerns(Boolean anyPatientSpecificConcerns)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnyPatientSpecificConcerns here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnyPatientSpecificConcerns here] end
	{
		// % protected region % [Add any additional logic for findByAnyPatientSpecificConcerns before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnyPatientSpecificConcerns before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByAnyPatientSpecificConcerns(anyPatientSpecificConcerns));

		// % protected region % [Add any additional logic for findByAnyPatientSpecificConcerns before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnyPatientSpecificConcerns before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sterlity Been Confirmed.
	 *
	 * @param sterlityBeenConfirmed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sterlity Been Confirmed
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findBySterlityBeenConfirmed(Boolean sterlityBeenConfirmed)
	// % protected region % [Add any throwables, implementations, or extensions for findBySterlityBeenConfirmed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySterlityBeenConfirmed here] end
	{
		// % protected region % [Add any additional logic for findBySterlityBeenConfirmed before the main body here] off begin
		// % protected region % [Add any additional logic for findBySterlityBeenConfirmed before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findBySterlityBeenConfirmed(sterlityBeenConfirmed));

		// % protected region % [Add any additional logic for findBySterlityBeenConfirmed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySterlityBeenConfirmed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Equipment Issues Any Concern.
	 *
	 * @param equipmentIssuesAnyConcern the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Equipment Issues Any Concern
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByEquipmentIssuesAnyConcern(Boolean equipmentIssuesAnyConcern)
	// % protected region % [Add any throwables, implementations, or extensions for findByEquipmentIssuesAnyConcern here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEquipmentIssuesAnyConcern here] end
	{
		// % protected region % [Add any additional logic for findByEquipmentIssuesAnyConcern before the main body here] off begin
		// % protected region % [Add any additional logic for findByEquipmentIssuesAnyConcern before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByEquipmentIssuesAnyConcern(equipmentIssuesAnyConcern));

		// % protected region % [Add any additional logic for findByEquipmentIssuesAnyConcern before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEquipmentIssuesAnyConcern before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Name Of Procedure.
	 *
	 * @param nameOfProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name Of Procedure
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByNameOfProcedure(Boolean nameOfProcedure)
	// % protected region % [Add any throwables, implementations, or extensions for findByNameOfProcedure here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNameOfProcedure here] end
	{
		// % protected region % [Add any additional logic for findByNameOfProcedure before the main body here] off begin
		// % protected region % [Add any additional logic for findByNameOfProcedure before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByNameOfProcedure(nameOfProcedure));

		// % protected region % [Add any additional logic for findByNameOfProcedure before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNameOfProcedure before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Instruments Need Count Correct.
	 *
	 * @param instrumentsNeedCountCorrect the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruments Need Count Correct
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByInstrumentsNeedCountCorrect(Boolean instrumentsNeedCountCorrect)
	// % protected region % [Add any throwables, implementations, or extensions for findByInstrumentsNeedCountCorrect here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInstrumentsNeedCountCorrect here] end
	{
		// % protected region % [Add any additional logic for findByInstrumentsNeedCountCorrect before the main body here] off begin
		// % protected region % [Add any additional logic for findByInstrumentsNeedCountCorrect before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByInstrumentsNeedCountCorrect(instrumentsNeedCountCorrect));

		// % protected region % [Add any additional logic for findByInstrumentsNeedCountCorrect before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInstrumentsNeedCountCorrect before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Specimen Is Labeled.
	 *
	 * @param specimenIsLabeled the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Specimen Is Labeled
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findBySpecimenIsLabeled(Boolean specimenIsLabeled)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecimenIsLabeled here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecimenIsLabeled here] end
	{
		// % protected region % [Add any additional logic for findBySpecimenIsLabeled before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecimenIsLabeled before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findBySpecimenIsLabeled(specimenIsLabeled));

		// % protected region % [Add any additional logic for findBySpecimenIsLabeled before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecimenIsLabeled before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Equipment Problems Addressed.
	 *
	 * @param equipmentProblemsAddressed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Equipment Problems Addressed
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByEquipmentProblemsAddressed(Boolean equipmentProblemsAddressed)
	// % protected region % [Add any throwables, implementations, or extensions for findByEquipmentProblemsAddressed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEquipmentProblemsAddressed here] end
	{
		// % protected region % [Add any additional logic for findByEquipmentProblemsAddressed before the main body here] off begin
		// % protected region % [Add any additional logic for findByEquipmentProblemsAddressed before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByEquipmentProblemsAddressed(equipmentProblemsAddressed));

		// % protected region % [Add any additional logic for findByEquipmentProblemsAddressed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEquipmentProblemsAddressed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Key Concerns For Recovery.
	 *
	 * @param keyConcernsForRecovery the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Key Concerns For Recovery
	 */
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findByKeyConcernsForRecovery(Boolean keyConcernsForRecovery)
	// % protected region % [Add any throwables, implementations, or extensions for findByKeyConcernsForRecovery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKeyConcernsForRecovery here] end
	{
		// % protected region % [Add any additional logic for findByKeyConcernsForRecovery before the main body here] off begin
		// % protected region % [Add any additional logic for findByKeyConcernsForRecovery before the main body here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByKeyConcernsForRecovery(keyConcernsForRecovery));

		// % protected region % [Add any additional logic for findByKeyConcernsForRecovery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKeyConcernsForRecovery before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<OperatingTheaterMedicalExaminationRecordEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<OperatingTheaterMedicalExaminationRecordEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<OperatingTheaterMedicalExaminationRecordEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'create')")
	public OperatingTheaterMedicalExaminationRecordEntity create(OperatingTheaterMedicalExaminationRecordEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		OperatingTheaterMedicalExaminationRecordEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'create')")
	public OperatingTheaterMedicalExaminationRecordEntity create(OperatingTheaterMedicalExaminationRecordEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		OperatingTheaterMedicalExaminationRecordEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		OperatingTheaterMedicalExaminationRecordEntity newEntity;

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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'create')")
	public List<OperatingTheaterMedicalExaminationRecordEntity> createAll(Iterable<OperatingTheaterMedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<OperatingTheaterMedicalExaminationRecordEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'update')")
	public OperatingTheaterMedicalExaminationRecordEntity update(OperatingTheaterMedicalExaminationRecordEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		OperatingTheaterMedicalExaminationRecordEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'update')")
	public OperatingTheaterMedicalExaminationRecordEntity update(OperatingTheaterMedicalExaminationRecordEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		OperatingTheaterMedicalExaminationRecordEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		OperatingTheaterMedicalExaminationRecordEntity newEntity;

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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'update')")
	public List<OperatingTheaterMedicalExaminationRecordEntity> updateAll(Iterable<OperatingTheaterMedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<OperatingTheaterMedicalExaminationRecordEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'create') or hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'update')")
	public OperatingTheaterMedicalExaminationRecordEntity save(OperatingTheaterMedicalExaminationRecordEntity entity) throws ConstraintViolationException
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

		OperatingTheaterMedicalExaminationRecordEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'create') or hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'update')")
	public List<OperatingTheaterMedicalExaminationRecordEntity> saveAll(Iterable<OperatingTheaterMedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<OperatingTheaterMedicalExaminationRecordEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'delete')")
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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'delete')")
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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	public List<OperatingTheaterMedicalExaminationRecordEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	public List<OperatingTheaterMedicalExaminationRecordEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(OperatingTheaterMedicalExaminationRecordEntity.class);

		// % protected region % [Add any additional processing before converting to a list of OperatingTheaterMedicalExaminationRecordEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of OperatingTheaterMedicalExaminationRecordEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<OperatingTheaterMedicalExaminationRecordEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of OperatingTheaterMedicalExaminationRecordEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of OperatingTheaterMedicalExaminationRecordEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(OperatingTheaterMedicalExaminationRecordEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of OperatingTheaterMedicalExaminationRecordEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of OperatingTheaterMedicalExaminationRecordEntityAudits
	 */
	private List<OperatingTheaterMedicalExaminationRecordEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<OperatingTheaterMedicalExaminationRecordEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param operatingTheaterMedicalExaminationRecord operatingTheaterMedicalExaminationRecord to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private OperatingTheaterMedicalExaminationRecordEntity updateAuditData(OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecord)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return operatingTheaterMedicalExaminationRecord;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private OperatingTheaterMedicalExaminationRecordEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		OperatingTheaterMedicalExaminationRecordEntity entityAtRevision = updateAuditData((OperatingTheaterMedicalExaminationRecordEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new OperatingTheaterMedicalExaminationRecordEntityAudit(
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

		QOperatingTheaterMedicalExaminationRecordEntity entity = QOperatingTheaterMedicalExaminationRecordEntity.operatingTheaterMedicalExaminationRecordEntity;

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
			case "intraoperativeRecordsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Intraoperative Records here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Intraoperative Records here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.intraoperativeRecords.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Intraoperative Records here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Intraoperative Records here] end

				break;
			case "postOperativeDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Post Operative Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Post Operative Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.postOperativeDetails.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Post Operative Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Post Operative Details here] end

				break;
			case "preoperativeRecordsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Preoperative Records here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Preoperative Records here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.preoperativeRecords.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Preoperative Records here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Preoperative Records here] end

				break;
			case "medicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Operating Theater Medical Examination Record here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Operating Theater Medical Examination Record here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Operating Theater Medical Examination Record here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Operating Theater Medical Examination Record here] end

				break;
			case "nursingAnesthesiaDetailId":
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Anesthesia Detail to Nursing Anesthesia Detail here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Anesthesia Detail to Nursing Anesthesia Detail here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nursingAnesthesiaDetail.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Anesthesia Detail to Nursing Anesthesia Detail here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Anesthesia Detail to Nursing Anesthesia Detail here] end

				break;
			case "nursingDetailSurgicalNursingsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Detail Surgical Nursings to Nursing Detail Surgical Nursing here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Detail Surgical Nursings to Nursing Detail Surgical Nursing here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nursingDetailSurgicalNursings.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Detail Surgical Nursings to Nursing Detail Surgical Nursing here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Detail Surgical Nursings to Nursing Detail Surgical Nursing here] end

				break;
			case "nursingDetailsAnesthesiaNursingsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Details Anesthesia Nursings to Nursing Details Anesthesia Nursing here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Details Anesthesia Nursings to Nursing Details Anesthesia Nursing here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nursingDetailsAnesthesiaNursings.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Details Anesthesia Nursings to Nursing Details Anesthesia Nursing here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Details Anesthesia Nursings to Nursing Details Anesthesia Nursing here] end

				break;
			case "nursingSurgicalDetailId":
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Surgical Detail to Nursing Surgical Detail here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Surgical Detail to Nursing Surgical Detail here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nursingSurgicalDetail.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Surgical Detail to Nursing Surgical Detail here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Surgical Detail to Nursing Surgical Detail here] end

				break;
			case "pulseOxymeterFunctioning":
				// % protected region % [Add any additional logic before the query parameters of pulseOxymeterFunctioning here] off begin
				// % protected region % [Add any additional logic before the query parameters of pulseOxymeterFunctioning here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pulseOxymeterFunctioning, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of pulseOxymeterFunctioning here] off begin
				// % protected region % [Add any additional logic after the query parameters of pulseOxymeterFunctioning here] end

				break;
			case "hasKnownAllergy":
				// % protected region % [Add any additional logic before the query parameters of hasKnownAllergy here] off begin
				// % protected region % [Add any additional logic before the query parameters of hasKnownAllergy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hasKnownAllergy, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of hasKnownAllergy here] off begin
				// % protected region % [Add any additional logic after the query parameters of hasKnownAllergy here] end

				break;
			case "howLongCaseTake":
				// % protected region % [Add any additional logic before the query parameters of howLongCaseTake here] off begin
				// % protected region % [Add any additional logic before the query parameters of howLongCaseTake here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.howLongCaseTake, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of howLongCaseTake here] off begin
				// % protected region % [Add any additional logic after the query parameters of howLongCaseTake here] end

				break;
			case "nameOfProcedure":
				// % protected region % [Add any additional logic before the query parameters of nameOfProcedure here] off begin
				// % protected region % [Add any additional logic before the query parameters of nameOfProcedure here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nameOfProcedure, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nameOfProcedure here] off begin
				// % protected region % [Add any additional logic after the query parameters of nameOfProcedure here] end

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
	public OperatingTheaterMedicalExaminationRecordEntity updateOldData(OperatingTheaterMedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public OperatingTheaterMedicalExaminationRecordEntity updateOldData(OperatingTheaterMedicalExaminationRecordEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		OperatingTheaterMedicalExaminationRecordEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInOperatingTheaterMedicalExaminationRecordEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getHasConfirmedIdentity() == null) {
			entityToUpdate.setHasConfirmedIdentity(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getAnesthesiaSafetyCheckCompleted() == null) {
			entityToUpdate.setAnesthesiaSafetyCheckCompleted(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getPulseOxymeterFunctioning() == null) {
			entityToUpdate.setPulseOxymeterFunctioning(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getTeamMemberIntroduced() == null) {
			entityToUpdate.setTeamMemberIntroduced(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getProfessionalConfirmedPatient() == null) {
			entityToUpdate.setProfessionalConfirmedPatient(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getWhareAreCriticalSteps() == null) {
			entityToUpdate.setWhareAreCriticalSteps(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getHowLongCaseTake() == null) {
			entityToUpdate.setHowLongCaseTake(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getWhatIsAnticipatedBloodLoss() == null) {
			entityToUpdate.setWhatIsAnticipatedBloodLoss(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getAnyPatientSpecificConcerns() == null) {
			entityToUpdate.setAnyPatientSpecificConcerns(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getSterlityBeenConfirmed() == null) {
			entityToUpdate.setSterlityBeenConfirmed(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getEquipmentIssuesAnyConcern() == null) {
			entityToUpdate.setEquipmentIssuesAnyConcern(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getNameOfProcedure() == null) {
			entityToUpdate.setNameOfProcedure(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInstrumentsNeedCountCorrect() == null) {
			entityToUpdate.setInstrumentsNeedCountCorrect(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getSpecimenIsLabeled() == null) {
			entityToUpdate.setSpecimenIsLabeled(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getEquipmentProblemsAddressed() == null) {
			entityToUpdate.setEquipmentProblemsAddressed(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getKeyConcernsForRecovery() == null) {
			entityToUpdate.setKeyConcernsForRecovery(false);
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
				entityToUpdate.getMedicalExaminationRecord().unsetOperatingTheaterMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getIntraoperativeRecords() == null && entity.getIntraoperativeRecordsId() == null) {
			entityToUpdate.unsetIntraoperativeRecords();
		} else if (entity.getIntraoperativeRecordsId() != null && entity.getIntraoperativeRecords() == null) {
			Optional<IntraoperativeRecordsEntity> intraoperativeRecordsEntity = this.intraoperativeRecordsRepository.findById(entity.getIntraoperativeRecordsId());
			entityToUpdate.setIntraoperativeRecords(intraoperativeRecordsEntity.orElseThrow());
		}
		if (persistRelations && entity.getIntraoperativeRecords() != null) {
			entityToUpdate.setIntraoperativeRecords(entity.getIntraoperativeRecords(), false);
			if (entityToUpdate.getIntraoperativeRecordsId() != null) {
				this.intraoperativeRecordsRepository.save(entityToUpdate.getIntraoperativeRecords());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getIntraoperativeRecords().unsetOperatingTheaterMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getPostOperativeDetails() == null && entity.getPostOperativeDetailsId() == null) {
			entityToUpdate.unsetPostOperativeDetails();
		} else if (entity.getPostOperativeDetailsId() != null && entity.getPostOperativeDetails() == null) {
			Optional<PostOperativeDetailsEntity> postOperativeDetailsEntity = this.postOperativeDetailsRepository.findById(entity.getPostOperativeDetailsId());
			entityToUpdate.setPostOperativeDetails(postOperativeDetailsEntity.orElseThrow());
		}
		if (persistRelations && entity.getPostOperativeDetails() != null) {
			entityToUpdate.setPostOperativeDetails(entity.getPostOperativeDetails(), false);
			if (entityToUpdate.getPostOperativeDetailsId() != null) {
				this.postOperativeDetailsRepository.save(entityToUpdate.getPostOperativeDetails());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPostOperativeDetails().unsetOperatingTheaterMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getPreoperativeRecords() == null && entity.getPreoperativeRecordsId() == null) {
			entityToUpdate.unsetPreoperativeRecords();
		} else if (entity.getPreoperativeRecordsId() != null && entity.getPreoperativeRecords() == null) {
			Optional<PreoperativeRecordsEntity> preoperativeRecordsEntity = this.preoperativeRecordsRepository.findById(entity.getPreoperativeRecordsId());
			entityToUpdate.setPreoperativeRecords(preoperativeRecordsEntity.orElseThrow());
		}
		if (persistRelations && entity.getPreoperativeRecords() != null) {
			entityToUpdate.setPreoperativeRecords(entity.getPreoperativeRecords(), false);
			if (entityToUpdate.getPreoperativeRecordsId() != null) {
				this.preoperativeRecordsRepository.save(entityToUpdate.getPreoperativeRecords());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPreoperativeRecords().unsetOperatingTheaterMedicalExaminationRecord();
			}
		}

		// Incoming One to Many reference
		if (entity.getNursingAnesthesiaDetail() == null && entity.getNursingAnesthesiaDetailId() == null) {
			entityToUpdate.unsetNursingAnesthesiaDetail();
		} else if (entity.getNursingAnesthesiaDetailId() != null && entity.getNursingAnesthesiaDetail() == null) {
			Optional<DiagnosisNandaEntity> nursingAnesthesiaDetailEntity = this.diagnosisNandaRepository.findById(entity.getNursingAnesthesiaDetailId());
			entityToUpdate.setNursingAnesthesiaDetail(nursingAnesthesiaDetailEntity.orElseThrow());
		}
		if (persistRelations && entity.getNursingAnesthesiaDetail() != null) {
			entityToUpdate.setNursingAnesthesiaDetail(entity.getNursingAnesthesiaDetail(), false);
			if (entityToUpdate.getNursingAnesthesiaDetailId() != null) {
				this.diagnosisNandaRepository.save(entityToUpdate.getNursingAnesthesiaDetail());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getNursingAnesthesiaDetail().unsetNursingAnesthesiaDetail();
			}
		}

		// Incoming One to Many reference
		if (entity.getNursingDetailSurgicalNursings() == null && entity.getNursingDetailSurgicalNursingsId() == null) {
			entityToUpdate.unsetNursingDetailSurgicalNursings();
		} else if (entity.getNursingDetailSurgicalNursingsId() != null && entity.getNursingDetailSurgicalNursings() == null) {
			Optional<StaffEntity> nursingDetailSurgicalNursingsEntity = this.staffRepository.findById(entity.getNursingDetailSurgicalNursingsId());
			entityToUpdate.setNursingDetailSurgicalNursings(nursingDetailSurgicalNursingsEntity.orElseThrow());
		}
		if (persistRelations && entity.getNursingDetailSurgicalNursings() != null) {
			entityToUpdate.setNursingDetailSurgicalNursings(entity.getNursingDetailSurgicalNursings(), false);
			if (entityToUpdate.getNursingDetailSurgicalNursingsId() != null) {
				this.staffRepository.save(entityToUpdate.getNursingDetailSurgicalNursings());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getNursingDetailSurgicalNursings().unsetNursingDetailSurgicalNursing();
			}
		}

		// Incoming One to Many reference
		if (entity.getNursingDetailsAnesthesiaNursings() == null && entity.getNursingDetailsAnesthesiaNursingsId() == null) {
			entityToUpdate.unsetNursingDetailsAnesthesiaNursings();
		} else if (entity.getNursingDetailsAnesthesiaNursingsId() != null && entity.getNursingDetailsAnesthesiaNursings() == null) {
			Optional<StaffEntity> nursingDetailsAnesthesiaNursingsEntity = this.staffRepository.findById(entity.getNursingDetailsAnesthesiaNursingsId());
			entityToUpdate.setNursingDetailsAnesthesiaNursings(nursingDetailsAnesthesiaNursingsEntity.orElseThrow());
		}
		if (persistRelations && entity.getNursingDetailsAnesthesiaNursings() != null) {
			entityToUpdate.setNursingDetailsAnesthesiaNursings(entity.getNursingDetailsAnesthesiaNursings(), false);
			if (entityToUpdate.getNursingDetailsAnesthesiaNursingsId() != null) {
				this.staffRepository.save(entityToUpdate.getNursingDetailsAnesthesiaNursings());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getNursingDetailsAnesthesiaNursings().unsetNursingDetailsAnesthesiaNursing();
			}
		}

		// Incoming One to Many reference
		if (entity.getNursingSurgicalDetail() == null && entity.getNursingSurgicalDetailId() == null) {
			entityToUpdate.unsetNursingSurgicalDetail();
		} else if (entity.getNursingSurgicalDetailId() != null && entity.getNursingSurgicalDetail() == null) {
			Optional<DiagnosisNandaEntity> nursingSurgicalDetailEntity = this.diagnosisNandaRepository.findById(entity.getNursingSurgicalDetailId());
			entityToUpdate.setNursingSurgicalDetail(nursingSurgicalDetailEntity.orElseThrow());
		}
		if (persistRelations && entity.getNursingSurgicalDetail() != null) {
			entityToUpdate.setNursingSurgicalDetail(entity.getNursingSurgicalDetail(), false);
			if (entityToUpdate.getNursingSurgicalDetailId() != null) {
				this.diagnosisNandaRepository.save(entityToUpdate.getNursingSurgicalDetail());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getNursingSurgicalDetail().unsetNursingSurgicalDetail();
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
	public void validateEntity(OperatingTheaterMedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<OperatingTheaterMedicalExaminationRecordEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the OperatingTheaterMedicalExaminationRecordEntity.
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

	public Set<String> validateEntityRelations(OperatingTheaterMedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getNursingAnesthesiaDetailId() != null && this.diagnosisNandaRepository.findById(entity.getNursingAnesthesiaDetailId()).isEmpty()) {
			errors.add("The UUID " + entity.getNursingAnesthesiaDetailId() + " is not associated with a Diagnosis Nanda Entity");
		}

		if (entity.getNursingDetailSurgicalNursingsId() != null && this.staffRepository.findById(entity.getNursingDetailSurgicalNursingsId()).isEmpty()) {
			errors.add("The UUID " + entity.getNursingDetailSurgicalNursingsId() + " is not associated with a Staff Entity");
		}

		if (entity.getNursingDetailsAnesthesiaNursingsId() != null && this.staffRepository.findById(entity.getNursingDetailsAnesthesiaNursingsId()).isEmpty()) {
			errors.add("The UUID " + entity.getNursingDetailsAnesthesiaNursingsId() + " is not associated with a Staff Entity");
		}

		if (entity.getNursingSurgicalDetailId() != null && this.diagnosisNandaRepository.findById(entity.getNursingSurgicalDetailId()).isEmpty()) {
			errors.add("The UUID " + entity.getNursingSurgicalDetailId() + " is not associated with a Diagnosis Nanda Entity");
		}

		if (entity.getMedicalExaminationRecordId() != null && this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordId() + " is not associated with a Medical Examination Record Entity");
		}

		if (entity.getIntraoperativeRecordsId() != null && this.intraoperativeRecordsRepository.findById(entity.getIntraoperativeRecordsId()).isEmpty()) {
			errors.add("The UUID " + entity.getIntraoperativeRecordsId() + " is not associated with a Intraoperative Records Entity");
		}

		if (entity.getPostOperativeDetailsId() != null && this.postOperativeDetailsRepository.findById(entity.getPostOperativeDetailsId()).isEmpty()) {
			errors.add("The UUID " + entity.getPostOperativeDetailsId() + " is not associated with a Post Operative Details Entity");
		}

		if (entity.getPreoperativeRecordsId() != null && this.preoperativeRecordsRepository.findById(entity.getPreoperativeRecordsId()).isEmpty()) {
			errors.add("The UUID " + entity.getPreoperativeRecordsId() + " is not associated with a Preoperative Records Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
