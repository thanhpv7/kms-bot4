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
 * Guice module for Insurance Provider used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InsuranceProviderModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InsuranceProviderModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InsuranceProviderModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InsuranceProviderEntityFactory insuranceProviderEntityFactory(
			// % protected region % [Apply any additional injected arguments for insuranceProviderEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for insuranceProviderEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InsuranceProviderEntityFactory");

		// % protected region % [Apply any additional logic for insuranceProviderEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderEntityFactory before the main body here] end

		InsuranceProviderEntityFactory entityFactory = new InsuranceProviderEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InsuranceProviderEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InsuranceProviderEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for insuranceProviderEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderEntityFactory after the main body here] end

		log.trace("Created InsuranceProviderEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Insurance Provider entity with no references set.
	 */
	@Provides
	@Named("insuranceProviderEntityWithNoRef")
	public InsuranceProviderEntity insuranceProviderEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for insuranceProviderEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for insuranceProviderEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InsuranceProviderEntity with no reference");

		// % protected region % [Apply any additional logic for insuranceProviderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderWithNoRef before the main body here] end

		InsuranceProviderEntity newEntity = new InsuranceProviderEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Provider Code here] off begin
		String randomStringforProviderCode = mock
				.strings()
				.get();
		newEntity.setProviderCode(randomStringforProviderCode);
		// % protected region % [Add customisation for Provider Code here] end
		// % protected region % [Add customisation for Provider Name here] off begin
		String randomStringforProviderName = mock
				.strings()
				.get();
		newEntity.setProviderName(randomStringforProviderName);
		// % protected region % [Add customisation for Provider Name here] end
		// % protected region % [Add customisation for Provider Type here] off begin
		String randomStringforProviderType = mock
				.strings()
				.get();
		newEntity.setProviderType(randomStringforProviderType);
		// % protected region % [Add customisation for Provider Type here] end
		// % protected region % [Add customisation for Benefit Provider here] off begin
		String randomStringforBenefitProvider = mock
				.strings()
				.get();
		newEntity.setBenefitProvider(randomStringforBenefitProvider);
		// % protected region % [Add customisation for Benefit Provider here] end
		// % protected region % [Add customisation for First Name here] off begin
		String randomStringforFirstName = mock
				.strings()
				.get();
		newEntity.setFirstName(randomStringforFirstName);
		// % protected region % [Add customisation for First Name here] end
		// % protected region % [Add customisation for Last Name here] off begin
		String randomStringforLastName = mock
				.strings()
				.get();
		newEntity.setLastName(randomStringforLastName);
		// % protected region % [Add customisation for Last Name here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringforPhoneNumber = mock
				.strings()
				.get();
		newEntity.setPhoneNumber(randomStringforPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Mobile Phone Number here] off begin
		String randomStringforMobilePhoneNumber = mock
				.strings()
				.get();
		newEntity.setMobilePhoneNumber(randomStringforMobilePhoneNumber);
		// % protected region % [Add customisation for Mobile Phone Number here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.strings()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Expiry Date here] off begin
		newEntity.setExpiryDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiry Date here] end
		// % protected region % [Add customisation for Expiring Date here] off begin
		newEntity.setExpiringDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiring Date here] end
		// % protected region % [Add customisation for Created Date here] off begin
		newEntity.setCreatedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Created Date here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for insuranceProviderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderWithNoRef after the main body here] end

		log.trace("Created entity of type InsuranceProviderEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Insurance Provider entities with no reference at all.
	 */
	@Provides
	@Named("insuranceProviderEntitiesWithNoRef")
	public Collection<InsuranceProviderEntity> insuranceProviderEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for insuranceProviderEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for insuranceProviderEntitiesWithNoRef here] end
		InsuranceProviderEntityFactory insuranceProviderEntityFactory
	) {
		log.trace("Creating entities of type InsuranceProviderEntity with no reference");

		// % protected region % [Apply any additional logic for insuranceProviderEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderEntitiesWithNoRef before the main body here] end

		Collection<InsuranceProviderEntity> newEntities = insuranceProviderEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for insuranceProviderEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InsuranceProviderEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Insurance Provider entity with all references set.
	 */
	@Provides
	@Named("insuranceProviderEntityWithRefs")
	public InsuranceProviderEntity insuranceProviderEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for insuranceProviderEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for insuranceProviderEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InsuranceProviderEntity with references");

		// % protected region % [Apply any additional logic for insuranceProviderEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderEntityWithRefs before the main body here] end

		InsuranceProviderEntity insuranceProviderEntity = injector.getInstance(Key.get(InsuranceProviderEntity.class, Names.named("insuranceProviderEntityWithNoRef")));

		// % protected region % [Apply any additional logic for insuranceProviderEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderEntityWithRefs after the main body here] end

		log.trace("Created entity of type InsuranceProviderEntity with references");

		return insuranceProviderEntity;
	}

	/**
	 * Return a collection of Insurance Provider entities with all references set.
	 */
	@Provides
	@Named("insuranceProviderEntitiesWithRefs")
	public Collection<InsuranceProviderEntity> insuranceProviderEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for insuranceProviderEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for insuranceProviderEntitiesWithRefs here] end
		InsuranceProviderEntityFactory insuranceProviderEntityFactory
	) {
		log.trace("Creating entities of type InsuranceProviderEntity with references");

		// % protected region % [Apply any additional logic for insuranceProviderEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderEntitiesWithRefs before the main body here] end

		Collection<InsuranceProviderEntity> newEntities = insuranceProviderEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for insuranceProviderEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceProviderEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InsuranceProviderEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
