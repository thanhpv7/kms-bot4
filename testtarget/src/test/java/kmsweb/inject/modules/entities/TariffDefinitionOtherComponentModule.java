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
 * Guice module for Tariff Definition Other Component used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TariffDefinitionOtherComponentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TariffDefinitionOtherComponentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TariffDefinitionOtherComponentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TariffDefinitionOtherComponentEntityFactory tariffDefinitionOtherComponentEntityFactory(
			// % protected region % [Apply any additional injected arguments for tariffDefinitionOtherComponentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for tariffDefinitionOtherComponentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TariffDefinitionOtherComponentEntityFactory");

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntityFactory before the main body here] end

		TariffDefinitionOtherComponentEntityFactory entityFactory = new TariffDefinitionOtherComponentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TariffDefinitionOtherComponentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TariffDefinitionOtherComponentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntityFactory after the main body here] end

		log.trace("Created TariffDefinitionOtherComponentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Tariff Definition Other Component entity with no references set.
	 */
	@Provides
	@Named("tariffDefinitionOtherComponentEntityWithNoRef")
	public TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for tariffDefinitionOtherComponentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffDefinitionOtherComponentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TariffDefinitionOtherComponentEntity with no reference");

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentWithNoRef before the main body here] end

		TariffDefinitionOtherComponentEntity newEntity = new TariffDefinitionOtherComponentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mock.doubles().get());
		// % protected region % [Add customisation for Price here] end

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentWithNoRef after the main body here] end

		log.trace("Created entity of type TariffDefinitionOtherComponentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Tariff Definition Other Component entities with no reference at all.
	 */
	@Provides
	@Named("tariffDefinitionOtherComponentEntitiesWithNoRef")
	public Collection<TariffDefinitionOtherComponentEntity> tariffDefinitionOtherComponentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for tariffDefinitionOtherComponentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffDefinitionOtherComponentEntitiesWithNoRef here] end
		TariffDefinitionOtherComponentEntityFactory tariffDefinitionOtherComponentEntityFactory
	) {
		log.trace("Creating entities of type TariffDefinitionOtherComponentEntity with no reference");

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntitiesWithNoRef before the main body here] end

		Collection<TariffDefinitionOtherComponentEntity> newEntities = tariffDefinitionOtherComponentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TariffDefinitionOtherComponentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Tariff Definition Other Component entity with all references set.
	 */
	@Provides
	@Named("tariffDefinitionOtherComponentEntityWithRefs")
	public TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for tariffDefinitionOtherComponentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffDefinitionOtherComponentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TariffDefinitionOtherComponentEntity with references");

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntityWithRefs before the main body here] end

		TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponentEntity = injector.getInstance(Key.get(TariffDefinitionOtherComponentEntity.class, Names.named("tariffDefinitionOtherComponentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntityWithRefs after the main body here] end

		log.trace("Created entity of type TariffDefinitionOtherComponentEntity with references");

		return tariffDefinitionOtherComponentEntity;
	}

	/**
	 * Return a collection of Tariff Definition Other Component entities with all references set.
	 */
	@Provides
	@Named("tariffDefinitionOtherComponentEntitiesWithRefs")
	public Collection<TariffDefinitionOtherComponentEntity> tariffDefinitionOtherComponentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for tariffDefinitionOtherComponentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffDefinitionOtherComponentEntitiesWithRefs here] end
		TariffDefinitionOtherComponentEntityFactory tariffDefinitionOtherComponentEntityFactory
	) {
		log.trace("Creating entities of type TariffDefinitionOtherComponentEntity with references");

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntitiesWithRefs before the main body here] end

		Collection<TariffDefinitionOtherComponentEntity> newEntities = tariffDefinitionOtherComponentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionOtherComponentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TariffDefinitionOtherComponentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
