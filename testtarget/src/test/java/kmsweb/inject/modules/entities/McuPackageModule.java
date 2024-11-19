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
 * Guice module for MCU Package used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class McuPackageModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring McuPackageModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured McuPackageModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public McuPackageEntityFactory mcuPackageEntityFactory(
			// % protected region % [Apply any additional injected arguments for mcuPackageEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for mcuPackageEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating McuPackageEntityFactory");

		// % protected region % [Apply any additional logic for mcuPackageEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageEntityFactory before the main body here] end

		McuPackageEntityFactory entityFactory = new McuPackageEntityFactory(
				// % protected region % [Apply any additional constructor arguments for McuPackageEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for McuPackageEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for mcuPackageEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageEntityFactory after the main body here] end

		log.trace("Created McuPackageEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty MCU Package entity with no references set.
	 */
	@Provides
	@Named("mcuPackageEntityWithNoRef")
	public McuPackageEntity mcuPackageEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for mcuPackageEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for mcuPackageEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type McuPackageEntity with no reference");

		// % protected region % [Apply any additional logic for mcuPackageWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageWithNoRef before the main body here] end

		McuPackageEntity newEntity = new McuPackageEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for MCU Package Code here] off begin
		String randomStringforMcuPackageCode = mock
				.strings()
				.get();
		newEntity.setMcuPackageCode(randomStringforMcuPackageCode);
		// % protected region % [Add customisation for MCU Package Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Package Type here] off begin
		String randomStringforPackageType = mock
				.strings()
				.get();
		newEntity.setPackageType(randomStringforPackageType);
		// % protected region % [Add customisation for Package Type here] end
		// % protected region % [Add customisation for Sequence here] off begin
		newEntity.setSequence(mock.ints().get());
		// % protected region % [Add customisation for Sequence here] end

		// % protected region % [Apply any additional logic for mcuPackageWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageWithNoRef after the main body here] end

		log.trace("Created entity of type McuPackageEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of MCU Package entities with no reference at all.
	 */
	@Provides
	@Named("mcuPackageEntitiesWithNoRef")
	public Collection<McuPackageEntity> mcuPackageEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for mcuPackageEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for mcuPackageEntitiesWithNoRef here] end
		McuPackageEntityFactory mcuPackageEntityFactory
	) {
		log.trace("Creating entities of type McuPackageEntity with no reference");

		// % protected region % [Apply any additional logic for mcuPackageEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageEntitiesWithNoRef before the main body here] end

		Collection<McuPackageEntity> newEntities = mcuPackageEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for mcuPackageEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type McuPackageEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a MCU Package entity with all references set.
	 */
	@Provides
	@Named("mcuPackageEntityWithRefs")
	public McuPackageEntity mcuPackageEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for mcuPackageEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for mcuPackageEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type McuPackageEntity with references");

		// % protected region % [Apply any additional logic for mcuPackageEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageEntityWithRefs before the main body here] end

		McuPackageEntity mcuPackageEntity = injector.getInstance(Key.get(McuPackageEntity.class, Names.named("mcuPackageEntityWithNoRef")));

		// % protected region % [Apply any additional logic for mcuPackageEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageEntityWithRefs after the main body here] end

		log.trace("Created entity of type McuPackageEntity with references");

		return mcuPackageEntity;
	}

	/**
	 * Return a collection of MCU Package entities with all references set.
	 */
	@Provides
	@Named("mcuPackageEntitiesWithRefs")
	public Collection<McuPackageEntity> mcuPackageEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for mcuPackageEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for mcuPackageEntitiesWithRefs here] end
		McuPackageEntityFactory mcuPackageEntityFactory
	) {
		log.trace("Creating entities of type McuPackageEntity with references");

		// % protected region % [Apply any additional logic for mcuPackageEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageEntitiesWithRefs before the main body here] end

		Collection<McuPackageEntity> newEntities = mcuPackageEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for mcuPackageEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type McuPackageEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
