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
 * Guice module for Purchase Order used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PurchaseOrderModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PurchaseOrderModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PurchaseOrderModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PurchaseOrderEntityFactory purchaseOrderEntityFactory(
			// % protected region % [Apply any additional injected arguments for purchaseOrderEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for purchaseOrderEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PurchaseOrderEntityFactory");

		// % protected region % [Apply any additional logic for purchaseOrderEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderEntityFactory before the main body here] end

		PurchaseOrderEntityFactory entityFactory = new PurchaseOrderEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PurchaseOrderEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PurchaseOrderEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for purchaseOrderEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderEntityFactory after the main body here] end

		log.trace("Created PurchaseOrderEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Purchase Order entity with no references set.
	 */
	@Provides
	@Named("purchaseOrderEntityWithNoRef")
	public PurchaseOrderEntity purchaseOrderEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for purchaseOrderEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for purchaseOrderEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PurchaseOrderEntity with no reference");

		// % protected region % [Apply any additional logic for purchaseOrderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderWithNoRef before the main body here] end

		PurchaseOrderEntity newEntity = new PurchaseOrderEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Purchase Order Type here] off begin
		String randomStringforPurchaseOrderType = mock
				.strings()
				.get();
		newEntity.setPurchaseOrderType(randomStringforPurchaseOrderType);
		// % protected region % [Add customisation for Purchase Order Type here] end
		// % protected region % [Add customisation for Purchase Order Number here] off begin
		String randomStringforPurchaseOrderNumber = mock
				.strings()
				.get();
		newEntity.setPurchaseOrderNumber(randomStringforPurchaseOrderNumber);
		// % protected region % [Add customisation for Purchase Order Number here] end
		// % protected region % [Add customisation for status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for status here] end
		// % protected region % [Add customisation for Supply Stock Group here] off begin
		String randomStringforSupplyStockGroup = mock
				.strings()
				.get();
		newEntity.setSupplyStockGroup(randomStringforSupplyStockGroup);
		// % protected region % [Add customisation for Supply Stock Group here] end
		// % protected region % [Add customisation for Order Date here] off begin
		newEntity.setOrderDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date here] end
		// % protected region % [Add customisation for Expected Date here] off begin
		newEntity.setExpectedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Expected Date here] end
		// % protected region % [Add customisation for Price VAT Included here] off begin
		newEntity.setPriceVATIncluded(mock.bools().get());
		// % protected region % [Add customisation for Price VAT Included here] end
		// % protected region % [Add customisation for Inventory VAT Included here] off begin
		newEntity.setInventoryVATIncluded(mock.bools().get());
		// % protected region % [Add customisation for Inventory VAT Included here] end
		// % protected region % [Add customisation for Reference Document here] off begin
		String randomStringforReferenceDocument = mock
				.strings()
				.get();
		newEntity.setReferenceDocument(randomStringforReferenceDocument);
		// % protected region % [Add customisation for Reference Document here] end
		// % protected region % [Add customisation for Supplier Reference Document here] off begin
		String randomStringforSupplierReferenceDocument = mock
				.strings()
				.get();
		newEntity.setSupplierReferenceDocument(randomStringforSupplierReferenceDocument);
		// % protected region % [Add customisation for Supplier Reference Document here] end
		// % protected region % [Add customisation for Payment Terms here] off begin
		String randomStringforPaymentTerms = mock
				.strings()
				.get();
		newEntity.setPaymentTerms(randomStringforPaymentTerms);
		// % protected region % [Add customisation for Payment Terms here] end
		// % protected region % [Add customisation for Shipping Method here] off begin
		String randomStringforShippingMethod = mock
				.strings()
				.get();
		newEntity.setShippingMethod(randomStringforShippingMethod);
		// % protected region % [Add customisation for Shipping Method here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Sub Total here] off begin
		newEntity.setSubTotal(mock.doubles().get());
		// % protected region % [Add customisation for Sub Total here] end
		// % protected region % [Add customisation for Extra Discount In Percent here] off begin
		newEntity.setExtraDiscountInPercent(mock.bools().get());
		// % protected region % [Add customisation for Extra Discount In Percent here] end
		// % protected region % [Add customisation for Extra Discount Include Tax here] off begin
		newEntity.setExtraDiscountIncludeTax(mock.bools().get());
		// % protected region % [Add customisation for Extra Discount Include Tax here] end
		// % protected region % [Add customisation for Extra Discount Value here] off begin
		newEntity.setExtraDiscountValue(mock.doubles().get());
		// % protected region % [Add customisation for Extra Discount Value here] end
		// % protected region % [Add customisation for Freight Fee Include Tax here] off begin
		newEntity.setFreightFeeIncludeTax(mock.bools().get());
		// % protected region % [Add customisation for Freight Fee Include Tax here] end
		// % protected region % [Add customisation for Freight Fee Value here] off begin
		newEntity.setFreightFeeValue(mock.doubles().get());
		// % protected region % [Add customisation for Freight Fee Value here] end
		// % protected region % [Add customisation for Other Fee Include Tax here] off begin
		newEntity.setOtherFeeIncludeTax(mock.bools().get());
		// % protected region % [Add customisation for Other Fee Include Tax here] end
		// % protected region % [Add customisation for Other Fee Value here] off begin
		newEntity.setOtherFeeValue(mock.doubles().get());
		// % protected region % [Add customisation for Other Fee Value here] end
		// % protected region % [Add customisation for Tax Base here] off begin
		newEntity.setTaxBase(mock.doubles().get());
		// % protected region % [Add customisation for Tax Base here] end
		// % protected region % [Add customisation for Tax Amount here] off begin
		newEntity.setTaxAmount(mock.doubles().get());
		// % protected region % [Add customisation for Tax Amount here] end
		// % protected region % [Add customisation for Total Amount here] off begin
		newEntity.setTotalAmount(mock.doubles().get());
		// % protected region % [Add customisation for Total Amount here] end

		// % protected region % [Apply any additional logic for purchaseOrderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderWithNoRef after the main body here] end

		log.trace("Created entity of type PurchaseOrderEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Purchase Order entities with no reference at all.
	 */
	@Provides
	@Named("purchaseOrderEntitiesWithNoRef")
	public Collection<PurchaseOrderEntity> purchaseOrderEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for purchaseOrderEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for purchaseOrderEntitiesWithNoRef here] end
		PurchaseOrderEntityFactory purchaseOrderEntityFactory
	) {
		log.trace("Creating entities of type PurchaseOrderEntity with no reference");

		// % protected region % [Apply any additional logic for purchaseOrderEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderEntitiesWithNoRef before the main body here] end

		Collection<PurchaseOrderEntity> newEntities = purchaseOrderEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for purchaseOrderEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PurchaseOrderEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Purchase Order entity with all references set.
	 */
	@Provides
	@Named("purchaseOrderEntityWithRefs")
	public PurchaseOrderEntity purchaseOrderEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for purchaseOrderEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for purchaseOrderEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PurchaseOrderEntity with references");

		// % protected region % [Apply any additional logic for purchaseOrderEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderEntityWithRefs before the main body here] end

		PurchaseOrderEntity purchaseOrderEntity = injector.getInstance(Key.get(PurchaseOrderEntity.class, Names.named("purchaseOrderEntityWithNoRef")));

		// % protected region % [Apply any additional logic for purchaseOrderEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderEntityWithRefs after the main body here] end

		log.trace("Created entity of type PurchaseOrderEntity with references");

		return purchaseOrderEntity;
	}

	/**
	 * Return a collection of Purchase Order entities with all references set.
	 */
	@Provides
	@Named("purchaseOrderEntitiesWithRefs")
	public Collection<PurchaseOrderEntity> purchaseOrderEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for purchaseOrderEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for purchaseOrderEntitiesWithRefs here] end
		PurchaseOrderEntityFactory purchaseOrderEntityFactory
	) {
		log.trace("Creating entities of type PurchaseOrderEntity with references");

		// % protected region % [Apply any additional logic for purchaseOrderEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderEntitiesWithRefs before the main body here] end

		Collection<PurchaseOrderEntity> newEntities = purchaseOrderEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for purchaseOrderEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for purchaseOrderEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PurchaseOrderEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
