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
 * Guice module for Patient General Info used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientGeneralInfoModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientGeneralInfoModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientGeneralInfoModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientGeneralInfoEntityFactory patientGeneralInfoEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientGeneralInfoEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientGeneralInfoEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientGeneralInfoEntityFactory");

		// % protected region % [Apply any additional logic for patientGeneralInfoEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoEntityFactory before the main body here] end

		PatientGeneralInfoEntityFactory entityFactory = new PatientGeneralInfoEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientGeneralInfoEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientGeneralInfoEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientGeneralInfoEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoEntityFactory after the main body here] end

		log.trace("Created PatientGeneralInfoEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient General Info entity with no references set.
	 */
	@Provides
	@Named("patientGeneralInfoEntityWithNoRef")
	public PatientGeneralInfoEntity patientGeneralInfoEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientGeneralInfoEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientGeneralInfoEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientGeneralInfoEntity with no reference");

		// % protected region % [Apply any additional logic for patientGeneralInfoWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoWithNoRef before the main body here] end

		PatientGeneralInfoEntity newEntity = new PatientGeneralInfoEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Patient ID here] off begin
		String randomStringforPatientID = mock
				.strings()
				.get();
		newEntity.setPatientID(randomStringforPatientID);
		// % protected region % [Add customisation for Patient ID here] end
		// % protected region % [Add customisation for Title here] off begin
		String randomStringforTitle = mock
				.strings()
				.get();
		newEntity.setTitle(randomStringforTitle);
		// % protected region % [Add customisation for Title here] end
		// % protected region % [Add customisation for Given Name here] off begin
		String randomStringforGivenName = mock
				.strings()
				.get();
		newEntity.setGivenName(randomStringforGivenName);
		// % protected region % [Add customisation for Given Name here] end
		// % protected region % [Add customisation for Last Name here] off begin
		String randomStringforLastName = mock
				.strings()
				.get();
		newEntity.setLastName(randomStringforLastName);
		// % protected region % [Add customisation for Last Name here] end
		// % protected region % [Add customisation for Place of Birth here] off begin
		String randomStringforPlaceOfBirth = mock
				.strings()
				.get();
		newEntity.setPlaceOfBirth(randomStringforPlaceOfBirth);
		// % protected region % [Add customisation for Place of Birth here] end
		// % protected region % [Add customisation for Date of Birth here] off begin
		newEntity.setDateOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date of Birth here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringforGender = mock
				.strings()
				.get();
		newEntity.setGender(randomStringforGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringforAddress = mock
				.strings()
				.get();
		newEntity.setAddress(randomStringforAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Patient Payment Type here] off begin
		String randomStringforPatientPaymentType = mock
				.strings()
				.get();
		newEntity.setPatientPaymentType(randomStringforPatientPaymentType);
		// % protected region % [Add customisation for Patient Payment Type here] end
		// % protected region % [Add customisation for Important Notes here] off begin
		String randomStringforImportantNotes = mock
				.strings()
				.get();
		newEntity.setImportantNotes(randomStringforImportantNotes);
		// % protected region % [Add customisation for Important Notes here] end
		// % protected region % [Add customisation for Patient Picture here] off begin
		// % protected region % [Add customisation for Patient Picture here] end
		// % protected region % [Add customisation for Has Outstanding Payment here] off begin
		newEntity.setHasOutstandingPayment(mock.bools().get());
		// % protected region % [Add customisation for Has Outstanding Payment here] end

		// % protected region % [Apply any additional logic for patientGeneralInfoWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoWithNoRef after the main body here] end

		log.trace("Created entity of type PatientGeneralInfoEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient General Info entities with no reference at all.
	 */
	@Provides
	@Named("patientGeneralInfoEntitiesWithNoRef")
	public Collection<PatientGeneralInfoEntity> patientGeneralInfoEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientGeneralInfoEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientGeneralInfoEntitiesWithNoRef here] end
		PatientGeneralInfoEntityFactory patientGeneralInfoEntityFactory
	) {
		log.trace("Creating entities of type PatientGeneralInfoEntity with no reference");

		// % protected region % [Apply any additional logic for patientGeneralInfoEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoEntitiesWithNoRef before the main body here] end

		Collection<PatientGeneralInfoEntity> newEntities = patientGeneralInfoEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientGeneralInfoEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientGeneralInfoEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient General Info entity with all references set.
	 */
	@Provides
	@Named("patientGeneralInfoEntityWithRefs")
	public PatientGeneralInfoEntity patientGeneralInfoEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientGeneralInfoEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientGeneralInfoEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientGeneralInfoEntity with references");

		// % protected region % [Apply any additional logic for patientGeneralInfoEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoEntityWithRefs before the main body here] end

		PatientGeneralInfoEntity patientGeneralInfoEntity = injector.getInstance(Key.get(PatientGeneralInfoEntity.class, Names.named("patientGeneralInfoEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientGeneralInfoEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientGeneralInfoEntity with references");

		return patientGeneralInfoEntity;
	}

	/**
	 * Return a collection of Patient General Info entities with all references set.
	 */
	@Provides
	@Named("patientGeneralInfoEntitiesWithRefs")
	public Collection<PatientGeneralInfoEntity> patientGeneralInfoEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientGeneralInfoEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientGeneralInfoEntitiesWithRefs here] end
		PatientGeneralInfoEntityFactory patientGeneralInfoEntityFactory
	) {
		log.trace("Creating entities of type PatientGeneralInfoEntity with references");

		// % protected region % [Apply any additional logic for patientGeneralInfoEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoEntitiesWithRefs before the main body here] end

		Collection<PatientGeneralInfoEntity> newEntities = patientGeneralInfoEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientGeneralInfoEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientGeneralInfoEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientGeneralInfoEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
