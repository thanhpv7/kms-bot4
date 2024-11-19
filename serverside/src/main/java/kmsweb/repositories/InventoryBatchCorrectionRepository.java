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

import kmsweb.entities.InventoryBatchCorrectionEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import kmsweb.entities.enums.*;
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
public interface InventoryBatchCorrectionRepository extends AbstractRepository<InventoryBatchCorrectionEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Correction Number.
	 *
	 * @param batchCorrectionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Correction Number
	 */
	Optional<InventoryBatchCorrectionEntity> findByBatchCorrectionNumber(@NotNull String batchCorrectionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	List<InventoryBatchCorrectionEntity> findByApprovalStatus(@NotNull String approvalStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	List<InventoryBatchCorrectionEntity> findByTransactionDate(@NotNull OffsetDateTime transactionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Type.
	 *
	 * @param transactionType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Type
	 */
	List<InventoryBatchCorrectionEntity> findByTransactionType(@NotNull BatchCorrectionTypeEnum transactionType);
	/**
	 * Return an entity or a list of entities that have the given attribute Reference Number.
	 *
	 * @param referenceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Number
	 */
	List<InventoryBatchCorrectionEntity> findByReferenceNumber(@NotNull String referenceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<InventoryBatchCorrectionEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Void Date.
	 *
	 * @param voidDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date
	 */
	List<InventoryBatchCorrectionEntity> findByVoidDate(@NotNull OffsetDateTime voidDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Void Reason.
	 *
	 * @param voidReason the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Reason
	 */
	List<InventoryBatchCorrectionEntity> findByVoidReason(@NotNull String voidReason);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InventoryBatchCorrectionEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InventoryBatchCorrectionEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}