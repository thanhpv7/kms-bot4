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
import kmsweb.entities.TransferOrderStockDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class TransferOrderStockDetailFactory implements FactoryBean<TransferOrderStockDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public TransferOrderStockDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public TransferOrderStockDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public TransferOrderStockDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for transferOrderStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailWithNoRef before the main body here] end

		TransferOrderStockDetailEntity newEntity = new TransferOrderStockDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Number here] off begin
		newEntity.setItemNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Item Number here] end
		// % protected region % [Add customisation for Source Available Quantity here] off begin
		newEntity.setSourceAvailableQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Source Available Quantity here] end
		// % protected region % [Add customisation for Destination SOH here] off begin
		newEntity.setDestinationSOH(mockNeat.doubles().get());
		// % protected region % [Add customisation for Destination SOH here] end
		// % protected region % [Add customisation for Quantity Ordered here] off begin
		newEntity.setQuantityOrdered(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Ordered here] end
		// % protected region % [Add customisation for uom here] off begin
		String randomStringForUom = mockNeat
				.strings()
				.get();
		newEntity.setUom(randomStringForUom);
		// % protected region % [Add customisation for uom here] end
		// % protected region % [Add customisation for Transaction Status here] off begin
		String randomStringForTransactionStatus = mockNeat
				.strings()
				.get();
		newEntity.setTransactionStatus(randomStringForTransactionStatus);
		// % protected region % [Add customisation for Transaction Status here] end
		// % protected region % [Add customisation for Quantity Issued here] off begin
		newEntity.setQuantityIssued(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Issued here] end
		// % protected region % [Add customisation for Quantity Received here] off begin
		newEntity.setQuantityReceived(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Received here] end
		// % protected region % [Add customisation for Source Min Level here] off begin
		newEntity.setSourceMinLevel(mockNeat.doubles().get());
		// % protected region % [Add customisation for Source Min Level here] end
		// % protected region % [Add customisation for Destination Max Level here] off begin
		newEntity.setDestinationMaxLevel(mockNeat.doubles().get());
		// % protected region % [Add customisation for Destination Max Level here] end
		// % protected region % [Add customisation for Quantity Transferred here] off begin
		newEntity.setQuantityTransferred(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Transferred here] end
		// % protected region % [Add customisation for Quantity Fulfilled here] off begin
		newEntity.setQuantityFulfilled(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Fulfilled here] end
		// % protected region % [Add customisation for Order Date Time here] off begin
		newEntity.setOrderDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date Time here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringForItemNotes = mockNeat
				.strings()
				.get();
		newEntity.setItemNotes(randomStringForItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mockNeat.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end

		// % protected region % [Apply any additional logic for transferOrderStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetailWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyTransfer Order here] off begin
			var transferOrderFactory = new TransferOrderFactory();
			newEntity.setTransferOrder(transferOrderFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyTransfer Order here] end

		}

		// % protected region % [Apply any additional logic for transferOrderStockDetail with ref here] off begin
		// % protected region % [Apply any additional logic for transferOrderStockDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<TransferOrderStockDetailEntity> getObjectType() {
		return TransferOrderStockDetailEntity.class;
	}
}