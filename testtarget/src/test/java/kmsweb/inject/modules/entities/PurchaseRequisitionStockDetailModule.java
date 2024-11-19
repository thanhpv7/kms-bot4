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
 * Guice module for Purchase Requisition Stock Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PurchaseRequisitionStockDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PurchaseRequisitionStockDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PurchaseRequisitionStockDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PurchaseRequisitionStockDetailEntityFactory purchaseRequisitionStockDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for purchaseRequisitionStockDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for purchaseRequisitionStockDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PurchaseRequisitionStockDetailEntityFactory");

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntityFactory before the main body here] end

		PurchaseRequisitionStockDetailEntityFactory entityFactory = new PurchaseRequisitionStockDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PurchaseRequisitionStockDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PurchaseRequisitionStockDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntityFactory after the main body here] end

		log.trace("Created PurchaseRequisitionStockDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Purchase Requisition Stock Detail entity with no references set.
	 */
	@Provides
	@Named("purchaseRequisitionStockDetailEntityWithNoRef")
	public PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for purchaseRequisitionStockDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for purchaseRequisitionStockDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PurchaseRequisitionStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailWithNoRef before the main body here] end

		PurchaseRequisitionStockDetailEntity newEntity = new PurchaseRequisitionStockDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SOH here] off begin
		newEntity.setSoh(mock.doubles().get());
		// % protected region % [Add customisation for SOH here] end
		// % protected region % [Add customisation for Max Level here] off begin
		newEntity.setMaxLevel(mock.doubles().get());
		// % protected region % [Add customisation for Max Level here] end
		// % protected region % [Add customisation for Quantity Requested here] off begin
		newEntity.setQuantityRequested(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Requested here] end
		// % protected region % [Add customisation for UOP here] off begin
		String randomStringforUop = mock
				.strings()
				.get();
		newEntity.setUop(randomStringforUop);
		// % protected region % [Add customisation for UOP here] end
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mock.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Total Price here] off begin
		newEntity.setTotalPrice(mock.doubles().get());
		// % protected region % [Add customisation for Total Price here] end
		// % protected region % [Add customisation for Item Status here] off begin
		String randomStringforItemStatus = mock
				.strings()
				.get();
		newEntity.setItemStatus(randomStringforItemStatus);
		// % protected region % [Add customisation for Item Status here] end
		// % protected region % [Add customisation for Quantity Ordered here] off begin
		newEntity.setQuantityOrdered(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Ordered here] end
		// % protected region % [Add customisation for Quantity Received here] off begin
		newEntity.setQuantityReceived(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Received here] end
		// % protected region % [Add customisation for Quantity Returned here] off begin
		newEntity.setQuantityReturned(mock.doubles().get());
		// % protected region % [Add customisation for Quantity Returned here] end
		// % protected region % [Add customisation for Item Notes here] off begin
		String randomStringforItemNotes = mock
				.strings()
				.get();
		newEntity.setItemNotes(randomStringforItemNotes);
		// % protected region % [Add customisation for Item Notes here] end
		// % protected region % [Add customisation for Remaining Quantity here] off begin
		newEntity.setRemainingQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Remaining Quantity here] end

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailWithNoRef after the main body here] end

		log.trace("Created entity of type PurchaseRequisitionStockDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Purchase Requisition Stock Detail entities with no reference at all.
	 */
	@Provides
	@Named("purchaseRequisitionStockDetailEntitiesWithNoRef")
	public Collection<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for purchaseRequisitionStockDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for purchaseRequisitionStockDetailEntitiesWithNoRef here] end
		PurchaseRequisitionStockDetailEntityFactory purchaseRequisitionStockDetailEntityFactory
	) {
		log.trace("Creating entities of type PurchaseRequisitionStockDetailEntity with no reference");

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntitiesWithNoRef before the main body here] end

		Collection<PurchaseRequisitionStockDetailEntity> newEntities = purchaseRequisitionStockDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PurchaseRequisitionStockDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Purchase Requisition Stock Detail entity with all references set.
	 */
	@Provides
	@Named("purchaseRequisitionStockDetailEntityWithRefs")
	public PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for purchaseRequisitionStockDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for purchaseRequisitionStockDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PurchaseRequisitionStockDetailEntity with references");

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntityWithRefs before the main body here] end

		PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetailEntity = injector.getInstance(Key.get(PurchaseRequisitionStockDetailEntity.class, Names.named("purchaseRequisitionStockDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type PurchaseRequisitionStockDetailEntity with references");

		return purchaseRequisitionStockDetailEntity;
	}

	/**
	 * Return a collection of Purchase Requisition Stock Detail entities with all references set.
	 */
	@Provides
	@Named("purchaseRequisitionStockDetailEntitiesWithRefs")
	public Collection<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for purchaseRequisitionStockDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for purchaseRequisitionStockDetailEntitiesWithRefs here] end
		PurchaseRequisitionStockDetailEntityFactory purchaseRequisitionStockDetailEntityFactory
	) {
		log.trace("Creating entities of type PurchaseRequisitionStockDetailEntity with references");

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntitiesWithRefs before the main body here] end

		Collection<PurchaseRequisitionStockDetailEntity> newEntities = purchaseRequisitionStockDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseRequisitionStockDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PurchaseRequisitionStockDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
