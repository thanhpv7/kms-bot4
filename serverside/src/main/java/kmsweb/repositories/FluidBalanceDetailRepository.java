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

import kmsweb.entities.FluidBalanceDetailEntity;
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
public interface FluidBalanceDetailRepository extends AbstractRepository<FluidBalanceDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Record Date Time.
	 *
	 * @param recordDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Record Date Time
	 */
	List<FluidBalanceDetailEntity> findByRecordDateTime(@NotNull OffsetDateTime recordDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Intake Oral.
	 *
	 * @param intakeOral the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intake Oral
	 */
	List<FluidBalanceDetailEntity> findByIntakeOral(@NotNull Double intakeOral);
	/**
	 * Return an entity or a list of entities that have the given attribute Intake NGT.
	 *
	 * @param intakeNGT the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intake NGT
	 */
	List<FluidBalanceDetailEntity> findByIntakeNGT(@NotNull Double intakeNGT);
	/**
	 * Return an entity or a list of entities that have the given attribute Intake IV Line.
	 *
	 * @param intakeIVLine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intake IV Line
	 */
	List<FluidBalanceDetailEntity> findByIntakeIVLine(@NotNull Double intakeIVLine);
	/**
	 * Return an entity or a list of entities that have the given attribute Intake Others.
	 *
	 * @param intakeOthers the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intake Others
	 */
	List<FluidBalanceDetailEntity> findByIntakeOthers(@NotNull Double intakeOthers);
	/**
	 * Return an entity or a list of entities that have the given attribute Output Urine.
	 *
	 * @param outputUrine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Urine
	 */
	List<FluidBalanceDetailEntity> findByOutputUrine(@NotNull Double outputUrine);
	/**
	 * Return an entity or a list of entities that have the given attribute Output NGT.
	 *
	 * @param outputNGT the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output NGT
	 */
	List<FluidBalanceDetailEntity> findByOutputNGT(@NotNull Double outputNGT);
	/**
	 * Return an entity or a list of entities that have the given attribute Output Drain.
	 *
	 * @param outputDrain the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Drain
	 */
	List<FluidBalanceDetailEntity> findByOutputDrain(@NotNull Double outputDrain);
	/**
	 * Return an entity or a list of entities that have the given attribute Output Stool.
	 *
	 * @param outputStool the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Stool
	 */
	List<FluidBalanceDetailEntity> findByOutputStool(@NotNull Double outputStool);
	/**
	 * Return an entity or a list of entities that have the given attribute Output Blood.
	 *
	 * @param outputBlood the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Blood
	 */
	List<FluidBalanceDetailEntity> findByOutputBlood(@NotNull Double outputBlood);
	/**
	 * Return an entity or a list of entities that have the given attribute Output IWL.
	 *
	 * @param outputIWL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output IWL
	 */
	List<FluidBalanceDetailEntity> findByOutputIWL(@NotNull Double outputIWL);
	/**
	 * Return an entity or a list of entities that have the given attribute Output Others.
	 *
	 * @param outputOthers the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Output Others
	 */
	List<FluidBalanceDetailEntity> findByOutputOthers(@NotNull Double outputOthers);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<FluidBalanceDetailEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Input.
	 *
	 * @param totalInput the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Input
	 */
	List<FluidBalanceDetailEntity> findByTotalInput(@NotNull Double totalInput);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Output.
	 *
	 * @param totalOutput the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Output
	 */
	List<FluidBalanceDetailEntity> findByTotalOutput(@NotNull Double totalOutput);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Balance Fluid.
	 *
	 * @param totalBalanceFluid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Balance Fluid
	 */
	List<FluidBalanceDetailEntity> findByTotalBalanceFluid(@NotNull Double totalBalanceFluid);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<FluidBalanceDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<FluidBalanceDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}