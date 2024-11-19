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
import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class MedicalExaminationRecordDischargeSummaryFactory implements FactoryBean<MedicalExaminationRecordDischargeSummaryEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public MedicalExaminationRecordDischargeSummaryEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public MedicalExaminationRecordDischargeSummaryEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public MedicalExaminationRecordDischargeSummaryEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryWithNoRef before the main body here] end

		MedicalExaminationRecordDischargeSummaryEntity newEntity = new MedicalExaminationRecordDischargeSummaryEntity();
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
		// % protected region % [Add customisation for Discharge Summary here] off begin
		String randomStringForDischargeSummary = mockNeat
				.strings()
				.get();
		newEntity.setDischargeSummary(randomStringForDischargeSummary);
		// % protected region % [Add customisation for Discharge Summary here] end
		// % protected region % [Add customisation for Condition Upon Discharge here] off begin
		String randomStringForConditionUponDischarge = mockNeat
				.strings()
				.get();
		newEntity.setConditionUponDischarge(randomStringForConditionUponDischarge);
		// % protected region % [Add customisation for Condition Upon Discharge here] end
		// % protected region % [Add customisation for Escorted By here] off begin
		String randomStringForEscortedBy = mockNeat
				.strings()
				.get();
		newEntity.setEscortedBy(randomStringForEscortedBy);
		// % protected region % [Add customisation for Escorted By here] end
		// % protected region % [Add customisation for Discharge Reason here] off begin
		String randomStringForDischargeReason = mockNeat
				.strings()
				.get();
		newEntity.setDischargeReason(randomStringForDischargeReason);
		// % protected region % [Add customisation for Discharge Reason here] end

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDischarging Doctor here] off begin
			var dischargingDoctorFactory = new StaffFactory();
			newEntity.setDischargingDoctor(dischargingDoctorFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDischarging Doctor here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnosis Examination Records here] off begin
			// Outgoing one to many reference
			var diagnosisExaminationRecordsFactory = new DiagnosisExaminationRecordFactory();
			newEntity.setDiagnosisExaminationRecords(Collections.singletonList(diagnosisExaminationRecordsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnosis Examination Records here] end

		}

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummary with ref here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummary with ref here] end

		return newEntity;
	}

	@Override
	public Class<MedicalExaminationRecordDischargeSummaryEntity> getObjectType() {
		return MedicalExaminationRecordDischargeSummaryEntity.class;
	}
}