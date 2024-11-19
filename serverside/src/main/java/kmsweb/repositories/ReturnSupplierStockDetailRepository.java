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

import kmsweb.entities.ReturnSupplierStockDetailEntity;
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
public interface ReturnSupplierStockDetailRepository extends AbstractRepository<ReturnSupplierStockDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Price.
	 *
	 * @param price the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price
	 */
	List<ReturnSupplierStockDetailEntity> findByPrice(@NotNull Double price);
	/**
	 * Return an entity or a list of entities that have the given attribute Available Quantity Returned.
	 *
	 * @param availableQuantityReturned the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Quantity Returned
	 */
	List<ReturnSupplierStockDetailEntity> findByAvailableQuantityReturned(@NotNull Double availableQuantityReturned);
	/**
	 * Return an entity or a list of entities that have the given attribute UOP.
	 *
	 * @param uop the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOP
	 */
	List<ReturnSupplierStockDetailEntity> findByUop(@NotNull String uop);
	/**
	 * Return an entity or a list of entities that have the given attribute Discount In Percent.
	 *
	 * @param discountInPercent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discount In Percent
	 */
	List<ReturnSupplierStockDetailEntity> findByDiscountInPercent(@NotNull Boolean discountInPercent);
	/**
	 * Return an entity or a list of entities that have the given attribute Discount Value.
	 *
	 * @param discountValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discount Value
	 */
	List<ReturnSupplierStockDetailEntity> findByDiscountValue(@NotNull Double discountValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Taxable.
	 *
	 * @param taxable the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Taxable
	 */
	List<ReturnSupplierStockDetailEntity> findByTaxable(@NotNull Boolean taxable);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Price.
	 *
	 * @param itemPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Price
	 */
	List<ReturnSupplierStockDetailEntity> findByItemPrice(@NotNull Double itemPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Available Quantity.
	 *
	 * @param availableQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Quantity
	 */
	List<ReturnSupplierStockDetailEntity> findByAvailableQuantity(@NotNull Double availableQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Ordered.
	 *
	 * @param quantityOrdered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Ordered
	 */
	List<ReturnSupplierStockDetailEntity> findByQuantityOrdered(@NotNull Double quantityOrdered);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Received.
	 *
	 * @param quantityReceived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Received
	 */
	List<ReturnSupplierStockDetailEntity> findByQuantityReceived(@NotNull Double quantityReceived);
	/**
	 * Return an entity or a list of entities that have the given attribute Previous Quantity Returned.
	 *
	 * @param previousQuantityReturned the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Previous Quantity Returned
	 */
	List<ReturnSupplierStockDetailEntity> findByPreviousQuantityReturned(@NotNull Double previousQuantityReturned);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	List<ReturnSupplierStockDetailEntity> findByItemNotes(@NotNull String itemNotes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ReturnSupplierStockDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ReturnSupplierStockDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}