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
 * Guice module for Invoice Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InvoiceItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InvoiceItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InvoiceItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InvoiceItemEntityFactory invoiceItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for invoiceItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for invoiceItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InvoiceItemEntityFactory");

		// % protected region % [Apply any additional logic for invoiceItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemEntityFactory before the main body here] end

		InvoiceItemEntityFactory entityFactory = new InvoiceItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InvoiceItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InvoiceItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for invoiceItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemEntityFactory after the main body here] end

		log.trace("Created InvoiceItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Invoice Item entity with no references set.
	 */
	@Provides
	@Named("invoiceItemEntityWithNoRef")
	public InvoiceItemEntity invoiceItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for invoiceItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for invoiceItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InvoiceItemEntity with no reference");

		// % protected region % [Apply any additional logic for invoiceItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemWithNoRef before the main body here] end

		InvoiceItemEntity newEntity = new InvoiceItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Tariff Code here] off begin
		String randomStringforTariffCode = mock
				.strings()
				.get();
		newEntity.setTariffCode(randomStringforTariffCode);
		// % protected region % [Add customisation for Tariff Code here] end
		// % protected region % [Add customisation for Tariff Type here] off begin
		newEntity.setTariffType(TariffTypeEnum.ROOM);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringforName = mock
				.strings()
				.get();
		newEntity.setName(randomStringforName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Medical Staff Code here] off begin
		String randomStringforMedicalStaffCode = mock
				.strings()
				.get();
		newEntity.setMedicalStaffCode(randomStringforMedicalStaffCode);
		// % protected region % [Add customisation for Medical Staff Code here] end
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mock.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Hospital Price here] off begin
		newEntity.setHospitalPrice(mock.doubles().get());
		// % protected region % [Add customisation for Hospital Price here] end
		// % protected region % [Add customisation for Total Other Component Price here] off begin
		newEntity.setTotalOtherComponentPrice(mock.doubles().get());
		// % protected region % [Add customisation for Total Other Component Price here] end
		// % protected region % [Add customisation for Quantity here] off begin
		newEntity.setQuantity(mock.doubles().get());
		// % protected region % [Add customisation for Quantity here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringforUnit = mock
				.strings()
				.get();
		newEntity.setUnit(randomStringforUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Discount here] off begin
		newEntity.setDiscount(mock.doubles().get());
		// % protected region % [Add customisation for Discount here] end
		// % protected region % [Add customisation for Tax here] off begin
		newEntity.setTax(mock.bools().get());
		// % protected region % [Add customisation for Tax here] end
		// % protected region % [Add customisation for Item Total here] off begin
		newEntity.setItemTotal(mock.doubles().get());
		// % protected region % [Add customisation for Item Total here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.size(500)
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for invoiceItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemWithNoRef after the main body here] end

		log.trace("Created entity of type InvoiceItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Invoice Item entities with no reference at all.
	 */
	@Provides
	@Named("invoiceItemEntitiesWithNoRef")
	public Collection<InvoiceItemEntity> invoiceItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for invoiceItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for invoiceItemEntitiesWithNoRef here] end
		InvoiceItemEntityFactory invoiceItemEntityFactory
	) {
		log.trace("Creating entities of type InvoiceItemEntity with no reference");

		// % protected region % [Apply any additional logic for invoiceItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemEntitiesWithNoRef before the main body here] end

		Collection<InvoiceItemEntity> newEntities = invoiceItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for invoiceItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InvoiceItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Invoice Item entity with all references set.
	 */
	@Provides
	@Named("invoiceItemEntityWithRefs")
	public InvoiceItemEntity invoiceItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for invoiceItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for invoiceItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InvoiceItemEntity with references");

		// % protected region % [Apply any additional logic for invoiceItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemEntityWithRefs before the main body here] end

		InvoiceItemEntity invoiceItemEntity = injector.getInstance(Key.get(InvoiceItemEntity.class, Names.named("invoiceItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for invoiceItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type InvoiceItemEntity with references");

		return invoiceItemEntity;
	}

	/**
	 * Return a collection of Invoice Item entities with all references set.
	 */
	@Provides
	@Named("invoiceItemEntitiesWithRefs")
	public Collection<InvoiceItemEntity> invoiceItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for invoiceItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for invoiceItemEntitiesWithRefs here] end
		InvoiceItemEntityFactory invoiceItemEntityFactory
	) {
		log.trace("Creating entities of type InvoiceItemEntity with references");

		// % protected region % [Apply any additional logic for invoiceItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemEntitiesWithRefs before the main body here] end

		Collection<InvoiceItemEntity> newEntities = invoiceItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for invoiceItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InvoiceItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
