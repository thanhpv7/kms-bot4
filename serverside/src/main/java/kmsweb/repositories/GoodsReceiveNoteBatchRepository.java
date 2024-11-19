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

import kmsweb.entities.GoodsReceiveNoteBatchEntity;
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
public interface GoodsReceiveNoteBatchRepository extends AbstractRepository<GoodsReceiveNoteBatchEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Item Line Number.
	 *
	 * @param itemLineNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Line Number
	 */
	List<GoodsReceiveNoteBatchEntity> findByItemLineNumber(@NotNull Integer itemLineNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Number.
	 *
	 * @param transactionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Number
	 */
	List<GoodsReceiveNoteBatchEntity> findByTransactionNumber(@NotNull String transactionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	List<GoodsReceiveNoteBatchEntity> findByTransactionDate(@NotNull OffsetDateTime transactionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Number.
	 *
	 * @param batchNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Number
	 */
	List<GoodsReceiveNoteBatchEntity> findByBatchNumber(@NotNull String batchNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Expiration Date.
	 *
	 * @param expirationDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expiration Date
	 */
	List<GoodsReceiveNoteBatchEntity> findByExpirationDate(@NotNull OffsetDateTime expirationDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Qty UOM Transaction.
	 *
	 * @param batchQtyUOMTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Qty UOM Transaction
	 */
	List<GoodsReceiveNoteBatchEntity> findByBatchQtyUOMTransaction(@NotNull Double batchQtyUOMTransaction);
	/**
	 * Return an entity or a list of entities that have the given attribute UOM Transaction.
	 *
	 * @param uomTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOM Transaction
	 */
	List<GoodsReceiveNoteBatchEntity> findByUomTransaction(@NotNull String uomTransaction);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Qty UOI.
	 *
	 * @param batchQtyUOI the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Qty UOI
	 */
	List<GoodsReceiveNoteBatchEntity> findByBatchQtyUOI(@NotNull Double batchQtyUOI);
	/**
	 * Return an entity or a list of entities that have the given attribute UOI.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOI
	 */
	List<GoodsReceiveNoteBatchEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Batch Item Notes.
	 *
	 * @param batchItemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Item Notes
	 */
	List<GoodsReceiveNoteBatchEntity> findByBatchItemNotes(@NotNull String batchItemNotes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<GoodsReceiveNoteBatchEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<GoodsReceiveNoteBatchEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}