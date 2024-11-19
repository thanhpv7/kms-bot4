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
package kmsweb.repositories;

import kmsweb.entities.TaskDashboardEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface TaskDashboardRepository extends AbstractRepository<TaskDashboardEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Kdppk.
	 *
	 * @param kdppk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kdppk
	 */
	List<TaskDashboardEntity> findByKdppk(@NotNull String kdppk);
	/**
	 * Return an entity or a list of entities that have the given attribute Jumlah antrean.
	 *
	 * @param jumlahAntrean the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Jumlah antrean
	 */
	List<TaskDashboardEntity> findByJumlahAntrean(@NotNull Integer jumlahAntrean);
	/**
	 * Return an entity or a list of entities that have the given attribute Namapoli.
	 *
	 * @param namapoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Namapoli
	 */
	List<TaskDashboardEntity> findByNamapoli(@NotNull String namapoli);
	/**
	 * Return an entity or a list of entities that have the given attribute Nmppk.
	 *
	 * @param nmppk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nmppk
	 */
	List<TaskDashboardEntity> findByNmppk(@NotNull String nmppk);
	/**
	 * Return an entity or a list of entities that have the given attribute Kodepoli.
	 *
	 * @param kodepoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kodepoli
	 */
	List<TaskDashboardEntity> findByKodepoli(@NotNull String kodepoli);
	/**
	 * Return an entity or a list of entities that have the given attribute Insert Date.
	 *
	 * @param insertDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Insert Date
	 */
	List<TaskDashboardEntity> findByInsertDate(@NotNull OffsetDateTime insertDate);
	/**
	 * Return an entity or a list of entities that have the given attribute tanggal.
	 *
	 * @param tanggal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tanggal
	 */
	List<TaskDashboardEntity> findByTanggal(@NotNull OffsetDateTime tanggal);
	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task1.
	 *
	 * @param waktuTask1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task1
	 */
	List<TaskDashboardEntity> findByWaktuTask1(@NotNull Integer waktuTask1);
	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task2.
	 *
	 * @param waktuTask2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task2
	 */
	List<TaskDashboardEntity> findByWaktuTask2(@NotNull Integer waktuTask2);
	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task3.
	 *
	 * @param waktuTask3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task3
	 */
	List<TaskDashboardEntity> findByWaktuTask3(@NotNull Integer waktuTask3);
	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task4.
	 *
	 * @param waktuTask4 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task4
	 */
	List<TaskDashboardEntity> findByWaktuTask4(@NotNull Integer waktuTask4);
	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task5.
	 *
	 * @param waktuTask5 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task5
	 */
	List<TaskDashboardEntity> findByWaktuTask5(@NotNull Integer waktuTask5);
	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task6.
	 *
	 * @param waktuTask6 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task6
	 */
	List<TaskDashboardEntity> findByWaktuTask6(@NotNull Integer waktuTask6);
	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task1.
	 *
	 * @param avgWaktuTask1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task1
	 */
	List<TaskDashboardEntity> findByAvgWaktuTask1(@NotNull Integer avgWaktuTask1);
	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task2.
	 *
	 * @param avgWaktuTask2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task2
	 */
	List<TaskDashboardEntity> findByAvgWaktuTask2(@NotNull Integer avgWaktuTask2);
	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task3.
	 *
	 * @param avgWaktuTask3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task3
	 */
	List<TaskDashboardEntity> findByAvgWaktuTask3(@NotNull Integer avgWaktuTask3);
	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task4.
	 *
	 * @param avgWaktuTask4 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task4
	 */
	List<TaskDashboardEntity> findByAvgWaktuTask4(@NotNull Integer avgWaktuTask4);
	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task5.
	 *
	 * @param avgWaktuTask5 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task5
	 */
	List<TaskDashboardEntity> findByAvgWaktuTask5(@NotNull Integer avgWaktuTask5);
	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task6.
	 *
	 * @param avgWaktuTask6 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task6
	 */
	List<TaskDashboardEntity> findByAvgWaktuTask6(@NotNull Integer avgWaktuTask6);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TaskDashboardEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TaskDashboardEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}