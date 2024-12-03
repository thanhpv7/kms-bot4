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

import kmsweb.entities.DoctorScheduleEntity;
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
public interface DoctorScheduleRepository extends AbstractRepository<DoctorScheduleEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Start Date Time.
	 *
	 * @param startDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Start Date Time
	 */
	List<DoctorScheduleEntity> findByStartDateTime(@NotNull OffsetDateTime startDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute End Date Time.
	 *
	 * @param endDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute End Date Time
	 */
	List<DoctorScheduleEntity> findByEndDateTime(@NotNull OffsetDateTime endDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Interval in minutes.
	 *
	 * @param intervalInMinutes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Interval in minutes
	 */
	List<DoctorScheduleEntity> findByIntervalInMinutes(@NotNull Integer intervalInMinutes);
	/**
	 * Return an entity or a list of entities that have the given attribute Location.
	 *
	 * @param location the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Location
	 */
	List<DoctorScheduleEntity> findByLocation(@NotNull String location);
	/**
	 * Return an entity or a list of entities that have the given attribute Scheduler Type.
	 *
	 * @param schedulerType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Scheduler Type
	 */
	List<DoctorScheduleEntity> findBySchedulerType(@NotNull String schedulerType);
	/**
	 * Return an entity or a list of entities that have the given attribute Monday.
	 *
	 * @param monday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Monday
	 */
	List<DoctorScheduleEntity> findByMonday(@NotNull Boolean monday);
	/**
	 * Return an entity or a list of entities that have the given attribute Tuesday.
	 *
	 * @param tuesday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tuesday
	 */
	List<DoctorScheduleEntity> findByTuesday(@NotNull Boolean tuesday);
	/**
	 * Return an entity or a list of entities that have the given attribute Wednesday.
	 *
	 * @param wednesday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Wednesday
	 */
	List<DoctorScheduleEntity> findByWednesday(@NotNull Boolean wednesday);
	/**
	 * Return an entity or a list of entities that have the given attribute Thursday.
	 *
	 * @param thursday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Thursday
	 */
	List<DoctorScheduleEntity> findByThursday(@NotNull Boolean thursday);
	/**
	 * Return an entity or a list of entities that have the given attribute Friday.
	 *
	 * @param friday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Friday
	 */
	List<DoctorScheduleEntity> findByFriday(@NotNull Boolean friday);
	/**
	 * Return an entity or a list of entities that have the given attribute Saturday.
	 *
	 * @param saturday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Saturday
	 */
	List<DoctorScheduleEntity> findBySaturday(@NotNull Boolean saturday);
	/**
	 * Return an entity or a list of entities that have the given attribute Sunday.
	 *
	 * @param sunday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sunday
	 */
	List<DoctorScheduleEntity> findBySunday(@NotNull Boolean sunday);
	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	List<DoctorScheduleEntity> findByEmail(@NotNull String email);
	/**
	 * Return an entity or a list of entities that have the given attribute Training.
	 *
	 * @param training the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Training
	 */
	List<DoctorScheduleEntity> findByTraining(@NotNull String training);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	List<DoctorScheduleEntity> findByDismissalDate(@NotNull OffsetDateTime dismissalDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Shift.
	 *
	 * @param shift the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shift
	 */
	List<DoctorScheduleEntity> findByShift(@NotNull String shift);
	/**
	 * Return an entity or a list of entities that have the given attribute Intervals.
	 *
	 * @param intervals the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intervals
	 */
	List<DoctorScheduleEntity> findByIntervals(@NotNull Integer intervals);
	/**
	 * Return an entity or a list of entities that have the given attribute Repetition.
	 *
	 * @param repetition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Repetition
	 */
	List<DoctorScheduleEntity> findByRepetition(@NotNull Boolean repetition);
	/**
	 * Return an entity or a list of entities that have the given attribute Number Of Repetition.
	 *
	 * @param numberOfRepetition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Number Of Repetition
	 */
	List<DoctorScheduleEntity> findByNumberOfRepetition(@NotNull Integer numberOfRepetition);
	/**
	 * Return an entity or a list of entities that have the given attribute Final Schedule.
	 *
	 * @param finalSchedule the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Final Schedule
	 */
	List<DoctorScheduleEntity> findByFinalSchedule(@NotNull OffsetDateTime finalSchedule);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DoctorScheduleEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DoctorScheduleEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}