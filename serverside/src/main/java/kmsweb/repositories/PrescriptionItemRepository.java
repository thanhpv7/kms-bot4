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

import kmsweb.entities.PrescriptionItemEntity;
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
public interface PrescriptionItemRepository extends AbstractRepository<PrescriptionItemEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Iteration Start.
	 *
	 * @param iterationStart the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Iteration Start
	 */
	List<PrescriptionItemEntity> findByIterationStart(@NotNull Integer iterationStart);
	/**
	 * Return an entity or a list of entities that have the given attribute Iteration End.
	 *
	 * @param iterationEnd the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Iteration End
	 */
	List<PrescriptionItemEntity> findByIterationEnd(@NotNull Integer iterationEnd);
	/**
	 * Return an entity or a list of entities that have the given attribute Requested Quantity.
	 *
	 * @param requestedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Requested Quantity
	 */
	List<PrescriptionItemEntity> findByRequestedQuantity(@NotNull Double requestedQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Allocated Quantity.
	 *
	 * @param allocatedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Allocated Quantity
	 */
	List<PrescriptionItemEntity> findByAllocatedQuantity(@NotNull Double allocatedQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Issued Quantity.
	 *
	 * @param issuedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Issued Quantity
	 */
	List<PrescriptionItemEntity> findByIssuedQuantity(@NotNull Double issuedQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Frequency.
	 *
	 * @param frequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Frequency
	 */
	List<PrescriptionItemEntity> findByFrequency(@NotNull String frequency);
	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Method.
	 *
	 * @param consumptionMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Method
	 */
	List<PrescriptionItemEntity> findByConsumptionMethod(@NotNull String consumptionMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Instruction.
	 *
	 * @param instruction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruction
	 */
	List<PrescriptionItemEntity> findByInstruction(@NotNull String instruction);
	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Times.
	 *
	 * @param dosageTimes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Times
	 */
	List<PrescriptionItemEntity> findByDosageTimes(@NotNull Integer dosageTimes);
	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Days.
	 *
	 * @param dosageDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Days
	 */
	List<PrescriptionItemEntity> findByDosageDays(@NotNull Double dosageDays);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<PrescriptionItemEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Unit Price.
	 *
	 * @param unitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Price
	 */
	List<PrescriptionItemEntity> findByUnitPrice(@NotNull Double unitPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Price.
	 *
	 * @param totalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Price
	 */
	List<PrescriptionItemEntity> findByTotalPrice(@NotNull Double totalPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Is dtd.
	 *
	 * @param isDtd the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is dtd
	 */
	List<PrescriptionItemEntity> findByIsDtd(@NotNull Boolean isDtd);
	/**
	 * Return an entity or a list of entities that have the given attribute Dose.
	 *
	 * @param dose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dose
	 */
	List<PrescriptionItemEntity> findByDose(@NotNull Integer dose);
	/**
	 * Return an entity or a list of entities that have the given attribute External Stock Name.
	 *
	 * @param externalStockName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Stock Name
	 */
	List<PrescriptionItemEntity> findByExternalStockName(@NotNull String externalStockName);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	List<PrescriptionItemEntity> findByApprovalStatus(@NotNull String approvalStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	List<PrescriptionItemEntity> findByInventoryRoundingValue(@NotNull Double inventoryRoundingValue);
	/**
	 * Return an entity or a list of entities that have the given attribute DTD Quantity.
	 *
	 * @param dtdQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DTD Quantity
	 */
	List<PrescriptionItemEntity> findByDtdQuantity(@NotNull Double dtdQuantity);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PrescriptionItemEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PrescriptionItemEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}