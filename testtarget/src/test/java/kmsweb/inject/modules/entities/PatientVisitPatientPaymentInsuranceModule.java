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
 * Guice module for Patient Visit Patient Payment Insurance used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientVisitPatientPaymentInsuranceModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientVisitPatientPaymentInsuranceModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientVisitPatientPaymentInsuranceModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientVisitPatientPaymentInsuranceEntityFactory patientVisitPatientPaymentInsuranceEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientVisitPatientPaymentInsuranceEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientVisitPatientPaymentInsuranceEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientVisitPatientPaymentInsuranceEntityFactory");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntityFactory before the main body here] end

		PatientVisitPatientPaymentInsuranceEntityFactory entityFactory = new PatientVisitPatientPaymentInsuranceEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientVisitPatientPaymentInsuranceEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientVisitPatientPaymentInsuranceEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntityFactory after the main body here] end

		log.trace("Created PatientVisitPatientPaymentInsuranceEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Visit Patient Payment Insurance entity with no references set.
	 */
	@Provides
	@Named("patientVisitPatientPaymentInsuranceEntityWithNoRef")
	public PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentInsuranceEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentInsuranceEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientVisitPatientPaymentInsuranceEntity with no reference");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceWithNoRef before the main body here] end

		PatientVisitPatientPaymentInsuranceEntity newEntity = new PatientVisitPatientPaymentInsuranceEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Member No here] off begin
		String randomStringforMemberNo = mock
				.strings()
				.get();
		newEntity.setMemberNo(randomStringforMemberNo);
		// % protected region % [Add customisation for Member No here] end
		// % protected region % [Add customisation for Policy Holder No here] off begin
		String randomStringforPolicyHolderNo = mock
				.strings()
				.get();
		newEntity.setPolicyHolderNo(randomStringforPolicyHolderNo);
		// % protected region % [Add customisation for Policy Holder No here] end
		// % protected region % [Add customisation for Eligility Verification here] off begin
		String randomStringforEligilityVerification = mock
				.strings()
				.get();
		newEntity.setEligilityVerification(randomStringforEligilityVerification);
		// % protected region % [Add customisation for Eligility Verification here] end
		// % protected region % [Add customisation for Guarantee Letter No here] off begin
		String randomStringforGuaranteeLetterNo = mock
				.strings()
				.get();
		newEntity.setGuaranteeLetterNo(randomStringforGuaranteeLetterNo);
		// % protected region % [Add customisation for Guarantee Letter No here] end
		// % protected region % [Add customisation for Coverage Balance here] off begin
		newEntity.setCoverageBalance(mock.doubles().get());
		// % protected region % [Add customisation for Coverage Balance here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceWithNoRef after the main body here] end

		log.trace("Created entity of type PatientVisitPatientPaymentInsuranceEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Visit Patient Payment Insurance entities with no reference at all.
	 */
	@Provides
	@Named("patientVisitPatientPaymentInsuranceEntitiesWithNoRef")
	public Collection<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsuranceEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentInsuranceEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentInsuranceEntitiesWithNoRef here] end
		PatientVisitPatientPaymentInsuranceEntityFactory patientVisitPatientPaymentInsuranceEntityFactory
	) {
		log.trace("Creating entities of type PatientVisitPatientPaymentInsuranceEntity with no reference");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntitiesWithNoRef before the main body here] end

		Collection<PatientVisitPatientPaymentInsuranceEntity> newEntities = patientVisitPatientPaymentInsuranceEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientVisitPatientPaymentInsuranceEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Visit Patient Payment Insurance entity with all references set.
	 */
	@Provides
	@Named("patientVisitPatientPaymentInsuranceEntityWithRefs")
	public PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentInsuranceEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentInsuranceEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientVisitPatientPaymentInsuranceEntity with references");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntityWithRefs before the main body here] end

		PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity = injector.getInstance(Key.get(PatientVisitPatientPaymentInsuranceEntity.class, Names.named("patientVisitPatientPaymentInsuranceEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientVisitPatientPaymentInsuranceEntity with references");

		return patientVisitPatientPaymentInsuranceEntity;
	}

	/**
	 * Return a collection of Patient Visit Patient Payment Insurance entities with all references set.
	 */
	@Provides
	@Named("patientVisitPatientPaymentInsuranceEntitiesWithRefs")
	public Collection<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsuranceEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentInsuranceEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentInsuranceEntitiesWithRefs here] end
		PatientVisitPatientPaymentInsuranceEntityFactory patientVisitPatientPaymentInsuranceEntityFactory
	) {
		log.trace("Creating entities of type PatientVisitPatientPaymentInsuranceEntity with references");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntitiesWithRefs before the main body here] end

		Collection<PatientVisitPatientPaymentInsuranceEntity> newEntities = patientVisitPatientPaymentInsuranceEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentInsuranceEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientVisitPatientPaymentInsuranceEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
