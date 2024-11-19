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
 * Guice module for Medication Header used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicationHeaderModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicationHeaderModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicationHeaderModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicationHeaderEntityFactory medicationHeaderEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicationHeaderEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicationHeaderEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicationHeaderEntityFactory");

		// % protected region % [Apply any additional logic for medicationHeaderEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderEntityFactory before the main body here] end

		MedicationHeaderEntityFactory entityFactory = new MedicationHeaderEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicationHeaderEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicationHeaderEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicationHeaderEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderEntityFactory after the main body here] end

		log.trace("Created MedicationHeaderEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medication Header entity with no references set.
	 */
	@Provides
	@Named("medicationHeaderEntityWithNoRef")
	public MedicationHeaderEntity medicationHeaderEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicationHeaderEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicationHeaderEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicationHeaderEntity with no reference");

		// % protected region % [Apply any additional logic for medicationHeaderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderWithNoRef before the main body here] end

		MedicationHeaderEntity newEntity = new MedicationHeaderEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Medication Number here] off begin
		String randomStringforMedicationNumber = mock
				.strings()
				.get();
		newEntity.setMedicationNumber(randomStringforMedicationNumber);
		// % protected region % [Add customisation for Medication Number here] end
		// % protected region % [Add customisation for Dispensing Type here] off begin
		String randomStringforDispensingType = mock
				.strings()
				.get();
		newEntity.setDispensingType(randomStringforDispensingType);
		// % protected region % [Add customisation for Dispensing Type here] end
		// % protected region % [Add customisation for Original Medication Number here] off begin
		String randomStringforOriginalMedicationNumber = mock
				.strings()
				.get();
		newEntity.setOriginalMedicationNumber(randomStringforOriginalMedicationNumber);
		// % protected region % [Add customisation for Original Medication Number here] end
		// % protected region % [Add customisation for Order Date here] off begin
		newEntity.setOrderDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Is Urgent here] off begin
		newEntity.setIsUrgent(mock.bools().get());
		// % protected region % [Add customisation for Is Urgent here] end
		// % protected region % [Add customisation for Is Compound here] off begin
		newEntity.setIsCompound(mock.bools().get());
		// % protected region % [Add customisation for Is Compound here] end
		// % protected region % [Add customisation for Revision No here] off begin
		newEntity.setRevisionNo(mock.ints().get());
		// % protected region % [Add customisation for Revision No here] end
		// % protected region % [Add customisation for Is Invoiced here] off begin
		newEntity.setIsInvoiced(mock.bools().get());
		// % protected region % [Add customisation for Is Invoiced here] end
		// % protected region % [Add customisation for External Warehouse here] off begin
		newEntity.setExternalWarehouse(mock.bools().get());
		// % protected region % [Add customisation for External Warehouse here] end
		// % protected region % [Add customisation for Restricted here] off begin
		newEntity.setRestricted(mock.bools().get());
		// % protected region % [Add customisation for Restricted here] end

		// % protected region % [Apply any additional logic for medicationHeaderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderWithNoRef after the main body here] end

		log.trace("Created entity of type MedicationHeaderEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medication Header entities with no reference at all.
	 */
	@Provides
	@Named("medicationHeaderEntitiesWithNoRef")
	public Collection<MedicationHeaderEntity> medicationHeaderEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicationHeaderEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicationHeaderEntitiesWithNoRef here] end
		MedicationHeaderEntityFactory medicationHeaderEntityFactory
	) {
		log.trace("Creating entities of type MedicationHeaderEntity with no reference");

		// % protected region % [Apply any additional logic for medicationHeaderEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderEntitiesWithNoRef before the main body here] end

		Collection<MedicationHeaderEntity> newEntities = medicationHeaderEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicationHeaderEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicationHeaderEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medication Header entity with all references set.
	 */
	@Provides
	@Named("medicationHeaderEntityWithRefs")
	public MedicationHeaderEntity medicationHeaderEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicationHeaderEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicationHeaderEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicationHeaderEntity with references");

		// % protected region % [Apply any additional logic for medicationHeaderEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderEntityWithRefs before the main body here] end

		MedicationHeaderEntity medicationHeaderEntity = injector.getInstance(Key.get(MedicationHeaderEntity.class, Names.named("medicationHeaderEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicationHeaderEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicationHeaderEntity with references");

		return medicationHeaderEntity;
	}

	/**
	 * Return a collection of Medication Header entities with all references set.
	 */
	@Provides
	@Named("medicationHeaderEntitiesWithRefs")
	public Collection<MedicationHeaderEntity> medicationHeaderEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicationHeaderEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicationHeaderEntitiesWithRefs here] end
		MedicationHeaderEntityFactory medicationHeaderEntityFactory
	) {
		log.trace("Creating entities of type MedicationHeaderEntity with references");

		// % protected region % [Apply any additional logic for medicationHeaderEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderEntitiesWithRefs before the main body here] end

		Collection<MedicationHeaderEntity> newEntities = medicationHeaderEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicationHeaderEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationHeaderEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicationHeaderEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
