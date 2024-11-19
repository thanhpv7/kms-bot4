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
 * Guice module for Patient Contact Info used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientContactInfoModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientContactInfoModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientContactInfoModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientContactInfoEntityFactory patientContactInfoEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientContactInfoEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientContactInfoEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientContactInfoEntityFactory");

		// % protected region % [Apply any additional logic for patientContactInfoEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoEntityFactory before the main body here] end

		PatientContactInfoEntityFactory entityFactory = new PatientContactInfoEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientContactInfoEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientContactInfoEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientContactInfoEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoEntityFactory after the main body here] end

		log.trace("Created PatientContactInfoEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Contact Info entity with no references set.
	 */
	@Provides
	@Named("patientContactInfoEntityWithNoRef")
	public PatientContactInfoEntity patientContactInfoEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientContactInfoEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientContactInfoEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientContactInfoEntity with no reference");

		// % protected region % [Apply any additional logic for patientContactInfoWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoWithNoRef before the main body here] end

		PatientContactInfoEntity newEntity = new PatientContactInfoEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
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
		// % protected region % [Add customisation for Home Phone No here] off begin
		String randomStringforHomePhoneNo = mock
				.strings()
				.get();
		newEntity.setHomePhoneNo(randomStringforHomePhoneNo);
		// % protected region % [Add customisation for Home Phone No here] end

		// % protected region % [Apply any additional logic for patientContactInfoWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoWithNoRef after the main body here] end

		log.trace("Created entity of type PatientContactInfoEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Contact Info entities with no reference at all.
	 */
	@Provides
	@Named("patientContactInfoEntitiesWithNoRef")
	public Collection<PatientContactInfoEntity> patientContactInfoEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientContactInfoEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientContactInfoEntitiesWithNoRef here] end
		PatientContactInfoEntityFactory patientContactInfoEntityFactory
	) {
		log.trace("Creating entities of type PatientContactInfoEntity with no reference");

		// % protected region % [Apply any additional logic for patientContactInfoEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoEntitiesWithNoRef before the main body here] end

		Collection<PatientContactInfoEntity> newEntities = patientContactInfoEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientContactInfoEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientContactInfoEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Contact Info entity with all references set.
	 */
	@Provides
	@Named("patientContactInfoEntityWithRefs")
	public PatientContactInfoEntity patientContactInfoEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientContactInfoEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientContactInfoEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientContactInfoEntity with references");

		// % protected region % [Apply any additional logic for patientContactInfoEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoEntityWithRefs before the main body here] end

		PatientContactInfoEntity patientContactInfoEntity = injector.getInstance(Key.get(PatientContactInfoEntity.class, Names.named("patientContactInfoEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientContactInfoEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientContactInfoEntity with references");

		return patientContactInfoEntity;
	}

	/**
	 * Return a collection of Patient Contact Info entities with all references set.
	 */
	@Provides
	@Named("patientContactInfoEntitiesWithRefs")
	public Collection<PatientContactInfoEntity> patientContactInfoEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientContactInfoEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientContactInfoEntitiesWithRefs here] end
		PatientContactInfoEntityFactory patientContactInfoEntityFactory
	) {
		log.trace("Creating entities of type PatientContactInfoEntity with references");

		// % protected region % [Apply any additional logic for patientContactInfoEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoEntitiesWithRefs before the main body here] end

		Collection<PatientContactInfoEntity> newEntities = patientContactInfoEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientContactInfoEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientContactInfoEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientContactInfoEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
