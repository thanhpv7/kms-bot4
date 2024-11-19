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
 * Guice module for Patient Vital Information used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientVitalInformationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientVitalInformationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientVitalInformationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientVitalInformationEntityFactory patientVitalInformationEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientVitalInformationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientVitalInformationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientVitalInformationEntityFactory");

		// % protected region % [Apply any additional logic for patientVitalInformationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationEntityFactory before the main body here] end

		PatientVitalInformationEntityFactory entityFactory = new PatientVitalInformationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientVitalInformationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientVitalInformationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientVitalInformationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationEntityFactory after the main body here] end

		log.trace("Created PatientVitalInformationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Vital Information entity with no references set.
	 */
	@Provides
	@Named("patientVitalInformationEntityWithNoRef")
	public PatientVitalInformationEntity patientVitalInformationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientVitalInformationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVitalInformationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientVitalInformationEntity with no reference");

		// % protected region % [Apply any additional logic for patientVitalInformationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationWithNoRef before the main body here] end

		PatientVitalInformationEntity newEntity = new PatientVitalInformationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Record Date Time here] off begin
		newEntity.setRecordDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Record Date Time here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mock.doubles().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mock.doubles().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Temperature here] off begin
		newEntity.setTemperature(mock.doubles().get());
		// % protected region % [Add customisation for Temperature here] end
		// % protected region % [Add customisation for Temperature Scale here] off begin
		String randomStringforTemperatureScale = mock
				.strings()
				.get();
		newEntity.setTemperatureScale(randomStringforTemperatureScale);
		// % protected region % [Add customisation for Temperature Scale here] end
		// % protected region % [Add customisation for Consciousness here] off begin
		String randomStringforConsciousness = mock
				.strings()
				.get();
		newEntity.setConsciousness(randomStringforConsciousness);
		// % protected region % [Add customisation for Consciousness here] end
		// % protected region % [Add customisation for Pulse here] off begin
		newEntity.setPulse(mock.doubles().get());
		// % protected region % [Add customisation for Pulse here] end
		// % protected region % [Add customisation for Pulse Rhythm here] off begin
		String randomStringforPulseRhythm = mock
				.strings()
				.get();
		newEntity.setPulseRhythm(randomStringforPulseRhythm);
		// % protected region % [Add customisation for Pulse Rhythm here] end
		// % protected region % [Add customisation for Strength here] off begin
		String randomStringforStrength = mock
				.strings()
				.get();
		newEntity.setStrength(randomStringforStrength);
		// % protected region % [Add customisation for Strength here] end
		// % protected region % [Add customisation for Gcs Eyes here] off begin
		String randomStringforGcsEyes = mock
				.strings()
				.get();
		newEntity.setGcsEyes(randomStringforGcsEyes);
		// % protected region % [Add customisation for Gcs Eyes here] end
		// % protected region % [Add customisation for Gcs Verbal here] off begin
		String randomStringforGcsVerbal = mock
				.strings()
				.get();
		newEntity.setGcsVerbal(randomStringforGcsVerbal);
		// % protected region % [Add customisation for Gcs Verbal here] end
		// % protected region % [Add customisation for Gcs Motor here] off begin
		String randomStringforGcsMotor = mock
				.strings()
				.get();
		newEntity.setGcsMotor(randomStringforGcsMotor);
		// % protected region % [Add customisation for Gcs Motor here] end
		// % protected region % [Add customisation for Total Gcs Score here] off begin
		newEntity.setTotalGcsScore(mock.doubles().get());
		// % protected region % [Add customisation for Total Gcs Score here] end
		// % protected region % [Add customisation for Respiratory here] off begin
		String randomStringforRespiratory = mock
				.strings()
				.get();
		newEntity.setRespiratory(randomStringforRespiratory);
		// % protected region % [Add customisation for Respiratory here] end
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
		// % protected region % [Add customisation for Bmi here] off begin
		newEntity.setBmi(mock.doubles().get());
		// % protected region % [Add customisation for Bmi here] end
		// % protected region % [Add customisation for Oxygen Saturation here] off begin
		newEntity.setOxygenSaturation(mock.doubles().get());
		// % protected region % [Add customisation for Oxygen Saturation here] end
		// % protected region % [Add customisation for Nutrition Status here] off begin
		String randomStringforNutritionStatus = mock
				.strings()
				.get();
		newEntity.setNutritionStatus(randomStringforNutritionStatus);
		// % protected region % [Add customisation for Nutrition Status here] end
		// % protected region % [Add customisation for Waist Circumference here] off begin
		newEntity.setWaistCircumference(mock.doubles().get());
		// % protected region % [Add customisation for Waist Circumference here] end
		// % protected region % [Add customisation for Waist Circumference Unit here] off begin
		String randomStringforWaistCircumferenceUnit = mock
				.strings()
				.get();
		newEntity.setWaistCircumferenceUnit(randomStringforWaistCircumferenceUnit);
		// % protected region % [Add customisation for Waist Circumference Unit here] end
		// % protected region % [Add customisation for Pain Scale here] off begin
		newEntity.setPainScale(mock.doubles().get());
		// % protected region % [Add customisation for Pain Scale here] end
		// % protected region % [Add customisation for Pain Scale Used here] off begin
		String randomStringforPainScaleUsed = mock
				.strings()
				.get();
		newEntity.setPainScaleUsed(randomStringforPainScaleUsed);
		// % protected region % [Add customisation for Pain Scale Used here] end
		// % protected region % [Add customisation for Risk Fall Scale here] off begin
		newEntity.setRiskFallScale(mock.doubles().get());
		// % protected region % [Add customisation for Risk Fall Scale here] end
		// % protected region % [Add customisation for Risk Fall Scale Used here] off begin
		String randomStringforRiskFallScaleUsed = mock
				.strings()
				.get();
		newEntity.setRiskFallScaleUsed(randomStringforRiskFallScaleUsed);
		// % protected region % [Add customisation for Risk Fall Scale Used here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for patientVitalInformationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationWithNoRef after the main body here] end

		log.trace("Created entity of type PatientVitalInformationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Vital Information entities with no reference at all.
	 */
	@Provides
	@Named("patientVitalInformationEntitiesWithNoRef")
	public Collection<PatientVitalInformationEntity> patientVitalInformationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientVitalInformationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVitalInformationEntitiesWithNoRef here] end
		PatientVitalInformationEntityFactory patientVitalInformationEntityFactory
	) {
		log.trace("Creating entities of type PatientVitalInformationEntity with no reference");

		// % protected region % [Apply any additional logic for patientVitalInformationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationEntitiesWithNoRef before the main body here] end

		Collection<PatientVitalInformationEntity> newEntities = patientVitalInformationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientVitalInformationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientVitalInformationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Vital Information entity with all references set.
	 */
	@Provides
	@Named("patientVitalInformationEntityWithRefs")
	public PatientVitalInformationEntity patientVitalInformationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientVitalInformationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVitalInformationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientVitalInformationEntity with references");

		// % protected region % [Apply any additional logic for patientVitalInformationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationEntityWithRefs before the main body here] end

		PatientVitalInformationEntity patientVitalInformationEntity = injector.getInstance(Key.get(PatientVitalInformationEntity.class, Names.named("patientVitalInformationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientVitalInformationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientVitalInformationEntity with references");

		return patientVitalInformationEntity;
	}

	/**
	 * Return a collection of Patient Vital Information entities with all references set.
	 */
	@Provides
	@Named("patientVitalInformationEntitiesWithRefs")
	public Collection<PatientVitalInformationEntity> patientVitalInformationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientVitalInformationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVitalInformationEntitiesWithRefs here] end
		PatientVitalInformationEntityFactory patientVitalInformationEntityFactory
	) {
		log.trace("Creating entities of type PatientVitalInformationEntity with references");

		// % protected region % [Apply any additional logic for patientVitalInformationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationEntitiesWithRefs before the main body here] end

		Collection<PatientVitalInformationEntity> newEntities = patientVitalInformationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientVitalInformationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientVitalInformationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
