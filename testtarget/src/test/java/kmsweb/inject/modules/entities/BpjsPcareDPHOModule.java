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
 * Guice module for BPJS Pcare DPHO used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPcareDPHOModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPcareDPHOModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPcareDPHOModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPcareDPHOEntityFactory bpjsPcareDPHOEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPcareDPHOEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPcareDPHOEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPcareDPHOEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntityFactory before the main body here] end

		BpjsPcareDPHOEntityFactory entityFactory = new BpjsPcareDPHOEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPcareDPHOEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPcareDPHOEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntityFactory after the main body here] end

		log.trace("Created BpjsPcareDPHOEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Pcare DPHO entity with no references set.
	 */
	@Provides
	@Named("bpjsPcareDPHOEntityWithNoRef")
	public BpjsPcareDPHOEntity bpjsPcareDPHOEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareDPHOEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareDPHOEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPcareDPHOEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareDPHOWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOWithNoRef before the main body here] end

		BpjsPcareDPHOEntity newEntity = new BpjsPcareDPHOEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for kdObat here] off begin
		String randomStringforKdobat = mock
				.strings()
				.get();
		newEntity.setKdobat(randomStringforKdobat);
		// % protected region % [Add customisation for kdObat here] end
		// % protected region % [Add customisation for nmObat here] off begin
		String randomStringforNmobat = mock
				.strings()
				.get();
		newEntity.setNmobat(randomStringforNmobat);
		// % protected region % [Add customisation for nmObat here] end
		// % protected region % [Add customisation for Sedia here] off begin
		String randomStringforSedia = mock
				.strings()
				.get();
		newEntity.setSedia(randomStringforSedia);
		// % protected region % [Add customisation for Sedia here] end

		// % protected region % [Apply any additional logic for bpjsPcareDPHOWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPcareDPHOEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Pcare DPHO entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPcareDPHOEntitiesWithNoRef")
	public Collection<BpjsPcareDPHOEntity> bpjsPcareDPHOEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareDPHOEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareDPHOEntitiesWithNoRef here] end
		BpjsPcareDPHOEntityFactory bpjsPcareDPHOEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareDPHOEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntitiesWithNoRef before the main body here] end

		Collection<BpjsPcareDPHOEntity> newEntities = bpjsPcareDPHOEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPcareDPHOEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Pcare DPHO entity with all references set.
	 */
	@Provides
	@Named("bpjsPcareDPHOEntityWithRefs")
	public BpjsPcareDPHOEntity bpjsPcareDPHOEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareDPHOEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareDPHOEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPcareDPHOEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntityWithRefs before the main body here] end

		BpjsPcareDPHOEntity bpjsPcareDPHOEntity = injector.getInstance(Key.get(BpjsPcareDPHOEntity.class, Names.named("bpjsPcareDPHOEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPcareDPHOEntity with references");

		return bpjsPcareDPHOEntity;
	}

	/**
	 * Return a collection of BPJS Pcare DPHO entities with all references set.
	 */
	@Provides
	@Named("bpjsPcareDPHOEntitiesWithRefs")
	public Collection<BpjsPcareDPHOEntity> bpjsPcareDPHOEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareDPHOEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareDPHOEntitiesWithRefs here] end
		BpjsPcareDPHOEntityFactory bpjsPcareDPHOEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareDPHOEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntitiesWithRefs before the main body here] end

		Collection<BpjsPcareDPHOEntity> newEntities = bpjsPcareDPHOEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareDPHOEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPcareDPHOEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
