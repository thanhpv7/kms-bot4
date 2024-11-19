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
 * Guice module for BPJS SEP INACBG Integration used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsSEPINACBGIntegrationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsSEPINACBGIntegrationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsSEPINACBGIntegrationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsSEPINACBGIntegrationEntityFactory bpjsSEPINACBGIntegrationEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsSEPINACBGIntegrationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsSEPINACBGIntegrationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsSEPINACBGIntegrationEntityFactory");

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntityFactory before the main body here] end

		BpjsSEPINACBGIntegrationEntityFactory entityFactory = new BpjsSEPINACBGIntegrationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsSEPINACBGIntegrationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsSEPINACBGIntegrationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntityFactory after the main body here] end

		log.trace("Created BpjsSEPINACBGIntegrationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS SEP INACBG Integration entity with no references set.
	 */
	@Provides
	@Named("bpjsSEPINACBGIntegrationEntityWithNoRef")
	public BpjsSEPINACBGIntegrationEntity bpjsSEPINACBGIntegrationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsSEPINACBGIntegrationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSEPINACBGIntegrationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsSEPINACBGIntegrationEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationWithNoRef before the main body here] end

		BpjsSEPINACBGIntegrationEntity newEntity = new BpjsSEPINACBGIntegrationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Patient ID here] off begin
		String randomStringforPatientID = mock
				.strings()
				.get();
		newEntity.setPatientID(randomStringforPatientID);
		// % protected region % [Add customisation for Patient ID here] end
		// % protected region % [Add customisation for Patient Name here] off begin
		String randomStringforPatientName = mock
				.strings()
				.get();
		newEntity.setPatientName(randomStringforPatientName);
		// % protected region % [Add customisation for Patient Name here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringforGender = mock
				.strings()
				.get();
		newEntity.setGender(randomStringforGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringforReferralNo = mock
				.strings()
				.get();
		newEntity.setReferralNo(randomStringforReferralNo);
		// % protected region % [Add customisation for Referral No here] end
		// % protected region % [Add customisation for Date of Birth here] off begin
		String randomStringforDateOfBirth = mock
				.strings()
				.get();
		newEntity.setDateOfBirth(randomStringforDateOfBirth);
		// % protected region % [Add customisation for Date of Birth here] end
		// % protected region % [Add customisation for Visit Date here] off begin
		String randomStringforVisitDate = mock
				.strings()
				.get();
		newEntity.setVisitDate(randomStringforVisitDate);
		// % protected region % [Add customisation for Visit Date here] end
		// % protected region % [Add customisation for Health Facility Level here] off begin
		String randomStringforHealthFacilityLevel = mock
				.strings()
				.get();
		newEntity.setHealthFacilityLevel(randomStringforHealthFacilityLevel);
		// % protected region % [Add customisation for Health Facility Level here] end

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsSEPINACBGIntegrationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS SEP INACBG Integration entities with no reference at all.
	 */
	@Provides
	@Named("bpjsSEPINACBGIntegrationEntitiesWithNoRef")
	public Collection<BpjsSEPINACBGIntegrationEntity> bpjsSEPINACBGIntegrationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsSEPINACBGIntegrationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSEPINACBGIntegrationEntitiesWithNoRef here] end
		BpjsSEPINACBGIntegrationEntityFactory bpjsSEPINACBGIntegrationEntityFactory
	) {
		log.trace("Creating entities of type BpjsSEPINACBGIntegrationEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntitiesWithNoRef before the main body here] end

		Collection<BpjsSEPINACBGIntegrationEntity> newEntities = bpjsSEPINACBGIntegrationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsSEPINACBGIntegrationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS SEP INACBG Integration entity with all references set.
	 */
	@Provides
	@Named("bpjsSEPINACBGIntegrationEntityWithRefs")
	public BpjsSEPINACBGIntegrationEntity bpjsSEPINACBGIntegrationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsSEPINACBGIntegrationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSEPINACBGIntegrationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsSEPINACBGIntegrationEntity with references");

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntityWithRefs before the main body here] end

		BpjsSEPINACBGIntegrationEntity bpjsSEPINACBGIntegrationEntity = injector.getInstance(Key.get(BpjsSEPINACBGIntegrationEntity.class, Names.named("bpjsSEPINACBGIntegrationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsSEPINACBGIntegrationEntity with references");

		return bpjsSEPINACBGIntegrationEntity;
	}

	/**
	 * Return a collection of BPJS SEP INACBG Integration entities with all references set.
	 */
	@Provides
	@Named("bpjsSEPINACBGIntegrationEntitiesWithRefs")
	public Collection<BpjsSEPINACBGIntegrationEntity> bpjsSEPINACBGIntegrationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsSEPINACBGIntegrationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSEPINACBGIntegrationEntitiesWithRefs here] end
		BpjsSEPINACBGIntegrationEntityFactory bpjsSEPINACBGIntegrationEntityFactory
	) {
		log.trace("Creating entities of type BpjsSEPINACBGIntegrationEntity with references");

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntitiesWithRefs before the main body here] end

		Collection<BpjsSEPINACBGIntegrationEntity> newEntities = bpjsSEPINACBGIntegrationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPINACBGIntegrationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsSEPINACBGIntegrationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
