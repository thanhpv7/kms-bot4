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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for Medical Examination Record used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalExaminationRecordModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalExaminationRecordModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalExaminationRecordModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalExaminationRecordEntityFactory medicalExaminationRecordEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalExaminationRecordEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalExaminationRecordEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalExaminationRecordEntityFactory");

		// % protected region % [Apply any additional logic for medicalExaminationRecordEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordEntityFactory before the main body here] end

		MedicalExaminationRecordEntityFactory entityFactory = new MedicalExaminationRecordEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalExaminationRecordEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalExaminationRecordEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalExaminationRecordEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordEntityFactory after the main body here] end

		log.trace("Created MedicalExaminationRecordEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Examination Record entity with no references set.
	 */
	@Provides
	@Named("medicalExaminationRecordEntityWithNoRef")
	public MedicalExaminationRecordEntity medicalExaminationRecordEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for medicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordWithNoRef before the main body here] end

		MedicalExaminationRecordEntity newEntity = new MedicalExaminationRecordEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mock.ints().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mock.ints().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Pulse here] off begin
		newEntity.setPulse(mock.ints().get());
		// % protected region % [Add customisation for Pulse here] end
		// % protected region % [Add customisation for BP Standing Systole here] off begin
		newEntity.setBpStandingSystole(mock.ints().get());
		// % protected region % [Add customisation for BP Standing Systole here] end
		// % protected region % [Add customisation for BP Standing Diastole here] off begin
		newEntity.setBpStandingDiastole(mock.ints().get());
		// % protected region % [Add customisation for BP Standing Diastole here] end
		// % protected region % [Add customisation for Pulse Regularity here] off begin
		String randomStringforPulseRegularity = mock
				.strings()
				.get();
		newEntity.setPulseRegularity(randomStringforPulseRegularity);
		// % protected region % [Add customisation for Pulse Regularity here] end
		// % protected region % [Add customisation for Pulse Strength here] off begin
		String randomStringforPulseStrength = mock
				.strings()
				.get();
		newEntity.setPulseStrength(randomStringforPulseStrength);
		// % protected region % [Add customisation for Pulse Strength here] end
		// % protected region % [Add customisation for Temperature here] off begin
		newEntity.setTemperature(mock.doubles().get());
		// % protected region % [Add customisation for Temperature here] end
		// % protected region % [Add customisation for Temperature scale here] off begin
		String randomStringforTemperatureScale = mock
				.strings()
				.get();
		newEntity.setTemperatureScale(randomStringforTemperatureScale);
		// % protected region % [Add customisation for Temperature scale here] end
		// % protected region % [Add customisation for GCS Eyes here] off begin
		String randomStringforGcsEyes = mock
				.strings()
				.get();
		newEntity.setGcsEyes(randomStringforGcsEyes);
		// % protected region % [Add customisation for GCS Eyes here] end
		// % protected region % [Add customisation for GCS Verbal here] off begin
		String randomStringforGcsVerbal = mock
				.strings()
				.get();
		newEntity.setGcsVerbal(randomStringforGcsVerbal);
		// % protected region % [Add customisation for GCS Verbal here] end
		// % protected region % [Add customisation for GCS Motor here] off begin
		String randomStringforGcsMotor = mock
				.strings()
				.get();
		newEntity.setGcsMotor(randomStringforGcsMotor);
		// % protected region % [Add customisation for GCS Motor here] end
		// % protected region % [Add customisation for Total GCS Score here] off begin
		newEntity.setTotalGCSScore(mock.doubles().get());
		// % protected region % [Add customisation for Total GCS Score here] end
		// % protected region % [Add customisation for Consciousness here] off begin
		String randomStringforConsciousness = mock
				.strings()
				.get();
		newEntity.setConsciousness(randomStringforConsciousness);
		// % protected region % [Add customisation for Consciousness here] end
		// % protected region % [Add customisation for Height here] off begin
		newEntity.setHeight(mock.doubles().get());
		// % protected region % [Add customisation for Height here] end
		// % protected region % [Add customisation for Height Scale here] off begin
		String randomStringforHeightScale = mock
				.strings()
				.get();
		newEntity.setHeightScale(randomStringforHeightScale);
		// % protected region % [Add customisation for Height Scale here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mock.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Weight Scale here] off begin
		String randomStringforWeightScale = mock
				.strings()
				.get();
		newEntity.setWeightScale(randomStringforWeightScale);
		// % protected region % [Add customisation for Weight Scale here] end
		// % protected region % [Add customisation for BMI here] off begin
		newEntity.setBmi(mock.doubles().get());
		// % protected region % [Add customisation for BMI here] end
		// % protected region % [Add customisation for Respiratory here] off begin
		newEntity.setRespiratory(mock.doubles().get());
		// % protected region % [Add customisation for Respiratory here] end
		// % protected region % [Add customisation for Oxygen Saturation here] off begin
		newEntity.setOxygenSaturation(mock.doubles().get());
		// % protected region % [Add customisation for Oxygen Saturation here] end
		// % protected region % [Add customisation for Waist Circumference here] off begin
		newEntity.setWaistCircumference(mock.doubles().get());
		// % protected region % [Add customisation for Waist Circumference here] end
		// % protected region % [Add customisation for Waist Circumference Unit here] off begin
		String randomStringforWaistCircumferenceUnit = mock
				.strings()
				.get();
		newEntity.setWaistCircumferenceUnit(randomStringforWaistCircumferenceUnit);
		// % protected region % [Add customisation for Waist Circumference Unit here] end
		// % protected region % [Add customisation for Nutrition Status here] off begin
		String randomStringforNutritionStatus = mock
				.strings()
				.get();
		newEntity.setNutritionStatus(randomStringforNutritionStatus);
		// % protected region % [Add customisation for Nutrition Status here] end
		// % protected region % [Add customisation for Pain Scale here] off begin
		newEntity.setPainScale(mock.ints().get());
		// % protected region % [Add customisation for Pain Scale here] end
		// % protected region % [Add customisation for Pain Scale Used here] off begin
		String randomStringforPainScaleUsed = mock
				.strings()
				.get();
		newEntity.setPainScaleUsed(randomStringforPainScaleUsed);
		// % protected region % [Add customisation for Pain Scale Used here] end
		// % protected region % [Add customisation for Risk Fall Scale here] off begin
		newEntity.setRiskFallScale(mock.ints().get());
		// % protected region % [Add customisation for Risk Fall Scale here] end
		// % protected region % [Add customisation for Objective here] off begin
		String randomStringforObjective = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setObjective(randomStringforObjective);
		// % protected region % [Add customisation for Objective here] end
		// % protected region % [Add customisation for Risk Fall Scale Used here] off begin
		String randomStringforRiskFallScaleUsed = mock
				.strings()
				.get();
		newEntity.setRiskFallScaleUsed(randomStringforRiskFallScaleUsed);
		// % protected region % [Add customisation for Risk Fall Scale Used here] end
		// % protected region % [Add customisation for Subjective here] off begin
		String randomStringforSubjective = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setSubjective(randomStringforSubjective);
		// % protected region % [Add customisation for Subjective here] end
		// % protected region % [Add customisation for Plan here] off begin
		String randomStringforPlan = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setPlan(randomStringforPlan);
		// % protected region % [Add customisation for Plan here] end
		// % protected region % [Add customisation for Purpose here] off begin
		String randomStringforPurpose = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setPurpose(randomStringforPurpose);
		// % protected region % [Add customisation for Purpose here] end
		// % protected region % [Add customisation for Examination Sub Case here] off begin
		String randomStringforExaminationSubCase = mock
				.strings()
				.get();
		newEntity.setExaminationSubCase(randomStringforExaminationSubCase);
		// % protected region % [Add customisation for Examination Sub Case here] end
		// % protected region % [Add customisation for Accidental Type here] off begin
		String randomStringforAccidentalType = mock
				.strings()
				.get();
		newEntity.setAccidentalType(randomStringforAccidentalType);
		// % protected region % [Add customisation for Accidental Type here] end
		// % protected region % [Add customisation for Service Case here] off begin
		String randomStringforServiceCase = mock
				.strings()
				.get();
		newEntity.setServiceCase(randomStringforServiceCase);
		// % protected region % [Add customisation for Service Case here] end
		// % protected region % [Add customisation for Accidental Sub Type here] off begin
		String randomStringforAccidentalSubType = mock
				.strings()
				.get();
		newEntity.setAccidentalSubType(randomStringforAccidentalSubType);
		// % protected region % [Add customisation for Accidental Sub Type here] end
		// % protected region % [Add customisation for Additional Notes here] off begin
		String randomStringforAdditionalNotes = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setAdditionalNotes(randomStringforAdditionalNotes);
		// % protected region % [Add customisation for Additional Notes here] end
		// % protected region % [Add customisation for Dental Procedure here] off begin
		String randomStringforDentalProcedure = mock
				.strings()
				.get();
		newEntity.setDentalProcedure(randomStringforDentalProcedure);
		// % protected region % [Add customisation for Dental Procedure here] end
		// % protected region % [Add customisation for Psychiatry Case here] off begin
		String randomStringforPsychiatryCase = mock
				.strings()
				.get();
		newEntity.setPsychiatryCase(randomStringforPsychiatryCase);
		// % protected region % [Add customisation for Psychiatry Case here] end
		// % protected region % [Add customisation for Therapy here] off begin
		String randomStringforTherapy = mock
				.strings()
				.get();
		newEntity.setTherapy(randomStringforTherapy);
		// % protected region % [Add customisation for Therapy here] end
		// % protected region % [Add customisation for Family Planning here] off begin
		newEntity.setFamilyPlanning(mock.bools().get());
		// % protected region % [Add customisation for Family Planning here] end
		// % protected region % [Add customisation for Condition here] off begin
		String randomStringforCondition = mock
				.strings()
				.get();
		newEntity.setCondition(randomStringforCondition);
		// % protected region % [Add customisation for Condition here] end
		// % protected region % [Add customisation for Family Planning Case here] off begin
		String randomStringforFamilyPlanningCase = mock
				.strings()
				.get();
		newEntity.setFamilyPlanningCase(randomStringforFamilyPlanningCase);
		// % protected region % [Add customisation for Family Planning Case here] end
		// % protected region % [Add customisation for Previous Contraceptive Method here] off begin
		String randomStringforPreviousContraceptiveMethod = mock
				.strings()
				.get();
		newEntity.setPreviousContraceptiveMethod(randomStringforPreviousContraceptiveMethod);
		// % protected region % [Add customisation for Previous Contraceptive Method here] end
		// % protected region % [Add customisation for Side Effects here] off begin
		String randomStringforSideEffects = mock
				.strings()
				.get();
		newEntity.setSideEffects(randomStringforSideEffects);
		// % protected region % [Add customisation for Side Effects here] end
		// % protected region % [Add customisation for Complication here] off begin
		String randomStringforComplication = mock
				.strings()
				.get();
		newEntity.setComplication(randomStringforComplication);
		// % protected region % [Add customisation for Complication here] end
		// % protected region % [Add customisation for Contraseptive Method here] off begin
		String randomStringforContraseptiveMethod = mock
				.strings()
				.get();
		newEntity.setContraseptiveMethod(randomStringforContraseptiveMethod);
		// % protected region % [Add customisation for Contraseptive Method here] end
		// % protected region % [Add customisation for Visit Type here] off begin
		String randomStringforVisitType = mock
				.strings()
				.get();
		newEntity.setVisitType(randomStringforVisitType);
		// % protected region % [Add customisation for Visit Type here] end
		// % protected region % [Add customisation for Hearing Test Method here] off begin
		String randomStringforHearingTestMethod = mock
				.strings()
				.get();
		newEntity.setHearingTestMethod(randomStringforHearingTestMethod);
		// % protected region % [Add customisation for Hearing Test Method here] end
		// % protected region % [Add customisation for Hearing Test Notes here] off begin
		String randomStringforHearingTestNotes = mock
				.strings()
				.get();
		newEntity.setHearingTestNotes(randomStringforHearingTestNotes);
		// % protected region % [Add customisation for Hearing Test Notes here] end
		// % protected region % [Add customisation for Hearing Loss Category here] off begin
		String randomStringforHearingLossCategory = mock
				.strings()
				.get();
		newEntity.setHearingLossCategory(randomStringforHearingLossCategory);
		// % protected region % [Add customisation for Hearing Loss Category here] end
		// % protected region % [Add customisation for Hearing Loss Notes here] off begin
		String randomStringforHearingLossNotes = mock
				.strings()
				.get();
		newEntity.setHearingLossNotes(randomStringforHearingLossNotes);
		// % protected region % [Add customisation for Hearing Loss Notes here] end
		// % protected region % [Add customisation for Eye Position Right Eye here] off begin
		String randomStringforEyePositionRightEye = mock
				.strings()
				.get();
		newEntity.setEyePositionRightEye(randomStringforEyePositionRightEye);
		// % protected region % [Add customisation for Eye Position Right Eye here] end
		// % protected region % [Add customisation for Eye Position Left Eye here] off begin
		String randomStringforEyePositionLeftEye = mock
				.strings()
				.get();
		newEntity.setEyePositionLeftEye(randomStringforEyePositionLeftEye);
		// % protected region % [Add customisation for Eye Position Left Eye here] end
		// % protected region % [Add customisation for Muscle Balance Right Eye here] off begin
		String randomStringforMuscleBalanceRightEye = mock
				.strings()
				.get();
		newEntity.setMuscleBalanceRightEye(randomStringforMuscleBalanceRightEye);
		// % protected region % [Add customisation for Muscle Balance Right Eye here] end
		// % protected region % [Add customisation for Muscle Balance Left Eye here] off begin
		String randomStringforMuscleBalanceLeftEye = mock
				.strings()
				.get();
		newEntity.setMuscleBalanceLeftEye(randomStringforMuscleBalanceLeftEye);
		// % protected region % [Add customisation for Muscle Balance Left Eye here] end
		// % protected region % [Add customisation for Visual Field Right Eye here] off begin
		String randomStringforVisualFieldRightEye = mock
				.strings()
				.get();
		newEntity.setVisualFieldRightEye(randomStringforVisualFieldRightEye);
		// % protected region % [Add customisation for Visual Field Right Eye here] end
		// % protected region % [Add customisation for Visual Field Left Eye here] off begin
		String randomStringforVisualFieldLeftEye = mock
				.strings()
				.get();
		newEntity.setVisualFieldLeftEye(randomStringforVisualFieldLeftEye);
		// % protected region % [Add customisation for Visual Field Left Eye here] end
		// % protected region % [Add customisation for Ocular Funduscopy Right Eye here] off begin
		String randomStringforOcularFunduscopyRightEye = mock
				.strings()
				.get();
		newEntity.setOcularFunduscopyRightEye(randomStringforOcularFunduscopyRightEye);
		// % protected region % [Add customisation for Ocular Funduscopy Right Eye here] end
		// % protected region % [Add customisation for Ocular Funduscopy Left Eye here] off begin
		String randomStringforOcularFunduscopyLeftEye = mock
				.strings()
				.get();
		newEntity.setOcularFunduscopyLeftEye(randomStringforOcularFunduscopyLeftEye);
		// % protected region % [Add customisation for Ocular Funduscopy Left Eye here] end
		// % protected region % [Add customisation for Intraocular Pressure Right Eye here] off begin
		String randomStringforIntraocularPressureRightEye = mock
				.strings()
				.get();
		newEntity.setIntraocularPressureRightEye(randomStringforIntraocularPressureRightEye);
		// % protected region % [Add customisation for Intraocular Pressure Right Eye here] end
		// % protected region % [Add customisation for Intraocular Pressure Left Eye here] off begin
		String randomStringforIntraocularPressureLeftEye = mock
				.strings()
				.get();
		newEntity.setIntraocularPressureLeftEye(randomStringforIntraocularPressureLeftEye);
		// % protected region % [Add customisation for Intraocular Pressure Left Eye here] end
		// % protected region % [Add customisation for Color Blindness here] off begin
		String randomStringforColorBlindness = mock
				.strings()
				.get();
		newEntity.setColorBlindness(randomStringforColorBlindness);
		// % protected region % [Add customisation for Color Blindness here] end
		// % protected region % [Add customisation for Visual Acuity Right Eye here] off begin
		String randomStringforVisualAcuityRightEye = mock
				.strings()
				.get();
		newEntity.setVisualAcuityRightEye(randomStringforVisualAcuityRightEye);
		// % protected region % [Add customisation for Visual Acuity Right Eye here] end
		// % protected region % [Add customisation for Visual Acuity Left Eye here] off begin
		String randomStringforVisualAcuityLeftEye = mock
				.strings()
				.get();
		newEntity.setVisualAcuityLeftEye(randomStringforVisualAcuityLeftEye);
		// % protected region % [Add customisation for Visual Acuity Left Eye here] end
		// % protected region % [Add customisation for Correction Right Eye here] off begin
		String randomStringforCorrectionRightEye = mock
				.strings()
				.get();
		newEntity.setCorrectionRightEye(randomStringforCorrectionRightEye);
		// % protected region % [Add customisation for Correction Right Eye here] end
		// % protected region % [Add customisation for Correction Left Eye here] off begin
		String randomStringforCorrectionLeftEye = mock
				.strings()
				.get();
		newEntity.setCorrectionLeftEye(randomStringforCorrectionLeftEye);
		// % protected region % [Add customisation for Correction Left Eye here] end
		// % protected region % [Add customisation for Addition Right Eye here] off begin
		String randomStringforAdditionRightEye = mock
				.strings()
				.get();
		newEntity.setAdditionRightEye(randomStringforAdditionRightEye);
		// % protected region % [Add customisation for Addition Right Eye here] end
		// % protected region % [Add customisation for Addition Left Eye here] off begin
		String randomStringforAdditionLeftEye = mock
				.strings()
				.get();
		newEntity.setAdditionLeftEye(randomStringforAdditionLeftEye);
		// % protected region % [Add customisation for Addition Left Eye here] end
		// % protected region % [Add customisation for Occlusion here] off begin
		String randomStringforOcclusion = mock
				.strings()
				.get();
		newEntity.setOcclusion(randomStringforOcclusion);
		// % protected region % [Add customisation for Occlusion here] end
		// % protected region % [Add customisation for Torus Palatinus here] off begin
		String randomStringforTorusPalatinus = mock
				.strings()
				.get();
		newEntity.setTorusPalatinus(randomStringforTorusPalatinus);
		// % protected region % [Add customisation for Torus Palatinus here] end
		// % protected region % [Add customisation for Torus Mandibularis here] off begin
		String randomStringforTorusMandibularis = mock
				.strings()
				.get();
		newEntity.setTorusMandibularis(randomStringforTorusMandibularis);
		// % protected region % [Add customisation for Torus Mandibularis here] end
		// % protected region % [Add customisation for Palatum here] off begin
		String randomStringforPalatum = mock
				.strings()
				.get();
		newEntity.setPalatum(randomStringforPalatum);
		// % protected region % [Add customisation for Palatum here] end
		// % protected region % [Add customisation for Diastema here] off begin
		newEntity.setDiastema(mock.bools().get());
		// % protected region % [Add customisation for Diastema here] end
		// % protected region % [Add customisation for Diastema Notes here] off begin
		String randomStringforDiastemaNotes = mock
				.strings()
				.get();
		newEntity.setDiastemaNotes(randomStringforDiastemaNotes);
		// % protected region % [Add customisation for Diastema Notes here] end
		// % protected region % [Add customisation for Tooth Anomaly here] off begin
		newEntity.setToothAnomaly(mock.bools().get());
		// % protected region % [Add customisation for Tooth Anomaly here] end
		// % protected region % [Add customisation for Tooth Anomaly Notes here] off begin
		String randomStringforToothAnomalyNotes = mock
				.strings()
				.get();
		newEntity.setToothAnomalyNotes(randomStringforToothAnomalyNotes);
		// % protected region % [Add customisation for Tooth Anomaly Notes here] end
		// % protected region % [Add customisation for Other Dental Notes here] off begin
		String randomStringforOtherDentalNotes = mock
				.strings()
				.get();
		newEntity.setOtherDentalNotes(randomStringforOtherDentalNotes);
		// % protected region % [Add customisation for Other Dental Notes here] end
		// % protected region % [Add customisation for Decayed here] off begin
		String randomStringforDecayed = mock
				.strings()
				.get();
		newEntity.setDecayed(randomStringforDecayed);
		// % protected region % [Add customisation for Decayed here] end
		// % protected region % [Add customisation for Missing here] off begin
		String randomStringforMissing = mock
				.strings()
				.get();
		newEntity.setMissing(randomStringforMissing);
		// % protected region % [Add customisation for Missing here] end
		// % protected region % [Add customisation for Filled here] off begin
		String randomStringforFilled = mock
				.strings()
				.get();
		newEntity.setFilled(randomStringforFilled);
		// % protected region % [Add customisation for Filled here] end
		// % protected region % [Add customisation for Total Photograph here] off begin
		String randomStringforTotalPhotograph = mock
				.strings()
				.get();
		newEntity.setTotalPhotograph(randomStringforTotalPhotograph);
		// % protected region % [Add customisation for Total Photograph here] end
		// % protected region % [Add customisation for Photograph Type here] off begin
		String randomStringforPhotographType = mock
				.strings()
				.get();
		newEntity.setPhotographType(randomStringforPhotographType);
		// % protected region % [Add customisation for Photograph Type here] end
		// % protected region % [Add customisation for Total Rontgen Photograph here] off begin
		String randomStringforTotalRontgenPhotograph = mock
				.strings()
				.get();
		newEntity.setTotalRontgenPhotograph(randomStringforTotalRontgenPhotograph);
		// % protected region % [Add customisation for Total Rontgen Photograph here] end
		// % protected region % [Add customisation for Rontgen Photograph Type here] off begin
		String randomStringforRontgenPhotographType = mock
				.strings()
				.get();
		newEntity.setRontgenPhotographType(randomStringforRontgenPhotographType);
		// % protected region % [Add customisation for Rontgen Photograph Type here] end

		// % protected region % [Apply any additional logic for medicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalExaminationRecordEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Examination Record entities with no reference at all.
	 */
	@Provides
	@Named("medicalExaminationRecordEntitiesWithNoRef")
	public Collection<MedicalExaminationRecordEntity> medicalExaminationRecordEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordEntitiesWithNoRef here] end
		MedicalExaminationRecordEntityFactory medicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type MedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for medicalExaminationRecordEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordEntitiesWithNoRef before the main body here] end

		Collection<MedicalExaminationRecordEntity> newEntities = medicalExaminationRecordEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalExaminationRecordEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalExaminationRecordEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Examination Record entity with all references set.
	 */
	@Provides
	@Named("medicalExaminationRecordEntityWithRefs")
	public MedicalExaminationRecordEntity medicalExaminationRecordEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for medicalExaminationRecordEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordEntityWithRefs before the main body here] end

		MedicalExaminationRecordEntity medicalExaminationRecordEntity = injector.getInstance(Key.get(MedicalExaminationRecordEntity.class, Names.named("medicalExaminationRecordEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalExaminationRecordEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalExaminationRecordEntity with references");

		return medicalExaminationRecordEntity;
	}

	/**
	 * Return a collection of Medical Examination Record entities with all references set.
	 */
	@Provides
	@Named("medicalExaminationRecordEntitiesWithRefs")
	public Collection<MedicalExaminationRecordEntity> medicalExaminationRecordEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordEntitiesWithRefs here] end
		MedicalExaminationRecordEntityFactory medicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type MedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for medicalExaminationRecordEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordEntitiesWithRefs before the main body here] end

		Collection<MedicalExaminationRecordEntity> newEntities = medicalExaminationRecordEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalExaminationRecordEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalExaminationRecordEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
