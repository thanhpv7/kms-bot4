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
 * Guice module for Merchant used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MerchantModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MerchantModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MerchantModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MerchantEntityFactory merchantEntityFactory(
			// % protected region % [Apply any additional injected arguments for merchantEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for merchantEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MerchantEntityFactory");

		// % protected region % [Apply any additional logic for merchantEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantEntityFactory before the main body here] end

		MerchantEntityFactory entityFactory = new MerchantEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MerchantEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MerchantEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for merchantEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantEntityFactory after the main body here] end

		log.trace("Created MerchantEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Merchant entity with no references set.
	 */
	@Provides
	@Named("merchantEntityWithNoRef")
	public MerchantEntity merchantEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for merchantEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for merchantEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MerchantEntity with no reference");

		// % protected region % [Apply any additional logic for merchantWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantWithNoRef before the main body here] end

		MerchantEntity newEntity = new MerchantEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Merchant Name here] off begin
		String randomStringforMerchantName = mock
				.strings()
				.get();
		newEntity.setMerchantName(randomStringforMerchantName);
		// % protected region % [Add customisation for Merchant Name here] end
		// % protected region % [Add customisation for Merchant Number here] off begin
		String randomStringforMerchantNumber = mock
				.strings()
				.get();
		newEntity.setMerchantNumber(randomStringforMerchantNumber);
		// % protected region % [Add customisation for Merchant Number here] end
		// % protected region % [Add customisation for Bank Account here] off begin
		String randomStringforBankAccount = mock
				.strings()
				.get();
		newEntity.setBankAccount(randomStringforBankAccount);
		// % protected region % [Add customisation for Bank Account here] end

		// % protected region % [Apply any additional logic for merchantWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantWithNoRef after the main body here] end

		log.trace("Created entity of type MerchantEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Merchant entities with no reference at all.
	 */
	@Provides
	@Named("merchantEntitiesWithNoRef")
	public Collection<MerchantEntity> merchantEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for merchantEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for merchantEntitiesWithNoRef here] end
		MerchantEntityFactory merchantEntityFactory
	) {
		log.trace("Creating entities of type MerchantEntity with no reference");

		// % protected region % [Apply any additional logic for merchantEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantEntitiesWithNoRef before the main body here] end

		Collection<MerchantEntity> newEntities = merchantEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for merchantEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MerchantEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Merchant entity with all references set.
	 */
	@Provides
	@Named("merchantEntityWithRefs")
	public MerchantEntity merchantEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for merchantEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for merchantEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MerchantEntity with references");

		// % protected region % [Apply any additional logic for merchantEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantEntityWithRefs before the main body here] end

		MerchantEntity merchantEntity = injector.getInstance(Key.get(MerchantEntity.class, Names.named("merchantEntityWithNoRef")));

		// % protected region % [Apply any additional logic for merchantEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantEntityWithRefs after the main body here] end

		log.trace("Created entity of type MerchantEntity with references");

		return merchantEntity;
	}

	/**
	 * Return a collection of Merchant entities with all references set.
	 */
	@Provides
	@Named("merchantEntitiesWithRefs")
	public Collection<MerchantEntity> merchantEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for merchantEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for merchantEntitiesWithRefs here] end
		MerchantEntityFactory merchantEntityFactory
	) {
		log.trace("Creating entities of type MerchantEntity with references");

		// % protected region % [Apply any additional logic for merchantEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantEntitiesWithRefs before the main body here] end

		Collection<MerchantEntity> newEntities = merchantEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for merchantEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MerchantEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
