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
import kmsweb.entities.InventoryAdjustmentItemEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InventoryAdjustmentItemFactory implements FactoryBean<InventoryAdjustmentItemEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InventoryAdjustmentItemEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InventoryAdjustmentItemEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InventoryAdjustmentItemEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemWithNoRef before the main body here] end

		InventoryAdjustmentItemEntity newEntity = new InventoryAdjustmentItemEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Line Number here] off begin
		newEntity.setItemLineNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Item Line Number here] end
		// % protected region % [Add customisation for Original SOH here] off begin
		newEntity.setOriginalSOH(mockNeat.doubles().get());
		// % protected region % [Add customisation for Original SOH here] end
		// % protected region % [Add customisation for Original Inventory Value here] off begin
		newEntity.setOriginalInventoryValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Original Inventory Value here] end
		// % protected region % [Add customisation for Qty here] off begin
		newEntity.setQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for Qty here] end
		// % protected region % [Add customisation for Uom here] off begin
		String randomStringForUom = mockNeat
				.strings()
				.get();
		newEntity.setUom(randomStringForUom);
		// % protected region % [Add customisation for Uom here] end
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Total Cost here] off begin
		newEntity.setTotalCost(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Cost here] end
		// % protected region % [Add customisation for Adjusted Soh here] off begin
		newEntity.setAdjustedSoh(mockNeat.doubles().get());
		// % protected region % [Add customisation for Adjusted Soh here] end
		// % protected region % [Add customisation for Adjusted Inventory Value here] off begin
		newEntity.setAdjustedInventoryValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Adjusted Inventory Value here] end
		// % protected region % [Add customisation for Minimal Level here] off begin
		newEntity.setMinimalLevel(mockNeat.doubles().get());
		// % protected region % [Add customisation for Minimal Level here] end
		// % protected region % [Add customisation for Maximal Level here] off begin
		newEntity.setMaximalLevel(mockNeat.doubles().get());
		// % protected region % [Add customisation for Maximal Level here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringForItemNotes = mockNeat
				.strings()
				.get();
		newEntity.setItemNotes(randomStringForItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringForUoi = mockNeat
				.strings()
				.get();
		newEntity.setUoi(randomStringForUoi);
		// % protected region % [Add customisation for Uoi here] end
		// % protected region % [Add customisation for Qty Uoi here] off begin
		newEntity.setQtyUoi(mockNeat.doubles().get());
		// % protected region % [Add customisation for Qty Uoi here] end
		// % protected region % [Add customisation for Price Uoi here] off begin
		newEntity.setPriceUoi(mockNeat.doubles().get());
		// % protected region % [Add customisation for Price Uoi here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyInventory Adjustment here] off begin
			var inventoryAdjustmentFactory = new InventoryAdjustmentFactory();
			newEntity.setInventoryAdjustment(inventoryAdjustmentFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyInventory Adjustment here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjusment Batchs here] off begin
			// Outgoing one to many reference
			var inventoryAdjusmentBatchsFactory = new InventoryAdjusmentBatchFactory();
			newEntity.setInventoryAdjusmentBatchs(Collections.singletonList(inventoryAdjusmentBatchsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjusment Batchs here] end

		}

		// % protected region % [Apply any additional logic for inventoryAdjustmentItem with ref here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItem with ref here] end

		return newEntity;
	}

	@Override
	public Class<InventoryAdjustmentItemEntity> getObjectType() {
		return InventoryAdjustmentItemEntity.class;
	}
}