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
 * Guice module for Location used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class LocationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring LocationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured LocationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public LocationEntityFactory locationEntityFactory(
			// % protected region % [Apply any additional injected arguments for locationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for locationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating LocationEntityFactory");

		// % protected region % [Apply any additional logic for locationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for locationEntityFactory before the main body here] end

		LocationEntityFactory entityFactory = new LocationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for LocationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for LocationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for locationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for locationEntityFactory after the main body here] end

		log.trace("Created LocationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Location entity with no references set.
	 */
	@Provides
	@Named("locationEntityWithNoRef")
	public LocationEntity locationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for locationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for locationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type LocationEntity with no reference");

		// % protected region % [Apply any additional logic for locationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for locationWithNoRef before the main body here] end

		LocationEntity newEntity = new LocationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Location Name here] off begin
		String randomStringforLocationName = mock
				.strings()
				.get();
		newEntity.setLocationName(randomStringforLocationName);
		// % protected region % [Add customisation for Location Name here] end
		// % protected region % [Add customisation for Aisle here] off begin
		String randomStringforAisle = mock
				.strings()
				.get();
		newEntity.setAisle(randomStringforAisle);
		// % protected region % [Add customisation for Aisle here] end
		// % protected region % [Add customisation for Shelf here] off begin
		String randomStringforShelf = mock
				.strings()
				.get();
		newEntity.setShelf(randomStringforShelf);
		// % protected region % [Add customisation for Shelf here] end
		// % protected region % [Add customisation for Bin here] off begin
		String randomStringforBin = mock
				.strings()
				.get();
		newEntity.setBin(randomStringforBin);
		// % protected region % [Add customisation for Bin here] end

		// % protected region % [Apply any additional logic for locationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for locationWithNoRef after the main body here] end

		log.trace("Created entity of type LocationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Location entities with no reference at all.
	 */
	@Provides
	@Named("locationEntitiesWithNoRef")
	public Collection<LocationEntity> locationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for locationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for locationEntitiesWithNoRef here] end
		LocationEntityFactory locationEntityFactory
	) {
		log.trace("Creating entities of type LocationEntity with no reference");

		// % protected region % [Apply any additional logic for locationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for locationEntitiesWithNoRef before the main body here] end

		Collection<LocationEntity> newEntities = locationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for locationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for locationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type LocationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Location entity with all references set.
	 */
	@Provides
	@Named("locationEntityWithRefs")
	public LocationEntity locationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for locationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for locationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type LocationEntity with references");

		// % protected region % [Apply any additional logic for locationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for locationEntityWithRefs before the main body here] end

		LocationEntity locationEntity = injector.getInstance(Key.get(LocationEntity.class, Names.named("locationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for locationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for locationEntityWithRefs after the main body here] end

		log.trace("Created entity of type LocationEntity with references");

		return locationEntity;
	}

	/**
	 * Return a collection of Location entities with all references set.
	 */
	@Provides
	@Named("locationEntitiesWithRefs")
	public Collection<LocationEntity> locationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for locationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for locationEntitiesWithRefs here] end
		LocationEntityFactory locationEntityFactory
	) {
		log.trace("Creating entities of type LocationEntity with references");

		// % protected region % [Apply any additional logic for locationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for locationEntitiesWithRefs before the main body here] end

		Collection<LocationEntity> newEntities = locationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for locationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for locationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type LocationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
