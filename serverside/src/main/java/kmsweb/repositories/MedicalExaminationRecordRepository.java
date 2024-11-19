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

import kmsweb.entities.MedicalExaminationRecordEntity;
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
public interface MedicalExaminationRecordRepository extends AbstractRepository<MedicalExaminationRecordEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	List<MedicalExaminationRecordEntity> findByDiastole(@NotNull Integer diastole);
	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	List<MedicalExaminationRecordEntity> findBySystole(@NotNull Integer systole);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse.
	 *
	 * @param pulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse
	 */
	List<MedicalExaminationRecordEntity> findByPulse(@NotNull Integer pulse);
	/**
	 * Return an entity or a list of entities that have the given attribute BP Standing Systole.
	 *
	 * @param bpStandingSystole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BP Standing Systole
	 */
	List<MedicalExaminationRecordEntity> findByBpStandingSystole(@NotNull Integer bpStandingSystole);
	/**
	 * Return an entity or a list of entities that have the given attribute BP Standing Diastole.
	 *
	 * @param bpStandingDiastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BP Standing Diastole
	 */
	List<MedicalExaminationRecordEntity> findByBpStandingDiastole(@NotNull Integer bpStandingDiastole);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Regularity.
	 *
	 * @param pulseRegularity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Regularity
	 */
	List<MedicalExaminationRecordEntity> findByPulseRegularity(@NotNull String pulseRegularity);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Strength.
	 *
	 * @param pulseStrength the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Strength
	 */
	List<MedicalExaminationRecordEntity> findByPulseStrength(@NotNull String pulseStrength);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature.
	 *
	 * @param temperature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature
	 */
	List<MedicalExaminationRecordEntity> findByTemperature(@NotNull Double temperature);
	/**
	 * Return an entity or a list of entities that have the given attribute Temperature scale.
	 *
	 * @param temperatureScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Temperature scale
	 */
	List<MedicalExaminationRecordEntity> findByTemperatureScale(@NotNull String temperatureScale);
	/**
	 * Return an entity or a list of entities that have the given attribute GCS Eyes.
	 *
	 * @param gcsEyes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute GCS Eyes
	 */
	List<MedicalExaminationRecordEntity> findByGcsEyes(@NotNull String gcsEyes);
	/**
	 * Return an entity or a list of entities that have the given attribute GCS Verbal.
	 *
	 * @param gcsVerbal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute GCS Verbal
	 */
	List<MedicalExaminationRecordEntity> findByGcsVerbal(@NotNull String gcsVerbal);
	/**
	 * Return an entity or a list of entities that have the given attribute GCS Motor.
	 *
	 * @param gcsMotor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute GCS Motor
	 */
	List<MedicalExaminationRecordEntity> findByGcsMotor(@NotNull String gcsMotor);
	/**
	 * Return an entity or a list of entities that have the given attribute Total GCS Score.
	 *
	 * @param totalGCSScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total GCS Score
	 */
	List<MedicalExaminationRecordEntity> findByTotalGCSScore(@NotNull Double totalGCSScore);
	/**
	 * Return an entity or a list of entities that have the given attribute Consciousness.
	 *
	 * @param consciousness the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consciousness
	 */
	List<MedicalExaminationRecordEntity> findByConsciousness(@NotNull String consciousness);
	/**
	 * Return an entity or a list of entities that have the given attribute Height.
	 *
	 * @param height the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height
	 */
	List<MedicalExaminationRecordEntity> findByHeight(@NotNull Double height);
	/**
	 * Return an entity or a list of entities that have the given attribute Height Scale.
	 *
	 * @param heightScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height Scale
	 */
	List<MedicalExaminationRecordEntity> findByHeightScale(@NotNull String heightScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	List<MedicalExaminationRecordEntity> findByWeight(@NotNull Double weight);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Scale.
	 *
	 * @param weightScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Scale
	 */
	List<MedicalExaminationRecordEntity> findByWeightScale(@NotNull String weightScale);
	/**
	 * Return an entity or a list of entities that have the given attribute BMI.
	 *
	 * @param bmi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BMI
	 */
	List<MedicalExaminationRecordEntity> findByBmi(@NotNull Double bmi);
	/**
	 * Return an entity or a list of entities that have the given attribute Respiratory.
	 *
	 * @param respiratory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Respiratory
	 */
	List<MedicalExaminationRecordEntity> findByRespiratory(@NotNull Double respiratory);
	/**
	 * Return an entity or a list of entities that have the given attribute Oxygen Saturation.
	 *
	 * @param oxygenSaturation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Oxygen Saturation
	 */
	List<MedicalExaminationRecordEntity> findByOxygenSaturation(@NotNull Double oxygenSaturation);
	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference.
	 *
	 * @param waistCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference
	 */
	List<MedicalExaminationRecordEntity> findByWaistCircumference(@NotNull Double waistCircumference);
	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference Unit.
	 *
	 * @param waistCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference Unit
	 */
	List<MedicalExaminationRecordEntity> findByWaistCircumferenceUnit(@NotNull String waistCircumferenceUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Nutrition Status.
	 *
	 * @param nutritionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nutrition Status
	 */
	List<MedicalExaminationRecordEntity> findByNutritionStatus(@NotNull String nutritionStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Pain Scale.
	 *
	 * @param painScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pain Scale
	 */
	List<MedicalExaminationRecordEntity> findByPainScale(@NotNull Integer painScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Pain Scale Used.
	 *
	 * @param painScaleUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pain Scale Used
	 */
	List<MedicalExaminationRecordEntity> findByPainScaleUsed(@NotNull String painScaleUsed);
	/**
	 * Return an entity or a list of entities that have the given attribute Risk Fall Scale.
	 *
	 * @param riskFallScale the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Fall Scale
	 */
	List<MedicalExaminationRecordEntity> findByRiskFallScale(@NotNull Integer riskFallScale);
	/**
	 * Return an entity or a list of entities that have the given attribute Objective.
	 *
	 * @param objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Objective
	 */
	List<MedicalExaminationRecordEntity> findByObjective(@NotNull String objective);
	/**
	 * Return an entity or a list of entities that have the given attribute Risk Fall Scale Used.
	 *
	 * @param riskFallScaleUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Fall Scale Used
	 */
	List<MedicalExaminationRecordEntity> findByRiskFallScaleUsed(@NotNull String riskFallScaleUsed);
	/**
	 * Return an entity or a list of entities that have the given attribute Subjective.
	 *
	 * @param subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Subjective
	 */
	List<MedicalExaminationRecordEntity> findBySubjective(@NotNull String subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Plan.
	 *
	 * @param plan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Plan
	 */
	List<MedicalExaminationRecordEntity> findByPlan(@NotNull String plan);
	/**
	 * Return an entity or a list of entities that have the given attribute Purpose.
	 *
	 * @param purpose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purpose
	 */
	List<MedicalExaminationRecordEntity> findByPurpose(@NotNull String purpose);
	/**
	 * Return an entity or a list of entities that have the given attribute Examination Sub Case.
	 *
	 * @param examinationSubCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Examination Sub Case
	 */
	List<MedicalExaminationRecordEntity> findByExaminationSubCase(@NotNull String examinationSubCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Accidental Type.
	 *
	 * @param accidentalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accidental Type
	 */
	List<MedicalExaminationRecordEntity> findByAccidentalType(@NotNull String accidentalType);
	/**
	 * Return an entity or a list of entities that have the given attribute Service Case.
	 *
	 * @param serviceCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Case
	 */
	List<MedicalExaminationRecordEntity> findByServiceCase(@NotNull String serviceCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Accidental Sub Type.
	 *
	 * @param accidentalSubType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accidental Sub Type
	 */
	List<MedicalExaminationRecordEntity> findByAccidentalSubType(@NotNull String accidentalSubType);
	/**
	 * Return an entity or a list of entities that have the given attribute Additional Notes.
	 *
	 * @param additionalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Additional Notes
	 */
	List<MedicalExaminationRecordEntity> findByAdditionalNotes(@NotNull String additionalNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Dental Procedure.
	 *
	 * @param dentalProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dental Procedure
	 */
	List<MedicalExaminationRecordEntity> findByDentalProcedure(@NotNull String dentalProcedure);
	/**
	 * Return an entity or a list of entities that have the given attribute Psychiatry Case.
	 *
	 * @param psychiatryCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Psychiatry Case
	 */
	List<MedicalExaminationRecordEntity> findByPsychiatryCase(@NotNull String psychiatryCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Therapy.
	 *
	 * @param therapy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Therapy
	 */
	List<MedicalExaminationRecordEntity> findByTherapy(@NotNull String therapy);
	/**
	 * Return an entity or a list of entities that have the given attribute Family Planning.
	 *
	 * @param familyPlanning the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Family Planning
	 */
	List<MedicalExaminationRecordEntity> findByFamilyPlanning(@NotNull Boolean familyPlanning);
	/**
	 * Return an entity or a list of entities that have the given attribute Condition.
	 *
	 * @param condition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Condition
	 */
	List<MedicalExaminationRecordEntity> findByCondition(@NotNull String condition);
	/**
	 * Return an entity or a list of entities that have the given attribute Family Planning Case.
	 *
	 * @param familyPlanningCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Family Planning Case
	 */
	List<MedicalExaminationRecordEntity> findByFamilyPlanningCase(@NotNull String familyPlanningCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Previous Contraceptive Method.
	 *
	 * @param previousContraceptiveMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Previous Contraceptive Method
	 */
	List<MedicalExaminationRecordEntity> findByPreviousContraceptiveMethod(@NotNull String previousContraceptiveMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Side Effects.
	 *
	 * @param sideEffects the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Side Effects
	 */
	List<MedicalExaminationRecordEntity> findBySideEffects(@NotNull String sideEffects);
	/**
	 * Return an entity or a list of entities that have the given attribute Complication.
	 *
	 * @param complication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Complication
	 */
	List<MedicalExaminationRecordEntity> findByComplication(@NotNull String complication);
	/**
	 * Return an entity or a list of entities that have the given attribute Contraseptive Method.
	 *
	 * @param contraseptiveMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contraseptive Method
	 */
	List<MedicalExaminationRecordEntity> findByContraseptiveMethod(@NotNull String contraseptiveMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Visit Type.
	 *
	 * @param visitType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Type
	 */
	List<MedicalExaminationRecordEntity> findByVisitType(@NotNull String visitType);
	/**
	 * Return an entity or a list of entities that have the given attribute Hearing Test Method.
	 *
	 * @param hearingTestMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hearing Test Method
	 */
	List<MedicalExaminationRecordEntity> findByHearingTestMethod(@NotNull String hearingTestMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Hearing Test Notes.
	 *
	 * @param hearingTestNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hearing Test Notes
	 */
	List<MedicalExaminationRecordEntity> findByHearingTestNotes(@NotNull String hearingTestNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Hearing Loss Category.
	 *
	 * @param hearingLossCategory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hearing Loss Category
	 */
	List<MedicalExaminationRecordEntity> findByHearingLossCategory(@NotNull String hearingLossCategory);
	/**
	 * Return an entity or a list of entities that have the given attribute Hearing Loss Notes.
	 *
	 * @param hearingLossNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hearing Loss Notes
	 */
	List<MedicalExaminationRecordEntity> findByHearingLossNotes(@NotNull String hearingLossNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Eye Position Right Eye.
	 *
	 * @param eyePositionRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Eye Position Right Eye
	 */
	List<MedicalExaminationRecordEntity> findByEyePositionRightEye(@NotNull String eyePositionRightEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Eye Position Left Eye.
	 *
	 * @param eyePositionLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Eye Position Left Eye
	 */
	List<MedicalExaminationRecordEntity> findByEyePositionLeftEye(@NotNull String eyePositionLeftEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Muscle Balance Right Eye.
	 *
	 * @param muscleBalanceRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Muscle Balance Right Eye
	 */
	List<MedicalExaminationRecordEntity> findByMuscleBalanceRightEye(@NotNull String muscleBalanceRightEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Muscle Balance Left Eye.
	 *
	 * @param muscleBalanceLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Muscle Balance Left Eye
	 */
	List<MedicalExaminationRecordEntity> findByMuscleBalanceLeftEye(@NotNull String muscleBalanceLeftEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Visual Field Right Eye.
	 *
	 * @param visualFieldRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visual Field Right Eye
	 */
	List<MedicalExaminationRecordEntity> findByVisualFieldRightEye(@NotNull String visualFieldRightEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Visual Field Left Eye.
	 *
	 * @param visualFieldLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visual Field Left Eye
	 */
	List<MedicalExaminationRecordEntity> findByVisualFieldLeftEye(@NotNull String visualFieldLeftEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Ocular Funduscopy Right Eye.
	 *
	 * @param ocularFunduscopyRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ocular Funduscopy Right Eye
	 */
	List<MedicalExaminationRecordEntity> findByOcularFunduscopyRightEye(@NotNull String ocularFunduscopyRightEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Ocular Funduscopy Left Eye.
	 *
	 * @param ocularFunduscopyLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ocular Funduscopy Left Eye
	 */
	List<MedicalExaminationRecordEntity> findByOcularFunduscopyLeftEye(@NotNull String ocularFunduscopyLeftEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Intraocular Pressure Right Eye.
	 *
	 * @param intraocularPressureRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intraocular Pressure Right Eye
	 */
	List<MedicalExaminationRecordEntity> findByIntraocularPressureRightEye(@NotNull String intraocularPressureRightEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Intraocular Pressure Left Eye.
	 *
	 * @param intraocularPressureLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intraocular Pressure Left Eye
	 */
	List<MedicalExaminationRecordEntity> findByIntraocularPressureLeftEye(@NotNull String intraocularPressureLeftEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Color Blindness.
	 *
	 * @param colorBlindness the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Color Blindness
	 */
	List<MedicalExaminationRecordEntity> findByColorBlindness(@NotNull String colorBlindness);
	/**
	 * Return an entity or a list of entities that have the given attribute Visual Acuity Right Eye.
	 *
	 * @param visualAcuityRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visual Acuity Right Eye
	 */
	List<MedicalExaminationRecordEntity> findByVisualAcuityRightEye(@NotNull String visualAcuityRightEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Visual Acuity Left Eye.
	 *
	 * @param visualAcuityLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visual Acuity Left Eye
	 */
	List<MedicalExaminationRecordEntity> findByVisualAcuityLeftEye(@NotNull String visualAcuityLeftEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Correction Right Eye.
	 *
	 * @param correctionRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Correction Right Eye
	 */
	List<MedicalExaminationRecordEntity> findByCorrectionRightEye(@NotNull String correctionRightEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Correction Left Eye.
	 *
	 * @param correctionLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Correction Left Eye
	 */
	List<MedicalExaminationRecordEntity> findByCorrectionLeftEye(@NotNull String correctionLeftEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Addition Right Eye.
	 *
	 * @param additionRightEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Addition Right Eye
	 */
	List<MedicalExaminationRecordEntity> findByAdditionRightEye(@NotNull String additionRightEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Addition Left Eye.
	 *
	 * @param additionLeftEye the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Addition Left Eye
	 */
	List<MedicalExaminationRecordEntity> findByAdditionLeftEye(@NotNull String additionLeftEye);
	/**
	 * Return an entity or a list of entities that have the given attribute Occlusion.
	 *
	 * @param occlusion the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Occlusion
	 */
	List<MedicalExaminationRecordEntity> findByOcclusion(@NotNull String occlusion);
	/**
	 * Return an entity or a list of entities that have the given attribute Torus Palatinus.
	 *
	 * @param torusPalatinus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Torus Palatinus
	 */
	List<MedicalExaminationRecordEntity> findByTorusPalatinus(@NotNull String torusPalatinus);
	/**
	 * Return an entity or a list of entities that have the given attribute Torus Mandibularis.
	 *
	 * @param torusMandibularis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Torus Mandibularis
	 */
	List<MedicalExaminationRecordEntity> findByTorusMandibularis(@NotNull String torusMandibularis);
	/**
	 * Return an entity or a list of entities that have the given attribute Palatum.
	 *
	 * @param palatum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Palatum
	 */
	List<MedicalExaminationRecordEntity> findByPalatum(@NotNull String palatum);
	/**
	 * Return an entity or a list of entities that have the given attribute Diastema.
	 *
	 * @param diastema the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastema
	 */
	List<MedicalExaminationRecordEntity> findByDiastema(@NotNull Boolean diastema);
	/**
	 * Return an entity or a list of entities that have the given attribute Diastema Notes.
	 *
	 * @param diastemaNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastema Notes
	 */
	List<MedicalExaminationRecordEntity> findByDiastemaNotes(@NotNull String diastemaNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Tooth Anomaly.
	 *
	 * @param toothAnomaly the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tooth Anomaly
	 */
	List<MedicalExaminationRecordEntity> findByToothAnomaly(@NotNull Boolean toothAnomaly);
	/**
	 * Return an entity or a list of entities that have the given attribute Tooth Anomaly Notes.
	 *
	 * @param toothAnomalyNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tooth Anomaly Notes
	 */
	List<MedicalExaminationRecordEntity> findByToothAnomalyNotes(@NotNull String toothAnomalyNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Dental Notes.
	 *
	 * @param otherDentalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Dental Notes
	 */
	List<MedicalExaminationRecordEntity> findByOtherDentalNotes(@NotNull String otherDentalNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Decayed.
	 *
	 * @param decayed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Decayed
	 */
	List<MedicalExaminationRecordEntity> findByDecayed(@NotNull String decayed);
	/**
	 * Return an entity or a list of entities that have the given attribute Missing.
	 *
	 * @param missing the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Missing
	 */
	List<MedicalExaminationRecordEntity> findByMissing(@NotNull String missing);
	/**
	 * Return an entity or a list of entities that have the given attribute Filled.
	 *
	 * @param filled the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Filled
	 */
	List<MedicalExaminationRecordEntity> findByFilled(@NotNull String filled);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Photograph.
	 *
	 * @param totalPhotograph the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Photograph
	 */
	List<MedicalExaminationRecordEntity> findByTotalPhotograph(@NotNull String totalPhotograph);
	/**
	 * Return an entity or a list of entities that have the given attribute Photograph Type.
	 *
	 * @param photographType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Photograph Type
	 */
	List<MedicalExaminationRecordEntity> findByPhotographType(@NotNull String photographType);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Rontgen Photograph.
	 *
	 * @param totalRontgenPhotograph the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Rontgen Photograph
	 */
	List<MedicalExaminationRecordEntity> findByTotalRontgenPhotograph(@NotNull String totalRontgenPhotograph);
	/**
	 * Return an entity or a list of entities that have the given attribute Rontgen Photograph Type.
	 *
	 * @param rontgenPhotographType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rontgen Photograph Type
	 */
	List<MedicalExaminationRecordEntity> findByRontgenPhotographType(@NotNull String rontgenPhotographType);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicalExaminationRecordEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicalExaminationRecordEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}