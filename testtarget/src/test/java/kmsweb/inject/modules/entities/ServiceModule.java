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
 * Guice module for Service used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ServiceModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ServiceModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ServiceModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ServiceEntityFactory serviceEntityFactory(
			// % protected region % [Apply any additional injected arguments for serviceEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for serviceEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ServiceEntityFactory");

		// % protected region % [Apply any additional logic for serviceEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceEntityFactory before the main body here] end

		ServiceEntityFactory entityFactory = new ServiceEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ServiceEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ServiceEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for serviceEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceEntityFactory after the main body here] end

		log.trace("Created ServiceEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Service entity with no references set.
	 */
	@Provides
	@Named("serviceEntityWithNoRef")
	public ServiceEntity serviceEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for serviceEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for serviceEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ServiceEntity with no reference");

		// % protected region % [Apply any additional logic for serviceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceWithNoRef before the main body here] end

		ServiceEntity newEntity = new ServiceEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Service Number here] off begin
		String randomStringforServiceNumber = mock
				.strings()
				.get();
		newEntity.setServiceNumber(randomStringforServiceNumber);
		// % protected region % [Add customisation for Service Number here] end
		// % protected region % [Add customisation for Service Name here] off begin
		String randomStringforServiceName = mock
				.strings()
				.get();
		newEntity.setServiceName(randomStringforServiceName);
		// % protected region % [Add customisation for Service Name here] end
		// % protected region % [Add customisation for Section Code here] off begin
		String randomStringforSectionCode = mock
				.strings()
				.get();
		newEntity.setSectionCode(randomStringforSectionCode);
		// % protected region % [Add customisation for Section Code here] end
		// % protected region % [Add customisation for By pass Doctor Assignment here] off begin
		newEntity.setByPassDoctorAssignment(mock.bools().get());
		// % protected region % [Add customisation for By pass Doctor Assignment here] end
		// % protected region % [Add customisation for Has Examination Item here] off begin
		newEntity.setHasExaminationItem(mock.bools().get());
		// % protected region % [Add customisation for Has Examination Item here] end
		// % protected region % [Add customisation for Revenue Center here] off begin
		String randomStringforRevenueCenter = mock
				.strings()
				.get();
		newEntity.setRevenueCenter(randomStringforRevenueCenter);
		// % protected region % [Add customisation for Revenue Center here] end
		// % protected region % [Add customisation for Service Code here] off begin
		String randomStringforServiceCode = mock
				.strings()
				.get();
		newEntity.setServiceCode(randomStringforServiceCode);
		// % protected region % [Add customisation for Service Code here] end

		// % protected region % [Apply any additional logic for serviceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceWithNoRef after the main body here] end

		log.trace("Created entity of type ServiceEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Service entities with no reference at all.
	 */
	@Provides
	@Named("serviceEntitiesWithNoRef")
	public Collection<ServiceEntity> serviceEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for serviceEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for serviceEntitiesWithNoRef here] end
		ServiceEntityFactory serviceEntityFactory
	) {
		log.trace("Creating entities of type ServiceEntity with no reference");

		// % protected region % [Apply any additional logic for serviceEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceEntitiesWithNoRef before the main body here] end

		Collection<ServiceEntity> newEntities = serviceEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for serviceEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ServiceEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Service entity with all references set.
	 */
	@Provides
	@Named("serviceEntityWithRefs")
	public ServiceEntity serviceEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for serviceEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for serviceEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ServiceEntity with references");

		// % protected region % [Apply any additional logic for serviceEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceEntityWithRefs before the main body here] end

		ServiceEntity serviceEntity = injector.getInstance(Key.get(ServiceEntity.class, Names.named("serviceEntityWithNoRef")));

		// % protected region % [Apply any additional logic for serviceEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceEntityWithRefs after the main body here] end

		log.trace("Created entity of type ServiceEntity with references");

		return serviceEntity;
	}

	/**
	 * Return a collection of Service entities with all references set.
	 */
	@Provides
	@Named("serviceEntitiesWithRefs")
	public Collection<ServiceEntity> serviceEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for serviceEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for serviceEntitiesWithRefs here] end
		ServiceEntityFactory serviceEntityFactory
	) {
		log.trace("Creating entities of type ServiceEntity with references");

		// % protected region % [Apply any additional logic for serviceEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceEntitiesWithRefs before the main body here] end

		Collection<ServiceEntity> newEntities = serviceEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for serviceEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ServiceEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
