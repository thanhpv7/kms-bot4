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
 * Guice module for Fluid Balance Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class FluidBalanceDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring FluidBalanceDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured FluidBalanceDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public FluidBalanceDetailEntityFactory fluidBalanceDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for fluidBalanceDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for fluidBalanceDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating FluidBalanceDetailEntityFactory");

		// % protected region % [Apply any additional logic for fluidBalanceDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailEntityFactory before the main body here] end

		FluidBalanceDetailEntityFactory entityFactory = new FluidBalanceDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for FluidBalanceDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for FluidBalanceDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for fluidBalanceDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailEntityFactory after the main body here] end

		log.trace("Created FluidBalanceDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Fluid Balance Detail entity with no references set.
	 */
	@Provides
	@Named("fluidBalanceDetailEntityWithNoRef")
	public FluidBalanceDetailEntity fluidBalanceDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for fluidBalanceDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for fluidBalanceDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type FluidBalanceDetailEntity with no reference");

		// % protected region % [Apply any additional logic for fluidBalanceDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailWithNoRef before the main body here] end

		FluidBalanceDetailEntity newEntity = new FluidBalanceDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Record Date Time here] off begin
		newEntity.setRecordDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Record Date Time here] end
		// % protected region % [Add customisation for Intake Oral here] off begin
		newEntity.setIntakeOral(mock.doubles().get());
		// % protected region % [Add customisation for Intake Oral here] end
		// % protected region % [Add customisation for Intake NGT here] off begin
		newEntity.setIntakeNGT(mock.doubles().get());
		// % protected region % [Add customisation for Intake NGT here] end
		// % protected region % [Add customisation for Intake IV Line here] off begin
		newEntity.setIntakeIVLine(mock.doubles().get());
		// % protected region % [Add customisation for Intake IV Line here] end
		// % protected region % [Add customisation for Intake Others here] off begin
		newEntity.setIntakeOthers(mock.doubles().get());
		// % protected region % [Add customisation for Intake Others here] end
		// % protected region % [Add customisation for Output Urine here] off begin
		newEntity.setOutputUrine(mock.doubles().get());
		// % protected region % [Add customisation for Output Urine here] end
		// % protected region % [Add customisation for Output NGT here] off begin
		newEntity.setOutputNGT(mock.doubles().get());
		// % protected region % [Add customisation for Output NGT here] end
		// % protected region % [Add customisation for Output Drain here] off begin
		newEntity.setOutputDrain(mock.doubles().get());
		// % protected region % [Add customisation for Output Drain here] end
		// % protected region % [Add customisation for Output Stool here] off begin
		newEntity.setOutputStool(mock.doubles().get());
		// % protected region % [Add customisation for Output Stool here] end
		// % protected region % [Add customisation for Output Blood here] off begin
		newEntity.setOutputBlood(mock.doubles().get());
		// % protected region % [Add customisation for Output Blood here] end
		// % protected region % [Add customisation for Output IWL here] off begin
		newEntity.setOutputIWL(mock.doubles().get());
		// % protected region % [Add customisation for Output IWL here] end
		// % protected region % [Add customisation for Output Others here] off begin
		newEntity.setOutputOthers(mock.doubles().get());
		// % protected region % [Add customisation for Output Others here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Total Input here] off begin
		newEntity.setTotalInput(mock.doubles().get());
		// % protected region % [Add customisation for Total Input here] end
		// % protected region % [Add customisation for Total Output here] off begin
		newEntity.setTotalOutput(mock.doubles().get());
		// % protected region % [Add customisation for Total Output here] end
		// % protected region % [Add customisation for Total Balance Fluid here] off begin
		newEntity.setTotalBalanceFluid(mock.doubles().get());
		// % protected region % [Add customisation for Total Balance Fluid here] end

		// % protected region % [Apply any additional logic for fluidBalanceDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailWithNoRef after the main body here] end

		log.trace("Created entity of type FluidBalanceDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Fluid Balance Detail entities with no reference at all.
	 */
	@Provides
	@Named("fluidBalanceDetailEntitiesWithNoRef")
	public Collection<FluidBalanceDetailEntity> fluidBalanceDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for fluidBalanceDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for fluidBalanceDetailEntitiesWithNoRef here] end
		FluidBalanceDetailEntityFactory fluidBalanceDetailEntityFactory
	) {
		log.trace("Creating entities of type FluidBalanceDetailEntity with no reference");

		// % protected region % [Apply any additional logic for fluidBalanceDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailEntitiesWithNoRef before the main body here] end

		Collection<FluidBalanceDetailEntity> newEntities = fluidBalanceDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for fluidBalanceDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type FluidBalanceDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Fluid Balance Detail entity with all references set.
	 */
	@Provides
	@Named("fluidBalanceDetailEntityWithRefs")
	public FluidBalanceDetailEntity fluidBalanceDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for fluidBalanceDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for fluidBalanceDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type FluidBalanceDetailEntity with references");

		// % protected region % [Apply any additional logic for fluidBalanceDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailEntityWithRefs before the main body here] end

		FluidBalanceDetailEntity fluidBalanceDetailEntity = injector.getInstance(Key.get(FluidBalanceDetailEntity.class, Names.named("fluidBalanceDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for fluidBalanceDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type FluidBalanceDetailEntity with references");

		return fluidBalanceDetailEntity;
	}

	/**
	 * Return a collection of Fluid Balance Detail entities with all references set.
	 */
	@Provides
	@Named("fluidBalanceDetailEntitiesWithRefs")
	public Collection<FluidBalanceDetailEntity> fluidBalanceDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for fluidBalanceDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for fluidBalanceDetailEntitiesWithRefs here] end
		FluidBalanceDetailEntityFactory fluidBalanceDetailEntityFactory
	) {
		log.trace("Creating entities of type FluidBalanceDetailEntity with references");

		// % protected region % [Apply any additional logic for fluidBalanceDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailEntitiesWithRefs before the main body here] end

		Collection<FluidBalanceDetailEntity> newEntities = fluidBalanceDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for fluidBalanceDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type FluidBalanceDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
