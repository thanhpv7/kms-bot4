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
 * Guice module for Goods Receive Note Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class GoodsReceiveNoteItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring GoodsReceiveNoteItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured GoodsReceiveNoteItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public GoodsReceiveNoteItemEntityFactory goodsReceiveNoteItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for goodsReceiveNoteItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for goodsReceiveNoteItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating GoodsReceiveNoteItemEntityFactory");

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntityFactory before the main body here] end

		GoodsReceiveNoteItemEntityFactory entityFactory = new GoodsReceiveNoteItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for GoodsReceiveNoteItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for GoodsReceiveNoteItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntityFactory after the main body here] end

		log.trace("Created GoodsReceiveNoteItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Goods Receive Note Item entity with no references set.
	 */
	@Provides
	@Named("goodsReceiveNoteItemEntityWithNoRef")
	public GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type GoodsReceiveNoteItemEntity with no reference");

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemWithNoRef before the main body here] end

		GoodsReceiveNoteItemEntity newEntity = new GoodsReceiveNoteItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Line Number here] off begin
		newEntity.setItemLineNumber(mock.ints().get());
		// % protected region % [Add customisation for Item Line Number here] end
		// % protected region % [Add customisation for UOP here] off begin
		String randomStringforUop = mock
				.strings()
				.get();
		newEntity.setUop(randomStringforUop);
		// % protected region % [Add customisation for UOP here] end
		// % protected region % [Add customisation for Qty Received here] off begin
		newEntity.setQtyReceived(mock.doubles().get());
		// % protected region % [Add customisation for Qty Received here] end
		// % protected region % [Add customisation for Qty Ordered here] off begin
		newEntity.setQtyOrdered(mock.doubles().get());
		// % protected region % [Add customisation for Qty Ordered here] end
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mock.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Total Item Price here] off begin
		newEntity.setTotalItemPrice(mock.doubles().get());
		// % protected region % [Add customisation for Total Item Price here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringforItemNotes = mock
				.strings()
				.get();
		newEntity.setItemNotes(randomStringforItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Prev Qty Received here] off begin
		newEntity.setPrevQtyReceived(mock.doubles().get());
		// % protected region % [Add customisation for Prev Qty Received here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Qty Received UOI here] off begin
		newEntity.setQtyReceivedUOI(mock.doubles().get());
		// % protected region % [Add customisation for Qty Received UOI here] end
		// % protected region % [Add customisation for Price UOI here] off begin
		newEntity.setPriceUOI(mock.doubles().get());
		// % protected region % [Add customisation for Price UOI here] end
		// % protected region % [Add customisation for On Hand Qty UOP here] off begin
		newEntity.setOnHandQtyUOP(mock.doubles().get());
		// % protected region % [Add customisation for On Hand Qty UOP here] end
		// % protected region % [Add customisation for Max Level UOP here] off begin
		newEntity.setMaxLevelUOP(mock.doubles().get());
		// % protected region % [Add customisation for Max Level UOP here] end
		// % protected region % [Add customisation for Discount Value here] off begin
		newEntity.setDiscountValue(mock.doubles().get());
		// % protected region % [Add customisation for Discount Value here] end
		// % protected region % [Add customisation for Tax Value here] off begin
		newEntity.setTaxValue(mock.doubles().get());
		// % protected region % [Add customisation for Tax Value here] end
		// % protected region % [Add customisation for Inventory Rounding Value here] off begin
		newEntity.setInventoryRoundingValue(mock.doubles().get());
		// % protected region % [Add customisation for Inventory Rounding Value here] end
		// % protected region % [Add customisation for Discount In Percent here] off begin
		newEntity.setDiscountInPercent(mock.bools().get());
		// % protected region % [Add customisation for Discount In Percent here] end
		// % protected region % [Add customisation for Tax In Percent here] off begin
		newEntity.setTaxInPercent(mock.bools().get());
		// % protected region % [Add customisation for Tax In Percent here] end

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemWithNoRef after the main body here] end

		log.trace("Created entity of type GoodsReceiveNoteItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Goods Receive Note Item entities with no reference at all.
	 */
	@Provides
	@Named("goodsReceiveNoteItemEntitiesWithNoRef")
	public Collection<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteItemEntitiesWithNoRef here] end
		GoodsReceiveNoteItemEntityFactory goodsReceiveNoteItemEntityFactory
	) {
		log.trace("Creating entities of type GoodsReceiveNoteItemEntity with no reference");

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntitiesWithNoRef before the main body here] end

		Collection<GoodsReceiveNoteItemEntity> newEntities = goodsReceiveNoteItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type GoodsReceiveNoteItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Goods Receive Note Item entity with all references set.
	 */
	@Provides
	@Named("goodsReceiveNoteItemEntityWithRefs")
	public GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type GoodsReceiveNoteItemEntity with references");

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntityWithRefs before the main body here] end

		GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity = injector.getInstance(Key.get(GoodsReceiveNoteItemEntity.class, Names.named("goodsReceiveNoteItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type GoodsReceiveNoteItemEntity with references");

		return goodsReceiveNoteItemEntity;
	}

	/**
	 * Return a collection of Goods Receive Note Item entities with all references set.
	 */
	@Provides
	@Named("goodsReceiveNoteItemEntitiesWithRefs")
	public Collection<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteItemEntitiesWithRefs here] end
		GoodsReceiveNoteItemEntityFactory goodsReceiveNoteItemEntityFactory
	) {
		log.trace("Creating entities of type GoodsReceiveNoteItemEntity with references");

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntitiesWithRefs before the main body here] end

		Collection<GoodsReceiveNoteItemEntity> newEntities = goodsReceiveNoteItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type GoodsReceiveNoteItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
