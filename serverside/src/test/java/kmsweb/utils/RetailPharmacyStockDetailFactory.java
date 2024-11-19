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
import kmsweb.entities.RetailPharmacyStockDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class RetailPharmacyStockDetailFactory implements FactoryBean<RetailPharmacyStockDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public RetailPharmacyStockDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public RetailPharmacyStockDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public RetailPharmacyStockDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailWithNoRef before the main body here] end

		RetailPharmacyStockDetailEntity newEntity = new RetailPharmacyStockDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Supply Stock Group here] off begin
		String randomStringForSupplyStockGroup = mockNeat
				.strings()
				.get();
		newEntity.setSupplyStockGroup(randomStringForSupplyStockGroup);
		// % protected region % [Add customisation for Supply Stock Group here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringForUoi = mockNeat
				.strings()
				.get();
		newEntity.setUoi(randomStringForUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Available Quantity here] off begin
		newEntity.setAvailableQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Available Quantity here] end
		// % protected region % [Add customisation for Quantity here] off begin
		newEntity.setQuantity(mockNeat.doubles().get());
		// % protected region % [Add customisation for Quantity here] end
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Discount here] off begin
		newEntity.setDiscount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Discount here] end
		// % protected region % [Add customisation for Tax Included here] off begin
		newEntity.setTaxIncluded(mockNeat.bools().get());
		// % protected region % [Add customisation for Tax Included here] end
		// % protected region % [Add customisation for Tax Amount here] off begin
		newEntity.setTaxAmount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Tax Amount here] end
		// % protected region % [Add customisation for Total Item Price here] off begin
		newEntity.setTotalItemPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Item Price here] end

		// % protected region % [Apply any additional logic for retailPharmacyStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetailWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRetail Pharmacy here] off begin
			var retailPharmacyFactory = new RetailPharmacyFactory();
			newEntity.setRetailPharmacy(retailPharmacyFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRetail Pharmacy here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

		}

		// % protected region % [Apply any additional logic for retailPharmacyStockDetail with ref here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyStockDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<RetailPharmacyStockDetailEntity> getObjectType() {
		return RetailPharmacyStockDetailEntity.class;
	}
}