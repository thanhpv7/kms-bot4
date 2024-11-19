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
 * Guice module for Health Facility used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class HealthFacilityModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring HealthFacilityModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured HealthFacilityModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public HealthFacilityEntityFactory healthFacilityEntityFactory(
			// % protected region % [Apply any additional injected arguments for healthFacilityEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for healthFacilityEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating HealthFacilityEntityFactory");

		// % protected region % [Apply any additional logic for healthFacilityEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityEntityFactory before the main body here] end

		HealthFacilityEntityFactory entityFactory = new HealthFacilityEntityFactory(
				// % protected region % [Apply any additional constructor arguments for HealthFacilityEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for HealthFacilityEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for healthFacilityEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityEntityFactory after the main body here] end

		log.trace("Created HealthFacilityEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Health Facility entity with no references set.
	 */
	@Provides
	@Named("healthFacilityEntityWithNoRef")
	public HealthFacilityEntity healthFacilityEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for healthFacilityEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for healthFacilityEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type HealthFacilityEntity with no reference");

		// % protected region % [Apply any additional logic for healthFacilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityWithNoRef before the main body here] end

		HealthFacilityEntity newEntity = new HealthFacilityEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Health Facility ID here] off begin
		String randomStringforHealthFacilityID = mock
				.strings()
				.get();
		newEntity.setHealthFacilityID(randomStringforHealthFacilityID);
		// % protected region % [Add customisation for Health Facility ID here] end
		// % protected region % [Add customisation for Health Facility Name here] off begin
		String randomStringforHealthFacilityName = mock
				.strings()
				.get();
		newEntity.setHealthFacilityName(randomStringforHealthFacilityName);
		// % protected region % [Add customisation for Health Facility Name here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringforAddress = mock
				.strings()
				.get();
		newEntity.setAddress(randomStringforAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for City here] off begin
		String randomStringforCity = mock
				.strings()
				.get();
		newEntity.setCity(randomStringforCity);
		// % protected region % [Add customisation for City here] end
		// % protected region % [Add customisation for Post Code here] off begin
		String randomStringforPostCode = mock
				.strings()
				.get();
		newEntity.setPostCode(randomStringforPostCode);
		// % protected region % [Add customisation for Post Code here] end
		// % protected region % [Add customisation for Province here] off begin
		String randomStringforProvince = mock
				.strings()
				.get();
		newEntity.setProvince(randomStringforProvince);
		// % protected region % [Add customisation for Province here] end
		// % protected region % [Add customisation for Country here] off begin
		String randomStringforCountry = mock
				.strings()
				.get();
		newEntity.setCountry(randomStringforCountry);
		// % protected region % [Add customisation for Country here] end
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
		// % protected region % [Add customisation for website here] off begin
		String randomStringforWebsite = mock
				.strings()
				.get();
		newEntity.setWebsite(randomStringforWebsite);
		// % protected region % [Add customisation for website here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.strings()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Salutation here] off begin
		String randomStringforSalutation = mock
				.strings()
				.get();
		newEntity.setSalutation(randomStringforSalutation);
		// % protected region % [Add customisation for Salutation here] end
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
		// % protected region % [Add customisation for Phone Number POC here] off begin
		String randomStringforPhoneNumberPOC = mock
				.strings()
				.get();
		newEntity.setPhoneNumberPOC(randomStringforPhoneNumberPOC);
		// % protected region % [Add customisation for Phone Number POC here] end
		// % protected region % [Add customisation for Mobile Phone Number POC here] off begin
		String randomStringforMobilePhoneNumberPOC = mock
				.strings()
				.get();
		newEntity.setMobilePhoneNumberPOC(randomStringforMobilePhoneNumberPOC);
		// % protected region % [Add customisation for Mobile Phone Number POC here] end
		// % protected region % [Add customisation for Email POC here] off begin
		String randomStringforEmailPOC = mock
				.strings()
				.get();
		newEntity.setEmailPOC(randomStringforEmailPOC);
		// % protected region % [Add customisation for Email POC here] end
		// % protected region % [Add customisation for Health Facility Type here] off begin
		String randomStringforHealthFacilityType = mock
				.strings()
				.get();
		newEntity.setHealthFacilityType(randomStringforHealthFacilityType);
		// % protected region % [Add customisation for Health Facility Type here] end

		// % protected region % [Apply any additional logic for healthFacilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityWithNoRef after the main body here] end

		log.trace("Created entity of type HealthFacilityEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Health Facility entities with no reference at all.
	 */
	@Provides
	@Named("healthFacilityEntitiesWithNoRef")
	public Collection<HealthFacilityEntity> healthFacilityEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for healthFacilityEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for healthFacilityEntitiesWithNoRef here] end
		HealthFacilityEntityFactory healthFacilityEntityFactory
	) {
		log.trace("Creating entities of type HealthFacilityEntity with no reference");

		// % protected region % [Apply any additional logic for healthFacilityEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityEntitiesWithNoRef before the main body here] end

		Collection<HealthFacilityEntity> newEntities = healthFacilityEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for healthFacilityEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type HealthFacilityEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Health Facility entity with all references set.
	 */
	@Provides
	@Named("healthFacilityEntityWithRefs")
	public HealthFacilityEntity healthFacilityEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for healthFacilityEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for healthFacilityEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type HealthFacilityEntity with references");

		// % protected region % [Apply any additional logic for healthFacilityEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityEntityWithRefs before the main body here] end

		HealthFacilityEntity healthFacilityEntity = injector.getInstance(Key.get(HealthFacilityEntity.class, Names.named("healthFacilityEntityWithNoRef")));

		// % protected region % [Apply any additional logic for healthFacilityEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityEntityWithRefs after the main body here] end

		log.trace("Created entity of type HealthFacilityEntity with references");

		return healthFacilityEntity;
	}

	/**
	 * Return a collection of Health Facility entities with all references set.
	 */
	@Provides
	@Named("healthFacilityEntitiesWithRefs")
	public Collection<HealthFacilityEntity> healthFacilityEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for healthFacilityEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for healthFacilityEntitiesWithRefs here] end
		HealthFacilityEntityFactory healthFacilityEntityFactory
	) {
		log.trace("Creating entities of type HealthFacilityEntity with references");

		// % protected region % [Apply any additional logic for healthFacilityEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityEntitiesWithRefs before the main body here] end

		Collection<HealthFacilityEntity> newEntities = healthFacilityEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for healthFacilityEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for healthFacilityEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type HealthFacilityEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
