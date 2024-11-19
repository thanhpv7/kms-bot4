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
 * Guice module for BPJS Treatment History used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsTreatmentHistoryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsTreatmentHistoryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsTreatmentHistoryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsTreatmentHistoryEntityFactory bpjsTreatmentHistoryEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsTreatmentHistoryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsTreatmentHistoryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsTreatmentHistoryEntityFactory");

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntityFactory before the main body here] end

		BpjsTreatmentHistoryEntityFactory entityFactory = new BpjsTreatmentHistoryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsTreatmentHistoryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsTreatmentHistoryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntityFactory after the main body here] end

		log.trace("Created BpjsTreatmentHistoryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Treatment History entity with no references set.
	 */
	@Provides
	@Named("bpjsTreatmentHistoryEntityWithNoRef")
	public BpjsTreatmentHistoryEntity bpjsTreatmentHistoryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentHistoryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentHistoryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsTreatmentHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryWithNoRef before the main body here] end

		BpjsTreatmentHistoryEntity newEntity = new BpjsTreatmentHistoryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Diagnose here] off begin
		String randomStringforDiagnose = mock
				.strings()
				.get();
		newEntity.setDiagnose(randomStringforDiagnose);
		// % protected region % [Add customisation for Diagnose here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringforTreatmentType = mock
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringforTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringforName = mock
				.strings()
				.get();
		newEntity.setName(randomStringforName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringforReferralNo = mock
				.strings()
				.get();
		newEntity.setReferralNo(randomStringforReferralNo);
		// % protected region % [Add customisation for Referral No here] end
		// % protected region % [Add customisation for Polyclinic here] off begin
		String randomStringforPolyclinic = mock
				.strings()
				.get();
		newEntity.setPolyclinic(randomStringforPolyclinic);
		// % protected region % [Add customisation for Polyclinic here] end
		// % protected region % [Add customisation for Health Facility here] off begin
		String randomStringforHealthFacility = mock
				.strings()
				.get();
		newEntity.setHealthFacility(randomStringforHealthFacility);
		// % protected region % [Add customisation for Health Facility here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		newEntity.setSepDate(OffsetDateTime.now());
		// % protected region % [Add customisation for SEP Date here] end

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsTreatmentHistoryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Treatment History entities with no reference at all.
	 */
	@Provides
	@Named("bpjsTreatmentHistoryEntitiesWithNoRef")
	public Collection<BpjsTreatmentHistoryEntity> bpjsTreatmentHistoryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentHistoryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentHistoryEntitiesWithNoRef here] end
		BpjsTreatmentHistoryEntityFactory bpjsTreatmentHistoryEntityFactory
	) {
		log.trace("Creating entities of type BpjsTreatmentHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntitiesWithNoRef before the main body here] end

		Collection<BpjsTreatmentHistoryEntity> newEntities = bpjsTreatmentHistoryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsTreatmentHistoryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Treatment History entity with all references set.
	 */
	@Provides
	@Named("bpjsTreatmentHistoryEntityWithRefs")
	public BpjsTreatmentHistoryEntity bpjsTreatmentHistoryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentHistoryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsTreatmentHistoryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsTreatmentHistoryEntity with references");

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntityWithRefs before the main body here] end

		BpjsTreatmentHistoryEntity bpjsTreatmentHistoryEntity = injector.getInstance(Key.get(BpjsTreatmentHistoryEntity.class, Names.named("bpjsTreatmentHistoryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsTreatmentHistoryEntity with references");

		return bpjsTreatmentHistoryEntity;
	}

	/**
	 * Return a collection of BPJS Treatment History entities with all references set.
	 */
	@Provides
	@Named("bpjsTreatmentHistoryEntitiesWithRefs")
	public Collection<BpjsTreatmentHistoryEntity> bpjsTreatmentHistoryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentHistoryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsTreatmentHistoryEntitiesWithRefs here] end
		BpjsTreatmentHistoryEntityFactory bpjsTreatmentHistoryEntityFactory
	) {
		log.trace("Creating entities of type BpjsTreatmentHistoryEntity with references");

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntitiesWithRefs before the main body here] end

		Collection<BpjsTreatmentHistoryEntity> newEntities = bpjsTreatmentHistoryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsTreatmentHistoryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsTreatmentHistoryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
