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
 * Guice module for Invoice Payment Self Paying used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InvoicePaymentSelfPayingModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InvoicePaymentSelfPayingModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InvoicePaymentSelfPayingModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InvoicePaymentSelfPayingEntityFactory invoicePaymentSelfPayingEntityFactory(
			// % protected region % [Apply any additional injected arguments for invoicePaymentSelfPayingEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for invoicePaymentSelfPayingEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InvoicePaymentSelfPayingEntityFactory");

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntityFactory before the main body here] end

		InvoicePaymentSelfPayingEntityFactory entityFactory = new InvoicePaymentSelfPayingEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InvoicePaymentSelfPayingEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InvoicePaymentSelfPayingEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntityFactory after the main body here] end

		log.trace("Created InvoicePaymentSelfPayingEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Invoice Payment Self Paying entity with no references set.
	 */
	@Provides
	@Named("invoicePaymentSelfPayingEntityWithNoRef")
	public InvoicePaymentSelfPayingEntity invoicePaymentSelfPayingEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for invoicePaymentSelfPayingEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for invoicePaymentSelfPayingEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InvoicePaymentSelfPayingEntity with no reference");

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingWithNoRef before the main body here] end

		InvoicePaymentSelfPayingEntity newEntity = new InvoicePaymentSelfPayingEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Sponsor Name here] off begin
		String randomStringforSponsorName = mock
				.strings()
				.get();
		newEntity.setSponsorName(randomStringforSponsorName);
		// % protected region % [Add customisation for Sponsor Name here] end
		// % protected region % [Add customisation for Sponsor Address here] off begin
		String randomStringforSponsorAddress = mock
				.strings()
				.get();
		newEntity.setSponsorAddress(randomStringforSponsorAddress);
		// % protected region % [Add customisation for Sponsor Address here] end
		// % protected region % [Add customisation for Sponsor Phone No here] off begin
		String randomStringforSponsorPhoneNo = mock
				.strings()
				.get();
		newEntity.setSponsorPhoneNo(randomStringforSponsorPhoneNo);
		// % protected region % [Add customisation for Sponsor Phone No here] end
		// % protected region % [Add customisation for Sponsorship here] off begin
		String randomStringforSponsorship = mock
				.strings()
				.get();
		newEntity.setSponsorship(randomStringforSponsorship);
		// % protected region % [Add customisation for Sponsorship here] end

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingWithNoRef after the main body here] end

		log.trace("Created entity of type InvoicePaymentSelfPayingEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Invoice Payment Self Paying entities with no reference at all.
	 */
	@Provides
	@Named("invoicePaymentSelfPayingEntitiesWithNoRef")
	public Collection<InvoicePaymentSelfPayingEntity> invoicePaymentSelfPayingEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for invoicePaymentSelfPayingEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for invoicePaymentSelfPayingEntitiesWithNoRef here] end
		InvoicePaymentSelfPayingEntityFactory invoicePaymentSelfPayingEntityFactory
	) {
		log.trace("Creating entities of type InvoicePaymentSelfPayingEntity with no reference");

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntitiesWithNoRef before the main body here] end

		Collection<InvoicePaymentSelfPayingEntity> newEntities = invoicePaymentSelfPayingEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InvoicePaymentSelfPayingEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Invoice Payment Self Paying entity with all references set.
	 */
	@Provides
	@Named("invoicePaymentSelfPayingEntityWithRefs")
	public InvoicePaymentSelfPayingEntity invoicePaymentSelfPayingEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for invoicePaymentSelfPayingEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for invoicePaymentSelfPayingEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InvoicePaymentSelfPayingEntity with references");

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntityWithRefs before the main body here] end

		InvoicePaymentSelfPayingEntity invoicePaymentSelfPayingEntity = injector.getInstance(Key.get(InvoicePaymentSelfPayingEntity.class, Names.named("invoicePaymentSelfPayingEntityWithNoRef")));

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntityWithRefs after the main body here] end

		log.trace("Created entity of type InvoicePaymentSelfPayingEntity with references");

		return invoicePaymentSelfPayingEntity;
	}

	/**
	 * Return a collection of Invoice Payment Self Paying entities with all references set.
	 */
	@Provides
	@Named("invoicePaymentSelfPayingEntitiesWithRefs")
	public Collection<InvoicePaymentSelfPayingEntity> invoicePaymentSelfPayingEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for invoicePaymentSelfPayingEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for invoicePaymentSelfPayingEntitiesWithRefs here] end
		InvoicePaymentSelfPayingEntityFactory invoicePaymentSelfPayingEntityFactory
	) {
		log.trace("Creating entities of type InvoicePaymentSelfPayingEntity with references");

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntitiesWithRefs before the main body here] end

		Collection<InvoicePaymentSelfPayingEntity> newEntities = invoicePaymentSelfPayingEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentSelfPayingEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InvoicePaymentSelfPayingEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
