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
 * Guice module for BPJS Claim Submission used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsClaimSubmissionModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsClaimSubmissionModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsClaimSubmissionModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsClaimSubmissionEntityFactory bpjsClaimSubmissionEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsClaimSubmissionEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsClaimSubmissionEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsClaimSubmissionEntityFactory");

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntityFactory before the main body here] end

		BpjsClaimSubmissionEntityFactory entityFactory = new BpjsClaimSubmissionEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsClaimSubmissionEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsClaimSubmissionEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntityFactory after the main body here] end

		log.trace("Created BpjsClaimSubmissionEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Claim Submission entity with no references set.
	 */
	@Provides
	@Named("bpjsClaimSubmissionEntityWithNoRef")
	public BpjsClaimSubmissionEntity bpjsClaimSubmissionEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsClaimSubmissionEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsClaimSubmissionEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsClaimSubmissionEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionWithNoRef before the main body here] end

		BpjsClaimSubmissionEntity newEntity = new BpjsClaimSubmissionEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Admission Date here] off begin
		newEntity.setAdmissionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for Insurance Provider here] off begin
		String randomStringforInsuranceProvider = mock
				.strings()
				.get();
		newEntity.setInsuranceProvider(randomStringforInsuranceProvider);
		// % protected region % [Add customisation for Insurance Provider here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringforTreatmentType = mock
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringforTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Follow Up Plan here] off begin
		String randomStringforFollowUpPlan = mock
				.strings()
				.get();
		newEntity.setFollowUpPlan(randomStringforFollowUpPlan);
		// % protected region % [Add customisation for Follow Up Plan here] end
		// % protected region % [Add customisation for Control Date here] off begin
		newEntity.setControlDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Control Date here] end
		// % protected region % [Add customisation for Additional Diagnosis here] off begin
		String randomStringforAdditionalDiagnosis = mock
				.strings()
				.get();
		newEntity.setAdditionalDiagnosis(randomStringforAdditionalDiagnosis);
		// % protected region % [Add customisation for Additional Diagnosis here] end
		// % protected region % [Add customisation for Additional Procedure here] off begin
		String randomStringforAdditionalProcedure = mock
				.strings()
				.get();
		newEntity.setAdditionalProcedure(randomStringforAdditionalProcedure);
		// % protected region % [Add customisation for Additional Procedure here] end
		// % protected region % [Add customisation for Kelas Rawat here] off begin
		newEntity.setKelasRawat(KelasRawatEnum.TANPA_KELAS);
		// % protected region % [Add customisation for Kelas Rawat here] end

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsClaimSubmissionEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Claim Submission entities with no reference at all.
	 */
	@Provides
	@Named("bpjsClaimSubmissionEntitiesWithNoRef")
	public Collection<BpjsClaimSubmissionEntity> bpjsClaimSubmissionEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsClaimSubmissionEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsClaimSubmissionEntitiesWithNoRef here] end
		BpjsClaimSubmissionEntityFactory bpjsClaimSubmissionEntityFactory
	) {
		log.trace("Creating entities of type BpjsClaimSubmissionEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntitiesWithNoRef before the main body here] end

		Collection<BpjsClaimSubmissionEntity> newEntities = bpjsClaimSubmissionEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsClaimSubmissionEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Claim Submission entity with all references set.
	 */
	@Provides
	@Named("bpjsClaimSubmissionEntityWithRefs")
	public BpjsClaimSubmissionEntity bpjsClaimSubmissionEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsClaimSubmissionEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsClaimSubmissionEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsClaimSubmissionEntity with references");

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntityWithRefs before the main body here] end

		BpjsClaimSubmissionEntity bpjsClaimSubmissionEntity = injector.getInstance(Key.get(BpjsClaimSubmissionEntity.class, Names.named("bpjsClaimSubmissionEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsClaimSubmissionEntity with references");

		return bpjsClaimSubmissionEntity;
	}

	/**
	 * Return a collection of BPJS Claim Submission entities with all references set.
	 */
	@Provides
	@Named("bpjsClaimSubmissionEntitiesWithRefs")
	public Collection<BpjsClaimSubmissionEntity> bpjsClaimSubmissionEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsClaimSubmissionEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsClaimSubmissionEntitiesWithRefs here] end
		BpjsClaimSubmissionEntityFactory bpjsClaimSubmissionEntityFactory
	) {
		log.trace("Creating entities of type BpjsClaimSubmissionEntity with references");

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntitiesWithRefs before the main body here] end

		Collection<BpjsClaimSubmissionEntity> newEntities = bpjsClaimSubmissionEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsClaimSubmissionEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsClaimSubmissionEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
