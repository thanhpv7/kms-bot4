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
 * Guice module for BPJS Total Referral SEP used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsTotalReferralSEPModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsTotalReferralSEPModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsTotalReferralSEPModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsTotalReferralSEPEntityFactory bpjsTotalReferralSEPEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsTotalReferralSEPEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsTotalReferralSEPEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsTotalReferralSEPEntityFactory");

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntityFactory before the main body here] end

		BpjsTotalReferralSEPEntityFactory entityFactory = new BpjsTotalReferralSEPEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsTotalReferralSEPEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsTotalReferralSEPEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntityFactory after the main body here] end

		log.trace("Created BpjsTotalReferralSEPEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Total Referral SEP entity with no references set.
	 */
	@Provides
	@Named("bpjsTotalReferralSEPEntityWithNoRef")
	public BpjsTotalReferralSEPEntity bpjsTotalReferralSEPEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsTotalReferralSEPEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsTotalReferralSEPEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsTotalReferralSEPEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPWithNoRef before the main body here] end

		BpjsTotalReferralSEPEntity newEntity = new BpjsTotalReferralSEPEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Referral Type here] off begin
		String randomStringforReferralType = mock
				.strings()
				.get();
		newEntity.setReferralType(randomStringforReferralType);
		// % protected region % [Add customisation for Referral Type here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringforReferralNo = mock
				.strings()
				.get();
		newEntity.setReferralNo(randomStringforReferralNo);
		// % protected region % [Add customisation for Referral No here] end
		// % protected region % [Add customisation for Total SEP here] off begin
		String randomStringforTotalSEP = mock
				.strings()
				.get();
		newEntity.setTotalSEP(randomStringforTotalSEP);
		// % protected region % [Add customisation for Total SEP here] end

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsTotalReferralSEPEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Total Referral SEP entities with no reference at all.
	 */
	@Provides
	@Named("bpjsTotalReferralSEPEntitiesWithNoRef")
	public Collection<BpjsTotalReferralSEPEntity> bpjsTotalReferralSEPEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsTotalReferralSEPEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsTotalReferralSEPEntitiesWithNoRef here] end
		BpjsTotalReferralSEPEntityFactory bpjsTotalReferralSEPEntityFactory
	) {
		log.trace("Creating entities of type BpjsTotalReferralSEPEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntitiesWithNoRef before the main body here] end

		Collection<BpjsTotalReferralSEPEntity> newEntities = bpjsTotalReferralSEPEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsTotalReferralSEPEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Total Referral SEP entity with all references set.
	 */
	@Provides
	@Named("bpjsTotalReferralSEPEntityWithRefs")
	public BpjsTotalReferralSEPEntity bpjsTotalReferralSEPEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsTotalReferralSEPEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsTotalReferralSEPEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsTotalReferralSEPEntity with references");

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntityWithRefs before the main body here] end

		BpjsTotalReferralSEPEntity bpjsTotalReferralSEPEntity = injector.getInstance(Key.get(BpjsTotalReferralSEPEntity.class, Names.named("bpjsTotalReferralSEPEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsTotalReferralSEPEntity with references");

		return bpjsTotalReferralSEPEntity;
	}

	/**
	 * Return a collection of BPJS Total Referral SEP entities with all references set.
	 */
	@Provides
	@Named("bpjsTotalReferralSEPEntitiesWithRefs")
	public Collection<BpjsTotalReferralSEPEntity> bpjsTotalReferralSEPEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsTotalReferralSEPEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsTotalReferralSEPEntitiesWithRefs here] end
		BpjsTotalReferralSEPEntityFactory bpjsTotalReferralSEPEntityFactory
	) {
		log.trace("Creating entities of type BpjsTotalReferralSEPEntity with references");

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntitiesWithRefs before the main body here] end

		Collection<BpjsTotalReferralSEPEntity> newEntities = bpjsTotalReferralSEPEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTotalReferralSEPEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsTotalReferralSEPEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
