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
import kmsweb.entities.LocationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class LocationFactory implements FactoryBean<LocationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public LocationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public LocationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public LocationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for locationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for locationWithNoRef before the main body here] end

		LocationEntity newEntity = new LocationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Location Name here] off begin
		String randomStringForLocationName = mockNeat
				.strings()
				.get();
		newEntity.setLocationName(randomStringForLocationName);
		// % protected region % [Add customisation for Location Name here] end
		// % protected region % [Add customisation for Aisle here] off begin
		String randomStringForAisle = mockNeat
				.strings()
				.get();
		newEntity.setAisle(randomStringForAisle);
		// % protected region % [Add customisation for Aisle here] end
		// % protected region % [Add customisation for Shelf here] off begin
		String randomStringForShelf = mockNeat
				.strings()
				.get();
		newEntity.setShelf(randomStringForShelf);
		// % protected region % [Add customisation for Shelf here] end
		// % protected region % [Add customisation for Bin here] off begin
		String randomStringForBin = mockNeat
				.strings()
				.get();
		newEntity.setBin(randomStringForBin);
		// % protected region % [Add customisation for Bin here] end

		// % protected region % [Apply any additional logic for locationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for locationWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] off begin
			var warehouseFactory = new WarehouseFactory();
			newEntity.setWarehouse(warehouseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Controls here] off begin
			// Outgoing one to many reference
			var stockControlsFactory = new StockControlFactory();
			newEntity.setStockControls(Collections.singletonList(stockControlsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Controls here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Warehouse Initial Stock s here] off begin
			// Outgoing one to many reference
			var warehouseInitialStockSFactory = new WarehouseInitialStockFactory();
			newEntity.setWarehouseInitialStockS(Collections.singletonList(warehouseInitialStockSFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Warehouse Initial Stock s here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Warehouse Inventories here] off begin
			// Outgoing one to many reference
			var warehouseInventoriesFactory = new WarehouseInventoryFactory();
			newEntity.setWarehouseInventories(Collections.singletonList(warehouseInventoriesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Warehouse Inventories here] end

		}

		// % protected region % [Apply any additional logic for location with ref here] off begin
		// % protected region % [Apply any additional logic for location with ref here] end

		return newEntity;
	}

	@Override
	public Class<LocationEntity> getObjectType() {
		return LocationEntity.class;
	}
}