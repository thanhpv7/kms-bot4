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
import kmsweb.entities.DoctorScheduleEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class DoctorScheduleFactory implements FactoryBean<DoctorScheduleEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public DoctorScheduleEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public DoctorScheduleEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public DoctorScheduleEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for doctorScheduleWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleWithNoRef before the main body here] end

		DoctorScheduleEntity newEntity = new DoctorScheduleEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] off begin
		newEntity.setStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] end
		// % protected region % [Add customisation for End Date Time here] off begin
		newEntity.setEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date Time here] end
		// % protected region % [Add customisation for Interval in minutes here] off begin
		newEntity.setIntervalInMinutes(mockNeat.ints().get());
		// % protected region % [Add customisation for Interval in minutes here] end
		// % protected region % [Add customisation for Location here] off begin
		String randomStringForLocation = mockNeat
				.strings()
				.get();
		newEntity.setLocation(randomStringForLocation);
		// % protected region % [Add customisation for Location here] end
		// % protected region % [Add customisation for Scheduler Type here] off begin
		String randomStringForSchedulerType = mockNeat
				.strings()
				.get();
		newEntity.setSchedulerType(randomStringForSchedulerType);
		// % protected region % [Add customisation for Scheduler Type here] end
		// % protected region % [Add customisation for Monday here] off begin
		newEntity.setMonday(mockNeat.bools().get());
		// % protected region % [Add customisation for Monday here] end
		// % protected region % [Add customisation for Tuesday here] off begin
		newEntity.setTuesday(mockNeat.bools().get());
		// % protected region % [Add customisation for Tuesday here] end
		// % protected region % [Add customisation for Wednesday here] off begin
		newEntity.setWednesday(mockNeat.bools().get());
		// % protected region % [Add customisation for Wednesday here] end
		// % protected region % [Add customisation for Thursday here] off begin
		newEntity.setThursday(mockNeat.bools().get());
		// % protected region % [Add customisation for Thursday here] end
		// % protected region % [Add customisation for Friday here] off begin
		newEntity.setFriday(mockNeat.bools().get());
		// % protected region % [Add customisation for Friday here] end
		// % protected region % [Add customisation for Saturday here] off begin
		newEntity.setSaturday(mockNeat.bools().get());
		// % protected region % [Add customisation for Saturday here] end
		// % protected region % [Add customisation for Sunday here] off begin
		newEntity.setSunday(mockNeat.bools().get());
		// % protected region % [Add customisation for Sunday here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringForEmail = mockNeat
				.strings()
				.get();
		newEntity.setEmail(randomStringForEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Training here] off begin
		String randomStringForTraining = mockNeat
				.strings()
				.get();
		newEntity.setTraining(randomStringForTraining);
		// % protected region % [Add customisation for Training here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for Shift here] off begin
		String randomStringForShift = mockNeat
				.strings()
				.get();
		newEntity.setShift(randomStringForShift);
		// % protected region % [Add customisation for Shift here] end
		// % protected region % [Add customisation for Intervals here] off begin
		newEntity.setIntervals(mockNeat.ints().get());
		// % protected region % [Add customisation for Intervals here] end
		// % protected region % [Add customisation for Repetition here] off begin
		newEntity.setRepetition(mockNeat.bools().get());
		// % protected region % [Add customisation for Repetition here] end
		// % protected region % [Add customisation for Number Of Repetition here] off begin
		newEntity.setNumberOfRepetition(mockNeat.ints().get());
		// % protected region % [Add customisation for Number Of Repetition here] end
		// % protected region % [Add customisation for Final Schedule here] off begin
		newEntity.setFinalSchedule(OffsetDateTime.now());
		// % protected region % [Add customisation for Final Schedule here] end

		// % protected region % [Apply any additional logic for doctorScheduleWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyService here] off begin
			var serviceFactory = new ServiceFactory();
			newEntity.setService(serviceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyService here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

		}

		// % protected region % [Apply any additional logic for doctorSchedule with ref here] off begin
		// % protected region % [Apply any additional logic for doctorSchedule with ref here] end

		return newEntity;
	}

	@Override
	public Class<DoctorScheduleEntity> getObjectType() {
		return DoctorScheduleEntity.class;
	}
}