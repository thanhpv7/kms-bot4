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
 * Guice module for BPJS Dismissal Mapping used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsDismissalMappingModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsDismissalMappingModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsDismissalMappingModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsDismissalMappingEntityFactory bpjsDismissalMappingEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsDismissalMappingEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsDismissalMappingEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsDismissalMappingEntityFactory");

		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntityFactory before the main body here] end

		BpjsDismissalMappingEntityFactory entityFactory = new BpjsDismissalMappingEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsDismissalMappingEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsDismissalMappingEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntityFactory after the main body here] end

		log.trace("Created BpjsDismissalMappingEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Dismissal Mapping entity with no references set.
	 */
	@Provides
	@Named("bpjsDismissalMappingEntityWithNoRef")
	public BpjsDismissalMappingEntity bpjsDismissalMappingEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsDismissalMappingEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDismissalMappingEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsDismissalMappingEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDismissalMappingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingWithNoRef before the main body here] end

		BpjsDismissalMappingEntity newEntity = new BpjsDismissalMappingEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Ref Code here] off begin
		String randomStringforRefCode = mock
				.strings()
				.size(25)
				.get();
		newEntity.setRefCode(randomStringforRefCode);
		// % protected region % [Add customisation for Ref Code here] end
		// % protected region % [Add customisation for Ref Name here] off begin
		String randomStringforRefName = mock
				.strings()
				.size(50)
				.get();
		newEntity.setRefName(randomStringforRefName);
		// % protected region % [Add customisation for Ref Name here] end
		// % protected region % [Add customisation for Internal Dismissal here] off begin
		String randomStringforInternalDismissal = mock
				.strings()
				.get();
		newEntity.setInternalDismissal(randomStringforInternalDismissal);
		// % protected region % [Add customisation for Internal Dismissal here] end

		// % protected region % [Apply any additional logic for bpjsDismissalMappingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsDismissalMappingEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Dismissal Mapping entities with no reference at all.
	 */
	@Provides
	@Named("bpjsDismissalMappingEntitiesWithNoRef")
	public Collection<BpjsDismissalMappingEntity> bpjsDismissalMappingEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsDismissalMappingEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDismissalMappingEntitiesWithNoRef here] end
		BpjsDismissalMappingEntityFactory bpjsDismissalMappingEntityFactory
	) {
		log.trace("Creating entities of type BpjsDismissalMappingEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntitiesWithNoRef before the main body here] end

		Collection<BpjsDismissalMappingEntity> newEntities = bpjsDismissalMappingEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsDismissalMappingEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Dismissal Mapping entity with all references set.
	 */
	@Provides
	@Named("bpjsDismissalMappingEntityWithRefs")
	public BpjsDismissalMappingEntity bpjsDismissalMappingEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsDismissalMappingEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDismissalMappingEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsDismissalMappingEntity with references");

		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntityWithRefs before the main body here] end

		BpjsDismissalMappingEntity bpjsDismissalMappingEntity = injector.getInstance(Key.get(BpjsDismissalMappingEntity.class, Names.named("bpjsDismissalMappingEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsDismissalMappingEntity with references");

		return bpjsDismissalMappingEntity;
	}

	/**
	 * Return a collection of BPJS Dismissal Mapping entities with all references set.
	 */
	@Provides
	@Named("bpjsDismissalMappingEntitiesWithRefs")
	public Collection<BpjsDismissalMappingEntity> bpjsDismissalMappingEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsDismissalMappingEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDismissalMappingEntitiesWithRefs here] end
		BpjsDismissalMappingEntityFactory bpjsDismissalMappingEntityFactory
	) {
		log.trace("Creating entities of type BpjsDismissalMappingEntity with references");

		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntitiesWithRefs before the main body here] end

		Collection<BpjsDismissalMappingEntity> newEntities = bpjsDismissalMappingEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDismissalMappingEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsDismissalMappingEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
