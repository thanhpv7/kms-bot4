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
 * Guice module for Compound Prescription Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class CompoundPrescriptionItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring CompoundPrescriptionItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured CompoundPrescriptionItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public CompoundPrescriptionItemEntityFactory compoundPrescriptionItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for compoundPrescriptionItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for compoundPrescriptionItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating CompoundPrescriptionItemEntityFactory");

		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntityFactory before the main body here] end

		CompoundPrescriptionItemEntityFactory entityFactory = new CompoundPrescriptionItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for CompoundPrescriptionItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for CompoundPrescriptionItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntityFactory after the main body here] end

		log.trace("Created CompoundPrescriptionItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Compound Prescription Item entity with no references set.
	 */
	@Provides
	@Named("compoundPrescriptionItemEntityWithNoRef")
	public CompoundPrescriptionItemEntity compoundPrescriptionItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for compoundPrescriptionItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for compoundPrescriptionItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type CompoundPrescriptionItemEntity with no reference");

		// % protected region % [Apply any additional logic for compoundPrescriptionItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemWithNoRef before the main body here] end

		CompoundPrescriptionItemEntity newEntity = new CompoundPrescriptionItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Dose here] off begin
		newEntity.setDose(mock.ints().get());
		// % protected region % [Add customisation for Dose here] end
		// % protected region % [Add customisation for Requested Quantity here] off begin
		newEntity.setRequestedQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Requested Quantity here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for compoundPrescriptionItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemWithNoRef after the main body here] end

		log.trace("Created entity of type CompoundPrescriptionItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Compound Prescription Item entities with no reference at all.
	 */
	@Provides
	@Named("compoundPrescriptionItemEntitiesWithNoRef")
	public Collection<CompoundPrescriptionItemEntity> compoundPrescriptionItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for compoundPrescriptionItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for compoundPrescriptionItemEntitiesWithNoRef here] end
		CompoundPrescriptionItemEntityFactory compoundPrescriptionItemEntityFactory
	) {
		log.trace("Creating entities of type CompoundPrescriptionItemEntity with no reference");

		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntitiesWithNoRef before the main body here] end

		Collection<CompoundPrescriptionItemEntity> newEntities = compoundPrescriptionItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type CompoundPrescriptionItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Compound Prescription Item entity with all references set.
	 */
	@Provides
	@Named("compoundPrescriptionItemEntityWithRefs")
	public CompoundPrescriptionItemEntity compoundPrescriptionItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for compoundPrescriptionItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for compoundPrescriptionItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type CompoundPrescriptionItemEntity with references");

		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntityWithRefs before the main body here] end

		CompoundPrescriptionItemEntity compoundPrescriptionItemEntity = injector.getInstance(Key.get(CompoundPrescriptionItemEntity.class, Names.named("compoundPrescriptionItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type CompoundPrescriptionItemEntity with references");

		return compoundPrescriptionItemEntity;
	}

	/**
	 * Return a collection of Compound Prescription Item entities with all references set.
	 */
	@Provides
	@Named("compoundPrescriptionItemEntitiesWithRefs")
	public Collection<CompoundPrescriptionItemEntity> compoundPrescriptionItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for compoundPrescriptionItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for compoundPrescriptionItemEntitiesWithRefs here] end
		CompoundPrescriptionItemEntityFactory compoundPrescriptionItemEntityFactory
	) {
		log.trace("Creating entities of type CompoundPrescriptionItemEntity with references");

		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntitiesWithRefs before the main body here] end

		Collection<CompoundPrescriptionItemEntity> newEntities = compoundPrescriptionItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type CompoundPrescriptionItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
