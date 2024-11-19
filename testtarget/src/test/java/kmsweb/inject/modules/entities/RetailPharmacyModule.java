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
 * Guice module for Retail Pharmacy used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class RetailPharmacyModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring RetailPharmacyModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured RetailPharmacyModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public RetailPharmacyEntityFactory retailPharmacyEntityFactory(
			// % protected region % [Apply any additional injected arguments for retailPharmacyEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for retailPharmacyEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating RetailPharmacyEntityFactory");

		// % protected region % [Apply any additional logic for retailPharmacyEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyEntityFactory before the main body here] end

		RetailPharmacyEntityFactory entityFactory = new RetailPharmacyEntityFactory(
				// % protected region % [Apply any additional constructor arguments for RetailPharmacyEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for RetailPharmacyEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for retailPharmacyEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyEntityFactory after the main body here] end

		log.trace("Created RetailPharmacyEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Retail Pharmacy entity with no references set.
	 */
	@Provides
	@Named("retailPharmacyEntityWithNoRef")
	public RetailPharmacyEntity retailPharmacyEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for retailPharmacyEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for retailPharmacyEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type RetailPharmacyEntity with no reference");

		// % protected region % [Apply any additional logic for retailPharmacyWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyWithNoRef before the main body here] end

		RetailPharmacyEntity newEntity = new RetailPharmacyEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Customer Type here] off begin
		String randomStringforCustomerType = mock
				.strings()
				.get();
		newEntity.setCustomerType(randomStringforCustomerType);
		// % protected region % [Add customisation for Customer Type here] end
		// % protected region % [Add customisation for Retail Number here] off begin
		String randomStringforRetailNumber = mock
				.strings()
				.get();
		newEntity.setRetailNumber(randomStringforRetailNumber);
		// % protected region % [Add customisation for Retail Number here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for Customer Name here] off begin
		String randomStringforCustomerName = mock
				.strings()
				.get();
		newEntity.setCustomerName(randomStringforCustomerName);
		// % protected region % [Add customisation for Customer Name here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringforAddress = mock
				.strings()
				.get();
		newEntity.setAddress(randomStringforAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringforPhoneNumber = mock
				.strings()
				.get();
		newEntity.setPhoneNumber(randomStringforPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Payment Status here] off begin
		String randomStringforPaymentStatus = mock
				.strings()
				.get();
		newEntity.setPaymentStatus(randomStringforPaymentStatus);
		// % protected region % [Add customisation for Payment Status here] end
		// % protected region % [Add customisation for Total Price here] off begin
		newEntity.setTotalPrice(mock.doubles().get());
		// % protected region % [Add customisation for Total Price here] end

		// % protected region % [Apply any additional logic for retailPharmacyWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyWithNoRef after the main body here] end

		log.trace("Created entity of type RetailPharmacyEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Retail Pharmacy entities with no reference at all.
	 */
	@Provides
	@Named("retailPharmacyEntitiesWithNoRef")
	public Collection<RetailPharmacyEntity> retailPharmacyEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for retailPharmacyEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for retailPharmacyEntitiesWithNoRef here] end
		RetailPharmacyEntityFactory retailPharmacyEntityFactory
	) {
		log.trace("Creating entities of type RetailPharmacyEntity with no reference");

		// % protected region % [Apply any additional logic for retailPharmacyEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyEntitiesWithNoRef before the main body here] end

		Collection<RetailPharmacyEntity> newEntities = retailPharmacyEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for retailPharmacyEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type RetailPharmacyEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Retail Pharmacy entity with all references set.
	 */
	@Provides
	@Named("retailPharmacyEntityWithRefs")
	public RetailPharmacyEntity retailPharmacyEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for retailPharmacyEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for retailPharmacyEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type RetailPharmacyEntity with references");

		// % protected region % [Apply any additional logic for retailPharmacyEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyEntityWithRefs before the main body here] end

		RetailPharmacyEntity retailPharmacyEntity = injector.getInstance(Key.get(RetailPharmacyEntity.class, Names.named("retailPharmacyEntityWithNoRef")));

		// % protected region % [Apply any additional logic for retailPharmacyEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyEntityWithRefs after the main body here] end

		log.trace("Created entity of type RetailPharmacyEntity with references");

		return retailPharmacyEntity;
	}

	/**
	 * Return a collection of Retail Pharmacy entities with all references set.
	 */
	@Provides
	@Named("retailPharmacyEntitiesWithRefs")
	public Collection<RetailPharmacyEntity> retailPharmacyEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for retailPharmacyEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for retailPharmacyEntitiesWithRefs here] end
		RetailPharmacyEntityFactory retailPharmacyEntityFactory
	) {
		log.trace("Creating entities of type RetailPharmacyEntity with references");

		// % protected region % [Apply any additional logic for retailPharmacyEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyEntitiesWithRefs before the main body here] end

		Collection<RetailPharmacyEntity> newEntities = retailPharmacyEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for retailPharmacyEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type RetailPharmacyEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
