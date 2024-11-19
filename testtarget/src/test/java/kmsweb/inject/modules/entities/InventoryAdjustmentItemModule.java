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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for Inventory Adjustment Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InventoryAdjustmentItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InventoryAdjustmentItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InventoryAdjustmentItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InventoryAdjustmentItemEntityFactory inventoryAdjustmentItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for inventoryAdjustmentItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for inventoryAdjustmentItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InventoryAdjustmentItemEntityFactory");

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntityFactory before the main body here] end

		InventoryAdjustmentItemEntityFactory entityFactory = new InventoryAdjustmentItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InventoryAdjustmentItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InventoryAdjustmentItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntityFactory after the main body here] end

		log.trace("Created InventoryAdjustmentItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Inventory Adjustment Item entity with no references set.
	 */
	@Provides
	@Named("inventoryAdjustmentItemEntityWithNoRef")
	public InventoryAdjustmentItemEntity inventoryAdjustmentItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InventoryAdjustmentItemEntity with no reference");

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemWithNoRef before the main body here] end

		InventoryAdjustmentItemEntity newEntity = new InventoryAdjustmentItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Line Number here] off begin
		newEntity.setItemLineNumber(mock.ints().get());
		// % protected region % [Add customisation for Item Line Number here] end
		// % protected region % [Add customisation for Original SOH here] off begin
		newEntity.setOriginalSOH(mock.doubles().get());
		// % protected region % [Add customisation for Original SOH here] end
		// % protected region % [Add customisation for Original Inventory Value here] off begin
		newEntity.setOriginalInventoryValue(mock.doubles().get());
		// % protected region % [Add customisation for Original Inventory Value here] end
		// % protected region % [Add customisation for Qty here] off begin
		newEntity.setQty(mock.doubles().get());
		// % protected region % [Add customisation for Qty here] end
		// % protected region % [Add customisation for Uom here] off begin
		String randomStringforUom = mock
				.strings()
				.get();
		newEntity.setUom(randomStringforUom);
		// % protected region % [Add customisation for Uom here] end
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mock.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Total Cost here] off begin
		newEntity.setTotalCost(mock.doubles().get());
		// % protected region % [Add customisation for Total Cost here] end
		// % protected region % [Add customisation for Adjusted Soh here] off begin
		newEntity.setAdjustedSoh(mock.doubles().get());
		// % protected region % [Add customisation for Adjusted Soh here] end
		// % protected region % [Add customisation for Adjusted Inventory Value here] off begin
		newEntity.setAdjustedInventoryValue(mock.doubles().get());
		// % protected region % [Add customisation for Adjusted Inventory Value here] end
		// % protected region % [Add customisation for Minimal Level here] off begin
		newEntity.setMinimalLevel(mock.doubles().get());
		// % protected region % [Add customisation for Minimal Level here] end
		// % protected region % [Add customisation for Maximal Level here] off begin
		newEntity.setMaximalLevel(mock.doubles().get());
		// % protected region % [Add customisation for Maximal Level here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringforItemNotes = mock
				.strings()
				.get();
		newEntity.setItemNotes(randomStringforItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for Uoi here] end
		// % protected region % [Add customisation for Qty Uoi here] off begin
		newEntity.setQtyUoi(mock.doubles().get());
		// % protected region % [Add customisation for Qty Uoi here] end
		// % protected region % [Add customisation for Price Uoi here] off begin
		newEntity.setPriceUoi(mock.doubles().get());
		// % protected region % [Add customisation for Price Uoi here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mock.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemWithNoRef after the main body here] end

		log.trace("Created entity of type InventoryAdjustmentItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Inventory Adjustment Item entities with no reference at all.
	 */
	@Provides
	@Named("inventoryAdjustmentItemEntitiesWithNoRef")
	public Collection<InventoryAdjustmentItemEntity> inventoryAdjustmentItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentItemEntitiesWithNoRef here] end
		InventoryAdjustmentItemEntityFactory inventoryAdjustmentItemEntityFactory
	) {
		log.trace("Creating entities of type InventoryAdjustmentItemEntity with no reference");

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntitiesWithNoRef before the main body here] end

		Collection<InventoryAdjustmentItemEntity> newEntities = inventoryAdjustmentItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InventoryAdjustmentItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Inventory Adjustment Item entity with all references set.
	 */
	@Provides
	@Named("inventoryAdjustmentItemEntityWithRefs")
	public InventoryAdjustmentItemEntity inventoryAdjustmentItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InventoryAdjustmentItemEntity with references");

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntityWithRefs before the main body here] end

		InventoryAdjustmentItemEntity inventoryAdjustmentItemEntity = injector.getInstance(Key.get(InventoryAdjustmentItemEntity.class, Names.named("inventoryAdjustmentItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type InventoryAdjustmentItemEntity with references");

		return inventoryAdjustmentItemEntity;
	}

	/**
	 * Return a collection of Inventory Adjustment Item entities with all references set.
	 */
	@Provides
	@Named("inventoryAdjustmentItemEntitiesWithRefs")
	public Collection<InventoryAdjustmentItemEntity> inventoryAdjustmentItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentItemEntitiesWithRefs here] end
		InventoryAdjustmentItemEntityFactory inventoryAdjustmentItemEntityFactory
	) {
		log.trace("Creating entities of type InventoryAdjustmentItemEntity with references");

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntitiesWithRefs before the main body here] end

		Collection<InventoryAdjustmentItemEntity> newEntities = inventoryAdjustmentItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InventoryAdjustmentItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
