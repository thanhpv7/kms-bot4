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
 * Guice module for Invoice Payment Other used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InvoicePaymentOtherModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InvoicePaymentOtherModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InvoicePaymentOtherModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InvoicePaymentOtherEntityFactory invoicePaymentOtherEntityFactory(
			// % protected region % [Apply any additional injected arguments for invoicePaymentOtherEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for invoicePaymentOtherEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InvoicePaymentOtherEntityFactory");

		// % protected region % [Apply any additional logic for invoicePaymentOtherEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherEntityFactory before the main body here] end

		InvoicePaymentOtherEntityFactory entityFactory = new InvoicePaymentOtherEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InvoicePaymentOtherEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InvoicePaymentOtherEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for invoicePaymentOtherEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherEntityFactory after the main body here] end

		log.trace("Created InvoicePaymentOtherEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Invoice Payment Other entity with no references set.
	 */
	@Provides
	@Named("invoicePaymentOtherEntityWithNoRef")
	public InvoicePaymentOtherEntity invoicePaymentOtherEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for invoicePaymentOtherEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for invoicePaymentOtherEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InvoicePaymentOtherEntity with no reference");

		// % protected region % [Apply any additional logic for invoicePaymentOtherWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherWithNoRef before the main body here] end

		InvoicePaymentOtherEntity newEntity = new InvoicePaymentOtherEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Tax Amount here] off begin
		newEntity.setTaxAmount(mock.doubles().get());
		// % protected region % [Add customisation for Tax Amount here] end

		// % protected region % [Apply any additional logic for invoicePaymentOtherWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherWithNoRef after the main body here] end

		log.trace("Created entity of type InvoicePaymentOtherEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Invoice Payment Other entities with no reference at all.
	 */
	@Provides
	@Named("invoicePaymentOtherEntitiesWithNoRef")
	public Collection<InvoicePaymentOtherEntity> invoicePaymentOtherEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for invoicePaymentOtherEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for invoicePaymentOtherEntitiesWithNoRef here] end
		InvoicePaymentOtherEntityFactory invoicePaymentOtherEntityFactory
	) {
		log.trace("Creating entities of type InvoicePaymentOtherEntity with no reference");

		// % protected region % [Apply any additional logic for invoicePaymentOtherEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherEntitiesWithNoRef before the main body here] end

		Collection<InvoicePaymentOtherEntity> newEntities = invoicePaymentOtherEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for invoicePaymentOtherEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InvoicePaymentOtherEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Invoice Payment Other entity with all references set.
	 */
	@Provides
	@Named("invoicePaymentOtherEntityWithRefs")
	public InvoicePaymentOtherEntity invoicePaymentOtherEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for invoicePaymentOtherEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for invoicePaymentOtherEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InvoicePaymentOtherEntity with references");

		// % protected region % [Apply any additional logic for invoicePaymentOtherEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherEntityWithRefs before the main body here] end

		InvoicePaymentOtherEntity invoicePaymentOtherEntity = injector.getInstance(Key.get(InvoicePaymentOtherEntity.class, Names.named("invoicePaymentOtherEntityWithNoRef")));

		// % protected region % [Apply any additional logic for invoicePaymentOtherEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherEntityWithRefs after the main body here] end

		log.trace("Created entity of type InvoicePaymentOtherEntity with references");

		return invoicePaymentOtherEntity;
	}

	/**
	 * Return a collection of Invoice Payment Other entities with all references set.
	 */
	@Provides
	@Named("invoicePaymentOtherEntitiesWithRefs")
	public Collection<InvoicePaymentOtherEntity> invoicePaymentOtherEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for invoicePaymentOtherEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for invoicePaymentOtherEntitiesWithRefs here] end
		InvoicePaymentOtherEntityFactory invoicePaymentOtherEntityFactory
	) {
		log.trace("Creating entities of type InvoicePaymentOtherEntity with references");

		// % protected region % [Apply any additional logic for invoicePaymentOtherEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherEntitiesWithRefs before the main body here] end

		Collection<InvoicePaymentOtherEntity> newEntities = invoicePaymentOtherEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for invoicePaymentOtherEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoicePaymentOtherEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InvoicePaymentOtherEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
