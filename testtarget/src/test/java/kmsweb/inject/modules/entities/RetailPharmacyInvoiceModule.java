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
 * Guice module for Retail Pharmacy Invoice used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class RetailPharmacyInvoiceModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring RetailPharmacyInvoiceModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured RetailPharmacyInvoiceModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public RetailPharmacyInvoiceEntityFactory retailPharmacyInvoiceEntityFactory(
			// % protected region % [Apply any additional injected arguments for retailPharmacyInvoiceEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for retailPharmacyInvoiceEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating RetailPharmacyInvoiceEntityFactory");

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntityFactory before the main body here] end

		RetailPharmacyInvoiceEntityFactory entityFactory = new RetailPharmacyInvoiceEntityFactory(
				// % protected region % [Apply any additional constructor arguments for RetailPharmacyInvoiceEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for RetailPharmacyInvoiceEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntityFactory after the main body here] end

		log.trace("Created RetailPharmacyInvoiceEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Retail Pharmacy Invoice entity with no references set.
	 */
	@Provides
	@Named("retailPharmacyInvoiceEntityWithNoRef")
	public RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for retailPharmacyInvoiceEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for retailPharmacyInvoiceEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type RetailPharmacyInvoiceEntity with no reference");

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceWithNoRef before the main body here] end

		RetailPharmacyInvoiceEntity newEntity = new RetailPharmacyInvoiceEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Invoice Number here] off begin
		String randomStringforInvoiceNumber = mock
				.strings()
				.get();
		newEntity.setInvoiceNumber(randomStringforInvoiceNumber);
		// % protected region % [Add customisation for Invoice Number here] end
		// % protected region % [Add customisation for Revision Number here] off begin
		newEntity.setRevisionNumber(mock.ints().get());
		// % protected region % [Add customisation for Revision Number here] end
		// % protected region % [Add customisation for Invoice Status here] off begin
		String randomStringforInvoiceStatus = mock
				.strings()
				.get();
		newEntity.setInvoiceStatus(randomStringforInvoiceStatus);
		// % protected region % [Add customisation for Invoice Status here] end
		// % protected region % [Add customisation for Invoice Date here] off begin
		newEntity.setInvoiceDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Invoice Date here] end
		// % protected region % [Add customisation for Cancel Date here] off begin
		newEntity.setCancelDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Cancel Date here] end
		// % protected region % [Add customisation for Billing Location here] off begin
		String randomStringforBillingLocation = mock
				.strings()
				.get();
		newEntity.setBillingLocation(randomStringforBillingLocation);
		// % protected region % [Add customisation for Billing Location here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Patient Payment Type here] off begin
		String randomStringforPatientPaymentType = mock
				.strings()
				.get();
		newEntity.setPatientPaymentType(randomStringforPatientPaymentType);
		// % protected region % [Add customisation for Patient Payment Type here] end
		// % protected region % [Add customisation for Verification Date here] off begin
		newEntity.setVerificationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Verification Date here] end
		// % protected region % [Add customisation for Display Doctor on Print here] off begin
		newEntity.setDisplayDoctorOnPrint(mock.bools().get());
		// % protected region % [Add customisation for Display Doctor on Print here] end
		// % protected region % [Add customisation for Claim No here] off begin
		String randomStringforClaimNo = mock
				.strings()
				.get();
		newEntity.setClaimNo(randomStringforClaimNo);
		// % protected region % [Add customisation for Claim No here] end
		// % protected region % [Add customisation for Payment Status here] off begin
		String randomStringforPaymentStatus = mock
				.strings()
				.get();
		newEntity.setPaymentStatus(randomStringforPaymentStatus);
		// % protected region % [Add customisation for Payment Status here] end
		// % protected region % [Add customisation for Invoice Amount here] off begin
		newEntity.setInvoiceAmount(mock.doubles().get());
		// % protected region % [Add customisation for Invoice Amount here] end
		// % protected region % [Add customisation for Outstanding Amount here] off begin
		newEntity.setOutstandingAmount(mock.doubles().get());
		// % protected region % [Add customisation for Outstanding Amount here] end
		// % protected region % [Add customisation for Customer Name here] off begin
		String randomStringforCustomerName = mock
				.strings()
				.get();
		newEntity.setCustomerName(randomStringforCustomerName);
		// % protected region % [Add customisation for Customer Name here] end

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceWithNoRef after the main body here] end

		log.trace("Created entity of type RetailPharmacyInvoiceEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Retail Pharmacy Invoice entities with no reference at all.
	 */
	@Provides
	@Named("retailPharmacyInvoiceEntitiesWithNoRef")
	public Collection<RetailPharmacyInvoiceEntity> retailPharmacyInvoiceEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for retailPharmacyInvoiceEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for retailPharmacyInvoiceEntitiesWithNoRef here] end
		RetailPharmacyInvoiceEntityFactory retailPharmacyInvoiceEntityFactory
	) {
		log.trace("Creating entities of type RetailPharmacyInvoiceEntity with no reference");

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntitiesWithNoRef before the main body here] end

		Collection<RetailPharmacyInvoiceEntity> newEntities = retailPharmacyInvoiceEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type RetailPharmacyInvoiceEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Retail Pharmacy Invoice entity with all references set.
	 */
	@Provides
	@Named("retailPharmacyInvoiceEntityWithRefs")
	public RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for retailPharmacyInvoiceEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for retailPharmacyInvoiceEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type RetailPharmacyInvoiceEntity with references");

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntityWithRefs before the main body here] end

		RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity = injector.getInstance(Key.get(RetailPharmacyInvoiceEntity.class, Names.named("retailPharmacyInvoiceEntityWithNoRef")));

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntityWithRefs after the main body here] end

		log.trace("Created entity of type RetailPharmacyInvoiceEntity with references");

		return retailPharmacyInvoiceEntity;
	}

	/**
	 * Return a collection of Retail Pharmacy Invoice entities with all references set.
	 */
	@Provides
	@Named("retailPharmacyInvoiceEntitiesWithRefs")
	public Collection<RetailPharmacyInvoiceEntity> retailPharmacyInvoiceEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for retailPharmacyInvoiceEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for retailPharmacyInvoiceEntitiesWithRefs here] end
		RetailPharmacyInvoiceEntityFactory retailPharmacyInvoiceEntityFactory
	) {
		log.trace("Creating entities of type RetailPharmacyInvoiceEntity with references");

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntitiesWithRefs before the main body here] end

		Collection<RetailPharmacyInvoiceEntity> newEntities = retailPharmacyInvoiceEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for retailPharmacyInvoiceEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type RetailPharmacyInvoiceEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
