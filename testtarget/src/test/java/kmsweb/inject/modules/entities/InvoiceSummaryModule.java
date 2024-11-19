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
 * Guice module for Invoice Summary used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InvoiceSummaryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InvoiceSummaryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InvoiceSummaryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InvoiceSummaryEntityFactory invoiceSummaryEntityFactory(
			// % protected region % [Apply any additional injected arguments for invoiceSummaryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for invoiceSummaryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InvoiceSummaryEntityFactory");

		// % protected region % [Apply any additional logic for invoiceSummaryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryEntityFactory before the main body here] end

		InvoiceSummaryEntityFactory entityFactory = new InvoiceSummaryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InvoiceSummaryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InvoiceSummaryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for invoiceSummaryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryEntityFactory after the main body here] end

		log.trace("Created InvoiceSummaryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Invoice Summary entity with no references set.
	 */
	@Provides
	@Named("invoiceSummaryEntityWithNoRef")
	public InvoiceSummaryEntity invoiceSummaryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for invoiceSummaryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for invoiceSummaryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InvoiceSummaryEntity with no reference");

		// % protected region % [Apply any additional logic for invoiceSummaryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryWithNoRef before the main body here] end

		InvoiceSummaryEntity newEntity = new InvoiceSummaryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Sub Total here] off begin
		newEntity.setSubTotal(mock.doubles().get());
		// % protected region % [Add customisation for Sub Total here] end
		// % protected region % [Add customisation for Tax On Other Discount here] off begin
		newEntity.setTaxOnOtherDiscount(mock.bools().get());
		// % protected region % [Add customisation for Tax On Other Discount here] end
		// % protected region % [Add customisation for Other Discount here] off begin
		newEntity.setOtherDiscount(mock.doubles().get());
		// % protected region % [Add customisation for Other Discount here] end
		// % protected region % [Add customisation for Tax On Other Fee here] off begin
		newEntity.setTaxOnOtherFee(mock.bools().get());
		// % protected region % [Add customisation for Tax On Other Fee here] end
		// % protected region % [Add customisation for Other Fee here] off begin
		newEntity.setOtherFee(mock.doubles().get());
		// % protected region % [Add customisation for Other Fee here] end
		// % protected region % [Add customisation for Tax here] off begin
		newEntity.setTax(mock.doubles().get());
		// % protected region % [Add customisation for Tax here] end
		// % protected region % [Add customisation for Total Invoice here] off begin
		newEntity.setTotalInvoice(mock.doubles().get());
		// % protected region % [Add customisation for Total Invoice here] end
		// % protected region % [Add customisation for Available Down Payment here] off begin
		newEntity.setAvailableDownPayment(mock.doubles().get());
		// % protected region % [Add customisation for Available Down Payment here] end
		// % protected region % [Add customisation for Total Coverage here] off begin
		newEntity.setTotalCoverage(mock.doubles().get());
		// % protected region % [Add customisation for Total Coverage here] end
		// % protected region % [Add customisation for Outstanding Amount here] off begin
		newEntity.setOutstandingAmount(mock.doubles().get());
		// % protected region % [Add customisation for Outstanding Amount here] end
		// % protected region % [Add customisation for BPJS Coverage here] off begin
		newEntity.setBpjsCoverage(mock.doubles().get());
		// % protected region % [Add customisation for BPJS Coverage here] end

		// % protected region % [Apply any additional logic for invoiceSummaryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryWithNoRef after the main body here] end

		log.trace("Created entity of type InvoiceSummaryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Invoice Summary entities with no reference at all.
	 */
	@Provides
	@Named("invoiceSummaryEntitiesWithNoRef")
	public Collection<InvoiceSummaryEntity> invoiceSummaryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for invoiceSummaryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for invoiceSummaryEntitiesWithNoRef here] end
		InvoiceSummaryEntityFactory invoiceSummaryEntityFactory
	) {
		log.trace("Creating entities of type InvoiceSummaryEntity with no reference");

		// % protected region % [Apply any additional logic for invoiceSummaryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryEntitiesWithNoRef before the main body here] end

		Collection<InvoiceSummaryEntity> newEntities = invoiceSummaryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for invoiceSummaryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InvoiceSummaryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Invoice Summary entity with all references set.
	 */
	@Provides
	@Named("invoiceSummaryEntityWithRefs")
	public InvoiceSummaryEntity invoiceSummaryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for invoiceSummaryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for invoiceSummaryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InvoiceSummaryEntity with references");

		// % protected region % [Apply any additional logic for invoiceSummaryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryEntityWithRefs before the main body here] end

		InvoiceSummaryEntity invoiceSummaryEntity = injector.getInstance(Key.get(InvoiceSummaryEntity.class, Names.named("invoiceSummaryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for invoiceSummaryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryEntityWithRefs after the main body here] end

		log.trace("Created entity of type InvoiceSummaryEntity with references");

		return invoiceSummaryEntity;
	}

	/**
	 * Return a collection of Invoice Summary entities with all references set.
	 */
	@Provides
	@Named("invoiceSummaryEntitiesWithRefs")
	public Collection<InvoiceSummaryEntity> invoiceSummaryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for invoiceSummaryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for invoiceSummaryEntitiesWithRefs here] end
		InvoiceSummaryEntityFactory invoiceSummaryEntityFactory
	) {
		log.trace("Creating entities of type InvoiceSummaryEntity with references");

		// % protected region % [Apply any additional logic for invoiceSummaryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryEntitiesWithRefs before the main body here] end

		Collection<InvoiceSummaryEntity> newEntities = invoiceSummaryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for invoiceSummaryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for invoiceSummaryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InvoiceSummaryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
