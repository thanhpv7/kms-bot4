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
 * Guice module for BPJS Treatment Class Mapping used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsTreatmentClassMappingModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsTreatmentClassMappingModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsTreatmentClassMappingModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsTreatmentClassMappingEntityFactory bpjsTreatmentClassMappingEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsTreatmentClassMappingEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsTreatmentClassMappingEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsTreatmentClassMappingEntityFactory");

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntityFactory before the main body here] end

		BpjsTreatmentClassMappingEntityFactory entityFactory = new BpjsTreatmentClassMappingEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsTreatmentClassMappingEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsTreatmentClassMappingEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntityFactory after the main body here] end

		log.trace("Created BpjsTreatmentClassMappingEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Treatment Class Mapping entity with no references set.
	 */
	@Provides
	@Named("bpjsTreatmentClassMappingEntityWithNoRef")
	public BpjsTreatmentClassMappingEntity bpjsTreatmentClassMappingEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentClassMappingEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentClassMappingEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsTreatmentClassMappingEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingWithNoRef before the main body here] end

		BpjsTreatmentClassMappingEntity newEntity = new BpjsTreatmentClassMappingEntity();
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
		// % protected region % [Add customisation for Internal Treatment Class here] off begin
		String randomStringforInternalTreatmentClass = mock
				.strings()
				.get();
		newEntity.setInternalTreatmentClass(randomStringforInternalTreatmentClass);
		// % protected region % [Add customisation for Internal Treatment Class here] end

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsTreatmentClassMappingEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Treatment Class Mapping entities with no reference at all.
	 */
	@Provides
	@Named("bpjsTreatmentClassMappingEntitiesWithNoRef")
	public Collection<BpjsTreatmentClassMappingEntity> bpjsTreatmentClassMappingEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentClassMappingEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentClassMappingEntitiesWithNoRef here] end
		BpjsTreatmentClassMappingEntityFactory bpjsTreatmentClassMappingEntityFactory
	) {
		log.trace("Creating entities of type BpjsTreatmentClassMappingEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntitiesWithNoRef before the main body here] end

		Collection<BpjsTreatmentClassMappingEntity> newEntities = bpjsTreatmentClassMappingEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsTreatmentClassMappingEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Treatment Class Mapping entity with all references set.
	 */
	@Provides
	@Named("bpjsTreatmentClassMappingEntityWithRefs")
	public BpjsTreatmentClassMappingEntity bpjsTreatmentClassMappingEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentClassMappingEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentClassMappingEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsTreatmentClassMappingEntity with references");

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntityWithRefs before the main body here] end

		BpjsTreatmentClassMappingEntity bpjsTreatmentClassMappingEntity = injector.getInstance(Key.get(BpjsTreatmentClassMappingEntity.class, Names.named("bpjsTreatmentClassMappingEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsTreatmentClassMappingEntity with references");

		return bpjsTreatmentClassMappingEntity;
	}

	/**
	 * Return a collection of BPJS Treatment Class Mapping entities with all references set.
	 */
	@Provides
	@Named("bpjsTreatmentClassMappingEntitiesWithRefs")
	public Collection<BpjsTreatmentClassMappingEntity> bpjsTreatmentClassMappingEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentClassMappingEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentClassMappingEntitiesWithRefs here] end
		BpjsTreatmentClassMappingEntityFactory bpjsTreatmentClassMappingEntityFactory
	) {
		log.trace("Creating entities of type BpjsTreatmentClassMappingEntity with references");

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntitiesWithRefs before the main body here] end

		Collection<BpjsTreatmentClassMappingEntity> newEntities = bpjsTreatmentClassMappingEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentClassMappingEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsTreatmentClassMappingEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
