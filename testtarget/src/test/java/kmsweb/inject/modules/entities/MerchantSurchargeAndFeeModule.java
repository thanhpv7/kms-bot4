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
 * Guice module for Merchant Surcharge and Fee used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MerchantSurchargeAndFeeModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MerchantSurchargeAndFeeModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MerchantSurchargeAndFeeModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MerchantSurchargeAndFeeEntityFactory merchantSurchargeAndFeeEntityFactory(
			// % protected region % [Apply any additional injected arguments for merchantSurchargeAndFeeEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for merchantSurchargeAndFeeEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MerchantSurchargeAndFeeEntityFactory");

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntityFactory before the main body here] end

		MerchantSurchargeAndFeeEntityFactory entityFactory = new MerchantSurchargeAndFeeEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MerchantSurchargeAndFeeEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MerchantSurchargeAndFeeEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntityFactory after the main body here] end

		log.trace("Created MerchantSurchargeAndFeeEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Merchant Surcharge and Fee entity with no references set.
	 */
	@Provides
	@Named("merchantSurchargeAndFeeEntityWithNoRef")
	public MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for merchantSurchargeAndFeeEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for merchantSurchargeAndFeeEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MerchantSurchargeAndFeeEntity with no reference");

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeWithNoRef before the main body here] end

		MerchantSurchargeAndFeeEntity newEntity = new MerchantSurchargeAndFeeEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Bank Name here] off begin
		String randomStringforBankName = mock
				.strings()
				.get();
		newEntity.setBankName(randomStringforBankName);
		// % protected region % [Add customisation for Bank Name here] end
		// % protected region % [Add customisation for Card Type here] off begin
		String randomStringforCardType = mock
				.strings()
				.get();
		newEntity.setCardType(randomStringforCardType);
		// % protected region % [Add customisation for Card Type here] end
		// % protected region % [Add customisation for Surcharge here] off begin
		newEntity.setSurcharge(mock.doubles().get());
		// % protected region % [Add customisation for Surcharge here] end
		// % protected region % [Add customisation for Fee here] off begin
		String randomStringforFee = mock
				.strings()
				.get();
		newEntity.setFee(randomStringforFee);
		// % protected region % [Add customisation for Fee here] end

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeWithNoRef after the main body here] end

		log.trace("Created entity of type MerchantSurchargeAndFeeEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Merchant Surcharge and Fee entities with no reference at all.
	 */
	@Provides
	@Named("merchantSurchargeAndFeeEntitiesWithNoRef")
	public Collection<MerchantSurchargeAndFeeEntity> merchantSurchargeAndFeeEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for merchantSurchargeAndFeeEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for merchantSurchargeAndFeeEntitiesWithNoRef here] end
		MerchantSurchargeAndFeeEntityFactory merchantSurchargeAndFeeEntityFactory
	) {
		log.trace("Creating entities of type MerchantSurchargeAndFeeEntity with no reference");

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntitiesWithNoRef before the main body here] end

		Collection<MerchantSurchargeAndFeeEntity> newEntities = merchantSurchargeAndFeeEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MerchantSurchargeAndFeeEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Merchant Surcharge and Fee entity with all references set.
	 */
	@Provides
	@Named("merchantSurchargeAndFeeEntityWithRefs")
	public MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for merchantSurchargeAndFeeEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for merchantSurchargeAndFeeEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MerchantSurchargeAndFeeEntity with references");

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntityWithRefs before the main body here] end

		MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntity = injector.getInstance(Key.get(MerchantSurchargeAndFeeEntity.class, Names.named("merchantSurchargeAndFeeEntityWithNoRef")));

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntityWithRefs after the main body here] end

		log.trace("Created entity of type MerchantSurchargeAndFeeEntity with references");

		return merchantSurchargeAndFeeEntity;
	}

	/**
	 * Return a collection of Merchant Surcharge and Fee entities with all references set.
	 */
	@Provides
	@Named("merchantSurchargeAndFeeEntitiesWithRefs")
	public Collection<MerchantSurchargeAndFeeEntity> merchantSurchargeAndFeeEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for merchantSurchargeAndFeeEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for merchantSurchargeAndFeeEntitiesWithRefs here] end
		MerchantSurchargeAndFeeEntityFactory merchantSurchargeAndFeeEntityFactory
	) {
		log.trace("Creating entities of type MerchantSurchargeAndFeeEntity with references");

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntitiesWithRefs before the main body here] end

		Collection<MerchantSurchargeAndFeeEntity> newEntities = merchantSurchargeAndFeeEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for merchantSurchargeAndFeeEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MerchantSurchargeAndFeeEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
