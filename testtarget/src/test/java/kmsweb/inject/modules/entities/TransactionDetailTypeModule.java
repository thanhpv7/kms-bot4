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
 * Guice module for Transaction Detail Type used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TransactionDetailTypeModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TransactionDetailTypeModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TransactionDetailTypeModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TransactionDetailTypeEntityFactory transactionDetailTypeEntityFactory(
			// % protected region % [Apply any additional injected arguments for transactionDetailTypeEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for transactionDetailTypeEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TransactionDetailTypeEntityFactory");

		// % protected region % [Apply any additional logic for transactionDetailTypeEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeEntityFactory before the main body here] end

		TransactionDetailTypeEntityFactory entityFactory = new TransactionDetailTypeEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TransactionDetailTypeEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TransactionDetailTypeEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for transactionDetailTypeEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeEntityFactory after the main body here] end

		log.trace("Created TransactionDetailTypeEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Transaction Detail Type entity with no references set.
	 */
	@Provides
	@Named("transactionDetailTypeEntityWithNoRef")
	public TransactionDetailTypeEntity transactionDetailTypeEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for transactionDetailTypeEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for transactionDetailTypeEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TransactionDetailTypeEntity with no reference");

		// % protected region % [Apply any additional logic for transactionDetailTypeWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeWithNoRef before the main body here] end

		TransactionDetailTypeEntity newEntity = new TransactionDetailTypeEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Detail here] off begin
		String randomStringforTransactionDetail = mock
				.strings()
				.get();
		newEntity.setTransactionDetail(randomStringforTransactionDetail);
		// % protected region % [Add customisation for Transaction Detail here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for COA COGS here] off begin
		String randomStringforCoaCOGS = mock
				.strings()
				.get();
		newEntity.setCoaCOGS(randomStringforCoaCOGS);
		// % protected region % [Add customisation for COA COGS here] end
		// % protected region % [Add customisation for COA Sell here] off begin
		String randomStringforCoaSell = mock
				.strings()
				.get();
		newEntity.setCoaSell(randomStringforCoaSell);
		// % protected region % [Add customisation for COA Sell here] end
		// % protected region % [Add customisation for COA Inventory here] off begin
		String randomStringforCoaInventory = mock
				.strings()
				.get();
		newEntity.setCoaInventory(randomStringforCoaInventory);
		// % protected region % [Add customisation for COA Inventory here] end

		// % protected region % [Apply any additional logic for transactionDetailTypeWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeWithNoRef after the main body here] end

		log.trace("Created entity of type TransactionDetailTypeEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Transaction Detail Type entities with no reference at all.
	 */
	@Provides
	@Named("transactionDetailTypeEntitiesWithNoRef")
	public Collection<TransactionDetailTypeEntity> transactionDetailTypeEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for transactionDetailTypeEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for transactionDetailTypeEntitiesWithNoRef here] end
		TransactionDetailTypeEntityFactory transactionDetailTypeEntityFactory
	) {
		log.trace("Creating entities of type TransactionDetailTypeEntity with no reference");

		// % protected region % [Apply any additional logic for transactionDetailTypeEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeEntitiesWithNoRef before the main body here] end

		Collection<TransactionDetailTypeEntity> newEntities = transactionDetailTypeEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for transactionDetailTypeEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TransactionDetailTypeEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Transaction Detail Type entity with all references set.
	 */
	@Provides
	@Named("transactionDetailTypeEntityWithRefs")
	public TransactionDetailTypeEntity transactionDetailTypeEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for transactionDetailTypeEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for transactionDetailTypeEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TransactionDetailTypeEntity with references");

		// % protected region % [Apply any additional logic for transactionDetailTypeEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeEntityWithRefs before the main body here] end

		TransactionDetailTypeEntity transactionDetailTypeEntity = injector.getInstance(Key.get(TransactionDetailTypeEntity.class, Names.named("transactionDetailTypeEntityWithNoRef")));

		// % protected region % [Apply any additional logic for transactionDetailTypeEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeEntityWithRefs after the main body here] end

		log.trace("Created entity of type TransactionDetailTypeEntity with references");

		return transactionDetailTypeEntity;
	}

	/**
	 * Return a collection of Transaction Detail Type entities with all references set.
	 */
	@Provides
	@Named("transactionDetailTypeEntitiesWithRefs")
	public Collection<TransactionDetailTypeEntity> transactionDetailTypeEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for transactionDetailTypeEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for transactionDetailTypeEntitiesWithRefs here] end
		TransactionDetailTypeEntityFactory transactionDetailTypeEntityFactory
	) {
		log.trace("Creating entities of type TransactionDetailTypeEntity with references");

		// % protected region % [Apply any additional logic for transactionDetailTypeEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeEntitiesWithRefs before the main body here] end

		Collection<TransactionDetailTypeEntity> newEntities = transactionDetailTypeEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for transactionDetailTypeEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for transactionDetailTypeEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TransactionDetailTypeEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
