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
 * Guice module for Task Dashboard used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TaskDashboardModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TaskDashboardModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TaskDashboardModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TaskDashboardEntityFactory taskDashboardEntityFactory(
			// % protected region % [Apply any additional injected arguments for taskDashboardEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for taskDashboardEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TaskDashboardEntityFactory");

		// % protected region % [Apply any additional logic for taskDashboardEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardEntityFactory before the main body here] end

		TaskDashboardEntityFactory entityFactory = new TaskDashboardEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TaskDashboardEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TaskDashboardEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for taskDashboardEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardEntityFactory after the main body here] end

		log.trace("Created TaskDashboardEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Task Dashboard entity with no references set.
	 */
	@Provides
	@Named("taskDashboardEntityWithNoRef")
	public TaskDashboardEntity taskDashboardEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for taskDashboardEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for taskDashboardEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TaskDashboardEntity with no reference");

		// % protected region % [Apply any additional logic for taskDashboardWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardWithNoRef before the main body here] end

		TaskDashboardEntity newEntity = new TaskDashboardEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kdppk here] off begin
		String randomStringforKdppk = mock
				.strings()
				.get();
		newEntity.setKdppk(randomStringforKdppk);
		// % protected region % [Add customisation for Kdppk here] end
		// % protected region % [Add customisation for Jumlah antrean here] off begin
		newEntity.setJumlahAntrean(mock.ints().get());
		// % protected region % [Add customisation for Jumlah antrean here] end
		// % protected region % [Add customisation for Namapoli here] off begin
		String randomStringforNamapoli = mock
				.strings()
				.get();
		newEntity.setNamapoli(randomStringforNamapoli);
		// % protected region % [Add customisation for Namapoli here] end
		// % protected region % [Add customisation for Nmppk here] off begin
		String randomStringforNmppk = mock
				.strings()
				.get();
		newEntity.setNmppk(randomStringforNmppk);
		// % protected region % [Add customisation for Nmppk here] end
		// % protected region % [Add customisation for Kodepoli here] off begin
		String randomStringforKodepoli = mock
				.strings()
				.get();
		newEntity.setKodepoli(randomStringforKodepoli);
		// % protected region % [Add customisation for Kodepoli here] end
		// % protected region % [Add customisation for Insert Date here] off begin
		newEntity.setInsertDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Insert Date here] end
		// % protected region % [Add customisation for tanggal here] off begin
		newEntity.setTanggal(OffsetDateTime.now());
		// % protected region % [Add customisation for tanggal here] end
		// % protected region % [Add customisation for Waktu Task1 here] off begin
		newEntity.setWaktuTask1(mock.ints().get());
		// % protected region % [Add customisation for Waktu Task1 here] end
		// % protected region % [Add customisation for Waktu Task2 here] off begin
		newEntity.setWaktuTask2(mock.ints().get());
		// % protected region % [Add customisation for Waktu Task2 here] end
		// % protected region % [Add customisation for Waktu Task3 here] off begin
		newEntity.setWaktuTask3(mock.ints().get());
		// % protected region % [Add customisation for Waktu Task3 here] end
		// % protected region % [Add customisation for Waktu Task4 here] off begin
		newEntity.setWaktuTask4(mock.ints().get());
		// % protected region % [Add customisation for Waktu Task4 here] end
		// % protected region % [Add customisation for Waktu Task5 here] off begin
		newEntity.setWaktuTask5(mock.ints().get());
		// % protected region % [Add customisation for Waktu Task5 here] end
		// % protected region % [Add customisation for Waktu Task6 here] off begin
		newEntity.setWaktuTask6(mock.ints().get());
		// % protected region % [Add customisation for Waktu Task6 here] end
		// % protected region % [Add customisation for avg waktu task1 here] off begin
		newEntity.setAvgWaktuTask1(mock.ints().get());
		// % protected region % [Add customisation for avg waktu task1 here] end
		// % protected region % [Add customisation for avg waktu task2 here] off begin
		newEntity.setAvgWaktuTask2(mock.ints().get());
		// % protected region % [Add customisation for avg waktu task2 here] end
		// % protected region % [Add customisation for avg waktu task3 here] off begin
		newEntity.setAvgWaktuTask3(mock.ints().get());
		// % protected region % [Add customisation for avg waktu task3 here] end
		// % protected region % [Add customisation for avg waktu task4 here] off begin
		newEntity.setAvgWaktuTask4(mock.ints().get());
		// % protected region % [Add customisation for avg waktu task4 here] end
		// % protected region % [Add customisation for avg waktu task5 here] off begin
		newEntity.setAvgWaktuTask5(mock.ints().get());
		// % protected region % [Add customisation for avg waktu task5 here] end
		// % protected region % [Add customisation for avg waktu task6 here] off begin
		newEntity.setAvgWaktuTask6(mock.ints().get());
		// % protected region % [Add customisation for avg waktu task6 here] end

		// % protected region % [Apply any additional logic for taskDashboardWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardWithNoRef after the main body here] end

		log.trace("Created entity of type TaskDashboardEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Task Dashboard entities with no reference at all.
	 */
	@Provides
	@Named("taskDashboardEntitiesWithNoRef")
	public Collection<TaskDashboardEntity> taskDashboardEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for taskDashboardEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for taskDashboardEntitiesWithNoRef here] end
		TaskDashboardEntityFactory taskDashboardEntityFactory
	) {
		log.trace("Creating entities of type TaskDashboardEntity with no reference");

		// % protected region % [Apply any additional logic for taskDashboardEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardEntitiesWithNoRef before the main body here] end

		Collection<TaskDashboardEntity> newEntities = taskDashboardEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for taskDashboardEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TaskDashboardEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Task Dashboard entity with all references set.
	 */
	@Provides
	@Named("taskDashboardEntityWithRefs")
	public TaskDashboardEntity taskDashboardEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for taskDashboardEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for taskDashboardEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TaskDashboardEntity with references");

		// % protected region % [Apply any additional logic for taskDashboardEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardEntityWithRefs before the main body here] end

		TaskDashboardEntity taskDashboardEntity = injector.getInstance(Key.get(TaskDashboardEntity.class, Names.named("taskDashboardEntityWithNoRef")));

		// % protected region % [Apply any additional logic for taskDashboardEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardEntityWithRefs after the main body here] end

		log.trace("Created entity of type TaskDashboardEntity with references");

		return taskDashboardEntity;
	}

	/**
	 * Return a collection of Task Dashboard entities with all references set.
	 */
	@Provides
	@Named("taskDashboardEntitiesWithRefs")
	public Collection<TaskDashboardEntity> taskDashboardEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for taskDashboardEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for taskDashboardEntitiesWithRefs here] end
		TaskDashboardEntityFactory taskDashboardEntityFactory
	) {
		log.trace("Creating entities of type TaskDashboardEntity with references");

		// % protected region % [Apply any additional logic for taskDashboardEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardEntitiesWithRefs before the main body here] end

		Collection<TaskDashboardEntity> newEntities = taskDashboardEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for taskDashboardEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TaskDashboardEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
