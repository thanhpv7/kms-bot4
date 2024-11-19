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
 * Guice module for BPJS Referral Specialist used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsReferralSpecialistModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsReferralSpecialistModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsReferralSpecialistModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsReferralSpecialistEntityFactory bpjsReferralSpecialistEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsReferralSpecialistEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsReferralSpecialistEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsReferralSpecialistEntityFactory");

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntityFactory before the main body here] end

		BpjsReferralSpecialistEntityFactory entityFactory = new BpjsReferralSpecialistEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsReferralSpecialistEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsReferralSpecialistEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntityFactory after the main body here] end

		log.trace("Created BpjsReferralSpecialistEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Referral Specialist entity with no references set.
	 */
	@Provides
	@Named("bpjsReferralSpecialistEntityWithNoRef")
	public BpjsReferralSpecialistEntity bpjsReferralSpecialistEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsReferralSpecialistEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsReferralSpecialistEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsReferralSpecialistEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistWithNoRef before the main body here] end

		BpjsReferralSpecialistEntity newEntity = new BpjsReferralSpecialistEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Specialist Code here] off begin
		String randomStringforSpecialistCode = mock
				.strings()
				.get();
		newEntity.setSpecialistCode(randomStringforSpecialistCode);
		// % protected region % [Add customisation for Specialist Code here] end
		// % protected region % [Add customisation for Specialist Name here] off begin
		String randomStringforSpecialistName = mock
				.strings()
				.get();
		newEntity.setSpecialistName(randomStringforSpecialistName);
		// % protected region % [Add customisation for Specialist Name here] end
		// % protected region % [Add customisation for Capacity here] off begin
		String randomStringforCapacity = mock
				.strings()
				.get();
		newEntity.setCapacity(randomStringforCapacity);
		// % protected region % [Add customisation for Capacity here] end
		// % protected region % [Add customisation for Total Referral here] off begin
		String randomStringforTotalReferral = mock
				.strings()
				.get();
		newEntity.setTotalReferral(randomStringforTotalReferral);
		// % protected region % [Add customisation for Total Referral here] end
		// % protected region % [Add customisation for Percentage here] off begin
		String randomStringforPercentage = mock
				.strings()
				.get();
		newEntity.setPercentage(randomStringforPercentage);
		// % protected region % [Add customisation for Percentage here] end

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsReferralSpecialistEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Referral Specialist entities with no reference at all.
	 */
	@Provides
	@Named("bpjsReferralSpecialistEntitiesWithNoRef")
	public Collection<BpjsReferralSpecialistEntity> bpjsReferralSpecialistEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsReferralSpecialistEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsReferralSpecialistEntitiesWithNoRef here] end
		BpjsReferralSpecialistEntityFactory bpjsReferralSpecialistEntityFactory
	) {
		log.trace("Creating entities of type BpjsReferralSpecialistEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntitiesWithNoRef before the main body here] end

		Collection<BpjsReferralSpecialistEntity> newEntities = bpjsReferralSpecialistEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsReferralSpecialistEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Referral Specialist entity with all references set.
	 */
	@Provides
	@Named("bpjsReferralSpecialistEntityWithRefs")
	public BpjsReferralSpecialistEntity bpjsReferralSpecialistEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsReferralSpecialistEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsReferralSpecialistEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsReferralSpecialistEntity with references");

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntityWithRefs before the main body here] end

		BpjsReferralSpecialistEntity bpjsReferralSpecialistEntity = injector.getInstance(Key.get(BpjsReferralSpecialistEntity.class, Names.named("bpjsReferralSpecialistEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsReferralSpecialistEntity with references");

		return bpjsReferralSpecialistEntity;
	}

	/**
	 * Return a collection of BPJS Referral Specialist entities with all references set.
	 */
	@Provides
	@Named("bpjsReferralSpecialistEntitiesWithRefs")
	public Collection<BpjsReferralSpecialistEntity> bpjsReferralSpecialistEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsReferralSpecialistEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsReferralSpecialistEntitiesWithRefs here] end
		BpjsReferralSpecialistEntityFactory bpjsReferralSpecialistEntityFactory
	) {
		log.trace("Creating entities of type BpjsReferralSpecialistEntity with references");

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntitiesWithRefs before the main body here] end

		Collection<BpjsReferralSpecialistEntity> newEntities = bpjsReferralSpecialistEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsReferralSpecialistEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsReferralSpecialistEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
