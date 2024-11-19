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
import kmsweb.entities.HemodialysisExaminationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class HemodialysisExaminationFactory implements FactoryBean<HemodialysisExaminationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public HemodialysisExaminationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public HemodialysisExaminationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public HemodialysisExaminationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for hemodialysisExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationWithNoRef before the main body here] end

		HemodialysisExaminationEntity newEntity = new HemodialysisExaminationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for First Dialysis here] off begin
		newEntity.setFirstDialysis(OffsetDateTime.now());
		// % protected region % [Add customisation for First Dialysis here] end
		// % protected region % [Add customisation for Dialysis Frequency here] off begin
		String randomStringForDialysisFrequency = mockNeat
				.strings()
				.get();
		newEntity.setDialysisFrequency(randomStringForDialysisFrequency);
		// % protected region % [Add customisation for Dialysis Frequency here] end
		// % protected region % [Add customisation for Dialysis No here] off begin
		String randomStringForDialysisNo = mockNeat
				.strings()
				.get();
		newEntity.setDialysisNo(randomStringForDialysisNo);
		// % protected region % [Add customisation for Dialysis No here] end
		// % protected region % [Add customisation for Hemodialysis Type here] off begin
		String randomStringForHemodialysisType = mockNeat
				.strings()
				.get();
		newEntity.setHemodialysisType(randomStringForHemodialysisType);
		// % protected region % [Add customisation for Hemodialysis Type here] end
		// % protected region % [Add customisation for Condition here] off begin
		String randomStringForCondition = mockNeat
				.strings()
				.get();
		newEntity.setCondition(randomStringForCondition);
		// % protected region % [Add customisation for Condition here] end
		// % protected region % [Add customisation for Vascular Access here] off begin
		String randomStringForVascularAccess = mockNeat
				.strings()
				.get();
		newEntity.setVascularAccess(randomStringForVascularAccess);
		// % protected region % [Add customisation for Vascular Access here] end
		// % protected region % [Add customisation for Heparinization here] off begin
		String randomStringForHeparinization = mockNeat
				.strings()
				.get();
		newEntity.setHeparinization(randomStringForHeparinization);
		// % protected region % [Add customisation for Heparinization here] end
		// % protected region % [Add customisation for Heparinization Initial Dose here] off begin
		String randomStringForHeparinizationInitialDose = mockNeat
				.strings()
				.get();
		newEntity.setHeparinizationInitialDose(randomStringForHeparinizationInitialDose);
		// % protected region % [Add customisation for Heparinization Initial Dose here] end
		// % protected region % [Add customisation for Heparinization Follow Up Dose here] off begin
		String randomStringForHeparinizationFollowUpDose = mockNeat
				.strings()
				.get();
		newEntity.setHeparinizationFollowUpDose(randomStringForHeparinizationFollowUpDose);
		// % protected region % [Add customisation for Heparinization Follow Up Dose here] end
		// % protected region % [Add customisation for Dialyzer here] off begin
		String randomStringForDialyzer = mockNeat
				.strings()
				.get();
		newEntity.setDialyzer(randomStringForDialyzer);
		// % protected region % [Add customisation for Dialyzer here] end
		// % protected region % [Add customisation for Dialyzer Type here] off begin
		String randomStringForDialyzerType = mockNeat
				.strings()
				.get();
		newEntity.setDialyzerType(randomStringForDialyzerType);
		// % protected region % [Add customisation for Dialyzer Type here] end
		// % protected region % [Add customisation for Dialysis Fluid here] off begin
		String randomStringForDialysisFluid = mockNeat
				.strings()
				.get();
		newEntity.setDialysisFluid(randomStringForDialysisFluid);
		// % protected region % [Add customisation for Dialysis Fluid here] end
		// % protected region % [Add customisation for Dry Weight here] off begin
		newEntity.setDryWeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Dry Weight here] end
		// % protected region % [Add customisation for Dry Weight Unit here] off begin
		String randomStringForDryWeightUnit = mockNeat
				.strings()
				.get();
		newEntity.setDryWeightUnit(randomStringForDryWeightUnit);
		// % protected region % [Add customisation for Dry Weight Unit here] end
		// % protected region % [Add customisation for Weight Upon Arrival here] off begin
		newEntity.setWeightUponArrival(mockNeat.doubles().get());
		// % protected region % [Add customisation for Weight Upon Arrival here] end
		// % protected region % [Add customisation for Weight Upon Arrival Unit here] off begin
		String randomStringForWeightUponArrivalUnit = mockNeat
				.strings()
				.get();
		newEntity.setWeightUponArrivalUnit(randomStringForWeightUponArrivalUnit);
		// % protected region % [Add customisation for Weight Upon Arrival Unit here] end
		// % protected region % [Add customisation for Weight During Previous Hemodialysis here] off begin
		newEntity.setWeightDuringPreviousHemodialysis(mockNeat.doubles().get());
		// % protected region % [Add customisation for Weight During Previous Hemodialysis here] end
		// % protected region % [Add customisation for Weight During Previous Hemodialysis Unit here] off begin
		String randomStringForWeightDuringPreviousHemodialysisUnit = mockNeat
				.strings()
				.get();
		newEntity.setWeightDuringPreviousHemodialysisUnit(randomStringForWeightDuringPreviousHemodialysisUnit);
		// % protected region % [Add customisation for Weight During Previous Hemodialysis Unit here] end
		// % protected region % [Add customisation for Anti HIV here] off begin
		newEntity.setAntiHIV(mockNeat.bools().get());
		// % protected region % [Add customisation for Anti HIV here] end
		// % protected region % [Add customisation for HbsAg here] off begin
		newEntity.setHbsag(mockNeat.bools().get());
		// % protected region % [Add customisation for HbsAg here] end
		// % protected region % [Add customisation for Anti HCV here] off begin
		newEntity.setAntiHCV(mockNeat.bools().get());
		// % protected region % [Add customisation for Anti HCV here] end
		// % protected region % [Add customisation for Hemodialysis Start Time here] off begin
		newEntity.setHemodialysisStartTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Hemodialysis Start Time here] end
		// % protected region % [Add customisation for Hemodialysis End Time here] off begin
		newEntity.setHemodialysisEndTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Hemodialysis End Time here] end
		// % protected region % [Add customisation for Target here] off begin
		String randomStringForTarget = mockNeat
				.strings()
				.get();
		newEntity.setTarget(randomStringForTarget);
		// % protected region % [Add customisation for Target here] end
		// % protected region % [Add customisation for Priming Volume here] off begin
		String randomStringForPrimingVolume = mockNeat
				.strings()
				.get();
		newEntity.setPrimingVolume(randomStringForPrimingVolume);
		// % protected region % [Add customisation for Priming Volume here] end
		// % protected region % [Add customisation for Remaining Priming here] off begin
		String randomStringForRemainingPriming = mockNeat
				.strings()
				.get();
		newEntity.setRemainingPriming(randomStringForRemainingPriming);
		// % protected region % [Add customisation for Remaining Priming here] end
		// % protected region % [Add customisation for Complication here] off begin
		String randomStringForComplication = mockNeat
				.strings()
				.get();
		newEntity.setComplication(randomStringForComplication);
		// % protected region % [Add customisation for Complication here] end
		// % protected region % [Add customisation for Hemodialysis Details here] off begin
		String randomStringForHemodialysisDetails = mockNeat
				.strings()
				.get();
		newEntity.setHemodialysisDetails(randomStringForHemodialysisDetails);
		// % protected region % [Add customisation for Hemodialysis Details here] end
		// % protected region % [Add customisation for Weight Upon Dismissal here] off begin
		newEntity.setWeightUponDismissal(mockNeat.doubles().get());
		// % protected region % [Add customisation for Weight Upon Dismissal here] end
		// % protected region % [Add customisation for Weight Upon Dismissal Unit here] off begin
		String randomStringForWeightUponDismissalUnit = mockNeat
				.strings()
				.get();
		newEntity.setWeightUponDismissalUnit(randomStringForWeightUponDismissalUnit);
		// % protected region % [Add customisation for Weight Upon Dismissal Unit here] end
		// % protected region % [Add customisation for Priming here] off begin
		newEntity.setPriming(mockNeat.doubles().get());
		// % protected region % [Add customisation for Priming here] end
		// % protected region % [Add customisation for Blood here] off begin
		newEntity.setBlood(mockNeat.doubles().get());
		// % protected region % [Add customisation for Blood here] end
		// % protected region % [Add customisation for IV Line here] off begin
		newEntity.setIvLine(mockNeat.doubles().get());
		// % protected region % [Add customisation for IV Line here] end
		// % protected region % [Add customisation for Oral here] off begin
		newEntity.setOral(mockNeat.doubles().get());
		// % protected region % [Add customisation for Oral here] end
		// % protected region % [Add customisation for Wash Out here] off begin
		newEntity.setWashOut(mockNeat.doubles().get());
		// % protected region % [Add customisation for Wash Out here] end
		// % protected region % [Add customisation for Total Fluid Intake here] off begin
		newEntity.setTotalFluidIntake(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Fluid Intake here] end
		// % protected region % [Add customisation for Urine here] off begin
		newEntity.setUrine(mockNeat.doubles().get());
		// % protected region % [Add customisation for Urine here] end
		// % protected region % [Add customisation for Others here] off begin
		newEntity.setOthers(mockNeat.doubles().get());
		// % protected region % [Add customisation for Others here] end
		// % protected region % [Add customisation for Total Fluid Output here] off begin
		newEntity.setTotalFluidOutput(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Fluid Output here] end
		// % protected region % [Add customisation for Fluid Balance here] off begin
		newEntity.setFluidBalance(mockNeat.doubles().get());
		// % protected region % [Add customisation for Fluid Balance here] end
		// % protected region % [Add customisation for Post Hemodialysis Evaluation here] off begin
		String randomStringForPostHemodialysisEvaluation = mockNeat
				.strings()
				.size(500)
				.get();
		newEntity.setPostHemodialysisEvaluation(randomStringForPostHemodialysisEvaluation);
		// % protected region % [Add customisation for Post Hemodialysis Evaluation here] end

		// % protected region % [Apply any additional logic for hemodialysisExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
			// % protected region % [Override the reference inclusion for outgoingOneToMany Hemodialysis Monitorings here] off begin
			// Outgoing one to many reference
			var hemodialysisMonitoringsFactory = new HemodialysisMonitoringFactory();
			newEntity.setHemodialysisMonitorings(Collections.singletonList(hemodialysisMonitoringsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Hemodialysis Monitorings here] end

		}

		// % protected region % [Apply any additional logic for hemodialysisExamination with ref here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExamination with ref here] end

		return newEntity;
	}

	@Override
	public Class<HemodialysisExaminationEntity> getObjectType() {
		return HemodialysisExaminationEntity.class;
	}
}