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
 * Guice module for Patient Case History used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientCaseHistoryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientCaseHistoryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientCaseHistoryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientCaseHistoryEntityFactory patientCaseHistoryEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientCaseHistoryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientCaseHistoryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientCaseHistoryEntityFactory");

		// % protected region % [Apply any additional logic for patientCaseHistoryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryEntityFactory before the main body here] end

		PatientCaseHistoryEntityFactory entityFactory = new PatientCaseHistoryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientCaseHistoryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientCaseHistoryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientCaseHistoryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryEntityFactory after the main body here] end

		log.trace("Created PatientCaseHistoryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Case History entity with no references set.
	 */
	@Provides
	@Named("patientCaseHistoryEntityWithNoRef")
	public PatientCaseHistoryEntity patientCaseHistoryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientCaseHistoryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientCaseHistoryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientCaseHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for patientCaseHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryWithNoRef before the main body here] end

		PatientCaseHistoryEntity newEntity = new PatientCaseHistoryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Allergy here] off begin
		String randomStringforAllergy = mock
				.strings()
				.get();
		newEntity.setAllergy(randomStringforAllergy);
		// % protected region % [Add customisation for Allergy here] end
		// % protected region % [Add customisation for Disability Notes here] off begin
		String randomStringforDisabilityNotes = mock
				.strings()
				.get();
		newEntity.setDisabilityNotes(randomStringforDisabilityNotes);
		// % protected region % [Add customisation for Disability Notes here] end
		// % protected region % [Add customisation for History of Disease here] off begin
		String randomStringforHistoryOfDisease = mock
				.strings()
				.get();
		newEntity.setHistoryOfDisease(randomStringforHistoryOfDisease);
		// % protected region % [Add customisation for History of Disease here] end
		// % protected region % [Add customisation for Case History Date Time here] off begin
		newEntity.setCaseHistoryDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Case History Date Time here] end
		// % protected region % [Add customisation for Patient Habits here] off begin
		String randomStringforPatientHabits = mock
				.strings()
				.get();
		newEntity.setPatientHabits(randomStringforPatientHabits);
		// % protected region % [Add customisation for Patient Habits here] end
		// % protected region % [Add customisation for Nutrition HIstory here] off begin
		String randomStringforNutritionHIstory = mock
				.strings()
				.get();
		newEntity.setNutritionHIstory(randomStringforNutritionHIstory);
		// % protected region % [Add customisation for Nutrition HIstory here] end
		// % protected region % [Add customisation for Family History here] off begin
		String randomStringforFamilyHistory = mock
				.strings()
				.get();
		newEntity.setFamilyHistory(randomStringforFamilyHistory);
		// % protected region % [Add customisation for Family History here] end

		// % protected region % [Apply any additional logic for patientCaseHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryWithNoRef after the main body here] end

		log.trace("Created entity of type PatientCaseHistoryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Case History entities with no reference at all.
	 */
	@Provides
	@Named("patientCaseHistoryEntitiesWithNoRef")
	public Collection<PatientCaseHistoryEntity> patientCaseHistoryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientCaseHistoryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientCaseHistoryEntitiesWithNoRef here] end
		PatientCaseHistoryEntityFactory patientCaseHistoryEntityFactory
	) {
		log.trace("Creating entities of type PatientCaseHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for patientCaseHistoryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryEntitiesWithNoRef before the main body here] end

		Collection<PatientCaseHistoryEntity> newEntities = patientCaseHistoryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientCaseHistoryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientCaseHistoryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Case History entity with all references set.
	 */
	@Provides
	@Named("patientCaseHistoryEntityWithRefs")
	public PatientCaseHistoryEntity patientCaseHistoryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientCaseHistoryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientCaseHistoryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientCaseHistoryEntity with references");

		// % protected region % [Apply any additional logic for patientCaseHistoryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryEntityWithRefs before the main body here] end

		PatientCaseHistoryEntity patientCaseHistoryEntity = injector.getInstance(Key.get(PatientCaseHistoryEntity.class, Names.named("patientCaseHistoryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientCaseHistoryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientCaseHistoryEntity with references");

		return patientCaseHistoryEntity;
	}

	/**
	 * Return a collection of Patient Case History entities with all references set.
	 */
	@Provides
	@Named("patientCaseHistoryEntitiesWithRefs")
	public Collection<PatientCaseHistoryEntity> patientCaseHistoryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientCaseHistoryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientCaseHistoryEntitiesWithRefs here] end
		PatientCaseHistoryEntityFactory patientCaseHistoryEntityFactory
	) {
		log.trace("Creating entities of type PatientCaseHistoryEntity with references");

		// % protected region % [Apply any additional logic for patientCaseHistoryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryEntitiesWithRefs before the main body here] end

		Collection<PatientCaseHistoryEntity> newEntities = patientCaseHistoryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientCaseHistoryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientCaseHistoryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
