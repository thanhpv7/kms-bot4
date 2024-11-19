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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.MedicalExaminationRecordEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class MedicalExaminationRecordFactory implements FactoryBean<MedicalExaminationRecordEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public MedicalExaminationRecordEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public MedicalExaminationRecordEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public MedicalExaminationRecordEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for medicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordWithNoRef before the main body here] end

		MedicalExaminationRecordEntity newEntity = new MedicalExaminationRecordEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mockNeat.ints().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mockNeat.ints().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Pulse here] off begin
		newEntity.setPulse(mockNeat.ints().get());
		// % protected region % [Add customisation for Pulse here] end
		// % protected region % [Add customisation for BP Standing Systole here] off begin
		newEntity.setBpStandingSystole(mockNeat.ints().get());
		// % protected region % [Add customisation for BP Standing Systole here] end
		// % protected region % [Add customisation for BP Standing Diastole here] off begin
		newEntity.setBpStandingDiastole(mockNeat.ints().get());
		// % protected region % [Add customisation for BP Standing Diastole here] end
		// % protected region % [Add customisation for Pulse Regularity here] off begin
		String randomStringForPulseRegularity = mockNeat
				.strings()
				.get();
		newEntity.setPulseRegularity(randomStringForPulseRegularity);
		// % protected region % [Add customisation for Pulse Regularity here] end
		// % protected region % [Add customisation for Pulse Strength here] off begin
		String randomStringForPulseStrength = mockNeat
				.strings()
				.get();
		newEntity.setPulseStrength(randomStringForPulseStrength);
		// % protected region % [Add customisation for Pulse Strength here] end
		// % protected region % [Add customisation for Temperature here] off begin
		newEntity.setTemperature(mockNeat.doubles().get());
		// % protected region % [Add customisation for Temperature here] end
		// % protected region % [Add customisation for Temperature scale here] off begin
		String randomStringForTemperatureScale = mockNeat
				.strings()
				.get();
		newEntity.setTemperatureScale(randomStringForTemperatureScale);
		// % protected region % [Add customisation for Temperature scale here] end
		// % protected region % [Add customisation for GCS Eyes here] off begin
		String randomStringForGcsEyes = mockNeat
				.strings()
				.get();
		newEntity.setGcsEyes(randomStringForGcsEyes);
		// % protected region % [Add customisation for GCS Eyes here] end
		// % protected region % [Add customisation for GCS Verbal here] off begin
		String randomStringForGcsVerbal = mockNeat
				.strings()
				.get();
		newEntity.setGcsVerbal(randomStringForGcsVerbal);
		// % protected region % [Add customisation for GCS Verbal here] end
		// % protected region % [Add customisation for GCS Motor here] off begin
		String randomStringForGcsMotor = mockNeat
				.strings()
				.get();
		newEntity.setGcsMotor(randomStringForGcsMotor);
		// % protected region % [Add customisation for GCS Motor here] end
		// % protected region % [Add customisation for Total GCS Score here] off begin
		newEntity.setTotalGCSScore(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total GCS Score here] end
		// % protected region % [Add customisation for Consciousness here] off begin
		String randomStringForConsciousness = mockNeat
				.strings()
				.get();
		newEntity.setConsciousness(randomStringForConsciousness);
		// % protected region % [Add customisation for Consciousness here] end
		// % protected region % [Add customisation for Height here] off begin
		newEntity.setHeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Height here] end
		// % protected region % [Add customisation for Height Scale here] off begin
		String randomStringForHeightScale = mockNeat
				.strings()
				.get();
		newEntity.setHeightScale(randomStringForHeightScale);
		// % protected region % [Add customisation for Height Scale here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Weight Scale here] off begin
		String randomStringForWeightScale = mockNeat
				.strings()
				.get();
		newEntity.setWeightScale(randomStringForWeightScale);
		// % protected region % [Add customisation for Weight Scale here] end
		// % protected region % [Add customisation for BMI here] off begin
		newEntity.setBmi(mockNeat.doubles().get());
		// % protected region % [Add customisation for BMI here] end
		// % protected region % [Add customisation for Respiratory here] off begin
		newEntity.setRespiratory(mockNeat.doubles().get());
		// % protected region % [Add customisation for Respiratory here] end
		// % protected region % [Add customisation for Oxygen Saturation here] off begin
		newEntity.setOxygenSaturation(mockNeat.doubles().get());
		// % protected region % [Add customisation for Oxygen Saturation here] end
		// % protected region % [Add customisation for Waist Circumference here] off begin
		newEntity.setWaistCircumference(mockNeat.doubles().get());
		// % protected region % [Add customisation for Waist Circumference here] end
		// % protected region % [Add customisation for Waist Circumference Unit here] off begin
		String randomStringForWaistCircumferenceUnit = mockNeat
				.strings()
				.get();
		newEntity.setWaistCircumferenceUnit(randomStringForWaistCircumferenceUnit);
		// % protected region % [Add customisation for Waist Circumference Unit here] end
		// % protected region % [Add customisation for Nutrition Status here] off begin
		String randomStringForNutritionStatus = mockNeat
				.strings()
				.get();
		newEntity.setNutritionStatus(randomStringForNutritionStatus);
		// % protected region % [Add customisation for Nutrition Status here] end
		// % protected region % [Add customisation for Pain Scale here] off begin
		newEntity.setPainScale(mockNeat.ints().get());
		// % protected region % [Add customisation for Pain Scale here] end
		// % protected region % [Add customisation for Pain Scale Used here] off begin
		String randomStringForPainScaleUsed = mockNeat
				.strings()
				.get();
		newEntity.setPainScaleUsed(randomStringForPainScaleUsed);
		// % protected region % [Add customisation for Pain Scale Used here] end
		// % protected region % [Add customisation for Risk Fall Scale here] off begin
		newEntity.setRiskFallScale(mockNeat.ints().get());
		// % protected region % [Add customisation for Risk Fall Scale here] end
		// % protected region % [Add customisation for Objective here] off begin
		String randomStringForObjective = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setObjective(randomStringForObjective);
		// % protected region % [Add customisation for Objective here] end
		// % protected region % [Add customisation for Risk Fall Scale Used here] off begin
		String randomStringForRiskFallScaleUsed = mockNeat
				.strings()
				.get();
		newEntity.setRiskFallScaleUsed(randomStringForRiskFallScaleUsed);
		// % protected region % [Add customisation for Risk Fall Scale Used here] end
		// % protected region % [Add customisation for Subjective here] off begin
		String randomStringForSubjective = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setSubjective(randomStringForSubjective);
		// % protected region % [Add customisation for Subjective here] end
		// % protected region % [Add customisation for Plan here] off begin
		String randomStringForPlan = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setPlan(randomStringForPlan);
		// % protected region % [Add customisation for Plan here] end
		// % protected region % [Add customisation for Purpose here] off begin
		String randomStringForPurpose = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setPurpose(randomStringForPurpose);
		// % protected region % [Add customisation for Purpose here] end
		// % protected region % [Add customisation for Examination Sub Case here] off begin
		String randomStringForExaminationSubCase = mockNeat
				.strings()
				.get();
		newEntity.setExaminationSubCase(randomStringForExaminationSubCase);
		// % protected region % [Add customisation for Examination Sub Case here] end
		// % protected region % [Add customisation for Accidental Type here] off begin
		String randomStringForAccidentalType = mockNeat
				.strings()
				.get();
		newEntity.setAccidentalType(randomStringForAccidentalType);
		// % protected region % [Add customisation for Accidental Type here] end
		// % protected region % [Add customisation for Service Case here] off begin
		String randomStringForServiceCase = mockNeat
				.strings()
				.get();
		newEntity.setServiceCase(randomStringForServiceCase);
		// % protected region % [Add customisation for Service Case here] end
		// % protected region % [Add customisation for Accidental Sub Type here] off begin
		String randomStringForAccidentalSubType = mockNeat
				.strings()
				.get();
		newEntity.setAccidentalSubType(randomStringForAccidentalSubType);
		// % protected region % [Add customisation for Accidental Sub Type here] end
		// % protected region % [Add customisation for Additional Notes here] off begin
		String randomStringForAdditionalNotes = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setAdditionalNotes(randomStringForAdditionalNotes);
		// % protected region % [Add customisation for Additional Notes here] end
		// % protected region % [Add customisation for Dental Procedure here] off begin
		String randomStringForDentalProcedure = mockNeat
				.strings()
				.get();
		newEntity.setDentalProcedure(randomStringForDentalProcedure);
		// % protected region % [Add customisation for Dental Procedure here] end
		// % protected region % [Add customisation for Psychiatry Case here] off begin
		String randomStringForPsychiatryCase = mockNeat
				.strings()
				.get();
		newEntity.setPsychiatryCase(randomStringForPsychiatryCase);
		// % protected region % [Add customisation for Psychiatry Case here] end
		// % protected region % [Add customisation for Therapy here] off begin
		String randomStringForTherapy = mockNeat
				.strings()
				.get();
		newEntity.setTherapy(randomStringForTherapy);
		// % protected region % [Add customisation for Therapy here] end
		// % protected region % [Add customisation for Family Planning here] off begin
		newEntity.setFamilyPlanning(mockNeat.bools().get());
		// % protected region % [Add customisation for Family Planning here] end
		// % protected region % [Add customisation for Condition here] off begin
		String randomStringForCondition = mockNeat
				.strings()
				.get();
		newEntity.setCondition(randomStringForCondition);
		// % protected region % [Add customisation for Condition here] end
		// % protected region % [Add customisation for Family Planning Case here] off begin
		String randomStringForFamilyPlanningCase = mockNeat
				.strings()
				.get();
		newEntity.setFamilyPlanningCase(randomStringForFamilyPlanningCase);
		// % protected region % [Add customisation for Family Planning Case here] end
		// % protected region % [Add customisation for Previous Contraceptive Method here] off begin
		String randomStringForPreviousContraceptiveMethod = mockNeat
				.strings()
				.get();
		newEntity.setPreviousContraceptiveMethod(randomStringForPreviousContraceptiveMethod);
		// % protected region % [Add customisation for Previous Contraceptive Method here] end
		// % protected region % [Add customisation for Side Effects here] off begin
		String randomStringForSideEffects = mockNeat
				.strings()
				.get();
		newEntity.setSideEffects(randomStringForSideEffects);
		// % protected region % [Add customisation for Side Effects here] end
		// % protected region % [Add customisation for Complication here] off begin
		String randomStringForComplication = mockNeat
				.strings()
				.get();
		newEntity.setComplication(randomStringForComplication);
		// % protected region % [Add customisation for Complication here] end
		// % protected region % [Add customisation for Contraseptive Method here] off begin
		String randomStringForContraseptiveMethod = mockNeat
				.strings()
				.get();
		newEntity.setContraseptiveMethod(randomStringForContraseptiveMethod);
		// % protected region % [Add customisation for Contraseptive Method here] end
		// % protected region % [Add customisation for Visit Type here] off begin
		String randomStringForVisitType = mockNeat
				.strings()
				.get();
		newEntity.setVisitType(randomStringForVisitType);
		// % protected region % [Add customisation for Visit Type here] end
		// % protected region % [Add customisation for Hearing Test Method here] off begin
		String randomStringForHearingTestMethod = mockNeat
				.strings()
				.get();
		newEntity.setHearingTestMethod(randomStringForHearingTestMethod);
		// % protected region % [Add customisation for Hearing Test Method here] end
		// % protected region % [Add customisation for Hearing Test Notes here] off begin
		String randomStringForHearingTestNotes = mockNeat
				.strings()
				.get();
		newEntity.setHearingTestNotes(randomStringForHearingTestNotes);
		// % protected region % [Add customisation for Hearing Test Notes here] end
		// % protected region % [Add customisation for Hearing Loss Category here] off begin
		String randomStringForHearingLossCategory = mockNeat
				.strings()
				.get();
		newEntity.setHearingLossCategory(randomStringForHearingLossCategory);
		// % protected region % [Add customisation for Hearing Loss Category here] end
		// % protected region % [Add customisation for Hearing Loss Notes here] off begin
		String randomStringForHearingLossNotes = mockNeat
				.strings()
				.get();
		newEntity.setHearingLossNotes(randomStringForHearingLossNotes);
		// % protected region % [Add customisation for Hearing Loss Notes here] end
		// % protected region % [Add customisation for Eye Position Right Eye here] off begin
		String randomStringForEyePositionRightEye = mockNeat
				.strings()
				.get();
		newEntity.setEyePositionRightEye(randomStringForEyePositionRightEye);
		// % protected region % [Add customisation for Eye Position Right Eye here] end
		// % protected region % [Add customisation for Eye Position Left Eye here] off begin
		String randomStringForEyePositionLeftEye = mockNeat
				.strings()
				.get();
		newEntity.setEyePositionLeftEye(randomStringForEyePositionLeftEye);
		// % protected region % [Add customisation for Eye Position Left Eye here] end
		// % protected region % [Add customisation for Muscle Balance Right Eye here] off begin
		String randomStringForMuscleBalanceRightEye = mockNeat
				.strings()
				.get();
		newEntity.setMuscleBalanceRightEye(randomStringForMuscleBalanceRightEye);
		// % protected region % [Add customisation for Muscle Balance Right Eye here] end
		// % protected region % [Add customisation for Muscle Balance Left Eye here] off begin
		String randomStringForMuscleBalanceLeftEye = mockNeat
				.strings()
				.get();
		newEntity.setMuscleBalanceLeftEye(randomStringForMuscleBalanceLeftEye);
		// % protected region % [Add customisation for Muscle Balance Left Eye here] end
		// % protected region % [Add customisation for Visual Field Right Eye here] off begin
		String randomStringForVisualFieldRightEye = mockNeat
				.strings()
				.get();
		newEntity.setVisualFieldRightEye(randomStringForVisualFieldRightEye);
		// % protected region % [Add customisation for Visual Field Right Eye here] end
		// % protected region % [Add customisation for Visual Field Left Eye here] off begin
		String randomStringForVisualFieldLeftEye = mockNeat
				.strings()
				.get();
		newEntity.setVisualFieldLeftEye(randomStringForVisualFieldLeftEye);
		// % protected region % [Add customisation for Visual Field Left Eye here] end
		// % protected region % [Add customisation for Ocular Funduscopy Right Eye here] off begin
		String randomStringForOcularFunduscopyRightEye = mockNeat
				.strings()
				.get();
		newEntity.setOcularFunduscopyRightEye(randomStringForOcularFunduscopyRightEye);
		// % protected region % [Add customisation for Ocular Funduscopy Right Eye here] end
		// % protected region % [Add customisation for Ocular Funduscopy Left Eye here] off begin
		String randomStringForOcularFunduscopyLeftEye = mockNeat
				.strings()
				.get();
		newEntity.setOcularFunduscopyLeftEye(randomStringForOcularFunduscopyLeftEye);
		// % protected region % [Add customisation for Ocular Funduscopy Left Eye here] end
		// % protected region % [Add customisation for Intraocular Pressure Right Eye here] off begin
		String randomStringForIntraocularPressureRightEye = mockNeat
				.strings()
				.get();
		newEntity.setIntraocularPressureRightEye(randomStringForIntraocularPressureRightEye);
		// % protected region % [Add customisation for Intraocular Pressure Right Eye here] end
		// % protected region % [Add customisation for Intraocular Pressure Left Eye here] off begin
		String randomStringForIntraocularPressureLeftEye = mockNeat
				.strings()
				.get();
		newEntity.setIntraocularPressureLeftEye(randomStringForIntraocularPressureLeftEye);
		// % protected region % [Add customisation for Intraocular Pressure Left Eye here] end
		// % protected region % [Add customisation for Color Blindness here] off begin
		String randomStringForColorBlindness = mockNeat
				.strings()
				.get();
		newEntity.setColorBlindness(randomStringForColorBlindness);
		// % protected region % [Add customisation for Color Blindness here] end
		// % protected region % [Add customisation for Visual Acuity Right Eye here] off begin
		String randomStringForVisualAcuityRightEye = mockNeat
				.strings()
				.get();
		newEntity.setVisualAcuityRightEye(randomStringForVisualAcuityRightEye);
		// % protected region % [Add customisation for Visual Acuity Right Eye here] end
		// % protected region % [Add customisation for Visual Acuity Left Eye here] off begin
		String randomStringForVisualAcuityLeftEye = mockNeat
				.strings()
				.get();
		newEntity.setVisualAcuityLeftEye(randomStringForVisualAcuityLeftEye);
		// % protected region % [Add customisation for Visual Acuity Left Eye here] end
		// % protected region % [Add customisation for Correction Right Eye here] off begin
		String randomStringForCorrectionRightEye = mockNeat
				.strings()
				.get();
		newEntity.setCorrectionRightEye(randomStringForCorrectionRightEye);
		// % protected region % [Add customisation for Correction Right Eye here] end
		// % protected region % [Add customisation for Correction Left Eye here] off begin
		String randomStringForCorrectionLeftEye = mockNeat
				.strings()
				.get();
		newEntity.setCorrectionLeftEye(randomStringForCorrectionLeftEye);
		// % protected region % [Add customisation for Correction Left Eye here] end
		// % protected region % [Add customisation for Addition Right Eye here] off begin
		String randomStringForAdditionRightEye = mockNeat
				.strings()
				.get();
		newEntity.setAdditionRightEye(randomStringForAdditionRightEye);
		// % protected region % [Add customisation for Addition Right Eye here] end
		// % protected region % [Add customisation for Addition Left Eye here] off begin
		String randomStringForAdditionLeftEye = mockNeat
				.strings()
				.get();
		newEntity.setAdditionLeftEye(randomStringForAdditionLeftEye);
		// % protected region % [Add customisation for Addition Left Eye here] end
		// % protected region % [Add customisation for Occlusion here] off begin
		String randomStringForOcclusion = mockNeat
				.strings()
				.get();
		newEntity.setOcclusion(randomStringForOcclusion);
		// % protected region % [Add customisation for Occlusion here] end
		// % protected region % [Add customisation for Torus Palatinus here] off begin
		String randomStringForTorusPalatinus = mockNeat
				.strings()
				.get();
		newEntity.setTorusPalatinus(randomStringForTorusPalatinus);
		// % protected region % [Add customisation for Torus Palatinus here] end
		// % protected region % [Add customisation for Torus Mandibularis here] off begin
		String randomStringForTorusMandibularis = mockNeat
				.strings()
				.get();
		newEntity.setTorusMandibularis(randomStringForTorusMandibularis);
		// % protected region % [Add customisation for Torus Mandibularis here] end
		// % protected region % [Add customisation for Palatum here] off begin
		String randomStringForPalatum = mockNeat
				.strings()
				.get();
		newEntity.setPalatum(randomStringForPalatum);
		// % protected region % [Add customisation for Palatum here] end
		// % protected region % [Add customisation for Diastema here] off begin
		newEntity.setDiastema(mockNeat.bools().get());
		// % protected region % [Add customisation for Diastema here] end
		// % protected region % [Add customisation for Diastema Notes here] off begin
		String randomStringForDiastemaNotes = mockNeat
				.strings()
				.get();
		newEntity.setDiastemaNotes(randomStringForDiastemaNotes);
		// % protected region % [Add customisation for Diastema Notes here] end
		// % protected region % [Add customisation for Tooth Anomaly here] off begin
		newEntity.setToothAnomaly(mockNeat.bools().get());
		// % protected region % [Add customisation for Tooth Anomaly here] end
		// % protected region % [Add customisation for Tooth Anomaly Notes here] off begin
		String randomStringForToothAnomalyNotes = mockNeat
				.strings()
				.get();
		newEntity.setToothAnomalyNotes(randomStringForToothAnomalyNotes);
		// % protected region % [Add customisation for Tooth Anomaly Notes here] end
		// % protected region % [Add customisation for Other Dental Notes here] off begin
		String randomStringForOtherDentalNotes = mockNeat
				.strings()
				.get();
		newEntity.setOtherDentalNotes(randomStringForOtherDentalNotes);
		// % protected region % [Add customisation for Other Dental Notes here] end
		// % protected region % [Add customisation for Decayed here] off begin
		String randomStringForDecayed = mockNeat
				.strings()
				.get();
		newEntity.setDecayed(randomStringForDecayed);
		// % protected region % [Add customisation for Decayed here] end
		// % protected region % [Add customisation for Missing here] off begin
		String randomStringForMissing = mockNeat
				.strings()
				.get();
		newEntity.setMissing(randomStringForMissing);
		// % protected region % [Add customisation for Missing here] end
		// % protected region % [Add customisation for Filled here] off begin
		String randomStringForFilled = mockNeat
				.strings()
				.get();
		newEntity.setFilled(randomStringForFilled);
		// % protected region % [Add customisation for Filled here] end
		// % protected region % [Add customisation for Total Photograph here] off begin
		String randomStringForTotalPhotograph = mockNeat
				.strings()
				.get();
		newEntity.setTotalPhotograph(randomStringForTotalPhotograph);
		// % protected region % [Add customisation for Total Photograph here] end
		// % protected region % [Add customisation for Photograph Type here] off begin
		String randomStringForPhotographType = mockNeat
				.strings()
				.get();
		newEntity.setPhotographType(randomStringForPhotographType);
		// % protected region % [Add customisation for Photograph Type here] end
		// % protected region % [Add customisation for Total Rontgen Photograph here] off begin
		String randomStringForTotalRontgenPhotograph = mockNeat
				.strings()
				.get();
		newEntity.setTotalRontgenPhotograph(randomStringForTotalRontgenPhotograph);
		// % protected region % [Add customisation for Total Rontgen Photograph here] end
		// % protected region % [Add customisation for Rontgen Photograph Type here] off begin
		String randomStringForRontgenPhotographType = mockNeat
				.strings()
				.get();
		newEntity.setRontgenPhotographType(randomStringForRontgenPhotographType);
		// % protected region % [Add customisation for Rontgen Photograph Type here] end

		// % protected region % [Apply any additional logic for medicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Inpatient Medical Examination Record here] off begin
			// Incoming One to One reference
			var inpatientMedicalExaminationRecordFactory = new InpatientMedicalExaminationRecordFactory();
			newEntity.setInpatientMedicalExaminationRecord(inpatientMedicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Inpatient Medical Examination Record here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] off begin
			// Incoming One to One reference
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] end
			// % protected region % [Override the reference inclusions for outgoingOneToOne Birth History] off begin
			// Outgoing one to one reference
			var birthHistoryFactory = new BirthHistoryFactory();
			newEntity.setBirthHistory(birthHistoryFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Birth History] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Body Chart Examination] off begin
			// Outgoing one to one reference
			var bodyChartExaminationFactory = new BodyChartExaminationFactory();
			newEntity.setBodyChartExamination(bodyChartExaminationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Body Chart Examination] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Delivery Medical Examination Record] off begin
			// Outgoing one to one reference
			var deliveryMedicalExaminationRecordFactory = new DeliveryMedicalExaminationRecordFactory();
			newEntity.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Delivery Medical Examination Record] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne ENT Examination] off begin
			// Outgoing one to one reference
			var entExaminationFactory = new EntExaminationFactory();
			newEntity.setEntExamination(entExaminationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne ENT Examination] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Emergency Medication Examination Record] off begin
			// Outgoing one to one reference
			var emergencyMedicationExaminationRecordFactory = new EmergencyMedicalExaminationRecordFactory();
			newEntity.setEmergencyMedicationExaminationRecord(emergencyMedicationExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Emergency Medication Examination Record] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Formulir Konseling Tes Hiv] off begin
			// Outgoing one to one reference
			var formulirKonselingTesHivFactory = new FormulirKonselingTesHivFactory();
			newEntity.setFormulirKonselingTesHiv(formulirKonselingTesHivFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Formulir Konseling Tes Hiv] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Hemodialysis Examination] off begin
			// Outgoing one to one reference
			var hemodialysisExaminationFactory = new HemodialysisExaminationFactory();
			newEntity.setHemodialysisExamination(hemodialysisExaminationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Hemodialysis Examination] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Examination Record Discharge Summary] off begin
			// Outgoing one to one reference
			var medicalExaminationRecordDischargeSummaryFactory = new MedicalExaminationRecordDischargeSummaryFactory();
			newEntity.setMedicalExaminationRecordDischargeSummary(medicalExaminationRecordDischargeSummaryFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Examination Record Discharge Summary] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Record Initial Checklist] off begin
			// Outgoing one to one reference
			var medicalRecordInitialChecklistFactory = new MedicalRecordInitialChecklistFactory();
			newEntity.setMedicalRecordInitialChecklist(medicalRecordInitialChecklistFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Record Initial Checklist] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Record Next Verification Checklist] off begin
			// Outgoing one to one reference
			var medicalRecordNextVerificationChecklistFactory = new MedicalRecordNextVerificationChecklistFactory();
			newEntity.setMedicalRecordNextVerificationChecklist(medicalRecordNextVerificationChecklistFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Record Next Verification Checklist] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Nurse Vital Sign Measurement] off begin
			// Outgoing one to one reference
			var nurseVitalSignMeasurementFactory = new NurseVitalSignMeasurementFactory();
			newEntity.setNurseVitalSignMeasurement(nurseVitalSignMeasurementFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Nurse Vital Sign Measurement] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Obstetric And Gynecology History] off begin
			// Outgoing one to one reference
			var obstetricAndGynecologyHistoryFactory = new ObstetricAndGynecologyHistoryFactory();
			newEntity.setObstetricAndGynecologyHistory(obstetricAndGynecologyHistoryFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Obstetric And Gynecology History] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Odontogram Examination] off begin
			// Outgoing one to one reference
			var odontogramExaminationFactory = new OdontogramExaminationFactory();
			newEntity.setOdontogramExamination(odontogramExaminationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Odontogram Examination] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Operating Theater Medical Examination Record] off begin
			// Outgoing one to one reference
			var operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();
			newEntity.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Operating Theater Medical Examination Record] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Ophthalmology Examination] off begin
			// Outgoing one to one reference
			var ophthalmologyExaminationFactory = new OphthalmologyExaminationFactory();
			newEntity.setOphthalmologyExamination(ophthalmologyExaminationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Ophthalmology Examination] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDoctor here] off begin
			var doctorFactory = new StaffFactory();
			newEntity.setDoctor(doctorFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDoctor here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Transcriber here] off begin
			var medicalTranscriberFactory = new StaffFactory();
			newEntity.setMedicalTranscriber(medicalTranscriberFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Transcriber here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyNurse here] off begin
			var nurseFactory = new StaffFactory();
			newEntity.setNurse(nurseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyNurse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Amendment Details here] off begin
			// Outgoing one to many reference
			var amendmentDetailsFactory = new AmendmentDetailFactory();
			newEntity.setAmendmentDetails(Collections.singletonList(amendmentDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Amendment Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Co Treating Doctors here] off begin
			// Outgoing one to many reference
			var coTreatingDoctorsFactory = new CoTreatingDoctorFactory();
			newEntity.setCoTreatingDoctors(Collections.singletonList(coTreatingDoctorsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Co Treating Doctors here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Daily Care CPPTs here] off begin
			// Outgoing one to many reference
			var dailyCareCPPTsFactory = new DailyCareCPPTFactory();
			newEntity.setDailyCareCPPTs(Collections.singletonList(dailyCareCPPTsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Daily Care CPPTs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnosis Examination Records here] off begin
			// Outgoing one to many reference
			var diagnosisExaminationRecordsFactory = new DiagnosisExaminationRecordFactory();
			newEntity.setDiagnosisExaminationRecords(Collections.singletonList(diagnosisExaminationRecordsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnosis Examination Records here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnosis Nandas here] off begin
			// Outgoing one to many reference
			var diagnosisNandasFactory = new DiagnosisNandaFactory();
			newEntity.setDiagnosisNandas(Collections.singletonList(diagnosisNandasFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnosis Nandas here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Room Transfers here] off begin
			// Outgoing one to many reference
			var roomTransfersFactory = new RoomTransferFactory();
			newEntity.setRoomTransfers(Collections.singletonList(roomTransfersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Room Transfers here] end

		}

		// % protected region % [Apply any additional logic for medicalExaminationRecord with ref here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecord with ref here] end

		return newEntity;
	}

	@Override
	public Class<MedicalExaminationRecordEntity> getObjectType() {
		return MedicalExaminationRecordEntity.class;
	}
}