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
 * Guice module for Medication Administered History used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicationAdministeredHistoryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicationAdministeredHistoryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicationAdministeredHistoryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicationAdministeredHistoryEntityFactory medicationAdministeredHistoryEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicationAdministeredHistoryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicationAdministeredHistoryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicationAdministeredHistoryEntityFactory");

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntityFactory before the main body here] end

		MedicationAdministeredHistoryEntityFactory entityFactory = new MedicationAdministeredHistoryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicationAdministeredHistoryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicationAdministeredHistoryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntityFactory after the main body here] end

		log.trace("Created MedicationAdministeredHistoryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medication Administered History entity with no references set.
	 */
	@Provides
	@Named("medicationAdministeredHistoryEntityWithNoRef")
	public MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicationAdministeredHistoryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicationAdministeredHistoryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicationAdministeredHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryWithNoRef before the main body here] end

		MedicationAdministeredHistoryEntity newEntity = new MedicationAdministeredHistoryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for DateTime here] off begin
		newEntity.setDatetime(OffsetDateTime.now());
		// % protected region % [Add customisation for DateTime here] end
		// % protected region % [Add customisation for Administration Notes here] off begin
		String randomStringforAdministrationNotes = mock
				.strings()
				.get();
		newEntity.setAdministrationNotes(randomStringforAdministrationNotes);
		// % protected region % [Add customisation for Administration Notes here] end
		// % protected region % [Add customisation for Administered Quantity here] off begin
		newEntity.setAdministeredQuantity(mock.ints().get());
		// % protected region % [Add customisation for Administered Quantity here] end
		// % protected region % [Add customisation for Taken Home Quantity here] off begin
		newEntity.setTakenHomeQuantity(mock.ints().get());
		// % protected region % [Add customisation for Taken Home Quantity here] end
		// % protected region % [Add customisation for Returned Quantity here] off begin
		newEntity.setReturnedQuantity(mock.ints().get());
		// % protected region % [Add customisation for Returned Quantity here] end
		// % protected region % [Add customisation for Total Administered Quantity here] off begin
		newEntity.setTotalAdministeredQuantity(mock.ints().get());
		// % protected region % [Add customisation for Total Administered Quantity here] end

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryWithNoRef after the main body here] end

		log.trace("Created entity of type MedicationAdministeredHistoryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medication Administered History entities with no reference at all.
	 */
	@Provides
	@Named("medicationAdministeredHistoryEntitiesWithNoRef")
	public Collection<MedicationAdministeredHistoryEntity> medicationAdministeredHistoryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicationAdministeredHistoryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicationAdministeredHistoryEntitiesWithNoRef here] end
		MedicationAdministeredHistoryEntityFactory medicationAdministeredHistoryEntityFactory
	) {
		log.trace("Creating entities of type MedicationAdministeredHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntitiesWithNoRef before the main body here] end

		Collection<MedicationAdministeredHistoryEntity> newEntities = medicationAdministeredHistoryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicationAdministeredHistoryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medication Administered History entity with all references set.
	 */
	@Provides
	@Named("medicationAdministeredHistoryEntityWithRefs")
	public MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicationAdministeredHistoryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicationAdministeredHistoryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicationAdministeredHistoryEntity with references");

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntityWithRefs before the main body here] end

		MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntity = injector.getInstance(Key.get(MedicationAdministeredHistoryEntity.class, Names.named("medicationAdministeredHistoryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicationAdministeredHistoryEntity with references");

		return medicationAdministeredHistoryEntity;
	}

	/**
	 * Return a collection of Medication Administered History entities with all references set.
	 */
	@Provides
	@Named("medicationAdministeredHistoryEntitiesWithRefs")
	public Collection<MedicationAdministeredHistoryEntity> medicationAdministeredHistoryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicationAdministeredHistoryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicationAdministeredHistoryEntitiesWithRefs here] end
		MedicationAdministeredHistoryEntityFactory medicationAdministeredHistoryEntityFactory
	) {
		log.trace("Creating entities of type MedicationAdministeredHistoryEntity with references");

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntitiesWithRefs before the main body here] end

		Collection<MedicationAdministeredHistoryEntity> newEntities = medicationAdministeredHistoryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicationAdministeredHistoryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
