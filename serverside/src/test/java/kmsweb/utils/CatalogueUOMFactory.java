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
import kmsweb.entities.CatalogueUOMEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class CatalogueUOMFactory implements FactoryBean<CatalogueUOMEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public CatalogueUOMEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public CatalogueUOMEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public CatalogueUOMEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for catalogueUOMWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMWithNoRef before the main body here] end

		CatalogueUOMEntity newEntity = new CatalogueUOMEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Unit Name here] off begin
		String randomStringForUnitName = mockNeat
				.strings()
				.get();
		newEntity.setUnitName(randomStringForUnitName);
		// % protected region % [Add customisation for Unit Name here] end
		// % protected region % [Add customisation for Conversion here] off begin
		String randomStringForConversion = mockNeat
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setConversion(randomStringForConversion);
		// % protected region % [Add customisation for Conversion here] end
		// % protected region % [Add customisation for Default Transaction here] off begin
		newEntity.setDefaultTransaction(mockNeat.bools().get());
		// % protected region % [Add customisation for Default Transaction here] end
		// % protected region % [Add customisation for Default Stock Card here] off begin
		newEntity.setDefaultStockCard(mockNeat.bools().get());
		// % protected region % [Add customisation for Default Stock Card here] end
		// % protected region % [Add customisation for Default Purchasing here] off begin
		newEntity.setDefaultPurchasing(mockNeat.bools().get());
		// % protected region % [Add customisation for Default Purchasing here] end

		// % protected region % [Apply any additional logic for catalogueUOMWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for outgoingOneToOne Unit Of Measurement] off begin
			// Outgoing one to one reference
			var unitOfMeasurementFactory = new UnitOfMeasurementFactory();
			newEntity.setUnitOfMeasurement(unitOfMeasurementFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Unit Of Measurement] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] off begin
			var stockCatalogueFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogue(stockCatalogueFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStock Catalogue here] end

		}

		// % protected region % [Apply any additional logic for catalogueUOM with ref here] off begin
		// % protected region % [Apply any additional logic for catalogueUOM with ref here] end

		return newEntity;
	}

	@Override
	public Class<CatalogueUOMEntity> getObjectType() {
		return CatalogueUOMEntity.class;
	}
}