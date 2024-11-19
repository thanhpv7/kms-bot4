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
 * Guice module for Inventory Adjustment used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InventoryAdjustmentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InventoryAdjustmentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InventoryAdjustmentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InventoryAdjustmentEntityFactory inventoryAdjustmentEntityFactory(
			// % protected region % [Apply any additional injected arguments for inventoryAdjustmentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for inventoryAdjustmentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InventoryAdjustmentEntityFactory");

		// % protected region % [Apply any additional logic for inventoryAdjustmentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentEntityFactory before the main body here] end

		InventoryAdjustmentEntityFactory entityFactory = new InventoryAdjustmentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InventoryAdjustmentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InventoryAdjustmentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for inventoryAdjustmentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentEntityFactory after the main body here] end

		log.trace("Created InventoryAdjustmentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Inventory Adjustment entity with no references set.
	 */
	@Provides
	@Named("inventoryAdjustmentEntityWithNoRef")
	public InventoryAdjustmentEntity inventoryAdjustmentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InventoryAdjustmentEntity with no reference");

		// % protected region % [Apply any additional logic for inventoryAdjustmentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentWithNoRef before the main body here] end

		InventoryAdjustmentEntity newEntity = new InventoryAdjustmentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Adjustment Number here] off begin
		String randomStringforAdjustmentNumber = mock
				.strings()
				.get();
		newEntity.setAdjustmentNumber(randomStringforAdjustmentNumber);
		// % protected region % [Add customisation for Adjustment Number here] end
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
		String randomStringforTransactionType = mock
				.strings()
				.get();
		newEntity.setTransactionType(randomStringforTransactionType);
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
		// % protected region % [Add customisation for Adjustment Type here] off begin
		String randomStringforAdjustmentType = mock
				.strings()
				.get();
		newEntity.setAdjustmentType(randomStringforAdjustmentType);
		// % protected region % [Add customisation for Adjustment Type here] end

		// % protected region % [Apply any additional logic for inventoryAdjustmentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentWithNoRef after the main body here] end

		log.trace("Created entity of type InventoryAdjustmentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Inventory Adjustment entities with no reference at all.
	 */
	@Provides
	@Named("inventoryAdjustmentEntitiesWithNoRef")
	public Collection<InventoryAdjustmentEntity> inventoryAdjustmentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentEntitiesWithNoRef here] end
		InventoryAdjustmentEntityFactory inventoryAdjustmentEntityFactory
	) {
		log.trace("Creating entities of type InventoryAdjustmentEntity with no reference");

		// % protected region % [Apply any additional logic for inventoryAdjustmentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentEntitiesWithNoRef before the main body here] end

		Collection<InventoryAdjustmentEntity> newEntities = inventoryAdjustmentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for inventoryAdjustmentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InventoryAdjustmentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Inventory Adjustment entity with all references set.
	 */
	@Provides
	@Named("inventoryAdjustmentEntityWithRefs")
	public InventoryAdjustmentEntity inventoryAdjustmentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InventoryAdjustmentEntity with references");

		// % protected region % [Apply any additional logic for inventoryAdjustmentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentEntityWithRefs before the main body here] end

		InventoryAdjustmentEntity inventoryAdjustmentEntity = injector.getInstance(Key.get(InventoryAdjustmentEntity.class, Names.named("inventoryAdjustmentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for inventoryAdjustmentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentEntityWithRefs after the main body here] end

		log.trace("Created entity of type InventoryAdjustmentEntity with references");

		return inventoryAdjustmentEntity;
	}

	/**
	 * Return a collection of Inventory Adjustment entities with all references set.
	 */
	@Provides
	@Named("inventoryAdjustmentEntitiesWithRefs")
	public Collection<InventoryAdjustmentEntity> inventoryAdjustmentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for inventoryAdjustmentEntitiesWithRefs here] end
		InventoryAdjustmentEntityFactory inventoryAdjustmentEntityFactory
	) {
		log.trace("Creating entities of type InventoryAdjustmentEntity with references");

		// % protected region % [Apply any additional logic for inventoryAdjustmentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentEntitiesWithRefs before the main body here] end

		Collection<InventoryAdjustmentEntity> newEntities = inventoryAdjustmentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for inventoryAdjustmentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inventoryAdjustmentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InventoryAdjustmentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
