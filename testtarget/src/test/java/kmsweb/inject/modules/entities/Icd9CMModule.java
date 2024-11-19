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
 * Guice module for ICD 9 CM used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class Icd9CMModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring Icd9CMModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured Icd9CMModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public Icd9CMEntityFactory icd9CMEntityFactory(
			// % protected region % [Apply any additional injected arguments for icd9CMEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for icd9CMEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating Icd9CMEntityFactory");

		// % protected region % [Apply any additional logic for icd9CMEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMEntityFactory before the main body here] end

		Icd9CMEntityFactory entityFactory = new Icd9CMEntityFactory(
				// % protected region % [Apply any additional constructor arguments for Icd9CMEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for Icd9CMEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for icd9CMEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMEntityFactory after the main body here] end

		log.trace("Created Icd9CMEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty ICD 9 CM entity with no references set.
	 */
	@Provides
	@Named("icd9CMEntityWithNoRef")
	public Icd9CMEntity icd9CMEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for icd9CMEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for icd9CMEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type Icd9CMEntity with no reference");

		// % protected region % [Apply any additional logic for icd9CMWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMWithNoRef before the main body here] end

		Icd9CMEntity newEntity = new Icd9CMEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Top Procedure here] off begin
		newEntity.setTopProcedure(mock.bools().get());
		// % protected region % [Add customisation for Top Procedure here] end

		// % protected region % [Apply any additional logic for icd9CMWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMWithNoRef after the main body here] end

		log.trace("Created entity of type Icd9CMEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of ICD 9 CM entities with no reference at all.
	 */
	@Provides
	@Named("icd9CMEntitiesWithNoRef")
	public Collection<Icd9CMEntity> icd9CMEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for icd9CMEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for icd9CMEntitiesWithNoRef here] end
		Icd9CMEntityFactory icd9CMEntityFactory
	) {
		log.trace("Creating entities of type Icd9CMEntity with no reference");

		// % protected region % [Apply any additional logic for icd9CMEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMEntitiesWithNoRef before the main body here] end

		Collection<Icd9CMEntity> newEntities = icd9CMEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for icd9CMEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type Icd9CMEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a ICD 9 CM entity with all references set.
	 */
	@Provides
	@Named("icd9CMEntityWithRefs")
	public Icd9CMEntity icd9CMEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for icd9CMEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for icd9CMEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type Icd9CMEntity with references");

		// % protected region % [Apply any additional logic for icd9CMEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMEntityWithRefs before the main body here] end

		Icd9CMEntity icd9CMEntity = injector.getInstance(Key.get(Icd9CMEntity.class, Names.named("icd9CMEntityWithNoRef")));

		// % protected region % [Apply any additional logic for icd9CMEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMEntityWithRefs after the main body here] end

		log.trace("Created entity of type Icd9CMEntity with references");

		return icd9CMEntity;
	}

	/**
	 * Return a collection of ICD 9 CM entities with all references set.
	 */
	@Provides
	@Named("icd9CMEntitiesWithRefs")
	public Collection<Icd9CMEntity> icd9CMEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for icd9CMEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for icd9CMEntitiesWithRefs here] end
		Icd9CMEntityFactory icd9CMEntityFactory
	) {
		log.trace("Creating entities of type Icd9CMEntity with references");

		// % protected region % [Apply any additional logic for icd9CMEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMEntitiesWithRefs before the main body here] end

		Collection<Icd9CMEntity> newEntities = icd9CMEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for icd9CMEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for icd9CMEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type Icd9CMEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
