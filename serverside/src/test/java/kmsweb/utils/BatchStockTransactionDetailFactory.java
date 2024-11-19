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
import kmsweb.entities.BatchStockTransactionDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BatchStockTransactionDetailFactory implements FactoryBean<BatchStockTransactionDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BatchStockTransactionDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BatchStockTransactionDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BatchStockTransactionDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for batchStockTransactionDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailWithNoRef before the main body here] end

		BatchStockTransactionDetailEntity newEntity = new BatchStockTransactionDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Batch No here] off begin
		String randomStringForBatchNo = mockNeat
				.strings()
				.get();
		newEntity.setBatchNo(randomStringForBatchNo);
		// % protected region % [Add customisation for Batch No here] end
		// % protected region % [Add customisation for Expiration Date here] off begin
		newEntity.setExpirationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiration Date here] end
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
		// % protected region % [Add customisation for Batch Transaction Type here] off begin
		String randomStringForBatchTransactionType = mockNeat
				.strings()
				.get();
		newEntity.setBatchTransactionType(randomStringForBatchTransactionType);
		// % protected region % [Add customisation for Batch Transaction Type here] end
		// % protected region % [Add customisation for Batch Qty Uoi here] off begin
		newEntity.setBatchQtyUoi(mockNeat.doubles().get());
		// % protected region % [Add customisation for Batch Qty Uoi here] end
		// % protected region % [Add customisation for Batch Qty Uom Transaction here] off begin
		newEntity.setBatchQtyUomTransaction(mockNeat.doubles().get());
		// % protected region % [Add customisation for Batch Qty Uom Transaction here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringForUoi = mockNeat
				.strings()
				.get();
		newEntity.setUoi(randomStringForUoi);
		// % protected region % [Add customisation for Uoi here] end
		// % protected region % [Add customisation for Uom Transaction here] off begin
		String randomStringForUomTransaction = mockNeat
				.strings()
				.get();
		newEntity.setUomTransaction(randomStringForUomTransaction);
		// % protected region % [Add customisation for Uom Transaction here] end
		// % protected region % [Add customisation for Batch Item Notes here] off begin
		String randomStringForBatchItemNotes = mockNeat
				.strings()
				.get();
		newEntity.setBatchItemNotes(randomStringForBatchItemNotes);
		// % protected region % [Add customisation for Batch Item Notes here] end

		// % protected region % [Apply any additional logic for batchStockTransactionDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailWithNoRef after the main body here] end


		if (includeReferences) {
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

		// % protected region % [Apply any additional logic for batchStockTransactionDetail with ref here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<BatchStockTransactionDetailEntity> getObjectType() {
		return BatchStockTransactionDetailEntity.class;
	}
}