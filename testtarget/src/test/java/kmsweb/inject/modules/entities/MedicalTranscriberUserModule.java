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
 * Guice module for Medical Transcriber User used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalTranscriberUserModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalTranscriberUserModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalTranscriberUserModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalTranscriberUserEntityFactory medicalTranscriberUserEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalTranscriberUserEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalTranscriberUserEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalTranscriberUserEntityFactory");

		// % protected region % [Apply any additional logic for medicalTranscriberUserEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserEntityFactory before the main body here] end

		MedicalTranscriberUserEntityFactory entityFactory = new MedicalTranscriberUserEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalTranscriberUserEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalTranscriberUserEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalTranscriberUserEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserEntityFactory after the main body here] end

		log.trace("Created MedicalTranscriberUserEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Transcriber User entity with no references set.
	 */
	@Provides
	@Named("medicalTranscriberUserEntityWithNoRef")
	public MedicalTranscriberUserEntity medicalTranscriberUserEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalTranscriberUserEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalTranscriberUserEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalTranscriberUserEntity with no reference");

		// % protected region % [Apply any additional logic for medicalTranscriberUserWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserWithNoRef before the main body here] end

		MedicalTranscriberUserEntity newEntity = new MedicalTranscriberUserEntity();
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

		// % protected region % [Apply any additional logic for medicalTranscriberUserWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalTranscriberUserEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Transcriber User entities with no reference at all.
	 */
	@Provides
	@Named("medicalTranscriberUserEntitiesWithNoRef")
	public Collection<MedicalTranscriberUserEntity> medicalTranscriberUserEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalTranscriberUserEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalTranscriberUserEntitiesWithNoRef here] end
		MedicalTranscriberUserEntityFactory medicalTranscriberUserEntityFactory
	) {
		log.trace("Creating entities of type MedicalTranscriberUserEntity with no reference");

		// % protected region % [Apply any additional logic for medicalTranscriberUserEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserEntitiesWithNoRef before the main body here] end

		Collection<MedicalTranscriberUserEntity> newEntities = medicalTranscriberUserEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalTranscriberUserEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalTranscriberUserEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Transcriber User entity with all references set.
	 */
	@Provides
	@Named("medicalTranscriberUserEntityWithRefs")
	public MedicalTranscriberUserEntity medicalTranscriberUserEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalTranscriberUserEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalTranscriberUserEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalTranscriberUserEntity with references");

		// % protected region % [Apply any additional logic for medicalTranscriberUserEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserEntityWithRefs before the main body here] end

		MedicalTranscriberUserEntity medicalTranscriberUserEntity = injector.getInstance(Key.get(MedicalTranscriberUserEntity.class, Names.named("medicalTranscriberUserEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalTranscriberUserEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalTranscriberUserEntity with references");

		return medicalTranscriberUserEntity;
	}

	/**
	 * Return a collection of Medical Transcriber User entities with all references set.
	 */
	@Provides
	@Named("medicalTranscriberUserEntitiesWithRefs")
	public Collection<MedicalTranscriberUserEntity> medicalTranscriberUserEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalTranscriberUserEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalTranscriberUserEntitiesWithRefs here] end
		MedicalTranscriberUserEntityFactory medicalTranscriberUserEntityFactory
	) {
		log.trace("Creating entities of type MedicalTranscriberUserEntity with references");

		// % protected region % [Apply any additional logic for medicalTranscriberUserEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserEntitiesWithRefs before the main body here] end

		Collection<MedicalTranscriberUserEntity> newEntities = medicalTranscriberUserEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalTranscriberUserEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalTranscriberUserEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalTranscriberUserEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
