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
 * Guice module for BPJS Pcare Kesadaran used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPcareKesadaranModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPcareKesadaranModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPcareKesadaranModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPcareKesadaranEntityFactory bpjsPcareKesadaranEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPcareKesadaranEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPcareKesadaranEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPcareKesadaranEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntityFactory before the main body here] end

		BpjsPcareKesadaranEntityFactory entityFactory = new BpjsPcareKesadaranEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPcareKesadaranEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPcareKesadaranEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntityFactory after the main body here] end

		log.trace("Created BpjsPcareKesadaranEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Pcare Kesadaran entity with no references set.
	 */
	@Provides
	@Named("bpjsPcareKesadaranEntityWithNoRef")
	public BpjsPcareKesadaranEntity bpjsPcareKesadaranEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKesadaranEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKesadaranEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPcareKesadaranEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranWithNoRef before the main body here] end

		BpjsPcareKesadaranEntity newEntity = new BpjsPcareKesadaranEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for kdSadar here] off begin
		String randomStringforKdsadar = mock
				.strings()
				.get();
		newEntity.setKdsadar(randomStringforKdsadar);
		// % protected region % [Add customisation for kdSadar here] end
		// % protected region % [Add customisation for nmSadar here] off begin
		String randomStringforNmsadar = mock
				.strings()
				.get();
		newEntity.setNmsadar(randomStringforNmsadar);
		// % protected region % [Add customisation for nmSadar here] end
		// % protected region % [Add customisation for Kesadaran Internal here] off begin
		String randomStringforKesadaranInternal = mock
				.strings()
				.get();
		newEntity.setKesadaranInternal(randomStringforKesadaranInternal);
		// % protected region % [Add customisation for Kesadaran Internal here] end

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPcareKesadaranEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Kesadaran entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPcareKesadaranEntitiesWithNoRef")
	public Collection<BpjsPcareKesadaranEntity> bpjsPcareKesadaranEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKesadaranEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKesadaranEntitiesWithNoRef here] end
		BpjsPcareKesadaranEntityFactory bpjsPcareKesadaranEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareKesadaranEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntitiesWithNoRef before the main body here] end

		Collection<BpjsPcareKesadaranEntity> newEntities = bpjsPcareKesadaranEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPcareKesadaranEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Pcare Kesadaran entity with all references set.
	 */
	@Provides
	@Named("bpjsPcareKesadaranEntityWithRefs")
	public BpjsPcareKesadaranEntity bpjsPcareKesadaranEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKesadaranEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKesadaranEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPcareKesadaranEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntityWithRefs before the main body here] end

		BpjsPcareKesadaranEntity bpjsPcareKesadaranEntity = injector.getInstance(Key.get(BpjsPcareKesadaranEntity.class, Names.named("bpjsPcareKesadaranEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPcareKesadaranEntity with references");

		return bpjsPcareKesadaranEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Kesadaran entities with all references set.
	 */
	@Provides
	@Named("bpjsPcareKesadaranEntitiesWithRefs")
	public Collection<BpjsPcareKesadaranEntity> bpjsPcareKesadaranEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKesadaranEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKesadaranEntitiesWithRefs here] end
		BpjsPcareKesadaranEntityFactory bpjsPcareKesadaranEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareKesadaranEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntitiesWithRefs before the main body here] end

		Collection<BpjsPcareKesadaranEntity> newEntities = bpjsPcareKesadaranEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKesadaranEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPcareKesadaranEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
