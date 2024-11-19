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
 * Guice module for BPJS Patient Referral used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPatientReferralModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPatientReferralModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPatientReferralModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPatientReferralEntityFactory bpjsPatientReferralEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPatientReferralEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPatientReferralEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPatientReferralEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPatientReferralEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralEntityFactory before the main body here] end

		BpjsPatientReferralEntityFactory entityFactory = new BpjsPatientReferralEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPatientReferralEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPatientReferralEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPatientReferralEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralEntityFactory after the main body here] end

		log.trace("Created BpjsPatientReferralEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Patient Referral entity with no references set.
	 */
	@Provides
	@Named("bpjsPatientReferralEntityWithNoRef")
	public BpjsPatientReferralEntity bpjsPatientReferralEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPatientReferralEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPatientReferralEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPatientReferralEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPatientReferralWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralWithNoRef before the main body here] end

		BpjsPatientReferralEntity newEntity = new BpjsPatientReferralEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for No SEP here] off begin
		String randomStringforNoSEP = mock
				.strings()
				.get();
		newEntity.setNoSEP(randomStringforNoSEP);
		// % protected region % [Add customisation for No SEP here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringforReferralNo = mock
				.strings()
				.get();
		newEntity.setReferralNo(randomStringforReferralNo);
		// % protected region % [Add customisation for Referral No here] end
		// % protected region % [Add customisation for Referred Type here] off begin
		String randomStringforReferredType = mock
				.strings()
				.get();
		newEntity.setReferredType(randomStringforReferredType);
		// % protected region % [Add customisation for Referred Type here] end
		// % protected region % [Add customisation for Referral Date here] off begin
		newEntity.setReferralDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Referral Date here] end
		// % protected region % [Add customisation for Referal Date Plan here] off begin
		newEntity.setReferalDatePlan(OffsetDateTime.now());
		// % protected region % [Add customisation for Referal Date Plan here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringforTreatmentType = mock
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringforTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for bpjsPatientReferralWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPatientReferralEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Patient Referral entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPatientReferralEntitiesWithNoRef")
	public Collection<BpjsPatientReferralEntity> bpjsPatientReferralEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPatientReferralEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPatientReferralEntitiesWithNoRef here] end
		BpjsPatientReferralEntityFactory bpjsPatientReferralEntityFactory
	) {
		log.trace("Creating entities of type BpjsPatientReferralEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPatientReferralEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralEntitiesWithNoRef before the main body here] end

		Collection<BpjsPatientReferralEntity> newEntities = bpjsPatientReferralEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPatientReferralEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPatientReferralEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Patient Referral entity with all references set.
	 */
	@Provides
	@Named("bpjsPatientReferralEntityWithRefs")
	public BpjsPatientReferralEntity bpjsPatientReferralEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPatientReferralEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPatientReferralEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPatientReferralEntity with references");

		// % protected region % [Apply any additional logic for bpjsPatientReferralEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralEntityWithRefs before the main body here] end

		BpjsPatientReferralEntity bpjsPatientReferralEntity = injector.getInstance(Key.get(BpjsPatientReferralEntity.class, Names.named("bpjsPatientReferralEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPatientReferralEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPatientReferralEntity with references");

		return bpjsPatientReferralEntity;
	}

	/**
	 * Return a collection of BPJS Patient Referral entities with all references set.
	 */
	@Provides
	@Named("bpjsPatientReferralEntitiesWithRefs")
	public Collection<BpjsPatientReferralEntity> bpjsPatientReferralEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPatientReferralEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPatientReferralEntitiesWithRefs here] end
		BpjsPatientReferralEntityFactory bpjsPatientReferralEntityFactory
	) {
		log.trace("Creating entities of type BpjsPatientReferralEntity with references");

		// % protected region % [Apply any additional logic for bpjsPatientReferralEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralEntitiesWithRefs before the main body here] end

		Collection<BpjsPatientReferralEntity> newEntities = bpjsPatientReferralEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPatientReferralEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPatientReferralEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPatientReferralEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
