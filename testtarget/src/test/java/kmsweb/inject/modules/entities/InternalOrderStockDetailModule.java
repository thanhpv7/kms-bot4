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
 * Guice module for Internal Order Stock Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InternalOrderStockDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InternalOrderStockDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InternalOrderStockDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InternalOrderStockDetailEntityFactory internalOrderStockDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for internalOrderStockDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for internalOrderStockDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InternalOrderStockDetailEntityFactory");

		// % protected region % [Apply any additional logic for internalOrderStockDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailEntityFactory before the main body here] end

		InternalOrderStockDetailEntityFactory entityFactory = new InternalOrderStockDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InternalOrderStockDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InternalOrderStockDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for internalOrderStockDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailEntityFactory after the main body here] end

		log.trace("Created InternalOrderStockDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Internal Order Stock Detail entity with no references set.
	 */
	@Provides
	@Named("internalOrderStockDetailEntityWithNoRef")
	public InternalOrderStockDetailEntity internalOrderStockDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for internalOrderStockDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for internalOrderStockDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InternalOrderStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for internalOrderStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailWithNoRef before the main body here] end

		InternalOrderStockDetailEntity newEntity = new InternalOrderStockDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Number here] off begin
		newEntity.setItemNumber(mock.ints().get());
		// % protected region % [Add customisation for Item Number here] end
		// % protected region % [Add customisation for Source Available Quantity here] off begin
		newEntity.setSourceAvailableQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Source Available Quantity here] end
		// % protected region % [Add customisation for Quantity Ordered here] off begin
		newEntity.setQuantityOrdered(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Ordered here] end
		// % protected region % [Add customisation for uom here] off begin
		String randomStringforUom = mock
				.strings()
				.get();
		newEntity.setUom(randomStringforUom);
		// % protected region % [Add customisation for uom here] end
		// % protected region % [Add customisation for Transaction Status here] off begin
		String randomStringforTransactionStatus = mock
				.strings()
				.get();
		newEntity.setTransactionStatus(randomStringforTransactionStatus);
		// % protected region % [Add customisation for Transaction Status here] end
		// % protected region % [Add customisation for Quantity Issued here] off begin
		newEntity.setQuantityIssued(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Issued here] end
		// % protected region % [Add customisation for Quantity Received here] off begin
		newEntity.setQuantityReceived(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Received here] end
		// % protected region % [Add customisation for Source Min Level here] off begin
		newEntity.setSourceMinLevel(mock.doubles().get());
		// % protected region % [Add customisation for Source Min Level here] end
		// % protected region % [Add customisation for Quantity Fulfilled here] off begin
		newEntity.setQuantityFulfilled(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Fulfilled here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringforItemNotes = mock
				.strings()
				.get();
		newEntity.setItemNotes(randomStringforItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mock.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end

		// % protected region % [Apply any additional logic for internalOrderStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailWithNoRef after the main body here] end

		log.trace("Created entity of type InternalOrderStockDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Internal Order Stock Detail entities with no reference at all.
	 */
	@Provides
	@Named("internalOrderStockDetailEntitiesWithNoRef")
	public Collection<InternalOrderStockDetailEntity> internalOrderStockDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for internalOrderStockDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for internalOrderStockDetailEntitiesWithNoRef here] end
		InternalOrderStockDetailEntityFactory internalOrderStockDetailEntityFactory
	) {
		log.trace("Creating entities of type InternalOrderStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for internalOrderStockDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailEntitiesWithNoRef before the main body here] end

		Collection<InternalOrderStockDetailEntity> newEntities = internalOrderStockDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for internalOrderStockDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InternalOrderStockDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Internal Order Stock Detail entity with all references set.
	 */
	@Provides
	@Named("internalOrderStockDetailEntityWithRefs")
	public InternalOrderStockDetailEntity internalOrderStockDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for internalOrderStockDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for internalOrderStockDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InternalOrderStockDetailEntity with references");

		// % protected region % [Apply any additional logic for internalOrderStockDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailEntityWithRefs before the main body here] end

		InternalOrderStockDetailEntity internalOrderStockDetailEntity = injector.getInstance(Key.get(InternalOrderStockDetailEntity.class, Names.named("internalOrderStockDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for internalOrderStockDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type InternalOrderStockDetailEntity with references");

		return internalOrderStockDetailEntity;
	}

	/**
	 * Return a collection of Internal Order Stock Detail entities with all references set.
	 */
	@Provides
	@Named("internalOrderStockDetailEntitiesWithRefs")
	public Collection<InternalOrderStockDetailEntity> internalOrderStockDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for internalOrderStockDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for internalOrderStockDetailEntitiesWithRefs here] end
		InternalOrderStockDetailEntityFactory internalOrderStockDetailEntityFactory
	) {
		log.trace("Creating entities of type InternalOrderStockDetailEntity with references");

		// % protected region % [Apply any additional logic for internalOrderStockDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailEntitiesWithRefs before the main body here] end

		Collection<InternalOrderStockDetailEntity> newEntities = internalOrderStockDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for internalOrderStockDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderStockDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InternalOrderStockDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
