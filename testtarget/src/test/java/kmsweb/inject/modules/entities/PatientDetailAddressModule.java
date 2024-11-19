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
 * Guice module for Patient Detail Address used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientDetailAddressModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientDetailAddressModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientDetailAddressModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientDetailAddressEntityFactory patientDetailAddressEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientDetailAddressEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientDetailAddressEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientDetailAddressEntityFactory");

		// % protected region % [Apply any additional logic for patientDetailAddressEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressEntityFactory before the main body here] end

		PatientDetailAddressEntityFactory entityFactory = new PatientDetailAddressEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientDetailAddressEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientDetailAddressEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientDetailAddressEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressEntityFactory after the main body here] end

		log.trace("Created PatientDetailAddressEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Detail Address entity with no references set.
	 */
	@Provides
	@Named("patientDetailAddressEntityWithNoRef")
	public PatientDetailAddressEntity patientDetailAddressEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientDetailAddressEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientDetailAddressEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientDetailAddressEntity with no reference");

		// % protected region % [Apply any additional logic for patientDetailAddressWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressWithNoRef before the main body here] end

		PatientDetailAddressEntity newEntity = new PatientDetailAddressEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Country here] off begin
		String randomStringforCountry = mock
				.strings()
				.get();
		newEntity.setCountry(randomStringforCountry);
		// % protected region % [Add customisation for Country here] end
		// % protected region % [Add customisation for State here] off begin
		String randomStringforState = mock
				.strings()
				.get();
		newEntity.setState(randomStringforState);
		// % protected region % [Add customisation for State here] end
		// % protected region % [Add customisation for Regency here] off begin
		String randomStringforRegency = mock
				.strings()
				.get();
		newEntity.setRegency(randomStringforRegency);
		// % protected region % [Add customisation for Regency here] end
		// % protected region % [Add customisation for District here] off begin
		String randomStringforDistrict = mock
				.strings()
				.get();
		newEntity.setDistrict(randomStringforDistrict);
		// % protected region % [Add customisation for District here] end
		// % protected region % [Add customisation for Village here] off begin
		String randomStringforVillage = mock
				.strings()
				.get();
		newEntity.setVillage(randomStringforVillage);
		// % protected region % [Add customisation for Village here] end
		// % protected region % [Add customisation for Post Code here] off begin
		String randomStringforPostCode = mock
				.strings()
				.get();
		newEntity.setPostCode(randomStringforPostCode);
		// % protected region % [Add customisation for Post Code here] end
		// % protected region % [Add customisation for RT here] off begin
		String randomStringforRt = mock
				.strings()
				.get();
		newEntity.setRt(randomStringforRt);
		// % protected region % [Add customisation for RT here] end
		// % protected region % [Add customisation for RW here] off begin
		String randomStringforRw = mock
				.strings()
				.get();
		newEntity.setRw(randomStringforRw);
		// % protected region % [Add customisation for RW here] end

		// % protected region % [Apply any additional logic for patientDetailAddressWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressWithNoRef after the main body here] end

		log.trace("Created entity of type PatientDetailAddressEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Detail Address entities with no reference at all.
	 */
	@Provides
	@Named("patientDetailAddressEntitiesWithNoRef")
	public Collection<PatientDetailAddressEntity> patientDetailAddressEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientDetailAddressEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientDetailAddressEntitiesWithNoRef here] end
		PatientDetailAddressEntityFactory patientDetailAddressEntityFactory
	) {
		log.trace("Creating entities of type PatientDetailAddressEntity with no reference");

		// % protected region % [Apply any additional logic for patientDetailAddressEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressEntitiesWithNoRef before the main body here] end

		Collection<PatientDetailAddressEntity> newEntities = patientDetailAddressEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientDetailAddressEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientDetailAddressEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Detail Address entity with all references set.
	 */
	@Provides
	@Named("patientDetailAddressEntityWithRefs")
	public PatientDetailAddressEntity patientDetailAddressEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientDetailAddressEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientDetailAddressEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientDetailAddressEntity with references");

		// % protected region % [Apply any additional logic for patientDetailAddressEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressEntityWithRefs before the main body here] end

		PatientDetailAddressEntity patientDetailAddressEntity = injector.getInstance(Key.get(PatientDetailAddressEntity.class, Names.named("patientDetailAddressEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientDetailAddressEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientDetailAddressEntity with references");

		return patientDetailAddressEntity;
	}

	/**
	 * Return a collection of Patient Detail Address entities with all references set.
	 */
	@Provides
	@Named("patientDetailAddressEntitiesWithRefs")
	public Collection<PatientDetailAddressEntity> patientDetailAddressEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientDetailAddressEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientDetailAddressEntitiesWithRefs here] end
		PatientDetailAddressEntityFactory patientDetailAddressEntityFactory
	) {
		log.trace("Creating entities of type PatientDetailAddressEntity with references");

		// % protected region % [Apply any additional logic for patientDetailAddressEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressEntitiesWithRefs before the main body here] end

		Collection<PatientDetailAddressEntity> newEntities = patientDetailAddressEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientDetailAddressEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailAddressEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientDetailAddressEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
