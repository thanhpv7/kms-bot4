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
 * Guice module for Tariff Schema used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TariffSchemaModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TariffSchemaModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TariffSchemaModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TariffSchemaEntityFactory tariffSchemaEntityFactory(
			// % protected region % [Apply any additional injected arguments for tariffSchemaEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for tariffSchemaEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TariffSchemaEntityFactory");

		// % protected region % [Apply any additional logic for tariffSchemaEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaEntityFactory before the main body here] end

		TariffSchemaEntityFactory entityFactory = new TariffSchemaEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TariffSchemaEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TariffSchemaEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for tariffSchemaEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaEntityFactory after the main body here] end

		log.trace("Created TariffSchemaEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Tariff Schema entity with no references set.
	 */
	@Provides
	@Named("tariffSchemaEntityWithNoRef")
	public TariffSchemaEntity tariffSchemaEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for tariffSchemaEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffSchemaEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TariffSchemaEntity with no reference");

		// % protected region % [Apply any additional logic for tariffSchemaWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaWithNoRef before the main body here] end

		TariffSchemaEntity newEntity = new TariffSchemaEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Schema Code here] off begin
		String randomStringforSchemaCode = mock
				.strings()
				.get();
		newEntity.setSchemaCode(randomStringforSchemaCode);
		// % protected region % [Add customisation for Schema Code here] end
		// % protected region % [Add customisation for Scheme Name here] off begin
		String randomStringforSchemeName = mock
				.strings()
				.get();
		newEntity.setSchemeName(randomStringforSchemeName);
		// % protected region % [Add customisation for Scheme Name here] end
		// % protected region % [Add customisation for Start Date here] off begin
		newEntity.setStartDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date here] end
		// % protected region % [Add customisation for End Date here] off begin
		newEntity.setEndDate(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date here] end

		// % protected region % [Apply any additional logic for tariffSchemaWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaWithNoRef after the main body here] end

		log.trace("Created entity of type TariffSchemaEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Tariff Schema entities with no reference at all.
	 */
	@Provides
	@Named("tariffSchemaEntitiesWithNoRef")
	public Collection<TariffSchemaEntity> tariffSchemaEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for tariffSchemaEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffSchemaEntitiesWithNoRef here] end
		TariffSchemaEntityFactory tariffSchemaEntityFactory
	) {
		log.trace("Creating entities of type TariffSchemaEntity with no reference");

		// % protected region % [Apply any additional logic for tariffSchemaEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaEntitiesWithNoRef before the main body here] end

		Collection<TariffSchemaEntity> newEntities = tariffSchemaEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for tariffSchemaEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TariffSchemaEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Tariff Schema entity with all references set.
	 */
	@Provides
	@Named("tariffSchemaEntityWithRefs")
	public TariffSchemaEntity tariffSchemaEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for tariffSchemaEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffSchemaEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TariffSchemaEntity with references");

		// % protected region % [Apply any additional logic for tariffSchemaEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaEntityWithRefs before the main body here] end

		TariffSchemaEntity tariffSchemaEntity = injector.getInstance(Key.get(TariffSchemaEntity.class, Names.named("tariffSchemaEntityWithNoRef")));

		// % protected region % [Apply any additional logic for tariffSchemaEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaEntityWithRefs after the main body here] end

		log.trace("Created entity of type TariffSchemaEntity with references");

		return tariffSchemaEntity;
	}

	/**
	 * Return a collection of Tariff Schema entities with all references set.
	 */
	@Provides
	@Named("tariffSchemaEntitiesWithRefs")
	public Collection<TariffSchemaEntity> tariffSchemaEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for tariffSchemaEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffSchemaEntitiesWithRefs here] end
		TariffSchemaEntityFactory tariffSchemaEntityFactory
	) {
		log.trace("Creating entities of type TariffSchemaEntity with references");

		// % protected region % [Apply any additional logic for tariffSchemaEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaEntitiesWithRefs before the main body here] end

		Collection<TariffSchemaEntity> newEntities = tariffSchemaEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for tariffSchemaEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffSchemaEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TariffSchemaEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
