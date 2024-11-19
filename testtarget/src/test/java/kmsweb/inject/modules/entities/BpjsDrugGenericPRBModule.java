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
 * Guice module for BPJS Drug Generic PRB used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsDrugGenericPRBModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsDrugGenericPRBModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsDrugGenericPRBModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsDrugGenericPRBEntityFactory bpjsDrugGenericPRBEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsDrugGenericPRBEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsDrugGenericPRBEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsDrugGenericPRBEntityFactory");

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntityFactory before the main body here] end

		BpjsDrugGenericPRBEntityFactory entityFactory = new BpjsDrugGenericPRBEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsDrugGenericPRBEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsDrugGenericPRBEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntityFactory after the main body here] end

		log.trace("Created BpjsDrugGenericPRBEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Drug Generic PRB entity with no references set.
	 */
	@Provides
	@Named("bpjsDrugGenericPRBEntityWithNoRef")
	public BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsDrugGenericPRBEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDrugGenericPRBEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsDrugGenericPRBEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBWithNoRef before the main body here] end

		BpjsDrugGenericPRBEntity newEntity = new BpjsDrugGenericPRBEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Ref Drug Code here] off begin
		String randomStringforRefDrugCode = mock
				.strings()
				.get();
		newEntity.setRefDrugCode(randomStringforRefDrugCode);
		// % protected region % [Add customisation for Ref Drug Code here] end
		// % protected region % [Add customisation for Ref Drug Name here] off begin
		String randomStringforRefDrugName = mock
				.strings()
				.get();
		newEntity.setRefDrugName(randomStringforRefDrugName);
		// % protected region % [Add customisation for Ref Drug Name here] end

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsDrugGenericPRBEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Drug Generic PRB entities with no reference at all.
	 */
	@Provides
	@Named("bpjsDrugGenericPRBEntitiesWithNoRef")
	public Collection<BpjsDrugGenericPRBEntity> bpjsDrugGenericPRBEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsDrugGenericPRBEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDrugGenericPRBEntitiesWithNoRef here] end
		BpjsDrugGenericPRBEntityFactory bpjsDrugGenericPRBEntityFactory
	) {
		log.trace("Creating entities of type BpjsDrugGenericPRBEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntitiesWithNoRef before the main body here] end

		Collection<BpjsDrugGenericPRBEntity> newEntities = bpjsDrugGenericPRBEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsDrugGenericPRBEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Drug Generic PRB entity with all references set.
	 */
	@Provides
	@Named("bpjsDrugGenericPRBEntityWithRefs")
	public BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsDrugGenericPRBEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDrugGenericPRBEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsDrugGenericPRBEntity with references");

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntityWithRefs before the main body here] end

		BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity = injector.getInstance(Key.get(BpjsDrugGenericPRBEntity.class, Names.named("bpjsDrugGenericPRBEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsDrugGenericPRBEntity with references");

		return bpjsDrugGenericPRBEntity;
	}

	/**
	 * Return a collection of BPJS Drug Generic PRB entities with all references set.
	 */
	@Provides
	@Named("bpjsDrugGenericPRBEntitiesWithRefs")
	public Collection<BpjsDrugGenericPRBEntity> bpjsDrugGenericPRBEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsDrugGenericPRBEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDrugGenericPRBEntitiesWithRefs here] end
		BpjsDrugGenericPRBEntityFactory bpjsDrugGenericPRBEntityFactory
	) {
		log.trace("Creating entities of type BpjsDrugGenericPRBEntity with references");

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntitiesWithRefs before the main body here] end

		Collection<BpjsDrugGenericPRBEntity> newEntities = bpjsDrugGenericPRBEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDrugGenericPRBEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsDrugGenericPRBEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
