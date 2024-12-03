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
 * Guice module for Doctor Schedule used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DoctorScheduleModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DoctorScheduleModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DoctorScheduleModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DoctorScheduleEntityFactory doctorScheduleEntityFactory(
			// % protected region % [Apply any additional injected arguments for doctorScheduleEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for doctorScheduleEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DoctorScheduleEntityFactory");

		// % protected region % [Apply any additional logic for doctorScheduleEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleEntityFactory before the main body here] end

		DoctorScheduleEntityFactory entityFactory = new DoctorScheduleEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DoctorScheduleEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DoctorScheduleEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for doctorScheduleEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleEntityFactory after the main body here] end

		log.trace("Created DoctorScheduleEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Doctor Schedule entity with no references set.
	 */
	@Provides
	@Named("doctorScheduleEntityWithNoRef")
	public DoctorScheduleEntity doctorScheduleEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for doctorScheduleEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for doctorScheduleEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DoctorScheduleEntity with no reference");

		// % protected region % [Apply any additional logic for doctorScheduleWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleWithNoRef before the main body here] end

		DoctorScheduleEntity newEntity = new DoctorScheduleEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] off begin
		newEntity.setStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] end
		// % protected region % [Add customisation for End Date Time here] off begin
		newEntity.setEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date Time here] end
		// % protected region % [Add customisation for Interval in minutes here] off begin
		newEntity.setIntervalInMinutes(mock.ints().get());
		// % protected region % [Add customisation for Interval in minutes here] end
		// % protected region % [Add customisation for Location here] off begin
		String randomStringforLocation = mock
				.strings()
				.get();
		newEntity.setLocation(randomStringforLocation);
		// % protected region % [Add customisation for Location here] end
		// % protected region % [Add customisation for Scheduler Type here] off begin
		String randomStringforSchedulerType = mock
				.strings()
				.get();
		newEntity.setSchedulerType(randomStringforSchedulerType);
		// % protected region % [Add customisation for Scheduler Type here] end
		// % protected region % [Add customisation for Monday here] off begin
		newEntity.setMonday(mock.bools().get());
		// % protected region % [Add customisation for Monday here] end
		// % protected region % [Add customisation for Tuesday here] off begin
		newEntity.setTuesday(mock.bools().get());
		// % protected region % [Add customisation for Tuesday here] end
		// % protected region % [Add customisation for Wednesday here] off begin
		newEntity.setWednesday(mock.bools().get());
		// % protected region % [Add customisation for Wednesday here] end
		// % protected region % [Add customisation for Thursday here] off begin
		newEntity.setThursday(mock.bools().get());
		// % protected region % [Add customisation for Thursday here] end
		// % protected region % [Add customisation for Friday here] off begin
		newEntity.setFriday(mock.bools().get());
		// % protected region % [Add customisation for Friday here] end
		// % protected region % [Add customisation for Saturday here] off begin
		newEntity.setSaturday(mock.bools().get());
		// % protected region % [Add customisation for Saturday here] end
		// % protected region % [Add customisation for Sunday here] off begin
		newEntity.setSunday(mock.bools().get());
		// % protected region % [Add customisation for Sunday here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.strings()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Training here] off begin
		String randomStringforTraining = mock
				.strings()
				.get();
		newEntity.setTraining(randomStringforTraining);
		// % protected region % [Add customisation for Training here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for Shift here] off begin
		String randomStringforShift = mock
				.strings()
				.get();
		newEntity.setShift(randomStringforShift);
		// % protected region % [Add customisation for Shift here] end
		// % protected region % [Add customisation for Intervals here] off begin
		newEntity.setIntervals(mock.ints().get());
		// % protected region % [Add customisation for Intervals here] end
		// % protected region % [Add customisation for Repetition here] off begin
		newEntity.setRepetition(mock.bools().get());
		// % protected region % [Add customisation for Repetition here] end
		// % protected region % [Add customisation for Number Of Repetition here] off begin
		newEntity.setNumberOfRepetition(mock.ints().get());
		// % protected region % [Add customisation for Number Of Repetition here] end
		// % protected region % [Add customisation for Final Schedule here] off begin
		newEntity.setFinalSchedule(OffsetDateTime.now());
		// % protected region % [Add customisation for Final Schedule here] end

		// % protected region % [Apply any additional logic for doctorScheduleWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleWithNoRef after the main body here] end

		log.trace("Created entity of type DoctorScheduleEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Doctor Schedule entities with no reference at all.
	 */
	@Provides
	@Named("doctorScheduleEntitiesWithNoRef")
	public Collection<DoctorScheduleEntity> doctorScheduleEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for doctorScheduleEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for doctorScheduleEntitiesWithNoRef here] end
		DoctorScheduleEntityFactory doctorScheduleEntityFactory
	) {
		log.trace("Creating entities of type DoctorScheduleEntity with no reference");

		// % protected region % [Apply any additional logic for doctorScheduleEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleEntitiesWithNoRef before the main body here] end

		Collection<DoctorScheduleEntity> newEntities = doctorScheduleEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for doctorScheduleEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DoctorScheduleEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Doctor Schedule entity with all references set.
	 */
	@Provides
	@Named("doctorScheduleEntityWithRefs")
	public DoctorScheduleEntity doctorScheduleEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for doctorScheduleEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for doctorScheduleEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DoctorScheduleEntity with references");

		// % protected region % [Apply any additional logic for doctorScheduleEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleEntityWithRefs before the main body here] end

		DoctorScheduleEntity doctorScheduleEntity = injector.getInstance(Key.get(DoctorScheduleEntity.class, Names.named("doctorScheduleEntityWithNoRef")));

		// % protected region % [Apply any additional logic for doctorScheduleEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleEntityWithRefs after the main body here] end

		log.trace("Created entity of type DoctorScheduleEntity with references");

		return doctorScheduleEntity;
	}

	/**
	 * Return a collection of Doctor Schedule entities with all references set.
	 */
	@Provides
	@Named("doctorScheduleEntitiesWithRefs")
	public Collection<DoctorScheduleEntity> doctorScheduleEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for doctorScheduleEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for doctorScheduleEntitiesWithRefs here] end
		DoctorScheduleEntityFactory doctorScheduleEntityFactory
	) {
		log.trace("Creating entities of type DoctorScheduleEntity with references");

		// % protected region % [Apply any additional logic for doctorScheduleEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleEntitiesWithRefs before the main body here] end

		Collection<DoctorScheduleEntity> newEntities = doctorScheduleEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for doctorScheduleEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for doctorScheduleEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DoctorScheduleEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
