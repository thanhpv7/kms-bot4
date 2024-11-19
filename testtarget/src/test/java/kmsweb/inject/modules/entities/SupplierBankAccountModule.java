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
 * Guice module for Supplier Bank Account used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class SupplierBankAccountModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring SupplierBankAccountModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured SupplierBankAccountModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public SupplierBankAccountEntityFactory supplierBankAccountEntityFactory(
			// % protected region % [Apply any additional injected arguments for supplierBankAccountEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for supplierBankAccountEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating SupplierBankAccountEntityFactory");

		// % protected region % [Apply any additional logic for supplierBankAccountEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountEntityFactory before the main body here] end

		SupplierBankAccountEntityFactory entityFactory = new SupplierBankAccountEntityFactory(
				// % protected region % [Apply any additional constructor arguments for SupplierBankAccountEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for SupplierBankAccountEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for supplierBankAccountEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountEntityFactory after the main body here] end

		log.trace("Created SupplierBankAccountEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Supplier Bank Account entity with no references set.
	 */
	@Provides
	@Named("supplierBankAccountEntityWithNoRef")
	public SupplierBankAccountEntity supplierBankAccountEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for supplierBankAccountEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for supplierBankAccountEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type SupplierBankAccountEntity with no reference");

		// % protected region % [Apply any additional logic for supplierBankAccountWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountWithNoRef before the main body here] end

		SupplierBankAccountEntity newEntity = new SupplierBankAccountEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Bank Name here] off begin
		String randomStringforBankName = mock
				.strings()
				.get();
		newEntity.setBankName(randomStringforBankName);
		// % protected region % [Add customisation for Bank Name here] end
		// % protected region % [Add customisation for Account Name here] off begin
		String randomStringforAccountName = mock
				.strings()
				.get();
		newEntity.setAccountName(randomStringforAccountName);
		// % protected region % [Add customisation for Account Name here] end
		// % protected region % [Add customisation for Account Number here] off begin
		String randomStringforAccountNumber = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setAccountNumber(randomStringforAccountNumber);
		// % protected region % [Add customisation for Account Number here] end
		// % protected region % [Add customisation for City here] off begin
		String randomStringforCity = mock
				.strings()
				.get();
		newEntity.setCity(randomStringforCity);
		// % protected region % [Add customisation for City here] end
		// % protected region % [Add customisation for Branch here] off begin
		String randomStringforBranch = mock
				.strings()
				.get();
		newEntity.setBranch(randomStringforBranch);
		// % protected region % [Add customisation for Branch here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for supplierBankAccountWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountWithNoRef after the main body here] end

		log.trace("Created entity of type SupplierBankAccountEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Supplier Bank Account entities with no reference at all.
	 */
	@Provides
	@Named("supplierBankAccountEntitiesWithNoRef")
	public Collection<SupplierBankAccountEntity> supplierBankAccountEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for supplierBankAccountEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for supplierBankAccountEntitiesWithNoRef here] end
		SupplierBankAccountEntityFactory supplierBankAccountEntityFactory
	) {
		log.trace("Creating entities of type SupplierBankAccountEntity with no reference");

		// % protected region % [Apply any additional logic for supplierBankAccountEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountEntitiesWithNoRef before the main body here] end

		Collection<SupplierBankAccountEntity> newEntities = supplierBankAccountEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for supplierBankAccountEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type SupplierBankAccountEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Supplier Bank Account entity with all references set.
	 */
	@Provides
	@Named("supplierBankAccountEntityWithRefs")
	public SupplierBankAccountEntity supplierBankAccountEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for supplierBankAccountEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for supplierBankAccountEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type SupplierBankAccountEntity with references");

		// % protected region % [Apply any additional logic for supplierBankAccountEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountEntityWithRefs before the main body here] end

		SupplierBankAccountEntity supplierBankAccountEntity = injector.getInstance(Key.get(SupplierBankAccountEntity.class, Names.named("supplierBankAccountEntityWithNoRef")));

		// % protected region % [Apply any additional logic for supplierBankAccountEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountEntityWithRefs after the main body here] end

		log.trace("Created entity of type SupplierBankAccountEntity with references");

		return supplierBankAccountEntity;
	}

	/**
	 * Return a collection of Supplier Bank Account entities with all references set.
	 */
	@Provides
	@Named("supplierBankAccountEntitiesWithRefs")
	public Collection<SupplierBankAccountEntity> supplierBankAccountEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for supplierBankAccountEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for supplierBankAccountEntitiesWithRefs here] end
		SupplierBankAccountEntityFactory supplierBankAccountEntityFactory
	) {
		log.trace("Creating entities of type SupplierBankAccountEntity with references");

		// % protected region % [Apply any additional logic for supplierBankAccountEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountEntitiesWithRefs before the main body here] end

		Collection<SupplierBankAccountEntity> newEntities = supplierBankAccountEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for supplierBankAccountEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierBankAccountEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type SupplierBankAccountEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
