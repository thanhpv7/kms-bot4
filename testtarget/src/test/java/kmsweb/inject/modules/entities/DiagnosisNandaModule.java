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
 * Guice module for Diagnosis Nanda used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DiagnosisNandaModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DiagnosisNandaModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DiagnosisNandaModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DiagnosisNandaEntityFactory diagnosisNandaEntityFactory(
			// % protected region % [Apply any additional injected arguments for diagnosisNandaEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for diagnosisNandaEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DiagnosisNandaEntityFactory");

		// % protected region % [Apply any additional logic for diagnosisNandaEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaEntityFactory before the main body here] end

		DiagnosisNandaEntityFactory entityFactory = new DiagnosisNandaEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DiagnosisNandaEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DiagnosisNandaEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for diagnosisNandaEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaEntityFactory after the main body here] end

		log.trace("Created DiagnosisNandaEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Diagnosis Nanda entity with no references set.
	 */
	@Provides
	@Named("diagnosisNandaEntityWithNoRef")
	public DiagnosisNandaEntity diagnosisNandaEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for diagnosisNandaEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosisNandaEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DiagnosisNandaEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosisNandaWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaWithNoRef before the main body here] end

		DiagnosisNandaEntity newEntity = new DiagnosisNandaEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Nursing Notes here] off begin
		String randomStringforNursingNotes = mock
				.strings()
				.get();
		newEntity.setNursingNotes(randomStringforNursingNotes);
		// % protected region % [Add customisation for Nursing Notes here] end
		// % protected region % [Add customisation for Sequence here] off begin
		newEntity.setSequence(mock.ints().get());
		// % protected region % [Add customisation for Sequence here] end

		// % protected region % [Apply any additional logic for diagnosisNandaWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaWithNoRef after the main body here] end

		log.trace("Created entity of type DiagnosisNandaEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Diagnosis Nanda entities with no reference at all.
	 */
	@Provides
	@Named("diagnosisNandaEntitiesWithNoRef")
	public Collection<DiagnosisNandaEntity> diagnosisNandaEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for diagnosisNandaEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosisNandaEntitiesWithNoRef here] end
		DiagnosisNandaEntityFactory diagnosisNandaEntityFactory
	) {
		log.trace("Creating entities of type DiagnosisNandaEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosisNandaEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaEntitiesWithNoRef before the main body here] end

		Collection<DiagnosisNandaEntity> newEntities = diagnosisNandaEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for diagnosisNandaEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DiagnosisNandaEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Diagnosis Nanda entity with all references set.
	 */
	@Provides
	@Named("diagnosisNandaEntityWithRefs")
	public DiagnosisNandaEntity diagnosisNandaEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for diagnosisNandaEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosisNandaEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DiagnosisNandaEntity with references");

		// % protected region % [Apply any additional logic for diagnosisNandaEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaEntityWithRefs before the main body here] end

		DiagnosisNandaEntity diagnosisNandaEntity = injector.getInstance(Key.get(DiagnosisNandaEntity.class, Names.named("diagnosisNandaEntityWithNoRef")));

		// % protected region % [Apply any additional logic for diagnosisNandaEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaEntityWithRefs after the main body here] end

		log.trace("Created entity of type DiagnosisNandaEntity with references");

		return diagnosisNandaEntity;
	}

	/**
	 * Return a collection of Diagnosis Nanda entities with all references set.
	 */
	@Provides
	@Named("diagnosisNandaEntitiesWithRefs")
	public Collection<DiagnosisNandaEntity> diagnosisNandaEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for diagnosisNandaEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosisNandaEntitiesWithRefs here] end
		DiagnosisNandaEntityFactory diagnosisNandaEntityFactory
	) {
		log.trace("Creating entities of type DiagnosisNandaEntity with references");

		// % protected region % [Apply any additional logic for diagnosisNandaEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaEntitiesWithRefs before the main body here] end

		Collection<DiagnosisNandaEntity> newEntities = diagnosisNandaEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for diagnosisNandaEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisNandaEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DiagnosisNandaEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
