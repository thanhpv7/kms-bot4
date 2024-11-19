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
 * Guice module for BPJS SEP Internal Data used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsSEPInternalDataModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsSEPInternalDataModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsSEPInternalDataModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsSEPInternalDataEntityFactory bpjsSEPInternalDataEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsSEPInternalDataEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsSEPInternalDataEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsSEPInternalDataEntityFactory");

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntityFactory before the main body here] end

		BpjsSEPInternalDataEntityFactory entityFactory = new BpjsSEPInternalDataEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsSEPInternalDataEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsSEPInternalDataEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntityFactory after the main body here] end

		log.trace("Created BpjsSEPInternalDataEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS SEP Internal Data entity with no references set.
	 */
	@Provides
	@Named("bpjsSEPInternalDataEntityWithNoRef")
	public BpjsSEPInternalDataEntity bpjsSEPInternalDataEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsSEPInternalDataEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSEPInternalDataEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsSEPInternalDataEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataWithNoRef before the main body here] end

		BpjsSEPInternalDataEntity newEntity = new BpjsSEPInternalDataEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Referred Polyclinic here] off begin
		String randomStringforReferredPolyclinic = mock
				.strings()
				.get();
		newEntity.setReferredPolyclinic(randomStringforReferredPolyclinic);
		// % protected region % [Add customisation for Referred Polyclinic here] end
		// % protected region % [Add customisation for Referring Polyclinic here] off begin
		String randomStringforReferringPolyclinic = mock
				.strings()
				.get();
		newEntity.setReferringPolyclinic(randomStringforReferringPolyclinic);
		// % protected region % [Add customisation for Referring Polyclinic here] end
		// % protected region % [Add customisation for Internal Referral Date here] off begin
		String randomStringforInternalReferralDate = mock
				.strings()
				.get();
		newEntity.setInternalReferralDate(randomStringforInternalReferralDate);
		// % protected region % [Add customisation for Internal Referral Date here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Ref SEP No here] off begin
		String randomStringforRefSEPNo = mock
				.strings()
				.get();
		newEntity.setRefSEPNo(randomStringforRefSEPNo);
		// % protected region % [Add customisation for Ref SEP No here] end
		// % protected region % [Add customisation for SEP Health Facility here] off begin
		String randomStringforSepHealthFacility = mock
				.strings()
				.get();
		newEntity.setSepHealthFacility(randomStringforSepHealthFacility);
		// % protected region % [Add customisation for SEP Health Facility here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		String randomStringforSepDate = mock
				.strings()
				.get();
		newEntity.setSepDate(randomStringforSepDate);
		// % protected region % [Add customisation for SEP Date here] end
		// % protected region % [Add customisation for Letter No here] off begin
		String randomStringforLetterNo = mock
				.strings()
				.get();
		newEntity.setLetterNo(randomStringforLetterNo);
		// % protected region % [Add customisation for Letter No here] end
		// % protected region % [Add customisation for Is Internal here] off begin
		String randomStringforIsInternal = mock
				.strings()
				.get();
		newEntity.setIsInternal(randomStringforIsInternal);
		// % protected region % [Add customisation for Is Internal here] end
		// % protected region % [Add customisation for Referring Polyclinic Code here] off begin
		String randomStringforReferringPolyclinicCode = mock
				.strings()
				.get();
		newEntity.setReferringPolyclinicCode(randomStringforReferringPolyclinicCode);
		// % protected region % [Add customisation for Referring Polyclinic Code here] end
		// % protected region % [Add customisation for Diagnostic Support here] off begin
		String randomStringforDiagnosticSupport = mock
				.strings()
				.get();
		newEntity.setDiagnosticSupport(randomStringforDiagnosticSupport);
		// % protected region % [Add customisation for Diagnostic Support here] end
		// % protected region % [Add customisation for Referring Diagnose here] off begin
		String randomStringforReferringDiagnose = mock
				.strings()
				.get();
		newEntity.setReferringDiagnose(randomStringforReferringDiagnose);
		// % protected region % [Add customisation for Referring Diagnose here] end
		// % protected region % [Add customisation for Doctor here] off begin
		String randomStringforDoctor = mock
				.strings()
				.get();
		newEntity.setDoctor(randomStringforDoctor);
		// % protected region % [Add customisation for Doctor here] end

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsSEPInternalDataEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS SEP Internal Data entities with no reference at all.
	 */
	@Provides
	@Named("bpjsSEPInternalDataEntitiesWithNoRef")
	public Collection<BpjsSEPInternalDataEntity> bpjsSEPInternalDataEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsSEPInternalDataEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSEPInternalDataEntitiesWithNoRef here] end
		BpjsSEPInternalDataEntityFactory bpjsSEPInternalDataEntityFactory
	) {
		log.trace("Creating entities of type BpjsSEPInternalDataEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntitiesWithNoRef before the main body here] end

		Collection<BpjsSEPInternalDataEntity> newEntities = bpjsSEPInternalDataEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsSEPInternalDataEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS SEP Internal Data entity with all references set.
	 */
	@Provides
	@Named("bpjsSEPInternalDataEntityWithRefs")
	public BpjsSEPInternalDataEntity bpjsSEPInternalDataEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsSEPInternalDataEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSEPInternalDataEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsSEPInternalDataEntity with references");

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntityWithRefs before the main body here] end

		BpjsSEPInternalDataEntity bpjsSEPInternalDataEntity = injector.getInstance(Key.get(BpjsSEPInternalDataEntity.class, Names.named("bpjsSEPInternalDataEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsSEPInternalDataEntity with references");

		return bpjsSEPInternalDataEntity;
	}

	/**
	 * Return a collection of BPJS SEP Internal Data entities with all references set.
	 */
	@Provides
	@Named("bpjsSEPInternalDataEntitiesWithRefs")
	public Collection<BpjsSEPInternalDataEntity> bpjsSEPInternalDataEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsSEPInternalDataEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSEPInternalDataEntitiesWithRefs here] end
		BpjsSEPInternalDataEntityFactory bpjsSEPInternalDataEntityFactory
	) {
		log.trace("Creating entities of type BpjsSEPInternalDataEntity with references");

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntitiesWithRefs before the main body here] end

		Collection<BpjsSEPInternalDataEntity> newEntities = bpjsSEPInternalDataEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPInternalDataEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsSEPInternalDataEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
