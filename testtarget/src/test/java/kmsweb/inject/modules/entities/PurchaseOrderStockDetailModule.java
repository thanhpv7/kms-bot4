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
 * Guice module for Purchase Order Stock Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PurchaseOrderStockDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PurchaseOrderStockDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PurchaseOrderStockDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PurchaseOrderStockDetailEntityFactory purchaseOrderStockDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for purchaseOrderStockDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for purchaseOrderStockDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PurchaseOrderStockDetailEntityFactory");

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntityFactory before the main body here] end

		PurchaseOrderStockDetailEntityFactory entityFactory = new PurchaseOrderStockDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PurchaseOrderStockDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PurchaseOrderStockDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntityFactory after the main body here] end

		log.trace("Created PurchaseOrderStockDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Purchase Order Stock Detail entity with no references set.
	 */
	@Provides
	@Named("purchaseOrderStockDetailEntityWithNoRef")
	public PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for purchaseOrderStockDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for purchaseOrderStockDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PurchaseOrderStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailWithNoRef before the main body here] end

		PurchaseOrderStockDetailEntity newEntity = new PurchaseOrderStockDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mock.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Quantity Ordered here] off begin
		newEntity.setQuantityOrdered(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Ordered here] end
		// % protected region % [Add customisation for UOP here] off begin
		String randomStringforUop = mock
				.strings()
				.get();
		newEntity.setUop(randomStringforUop);
		// % protected region % [Add customisation for UOP here] end
		// % protected region % [Add customisation for Discount In Percent here] off begin
		newEntity.setDiscountInPercent(mock.bools().get());
		// % protected region % [Add customisation for Discount In Percent here] end
		// % protected region % [Add customisation for Discount Value here] off begin
		newEntity.setDiscountValue(mock.doubles().get());
		// % protected region % [Add customisation for Discount Value here] end
		// % protected region % [Add customisation for Taxable here] off begin
		newEntity.setTaxable(mock.bools().get());
		// % protected region % [Add customisation for Taxable here] end
		// % protected region % [Add customisation for Item Price here] off begin
		newEntity.setItemPrice(mock.doubles().get());
		// % protected region % [Add customisation for Item Price here] end
		// % protected region % [Add customisation for Item Status here] off begin
		String randomStringforItemStatus = mock
				.strings()
				.get();
		newEntity.setItemStatus(randomStringforItemStatus);
		// % protected region % [Add customisation for Item Status here] end
		// % protected region % [Add customisation for SOH here] off begin
		newEntity.setSoh(mock.doubles().get());
		// % protected region % [Add customisation for SOH here] end
		// % protected region % [Add customisation for Max Level here] off begin
		newEntity.setMaxLevel(mock.doubles().get());
		// % protected region % [Add customisation for Max Level here] end
		// % protected region % [Add customisation for Quantity Received here] off begin
		newEntity.setQuantityReceived(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Received here] end
		// % protected region % [Add customisation for Quantity Returned here] off begin
		newEntity.setQuantityReturned(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Returned here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringforItemNotes = mock
				.strings()
				.get();
		newEntity.setItemNotes(randomStringforItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Remaining Quantity here] off begin
		newEntity.setRemainingQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Remaining Quantity here] end

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailWithNoRef after the main body here] end

		log.trace("Created entity of type PurchaseOrderStockDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Purchase Order Stock Detail entities with no reference at all.
	 */
	@Provides
	@Named("purchaseOrderStockDetailEntitiesWithNoRef")
	public Collection<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for purchaseOrderStockDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for purchaseOrderStockDetailEntitiesWithNoRef here] end
		PurchaseOrderStockDetailEntityFactory purchaseOrderStockDetailEntityFactory
	) {
		log.trace("Creating entities of type PurchaseOrderStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntitiesWithNoRef before the main body here] end

		Collection<PurchaseOrderStockDetailEntity> newEntities = purchaseOrderStockDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PurchaseOrderStockDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Purchase Order Stock Detail entity with all references set.
	 */
	@Provides
	@Named("purchaseOrderStockDetailEntityWithRefs")
	public PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for purchaseOrderStockDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for purchaseOrderStockDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PurchaseOrderStockDetailEntity with references");

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntityWithRefs before the main body here] end

		PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity = injector.getInstance(Key.get(PurchaseOrderStockDetailEntity.class, Names.named("purchaseOrderStockDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type PurchaseOrderStockDetailEntity with references");

		return purchaseOrderStockDetailEntity;
	}

	/**
	 * Return a collection of Purchase Order Stock Detail entities with all references set.
	 */
	@Provides
	@Named("purchaseOrderStockDetailEntitiesWithRefs")
	public Collection<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for purchaseOrderStockDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for purchaseOrderStockDetailEntitiesWithRefs here] end
		PurchaseOrderStockDetailEntityFactory purchaseOrderStockDetailEntityFactory
	) {
		log.trace("Creating entities of type PurchaseOrderStockDetailEntity with references");

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntitiesWithRefs before the main body here] end

		Collection<PurchaseOrderStockDetailEntity> newEntities = purchaseOrderStockDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PurchaseOrderStockDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
