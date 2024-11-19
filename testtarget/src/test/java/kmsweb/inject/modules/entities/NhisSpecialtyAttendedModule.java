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
 * Guice module for NHIS Specialty Attended used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NhisSpecialtyAttendedModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NhisSpecialtyAttendedModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NhisSpecialtyAttendedModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NhisSpecialtyAttendedEntityFactory nhisSpecialtyAttendedEntityFactory(
			// % protected region % [Apply any additional injected arguments for nhisSpecialtyAttendedEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nhisSpecialtyAttendedEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NhisSpecialtyAttendedEntityFactory");

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntityFactory before the main body here] end

		NhisSpecialtyAttendedEntityFactory entityFactory = new NhisSpecialtyAttendedEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NhisSpecialtyAttendedEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NhisSpecialtyAttendedEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntityFactory after the main body here] end

		log.trace("Created NhisSpecialtyAttendedEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty NHIS Specialty Attended entity with no references set.
	 */
	@Provides
	@Named("nhisSpecialtyAttendedEntityWithNoRef")
	public NhisSpecialtyAttendedEntity nhisSpecialtyAttendedEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nhisSpecialtyAttendedEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisSpecialtyAttendedEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NhisSpecialtyAttendedEntity with no reference");

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedWithNoRef before the main body here] end

		NhisSpecialtyAttendedEntity newEntity = new NhisSpecialtyAttendedEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Code here] off begin
		String randomStringforCode = mock
				.strings()
				.get();
		newEntity.setCode(randomStringforCode);
		// % protected region % [Add customisation for Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Services here] off begin
		String randomStringforServices = mock
				.strings()
				.get();
		newEntity.setServices(randomStringforServices);
		// % protected region % [Add customisation for Services here] end

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedWithNoRef after the main body here] end

		log.trace("Created entity of type NhisSpecialtyAttendedEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of NHIS Specialty Attended entities with no reference at all.
	 */
	@Provides
	@Named("nhisSpecialtyAttendedEntitiesWithNoRef")
	public Collection<NhisSpecialtyAttendedEntity> nhisSpecialtyAttendedEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nhisSpecialtyAttendedEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisSpecialtyAttendedEntitiesWithNoRef here] end
		NhisSpecialtyAttendedEntityFactory nhisSpecialtyAttendedEntityFactory
	) {
		log.trace("Creating entities of type NhisSpecialtyAttendedEntity with no reference");

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntitiesWithNoRef before the main body here] end

		Collection<NhisSpecialtyAttendedEntity> newEntities = nhisSpecialtyAttendedEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NhisSpecialtyAttendedEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a NHIS Specialty Attended entity with all references set.
	 */
	@Provides
	@Named("nhisSpecialtyAttendedEntityWithRefs")
	public NhisSpecialtyAttendedEntity nhisSpecialtyAttendedEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nhisSpecialtyAttendedEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisSpecialtyAttendedEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NhisSpecialtyAttendedEntity with references");

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntityWithRefs before the main body here] end

		NhisSpecialtyAttendedEntity nhisSpecialtyAttendedEntity = injector.getInstance(Key.get(NhisSpecialtyAttendedEntity.class, Names.named("nhisSpecialtyAttendedEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntityWithRefs after the main body here] end

		log.trace("Created entity of type NhisSpecialtyAttendedEntity with references");

		return nhisSpecialtyAttendedEntity;
	}

	/**
	 * Return a collection of NHIS Specialty Attended entities with all references set.
	 */
	@Provides
	@Named("nhisSpecialtyAttendedEntitiesWithRefs")
	public Collection<NhisSpecialtyAttendedEntity> nhisSpecialtyAttendedEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nhisSpecialtyAttendedEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisSpecialtyAttendedEntitiesWithRefs here] end
		NhisSpecialtyAttendedEntityFactory nhisSpecialtyAttendedEntityFactory
	) {
		log.trace("Creating entities of type NhisSpecialtyAttendedEntity with references");

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntitiesWithRefs before the main body here] end

		Collection<NhisSpecialtyAttendedEntity> newEntities = nhisSpecialtyAttendedEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisSpecialtyAttendedEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NhisSpecialtyAttendedEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
