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

import kmsweb.entities.DailyCareCPPTEntity;
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
public interface DailyCareCPPTRepository extends AbstractRepository<DailyCareCPPTEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Subjective.
	 *
	 * @param subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Subjective
	 */
	List<DailyCareCPPTEntity> findBySubjective(@NotNull String subjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Objective.
	 *
	 * @param objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Objective
	 */
	List<DailyCareCPPTEntity> findByObjective(@NotNull String objective);
	/**
	 * Return an entity or a list of entities that have the given attribute Diagnose.
	 *
	 * @param diagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnose
	 */
	List<DailyCareCPPTEntity> findByDiagnose(@NotNull String diagnose);
	/**
	 * Return an entity or a list of entities that have the given attribute Plan.
	 *
	 * @param plan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Plan
	 */
	List<DailyCareCPPTEntity> findByPlan(@NotNull String plan);
	/**
	 * Return an entity or a list of entities that have the given attribute Instruction.
	 *
	 * @param instruction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruction
	 */
	List<DailyCareCPPTEntity> findByInstruction(@NotNull String instruction);
	/**
	 * Return an entity or a list of entities that have the given attribute Verified Date.
	 *
	 * @param verifiedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Verified Date
	 */
	List<DailyCareCPPTEntity> findByVerifiedDate(@NotNull OffsetDateTime verifiedDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Verified By.
	 *
	 * @param verifiedBy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Verified By
	 */
	List<DailyCareCPPTEntity> findByVerifiedBy(@NotNull String verifiedBy);
	/**
	 * Return an entity or a list of entities that have the given attribute Canceled Date.
	 *
	 * @param canceledDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Canceled Date
	 */
	List<DailyCareCPPTEntity> findByCanceledDate(@NotNull OffsetDateTime canceledDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Canceled By.
	 *
	 * @param canceledBy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Canceled By
	 */
	List<DailyCareCPPTEntity> findByCanceledBy(@NotNull String canceledBy);
	/**
	 * Return an entity or a list of entities that have the given attribute Status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Status
	 */
	List<DailyCareCPPTEntity> findByStatus(@NotNull String status);
	/**
	 * Return an entity or a list of entities that have the given attribute CPPT Date Time.
	 *
	 * @param cpptDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute CPPT Date Time
	 */
	List<DailyCareCPPTEntity> findByCpptDateTime(@NotNull OffsetDateTime cpptDateTime);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DailyCareCPPTEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DailyCareCPPTEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}