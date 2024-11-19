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
 * Guice module for Stock Transaction Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class StockTransactionDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring StockTransactionDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured StockTransactionDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public StockTransactionDetailEntityFactory stockTransactionDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for stockTransactionDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for stockTransactionDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating StockTransactionDetailEntityFactory");

		// % protected region % [Apply any additional logic for stockTransactionDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailEntityFactory before the main body here] end

		StockTransactionDetailEntityFactory entityFactory = new StockTransactionDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for StockTransactionDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for StockTransactionDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for stockTransactionDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailEntityFactory after the main body here] end

		log.trace("Created StockTransactionDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Stock Transaction Detail entity with no references set.
	 */
	@Provides
	@Named("stockTransactionDetailEntityWithNoRef")
	public StockTransactionDetailEntity stockTransactionDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for stockTransactionDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for stockTransactionDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type StockTransactionDetailEntity with no reference");

		// % protected region % [Apply any additional logic for stockTransactionDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailWithNoRef before the main body here] end

		StockTransactionDetailEntity newEntity = new StockTransactionDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Number here] off begin
		String randomStringforTransactionNumber = mock
				.strings()
				.get();
		newEntity.setTransactionNumber(randomStringforTransactionNumber);
		// % protected region % [Add customisation for Transaction Number here] end
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Transaction Type here] off begin
		String randomStringforTransactionType = mock
				.strings()
				.get();
		newEntity.setTransactionType(randomStringforTransactionType);
		// % protected region % [Add customisation for Transaction Type here] end
		// % protected region % [Add customisation for Transaction Notes here] off begin
		String randomStringforTransactionNotes = mock
				.strings()
				.get();
		newEntity.setTransactionNotes(randomStringforTransactionNotes);
		// % protected region % [Add customisation for Transaction Notes here] end
		// % protected region % [Add customisation for Item Line Number here] off begin
		newEntity.setItemLineNumber(mock.ints().get());
		// % protected region % [Add customisation for Item Line Number here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringforItemNotes = mock
				.strings()
				.get();
		newEntity.setItemNotes(randomStringforItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Qty Uoi here] off begin
		newEntity.setQtyUoi(mock.doubles().get());
		// % protected region % [Add customisation for Qty Uoi here] end
		// % protected region % [Add customisation for Qty Uom Transaction here] off begin
		newEntity.setQtyUomTransaction(mock.doubles().get());
		// % protected region % [Add customisation for Qty Uom Transaction here] end
		// % protected region % [Add customisation for Total Cost here] off begin
		newEntity.setTotalCost(mock.doubles().get());
		// % protected region % [Add customisation for Total Cost here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for Uoi here] end
		// % protected region % [Add customisation for Uom Transaction here] off begin
		String randomStringforUomTransaction = mock
				.strings()
				.get();
		newEntity.setUomTransaction(randomStringforUomTransaction);
		// % protected region % [Add customisation for Uom Transaction here] end
		// % protected region % [Add customisation for Source Order Number here] off begin
		String randomStringforSourceOrderNumber = mock
				.strings()
				.get();
		newEntity.setSourceOrderNumber(randomStringforSourceOrderNumber);
		// % protected region % [Add customisation for Source Order Number here] end
		// % protected region % [Add customisation for Qty Transit Uoi here] off begin
		newEntity.setQtyTransitUoi(mock.doubles().get());
		// % protected region % [Add customisation for Qty Transit Uoi here] end
		// % protected region % [Add customisation for Qty Transit Uom Transaction here] off begin
		newEntity.setQtyTransitUomTransaction(mock.doubles().get());
		// % protected region % [Add customisation for Qty Transit Uom Transaction here] end

		// % protected region % [Apply any additional logic for stockTransactionDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailWithNoRef after the main body here] end

		log.trace("Created entity of type StockTransactionDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Stock Transaction Detail entities with no reference at all.
	 */
	@Provides
	@Named("stockTransactionDetailEntitiesWithNoRef")
	public Collection<StockTransactionDetailEntity> stockTransactionDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for stockTransactionDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for stockTransactionDetailEntitiesWithNoRef here] end
		StockTransactionDetailEntityFactory stockTransactionDetailEntityFactory
	) {
		log.trace("Creating entities of type StockTransactionDetailEntity with no reference");

		// % protected region % [Apply any additional logic for stockTransactionDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailEntitiesWithNoRef before the main body here] end

		Collection<StockTransactionDetailEntity> newEntities = stockTransactionDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for stockTransactionDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type StockTransactionDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Stock Transaction Detail entity with all references set.
	 */
	@Provides
	@Named("stockTransactionDetailEntityWithRefs")
	public StockTransactionDetailEntity stockTransactionDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for stockTransactionDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for stockTransactionDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type StockTransactionDetailEntity with references");

		// % protected region % [Apply any additional logic for stockTransactionDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailEntityWithRefs before the main body here] end

		StockTransactionDetailEntity stockTransactionDetailEntity = injector.getInstance(Key.get(StockTransactionDetailEntity.class, Names.named("stockTransactionDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for stockTransactionDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type StockTransactionDetailEntity with references");

		return stockTransactionDetailEntity;
	}

	/**
	 * Return a collection of Stock Transaction Detail entities with all references set.
	 */
	@Provides
	@Named("stockTransactionDetailEntitiesWithRefs")
	public Collection<StockTransactionDetailEntity> stockTransactionDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for stockTransactionDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for stockTransactionDetailEntitiesWithRefs here] end
		StockTransactionDetailEntityFactory stockTransactionDetailEntityFactory
	) {
		log.trace("Creating entities of type StockTransactionDetailEntity with references");

		// % protected region % [Apply any additional logic for stockTransactionDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailEntitiesWithRefs before the main body here] end

		Collection<StockTransactionDetailEntity> newEntities = stockTransactionDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for stockTransactionDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockTransactionDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type StockTransactionDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
