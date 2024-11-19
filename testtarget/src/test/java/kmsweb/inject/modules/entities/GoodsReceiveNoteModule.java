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
 * Guice module for Goods Receive Note used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class GoodsReceiveNoteModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring GoodsReceiveNoteModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured GoodsReceiveNoteModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public GoodsReceiveNoteEntityFactory goodsReceiveNoteEntityFactory(
			// % protected region % [Apply any additional injected arguments for goodsReceiveNoteEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for goodsReceiveNoteEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating GoodsReceiveNoteEntityFactory");

		// % protected region % [Apply any additional logic for goodsReceiveNoteEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteEntityFactory before the main body here] end

		GoodsReceiveNoteEntityFactory entityFactory = new GoodsReceiveNoteEntityFactory(
				// % protected region % [Apply any additional constructor arguments for GoodsReceiveNoteEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for GoodsReceiveNoteEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for goodsReceiveNoteEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteEntityFactory after the main body here] end

		log.trace("Created GoodsReceiveNoteEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Goods Receive Note entity with no references set.
	 */
	@Provides
	@Named("goodsReceiveNoteEntityWithNoRef")
	public GoodsReceiveNoteEntity goodsReceiveNoteEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type GoodsReceiveNoteEntity with no reference");

		// % protected region % [Apply any additional logic for goodsReceiveNoteWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteWithNoRef before the main body here] end

		GoodsReceiveNoteEntity newEntity = new GoodsReceiveNoteEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Receive Number here] off begin
		String randomStringforReceiveNumber = mock
				.strings()
				.get();
		newEntity.setReceiveNumber(randomStringforReceiveNumber);
		// % protected region % [Add customisation for Receive Number here] end
		// % protected region % [Add customisation for Source Document Type here] off begin
		newEntity.setSourceDocumentType(GrnSourceTypeEnum.NONE);
		// % protected region % [Add customisation for Source Document Type here] end
		// % protected region % [Add customisation for Source Document Number here] off begin
		String randomStringforSourceDocumentNumber = mock
				.strings()
				.get();
		newEntity.setSourceDocumentNumber(randomStringforSourceDocumentNumber);
		// % protected region % [Add customisation for Source Document Number here] end
		// % protected region % [Add customisation for Receive Date here] off begin
		newEntity.setReceiveDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Receive Date here] end
		// % protected region % [Add customisation for Void Date here] off begin
		newEntity.setVoidDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringforApprovalStatus = mock
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringforApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Supplier Invoice Number here] off begin
		String randomStringforSupplierInvoiceNumber = mock
				.strings()
				.get();
		newEntity.setSupplierInvoiceNumber(randomStringforSupplierInvoiceNumber);
		// % protected region % [Add customisation for Supplier Invoice Number here] end
		// % protected region % [Add customisation for Shipping Method here] off begin
		String randomStringforShippingMethod = mock
				.strings()
				.get();
		newEntity.setShippingMethod(randomStringforShippingMethod);
		// % protected region % [Add customisation for Shipping Method here] end
		// % protected region % [Add customisation for Shipping Number here] off begin
		String randomStringforShippingNumber = mock
				.strings()
				.get();
		newEntity.setShippingNumber(randomStringforShippingNumber);
		// % protected region % [Add customisation for Shipping Number here] end
		// % protected region % [Add customisation for Shipping Date here] off begin
		newEntity.setShippingDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Shipping Date here] end

		// % protected region % [Apply any additional logic for goodsReceiveNoteWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteWithNoRef after the main body here] end

		log.trace("Created entity of type GoodsReceiveNoteEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Goods Receive Note entities with no reference at all.
	 */
	@Provides
	@Named("goodsReceiveNoteEntitiesWithNoRef")
	public Collection<GoodsReceiveNoteEntity> goodsReceiveNoteEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteEntitiesWithNoRef here] end
		GoodsReceiveNoteEntityFactory goodsReceiveNoteEntityFactory
	) {
		log.trace("Creating entities of type GoodsReceiveNoteEntity with no reference");

		// % protected region % [Apply any additional logic for goodsReceiveNoteEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteEntitiesWithNoRef before the main body here] end

		Collection<GoodsReceiveNoteEntity> newEntities = goodsReceiveNoteEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for goodsReceiveNoteEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type GoodsReceiveNoteEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Goods Receive Note entity with all references set.
	 */
	@Provides
	@Named("goodsReceiveNoteEntityWithRefs")
	public GoodsReceiveNoteEntity goodsReceiveNoteEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type GoodsReceiveNoteEntity with references");

		// % protected region % [Apply any additional logic for goodsReceiveNoteEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteEntityWithRefs before the main body here] end

		GoodsReceiveNoteEntity goodsReceiveNoteEntity = injector.getInstance(Key.get(GoodsReceiveNoteEntity.class, Names.named("goodsReceiveNoteEntityWithNoRef")));

		// % protected region % [Apply any additional logic for goodsReceiveNoteEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteEntityWithRefs after the main body here] end

		log.trace("Created entity of type GoodsReceiveNoteEntity with references");

		return goodsReceiveNoteEntity;
	}

	/**
	 * Return a collection of Goods Receive Note entities with all references set.
	 */
	@Provides
	@Named("goodsReceiveNoteEntitiesWithRefs")
	public Collection<GoodsReceiveNoteEntity> goodsReceiveNoteEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for goodsReceiveNoteEntitiesWithRefs here] end
		GoodsReceiveNoteEntityFactory goodsReceiveNoteEntityFactory
	) {
		log.trace("Creating entities of type GoodsReceiveNoteEntity with references");

		// % protected region % [Apply any additional logic for goodsReceiveNoteEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteEntitiesWithRefs before the main body here] end

		Collection<GoodsReceiveNoteEntity> newEntities = goodsReceiveNoteEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for goodsReceiveNoteEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for goodsReceiveNoteEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type GoodsReceiveNoteEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
