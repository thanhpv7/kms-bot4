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
 * Guice module for BPJS Dismissal Condition used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsDismissalConditionModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsDismissalConditionModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsDismissalConditionModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsDismissalConditionEntityFactory bpjsDismissalConditionEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsDismissalConditionEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsDismissalConditionEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsDismissalConditionEntityFactory");

		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntityFactory before the main body here] end

		BpjsDismissalConditionEntityFactory entityFactory = new BpjsDismissalConditionEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsDismissalConditionEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsDismissalConditionEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntityFactory after the main body here] end

		log.trace("Created BpjsDismissalConditionEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Dismissal Condition entity with no references set.
	 */
	@Provides
	@Named("bpjsDismissalConditionEntityWithNoRef")
	public BpjsDismissalConditionEntity bpjsDismissalConditionEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsDismissalConditionEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDismissalConditionEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsDismissalConditionEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDismissalConditionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionWithNoRef before the main body here] end

		BpjsDismissalConditionEntity newEntity = new BpjsDismissalConditionEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Condition Name here] off begin
		String randomStringforConditionName = mock
				.strings()
				.get();
		newEntity.setConditionName(randomStringforConditionName);
		// % protected region % [Add customisation for Condition Name here] end
		// % protected region % [Add customisation for Condition Code here] off begin
		String randomStringforConditionCode = mock
				.strings()
				.get();
		newEntity.setConditionCode(randomStringforConditionCode);
		// % protected region % [Add customisation for Condition Code here] end

		// % protected region % [Apply any additional logic for bpjsDismissalConditionWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsDismissalConditionEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Dismissal Condition entities with no reference at all.
	 */
	@Provides
	@Named("bpjsDismissalConditionEntitiesWithNoRef")
	public Collection<BpjsDismissalConditionEntity> bpjsDismissalConditionEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsDismissalConditionEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDismissalConditionEntitiesWithNoRef here] end
		BpjsDismissalConditionEntityFactory bpjsDismissalConditionEntityFactory
	) {
		log.trace("Creating entities of type BpjsDismissalConditionEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntitiesWithNoRef before the main body here] end

		Collection<BpjsDismissalConditionEntity> newEntities = bpjsDismissalConditionEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsDismissalConditionEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Dismissal Condition entity with all references set.
	 */
	@Provides
	@Named("bpjsDismissalConditionEntityWithRefs")
	public BpjsDismissalConditionEntity bpjsDismissalConditionEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsDismissalConditionEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDismissalConditionEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsDismissalConditionEntity with references");

		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntityWithRefs before the main body here] end

		BpjsDismissalConditionEntity bpjsDismissalConditionEntity = injector.getInstance(Key.get(BpjsDismissalConditionEntity.class, Names.named("bpjsDismissalConditionEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsDismissalConditionEntity with references");

		return bpjsDismissalConditionEntity;
	}

	/**
	 * Return a collection of BPJS Dismissal Condition entities with all references set.
	 */
	@Provides
	@Named("bpjsDismissalConditionEntitiesWithRefs")
	public Collection<BpjsDismissalConditionEntity> bpjsDismissalConditionEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsDismissalConditionEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDismissalConditionEntitiesWithRefs here] end
		BpjsDismissalConditionEntityFactory bpjsDismissalConditionEntityFactory
	) {
		log.trace("Creating entities of type BpjsDismissalConditionEntity with references");

		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntitiesWithRefs before the main body here] end

		Collection<BpjsDismissalConditionEntity> newEntities = bpjsDismissalConditionEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalConditionEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsDismissalConditionEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
