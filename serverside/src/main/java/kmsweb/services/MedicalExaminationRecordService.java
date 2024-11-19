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
import kmsweb.repositories.MedicalExaminationRecordRepository;
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
import kmsweb.entities.AmendmentDetailEntity;
import kmsweb.repositories.AmendmentDetailRepository;
import kmsweb.entities.BirthHistoryEntity;
import kmsweb.repositories.BirthHistoryRepository;
import kmsweb.entities.BodyChartExaminationEntity;
import kmsweb.repositories.BodyChartExaminationRepository;
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.repositories.CoTreatingDoctorRepository;
import kmsweb.entities.DailyCareCPPTEntity;
import kmsweb.repositories.DailyCareCPPTRepository;
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.repositories.DiagnosisExaminationRecordRepository;
import kmsweb.entities.DiagnosisNandaEntity;
import kmsweb.repositories.DiagnosisNandaRepository;
import kmsweb.entities.EntExaminationEntity;
import kmsweb.repositories.EntExaminationRepository;
import kmsweb.entities.EmergencyMedicalExaminationRecordEntity;
import kmsweb.repositories.EmergencyMedicalExaminationRecordRepository;
import kmsweb.entities.FormulirKonselingTesHivEntity;
import kmsweb.repositories.FormulirKonselingTesHivRepository;
import kmsweb.entities.HemodialysisExaminationEntity;
import kmsweb.repositories.HemodialysisExaminationRepository;
import kmsweb.entities.InpatientMedicalExaminationRecordEntity;
import kmsweb.repositories.InpatientMedicalExaminationRecordRepository;
import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import kmsweb.repositories.MedicalExaminationRecordDischargeSummaryRepository;
import kmsweb.entities.MedicalRecordInitialChecklistEntity;
import kmsweb.repositories.MedicalRecordInitialChecklistRepository;
import kmsweb.entities.MedicalRecordNextVerificationChecklistEntity;
import kmsweb.repositories.MedicalRecordNextVerificationChecklistRepository;
import kmsweb.entities.NurseVitalSignMeasurementEntity;
import kmsweb.repositories.NurseVitalSignMeasurementRepository;
import kmsweb.entities.ObstetricAndGynecologyHistoryEntity;
import kmsweb.repositories.ObstetricAndGynecologyHistoryRepository;
import kmsweb.entities.OdontogramExaminationEntity;
import kmsweb.repositories.OdontogramExaminationRepository;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.entities.OphthalmologyExaminationEntity;
import kmsweb.repositories.OphthalmologyExaminationRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.entities.RoomTransferEntity;
import kmsweb.repositories.RoomTransferRepository;
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
public class MedicalExaminationRecordService extends AbstractService<MedicalExaminationRecordEntity, MedicalExaminationRecordRepository, MedicalExaminationRecordEntityAudit> {

	private final String[] referenceNamesInMedicalExaminationRecordEntity = {
		"amendmentDetails",
		"birthHistory",
		"bodyChartExamination",
		"coTreatingDoctors",
		"dailyCareCPPTs",
		"deliveryMedicalExaminationRecord",
		"diagnosisExaminationRecords",
		"diagnosisNandas",
		"entExamination",
		"emergencyMedicationExaminationRecord",
		"formulirKonselingTesHiv",
		"hemodialysisExamination",
		"medicalExaminationRecordDischargeSummary",
		"medicalRecordInitialChecklist",
		"medicalRecordNextVerificationChecklist",
		"nurseVitalSignMeasurement",
		"obstetricAndGynecologyHistory",
		"odontogramExamination",
		"operatingTheaterMedicalExaminationRecord",
		"ophthalmologyExamination",
		"roomTransfers",
		"doctor",
		"inpatientMedicalExaminationRecord",
		"registration",
		"medicalTranscriber",
		"nurse",
	};

	private final AmendmentDetailRepository amendmentDetailRepository;

	private final BirthHistoryRepository birthHistoryRepository;

	private final BodyChartExaminationRepository bodyChartExaminationRepository;

	private final CoTreatingDoctorRepository coTreatingDoctorRepository;

	private final DailyCareCPPTRepository dailyCareCPPTRepository;

	private final DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository;

	private final DiagnosisExaminationRecordRepository diagnosisExaminationRecordRepository;

	private final DiagnosisNandaRepository diagnosisNandaRepository;

	private final EntExaminationRepository entExaminationRepository;

	private final EmergencyMedicalExaminationRecordRepository emergencyMedicalExaminationRecordRepository;

	private final FormulirKonselingTesHivRepository formulirKonselingTesHivRepository;

	private final HemodialysisExaminationRepository hemodialysisExaminationRepository;

	private final InpatientMedicalExaminationRecordRepository inpatientMedicalExaminationRecordRepository;

	private final MedicalExaminationRecordDischargeSummaryRepository medicalExaminationRecordDischargeSummaryRepository;

	private final MedicalRecordInitialChecklistRepository medicalRecordInitialChecklistRepository;

	private final MedicalRecordNextVerificationChecklistRepository medicalRecordNextVerificationChecklistRepository;

	private final NurseVitalSignMeasurementRepository nurseVitalSignMeasurementRepository;

	private final ObstetricAndGynecologyHistoryRepository obstetricAndGynecologyHistoryRepository;

	private final OdontogramExaminationRepository odontogramExaminationRepository;

	private final OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	private final OphthalmologyExaminationRepository ophthalmologyExaminationRepository;

	private final RegistrationRepository registrationRepository;

	private final RoomTransferRepository roomTransferRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public MedicalExaminationRecordService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		AmendmentDetailRepository amendmentDetailRepository,
		BirthHistoryRepository birthHistoryRepository,
		BodyChartExaminationRepository bodyChartExaminationRepository,
		CoTreatingDoctorRepository coTreatingDoctorRepository,
		DailyCareCPPTRepository dailyCareCPPTRepository,
		DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository,
		DiagnosisExaminationRecordRepository diagnosisExaminationRecordRepository,
		DiagnosisNandaRepository diagnosisNandaRepository,
		EntExaminationRepository entExaminationRepository,
		EmergencyMedicalExaminationRecordRepository emergencyMedicalExaminationRecordRepository,
		FormulirKonselingTesHivRepository formulirKonselingTesHivRepository,
		HemodialysisExaminationRepository hemodialysisExaminationRepository,
		InpatientMedicalExaminationRecordRepository inpatientMedicalExaminationRecordRepository,
		MedicalExaminationRecordDischargeSummaryRepository medicalExaminationRecordDischargeSummaryRepository,
		MedicalRecordInitialChecklistRepository medicalRecordInitialChecklistRepository,
		MedicalRecordNextVerificationChecklistRepository medicalRecordNextVerificationChecklistRepository,
		NurseVitalSignMeasurementRepository nurseVitalSignMeasurementRepository,
		ObstetricAndGynecologyHistoryRepository obstetricAndGynecologyHistoryRepository,
		OdontogramExaminationRepository odontogramExaminationRepository,
		OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository,
		OphthalmologyExaminationRepository ophthalmologyExaminationRepository,
		RegistrationRepository registrationRepository,
		RoomTransferRepository roomTransferRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		MedicalExaminationRecordRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.amendmentDetailRepository = amendmentDetailRepository;

		this.birthHistoryRepository = birthHistoryRepository;

		this.bodyChartExaminationRepository = bodyChartExaminationRepository;

		this.coTreatingDoctorRepository = coTreatingDoctorRepository;

		this.dailyCareCPPTRepository = dailyCareCPPTRepository;

		this.deliveryMedicalExaminationRecordRepository = deliveryMedicalExaminationRecordRepository;

		this.diagnosisExaminationRecordRepository = diagnosisExaminationRecordRepository;

		this.diagnosisNandaRepository = diagnosisNandaRepository;

		this.entExaminationRepository = entExaminationRepository;

		this.emergencyMedicalExaminationRecordRepository = emergencyMedicalExaminationRecordRepository;

		this.formulirKonselingTesHivRepository = formulirKonselingTesHivRepository;

		this.hemodialysisExaminationRepository = hemodialysisExaminationRepository;

		this.inpatientMedicalExaminationRecordRepository = inpatientMedicalExaminationRecordRepository;

		this.medicalExaminationRecordDischargeSummaryRepository = medicalExaminationRecordDischargeSummaryRepository;

		this.medicalRecordInitialChecklistRepository = medicalRecordInitialChecklistRepository;

		this.medicalRecordNextVerificationChecklistRepository = medicalRecordNextVerificationChecklistRepository;

		this.nurseVitalSignMeasurementRepository = nurseVitalSignMeasurementRepository;

		this.obstetricAndGynecologyHistoryRepository = obstetricAndGynecologyHistoryRepository;

		this.odontogramExaminationRepository = odontogramExaminationRepository;

		this.operatingTheaterMedicalExaminationRecordRepository = operatingTheaterMedicalExaminationRecordRepository;

		this.ophthalmologyExaminationRepository = ophthalmologyExaminationRepository;

		this.registrationRepository = registrationRepository;

