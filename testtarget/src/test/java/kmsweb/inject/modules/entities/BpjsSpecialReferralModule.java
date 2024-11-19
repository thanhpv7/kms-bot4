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
 * Guice module for BPJS Special Referral used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsSpecialReferralModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsSpecialReferralModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsSpecialReferralModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsSpecialReferralEntityFactory bpjsSpecialReferralEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsSpecialReferralEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsSpecialReferralEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsSpecialReferralEntityFactory");

		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntityFactory before the main body here] end

		BpjsSpecialReferralEntityFactory entityFactory = new BpjsSpecialReferralEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsSpecialReferralEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsSpecialReferralEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntityFactory after the main body here] end

		log.trace("Created BpjsSpecialReferralEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Special Referral entity with no references set.
	 */
	@Provides
	@Named("bpjsSpecialReferralEntityWithNoRef")
	public BpjsSpecialReferralEntity bpjsSpecialReferralEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsSpecialReferralEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSpecialReferralEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsSpecialReferralEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSpecialReferralWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralWithNoRef before the main body here] end

		BpjsSpecialReferralEntity newEntity = new BpjsSpecialReferralEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Referral ID here] off begin
		String randomStringforReferralID = mock
				.strings()
				.get();
		newEntity.setReferralID(randomStringforReferralID);
		// % protected region % [Add customisation for Referral ID here] end
		// % protected region % [Add customisation for Referral No here] off begin
		String randomStringforReferralNo = mock
				.strings()
				.get();
		newEntity.setReferralNo(randomStringforReferralNo);
		// % protected region % [Add customisation for Referral No here] end
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
		// % protected region % [Add customisation for PPK Diagnose here] off begin
		String randomStringforPpkDiagnose = mock
				.strings()
				.get();
		newEntity.setPpkDiagnose(randomStringforPpkDiagnose);
		// % protected region % [Add customisation for PPK Diagnose here] end
		// % protected region % [Add customisation for Referral Start Date here] off begin
		String randomStringforReferralStartDate = mock
				.strings()
				.get();
		newEntity.setReferralStartDate(randomStringforReferralStartDate);
		// % protected region % [Add customisation for Referral Start Date here] end
		// % protected region % [Add customisation for Referral End Date here] off begin
		String randomStringforReferralEndDate = mock
				.strings()
				.get();
		newEntity.setReferralEndDate(randomStringforReferralEndDate);
		// % protected region % [Add customisation for Referral End Date here] end

		// % protected region % [Apply any additional logic for bpjsSpecialReferralWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsSpecialReferralEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Special Referral entities with no reference at all.
	 */
	@Provides
	@Named("bpjsSpecialReferralEntitiesWithNoRef")
	public Collection<BpjsSpecialReferralEntity> bpjsSpecialReferralEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsSpecialReferralEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSpecialReferralEntitiesWithNoRef here] end
		BpjsSpecialReferralEntityFactory bpjsSpecialReferralEntityFactory
	) {
		log.trace("Creating entities of type BpjsSpecialReferralEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntitiesWithNoRef before the main body here] end

		Collection<BpjsSpecialReferralEntity> newEntities = bpjsSpecialReferralEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsSpecialReferralEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Special Referral entity with all references set.
	 */
	@Provides
	@Named("bpjsSpecialReferralEntityWithRefs")
	public BpjsSpecialReferralEntity bpjsSpecialReferralEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsSpecialReferralEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSpecialReferralEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsSpecialReferralEntity with references");

		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntityWithRefs before the main body here] end

		BpjsSpecialReferralEntity bpjsSpecialReferralEntity = injector.getInstance(Key.get(BpjsSpecialReferralEntity.class, Names.named("bpjsSpecialReferralEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsSpecialReferralEntity with references");

		return bpjsSpecialReferralEntity;
	}

	/**
	 * Return a collection of BPJS Special Referral entities with all references set.
	 */
	@Provides
	@Named("bpjsSpecialReferralEntitiesWithRefs")
	public Collection<BpjsSpecialReferralEntity> bpjsSpecialReferralEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsSpecialReferralEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSpecialReferralEntitiesWithRefs here] end
		BpjsSpecialReferralEntityFactory bpjsSpecialReferralEntityFactory
	) {
		log.trace("Creating entities of type BpjsSpecialReferralEntity with references");

		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntitiesWithRefs before the main body here] end

		Collection<BpjsSpecialReferralEntity> newEntities = bpjsSpecialReferralEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSpecialReferralEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsSpecialReferralEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
