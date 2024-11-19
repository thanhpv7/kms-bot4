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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class GoodsReceiveNoteItemFactory implements FactoryBean<GoodsReceiveNoteItemEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public GoodsReceiveNoteItemEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public GoodsReceiveNoteItemEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public GoodsReceiveNoteItemEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemWithNoRef before the main body here] end

		GoodsReceiveNoteItemEntity newEntity = new GoodsReceiveNoteItemEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Line Number here] off begin
		newEntity.setItemLineNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Item Line Number here] end
		// % protected region % [Add customisation for UOP here] off begin
		String randomStringForUop = mockNeat
				.strings()
				.get();
		newEntity.setUop(randomStringForUop);
		// % protected region % [Add customisation for UOP here] end
		// % protected region % [Add customisation for Qty Received here] off begin
		newEntity.setQtyReceived(mockNeat.doubles().get());
		// % protected region % [Add customisation for Qty Received here] end
		// % protected region % [Add customisation for Qty Ordered here] off begin
		newEntity.setQtyOrdered(mockNeat.doubles().get());
		// % protected region % [Add customisation for Qty Ordered here] end
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Total Item Price here] off begin
		newEntity.setTotalItemPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Item Price here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringForItemNotes = mockNeat
				.strings()
				.get();
		newEntity.setItemNotes(randomStringForItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Prev Qty Received here] off begin
		newEntity.setPrevQtyReceived(mockNeat.doubles().get());
		// % protected region % [Add customisation for Prev Qty Received here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringForUoi = mockNeat
				.strings()
				.get();
		newEntity.setUoi(randomStringForUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Qty Received UOI here] off begin
		newEntity.setQtyReceivedUOI(mockNeat.doubles().get());
		// % protected region % [Add customisation for Qty Received UOI here] end
		// % protected region % [Add customisation for Price UOI here] off begin
		newEntity.setPriceUOI(mockNeat.doubles().get());
		// % protected region % [Add customisation for Price UOI here] end
		// % protected region % [Add customisation for On Hand Qty UOP here] off begin
		newEntity.setOnHandQtyUOP(mockNeat.doubles().get());
		// % protected region % [Add customisation for On Hand Qty UOP here] end
		// % protected region % [Add customisation for Max Level UOP here] off begin
		newEntity.setMaxLevelUOP(mockNeat.doubles().get());
		// % protected region % [Add customisation for Max Level UOP here] end
		// % protected region % [Add customisation for Discount Value here] off begin
		newEntity.setDiscountValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Discount Value here] end
		// % protected region % [Add customisation for Tax Value here] off begin
		newEntity.setTaxValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Tax Value here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end
		// % protected region % [Add customisation for Discount In Percent here] off begin
		newEntity.setDiscountInPercent(mockNeat.bools().get());
		// % protected region % [Add customisation for Discount In Percent here] end
		// % protected region % [Add customisation for Tax In Percent here] off begin
		newEntity.setTaxInPercent(mockNeat.bools().get());
		// % protected region % [Add customisation for Tax In Percent here] end

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyGoods Receive Note here] off begin
			var goodsReceiveNoteFactory = new GoodsReceiveNoteFactory();
			newEntity.setGoodsReceiveNote(goodsReceiveNoteFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyGoods Receive Note here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPurchase Order Stock Detail here] off begin
			var purchaseOrderStockDetailFactory = new PurchaseOrderStockDetailFactory();
			newEntity.setPurchaseOrderStockDetail(purchaseOrderStockDetailFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPurchase Order Stock Detail here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Batchs here] off begin
			// Outgoing one to many reference
			var goodsReceiveNoteBatchsFactory = new GoodsReceiveNoteBatchFactory();
			newEntity.setGoodsReceiveNoteBatchs(Collections.singletonList(goodsReceiveNoteBatchsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Batchs here] end

		}

		// % protected region % [Apply any additional logic for goodsReceiveNoteItem with ref here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItem with ref here] end

		return newEntity;
	}

	@Override
	public Class<GoodsReceiveNoteItemEntity> getObjectType() {
		return GoodsReceiveNoteItemEntity.class;
	}
}