		this.roomTransferRepository = roomTransferRepository;

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
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
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
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByDiastole(Integer diastole)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] end
	{
		// % protected region % [Add any additional logic for findByDiastole before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastole before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByDiastole(diastole));

		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findBySystole(Integer systole)
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] end
	{
		// % protected region % [Add any additional logic for findBySystole before the main body here] off begin
		// % protected region % [Add any additional logic for findBySystole before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findBySystole(systole));

		// % protected region % [Add any additional logic for findBySystole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySystole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pulse.
	 *
	 * @param pulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPulse(Integer pulse)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulse here] end
	{
		// % protected region % [Add any additional logic for findByPulse before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulse before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPulse(pulse));

		// % protected region % [Add any additional logic for findByPulse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPulse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BP Standing Systole.
	 *
	 * @param bpStandingSystole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BP Standing Systole
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByBpStandingSystole(Integer bpStandingSystole)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpStandingSystole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpStandingSystole here] end
	{
		// % protected region % [Add any additional logic for findByBpStandingSystole before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpStandingSystole before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByBpStandingSystole(bpStandingSystole));

		// % protected region % [Add any additional logic for findByBpStandingSystole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpStandingSystole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BP Standing Diastole.
	 *
	 * @param bpStandingDiastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BP Standing Diastole
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByBpStandingDiastole(Integer bpStandingDiastole)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpStandingDiastole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpStandingDiastole here] end
	{
		// % protected region % [Add any additional logic for findByBpStandingDiastole before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpStandingDiastole before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByBpStandingDiastole(bpStandingDiastole));

		// % protected region % [Add any additional logic for findByBpStandingDiastole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpStandingDiastole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Regularity.
	 *
	 * @param pulseRegularity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Regularity
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPulseRegularity(String pulseRegularity)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseRegularity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseRegularity here] end
	{
		// % protected region % [Add any additional logic for findByPulseRegularity before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulseRegularity before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPulseRegularity(pulseRegularity));

		// % protected region % [Add any additional logic for findByPulseRegularity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPulseRegularity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Strength.
	 *
	 * @param pulseStrength the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Strength
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPulseStrength(String pulseStrength)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseStrength here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseStrength here] end
	{
		// % protected region % [Add any additional logic for findByPulseStrength before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulseStrength before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPulseStrength(pulseStrength));

		// % protected region % [Add any additional logic for findByPulseStrength before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPulseStrength before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Temperature.
	 *
	 * @param temperature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByTemperature(Double temperature)
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperature here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperature here] end
	{
		// % protected region % [Add any additional logic for findByTemperature before the main body here] off begin
		// % protected region % [Add any additional logic for findByTemperature before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTemperature(temperature));

		// % protected region % [Add any additional logic for findByTemperature before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTemperature before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Temperature scale.
	 *
	 * @param temperatureScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature scale
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByTemperatureScale(String temperatureScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperatureScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperatureScale here] end
	{
		// % protected region % [Add any additional logic for findByTemperatureScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByTemperatureScale before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTemperatureScale(temperatureScale));

		// % protected region % [Add any additional logic for findByTemperatureScale before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTemperatureScale before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute GCS Eyes.
	 *
	 * @param gcsEyes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute GCS Eyes
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByGcsEyes(String gcsEyes)
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsEyes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsEyes here] end
	{
		// % protected region % [Add any additional logic for findByGcsEyes before the main body here] off begin
		// % protected region % [Add any additional logic for findByGcsEyes before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByGcsEyes(gcsEyes));

		// % protected region % [Add any additional logic for findByGcsEyes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGcsEyes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute GCS Verbal.
	 *
	 * @param gcsVerbal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute GCS Verbal
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByGcsVerbal(String gcsVerbal)
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsVerbal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsVerbal here] end
	{
		// % protected region % [Add any additional logic for findByGcsVerbal before the main body here] off begin
		// % protected region % [Add any additional logic for findByGcsVerbal before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByGcsVerbal(gcsVerbal));

		// % protected region % [Add any additional logic for findByGcsVerbal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGcsVerbal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute GCS Motor.
	 *
	 * @param gcsMotor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute GCS Motor
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByGcsMotor(String gcsMotor)
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsMotor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsMotor here] end
	{
		// % protected region % [Add any additional logic for findByGcsMotor before the main body here] off begin
		// % protected region % [Add any additional logic for findByGcsMotor before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByGcsMotor(gcsMotor));

		// % protected region % [Add any additional logic for findByGcsMotor before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGcsMotor before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total GCS Score.
	 *
	 * @param totalGCSScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total GCS Score
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByTotalGCSScore(Double totalGCSScore)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalGCSScore here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalGCSScore here] end
	{
		// % protected region % [Add any additional logic for findByTotalGCSScore before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalGCSScore before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTotalGCSScore(totalGCSScore));

		// % protected region % [Add any additional logic for findByTotalGCSScore before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalGCSScore before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Consciousness.
	 *
	 * @param consciousness the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consciousness
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByConsciousness(String consciousness)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsciousness here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsciousness here] end
	{
		// % protected region % [Add any additional logic for findByConsciousness before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsciousness before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByConsciousness(consciousness));

		// % protected region % [Add any additional logic for findByConsciousness before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsciousness before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Height.
	 *
	 * @param height the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByHeight(Double height)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeight here] end
	{
		// % protected region % [Add any additional logic for findByHeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeight before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHeight(height));

		// % protected region % [Add any additional logic for findByHeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Height Scale.
	 *
	 * @param heightScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height Scale
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByHeightScale(String heightScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeightScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeightScale here] end
	{
		// % protected region % [Add any additional logic for findByHeightScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeightScale before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHeightScale(heightScale));

		// % protected region % [Add any additional logic for findByHeightScale before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeightScale before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByWeight(Double weight)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] end
	{
		// % protected region % [Add any additional logic for findByWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeight before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByWeight(weight));

		// % protected region % [Add any additional logic for findByWeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight Scale.
	 *
	 * @param weightScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Scale
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByWeightScale(String weightScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightScale here] end
	{
		// % protected region % [Add any additional logic for findByWeightScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightScale before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByWeightScale(weightScale));

		// % protected region % [Add any additional logic for findByWeightScale before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightScale before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BMI.
	 *
	 * @param bmi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BMI
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByBmi(Double bmi)
	// % protected region % [Add any throwables, implementations, or extensions for findByBmi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBmi here] end
	{
		// % protected region % [Add any additional logic for findByBmi before the main body here] off begin
		// % protected region % [Add any additional logic for findByBmi before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByBmi(bmi));

		// % protected region % [Add any additional logic for findByBmi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBmi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Respiratory.
	 *
	 * @param respiratory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Respiratory
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByRespiratory(Double respiratory)
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratory here] end
	{
		// % protected region % [Add any additional logic for findByRespiratory before the main body here] off begin
		// % protected region % [Add any additional logic for findByRespiratory before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByRespiratory(respiratory));

		// % protected region % [Add any additional logic for findByRespiratory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRespiratory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Oxygen Saturation.
	 *
	 * @param oxygenSaturation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Oxygen Saturation
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByOxygenSaturation(Double oxygenSaturation)
	// % protected region % [Add any throwables, implementations, or extensions for findByOxygenSaturation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOxygenSaturation here] end
	{
		// % protected region % [Add any additional logic for findByOxygenSaturation before the main body here] off begin
		// % protected region % [Add any additional logic for findByOxygenSaturation before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByOxygenSaturation(oxygenSaturation));

		// % protected region % [Add any additional logic for findByOxygenSaturation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOxygenSaturation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference.
	 *
	 * @param waistCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByWaistCircumference(Double waistCircumference)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumference here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumference here] end
	{
		// % protected region % [Add any additional logic for findByWaistCircumference before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumference before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByWaistCircumference(waistCircumference));

		// % protected region % [Add any additional logic for findByWaistCircumference before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumference before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference Unit.
	 *
	 * @param waistCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference Unit
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByWaistCircumferenceUnit(String waistCircumferenceUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumferenceUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumferenceUnit here] end
	{
		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByWaistCircumferenceUnit(waistCircumferenceUnit));

		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nutrition Status.
	 *
	 * @param nutritionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nutrition Status
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByNutritionStatus(String nutritionStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByNutritionStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNutritionStatus here] end
	{
		// % protected region % [Add any additional logic for findByNutritionStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByNutritionStatus before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByNutritionStatus(nutritionStatus));

		// % protected region % [Add any additional logic for findByNutritionStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNutritionStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pain Scale.
	 *
	 * @param painScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pain Scale
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPainScale(Integer painScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScale here] end
	{
		// % protected region % [Add any additional logic for findByPainScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByPainScale before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPainScale(painScale));

		// % protected region % [Add any additional logic for findByPainScale before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPainScale before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pain Scale Used.
	 *
	 * @param painScaleUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pain Scale Used
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPainScaleUsed(String painScaleUsed)
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScaleUsed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScaleUsed here] end
	{
		// % protected region % [Add any additional logic for findByPainScaleUsed before the main body here] off begin
		// % protected region % [Add any additional logic for findByPainScaleUsed before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPainScaleUsed(painScaleUsed));

		// % protected region % [Add any additional logic for findByPainScaleUsed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPainScaleUsed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Risk Fall Scale.
	 *
	 * @param riskFallScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Fall Scale
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByRiskFallScale(Integer riskFallScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScale here] end
	{
		// % protected region % [Add any additional logic for findByRiskFallScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScale before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByRiskFallScale(riskFallScale));

		// % protected region % [Add any additional logic for findByRiskFallScale before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScale before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Objective.
	 *
	 * @param objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Objective
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByObjective(String objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByObjective here] end
	{
		// % protected region % [Add any additional logic for findByObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByObjective before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByObjective(objective));

		// % protected region % [Add any additional logic for findByObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Risk Fall Scale Used.
	 *
	 * @param riskFallScaleUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Fall Scale Used
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByRiskFallScaleUsed(String riskFallScaleUsed)
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScaleUsed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScaleUsed here] end
	{
		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before the main body here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByRiskFallScaleUsed(riskFallScaleUsed));

		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Subjective.
	 *
	 * @param subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Subjective
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findBySubjective(String subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubjective here] end
	{
		// % protected region % [Add any additional logic for findBySubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubjective before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findBySubjective(subjective));

		// % protected region % [Add any additional logic for findBySubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Plan.
	 *
	 * @param plan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Plan
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPlan(String plan)
	// % protected region % [Add any throwables, implementations, or extensions for findByPlan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPlan here] end
	{
		// % protected region % [Add any additional logic for findByPlan before the main body here] off begin
		// % protected region % [Add any additional logic for findByPlan before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPlan(plan));

		// % protected region % [Add any additional logic for findByPlan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPlan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Purpose.
	 *
	 * @param purpose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purpose
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPurpose(String purpose)
	// % protected region % [Add any throwables, implementations, or extensions for findByPurpose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPurpose here] end
	{
		// % protected region % [Add any additional logic for findByPurpose before the main body here] off begin
		// % protected region % [Add any additional logic for findByPurpose before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPurpose(purpose));

		// % protected region % [Add any additional logic for findByPurpose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPurpose before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Examination Sub Case.
	 *
	 * @param examinationSubCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Examination Sub Case
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByExaminationSubCase(String examinationSubCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByExaminationSubCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExaminationSubCase here] end
	{
		// % protected region % [Add any additional logic for findByExaminationSubCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByExaminationSubCase before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByExaminationSubCase(examinationSubCase));

		// % protected region % [Add any additional logic for findByExaminationSubCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExaminationSubCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Accidental Type.
	 *
	 * @param accidentalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accidental Type
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByAccidentalType(String accidentalType)
	// % protected region % [Add any throwables, implementations, or extensions for findByAccidentalType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAccidentalType here] end
	{
		// % protected region % [Add any additional logic for findByAccidentalType before the main body here] off begin
		// % protected region % [Add any additional logic for findByAccidentalType before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByAccidentalType(accidentalType));

		// % protected region % [Add any additional logic for findByAccidentalType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAccidentalType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Service Case.
	 *
	 * @param serviceCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Case
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByServiceCase(String serviceCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceCase here] end
	{
		// % protected region % [Add any additional logic for findByServiceCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByServiceCase before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByServiceCase(serviceCase));

		// % protected region % [Add any additional logic for findByServiceCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByServiceCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Accidental Sub Type.
	 *
	 * @param accidentalSubType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accidental Sub Type
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByAccidentalSubType(String accidentalSubType)
	// % protected region % [Add any throwables, implementations, or extensions for findByAccidentalSubType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAccidentalSubType here] end
	{
		// % protected region % [Add any additional logic for findByAccidentalSubType before the main body here] off begin
		// % protected region % [Add any additional logic for findByAccidentalSubType before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByAccidentalSubType(accidentalSubType));

		// % protected region % [Add any additional logic for findByAccidentalSubType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAccidentalSubType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Additional Notes.
	 *
	 * @param additionalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Additional Notes
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByAdditionalNotes(String additionalNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionalNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionalNotes here] end
	{
		// % protected region % [Add any additional logic for findByAdditionalNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdditionalNotes before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByAdditionalNotes(additionalNotes));

		// % protected region % [Add any additional logic for findByAdditionalNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdditionalNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dental Procedure.
	 *
	 * @param dentalProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dental Procedure
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByDentalProcedure(String dentalProcedure)
	// % protected region % [Add any throwables, implementations, or extensions for findByDentalProcedure here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDentalProcedure here] end
	{
		// % protected region % [Add any additional logic for findByDentalProcedure before the main body here] off begin
		// % protected region % [Add any additional logic for findByDentalProcedure before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByDentalProcedure(dentalProcedure));

		// % protected region % [Add any additional logic for findByDentalProcedure before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDentalProcedure before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Psychiatry Case.
	 *
	 * @param psychiatryCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Psychiatry Case
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPsychiatryCase(String psychiatryCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByPsychiatryCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPsychiatryCase here] end
	{
		// % protected region % [Add any additional logic for findByPsychiatryCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByPsychiatryCase before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPsychiatryCase(psychiatryCase));

		// % protected region % [Add any additional logic for findByPsychiatryCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPsychiatryCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Therapy.
	 *
	 * @param therapy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Therapy
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByTherapy(String therapy)
	// % protected region % [Add any throwables, implementations, or extensions for findByTherapy here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTherapy here] end
	{
		// % protected region % [Add any additional logic for findByTherapy before the main body here] off begin
		// % protected region % [Add any additional logic for findByTherapy before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTherapy(therapy));

		// % protected region % [Add any additional logic for findByTherapy before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTherapy before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Family Planning.
	 *
	 * @param familyPlanning the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Family Planning
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByFamilyPlanning(Boolean familyPlanning)
	// % protected region % [Add any throwables, implementations, or extensions for findByFamilyPlanning here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFamilyPlanning here] end
	{
		// % protected region % [Add any additional logic for findByFamilyPlanning before the main body here] off begin
		// % protected region % [Add any additional logic for findByFamilyPlanning before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByFamilyPlanning(familyPlanning));

		// % protected region % [Add any additional logic for findByFamilyPlanning before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFamilyPlanning before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Condition.
	 *
	 * @param condition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Condition
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByCondition(String condition)
	// % protected region % [Add any throwables, implementations, or extensions for findByCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCondition here] end
	{
		// % protected region % [Add any additional logic for findByCondition before the main body here] off begin
		// % protected region % [Add any additional logic for findByCondition before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByCondition(condition));

		// % protected region % [Add any additional logic for findByCondition before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCondition before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Family Planning Case.
	 *
	 * @param familyPlanningCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Family Planning Case
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByFamilyPlanningCase(String familyPlanningCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByFamilyPlanningCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFamilyPlanningCase here] end
	{
		// % protected region % [Add any additional logic for findByFamilyPlanningCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByFamilyPlanningCase before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByFamilyPlanningCase(familyPlanningCase));

		// % protected region % [Add any additional logic for findByFamilyPlanningCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFamilyPlanningCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Previous Contraceptive Method.
	 *
	 * @param previousContraceptiveMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Previous Contraceptive Method
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPreviousContraceptiveMethod(String previousContraceptiveMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByPreviousContraceptiveMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPreviousContraceptiveMethod here] end
	{
		// % protected region % [Add any additional logic for findByPreviousContraceptiveMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByPreviousContraceptiveMethod before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPreviousContraceptiveMethod(previousContraceptiveMethod));

		// % protected region % [Add any additional logic for findByPreviousContraceptiveMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPreviousContraceptiveMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Side Effects.
	 *
	 * @param sideEffects the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Side Effects
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findBySideEffects(String sideEffects)
	// % protected region % [Add any throwables, implementations, or extensions for findBySideEffects here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySideEffects here] end
	{
		// % protected region % [Add any additional logic for findBySideEffects before the main body here] off begin
		// % protected region % [Add any additional logic for findBySideEffects before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findBySideEffects(sideEffects));

		// % protected region % [Add any additional logic for findBySideEffects before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySideEffects before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Complication.
	 *
	 * @param complication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Complication
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByComplication(String complication)
	// % protected region % [Add any throwables, implementations, or extensions for findByComplication here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByComplication here] end
	{
		// % protected region % [Add any additional logic for findByComplication before the main body here] off begin
		// % protected region % [Add any additional logic for findByComplication before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByComplication(complication));

		// % protected region % [Add any additional logic for findByComplication before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByComplication before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Contraseptive Method.
	 *
	 * @param contraseptiveMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contraseptive Method
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByContraseptiveMethod(String contraseptiveMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByContraseptiveMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByContraseptiveMethod here] end
	{
		// % protected region % [Add any additional logic for findByContraseptiveMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByContraseptiveMethod before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByContraseptiveMethod(contraseptiveMethod));

		// % protected region % [Add any additional logic for findByContraseptiveMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByContraseptiveMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Visit Type.
	 *
	 * @param visitType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Type
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByVisitType(String visitType)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitType here] end
	{
		// % protected region % [Add any additional logic for findByVisitType before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisitType before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByVisitType(visitType));

		// % protected region % [Add any additional logic for findByVisitType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisitType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hearing Test Method.
	 *
	 * @param hearingTestMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hearing Test Method
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByHearingTestMethod(String hearingTestMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByHearingTestMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHearingTestMethod here] end
	{
		// % protected region % [Add any additional logic for findByHearingTestMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByHearingTestMethod before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHearingTestMethod(hearingTestMethod));

		// % protected region % [Add any additional logic for findByHearingTestMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHearingTestMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hearing Test Notes.
	 *
	 * @param hearingTestNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hearing Test Notes
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByHearingTestNotes(String hearingTestNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByHearingTestNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHearingTestNotes here] end
	{
		// % protected region % [Add any additional logic for findByHearingTestNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByHearingTestNotes before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHearingTestNotes(hearingTestNotes));

		// % protected region % [Add any additional logic for findByHearingTestNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHearingTestNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hearing Loss Category.
	 *
	 * @param hearingLossCategory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hearing Loss Category
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByHearingLossCategory(String hearingLossCategory)
	// % protected region % [Add any throwables, implementations, or extensions for findByHearingLossCategory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHearingLossCategory here] end
	{
		// % protected region % [Add any additional logic for findByHearingLossCategory before the main body here] off begin
		// % protected region % [Add any additional logic for findByHearingLossCategory before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHearingLossCategory(hearingLossCategory));

		// % protected region % [Add any additional logic for findByHearingLossCategory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHearingLossCategory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hearing Loss Notes.
	 *
	 * @param hearingLossNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hearing Loss Notes
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByHearingLossNotes(String hearingLossNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByHearingLossNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHearingLossNotes here] end
	{
		// % protected region % [Add any additional logic for findByHearingLossNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByHearingLossNotes before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByHearingLossNotes(hearingLossNotes));

		// % protected region % [Add any additional logic for findByHearingLossNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHearingLossNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Eye Position Right Eye.
	 *
	 * @param eyePositionRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Eye Position Right Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByEyePositionRightEye(String eyePositionRightEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByEyePositionRightEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEyePositionRightEye here] end
	{
		// % protected region % [Add any additional logic for findByEyePositionRightEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByEyePositionRightEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByEyePositionRightEye(eyePositionRightEye));

		// % protected region % [Add any additional logic for findByEyePositionRightEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEyePositionRightEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Eye Position Left Eye.
	 *
	 * @param eyePositionLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Eye Position Left Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByEyePositionLeftEye(String eyePositionLeftEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByEyePositionLeftEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEyePositionLeftEye here] end
	{
		// % protected region % [Add any additional logic for findByEyePositionLeftEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByEyePositionLeftEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByEyePositionLeftEye(eyePositionLeftEye));

		// % protected region % [Add any additional logic for findByEyePositionLeftEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEyePositionLeftEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Muscle Balance Right Eye.
	 *
	 * @param muscleBalanceRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Muscle Balance Right Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByMuscleBalanceRightEye(String muscleBalanceRightEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByMuscleBalanceRightEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMuscleBalanceRightEye here] end
	{
		// % protected region % [Add any additional logic for findByMuscleBalanceRightEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByMuscleBalanceRightEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByMuscleBalanceRightEye(muscleBalanceRightEye));

		// % protected region % [Add any additional logic for findByMuscleBalanceRightEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMuscleBalanceRightEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Muscle Balance Left Eye.
	 *
	 * @param muscleBalanceLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Muscle Balance Left Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByMuscleBalanceLeftEye(String muscleBalanceLeftEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByMuscleBalanceLeftEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMuscleBalanceLeftEye here] end
	{
		// % protected region % [Add any additional logic for findByMuscleBalanceLeftEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByMuscleBalanceLeftEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByMuscleBalanceLeftEye(muscleBalanceLeftEye));

		// % protected region % [Add any additional logic for findByMuscleBalanceLeftEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMuscleBalanceLeftEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Visual Field Right Eye.
	 *
	 * @param visualFieldRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visual Field Right Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByVisualFieldRightEye(String visualFieldRightEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisualFieldRightEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisualFieldRightEye here] end
	{
		// % protected region % [Add any additional logic for findByVisualFieldRightEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisualFieldRightEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByVisualFieldRightEye(visualFieldRightEye));

		// % protected region % [Add any additional logic for findByVisualFieldRightEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisualFieldRightEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Visual Field Left Eye.
	 *
	 * @param visualFieldLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visual Field Left Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByVisualFieldLeftEye(String visualFieldLeftEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisualFieldLeftEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisualFieldLeftEye here] end
	{
		// % protected region % [Add any additional logic for findByVisualFieldLeftEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisualFieldLeftEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByVisualFieldLeftEye(visualFieldLeftEye));

		// % protected region % [Add any additional logic for findByVisualFieldLeftEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisualFieldLeftEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Ocular Funduscopy Right Eye.
	 *
	 * @param ocularFunduscopyRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ocular Funduscopy Right Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByOcularFunduscopyRightEye(String ocularFunduscopyRightEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByOcularFunduscopyRightEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOcularFunduscopyRightEye here] end
	{
		// % protected region % [Add any additional logic for findByOcularFunduscopyRightEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByOcularFunduscopyRightEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByOcularFunduscopyRightEye(ocularFunduscopyRightEye));

		// % protected region % [Add any additional logic for findByOcularFunduscopyRightEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOcularFunduscopyRightEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Ocular Funduscopy Left Eye.
	 *
	 * @param ocularFunduscopyLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ocular Funduscopy Left Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByOcularFunduscopyLeftEye(String ocularFunduscopyLeftEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByOcularFunduscopyLeftEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOcularFunduscopyLeftEye here] end
	{
		// % protected region % [Add any additional logic for findByOcularFunduscopyLeftEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByOcularFunduscopyLeftEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByOcularFunduscopyLeftEye(ocularFunduscopyLeftEye));

		// % protected region % [Add any additional logic for findByOcularFunduscopyLeftEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOcularFunduscopyLeftEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Intraocular Pressure Right Eye.
	 *
	 * @param intraocularPressureRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intraocular Pressure Right Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByIntraocularPressureRightEye(String intraocularPressureRightEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByIntraocularPressureRightEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIntraocularPressureRightEye here] end
	{
		// % protected region % [Add any additional logic for findByIntraocularPressureRightEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByIntraocularPressureRightEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByIntraocularPressureRightEye(intraocularPressureRightEye));

		// % protected region % [Add any additional logic for findByIntraocularPressureRightEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIntraocularPressureRightEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Intraocular Pressure Left Eye.
	 *
	 * @param intraocularPressureLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intraocular Pressure Left Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByIntraocularPressureLeftEye(String intraocularPressureLeftEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByIntraocularPressureLeftEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIntraocularPressureLeftEye here] end
	{
		// % protected region % [Add any additional logic for findByIntraocularPressureLeftEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByIntraocularPressureLeftEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByIntraocularPressureLeftEye(intraocularPressureLeftEye));

		// % protected region % [Add any additional logic for findByIntraocularPressureLeftEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIntraocularPressureLeftEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Color Blindness.
	 *
	 * @param colorBlindness the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Color Blindness
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByColorBlindness(String colorBlindness)
	// % protected region % [Add any throwables, implementations, or extensions for findByColorBlindness here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByColorBlindness here] end
	{
		// % protected region % [Add any additional logic for findByColorBlindness before the main body here] off begin
		// % protected region % [Add any additional logic for findByColorBlindness before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByColorBlindness(colorBlindness));

		// % protected region % [Add any additional logic for findByColorBlindness before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByColorBlindness before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Visual Acuity Right Eye.
	 *
	 * @param visualAcuityRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visual Acuity Right Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByVisualAcuityRightEye(String visualAcuityRightEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisualAcuityRightEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisualAcuityRightEye here] end
	{
		// % protected region % [Add any additional logic for findByVisualAcuityRightEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisualAcuityRightEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByVisualAcuityRightEye(visualAcuityRightEye));

		// % protected region % [Add any additional logic for findByVisualAcuityRightEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisualAcuityRightEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Visual Acuity Left Eye.
	 *
	 * @param visualAcuityLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visual Acuity Left Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByVisualAcuityLeftEye(String visualAcuityLeftEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisualAcuityLeftEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisualAcuityLeftEye here] end
	{
		// % protected region % [Add any additional logic for findByVisualAcuityLeftEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisualAcuityLeftEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByVisualAcuityLeftEye(visualAcuityLeftEye));

		// % protected region % [Add any additional logic for findByVisualAcuityLeftEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisualAcuityLeftEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Correction Right Eye.
	 *
	 * @param correctionRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Correction Right Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByCorrectionRightEye(String correctionRightEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByCorrectionRightEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCorrectionRightEye here] end
	{
		// % protected region % [Add any additional logic for findByCorrectionRightEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByCorrectionRightEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByCorrectionRightEye(correctionRightEye));

		// % protected region % [Add any additional logic for findByCorrectionRightEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCorrectionRightEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Correction Left Eye.
	 *
	 * @param correctionLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Correction Left Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByCorrectionLeftEye(String correctionLeftEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByCorrectionLeftEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCorrectionLeftEye here] end
	{
		// % protected region % [Add any additional logic for findByCorrectionLeftEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByCorrectionLeftEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByCorrectionLeftEye(correctionLeftEye));

		// % protected region % [Add any additional logic for findByCorrectionLeftEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCorrectionLeftEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Addition Right Eye.
	 *
	 * @param additionRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Addition Right Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByAdditionRightEye(String additionRightEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionRightEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionRightEye here] end
	{
		// % protected region % [Add any additional logic for findByAdditionRightEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdditionRightEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByAdditionRightEye(additionRightEye));

		// % protected region % [Add any additional logic for findByAdditionRightEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdditionRightEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Addition Left Eye.
	 *
	 * @param additionLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Addition Left Eye
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByAdditionLeftEye(String additionLeftEye)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionLeftEye here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionLeftEye here] end
	{
		// % protected region % [Add any additional logic for findByAdditionLeftEye before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdditionLeftEye before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByAdditionLeftEye(additionLeftEye));

		// % protected region % [Add any additional logic for findByAdditionLeftEye before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdditionLeftEye before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Occlusion.
	 *
	 * @param occlusion the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Occlusion
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByOcclusion(String occlusion)
	// % protected region % [Add any throwables, implementations, or extensions for findByOcclusion here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOcclusion here] end
	{
		// % protected region % [Add any additional logic for findByOcclusion before the main body here] off begin
		// % protected region % [Add any additional logic for findByOcclusion before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByOcclusion(occlusion));

		// % protected region % [Add any additional logic for findByOcclusion before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOcclusion before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Torus Palatinus.
	 *
	 * @param torusPalatinus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Torus Palatinus
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByTorusPalatinus(String torusPalatinus)
	// % protected region % [Add any throwables, implementations, or extensions for findByTorusPalatinus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTorusPalatinus here] end
	{
		// % protected region % [Add any additional logic for findByTorusPalatinus before the main body here] off begin
		// % protected region % [Add any additional logic for findByTorusPalatinus before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTorusPalatinus(torusPalatinus));

		// % protected region % [Add any additional logic for findByTorusPalatinus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTorusPalatinus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Torus Mandibularis.
	 *
	 * @param torusMandibularis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Torus Mandibularis
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByTorusMandibularis(String torusMandibularis)
	// % protected region % [Add any throwables, implementations, or extensions for findByTorusMandibularis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTorusMandibularis here] end
	{
		// % protected region % [Add any additional logic for findByTorusMandibularis before the main body here] off begin
		// % protected region % [Add any additional logic for findByTorusMandibularis before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTorusMandibularis(torusMandibularis));

		// % protected region % [Add any additional logic for findByTorusMandibularis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTorusMandibularis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Palatum.
	 *
	 * @param palatum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Palatum
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPalatum(String palatum)
	// % protected region % [Add any throwables, implementations, or extensions for findByPalatum here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPalatum here] end
	{
		// % protected region % [Add any additional logic for findByPalatum before the main body here] off begin
		// % protected region % [Add any additional logic for findByPalatum before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPalatum(palatum));

		// % protected region % [Add any additional logic for findByPalatum before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPalatum before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diastema.
	 *
	 * @param diastema the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastema
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByDiastema(Boolean diastema)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastema here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastema here] end
	{
		// % protected region % [Add any additional logic for findByDiastema before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastema before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByDiastema(diastema));

		// % protected region % [Add any additional logic for findByDiastema before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiastema before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diastema Notes.
	 *
	 * @param diastemaNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastema Notes
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByDiastemaNotes(String diastemaNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastemaNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastemaNotes here] end
	{
		// % protected region % [Add any additional logic for findByDiastemaNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastemaNotes before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByDiastemaNotes(diastemaNotes));

		// % protected region % [Add any additional logic for findByDiastemaNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiastemaNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tooth Anomaly.
	 *
	 * @param toothAnomaly the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tooth Anomaly
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByToothAnomaly(Boolean toothAnomaly)
	// % protected region % [Add any throwables, implementations, or extensions for findByToothAnomaly here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByToothAnomaly here] end
	{
		// % protected region % [Add any additional logic for findByToothAnomaly before the main body here] off begin
		// % protected region % [Add any additional logic for findByToothAnomaly before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByToothAnomaly(toothAnomaly));

		// % protected region % [Add any additional logic for findByToothAnomaly before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByToothAnomaly before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tooth Anomaly Notes.
	 *
	 * @param toothAnomalyNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tooth Anomaly Notes
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByToothAnomalyNotes(String toothAnomalyNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByToothAnomalyNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByToothAnomalyNotes here] end
	{
		// % protected region % [Add any additional logic for findByToothAnomalyNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByToothAnomalyNotes before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByToothAnomalyNotes(toothAnomalyNotes));

		// % protected region % [Add any additional logic for findByToothAnomalyNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByToothAnomalyNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Dental Notes.
	 *
	 * @param otherDentalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Dental Notes
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByOtherDentalNotes(String otherDentalNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherDentalNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherDentalNotes here] end
	{
		// % protected region % [Add any additional logic for findByOtherDentalNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherDentalNotes before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByOtherDentalNotes(otherDentalNotes));

		// % protected region % [Add any additional logic for findByOtherDentalNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherDentalNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Decayed.
	 *
	 * @param decayed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Decayed
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByDecayed(String decayed)
	// % protected region % [Add any throwables, implementations, or extensions for findByDecayed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDecayed here] end
	{
		// % protected region % [Add any additional logic for findByDecayed before the main body here] off begin
		// % protected region % [Add any additional logic for findByDecayed before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByDecayed(decayed));

		// % protected region % [Add any additional logic for findByDecayed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDecayed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Missing.
	 *
	 * @param missing the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Missing
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByMissing(String missing)
	// % protected region % [Add any throwables, implementations, or extensions for findByMissing here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMissing here] end
	{
		// % protected region % [Add any additional logic for findByMissing before the main body here] off begin
		// % protected region % [Add any additional logic for findByMissing before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByMissing(missing));

		// % protected region % [Add any additional logic for findByMissing before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMissing before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Filled.
	 *
	 * @param filled the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Filled
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByFilled(String filled)
	// % protected region % [Add any throwables, implementations, or extensions for findByFilled here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFilled here] end
	{
		// % protected region % [Add any additional logic for findByFilled before the main body here] off begin
		// % protected region % [Add any additional logic for findByFilled before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByFilled(filled));

		// % protected region % [Add any additional logic for findByFilled before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFilled before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Photograph.
	 *
	 * @param totalPhotograph the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Photograph
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByTotalPhotograph(String totalPhotograph)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalPhotograph here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalPhotograph here] end
	{
		// % protected region % [Add any additional logic for findByTotalPhotograph before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalPhotograph before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTotalPhotograph(totalPhotograph));

		// % protected region % [Add any additional logic for findByTotalPhotograph before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalPhotograph before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Photograph Type.
	 *
	 * @param photographType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Photograph Type
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByPhotographType(String photographType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhotographType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhotographType here] end
	{
		// % protected region % [Add any additional logic for findByPhotographType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhotographType before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPhotographType(photographType));

		// % protected region % [Add any additional logic for findByPhotographType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhotographType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Rontgen Photograph.
	 *
	 * @param totalRontgenPhotograph the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Rontgen Photograph
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByTotalRontgenPhotograph(String totalRontgenPhotograph)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalRontgenPhotograph here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalRontgenPhotograph here] end
	{
		// % protected region % [Add any additional logic for findByTotalRontgenPhotograph before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalRontgenPhotograph before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTotalRontgenPhotograph(totalRontgenPhotograph));

		// % protected region % [Add any additional logic for findByTotalRontgenPhotograph before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalRontgenPhotograph before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Rontgen Photograph Type.
	 *
	 * @param rontgenPhotographType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rontgen Photograph Type
	 */
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findByRontgenPhotographType(String rontgenPhotographType)
	// % protected region % [Add any throwables, implementations, or extensions for findByRontgenPhotographType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRontgenPhotographType here] end
	{
		// % protected region % [Add any additional logic for findByRontgenPhotographType before the main body here] off begin
		// % protected region % [Add any additional logic for findByRontgenPhotographType before the main body here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByRontgenPhotographType(rontgenPhotographType));

		// % protected region % [Add any additional logic for findByRontgenPhotographType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRontgenPhotographType before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<MedicalExaminationRecordEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<MedicalExaminationRecordEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<MedicalExaminationRecordEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'create')")
	public MedicalExaminationRecordEntity create(MedicalExaminationRecordEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		MedicalExaminationRecordEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'create')")
	public MedicalExaminationRecordEntity create(MedicalExaminationRecordEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		MedicalExaminationRecordEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		MedicalExaminationRecordEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'create')")
	public List<MedicalExaminationRecordEntity> createAll(Iterable<MedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<MedicalExaminationRecordEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<MedicalExaminationRecordEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'update')")
	public MedicalExaminationRecordEntity update(MedicalExaminationRecordEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		MedicalExaminationRecordEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'update')")
	public MedicalExaminationRecordEntity update(MedicalExaminationRecordEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		MedicalExaminationRecordEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		MedicalExaminationRecordEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'update')")
	public List<MedicalExaminationRecordEntity> updateAll(Iterable<MedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<MedicalExaminationRecordEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<MedicalExaminationRecordEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'create') or hasPermission('MedicalExaminationRecordEntity', 'update')")
	public MedicalExaminationRecordEntity save(MedicalExaminationRecordEntity entity) throws ConstraintViolationException
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

		MedicalExaminationRecordEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'create') or hasPermission('MedicalExaminationRecordEntity', 'update')")
	public List<MedicalExaminationRecordEntity> saveAll(Iterable<MedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<MedicalExaminationRecordEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	public List<MedicalExaminationRecordEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	public List<MedicalExaminationRecordEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(MedicalExaminationRecordEntity.class);

		// % protected region % [Add any additional processing before converting to a list of MedicalExaminationRecordEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicalExaminationRecordEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicalExaminationRecordEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of MedicalExaminationRecordEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicalExaminationRecordEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(MedicalExaminationRecordEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of MedicalExaminationRecordEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of MedicalExaminationRecordEntityAudits
	 */
	private List<MedicalExaminationRecordEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<MedicalExaminationRecordEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param medicalExaminationRecord medicalExaminationRecord to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private MedicalExaminationRecordEntity updateAuditData(MedicalExaminationRecordEntity medicalExaminationRecord)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return medicalExaminationRecord;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private MedicalExaminationRecordEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		MedicalExaminationRecordEntity entityAtRevision = updateAuditData((MedicalExaminationRecordEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new MedicalExaminationRecordEntityAudit(
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

		QMedicalExaminationRecordEntity entity = QMedicalExaminationRecordEntity.medicalExaminationRecordEntity;

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
			case "birthHistoryId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Birth History here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Birth History here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.birthHistory.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Birth History here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Birth History here] end

				break;
			case "bodyChartExaminationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Body Chart Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Body Chart Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bodyChartExamination.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Body Chart Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Body Chart Examination here] end

				break;
			case "deliveryMedicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Delivery Medical Examination Record here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Delivery Medical Examination Record here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryMedicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Delivery Medical Examination Record here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Delivery Medical Examination Record here] end

				break;
			case "entExaminationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to ENT Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to ENT Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.entExamination.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to ENT Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to ENT Examination here] end

				break;
			case "emergencyMedicationExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Emergency Medication Examination Record here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Emergency Medication Examination Record here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.emergencyMedicationExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Emergency Medication Examination Record here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Emergency Medication Examination Record here] end

				break;
			case "formulirKonselingTesHivId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Formulir Konseling Tes Hiv here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Formulir Konseling Tes Hiv here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.formulirKonselingTesHiv.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Formulir Konseling Tes Hiv here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Formulir Konseling Tes Hiv here] end

				break;
			case "hemodialysisExaminationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Hemodialysis Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Hemodialysis Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hemodialysisExamination.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Hemodialysis Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Hemodialysis Examination here] end

				break;
			case "medicalExaminationRecordDischargeSummaryId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Medical Examination Record Discharge Summary here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Medical Examination Record Discharge Summary here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecordDischargeSummary.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Medical Examination Record Discharge Summary here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Medical Examination Record Discharge Summary here] end

				break;
			case "medicalRecordInitialChecklistId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Medical Record Initial Checklist here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Medical Record Initial Checklist here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalRecordInitialChecklist.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Medical Record Initial Checklist here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Medical Record Initial Checklist here] end

				break;
			case "medicalRecordNextVerificationChecklistId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Medical Record Next Verification Checklist here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Medical Record Next Verification Checklist here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalRecordNextVerificationChecklist.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Medical Record Next Verification Checklist here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Medical Record Next Verification Checklist here] end

				break;
			case "nurseVitalSignMeasurementId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Nurse Vital Sign Measurement here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Nurse Vital Sign Measurement here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nurseVitalSignMeasurement.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Nurse Vital Sign Measurement here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Nurse Vital Sign Measurement here] end

				break;
			case "obstetricAndGynecologyHistoryId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Obstetric And Gynecology History here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Obstetric And Gynecology History here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.obstetricAndGynecologyHistory.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Obstetric And Gynecology History here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Obstetric And Gynecology History here] end

				break;
			case "odontogramExaminationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Odontogram Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Odontogram Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.odontogramExamination.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Odontogram Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Odontogram Examination here] end

				break;
			case "operatingTheaterMedicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Operating Theater Medical Examination Record here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Operating Theater Medical Examination Record here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.operatingTheaterMedicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Operating Theater Medical Examination Record here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Operating Theater Medical Examination Record here] end

				break;
			case "ophthalmologyExaminationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Ophthalmology Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Ophthalmology Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.ophthalmologyExamination.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Ophthalmology Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Ophthalmology Examination here] end

				break;
			case "inpatientMedicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Inpatient Medical Examination Record to Medical Examination Record here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Inpatient Medical Examination Record to Medical Examination Record here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inpatientMedicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Inpatient Medical Examination Record to Medical Examination Record here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Inpatient Medical Examination Record to Medical Examination Record here] end

				break;
			case "registrationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Examination Record here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Examination Record here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registration.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Examination Record here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Examination Record here] end

				break;
			case "doctorId":
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor to Doctor on examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor to Doctor on examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctor.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Doctor to Doctor on examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Doctor to Doctor on examination here] end

				break;
			case "medicalTranscriberId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber to Medical Record Transcriber here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber to Medical Record Transcriber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalTranscriber.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber to Medical Record Transcriber here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber to Medical Record Transcriber here] end

				break;
			case "nurseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Nurse to Nurse here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Nurse to Nurse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nurse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Nurse to Nurse here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Nurse to Nurse here] end

				break;
			case "amendmentDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Amendment Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Amendment Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.amendmentDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Amendment Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Amendment Details here] end

				break;
			case "coTreatingDoctorsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Co Treating Doctors here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Co Treating Doctors here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.coTreatingDoctors.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Co Treating Doctors here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Co Treating Doctors here] end

				break;
			case "dailyCareCPPTsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Daily Care CPPTs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Daily Care CPPTs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dailyCareCPPTs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Daily Care CPPTs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Daily Care CPPTs here] end

				break;
			case "diagnosisExaminationRecordsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Diagnosis Examination Records here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Diagnosis Examination Records here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnosisExaminationRecords.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Diagnosis Examination Records here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Diagnosis Examination Records here] end

				break;
			case "diagnosisNandasId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Diagnosis Nandas here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Diagnosis Nandas here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnosisNandas.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Diagnosis Nandas here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Diagnosis Nandas here] end

				break;
			case "roomTransfersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Room Transfers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Room Transfers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.roomTransfers.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Room Transfers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Room Transfers here] end

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
	public MedicalExaminationRecordEntity updateOldData(MedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public MedicalExaminationRecordEntity updateOldData(MedicalExaminationRecordEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		MedicalExaminationRecordEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInMedicalExaminationRecordEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getFamilyPlanning() == null) {
			entityToUpdate.setFamilyPlanning(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDiastema() == null) {
			entityToUpdate.setDiastema(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getToothAnomaly() == null) {
			entityToUpdate.setToothAnomaly(false);
		}

		// Incoming One to One reference
		if (entity.getInpatientMedicalExaminationRecord() == null && entity.getInpatientMedicalExaminationRecordId() == null) {
			entityToUpdate.unsetInpatientMedicalExaminationRecord();
		} else if (entity.getInpatientMedicalExaminationRecordId() != null && entity.getInpatientMedicalExaminationRecord() == null) {
			Optional<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecordEntity = this.inpatientMedicalExaminationRecordRepository.findById(entity.getInpatientMedicalExaminationRecordId());
			entityToUpdate.setInpatientMedicalExaminationRecord(inpatientMedicalExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getInpatientMedicalExaminationRecord() != null) {
			entityToUpdate.setInpatientMedicalExaminationRecord(entity.getInpatientMedicalExaminationRecord(), false);
			if (entityToUpdate.getInpatientMedicalExaminationRecordId() != null) {
				this.inpatientMedicalExaminationRecordRepository.save(entityToUpdate.getInpatientMedicalExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getInpatientMedicalExaminationRecord().unsetMedicalExaminationRecord();
			}
		}

		// Incoming One to One reference
		if (entity.getRegistration() == null && entity.getRegistrationId() == null) {
			entityToUpdate.unsetRegistration();
		} else if (entity.getRegistrationId() != null && entity.getRegistration() == null) {
			Optional<RegistrationEntity> registrationEntity = this.registrationRepository.findById(entity.getRegistrationId());
			entityToUpdate.setRegistration(registrationEntity.orElseThrow());
		}
		if (persistRelations && entity.getRegistration() != null) {
			entityToUpdate.setRegistration(entity.getRegistration(), false);
			if (entityToUpdate.getRegistrationId() != null) {
				this.registrationRepository.save(entityToUpdate.getRegistration());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRegistration().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getBirthHistory() == null && entity.getBirthHistoryId() == null) {
			entityToUpdate.unsetBirthHistory();
		} else if (entity.getBirthHistoryId() != null && entity.getBirthHistory() == null) {
			Optional<BirthHistoryEntity> birthHistoryEntity = this.birthHistoryRepository.findById(entity.getBirthHistoryId());
			entityToUpdate.setBirthHistory(birthHistoryEntity.orElseThrow());
		}
		if (persistRelations && entity.getBirthHistory() != null) {
			entityToUpdate.setBirthHistory(entity.getBirthHistory(), false);
			if (entityToUpdate.getBirthHistoryId() != null) {
				this.birthHistoryRepository.save(entityToUpdate.getBirthHistory());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBirthHistory().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getBodyChartExamination() == null && entity.getBodyChartExaminationId() == null) {
			entityToUpdate.unsetBodyChartExamination();
		} else if (entity.getBodyChartExaminationId() != null && entity.getBodyChartExamination() == null) {
			Optional<BodyChartExaminationEntity> bodyChartExaminationEntity = this.bodyChartExaminationRepository.findById(entity.getBodyChartExaminationId());
			entityToUpdate.setBodyChartExamination(bodyChartExaminationEntity.orElseThrow());
		}
		if (persistRelations && entity.getBodyChartExamination() != null) {
			entityToUpdate.setBodyChartExamination(entity.getBodyChartExamination(), false);
			if (entityToUpdate.getBodyChartExaminationId() != null) {
				this.bodyChartExaminationRepository.save(entityToUpdate.getBodyChartExamination());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBodyChartExamination().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getDeliveryMedicalExaminationRecord() == null && entity.getDeliveryMedicalExaminationRecordId() == null) {
			entityToUpdate.unsetDeliveryMedicalExaminationRecord();
		} else if (entity.getDeliveryMedicalExaminationRecordId() != null && entity.getDeliveryMedicalExaminationRecord() == null) {
			Optional<DeliveryMedicalExaminationRecordEntity> deliveryMedicalExaminationRecordEntity = this.deliveryMedicalExaminationRecordRepository.findById(entity.getDeliveryMedicalExaminationRecordId());
			entityToUpdate.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getDeliveryMedicalExaminationRecord() != null) {
			entityToUpdate.setDeliveryMedicalExaminationRecord(entity.getDeliveryMedicalExaminationRecord(), false);
			if (entityToUpdate.getDeliveryMedicalExaminationRecordId() != null) {
				this.deliveryMedicalExaminationRecordRepository.save(entityToUpdate.getDeliveryMedicalExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDeliveryMedicalExaminationRecord().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getEntExamination() == null && entity.getEntExaminationId() == null) {
			entityToUpdate.unsetEntExamination();
		} else if (entity.getEntExaminationId() != null && entity.getEntExamination() == null) {
			Optional<EntExaminationEntity> entExaminationEntity = this.entExaminationRepository.findById(entity.getEntExaminationId());
			entityToUpdate.setEntExamination(entExaminationEntity.orElseThrow());
		}
		if (persistRelations && entity.getEntExamination() != null) {
			entityToUpdate.setEntExamination(entity.getEntExamination(), false);
			if (entityToUpdate.getEntExaminationId() != null) {
				this.entExaminationRepository.save(entityToUpdate.getEntExamination());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getEntExamination().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getEmergencyMedicationExaminationRecord() == null && entity.getEmergencyMedicationExaminationRecordId() == null) {
			entityToUpdate.unsetEmergencyMedicationExaminationRecord();
		} else if (entity.getEmergencyMedicationExaminationRecordId() != null && entity.getEmergencyMedicationExaminationRecord() == null) {
			Optional<EmergencyMedicalExaminationRecordEntity> emergencyMedicationExaminationRecordEntity = this.emergencyMedicalExaminationRecordRepository.findById(entity.getEmergencyMedicationExaminationRecordId());
			entityToUpdate.setEmergencyMedicationExaminationRecord(emergencyMedicationExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getEmergencyMedicationExaminationRecord() != null) {
			entityToUpdate.setEmergencyMedicationExaminationRecord(entity.getEmergencyMedicationExaminationRecord(), false);
			if (entityToUpdate.getEmergencyMedicationExaminationRecordId() != null) {
				this.emergencyMedicalExaminationRecordRepository.save(entityToUpdate.getEmergencyMedicationExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getEmergencyMedicationExaminationRecord().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getFormulirKonselingTesHiv() == null && entity.getFormulirKonselingTesHivId() == null) {
			entityToUpdate.unsetFormulirKonselingTesHiv();
		} else if (entity.getFormulirKonselingTesHivId() != null && entity.getFormulirKonselingTesHiv() == null) {
			Optional<FormulirKonselingTesHivEntity> formulirKonselingTesHivEntity = this.formulirKonselingTesHivRepository.findById(entity.getFormulirKonselingTesHivId());
			entityToUpdate.setFormulirKonselingTesHiv(formulirKonselingTesHivEntity.orElseThrow());
		}
		if (persistRelations && entity.getFormulirKonselingTesHiv() != null) {
			entityToUpdate.setFormulirKonselingTesHiv(entity.getFormulirKonselingTesHiv(), false);
			if (entityToUpdate.getFormulirKonselingTesHivId() != null) {
				this.formulirKonselingTesHivRepository.save(entityToUpdate.getFormulirKonselingTesHiv());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getFormulirKonselingTesHiv().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getHemodialysisExamination() == null && entity.getHemodialysisExaminationId() == null) {
			entityToUpdate.unsetHemodialysisExamination();
		} else if (entity.getHemodialysisExaminationId() != null && entity.getHemodialysisExamination() == null) {
			Optional<HemodialysisExaminationEntity> hemodialysisExaminationEntity = this.hemodialysisExaminationRepository.findById(entity.getHemodialysisExaminationId());
			entityToUpdate.setHemodialysisExamination(hemodialysisExaminationEntity.orElseThrow());
		}
		if (persistRelations && entity.getHemodialysisExamination() != null) {
			entityToUpdate.setHemodialysisExamination(entity.getHemodialysisExamination(), false);
			if (entityToUpdate.getHemodialysisExaminationId() != null) {
				this.hemodialysisExaminationRepository.save(entityToUpdate.getHemodialysisExamination());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getHemodialysisExamination().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalExaminationRecordDischargeSummary() == null && entity.getMedicalExaminationRecordDischargeSummaryId() == null) {
			entityToUpdate.unsetMedicalExaminationRecordDischargeSummary();
		} else if (entity.getMedicalExaminationRecordDischargeSummaryId() != null && entity.getMedicalExaminationRecordDischargeSummary() == null) {
			Optional<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummaryEntity = this.medicalExaminationRecordDischargeSummaryRepository.findById(entity.getMedicalExaminationRecordDischargeSummaryId());
			entityToUpdate.setMedicalExaminationRecordDischargeSummary(medicalExaminationRecordDischargeSummaryEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalExaminationRecordDischargeSummary() != null) {
			entityToUpdate.setMedicalExaminationRecordDischargeSummary(entity.getMedicalExaminationRecordDischargeSummary(), false);
			if (entityToUpdate.getMedicalExaminationRecordDischargeSummaryId() != null) {
				this.medicalExaminationRecordDischargeSummaryRepository.save(entityToUpdate.getMedicalExaminationRecordDischargeSummary());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalExaminationRecordDischargeSummary().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalRecordInitialChecklist() == null && entity.getMedicalRecordInitialChecklistId() == null) {
			entityToUpdate.unsetMedicalRecordInitialChecklist();
		} else if (entity.getMedicalRecordInitialChecklistId() != null && entity.getMedicalRecordInitialChecklist() == null) {
			Optional<MedicalRecordInitialChecklistEntity> medicalRecordInitialChecklistEntity = this.medicalRecordInitialChecklistRepository.findById(entity.getMedicalRecordInitialChecklistId());
			entityToUpdate.setMedicalRecordInitialChecklist(medicalRecordInitialChecklistEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalRecordInitialChecklist() != null) {
			entityToUpdate.setMedicalRecordInitialChecklist(entity.getMedicalRecordInitialChecklist(), false);
			if (entityToUpdate.getMedicalRecordInitialChecklistId() != null) {
				this.medicalRecordInitialChecklistRepository.save(entityToUpdate.getMedicalRecordInitialChecklist());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalRecordInitialChecklist().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalRecordNextVerificationChecklist() == null && entity.getMedicalRecordNextVerificationChecklistId() == null) {
			entityToUpdate.unsetMedicalRecordNextVerificationChecklist();
		} else if (entity.getMedicalRecordNextVerificationChecklistId() != null && entity.getMedicalRecordNextVerificationChecklist() == null) {
			Optional<MedicalRecordNextVerificationChecklistEntity> medicalRecordNextVerificationChecklistEntity = this.medicalRecordNextVerificationChecklistRepository.findById(entity.getMedicalRecordNextVerificationChecklistId());
			entityToUpdate.setMedicalRecordNextVerificationChecklist(medicalRecordNextVerificationChecklistEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalRecordNextVerificationChecklist() != null) {
			entityToUpdate.setMedicalRecordNextVerificationChecklist(entity.getMedicalRecordNextVerificationChecklist(), false);
			if (entityToUpdate.getMedicalRecordNextVerificationChecklistId() != null) {
				this.medicalRecordNextVerificationChecklistRepository.save(entityToUpdate.getMedicalRecordNextVerificationChecklist());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalRecordNextVerificationChecklist().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getNurseVitalSignMeasurement() == null && entity.getNurseVitalSignMeasurementId() == null) {
			entityToUpdate.unsetNurseVitalSignMeasurement();
		} else if (entity.getNurseVitalSignMeasurementId() != null && entity.getNurseVitalSignMeasurement() == null) {
			Optional<NurseVitalSignMeasurementEntity> nurseVitalSignMeasurementEntity = this.nurseVitalSignMeasurementRepository.findById(entity.getNurseVitalSignMeasurementId());
			entityToUpdate.setNurseVitalSignMeasurement(nurseVitalSignMeasurementEntity.orElseThrow());
		}
		if (persistRelations && entity.getNurseVitalSignMeasurement() != null) {
			entityToUpdate.setNurseVitalSignMeasurement(entity.getNurseVitalSignMeasurement(), false);
			if (entityToUpdate.getNurseVitalSignMeasurementId() != null) {
				this.nurseVitalSignMeasurementRepository.save(entityToUpdate.getNurseVitalSignMeasurement());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getNurseVitalSignMeasurement().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getObstetricAndGynecologyHistory() == null && entity.getObstetricAndGynecologyHistoryId() == null) {
			entityToUpdate.unsetObstetricAndGynecologyHistory();
		} else if (entity.getObstetricAndGynecologyHistoryId() != null && entity.getObstetricAndGynecologyHistory() == null) {
			Optional<ObstetricAndGynecologyHistoryEntity> obstetricAndGynecologyHistoryEntity = this.obstetricAndGynecologyHistoryRepository.findById(entity.getObstetricAndGynecologyHistoryId());
			entityToUpdate.setObstetricAndGynecologyHistory(obstetricAndGynecologyHistoryEntity.orElseThrow());
		}
		if (persistRelations && entity.getObstetricAndGynecologyHistory() != null) {
			entityToUpdate.setObstetricAndGynecologyHistory(entity.getObstetricAndGynecologyHistory(), false);
			if (entityToUpdate.getObstetricAndGynecologyHistoryId() != null) {
				this.obstetricAndGynecologyHistoryRepository.save(entityToUpdate.getObstetricAndGynecologyHistory());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getObstetricAndGynecologyHistory().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getOdontogramExamination() == null && entity.getOdontogramExaminationId() == null) {
			entityToUpdate.unsetOdontogramExamination();
		} else if (entity.getOdontogramExaminationId() != null && entity.getOdontogramExamination() == null) {
			Optional<OdontogramExaminationEntity> odontogramExaminationEntity = this.odontogramExaminationRepository.findById(entity.getOdontogramExaminationId());
			entityToUpdate.setOdontogramExamination(odontogramExaminationEntity.orElseThrow());
		}
		if (persistRelations && entity.getOdontogramExamination() != null) {
			entityToUpdate.setOdontogramExamination(entity.getOdontogramExamination(), false);
			if (entityToUpdate.getOdontogramExaminationId() != null) {
				this.odontogramExaminationRepository.save(entityToUpdate.getOdontogramExamination());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getOdontogramExamination().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
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
				entityToUpdate.getOperatingTheaterMedicalExaminationRecord().unsetMedicalExaminationRecord();
			}
		}

		// Outgoing one to one reference
		if (entity.getOphthalmologyExamination() == null && entity.getOphthalmologyExaminationId() == null) {
			entityToUpdate.unsetOphthalmologyExamination();
		} else if (entity.getOphthalmologyExaminationId() != null && entity.getOphthalmologyExamination() == null) {
			Optional<OphthalmologyExaminationEntity> ophthalmologyExaminationEntity = this.ophthalmologyExaminationRepository.findById(entity.getOphthalmologyExaminationId());
			entityToUpdate.setOphthalmologyExamination(ophthalmologyExaminationEntity.orElseThrow());
		}
		if (persistRelations && entity.getOphthalmologyExamination() != null) {
			entityToUpdate.setOphthalmologyExamination(entity.getOphthalmologyExamination(), false);
			if (entityToUpdate.getOphthalmologyExaminationId() != null) {
				this.ophthalmologyExaminationRepository.save(entityToUpdate.getOphthalmologyExamination());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getOphthalmologyExamination().unsetMedicalExaminationRecord();
			}
		}

		// Incoming One to Many reference
		if (entity.getDoctor() == null && entity.getDoctorId() == null) {
			entityToUpdate.unsetDoctor();
		} else if (entity.getDoctorId() != null && entity.getDoctor() == null) {
			Optional<StaffEntity> doctorEntity = this.staffRepository.findById(entity.getDoctorId());
			entityToUpdate.setDoctor(doctorEntity.orElseThrow());
		}
		if (persistRelations && entity.getDoctor() != null) {
			entityToUpdate.setDoctor(entity.getDoctor(), false);
			if (entityToUpdate.getDoctorId() != null) {
				this.staffRepository.save(entityToUpdate.getDoctor());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDoctor().unsetDoctorOnExamination();
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
				entityToUpdate.getMedicalTranscriber().unsetMedicalRecordTranscriber();
			}
		}

		// Incoming One to Many reference
		if (entity.getNurse() == null && entity.getNurseId() == null) {
			entityToUpdate.unsetNurse();
		} else if (entity.getNurseId() != null && entity.getNurse() == null) {
			Optional<StaffEntity> nurseEntity = this.staffRepository.findById(entity.getNurseId());
			entityToUpdate.setNurse(nurseEntity.orElseThrow());
		}
		if (persistRelations && entity.getNurse() != null) {
			entityToUpdate.setNurse(entity.getNurse(), false);
			if (entityToUpdate.getNurseId() != null) {
				this.staffRepository.save(entityToUpdate.getNurse());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getNurse().unsetNurse();
			}
		}

		// Outgoing one to many reference
		if (entity.getAmendmentDetailsIds().isEmpty() && entity.getAmendmentDetails().isEmpty()) {
			entityToUpdate.setAmendmentDetails(new HashSet<>());
		} else if (!entity.getAmendmentDetailsIds().isEmpty() && entity.getAmendmentDetails().isEmpty()) {
			Iterable<AmendmentDetailEntity> amendmentDetailsEntities =
					this.amendmentDetailRepository.findAllById(entity.getAmendmentDetailsIds());
			entityToUpdate.setAmendmentDetails(Sets.newHashSet(amendmentDetailsEntities));
		}
		if (persistRelations && !entity.getAmendmentDetails().isEmpty()) {
			Set<AmendmentDetailEntity> updatedEntities = new HashSet<>();
			entity.getAmendmentDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.amendmentDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAmendmentDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getCoTreatingDoctorsIds().isEmpty() && entity.getCoTreatingDoctors().isEmpty()) {
			entityToUpdate.setCoTreatingDoctors(new HashSet<>());
		} else if (!entity.getCoTreatingDoctorsIds().isEmpty() && entity.getCoTreatingDoctors().isEmpty()) {
			Iterable<CoTreatingDoctorEntity> coTreatingDoctorsEntities =
					this.coTreatingDoctorRepository.findAllById(entity.getCoTreatingDoctorsIds());
			entityToUpdate.setCoTreatingDoctors(Sets.newHashSet(coTreatingDoctorsEntities));
		}
		if (persistRelations && !entity.getCoTreatingDoctors().isEmpty()) {
			Set<CoTreatingDoctorEntity> updatedEntities = new HashSet<>();
			entity.getCoTreatingDoctors().forEach(model -> {
				if (model.getId() != null) {
					model = this.coTreatingDoctorRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCoTreatingDoctors(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDailyCareCPPTsIds().isEmpty() && entity.getDailyCareCPPTs().isEmpty()) {
			entityToUpdate.setDailyCareCPPTs(new HashSet<>());
		} else if (!entity.getDailyCareCPPTsIds().isEmpty() && entity.getDailyCareCPPTs().isEmpty()) {
			Iterable<DailyCareCPPTEntity> dailyCareCPPTsEntities =
					this.dailyCareCPPTRepository.findAllById(entity.getDailyCareCPPTsIds());
			entityToUpdate.setDailyCareCPPTs(Sets.newHashSet(dailyCareCPPTsEntities));
		}
		if (persistRelations && !entity.getDailyCareCPPTs().isEmpty()) {
			Set<DailyCareCPPTEntity> updatedEntities = new HashSet<>();
			entity.getDailyCareCPPTs().forEach(model -> {
				if (model.getId() != null) {
					model = this.dailyCareCPPTRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDailyCareCPPTs(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDiagnosisExaminationRecordsIds().isEmpty() && entity.getDiagnosisExaminationRecords().isEmpty()) {
			entityToUpdate.setDiagnosisExaminationRecords(new HashSet<>());
		} else if (!entity.getDiagnosisExaminationRecordsIds().isEmpty() && entity.getDiagnosisExaminationRecords().isEmpty()) {
			Iterable<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordsEntities =
					this.diagnosisExaminationRecordRepository.findAllById(entity.getDiagnosisExaminationRecordsIds());
			entityToUpdate.setDiagnosisExaminationRecords(Sets.newHashSet(diagnosisExaminationRecordsEntities));
		}
		if (persistRelations && !entity.getDiagnosisExaminationRecords().isEmpty()) {
			Set<DiagnosisExaminationRecordEntity> updatedEntities = new HashSet<>();
			entity.getDiagnosisExaminationRecords().forEach(model -> {
				if (model.getId() != null) {
					model = this.diagnosisExaminationRecordRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDiagnosisExaminationRecords(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDiagnosisNandasIds().isEmpty() && entity.getDiagnosisNandas().isEmpty()) {
			entityToUpdate.setDiagnosisNandas(new HashSet<>());
		} else if (!entity.getDiagnosisNandasIds().isEmpty() && entity.getDiagnosisNandas().isEmpty()) {
			Iterable<DiagnosisNandaEntity> diagnosisNandasEntities =
					this.diagnosisNandaRepository.findAllById(entity.getDiagnosisNandasIds());
			entityToUpdate.setDiagnosisNandas(Sets.newHashSet(diagnosisNandasEntities));
		}
		if (persistRelations && !entity.getDiagnosisNandas().isEmpty()) {
			Set<DiagnosisNandaEntity> updatedEntities = new HashSet<>();
			entity.getDiagnosisNandas().forEach(model -> {
				if (model.getId() != null) {
					model = this.diagnosisNandaRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDiagnosisNandas(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRoomTransfersIds().isEmpty() && entity.getRoomTransfers().isEmpty()) {
			entityToUpdate.setRoomTransfers(new HashSet<>());
		} else if (!entity.getRoomTransfersIds().isEmpty() && entity.getRoomTransfers().isEmpty()) {
			Iterable<RoomTransferEntity> roomTransfersEntities =
					this.roomTransferRepository.findAllById(entity.getRoomTransfersIds());
			entityToUpdate.setRoomTransfers(Sets.newHashSet(roomTransfersEntities));
		}
		if (persistRelations && !entity.getRoomTransfers().isEmpty()) {
			Set<RoomTransferEntity> updatedEntities = new HashSet<>();
			entity.getRoomTransfers().forEach(model -> {
				if (model.getId() != null) {
					model = this.roomTransferRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRoomTransfers(updatedEntities);
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
	public void validateEntity(MedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<MedicalExaminationRecordEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the MedicalExaminationRecordEntity.
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

	public Set<String> validateEntityRelations(MedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getDoctorId() != null && this.staffRepository.findById(entity.getDoctorId()).isEmpty()) {
			errors.add("The UUID " + entity.getDoctorId() + " is not associated with a Staff Entity");
		}

		if (entity.getInpatientMedicalExaminationRecordId() != null && this.inpatientMedicalExaminationRecordRepository.findById(entity.getInpatientMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getInpatientMedicalExaminationRecordId() + " is not associated with a Inpatient Medical Examination Record Entity");
		}

		if (entity.getRegistrationId() != null && this.registrationRepository.findById(entity.getRegistrationId()).isEmpty()) {
			errors.add("The UUID " + entity.getRegistrationId() + " is not associated with a Registration Entity");
		}

		if (entity.getMedicalTranscriberId() != null && this.staffRepository.findById(entity.getMedicalTranscriberId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalTranscriberId() + " is not associated with a Staff Entity");
		}

		if (entity.getNurseId() != null && this.staffRepository.findById(entity.getNurseId()).isEmpty()) {
			errors.add("The UUID " + entity.getNurseId() + " is not associated with a Staff Entity");
		}

		for (UUID id : entity.getAmendmentDetailsIds()) {
			if (this.amendmentDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Amendment Detail Entity");
			}
		}

		if (entity.getBirthHistoryId() != null && this.birthHistoryRepository.findById(entity.getBirthHistoryId()).isEmpty()) {
			errors.add("The UUID " + entity.getBirthHistoryId() + " is not associated with a Birth History Entity");
		}

		if (entity.getBodyChartExaminationId() != null && this.bodyChartExaminationRepository.findById(entity.getBodyChartExaminationId()).isEmpty()) {
			errors.add("The UUID " + entity.getBodyChartExaminationId() + " is not associated with a Body Chart Examination Entity");
		}

		for (UUID id : entity.getCoTreatingDoctorsIds()) {
			if (this.coTreatingDoctorRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Co Treating Doctor Entity");
			}
		}

		for (UUID id : entity.getDailyCareCPPTsIds()) {
			if (this.dailyCareCPPTRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Daily Care CPPT Entity");
			}
		}

		if (entity.getDeliveryMedicalExaminationRecordId() != null && this.deliveryMedicalExaminationRecordRepository.findById(entity.getDeliveryMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getDeliveryMedicalExaminationRecordId() + " is not associated with a Delivery Medical Examination Record Entity");
		}

		for (UUID id : entity.getDiagnosisExaminationRecordsIds()) {
			if (this.diagnosisExaminationRecordRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Diagnosis Examination Record Entity");
			}
		}

		for (UUID id : entity.getDiagnosisNandasIds()) {
			if (this.diagnosisNandaRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Diagnosis Nanda Entity");
			}
		}

		if (entity.getEntExaminationId() != null && this.entExaminationRepository.findById(entity.getEntExaminationId()).isEmpty()) {
			errors.add("The UUID " + entity.getEntExaminationId() + " is not associated with a ENT Examination Entity");
		}

		if (entity.getEmergencyMedicationExaminationRecordId() != null && this.emergencyMedicalExaminationRecordRepository.findById(entity.getEmergencyMedicationExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getEmergencyMedicationExaminationRecordId() + " is not associated with a Emergency Medical Examination Record Entity");
		}

		if (entity.getFormulirKonselingTesHivId() != null && this.formulirKonselingTesHivRepository.findById(entity.getFormulirKonselingTesHivId()).isEmpty()) {
			errors.add("The UUID " + entity.getFormulirKonselingTesHivId() + " is not associated with a Formulir Konseling Tes Hiv Entity");
		}

		if (entity.getHemodialysisExaminationId() != null && this.hemodialysisExaminationRepository.findById(entity.getHemodialysisExaminationId()).isEmpty()) {
			errors.add("The UUID " + entity.getHemodialysisExaminationId() + " is not associated with a Hemodialysis Examination Entity");
		}

		if (entity.getMedicalExaminationRecordDischargeSummaryId() != null && this.medicalExaminationRecordDischargeSummaryRepository.findById(entity.getMedicalExaminationRecordDischargeSummaryId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordDischargeSummaryId() + " is not associated with a Medical Examination Record Discharge Summary Entity");
		}

		if (entity.getMedicalRecordInitialChecklistId() != null && this.medicalRecordInitialChecklistRepository.findById(entity.getMedicalRecordInitialChecklistId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalRecordInitialChecklistId() + " is not associated with a Medical Record Initial Checklist Entity");
		}

		if (entity.getMedicalRecordNextVerificationChecklistId() != null && this.medicalRecordNextVerificationChecklistRepository.findById(entity.getMedicalRecordNextVerificationChecklistId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalRecordNextVerificationChecklistId() + " is not associated with a Medical Record Next Verification Checklist Entity");
		}

		if (entity.getNurseVitalSignMeasurementId() != null && this.nurseVitalSignMeasurementRepository.findById(entity.getNurseVitalSignMeasurementId()).isEmpty()) {
			errors.add("The UUID " + entity.getNurseVitalSignMeasurementId() + " is not associated with a Nurse Vital Sign Measurement Entity");
		}

		if (entity.getObstetricAndGynecologyHistoryId() != null && this.obstetricAndGynecologyHistoryRepository.findById(entity.getObstetricAndGynecologyHistoryId()).isEmpty()) {
			errors.add("The UUID " + entity.getObstetricAndGynecologyHistoryId() + " is not associated with a Obstetric And Gynecology History Entity");
		}

		if (entity.getOdontogramExaminationId() != null && this.odontogramExaminationRepository.findById(entity.getOdontogramExaminationId()).isEmpty()) {
			errors.add("The UUID " + entity.getOdontogramExaminationId() + " is not associated with a Odontogram Examination Entity");
		}

		if (entity.getOperatingTheaterMedicalExaminationRecordId() != null && this.operatingTheaterMedicalExaminationRecordRepository.findById(entity.getOperatingTheaterMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getOperatingTheaterMedicalExaminationRecordId() + " is not associated with a Operating Theater Medical Examination Record Entity");
		}

		if (entity.getOphthalmologyExaminationId() != null && this.ophthalmologyExaminationRepository.findById(entity.getOphthalmologyExaminationId()).isEmpty()) {
			errors.add("The UUID " + entity.getOphthalmologyExaminationId() + " is not associated with a Ophthalmology Examination Entity");
		}

		for (UUID id : entity.getRoomTransfersIds()) {
			if (this.roomTransferRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Room Transfer Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
