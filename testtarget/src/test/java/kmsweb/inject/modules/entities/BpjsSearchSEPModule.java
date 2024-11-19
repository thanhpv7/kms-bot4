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
 * Guice module for BPJS Search SEP used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsSearchSEPModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsSearchSEPModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsSearchSEPModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsSearchSEPEntityFactory bpjsSearchSEPEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsSearchSEPEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsSearchSEPEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsSearchSEPEntityFactory");

		// % protected region % [Apply any additional logic for bpjsSearchSEPEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPEntityFactory before the main body here] end

		BpjsSearchSEPEntityFactory entityFactory = new BpjsSearchSEPEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsSearchSEPEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsSearchSEPEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsSearchSEPEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPEntityFactory after the main body here] end

		log.trace("Created BpjsSearchSEPEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Search SEP entity with no references set.
	 */
	@Provides
	@Named("bpjsSearchSEPEntityWithNoRef")
	public BpjsSearchSEPEntity bpjsSearchSEPEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsSearchSEPEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSearchSEPEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsSearchSEPEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSearchSEPWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPWithNoRef before the main body here] end

		BpjsSearchSEPEntity newEntity = new BpjsSearchSEPEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		String randomStringforSepDate = mock
				.strings()
				.get();
		newEntity.setSepDate(randomStringforSepDate);
		// % protected region % [Add customisation for SEP Date here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringforTreatmentType = mock
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringforTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Polyclinic here] off begin
		String randomStringforPolyclinic = mock
				.strings()
				.get();
		newEntity.setPolyclinic(randomStringforPolyclinic);
		// % protected region % [Add customisation for Polyclinic here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Name here] off begin
		String randomStringforName = mock
				.strings()
				.get();
		newEntity.setName(randomStringforName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringforGender = mock
				.strings()
				.get();
		newEntity.setGender(randomStringforGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Date of Birth here] off begin
		String randomStringforDateOfBirth = mock
				.strings()
				.get();
		newEntity.setDateOfBirth(randomStringforDateOfBirth);
		// % protected region % [Add customisation for Date of Birth here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Provider here] off begin
		String randomStringforProvider = mock
				.strings()
				.get();
		newEntity.setProvider(randomStringforProvider);
		// % protected region % [Add customisation for Provider here] end
		// % protected region % [Add customisation for Referral Provider here] off begin
		String randomStringforReferralProvider = mock
				.strings()
				.get();
		newEntity.setReferralProvider(randomStringforReferralProvider);
		// % protected region % [Add customisation for Referral Provider here] end
		// % protected region % [Add customisation for Referral Source here] off begin
		String randomStringforReferralSource = mock
				.strings()
				.get();
		newEntity.setReferralSource(randomStringforReferralSource);
		// % protected region % [Add customisation for Referral Source here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringforReferralNo = mock
				.strings()
				.get();
		newEntity.setReferralNo(randomStringforReferralNo);
		// % protected region % [Add customisation for Referral No here] end
		// % protected region % [Add customisation for Referral Date here] off begin
		String randomStringforReferralDate = mock
				.strings()
				.get();
		newEntity.setReferralDate(randomStringforReferralDate);
		// % protected region % [Add customisation for Referral Date here] end
		// % protected region % [Add customisation for Diagnose here] off begin
		String randomStringforDiagnose = mock
				.strings()
				.get();
		newEntity.setDiagnose(randomStringforDiagnose);
		// % protected region % [Add customisation for Diagnose here] end

		// % protected region % [Apply any additional logic for bpjsSearchSEPWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsSearchSEPEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Search SEP entities with no reference at all.
	 */
	@Provides
	@Named("bpjsSearchSEPEntitiesWithNoRef")
	public Collection<BpjsSearchSEPEntity> bpjsSearchSEPEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsSearchSEPEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSearchSEPEntitiesWithNoRef here] end
		BpjsSearchSEPEntityFactory bpjsSearchSEPEntityFactory
	) {
		log.trace("Creating entities of type BpjsSearchSEPEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSearchSEPEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPEntitiesWithNoRef before the main body here] end

		Collection<BpjsSearchSEPEntity> newEntities = bpjsSearchSEPEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsSearchSEPEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsSearchSEPEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Search SEP entity with all references set.
	 */
	@Provides
	@Named("bpjsSearchSEPEntityWithRefs")
	public BpjsSearchSEPEntity bpjsSearchSEPEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsSearchSEPEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSearchSEPEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsSearchSEPEntity with references");

		// % protected region % [Apply any additional logic for bpjsSearchSEPEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPEntityWithRefs before the main body here] end

		BpjsSearchSEPEntity bpjsSearchSEPEntity = injector.getInstance(Key.get(BpjsSearchSEPEntity.class, Names.named("bpjsSearchSEPEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsSearchSEPEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsSearchSEPEntity with references");

		return bpjsSearchSEPEntity;
	}

	/**
	 * Return a collection of BPJS Search SEP entities with all references set.
	 */
	@Provides
	@Named("bpjsSearchSEPEntitiesWithRefs")
	public Collection<BpjsSearchSEPEntity> bpjsSearchSEPEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsSearchSEPEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSearchSEPEntitiesWithRefs here] end
		BpjsSearchSEPEntityFactory bpjsSearchSEPEntityFactory
	) {
		log.trace("Creating entities of type BpjsSearchSEPEntity with references");

		// % protected region % [Apply any additional logic for bpjsSearchSEPEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPEntitiesWithRefs before the main body here] end

		Collection<BpjsSearchSEPEntity> newEntities = bpjsSearchSEPEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsSearchSEPEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchSEPEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsSearchSEPEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
