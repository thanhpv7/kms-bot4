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

import kmsweb.entities.IntraoperativeRecordsEntity;
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
public interface IntraoperativeRecordsRepository extends AbstractRepository<IntraoperativeRecordsEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Start Date Time.
	 *
	 * @param startDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Start Date Time
	 */
	List<IntraoperativeRecordsEntity> findByStartDateTime(@NotNull OffsetDateTime startDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute End Date Time.
	 *
	 * @param endDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute End Date Time
	 */
	List<IntraoperativeRecordsEntity> findByEndDateTime(@NotNull OffsetDateTime endDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Start Date Time.
	 *
	 * @param surgeryStartDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Start Date Time
	 */
	List<IntraoperativeRecordsEntity> findBySurgeryStartDateTime(@NotNull OffsetDateTime surgeryStartDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Surgery End Date Time.
	 *
	 * @param surgeryEndDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery End Date Time
	 */
	List<IntraoperativeRecordsEntity> findBySurgeryEndDateTime(@NotNull OffsetDateTime surgeryEndDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Details.
	 *
	 * @param surgeryDetails the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Details
	 */
	List<IntraoperativeRecordsEntity> findBySurgeryDetails(@NotNull String surgeryDetails);
	/**
	 * Return an entity or a list of entities that have the given attribute Blood Transfusion.
	 *
	 * @param bloodTransfusion the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Blood Transfusion
	 */
	List<IntraoperativeRecordsEntity> findByBloodTransfusion(@NotNull String bloodTransfusion);
	/**
	 * Return an entity or a list of entities that have the given attribute Instruments Used.
	 *
	 * @param instrumentsUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruments Used
	 */
	List<IntraoperativeRecordsEntity> findByInstrumentsUsed(@NotNull String instrumentsUsed);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Start Date Time.
	 *
	 * @param anesthesiaStartDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Start Date Time
	 */
	List<IntraoperativeRecordsEntity> findByAnesthesiaStartDateTime(@NotNull OffsetDateTime anesthesiaStartDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Type.
	 *
	 * @param anesthesiaType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Type
	 */
	List<IntraoperativeRecordsEntity> findByAnesthesiaType(@NotNull String anesthesiaType);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Method.
	 *
	 * @param anesthesiaMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Method
	 */
	List<IntraoperativeRecordsEntity> findByAnesthesiaMethod(@NotNull String anesthesiaMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Agents.
	 *
	 * @param anesthesiaAgents the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Agents
	 */
	List<IntraoperativeRecordsEntity> findByAnesthesiaAgents(@NotNull String anesthesiaAgents);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Observations.
	 *
	 * @param anesthesiaObservations the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Observations
	 */
	List<IntraoperativeRecordsEntity> findByAnesthesiaObservations(@NotNull String anesthesiaObservations);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Notes.
	 *
	 * @param anesthesiaNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Notes
	 */
	List<IntraoperativeRecordsEntity> findByAnesthesiaNotes(@NotNull String anesthesiaNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia End Date Time.
	 *
	 * @param anesthesiaEndDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia End Date Time
	 */
	List<IntraoperativeRecordsEntity> findByAnesthesiaEndDateTime(@NotNull OffsetDateTime anesthesiaEndDateTime);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<IntraoperativeRecordsEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<IntraoperativeRecordsEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}