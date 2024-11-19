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
 * Guice module for Batch Stock Transaction Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BatchStockTransactionDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BatchStockTransactionDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BatchStockTransactionDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BatchStockTransactionDetailEntityFactory batchStockTransactionDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for batchStockTransactionDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for batchStockTransactionDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BatchStockTransactionDetailEntityFactory");

		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntityFactory before the main body here] end

		BatchStockTransactionDetailEntityFactory entityFactory = new BatchStockTransactionDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BatchStockTransactionDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BatchStockTransactionDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntityFactory after the main body here] end

		log.trace("Created BatchStockTransactionDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Batch Stock Transaction Detail entity with no references set.
	 */
	@Provides
	@Named("batchStockTransactionDetailEntityWithNoRef")
	public BatchStockTransactionDetailEntity batchStockTransactionDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for batchStockTransactionDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for batchStockTransactionDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BatchStockTransactionDetailEntity with no reference");

		// % protected region % [Apply any additional logic for batchStockTransactionDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailWithNoRef before the main body here] end

		BatchStockTransactionDetailEntity newEntity = new BatchStockTransactionDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Batch No here] off begin
		String randomStringforBatchNo = mock
				.strings()
				.get();
		newEntity.setBatchNo(randomStringforBatchNo);
		// % protected region % [Add customisation for Batch No here] end
		// % protected region % [Add customisation for Expiration Date here] off begin
		newEntity.setExpirationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiration Date here] end
		// % protected region % [Add customisation for Item Line Number here] off begin
		newEntity.setItemLineNumber(mock.ints().get());
		// % protected region % [Add customisation for Item Line Number here] end
		// % protected region % [Add customisation for Transaction Number here] off begin
		String randomStringforTransactionNumber = mock
				.strings()
				.get();
		newEntity.setTransactionNumber(randomStringforTransactionNumber);
		// % protected region % [Add customisation for Transaction Number here] end
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Batch Transaction Type here] off begin
		String randomStringforBatchTransactionType = mock
				.strings()
				.get();
		newEntity.setBatchTransactionType(randomStringforBatchTransactionType);
		// % protected region % [Add customisation for Batch Transaction Type here] end
		// % protected region % [Add customisation for Batch Qty Uoi here] off begin
		newEntity.setBatchQtyUoi(mock.doubles().get());
		// % protected region % [Add customisation for Batch Qty Uoi here] end
		// % protected region % [Add customisation for Batch Qty Uom Transaction here] off begin
		newEntity.setBatchQtyUomTransaction(mock.doubles().get());
		// % protected region % [Add customisation for Batch Qty Uom Transaction here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for Uoi here] end
		// % protected region % [Add customisation for Uom Transaction here] off begin
		String randomStringforUomTransaction = mock
				.strings()
				.get();
		newEntity.setUomTransaction(randomStringforUomTransaction);
		// % protected region % [Add customisation for Uom Transaction here] end
		// % protected region % [Add customisation for Batch Item Notes here] off begin
		String randomStringforBatchItemNotes = mock
				.strings()
				.get();
		newEntity.setBatchItemNotes(randomStringforBatchItemNotes);
		// % protected region % [Add customisation for Batch Item Notes here] end

		// % protected region % [Apply any additional logic for batchStockTransactionDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailWithNoRef after the main body here] end

		log.trace("Created entity of type BatchStockTransactionDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Batch Stock Transaction Detail entities with no reference at all.
	 */
	@Provides
	@Named("batchStockTransactionDetailEntitiesWithNoRef")
	public Collection<BatchStockTransactionDetailEntity> batchStockTransactionDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for batchStockTransactionDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for batchStockTransactionDetailEntitiesWithNoRef here] end
		BatchStockTransactionDetailEntityFactory batchStockTransactionDetailEntityFactory
	) {
		log.trace("Creating entities of type BatchStockTransactionDetailEntity with no reference");

		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntitiesWithNoRef before the main body here] end

		Collection<BatchStockTransactionDetailEntity> newEntities = batchStockTransactionDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BatchStockTransactionDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Batch Stock Transaction Detail entity with all references set.
	 */
	@Provides
	@Named("batchStockTransactionDetailEntityWithRefs")
	public BatchStockTransactionDetailEntity batchStockTransactionDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for batchStockTransactionDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for batchStockTransactionDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BatchStockTransactionDetailEntity with references");

		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntityWithRefs before the main body here] end

		BatchStockTransactionDetailEntity batchStockTransactionDetailEntity = injector.getInstance(Key.get(BatchStockTransactionDetailEntity.class, Names.named("batchStockTransactionDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type BatchStockTransactionDetailEntity with references");

		return batchStockTransactionDetailEntity;
	}

	/**
	 * Return a collection of Batch Stock Transaction Detail entities with all references set.
	 */
	@Provides
	@Named("batchStockTransactionDetailEntitiesWithRefs")
	public Collection<BatchStockTransactionDetailEntity> batchStockTransactionDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for batchStockTransactionDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for batchStockTransactionDetailEntitiesWithRefs here] end
		BatchStockTransactionDetailEntityFactory batchStockTransactionDetailEntityFactory
	) {
		log.trace("Creating entities of type BatchStockTransactionDetailEntity with references");

		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntitiesWithRefs before the main body here] end

		Collection<BatchStockTransactionDetailEntity> newEntities = batchStockTransactionDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockTransactionDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BatchStockTransactionDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
