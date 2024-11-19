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
 * Guice module for Administration User used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class AdministrationUserModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring AdministrationUserModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured AdministrationUserModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public AdministrationUserEntityFactory administrationUserEntityFactory(
			// % protected region % [Apply any additional injected arguments for administrationUserEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for administrationUserEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating AdministrationUserEntityFactory");

		// % protected region % [Apply any additional logic for administrationUserEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserEntityFactory before the main body here] end

		AdministrationUserEntityFactory entityFactory = new AdministrationUserEntityFactory(
				// % protected region % [Apply any additional constructor arguments for AdministrationUserEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for AdministrationUserEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for administrationUserEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserEntityFactory after the main body here] end

		log.trace("Created AdministrationUserEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Administration User entity with no references set.
	 */
	@Provides
	@Named("administrationUserEntityWithNoRef")
	public AdministrationUserEntity administrationUserEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for administrationUserEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for administrationUserEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type AdministrationUserEntity with no reference");

		// % protected region % [Apply any additional logic for administrationUserWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserWithNoRef before the main body here] end

		AdministrationUserEntity newEntity = new AdministrationUserEntity();
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

		// % protected region % [Apply any additional logic for administrationUserWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserWithNoRef after the main body here] end

		log.trace("Created entity of type AdministrationUserEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Administration User entities with no reference at all.
	 */
	@Provides
	@Named("administrationUserEntitiesWithNoRef")
	public Collection<AdministrationUserEntity> administrationUserEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for administrationUserEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for administrationUserEntitiesWithNoRef here] end
		AdministrationUserEntityFactory administrationUserEntityFactory
	) {
		log.trace("Creating entities of type AdministrationUserEntity with no reference");

		// % protected region % [Apply any additional logic for administrationUserEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserEntitiesWithNoRef before the main body here] end

		Collection<AdministrationUserEntity> newEntities = administrationUserEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for administrationUserEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type AdministrationUserEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Administration User entity with all references set.
	 */
	@Provides
	@Named("administrationUserEntityWithRefs")
	public AdministrationUserEntity administrationUserEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for administrationUserEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for administrationUserEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type AdministrationUserEntity with references");

		// % protected region % [Apply any additional logic for administrationUserEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserEntityWithRefs before the main body here] end

		AdministrationUserEntity administrationUserEntity = injector.getInstance(Key.get(AdministrationUserEntity.class, Names.named("administrationUserEntityWithNoRef")));

		// % protected region % [Apply any additional logic for administrationUserEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserEntityWithRefs after the main body here] end

		log.trace("Created entity of type AdministrationUserEntity with references");

		return administrationUserEntity;
	}

	/**
	 * Return a collection of Administration User entities with all references set.
	 */
	@Provides
	@Named("administrationUserEntitiesWithRefs")
	public Collection<AdministrationUserEntity> administrationUserEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for administrationUserEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for administrationUserEntitiesWithRefs here] end
		AdministrationUserEntityFactory administrationUserEntityFactory
	) {
		log.trace("Creating entities of type AdministrationUserEntity with references");

		// % protected region % [Apply any additional logic for administrationUserEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserEntitiesWithRefs before the main body here] end

		Collection<AdministrationUserEntity> newEntities = administrationUserEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for administrationUserEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for administrationUserEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type AdministrationUserEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
