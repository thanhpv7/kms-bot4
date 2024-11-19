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

import kmsweb.entities.PurchaseRequisitionStockDetailEntity;
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
public interface PurchaseRequisitionStockDetailRepository extends AbstractRepository<PurchaseRequisitionStockDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute SOH.
	 *
	 * @param soh the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SOH
	 */
	List<PurchaseRequisitionStockDetailEntity> findBySoh(@NotNull Double soh);
	/**
	 * Return an entity or a list of entities that have the given attribute Max Level.
	 *
	 * @param maxLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Max Level
	 */
	List<PurchaseRequisitionStockDetailEntity> findByMaxLevel(@NotNull Double maxLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Requested.
	 *
	 * @param quantityRequested the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Requested
	 */
	List<PurchaseRequisitionStockDetailEntity> findByQuantityRequested(@NotNull Double quantityRequested);
	/**
	 * Return an entity or a list of entities that have the given attribute UOP.
	 *
	 * @param uop the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOP
	 */
	List<PurchaseRequisitionStockDetailEntity> findByUop(@NotNull String uop);
	/**
	 * Return an entity or a list of entities that have the given attribute Unit Price.
	 *
	 * @param unitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Price
	 */
	List<PurchaseRequisitionStockDetailEntity> findByUnitPrice(@NotNull Double unitPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Price.
	 *
	 * @param totalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Price
	 */
	List<PurchaseRequisitionStockDetailEntity> findByTotalPrice(@NotNull Double totalPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Status.
	 *
	 * @param itemStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Status
	 */
	List<PurchaseRequisitionStockDetailEntity> findByItemStatus(@NotNull String itemStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Ordered.
	 *
	 * @param quantityOrdered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Ordered
	 */
	List<PurchaseRequisitionStockDetailEntity> findByQuantityOrdered(@NotNull Double quantityOrdered);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Received.
	 *
	 * @param quantityReceived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Received
	 */
	List<PurchaseRequisitionStockDetailEntity> findByQuantityReceived(@NotNull Double quantityReceived);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Returned.
	 *
	 * @param quantityReturned the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Returned
	 */
	List<PurchaseRequisitionStockDetailEntity> findByQuantityReturned(@NotNull Double quantityReturned);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	List<PurchaseRequisitionStockDetailEntity> findByItemNotes(@NotNull String itemNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Remaining Quantity.
	 *
	 * @param remainingQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Remaining Quantity
	 */
	List<PurchaseRequisitionStockDetailEntity> findByRemainingQuantity(@NotNull Double remainingQuantity);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PurchaseRequisitionStockDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PurchaseRequisitionStockDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}