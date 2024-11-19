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
 * Guice module for Nurse Vital Sign Measurement used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NurseVitalSignMeasurementModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NurseVitalSignMeasurementModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NurseVitalSignMeasurementModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NurseVitalSignMeasurementEntityFactory nurseVitalSignMeasurementEntityFactory(
			// % protected region % [Apply any additional injected arguments for nurseVitalSignMeasurementEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nurseVitalSignMeasurementEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NurseVitalSignMeasurementEntityFactory");

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntityFactory before the main body here] end

		NurseVitalSignMeasurementEntityFactory entityFactory = new NurseVitalSignMeasurementEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NurseVitalSignMeasurementEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NurseVitalSignMeasurementEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntityFactory after the main body here] end

		log.trace("Created NurseVitalSignMeasurementEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Nurse Vital Sign Measurement entity with no references set.
	 */
	@Provides
	@Named("nurseVitalSignMeasurementEntityWithNoRef")
	public NurseVitalSignMeasurementEntity nurseVitalSignMeasurementEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nurseVitalSignMeasurementEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nurseVitalSignMeasurementEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NurseVitalSignMeasurementEntity with no reference");

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementWithNoRef before the main body here] end

		NurseVitalSignMeasurementEntity newEntity = new NurseVitalSignMeasurementEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mock.ints().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mock.ints().get());
		// % protected region % [Add customisation for Systole here] end
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
		newEntity.setPulse(mock.ints().get());
		// % protected region % [Add customisation for Pulse here] end
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
		// % protected region % [Add customisation for Total GCS Score here] off begin
		newEntity.setTotalGCSScore(mock.doubles().get());
		// % protected region % [Add customisation for Total GCS Score here] end
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
		// % protected region % [Add customisation for Respiratory here] off begin
		newEntity.setRespiratory(mock.doubles().get());
		// % protected region % [Add customisation for Respiratory here] end
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
		// % protected region % [Add customisation for Risk Fall Scale Used here] off begin
		String randomStringforRiskFallScaleUsed = mock
				.strings()
				.get();
		newEntity.setRiskFallScaleUsed(randomStringforRiskFallScaleUsed);
		// % protected region % [Add customisation for Risk Fall Scale Used here] end

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementWithNoRef after the main body here] end

		log.trace("Created entity of type NurseVitalSignMeasurementEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Nurse Vital Sign Measurement entities with no reference at all.
	 */
	@Provides
	@Named("nurseVitalSignMeasurementEntitiesWithNoRef")
	public Collection<NurseVitalSignMeasurementEntity> nurseVitalSignMeasurementEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nurseVitalSignMeasurementEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nurseVitalSignMeasurementEntitiesWithNoRef here] end
		NurseVitalSignMeasurementEntityFactory nurseVitalSignMeasurementEntityFactory
	) {
		log.trace("Creating entities of type NurseVitalSignMeasurementEntity with no reference");

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntitiesWithNoRef before the main body here] end

		Collection<NurseVitalSignMeasurementEntity> newEntities = nurseVitalSignMeasurementEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NurseVitalSignMeasurementEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Nurse Vital Sign Measurement entity with all references set.
	 */
	@Provides
	@Named("nurseVitalSignMeasurementEntityWithRefs")
	public NurseVitalSignMeasurementEntity nurseVitalSignMeasurementEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nurseVitalSignMeasurementEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nurseVitalSignMeasurementEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NurseVitalSignMeasurementEntity with references");

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntityWithRefs before the main body here] end

		NurseVitalSignMeasurementEntity nurseVitalSignMeasurementEntity = injector.getInstance(Key.get(NurseVitalSignMeasurementEntity.class, Names.named("nurseVitalSignMeasurementEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntityWithRefs after the main body here] end

		log.trace("Created entity of type NurseVitalSignMeasurementEntity with references");

		return nurseVitalSignMeasurementEntity;
	}

	/**
	 * Return a collection of Nurse Vital Sign Measurement entities with all references set.
	 */
	@Provides
	@Named("nurseVitalSignMeasurementEntitiesWithRefs")
	public Collection<NurseVitalSignMeasurementEntity> nurseVitalSignMeasurementEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nurseVitalSignMeasurementEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nurseVitalSignMeasurementEntitiesWithRefs here] end
		NurseVitalSignMeasurementEntityFactory nurseVitalSignMeasurementEntityFactory
	) {
		log.trace("Creating entities of type NurseVitalSignMeasurementEntity with references");

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntitiesWithRefs before the main body here] end

		Collection<NurseVitalSignMeasurementEntity> newEntities = nurseVitalSignMeasurementEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nurseVitalSignMeasurementEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NurseVitalSignMeasurementEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
