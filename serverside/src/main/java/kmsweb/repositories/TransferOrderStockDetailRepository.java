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

import kmsweb.entities.TransferOrderStockDetailEntity;
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
public interface TransferOrderStockDetailRepository extends AbstractRepository<TransferOrderStockDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Item Number.
	 *
	 * @param itemNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Number
	 */
	List<TransferOrderStockDetailEntity> findByItemNumber(@NotNull Integer itemNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Available Quantity.
	 *
	 * @param sourceAvailableQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Available Quantity
	 */
	List<TransferOrderStockDetailEntity> findBySourceAvailableQuantity(@NotNull Double sourceAvailableQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Destination SOH.
	 *
	 * @param destinationSOH the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Destination SOH
	 */
	List<TransferOrderStockDetailEntity> findByDestinationSOH(@NotNull Double destinationSOH);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Ordered.
	 *
	 * @param quantityOrdered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Ordered
	 */
	List<TransferOrderStockDetailEntity> findByQuantityOrdered(@NotNull Double quantityOrdered);
	/**
	 * Return an entity or a list of entities that have the given attribute uom.
	 *
	 * @param uom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute uom
	 */
	List<TransferOrderStockDetailEntity> findByUom(@NotNull String uom);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Status.
	 *
	 * @param transactionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Status
	 */
	List<TransferOrderStockDetailEntity> findByTransactionStatus(@NotNull String transactionStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Issued.
	 *
	 * @param quantityIssued the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Issued
	 */
	List<TransferOrderStockDetailEntity> findByQuantityIssued(@NotNull Double quantityIssued);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Received.
	 *
	 * @param quantityReceived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Received
	 */
	List<TransferOrderStockDetailEntity> findByQuantityReceived(@NotNull Double quantityReceived);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Min Level.
	 *
	 * @param sourceMinLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Min Level
	 */
	List<TransferOrderStockDetailEntity> findBySourceMinLevel(@NotNull Double sourceMinLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Destination Max Level.
	 *
	 * @param destinationMaxLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Destination Max Level
	 */
	List<TransferOrderStockDetailEntity> findByDestinationMaxLevel(@NotNull Double destinationMaxLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Transferred.
	 *
	 * @param quantityTransferred the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Transferred
	 */
	List<TransferOrderStockDetailEntity> findByQuantityTransferred(@NotNull Double quantityTransferred);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Fulfilled.
	 *
	 * @param quantityFulfilled the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Fulfilled
	 */
	List<TransferOrderStockDetailEntity> findByQuantityFulfilled(@NotNull Double quantityFulfilled);
	/**
	 * Return an entity or a list of entities that have the given attribute Order Date Time.
	 *
	 * @param orderDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date Time
	 */
	List<TransferOrderStockDetailEntity> findByOrderDateTime(@NotNull OffsetDateTime orderDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	List<TransferOrderStockDetailEntity> findByItemNotes(@NotNull String itemNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	List<TransferOrderStockDetailEntity> findByInventoryRoundingValue(@NotNull Double inventoryRoundingValue);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TransferOrderStockDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TransferOrderStockDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}