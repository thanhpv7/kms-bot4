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
 * Guice module for Patient Emergency Contact Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientEmergencyContactDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientEmergencyContactDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientEmergencyContactDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientEmergencyContactDetailEntityFactory patientEmergencyContactDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientEmergencyContactDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientEmergencyContactDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientEmergencyContactDetailEntityFactory");

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntityFactory before the main body here] end

		PatientEmergencyContactDetailEntityFactory entityFactory = new PatientEmergencyContactDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientEmergencyContactDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientEmergencyContactDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntityFactory after the main body here] end

		log.trace("Created PatientEmergencyContactDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Emergency Contact Detail entity with no references set.
	 */
	@Provides
	@Named("patientEmergencyContactDetailEntityWithNoRef")
	public PatientEmergencyContactDetailEntity patientEmergencyContactDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientEmergencyContactDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientEmergencyContactDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientEmergencyContactDetailEntity with no reference");

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailWithNoRef before the main body here] end

		PatientEmergencyContactDetailEntity newEntity = new PatientEmergencyContactDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Title here] off begin
		String randomStringforTitle = mock
				.strings()
				.get();
		newEntity.setTitle(randomStringforTitle);
		// % protected region % [Add customisation for Title here] end
		// % protected region % [Add customisation for Given Name here] off begin
		String randomStringforGivenName = mock
				.strings()
				.get();
		newEntity.setGivenName(randomStringforGivenName);
		// % protected region % [Add customisation for Given Name here] end
		// % protected region % [Add customisation for Last Name here] off begin
		String randomStringforLastName = mock
				.strings()
				.get();
		newEntity.setLastName(randomStringforLastName);
		// % protected region % [Add customisation for Last Name here] end
		// % protected region % [Add customisation for Relationship here] off begin
		String randomStringforRelationship = mock
				.strings()
				.get();
		newEntity.setRelationship(randomStringforRelationship);
		// % protected region % [Add customisation for Relationship here] end
		// % protected region % [Add customisation for Date Of Birth here] off begin
		newEntity.setDateOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Of Birth here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringforAddress = mock
				.strings()
				.get();
		newEntity.setAddress(randomStringforAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Home Phone No here] off begin
		String randomStringforHomePhoneNo = mock
				.strings()
				.get();
		newEntity.setHomePhoneNo(randomStringforHomePhoneNo);
		// % protected region % [Add customisation for Home Phone No here] end
		// % protected region % [Add customisation for Mobile Phone No here] off begin
		String randomStringforMobilePhoneNo = mock
				.strings()
				.get();
		newEntity.setMobilePhoneNo(randomStringforMobilePhoneNo);
		// % protected region % [Add customisation for Mobile Phone No here] end
		// % protected region % [Add customisation for Office Phone No here] off begin
		String randomStringforOfficePhoneNo = mock
				.strings()
				.get();
		newEntity.setOfficePhoneNo(randomStringforOfficePhoneNo);
		// % protected region % [Add customisation for Office Phone No here] end
		// % protected region % [Add customisation for Extension No here] off begin
		String randomStringforExtensionNo = mock
				.strings()
				.get();
		newEntity.setExtensionNo(randomStringforExtensionNo);
		// % protected region % [Add customisation for Extension No here] end
		// % protected region % [Add customisation for Email Address here] off begin
		String randomStringforEmailAddress = mock
				.strings()
				.get();
		newEntity.setEmailAddress(randomStringforEmailAddress);
		// % protected region % [Add customisation for Email Address here] end
		// % protected region % [Add customisation for ID Card here] off begin
		String randomStringforIdCard = mock
				.strings()
				.get();
		newEntity.setIdCard(randomStringforIdCard);
		// % protected region % [Add customisation for ID Card here] end

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailWithNoRef after the main body here] end

		log.trace("Created entity of type PatientEmergencyContactDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Emergency Contact Detail entities with no reference at all.
	 */
	@Provides
	@Named("patientEmergencyContactDetailEntitiesWithNoRef")
	public Collection<PatientEmergencyContactDetailEntity> patientEmergencyContactDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientEmergencyContactDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientEmergencyContactDetailEntitiesWithNoRef here] end
		PatientEmergencyContactDetailEntityFactory patientEmergencyContactDetailEntityFactory
	) {
		log.trace("Creating entities of type PatientEmergencyContactDetailEntity with no reference");

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntitiesWithNoRef before the main body here] end

		Collection<PatientEmergencyContactDetailEntity> newEntities = patientEmergencyContactDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientEmergencyContactDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Emergency Contact Detail entity with all references set.
	 */
	@Provides
	@Named("patientEmergencyContactDetailEntityWithRefs")
	public PatientEmergencyContactDetailEntity patientEmergencyContactDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientEmergencyContactDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientEmergencyContactDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientEmergencyContactDetailEntity with references");

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntityWithRefs before the main body here] end

		PatientEmergencyContactDetailEntity patientEmergencyContactDetailEntity = injector.getInstance(Key.get(PatientEmergencyContactDetailEntity.class, Names.named("patientEmergencyContactDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientEmergencyContactDetailEntity with references");

		return patientEmergencyContactDetailEntity;
	}

	/**
	 * Return a collection of Patient Emergency Contact Detail entities with all references set.
	 */
	@Provides
	@Named("patientEmergencyContactDetailEntitiesWithRefs")
	public Collection<PatientEmergencyContactDetailEntity> patientEmergencyContactDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientEmergencyContactDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientEmergencyContactDetailEntitiesWithRefs here] end
		PatientEmergencyContactDetailEntityFactory patientEmergencyContactDetailEntityFactory
	) {
		log.trace("Creating entities of type PatientEmergencyContactDetailEntity with references");

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntitiesWithRefs before the main body here] end

		Collection<PatientEmergencyContactDetailEntity> newEntities = patientEmergencyContactDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientEmergencyContactDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientEmergencyContactDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
