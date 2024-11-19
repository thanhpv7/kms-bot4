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
 * Guice module for Patient Payment  Self Paying used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientPaymentSelfPayingModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientPaymentSelfPayingModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientPaymentSelfPayingModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientPaymentSelfPayingEntityFactory patientPaymentSelfPayingEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientPaymentSelfPayingEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientPaymentSelfPayingEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientPaymentSelfPayingEntityFactory");

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntityFactory before the main body here] end

		PatientPaymentSelfPayingEntityFactory entityFactory = new PatientPaymentSelfPayingEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientPaymentSelfPayingEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientPaymentSelfPayingEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntityFactory after the main body here] end

		log.trace("Created PatientPaymentSelfPayingEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Payment  Self Paying entity with no references set.
	 */
	@Provides
	@Named("patientPaymentSelfPayingEntityWithNoRef")
	public PatientPaymentSelfPayingEntity patientPaymentSelfPayingEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientPaymentSelfPayingEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPaymentSelfPayingEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientPaymentSelfPayingEntity with no reference");

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingWithNoRef before the main body here] end

		PatientPaymentSelfPayingEntity newEntity = new PatientPaymentSelfPayingEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Sponsor Name here] off begin
		String randomStringforSponsorName = mock
				.strings()
				.get();
		newEntity.setSponsorName(randomStringforSponsorName);
		// % protected region % [Add customisation for Sponsor Name here] end
		// % protected region % [Add customisation for Sponsor Address here] off begin
		String randomStringforSponsorAddress = mock
				.strings()
				.get();
		newEntity.setSponsorAddress(randomStringforSponsorAddress);
		// % protected region % [Add customisation for Sponsor Address here] end
		// % protected region % [Add customisation for Sponsor Phone No here] off begin
		String randomStringforSponsorPhoneNo = mock
				.strings()
				.get();
		newEntity.setSponsorPhoneNo(randomStringforSponsorPhoneNo);
		// % protected region % [Add customisation for Sponsor Phone No here] end
		// % protected region % [Add customisation for Sponsorship here] off begin
		String randomStringforSponsorship = mock
				.strings()
				.get();
		newEntity.setSponsorship(randomStringforSponsorship);
		// % protected region % [Add customisation for Sponsorship here] end

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingWithNoRef after the main body here] end

		log.trace("Created entity of type PatientPaymentSelfPayingEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Payment  Self Paying entities with no reference at all.
	 */
	@Provides
	@Named("patientPaymentSelfPayingEntitiesWithNoRef")
	public Collection<PatientPaymentSelfPayingEntity> patientPaymentSelfPayingEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientPaymentSelfPayingEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPaymentSelfPayingEntitiesWithNoRef here] end
		PatientPaymentSelfPayingEntityFactory patientPaymentSelfPayingEntityFactory
	) {
		log.trace("Creating entities of type PatientPaymentSelfPayingEntity with no reference");

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntitiesWithNoRef before the main body here] end

		Collection<PatientPaymentSelfPayingEntity> newEntities = patientPaymentSelfPayingEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientPaymentSelfPayingEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Payment  Self Paying entity with all references set.
	 */
	@Provides
	@Named("patientPaymentSelfPayingEntityWithRefs")
	public PatientPaymentSelfPayingEntity patientPaymentSelfPayingEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientPaymentSelfPayingEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPaymentSelfPayingEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientPaymentSelfPayingEntity with references");

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntityWithRefs before the main body here] end

		PatientPaymentSelfPayingEntity patientPaymentSelfPayingEntity = injector.getInstance(Key.get(PatientPaymentSelfPayingEntity.class, Names.named("patientPaymentSelfPayingEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientPaymentSelfPayingEntity with references");

		return patientPaymentSelfPayingEntity;
	}

	/**
	 * Return a collection of Patient Payment  Self Paying entities with all references set.
	 */
	@Provides
	@Named("patientPaymentSelfPayingEntitiesWithRefs")
	public Collection<PatientPaymentSelfPayingEntity> patientPaymentSelfPayingEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientPaymentSelfPayingEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPaymentSelfPayingEntitiesWithRefs here] end
		PatientPaymentSelfPayingEntityFactory patientPaymentSelfPayingEntityFactory
	) {
		log.trace("Creating entities of type PatientPaymentSelfPayingEntity with references");

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntitiesWithRefs before the main body here] end

		Collection<PatientPaymentSelfPayingEntity> newEntities = patientPaymentSelfPayingEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPaymentSelfPayingEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientPaymentSelfPayingEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
