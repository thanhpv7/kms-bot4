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
 * Guice module for Batch Stock Balance Per Date used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BatchStockBalancePerDateModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BatchStockBalancePerDateModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BatchStockBalancePerDateModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BatchStockBalancePerDateEntityFactory batchStockBalancePerDateEntityFactory(
			// % protected region % [Apply any additional injected arguments for batchStockBalancePerDateEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for batchStockBalancePerDateEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BatchStockBalancePerDateEntityFactory");

		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntityFactory before the main body here] end

		BatchStockBalancePerDateEntityFactory entityFactory = new BatchStockBalancePerDateEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BatchStockBalancePerDateEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BatchStockBalancePerDateEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntityFactory after the main body here] end

		log.trace("Created BatchStockBalancePerDateEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Batch Stock Balance Per Date entity with no references set.
	 */
	@Provides
	@Named("batchStockBalancePerDateEntityWithNoRef")
	public BatchStockBalancePerDateEntity batchStockBalancePerDateEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for batchStockBalancePerDateEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for batchStockBalancePerDateEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BatchStockBalancePerDateEntity with no reference");

		// % protected region % [Apply any additional logic for batchStockBalancePerDateWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateWithNoRef before the main body here] end

		BatchStockBalancePerDateEntity newEntity = new BatchStockBalancePerDateEntity();
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
		// % protected region % [Add customisation for As Of Date here] off begin
		newEntity.setAsOfDate(OffsetDateTime.now());
		// % protected region % [Add customisation for As Of Date here] end
		// % protected region % [Add customisation for Batch Qty Uoi here] off begin
		newEntity.setBatchQtyUoi(mock.doubles().get());
		// % protected region % [Add customisation for Batch Qty Uoi here] end
		// % protected region % [Add customisation for Uoi here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for Uoi here] end

		// % protected region % [Apply any additional logic for batchStockBalancePerDateWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateWithNoRef after the main body here] end

		log.trace("Created entity of type BatchStockBalancePerDateEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Batch Stock Balance Per Date entities with no reference at all.
	 */
	@Provides
	@Named("batchStockBalancePerDateEntitiesWithNoRef")
	public Collection<BatchStockBalancePerDateEntity> batchStockBalancePerDateEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for batchStockBalancePerDateEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for batchStockBalancePerDateEntitiesWithNoRef here] end
		BatchStockBalancePerDateEntityFactory batchStockBalancePerDateEntityFactory
	) {
		log.trace("Creating entities of type BatchStockBalancePerDateEntity with no reference");

		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntitiesWithNoRef before the main body here] end

		Collection<BatchStockBalancePerDateEntity> newEntities = batchStockBalancePerDateEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BatchStockBalancePerDateEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Batch Stock Balance Per Date entity with all references set.
	 */
	@Provides
	@Named("batchStockBalancePerDateEntityWithRefs")
	public BatchStockBalancePerDateEntity batchStockBalancePerDateEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for batchStockBalancePerDateEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for batchStockBalancePerDateEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BatchStockBalancePerDateEntity with references");

		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntityWithRefs before the main body here] end

		BatchStockBalancePerDateEntity batchStockBalancePerDateEntity = injector.getInstance(Key.get(BatchStockBalancePerDateEntity.class, Names.named("batchStockBalancePerDateEntityWithNoRef")));

		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntityWithRefs after the main body here] end

		log.trace("Created entity of type BatchStockBalancePerDateEntity with references");

		return batchStockBalancePerDateEntity;
	}

	/**
	 * Return a collection of Batch Stock Balance Per Date entities with all references set.
	 */
	@Provides
	@Named("batchStockBalancePerDateEntitiesWithRefs")
	public Collection<BatchStockBalancePerDateEntity> batchStockBalancePerDateEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for batchStockBalancePerDateEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for batchStockBalancePerDateEntitiesWithRefs here] end
		BatchStockBalancePerDateEntityFactory batchStockBalancePerDateEntityFactory
	) {
		log.trace("Creating entities of type BatchStockBalancePerDateEntity with references");

		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntitiesWithRefs before the main body here] end

		Collection<BatchStockBalancePerDateEntity> newEntities = batchStockBalancePerDateEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for batchStockBalancePerDateEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BatchStockBalancePerDateEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
