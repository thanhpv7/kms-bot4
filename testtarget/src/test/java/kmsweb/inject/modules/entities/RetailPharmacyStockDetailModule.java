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
 * Guice module for Retail Pharmacy Stock Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class RetailPharmacyStockDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring RetailPharmacyStockDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured RetailPharmacyStockDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public RetailPharmacyStockDetailEntityFactory retailPharmacyStockDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for retailPharmacyStockDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for retailPharmacyStockDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating RetailPharmacyStockDetailEntityFactory");

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntityFactory before the main body here] end

		RetailPharmacyStockDetailEntityFactory entityFactory = new RetailPharmacyStockDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for RetailPharmacyStockDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for RetailPharmacyStockDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntityFactory after the main body here] end

		log.trace("Created RetailPharmacyStockDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Retail Pharmacy Stock Detail entity with no references set.
	 */
	@Provides
	@Named("retailPharmacyStockDetailEntityWithNoRef")
	public RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for retailPharmacyStockDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for retailPharmacyStockDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type RetailPharmacyStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailWithNoRef before the main body here] end

		RetailPharmacyStockDetailEntity newEntity = new RetailPharmacyStockDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Supply Stock Group here] off begin
		String randomStringforSupplyStockGroup = mock
				.strings()
				.get();
		newEntity.setSupplyStockGroup(randomStringforSupplyStockGroup);
		// % protected region % [Add customisation for Supply Stock Group here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Available Quantity here] off begin
		newEntity.setAvailableQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Available Quantity here] end
		// % protected region % [Add customisation for Quantity here] off begin
		newEntity.setQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Quantity here] end
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mock.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Discount here] off begin
		newEntity.setDiscount(mock.doubles().get());
		// % protected region % [Add customisation for Discount here] end
		// % protected region % [Add customisation for Tax Included here] off begin
		newEntity.setTaxIncluded(mock.bools().get());
		// % protected region % [Add customisation for Tax Included here] end
		// % protected region % [Add customisation for Tax Amount here] off begin
		newEntity.setTaxAmount(mock.doubles().get());
		// % protected region % [Add customisation for Tax Amount here] end
		// % protected region % [Add customisation for Total Item Price here] off begin
		newEntity.setTotalItemPrice(mock.doubles().get());
		// % protected region % [Add customisation for Total Item Price here] end

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailWithNoRef after the main body here] end

		log.trace("Created entity of type RetailPharmacyStockDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Retail Pharmacy Stock Detail entities with no reference at all.
	 */
	@Provides
	@Named("retailPharmacyStockDetailEntitiesWithNoRef")
	public Collection<RetailPharmacyStockDetailEntity> retailPharmacyStockDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for retailPharmacyStockDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for retailPharmacyStockDetailEntitiesWithNoRef here] end
		RetailPharmacyStockDetailEntityFactory retailPharmacyStockDetailEntityFactory
	) {
		log.trace("Creating entities of type RetailPharmacyStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntitiesWithNoRef before the main body here] end

		Collection<RetailPharmacyStockDetailEntity> newEntities = retailPharmacyStockDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type RetailPharmacyStockDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Retail Pharmacy Stock Detail entity with all references set.
	 */
	@Provides
	@Named("retailPharmacyStockDetailEntityWithRefs")
	public RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for retailPharmacyStockDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for retailPharmacyStockDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type RetailPharmacyStockDetailEntity with references");

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntityWithRefs before the main body here] end

		RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity = injector.getInstance(Key.get(RetailPharmacyStockDetailEntity.class, Names.named("retailPharmacyStockDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type RetailPharmacyStockDetailEntity with references");

		return retailPharmacyStockDetailEntity;
	}

	/**
	 * Return a collection of Retail Pharmacy Stock Detail entities with all references set.
	 */
	@Provides
	@Named("retailPharmacyStockDetailEntitiesWithRefs")
	public Collection<RetailPharmacyStockDetailEntity> retailPharmacyStockDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for retailPharmacyStockDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for retailPharmacyStockDetailEntitiesWithRefs here] end
		RetailPharmacyStockDetailEntityFactory retailPharmacyStockDetailEntityFactory
	) {
		log.trace("Creating entities of type RetailPharmacyStockDetailEntity with references");

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntitiesWithRefs before the main body here] end

		Collection<RetailPharmacyStockDetailEntity> newEntities = retailPharmacyStockDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type RetailPharmacyStockDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
