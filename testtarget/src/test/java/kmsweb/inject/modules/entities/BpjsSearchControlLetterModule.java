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
 * Guice module for BPJS Search Control Letter used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsSearchControlLetterModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsSearchControlLetterModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsSearchControlLetterModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsSearchControlLetterEntityFactory bpjsSearchControlLetterEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsSearchControlLetterEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsSearchControlLetterEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsSearchControlLetterEntityFactory");

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntityFactory before the main body here] end

		BpjsSearchControlLetterEntityFactory entityFactory = new BpjsSearchControlLetterEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsSearchControlLetterEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsSearchControlLetterEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntityFactory after the main body here] end

		log.trace("Created BpjsSearchControlLetterEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Search Control Letter entity with no references set.
	 */
	@Provides
	@Named("bpjsSearchControlLetterEntityWithNoRef")
	public BpjsSearchControlLetterEntity bpjsSearchControlLetterEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsSearchControlLetterEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSearchControlLetterEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsSearchControlLetterEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterWithNoRef before the main body here] end

		BpjsSearchControlLetterEntity newEntity = new BpjsSearchControlLetterEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Control Letter No here] off begin
		String randomStringforControlLetterNo = mock
				.strings()
				.get();
		newEntity.setControlLetterNo(randomStringforControlLetterNo);
		// % protected region % [Add customisation for Control Letter No here] end
		// % protected region % [Add customisation for Control Plan Date here] off begin
		String randomStringforControlPlanDate = mock
				.strings()
				.get();
		newEntity.setControlPlanDate(randomStringforControlPlanDate);
		// % protected region % [Add customisation for Control Plan Date here] end
		// % protected region % [Add customisation for Date here] off begin
		String randomStringforDate = mock
				.strings()
				.get();
		newEntity.setDate(randomStringforDate);
		// % protected region % [Add customisation for Date here] end
		// % protected region % [Add customisation for Control Type here] off begin
		String randomStringforControlType = mock
				.strings()
				.get();
		newEntity.setControlType(randomStringforControlType);
		// % protected region % [Add customisation for Control Type here] end
		// % protected region % [Add customisation for Polyclinic here] off begin
		String randomStringforPolyclinic = mock
				.strings()
				.get();
		newEntity.setPolyclinic(randomStringforPolyclinic);
		// % protected region % [Add customisation for Polyclinic here] end
		// % protected region % [Add customisation for Doctor here] off begin
		String randomStringforDoctor = mock
				.strings()
				.get();
		newEntity.setDoctor(randomStringforDoctor);
		// % protected region % [Add customisation for Doctor here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Polyclinic Destination here] off begin
		String randomStringforPolyclinicDestination = mock
				.strings()
				.get();
		newEntity.setPolyclinicDestination(randomStringforPolyclinicDestination);
		// % protected region % [Add customisation for Polyclinic Destination here] end
		// % protected region % [Add customisation for Doctor Destination here] off begin
		String randomStringforDoctorDestination = mock
				.strings()
				.get();
		newEntity.setDoctorDestination(randomStringforDoctorDestination);
		// % protected region % [Add customisation for Doctor Destination here] end
		// % protected region % [Add customisation for Polyclinic Source here] off begin
		String randomStringforPolyclinicSource = mock
				.strings()
				.get();
		newEntity.setPolyclinicSource(randomStringforPolyclinicSource);
		// % protected region % [Add customisation for Polyclinic Source here] end
		// % protected region % [Add customisation for Doctor Source here] off begin
		String randomStringforDoctorSource = mock
				.strings()
				.get();
		newEntity.setDoctorSource(randomStringforDoctorSource);
		// % protected region % [Add customisation for Doctor Source here] end
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

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsSearchControlLetterEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Search Control Letter entities with no reference at all.
	 */
	@Provides
	@Named("bpjsSearchControlLetterEntitiesWithNoRef")
	public Collection<BpjsSearchControlLetterEntity> bpjsSearchControlLetterEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsSearchControlLetterEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSearchControlLetterEntitiesWithNoRef here] end
		BpjsSearchControlLetterEntityFactory bpjsSearchControlLetterEntityFactory
	) {
		log.trace("Creating entities of type BpjsSearchControlLetterEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntitiesWithNoRef before the main body here] end

		Collection<BpjsSearchControlLetterEntity> newEntities = bpjsSearchControlLetterEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsSearchControlLetterEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Search Control Letter entity with all references set.
	 */
	@Provides
	@Named("bpjsSearchControlLetterEntityWithRefs")
	public BpjsSearchControlLetterEntity bpjsSearchControlLetterEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsSearchControlLetterEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSearchControlLetterEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsSearchControlLetterEntity with references");

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntityWithRefs before the main body here] end

		BpjsSearchControlLetterEntity bpjsSearchControlLetterEntity = injector.getInstance(Key.get(BpjsSearchControlLetterEntity.class, Names.named("bpjsSearchControlLetterEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsSearchControlLetterEntity with references");

		return bpjsSearchControlLetterEntity;
	}

	/**
	 * Return a collection of BPJS Search Control Letter entities with all references set.
	 */
	@Provides
	@Named("bpjsSearchControlLetterEntitiesWithRefs")
	public Collection<BpjsSearchControlLetterEntity> bpjsSearchControlLetterEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsSearchControlLetterEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSearchControlLetterEntitiesWithRefs here] end
		BpjsSearchControlLetterEntityFactory bpjsSearchControlLetterEntityFactory
	) {
		log.trace("Creating entities of type BpjsSearchControlLetterEntity with references");

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntitiesWithRefs before the main body here] end

		Collection<BpjsSearchControlLetterEntity> newEntities = bpjsSearchControlLetterEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSearchControlLetterEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsSearchControlLetterEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
