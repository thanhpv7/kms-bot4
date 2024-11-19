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
 * Guice module for BPJS SEP used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsSEPModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsSEPModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsSEPModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsSEPEntityFactory bpjsSEPEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsSEPEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsSEPEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsSEPEntityFactory");

		// % protected region % [Apply any additional logic for bpjsSEPEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPEntityFactory before the main body here] end

		BpjsSEPEntityFactory entityFactory = new BpjsSEPEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsSEPEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsSEPEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsSEPEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPEntityFactory after the main body here] end

		log.trace("Created BpjsSEPEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS SEP entity with no references set.
	 */
	@Provides
	@Named("bpjsSEPEntityWithNoRef")
	public BpjsSEPEntity bpjsSEPEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsSEPEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSEPEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsSEPEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSEPWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPWithNoRef before the main body here] end

		BpjsSEPEntity newEntity = new BpjsSEPEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for No SEP here] off begin
		String randomStringforNoSEP = mock
				.strings()
				.get();
		newEntity.setNoSEP(randomStringforNoSEP);
		// % protected region % [Add customisation for No SEP here] end

		// % protected region % [Apply any additional logic for bpjsSEPWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsSEPEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS SEP entities with no reference at all.
	 */
	@Provides
	@Named("bpjsSEPEntitiesWithNoRef")
	public Collection<BpjsSEPEntity> bpjsSEPEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsSEPEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSEPEntitiesWithNoRef here] end
		BpjsSEPEntityFactory bpjsSEPEntityFactory
	) {
		log.trace("Creating entities of type BpjsSEPEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSEPEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPEntitiesWithNoRef before the main body here] end

		Collection<BpjsSEPEntity> newEntities = bpjsSEPEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsSEPEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsSEPEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS SEP entity with all references set.
	 */
	@Provides
	@Named("bpjsSEPEntityWithRefs")
	public BpjsSEPEntity bpjsSEPEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsSEPEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSEPEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsSEPEntity with references");

		// % protected region % [Apply any additional logic for bpjsSEPEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPEntityWithRefs before the main body here] end

		BpjsSEPEntity bpjsSEPEntity = injector.getInstance(Key.get(BpjsSEPEntity.class, Names.named("bpjsSEPEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsSEPEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsSEPEntity with references");

		return bpjsSEPEntity;
	}

	/**
	 * Return a collection of BPJS SEP entities with all references set.
	 */
	@Provides
	@Named("bpjsSEPEntitiesWithRefs")
	public Collection<BpjsSEPEntity> bpjsSEPEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsSEPEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSEPEntitiesWithRefs here] end
		BpjsSEPEntityFactory bpjsSEPEntityFactory
	) {
		log.trace("Creating entities of type BpjsSEPEntity with references");

		// % protected region % [Apply any additional logic for bpjsSEPEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPEntitiesWithRefs before the main body here] end

		Collection<BpjsSEPEntity> newEntities = bpjsSEPEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsSEPEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsSEPEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
