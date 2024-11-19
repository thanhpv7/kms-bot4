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

import kmsweb.entities.HemodialysisExaminationEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface HemodialysisExaminationRepository extends AbstractRepository<HemodialysisExaminationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute First Dialysis.
	 *
	 * @param firstDialysis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Dialysis
	 */
	List<HemodialysisExaminationEntity> findByFirstDialysis(@NotNull OffsetDateTime firstDialysis);
	/**
	 * Return an entity or a list of entities that have the given attribute Dialysis Frequency.
	 *
	 * @param dialysisFrequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialysis Frequency
	 */
	List<HemodialysisExaminationEntity> findByDialysisFrequency(@NotNull String dialysisFrequency);
	/**
	 * Return an entity or a list of entities that have the given attribute Dialysis No.
	 *
	 * @param dialysisNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialysis No
	 */
	List<HemodialysisExaminationEntity> findByDialysisNo(@NotNull String dialysisNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Hemodialysis Type.
	 *
	 * @param hemodialysisType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemodialysis Type
	 */
	List<HemodialysisExaminationEntity> findByHemodialysisType(@NotNull String hemodialysisType);
	/**
	 * Return an entity or a list of entities that have the given attribute Condition.
	 *
	 * @param condition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Condition
	 */
	List<HemodialysisExaminationEntity> findByCondition(@NotNull String condition);
	/**
	 * Return an entity or a list of entities that have the given attribute Vascular Access.
	 *
	 * @param vascularAccess the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vascular Access
	 */
	List<HemodialysisExaminationEntity> findByVascularAccess(@NotNull String vascularAccess);
	/**
	 * Return an entity or a list of entities that have the given attribute Heparinization.
	 *
	 * @param heparinization the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Heparinization
	 */
	List<HemodialysisExaminationEntity> findByHeparinization(@NotNull String heparinization);
	/**
	 * Return an entity or a list of entities that have the given attribute Heparinization Initial Dose.
	 *
	 * @param heparinizationInitialDose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Heparinization Initial Dose
	 */
	List<HemodialysisExaminationEntity> findByHeparinizationInitialDose(@NotNull String heparinizationInitialDose);
	/**
	 * Return an entity or a list of entities that have the given attribute Heparinization Follow Up Dose.
	 *
	 * @param heparinizationFollowUpDose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Heparinization Follow Up Dose
	 */
	List<HemodialysisExaminationEntity> findByHeparinizationFollowUpDose(@NotNull String heparinizationFollowUpDose);
	/**
	 * Return an entity or a list of entities that have the given attribute Dialyzer.
	 *
	 * @param dialyzer the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialyzer
	 */
	List<HemodialysisExaminationEntity> findByDialyzer(@NotNull String dialyzer);
	/**
	 * Return an entity or a list of entities that have the given attribute Dialyzer Type.
	 *
	 * @param dialyzerType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialyzer Type
	 */
	List<HemodialysisExaminationEntity> findByDialyzerType(@NotNull String dialyzerType);
	/**
	 * Return an entity or a list of entities that have the given attribute Dialysis Fluid.
	 *
	 * @param dialysisFluid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialysis Fluid
	 */
	List<HemodialysisExaminationEntity> findByDialysisFluid(@NotNull String dialysisFluid);
	/**
	 * Return an entity or a list of entities that have the given attribute Dry Weight.
	 *
	 * @param dryWeight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dry Weight
	 */
	List<HemodialysisExaminationEntity> findByDryWeight(@NotNull Double dryWeight);
	/**
	 * Return an entity or a list of entities that have the given attribute Dry Weight Unit.
	 *
	 * @param dryWeightUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dry Weight Unit
	 */
	List<HemodialysisExaminationEntity> findByDryWeightUnit(@NotNull String dryWeightUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Upon Arrival.
	 *
	 * @param weightUponArrival the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Upon Arrival
	 */
	List<HemodialysisExaminationEntity> findByWeightUponArrival(@NotNull Double weightUponArrival);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Upon Arrival Unit.
	 *
	 * @param weightUponArrivalUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Upon Arrival Unit
	 */
	List<HemodialysisExaminationEntity> findByWeightUponArrivalUnit(@NotNull String weightUponArrivalUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight During Previous Hemodialysis.
	 *
	 * @param weightDuringPreviousHemodialysis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight During Previous Hemodialysis
	 */
	List<HemodialysisExaminationEntity> findByWeightDuringPreviousHemodialysis(@NotNull Double weightDuringPreviousHemodialysis);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight During Previous Hemodialysis Unit.
	 *
	 * @param weightDuringPreviousHemodialysisUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight During Previous Hemodialysis Unit
	 */
	List<HemodialysisExaminationEntity> findByWeightDuringPreviousHemodialysisUnit(@NotNull String weightDuringPreviousHemodialysisUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Anti HIV.
	 *
	 * @param antiHIV the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anti HIV
	 */
	List<HemodialysisExaminationEntity> findByAntiHIV(@NotNull Boolean antiHIV);
	/**
	 * Return an entity or a list of entities that have the given attribute HbsAg.
	 *
	 * @param hbsag the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HbsAg
	 */
	List<HemodialysisExaminationEntity> findByHbsag(@NotNull Boolean hbsag);
	/**
	 * Return an entity or a list of entities that have the given attribute Anti HCV.
	 *
	 * @param antiHCV the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anti HCV
	 */
	List<HemodialysisExaminationEntity> findByAntiHCV(@NotNull Boolean antiHCV);
	/**
	 * Return an entity or a list of entities that have the given attribute Hemodialysis Start Time.
	 *
	 * @param hemodialysisStartTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemodialysis Start Time
	 */
	List<HemodialysisExaminationEntity> findByHemodialysisStartTime(@NotNull OffsetDateTime hemodialysisStartTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Hemodialysis End Time.
	 *
	 * @param hemodialysisEndTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemodialysis End Time
	 */
	List<HemodialysisExaminationEntity> findByHemodialysisEndTime(@NotNull OffsetDateTime hemodialysisEndTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Target.
	 *
	 * @param target the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Target
	 */
	List<HemodialysisExaminationEntity> findByTarget(@NotNull String target);
	/**
	 * Return an entity or a list of entities that have the given attribute Priming Volume.
	 *
	 * @param primingVolume the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Priming Volume
	 */
	List<HemodialysisExaminationEntity> findByPrimingVolume(@NotNull String primingVolume);
	/**
	 * Return an entity or a list of entities that have the given attribute Remaining Priming.
	 *
	 * @param remainingPriming the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Remaining Priming
	 */
	List<HemodialysisExaminationEntity> findByRemainingPriming(@NotNull String remainingPriming);
	/**
	 * Return an entity or a list of entities that have the given attribute Complication.
	 *
	 * @param complication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Complication
	 */
	List<HemodialysisExaminationEntity> findByComplication(@NotNull String complication);
	/**
	 * Return an entity or a list of entities that have the given attribute Hemodialysis Details.
	 *
	 * @param hemodialysisDetails the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemodialysis Details
	 */
	List<HemodialysisExaminationEntity> findByHemodialysisDetails(@NotNull String hemodialysisDetails);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Upon Dismissal.
	 *
	 * @param weightUponDismissal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Upon Dismissal
	 */
	List<HemodialysisExaminationEntity> findByWeightUponDismissal(@NotNull Double weightUponDismissal);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Upon Dismissal Unit.
	 *
	 * @param weightUponDismissalUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Upon Dismissal Unit
	 */
	List<HemodialysisExaminationEntity> findByWeightUponDismissalUnit(@NotNull String weightUponDismissalUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Priming.
	 *
	 * @param priming the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Priming
	 */
	List<HemodialysisExaminationEntity> findByPriming(@NotNull Double priming);
	/**
	 * Return an entity or a list of entities that have the given attribute Blood.
	 *
	 * @param blood the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Blood
	 */
	List<HemodialysisExaminationEntity> findByBlood(@NotNull Double blood);
	/**
	 * Return an entity or a list of entities that have the given attribute IV Line.
	 *
	 * @param ivLine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute IV Line
	 */
	List<HemodialysisExaminationEntity> findByIvLine(@NotNull Double ivLine);
	/**
	 * Return an entity or a list of entities that have the given attribute Oral.
	 *
	 * @param oral the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Oral
	 */
	List<HemodialysisExaminationEntity> findByOral(@NotNull Double oral);
	/**
	 * Return an entity or a list of entities that have the given attribute Wash Out.
	 *
	 * @param washOut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Wash Out
	 */
	List<HemodialysisExaminationEntity> findByWashOut(@NotNull Double washOut);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Fluid Intake.
	 *
	 * @param totalFluidIntake the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Fluid Intake
	 */
	List<HemodialysisExaminationEntity> findByTotalFluidIntake(@NotNull Double totalFluidIntake);
	/**
	 * Return an entity or a list of entities that have the given attribute Urine.
	 *
	 * @param urine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Urine
	 */
	List<HemodialysisExaminationEntity> findByUrine(@NotNull Double urine);
	/**
	 * Return an entity or a list of entities that have the given attribute Others.
	 *
	 * @param others the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Others
	 */
	List<HemodialysisExaminationEntity> findByOthers(@NotNull Double others);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Fluid Output.
	 *
	 * @param totalFluidOutput the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Fluid Output
	 */
	List<HemodialysisExaminationEntity> findByTotalFluidOutput(@NotNull Double totalFluidOutput);
	/**
	 * Return an entity or a list of entities that have the given attribute Fluid Balance.
	 *
	 * @param fluidBalance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fluid Balance
	 */
	List<HemodialysisExaminationEntity> findByFluidBalance(@NotNull Double fluidBalance);
	/**
	 * Return an entity or a list of entities that have the given attribute Post Hemodialysis Evaluation.
	 *
	 * @param postHemodialysisEvaluation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Post Hemodialysis Evaluation
	 */
	List<HemodialysisExaminationEntity> findByPostHemodialysisEvaluation(@NotNull String postHemodialysisEvaluation);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HemodialysisExaminationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HemodialysisExaminationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}