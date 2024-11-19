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
import kmsweb.repositories.PatientVitalInformationRepository;
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
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
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
public class PatientVitalInformationService extends AbstractService<PatientVitalInformationEntity, PatientVitalInformationRepository, PatientVitalInformationEntityAudit> {

	private final String[] referenceNamesInPatientVitalInformationEntity = {
		"registration",
		"staff",
	};

	private final RegistrationRepository registrationRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientVitalInformationService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		RegistrationRepository registrationRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PatientVitalInformationRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.registrationRepository = registrationRepository;

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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Record Date Time.
	 *
	 * @param recordDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Record Date Time
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByRecordDateTime(OffsetDateTime recordDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByRecordDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRecordDateTime here] end
	{
		// % protected region % [Add any additional logic for findByRecordDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByRecordDateTime before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByRecordDateTime(recordDateTime));

		// % protected region % [Add any additional logic for findByRecordDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRecordDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findBySystole(Double systole)
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] end
	{
		// % protected region % [Add any additional logic for findBySystole before the main body here] off begin
		// % protected region % [Add any additional logic for findBySystole before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findBySystole(systole));

		// % protected region % [Add any additional logic for findBySystole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySystole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByDiastole(Double diastole)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] end
	{
		// % protected region % [Add any additional logic for findByDiastole before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastole before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByDiastole(diastole));

		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Temperature.
	 *
	 * @param temperature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByTemperature(Double temperature)
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperature here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperature here] end
	{
		// % protected region % [Add any additional logic for findByTemperature before the main body here] off begin
		// % protected region % [Add any additional logic for findByTemperature before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByTemperature(temperature));

		// % protected region % [Add any additional logic for findByTemperature before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTemperature before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Temperature Scale.
	 *
	 * @param temperatureScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature Scale
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByTemperatureScale(String temperatureScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperatureScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperatureScale here] end
	{
		// % protected region % [Add any additional logic for findByTemperatureScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByTemperatureScale before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByTemperatureScale(temperatureScale));

		// % protected region % [Add any additional logic for findByTemperatureScale before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTemperatureScale before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Consciousness.
	 *
	 * @param consciousness the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consciousness
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByConsciousness(String consciousness)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsciousness here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsciousness here] end
	{
		// % protected region % [Add any additional logic for findByConsciousness before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsciousness before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByConsciousness(consciousness));

		// % protected region % [Add any additional logic for findByConsciousness before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsciousness before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pulse.
	 *
	 * @param pulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByPulse(Double pulse)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulse here] end
	{
		// % protected region % [Add any additional logic for findByPulse before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulse before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByPulse(pulse));

		// % protected region % [Add any additional logic for findByPulse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPulse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Rhythm.
	 *
	 * @param pulseRhythm the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Rhythm
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByPulseRhythm(String pulseRhythm)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseRhythm here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseRhythm here] end
	{
		// % protected region % [Add any additional logic for findByPulseRhythm before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulseRhythm before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByPulseRhythm(pulseRhythm));

		// % protected region % [Add any additional logic for findByPulseRhythm before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPulseRhythm before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Strength.
	 *
	 * @param strength the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Strength
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByStrength(String strength)
	// % protected region % [Add any throwables, implementations, or extensions for findByStrength here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStrength here] end
	{
		// % protected region % [Add any additional logic for findByStrength before the main body here] off begin
		// % protected region % [Add any additional logic for findByStrength before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByStrength(strength));

		// % protected region % [Add any additional logic for findByStrength before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStrength before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gcs Eyes.
	 *
	 * @param gcsEyes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gcs Eyes
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByGcsEyes(String gcsEyes)
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsEyes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsEyes here] end
	{
		// % protected region % [Add any additional logic for findByGcsEyes before the main body here] off begin
		// % protected region % [Add any additional logic for findByGcsEyes before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByGcsEyes(gcsEyes));

		// % protected region % [Add any additional logic for findByGcsEyes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGcsEyes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gcs Verbal.
	 *
	 * @param gcsVerbal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gcs Verbal
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByGcsVerbal(String gcsVerbal)
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsVerbal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsVerbal here] end
	{
		// % protected region % [Add any additional logic for findByGcsVerbal before the main body here] off begin
		// % protected region % [Add any additional logic for findByGcsVerbal before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByGcsVerbal(gcsVerbal));

		// % protected region % [Add any additional logic for findByGcsVerbal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGcsVerbal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gcs Motor.
	 *
	 * @param gcsMotor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gcs Motor
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByGcsMotor(String gcsMotor)
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsMotor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsMotor here] end
	{
		// % protected region % [Add any additional logic for findByGcsMotor before the main body here] off begin
		// % protected region % [Add any additional logic for findByGcsMotor before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByGcsMotor(gcsMotor));

		// % protected region % [Add any additional logic for findByGcsMotor before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGcsMotor before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Gcs Score.
	 *
	 * @param totalGcsScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Gcs Score
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByTotalGcsScore(Double totalGcsScore)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalGcsScore here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalGcsScore here] end
	{
		// % protected region % [Add any additional logic for findByTotalGcsScore before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalGcsScore before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByTotalGcsScore(totalGcsScore));

		// % protected region % [Add any additional logic for findByTotalGcsScore before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalGcsScore before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Respiratory.
	 *
	 * @param respiratory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Respiratory
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByRespiratory(String respiratory)
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratory here] end
	{
		// % protected region % [Add any additional logic for findByRespiratory before the main body here] off begin
		// % protected region % [Add any additional logic for findByRespiratory before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByRespiratory(respiratory));

		// % protected region % [Add any additional logic for findByRespiratory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRespiratory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Height.
	 *
	 * @param height the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByHeight(Double height)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeight here] end
	{
		// % protected region % [Add any additional logic for findByHeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeight before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByHeight(height));

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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByHeightScale(String heightScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeightScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeightScale here] end
	{
		// % protected region % [Add any additional logic for findByHeightScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeightScale before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByHeightScale(heightScale));

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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByWeight(Double weight)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] end
	{
		// % protected region % [Add any additional logic for findByWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeight before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByWeight(weight));

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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByWeightScale(String weightScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightScale here] end
	{
		// % protected region % [Add any additional logic for findByWeightScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightScale before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByWeightScale(weightScale));

		// % protected region % [Add any additional logic for findByWeightScale before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightScale before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Bmi.
	 *
	 * @param bmi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bmi
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByBmi(Double bmi)
	// % protected region % [Add any throwables, implementations, or extensions for findByBmi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBmi here] end
	{
		// % protected region % [Add any additional logic for findByBmi before the main body here] off begin
		// % protected region % [Add any additional logic for findByBmi before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByBmi(bmi));

		// % protected region % [Add any additional logic for findByBmi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBmi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Oxygen Saturation.
	 *
	 * @param oxygenSaturation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Oxygen Saturation
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByOxygenSaturation(Double oxygenSaturation)
	// % protected region % [Add any throwables, implementations, or extensions for findByOxygenSaturation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOxygenSaturation here] end
	{
		// % protected region % [Add any additional logic for findByOxygenSaturation before the main body here] off begin
		// % protected region % [Add any additional logic for findByOxygenSaturation before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByOxygenSaturation(oxygenSaturation));

		// % protected region % [Add any additional logic for findByOxygenSaturation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOxygenSaturation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nutrition Status.
	 *
	 * @param nutritionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nutrition Status
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByNutritionStatus(String nutritionStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByNutritionStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNutritionStatus here] end
	{
		// % protected region % [Add any additional logic for findByNutritionStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByNutritionStatus before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByNutritionStatus(nutritionStatus));

		// % protected region % [Add any additional logic for findByNutritionStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNutritionStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference.
	 *
	 * @param waistCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByWaistCircumference(Double waistCircumference)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumference here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumference here] end
	{
		// % protected region % [Add any additional logic for findByWaistCircumference before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumference before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByWaistCircumference(waistCircumference));

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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByWaistCircumferenceUnit(String waistCircumferenceUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumferenceUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumferenceUnit here] end
	{
		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByWaistCircumferenceUnit(waistCircumferenceUnit));

		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pain Scale.
	 *
	 * @param painScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pain Scale
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByPainScale(Double painScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScale here] end
	{
		// % protected region % [Add any additional logic for findByPainScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByPainScale before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByPainScale(painScale));

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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByPainScaleUsed(String painScaleUsed)
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScaleUsed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScaleUsed here] end
	{
		// % protected region % [Add any additional logic for findByPainScaleUsed before the main body here] off begin
		// % protected region % [Add any additional logic for findByPainScaleUsed before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByPainScaleUsed(painScaleUsed));

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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByRiskFallScale(Double riskFallScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScale here] end
	{
		// % protected region % [Add any additional logic for findByRiskFallScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScale before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByRiskFallScale(riskFallScale));

		// % protected region % [Add any additional logic for findByRiskFallScale before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScale before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Risk Fall Scale Used.
	 *
	 * @param riskFallScaleUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Fall Scale Used
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByRiskFallScaleUsed(String riskFallScaleUsed)
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScaleUsed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScaleUsed here] end
	{
		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before the main body here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByRiskFallScaleUsed(riskFallScaleUsed));

		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PatientVitalInformationEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PatientVitalInformationEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PatientVitalInformationEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'create')")
	public PatientVitalInformationEntity create(PatientVitalInformationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PatientVitalInformationEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'create')")
	public PatientVitalInformationEntity create(PatientVitalInformationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PatientVitalInformationEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PatientVitalInformationEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'create')")
	public List<PatientVitalInformationEntity> createAll(Iterable<PatientVitalInformationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PatientVitalInformationEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PatientVitalInformationEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'update')")
	public PatientVitalInformationEntity update(PatientVitalInformationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PatientVitalInformationEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'update')")
	public PatientVitalInformationEntity update(PatientVitalInformationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PatientVitalInformationEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PatientVitalInformationEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'update')")
	public List<PatientVitalInformationEntity> updateAll(Iterable<PatientVitalInformationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PatientVitalInformationEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PatientVitalInformationEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'create') or hasPermission('PatientVitalInformationEntity', 'update')")
	public PatientVitalInformationEntity save(PatientVitalInformationEntity entity) throws ConstraintViolationException
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

		PatientVitalInformationEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'create') or hasPermission('PatientVitalInformationEntity', 'update')")
	public List<PatientVitalInformationEntity> saveAll(Iterable<PatientVitalInformationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PatientVitalInformationEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	public List<PatientVitalInformationEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	public List<PatientVitalInformationEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PatientVitalInformationEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PatientVitalInformationEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientVitalInformationEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientVitalInformationEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PatientVitalInformationEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientVitalInformationEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PatientVitalInformationEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PatientVitalInformationEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PatientVitalInformationEntityAudits
	 */
	private List<PatientVitalInformationEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PatientVitalInformationEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param patientVitalInformation patientVitalInformation to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PatientVitalInformationEntity updateAuditData(PatientVitalInformationEntity patientVitalInformation)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return patientVitalInformation;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PatientVitalInformationEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PatientVitalInformationEntity entityAtRevision = updateAuditData((PatientVitalInformationEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PatientVitalInformationEntityAudit(
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

		QPatientVitalInformationEntity entity = QPatientVitalInformationEntity.patientVitalInformationEntity;

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
			case "registrationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Patient Vital Informations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Patient Vital Informations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registration.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Patient Vital Informations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Patient Vital Informations here] end

				break;
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Patient Vital Informations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Patient Vital Informations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Patient Vital Informations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Patient Vital Informations here] end

				break;
			case "recordDateTime":
				// % protected region % [Add any additional logic before the query parameters of recordDateTime here] off begin
				// % protected region % [Add any additional logic before the query parameters of recordDateTime here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.recordDateTime, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of recordDateTime here] off begin
				// % protected region % [Add any additional logic after the query parameters of recordDateTime here] end

				break;
			case "systole":
				// % protected region % [Add any additional logic before the query parameters of systole here] off begin
				// % protected region % [Add any additional logic before the query parameters of systole here] end


				// % protected region % [Add any additional logic after the query parameters of systole here] off begin
				// % protected region % [Add any additional logic after the query parameters of systole here] end

				break;
			case "diastole":
				// % protected region % [Add any additional logic before the query parameters of diastole here] off begin
				// % protected region % [Add any additional logic before the query parameters of diastole here] end


				// % protected region % [Add any additional logic after the query parameters of diastole here] off begin
				// % protected region % [Add any additional logic after the query parameters of diastole here] end

				break;
			case "temperature":
				// % protected region % [Add any additional logic before the query parameters of temperature here] off begin
				// % protected region % [Add any additional logic before the query parameters of temperature here] end


				// % protected region % [Add any additional logic after the query parameters of temperature here] off begin
				// % protected region % [Add any additional logic after the query parameters of temperature here] end

				break;
			case "totalGcsScore":
				// % protected region % [Add any additional logic before the query parameters of totalGcsScore here] off begin
				// % protected region % [Add any additional logic before the query parameters of totalGcsScore here] end


				// % protected region % [Add any additional logic after the query parameters of totalGcsScore here] off begin
				// % protected region % [Add any additional logic after the query parameters of totalGcsScore here] end

				break;
			case "notes":
				// % protected region % [Add any additional logic before the query parameters of notes here] off begin
				// % protected region % [Add any additional logic before the query parameters of notes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.notes, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of notes here] off begin
				// % protected region % [Add any additional logic after the query parameters of notes here] end

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
	public PatientVitalInformationEntity updateOldData(PatientVitalInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PatientVitalInformationEntity updateOldData(PatientVitalInformationEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PatientVitalInformationEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPatientVitalInformationEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
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
				entityToUpdate.getRegistration().unsetPatientVitalInformations();
			}
		}

		// Incoming One to Many reference
		if (entity.getStaff() == null && entity.getStaffId() == null) {
			entityToUpdate.unsetStaff();
		} else if (entity.getStaffId() != null && entity.getStaff() == null) {
			Optional<StaffEntity> staffEntity = this.staffRepository.findById(entity.getStaffId());
			entityToUpdate.setStaff(staffEntity.orElseThrow());
		}
		if (persistRelations && entity.getStaff() != null) {
			entityToUpdate.setStaff(entity.getStaff(), false);
			if (entityToUpdate.getStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getStaff().unsetPatientVitalInformations();
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
	public void validateEntity(PatientVitalInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PatientVitalInformationEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PatientVitalInformationEntity.
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

	public Set<String> validateEntityRelations(PatientVitalInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getRegistrationId() != null && this.registrationRepository.findById(entity.getRegistrationId()).isEmpty()) {
			errors.add("The UUID " + entity.getRegistrationId() + " is not associated with a Registration Entity");
		}

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
