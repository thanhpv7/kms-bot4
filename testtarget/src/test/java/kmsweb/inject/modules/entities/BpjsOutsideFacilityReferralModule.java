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
 * Guice module for BPJS Outside Facility Referral used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsOutsideFacilityReferralModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsOutsideFacilityReferralModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsOutsideFacilityReferralModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsOutsideFacilityReferralEntityFactory bpjsOutsideFacilityReferralEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsOutsideFacilityReferralEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsOutsideFacilityReferralEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsOutsideFacilityReferralEntityFactory");

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntityFactory before the main body here] end

		BpjsOutsideFacilityReferralEntityFactory entityFactory = new BpjsOutsideFacilityReferralEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsOutsideFacilityReferralEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsOutsideFacilityReferralEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntityFactory after the main body here] end

		log.trace("Created BpjsOutsideFacilityReferralEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Outside Facility Referral entity with no references set.
	 */
	@Provides
	@Named("bpjsOutsideFacilityReferralEntityWithNoRef")
	public BpjsOutsideFacilityReferralEntity bpjsOutsideFacilityReferralEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsOutsideFacilityReferralEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsOutsideFacilityReferralEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsOutsideFacilityReferralEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralWithNoRef before the main body here] end

		BpjsOutsideFacilityReferralEntity newEntity = new BpjsOutsideFacilityReferralEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
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
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringforTreatmentType = mock
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringforTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
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
		// % protected region % [Add customisation for Referred PPK Code here] off begin
		String randomStringforReferredPPKCode = mock
				.strings()
				.get();
		newEntity.setReferredPPKCode(randomStringforReferredPPKCode);
		// % protected region % [Add customisation for Referred PPK Code here] end
		// % protected region % [Add customisation for Referred PPK Name here] off begin
		String randomStringforReferredPPKName = mock
				.strings()
				.get();
		newEntity.setReferredPPKName(randomStringforReferredPPKName);
		// % protected region % [Add customisation for Referred PPK Name here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		String randomStringforSepDate = mock
				.strings()
				.get();
		newEntity.setSepDate(randomStringforSepDate);
		// % protected region % [Add customisation for SEP Date here] end
		// % protected region % [Add customisation for Visit Plan Date here] off begin
		String randomStringforVisitPlanDate = mock
				.strings()
				.get();
		newEntity.setVisitPlanDate(randomStringforVisitPlanDate);
		// % protected region % [Add customisation for Visit Plan Date here] end
		// % protected region % [Add customisation for Diagnose here] off begin
		String randomStringforDiagnose = mock
				.strings()
				.get();
		newEntity.setDiagnose(randomStringforDiagnose);
		// % protected region % [Add customisation for Diagnose here] end
		// % protected region % [Add customisation for Referral Type here] off begin
		String randomStringforReferralType = mock
				.strings()
				.get();
		newEntity.setReferralType(randomStringforReferralType);
		// % protected region % [Add customisation for Referral Type here] end
		// % protected region % [Add customisation for Referral Polyclinic here] off begin
		String randomStringforReferralPolyclinic = mock
				.strings()
				.get();
		newEntity.setReferralPolyclinic(randomStringforReferralPolyclinic);
		// % protected region % [Add customisation for Referral Polyclinic here] end
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
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsOutsideFacilityReferralEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Outside Facility Referral entities with no reference at all.
	 */
	@Provides
	@Named("bpjsOutsideFacilityReferralEntitiesWithNoRef")
	public Collection<BpjsOutsideFacilityReferralEntity> bpjsOutsideFacilityReferralEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsOutsideFacilityReferralEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsOutsideFacilityReferralEntitiesWithNoRef here] end
		BpjsOutsideFacilityReferralEntityFactory bpjsOutsideFacilityReferralEntityFactory
	) {
		log.trace("Creating entities of type BpjsOutsideFacilityReferralEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntitiesWithNoRef before the main body here] end

		Collection<BpjsOutsideFacilityReferralEntity> newEntities = bpjsOutsideFacilityReferralEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsOutsideFacilityReferralEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Outside Facility Referral entity with all references set.
	 */
	@Provides
	@Named("bpjsOutsideFacilityReferralEntityWithRefs")
	public BpjsOutsideFacilityReferralEntity bpjsOutsideFacilityReferralEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsOutsideFacilityReferralEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsOutsideFacilityReferralEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsOutsideFacilityReferralEntity with references");

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntityWithRefs before the main body here] end

		BpjsOutsideFacilityReferralEntity bpjsOutsideFacilityReferralEntity = injector.getInstance(Key.get(BpjsOutsideFacilityReferralEntity.class, Names.named("bpjsOutsideFacilityReferralEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsOutsideFacilityReferralEntity with references");

		return bpjsOutsideFacilityReferralEntity;
	}

	/**
	 * Return a collection of BPJS Outside Facility Referral entities with all references set.
	 */
	@Provides
	@Named("bpjsOutsideFacilityReferralEntitiesWithRefs")
	public Collection<BpjsOutsideFacilityReferralEntity> bpjsOutsideFacilityReferralEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsOutsideFacilityReferralEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsOutsideFacilityReferralEntitiesWithRefs here] end
		BpjsOutsideFacilityReferralEntityFactory bpjsOutsideFacilityReferralEntityFactory
	) {
		log.trace("Creating entities of type BpjsOutsideFacilityReferralEntity with references");

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntitiesWithRefs before the main body here] end

		Collection<BpjsOutsideFacilityReferralEntity> newEntities = bpjsOutsideFacilityReferralEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsOutsideFacilityReferralEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsOutsideFacilityReferralEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
