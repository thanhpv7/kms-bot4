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
import kmsweb.entities.TaskDashboardEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class TaskDashboardFactory implements FactoryBean<TaskDashboardEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public TaskDashboardEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public TaskDashboardEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public TaskDashboardEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for taskDashboardWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardWithNoRef before the main body here] end

		TaskDashboardEntity newEntity = new TaskDashboardEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kdppk here] off begin
		String randomStringForKdppk = mockNeat
				.strings()
				.get();
		newEntity.setKdppk(randomStringForKdppk);
		// % protected region % [Add customisation for Kdppk here] end
		// % protected region % [Add customisation for Jumlah antrean here] off begin
		newEntity.setJumlahAntrean(mockNeat.ints().get());
		// % protected region % [Add customisation for Jumlah antrean here] end
		// % protected region % [Add customisation for Namapoli here] off begin
		String randomStringForNamapoli = mockNeat
				.strings()
				.get();
		newEntity.setNamapoli(randomStringForNamapoli);
		// % protected region % [Add customisation for Namapoli here] end
		// % protected region % [Add customisation for Nmppk here] off begin
		String randomStringForNmppk = mockNeat
				.strings()
				.get();
		newEntity.setNmppk(randomStringForNmppk);
		// % protected region % [Add customisation for Nmppk here] end
		// % protected region % [Add customisation for Kodepoli here] off begin
		String randomStringForKodepoli = mockNeat
				.strings()
				.get();
		newEntity.setKodepoli(randomStringForKodepoli);
		// % protected region % [Add customisation for Kodepoli here] end
		// % protected region % [Add customisation for Insert Date here] off begin
		newEntity.setInsertDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Insert Date here] end
		// % protected region % [Add customisation for tanggal here] off begin
		newEntity.setTanggal(OffsetDateTime.now());
		// % protected region % [Add customisation for tanggal here] end
		// % protected region % [Add customisation for Waktu Task1 here] off begin
		newEntity.setWaktuTask1(mockNeat.ints().get());
		// % protected region % [Add customisation for Waktu Task1 here] end
		// % protected region % [Add customisation for Waktu Task2 here] off begin
		newEntity.setWaktuTask2(mockNeat.ints().get());
		// % protected region % [Add customisation for Waktu Task2 here] end
		// % protected region % [Add customisation for Waktu Task3 here] off begin
		newEntity.setWaktuTask3(mockNeat.ints().get());
		// % protected region % [Add customisation for Waktu Task3 here] end
		// % protected region % [Add customisation for Waktu Task4 here] off begin
		newEntity.setWaktuTask4(mockNeat.ints().get());
		// % protected region % [Add customisation for Waktu Task4 here] end
		// % protected region % [Add customisation for Waktu Task5 here] off begin
		newEntity.setWaktuTask5(mockNeat.ints().get());
		// % protected region % [Add customisation for Waktu Task5 here] end
		// % protected region % [Add customisation for Waktu Task6 here] off begin
		newEntity.setWaktuTask6(mockNeat.ints().get());
		// % protected region % [Add customisation for Waktu Task6 here] end
		// % protected region % [Add customisation for avg waktu task1 here] off begin
		newEntity.setAvgWaktuTask1(mockNeat.ints().get());
		// % protected region % [Add customisation for avg waktu task1 here] end
		// % protected region % [Add customisation for avg waktu task2 here] off begin
		newEntity.setAvgWaktuTask2(mockNeat.ints().get());
		// % protected region % [Add customisation for avg waktu task2 here] end
		// % protected region % [Add customisation for avg waktu task3 here] off begin
		newEntity.setAvgWaktuTask3(mockNeat.ints().get());
		// % protected region % [Add customisation for avg waktu task3 here] end
		// % protected region % [Add customisation for avg waktu task4 here] off begin
		newEntity.setAvgWaktuTask4(mockNeat.ints().get());
		// % protected region % [Add customisation for avg waktu task4 here] end
		// % protected region % [Add customisation for avg waktu task5 here] off begin
		newEntity.setAvgWaktuTask5(mockNeat.ints().get());
		// % protected region % [Add customisation for avg waktu task5 here] end
		// % protected region % [Add customisation for avg waktu task6 here] off begin
		newEntity.setAvgWaktuTask6(mockNeat.ints().get());
		// % protected region % [Add customisation for avg waktu task6 here] end

		// % protected region % [Apply any additional logic for taskDashboardWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for taskDashboardWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<TaskDashboardEntity> getObjectType() {
		return TaskDashboardEntity.class;
	}
}