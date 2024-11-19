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
 * Guice module for BPJS PRB Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPRBDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPRBDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPRBDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPRBDetailEntityFactory bpjsPRBDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPRBDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPRBDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPRBDetailEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPRBDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailEntityFactory before the main body here] end

		BpjsPRBDetailEntityFactory entityFactory = new BpjsPRBDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPRBDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPRBDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPRBDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailEntityFactory after the main body here] end

		log.trace("Created BpjsPRBDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS PRB Detail entity with no references set.
	 */
	@Provides
	@Named("bpjsPRBDetailEntityWithNoRef")
	public BpjsPRBDetailEntity bpjsPRBDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPRBDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPRBDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPRBDetailEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPRBDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailWithNoRef before the main body here] end

		BpjsPRBDetailEntity newEntity = new BpjsPRBDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SRB No here] off begin
		String randomStringforSrbNo = mock
				.strings()
				.get();
		newEntity.setSrbNo(randomStringforSrbNo);
		// % protected region % [Add customisation for SRB No here] end
		// % protected region % [Add customisation for Drug Code here] off begin
		String randomStringforDrugCode = mock
				.strings()
				.get();
		newEntity.setDrugCode(randomStringforDrugCode);
		// % protected region % [Add customisation for Drug Code here] end
		// % protected region % [Add customisation for Drug Name here] off begin
		String randomStringforDrugName = mock
				.strings()
				.get();
		newEntity.setDrugName(randomStringforDrugName);
		// % protected region % [Add customisation for Drug Name here] end
		// % protected region % [Add customisation for Signa 1 here] off begin
		String randomStringforSigna1 = mock
				.strings()
				.get();
		newEntity.setSigna1(randomStringforSigna1);
		// % protected region % [Add customisation for Signa 1 here] end
		// % protected region % [Add customisation for Signa 2 here] off begin
		String randomStringforSigna2 = mock
				.strings()
				.get();
		newEntity.setSigna2(randomStringforSigna2);
		// % protected region % [Add customisation for Signa 2 here] end
		// % protected region % [Add customisation for Qty here] off begin
		String randomStringforQty = mock
				.strings()
				.get();
		newEntity.setQty(randomStringforQty);
		// % protected region % [Add customisation for Qty here] end

		// % protected region % [Apply any additional logic for bpjsPRBDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPRBDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS PRB Detail entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPRBDetailEntitiesWithNoRef")
	public Collection<BpjsPRBDetailEntity> bpjsPRBDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPRBDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPRBDetailEntitiesWithNoRef here] end
		BpjsPRBDetailEntityFactory bpjsPRBDetailEntityFactory
	) {
		log.trace("Creating entities of type BpjsPRBDetailEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPRBDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailEntitiesWithNoRef before the main body here] end

		Collection<BpjsPRBDetailEntity> newEntities = bpjsPRBDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPRBDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPRBDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS PRB Detail entity with all references set.
	 */
	@Provides
	@Named("bpjsPRBDetailEntityWithRefs")
	public BpjsPRBDetailEntity bpjsPRBDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPRBDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPRBDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPRBDetailEntity with references");

		// % protected region % [Apply any additional logic for bpjsPRBDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailEntityWithRefs before the main body here] end

		BpjsPRBDetailEntity bpjsPRBDetailEntity = injector.getInstance(Key.get(BpjsPRBDetailEntity.class, Names.named("bpjsPRBDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPRBDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPRBDetailEntity with references");

		return bpjsPRBDetailEntity;
	}

	/**
	 * Return a collection of BPJS PRB Detail entities with all references set.
	 */
	@Provides
	@Named("bpjsPRBDetailEntitiesWithRefs")
	public Collection<BpjsPRBDetailEntity> bpjsPRBDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPRBDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPRBDetailEntitiesWithRefs here] end
		BpjsPRBDetailEntityFactory bpjsPRBDetailEntityFactory
	) {
		log.trace("Creating entities of type BpjsPRBDetailEntity with references");

		// % protected region % [Apply any additional logic for bpjsPRBDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailEntitiesWithRefs before the main body here] end

		Collection<BpjsPRBDetailEntity> newEntities = bpjsPRBDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPRBDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPRBDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPRBDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
