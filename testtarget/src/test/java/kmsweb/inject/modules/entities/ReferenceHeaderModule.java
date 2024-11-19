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
 * Guice module for Reference Header used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ReferenceHeaderModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ReferenceHeaderModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ReferenceHeaderModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ReferenceHeaderEntityFactory referenceHeaderEntityFactory(
			// % protected region % [Apply any additional injected arguments for referenceHeaderEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for referenceHeaderEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ReferenceHeaderEntityFactory");

		// % protected region % [Apply any additional logic for referenceHeaderEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderEntityFactory before the main body here] end

		ReferenceHeaderEntityFactory entityFactory = new ReferenceHeaderEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ReferenceHeaderEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ReferenceHeaderEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for referenceHeaderEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderEntityFactory after the main body here] end

		log.trace("Created ReferenceHeaderEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Reference Header entity with no references set.
	 */
	@Provides
	@Named("referenceHeaderEntityWithNoRef")
	public ReferenceHeaderEntity referenceHeaderEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for referenceHeaderEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for referenceHeaderEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ReferenceHeaderEntity with no reference");

		// % protected region % [Apply any additional logic for referenceHeaderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderWithNoRef before the main body here] end

		ReferenceHeaderEntity newEntity = new ReferenceHeaderEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Reference Type here] off begin
		String randomStringforReferenceType = mock
				.strings()
				.get();
		newEntity.setReferenceType(randomStringforReferenceType);
		// % protected region % [Add customisation for Reference Type here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end

		// % protected region % [Apply any additional logic for referenceHeaderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderWithNoRef after the main body here] end

		log.trace("Created entity of type ReferenceHeaderEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Reference Header entities with no reference at all.
	 */
	@Provides
	@Named("referenceHeaderEntitiesWithNoRef")
	public Collection<ReferenceHeaderEntity> referenceHeaderEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for referenceHeaderEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for referenceHeaderEntitiesWithNoRef here] end
		ReferenceHeaderEntityFactory referenceHeaderEntityFactory
	) {
		log.trace("Creating entities of type ReferenceHeaderEntity with no reference");

		// % protected region % [Apply any additional logic for referenceHeaderEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderEntitiesWithNoRef before the main body here] end

		Collection<ReferenceHeaderEntity> newEntities = referenceHeaderEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for referenceHeaderEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ReferenceHeaderEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Reference Header entity with all references set.
	 */
	@Provides
	@Named("referenceHeaderEntityWithRefs")
	public ReferenceHeaderEntity referenceHeaderEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for referenceHeaderEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for referenceHeaderEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ReferenceHeaderEntity with references");

		// % protected region % [Apply any additional logic for referenceHeaderEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderEntityWithRefs before the main body here] end

		ReferenceHeaderEntity referenceHeaderEntity = injector.getInstance(Key.get(ReferenceHeaderEntity.class, Names.named("referenceHeaderEntityWithNoRef")));

		// % protected region % [Apply any additional logic for referenceHeaderEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderEntityWithRefs after the main body here] end

		log.trace("Created entity of type ReferenceHeaderEntity with references");

		return referenceHeaderEntity;
	}

	/**
	 * Return a collection of Reference Header entities with all references set.
	 */
	@Provides
	@Named("referenceHeaderEntitiesWithRefs")
	public Collection<ReferenceHeaderEntity> referenceHeaderEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for referenceHeaderEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for referenceHeaderEntitiesWithRefs here] end
		ReferenceHeaderEntityFactory referenceHeaderEntityFactory
	) {
		log.trace("Creating entities of type ReferenceHeaderEntity with references");

		// % protected region % [Apply any additional logic for referenceHeaderEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderEntitiesWithRefs before the main body here] end

		Collection<ReferenceHeaderEntity> newEntities = referenceHeaderEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for referenceHeaderEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceHeaderEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ReferenceHeaderEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
