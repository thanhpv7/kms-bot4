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
 * Guice module for Chart of Account used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ChartOfAccountModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ChartOfAccountModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ChartOfAccountModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ChartOfAccountEntityFactory chartOfAccountEntityFactory(
			// % protected region % [Apply any additional injected arguments for chartOfAccountEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for chartOfAccountEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ChartOfAccountEntityFactory");

		// % protected region % [Apply any additional logic for chartOfAccountEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountEntityFactory before the main body here] end

		ChartOfAccountEntityFactory entityFactory = new ChartOfAccountEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ChartOfAccountEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ChartOfAccountEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for chartOfAccountEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountEntityFactory after the main body here] end

		log.trace("Created ChartOfAccountEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Chart of Account entity with no references set.
	 */
	@Provides
	@Named("chartOfAccountEntityWithNoRef")
	public ChartOfAccountEntity chartOfAccountEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for chartOfAccountEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for chartOfAccountEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ChartOfAccountEntity with no reference");

		// % protected region % [Apply any additional logic for chartOfAccountWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountWithNoRef before the main body here] end

		ChartOfAccountEntity newEntity = new ChartOfAccountEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Account Code here] off begin
		String randomStringforAccountCode = mock
				.strings()
				.get();
		newEntity.setAccountCode(randomStringforAccountCode);
		// % protected region % [Add customisation for Account Code here] end
		// % protected region % [Add customisation for Account Name here] off begin
		String randomStringforAccountName = mock
				.strings()
				.get();
		newEntity.setAccountName(randomStringforAccountName);
		// % protected region % [Add customisation for Account Name here] end
		// % protected region % [Add customisation for Account Type here] off begin
		String randomStringforAccountType = mock
				.strings()
				.get();
		newEntity.setAccountType(randomStringforAccountType);
		// % protected region % [Add customisation for Account Type here] end
		// % protected region % [Add customisation for Tax Code here] off begin
		String randomStringforTaxCode = mock
				.strings()
				.get();
		newEntity.setTaxCode(randomStringforTaxCode);
		// % protected region % [Add customisation for Tax Code here] end
		// % protected region % [Add customisation for Dashboard here] off begin
		newEntity.setDashboard(mock.bools().get());
		// % protected region % [Add customisation for Dashboard here] end
		// % protected region % [Add customisation for Expense Claim here] off begin
		newEntity.setExpenseClaim(mock.bools().get());
		// % protected region % [Add customisation for Expense Claim here] end
		// % protected region % [Add customisation for Enable Payment here] off begin
		newEntity.setEnablePayment(mock.bools().get());
		// % protected region % [Add customisation for Enable Payment here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end

		// % protected region % [Apply any additional logic for chartOfAccountWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountWithNoRef after the main body here] end

		log.trace("Created entity of type ChartOfAccountEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Chart of Account entities with no reference at all.
	 */
	@Provides
	@Named("chartOfAccountEntitiesWithNoRef")
	public Collection<ChartOfAccountEntity> chartOfAccountEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for chartOfAccountEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for chartOfAccountEntitiesWithNoRef here] end
		ChartOfAccountEntityFactory chartOfAccountEntityFactory
	) {
		log.trace("Creating entities of type ChartOfAccountEntity with no reference");

		// % protected region % [Apply any additional logic for chartOfAccountEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountEntitiesWithNoRef before the main body here] end

		Collection<ChartOfAccountEntity> newEntities = chartOfAccountEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for chartOfAccountEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ChartOfAccountEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Chart of Account entity with all references set.
	 */
	@Provides
	@Named("chartOfAccountEntityWithRefs")
	public ChartOfAccountEntity chartOfAccountEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for chartOfAccountEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for chartOfAccountEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ChartOfAccountEntity with references");

		// % protected region % [Apply any additional logic for chartOfAccountEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountEntityWithRefs before the main body here] end

		ChartOfAccountEntity chartOfAccountEntity = injector.getInstance(Key.get(ChartOfAccountEntity.class, Names.named("chartOfAccountEntityWithNoRef")));

		// % protected region % [Apply any additional logic for chartOfAccountEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountEntityWithRefs after the main body here] end

		log.trace("Created entity of type ChartOfAccountEntity with references");

		return chartOfAccountEntity;
	}

	/**
	 * Return a collection of Chart of Account entities with all references set.
	 */
	@Provides
	@Named("chartOfAccountEntitiesWithRefs")
	public Collection<ChartOfAccountEntity> chartOfAccountEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for chartOfAccountEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for chartOfAccountEntitiesWithRefs here] end
		ChartOfAccountEntityFactory chartOfAccountEntityFactory
	) {
		log.trace("Creating entities of type ChartOfAccountEntity with references");

		// % protected region % [Apply any additional logic for chartOfAccountEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountEntitiesWithRefs before the main body here] end

		Collection<ChartOfAccountEntity> newEntities = chartOfAccountEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for chartOfAccountEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ChartOfAccountEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
