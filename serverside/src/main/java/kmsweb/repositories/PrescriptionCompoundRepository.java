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

import kmsweb.entities.PrescriptionCompoundEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface PrescriptionCompoundRepository extends AbstractRepository<PrescriptionCompoundEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Iteration Start.
	 *
	 * @param iterationStart the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Iteration Start
	 */
	List<PrescriptionCompoundEntity> findByIterationStart(@NotNull Integer iterationStart);
	/**
	 * Return an entity or a list of entities that have the given attribute Iteration End.
	 *
	 * @param iterationEnd the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Iteration End
	 */
	List<PrescriptionCompoundEntity> findByIterationEnd(@NotNull Integer iterationEnd);
	/**
	 * Return an entity or a list of entities that have the given attribute Compound Code.
	 *
	 * @param compoundCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Code
	 */
	List<PrescriptionCompoundEntity> findByCompoundCode(@NotNull String compoundCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Compound Name.
	 *
	 * @param compoundName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Name
	 */
	List<PrescriptionCompoundEntity> findByCompoundName(@NotNull String compoundName);
	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Times.
	 *
	 * @param dosageTimes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Times
	 */
	List<PrescriptionCompoundEntity> findByDosageTimes(@NotNull Integer dosageTimes);
	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Days.
	 *
	 * @param dosageDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Days
	 */
	List<PrescriptionCompoundEntity> findByDosageDays(@NotNull Double dosageDays);
	/**
	 * Return an entity or a list of entities that have the given attribute Frequency.
	 *
	 * @param frequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Frequency
	 */
	List<PrescriptionCompoundEntity> findByFrequency(@NotNull String frequency);
	/**
	 * Return an entity or a list of entities that have the given attribute Is dtd.
	 *
	 * @param isDtd the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is dtd
	 */
	List<PrescriptionCompoundEntity> findByIsDtd(@NotNull Boolean isDtd);
	/**
	 * Return an entity or a list of entities that have the given attribute Requested Quantity.
	 *
	 * @param requestedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Requested Quantity
	 */
	List<PrescriptionCompoundEntity> findByRequestedQuantity(@NotNull Double requestedQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Allocated Quantity.
	 *
	 * @param allocatedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Allocated Quantity
	 */
	List<PrescriptionCompoundEntity> findByAllocatedQuantity(@NotNull Double allocatedQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Issued Quantity.
	 *
	 * @param issuedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Issued Quantity
	 */
	List<PrescriptionCompoundEntity> findByIssuedQuantity(@NotNull Double issuedQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Method.
	 *
	 * @param consumptionMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Method
	 */
	List<PrescriptionCompoundEntity> findByConsumptionMethod(@NotNull String consumptionMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Instruction.
	 *
	 * @param instruction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruction
	 */
	List<PrescriptionCompoundEntity> findByInstruction(@NotNull String instruction);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<PrescriptionCompoundEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Price.
	 *
	 * @param totalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Price
	 */
	List<PrescriptionCompoundEntity> findByTotalPrice(@NotNull Double totalPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute External Compound Name.
	 *
	 * @param externalCompoundName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Compound Name
	 */
	List<PrescriptionCompoundEntity> findByExternalCompoundName(@NotNull String externalCompoundName);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	List<PrescriptionCompoundEntity> findByApprovalStatus(@NotNull String approvalStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	List<PrescriptionCompoundEntity> findByInventoryRoundingValue(@NotNull Double inventoryRoundingValue);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PrescriptionCompoundEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PrescriptionCompoundEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}