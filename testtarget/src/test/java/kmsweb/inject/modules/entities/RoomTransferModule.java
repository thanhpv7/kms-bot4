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
 * Guice module for Room Transfer used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class RoomTransferModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring RoomTransferModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured RoomTransferModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public RoomTransferEntityFactory roomTransferEntityFactory(
			// % protected region % [Apply any additional injected arguments for roomTransferEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for roomTransferEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating RoomTransferEntityFactory");

		// % protected region % [Apply any additional logic for roomTransferEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferEntityFactory before the main body here] end

		RoomTransferEntityFactory entityFactory = new RoomTransferEntityFactory(
				// % protected region % [Apply any additional constructor arguments for RoomTransferEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for RoomTransferEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for roomTransferEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferEntityFactory after the main body here] end

		log.trace("Created RoomTransferEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Room Transfer entity with no references set.
	 */
	@Provides
	@Named("roomTransferEntityWithNoRef")
	public RoomTransferEntity roomTransferEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for roomTransferEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for roomTransferEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type RoomTransferEntity with no reference");

		// % protected region % [Apply any additional logic for roomTransferWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferWithNoRef before the main body here] end

		RoomTransferEntity newEntity = new RoomTransferEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] off begin
		newEntity.setStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] end
		// % protected region % [Add customisation for End Date Time here] off begin
		newEntity.setEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date Time here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Transferring Staff Name here] off begin
		String randomStringforTransferringStaffName = mock
				.strings()
				.get();
		newEntity.setTransferringStaffName(randomStringforTransferringStaffName);
		// % protected region % [Add customisation for Transferring Staff Name here] end

		// % protected region % [Apply any additional logic for roomTransferWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferWithNoRef after the main body here] end

		log.trace("Created entity of type RoomTransferEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Room Transfer entities with no reference at all.
	 */
	@Provides
	@Named("roomTransferEntitiesWithNoRef")
	public Collection<RoomTransferEntity> roomTransferEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for roomTransferEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for roomTransferEntitiesWithNoRef here] end
		RoomTransferEntityFactory roomTransferEntityFactory
	) {
		log.trace("Creating entities of type RoomTransferEntity with no reference");

		// % protected region % [Apply any additional logic for roomTransferEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferEntitiesWithNoRef before the main body here] end

		Collection<RoomTransferEntity> newEntities = roomTransferEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for roomTransferEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type RoomTransferEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Room Transfer entity with all references set.
	 */
	@Provides
	@Named("roomTransferEntityWithRefs")
	public RoomTransferEntity roomTransferEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for roomTransferEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for roomTransferEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type RoomTransferEntity with references");

		// % protected region % [Apply any additional logic for roomTransferEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferEntityWithRefs before the main body here] end

		RoomTransferEntity roomTransferEntity = injector.getInstance(Key.get(RoomTransferEntity.class, Names.named("roomTransferEntityWithNoRef")));

		// % protected region % [Apply any additional logic for roomTransferEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferEntityWithRefs after the main body here] end

		log.trace("Created entity of type RoomTransferEntity with references");

		return roomTransferEntity;
	}

	/**
	 * Return a collection of Room Transfer entities with all references set.
	 */
	@Provides
	@Named("roomTransferEntitiesWithRefs")
	public Collection<RoomTransferEntity> roomTransferEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for roomTransferEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for roomTransferEntitiesWithRefs here] end
		RoomTransferEntityFactory roomTransferEntityFactory
	) {
		log.trace("Creating entities of type RoomTransferEntity with references");

		// % protected region % [Apply any additional logic for roomTransferEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferEntitiesWithRefs before the main body here] end

		Collection<RoomTransferEntity> newEntities = roomTransferEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for roomTransferEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for roomTransferEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type RoomTransferEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
