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
 * Guice module for BPJS Diagnose used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsDiagnoseModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsDiagnoseModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsDiagnoseModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsDiagnoseEntityFactory bpjsDiagnoseEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsDiagnoseEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsDiagnoseEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsDiagnoseEntityFactory");

		// % protected region % [Apply any additional logic for bpjsDiagnoseEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseEntityFactory before the main body here] end

		BpjsDiagnoseEntityFactory entityFactory = new BpjsDiagnoseEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsDiagnoseEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsDiagnoseEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsDiagnoseEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseEntityFactory after the main body here] end

		log.trace("Created BpjsDiagnoseEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Diagnose entity with no references set.
	 */
	@Provides
	@Named("bpjsDiagnoseEntityWithNoRef")
	public BpjsDiagnoseEntity bpjsDiagnoseEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsDiagnoseEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDiagnoseEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsDiagnoseEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDiagnoseWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseWithNoRef before the main body here] end

		BpjsDiagnoseEntity newEntity = new BpjsDiagnoseEntity();
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

		// % protected region % [Apply any additional logic for bpjsDiagnoseWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsDiagnoseEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Diagnose entities with no reference at all.
	 */
	@Provides
	@Named("bpjsDiagnoseEntitiesWithNoRef")
	public Collection<BpjsDiagnoseEntity> bpjsDiagnoseEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsDiagnoseEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDiagnoseEntitiesWithNoRef here] end
		BpjsDiagnoseEntityFactory bpjsDiagnoseEntityFactory
	) {
		log.trace("Creating entities of type BpjsDiagnoseEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDiagnoseEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseEntitiesWithNoRef before the main body here] end

		Collection<BpjsDiagnoseEntity> newEntities = bpjsDiagnoseEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsDiagnoseEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsDiagnoseEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Diagnose entity with all references set.
	 */
	@Provides
	@Named("bpjsDiagnoseEntityWithRefs")
	public BpjsDiagnoseEntity bpjsDiagnoseEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsDiagnoseEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDiagnoseEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsDiagnoseEntity with references");

		// % protected region % [Apply any additional logic for bpjsDiagnoseEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseEntityWithRefs before the main body here] end

		BpjsDiagnoseEntity bpjsDiagnoseEntity = injector.getInstance(Key.get(BpjsDiagnoseEntity.class, Names.named("bpjsDiagnoseEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsDiagnoseEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsDiagnoseEntity with references");

		return bpjsDiagnoseEntity;
	}

	/**
	 * Return a collection of BPJS Diagnose entities with all references set.
	 */
	@Provides
	@Named("bpjsDiagnoseEntitiesWithRefs")
	public Collection<BpjsDiagnoseEntity> bpjsDiagnoseEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsDiagnoseEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDiagnoseEntitiesWithRefs here] end
		BpjsDiagnoseEntityFactory bpjsDiagnoseEntityFactory
	) {
		log.trace("Creating entities of type BpjsDiagnoseEntity with references");

		// % protected region % [Apply any additional logic for bpjsDiagnoseEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseEntitiesWithRefs before the main body here] end

		Collection<BpjsDiagnoseEntity> newEntities = bpjsDiagnoseEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsDiagnoseEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnoseEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsDiagnoseEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
