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
 * Guice module for Transaction Detail Type Mapping used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TransactionDetailTypeMappingModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TransactionDetailTypeMappingModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TransactionDetailTypeMappingModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TransactionDetailTypeMappingEntityFactory transactionDetailTypeMappingEntityFactory(
			// % protected region % [Apply any additional injected arguments for transactionDetailTypeMappingEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for transactionDetailTypeMappingEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TransactionDetailTypeMappingEntityFactory");

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntityFactory before the main body here] end

		TransactionDetailTypeMappingEntityFactory entityFactory = new TransactionDetailTypeMappingEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TransactionDetailTypeMappingEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TransactionDetailTypeMappingEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntityFactory after the main body here] end

		log.trace("Created TransactionDetailTypeMappingEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Transaction Detail Type Mapping entity with no references set.
	 */
	@Provides
	@Named("transactionDetailTypeMappingEntityWithNoRef")
	public TransactionDetailTypeMappingEntity transactionDetailTypeMappingEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for transactionDetailTypeMappingEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for transactionDetailTypeMappingEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TransactionDetailTypeMappingEntity with no reference");

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingWithNoRef before the main body here] end

		TransactionDetailTypeMappingEntity newEntity = new TransactionDetailTypeMappingEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Type here] off begin
		String randomStringforTransactionType = mock
				.strings()
				.get();
		newEntity.setTransactionType(randomStringforTransactionType);
		// % protected region % [Add customisation for Transaction Type here] end

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingWithNoRef after the main body here] end

		log.trace("Created entity of type TransactionDetailTypeMappingEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Transaction Detail Type Mapping entities with no reference at all.
	 */
	@Provides
	@Named("transactionDetailTypeMappingEntitiesWithNoRef")
	public Collection<TransactionDetailTypeMappingEntity> transactionDetailTypeMappingEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for transactionDetailTypeMappingEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for transactionDetailTypeMappingEntitiesWithNoRef here] end
		TransactionDetailTypeMappingEntityFactory transactionDetailTypeMappingEntityFactory
	) {
		log.trace("Creating entities of type TransactionDetailTypeMappingEntity with no reference");

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntitiesWithNoRef before the main body here] end

		Collection<TransactionDetailTypeMappingEntity> newEntities = transactionDetailTypeMappingEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TransactionDetailTypeMappingEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Transaction Detail Type Mapping entity with all references set.
	 */
	@Provides
	@Named("transactionDetailTypeMappingEntityWithRefs")
	public TransactionDetailTypeMappingEntity transactionDetailTypeMappingEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for transactionDetailTypeMappingEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for transactionDetailTypeMappingEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TransactionDetailTypeMappingEntity with references");

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntityWithRefs before the main body here] end

		TransactionDetailTypeMappingEntity transactionDetailTypeMappingEntity = injector.getInstance(Key.get(TransactionDetailTypeMappingEntity.class, Names.named("transactionDetailTypeMappingEntityWithNoRef")));

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntityWithRefs after the main body here] end

		log.trace("Created entity of type TransactionDetailTypeMappingEntity with references");

		return transactionDetailTypeMappingEntity;
	}

	/**
	 * Return a collection of Transaction Detail Type Mapping entities with all references set.
	 */
	@Provides
	@Named("transactionDetailTypeMappingEntitiesWithRefs")
	public Collection<TransactionDetailTypeMappingEntity> transactionDetailTypeMappingEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for transactionDetailTypeMappingEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for transactionDetailTypeMappingEntitiesWithRefs here] end
		TransactionDetailTypeMappingEntityFactory transactionDetailTypeMappingEntityFactory
	) {
		log.trace("Creating entities of type TransactionDetailTypeMappingEntity with references");

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntitiesWithRefs before the main body here] end

		Collection<TransactionDetailTypeMappingEntity> newEntities = transactionDetailTypeMappingEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeMappingEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TransactionDetailTypeMappingEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
