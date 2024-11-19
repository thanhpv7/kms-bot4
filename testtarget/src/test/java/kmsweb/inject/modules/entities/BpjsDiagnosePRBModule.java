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
 * Guice module for BPJS Diagnose PRB used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsDiagnosePRBModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsDiagnosePRBModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsDiagnosePRBModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsDiagnosePRBEntityFactory bpjsDiagnosePRBEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsDiagnosePRBEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsDiagnosePRBEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsDiagnosePRBEntityFactory");

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntityFactory before the main body here] end

		BpjsDiagnosePRBEntityFactory entityFactory = new BpjsDiagnosePRBEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsDiagnosePRBEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsDiagnosePRBEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntityFactory after the main body here] end

		log.trace("Created BpjsDiagnosePRBEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Diagnose PRB entity with no references set.
	 */
	@Provides
	@Named("bpjsDiagnosePRBEntityWithNoRef")
	public BpjsDiagnosePRBEntity bpjsDiagnosePRBEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsDiagnosePRBEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDiagnosePRBEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsDiagnosePRBEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBWithNoRef before the main body here] end

		BpjsDiagnosePRBEntity newEntity = new BpjsDiagnosePRBEntity();
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

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsDiagnosePRBEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Diagnose PRB entities with no reference at all.
	 */
	@Provides
	@Named("bpjsDiagnosePRBEntitiesWithNoRef")
	public Collection<BpjsDiagnosePRBEntity> bpjsDiagnosePRBEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsDiagnosePRBEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDiagnosePRBEntitiesWithNoRef here] end
		BpjsDiagnosePRBEntityFactory bpjsDiagnosePRBEntityFactory
	) {
		log.trace("Creating entities of type BpjsDiagnosePRBEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntitiesWithNoRef before the main body here] end

		Collection<BpjsDiagnosePRBEntity> newEntities = bpjsDiagnosePRBEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsDiagnosePRBEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Diagnose PRB entity with all references set.
	 */
	@Provides
	@Named("bpjsDiagnosePRBEntityWithRefs")
	public BpjsDiagnosePRBEntity bpjsDiagnosePRBEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsDiagnosePRBEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDiagnosePRBEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsDiagnosePRBEntity with references");

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntityWithRefs before the main body here] end

		BpjsDiagnosePRBEntity bpjsDiagnosePRBEntity = injector.getInstance(Key.get(BpjsDiagnosePRBEntity.class, Names.named("bpjsDiagnosePRBEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsDiagnosePRBEntity with references");

		return bpjsDiagnosePRBEntity;
	}

	/**
	 * Return a collection of BPJS Diagnose PRB entities with all references set.
	 */
	@Provides
	@Named("bpjsDiagnosePRBEntitiesWithRefs")
	public Collection<BpjsDiagnosePRBEntity> bpjsDiagnosePRBEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsDiagnosePRBEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDiagnosePRBEntitiesWithRefs here] end
		BpjsDiagnosePRBEntityFactory bpjsDiagnosePRBEntityFactory
	) {
		log.trace("Creating entities of type BpjsDiagnosePRBEntity with references");

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntitiesWithRefs before the main body here] end

		Collection<BpjsDiagnosePRBEntity> newEntities = bpjsDiagnosePRBEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDiagnosePRBEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsDiagnosePRBEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
