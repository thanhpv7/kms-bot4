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
 * Guice module for BPJS Treatment Room used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsTreatmentRoomModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsTreatmentRoomModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsTreatmentRoomModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsTreatmentRoomEntityFactory bpjsTreatmentRoomEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsTreatmentRoomEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsTreatmentRoomEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsTreatmentRoomEntityFactory");

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntityFactory before the main body here] end

		BpjsTreatmentRoomEntityFactory entityFactory = new BpjsTreatmentRoomEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsTreatmentRoomEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsTreatmentRoomEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntityFactory after the main body here] end

		log.trace("Created BpjsTreatmentRoomEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Treatment Room entity with no references set.
	 */
	@Provides
	@Named("bpjsTreatmentRoomEntityWithNoRef")
	public BpjsTreatmentRoomEntity bpjsTreatmentRoomEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentRoomEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentRoomEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsTreatmentRoomEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomWithNoRef before the main body here] end

		BpjsTreatmentRoomEntity newEntity = new BpjsTreatmentRoomEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for kode here] off begin
		String randomStringforKode = mock
				.strings()
				.get();
		newEntity.setKode(randomStringforKode);
		// % protected region % [Add customisation for kode here] end
		// % protected region % [Add customisation for nama here] off begin
		String randomStringforNama = mock
				.strings()
				.get();
		newEntity.setNama(randomStringforNama);
		// % protected region % [Add customisation for nama here] end

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsTreatmentRoomEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Treatment Room entities with no reference at all.
	 */
	@Provides
	@Named("bpjsTreatmentRoomEntitiesWithNoRef")
	public Collection<BpjsTreatmentRoomEntity> bpjsTreatmentRoomEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentRoomEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentRoomEntitiesWithNoRef here] end
		BpjsTreatmentRoomEntityFactory bpjsTreatmentRoomEntityFactory
	) {
		log.trace("Creating entities of type BpjsTreatmentRoomEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntitiesWithNoRef before the main body here] end

		Collection<BpjsTreatmentRoomEntity> newEntities = bpjsTreatmentRoomEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsTreatmentRoomEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Treatment Room entity with all references set.
	 */
	@Provides
	@Named("bpjsTreatmentRoomEntityWithRefs")
	public BpjsTreatmentRoomEntity bpjsTreatmentRoomEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentRoomEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentRoomEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsTreatmentRoomEntity with references");

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntityWithRefs before the main body here] end

		BpjsTreatmentRoomEntity bpjsTreatmentRoomEntity = injector.getInstance(Key.get(BpjsTreatmentRoomEntity.class, Names.named("bpjsTreatmentRoomEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsTreatmentRoomEntity with references");

		return bpjsTreatmentRoomEntity;
	}

	/**
	 * Return a collection of BPJS Treatment Room entities with all references set.
	 */
	@Provides
	@Named("bpjsTreatmentRoomEntitiesWithRefs")
	public Collection<BpjsTreatmentRoomEntity> bpjsTreatmentRoomEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentRoomEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentRoomEntitiesWithRefs here] end
		BpjsTreatmentRoomEntityFactory bpjsTreatmentRoomEntityFactory
	) {
		log.trace("Creating entities of type BpjsTreatmentRoomEntity with references");

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntitiesWithRefs before the main body here] end

		Collection<BpjsTreatmentRoomEntity> newEntities = bpjsTreatmentRoomEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentRoomEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsTreatmentRoomEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
