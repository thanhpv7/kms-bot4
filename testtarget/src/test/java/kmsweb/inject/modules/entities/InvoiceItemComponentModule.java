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
 * Guice module for Invoice Item Component used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InvoiceItemComponentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InvoiceItemComponentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InvoiceItemComponentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InvoiceItemComponentEntityFactory invoiceItemComponentEntityFactory(
			// % protected region % [Apply any additional injected arguments for invoiceItemComponentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for invoiceItemComponentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InvoiceItemComponentEntityFactory");

		// % protected region % [Apply any additional logic for invoiceItemComponentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentEntityFactory before the main body here] end

		InvoiceItemComponentEntityFactory entityFactory = new InvoiceItemComponentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InvoiceItemComponentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InvoiceItemComponentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for invoiceItemComponentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentEntityFactory after the main body here] end

		log.trace("Created InvoiceItemComponentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Invoice Item Component entity with no references set.
	 */
	@Provides
	@Named("invoiceItemComponentEntityWithNoRef")
	public InvoiceItemComponentEntity invoiceItemComponentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for invoiceItemComponentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for invoiceItemComponentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InvoiceItemComponentEntity with no reference");

		// % protected region % [Apply any additional logic for invoiceItemComponentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentWithNoRef before the main body here] end

		InvoiceItemComponentEntity newEntity = new InvoiceItemComponentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mock.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Medical Staff here] off begin
		String randomStringforMedicalStaff = mock
				.strings()
				.get();
		newEntity.setMedicalStaff(randomStringforMedicalStaff);
		// % protected region % [Add customisation for Medical Staff here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for invoiceItemComponentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentWithNoRef after the main body here] end

		log.trace("Created entity of type InvoiceItemComponentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Invoice Item Component entities with no reference at all.
	 */
	@Provides
	@Named("invoiceItemComponentEntitiesWithNoRef")
	public Collection<InvoiceItemComponentEntity> invoiceItemComponentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for invoiceItemComponentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for invoiceItemComponentEntitiesWithNoRef here] end
		InvoiceItemComponentEntityFactory invoiceItemComponentEntityFactory
	) {
		log.trace("Creating entities of type InvoiceItemComponentEntity with no reference");

		// % protected region % [Apply any additional logic for invoiceItemComponentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentEntitiesWithNoRef before the main body here] end

		Collection<InvoiceItemComponentEntity> newEntities = invoiceItemComponentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for invoiceItemComponentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InvoiceItemComponentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Invoice Item Component entity with all references set.
	 */
	@Provides
	@Named("invoiceItemComponentEntityWithRefs")
	public InvoiceItemComponentEntity invoiceItemComponentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for invoiceItemComponentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for invoiceItemComponentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InvoiceItemComponentEntity with references");

		// % protected region % [Apply any additional logic for invoiceItemComponentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentEntityWithRefs before the main body here] end

		InvoiceItemComponentEntity invoiceItemComponentEntity = injector.getInstance(Key.get(InvoiceItemComponentEntity.class, Names.named("invoiceItemComponentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for invoiceItemComponentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentEntityWithRefs after the main body here] end

		log.trace("Created entity of type InvoiceItemComponentEntity with references");

		return invoiceItemComponentEntity;
	}

	/**
	 * Return a collection of Invoice Item Component entities with all references set.
	 */
	@Provides
	@Named("invoiceItemComponentEntitiesWithRefs")
	public Collection<InvoiceItemComponentEntity> invoiceItemComponentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for invoiceItemComponentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for invoiceItemComponentEntitiesWithRefs here] end
		InvoiceItemComponentEntityFactory invoiceItemComponentEntityFactory
	) {
		log.trace("Creating entities of type InvoiceItemComponentEntity with references");

		// % protected region % [Apply any additional logic for invoiceItemComponentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentEntitiesWithRefs before the main body here] end

		Collection<InvoiceItemComponentEntity> newEntities = invoiceItemComponentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for invoiceItemComponentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceItemComponentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InvoiceItemComponentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
