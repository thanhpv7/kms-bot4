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
 * Guice module for Preoperative Records used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PreoperativeRecordsModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PreoperativeRecordsModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PreoperativeRecordsModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PreoperativeRecordsEntityFactory preoperativeRecordsEntityFactory(
			// % protected region % [Apply any additional injected arguments for preoperativeRecordsEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for preoperativeRecordsEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PreoperativeRecordsEntityFactory");

		// % protected region % [Apply any additional logic for preoperativeRecordsEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsEntityFactory before the main body here] end

		PreoperativeRecordsEntityFactory entityFactory = new PreoperativeRecordsEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PreoperativeRecordsEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PreoperativeRecordsEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for preoperativeRecordsEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsEntityFactory after the main body here] end

		log.trace("Created PreoperativeRecordsEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Preoperative Records entity with no references set.
	 */
	@Provides
	@Named("preoperativeRecordsEntityWithNoRef")
	public PreoperativeRecordsEntity preoperativeRecordsEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for preoperativeRecordsEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for preoperativeRecordsEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PreoperativeRecordsEntity with no reference");

		// % protected region % [Apply any additional logic for preoperativeRecordsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsWithNoRef before the main body here] end

		PreoperativeRecordsEntity newEntity = new PreoperativeRecordsEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] off begin
		newEntity.setStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] end
		// % protected region % [Add customisation for End Date Time here] off begin
		newEntity.setEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date Time here] end
		// % protected region % [Add customisation for Physical Status Evaluation here] off begin
		String randomStringforPhysicalStatusEvaluation = mock
				.strings()
				.get();
		newEntity.setPhysicalStatusEvaluation(randomStringforPhysicalStatusEvaluation);
		// % protected region % [Add customisation for Physical Status Evaluation here] end
		// % protected region % [Add customisation for Surgery Risk here] off begin
		String randomStringforSurgeryRisk = mock
				.strings()
				.get();
		newEntity.setSurgeryRisk(randomStringforSurgeryRisk);
		// % protected region % [Add customisation for Surgery Risk here] end
		// % protected region % [Add customisation for Psychological State here] off begin
		String randomStringforPsychologicalState = mock
				.strings()
				.get();
		newEntity.setPsychologicalState(randomStringforPsychologicalState);
		// % protected region % [Add customisation for Psychological State here] end
		// % protected region % [Add customisation for Anesthesia Surgery Risk here] off begin
		String randomStringforAnesthesiaSurgeryRisk = mock
				.strings()
				.get();
		newEntity.setAnesthesiaSurgeryRisk(randomStringforAnesthesiaSurgeryRisk);
		// % protected region % [Add customisation for Anesthesia Surgery Risk here] end
		// % protected region % [Add customisation for Preoperative Evaluation here] off begin
		String randomStringforPreoperativeEvaluation = mock
				.strings()
				.get();
		newEntity.setPreoperativeEvaluation(randomStringforPreoperativeEvaluation);
		// % protected region % [Add customisation for Preoperative Evaluation here] end
		// % protected region % [Add customisation for Anesthesia Notes here] off begin
		String randomStringforAnesthesiaNotes = mock
				.strings()
				.get();
		newEntity.setAnesthesiaNotes(randomStringforAnesthesiaNotes);
		// % protected region % [Add customisation for Anesthesia Notes here] end
		// % protected region % [Add customisation for Surgical Specialty here] off begin
		String randomStringforSurgicalSpecialty = mock
				.strings()
				.get();
		newEntity.setSurgicalSpecialty(randomStringforSurgicalSpecialty);
		// % protected region % [Add customisation for Surgical Specialty here] end
		// % protected region % [Add customisation for Antibiotic Prophylaxis Given here] off begin
		String randomStringforAntibioticProphylaxisGiven = mock
				.strings()
				.get();
		newEntity.setAntibioticProphylaxisGiven(randomStringforAntibioticProphylaxisGiven);
		// % protected region % [Add customisation for Antibiotic Prophylaxis Given here] end
		// % protected region % [Add customisation for Surgery Type here] off begin
		String randomStringforSurgeryType = mock
				.strings()
				.get();
		newEntity.setSurgeryType(randomStringforSurgeryType);
		// % protected region % [Add customisation for Surgery Type here] end
		// % protected region % [Add customisation for Surgery Class here] off begin
		String randomStringforSurgeryClass = mock
				.strings()
				.get();
		newEntity.setSurgeryClass(randomStringforSurgeryClass);
		// % protected region % [Add customisation for Surgery Class here] end
		// % protected region % [Add customisation for Surgical Surgery Risk here] off begin
		String randomStringforSurgicalSurgeryRisk = mock
				.strings()
				.get();
		newEntity.setSurgicalSurgeryRisk(randomStringforSurgicalSurgeryRisk);
		// % protected region % [Add customisation for Surgical Surgery Risk here] end
		// % protected region % [Add customisation for Physical Status Classification here] off begin
		String randomStringforPhysicalStatusClassification = mock
				.strings()
				.get();
		newEntity.setPhysicalStatusClassification(randomStringforPhysicalStatusClassification);
		// % protected region % [Add customisation for Physical Status Classification here] end
		// % protected region % [Add customisation for Pre Surgery Diagnosis here] off begin
		String randomStringforPreSurgeryDiagnosis = mock
				.strings()
				.get();
		newEntity.setPreSurgeryDiagnosis(randomStringforPreSurgeryDiagnosis);
		// % protected region % [Add customisation for Pre Surgery Diagnosis here] end
		// % protected region % [Add customisation for Preoperative Instructions here] off begin
		String randomStringforPreoperativeInstructions = mock
				.strings()
				.get();
		newEntity.setPreoperativeInstructions(randomStringforPreoperativeInstructions);
		// % protected region % [Add customisation for Preoperative Instructions here] end
		// % protected region % [Add customisation for Preoperative Surgical Notes here] off begin
		String randomStringforPreoperativeSurgicalNotes = mock
				.strings()
				.get();
		newEntity.setPreoperativeSurgicalNotes(randomStringforPreoperativeSurgicalNotes);
		// % protected region % [Add customisation for Preoperative Surgical Notes here] end

		// % protected region % [Apply any additional logic for preoperativeRecordsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsWithNoRef after the main body here] end

		log.trace("Created entity of type PreoperativeRecordsEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Preoperative Records entities with no reference at all.
	 */
	@Provides
	@Named("preoperativeRecordsEntitiesWithNoRef")
	public Collection<PreoperativeRecordsEntity> preoperativeRecordsEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for preoperativeRecordsEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for preoperativeRecordsEntitiesWithNoRef here] end
		PreoperativeRecordsEntityFactory preoperativeRecordsEntityFactory
	) {
		log.trace("Creating entities of type PreoperativeRecordsEntity with no reference");

		// % protected region % [Apply any additional logic for preoperativeRecordsEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsEntitiesWithNoRef before the main body here] end

		Collection<PreoperativeRecordsEntity> newEntities = preoperativeRecordsEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for preoperativeRecordsEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PreoperativeRecordsEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Preoperative Records entity with all references set.
	 */
	@Provides
	@Named("preoperativeRecordsEntityWithRefs")
	public PreoperativeRecordsEntity preoperativeRecordsEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for preoperativeRecordsEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for preoperativeRecordsEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PreoperativeRecordsEntity with references");

		// % protected region % [Apply any additional logic for preoperativeRecordsEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsEntityWithRefs before the main body here] end

		PreoperativeRecordsEntity preoperativeRecordsEntity = injector.getInstance(Key.get(PreoperativeRecordsEntity.class, Names.named("preoperativeRecordsEntityWithNoRef")));

		// % protected region % [Apply any additional logic for preoperativeRecordsEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsEntityWithRefs after the main body here] end

		log.trace("Created entity of type PreoperativeRecordsEntity with references");

		return preoperativeRecordsEntity;
	}

	/**
	 * Return a collection of Preoperative Records entities with all references set.
	 */
	@Provides
	@Named("preoperativeRecordsEntitiesWithRefs")
	public Collection<PreoperativeRecordsEntity> preoperativeRecordsEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for preoperativeRecordsEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for preoperativeRecordsEntitiesWithRefs here] end
		PreoperativeRecordsEntityFactory preoperativeRecordsEntityFactory
	) {
		log.trace("Creating entities of type PreoperativeRecordsEntity with references");

		// % protected region % [Apply any additional logic for preoperativeRecordsEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsEntitiesWithRefs before the main body here] end

		Collection<PreoperativeRecordsEntity> newEntities = preoperativeRecordsEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for preoperativeRecordsEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PreoperativeRecordsEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
