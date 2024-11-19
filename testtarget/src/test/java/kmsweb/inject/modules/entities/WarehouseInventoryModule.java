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
 * Guice module for Warehouse Inventory used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class WarehouseInventoryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring WarehouseInventoryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured WarehouseInventoryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public WarehouseInventoryEntityFactory warehouseInventoryEntityFactory(
			// % protected region % [Apply any additional injected arguments for warehouseInventoryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for warehouseInventoryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating WarehouseInventoryEntityFactory");

		// % protected region % [Apply any additional logic for warehouseInventoryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryEntityFactory before the main body here] end

		WarehouseInventoryEntityFactory entityFactory = new WarehouseInventoryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for WarehouseInventoryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for WarehouseInventoryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for warehouseInventoryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryEntityFactory after the main body here] end

		log.trace("Created WarehouseInventoryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Warehouse Inventory entity with no references set.
	 */
	@Provides
	@Named("warehouseInventoryEntityWithNoRef")
	public WarehouseInventoryEntity warehouseInventoryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for warehouseInventoryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for warehouseInventoryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type WarehouseInventoryEntity with no reference");

		// % protected region % [Apply any additional logic for warehouseInventoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryWithNoRef before the main body here] end

		WarehouseInventoryEntity newEntity = new WarehouseInventoryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SOH here] off begin
		newEntity.setSoh(mock.doubles().get());
		// % protected region % [Add customisation for SOH here] end
		// % protected region % [Add customisation for Reserved Quantity here] off begin
		newEntity.setReservedQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Reserved Quantity here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for warehouseInventoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryWithNoRef after the main body here] end

		log.trace("Created entity of type WarehouseInventoryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Warehouse Inventory entities with no reference at all.
	 */
	@Provides
	@Named("warehouseInventoryEntitiesWithNoRef")
	public Collection<WarehouseInventoryEntity> warehouseInventoryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for warehouseInventoryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for warehouseInventoryEntitiesWithNoRef here] end
		WarehouseInventoryEntityFactory warehouseInventoryEntityFactory
	) {
		log.trace("Creating entities of type WarehouseInventoryEntity with no reference");

		// % protected region % [Apply any additional logic for warehouseInventoryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryEntitiesWithNoRef before the main body here] end

		Collection<WarehouseInventoryEntity> newEntities = warehouseInventoryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for warehouseInventoryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type WarehouseInventoryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Warehouse Inventory entity with all references set.
	 */
	@Provides
	@Named("warehouseInventoryEntityWithRefs")
	public WarehouseInventoryEntity warehouseInventoryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for warehouseInventoryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for warehouseInventoryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type WarehouseInventoryEntity with references");

		// % protected region % [Apply any additional logic for warehouseInventoryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryEntityWithRefs before the main body here] end

		WarehouseInventoryEntity warehouseInventoryEntity = injector.getInstance(Key.get(WarehouseInventoryEntity.class, Names.named("warehouseInventoryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for warehouseInventoryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryEntityWithRefs after the main body here] end

		log.trace("Created entity of type WarehouseInventoryEntity with references");

		return warehouseInventoryEntity;
	}

	/**
	 * Return a collection of Warehouse Inventory entities with all references set.
	 */
	@Provides
	@Named("warehouseInventoryEntitiesWithRefs")
	public Collection<WarehouseInventoryEntity> warehouseInventoryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for warehouseInventoryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for warehouseInventoryEntitiesWithRefs here] end
		WarehouseInventoryEntityFactory warehouseInventoryEntityFactory
	) {
		log.trace("Creating entities of type WarehouseInventoryEntity with references");

		// % protected region % [Apply any additional logic for warehouseInventoryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryEntitiesWithRefs before the main body here] end

		Collection<WarehouseInventoryEntity> newEntities = warehouseInventoryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for warehouseInventoryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInventoryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type WarehouseInventoryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
