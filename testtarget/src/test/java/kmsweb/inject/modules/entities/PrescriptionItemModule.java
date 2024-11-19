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
 * Guice module for Prescription Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PrescriptionItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PrescriptionItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PrescriptionItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PrescriptionItemEntityFactory prescriptionItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for prescriptionItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for prescriptionItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PrescriptionItemEntityFactory");

		// % protected region % [Apply any additional logic for prescriptionItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemEntityFactory before the main body here] end

		PrescriptionItemEntityFactory entityFactory = new PrescriptionItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PrescriptionItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PrescriptionItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for prescriptionItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemEntityFactory after the main body here] end

		log.trace("Created PrescriptionItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Prescription Item entity with no references set.
	 */
	@Provides
	@Named("prescriptionItemEntityWithNoRef")
	public PrescriptionItemEntity prescriptionItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for prescriptionItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for prescriptionItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PrescriptionItemEntity with no reference");

		// % protected region % [Apply any additional logic for prescriptionItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemWithNoRef before the main body here] end

		PrescriptionItemEntity newEntity = new PrescriptionItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Iteration Start here] off begin
		newEntity.setIterationStart(mock.ints().get());
		// % protected region % [Add customisation for Iteration Start here] end
		// % protected region % [Add customisation for Iteration End here] off begin
		newEntity.setIterationEnd(mock.ints().get());
		// % protected region % [Add customisation for Iteration End here] end
		// % protected region % [Add customisation for Requested Quantity here] off begin
		newEntity.setRequestedQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Requested Quantity here] end
		// % protected region % [Add customisation for Allocated Quantity here] off begin
		newEntity.setAllocatedQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Allocated Quantity here] end
		// % protected region % [Add customisation for Issued Quantity here] off begin
		newEntity.setIssuedQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Issued Quantity here] end
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
		// % protected region % [Add customisation for Dosage Times here] off begin
		newEntity.setDosageTimes(mock.ints().get());
		// % protected region % [Add customisation for Dosage Times here] end
		// % protected region % [Add customisation for Dosage Days here] off begin
		newEntity.setDosageDays(mock.doubles().get());
		// % protected region % [Add customisation for Dosage Days here] end
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
		// % protected region % [Add customisation for Dose here] off begin
		newEntity.setDose(mock.ints().get());
		// % protected region % [Add customisation for Dose here] end
		// % protected region % [Add customisation for External Stock Name here] off begin
		String randomStringforExternalStockName = mock
				.strings()
				.get();
		newEntity.setExternalStockName(randomStringforExternalStockName);
		// % protected region % [Add customisation for External Stock Name here] end
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

		// % protected region % [Apply any additional logic for prescriptionItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemWithNoRef after the main body here] end

		log.trace("Created entity of type PrescriptionItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Prescription Item entities with no reference at all.
	 */
	@Provides
	@Named("prescriptionItemEntitiesWithNoRef")
	public Collection<PrescriptionItemEntity> prescriptionItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for prescriptionItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for prescriptionItemEntitiesWithNoRef here] end
		PrescriptionItemEntityFactory prescriptionItemEntityFactory
	) {
		log.trace("Creating entities of type PrescriptionItemEntity with no reference");

		// % protected region % [Apply any additional logic for prescriptionItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemEntitiesWithNoRef before the main body here] end

		Collection<PrescriptionItemEntity> newEntities = prescriptionItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for prescriptionItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PrescriptionItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Prescription Item entity with all references set.
	 */
	@Provides
	@Named("prescriptionItemEntityWithRefs")
	public PrescriptionItemEntity prescriptionItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for prescriptionItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for prescriptionItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PrescriptionItemEntity with references");

		// % protected region % [Apply any additional logic for prescriptionItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemEntityWithRefs before the main body here] end

		PrescriptionItemEntity prescriptionItemEntity = injector.getInstance(Key.get(PrescriptionItemEntity.class, Names.named("prescriptionItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for prescriptionItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type PrescriptionItemEntity with references");

		return prescriptionItemEntity;
	}

	/**
	 * Return a collection of Prescription Item entities with all references set.
	 */
	@Provides
	@Named("prescriptionItemEntitiesWithRefs")
	public Collection<PrescriptionItemEntity> prescriptionItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for prescriptionItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for prescriptionItemEntitiesWithRefs here] end
		PrescriptionItemEntityFactory prescriptionItemEntityFactory
	) {
		log.trace("Creating entities of type PrescriptionItemEntity with references");

		// % protected region % [Apply any additional logic for prescriptionItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemEntitiesWithRefs before the main body here] end

		Collection<PrescriptionItemEntity> newEntities = prescriptionItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for prescriptionItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for prescriptionItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PrescriptionItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
