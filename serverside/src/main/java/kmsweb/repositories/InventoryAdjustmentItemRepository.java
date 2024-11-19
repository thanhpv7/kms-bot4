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

import kmsweb.entities.InventoryAdjustmentItemEntity;
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
public interface InventoryAdjustmentItemRepository extends AbstractRepository<InventoryAdjustmentItemEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Item Line Number.
	 *
	 * @param itemLineNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Line Number
	 */
	List<InventoryAdjustmentItemEntity> findByItemLineNumber(@NotNull Integer itemLineNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Original SOH.
	 *
	 * @param originalSOH the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Original SOH
	 */
	List<InventoryAdjustmentItemEntity> findByOriginalSOH(@NotNull Double originalSOH);
	/**
	 * Return an entity or a list of entities that have the given attribute Original Inventory Value.
	 *
	 * @param originalInventoryValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Original Inventory Value
	 */
	List<InventoryAdjustmentItemEntity> findByOriginalInventoryValue(@NotNull Double originalInventoryValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty.
	 *
	 * @param qty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty
	 */
	List<InventoryAdjustmentItemEntity> findByQty(@NotNull Double qty);
	/**
	 * Return an entity or a list of entities that have the given attribute Uom.
	 *
	 * @param uom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uom
	 */
	List<InventoryAdjustmentItemEntity> findByUom(@NotNull String uom);
	/**
	 * Return an entity or a list of entities that have the given attribute Price.
	 *
	 * @param price the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price
	 */
	List<InventoryAdjustmentItemEntity> findByPrice(@NotNull Double price);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Cost.
	 *
	 * @param totalCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Cost
	 */
	List<InventoryAdjustmentItemEntity> findByTotalCost(@NotNull Double totalCost);
	/**
	 * Return an entity or a list of entities that have the given attribute Adjusted Soh.
	 *
	 * @param adjustedSoh the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Adjusted Soh
	 */
	List<InventoryAdjustmentItemEntity> findByAdjustedSoh(@NotNull Double adjustedSoh);
	/**
	 * Return an entity or a list of entities that have the given attribute Adjusted Inventory Value.
	 *
	 * @param adjustedInventoryValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Adjusted Inventory Value
	 */
	List<InventoryAdjustmentItemEntity> findByAdjustedInventoryValue(@NotNull Double adjustedInventoryValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Minimal Level.
	 *
	 * @param minimalLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Minimal Level
	 */
	List<InventoryAdjustmentItemEntity> findByMinimalLevel(@NotNull Double minimalLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Maximal Level.
	 *
	 * @param maximalLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maximal Level
	 */
	List<InventoryAdjustmentItemEntity> findByMaximalLevel(@NotNull Double maximalLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	List<InventoryAdjustmentItemEntity> findByItemNotes(@NotNull String itemNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Uoi.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uoi
	 */
	List<InventoryAdjustmentItemEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty Uoi.
	 *
	 * @param qtyUoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Uoi
	 */
	List<InventoryAdjustmentItemEntity> findByQtyUoi(@NotNull Double qtyUoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Price Uoi.
	 *
	 * @param priceUoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price Uoi
	 */
	List<InventoryAdjustmentItemEntity> findByPriceUoi(@NotNull Double priceUoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	List<InventoryAdjustmentItemEntity> findByInventoryRoundingValue(@NotNull Double inventoryRoundingValue);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InventoryAdjustmentItemEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InventoryAdjustmentItemEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}