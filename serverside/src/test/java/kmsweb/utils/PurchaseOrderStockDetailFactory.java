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
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PurchaseOrderStockDetailFactory implements FactoryBean<PurchaseOrderStockDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PurchaseOrderStockDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PurchaseOrderStockDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PurchaseOrderStockDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailWithNoRef before the main body here] end

		PurchaseOrderStockDetailEntity newEntity = new PurchaseOrderStockDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Quantity Ordered here] off begin
		newEntity.setQuantityOrdered(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Ordered here] end
		// % protected region % [Add customisation for UOP here] off begin
		String randomStringForUop = mockNeat
				.strings()
				.get();
		newEntity.setUop(randomStringForUop);
		// % protected region % [Add customisation for UOP here] end
		// % protected region % [Add customisation for Discount In Percent here] off begin
		newEntity.setDiscountInPercent(mockNeat.bools().get());
		// % protected region % [Add customisation for Discount In Percent here] end
		// % protected region % [Add customisation for Discount Value here] off begin
		newEntity.setDiscountValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Discount Value here] end
		// % protected region % [Add customisation for Taxable here] off begin
		newEntity.setTaxable(mockNeat.bools().get());
		// % protected region % [Add customisation for Taxable here] end
		// % protected region % [Add customisation for Item Price here] off begin
		newEntity.setItemPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Item Price here] end
		// % protected region % [Add customisation for Item Status here] off begin
		String randomStringForItemStatus = mockNeat
				.strings()
				.get();
		newEntity.setItemStatus(randomStringForItemStatus);
		// % protected region % [Add customisation for Item Status here] end
		// % protected region % [Add customisation for SOH here] off begin
		newEntity.setSoh(mockNeat.doubles().get());
		// % protected region % [Add customisation for SOH here] end
		// % protected region % [Add customisation for Max Level here] off begin
		newEntity.setMaxLevel(mockNeat.doubles().get());
		// % protected region % [Add customisation for Max Level here] end
		// % protected region % [Add customisation for Quantity Received here] off begin
		newEntity.setQuantityReceived(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Received here] end
		// % protected region % [Add customisation for Quantity Returned here] off begin
		newEntity.setQuantityReturned(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Returned here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringForItemNotes = mockNeat
				.strings()
				.get();
		newEntity.setItemNotes(randomStringForItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Remaining Quantity here] off begin
		newEntity.setRemainingQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Remaining Quantity here] end

		// % protected region % [Apply any additional logic for purchaseOrderStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetailWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPurchase Order here] off begin
			var purchaseOrderFactory = new PurchaseOrderFactory();
			newEntity.setPurchaseOrder(purchaseOrderFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPurchase Order here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPurchase Requisition Stock Detail here] off begin
			var purchaseRequisitionStockDetailFactory = new PurchaseRequisitionStockDetailFactory();
			newEntity.setPurchaseRequisitionStockDetail(purchaseRequisitionStockDetailFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPurchase Requisition Stock Detail here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Items here] off begin
			// Outgoing one to many reference
			var goodsReceiveNoteItemsFactory = new GoodsReceiveNoteItemFactory();
			newEntity.setGoodsReceiveNoteItems(Collections.singletonList(goodsReceiveNoteItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Items here] end

		}

		// % protected region % [Apply any additional logic for purchaseOrderStockDetail with ref here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderStockDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<PurchaseOrderStockDetailEntity> getObjectType() {
		return PurchaseOrderStockDetailEntity.class;
	}
}