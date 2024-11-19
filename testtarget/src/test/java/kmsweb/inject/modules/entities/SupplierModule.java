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
 * Guice module for Supplier used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class SupplierModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring SupplierModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured SupplierModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public SupplierEntityFactory supplierEntityFactory(
			// % protected region % [Apply any additional injected arguments for supplierEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for supplierEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating SupplierEntityFactory");

		// % protected region % [Apply any additional logic for supplierEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierEntityFactory before the main body here] end

		SupplierEntityFactory entityFactory = new SupplierEntityFactory(
				// % protected region % [Apply any additional constructor arguments for SupplierEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for SupplierEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for supplierEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierEntityFactory after the main body here] end

		log.trace("Created SupplierEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Supplier entity with no references set.
	 */
	@Provides
	@Named("supplierEntityWithNoRef")
	public SupplierEntity supplierEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for supplierEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for supplierEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type SupplierEntity with no reference");

		// % protected region % [Apply any additional logic for supplierWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierWithNoRef before the main body here] end

		SupplierEntity newEntity = new SupplierEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Supplier Number here] off begin
		String randomStringforSupplierNumber = mock
				.strings()
				.get();
		newEntity.setSupplierNumber(randomStringforSupplierNumber);
		// % protected region % [Add customisation for Supplier Number here] end
		// % protected region % [Add customisation for Supplier Name here] off begin
		String randomStringforSupplierName = mock
				.strings()
				.get();
		newEntity.setSupplierName(randomStringforSupplierName);
		// % protected region % [Add customisation for Supplier Name here] end
		// % protected region % [Add customisation for Tax ID here] off begin
		String randomStringforTaxID = mock
				.strings()
				.get();
		newEntity.setTaxID(randomStringforTaxID);
		// % protected region % [Add customisation for Tax ID here] end
		// % protected region % [Add customisation for Supply Stock Group here] off begin
		String randomStringforSupplyStockGroup = mock
				.strings()
				.get();
		newEntity.setSupplyStockGroup(randomStringforSupplyStockGroup);
		// % protected region % [Add customisation for Supply Stock Group here] end
		// % protected region % [Add customisation for Adress here] off begin
		String randomStringforAdress = mock
				.strings()
				.get();
		newEntity.setAdress(randomStringforAdress);
		// % protected region % [Add customisation for Adress here] end
		// % protected region % [Add customisation for Country here] off begin
		String randomStringforCountry = mock
				.strings()
				.get();
		newEntity.setCountry(randomStringforCountry);
		// % protected region % [Add customisation for Country here] end
		// % protected region % [Add customisation for State Province here] off begin
		String randomStringforStateProvince = mock
				.strings()
				.get();
		newEntity.setStateProvince(randomStringforStateProvince);
		// % protected region % [Add customisation for State Province here] end
		// % protected region % [Add customisation for City here] off begin
		String randomStringforCity = mock
				.strings()
				.get();
		newEntity.setCity(randomStringforCity);
		// % protected region % [Add customisation for City here] end
		// % protected region % [Add customisation for Postal Code here] off begin
		String randomStringforPostalCode = mock
				.strings()
				.get();
		newEntity.setPostalCode(randomStringforPostalCode);
		// % protected region % [Add customisation for Postal Code here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringforPhoneNumber = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setPhoneNumber(randomStringforPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Other Phone Number here] off begin
		String randomStringforOtherPhoneNumber = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setOtherPhoneNumber(randomStringforOtherPhoneNumber);
		// % protected region % [Add customisation for Other Phone Number here] end
		// % protected region % [Add customisation for Fax here] off begin
		String randomStringforFax = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setFax(randomStringforFax);
		// % protected region % [Add customisation for Fax here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.emails()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Website here] off begin
		String randomStringforWebsite = mock
				.strings()
				.get();
		newEntity.setWebsite(randomStringforWebsite);
		// % protected region % [Add customisation for Website here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Purchase Order Hold here] off begin
		newEntity.setPurchaseOrderHold(mock.bools().get());
		// % protected region % [Add customisation for Purchase Order Hold here] end
		// % protected region % [Add customisation for Purchase Order Hold Reason here] off begin
		String randomStringforPurchaseOrderHoldReason = mock
				.strings()
				.get();
		newEntity.setPurchaseOrderHoldReason(randomStringforPurchaseOrderHoldReason);
		// % protected region % [Add customisation for Purchase Order Hold Reason here] end
		// % protected region % [Add customisation for VAT Included here] off begin
		newEntity.setVatIncluded(mock.bools().get());
		// % protected region % [Add customisation for VAT Included here] end
		// % protected region % [Add customisation for Shipping Method here] off begin
		String randomStringforShippingMethod = mock
				.strings()
				.get();
		newEntity.setShippingMethod(randomStringforShippingMethod);
		// % protected region % [Add customisation for Shipping Method here] end
		// % protected region % [Add customisation for Lead Time Minimum here] off begin
		newEntity.setLeadTimeMinimum(mock.doubles().get());
		// % protected region % [Add customisation for Lead Time Minimum here] end
		// % protected region % [Add customisation for Lead Time Maximum here] off begin
		newEntity.setLeadTimeMaximum(mock.doubles().get());
		// % protected region % [Add customisation for Lead Time Maximum here] end
		// % protected region % [Add customisation for Last Purchase Date here] off begin
		newEntity.setLastPurchaseDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Last Purchase Date here] end
		// % protected region % [Add customisation for Last Purchase Order Number here] off begin
		String randomStringforLastPurchaseOrderNumber = mock
				.strings()
				.get();
		newEntity.setLastPurchaseOrderNumber(randomStringforLastPurchaseOrderNumber);
		// % protected region % [Add customisation for Last Purchase Order Number here] end
		// % protected region % [Add customisation for Lead Time Measurement here] off begin
		String randomStringforLeadTimeMeasurement = mock
				.strings()
				.get();
		newEntity.setLeadTimeMeasurement(randomStringforLeadTimeMeasurement);
		// % protected region % [Add customisation for Lead Time Measurement here] end

		// % protected region % [Apply any additional logic for supplierWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierWithNoRef after the main body here] end

		log.trace("Created entity of type SupplierEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Supplier entities with no reference at all.
	 */
	@Provides
	@Named("supplierEntitiesWithNoRef")
	public Collection<SupplierEntity> supplierEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for supplierEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for supplierEntitiesWithNoRef here] end
		SupplierEntityFactory supplierEntityFactory
	) {
		log.trace("Creating entities of type SupplierEntity with no reference");

		// % protected region % [Apply any additional logic for supplierEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierEntitiesWithNoRef before the main body here] end

		Collection<SupplierEntity> newEntities = supplierEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for supplierEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type SupplierEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Supplier entity with all references set.
	 */
	@Provides
	@Named("supplierEntityWithRefs")
	public SupplierEntity supplierEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for supplierEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for supplierEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type SupplierEntity with references");

		// % protected region % [Apply any additional logic for supplierEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierEntityWithRefs before the main body here] end

		SupplierEntity supplierEntity = injector.getInstance(Key.get(SupplierEntity.class, Names.named("supplierEntityWithNoRef")));

		// % protected region % [Apply any additional logic for supplierEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierEntityWithRefs after the main body here] end

		log.trace("Created entity of type SupplierEntity with references");

		return supplierEntity;
	}

	/**
	 * Return a collection of Supplier entities with all references set.
	 */
	@Provides
	@Named("supplierEntitiesWithRefs")
	public Collection<SupplierEntity> supplierEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for supplierEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for supplierEntitiesWithRefs here] end
		SupplierEntityFactory supplierEntityFactory
	) {
		log.trace("Creating entities of type SupplierEntity with references");

		// % protected region % [Apply any additional logic for supplierEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierEntitiesWithRefs before the main body here] end

		Collection<SupplierEntity> newEntities = supplierEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for supplierEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type SupplierEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
