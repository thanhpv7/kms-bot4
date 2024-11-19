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
import kmsweb.repositories.NurseVitalSignMeasurementRepository;
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
public class NurseVitalSignMeasurementService extends AbstractService<NurseVitalSignMeasurementEntity, NurseVitalSignMeasurementRepository, NurseVitalSignMeasurementEntityAudit> {

	private final String[] referenceNamesInNurseVitalSignMeasurementEntity = {
		"medicalExaminationRecord",
	};

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public NurseVitalSignMeasurementService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		NurseVitalSignMeasurementRepository repository
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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByDiastole(Integer diastole)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] end
	{
		// % protected region % [Add any additional logic for findByDiastole before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastole before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByDiastole(diastole));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findBySystole(Integer systole)
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] end
	{
		// % protected region % [Add any additional logic for findBySystole before the main body here] off begin
		// % protected region % [Add any additional logic for findBySystole before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findBySystole(systole));

		// % protected region % [Add any additional logic for findBySystole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySystole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Temperature.
	 *
	 * @param temperature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature
	 */
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByTemperature(Double temperature)
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperature here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperature here] end
	{
		// % protected region % [Add any additional logic for findByTemperature before the main body here] off begin
		// % protected region % [Add any additional logic for findByTemperature before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByTemperature(temperature));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByTemperatureScale(String temperatureScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperatureScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTemperatureScale here] end
	{
		// % protected region % [Add any additional logic for findByTemperatureScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByTemperatureScale before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByTemperatureScale(temperatureScale));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByConsciousness(String consciousness)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsciousness here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsciousness here] end
	{
		// % protected region % [Add any additional logic for findByConsciousness before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsciousness before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByConsciousness(consciousness));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByPulse(Integer pulse)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulse here] end
	{
		// % protected region % [Add any additional logic for findByPulse before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulse before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByPulse(pulse));

		// % protected region % [Add any additional logic for findByPulse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPulse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Regularity.
	 *
	 * @param pulseRegularity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Regularity
	 */
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByPulseRegularity(String pulseRegularity)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseRegularity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseRegularity here] end
	{
		// % protected region % [Add any additional logic for findByPulseRegularity before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulseRegularity before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByPulseRegularity(pulseRegularity));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByPulseStrength(String pulseStrength)
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseStrength here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPulseStrength here] end
	{
		// % protected region % [Add any additional logic for findByPulseStrength before the main body here] off begin
		// % protected region % [Add any additional logic for findByPulseStrength before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByPulseStrength(pulseStrength));

		// % protected region % [Add any additional logic for findByPulseStrength before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPulseStrength before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gcs Eyes.
	 *
	 * @param gcsEyes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gcs Eyes
	 */
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByGcsEyes(String gcsEyes)
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsEyes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsEyes here] end
	{
		// % protected region % [Add any additional logic for findByGcsEyes before the main body here] off begin
		// % protected region % [Add any additional logic for findByGcsEyes before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByGcsEyes(gcsEyes));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByGcsVerbal(String gcsVerbal)
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsVerbal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsVerbal here] end
	{
		// % protected region % [Add any additional logic for findByGcsVerbal before the main body here] off begin
		// % protected region % [Add any additional logic for findByGcsVerbal before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByGcsVerbal(gcsVerbal));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByGcsMotor(String gcsMotor)
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsMotor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGcsMotor here] end
	{
		// % protected region % [Add any additional logic for findByGcsMotor before the main body here] off begin
		// % protected region % [Add any additional logic for findByGcsMotor before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByGcsMotor(gcsMotor));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByTotalGCSScore(Double totalGCSScore)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalGCSScore here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalGCSScore here] end
	{
		// % protected region % [Add any additional logic for findByTotalGCSScore before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalGCSScore before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByTotalGCSScore(totalGCSScore));

		// % protected region % [Add any additional logic for findByTotalGCSScore before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalGCSScore before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Height.
	 *
	 * @param height the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height
	 */
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByHeight(Double height)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeight here] end
	{
		// % protected region % [Add any additional logic for findByHeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeight before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByHeight(height));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByHeightScale(String heightScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeightScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeightScale here] end
	{
		// % protected region % [Add any additional logic for findByHeightScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeightScale before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByHeightScale(heightScale));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByWeight(Double weight)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] end
	{
		// % protected region % [Add any additional logic for findByWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeight before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByWeight(weight));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByWeightScale(String weightScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightScale here] end
	{
		// % protected region % [Add any additional logic for findByWeightScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightScale before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByWeightScale(weightScale));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByBmi(Double bmi)
	// % protected region % [Add any throwables, implementations, or extensions for findByBmi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBmi here] end
	{
		// % protected region % [Add any additional logic for findByBmi before the main body here] off begin
		// % protected region % [Add any additional logic for findByBmi before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByBmi(bmi));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByRespiratory(Double respiratory)
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratory here] end
	{
		// % protected region % [Add any additional logic for findByRespiratory before the main body here] off begin
		// % protected region % [Add any additional logic for findByRespiratory before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByRespiratory(respiratory));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByOxygenSaturation(Double oxygenSaturation)
	// % protected region % [Add any throwables, implementations, or extensions for findByOxygenSaturation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOxygenSaturation here] end
	{
		// % protected region % [Add any additional logic for findByOxygenSaturation before the main body here] off begin
		// % protected region % [Add any additional logic for findByOxygenSaturation before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByOxygenSaturation(oxygenSaturation));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByNutritionStatus(String nutritionStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByNutritionStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNutritionStatus here] end
	{
		// % protected region % [Add any additional logic for findByNutritionStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByNutritionStatus before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByNutritionStatus(nutritionStatus));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByWaistCircumference(Double waistCircumference)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumference here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumference here] end
	{
		// % protected region % [Add any additional logic for findByWaistCircumference before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumference before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByWaistCircumference(waistCircumference));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByWaistCircumferenceUnit(String waistCircumferenceUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumferenceUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumferenceUnit here] end
	{
		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumferenceUnit before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByWaistCircumferenceUnit(waistCircumferenceUnit));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByPainScale(Integer painScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScale here] end
	{
		// % protected region % [Add any additional logic for findByPainScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByPainScale before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByPainScale(painScale));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByPainScaleUsed(String painScaleUsed)
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScaleUsed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPainScaleUsed here] end
	{
		// % protected region % [Add any additional logic for findByPainScaleUsed before the main body here] off begin
		// % protected region % [Add any additional logic for findByPainScaleUsed before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByPainScaleUsed(painScaleUsed));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByRiskFallScale(Integer riskFallScale)
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScale here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScale here] end
	{
		// % protected region % [Add any additional logic for findByRiskFallScale before the main body here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScale before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByRiskFallScale(riskFallScale));

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findByRiskFallScaleUsed(String riskFallScaleUsed)
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScaleUsed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFallScaleUsed here] end
	{
		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before the main body here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before the main body here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findByRiskFallScaleUsed(riskFallScaleUsed));

		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRiskFallScaleUsed before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<NurseVitalSignMeasurementEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<NurseVitalSignMeasurementEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<NurseVitalSignMeasurementEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'create')")
	public NurseVitalSignMeasurementEntity create(NurseVitalSignMeasurementEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		NurseVitalSignMeasurementEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'create')")
	public NurseVitalSignMeasurementEntity create(NurseVitalSignMeasurementEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		NurseVitalSignMeasurementEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		NurseVitalSignMeasurementEntity newEntity;

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'create')")
	public List<NurseVitalSignMeasurementEntity> createAll(Iterable<NurseVitalSignMeasurementEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<NurseVitalSignMeasurementEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<NurseVitalSignMeasurementEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'update')")
	public NurseVitalSignMeasurementEntity update(NurseVitalSignMeasurementEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		NurseVitalSignMeasurementEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'update')")
	public NurseVitalSignMeasurementEntity update(NurseVitalSignMeasurementEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		NurseVitalSignMeasurementEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		NurseVitalSignMeasurementEntity newEntity;

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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'update')")
	public List<NurseVitalSignMeasurementEntity> updateAll(Iterable<NurseVitalSignMeasurementEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<NurseVitalSignMeasurementEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<NurseVitalSignMeasurementEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'create') or hasPermission('NurseVitalSignMeasurementEntity', 'update')")
	public NurseVitalSignMeasurementEntity save(NurseVitalSignMeasurementEntity entity) throws ConstraintViolationException
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

		NurseVitalSignMeasurementEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'create') or hasPermission('NurseVitalSignMeasurementEntity', 'update')")
	public List<NurseVitalSignMeasurementEntity> saveAll(Iterable<NurseVitalSignMeasurementEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<NurseVitalSignMeasurementEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'delete')")
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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'delete')")
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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	public List<NurseVitalSignMeasurementEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	public List<NurseVitalSignMeasurementEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(NurseVitalSignMeasurementEntity.class);

		// % protected region % [Add any additional processing before converting to a list of NurseVitalSignMeasurementEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of NurseVitalSignMeasurementEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('NurseVitalSignMeasurementEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<NurseVitalSignMeasurementEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of NurseVitalSignMeasurementEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of NurseVitalSignMeasurementEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(NurseVitalSignMeasurementEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of NurseVitalSignMeasurementEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of NurseVitalSignMeasurementEntityAudits
	 */
	private List<NurseVitalSignMeasurementEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<NurseVitalSignMeasurementEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param nurseVitalSignMeasurement nurseVitalSignMeasurement to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private NurseVitalSignMeasurementEntity updateAuditData(NurseVitalSignMeasurementEntity nurseVitalSignMeasurement)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return nurseVitalSignMeasurement;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private NurseVitalSignMeasurementEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		NurseVitalSignMeasurementEntity entityAtRevision = updateAuditData((NurseVitalSignMeasurementEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new NurseVitalSignMeasurementEntityAudit(
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

		QNurseVitalSignMeasurementEntity entity = QNurseVitalSignMeasurementEntity.nurseVitalSignMeasurementEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Nurse Vital Sign Measurement here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Nurse Vital Sign Measurement here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Nurse Vital Sign Measurement here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Nurse Vital Sign Measurement here] end

				break;
			case "diastole":
				// % protected region % [Add any additional logic before the query parameters of diastole here] off begin
				// % protected region % [Add any additional logic before the query parameters of diastole here] end


				// % protected region % [Add any additional logic after the query parameters of diastole here] off begin
				// % protected region % [Add any additional logic after the query parameters of diastole here] end

				break;
			case "systole":
				// % protected region % [Add any additional logic before the query parameters of systole here] off begin
				// % protected region % [Add any additional logic before the query parameters of systole here] end


				// % protected region % [Add any additional logic after the query parameters of systole here] off begin
				// % protected region % [Add any additional logic after the query parameters of systole here] end

				break;
			case "pulseRegularity":
				// % protected region % [Add any additional logic before the query parameters of pulseRegularity here] off begin
				// % protected region % [Add any additional logic before the query parameters of pulseRegularity here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pulseRegularity, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of pulseRegularity here] off begin
				// % protected region % [Add any additional logic after the query parameters of pulseRegularity here] end

				break;
			case "waistCircumference":
				// % protected region % [Add any additional logic before the query parameters of waistCircumference here] off begin
				// % protected region % [Add any additional logic before the query parameters of waistCircumference here] end


				// % protected region % [Add any additional logic after the query parameters of waistCircumference here] off begin
				// % protected region % [Add any additional logic after the query parameters of waistCircumference here] end

				break;
			case "waistCircumferenceUnit":
				// % protected region % [Add any additional logic before the query parameters of waistCircumferenceUnit here] off begin
				// % protected region % [Add any additional logic before the query parameters of waistCircumferenceUnit here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.waistCircumferenceUnit, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of waistCircumferenceUnit here] off begin
				// % protected region % [Add any additional logic after the query parameters of waistCircumferenceUnit here] end

				break;
			case "painScale":
				// % protected region % [Add any additional logic before the query parameters of painScale here] off begin
				// % protected region % [Add any additional logic before the query parameters of painScale here] end


				// % protected region % [Add any additional logic after the query parameters of painScale here] off begin
				// % protected region % [Add any additional logic after the query parameters of painScale here] end

				break;
			case "painScaleUsed":
				// % protected region % [Add any additional logic before the query parameters of painScaleUsed here] off begin
				// % protected region % [Add any additional logic before the query parameters of painScaleUsed here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.painScaleUsed, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of painScaleUsed here] off begin
				// % protected region % [Add any additional logic after the query parameters of painScaleUsed here] end

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
	public NurseVitalSignMeasurementEntity updateOldData(NurseVitalSignMeasurementEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public NurseVitalSignMeasurementEntity updateOldData(NurseVitalSignMeasurementEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		NurseVitalSignMeasurementEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInNurseVitalSignMeasurementEntity);

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
				entityToUpdate.getMedicalExaminationRecord().unsetNurseVitalSignMeasurement();
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
	public void validateEntity(NurseVitalSignMeasurementEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<NurseVitalSignMeasurementEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the NurseVitalSignMeasurementEntity.
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

	public Set<String> validateEntityRelations(NurseVitalSignMeasurementEntity entity)
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
