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
 * Guice module for Inventory Batch Correction Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InventoryBatchCorrectionItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InventoryBatchCorrectionItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InventoryBatchCorrectionItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InventoryBatchCorrectionItemEntityFactory inventoryBatchCorrectionItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for inventoryBatchCorrectionItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for inventoryBatchCorrectionItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InventoryBatchCorrectionItemEntityFactory");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntityFactory before the main body here] end

		InventoryBatchCorrectionItemEntityFactory entityFactory = new InventoryBatchCorrectionItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InventoryBatchCorrectionItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InventoryBatchCorrectionItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntityFactory after the main body here] end

		log.trace("Created InventoryBatchCorrectionItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Inventory Batch Correction Item entity with no references set.
	 */
	@Provides
	@Named("inventoryBatchCorrectionItemEntityWithNoRef")
	public InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InventoryBatchCorrectionItemEntity with no reference");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemWithNoRef before the main body here] end

		InventoryBatchCorrectionItemEntity newEntity = new InventoryBatchCorrectionItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Line Number here] off begin
		newEntity.setItemLineNumber(mock.ints().get());
		// % protected region % [Add customisation for Item Line Number here] end
		// % protected region % [Add customisation for Batch Number here] off begin
		String randomStringforBatchNumber = mock
				.strings()
				.get();
		newEntity.setBatchNumber(randomStringforBatchNumber);
		// % protected region % [Add customisation for Batch Number here] end
		// % protected region % [Add customisation for Expiration Date here] off begin
		newEntity.setExpirationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiration Date here] end
		// % protected region % [Add customisation for UOM here] off begin
		String randomStringforUom = mock
				.strings()
				.get();
		newEntity.setUom(randomStringforUom);
		// % protected region % [Add customisation for UOM here] end
		// % protected region % [Add customisation for Available Qty Batch here] off begin
		newEntity.setAvailableQtyBatch(mock.doubles().get());
		// % protected region % [Add customisation for Available Qty Batch here] end
		// % protected region % [Add customisation for Actual Qty Batch here] off begin
		newEntity.setActualQtyBatch(mock.doubles().get());
		// % protected region % [Add customisation for Actual Qty Batch here] end
		// % protected region % [Add customisation for Qty Adjusted here] off begin
		newEntity.setQtyAdjusted(mock.doubles().get());
		// % protected region % [Add customisation for Qty Adjusted here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringforItemNotes = mock
				.strings()
				.get();
		newEntity.setItemNotes(randomStringforItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Qty UOI here] off begin
		newEntity.setQtyUOI(mock.doubles().get());
		// % protected region % [Add customisation for Qty UOI here] end

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemWithNoRef after the main body here] end

		log.trace("Created entity of type InventoryBatchCorrectionItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Inventory Batch Correction Item entities with no reference at all.
	 */
	@Provides
	@Named("inventoryBatchCorrectionItemEntitiesWithNoRef")
	public Collection<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionItemEntitiesWithNoRef here] end
		InventoryBatchCorrectionItemEntityFactory inventoryBatchCorrectionItemEntityFactory
	) {
		log.trace("Creating entities of type InventoryBatchCorrectionItemEntity with no reference");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntitiesWithNoRef before the main body here] end

		Collection<InventoryBatchCorrectionItemEntity> newEntities = inventoryBatchCorrectionItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InventoryBatchCorrectionItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Inventory Batch Correction Item entity with all references set.
	 */
	@Provides
	@Named("inventoryBatchCorrectionItemEntityWithRefs")
	public InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InventoryBatchCorrectionItemEntity with references");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntityWithRefs before the main body here] end

		InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntity = injector.getInstance(Key.get(InventoryBatchCorrectionItemEntity.class, Names.named("inventoryBatchCorrectionItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type InventoryBatchCorrectionItemEntity with references");

		return inventoryBatchCorrectionItemEntity;
	}

	/**
	 * Return a collection of Inventory Batch Correction Item entities with all references set.
	 */
	@Provides
	@Named("inventoryBatchCorrectionItemEntitiesWithRefs")
	public Collection<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionItemEntitiesWithRefs here] end
		InventoryBatchCorrectionItemEntityFactory inventoryBatchCorrectionItemEntityFactory
	) {
		log.trace("Creating entities of type InventoryBatchCorrectionItemEntity with references");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntitiesWithRefs before the main body here] end

		Collection<InventoryBatchCorrectionItemEntity> newEntities = inventoryBatchCorrectionItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InventoryBatchCorrectionItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
