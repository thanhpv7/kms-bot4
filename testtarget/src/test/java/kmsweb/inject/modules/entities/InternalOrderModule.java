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
 * Guice module for Internal Order used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InternalOrderModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InternalOrderModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InternalOrderModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InternalOrderEntityFactory internalOrderEntityFactory(
			// % protected region % [Apply any additional injected arguments for internalOrderEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for internalOrderEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InternalOrderEntityFactory");

		// % protected region % [Apply any additional logic for internalOrderEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderEntityFactory before the main body here] end

		InternalOrderEntityFactory entityFactory = new InternalOrderEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InternalOrderEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InternalOrderEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for internalOrderEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderEntityFactory after the main body here] end

		log.trace("Created InternalOrderEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Internal Order entity with no references set.
	 */
	@Provides
	@Named("internalOrderEntityWithNoRef")
	public InternalOrderEntity internalOrderEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for internalOrderEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for internalOrderEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InternalOrderEntity with no reference");

		// % protected region % [Apply any additional logic for internalOrderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderWithNoRef before the main body here] end

		InternalOrderEntity newEntity = new InternalOrderEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Internal Order Number here] off begin
		String randomStringforInternalOrderNumber = mock
				.strings()
				.get();
		newEntity.setInternalOrderNumber(randomStringforInternalOrderNumber);
		// % protected region % [Add customisation for Internal Order Number here] end
		// % protected region % [Add customisation for Transaction Status here] off begin
		String randomStringforTransactionStatus = mock
				.strings()
				.get();
		newEntity.setTransactionStatus(randomStringforTransactionStatus);
		// % protected region % [Add customisation for Transaction Status here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringforApprovalStatus = mock
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringforApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Order Date here] off begin
		newEntity.setOrderDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date here] end
		// % protected region % [Add customisation for Expected Date here] off begin
		newEntity.setExpectedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expected Date here] end
		// % protected region % [Add customisation for Request Unit here] off begin
		String randomStringforRequestUnit = mock
				.strings()
				.get();
		newEntity.setRequestUnit(randomStringforRequestUnit);
		// % protected region % [Add customisation for Request Unit here] end
		// % protected region % [Add customisation for Request Person here] off begin
		String randomStringforRequestPerson = mock
				.strings()
				.get();
		newEntity.setRequestPerson(randomStringforRequestPerson);
		// % protected region % [Add customisation for Request Person here] end
		// % protected region % [Add customisation for Transaction Detail Type here] off begin
		String randomStringforTransactionDetailType = mock
				.strings()
				.get();
		newEntity.setTransactionDetailType(randomStringforTransactionDetailType);
		// % protected region % [Add customisation for Transaction Detail Type here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringforReferenceNumber = mock
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringforReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Void Date here] off begin
		newEntity.setVoidDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date here] end
		// % protected region % [Add customisation for Issued Date Time here] off begin
		newEntity.setIssuedDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Issued Date Time here] end
		// % protected region % [Add customisation for Received Date Time here] off begin
		newEntity.setReceivedDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Received Date Time here] end

		// % protected region % [Apply any additional logic for internalOrderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderWithNoRef after the main body here] end

		log.trace("Created entity of type InternalOrderEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Internal Order entities with no reference at all.
	 */
	@Provides
	@Named("internalOrderEntitiesWithNoRef")
	public Collection<InternalOrderEntity> internalOrderEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for internalOrderEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for internalOrderEntitiesWithNoRef here] end
		InternalOrderEntityFactory internalOrderEntityFactory
	) {
		log.trace("Creating entities of type InternalOrderEntity with no reference");

		// % protected region % [Apply any additional logic for internalOrderEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderEntitiesWithNoRef before the main body here] end

		Collection<InternalOrderEntity> newEntities = internalOrderEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for internalOrderEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InternalOrderEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Internal Order entity with all references set.
	 */
	@Provides
	@Named("internalOrderEntityWithRefs")
	public InternalOrderEntity internalOrderEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for internalOrderEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for internalOrderEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InternalOrderEntity with references");

		// % protected region % [Apply any additional logic for internalOrderEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderEntityWithRefs before the main body here] end

		InternalOrderEntity internalOrderEntity = injector.getInstance(Key.get(InternalOrderEntity.class, Names.named("internalOrderEntityWithNoRef")));

		// % protected region % [Apply any additional logic for internalOrderEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderEntityWithRefs after the main body here] end

		log.trace("Created entity of type InternalOrderEntity with references");

		return internalOrderEntity;
	}

	/**
	 * Return a collection of Internal Order entities with all references set.
	 */
	@Provides
	@Named("internalOrderEntitiesWithRefs")
	public Collection<InternalOrderEntity> internalOrderEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for internalOrderEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for internalOrderEntitiesWithRefs here] end
		InternalOrderEntityFactory internalOrderEntityFactory
	) {
		log.trace("Creating entities of type InternalOrderEntity with references");

		// % protected region % [Apply any additional logic for internalOrderEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderEntitiesWithRefs before the main body here] end

		Collection<InternalOrderEntity> newEntities = internalOrderEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for internalOrderEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for internalOrderEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InternalOrderEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
