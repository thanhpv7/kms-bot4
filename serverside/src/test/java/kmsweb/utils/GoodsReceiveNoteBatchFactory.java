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
import kmsweb.entities.GoodsReceiveNoteBatchEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class GoodsReceiveNoteBatchFactory implements FactoryBean<GoodsReceiveNoteBatchEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public GoodsReceiveNoteBatchEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public GoodsReceiveNoteBatchEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public GoodsReceiveNoteBatchEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchWithNoRef before the main body here] end

		GoodsReceiveNoteBatchEntity newEntity = new GoodsReceiveNoteBatchEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Line Number here] off begin
		newEntity.setItemLineNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Item Line Number here] end
		// % protected region % [Add customisation for Transaction Number here] off begin
		String randomStringForTransactionNumber = mockNeat
				.strings()
				.get();
		newEntity.setTransactionNumber(randomStringForTransactionNumber);
		// % protected region % [Add customisation for Transaction Number here] end
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Batch Number here] off begin
		String randomStringForBatchNumber = mockNeat
				.strings()
				.get();
		newEntity.setBatchNumber(randomStringForBatchNumber);
		// % protected region % [Add customisation for Batch Number here] end
		// % protected region % [Add customisation for Expiration Date here] off begin
		newEntity.setExpirationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiration Date here] end
		// % protected region % [Add customisation for Batch Qty UOM Transaction here] off begin
		newEntity.setBatchQtyUOMTransaction(mockNeat.doubles().get());
		// % protected region % [Add customisation for Batch Qty UOM Transaction here] end
		// % protected region % [Add customisation for UOM Transaction here] off begin
		String randomStringForUomTransaction = mockNeat
				.strings()
				.get();
		newEntity.setUomTransaction(randomStringForUomTransaction);
		// % protected region % [Add customisation for UOM Transaction here] end
		// % protected region % [Add customisation for Batch Qty UOI here] off begin
		newEntity.setBatchQtyUOI(mockNeat.doubles().get());
		// % protected region % [Add customisation for Batch Qty UOI here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringForUoi = mockNeat
				.strings()
				.get();
		newEntity.setUoi(randomStringForUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Batch Item Notes here] off begin
		String randomStringForBatchItemNotes = mockNeat
				.strings()
				.get();
		newEntity.setBatchItemNotes(randomStringForBatchItemNotes);
		// % protected region % [Add customisation for Batch Item Notes here] end

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyGoods Receive Note Item here] off begin
			var goodsReceiveNoteItemFactory = new GoodsReceiveNoteItemFactory();
			newEntity.setGoodsReceiveNoteItem(goodsReceiveNoteItemFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyGoods Receive Note Item here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] off begin
			var warehouseFactory = new WarehouseFactory();
			newEntity.setWarehouse(warehouseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] end

		}

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatch with ref here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatch with ref here] end

		return newEntity;
	}

	@Override
	public Class<GoodsReceiveNoteBatchEntity> getObjectType() {
		return GoodsReceiveNoteBatchEntity.class;
	}
}