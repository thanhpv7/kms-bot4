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

import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
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
public interface MedicalExaminationRecordDischargeSummaryRepository extends AbstractRepository<MedicalExaminationRecordDischargeSummaryEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByDiastole(@NotNull Integer diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findBySystole(@NotNull Integer systole);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse.
	 *
	 * @param pulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByPulse(@NotNull Integer pulse);
	/**
	 * Return an entity or a list of entities that have the given attribute BP Standing Systole.
	 *
	 * @param bpStandingSystole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BP Standing Systole
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByBpStandingSystole(@NotNull Integer bpStandingSystole);
	/**
	 * Return an entity or a list of entities that have the given attribute BP Standing Diastole.
	 *
	 * @param bpStandingDiastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BP Standing Diastole
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByBpStandingDiastole(@NotNull Integer bpStandingDiastole);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Regularity.
	 *
	 * @param pulseRegularity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Regularity
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByPulseRegularity(@NotNull String pulseRegularity);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Strength.
	 *
	 * @param pulseStrength the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Strength
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByPulseStrength(@NotNull String pulseStrength);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature.
	 *
	 * @param temperature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByTemperature(@NotNull Double temperature);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature scale.
	 *
	 * @param temperatureScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature scale
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByTemperatureScale(@NotNull String temperatureScale);
	/**
	 * Return an entity or a list of entities that have the given attribute GCS Eyes.
	 *
	 * @param gcsEyes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute GCS Eyes
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByGcsEyes(@NotNull String gcsEyes);
	/**
	 * Return an entity or a list of entities that have the given attribute GCS Verbal.
	 *
	 * @param gcsVerbal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute GCS Verbal
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByGcsVerbal(@NotNull String gcsVerbal);
	/**
	 * Return an entity or a list of entities that have the given attribute GCS Motor.
	 *
	 * @param gcsMotor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute GCS Motor
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByGcsMotor(@NotNull String gcsMotor);
	/**
	 * Return an entity or a list of entities that have the given attribute Total GCS Score.
	 *
	 * @param totalGCSScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total GCS Score
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByTotalGCSScore(@NotNull Double totalGCSScore);
	/**
	 * Return an entity or a list of entities that have the given attribute Consciousness.
	 *
	 * @param consciousness the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consciousness
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByConsciousness(@NotNull String consciousness);
	/**
	 * Return an entity or a list of entities that have the given attribute Height.
	 *
	 * @param height the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByHeight(@NotNull Double height);
	/**
	 * Return an entity or a list of entities that have the given attribute Height Scale.
	 *
	 * @param heightScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height Scale
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByHeightScale(@NotNull String heightScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByWeight(@NotNull Double weight);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Scale.
	 *
	 * @param weightScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Scale
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByWeightScale(@NotNull String weightScale);
	/**
	 * Return an entity or a list of entities that have the given attribute BMI.
	 *
	 * @param bmi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BMI
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByBmi(@NotNull Double bmi);
	/**
	 * Return an entity or a list of entities that have the given attribute Respiratory.
	 *
	 * @param respiratory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Respiratory
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByRespiratory(@NotNull Double respiratory);
	/**
	 * Return an entity or a list of entities that have the given attribute Oxygen Saturation.
	 *
	 * @param oxygenSaturation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Oxygen Saturation
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByOxygenSaturation(@NotNull Double oxygenSaturation);
	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference.
	 *
	 * @param waistCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByWaistCircumference(@NotNull Double waistCircumference);
	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference Unit.
	 *
	 * @param waistCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference Unit
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByWaistCircumferenceUnit(@NotNull String waistCircumferenceUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Nutrition Status.
	 *
	 * @param nutritionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nutrition Status
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByNutritionStatus(@NotNull String nutritionStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Pain Scale.
	 *
	 * @param painScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pain Scale
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByPainScale(@NotNull Integer painScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Pain Scale Used.
	 *
	 * @param painScaleUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pain Scale Used
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByPainScaleUsed(@NotNull String painScaleUsed);
	/**
	 * Return an entity or a list of entities that have the given attribute Risk Fall Scale.
	 *
	 * @param riskFallScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Fall Scale
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByRiskFallScale(@NotNull Integer riskFallScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Objective.
	 *
	 * @param objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Objective
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByObjective(@NotNull String objective);
	/**
	 * Return an entity or a list of entities that have the given attribute Risk Fall Scale Used.
	 *
	 * @param riskFallScaleUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Fall Scale Used
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByRiskFallScaleUsed(@NotNull String riskFallScaleUsed);
	/**
	 * Return an entity or a list of entities that have the given attribute Subjective.
	 *
	 * @param subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Subjective
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findBySubjective(@NotNull String subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Plan.
	 *
	 * @param plan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Plan
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByPlan(@NotNull String plan);
	/**
	 * Return an entity or a list of entities that have the given attribute Purpose.
	 *
	 * @param purpose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purpose
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByPurpose(@NotNull String purpose);
	/**
	 * Return an entity or a list of entities that have the given attribute Examination Sub Case.
	 *
	 * @param examinationSubCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Examination Sub Case
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByExaminationSubCase(@NotNull String examinationSubCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Accidental Type.
	 *
	 * @param accidentalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accidental Type
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByAccidentalType(@NotNull String accidentalType);
	/**
	 * Return an entity or a list of entities that have the given attribute Service Case.
	 *
	 * @param serviceCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Case
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByServiceCase(@NotNull String serviceCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Accidental Sub Type.
	 *
	 * @param accidentalSubType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accidental Sub Type
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByAccidentalSubType(@NotNull String accidentalSubType);
	/**
	 * Return an entity or a list of entities that have the given attribute Additional Notes.
	 *
	 * @param additionalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Additional Notes
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByAdditionalNotes(@NotNull String additionalNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Discharge Summary.
	 *
	 * @param dischargeSummary the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discharge Summary
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByDischargeSummary(@NotNull String dischargeSummary);
	/**
	 * Return an entity or a list of entities that have the given attribute Condition Upon Discharge.
	 *
	 * @param conditionUponDischarge the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Condition Upon Discharge
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByConditionUponDischarge(@NotNull String conditionUponDischarge);
	/**
	 * Return an entity or a list of entities that have the given attribute Escorted By.
	 *
	 * @param escortedBy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Escorted By
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByEscortedBy(@NotNull String escortedBy);
	/**
	 * Return an entity or a list of entities that have the given attribute Discharge Reason.
	 *
	 * @param dischargeReason the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discharge Reason
	 */
	List<MedicalExaminationRecordDischargeSummaryEntity> findByDischargeReason(@NotNull String dischargeReason);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicalExaminationRecordDischargeSummaryEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicalExaminationRecordDischargeSummaryEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}