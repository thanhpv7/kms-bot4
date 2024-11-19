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
 * Guice module for Batch Stock Balance used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BatchStockBalanceModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BatchStockBalanceModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BatchStockBalanceModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BatchStockBalanceEntityFactory batchStockBalanceEntityFactory(
			// % protected region % [Apply any additional injected arguments for batchStockBalanceEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for batchStockBalanceEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BatchStockBalanceEntityFactory");

		// % protected region % [Apply any additional logic for batchStockBalanceEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceEntityFactory before the main body here] end

		BatchStockBalanceEntityFactory entityFactory = new BatchStockBalanceEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BatchStockBalanceEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BatchStockBalanceEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for batchStockBalanceEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceEntityFactory after the main body here] end

		log.trace("Created BatchStockBalanceEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Batch Stock Balance entity with no references set.
	 */
	@Provides
	@Named("batchStockBalanceEntityWithNoRef")
	public BatchStockBalanceEntity batchStockBalanceEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for batchStockBalanceEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for batchStockBalanceEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BatchStockBalanceEntity with no reference");

		// % protected region % [Apply any additional logic for batchStockBalanceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceWithNoRef before the main body here] end

		BatchStockBalanceEntity newEntity = new BatchStockBalanceEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Source Number here] off begin
		String randomStringforSourceNumber = mock
				.strings()
				.get();
		newEntity.setSourceNumber(randomStringforSourceNumber);
		// % protected region % [Add customisation for Source Number here] end
		// % protected region % [Add customisation for Batch No here] off begin
		String randomStringforBatchNo = mock
				.strings()
				.get();
		newEntity.setBatchNo(randomStringforBatchNo);
		// % protected region % [Add customisation for Batch No here] end
		// % protected region % [Add customisation for Expiration Date here] off begin
		newEntity.setExpirationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiration Date here] end
		// % protected region % [Add customisation for Batch Qty Uoi here] off begin
		newEntity.setBatchQtyUoi(mock.doubles().get());
		// % protected region % [Add customisation for Batch Qty Uoi here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for Uoi here] end

		// % protected region % [Apply any additional logic for batchStockBalanceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceWithNoRef after the main body here] end

		log.trace("Created entity of type BatchStockBalanceEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Batch Stock Balance entities with no reference at all.
	 */
	@Provides
	@Named("batchStockBalanceEntitiesWithNoRef")
	public Collection<BatchStockBalanceEntity> batchStockBalanceEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for batchStockBalanceEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for batchStockBalanceEntitiesWithNoRef here] end
		BatchStockBalanceEntityFactory batchStockBalanceEntityFactory
	) {
		log.trace("Creating entities of type BatchStockBalanceEntity with no reference");

		// % protected region % [Apply any additional logic for batchStockBalanceEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceEntitiesWithNoRef before the main body here] end

		Collection<BatchStockBalanceEntity> newEntities = batchStockBalanceEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for batchStockBalanceEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BatchStockBalanceEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Batch Stock Balance entity with all references set.
	 */
	@Provides
	@Named("batchStockBalanceEntityWithRefs")
	public BatchStockBalanceEntity batchStockBalanceEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for batchStockBalanceEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for batchStockBalanceEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BatchStockBalanceEntity with references");

		// % protected region % [Apply any additional logic for batchStockBalanceEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceEntityWithRefs before the main body here] end

		BatchStockBalanceEntity batchStockBalanceEntity = injector.getInstance(Key.get(BatchStockBalanceEntity.class, Names.named("batchStockBalanceEntityWithNoRef")));

		// % protected region % [Apply any additional logic for batchStockBalanceEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceEntityWithRefs after the main body here] end

		log.trace("Created entity of type BatchStockBalanceEntity with references");

		return batchStockBalanceEntity;
	}

	/**
	 * Return a collection of Batch Stock Balance entities with all references set.
	 */
	@Provides
	@Named("batchStockBalanceEntitiesWithRefs")
	public Collection<BatchStockBalanceEntity> batchStockBalanceEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for batchStockBalanceEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for batchStockBalanceEntitiesWithRefs here] end
		BatchStockBalanceEntityFactory batchStockBalanceEntityFactory
	) {
		log.trace("Creating entities of type BatchStockBalanceEntity with references");

		// % protected region % [Apply any additional logic for batchStockBalanceEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceEntitiesWithRefs before the main body here] end

		Collection<BatchStockBalanceEntity> newEntities = batchStockBalanceEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for batchStockBalanceEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalanceEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BatchStockBalanceEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
