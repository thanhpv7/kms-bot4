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
 * Guice module for Patient Personal Info used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientPersonalInfoModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientPersonalInfoModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientPersonalInfoModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientPersonalInfoEntityFactory patientPersonalInfoEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientPersonalInfoEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientPersonalInfoEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientPersonalInfoEntityFactory");

		// % protected region % [Apply any additional logic for patientPersonalInfoEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoEntityFactory before the main body here] end

		PatientPersonalInfoEntityFactory entityFactory = new PatientPersonalInfoEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientPersonalInfoEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientPersonalInfoEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientPersonalInfoEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoEntityFactory after the main body here] end

		log.trace("Created PatientPersonalInfoEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Personal Info entity with no references set.
	 */
	@Provides
	@Named("patientPersonalInfoEntityWithNoRef")
	public PatientPersonalInfoEntity patientPersonalInfoEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientPersonalInfoEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPersonalInfoEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientPersonalInfoEntity with no reference");

		// % protected region % [Apply any additional logic for patientPersonalInfoWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoWithNoRef before the main body here] end

		PatientPersonalInfoEntity newEntity = new PatientPersonalInfoEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Religion here] off begin
		String randomStringforReligion = mock
				.strings()
				.get();
		newEntity.setReligion(randomStringforReligion);
		// % protected region % [Add customisation for Religion here] end
		// % protected region % [Add customisation for Nationality here] off begin
		String randomStringforNationality = mock
				.strings()
				.get();
		newEntity.setNationality(randomStringforNationality);
		// % protected region % [Add customisation for Nationality here] end
		// % protected region % [Add customisation for Ethnicity here] off begin
		String randomStringforEthnicity = mock
				.strings()
				.get();
		newEntity.setEthnicity(randomStringforEthnicity);
		// % protected region % [Add customisation for Ethnicity here] end
		// % protected region % [Add customisation for Blood Type here] off begin
		newEntity.setBloodType(BloodTypeEnum.A);
		// % protected region % [Add customisation for Blood Type here] end
		// % protected region % [Add customisation for Rhesus here] off begin
		newEntity.setRhesus(RhesusEnum.POSITIVE);
		// % protected region % [Add customisation for Rhesus here] end
		// % protected region % [Add customisation for ID Number here] off begin
		String randomStringforIdNumber = mock
				.strings()
				.get();
		newEntity.setIdNumber(randomStringforIdNumber);
		// % protected region % [Add customisation for ID Number here] end
		// % protected region % [Add customisation for Occupation here] off begin
		String randomStringforOccupation = mock
				.strings()
				.get();
		newEntity.setOccupation(randomStringforOccupation);
		// % protected region % [Add customisation for Occupation here] end
		// % protected region % [Add customisation for External Patient here] off begin
		newEntity.setExternalPatient(mock.bools().get());
		// % protected region % [Add customisation for External Patient here] end
		// % protected region % [Add customisation for Is Dead here] off begin
		newEntity.setIsDead(mock.bools().get());
		// % protected region % [Add customisation for Is Dead here] end
		// % protected region % [Add customisation for External Notes here] off begin
		String randomStringforExternalNotes = mock
				.strings()
				.get();
		newEntity.setExternalNotes(randomStringforExternalNotes);
		// % protected region % [Add customisation for External Notes here] end
		// % protected region % [Add customisation for Other ID Number here] off begin
		String randomStringforOtherIDNumber = mock
				.strings()
				.get();
		newEntity.setOtherIDNumber(randomStringforOtherIDNumber);
		// % protected region % [Add customisation for Other ID Number here] end

		// % protected region % [Apply any additional logic for patientPersonalInfoWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoWithNoRef after the main body here] end

		log.trace("Created entity of type PatientPersonalInfoEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Personal Info entities with no reference at all.
	 */
	@Provides
	@Named("patientPersonalInfoEntitiesWithNoRef")
	public Collection<PatientPersonalInfoEntity> patientPersonalInfoEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientPersonalInfoEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPersonalInfoEntitiesWithNoRef here] end
		PatientPersonalInfoEntityFactory patientPersonalInfoEntityFactory
	) {
		log.trace("Creating entities of type PatientPersonalInfoEntity with no reference");

		// % protected region % [Apply any additional logic for patientPersonalInfoEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoEntitiesWithNoRef before the main body here] end

		Collection<PatientPersonalInfoEntity> newEntities = patientPersonalInfoEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientPersonalInfoEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientPersonalInfoEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Personal Info entity with all references set.
	 */
	@Provides
	@Named("patientPersonalInfoEntityWithRefs")
	public PatientPersonalInfoEntity patientPersonalInfoEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientPersonalInfoEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientPersonalInfoEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientPersonalInfoEntity with references");

		// % protected region % [Apply any additional logic for patientPersonalInfoEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoEntityWithRefs before the main body here] end

		PatientPersonalInfoEntity patientPersonalInfoEntity = injector.getInstance(Key.get(PatientPersonalInfoEntity.class, Names.named("patientPersonalInfoEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientPersonalInfoEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientPersonalInfoEntity with references");

		return patientPersonalInfoEntity;
	}

	/**
	 * Return a collection of Patient Personal Info entities with all references set.
	 */
	@Provides
	@Named("patientPersonalInfoEntitiesWithRefs")
	public Collection<PatientPersonalInfoEntity> patientPersonalInfoEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientPersonalInfoEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientPersonalInfoEntitiesWithRefs here] end
		PatientPersonalInfoEntityFactory patientPersonalInfoEntityFactory
	) {
		log.trace("Creating entities of type PatientPersonalInfoEntity with references");

		// % protected region % [Apply any additional logic for patientPersonalInfoEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoEntitiesWithRefs before the main body here] end

		Collection<PatientPersonalInfoEntity> newEntities = patientPersonalInfoEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientPersonalInfoEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientPersonalInfoEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
