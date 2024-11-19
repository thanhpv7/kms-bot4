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
 * Guice module for Compound Prescription Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class CompoundPrescriptionDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring CompoundPrescriptionDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured CompoundPrescriptionDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public CompoundPrescriptionDetailEntityFactory compoundPrescriptionDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for compoundPrescriptionDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for compoundPrescriptionDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating CompoundPrescriptionDetailEntityFactory");

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntityFactory before the main body here] end

		CompoundPrescriptionDetailEntityFactory entityFactory = new CompoundPrescriptionDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for CompoundPrescriptionDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for CompoundPrescriptionDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntityFactory after the main body here] end

		log.trace("Created CompoundPrescriptionDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Compound Prescription Detail entity with no references set.
	 */
	@Provides
	@Named("compoundPrescriptionDetailEntityWithNoRef")
	public CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for compoundPrescriptionDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for compoundPrescriptionDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type CompoundPrescriptionDetailEntity with no reference");

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailWithNoRef before the main body here] end

		CompoundPrescriptionDetailEntity newEntity = new CompoundPrescriptionDetailEntity();
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
		// % protected region % [Add customisation for Request Quantity here] off begin
		newEntity.setRequestQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Request Quantity here] end
		// % protected region % [Add customisation for Dosage Times here] off begin
		newEntity.setDosageTimes(mock.ints().get());
		// % protected region % [Add customisation for Dosage Times here] end
		// % protected region % [Add customisation for Dosage Days here] off begin
		newEntity.setDosageDays(mock.doubles().get());
		// % protected region % [Add customisation for Dosage Days here] end
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
		// % protected region % [Add customisation for Iteration Start here] off begin
		newEntity.setIterationStart(mock.ints().get());
		// % protected region % [Add customisation for Iteration Start here] end
		// % protected region % [Add customisation for Iteration End here] off begin
		newEntity.setIterationEnd(mock.ints().get());
		// % protected region % [Add customisation for Iteration End here] end
		// % protected region % [Add customisation for Is dtd here] off begin
		newEntity.setIsDtd(mock.bools().get());
		// % protected region % [Add customisation for Is dtd here] end
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

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailWithNoRef after the main body here] end

		log.trace("Created entity of type CompoundPrescriptionDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Compound Prescription Detail entities with no reference at all.
	 */
	@Provides
	@Named("compoundPrescriptionDetailEntitiesWithNoRef")
	public Collection<CompoundPrescriptionDetailEntity> compoundPrescriptionDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for compoundPrescriptionDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for compoundPrescriptionDetailEntitiesWithNoRef here] end
		CompoundPrescriptionDetailEntityFactory compoundPrescriptionDetailEntityFactory
	) {
		log.trace("Creating entities of type CompoundPrescriptionDetailEntity with no reference");

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntitiesWithNoRef before the main body here] end

		Collection<CompoundPrescriptionDetailEntity> newEntities = compoundPrescriptionDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type CompoundPrescriptionDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Compound Prescription Detail entity with all references set.
	 */
	@Provides
	@Named("compoundPrescriptionDetailEntityWithRefs")
	public CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for compoundPrescriptionDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for compoundPrescriptionDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type CompoundPrescriptionDetailEntity with references");

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntityWithRefs before the main body here] end

		CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity = injector.getInstance(Key.get(CompoundPrescriptionDetailEntity.class, Names.named("compoundPrescriptionDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type CompoundPrescriptionDetailEntity with references");

		return compoundPrescriptionDetailEntity;
	}

	/**
	 * Return a collection of Compound Prescription Detail entities with all references set.
	 */
	@Provides
	@Named("compoundPrescriptionDetailEntitiesWithRefs")
	public Collection<CompoundPrescriptionDetailEntity> compoundPrescriptionDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for compoundPrescriptionDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for compoundPrescriptionDetailEntitiesWithRefs here] end
		CompoundPrescriptionDetailEntityFactory compoundPrescriptionDetailEntityFactory
	) {
		log.trace("Creating entities of type CompoundPrescriptionDetailEntity with references");

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntitiesWithRefs before the main body here] end

		Collection<CompoundPrescriptionDetailEntity> newEntities = compoundPrescriptionDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for compoundPrescriptionDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type CompoundPrescriptionDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
