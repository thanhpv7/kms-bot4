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
 * Guice module for Warehouse used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class WarehouseModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring WarehouseModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured WarehouseModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public WarehouseEntityFactory warehouseEntityFactory(
			// % protected region % [Apply any additional injected arguments for warehouseEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for warehouseEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating WarehouseEntityFactory");

		// % protected region % [Apply any additional logic for warehouseEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseEntityFactory before the main body here] end

		WarehouseEntityFactory entityFactory = new WarehouseEntityFactory(
				// % protected region % [Apply any additional constructor arguments for WarehouseEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for WarehouseEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for warehouseEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseEntityFactory after the main body here] end

		log.trace("Created WarehouseEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Warehouse entity with no references set.
	 */
	@Provides
	@Named("warehouseEntityWithNoRef")
	public WarehouseEntity warehouseEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for warehouseEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for warehouseEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type WarehouseEntity with no reference");

		// % protected region % [Apply any additional logic for warehouseWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseWithNoRef before the main body here] end

		WarehouseEntity newEntity = new WarehouseEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Warehouse Number here] off begin
		String randomStringforWarehouseNumber = mock
				.strings()
				.get();
		newEntity.setWarehouseNumber(randomStringforWarehouseNumber);
		// % protected region % [Add customisation for Warehouse Number here] end
		// % protected region % [Add customisation for Warehouse Name here] off begin
		String randomStringforWarehouseName = mock
				.strings()
				.get();
		newEntity.setWarehouseName(randomStringforWarehouseName);
		// % protected region % [Add customisation for Warehouse Name here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.size(2000)
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringforAddress = mock
				.strings()
				.get();
		newEntity.setAddress(randomStringforAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Contact Person here] off begin
		String randomStringforContactPerson = mock
				.strings()
				.get();
		newEntity.setContactPerson(randomStringforContactPerson);
		// % protected region % [Add customisation for Contact Person here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringforPhoneNumber = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setPhoneNumber(randomStringforPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Ext here] off begin
		String randomStringforExt = mock
				.strings()
				.get();
		newEntity.setExt(randomStringforExt);
		// % protected region % [Add customisation for Ext here] end
		// % protected region % [Add customisation for Mobile Phone Number here] off begin
		String randomStringforMobilePhoneNumber = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setMobilePhoneNumber(randomStringforMobilePhoneNumber);
		// % protected region % [Add customisation for Mobile Phone Number here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.emails()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Revenue Center here] off begin
		String randomStringforRevenueCenter = mock
				.strings()
				.get();
		newEntity.setRevenueCenter(randomStringforRevenueCenter);
		// % protected region % [Add customisation for Revenue Center here] end

		// % protected region % [Apply any additional logic for warehouseWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseWithNoRef after the main body here] end

		log.trace("Created entity of type WarehouseEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Warehouse entities with no reference at all.
	 */
	@Provides
	@Named("warehouseEntitiesWithNoRef")
	public Collection<WarehouseEntity> warehouseEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for warehouseEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for warehouseEntitiesWithNoRef here] end
		WarehouseEntityFactory warehouseEntityFactory
	) {
		log.trace("Creating entities of type WarehouseEntity with no reference");

		// % protected region % [Apply any additional logic for warehouseEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseEntitiesWithNoRef before the main body here] end

		Collection<WarehouseEntity> newEntities = warehouseEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for warehouseEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type WarehouseEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Warehouse entity with all references set.
	 */
	@Provides
	@Named("warehouseEntityWithRefs")
	public WarehouseEntity warehouseEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for warehouseEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for warehouseEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type WarehouseEntity with references");

		// % protected region % [Apply any additional logic for warehouseEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseEntityWithRefs before the main body here] end

		WarehouseEntity warehouseEntity = injector.getInstance(Key.get(WarehouseEntity.class, Names.named("warehouseEntityWithNoRef")));

		// % protected region % [Apply any additional logic for warehouseEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseEntityWithRefs after the main body here] end

		log.trace("Created entity of type WarehouseEntity with references");

		return warehouseEntity;
	}

	/**
	 * Return a collection of Warehouse entities with all references set.
	 */
	@Provides
	@Named("warehouseEntitiesWithRefs")
	public Collection<WarehouseEntity> warehouseEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for warehouseEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for warehouseEntitiesWithRefs here] end
		WarehouseEntityFactory warehouseEntityFactory
	) {
		log.trace("Creating entities of type WarehouseEntity with references");

		// % protected region % [Apply any additional logic for warehouseEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseEntitiesWithRefs before the main body here] end

		Collection<WarehouseEntity> newEntities = warehouseEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for warehouseEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type WarehouseEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
