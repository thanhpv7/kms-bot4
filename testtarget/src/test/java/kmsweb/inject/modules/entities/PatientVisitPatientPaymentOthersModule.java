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
 * Guice module for Patient Visit Patient Payment Others used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientVisitPatientPaymentOthersModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientVisitPatientPaymentOthersModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientVisitPatientPaymentOthersModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientVisitPatientPaymentOthersEntityFactory patientVisitPatientPaymentOthersEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientVisitPatientPaymentOthersEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientVisitPatientPaymentOthersEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientVisitPatientPaymentOthersEntityFactory");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntityFactory before the main body here] end

		PatientVisitPatientPaymentOthersEntityFactory entityFactory = new PatientVisitPatientPaymentOthersEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientVisitPatientPaymentOthersEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientVisitPatientPaymentOthersEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntityFactory after the main body here] end

		log.trace("Created PatientVisitPatientPaymentOthersEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Visit Patient Payment Others entity with no references set.
	 */
	@Provides
	@Named("patientVisitPatientPaymentOthersEntityWithNoRef")
	public PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentOthersEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentOthersEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientVisitPatientPaymentOthersEntity with no reference");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersWithNoRef before the main body here] end

		PatientVisitPatientPaymentOthersEntity newEntity = new PatientVisitPatientPaymentOthersEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersWithNoRef after the main body here] end

		log.trace("Created entity of type PatientVisitPatientPaymentOthersEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Visit Patient Payment Others entities with no reference at all.
	 */
	@Provides
	@Named("patientVisitPatientPaymentOthersEntitiesWithNoRef")
	public Collection<PatientVisitPatientPaymentOthersEntity> patientVisitPatientPaymentOthersEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentOthersEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentOthersEntitiesWithNoRef here] end
		PatientVisitPatientPaymentOthersEntityFactory patientVisitPatientPaymentOthersEntityFactory
	) {
		log.trace("Creating entities of type PatientVisitPatientPaymentOthersEntity with no reference");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntitiesWithNoRef before the main body here] end

		Collection<PatientVisitPatientPaymentOthersEntity> newEntities = patientVisitPatientPaymentOthersEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientVisitPatientPaymentOthersEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Visit Patient Payment Others entity with all references set.
	 */
	@Provides
	@Named("patientVisitPatientPaymentOthersEntityWithRefs")
	public PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentOthersEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentOthersEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientVisitPatientPaymentOthersEntity with references");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntityWithRefs before the main body here] end

		PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity = injector.getInstance(Key.get(PatientVisitPatientPaymentOthersEntity.class, Names.named("patientVisitPatientPaymentOthersEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientVisitPatientPaymentOthersEntity with references");

		return patientVisitPatientPaymentOthersEntity;
	}

	/**
	 * Return a collection of Patient Visit Patient Payment Others entities with all references set.
	 */
	@Provides
	@Named("patientVisitPatientPaymentOthersEntitiesWithRefs")
	public Collection<PatientVisitPatientPaymentOthersEntity> patientVisitPatientPaymentOthersEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentOthersEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientVisitPatientPaymentOthersEntitiesWithRefs here] end
		PatientVisitPatientPaymentOthersEntityFactory patientVisitPatientPaymentOthersEntityFactory
	) {
		log.trace("Creating entities of type PatientVisitPatientPaymentOthersEntity with references");

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntitiesWithRefs before the main body here] end

		Collection<PatientVisitPatientPaymentOthersEntity> newEntities = patientVisitPatientPaymentOthersEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVisitPatientPaymentOthersEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientVisitPatientPaymentOthersEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
