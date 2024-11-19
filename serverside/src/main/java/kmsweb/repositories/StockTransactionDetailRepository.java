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

import kmsweb.entities.StockTransactionDetailEntity;
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
public interface StockTransactionDetailRepository extends AbstractRepository<StockTransactionDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Number.
	 *
	 * @param transactionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Number
	 */
	List<StockTransactionDetailEntity> findByTransactionNumber(@NotNull String transactionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	List<StockTransactionDetailEntity> findByTransactionDate(@NotNull OffsetDateTime transactionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Type.
	 *
	 * @param transactionType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Type
	 */
	List<StockTransactionDetailEntity> findByTransactionType(@NotNull String transactionType);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Notes.
	 *
	 * @param transactionNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Notes
	 */
	List<StockTransactionDetailEntity> findByTransactionNotes(@NotNull String transactionNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Line Number.
	 *
	 * @param itemLineNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Line Number
	 */
	List<StockTransactionDetailEntity> findByItemLineNumber(@NotNull Integer itemLineNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	List<StockTransactionDetailEntity> findByItemNotes(@NotNull String itemNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty Uoi.
	 *
	 * @param qtyUoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Uoi
	 */
	List<StockTransactionDetailEntity> findByQtyUoi(@NotNull Double qtyUoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty Uom Transaction.
	 *
	 * @param qtyUomTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Uom Transaction
	 */
	List<StockTransactionDetailEntity> findByQtyUomTransaction(@NotNull Double qtyUomTransaction);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Cost.
	 *
	 * @param totalCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Cost
	 */
	List<StockTransactionDetailEntity> findByTotalCost(@NotNull Double totalCost);
	/**
	 * Return an entity or a list of entities that have the given attribute Uoi.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uoi
	 */
	List<StockTransactionDetailEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Uom Transaction.
	 *
	 * @param uomTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uom Transaction
	 */
	List<StockTransactionDetailEntity> findByUomTransaction(@NotNull String uomTransaction);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Order Number.
	 *
	 * @param sourceOrderNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Order Number
	 */
	List<StockTransactionDetailEntity> findBySourceOrderNumber(@NotNull String sourceOrderNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty Transit Uoi.
	 *
	 * @param qtyTransitUoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Transit Uoi
	 */
	List<StockTransactionDetailEntity> findByQtyTransitUoi(@NotNull Double qtyTransitUoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty Transit Uom Transaction.
	 *
	 * @param qtyTransitUomTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Transit Uom Transaction
	 */
	List<StockTransactionDetailEntity> findByQtyTransitUomTransaction(@NotNull Double qtyTransitUomTransaction);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<StockTransactionDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<StockTransactionDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}