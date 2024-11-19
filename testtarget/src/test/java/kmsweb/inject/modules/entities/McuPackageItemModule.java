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
 * Guice module for MCU Package Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class McuPackageItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring McuPackageItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured McuPackageItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public McuPackageItemEntityFactory mcuPackageItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for mcuPackageItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for mcuPackageItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating McuPackageItemEntityFactory");

		// % protected region % [Apply any additional logic for mcuPackageItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemEntityFactory before the main body here] end

		McuPackageItemEntityFactory entityFactory = new McuPackageItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for McuPackageItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for McuPackageItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for mcuPackageItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemEntityFactory after the main body here] end

		log.trace("Created McuPackageItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty MCU Package Item entity with no references set.
	 */
	@Provides
	@Named("mcuPackageItemEntityWithNoRef")
	public McuPackageItemEntity mcuPackageItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for mcuPackageItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for mcuPackageItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type McuPackageItemEntity with no reference");

		// % protected region % [Apply any additional logic for mcuPackageItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemWithNoRef before the main body here] end

		McuPackageItemEntity newEntity = new McuPackageItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Code here] off begin
		String randomStringforItemCode = mock
				.strings()
				.get();
		newEntity.setItemCode(randomStringforItemCode);
		// % protected region % [Add customisation for Item Code here] end
		// % protected region % [Add customisation for Duration here] off begin
		newEntity.setDuration(mock.ints().get());
		// % protected region % [Add customisation for Duration here] end
		// % protected region % [Add customisation for Sequence here] off begin
		newEntity.setSequence(mock.ints().get());
		// % protected region % [Add customisation for Sequence here] end

		// % protected region % [Apply any additional logic for mcuPackageItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemWithNoRef after the main body here] end

		log.trace("Created entity of type McuPackageItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of MCU Package Item entities with no reference at all.
	 */
	@Provides
	@Named("mcuPackageItemEntitiesWithNoRef")
	public Collection<McuPackageItemEntity> mcuPackageItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for mcuPackageItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for mcuPackageItemEntitiesWithNoRef here] end
		McuPackageItemEntityFactory mcuPackageItemEntityFactory
	) {
		log.trace("Creating entities of type McuPackageItemEntity with no reference");

		// % protected region % [Apply any additional logic for mcuPackageItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemEntitiesWithNoRef before the main body here] end

		Collection<McuPackageItemEntity> newEntities = mcuPackageItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for mcuPackageItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type McuPackageItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a MCU Package Item entity with all references set.
	 */
	@Provides
	@Named("mcuPackageItemEntityWithRefs")
	public McuPackageItemEntity mcuPackageItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for mcuPackageItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for mcuPackageItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type McuPackageItemEntity with references");

		// % protected region % [Apply any additional logic for mcuPackageItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemEntityWithRefs before the main body here] end

		McuPackageItemEntity mcuPackageItemEntity = injector.getInstance(Key.get(McuPackageItemEntity.class, Names.named("mcuPackageItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for mcuPackageItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type McuPackageItemEntity with references");

		return mcuPackageItemEntity;
	}

	/**
	 * Return a collection of MCU Package Item entities with all references set.
	 */
	@Provides
	@Named("mcuPackageItemEntitiesWithRefs")
	public Collection<McuPackageItemEntity> mcuPackageItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for mcuPackageItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for mcuPackageItemEntitiesWithRefs here] end
		McuPackageItemEntityFactory mcuPackageItemEntityFactory
	) {
		log.trace("Creating entities of type McuPackageItemEntity with references");

		// % protected region % [Apply any additional logic for mcuPackageItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemEntitiesWithRefs before the main body here] end

		Collection<McuPackageItemEntity> newEntities = mcuPackageItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for mcuPackageItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for mcuPackageItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type McuPackageItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
