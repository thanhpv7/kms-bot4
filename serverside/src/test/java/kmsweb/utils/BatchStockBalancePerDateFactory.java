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
import kmsweb.entities.BatchStockBalancePerDateEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BatchStockBalancePerDateFactory implements FactoryBean<BatchStockBalancePerDateEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BatchStockBalancePerDateEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BatchStockBalancePerDateEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BatchStockBalancePerDateEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for batchStockBalancePerDateWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateWithNoRef before the main body here] end

		BatchStockBalancePerDateEntity newEntity = new BatchStockBalancePerDateEntity();
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
		// % protected region % [Add customisation for As Of Date here] off begin
		newEntity.setAsOfDate(OffsetDateTime.now());
		// % protected region % [Add customisation for As Of Date here] end
		// % protected region % [Add customisation for Batch Qty Uoi here] off begin
		newEntity.setBatchQtyUoi(mockNeat.doubles().get());
		// % protected region % [Add customisation for Batch Qty Uoi here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringForUoi = mockNeat
				.strings()
				.get();
		newEntity.setUoi(randomStringForUoi);
		// % protected region % [Add customisation for Uoi here] end

		// % protected region % [Apply any additional logic for batchStockBalancePerDateWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateWithNoRef after the main body here] end


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

		// % protected region % [Apply any additional logic for batchStockBalancePerDate with ref here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDate with ref here] end

		return newEntity;
	}

	@Override
	public Class<BatchStockBalancePerDateEntity> getObjectType() {
		return BatchStockBalancePerDateEntity.class;
	}
}