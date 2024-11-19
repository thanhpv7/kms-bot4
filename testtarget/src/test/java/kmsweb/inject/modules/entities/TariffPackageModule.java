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
 * Guice module for Tariff Package used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TariffPackageModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TariffPackageModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TariffPackageModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TariffPackageEntityFactory tariffPackageEntityFactory(
			// % protected region % [Apply any additional injected arguments for tariffPackageEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for tariffPackageEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TariffPackageEntityFactory");

		// % protected region % [Apply any additional logic for tariffPackageEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageEntityFactory before the main body here] end

		TariffPackageEntityFactory entityFactory = new TariffPackageEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TariffPackageEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TariffPackageEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for tariffPackageEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageEntityFactory after the main body here] end

		log.trace("Created TariffPackageEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Tariff Package entity with no references set.
	 */
	@Provides
	@Named("tariffPackageEntityWithNoRef")
	public TariffPackageEntity tariffPackageEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for tariffPackageEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffPackageEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TariffPackageEntity with no reference");

		// % protected region % [Apply any additional logic for tariffPackageWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageWithNoRef before the main body here] end

		TariffPackageEntity newEntity = new TariffPackageEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Tariff Package Code here] off begin
		String randomStringforTariffPackageCode = mock
				.strings()
				.get();
		newEntity.setTariffPackageCode(randomStringforTariffPackageCode);
		// % protected region % [Add customisation for Tariff Package Code here] end
		// % protected region % [Add customisation for Tariff Package Name here] off begin
		String randomStringforTariffPackageName = mock
				.strings()
				.get();
		newEntity.setTariffPackageName(randomStringforTariffPackageName);
		// % protected region % [Add customisation for Tariff Package Name here] end
		// % protected region % [Add customisation for Tariff Package Classification here] off begin
		String randomStringforTariffPackageClassification = mock
				.strings()
				.get();
		newEntity.setTariffPackageClassification(randomStringforTariffPackageClassification);
		// % protected region % [Add customisation for Tariff Package Classification here] end
		// % protected region % [Add customisation for COA Sell here] off begin
		String randomStringforCoaSell = mock
				.strings()
				.get();
		newEntity.setCoaSell(randomStringforCoaSell);
		// % protected region % [Add customisation for COA Sell here] end
		// % protected region % [Add customisation for Tariff Package Description here] off begin
		String randomStringforTariffPackageDescription = mock
				.strings()
				.get();
		newEntity.setTariffPackageDescription(randomStringforTariffPackageDescription);
		// % protected region % [Add customisation for Tariff Package Description here] end
		// % protected region % [Add customisation for Apply To All Services here] off begin
		newEntity.setApplyToAllServices(mock.bools().get());
		// % protected region % [Add customisation for Apply To All Services here] end

		// % protected region % [Apply any additional logic for tariffPackageWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageWithNoRef after the main body here] end

		log.trace("Created entity of type TariffPackageEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Tariff Package entities with no reference at all.
	 */
	@Provides
	@Named("tariffPackageEntitiesWithNoRef")
	public Collection<TariffPackageEntity> tariffPackageEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for tariffPackageEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffPackageEntitiesWithNoRef here] end
		TariffPackageEntityFactory tariffPackageEntityFactory
	) {
		log.trace("Creating entities of type TariffPackageEntity with no reference");

		// % protected region % [Apply any additional logic for tariffPackageEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageEntitiesWithNoRef before the main body here] end

		Collection<TariffPackageEntity> newEntities = tariffPackageEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for tariffPackageEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TariffPackageEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Tariff Package entity with all references set.
	 */
	@Provides
	@Named("tariffPackageEntityWithRefs")
	public TariffPackageEntity tariffPackageEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for tariffPackageEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffPackageEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TariffPackageEntity with references");

		// % protected region % [Apply any additional logic for tariffPackageEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageEntityWithRefs before the main body here] end

		TariffPackageEntity tariffPackageEntity = injector.getInstance(Key.get(TariffPackageEntity.class, Names.named("tariffPackageEntityWithNoRef")));

		// % protected region % [Apply any additional logic for tariffPackageEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageEntityWithRefs after the main body here] end

		log.trace("Created entity of type TariffPackageEntity with references");

		return tariffPackageEntity;
	}

	/**
	 * Return a collection of Tariff Package entities with all references set.
	 */
	@Provides
	@Named("tariffPackageEntitiesWithRefs")
	public Collection<TariffPackageEntity> tariffPackageEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for tariffPackageEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffPackageEntitiesWithRefs here] end
		TariffPackageEntityFactory tariffPackageEntityFactory
	) {
		log.trace("Creating entities of type TariffPackageEntity with references");

		// % protected region % [Apply any additional logic for tariffPackageEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageEntitiesWithRefs before the main body here] end

		Collection<TariffPackageEntity> newEntities = tariffPackageEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for tariffPackageEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TariffPackageEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
