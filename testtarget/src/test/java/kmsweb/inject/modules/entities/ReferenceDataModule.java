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
 * Guice module for Reference Data used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ReferenceDataModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ReferenceDataModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ReferenceDataModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ReferenceDataEntityFactory referenceDataEntityFactory(
			// % protected region % [Apply any additional injected arguments for referenceDataEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for referenceDataEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ReferenceDataEntityFactory");

		// % protected region % [Apply any additional logic for referenceDataEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataEntityFactory before the main body here] end

		ReferenceDataEntityFactory entityFactory = new ReferenceDataEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ReferenceDataEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ReferenceDataEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for referenceDataEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataEntityFactory after the main body here] end

		log.trace("Created ReferenceDataEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Reference Data entity with no references set.
	 */
	@Provides
	@Named("referenceDataEntityWithNoRef")
	public ReferenceDataEntity referenceDataEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for referenceDataEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for referenceDataEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ReferenceDataEntity with no reference");

		// % protected region % [Apply any additional logic for referenceDataWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataWithNoRef before the main body here] end

		ReferenceDataEntity newEntity = new ReferenceDataEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Reference Type here] off begin
		String randomStringforReferenceType = mock
				.strings()
				.get();
		newEntity.setReferenceType(randomStringforReferenceType);
		// % protected region % [Add customisation for Reference Type here] end
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
		// % protected region % [Add customisation for Associated Values here] off begin
		String randomStringforAssociatedValues = mock
				.strings()
				.get();
		newEntity.setAssociatedValues(randomStringforAssociatedValues);
		// % protected region % [Add customisation for Associated Values here] end
		// % protected region % [Add customisation for Sequence here] off begin
		newEntity.setSequence(mock.ints().get());
		// % protected region % [Add customisation for Sequence here] end
		// % protected region % [Add customisation for Filter here] off begin
		String randomStringforFilter = mock
				.strings()
				.get();
		newEntity.setFilter(randomStringforFilter);
		// % protected region % [Add customisation for Filter here] end

		// % protected region % [Apply any additional logic for referenceDataWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataWithNoRef after the main body here] end

		log.trace("Created entity of type ReferenceDataEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Reference Data entities with no reference at all.
	 */
	@Provides
	@Named("referenceDataEntitiesWithNoRef")
	public Collection<ReferenceDataEntity> referenceDataEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for referenceDataEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for referenceDataEntitiesWithNoRef here] end
		ReferenceDataEntityFactory referenceDataEntityFactory
	) {
		log.trace("Creating entities of type ReferenceDataEntity with no reference");

		// % protected region % [Apply any additional logic for referenceDataEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataEntitiesWithNoRef before the main body here] end

		Collection<ReferenceDataEntity> newEntities = referenceDataEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for referenceDataEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ReferenceDataEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Reference Data entity with all references set.
	 */
	@Provides
	@Named("referenceDataEntityWithRefs")
	public ReferenceDataEntity referenceDataEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for referenceDataEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for referenceDataEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ReferenceDataEntity with references");

		// % protected region % [Apply any additional logic for referenceDataEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataEntityWithRefs before the main body here] end

		ReferenceDataEntity referenceDataEntity = injector.getInstance(Key.get(ReferenceDataEntity.class, Names.named("referenceDataEntityWithNoRef")));

		// % protected region % [Apply any additional logic for referenceDataEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataEntityWithRefs after the main body here] end

		log.trace("Created entity of type ReferenceDataEntity with references");

		return referenceDataEntity;
	}

	/**
	 * Return a collection of Reference Data entities with all references set.
	 */
	@Provides
	@Named("referenceDataEntitiesWithRefs")
	public Collection<ReferenceDataEntity> referenceDataEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for referenceDataEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for referenceDataEntitiesWithRefs here] end
		ReferenceDataEntityFactory referenceDataEntityFactory
	) {
		log.trace("Creating entities of type ReferenceDataEntity with references");

		// % protected region % [Apply any additional logic for referenceDataEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataEntitiesWithRefs before the main body here] end

		Collection<ReferenceDataEntity> newEntities = referenceDataEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for referenceDataEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for referenceDataEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ReferenceDataEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
