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
 * Guice module for Service Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ServiceItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ServiceItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ServiceItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ServiceItemEntityFactory serviceItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for serviceItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for serviceItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ServiceItemEntityFactory");

		// % protected region % [Apply any additional logic for serviceItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemEntityFactory before the main body here] end

		ServiceItemEntityFactory entityFactory = new ServiceItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ServiceItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ServiceItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for serviceItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemEntityFactory after the main body here] end

		log.trace("Created ServiceItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Service Item entity with no references set.
	 */
	@Provides
	@Named("serviceItemEntityWithNoRef")
	public ServiceItemEntity serviceItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for serviceItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for serviceItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ServiceItemEntity with no reference");

		// % protected region % [Apply any additional logic for serviceItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemWithNoRef before the main body here] end

		ServiceItemEntity newEntity = new ServiceItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Service Item Code here] off begin
		String randomStringforServiceItemCode = mock
				.strings()
				.get();
		newEntity.setServiceItemCode(randomStringforServiceItemCode);
		// % protected region % [Add customisation for Service Item Code here] end
		// % protected region % [Add customisation for Service Item Name here] off begin
		String randomStringforServiceItemName = mock
				.strings()
				.get();
		newEntity.setServiceItemName(randomStringforServiceItemName);
		// % protected region % [Add customisation for Service Item Name here] end
		// % protected region % [Add customisation for Classification here] off begin
		String randomStringforClassification = mock
				.strings()
				.get();
		newEntity.setClassification(randomStringforClassification);
		// % protected region % [Add customisation for Classification here] end
		// % protected region % [Add customisation for Apply to all Service here] off begin
		newEntity.setApplyToAllService(mock.bools().get());
		// % protected region % [Add customisation for Apply to all Service here] end
		// % protected region % [Add customisation for Apply To here] off begin
		newEntity.setApplyTo(ApplyToEnum.SECTION);
		// % protected region % [Add customisation for Apply To here] end
		// % protected region % [Add customisation for COA COGS here] off begin
		String randomStringforCoaCOGS = mock
				.strings()
				.get();
		newEntity.setCoaCOGS(randomStringforCoaCOGS);
		// % protected region % [Add customisation for COA COGS here] end
		// % protected region % [Add customisation for COA Sell here] off begin
		String randomStringforCoaSell = mock
				.strings()
				.get();
		newEntity.setCoaSell(randomStringforCoaSell);
		// % protected region % [Add customisation for COA Sell here] end
		// % protected region % [Add customisation for COA Inventory here] off begin
		String randomStringforCoaInventory = mock
				.strings()
				.get();
		newEntity.setCoaInventory(randomStringforCoaInventory);
		// % protected region % [Add customisation for COA Inventory here] end

		// % protected region % [Apply any additional logic for serviceItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemWithNoRef after the main body here] end

		log.trace("Created entity of type ServiceItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Service Item entities with no reference at all.
	 */
	@Provides
	@Named("serviceItemEntitiesWithNoRef")
	public Collection<ServiceItemEntity> serviceItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for serviceItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for serviceItemEntitiesWithNoRef here] end
		ServiceItemEntityFactory serviceItemEntityFactory
	) {
		log.trace("Creating entities of type ServiceItemEntity with no reference");

		// % protected region % [Apply any additional logic for serviceItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemEntitiesWithNoRef before the main body here] end

		Collection<ServiceItemEntity> newEntities = serviceItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for serviceItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ServiceItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Service Item entity with all references set.
	 */
	@Provides
	@Named("serviceItemEntityWithRefs")
	public ServiceItemEntity serviceItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for serviceItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for serviceItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ServiceItemEntity with references");

		// % protected region % [Apply any additional logic for serviceItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemEntityWithRefs before the main body here] end

		ServiceItemEntity serviceItemEntity = injector.getInstance(Key.get(ServiceItemEntity.class, Names.named("serviceItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for serviceItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type ServiceItemEntity with references");

		return serviceItemEntity;
	}

	/**
	 * Return a collection of Service Item entities with all references set.
	 */
	@Provides
	@Named("serviceItemEntitiesWithRefs")
	public Collection<ServiceItemEntity> serviceItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for serviceItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for serviceItemEntitiesWithRefs here] end
		ServiceItemEntityFactory serviceItemEntityFactory
	) {
		log.trace("Creating entities of type ServiceItemEntity with references");

		// % protected region % [Apply any additional logic for serviceItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemEntitiesWithRefs before the main body here] end

		Collection<ServiceItemEntity> newEntities = serviceItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for serviceItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for serviceItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ServiceItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
