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
 * Guice module for Bed Reserve used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BedReserveModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BedReserveModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BedReserveModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BedReserveEntityFactory bedReserveEntityFactory(
			// % protected region % [Apply any additional injected arguments for bedReserveEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bedReserveEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BedReserveEntityFactory");

		// % protected region % [Apply any additional logic for bedReserveEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveEntityFactory before the main body here] end

		BedReserveEntityFactory entityFactory = new BedReserveEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BedReserveEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BedReserveEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bedReserveEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveEntityFactory after the main body here] end

		log.trace("Created BedReserveEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Bed Reserve entity with no references set.
	 */
	@Provides
	@Named("bedReserveEntityWithNoRef")
	public BedReserveEntity bedReserveEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bedReserveEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bedReserveEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BedReserveEntity with no reference");

		// % protected region % [Apply any additional logic for bedReserveWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveWithNoRef before the main body here] end

		BedReserveEntity newEntity = new BedReserveEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for bedReserveWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveWithNoRef after the main body here] end

		log.trace("Created entity of type BedReserveEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Bed Reserve entities with no reference at all.
	 */
	@Provides
	@Named("bedReserveEntitiesWithNoRef")
	public Collection<BedReserveEntity> bedReserveEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bedReserveEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bedReserveEntitiesWithNoRef here] end
		BedReserveEntityFactory bedReserveEntityFactory
	) {
		log.trace("Creating entities of type BedReserveEntity with no reference");

		// % protected region % [Apply any additional logic for bedReserveEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveEntitiesWithNoRef before the main body here] end

		Collection<BedReserveEntity> newEntities = bedReserveEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bedReserveEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BedReserveEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Bed Reserve entity with all references set.
	 */
	@Provides
	@Named("bedReserveEntityWithRefs")
	public BedReserveEntity bedReserveEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bedReserveEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bedReserveEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BedReserveEntity with references");

		// % protected region % [Apply any additional logic for bedReserveEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveEntityWithRefs before the main body here] end

		BedReserveEntity bedReserveEntity = injector.getInstance(Key.get(BedReserveEntity.class, Names.named("bedReserveEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bedReserveEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveEntityWithRefs after the main body here] end

		log.trace("Created entity of type BedReserveEntity with references");

		return bedReserveEntity;
	}

	/**
	 * Return a collection of Bed Reserve entities with all references set.
	 */
	@Provides
	@Named("bedReserveEntitiesWithRefs")
	public Collection<BedReserveEntity> bedReserveEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bedReserveEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bedReserveEntitiesWithRefs here] end
		BedReserveEntityFactory bedReserveEntityFactory
	) {
		log.trace("Creating entities of type BedReserveEntity with references");

		// % protected region % [Apply any additional logic for bedReserveEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveEntitiesWithRefs before the main body here] end

		Collection<BedReserveEntity> newEntities = bedReserveEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bedReserveEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bedReserveEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BedReserveEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
