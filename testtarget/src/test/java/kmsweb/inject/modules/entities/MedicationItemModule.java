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
 * Guice module for Medication Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicationItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicationItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicationItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicationItemEntityFactory medicationItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicationItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicationItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicationItemEntityFactory");

		// % protected region % [Apply any additional logic for medicationItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemEntityFactory before the main body here] end

		MedicationItemEntityFactory entityFactory = new MedicationItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicationItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicationItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicationItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemEntityFactory after the main body here] end

		log.trace("Created MedicationItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medication Item entity with no references set.
	 */
	@Provides
	@Named("medicationItemEntityWithNoRef")
	public MedicationItemEntity medicationItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicationItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicationItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicationItemEntity with no reference");

		// % protected region % [Apply any additional logic for medicationItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemWithNoRef before the main body here] end

		MedicationItemEntity newEntity = new MedicationItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
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
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mock.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Total Price here] off begin
		newEntity.setTotalPrice(mock.doubles().get());
		// % protected region % [Add customisation for Total Price here] end
		// % protected region % [Add customisation for Is dtd here] off begin
		newEntity.setIsDtd(mock.bools().get());
		// % protected region % [Add customisation for Is dtd here] end
		// % protected region % [Add customisation for Total Issued Quantity here] off begin
		newEntity.setTotalIssuedQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Total Issued Quantity here] end
		// % protected region % [Add customisation for Total Administered Quantity here] off begin
		newEntity.setTotalAdministeredQuantity(mock.ints().get());
		// % protected region % [Add customisation for Total Administered Quantity here] end
		// % protected region % [Add customisation for Total Taken Home Quantity here] off begin
		newEntity.setTotalTakenHomeQuantity(mock.ints().get());
		// % protected region % [Add customisation for Total Taken Home Quantity here] end
		// % protected region % [Add customisation for Total Returned Quantity here] off begin
		newEntity.setTotalReturnedQuantity(mock.ints().get());
		// % protected region % [Add customisation for Total Returned Quantity here] end
		// % protected region % [Add customisation for External Medication Name here] off begin
		String randomStringforExternalMedicationName = mock
				.strings()
				.get();
		newEntity.setExternalMedicationName(randomStringforExternalMedicationName);
		// % protected region % [Add customisation for External Medication Name here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringforApprovalStatus = mock
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringforApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mock.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end
		// % protected region % [Add customisation for DTD Quantity here] off begin
		newEntity.setDtdQuantity(mock.doubles().get());
		// % protected region % [Add customisation for DTD Quantity here] end

		// % protected region % [Apply any additional logic for medicationItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemWithNoRef after the main body here] end

		log.trace("Created entity of type MedicationItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medication Item entities with no reference at all.
	 */
	@Provides
	@Named("medicationItemEntitiesWithNoRef")
	public Collection<MedicationItemEntity> medicationItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicationItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicationItemEntitiesWithNoRef here] end
		MedicationItemEntityFactory medicationItemEntityFactory
	) {
		log.trace("Creating entities of type MedicationItemEntity with no reference");

		// % protected region % [Apply any additional logic for medicationItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemEntitiesWithNoRef before the main body here] end

		Collection<MedicationItemEntity> newEntities = medicationItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicationItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicationItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medication Item entity with all references set.
	 */
	@Provides
	@Named("medicationItemEntityWithRefs")
	public MedicationItemEntity medicationItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicationItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicationItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicationItemEntity with references");

		// % protected region % [Apply any additional logic for medicationItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemEntityWithRefs before the main body here] end

		MedicationItemEntity medicationItemEntity = injector.getInstance(Key.get(MedicationItemEntity.class, Names.named("medicationItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicationItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicationItemEntity with references");

		return medicationItemEntity;
	}

	/**
	 * Return a collection of Medication Item entities with all references set.
	 */
	@Provides
	@Named("medicationItemEntitiesWithRefs")
	public Collection<MedicationItemEntity> medicationItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicationItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicationItemEntitiesWithRefs here] end
		MedicationItemEntityFactory medicationItemEntityFactory
	) {
		log.trace("Creating entities of type MedicationItemEntity with references");

		// % protected region % [Apply any additional logic for medicationItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemEntitiesWithRefs before the main body here] end

		Collection<MedicationItemEntity> newEntities = medicationItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicationItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicationItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
