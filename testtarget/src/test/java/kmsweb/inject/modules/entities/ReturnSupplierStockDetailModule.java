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
 * Guice module for Return Supplier Stock Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ReturnSupplierStockDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ReturnSupplierStockDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ReturnSupplierStockDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ReturnSupplierStockDetailEntityFactory returnSupplierStockDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for returnSupplierStockDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for returnSupplierStockDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ReturnSupplierStockDetailEntityFactory");

		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntityFactory before the main body here] end

		ReturnSupplierStockDetailEntityFactory entityFactory = new ReturnSupplierStockDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ReturnSupplierStockDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ReturnSupplierStockDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntityFactory after the main body here] end

		log.trace("Created ReturnSupplierStockDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Return Supplier Stock Detail entity with no references set.
	 */
	@Provides
	@Named("returnSupplierStockDetailEntityWithNoRef")
	public ReturnSupplierStockDetailEntity returnSupplierStockDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for returnSupplierStockDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for returnSupplierStockDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ReturnSupplierStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for returnSupplierStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailWithNoRef before the main body here] end

		ReturnSupplierStockDetailEntity newEntity = new ReturnSupplierStockDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mock.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Available Quantity Returned here] off begin
		newEntity.setAvailableQuantityReturned(mock.doubles().get());
		// % protected region % [Add customisation for Available Quantity Returned here] end
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
		// % protected region % [Add customisation for Available Quantity here] off begin
		newEntity.setAvailableQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Available Quantity here] end
		// % protected region % [Add customisation for Quantity Ordered here] off begin
		newEntity.setQuantityOrdered(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Ordered here] end
		// % protected region % [Add customisation for Quantity Received here] off begin
		newEntity.setQuantityReceived(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Received here] end
		// % protected region % [Add customisation for Previous Quantity Returned here] off begin
		newEntity.setPreviousQuantityReturned(mock.doubles().get());
		// % protected region % [Add customisation for Previous Quantity Returned here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringforItemNotes = mock
				.strings()
				.get();
		newEntity.setItemNotes(randomStringforItemNotes);
		// % protected region % [Add customisation for Item Notes here] end

		// % protected region % [Apply any additional logic for returnSupplierStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailWithNoRef after the main body here] end

		log.trace("Created entity of type ReturnSupplierStockDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Return Supplier Stock Detail entities with no reference at all.
	 */
	@Provides
	@Named("returnSupplierStockDetailEntitiesWithNoRef")
	public Collection<ReturnSupplierStockDetailEntity> returnSupplierStockDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for returnSupplierStockDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for returnSupplierStockDetailEntitiesWithNoRef here] end
		ReturnSupplierStockDetailEntityFactory returnSupplierStockDetailEntityFactory
	) {
		log.trace("Creating entities of type ReturnSupplierStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntitiesWithNoRef before the main body here] end

		Collection<ReturnSupplierStockDetailEntity> newEntities = returnSupplierStockDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ReturnSupplierStockDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Return Supplier Stock Detail entity with all references set.
	 */
	@Provides
	@Named("returnSupplierStockDetailEntityWithRefs")
	public ReturnSupplierStockDetailEntity returnSupplierStockDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for returnSupplierStockDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for returnSupplierStockDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ReturnSupplierStockDetailEntity with references");

		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntityWithRefs before the main body here] end

		ReturnSupplierStockDetailEntity returnSupplierStockDetailEntity = injector.getInstance(Key.get(ReturnSupplierStockDetailEntity.class, Names.named("returnSupplierStockDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type ReturnSupplierStockDetailEntity with references");

		return returnSupplierStockDetailEntity;
	}

	/**
	 * Return a collection of Return Supplier Stock Detail entities with all references set.
	 */
	@Provides
	@Named("returnSupplierStockDetailEntitiesWithRefs")
	public Collection<ReturnSupplierStockDetailEntity> returnSupplierStockDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for returnSupplierStockDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for returnSupplierStockDetailEntitiesWithRefs here] end
		ReturnSupplierStockDetailEntityFactory returnSupplierStockDetailEntityFactory
	) {
		log.trace("Creating entities of type ReturnSupplierStockDetailEntity with references");

		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntitiesWithRefs before the main body here] end

		Collection<ReturnSupplierStockDetailEntity> newEntities = returnSupplierStockDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ReturnSupplierStockDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
