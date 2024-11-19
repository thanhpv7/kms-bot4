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
package kmsweb.repositories;

import kmsweb.entities.NurseVitalSignMeasurementEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface NurseVitalSignMeasurementRepository extends AbstractRepository<NurseVitalSignMeasurementEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	List<NurseVitalSignMeasurementEntity> findByDiastole(@NotNull Integer diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	List<NurseVitalSignMeasurementEntity> findBySystole(@NotNull Integer systole);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature.
	 *
	 * @param temperature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature
	 */
	List<NurseVitalSignMeasurementEntity> findByTemperature(@NotNull Double temperature);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature Scale.
	 *
	 * @param temperatureScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature Scale
	 */
	List<NurseVitalSignMeasurementEntity> findByTemperatureScale(@NotNull String temperatureScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Consciousness.
	 *
	 * @param consciousness the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consciousness
	 */
	List<NurseVitalSignMeasurementEntity> findByConsciousness(@NotNull String consciousness);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse.
	 *
	 * @param pulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse
	 */
	List<NurseVitalSignMeasurementEntity> findByPulse(@NotNull Integer pulse);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Regularity.
	 *
	 * @param pulseRegularity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Regularity
	 */
	List<NurseVitalSignMeasurementEntity> findByPulseRegularity(@NotNull String pulseRegularity);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Strength.
	 *
	 * @param pulseStrength the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Strength
	 */
	List<NurseVitalSignMeasurementEntity> findByPulseStrength(@NotNull String pulseStrength);
	/**
	 * Return an entity or a list of entities that have the given attribute Gcs Eyes.
	 *
	 * @param gcsEyes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gcs Eyes
	 */
	List<NurseVitalSignMeasurementEntity> findByGcsEyes(@NotNull String gcsEyes);
	/**
	 * Return an entity or a list of entities that have the given attribute Gcs Verbal.
	 *
	 * @param gcsVerbal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gcs Verbal
	 */
	List<NurseVitalSignMeasurementEntity> findByGcsVerbal(@NotNull String gcsVerbal);
	/**
	 * Return an entity or a list of entities that have the given attribute Gcs Motor.
	 *
	 * @param gcsMotor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gcs Motor
	 */
	List<NurseVitalSignMeasurementEntity> findByGcsMotor(@NotNull String gcsMotor);
	/**
	 * Return an entity or a list of entities that have the given attribute Total GCS Score.
	 *
	 * @param totalGCSScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total GCS Score
	 */
	List<NurseVitalSignMeasurementEntity> findByTotalGCSScore(@NotNull Double totalGCSScore);
	/**
	 * Return an entity or a list of entities that have the given attribute Height.
	 *
	 * @param height the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height
	 */
	List<NurseVitalSignMeasurementEntity> findByHeight(@NotNull Double height);
	/**
	 * Return an entity or a list of entities that have the given attribute Height Scale.
	 *
	 * @param heightScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height Scale
	 */
	List<NurseVitalSignMeasurementEntity> findByHeightScale(@NotNull String heightScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	List<NurseVitalSignMeasurementEntity> findByWeight(@NotNull Double weight);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Scale.
	 *
	 * @param weightScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Scale
	 */
	List<NurseVitalSignMeasurementEntity> findByWeightScale(@NotNull String weightScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Bmi.
	 *
	 * @param bmi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bmi
	 */
	List<NurseVitalSignMeasurementEntity> findByBmi(@NotNull Double bmi);
	/**
	 * Return an entity or a list of entities that have the given attribute Respiratory.
	 *
	 * @param respiratory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Respiratory
	 */
	List<NurseVitalSignMeasurementEntity> findByRespiratory(@NotNull Double respiratory);
	/**
	 * Return an entity or a list of entities that have the given attribute Oxygen Saturation.
	 *
	 * @param oxygenSaturation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Oxygen Saturation
	 */
	List<NurseVitalSignMeasurementEntity> findByOxygenSaturation(@NotNull Double oxygenSaturation);
	/**
	 * Return an entity or a list of entities that have the given attribute Nutrition Status.
	 *
	 * @param nutritionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nutrition Status
	 */
	List<NurseVitalSignMeasurementEntity> findByNutritionStatus(@NotNull String nutritionStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference.
	 *
	 * @param waistCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference
	 */
	List<NurseVitalSignMeasurementEntity> findByWaistCircumference(@NotNull Double waistCircumference);
	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference Unit.
	 *
	 * @param waistCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference Unit
	 */
	List<NurseVitalSignMeasurementEntity> findByWaistCircumferenceUnit(@NotNull String waistCircumferenceUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Pain Scale.
	 *
	 * @param painScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pain Scale
	 */
	List<NurseVitalSignMeasurementEntity> findByPainScale(@NotNull Integer painScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Pain Scale Used.
	 *
	 * @param painScaleUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pain Scale Used
	 */
	List<NurseVitalSignMeasurementEntity> findByPainScaleUsed(@NotNull String painScaleUsed);
	/**
	 * Return an entity or a list of entities that have the given attribute Risk Fall Scale.
	 *
	 * @param riskFallScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Fall Scale
	 */
	List<NurseVitalSignMeasurementEntity> findByRiskFallScale(@NotNull Integer riskFallScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Risk Fall Scale Used.
	 *
	 * @param riskFallScaleUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Fall Scale Used
	 */
	List<NurseVitalSignMeasurementEntity> findByRiskFallScaleUsed(@NotNull String riskFallScaleUsed);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NurseVitalSignMeasurementEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NurseVitalSignMeasurementEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}