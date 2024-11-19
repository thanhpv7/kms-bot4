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
 * Guice module for Goods Receive Note Batch used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class GoodsReceiveNoteBatchModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring GoodsReceiveNoteBatchModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured GoodsReceiveNoteBatchModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public GoodsReceiveNoteBatchEntityFactory goodsReceiveNoteBatchEntityFactory(
			// % protected region % [Apply any additional injected arguments for goodsReceiveNoteBatchEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for goodsReceiveNoteBatchEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating GoodsReceiveNoteBatchEntityFactory");

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntityFactory before the main body here] end

		GoodsReceiveNoteBatchEntityFactory entityFactory = new GoodsReceiveNoteBatchEntityFactory(
				// % protected region % [Apply any additional constructor arguments for GoodsReceiveNoteBatchEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for GoodsReceiveNoteBatchEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntityFactory after the main body here] end

		log.trace("Created GoodsReceiveNoteBatchEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Goods Receive Note Batch entity with no references set.
	 */
	@Provides
	@Named("goodsReceiveNoteBatchEntityWithNoRef")
	public GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteBatchEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteBatchEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type GoodsReceiveNoteBatchEntity with no reference");

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchWithNoRef before the main body here] end

		GoodsReceiveNoteBatchEntity newEntity = new GoodsReceiveNoteBatchEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
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
		// % protected region % [Add customisation for Batch Number here] off begin
		String randomStringforBatchNumber = mock
				.strings()
				.get();
		newEntity.setBatchNumber(randomStringforBatchNumber);
		// % protected region % [Add customisation for Batch Number here] end
		// % protected region % [Add customisation for Expiration Date here] off begin
		newEntity.setExpirationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expiration Date here] end
		// % protected region % [Add customisation for Batch Qty UOM Transaction here] off begin
		newEntity.setBatchQtyUOMTransaction(mock.doubles().get());
		// % protected region % [Add customisation for Batch Qty UOM Transaction here] end
		// % protected region % [Add customisation for UOM Transaction here] off begin
		String randomStringforUomTransaction = mock
				.strings()
				.get();
		newEntity.setUomTransaction(randomStringforUomTransaction);
		// % protected region % [Add customisation for UOM Transaction here] end
		// % protected region % [Add customisation for Batch Qty UOI here] off begin
		newEntity.setBatchQtyUOI(mock.doubles().get());
		// % protected region % [Add customisation for Batch Qty UOI here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Batch Item Notes here] off begin
		String randomStringforBatchItemNotes = mock
				.strings()
				.get();
		newEntity.setBatchItemNotes(randomStringforBatchItemNotes);
		// % protected region % [Add customisation for Batch Item Notes here] end

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchWithNoRef after the main body here] end

		log.trace("Created entity of type GoodsReceiveNoteBatchEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Goods Receive Note Batch entities with no reference at all.
	 */
	@Provides
	@Named("goodsReceiveNoteBatchEntitiesWithNoRef")
	public Collection<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteBatchEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteBatchEntitiesWithNoRef here] end
		GoodsReceiveNoteBatchEntityFactory goodsReceiveNoteBatchEntityFactory
	) {
		log.trace("Creating entities of type GoodsReceiveNoteBatchEntity with no reference");

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntitiesWithNoRef before the main body here] end

		Collection<GoodsReceiveNoteBatchEntity> newEntities = goodsReceiveNoteBatchEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type GoodsReceiveNoteBatchEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Goods Receive Note Batch entity with all references set.
	 */
	@Provides
	@Named("goodsReceiveNoteBatchEntityWithRefs")
	public GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteBatchEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteBatchEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type GoodsReceiveNoteBatchEntity with references");

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntityWithRefs before the main body here] end

		GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntity = injector.getInstance(Key.get(GoodsReceiveNoteBatchEntity.class, Names.named("goodsReceiveNoteBatchEntityWithNoRef")));

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntityWithRefs after the main body here] end

		log.trace("Created entity of type GoodsReceiveNoteBatchEntity with references");

		return goodsReceiveNoteBatchEntity;
	}

	/**
	 * Return a collection of Goods Receive Note Batch entities with all references set.
	 */
	@Provides
	@Named("goodsReceiveNoteBatchEntitiesWithRefs")
	public Collection<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteBatchEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteBatchEntitiesWithRefs here] end
		GoodsReceiveNoteBatchEntityFactory goodsReceiveNoteBatchEntityFactory
	) {
		log.trace("Creating entities of type GoodsReceiveNoteBatchEntity with references");

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntitiesWithRefs before the main body here] end

		Collection<GoodsReceiveNoteBatchEntity> newEntities = goodsReceiveNoteBatchEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteBatchEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type GoodsReceiveNoteBatchEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
