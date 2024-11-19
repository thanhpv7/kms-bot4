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
 * Guice module for Journal used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class JournalModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring JournalModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured JournalModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public JournalEntityFactory journalEntityFactory(
			// % protected region % [Apply any additional injected arguments for journalEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for journalEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating JournalEntityFactory");

		// % protected region % [Apply any additional logic for journalEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for journalEntityFactory before the main body here] end

		JournalEntityFactory entityFactory = new JournalEntityFactory(
				// % protected region % [Apply any additional constructor arguments for JournalEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for JournalEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for journalEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for journalEntityFactory after the main body here] end

		log.trace("Created JournalEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Journal entity with no references set.
	 */
	@Provides
	@Named("journalEntityWithNoRef")
	public JournalEntity journalEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for journalEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for journalEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type JournalEntity with no reference");

		// % protected region % [Apply any additional logic for journalWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for journalWithNoRef before the main body here] end

		JournalEntity newEntity = new JournalEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Journal Number here] off begin
		String randomStringforJournalNumber = mock
				.strings()
				.get();
		newEntity.setJournalNumber(randomStringforJournalNumber);
		// % protected region % [Add customisation for Journal Number here] end
		// % protected region % [Add customisation for Transaction Date here] off begin
		newEntity.setTransactionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Transaction Date here] end
		// % protected region % [Add customisation for Reference Number here] off begin
		String randomStringforReferenceNumber = mock
				.strings()
				.get();
		newEntity.setReferenceNumber(randomStringforReferenceNumber);
		// % protected region % [Add customisation for Reference Number here] end
		// % protected region % [Add customisation for Transaction Type here] off begin
		String randomStringforTransactionType = mock
				.strings()
				.get();
		newEntity.setTransactionType(randomStringforTransactionType);
		// % protected region % [Add customisation for Transaction Type here] end
		// % protected region % [Add customisation for Transaction Detail Type here] off begin
		String randomStringforTransactionDetailType = mock
				.strings()
				.get();
		newEntity.setTransactionDetailType(randomStringforTransactionDetailType);
		// % protected region % [Add customisation for Transaction Detail Type here] end
		// % protected region % [Add customisation for Account Number here] off begin
		String randomStringforAccountNumber = mock
				.strings()
				.get();
		newEntity.setAccountNumber(randomStringforAccountNumber);
		// % protected region % [Add customisation for Account Number here] end
		// % protected region % [Add customisation for Debit here] off begin
		newEntity.setDebit(mock.doubles().get());
		// % protected region % [Add customisation for Debit here] end
		// % protected region % [Add customisation for Credit here] off begin
		newEntity.setCredit(mock.doubles().get());
		// % protected region % [Add customisation for Credit here] end
		// % protected region % [Add customisation for Posting Status here] off begin
		String randomStringforPostingStatus = mock
				.strings()
				.get();
		newEntity.setPostingStatus(randomStringforPostingStatus);
		// % protected region % [Add customisation for Posting Status here] end
		// % protected region % [Add customisation for Posting Date Time here] off begin
		newEntity.setPostingDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Posting Date Time here] end
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
		// % protected region % [Add customisation for Customer Number here] off begin
		String randomStringforCustomerNumber = mock
				.strings()
				.get();
		newEntity.setCustomerNumber(randomStringforCustomerNumber);
		// % protected region % [Add customisation for Customer Number here] end
		// % protected region % [Add customisation for Customer Name here] off begin
		String randomStringforCustomerName = mock
				.strings()
				.get();
		newEntity.setCustomerName(randomStringforCustomerName);
		// % protected region % [Add customisation for Customer Name here] end
		// % protected region % [Add customisation for Revenue Center here] off begin
		String randomStringforRevenueCenter = mock
				.strings()
				.get();
		newEntity.setRevenueCenter(randomStringforRevenueCenter);
		// % protected region % [Add customisation for Revenue Center here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end

		// % protected region % [Apply any additional logic for journalWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for journalWithNoRef after the main body here] end

		log.trace("Created entity of type JournalEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Journal entities with no reference at all.
	 */
	@Provides
	@Named("journalEntitiesWithNoRef")
	public Collection<JournalEntity> journalEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for journalEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for journalEntitiesWithNoRef here] end
		JournalEntityFactory journalEntityFactory
	) {
		log.trace("Creating entities of type JournalEntity with no reference");

		// % protected region % [Apply any additional logic for journalEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for journalEntitiesWithNoRef before the main body here] end

		Collection<JournalEntity> newEntities = journalEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for journalEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for journalEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type JournalEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Journal entity with all references set.
	 */
	@Provides
	@Named("journalEntityWithRefs")
	public JournalEntity journalEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for journalEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for journalEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type JournalEntity with references");

		// % protected region % [Apply any additional logic for journalEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for journalEntityWithRefs before the main body here] end

		JournalEntity journalEntity = injector.getInstance(Key.get(JournalEntity.class, Names.named("journalEntityWithNoRef")));

		// % protected region % [Apply any additional logic for journalEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for journalEntityWithRefs after the main body here] end

		log.trace("Created entity of type JournalEntity with references");

		return journalEntity;
	}

	/**
	 * Return a collection of Journal entities with all references set.
	 */
	@Provides
	@Named("journalEntitiesWithRefs")
	public Collection<JournalEntity> journalEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for journalEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for journalEntitiesWithRefs here] end
		JournalEntityFactory journalEntityFactory
	) {
		log.trace("Creating entities of type JournalEntity with references");

		// % protected region % [Apply any additional logic for journalEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for journalEntitiesWithRefs before the main body here] end

		Collection<JournalEntity> newEntities = journalEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for journalEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for journalEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type JournalEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
