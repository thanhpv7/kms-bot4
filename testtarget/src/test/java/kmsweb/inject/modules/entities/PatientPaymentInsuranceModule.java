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
 * Guice module for Patient Payment Insurance used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientPaymentInsuranceModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientPaymentInsuranceModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientPaymentInsuranceModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientPaymentInsuranceEntityFactory patientPaymentInsuranceEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientPaymentInsuranceEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientPaymentInsuranceEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientPaymentInsuranceEntityFactory");

		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntityFactory before the main body here] end

		PatientPaymentInsuranceEntityFactory entityFactory = new PatientPaymentInsuranceEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientPaymentInsuranceEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientPaymentInsuranceEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntityFactory after the main body here] end

		log.trace("Created PatientPaymentInsuranceEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Payment Insurance entity with no references set.
	 */
	@Provides
	@Named("patientPaymentInsuranceEntityWithNoRef")
	public PatientPaymentInsuranceEntity patientPaymentInsuranceEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientPaymentInsuranceEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPaymentInsuranceEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientPaymentInsuranceEntity with no reference");

		// % protected region % [Apply any additional logic for patientPaymentInsuranceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceWithNoRef before the main body here] end

		PatientPaymentInsuranceEntity newEntity = new PatientPaymentInsuranceEntity();
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

		// % protected region % [Apply any additional logic for patientPaymentInsuranceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceWithNoRef after the main body here] end

		log.trace("Created entity of type PatientPaymentInsuranceEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Payment Insurance entities with no reference at all.
	 */
	@Provides
	@Named("patientPaymentInsuranceEntitiesWithNoRef")
	public Collection<PatientPaymentInsuranceEntity> patientPaymentInsuranceEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientPaymentInsuranceEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPaymentInsuranceEntitiesWithNoRef here] end
		PatientPaymentInsuranceEntityFactory patientPaymentInsuranceEntityFactory
	) {
		log.trace("Creating entities of type PatientPaymentInsuranceEntity with no reference");

		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntitiesWithNoRef before the main body here] end

		Collection<PatientPaymentInsuranceEntity> newEntities = patientPaymentInsuranceEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientPaymentInsuranceEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Payment Insurance entity with all references set.
	 */
	@Provides
	@Named("patientPaymentInsuranceEntityWithRefs")
	public PatientPaymentInsuranceEntity patientPaymentInsuranceEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientPaymentInsuranceEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPaymentInsuranceEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientPaymentInsuranceEntity with references");

		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntityWithRefs before the main body here] end

		PatientPaymentInsuranceEntity patientPaymentInsuranceEntity = injector.getInstance(Key.get(PatientPaymentInsuranceEntity.class, Names.named("patientPaymentInsuranceEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientPaymentInsuranceEntity with references");

		return patientPaymentInsuranceEntity;
	}

	/**
	 * Return a collection of Patient Payment Insurance entities with all references set.
	 */
	@Provides
	@Named("patientPaymentInsuranceEntitiesWithRefs")
	public Collection<PatientPaymentInsuranceEntity> patientPaymentInsuranceEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientPaymentInsuranceEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPaymentInsuranceEntitiesWithRefs here] end
		PatientPaymentInsuranceEntityFactory patientPaymentInsuranceEntityFactory
	) {
		log.trace("Creating entities of type PatientPaymentInsuranceEntity with references");

		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntitiesWithRefs before the main body here] end

		Collection<PatientPaymentInsuranceEntity> newEntities = patientPaymentInsuranceEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentInsuranceEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientPaymentInsuranceEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
