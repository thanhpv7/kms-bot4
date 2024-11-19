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
 * Guice module for BPJS List Task used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsListTaskModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsListTaskModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsListTaskModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsListTaskEntityFactory bpjsListTaskEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsListTaskEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsListTaskEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsListTaskEntityFactory");

		// % protected region % [Apply any additional logic for bpjsListTaskEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskEntityFactory before the main body here] end

		BpjsListTaskEntityFactory entityFactory = new BpjsListTaskEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsListTaskEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsListTaskEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsListTaskEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskEntityFactory after the main body here] end

		log.trace("Created BpjsListTaskEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS List Task entity with no references set.
	 */
	@Provides
	@Named("bpjsListTaskEntityWithNoRef")
	public BpjsListTaskEntity bpjsListTaskEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsListTaskEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsListTaskEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsListTaskEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsListTaskWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskWithNoRef before the main body here] end

		BpjsListTaskEntity newEntity = new BpjsListTaskEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kodebooking here] off begin
		String randomStringforKodebooking = mock
				.strings()
				.get();
		newEntity.setKodebooking(randomStringforKodebooking);
		// % protected region % [Add customisation for Kodebooking here] end
		// % protected region % [Add customisation for Taskname here] off begin
		String randomStringforTaskname = mock
				.strings()
				.get();
		newEntity.setTaskname(randomStringforTaskname);
		// % protected region % [Add customisation for Taskname here] end
		// % protected region % [Add customisation for TaskId here] off begin
		newEntity.setTaskid(mock.ints().get());
		// % protected region % [Add customisation for TaskId here] end
		// % protected region % [Add customisation for Waktu here] off begin
		String randomStringforWaktu = mock
				.strings()
				.get();
		newEntity.setWaktu(randomStringforWaktu);
		// % protected region % [Add customisation for Waktu here] end
		// % protected region % [Add customisation for WaktuRS here] off begin
		String randomStringforWakturs = mock
				.strings()
				.get();
		newEntity.setWakturs(randomStringforWakturs);
		// % protected region % [Add customisation for WaktuRS here] end

		// % protected region % [Apply any additional logic for bpjsListTaskWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsListTaskEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS List Task entities with no reference at all.
	 */
	@Provides
	@Named("bpjsListTaskEntitiesWithNoRef")
	public Collection<BpjsListTaskEntity> bpjsListTaskEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsListTaskEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsListTaskEntitiesWithNoRef here] end
		BpjsListTaskEntityFactory bpjsListTaskEntityFactory
	) {
		log.trace("Creating entities of type BpjsListTaskEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsListTaskEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskEntitiesWithNoRef before the main body here] end

		Collection<BpjsListTaskEntity> newEntities = bpjsListTaskEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsListTaskEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsListTaskEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS List Task entity with all references set.
	 */
	@Provides
	@Named("bpjsListTaskEntityWithRefs")
	public BpjsListTaskEntity bpjsListTaskEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsListTaskEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsListTaskEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsListTaskEntity with references");

		// % protected region % [Apply any additional logic for bpjsListTaskEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskEntityWithRefs before the main body here] end

		BpjsListTaskEntity bpjsListTaskEntity = injector.getInstance(Key.get(BpjsListTaskEntity.class, Names.named("bpjsListTaskEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsListTaskEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsListTaskEntity with references");

		return bpjsListTaskEntity;
	}

	/**
	 * Return a collection of BPJS List Task entities with all references set.
	 */
	@Provides
	@Named("bpjsListTaskEntitiesWithRefs")
	public Collection<BpjsListTaskEntity> bpjsListTaskEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsListTaskEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsListTaskEntitiesWithRefs here] end
		BpjsListTaskEntityFactory bpjsListTaskEntityFactory
	) {
		log.trace("Creating entities of type BpjsListTaskEntity with references");

		// % protected region % [Apply any additional logic for bpjsListTaskEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskEntitiesWithRefs before the main body here] end

		Collection<BpjsListTaskEntity> newEntities = bpjsListTaskEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsListTaskEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListTaskEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsListTaskEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
