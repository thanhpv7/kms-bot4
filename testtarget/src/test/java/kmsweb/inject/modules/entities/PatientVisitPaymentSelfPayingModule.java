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
 * Guice module for Patient Visit Payment Self Paying used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientVisitPaymentSelfPayingModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientVisitPaymentSelfPayingModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientVisitPaymentSelfPayingModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientVisitPaymentSelfPayingEntityFactory patientVisitPaymentSelfPayingEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientVisitPaymentSelfPayingEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientVisitPaymentSelfPayingEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientVisitPaymentSelfPayingEntityFactory");

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntityFactory before the main body here] end

		PatientVisitPaymentSelfPayingEntityFactory entityFactory = new PatientVisitPaymentSelfPayingEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientVisitPaymentSelfPayingEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientVisitPaymentSelfPayingEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntityFactory after the main body here] end

		log.trace("Created PatientVisitPaymentSelfPayingEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Visit Payment Self Paying entity with no references set.
	 */
	@Provides
	@Named("patientVisitPaymentSelfPayingEntityWithNoRef")
	public PatientVisitPaymentSelfPayingEntity patientVisitPaymentSelfPayingEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientVisitPaymentSelfPayingEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVisitPaymentSelfPayingEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientVisitPaymentSelfPayingEntity with no reference");

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingWithNoRef before the main body here] end

		PatientVisitPaymentSelfPayingEntity newEntity = new PatientVisitPaymentSelfPayingEntity();
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

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingWithNoRef after the main body here] end

		log.trace("Created entity of type PatientVisitPaymentSelfPayingEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Visit Payment Self Paying entities with no reference at all.
	 */
	@Provides
	@Named("patientVisitPaymentSelfPayingEntitiesWithNoRef")
	public Collection<PatientVisitPaymentSelfPayingEntity> patientVisitPaymentSelfPayingEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientVisitPaymentSelfPayingEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVisitPaymentSelfPayingEntitiesWithNoRef here] end
		PatientVisitPaymentSelfPayingEntityFactory patientVisitPaymentSelfPayingEntityFactory
	) {
		log.trace("Creating entities of type PatientVisitPaymentSelfPayingEntity with no reference");

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntitiesWithNoRef before the main body here] end

		Collection<PatientVisitPaymentSelfPayingEntity> newEntities = patientVisitPaymentSelfPayingEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientVisitPaymentSelfPayingEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Visit Payment Self Paying entity with all references set.
	 */
	@Provides
	@Named("patientVisitPaymentSelfPayingEntityWithRefs")
	public PatientVisitPaymentSelfPayingEntity patientVisitPaymentSelfPayingEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientVisitPaymentSelfPayingEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVisitPaymentSelfPayingEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientVisitPaymentSelfPayingEntity with references");

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntityWithRefs before the main body here] end

		PatientVisitPaymentSelfPayingEntity patientVisitPaymentSelfPayingEntity = injector.getInstance(Key.get(PatientVisitPaymentSelfPayingEntity.class, Names.named("patientVisitPaymentSelfPayingEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientVisitPaymentSelfPayingEntity with references");

		return patientVisitPaymentSelfPayingEntity;
	}

	/**
	 * Return a collection of Patient Visit Payment Self Paying entities with all references set.
	 */
	@Provides
	@Named("patientVisitPaymentSelfPayingEntitiesWithRefs")
	public Collection<PatientVisitPaymentSelfPayingEntity> patientVisitPaymentSelfPayingEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientVisitPaymentSelfPayingEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVisitPaymentSelfPayingEntitiesWithRefs here] end
		PatientVisitPaymentSelfPayingEntityFactory patientVisitPaymentSelfPayingEntityFactory
	) {
		log.trace("Creating entities of type PatientVisitPaymentSelfPayingEntity with references");

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntitiesWithRefs before the main body here] end

		Collection<PatientVisitPaymentSelfPayingEntity> newEntities = patientVisitPaymentSelfPayingEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPaymentSelfPayingEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientVisitPaymentSelfPayingEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
