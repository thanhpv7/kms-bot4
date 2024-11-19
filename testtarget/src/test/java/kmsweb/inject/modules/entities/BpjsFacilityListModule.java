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
 * Guice module for BPJS Facility List used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsFacilityListModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsFacilityListModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsFacilityListModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsFacilityListEntityFactory bpjsFacilityListEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsFacilityListEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsFacilityListEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsFacilityListEntityFactory");

		// % protected region % [Apply any additional logic for bpjsFacilityListEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListEntityFactory before the main body here] end

		BpjsFacilityListEntityFactory entityFactory = new BpjsFacilityListEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsFacilityListEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsFacilityListEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsFacilityListEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListEntityFactory after the main body here] end

		log.trace("Created BpjsFacilityListEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Facility List entity with no references set.
	 */
	@Provides
	@Named("bpjsFacilityListEntityWithNoRef")
	public BpjsFacilityListEntity bpjsFacilityListEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsFacilityListEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsFacilityListEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsFacilityListEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsFacilityListWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListWithNoRef before the main body here] end

		BpjsFacilityListEntity newEntity = new BpjsFacilityListEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Facility Code here] off begin
		String randomStringforFacilityCode = mock
				.strings()
				.get();
		newEntity.setFacilityCode(randomStringforFacilityCode);
		// % protected region % [Add customisation for Facility Code here] end
		// % protected region % [Add customisation for Facility Name here] off begin
		String randomStringforFacilityName = mock
				.strings()
				.get();
		newEntity.setFacilityName(randomStringforFacilityName);
		// % protected region % [Add customisation for Facility Name here] end

		// % protected region % [Apply any additional logic for bpjsFacilityListWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsFacilityListEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Facility List entities with no reference at all.
	 */
	@Provides
	@Named("bpjsFacilityListEntitiesWithNoRef")
	public Collection<BpjsFacilityListEntity> bpjsFacilityListEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsFacilityListEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsFacilityListEntitiesWithNoRef here] end
		BpjsFacilityListEntityFactory bpjsFacilityListEntityFactory
	) {
		log.trace("Creating entities of type BpjsFacilityListEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsFacilityListEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListEntitiesWithNoRef before the main body here] end

		Collection<BpjsFacilityListEntity> newEntities = bpjsFacilityListEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsFacilityListEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsFacilityListEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Facility List entity with all references set.
	 */
	@Provides
	@Named("bpjsFacilityListEntityWithRefs")
	public BpjsFacilityListEntity bpjsFacilityListEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsFacilityListEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsFacilityListEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsFacilityListEntity with references");

		// % protected region % [Apply any additional logic for bpjsFacilityListEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListEntityWithRefs before the main body here] end

		BpjsFacilityListEntity bpjsFacilityListEntity = injector.getInstance(Key.get(BpjsFacilityListEntity.class, Names.named("bpjsFacilityListEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsFacilityListEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsFacilityListEntity with references");

		return bpjsFacilityListEntity;
	}

	/**
	 * Return a collection of BPJS Facility List entities with all references set.
	 */
	@Provides
	@Named("bpjsFacilityListEntitiesWithRefs")
	public Collection<BpjsFacilityListEntity> bpjsFacilityListEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsFacilityListEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsFacilityListEntitiesWithRefs here] end
		BpjsFacilityListEntityFactory bpjsFacilityListEntityFactory
	) {
		log.trace("Creating entities of type BpjsFacilityListEntity with references");

		// % protected region % [Apply any additional logic for bpjsFacilityListEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListEntitiesWithRefs before the main body here] end

		Collection<BpjsFacilityListEntity> newEntities = bpjsFacilityListEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsFacilityListEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFacilityListEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsFacilityListEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
