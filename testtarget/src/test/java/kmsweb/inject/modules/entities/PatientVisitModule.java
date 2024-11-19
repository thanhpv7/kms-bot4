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
 * Guice module for Patient Visit used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientVisitModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientVisitModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientVisitModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientVisitEntityFactory patientVisitEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientVisitEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientVisitEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientVisitEntityFactory");

		// % protected region % [Apply any additional logic for patientVisitEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitEntityFactory before the main body here] end

		PatientVisitEntityFactory entityFactory = new PatientVisitEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientVisitEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientVisitEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientVisitEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitEntityFactory after the main body here] end

		log.trace("Created PatientVisitEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Visit entity with no references set.
	 */
	@Provides
	@Named("patientVisitEntityWithNoRef")
	public PatientVisitEntity patientVisitEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientVisitEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVisitEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientVisitEntity with no reference");

		// % protected region % [Apply any additional logic for patientVisitWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitWithNoRef before the main body here] end

		PatientVisitEntity newEntity = new PatientVisitEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Visit Number here] off begin
		String randomStringforVisitNumber = mock
				.strings()
				.get();
		newEntity.setVisitNumber(randomStringforVisitNumber);
		// % protected region % [Add customisation for Visit Number here] end
		// % protected region % [Add customisation for Registration Type here] off begin
		String randomStringforRegistrationType = mock
				.strings()
				.get();
		newEntity.setRegistrationType(randomStringforRegistrationType);
		// % protected region % [Add customisation for Registration Type here] end
		// % protected region % [Add customisation for Visit Date here] off begin
		newEntity.setVisitDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Visit Date here] end
		// % protected region % [Add customisation for Registration Location here] off begin
		String randomStringforRegistrationLocation = mock
				.strings()
				.get();
		newEntity.setRegistrationLocation(randomStringforRegistrationLocation);
		// % protected region % [Add customisation for Registration Location here] end
		// % protected region % [Add customisation for Patient Payment Type here] off begin
		String randomStringforPatientPaymentType = mock
				.strings()
				.get();
		newEntity.setPatientPaymentType(randomStringforPatientPaymentType);
		// % protected region % [Add customisation for Patient Payment Type here] end
		// % protected region % [Add customisation for Visit Type here] off begin
		String randomStringforVisitType = mock
				.strings()
				.get();
		newEntity.setVisitType(randomStringforVisitType);
		// % protected region % [Add customisation for Visit Type here] end

		// % protected region % [Apply any additional logic for patientVisitWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitWithNoRef after the main body here] end

		log.trace("Created entity of type PatientVisitEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Visit entities with no reference at all.
	 */
	@Provides
	@Named("patientVisitEntitiesWithNoRef")
	public Collection<PatientVisitEntity> patientVisitEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientVisitEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVisitEntitiesWithNoRef here] end
		PatientVisitEntityFactory patientVisitEntityFactory
	) {
		log.trace("Creating entities of type PatientVisitEntity with no reference");

		// % protected region % [Apply any additional logic for patientVisitEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitEntitiesWithNoRef before the main body here] end

		Collection<PatientVisitEntity> newEntities = patientVisitEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientVisitEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientVisitEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Visit entity with all references set.
	 */
	@Provides
	@Named("patientVisitEntityWithRefs")
	public PatientVisitEntity patientVisitEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientVisitEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVisitEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientVisitEntity with references");

		// % protected region % [Apply any additional logic for patientVisitEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitEntityWithRefs before the main body here] end

		PatientVisitEntity patientVisitEntity = injector.getInstance(Key.get(PatientVisitEntity.class, Names.named("patientVisitEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientVisitEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientVisitEntity with references");

		return patientVisitEntity;
	}

	/**
	 * Return a collection of Patient Visit entities with all references set.
	 */
	@Provides
	@Named("patientVisitEntitiesWithRefs")
	public Collection<PatientVisitEntity> patientVisitEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientVisitEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVisitEntitiesWithRefs here] end
		PatientVisitEntityFactory patientVisitEntityFactory
	) {
		log.trace("Creating entities of type PatientVisitEntity with references");

		// % protected region % [Apply any additional logic for patientVisitEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitEntitiesWithRefs before the main body here] end

		Collection<PatientVisitEntity> newEntities = patientVisitEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientVisitEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientVisitEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
