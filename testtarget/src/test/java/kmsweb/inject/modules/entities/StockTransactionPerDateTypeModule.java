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
 * Guice module for Stock Transaction Per Date Type used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class StockTransactionPerDateTypeModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring StockTransactionPerDateTypeModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured StockTransactionPerDateTypeModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public StockTransactionPerDateTypeEntityFactory stockTransactionPerDateTypeEntityFactory(
			// % protected region % [Apply any additional injected arguments for stockTransactionPerDateTypeEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for stockTransactionPerDateTypeEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating StockTransactionPerDateTypeEntityFactory");

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntityFactory before the main body here] end

		StockTransactionPerDateTypeEntityFactory entityFactory = new StockTransactionPerDateTypeEntityFactory(
				// % protected region % [Apply any additional constructor arguments for StockTransactionPerDateTypeEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for StockTransactionPerDateTypeEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntityFactory after the main body here] end

		log.trace("Created StockTransactionPerDateTypeEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Stock Transaction Per Date Type entity with no references set.
	 */
	@Provides
	@Named("stockTransactionPerDateTypeEntityWithNoRef")
	public StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateTypeEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateTypeEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type StockTransactionPerDateTypeEntity with no reference");

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeWithNoRef before the main body here] end

		StockTransactionPerDateTypeEntity newEntity = new StockTransactionPerDateTypeEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for As Of Date here] off begin
		newEntity.setAsOfDate(OffsetDateTime.now());
		// % protected region % [Add customisation for As Of Date here] end
		// % protected region % [Add customisation for Transaction Type here] off begin
		String randomStringforTransactionType = mock
				.strings()
				.get();
		newEntity.setTransactionType(randomStringforTransactionType);
		// % protected region % [Add customisation for Transaction Type here] end
		// % protected region % [Add customisation for Qty Uoi here] off begin
		newEntity.setQtyUoi(mock.doubles().get());
		// % protected region % [Add customisation for Qty Uoi here] end

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeWithNoRef after the main body here] end

		log.trace("Created entity of type StockTransactionPerDateTypeEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Stock Transaction Per Date Type entities with no reference at all.
	 */
	@Provides
	@Named("stockTransactionPerDateTypeEntitiesWithNoRef")
	public Collection<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypeEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateTypeEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateTypeEntitiesWithNoRef here] end
		StockTransactionPerDateTypeEntityFactory stockTransactionPerDateTypeEntityFactory
	) {
		log.trace("Creating entities of type StockTransactionPerDateTypeEntity with no reference");

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntitiesWithNoRef before the main body here] end

		Collection<StockTransactionPerDateTypeEntity> newEntities = stockTransactionPerDateTypeEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type StockTransactionPerDateTypeEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Stock Transaction Per Date Type entity with all references set.
	 */
	@Provides
	@Named("stockTransactionPerDateTypeEntityWithRefs")
	public StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateTypeEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateTypeEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type StockTransactionPerDateTypeEntity with references");

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntityWithRefs before the main body here] end

		StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntity = injector.getInstance(Key.get(StockTransactionPerDateTypeEntity.class, Names.named("stockTransactionPerDateTypeEntityWithNoRef")));

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntityWithRefs after the main body here] end

		log.trace("Created entity of type StockTransactionPerDateTypeEntity with references");

		return stockTransactionPerDateTypeEntity;
	}

	/**
	 * Return a collection of Stock Transaction Per Date Type entities with all references set.
	 */
	@Provides
	@Named("stockTransactionPerDateTypeEntitiesWithRefs")
	public Collection<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypeEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateTypeEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for stockTransactionPerDateTypeEntitiesWithRefs here] end
		StockTransactionPerDateTypeEntityFactory stockTransactionPerDateTypeEntityFactory
	) {
		log.trace("Creating entities of type StockTransactionPerDateTypeEntity with references");

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntitiesWithRefs before the main body here] end

		Collection<StockTransactionPerDateTypeEntity> newEntities = stockTransactionPerDateTypeEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionPerDateTypeEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type StockTransactionPerDateTypeEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}