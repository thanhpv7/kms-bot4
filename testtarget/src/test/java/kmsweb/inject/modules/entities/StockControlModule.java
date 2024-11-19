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
 * Guice module for Stock Control used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class StockControlModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring StockControlModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured StockControlModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public StockControlEntityFactory stockControlEntityFactory(
			// % protected region % [Apply any additional injected arguments for stockControlEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for stockControlEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating StockControlEntityFactory");

		// % protected region % [Apply any additional logic for stockControlEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlEntityFactory before the main body here] end

		StockControlEntityFactory entityFactory = new StockControlEntityFactory(
				// % protected region % [Apply any additional constructor arguments for StockControlEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for StockControlEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for stockControlEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlEntityFactory after the main body here] end

		log.trace("Created StockControlEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Stock Control entity with no references set.
	 */
	@Provides
	@Named("stockControlEntityWithNoRef")
	public StockControlEntity stockControlEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for stockControlEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for stockControlEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type StockControlEntity with no reference");

		// % protected region % [Apply any additional logic for stockControlWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlWithNoRef before the main body here] end

		StockControlEntity newEntity = new StockControlEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for On Hand Qty here] off begin
		newEntity.setOnHandQty(mock.doubles().get());
		// % protected region % [Add customisation for On Hand Qty here] end
		// % protected region % [Add customisation for Available Qty here] off begin
		newEntity.setAvailableQty(mock.doubles().get());
		// % protected region % [Add customisation for Available Qty here] end
		// % protected region % [Add customisation for On Reserved Qty here] off begin
		newEntity.setOnReservedQty(mock.doubles().get());
		// % protected region % [Add customisation for On Reserved Qty here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for Uoi here] end
		// % protected region % [Add customisation for Min Level here] off begin
		newEntity.setMinLevel(mock.doubles().get());
		// % protected region % [Add customisation for Min Level here] end
		// % protected region % [Add customisation for Max Level here] off begin
		newEntity.setMaxLevel(mock.doubles().get());
		// % protected region % [Add customisation for Max Level here] end
		// % protected region % [Add customisation for In Transit Qty here] off begin
		newEntity.setInTransitQty(mock.doubles().get());
		// % protected region % [Add customisation for In Transit Qty here] end
		// % protected region % [Add customisation for Average Cost here] off begin
		newEntity.setAverageCost(mock.doubles().get());
		// % protected region % [Add customisation for Average Cost here] end

		// % protected region % [Apply any additional logic for stockControlWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlWithNoRef after the main body here] end

		log.trace("Created entity of type StockControlEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Stock Control entities with no reference at all.
	 */
	@Provides
	@Named("stockControlEntitiesWithNoRef")
	public Collection<StockControlEntity> stockControlEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for stockControlEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for stockControlEntitiesWithNoRef here] end
		StockControlEntityFactory stockControlEntityFactory
	) {
		log.trace("Creating entities of type StockControlEntity with no reference");

		// % protected region % [Apply any additional logic for stockControlEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlEntitiesWithNoRef before the main body here] end

		Collection<StockControlEntity> newEntities = stockControlEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for stockControlEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type StockControlEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Stock Control entity with all references set.
	 */
	@Provides
	@Named("stockControlEntityWithRefs")
	public StockControlEntity stockControlEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for stockControlEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for stockControlEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type StockControlEntity with references");

		// % protected region % [Apply any additional logic for stockControlEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlEntityWithRefs before the main body here] end

		StockControlEntity stockControlEntity = injector.getInstance(Key.get(StockControlEntity.class, Names.named("stockControlEntityWithNoRef")));

		// % protected region % [Apply any additional logic for stockControlEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlEntityWithRefs after the main body here] end

		log.trace("Created entity of type StockControlEntity with references");

		return stockControlEntity;
	}

	/**
	 * Return a collection of Stock Control entities with all references set.
	 */
	@Provides
	@Named("stockControlEntitiesWithRefs")
	public Collection<StockControlEntity> stockControlEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for stockControlEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for stockControlEntitiesWithRefs here] end
		StockControlEntityFactory stockControlEntityFactory
	) {
		log.trace("Creating entities of type StockControlEntity with references");

		// % protected region % [Apply any additional logic for stockControlEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlEntitiesWithRefs before the main body here] end

		Collection<StockControlEntity> newEntities = stockControlEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for stockControlEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockControlEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type StockControlEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
