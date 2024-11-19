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
 * Guice module for Pharmacy Setup used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PharmacySetupModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PharmacySetupModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PharmacySetupModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PharmacySetupEntityFactory pharmacySetupEntityFactory(
			// % protected region % [Apply any additional injected arguments for pharmacySetupEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pharmacySetupEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PharmacySetupEntityFactory");

		// % protected region % [Apply any additional logic for pharmacySetupEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupEntityFactory before the main body here] end

		PharmacySetupEntityFactory entityFactory = new PharmacySetupEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PharmacySetupEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PharmacySetupEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pharmacySetupEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupEntityFactory after the main body here] end

		log.trace("Created PharmacySetupEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Pharmacy Setup entity with no references set.
	 */
	@Provides
	@Named("pharmacySetupEntityWithNoRef")
	public PharmacySetupEntity pharmacySetupEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pharmacySetupEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pharmacySetupEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PharmacySetupEntity with no reference");

		// % protected region % [Apply any additional logic for pharmacySetupWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupWithNoRef before the main body here] end

		PharmacySetupEntity newEntity = new PharmacySetupEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Hospital Pharmacy here] off begin
		String randomStringforHospitalPharmacy = mock
				.strings()
				.get();
		newEntity.setHospitalPharmacy(randomStringforHospitalPharmacy);
		// % protected region % [Add customisation for Hospital Pharmacy here] end
		// % protected region % [Add customisation for Head of Pharmacy here] off begin
		String randomStringforHeadOfPharmacy = mock
				.strings()
				.get();
		newEntity.setHeadOfPharmacy(randomStringforHeadOfPharmacy);
		// % protected region % [Add customisation for Head of Pharmacy here] end
		// % protected region % [Add customisation for Pharmacist License No here] off begin
		String randomStringforPharmacistLicenseNo = mock
				.strings()
				.get();
		newEntity.setPharmacistLicenseNo(randomStringforPharmacistLicenseNo);
		// % protected region % [Add customisation for Pharmacist License No here] end
		// % protected region % [Add customisation for Label setup here] off begin
		String randomStringforLabelSetup = mock
				.strings()
				.get();
		newEntity.setLabelSetup(randomStringforLabelSetup);
		// % protected region % [Add customisation for Label setup here] end

		// % protected region % [Apply any additional logic for pharmacySetupWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupWithNoRef after the main body here] end

		log.trace("Created entity of type PharmacySetupEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Pharmacy Setup entities with no reference at all.
	 */
	@Provides
	@Named("pharmacySetupEntitiesWithNoRef")
	public Collection<PharmacySetupEntity> pharmacySetupEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pharmacySetupEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pharmacySetupEntitiesWithNoRef here] end
		PharmacySetupEntityFactory pharmacySetupEntityFactory
	) {
		log.trace("Creating entities of type PharmacySetupEntity with no reference");

		// % protected region % [Apply any additional logic for pharmacySetupEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupEntitiesWithNoRef before the main body here] end

		Collection<PharmacySetupEntity> newEntities = pharmacySetupEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pharmacySetupEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PharmacySetupEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Pharmacy Setup entity with all references set.
	 */
	@Provides
	@Named("pharmacySetupEntityWithRefs")
	public PharmacySetupEntity pharmacySetupEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pharmacySetupEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pharmacySetupEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PharmacySetupEntity with references");

		// % protected region % [Apply any additional logic for pharmacySetupEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupEntityWithRefs before the main body here] end

		PharmacySetupEntity pharmacySetupEntity = injector.getInstance(Key.get(PharmacySetupEntity.class, Names.named("pharmacySetupEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pharmacySetupEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupEntityWithRefs after the main body here] end

		log.trace("Created entity of type PharmacySetupEntity with references");

		return pharmacySetupEntity;
	}

	/**
	 * Return a collection of Pharmacy Setup entities with all references set.
	 */
	@Provides
	@Named("pharmacySetupEntitiesWithRefs")
	public Collection<PharmacySetupEntity> pharmacySetupEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pharmacySetupEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pharmacySetupEntitiesWithRefs here] end
		PharmacySetupEntityFactory pharmacySetupEntityFactory
	) {
		log.trace("Creating entities of type PharmacySetupEntity with references");

		// % protected region % [Apply any additional logic for pharmacySetupEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupEntitiesWithRefs before the main body here] end

		Collection<PharmacySetupEntity> newEntities = pharmacySetupEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pharmacySetupEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pharmacySetupEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PharmacySetupEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
