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
 * Guice module for Medical Examination Record Discharge Summary used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalExaminationRecordDischargeSummaryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalExaminationRecordDischargeSummaryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalExaminationRecordDischargeSummaryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalExaminationRecordDischargeSummaryEntityFactory medicalExaminationRecordDischargeSummaryEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalExaminationRecordDischargeSummaryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalExaminationRecordDischargeSummaryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalExaminationRecordDischargeSummaryEntityFactory");

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntityFactory before the main body here] end

		MedicalExaminationRecordDischargeSummaryEntityFactory entityFactory = new MedicalExaminationRecordDischargeSummaryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalExaminationRecordDischargeSummaryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalExaminationRecordDischargeSummaryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntityFactory after the main body here] end

		log.trace("Created MedicalExaminationRecordDischargeSummaryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Examination Record Discharge Summary entity with no references set.
	 */
	@Provides
	@Named("medicalExaminationRecordDischargeSummaryEntityWithNoRef")
	public MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordDischargeSummaryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordDischargeSummaryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalExaminationRecordDischargeSummaryEntity with no reference");

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryWithNoRef before the main body here] end

		MedicalExaminationRecordDischargeSummaryEntity newEntity = new MedicalExaminationRecordDischargeSummaryEntity();
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
		// % protected region % [Add customisation for Discharge Summary here] off begin
		String randomStringforDischargeSummary = mock
				.strings()
				.get();
		newEntity.setDischargeSummary(randomStringforDischargeSummary);
		// % protected region % [Add customisation for Discharge Summary here] end
		// % protected region % [Add customisation for Condition Upon Discharge here] off begin
		String randomStringforConditionUponDischarge = mock
				.strings()
				.get();
		newEntity.setConditionUponDischarge(randomStringforConditionUponDischarge);
		// % protected region % [Add customisation for Condition Upon Discharge here] end
		// % protected region % [Add customisation for Escorted By here] off begin
		String randomStringforEscortedBy = mock
				.strings()
				.get();
		newEntity.setEscortedBy(randomStringforEscortedBy);
		// % protected region % [Add customisation for Escorted By here] end
		// % protected region % [Add customisation for Discharge Reason here] off begin
		String randomStringforDischargeReason = mock
				.strings()
				.get();
		newEntity.setDischargeReason(randomStringforDischargeReason);
		// % protected region % [Add customisation for Discharge Reason here] end

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalExaminationRecordDischargeSummaryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Examination Record Discharge Summary entities with no reference at all.
	 */
	@Provides
	@Named("medicalExaminationRecordDischargeSummaryEntitiesWithNoRef")
	public Collection<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummaryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordDischargeSummaryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordDischargeSummaryEntitiesWithNoRef here] end
		MedicalExaminationRecordDischargeSummaryEntityFactory medicalExaminationRecordDischargeSummaryEntityFactory
	) {
		log.trace("Creating entities of type MedicalExaminationRecordDischargeSummaryEntity with no reference");

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntitiesWithNoRef before the main body here] end

		Collection<MedicalExaminationRecordDischargeSummaryEntity> newEntities = medicalExaminationRecordDischargeSummaryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalExaminationRecordDischargeSummaryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Examination Record Discharge Summary entity with all references set.
	 */
	@Provides
	@Named("medicalExaminationRecordDischargeSummaryEntityWithRefs")
	public MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordDischargeSummaryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordDischargeSummaryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalExaminationRecordDischargeSummaryEntity with references");

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntityWithRefs before the main body here] end

		MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity = injector.getInstance(Key.get(MedicalExaminationRecordDischargeSummaryEntity.class, Names.named("medicalExaminationRecordDischargeSummaryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalExaminationRecordDischargeSummaryEntity with references");

		return medicalExaminationRecordDischargeSummaryEntity;
	}

	/**
	 * Return a collection of Medical Examination Record Discharge Summary entities with all references set.
	 */
	@Provides
	@Named("medicalExaminationRecordDischargeSummaryEntitiesWithRefs")
	public Collection<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummaryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordDischargeSummaryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalExaminationRecordDischargeSummaryEntitiesWithRefs here] end
		MedicalExaminationRecordDischargeSummaryEntityFactory medicalExaminationRecordDischargeSummaryEntityFactory
	) {
		log.trace("Creating entities of type MedicalExaminationRecordDischargeSummaryEntity with references");

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntitiesWithRefs before the main body here] end

		Collection<MedicalExaminationRecordDischargeSummaryEntity> newEntities = medicalExaminationRecordDischargeSummaryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalExaminationRecordDischargeSummaryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalExaminationRecordDischargeSummaryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
