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
 * Guice module for Return Supplier used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ReturnSupplierModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ReturnSupplierModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ReturnSupplierModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ReturnSupplierEntityFactory returnSupplierEntityFactory(
			// % protected region % [Apply any additional injected arguments for returnSupplierEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for returnSupplierEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ReturnSupplierEntityFactory");

		// % protected region % [Apply any additional logic for returnSupplierEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierEntityFactory before the main body here] end

		ReturnSupplierEntityFactory entityFactory = new ReturnSupplierEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ReturnSupplierEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ReturnSupplierEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for returnSupplierEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierEntityFactory after the main body here] end

		log.trace("Created ReturnSupplierEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Return Supplier entity with no references set.
	 */
	@Provides
	@Named("returnSupplierEntityWithNoRef")
	public ReturnSupplierEntity returnSupplierEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for returnSupplierEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for returnSupplierEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ReturnSupplierEntity with no reference");

		// % protected region % [Apply any additional logic for returnSupplierWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierWithNoRef before the main body here] end

		ReturnSupplierEntity newEntity = new ReturnSupplierEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Return Number here] off begin
		String randomStringforReturnNumber = mock
				.strings()
				.get();
		newEntity.setReturnNumber(randomStringforReturnNumber);
		// % protected region % [Add customisation for Return Number here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringforApprovalStatus = mock
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringforApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Return Date here] off begin
		newEntity.setReturnDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Return Date here] end
		// % protected region % [Add customisation for Order Date here] off begin
		newEntity.setOrderDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Order Date here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Invoice Return Number here] off begin
		String randomStringforInvoiceReturnNumber = mock
				.strings()
				.get();
		newEntity.setInvoiceReturnNumber(randomStringforInvoiceReturnNumber);
		// % protected region % [Add customisation for Invoice Return Number here] end
		// % protected region % [Add customisation for Tax Invoice Number here] off begin
		String randomStringforTaxInvoiceNumber = mock
				.strings()
				.get();
		newEntity.setTaxInvoiceNumber(randomStringforTaxInvoiceNumber);
		// % protected region % [Add customisation for Tax Invoice Number here] end
		// % protected region % [Add customisation for Price VAT Included here] off begin
		newEntity.setPriceVATIncluded(mock.bools().get());
		// % protected region % [Add customisation for Price VAT Included here] end
		// % protected region % [Add customisation for Void Date here] off begin
		newEntity.setVoidDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Void Date here] end
		// % protected region % [Add customisation for Void Reason here] off begin
		String randomStringforVoidReason = mock
				.strings()
				.get();
		newEntity.setVoidReason(randomStringforVoidReason);
		// % protected region % [Add customisation for Void Reason here] end
		// % protected region % [Add customisation for Sub Total here] off begin
		newEntity.setSubTotal(mock.doubles().get());
		// % protected region % [Add customisation for Sub Total here] end
		// % protected region % [Add customisation for Extra Discount In Percentage here] off begin
		newEntity.setExtraDiscountInPercentage(mock.bools().get());
		// % protected region % [Add customisation for Extra Discount In Percentage here] end
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

		// % protected region % [Apply any additional logic for returnSupplierWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierWithNoRef after the main body here] end

		log.trace("Created entity of type ReturnSupplierEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Return Supplier entities with no reference at all.
	 */
	@Provides
	@Named("returnSupplierEntitiesWithNoRef")
	public Collection<ReturnSupplierEntity> returnSupplierEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for returnSupplierEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for returnSupplierEntitiesWithNoRef here] end
		ReturnSupplierEntityFactory returnSupplierEntityFactory
	) {
		log.trace("Creating entities of type ReturnSupplierEntity with no reference");

		// % protected region % [Apply any additional logic for returnSupplierEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierEntitiesWithNoRef before the main body here] end

		Collection<ReturnSupplierEntity> newEntities = returnSupplierEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for returnSupplierEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ReturnSupplierEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Return Supplier entity with all references set.
	 */
	@Provides
	@Named("returnSupplierEntityWithRefs")
	public ReturnSupplierEntity returnSupplierEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for returnSupplierEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for returnSupplierEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ReturnSupplierEntity with references");

		// % protected region % [Apply any additional logic for returnSupplierEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierEntityWithRefs before the main body here] end

		ReturnSupplierEntity returnSupplierEntity = injector.getInstance(Key.get(ReturnSupplierEntity.class, Names.named("returnSupplierEntityWithNoRef")));

		// % protected region % [Apply any additional logic for returnSupplierEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierEntityWithRefs after the main body here] end

		log.trace("Created entity of type ReturnSupplierEntity with references");

		return returnSupplierEntity;
	}

	/**
	 * Return a collection of Return Supplier entities with all references set.
	 */
	@Provides
	@Named("returnSupplierEntitiesWithRefs")
	public Collection<ReturnSupplierEntity> returnSupplierEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for returnSupplierEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for returnSupplierEntitiesWithRefs here] end
		ReturnSupplierEntityFactory returnSupplierEntityFactory
	) {
		log.trace("Creating entities of type ReturnSupplierEntity with references");

		// % protected region % [Apply any additional logic for returnSupplierEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierEntitiesWithRefs before the main body here] end

		Collection<ReturnSupplierEntity> newEntities = returnSupplierEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for returnSupplierEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for returnSupplierEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ReturnSupplierEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
