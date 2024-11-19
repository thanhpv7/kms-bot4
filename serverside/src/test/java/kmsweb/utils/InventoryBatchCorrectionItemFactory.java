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
import kmsweb.entities.InventoryBatchCorrectionItemEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InventoryBatchCorrectionItemFactory implements FactoryBean<InventoryBatchCorrectionItemEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InventoryBatchCorrectionItemEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InventoryBatchCorrectionItemEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InventoryBatchCorrectionItemEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemWithNoRef before the main body here] end

		InventoryBatchCorrectionItemEntity newEntity = new InventoryBatchCorrectionItemEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Line Number here] off begin
		newEntity.setItemLineNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Item Line Number here] end
		// % protected region % [Add customisation for Batch Number here] off begin
		String randomStringForBatchNumber = mockNeat
				.strings()
				.get();
		newEntity.setBatchNumber(randomStringForBatchNumber);
		// % protected region % [Add customisation for Batch Number here] end
		// % protected region % [Add customisation for Expiration Date here] off begin
		newEntity.setExpirationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiration Date here] end
		// % protected region % [Add customisation for UOM here] off begin
		String randomStringForUom = mockNeat
				.strings()
				.get();
		newEntity.setUom(randomStringForUom);
		// % protected region % [Add customisation for UOM here] end
		// % protected region % [Add customisation for Available Qty Batch here] off begin
		newEntity.setAvailableQtyBatch(mockNeat.doubles().get());
		// % protected region % [Add customisation for Available Qty Batch here] end
		// % protected region % [Add customisation for Actual Qty Batch here] off begin
		newEntity.setActualQtyBatch(mockNeat.doubles().get());
		// % protected region % [Add customisation for Actual Qty Batch here] end
		// % protected region % [Add customisation for Qty Adjusted here] off begin
		newEntity.setQtyAdjusted(mockNeat.doubles().get());
		// % protected region % [Add customisation for Qty Adjusted here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringForItemNotes = mockNeat
				.strings()
				.get();
		newEntity.setItemNotes(randomStringForItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringForUoi = mockNeat
				.strings()
				.get();
		newEntity.setUoi(randomStringForUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Qty UOI here] off begin
		newEntity.setQtyUOI(mockNeat.doubles().get());
		// % protected region % [Add customisation for Qty UOI here] end

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyInventory Batch Correction here] off begin
			var inventoryBatchCorrectionFactory = new InventoryBatchCorrectionFactory();
			newEntity.setInventoryBatchCorrection(inventoryBatchCorrectionFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyInventory Batch Correction here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

		}

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItem with ref here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItem with ref here] end

		return newEntity;
	}

	@Override
	public Class<InventoryBatchCorrectionItemEntity> getObjectType() {
		return InventoryBatchCorrectionItemEntity.class;
	}
}