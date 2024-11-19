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
 * Guice module for Medication Compound used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicationCompoundModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicationCompoundModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicationCompoundModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicationCompoundEntityFactory medicationCompoundEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicationCompoundEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicationCompoundEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicationCompoundEntityFactory");

		// % protected region % [Apply any additional logic for medicationCompoundEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundEntityFactory before the main body here] end

		MedicationCompoundEntityFactory entityFactory = new MedicationCompoundEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicationCompoundEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicationCompoundEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicationCompoundEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundEntityFactory after the main body here] end

		log.trace("Created MedicationCompoundEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medication Compound entity with no references set.
	 */
	@Provides
	@Named("medicationCompoundEntityWithNoRef")
	public MedicationCompoundEntity medicationCompoundEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicationCompoundEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicationCompoundEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicationCompoundEntity with no reference");

		// % protected region % [Apply any additional logic for medicationCompoundWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundWithNoRef before the main body here] end

		MedicationCompoundEntity newEntity = new MedicationCompoundEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Compound Code here] off begin
		String randomStringforCompoundCode = mock
				.strings()
				.get();
		newEntity.setCompoundCode(randomStringforCompoundCode);
		// % protected region % [Add customisation for Compound Code here] end
		// % protected region % [Add customisation for Compound Name here] off begin
		String randomStringforCompoundName = mock
				.strings()
				.get();
		newEntity.setCompoundName(randomStringforCompoundName);
		// % protected region % [Add customisation for Compound Name here] end
		// % protected region % [Add customisation for Requested Qty here] off begin
		newEntity.setRequestedQty(mock.doubles().get());
		// % protected region % [Add customisation for Requested Qty here] end
		// % protected region % [Add customisation for Outstanding Qty here] off begin
		newEntity.setOutstandingQty(mock.doubles().get());
		// % protected region % [Add customisation for Outstanding Qty here] end
		// % protected region % [Add customisation for Returned Qty here] off begin
		newEntity.setReturnedQty(mock.doubles().get());
		// % protected region % [Add customisation for Returned Qty here] end
		// % protected region % [Add customisation for Issued Qty here] off begin
		newEntity.setIssuedQty(mock.doubles().get());
		// % protected region % [Add customisation for Issued Qty here] end
		// % protected region % [Add customisation for Administered Qty here] off begin
		newEntity.setAdministeredQty(mock.doubles().get());
		// % protected region % [Add customisation for Administered Qty here] end
		// % protected region % [Add customisation for Taken Home Qty here] off begin
		newEntity.setTakenHomeQty(mock.doubles().get());
		// % protected region % [Add customisation for Taken Home Qty here] end
		// % protected region % [Add customisation for Dosage Frequency here] off begin
		newEntity.setDosageFrequency(mock.doubles().get());
		// % protected region % [Add customisation for Dosage Frequency here] end
		// % protected region % [Add customisation for Dosage Qty here] off begin
		newEntity.setDosageQty(mock.doubles().get());
		// % protected region % [Add customisation for Dosage Qty here] end
		// % protected region % [Add customisation for Dose here] off begin
		newEntity.setDose(mock.doubles().get());
		// % protected region % [Add customisation for Dose here] end
		// % protected region % [Add customisation for Frequency here] off begin
		String randomStringforFrequency = mock
				.strings()
				.get();
		newEntity.setFrequency(randomStringforFrequency);
		// % protected region % [Add customisation for Frequency here] end
		// % protected region % [Add customisation for Consumption Method here] off begin
		String randomStringforConsumptionMethod = mock
				.strings()
				.get();
		newEntity.setConsumptionMethod(randomStringforConsumptionMethod);
		// % protected region % [Add customisation for Consumption Method here] end
		// % protected region % [Add customisation for Instruction here] off begin
		String randomStringforInstruction = mock
				.strings()
				.get();
		newEntity.setInstruction(randomStringforInstruction);
		// % protected region % [Add customisation for Instruction here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Total Price here] off begin
		newEntity.setTotalPrice(mock.doubles().get());
		// % protected region % [Add customisation for Total Price here] end
		// % protected region % [Add customisation for Is dtd here] off begin
		newEntity.setIsDtd(mock.bools().get());
		// % protected region % [Add customisation for Is dtd here] end
		// % protected region % [Add customisation for Total Administered Quantity here] off begin
		newEntity.setTotalAdministeredQuantity(mock.ints().get());
		// % protected region % [Add customisation for Total Administered Quantity here] end
		// % protected region % [Add customisation for Total Issued Quantity here] off begin
		newEntity.setTotalIssuedQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Total Issued Quantity here] end
		// % protected region % [Add customisation for Total Taken Home Quantity here] off begin
		newEntity.setTotalTakenHomeQuantity(mock.ints().get());
		// % protected region % [Add customisation for Total Taken Home Quantity here] end
		// % protected region % [Add customisation for Total Returned Quantity here] off begin
		newEntity.setTotalReturnedQuantity(mock.ints().get());
		// % protected region % [Add customisation for Total Returned Quantity here] end
		// % protected region % [Add customisation for External Compound Name here] off begin
		String randomStringforExternalCompoundName = mock
				.strings()
				.get();
		newEntity.setExternalCompoundName(randomStringforExternalCompoundName);
		// % protected region % [Add customisation for External Compound Name here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringforApprovalStatus = mock
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringforApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mock.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end

		// % protected region % [Apply any additional logic for medicationCompoundWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundWithNoRef after the main body here] end

		log.trace("Created entity of type MedicationCompoundEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medication Compound entities with no reference at all.
	 */
	@Provides
	@Named("medicationCompoundEntitiesWithNoRef")
	public Collection<MedicationCompoundEntity> medicationCompoundEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicationCompoundEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicationCompoundEntitiesWithNoRef here] end
		MedicationCompoundEntityFactory medicationCompoundEntityFactory
	) {
		log.trace("Creating entities of type MedicationCompoundEntity with no reference");

		// % protected region % [Apply any additional logic for medicationCompoundEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundEntitiesWithNoRef before the main body here] end

		Collection<MedicationCompoundEntity> newEntities = medicationCompoundEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicationCompoundEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicationCompoundEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medication Compound entity with all references set.
	 */
	@Provides
	@Named("medicationCompoundEntityWithRefs")
	public MedicationCompoundEntity medicationCompoundEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicationCompoundEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicationCompoundEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicationCompoundEntity with references");

		// % protected region % [Apply any additional logic for medicationCompoundEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundEntityWithRefs before the main body here] end

		MedicationCompoundEntity medicationCompoundEntity = injector.getInstance(Key.get(MedicationCompoundEntity.class, Names.named("medicationCompoundEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicationCompoundEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicationCompoundEntity with references");

		return medicationCompoundEntity;
	}

	/**
	 * Return a collection of Medication Compound entities with all references set.
	 */
	@Provides
	@Named("medicationCompoundEntitiesWithRefs")
	public Collection<MedicationCompoundEntity> medicationCompoundEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicationCompoundEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicationCompoundEntitiesWithRefs here] end
		MedicationCompoundEntityFactory medicationCompoundEntityFactory
	) {
		log.trace("Creating entities of type MedicationCompoundEntity with references");

		// % protected region % [Apply any additional logic for medicationCompoundEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundEntitiesWithRefs before the main body here] end

		Collection<MedicationCompoundEntity> newEntities = medicationCompoundEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicationCompoundEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationCompoundEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicationCompoundEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
