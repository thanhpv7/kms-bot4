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
 * Guice module for Room Facility used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class RoomFacilityModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring RoomFacilityModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured RoomFacilityModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public RoomFacilityEntityFactory roomFacilityEntityFactory(
			// % protected region % [Apply any additional injected arguments for roomFacilityEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for roomFacilityEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating RoomFacilityEntityFactory");

		// % protected region % [Apply any additional logic for roomFacilityEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityEntityFactory before the main body here] end

		RoomFacilityEntityFactory entityFactory = new RoomFacilityEntityFactory(
				// % protected region % [Apply any additional constructor arguments for RoomFacilityEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for RoomFacilityEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for roomFacilityEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityEntityFactory after the main body here] end

		log.trace("Created RoomFacilityEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Room Facility entity with no references set.
	 */
	@Provides
	@Named("roomFacilityEntityWithNoRef")
	public RoomFacilityEntity roomFacilityEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for roomFacilityEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for roomFacilityEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type RoomFacilityEntity with no reference");

		// % protected region % [Apply any additional logic for roomFacilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityWithNoRef before the main body here] end

		RoomFacilityEntity newEntity = new RoomFacilityEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Room Number here] off begin
		String randomStringforRoomNumber = mock
				.strings()
				.get();
		newEntity.setRoomNumber(randomStringforRoomNumber);
		// % protected region % [Add customisation for Room Number here] end
		// % protected region % [Add customisation for Room Name here] off begin
		String randomStringforRoomName = mock
				.strings()
				.get();
		newEntity.setRoomName(randomStringforRoomName);
		// % protected region % [Add customisation for Room Name here] end
		// % protected region % [Add customisation for Department here] off begin
		String randomStringforDepartment = mock
				.strings()
				.get();
		newEntity.setDepartment(randomStringforDepartment);
		// % protected region % [Add customisation for Department here] end
		// % protected region % [Add customisation for Gender Allocation here] off begin
		String randomStringforGenderAllocation = mock
				.strings()
				.get();
		newEntity.setGenderAllocation(randomStringforGenderAllocation);
		// % protected region % [Add customisation for Gender Allocation here] end
		// % protected region % [Add customisation for Location here] off begin
		String randomStringforLocation = mock
				.strings()
				.get();
		newEntity.setLocation(randomStringforLocation);
		// % protected region % [Add customisation for Location here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Room Facility Picture here] off begin
		// % protected region % [Add customisation for Room Facility Picture here] end
		// % protected region % [Add customisation for Category here] off begin
		String randomStringforCategory = mock
				.strings()
				.get();
		newEntity.setCategory(randomStringforCategory);
		// % protected region % [Add customisation for Category here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end

		// % protected region % [Apply any additional logic for roomFacilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityWithNoRef after the main body here] end

		log.trace("Created entity of type RoomFacilityEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Room Facility entities with no reference at all.
	 */
	@Provides
	@Named("roomFacilityEntitiesWithNoRef")
	public Collection<RoomFacilityEntity> roomFacilityEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for roomFacilityEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for roomFacilityEntitiesWithNoRef here] end
		RoomFacilityEntityFactory roomFacilityEntityFactory
	) {
		log.trace("Creating entities of type RoomFacilityEntity with no reference");

		// % protected region % [Apply any additional logic for roomFacilityEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityEntitiesWithNoRef before the main body here] end

		Collection<RoomFacilityEntity> newEntities = roomFacilityEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for roomFacilityEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type RoomFacilityEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Room Facility entity with all references set.
	 */
	@Provides
	@Named("roomFacilityEntityWithRefs")
	public RoomFacilityEntity roomFacilityEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for roomFacilityEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for roomFacilityEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type RoomFacilityEntity with references");

		// % protected region % [Apply any additional logic for roomFacilityEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityEntityWithRefs before the main body here] end

		RoomFacilityEntity roomFacilityEntity = injector.getInstance(Key.get(RoomFacilityEntity.class, Names.named("roomFacilityEntityWithNoRef")));

		// % protected region % [Apply any additional logic for roomFacilityEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityEntityWithRefs after the main body here] end

		log.trace("Created entity of type RoomFacilityEntity with references");

		return roomFacilityEntity;
	}

	/**
	 * Return a collection of Room Facility entities with all references set.
	 */
	@Provides
	@Named("roomFacilityEntitiesWithRefs")
	public Collection<RoomFacilityEntity> roomFacilityEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for roomFacilityEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for roomFacilityEntitiesWithRefs here] end
		RoomFacilityEntityFactory roomFacilityEntityFactory
	) {
		log.trace("Creating entities of type RoomFacilityEntity with references");

		// % protected region % [Apply any additional logic for roomFacilityEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityEntitiesWithRefs before the main body here] end

		Collection<RoomFacilityEntity> newEntities = roomFacilityEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for roomFacilityEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type RoomFacilityEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
