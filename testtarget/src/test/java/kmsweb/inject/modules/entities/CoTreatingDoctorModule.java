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
 * Guice module for Co Treating Doctor used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class CoTreatingDoctorModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring CoTreatingDoctorModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured CoTreatingDoctorModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public CoTreatingDoctorEntityFactory coTreatingDoctorEntityFactory(
			// % protected region % [Apply any additional injected arguments for coTreatingDoctorEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for coTreatingDoctorEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating CoTreatingDoctorEntityFactory");

		// % protected region % [Apply any additional logic for coTreatingDoctorEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorEntityFactory before the main body here] end

		CoTreatingDoctorEntityFactory entityFactory = new CoTreatingDoctorEntityFactory(
				// % protected region % [Apply any additional constructor arguments for CoTreatingDoctorEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for CoTreatingDoctorEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for coTreatingDoctorEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorEntityFactory after the main body here] end

		log.trace("Created CoTreatingDoctorEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Co Treating Doctor entity with no references set.
	 */
	@Provides
	@Named("coTreatingDoctorEntityWithNoRef")
	public CoTreatingDoctorEntity coTreatingDoctorEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for coTreatingDoctorEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for coTreatingDoctorEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type CoTreatingDoctorEntity with no reference");

		// % protected region % [Apply any additional logic for coTreatingDoctorWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorWithNoRef before the main body here] end

		CoTreatingDoctorEntity newEntity = new CoTreatingDoctorEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Doctor Notes here] off begin
		String randomStringforDoctorNotes = mock
				.strings()
				.get();
		newEntity.setDoctorNotes(randomStringforDoctorNotes);
		// % protected region % [Add customisation for Doctor Notes here] end

		// % protected region % [Apply any additional logic for coTreatingDoctorWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorWithNoRef after the main body here] end

		log.trace("Created entity of type CoTreatingDoctorEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Co Treating Doctor entities with no reference at all.
	 */
	@Provides
	@Named("coTreatingDoctorEntitiesWithNoRef")
	public Collection<CoTreatingDoctorEntity> coTreatingDoctorEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for coTreatingDoctorEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for coTreatingDoctorEntitiesWithNoRef here] end
		CoTreatingDoctorEntityFactory coTreatingDoctorEntityFactory
	) {
		log.trace("Creating entities of type CoTreatingDoctorEntity with no reference");

		// % protected region % [Apply any additional logic for coTreatingDoctorEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorEntitiesWithNoRef before the main body here] end

		Collection<CoTreatingDoctorEntity> newEntities = coTreatingDoctorEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for coTreatingDoctorEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type CoTreatingDoctorEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Co Treating Doctor entity with all references set.
	 */
	@Provides
	@Named("coTreatingDoctorEntityWithRefs")
	public CoTreatingDoctorEntity coTreatingDoctorEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for coTreatingDoctorEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for coTreatingDoctorEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type CoTreatingDoctorEntity with references");

		// % protected region % [Apply any additional logic for coTreatingDoctorEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorEntityWithRefs before the main body here] end

		CoTreatingDoctorEntity coTreatingDoctorEntity = injector.getInstance(Key.get(CoTreatingDoctorEntity.class, Names.named("coTreatingDoctorEntityWithNoRef")));

		// % protected region % [Apply any additional logic for coTreatingDoctorEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorEntityWithRefs after the main body here] end

		log.trace("Created entity of type CoTreatingDoctorEntity with references");

		return coTreatingDoctorEntity;
	}

	/**
	 * Return a collection of Co Treating Doctor entities with all references set.
	 */
	@Provides
	@Named("coTreatingDoctorEntitiesWithRefs")
	public Collection<CoTreatingDoctorEntity> coTreatingDoctorEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for coTreatingDoctorEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for coTreatingDoctorEntitiesWithRefs here] end
		CoTreatingDoctorEntityFactory coTreatingDoctorEntityFactory
	) {
		log.trace("Creating entities of type CoTreatingDoctorEntity with references");

		// % protected region % [Apply any additional logic for coTreatingDoctorEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorEntitiesWithRefs before the main body here] end

		Collection<CoTreatingDoctorEntity> newEntities = coTreatingDoctorEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for coTreatingDoctorEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type CoTreatingDoctorEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
