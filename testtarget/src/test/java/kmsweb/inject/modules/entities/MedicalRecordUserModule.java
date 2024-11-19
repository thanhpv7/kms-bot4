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
 * Guice module for Medical Record user used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalRecordUserModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalRecordUserModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalRecordUserModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalRecordUserEntityFactory medicalRecordUserEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalRecordUserEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalRecordUserEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalRecordUserEntityFactory");

		// % protected region % [Apply any additional logic for medicalRecordUserEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserEntityFactory before the main body here] end

		MedicalRecordUserEntityFactory entityFactory = new MedicalRecordUserEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalRecordUserEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalRecordUserEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalRecordUserEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserEntityFactory after the main body here] end

		log.trace("Created MedicalRecordUserEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Record user entity with no references set.
	 */
	@Provides
	@Named("medicalRecordUserEntityWithNoRef")
	public MedicalRecordUserEntity medicalRecordUserEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalRecordUserEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalRecordUserEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalRecordUserEntity with no reference");

		// % protected region % [Apply any additional logic for medicalRecordUserWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserWithNoRef before the main body here] end

		MedicalRecordUserEntity newEntity = new MedicalRecordUserEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Name here] off begin
		String randomStringforName = mock
				.strings()
				.get();
		newEntity.setName(randomStringforName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Username here] off begin
		String randomStringforUsername = mock
				.emails()
				.get();
		newEntity.setUsername(randomStringforUsername);
		// % protected region % [Add customisation for Username here] end
		// % protected region % [Add customisation for Password here] off begin
		String randomStringforPassword = mock
				.strings()
				.size(255)
				.get();
		newEntity.setPassword(randomStringforPassword);
		// % protected region % [Add customisation for Password here] end
		// % protected region % [Add customisation for Email Confirmed confirmed here] off begin
		newEntity.setEmailConfirmedConfirmed(mock.bools().get());
		// % protected region % [Add customisation for Email Confirmed confirmed here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.strings()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Is Archived here] off begin
		newEntity.setIsArchived(mock.bools().get());
		// % protected region % [Add customisation for Is Archived here] end

		// % protected region % [Apply any additional logic for medicalRecordUserWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalRecordUserEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Record user entities with no reference at all.
	 */
	@Provides
	@Named("medicalRecordUserEntitiesWithNoRef")
	public Collection<MedicalRecordUserEntity> medicalRecordUserEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalRecordUserEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalRecordUserEntitiesWithNoRef here] end
		MedicalRecordUserEntityFactory medicalRecordUserEntityFactory
	) {
		log.trace("Creating entities of type MedicalRecordUserEntity with no reference");

		// % protected region % [Apply any additional logic for medicalRecordUserEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserEntitiesWithNoRef before the main body here] end

		Collection<MedicalRecordUserEntity> newEntities = medicalRecordUserEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalRecordUserEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalRecordUserEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Record user entity with all references set.
	 */
	@Provides
	@Named("medicalRecordUserEntityWithRefs")
	public MedicalRecordUserEntity medicalRecordUserEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalRecordUserEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalRecordUserEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalRecordUserEntity with references");

		// % protected region % [Apply any additional logic for medicalRecordUserEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserEntityWithRefs before the main body here] end

		MedicalRecordUserEntity medicalRecordUserEntity = injector.getInstance(Key.get(MedicalRecordUserEntity.class, Names.named("medicalRecordUserEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalRecordUserEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalRecordUserEntity with references");

		return medicalRecordUserEntity;
	}

	/**
	 * Return a collection of Medical Record user entities with all references set.
	 */
	@Provides
	@Named("medicalRecordUserEntitiesWithRefs")
	public Collection<MedicalRecordUserEntity> medicalRecordUserEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalRecordUserEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalRecordUserEntitiesWithRefs here] end
		MedicalRecordUserEntityFactory medicalRecordUserEntityFactory
	) {
		log.trace("Creating entities of type MedicalRecordUserEntity with references");

		// % protected region % [Apply any additional logic for medicalRecordUserEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserEntitiesWithRefs before the main body here] end

		Collection<MedicalRecordUserEntity> newEntities = medicalRecordUserEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalRecordUserEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordUserEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalRecordUserEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
