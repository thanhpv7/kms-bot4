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
 * Guice module for Administrator used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class AdministratorModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring AdministratorModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured AdministratorModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public AdministratorEntityFactory administratorEntityFactory(
			// % protected region % [Apply any additional injected arguments for administratorEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for administratorEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating AdministratorEntityFactory");

		// % protected region % [Apply any additional logic for administratorEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for administratorEntityFactory before the main body here] end

		AdministratorEntityFactory entityFactory = new AdministratorEntityFactory(
				// % protected region % [Apply any additional constructor arguments for AdministratorEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for AdministratorEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for administratorEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for administratorEntityFactory after the main body here] end

		log.trace("Created AdministratorEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Administrator entity with no references set.
	 */
	@Provides
	@Named("administratorEntityWithNoRef")
	public AdministratorEntity administratorEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for administratorEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for administratorEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type AdministratorEntity with no reference");

		// % protected region % [Apply any additional logic for administratorWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for administratorWithNoRef before the main body here] end

		AdministratorEntity newEntity = new AdministratorEntity();
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

		// % protected region % [Apply any additional logic for administratorWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for administratorWithNoRef after the main body here] end

		log.trace("Created entity of type AdministratorEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Administrator entities with no reference at all.
	 */
	@Provides
	@Named("administratorEntitiesWithNoRef")
	public Collection<AdministratorEntity> administratorEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for administratorEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for administratorEntitiesWithNoRef here] end
		AdministratorEntityFactory administratorEntityFactory
	) {
		log.trace("Creating entities of type AdministratorEntity with no reference");

		// % protected region % [Apply any additional logic for administratorEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for administratorEntitiesWithNoRef before the main body here] end

		Collection<AdministratorEntity> newEntities = administratorEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for administratorEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for administratorEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type AdministratorEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Administrator entity with all references set.
	 */
	@Provides
	@Named("administratorEntityWithRefs")
	public AdministratorEntity administratorEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for administratorEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for administratorEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type AdministratorEntity with references");

		// % protected region % [Apply any additional logic for administratorEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for administratorEntityWithRefs before the main body here] end

		AdministratorEntity administratorEntity = injector.getInstance(Key.get(AdministratorEntity.class, Names.named("administratorEntityWithNoRef")));

		// % protected region % [Apply any additional logic for administratorEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for administratorEntityWithRefs after the main body here] end

		log.trace("Created entity of type AdministratorEntity with references");

		return administratorEntity;
	}

	/**
	 * Return a collection of Administrator entities with all references set.
	 */
	@Provides
	@Named("administratorEntitiesWithRefs")
	public Collection<AdministratorEntity> administratorEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for administratorEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for administratorEntitiesWithRefs here] end
		AdministratorEntityFactory administratorEntityFactory
	) {
		log.trace("Creating entities of type AdministratorEntity with references");

		// % protected region % [Apply any additional logic for administratorEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for administratorEntitiesWithRefs before the main body here] end

		Collection<AdministratorEntity> newEntities = administratorEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for administratorEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for administratorEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type AdministratorEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
