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
 * Guice module for Hospital Group Information used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class HospitalGroupInformationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring HospitalGroupInformationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured HospitalGroupInformationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public HospitalGroupInformationEntityFactory hospitalGroupInformationEntityFactory(
			// % protected region % [Apply any additional injected arguments for hospitalGroupInformationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for hospitalGroupInformationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating HospitalGroupInformationEntityFactory");

		// % protected region % [Apply any additional logic for hospitalGroupInformationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationEntityFactory before the main body here] end

		HospitalGroupInformationEntityFactory entityFactory = new HospitalGroupInformationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for HospitalGroupInformationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for HospitalGroupInformationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for hospitalGroupInformationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationEntityFactory after the main body here] end

		log.trace("Created HospitalGroupInformationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Hospital Group Information entity with no references set.
	 */
	@Provides
	@Named("hospitalGroupInformationEntityWithNoRef")
	public HospitalGroupInformationEntity hospitalGroupInformationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for hospitalGroupInformationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for hospitalGroupInformationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type HospitalGroupInformationEntity with no reference");

		// % protected region % [Apply any additional logic for hospitalGroupInformationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationWithNoRef before the main body here] end

		HospitalGroupInformationEntity newEntity = new HospitalGroupInformationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Hospital Group Code here] off begin
		String randomStringforHospitalGroupCode = mock
				.strings()
				.get();
		newEntity.setHospitalGroupCode(randomStringforHospitalGroupCode);
		// % protected region % [Add customisation for Hospital Group Code here] end
		// % protected region % [Add customisation for Hospital Group Name here] off begin
		String randomStringforHospitalGroupName = mock
				.strings()
				.get();
		newEntity.setHospitalGroupName(randomStringforHospitalGroupName);
		// % protected region % [Add customisation for Hospital Group Name here] end
		// % protected region % [Add customisation for Hospital Group Corporation Name here] off begin
		String randomStringforHospitalGroupCorporationName = mock
				.strings()
				.get();
		newEntity.setHospitalGroupCorporationName(randomStringforHospitalGroupCorporationName);
		// % protected region % [Add customisation for Hospital Group Corporation Name here] end
		// % protected region % [Add customisation for Hospital Group Director here] off begin
		String randomStringforHospitalGroupDirector = mock
				.strings()
				.get();
		newEntity.setHospitalGroupDirector(randomStringforHospitalGroupDirector);
		// % protected region % [Add customisation for Hospital Group Director here] end
		// % protected region % [Add customisation for Operational License No here] off begin
		String randomStringforOperationalLicenseNo = mock
				.strings()
				.get();
		newEntity.setOperationalLicenseNo(randomStringforOperationalLicenseNo);
		// % protected region % [Add customisation for Operational License No here] end
		// % protected region % [Add customisation for Hospital Group Corporation Status here] off begin
		String randomStringforHospitalGroupCorporationStatus = mock
				.strings()
				.get();
		newEntity.setHospitalGroupCorporationStatus(randomStringforHospitalGroupCorporationStatus);
		// % protected region % [Add customisation for Hospital Group Corporation Status here] end
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
		// % protected region % [Add customisation for Postcode here] off begin
		String randomStringforPostcode = mock
				.strings()
				.get();
		newEntity.setPostcode(randomStringforPostcode);
		// % protected region % [Add customisation for Postcode here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringforPhoneNumber = mock
				.strings()
				.get();
		newEntity.setPhoneNumber(randomStringforPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Fax here] off begin
		String randomStringforFax = mock
				.strings()
				.get();
		newEntity.setFax(randomStringforFax);
		// % protected region % [Add customisation for Fax here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.strings()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Website here] off begin
		String randomStringforWebsite = mock
				.strings()
				.get();
		newEntity.setWebsite(randomStringforWebsite);
		// % protected region % [Add customisation for Website here] end
		// % protected region % [Add customisation for Contact Person here] off begin
		String randomStringforContactPerson = mock
				.strings()
				.get();
		newEntity.setContactPerson(randomStringforContactPerson);
		// % protected region % [Add customisation for Contact Person here] end
		// % protected region % [Add customisation for Contact Person Phone Number here] off begin
		String randomStringforContactPersonPhoneNumber = mock
				.strings()
				.get();
		newEntity.setContactPersonPhoneNumber(randomStringforContactPersonPhoneNumber);
		// % protected region % [Add customisation for Contact Person Phone Number here] end
		// % protected region % [Add customisation for Contact Person Email here] off begin
		String randomStringforContactPersonEmail = mock
				.strings()
				.get();
		newEntity.setContactPersonEmail(randomStringforContactPersonEmail);
		// % protected region % [Add customisation for Contact Person Email here] end

		// % protected region % [Apply any additional logic for hospitalGroupInformationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationWithNoRef after the main body here] end

		log.trace("Created entity of type HospitalGroupInformationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Hospital Group Information entities with no reference at all.
	 */
	@Provides
	@Named("hospitalGroupInformationEntitiesWithNoRef")
	public Collection<HospitalGroupInformationEntity> hospitalGroupInformationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for hospitalGroupInformationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for hospitalGroupInformationEntitiesWithNoRef here] end
		HospitalGroupInformationEntityFactory hospitalGroupInformationEntityFactory
	) {
		log.trace("Creating entities of type HospitalGroupInformationEntity with no reference");

		// % protected region % [Apply any additional logic for hospitalGroupInformationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationEntitiesWithNoRef before the main body here] end

		Collection<HospitalGroupInformationEntity> newEntities = hospitalGroupInformationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for hospitalGroupInformationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type HospitalGroupInformationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Hospital Group Information entity with all references set.
	 */
	@Provides
	@Named("hospitalGroupInformationEntityWithRefs")
	public HospitalGroupInformationEntity hospitalGroupInformationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for hospitalGroupInformationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for hospitalGroupInformationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type HospitalGroupInformationEntity with references");

		// % protected region % [Apply any additional logic for hospitalGroupInformationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationEntityWithRefs before the main body here] end

		HospitalGroupInformationEntity hospitalGroupInformationEntity = injector.getInstance(Key.get(HospitalGroupInformationEntity.class, Names.named("hospitalGroupInformationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for hospitalGroupInformationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationEntityWithRefs after the main body here] end

		log.trace("Created entity of type HospitalGroupInformationEntity with references");

		return hospitalGroupInformationEntity;
	}

	/**
	 * Return a collection of Hospital Group Information entities with all references set.
	 */
	@Provides
	@Named("hospitalGroupInformationEntitiesWithRefs")
	public Collection<HospitalGroupInformationEntity> hospitalGroupInformationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for hospitalGroupInformationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for hospitalGroupInformationEntitiesWithRefs here] end
		HospitalGroupInformationEntityFactory hospitalGroupInformationEntityFactory
	) {
		log.trace("Creating entities of type HospitalGroupInformationEntity with references");

		// % protected region % [Apply any additional logic for hospitalGroupInformationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationEntitiesWithRefs before the main body here] end

		Collection<HospitalGroupInformationEntity> newEntities = hospitalGroupInformationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for hospitalGroupInformationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalGroupInformationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type HospitalGroupInformationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
