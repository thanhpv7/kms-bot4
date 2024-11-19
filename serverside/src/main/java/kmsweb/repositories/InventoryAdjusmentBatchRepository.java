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

import kmsweb.entities.InventoryAdjusmentBatchEntity;
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
public interface InventoryAdjusmentBatchRepository extends AbstractRepository<InventoryAdjusmentBatchEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Item Line Number.
	 *
	 * @param itemLineNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Line Number
	 */
	List<InventoryAdjusmentBatchEntity> findByItemLineNumber(@NotNull Integer itemLineNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Number.
	 *
	 * @param transactionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Number
	 */
	List<InventoryAdjusmentBatchEntity> findByTransactionNumber(@NotNull String transactionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	List<InventoryAdjusmentBatchEntity> findByTransactionDate(@NotNull OffsetDateTime transactionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch No.
	 *
	 * @param batchNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch No
	 */
	List<InventoryAdjusmentBatchEntity> findByBatchNo(@NotNull String batchNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Expiration Date.
	 *
	 * @param expirationDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expiration Date
	 */
	List<InventoryAdjusmentBatchEntity> findByExpirationDate(@NotNull OffsetDateTime expirationDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Qty Uom Transaction.
	 *
	 * @param batchQtyUomTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Qty Uom Transaction
	 */
	List<InventoryAdjusmentBatchEntity> findByBatchQtyUomTransaction(@NotNull Double batchQtyUomTransaction);
	/**
	 * Return an entity or a list of entities that have the given attribute Uom Transaction.
	 *
	 * @param uomTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uom Transaction
	 */
	List<InventoryAdjusmentBatchEntity> findByUomTransaction(@NotNull String uomTransaction);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Qty Uoi.
	 *
	 * @param batchQtyUoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Qty Uoi
	 */
	List<InventoryAdjusmentBatchEntity> findByBatchQtyUoi(@NotNull Double batchQtyUoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Uoi.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uoi
	 */
	List<InventoryAdjusmentBatchEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Item Notes.
	 *
	 * @param batchItemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Item Notes
	 */
	List<InventoryAdjusmentBatchEntity> findByBatchItemNotes(@NotNull String batchItemNotes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InventoryAdjusmentBatchEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InventoryAdjusmentBatchEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}