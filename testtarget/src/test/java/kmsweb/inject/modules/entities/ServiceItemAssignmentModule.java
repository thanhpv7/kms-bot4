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
 * Guice module for Service Item Assignment used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ServiceItemAssignmentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ServiceItemAssignmentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ServiceItemAssignmentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ServiceItemAssignmentEntityFactory serviceItemAssignmentEntityFactory(
			// % protected region % [Apply any additional injected arguments for serviceItemAssignmentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for serviceItemAssignmentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ServiceItemAssignmentEntityFactory");

		// % protected region % [Apply any additional logic for serviceItemAssignmentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentEntityFactory before the main body here] end

		ServiceItemAssignmentEntityFactory entityFactory = new ServiceItemAssignmentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ServiceItemAssignmentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ServiceItemAssignmentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for serviceItemAssignmentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentEntityFactory after the main body here] end

		log.trace("Created ServiceItemAssignmentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Service Item Assignment entity with no references set.
	 */
	@Provides
	@Named("serviceItemAssignmentEntityWithNoRef")
	public ServiceItemAssignmentEntity serviceItemAssignmentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for serviceItemAssignmentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for serviceItemAssignmentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ServiceItemAssignmentEntity with no reference");

		// % protected region % [Apply any additional logic for serviceItemAssignmentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentWithNoRef before the main body here] end

		ServiceItemAssignmentEntity newEntity = new ServiceItemAssignmentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Assign Code here] off begin
		String randomStringforAssignCode = mock
				.strings()
				.get();
		newEntity.setAssignCode(randomStringforAssignCode);
		// % protected region % [Add customisation for Assign Code here] end

		// % protected region % [Apply any additional logic for serviceItemAssignmentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentWithNoRef after the main body here] end

		log.trace("Created entity of type ServiceItemAssignmentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Service Item Assignment entities with no reference at all.
	 */
	@Provides
	@Named("serviceItemAssignmentEntitiesWithNoRef")
	public Collection<ServiceItemAssignmentEntity> serviceItemAssignmentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for serviceItemAssignmentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for serviceItemAssignmentEntitiesWithNoRef here] end
		ServiceItemAssignmentEntityFactory serviceItemAssignmentEntityFactory
	) {
		log.trace("Creating entities of type ServiceItemAssignmentEntity with no reference");

		// % protected region % [Apply any additional logic for serviceItemAssignmentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentEntitiesWithNoRef before the main body here] end

		Collection<ServiceItemAssignmentEntity> newEntities = serviceItemAssignmentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for serviceItemAssignmentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ServiceItemAssignmentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Service Item Assignment entity with all references set.
	 */
	@Provides
	@Named("serviceItemAssignmentEntityWithRefs")
	public ServiceItemAssignmentEntity serviceItemAssignmentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for serviceItemAssignmentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for serviceItemAssignmentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ServiceItemAssignmentEntity with references");

		// % protected region % [Apply any additional logic for serviceItemAssignmentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentEntityWithRefs before the main body here] end

		ServiceItemAssignmentEntity serviceItemAssignmentEntity = injector.getInstance(Key.get(ServiceItemAssignmentEntity.class, Names.named("serviceItemAssignmentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for serviceItemAssignmentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentEntityWithRefs after the main body here] end

		log.trace("Created entity of type ServiceItemAssignmentEntity with references");

		return serviceItemAssignmentEntity;
	}

	/**
	 * Return a collection of Service Item Assignment entities with all references set.
	 */
	@Provides
	@Named("serviceItemAssignmentEntitiesWithRefs")
	public Collection<ServiceItemAssignmentEntity> serviceItemAssignmentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for serviceItemAssignmentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for serviceItemAssignmentEntitiesWithRefs here] end
		ServiceItemAssignmentEntityFactory serviceItemAssignmentEntityFactory
	) {
		log.trace("Creating entities of type ServiceItemAssignmentEntity with references");

		// % protected region % [Apply any additional logic for serviceItemAssignmentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentEntitiesWithRefs before the main body here] end

		Collection<ServiceItemAssignmentEntity> newEntities = serviceItemAssignmentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for serviceItemAssignmentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemAssignmentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ServiceItemAssignmentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
