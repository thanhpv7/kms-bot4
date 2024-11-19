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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.RoomFacilityEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class RoomFacilityFactory implements FactoryBean<RoomFacilityEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public RoomFacilityEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public RoomFacilityEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public RoomFacilityEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for roomFacilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityWithNoRef before the main body here] end

		RoomFacilityEntity newEntity = new RoomFacilityEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Room Number here] off begin
		String randomStringForRoomNumber = mockNeat
				.strings()
				.get();
		newEntity.setRoomNumber(randomStringForRoomNumber);
		// % protected region % [Add customisation for Room Number here] end
		// % protected region % [Add customisation for Room Name here] off begin
		String randomStringForRoomName = mockNeat
				.strings()
				.get();
		newEntity.setRoomName(randomStringForRoomName);
		// % protected region % [Add customisation for Room Name here] end
		// % protected region % [Add customisation for Department here] off begin
		String randomStringForDepartment = mockNeat
				.strings()
				.get();
		newEntity.setDepartment(randomStringForDepartment);
		// % protected region % [Add customisation for Department here] end
		// % protected region % [Add customisation for Gender Allocation here] off begin
		String randomStringForGenderAllocation = mockNeat
				.strings()
				.get();
		newEntity.setGenderAllocation(randomStringForGenderAllocation);
		// % protected region % [Add customisation for Gender Allocation here] end
		// % protected region % [Add customisation for Location here] off begin
		String randomStringForLocation = mockNeat
				.strings()
				.get();
		newEntity.setLocation(randomStringForLocation);
		// % protected region % [Add customisation for Location here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Room Facility Picture here] off begin
		// % protected region % [Add customisation for Room Facility Picture here] end
		// % protected region % [Add customisation for Category here] off begin
		String randomStringForCategory = mockNeat
				.strings()
				.get();
		newEntity.setCategory(randomStringForCategory);
		// % protected region % [Add customisation for Category here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end

		// % protected region % [Apply any additional logic for roomFacilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for roomFacilityWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Facilities here] off begin
			// Outgoing one to many reference
			var bedFacilitiesFactory = new BedFacilityFactory();
			newEntity.setBedFacilities(Collections.singletonList(bedFacilitiesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Facilities here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Operating Room here] off begin
			// Outgoing one to many reference
			var operatingRoomFactory = new IntraoperativeRecordsFactory();
			newEntity.setOperatingRoom(Collections.singletonList(operatingRoomFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Operating Room here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Preoperative Rooms here] off begin
			// Outgoing one to many reference
			var preoperativeRoomsFactory = new PreoperativeRecordsFactory();
			newEntity.setPreoperativeRooms(Collections.singletonList(preoperativeRoomsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Preoperative Rooms here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Recovery Rooms here] off begin
			// Outgoing one to many reference
			var recoveryRoomsFactory = new PostOperativeDetailsFactory();
			newEntity.setRecoveryRooms(Collections.singletonList(recoveryRoomsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Recovery Rooms here] end

		}

		// % protected region % [Apply any additional logic for roomFacility with ref here] off begin
		// % protected region % [Apply any additional logic for roomFacility with ref here] end

		return newEntity;
	}

	@Override
	public Class<RoomFacilityEntity> getObjectType() {
		return RoomFacilityEntity.class;
	}
}