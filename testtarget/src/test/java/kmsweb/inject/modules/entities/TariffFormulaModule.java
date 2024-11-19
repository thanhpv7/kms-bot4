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
 * Guice module for Tariff Formula used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TariffFormulaModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TariffFormulaModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TariffFormulaModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TariffFormulaEntityFactory tariffFormulaEntityFactory(
			// % protected region % [Apply any additional injected arguments for tariffFormulaEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for tariffFormulaEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TariffFormulaEntityFactory");

		// % protected region % [Apply any additional logic for tariffFormulaEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaEntityFactory before the main body here] end

		TariffFormulaEntityFactory entityFactory = new TariffFormulaEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TariffFormulaEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TariffFormulaEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for tariffFormulaEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaEntityFactory after the main body here] end

		log.trace("Created TariffFormulaEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Tariff Formula entity with no references set.
	 */
	@Provides
	@Named("tariffFormulaEntityWithNoRef")
	public TariffFormulaEntity tariffFormulaEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for tariffFormulaEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffFormulaEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TariffFormulaEntity with no reference");

		// % protected region % [Apply any additional logic for tariffFormulaWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaWithNoRef before the main body here] end

		TariffFormulaEntity newEntity = new TariffFormulaEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Tariff Type here] off begin
		newEntity.setTariffType(TariffTypeEnum.ROOM);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Classification here] off begin
		String randomStringforClassification = mock
				.strings()
				.get();
		newEntity.setClassification(randomStringforClassification);
		// % protected region % [Add customisation for Classification here] end
		// % protected region % [Add customisation for Multiplier here] off begin
		newEntity.setMultiplier(mock.doubles().get());
		// % protected region % [Add customisation for Multiplier here] end
		// % protected region % [Add customisation for Rounding here] off begin
		newEntity.setRounding(mock.ints().get());
		// % protected region % [Add customisation for Rounding here] end
		// % protected region % [Add customisation for Rounding method here] off begin
		newEntity.setRoundingMethod(RoundingMethodEnum.ROUNDING_DOWN);
		// % protected region % [Add customisation for Rounding method here] end

		// % protected region % [Apply any additional logic for tariffFormulaWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaWithNoRef after the main body here] end

		log.trace("Created entity of type TariffFormulaEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Tariff Formula entities with no reference at all.
	 */
	@Provides
	@Named("tariffFormulaEntitiesWithNoRef")
	public Collection<TariffFormulaEntity> tariffFormulaEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for tariffFormulaEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffFormulaEntitiesWithNoRef here] end
		TariffFormulaEntityFactory tariffFormulaEntityFactory
	) {
		log.trace("Creating entities of type TariffFormulaEntity with no reference");

		// % protected region % [Apply any additional logic for tariffFormulaEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaEntitiesWithNoRef before the main body here] end

		Collection<TariffFormulaEntity> newEntities = tariffFormulaEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for tariffFormulaEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TariffFormulaEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Tariff Formula entity with all references set.
	 */
	@Provides
	@Named("tariffFormulaEntityWithRefs")
	public TariffFormulaEntity tariffFormulaEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for tariffFormulaEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffFormulaEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TariffFormulaEntity with references");

		// % protected region % [Apply any additional logic for tariffFormulaEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaEntityWithRefs before the main body here] end

		TariffFormulaEntity tariffFormulaEntity = injector.getInstance(Key.get(TariffFormulaEntity.class, Names.named("tariffFormulaEntityWithNoRef")));

		// % protected region % [Apply any additional logic for tariffFormulaEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaEntityWithRefs after the main body here] end

		log.trace("Created entity of type TariffFormulaEntity with references");

		return tariffFormulaEntity;
	}

	/**
	 * Return a collection of Tariff Formula entities with all references set.
	 */
	@Provides
	@Named("tariffFormulaEntitiesWithRefs")
	public Collection<TariffFormulaEntity> tariffFormulaEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for tariffFormulaEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffFormulaEntitiesWithRefs here] end
		TariffFormulaEntityFactory tariffFormulaEntityFactory
	) {
		log.trace("Creating entities of type TariffFormulaEntity with references");

		// % protected region % [Apply any additional logic for tariffFormulaEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaEntitiesWithRefs before the main body here] end

		Collection<TariffFormulaEntity> newEntities = tariffFormulaEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for tariffFormulaEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffFormulaEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TariffFormulaEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
