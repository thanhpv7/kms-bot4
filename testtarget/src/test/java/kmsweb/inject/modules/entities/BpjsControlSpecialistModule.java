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
 * Guice module for BPJS Control Specialist used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsControlSpecialistModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsControlSpecialistModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsControlSpecialistModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsControlSpecialistEntityFactory bpjsControlSpecialistEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsControlSpecialistEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsControlSpecialistEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsControlSpecialistEntityFactory");

		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntityFactory before the main body here] end

		BpjsControlSpecialistEntityFactory entityFactory = new BpjsControlSpecialistEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsControlSpecialistEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsControlSpecialistEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntityFactory after the main body here] end

		log.trace("Created BpjsControlSpecialistEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Control Specialist entity with no references set.
	 */
	@Provides
	@Named("bpjsControlSpecialistEntityWithNoRef")
	public BpjsControlSpecialistEntity bpjsControlSpecialistEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsControlSpecialistEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsControlSpecialistEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsControlSpecialistEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsControlSpecialistWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistWithNoRef before the main body here] end

		BpjsControlSpecialistEntity newEntity = new BpjsControlSpecialistEntity();
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
		// % protected region % [Add customisation for Total Control Plan Referral here] off begin
		String randomStringforTotalControlPlanReferral = mock
				.strings()
				.get();
		newEntity.setTotalControlPlanReferral(randomStringforTotalControlPlanReferral);
		// % protected region % [Add customisation for Total Control Plan Referral here] end
		// % protected region % [Add customisation for Percentage here] off begin
		String randomStringforPercentage = mock
				.strings()
				.get();
		newEntity.setPercentage(randomStringforPercentage);
		// % protected region % [Add customisation for Percentage here] end

		// % protected region % [Apply any additional logic for bpjsControlSpecialistWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsControlSpecialistEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Control Specialist entities with no reference at all.
	 */
	@Provides
	@Named("bpjsControlSpecialistEntitiesWithNoRef")
	public Collection<BpjsControlSpecialistEntity> bpjsControlSpecialistEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsControlSpecialistEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsControlSpecialistEntitiesWithNoRef here] end
		BpjsControlSpecialistEntityFactory bpjsControlSpecialistEntityFactory
	) {
		log.trace("Creating entities of type BpjsControlSpecialistEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntitiesWithNoRef before the main body here] end

		Collection<BpjsControlSpecialistEntity> newEntities = bpjsControlSpecialistEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsControlSpecialistEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Control Specialist entity with all references set.
	 */
	@Provides
	@Named("bpjsControlSpecialistEntityWithRefs")
	public BpjsControlSpecialistEntity bpjsControlSpecialistEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsControlSpecialistEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsControlSpecialistEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsControlSpecialistEntity with references");

		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntityWithRefs before the main body here] end

		BpjsControlSpecialistEntity bpjsControlSpecialistEntity = injector.getInstance(Key.get(BpjsControlSpecialistEntity.class, Names.named("bpjsControlSpecialistEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsControlSpecialistEntity with references");

		return bpjsControlSpecialistEntity;
	}

	/**
	 * Return a collection of BPJS Control Specialist entities with all references set.
	 */
	@Provides
	@Named("bpjsControlSpecialistEntitiesWithRefs")
	public Collection<BpjsControlSpecialistEntity> bpjsControlSpecialistEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsControlSpecialistEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsControlSpecialistEntitiesWithRefs here] end
		BpjsControlSpecialistEntityFactory bpjsControlSpecialistEntityFactory
	) {
		log.trace("Creating entities of type BpjsControlSpecialistEntity with references");

		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntitiesWithRefs before the main body here] end

		Collection<BpjsControlSpecialistEntity> newEntities = bpjsControlSpecialistEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsControlSpecialistEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsControlSpecialistEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
