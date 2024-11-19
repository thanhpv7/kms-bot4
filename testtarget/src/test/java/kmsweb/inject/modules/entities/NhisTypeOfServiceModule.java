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
 * Guice module for NHIS Type Of Service used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NhisTypeOfServiceModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NhisTypeOfServiceModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NhisTypeOfServiceModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NhisTypeOfServiceEntityFactory nhisTypeOfServiceEntityFactory(
			// % protected region % [Apply any additional injected arguments for nhisTypeOfServiceEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nhisTypeOfServiceEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NhisTypeOfServiceEntityFactory");

		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntityFactory before the main body here] end

		NhisTypeOfServiceEntityFactory entityFactory = new NhisTypeOfServiceEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NhisTypeOfServiceEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NhisTypeOfServiceEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntityFactory after the main body here] end

		log.trace("Created NhisTypeOfServiceEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty NHIS Type Of Service entity with no references set.
	 */
	@Provides
	@Named("nhisTypeOfServiceEntityWithNoRef")
	public NhisTypeOfServiceEntity nhisTypeOfServiceEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nhisTypeOfServiceEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisTypeOfServiceEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NhisTypeOfServiceEntity with no reference");

		// % protected region % [Apply any additional logic for nhisTypeOfServiceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceWithNoRef before the main body here] end

		NhisTypeOfServiceEntity newEntity = new NhisTypeOfServiceEntity();
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
		// % protected region % [Add customisation for Sections here] off begin
		String randomStringforSections = mock
				.strings()
				.get();
		newEntity.setSections(randomStringforSections);
		// % protected region % [Add customisation for Sections here] end

		// % protected region % [Apply any additional logic for nhisTypeOfServiceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceWithNoRef after the main body here] end

		log.trace("Created entity of type NhisTypeOfServiceEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of NHIS Type Of Service entities with no reference at all.
	 */
	@Provides
	@Named("nhisTypeOfServiceEntitiesWithNoRef")
	public Collection<NhisTypeOfServiceEntity> nhisTypeOfServiceEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nhisTypeOfServiceEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisTypeOfServiceEntitiesWithNoRef here] end
		NhisTypeOfServiceEntityFactory nhisTypeOfServiceEntityFactory
	) {
		log.trace("Creating entities of type NhisTypeOfServiceEntity with no reference");

		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntitiesWithNoRef before the main body here] end

		Collection<NhisTypeOfServiceEntity> newEntities = nhisTypeOfServiceEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NhisTypeOfServiceEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a NHIS Type Of Service entity with all references set.
	 */
	@Provides
	@Named("nhisTypeOfServiceEntityWithRefs")
	public NhisTypeOfServiceEntity nhisTypeOfServiceEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nhisTypeOfServiceEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisTypeOfServiceEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NhisTypeOfServiceEntity with references");

		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntityWithRefs before the main body here] end

		NhisTypeOfServiceEntity nhisTypeOfServiceEntity = injector.getInstance(Key.get(NhisTypeOfServiceEntity.class, Names.named("nhisTypeOfServiceEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntityWithRefs after the main body here] end

		log.trace("Created entity of type NhisTypeOfServiceEntity with references");

		return nhisTypeOfServiceEntity;
	}

	/**
	 * Return a collection of NHIS Type Of Service entities with all references set.
	 */
	@Provides
	@Named("nhisTypeOfServiceEntitiesWithRefs")
	public Collection<NhisTypeOfServiceEntity> nhisTypeOfServiceEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nhisTypeOfServiceEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisTypeOfServiceEntitiesWithRefs here] end
		NhisTypeOfServiceEntityFactory nhisTypeOfServiceEntityFactory
	) {
		log.trace("Creating entities of type NhisTypeOfServiceEntity with references");

		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntitiesWithRefs before the main body here] end

		Collection<NhisTypeOfServiceEntity> newEntities = nhisTypeOfServiceEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisTypeOfServiceEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NhisTypeOfServiceEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
