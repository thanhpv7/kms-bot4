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
 * Guice module for Transfer Order Stock Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TransferOrderStockDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TransferOrderStockDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TransferOrderStockDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TransferOrderStockDetailEntityFactory transferOrderStockDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for transferOrderStockDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for transferOrderStockDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TransferOrderStockDetailEntityFactory");

		// % protected region % [Apply any additional logic for transferOrderStockDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailEntityFactory before the main body here] end

		TransferOrderStockDetailEntityFactory entityFactory = new TransferOrderStockDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TransferOrderStockDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TransferOrderStockDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for transferOrderStockDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailEntityFactory after the main body here] end

		log.trace("Created TransferOrderStockDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Transfer Order Stock Detail entity with no references set.
	 */
	@Provides
	@Named("transferOrderStockDetailEntityWithNoRef")
	public TransferOrderStockDetailEntity transferOrderStockDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for transferOrderStockDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for transferOrderStockDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TransferOrderStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for transferOrderStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailWithNoRef before the main body here] end

		TransferOrderStockDetailEntity newEntity = new TransferOrderStockDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Number here] off begin
		newEntity.setItemNumber(mock.ints().get());
		// % protected region % [Add customisation for Item Number here] end
		// % protected region % [Add customisation for Source Available Quantity here] off begin
		newEntity.setSourceAvailableQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Source Available Quantity here] end
		// % protected region % [Add customisation for Destination SOH here] off begin
		newEntity.setDestinationSOH(mock.doubles().get());
		// % protected region % [Add customisation for Destination SOH here] end
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
		// % protected region % [Add customisation for Destination Max Level here] off begin
		newEntity.setDestinationMaxLevel(mock.doubles().get());
		// % protected region % [Add customisation for Destination Max Level here] end
		// % protected region % [Add customisation for Quantity Transferred here] off begin
		newEntity.setQuantityTransferred(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Transferred here] end
		// % protected region % [Add customisation for Quantity Fulfilled here] off begin
		newEntity.setQuantityFulfilled(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Fulfilled here] end
		// % protected region % [Add customisation for Order Date Time here] off begin
		newEntity.setOrderDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date Time here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringforItemNotes = mock
				.strings()
				.get();
		newEntity.setItemNotes(randomStringforItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mock.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end

		// % protected region % [Apply any additional logic for transferOrderStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailWithNoRef after the main body here] end

		log.trace("Created entity of type TransferOrderStockDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Transfer Order Stock Detail entities with no reference at all.
	 */
	@Provides
	@Named("transferOrderStockDetailEntitiesWithNoRef")
	public Collection<TransferOrderStockDetailEntity> transferOrderStockDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for transferOrderStockDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for transferOrderStockDetailEntitiesWithNoRef here] end
		TransferOrderStockDetailEntityFactory transferOrderStockDetailEntityFactory
	) {
		log.trace("Creating entities of type TransferOrderStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for transferOrderStockDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailEntitiesWithNoRef before the main body here] end

		Collection<TransferOrderStockDetailEntity> newEntities = transferOrderStockDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for transferOrderStockDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TransferOrderStockDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Transfer Order Stock Detail entity with all references set.
	 */
	@Provides
	@Named("transferOrderStockDetailEntityWithRefs")
	public TransferOrderStockDetailEntity transferOrderStockDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for transferOrderStockDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for transferOrderStockDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TransferOrderStockDetailEntity with references");

		// % protected region % [Apply any additional logic for transferOrderStockDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailEntityWithRefs before the main body here] end

		TransferOrderStockDetailEntity transferOrderStockDetailEntity = injector.getInstance(Key.get(TransferOrderStockDetailEntity.class, Names.named("transferOrderStockDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for transferOrderStockDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type TransferOrderStockDetailEntity with references");

		return transferOrderStockDetailEntity;
	}

	/**
	 * Return a collection of Transfer Order Stock Detail entities with all references set.
	 */
	@Provides
	@Named("transferOrderStockDetailEntitiesWithRefs")
	public Collection<TransferOrderStockDetailEntity> transferOrderStockDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for transferOrderStockDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for transferOrderStockDetailEntitiesWithRefs here] end
		TransferOrderStockDetailEntityFactory transferOrderStockDetailEntityFactory
	) {
		log.trace("Creating entities of type TransferOrderStockDetailEntity with references");

		// % protected region % [Apply any additional logic for transferOrderStockDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailEntitiesWithRefs before the main body here] end

		Collection<TransferOrderStockDetailEntity> newEntities = transferOrderStockDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for transferOrderStockDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TransferOrderStockDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
