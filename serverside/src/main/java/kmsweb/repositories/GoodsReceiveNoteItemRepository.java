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

import kmsweb.entities.GoodsReceiveNoteItemEntity;
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
public interface GoodsReceiveNoteItemRepository extends AbstractRepository<GoodsReceiveNoteItemEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Item Line Number.
	 *
	 * @param itemLineNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Line Number
	 */
	List<GoodsReceiveNoteItemEntity> findByItemLineNumber(@NotNull Integer itemLineNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute UOP.
	 *
	 * @param uop the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOP
	 */
	List<GoodsReceiveNoteItemEntity> findByUop(@NotNull String uop);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty Received.
	 *
	 * @param qtyReceived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Received
	 */
	List<GoodsReceiveNoteItemEntity> findByQtyReceived(@NotNull Double qtyReceived);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty Ordered.
	 *
	 * @param qtyOrdered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Ordered
	 */
	List<GoodsReceiveNoteItemEntity> findByQtyOrdered(@NotNull Double qtyOrdered);
	/**
	 * Return an entity or a list of entities that have the given attribute Price.
	 *
	 * @param price the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price
	 */
	List<GoodsReceiveNoteItemEntity> findByPrice(@NotNull Double price);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Item Price.
	 *
	 * @param totalItemPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Item Price
	 */
	List<GoodsReceiveNoteItemEntity> findByTotalItemPrice(@NotNull Double totalItemPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	List<GoodsReceiveNoteItemEntity> findByItemNotes(@NotNull String itemNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Prev Qty Received.
	 *
	 * @param prevQtyReceived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Prev Qty Received
	 */
	List<GoodsReceiveNoteItemEntity> findByPrevQtyReceived(@NotNull Double prevQtyReceived);
	/**
	 * Return an entity or a list of entities that have the given attribute UOI.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOI
	 */
	List<GoodsReceiveNoteItemEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Qty Received UOI.
	 *
	 * @param qtyReceivedUOI the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Received UOI
	 */
	List<GoodsReceiveNoteItemEntity> findByQtyReceivedUOI(@NotNull Double qtyReceivedUOI);
	/**
	 * Return an entity or a list of entities that have the given attribute Price UOI.
	 *
	 * @param priceUOI the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price UOI
	 */
	List<GoodsReceiveNoteItemEntity> findByPriceUOI(@NotNull Double priceUOI);
	/**
	 * Return an entity or a list of entities that have the given attribute On Hand Qty UOP.
	 *
	 * @param onHandQtyUOP the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute On Hand Qty UOP
	 */
	List<GoodsReceiveNoteItemEntity> findByOnHandQtyUOP(@NotNull Double onHandQtyUOP);
	/**
	 * Return an entity or a list of entities that have the given attribute Max Level UOP.
	 *
	 * @param maxLevelUOP the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Max Level UOP
	 */
	List<GoodsReceiveNoteItemEntity> findByMaxLevelUOP(@NotNull Double maxLevelUOP);
	/**
	 * Return an entity or a list of entities that have the given attribute Discount Value.
	 *
	 * @param discountValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discount Value
	 */
	List<GoodsReceiveNoteItemEntity> findByDiscountValue(@NotNull Double discountValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Value.
	 *
	 * @param taxValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Value
	 */
	List<GoodsReceiveNoteItemEntity> findByTaxValue(@NotNull Double taxValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	List<GoodsReceiveNoteItemEntity> findByInventoryRoundingValue(@NotNull Double inventoryRoundingValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Discount In Percent.
	 *
	 * @param discountInPercent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discount In Percent
	 */
	List<GoodsReceiveNoteItemEntity> findByDiscountInPercent(@NotNull Boolean discountInPercent);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax In Percent.
	 *
	 * @param taxInPercent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax In Percent
	 */
	List<GoodsReceiveNoteItemEntity> findByTaxInPercent(@NotNull Boolean taxInPercent);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<GoodsReceiveNoteItemEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<GoodsReceiveNoteItemEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}