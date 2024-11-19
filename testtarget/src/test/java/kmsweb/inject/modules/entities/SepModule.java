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
 * Guice module for SEP used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class SepModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring SepModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured SepModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public SepEntityFactory sepEntityFactory(
			// % protected region % [Apply any additional injected arguments for sepEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for sepEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating SepEntityFactory");

		// % protected region % [Apply any additional logic for sepEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for sepEntityFactory before the main body here] end

		SepEntityFactory entityFactory = new SepEntityFactory(
				// % protected region % [Apply any additional constructor arguments for SepEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for SepEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for sepEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for sepEntityFactory after the main body here] end

		log.trace("Created SepEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty SEP entity with no references set.
	 */
	@Provides
	@Named("sepEntityWithNoRef")
	public SepEntity sepEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for sepEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for sepEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type SepEntity with no reference");

		// % protected region % [Apply any additional logic for sepWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for sepWithNoRef before the main body here] end

		SepEntity newEntity = new SepEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Sep Data here] off begin
		String randomStringforSepData = mock
				.strings()
				.get();
		newEntity.setSepData(randomStringforSepData);
		// % protected region % [Add customisation for Sep Data here] end

		// % protected region % [Apply any additional logic for sepWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for sepWithNoRef after the main body here] end

		log.trace("Created entity of type SepEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of SEP entities with no reference at all.
	 */
	@Provides
	@Named("sepEntitiesWithNoRef")
	public Collection<SepEntity> sepEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for sepEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for sepEntitiesWithNoRef here] end
		SepEntityFactory sepEntityFactory
	) {
		log.trace("Creating entities of type SepEntity with no reference");

		// % protected region % [Apply any additional logic for sepEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for sepEntitiesWithNoRef before the main body here] end

		Collection<SepEntity> newEntities = sepEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for sepEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for sepEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type SepEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a SEP entity with all references set.
	 */
	@Provides
	@Named("sepEntityWithRefs")
	public SepEntity sepEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for sepEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for sepEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type SepEntity with references");

		// % protected region % [Apply any additional logic for sepEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for sepEntityWithRefs before the main body here] end

		SepEntity sepEntity = injector.getInstance(Key.get(SepEntity.class, Names.named("sepEntityWithNoRef")));

		// % protected region % [Apply any additional logic for sepEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for sepEntityWithRefs after the main body here] end

		log.trace("Created entity of type SepEntity with references");

		return sepEntity;
	}

	/**
	 * Return a collection of SEP entities with all references set.
	 */
	@Provides
	@Named("sepEntitiesWithRefs")
	public Collection<SepEntity> sepEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for sepEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for sepEntitiesWithRefs here] end
		SepEntityFactory sepEntityFactory
	) {
		log.trace("Creating entities of type SepEntity with references");

		// % protected region % [Apply any additional logic for sepEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for sepEntitiesWithRefs before the main body here] end

		Collection<SepEntity> newEntities = sepEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for sepEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for sepEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type SepEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
