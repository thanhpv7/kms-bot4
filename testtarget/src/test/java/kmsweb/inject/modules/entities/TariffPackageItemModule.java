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
 * Guice module for Tariff Package Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TariffPackageItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TariffPackageItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TariffPackageItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TariffPackageItemEntityFactory tariffPackageItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for tariffPackageItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for tariffPackageItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TariffPackageItemEntityFactory");

		// % protected region % [Apply any additional logic for tariffPackageItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemEntityFactory before the main body here] end

		TariffPackageItemEntityFactory entityFactory = new TariffPackageItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TariffPackageItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TariffPackageItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for tariffPackageItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemEntityFactory after the main body here] end

		log.trace("Created TariffPackageItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Tariff Package Item entity with no references set.
	 */
	@Provides
	@Named("tariffPackageItemEntityWithNoRef")
	public TariffPackageItemEntity tariffPackageItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for tariffPackageItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffPackageItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TariffPackageItemEntity with no reference");

		// % protected region % [Apply any additional logic for tariffPackageItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemWithNoRef before the main body here] end

		TariffPackageItemEntity newEntity = new TariffPackageItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Tariff Type here] off begin
		newEntity.setTariffType(TariffTypeEnum.ROOM);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Tariff  Code here] off begin
		String randomStringforTariffCode = mock
				.strings()
				.get();
		newEntity.setTariffCode(randomStringforTariffCode);
		// % protected region % [Add customisation for Tariff  Code here] end
		// % protected region % [Add customisation for Tariff  Name here] off begin
		String randomStringforTariffName = mock
				.strings()
				.get();
		newEntity.setTariffName(randomStringforTariffName);
		// % protected region % [Add customisation for Tariff  Name here] end
		// % protected region % [Add customisation for Quantity here] off begin
		newEntity.setQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Quantity here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringforUnit = mock
				.strings()
				.get();
		newEntity.setUnit(randomStringforUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Modifiable here] off begin
		newEntity.setModifiable(mock.bools().get());
		// % protected region % [Add customisation for Modifiable here] end

		// % protected region % [Apply any additional logic for tariffPackageItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemWithNoRef after the main body here] end

		log.trace("Created entity of type TariffPackageItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Tariff Package Item entities with no reference at all.
	 */
	@Provides
	@Named("tariffPackageItemEntitiesWithNoRef")
	public Collection<TariffPackageItemEntity> tariffPackageItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for tariffPackageItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffPackageItemEntitiesWithNoRef here] end
		TariffPackageItemEntityFactory tariffPackageItemEntityFactory
	) {
		log.trace("Creating entities of type TariffPackageItemEntity with no reference");

		// % protected region % [Apply any additional logic for tariffPackageItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemEntitiesWithNoRef before the main body here] end

		Collection<TariffPackageItemEntity> newEntities = tariffPackageItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for tariffPackageItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TariffPackageItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Tariff Package Item entity with all references set.
	 */
	@Provides
	@Named("tariffPackageItemEntityWithRefs")
	public TariffPackageItemEntity tariffPackageItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for tariffPackageItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffPackageItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TariffPackageItemEntity with references");

		// % protected region % [Apply any additional logic for tariffPackageItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemEntityWithRefs before the main body here] end

		TariffPackageItemEntity tariffPackageItemEntity = injector.getInstance(Key.get(TariffPackageItemEntity.class, Names.named("tariffPackageItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for tariffPackageItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type TariffPackageItemEntity with references");

		return tariffPackageItemEntity;
	}

	/**
	 * Return a collection of Tariff Package Item entities with all references set.
	 */
	@Provides
	@Named("tariffPackageItemEntitiesWithRefs")
	public Collection<TariffPackageItemEntity> tariffPackageItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for tariffPackageItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffPackageItemEntitiesWithRefs here] end
		TariffPackageItemEntityFactory tariffPackageItemEntityFactory
	) {
		log.trace("Creating entities of type TariffPackageItemEntity with references");

		// % protected region % [Apply any additional logic for tariffPackageItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemEntitiesWithRefs before the main body here] end

		Collection<TariffPackageItemEntity> newEntities = tariffPackageItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for tariffPackageItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TariffPackageItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
