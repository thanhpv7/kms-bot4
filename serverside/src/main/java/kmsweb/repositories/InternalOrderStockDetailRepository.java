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

import kmsweb.entities.InternalOrderStockDetailEntity;
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
public interface InternalOrderStockDetailRepository extends AbstractRepository<InternalOrderStockDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Item Number.
	 *
	 * @param itemNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Number
	 */
	List<InternalOrderStockDetailEntity> findByItemNumber(@NotNull Integer itemNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Available Quantity.
	 *
	 * @param sourceAvailableQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Available Quantity
	 */
	List<InternalOrderStockDetailEntity> findBySourceAvailableQuantity(@NotNull Double sourceAvailableQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Ordered.
	 *
	 * @param quantityOrdered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Ordered
	 */
	List<InternalOrderStockDetailEntity> findByQuantityOrdered(@NotNull Double quantityOrdered);
	/**
	 * Return an entity or a list of entities that have the given attribute uom.
	 *
	 * @param uom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute uom
	 */
	List<InternalOrderStockDetailEntity> findByUom(@NotNull String uom);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Status.
	 *
	 * @param transactionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Status
	 */
	List<InternalOrderStockDetailEntity> findByTransactionStatus(@NotNull String transactionStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Issued.
	 *
	 * @param quantityIssued the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Issued
	 */
	List<InternalOrderStockDetailEntity> findByQuantityIssued(@NotNull Double quantityIssued);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Received.
	 *
	 * @param quantityReceived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Received
	 */
	List<InternalOrderStockDetailEntity> findByQuantityReceived(@NotNull Double quantityReceived);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Min Level.
	 *
	 * @param sourceMinLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Min Level
	 */
	List<InternalOrderStockDetailEntity> findBySourceMinLevel(@NotNull Double sourceMinLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Fulfilled.
	 *
	 * @param quantityFulfilled the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Fulfilled
	 */
	List<InternalOrderStockDetailEntity> findByQuantityFulfilled(@NotNull Double quantityFulfilled);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	List<InternalOrderStockDetailEntity> findByItemNotes(@NotNull String itemNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	List<InternalOrderStockDetailEntity> findByInventoryRoundingValue(@NotNull Double inventoryRoundingValue);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InternalOrderStockDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InternalOrderStockDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}