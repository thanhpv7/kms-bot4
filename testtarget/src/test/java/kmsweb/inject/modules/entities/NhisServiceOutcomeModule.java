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
 * Guice module for NHIS Service Outcome used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NhisServiceOutcomeModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NhisServiceOutcomeModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NhisServiceOutcomeModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NhisServiceOutcomeEntityFactory nhisServiceOutcomeEntityFactory(
			// % protected region % [Apply any additional injected arguments for nhisServiceOutcomeEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nhisServiceOutcomeEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NhisServiceOutcomeEntityFactory");

		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntityFactory before the main body here] end

		NhisServiceOutcomeEntityFactory entityFactory = new NhisServiceOutcomeEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NhisServiceOutcomeEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NhisServiceOutcomeEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntityFactory after the main body here] end

		log.trace("Created NhisServiceOutcomeEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty NHIS Service Outcome entity with no references set.
	 */
	@Provides
	@Named("nhisServiceOutcomeEntityWithNoRef")
	public NhisServiceOutcomeEntity nhisServiceOutcomeEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nhisServiceOutcomeEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisServiceOutcomeEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NhisServiceOutcomeEntity with no reference");

		// % protected region % [Apply any additional logic for nhisServiceOutcomeWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeWithNoRef before the main body here] end

		NhisServiceOutcomeEntity newEntity = new NhisServiceOutcomeEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
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
		// % protected region % [Add customisation for Dismissal Types here] off begin
		String randomStringforDismissalTypes = mock
				.strings()
				.get();
		newEntity.setDismissalTypes(randomStringforDismissalTypes);
		// % protected region % [Add customisation for Dismissal Types here] end

		// % protected region % [Apply any additional logic for nhisServiceOutcomeWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeWithNoRef after the main body here] end

		log.trace("Created entity of type NhisServiceOutcomeEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of NHIS Service Outcome entities with no reference at all.
	 */
	@Provides
	@Named("nhisServiceOutcomeEntitiesWithNoRef")
	public Collection<NhisServiceOutcomeEntity> nhisServiceOutcomeEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nhisServiceOutcomeEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisServiceOutcomeEntitiesWithNoRef here] end
		NhisServiceOutcomeEntityFactory nhisServiceOutcomeEntityFactory
	) {
		log.trace("Creating entities of type NhisServiceOutcomeEntity with no reference");

		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntitiesWithNoRef before the main body here] end

		Collection<NhisServiceOutcomeEntity> newEntities = nhisServiceOutcomeEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NhisServiceOutcomeEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a NHIS Service Outcome entity with all references set.
	 */
	@Provides
	@Named("nhisServiceOutcomeEntityWithRefs")
	public NhisServiceOutcomeEntity nhisServiceOutcomeEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nhisServiceOutcomeEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisServiceOutcomeEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NhisServiceOutcomeEntity with references");

		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntityWithRefs before the main body here] end

		NhisServiceOutcomeEntity nhisServiceOutcomeEntity = injector.getInstance(Key.get(NhisServiceOutcomeEntity.class, Names.named("nhisServiceOutcomeEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntityWithRefs after the main body here] end

		log.trace("Created entity of type NhisServiceOutcomeEntity with references");

		return nhisServiceOutcomeEntity;
	}

	/**
	 * Return a collection of NHIS Service Outcome entities with all references set.
	 */
	@Provides
	@Named("nhisServiceOutcomeEntitiesWithRefs")
	public Collection<NhisServiceOutcomeEntity> nhisServiceOutcomeEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nhisServiceOutcomeEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisServiceOutcomeEntitiesWithRefs here] end
		NhisServiceOutcomeEntityFactory nhisServiceOutcomeEntityFactory
	) {
		log.trace("Creating entities of type NhisServiceOutcomeEntity with references");

		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntitiesWithRefs before the main body here] end

		Collection<NhisServiceOutcomeEntity> newEntities = nhisServiceOutcomeEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisServiceOutcomeEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NhisServiceOutcomeEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
