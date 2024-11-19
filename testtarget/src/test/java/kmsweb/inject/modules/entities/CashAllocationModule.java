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
 * Guice module for Cash Allocation used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class CashAllocationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring CashAllocationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured CashAllocationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public CashAllocationEntityFactory cashAllocationEntityFactory(
			// % protected region % [Apply any additional injected arguments for cashAllocationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for cashAllocationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating CashAllocationEntityFactory");

		// % protected region % [Apply any additional logic for cashAllocationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationEntityFactory before the main body here] end

		CashAllocationEntityFactory entityFactory = new CashAllocationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for CashAllocationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for CashAllocationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for cashAllocationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationEntityFactory after the main body here] end

		log.trace("Created CashAllocationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Cash Allocation entity with no references set.
	 */
	@Provides
	@Named("cashAllocationEntityWithNoRef")
	public CashAllocationEntity cashAllocationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for cashAllocationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for cashAllocationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type CashAllocationEntity with no reference");

		// % protected region % [Apply any additional logic for cashAllocationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationWithNoRef before the main body here] end

		CashAllocationEntity newEntity = new CashAllocationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Cash Type here] off begin
		newEntity.setCashType(CashTypeEnum.REFUND);
		// % protected region % [Add customisation for Cash Type here] end
		// % protected region % [Add customisation for Allocated Date here] off begin
		newEntity.setAllocatedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Allocated Date here] end
		// % protected region % [Add customisation for Source Date here] off begin
		newEntity.setSourceDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Source Date here] end
		// % protected region % [Add customisation for Cash Number here] off begin
		String randomStringforCashNumber = mock
				.strings()
				.get();
		newEntity.setCashNumber(randomStringforCashNumber);
		// % protected region % [Add customisation for Cash Number here] end
		// % protected region % [Add customisation for Source Document Type here] off begin
		newEntity.setSourceDocumentType(SourceDocumentTypeEnum.PATIENT_RECEIPT);
		// % protected region % [Add customisation for Source Document Type here] end
		// % protected region % [Add customisation for Source Number here] off begin
		String randomStringforSourceNumber = mock
				.strings()
				.get();
		newEntity.setSourceNumber(randomStringforSourceNumber);
		// % protected region % [Add customisation for Source Number here] end
		// % protected region % [Add customisation for Source Amount here] off begin
		newEntity.setSourceAmount(mock.doubles().get());
		// % protected region % [Add customisation for Source Amount here] end
		// % protected region % [Add customisation for Outstanding Amount here] off begin
		newEntity.setOutstandingAmount(mock.doubles().get());
		// % protected region % [Add customisation for Outstanding Amount here] end
		// % protected region % [Add customisation for Allocated Amount here] off begin
		newEntity.setAllocatedAmount(mock.doubles().get());
		// % protected region % [Add customisation for Allocated Amount here] end

		// % protected region % [Apply any additional logic for cashAllocationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationWithNoRef after the main body here] end

		log.trace("Created entity of type CashAllocationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Cash Allocation entities with no reference at all.
	 */
	@Provides
	@Named("cashAllocationEntitiesWithNoRef")
	public Collection<CashAllocationEntity> cashAllocationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for cashAllocationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for cashAllocationEntitiesWithNoRef here] end
		CashAllocationEntityFactory cashAllocationEntityFactory
	) {
		log.trace("Creating entities of type CashAllocationEntity with no reference");

		// % protected region % [Apply any additional logic for cashAllocationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationEntitiesWithNoRef before the main body here] end

		Collection<CashAllocationEntity> newEntities = cashAllocationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for cashAllocationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type CashAllocationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Cash Allocation entity with all references set.
	 */
	@Provides
	@Named("cashAllocationEntityWithRefs")
	public CashAllocationEntity cashAllocationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for cashAllocationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for cashAllocationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type CashAllocationEntity with references");

		// % protected region % [Apply any additional logic for cashAllocationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationEntityWithRefs before the main body here] end

		CashAllocationEntity cashAllocationEntity = injector.getInstance(Key.get(CashAllocationEntity.class, Names.named("cashAllocationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for cashAllocationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationEntityWithRefs after the main body here] end

		log.trace("Created entity of type CashAllocationEntity with references");

		return cashAllocationEntity;
	}

	/**
	 * Return a collection of Cash Allocation entities with all references set.
	 */
	@Provides
	@Named("cashAllocationEntitiesWithRefs")
	public Collection<CashAllocationEntity> cashAllocationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for cashAllocationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for cashAllocationEntitiesWithRefs here] end
		CashAllocationEntityFactory cashAllocationEntityFactory
	) {
		log.trace("Creating entities of type CashAllocationEntity with references");

		// % protected region % [Apply any additional logic for cashAllocationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationEntitiesWithRefs before the main body here] end

		Collection<CashAllocationEntity> newEntities = cashAllocationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for cashAllocationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for cashAllocationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type CashAllocationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
