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
 * Guice module for Warehouse Initial Stock  used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class WarehouseInitialStockModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring WarehouseInitialStockModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured WarehouseInitialStockModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public WarehouseInitialStockEntityFactory warehouseInitialStockEntityFactory(
			// % protected region % [Apply any additional injected arguments for warehouseInitialStockEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for warehouseInitialStockEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating WarehouseInitialStockEntityFactory");

		// % protected region % [Apply any additional logic for warehouseInitialStockEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockEntityFactory before the main body here] end

		WarehouseInitialStockEntityFactory entityFactory = new WarehouseInitialStockEntityFactory(
				// % protected region % [Apply any additional constructor arguments for WarehouseInitialStockEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for WarehouseInitialStockEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for warehouseInitialStockEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockEntityFactory after the main body here] end

		log.trace("Created WarehouseInitialStockEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Warehouse Initial Stock  entity with no references set.
	 */
	@Provides
	@Named("warehouseInitialStockEntityWithNoRef")
	public WarehouseInitialStockEntity warehouseInitialStockEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for warehouseInitialStockEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for warehouseInitialStockEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type WarehouseInitialStockEntity with no reference");

		// % protected region % [Apply any additional logic for warehouseInitialStockWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockWithNoRef before the main body here] end

		WarehouseInitialStockEntity newEntity = new WarehouseInitialStockEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Minimum Level here] off begin
		newEntity.setMinimumLevel(mock.doubles().get());
		// % protected region % [Add customisation for Minimum Level here] end
		// % protected region % [Add customisation for Maximum Level here] off begin
		newEntity.setMaximumLevel(mock.doubles().get());
		// % protected region % [Add customisation for Maximum Level here] end

		// % protected region % [Apply any additional logic for warehouseInitialStockWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockWithNoRef after the main body here] end

		log.trace("Created entity of type WarehouseInitialStockEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Warehouse Initial Stock  entities with no reference at all.
	 */
	@Provides
	@Named("warehouseInitialStockEntitiesWithNoRef")
	public Collection<WarehouseInitialStockEntity> warehouseInitialStockEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for warehouseInitialStockEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for warehouseInitialStockEntitiesWithNoRef here] end
		WarehouseInitialStockEntityFactory warehouseInitialStockEntityFactory
	) {
		log.trace("Creating entities of type WarehouseInitialStockEntity with no reference");

		// % protected region % [Apply any additional logic for warehouseInitialStockEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockEntitiesWithNoRef before the main body here] end

		Collection<WarehouseInitialStockEntity> newEntities = warehouseInitialStockEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for warehouseInitialStockEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type WarehouseInitialStockEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Warehouse Initial Stock  entity with all references set.
	 */
	@Provides
	@Named("warehouseInitialStockEntityWithRefs")
	public WarehouseInitialStockEntity warehouseInitialStockEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for warehouseInitialStockEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for warehouseInitialStockEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type WarehouseInitialStockEntity with references");

		// % protected region % [Apply any additional logic for warehouseInitialStockEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockEntityWithRefs before the main body here] end

		WarehouseInitialStockEntity warehouseInitialStockEntity = injector.getInstance(Key.get(WarehouseInitialStockEntity.class, Names.named("warehouseInitialStockEntityWithNoRef")));

		// % protected region % [Apply any additional logic for warehouseInitialStockEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockEntityWithRefs after the main body here] end

		log.trace("Created entity of type WarehouseInitialStockEntity with references");

		return warehouseInitialStockEntity;
	}

	/**
	 * Return a collection of Warehouse Initial Stock  entities with all references set.
	 */
	@Provides
	@Named("warehouseInitialStockEntitiesWithRefs")
	public Collection<WarehouseInitialStockEntity> warehouseInitialStockEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for warehouseInitialStockEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for warehouseInitialStockEntitiesWithRefs here] end
		WarehouseInitialStockEntityFactory warehouseInitialStockEntityFactory
	) {
		log.trace("Creating entities of type WarehouseInitialStockEntity with references");

		// % protected region % [Apply any additional logic for warehouseInitialStockEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockEntitiesWithRefs before the main body here] end

		Collection<WarehouseInitialStockEntity> newEntities = warehouseInitialStockEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for warehouseInitialStockEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseInitialStockEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type WarehouseInitialStockEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
