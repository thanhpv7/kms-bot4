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

import kmsweb.entities.InventoryBatchCorrectionItemEntity;
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
public interface InventoryBatchCorrectionItemRepository extends AbstractRepository<InventoryBatchCorrectionItemEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Item Line Number.
	 *
	 * @param itemLineNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Line Number
	 */
	List<InventoryBatchCorrectionItemEntity> findByItemLineNumber(@NotNull Integer itemLineNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Number.
	 *
	 * @param batchNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Number
	 */
	List<InventoryBatchCorrectionItemEntity> findByBatchNumber(@NotNull String batchNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Expiration Date.
	 *
	 * @param expirationDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expiration Date
	 */
	List<InventoryBatchCorrectionItemEntity> findByExpirationDate(@NotNull OffsetDateTime expirationDate);
	/**
	 * Return an entity or a list of entities that have the given attribute UOM.
	 *
	 * @param uom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOM
	 */
	List<InventoryBatchCorrectionItemEntity> findByUom(@NotNull String uom);
	/**
	 * Return an entity or a list of entities that have the given attribute Available Qty Batch.
	 *
	 * @param availableQtyBatch the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Qty Batch
	 */
	List<InventoryBatchCorrectionItemEntity> findByAvailableQtyBatch(@NotNull Double availableQtyBatch);
	/**
	 * Return an entity or a list of entities that have the given attribute Actual Qty Batch.
	 *
	 * @param actualQtyBatch the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Actual Qty Batch
	 */
	List<InventoryBatchCorrectionItemEntity> findByActualQtyBatch(@NotNull Double actualQtyBatch);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty Adjusted.
	 *
	 * @param qtyAdjusted the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Adjusted
	 */
	List<InventoryBatchCorrectionItemEntity> findByQtyAdjusted(@NotNull Double qtyAdjusted);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	List<InventoryBatchCorrectionItemEntity> findByItemNotes(@NotNull String itemNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute UOI.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOI
	 */
	List<InventoryBatchCorrectionItemEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty UOI.
	 *
	 * @param qtyUOI the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty UOI
	 */
	List<InventoryBatchCorrectionItemEntity> findByQtyUOI(@NotNull Double qtyUOI);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InventoryBatchCorrectionItemEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InventoryBatchCorrectionItemEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}