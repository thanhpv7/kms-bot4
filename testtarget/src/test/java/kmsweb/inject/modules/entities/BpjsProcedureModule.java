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
 * Guice module for BPJS Procedure used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsProcedureModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsProcedureModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsProcedureModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsProcedureEntityFactory bpjsProcedureEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsProcedureEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsProcedureEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsProcedureEntityFactory");

		// % protected region % [Apply any additional logic for bpjsProcedureEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureEntityFactory before the main body here] end

		BpjsProcedureEntityFactory entityFactory = new BpjsProcedureEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsProcedureEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsProcedureEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsProcedureEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureEntityFactory after the main body here] end

		log.trace("Created BpjsProcedureEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Procedure entity with no references set.
	 */
	@Provides
	@Named("bpjsProcedureEntityWithNoRef")
	public BpjsProcedureEntity bpjsProcedureEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsProcedureEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsProcedureEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsProcedureEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsProcedureWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureWithNoRef before the main body here] end

		BpjsProcedureEntity newEntity = new BpjsProcedureEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Procedure Code here] off begin
		String randomStringforProcedureCode = mock
				.strings()
				.get();
		newEntity.setProcedureCode(randomStringforProcedureCode);
		// % protected region % [Add customisation for Procedure Code here] end
		// % protected region % [Add customisation for Procedure Name here] off begin
		String randomStringforProcedureName = mock
				.strings()
				.get();
		newEntity.setProcedureName(randomStringforProcedureName);
		// % protected region % [Add customisation for Procedure Name here] end

		// % protected region % [Apply any additional logic for bpjsProcedureWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsProcedureEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Procedure entities with no reference at all.
	 */
	@Provides
	@Named("bpjsProcedureEntitiesWithNoRef")
	public Collection<BpjsProcedureEntity> bpjsProcedureEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsProcedureEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsProcedureEntitiesWithNoRef here] end
		BpjsProcedureEntityFactory bpjsProcedureEntityFactory
	) {
		log.trace("Creating entities of type BpjsProcedureEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsProcedureEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureEntitiesWithNoRef before the main body here] end

		Collection<BpjsProcedureEntity> newEntities = bpjsProcedureEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsProcedureEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsProcedureEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Procedure entity with all references set.
	 */
	@Provides
	@Named("bpjsProcedureEntityWithRefs")
	public BpjsProcedureEntity bpjsProcedureEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsProcedureEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsProcedureEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsProcedureEntity with references");

		// % protected region % [Apply any additional logic for bpjsProcedureEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureEntityWithRefs before the main body here] end

		BpjsProcedureEntity bpjsProcedureEntity = injector.getInstance(Key.get(BpjsProcedureEntity.class, Names.named("bpjsProcedureEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsProcedureEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsProcedureEntity with references");

		return bpjsProcedureEntity;
	}

	/**
	 * Return a collection of BPJS Procedure entities with all references set.
	 */
	@Provides
	@Named("bpjsProcedureEntitiesWithRefs")
	public Collection<BpjsProcedureEntity> bpjsProcedureEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsProcedureEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsProcedureEntitiesWithRefs here] end
		BpjsProcedureEntityFactory bpjsProcedureEntityFactory
	) {
		log.trace("Creating entities of type BpjsProcedureEntity with references");

		// % protected region % [Apply any additional logic for bpjsProcedureEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureEntitiesWithRefs before the main body here] end

		Collection<BpjsProcedureEntity> newEntities = bpjsProcedureEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsProcedureEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsProcedureEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsProcedureEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
