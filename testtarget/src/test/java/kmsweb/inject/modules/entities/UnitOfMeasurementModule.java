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
 * Guice module for Unit Of Measurement used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class UnitOfMeasurementModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring UnitOfMeasurementModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured UnitOfMeasurementModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public UnitOfMeasurementEntityFactory unitOfMeasurementEntityFactory(
			// % protected region % [Apply any additional injected arguments for unitOfMeasurementEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for unitOfMeasurementEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating UnitOfMeasurementEntityFactory");

		// % protected region % [Apply any additional logic for unitOfMeasurementEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementEntityFactory before the main body here] end

		UnitOfMeasurementEntityFactory entityFactory = new UnitOfMeasurementEntityFactory(
				// % protected region % [Apply any additional constructor arguments for UnitOfMeasurementEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for UnitOfMeasurementEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for unitOfMeasurementEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementEntityFactory after the main body here] end

		log.trace("Created UnitOfMeasurementEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Unit Of Measurement entity with no references set.
	 */
	@Provides
	@Named("unitOfMeasurementEntityWithNoRef")
	public UnitOfMeasurementEntity unitOfMeasurementEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for unitOfMeasurementEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for unitOfMeasurementEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type UnitOfMeasurementEntity with no reference");

		// % protected region % [Apply any additional logic for unitOfMeasurementWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementWithNoRef before the main body here] end

		UnitOfMeasurementEntity newEntity = new UnitOfMeasurementEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Unit Name here] off begin
		String randomStringforUnitName = mock
				.strings()
				.get();
		newEntity.setUnitName(randomStringforUnitName);
		// % protected region % [Add customisation for Unit Name here] end
		// % protected region % [Add customisation for Symbol here] off begin
		String randomStringforSymbol = mock
				.strings()
				.get();
		newEntity.setSymbol(randomStringforSymbol);
		// % protected region % [Add customisation for Symbol here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Unit Category here] off begin
		String randomStringforUnitCategory = mock
				.strings()
				.get();
		newEntity.setUnitCategory(randomStringforUnitCategory);
		// % protected region % [Add customisation for Unit Category here] end
		// % protected region % [Add customisation for Consumption Unit here] off begin
		newEntity.setConsumptionUnit(mock.bools().get());
		// % protected region % [Add customisation for Consumption Unit here] end

		// % protected region % [Apply any additional logic for unitOfMeasurementWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementWithNoRef after the main body here] end

		log.trace("Created entity of type UnitOfMeasurementEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Unit Of Measurement entities with no reference at all.
	 */
	@Provides
	@Named("unitOfMeasurementEntitiesWithNoRef")
	public Collection<UnitOfMeasurementEntity> unitOfMeasurementEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for unitOfMeasurementEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for unitOfMeasurementEntitiesWithNoRef here] end
		UnitOfMeasurementEntityFactory unitOfMeasurementEntityFactory
	) {
		log.trace("Creating entities of type UnitOfMeasurementEntity with no reference");

		// % protected region % [Apply any additional logic for unitOfMeasurementEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementEntitiesWithNoRef before the main body here] end

		Collection<UnitOfMeasurementEntity> newEntities = unitOfMeasurementEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for unitOfMeasurementEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type UnitOfMeasurementEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Unit Of Measurement entity with all references set.
	 */
	@Provides
	@Named("unitOfMeasurementEntityWithRefs")
	public UnitOfMeasurementEntity unitOfMeasurementEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for unitOfMeasurementEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for unitOfMeasurementEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type UnitOfMeasurementEntity with references");

		// % protected region % [Apply any additional logic for unitOfMeasurementEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementEntityWithRefs before the main body here] end

		UnitOfMeasurementEntity unitOfMeasurementEntity = injector.getInstance(Key.get(UnitOfMeasurementEntity.class, Names.named("unitOfMeasurementEntityWithNoRef")));

		// % protected region % [Apply any additional logic for unitOfMeasurementEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementEntityWithRefs after the main body here] end

		log.trace("Created entity of type UnitOfMeasurementEntity with references");

		return unitOfMeasurementEntity;
	}

	/**
	 * Return a collection of Unit Of Measurement entities with all references set.
	 */
	@Provides
	@Named("unitOfMeasurementEntitiesWithRefs")
	public Collection<UnitOfMeasurementEntity> unitOfMeasurementEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for unitOfMeasurementEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for unitOfMeasurementEntitiesWithRefs here] end
		UnitOfMeasurementEntityFactory unitOfMeasurementEntityFactory
	) {
		log.trace("Creating entities of type UnitOfMeasurementEntity with references");

		// % protected region % [Apply any additional logic for unitOfMeasurementEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementEntitiesWithRefs before the main body here] end

		Collection<UnitOfMeasurementEntity> newEntities = unitOfMeasurementEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for unitOfMeasurementEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for unitOfMeasurementEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type UnitOfMeasurementEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
