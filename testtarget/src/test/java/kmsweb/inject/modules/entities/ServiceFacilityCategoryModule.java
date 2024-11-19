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
 * Guice module for Service Facility Category used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ServiceFacilityCategoryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ServiceFacilityCategoryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ServiceFacilityCategoryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ServiceFacilityCategoryEntityFactory serviceFacilityCategoryEntityFactory(
			// % protected region % [Apply any additional injected arguments for serviceFacilityCategoryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for serviceFacilityCategoryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ServiceFacilityCategoryEntityFactory");

		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntityFactory before the main body here] end

		ServiceFacilityCategoryEntityFactory entityFactory = new ServiceFacilityCategoryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ServiceFacilityCategoryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ServiceFacilityCategoryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntityFactory after the main body here] end

		log.trace("Created ServiceFacilityCategoryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Service Facility Category entity with no references set.
	 */
	@Provides
	@Named("serviceFacilityCategoryEntityWithNoRef")
	public ServiceFacilityCategoryEntity serviceFacilityCategoryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for serviceFacilityCategoryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for serviceFacilityCategoryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ServiceFacilityCategoryEntity with no reference");

		// % protected region % [Apply any additional logic for serviceFacilityCategoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryWithNoRef before the main body here] end

		ServiceFacilityCategoryEntity newEntity = new ServiceFacilityCategoryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Facility Code here] off begin
		String randomStringforFacilityCode = mock
				.strings()
				.get();
		newEntity.setFacilityCode(randomStringforFacilityCode);
		// % protected region % [Add customisation for Facility Code here] end

		// % protected region % [Apply any additional logic for serviceFacilityCategoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryWithNoRef after the main body here] end

		log.trace("Created entity of type ServiceFacilityCategoryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Service Facility Category entities with no reference at all.
	 */
	@Provides
	@Named("serviceFacilityCategoryEntitiesWithNoRef")
	public Collection<ServiceFacilityCategoryEntity> serviceFacilityCategoryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for serviceFacilityCategoryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for serviceFacilityCategoryEntitiesWithNoRef here] end
		ServiceFacilityCategoryEntityFactory serviceFacilityCategoryEntityFactory
	) {
		log.trace("Creating entities of type ServiceFacilityCategoryEntity with no reference");

		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntitiesWithNoRef before the main body here] end

		Collection<ServiceFacilityCategoryEntity> newEntities = serviceFacilityCategoryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ServiceFacilityCategoryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Service Facility Category entity with all references set.
	 */
	@Provides
	@Named("serviceFacilityCategoryEntityWithRefs")
	public ServiceFacilityCategoryEntity serviceFacilityCategoryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for serviceFacilityCategoryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for serviceFacilityCategoryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ServiceFacilityCategoryEntity with references");

		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntityWithRefs before the main body here] end

		ServiceFacilityCategoryEntity serviceFacilityCategoryEntity = injector.getInstance(Key.get(ServiceFacilityCategoryEntity.class, Names.named("serviceFacilityCategoryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntityWithRefs after the main body here] end

		log.trace("Created entity of type ServiceFacilityCategoryEntity with references");

		return serviceFacilityCategoryEntity;
	}

	/**
	 * Return a collection of Service Facility Category entities with all references set.
	 */
	@Provides
	@Named("serviceFacilityCategoryEntitiesWithRefs")
	public Collection<ServiceFacilityCategoryEntity> serviceFacilityCategoryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for serviceFacilityCategoryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for serviceFacilityCategoryEntitiesWithRefs here] end
		ServiceFacilityCategoryEntityFactory serviceFacilityCategoryEntityFactory
	) {
		log.trace("Creating entities of type ServiceFacilityCategoryEntity with references");

		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntitiesWithRefs before the main body here] end

		Collection<ServiceFacilityCategoryEntity> newEntities = serviceFacilityCategoryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceFacilityCategoryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ServiceFacilityCategoryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
