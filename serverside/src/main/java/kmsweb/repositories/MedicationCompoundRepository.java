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

import kmsweb.entities.MedicationCompoundEntity;
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
public interface MedicationCompoundRepository extends AbstractRepository<MedicationCompoundEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Compound Code.
	 *
	 * @param compoundCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Code
	 */
	List<MedicationCompoundEntity> findByCompoundCode(@NotNull String compoundCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Compound Name.
	 *
	 * @param compoundName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Name
	 */
	List<MedicationCompoundEntity> findByCompoundName(@NotNull String compoundName);
	/**
	 * Return an entity or a list of entities that have the given attribute Requested Qty.
	 *
	 * @param requestedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Requested Qty
	 */
	List<MedicationCompoundEntity> findByRequestedQty(@NotNull Double requestedQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Outstanding Qty.
	 *
	 * @param outstandingQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outstanding Qty
	 */
	List<MedicationCompoundEntity> findByOutstandingQty(@NotNull Double outstandingQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Returned Qty.
	 *
	 * @param returnedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Returned Qty
	 */
	List<MedicationCompoundEntity> findByReturnedQty(@NotNull Double returnedQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Issued Qty.
	 *
	 * @param issuedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Issued Qty
	 */
	List<MedicationCompoundEntity> findByIssuedQty(@NotNull Double issuedQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Administered Qty.
	 *
	 * @param administeredQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Administered Qty
	 */
	List<MedicationCompoundEntity> findByAdministeredQty(@NotNull Double administeredQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Taken Home Qty.
	 *
	 * @param takenHomeQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Taken Home Qty
	 */
	List<MedicationCompoundEntity> findByTakenHomeQty(@NotNull Double takenHomeQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Frequency.
	 *
	 * @param dosageFrequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Frequency
	 */
	List<MedicationCompoundEntity> findByDosageFrequency(@NotNull Double dosageFrequency);
	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Qty.
	 *
	 * @param dosageQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Qty
	 */
	List<MedicationCompoundEntity> findByDosageQty(@NotNull Double dosageQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Dose.
	 *
	 * @param dose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dose
	 */
	List<MedicationCompoundEntity> findByDose(@NotNull Double dose);
	/**
	 * Return an entity or a list of entities that have the given attribute Frequency.
	 *
	 * @param frequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Frequency
	 */
	List<MedicationCompoundEntity> findByFrequency(@NotNull String frequency);
	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Method.
	 *
	 * @param consumptionMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Method
	 */
	List<MedicationCompoundEntity> findByConsumptionMethod(@NotNull String consumptionMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Instruction.
	 *
	 * @param instruction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruction
	 */
	List<MedicationCompoundEntity> findByInstruction(@NotNull String instruction);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<MedicationCompoundEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Price.
	 *
	 * @param totalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Price
	 */
	List<MedicationCompoundEntity> findByTotalPrice(@NotNull Double totalPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Is dtd.
	 *
	 * @param isDtd the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is dtd
	 */
	List<MedicationCompoundEntity> findByIsDtd(@NotNull Boolean isDtd);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Administered Quantity.
	 *
	 * @param totalAdministeredQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Administered Quantity
	 */
	List<MedicationCompoundEntity> findByTotalAdministeredQuantity(@NotNull Integer totalAdministeredQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Issued Quantity.
	 *
	 * @param totalIssuedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Issued Quantity
	 */
	List<MedicationCompoundEntity> findByTotalIssuedQuantity(@NotNull Double totalIssuedQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Taken Home Quantity.
	 *
	 * @param totalTakenHomeQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Taken Home Quantity
	 */
	List<MedicationCompoundEntity> findByTotalTakenHomeQuantity(@NotNull Integer totalTakenHomeQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Returned Quantity.
	 *
	 * @param totalReturnedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Returned Quantity
	 */
	List<MedicationCompoundEntity> findByTotalReturnedQuantity(@NotNull Integer totalReturnedQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute External Compound Name.
	 *
	 * @param externalCompoundName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Compound Name
	 */
	List<MedicationCompoundEntity> findByExternalCompoundName(@NotNull String externalCompoundName);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	List<MedicationCompoundEntity> findByApprovalStatus(@NotNull String approvalStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	List<MedicationCompoundEntity> findByInventoryRoundingValue(@NotNull Double inventoryRoundingValue);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicationCompoundEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicationCompoundEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}