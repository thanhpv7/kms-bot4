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
import kmsweb.entities.ReturnSupplierStockDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class ReturnSupplierStockDetailFactory implements FactoryBean<ReturnSupplierStockDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public ReturnSupplierStockDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public ReturnSupplierStockDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public ReturnSupplierStockDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for returnSupplierStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailWithNoRef before the main body here] end

		ReturnSupplierStockDetailEntity newEntity = new ReturnSupplierStockDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Available Quantity Returned here] off begin
		newEntity.setAvailableQuantityReturned(mockNeat.doubles().get());
		// % protected region % [Add customisation for Available Quantity Returned here] end
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
		// % protected region % [Add customisation for Available Quantity here] off begin
		newEntity.setAvailableQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Available Quantity here] end
		// % protected region % [Add customisation for Quantity Ordered here] off begin
		newEntity.setQuantityOrdered(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Ordered here] end
		// % protected region % [Add customisation for Quantity Received here] off begin
		newEntity.setQuantityReceived(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity Received here] end
		// % protected region % [Add customisation for Previous Quantity Returned here] off begin
		newEntity.setPreviousQuantityReturned(mockNeat.doubles().get());
		// % protected region % [Add customisation for Previous Quantity Returned here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringForItemNotes = mockNeat
				.strings()
				.get();
		newEntity.setItemNotes(randomStringForItemNotes);
		// % protected region % [Add customisation for Item Notes here] end

		// % protected region % [Apply any additional logic for returnSupplierStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetailWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyReturn Supplier here] off begin
			var returnSupplierFactory = new ReturnSupplierFactory();
			newEntity.setReturnSupplier(returnSupplierFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyReturn Supplier here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

		}

		// % protected region % [Apply any additional logic for returnSupplierStockDetail with ref here] off begin
		// % protected region % [Apply any additional logic for returnSupplierStockDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<ReturnSupplierStockDetailEntity> getObjectType() {
		return ReturnSupplierStockDetailEntity.class;
	}
}