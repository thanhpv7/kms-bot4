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
 * Guice module for Inventory Batch Correction used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InventoryBatchCorrectionModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InventoryBatchCorrectionModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InventoryBatchCorrectionModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InventoryBatchCorrectionEntityFactory inventoryBatchCorrectionEntityFactory(
			// % protected region % [Apply any additional injected arguments for inventoryBatchCorrectionEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for inventoryBatchCorrectionEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InventoryBatchCorrectionEntityFactory");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntityFactory before the main body here] end

		InventoryBatchCorrectionEntityFactory entityFactory = new InventoryBatchCorrectionEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InventoryBatchCorrectionEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InventoryBatchCorrectionEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntityFactory after the main body here] end

		log.trace("Created InventoryBatchCorrectionEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Inventory Batch Correction entity with no references set.
	 */
	@Provides
	@Named("inventoryBatchCorrectionEntityWithNoRef")
	public InventoryBatchCorrectionEntity inventoryBatchCorrectionEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InventoryBatchCorrectionEntity with no reference");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionWithNoRef before the main body here] end

		InventoryBatchCorrectionEntity newEntity = new InventoryBatchCorrectionEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Batch Correction Number here] off begin
		String randomStringforBatchCorrectionNumber = mock
				.strings()
				.get();
		newEntity.setBatchCorrectionNumber(randomStringforBatchCorrectionNumber);
		// % protected region % [Add customisation for Batch Correction Number here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringforApprovalStatus = mock
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringforApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Transaction Type here] off begin
		newEntity.setTransactionType(BatchCorrectionTypeEnum.ADJUSTMENT_BATCH);
		// % protected region % [Add customisation for Transaction Type here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringforReferenceNumber = mock
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringforReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Void Date here] off begin
		newEntity.setVoidDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date here] end
		// % protected region % [Add customisation for Void Reason here] off begin
		String randomStringforVoidReason = mock
				.strings()
				.get();
		newEntity.setVoidReason(randomStringforVoidReason);
		// % protected region % [Add customisation for Void Reason here] end

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionWithNoRef after the main body here] end

		log.trace("Created entity of type InventoryBatchCorrectionEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Inventory Batch Correction entities with no reference at all.
	 */
	@Provides
	@Named("inventoryBatchCorrectionEntitiesWithNoRef")
	public Collection<InventoryBatchCorrectionEntity> inventoryBatchCorrectionEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionEntitiesWithNoRef here] end
		InventoryBatchCorrectionEntityFactory inventoryBatchCorrectionEntityFactory
	) {
		log.trace("Creating entities of type InventoryBatchCorrectionEntity with no reference");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntitiesWithNoRef before the main body here] end

		Collection<InventoryBatchCorrectionEntity> newEntities = inventoryBatchCorrectionEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InventoryBatchCorrectionEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Inventory Batch Correction entity with all references set.
	 */
	@Provides
	@Named("inventoryBatchCorrectionEntityWithRefs")
	public InventoryBatchCorrectionEntity inventoryBatchCorrectionEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionEntityWithRefs here] end
			@Named("warehouseEntityWithRefs") WarehouseEntity warehouse,
			Injector injector
	) {
		log.trace("Creating entity of type InventoryBatchCorrectionEntity with references");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntityWithRefs before the main body here] end

		InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity = injector.getInstance(Key.get(InventoryBatchCorrectionEntity.class, Names.named("inventoryBatchCorrectionEntityWithNoRef")));
		inventoryBatchCorrectionEntity.setWarehouse(warehouse, true);

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntityWithRefs after the main body here] end

		log.trace("Created entity of type InventoryBatchCorrectionEntity with references");

		return inventoryBatchCorrectionEntity;
	}

	/**
	 * Return a collection of Inventory Batch Correction entities with all references set.
	 */
	@Provides
	@Named("inventoryBatchCorrectionEntitiesWithRefs")
	public Collection<InventoryBatchCorrectionEntity> inventoryBatchCorrectionEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for inventoryBatchCorrectionEntitiesWithRefs here] end
		InventoryBatchCorrectionEntityFactory inventoryBatchCorrectionEntityFactory
	) {
		log.trace("Creating entities of type InventoryBatchCorrectionEntity with references");

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntitiesWithRefs before the main body here] end

		Collection<InventoryBatchCorrectionEntity> newEntities = inventoryBatchCorrectionEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryBatchCorrectionEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InventoryBatchCorrectionEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
