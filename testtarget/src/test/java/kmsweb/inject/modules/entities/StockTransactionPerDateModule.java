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
 * Guice module for Stock Transaction Per Date used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class StockTransactionPerDateModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring StockTransactionPerDateModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured StockTransactionPerDateModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public StockTransactionPerDateEntityFactory stockTransactionPerDateEntityFactory(
			// % protected region % [Apply any additional injected arguments for stockTransactionPerDateEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for stockTransactionPerDateEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating StockTransactionPerDateEntityFactory");

		// % protected region % [Apply any additional logic for stockTransactionPerDateEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateEntityFactory before the main body here] end

		StockTransactionPerDateEntityFactory entityFactory = new StockTransactionPerDateEntityFactory(
				// % protected region % [Apply any additional constructor arguments for StockTransactionPerDateEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for StockTransactionPerDateEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for stockTransactionPerDateEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateEntityFactory after the main body here] end

		log.trace("Created StockTransactionPerDateEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Stock Transaction Per Date entity with no references set.
	 */
	@Provides
	@Named("stockTransactionPerDateEntityWithNoRef")
	public StockTransactionPerDateEntity stockTransactionPerDateEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type StockTransactionPerDateEntity with no reference");

		// % protected region % [Apply any additional logic for stockTransactionPerDateWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateWithNoRef before the main body here] end

		StockTransactionPerDateEntity newEntity = new StockTransactionPerDateEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for As Of Date here] off begin
		newEntity.setAsOfDate(OffsetDateTime.now());
		// % protected region % [Add customisation for As Of Date here] end
		// % protected region % [Add customisation for Qty Uoi here] off begin
		newEntity.setQtyUoi(mock.doubles().get());
		// % protected region % [Add customisation for Qty Uoi here] end
		// % protected region % [Add customisation for Total Cost here] off begin
		newEntity.setTotalCost(mock.doubles().get());
		// % protected region % [Add customisation for Total Cost here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for Uoi here] end
		// % protected region % [Add customisation for Qty Transit Uoi here] off begin
		newEntity.setQtyTransitUoi(mock.doubles().get());
		// % protected region % [Add customisation for Qty Transit Uoi here] end

		// % protected region % [Apply any additional logic for stockTransactionPerDateWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateWithNoRef after the main body here] end

		log.trace("Created entity of type StockTransactionPerDateEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Stock Transaction Per Date entities with no reference at all.
	 */
	@Provides
	@Named("stockTransactionPerDateEntitiesWithNoRef")
	public Collection<StockTransactionPerDateEntity> stockTransactionPerDateEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateEntitiesWithNoRef here] end
		StockTransactionPerDateEntityFactory stockTransactionPerDateEntityFactory
	) {
		log.trace("Creating entities of type StockTransactionPerDateEntity with no reference");

		// % protected region % [Apply any additional logic for stockTransactionPerDateEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateEntitiesWithNoRef before the main body here] end

		Collection<StockTransactionPerDateEntity> newEntities = stockTransactionPerDateEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for stockTransactionPerDateEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type StockTransactionPerDateEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Stock Transaction Per Date entity with all references set.
	 */
	@Provides
	@Named("stockTransactionPerDateEntityWithRefs")
	public StockTransactionPerDateEntity stockTransactionPerDateEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type StockTransactionPerDateEntity with references");

		// % protected region % [Apply any additional logic for stockTransactionPerDateEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateEntityWithRefs before the main body here] end

		StockTransactionPerDateEntity stockTransactionPerDateEntity = injector.getInstance(Key.get(StockTransactionPerDateEntity.class, Names.named("stockTransactionPerDateEntityWithNoRef")));

		// % protected region % [Apply any additional logic for stockTransactionPerDateEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateEntityWithRefs after the main body here] end

		log.trace("Created entity of type StockTransactionPerDateEntity with references");

		return stockTransactionPerDateEntity;
	}

	/**
	 * Return a collection of Stock Transaction Per Date entities with all references set.
	 */
	@Provides
	@Named("stockTransactionPerDateEntitiesWithRefs")
	public Collection<StockTransactionPerDateEntity> stockTransactionPerDateEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateEntitiesWithRefs here] end
		StockTransactionPerDateEntityFactory stockTransactionPerDateEntityFactory
	) {
		log.trace("Creating entities of type StockTransactionPerDateEntity with references");

		// % protected region % [Apply any additional logic for stockTransactionPerDateEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateEntitiesWithRefs before the main body here] end

		Collection<StockTransactionPerDateEntity> newEntities = stockTransactionPerDateEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for stockTransactionPerDateEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type StockTransactionPerDateEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
