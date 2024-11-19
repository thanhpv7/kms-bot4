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
 * Guice module for Tariff Definition used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TariffDefinitionModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TariffDefinitionModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TariffDefinitionModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TariffDefinitionEntityFactory tariffDefinitionEntityFactory(
			// % protected region % [Apply any additional injected arguments for tariffDefinitionEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for tariffDefinitionEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TariffDefinitionEntityFactory");

		// % protected region % [Apply any additional logic for tariffDefinitionEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionEntityFactory before the main body here] end

		TariffDefinitionEntityFactory entityFactory = new TariffDefinitionEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TariffDefinitionEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TariffDefinitionEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for tariffDefinitionEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionEntityFactory after the main body here] end

		log.trace("Created TariffDefinitionEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Tariff Definition entity with no references set.
	 */
	@Provides
	@Named("tariffDefinitionEntityWithNoRef")
	public TariffDefinitionEntity tariffDefinitionEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for tariffDefinitionEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffDefinitionEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TariffDefinitionEntity with no reference");

		// % protected region % [Apply any additional logic for tariffDefinitionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionWithNoRef before the main body here] end

		TariffDefinitionEntity newEntity = new TariffDefinitionEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Tariff Type here] off begin
		newEntity.setTariffType(TariffTypeEnum.ROOM);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Tariff Code here] off begin
		String randomStringforTariffCode = mock
				.strings()
				.get();
		newEntity.setTariffCode(randomStringforTariffCode);
		// % protected region % [Add customisation for Tariff Code here] end
		// % protected region % [Add customisation for Tariff Price here] off begin
		newEntity.setTariffPrice(mock.doubles().get());
		// % protected region % [Add customisation for Tariff Price here] end
		// % protected region % [Add customisation for Hospital Price here] off begin
		newEntity.setHospitalPrice(mock.doubles().get());
		// % protected region % [Add customisation for Hospital Price here] end
		// % protected region % [Add customisation for Other Component Price here] off begin
		newEntity.setOtherComponentPrice(mock.doubles().get());
		// % protected region % [Add customisation for Other Component Price here] end

		// % protected region % [Apply any additional logic for tariffDefinitionWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionWithNoRef after the main body here] end

		log.trace("Created entity of type TariffDefinitionEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Tariff Definition entities with no reference at all.
	 */
	@Provides
	@Named("tariffDefinitionEntitiesWithNoRef")
	public Collection<TariffDefinitionEntity> tariffDefinitionEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for tariffDefinitionEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffDefinitionEntitiesWithNoRef here] end
		TariffDefinitionEntityFactory tariffDefinitionEntityFactory
	) {
		log.trace("Creating entities of type TariffDefinitionEntity with no reference");

		// % protected region % [Apply any additional logic for tariffDefinitionEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionEntitiesWithNoRef before the main body here] end

		Collection<TariffDefinitionEntity> newEntities = tariffDefinitionEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for tariffDefinitionEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TariffDefinitionEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Tariff Definition entity with all references set.
	 */
	@Provides
	@Named("tariffDefinitionEntityWithRefs")
	public TariffDefinitionEntity tariffDefinitionEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for tariffDefinitionEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffDefinitionEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TariffDefinitionEntity with references");

		// % protected region % [Apply any additional logic for tariffDefinitionEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionEntityWithRefs before the main body here] end

		TariffDefinitionEntity tariffDefinitionEntity = injector.getInstance(Key.get(TariffDefinitionEntity.class, Names.named("tariffDefinitionEntityWithNoRef")));

		// % protected region % [Apply any additional logic for tariffDefinitionEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionEntityWithRefs after the main body here] end

		log.trace("Created entity of type TariffDefinitionEntity with references");

		return tariffDefinitionEntity;
	}

	/**
	 * Return a collection of Tariff Definition entities with all references set.
	 */
	@Provides
	@Named("tariffDefinitionEntitiesWithRefs")
	public Collection<TariffDefinitionEntity> tariffDefinitionEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for tariffDefinitionEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffDefinitionEntitiesWithRefs here] end
		TariffDefinitionEntityFactory tariffDefinitionEntityFactory
	) {
		log.trace("Creating entities of type TariffDefinitionEntity with references");

		// % protected region % [Apply any additional logic for tariffDefinitionEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionEntitiesWithRefs before the main body here] end

		Collection<TariffDefinitionEntity> newEntities = tariffDefinitionEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for tariffDefinitionEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffDefinitionEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TariffDefinitionEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
