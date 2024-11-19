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
 * Guice module for BPJS Health Facility used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsHealthFacilityModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsHealthFacilityModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsHealthFacilityModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsHealthFacilityEntityFactory bpjsHealthFacilityEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsHealthFacilityEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsHealthFacilityEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsHealthFacilityEntityFactory");

		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntityFactory before the main body here] end

		BpjsHealthFacilityEntityFactory entityFactory = new BpjsHealthFacilityEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsHealthFacilityEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsHealthFacilityEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntityFactory after the main body here] end

		log.trace("Created BpjsHealthFacilityEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Health Facility entity with no references set.
	 */
	@Provides
	@Named("bpjsHealthFacilityEntityWithNoRef")
	public BpjsHealthFacilityEntity bpjsHealthFacilityEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsHealthFacilityEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsHealthFacilityEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsHealthFacilityEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsHealthFacilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityWithNoRef before the main body here] end

		BpjsHealthFacilityEntity newEntity = new BpjsHealthFacilityEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Ref Code here] off begin
		String randomStringforRefCode = mock
				.strings()
				.get();
		newEntity.setRefCode(randomStringforRefCode);
		// % protected region % [Add customisation for Ref Code here] end
		// % protected region % [Add customisation for Ref Name here] off begin
		String randomStringforRefName = mock
				.strings()
				.get();
		newEntity.setRefName(randomStringforRefName);
		// % protected region % [Add customisation for Ref Name here] end

		// % protected region % [Apply any additional logic for bpjsHealthFacilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsHealthFacilityEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Health Facility entities with no reference at all.
	 */
	@Provides
	@Named("bpjsHealthFacilityEntitiesWithNoRef")
	public Collection<BpjsHealthFacilityEntity> bpjsHealthFacilityEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsHealthFacilityEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsHealthFacilityEntitiesWithNoRef here] end
		BpjsHealthFacilityEntityFactory bpjsHealthFacilityEntityFactory
	) {
		log.trace("Creating entities of type BpjsHealthFacilityEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntitiesWithNoRef before the main body here] end

		Collection<BpjsHealthFacilityEntity> newEntities = bpjsHealthFacilityEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsHealthFacilityEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Health Facility entity with all references set.
	 */
	@Provides
	@Named("bpjsHealthFacilityEntityWithRefs")
	public BpjsHealthFacilityEntity bpjsHealthFacilityEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsHealthFacilityEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsHealthFacilityEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsHealthFacilityEntity with references");

		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntityWithRefs before the main body here] end

		BpjsHealthFacilityEntity bpjsHealthFacilityEntity = injector.getInstance(Key.get(BpjsHealthFacilityEntity.class, Names.named("bpjsHealthFacilityEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsHealthFacilityEntity with references");

		return bpjsHealthFacilityEntity;
	}

	/**
	 * Return a collection of BPJS Health Facility entities with all references set.
	 */
	@Provides
	@Named("bpjsHealthFacilityEntitiesWithRefs")
	public Collection<BpjsHealthFacilityEntity> bpjsHealthFacilityEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsHealthFacilityEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsHealthFacilityEntitiesWithRefs here] end
		BpjsHealthFacilityEntityFactory bpjsHealthFacilityEntityFactory
	) {
		log.trace("Creating entities of type BpjsHealthFacilityEntity with references");

		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntitiesWithRefs before the main body here] end

		Collection<BpjsHealthFacilityEntity> newEntities = bpjsHealthFacilityEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHealthFacilityEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsHealthFacilityEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
