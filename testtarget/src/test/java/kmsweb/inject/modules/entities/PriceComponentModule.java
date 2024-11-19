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
 * Guice module for Price Component used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PriceComponentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PriceComponentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PriceComponentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PriceComponentEntityFactory priceComponentEntityFactory(
			// % protected region % [Apply any additional injected arguments for priceComponentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for priceComponentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PriceComponentEntityFactory");

		// % protected region % [Apply any additional logic for priceComponentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentEntityFactory before the main body here] end

		PriceComponentEntityFactory entityFactory = new PriceComponentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PriceComponentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PriceComponentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for priceComponentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentEntityFactory after the main body here] end

		log.trace("Created PriceComponentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Price Component entity with no references set.
	 */
	@Provides
	@Named("priceComponentEntityWithNoRef")
	public PriceComponentEntity priceComponentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for priceComponentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for priceComponentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PriceComponentEntity with no reference");

		// % protected region % [Apply any additional logic for priceComponentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentWithNoRef before the main body here] end

		PriceComponentEntity newEntity = new PriceComponentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Component Code here] off begin
		String randomStringforComponentCode = mock
				.strings()
				.get();
		newEntity.setComponentCode(randomStringforComponentCode);
		// % protected region % [Add customisation for Component Code here] end
		// % protected region % [Add customisation for Component Name here] off begin
		String randomStringforComponentName = mock
				.strings()
				.get();
		newEntity.setComponentName(randomStringforComponentName);
		// % protected region % [Add customisation for Component Name here] end
		// % protected region % [Add customisation for COA COGS here] off begin
		String randomStringforCoaCOGS = mock
				.strings()
				.get();
		newEntity.setCoaCOGS(randomStringforCoaCOGS);
		// % protected region % [Add customisation for COA COGS here] end
		// % protected region % [Add customisation for COA Sell here] off begin
		String randomStringforCoaSell = mock
				.strings()
				.get();
		newEntity.setCoaSell(randomStringforCoaSell);
		// % protected region % [Add customisation for COA Sell here] end
		// % protected region % [Add customisation for COA Inventory here] off begin
		String randomStringforCoaInventory = mock
				.strings()
				.get();
		newEntity.setCoaInventory(randomStringforCoaInventory);
		// % protected region % [Add customisation for COA Inventory here] end

		// % protected region % [Apply any additional logic for priceComponentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentWithNoRef after the main body here] end

		log.trace("Created entity of type PriceComponentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Price Component entities with no reference at all.
	 */
	@Provides
	@Named("priceComponentEntitiesWithNoRef")
	public Collection<PriceComponentEntity> priceComponentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for priceComponentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for priceComponentEntitiesWithNoRef here] end
		PriceComponentEntityFactory priceComponentEntityFactory
	) {
		log.trace("Creating entities of type PriceComponentEntity with no reference");

		// % protected region % [Apply any additional logic for priceComponentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentEntitiesWithNoRef before the main body here] end

		Collection<PriceComponentEntity> newEntities = priceComponentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for priceComponentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PriceComponentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Price Component entity with all references set.
	 */
	@Provides
	@Named("priceComponentEntityWithRefs")
	public PriceComponentEntity priceComponentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for priceComponentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for priceComponentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PriceComponentEntity with references");

		// % protected region % [Apply any additional logic for priceComponentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentEntityWithRefs before the main body here] end

		PriceComponentEntity priceComponentEntity = injector.getInstance(Key.get(PriceComponentEntity.class, Names.named("priceComponentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for priceComponentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentEntityWithRefs after the main body here] end

		log.trace("Created entity of type PriceComponentEntity with references");

		return priceComponentEntity;
	}

	/**
	 * Return a collection of Price Component entities with all references set.
	 */
	@Provides
	@Named("priceComponentEntitiesWithRefs")
	public Collection<PriceComponentEntity> priceComponentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for priceComponentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for priceComponentEntitiesWithRefs here] end
		PriceComponentEntityFactory priceComponentEntityFactory
	) {
		log.trace("Creating entities of type PriceComponentEntity with references");

		// % protected region % [Apply any additional logic for priceComponentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentEntitiesWithRefs before the main body here] end

		Collection<PriceComponentEntity> newEntities = priceComponentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for priceComponentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for priceComponentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PriceComponentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
