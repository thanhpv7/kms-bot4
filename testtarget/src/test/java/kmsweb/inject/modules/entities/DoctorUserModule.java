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
 * Guice module for Doctor User used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DoctorUserModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DoctorUserModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DoctorUserModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DoctorUserEntityFactory doctorUserEntityFactory(
			// % protected region % [Apply any additional injected arguments for doctorUserEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for doctorUserEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DoctorUserEntityFactory");

		// % protected region % [Apply any additional logic for doctorUserEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserEntityFactory before the main body here] end

		DoctorUserEntityFactory entityFactory = new DoctorUserEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DoctorUserEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DoctorUserEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for doctorUserEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserEntityFactory after the main body here] end

		log.trace("Created DoctorUserEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Doctor User entity with no references set.
	 */
	@Provides
	@Named("doctorUserEntityWithNoRef")
	public DoctorUserEntity doctorUserEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for doctorUserEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for doctorUserEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DoctorUserEntity with no reference");

		// % protected region % [Apply any additional logic for doctorUserWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserWithNoRef before the main body here] end

		DoctorUserEntity newEntity = new DoctorUserEntity();
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

		// % protected region % [Apply any additional logic for doctorUserWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserWithNoRef after the main body here] end

		log.trace("Created entity of type DoctorUserEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Doctor User entities with no reference at all.
	 */
	@Provides
	@Named("doctorUserEntitiesWithNoRef")
	public Collection<DoctorUserEntity> doctorUserEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for doctorUserEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for doctorUserEntitiesWithNoRef here] end
		DoctorUserEntityFactory doctorUserEntityFactory
	) {
		log.trace("Creating entities of type DoctorUserEntity with no reference");

		// % protected region % [Apply any additional logic for doctorUserEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserEntitiesWithNoRef before the main body here] end

		Collection<DoctorUserEntity> newEntities = doctorUserEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for doctorUserEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DoctorUserEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Doctor User entity with all references set.
	 */
	@Provides
	@Named("doctorUserEntityWithRefs")
	public DoctorUserEntity doctorUserEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for doctorUserEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for doctorUserEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DoctorUserEntity with references");

		// % protected region % [Apply any additional logic for doctorUserEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserEntityWithRefs before the main body here] end

		DoctorUserEntity doctorUserEntity = injector.getInstance(Key.get(DoctorUserEntity.class, Names.named("doctorUserEntityWithNoRef")));

		// % protected region % [Apply any additional logic for doctorUserEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserEntityWithRefs after the main body here] end

		log.trace("Created entity of type DoctorUserEntity with references");

		return doctorUserEntity;
	}

	/**
	 * Return a collection of Doctor User entities with all references set.
	 */
	@Provides
	@Named("doctorUserEntitiesWithRefs")
	public Collection<DoctorUserEntity> doctorUserEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for doctorUserEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for doctorUserEntitiesWithRefs here] end
		DoctorUserEntityFactory doctorUserEntityFactory
	) {
		log.trace("Creating entities of type DoctorUserEntity with references");

		// % protected region % [Apply any additional logic for doctorUserEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserEntitiesWithRefs before the main body here] end

		Collection<DoctorUserEntity> newEntities = doctorUserEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for doctorUserEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorUserEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DoctorUserEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
