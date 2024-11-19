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
 * Guice module for Emergency Medical Examination Record used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class EmergencyMedicalExaminationRecordModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring EmergencyMedicalExaminationRecordModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured EmergencyMedicalExaminationRecordModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public EmergencyMedicalExaminationRecordEntityFactory emergencyMedicalExaminationRecordEntityFactory(
			// % protected region % [Apply any additional injected arguments for emergencyMedicalExaminationRecordEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for emergencyMedicalExaminationRecordEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating EmergencyMedicalExaminationRecordEntityFactory");

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntityFactory before the main body here] end

		EmergencyMedicalExaminationRecordEntityFactory entityFactory = new EmergencyMedicalExaminationRecordEntityFactory(
				// % protected region % [Apply any additional constructor arguments for EmergencyMedicalExaminationRecordEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for EmergencyMedicalExaminationRecordEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntityFactory after the main body here] end

		log.trace("Created EmergencyMedicalExaminationRecordEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Emergency Medical Examination Record entity with no references set.
	 */
	@Provides
	@Named("emergencyMedicalExaminationRecordEntityWithNoRef")
	public EmergencyMedicalExaminationRecordEntity emergencyMedicalExaminationRecordEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for emergencyMedicalExaminationRecordEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for emergencyMedicalExaminationRecordEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type EmergencyMedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordWithNoRef before the main body here] end

		EmergencyMedicalExaminationRecordEntity newEntity = new EmergencyMedicalExaminationRecordEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Surgical Or Non Surgical here] off begin
		String randomStringforSurgicalOrNonSurgical = mock
				.strings()
				.get();
		newEntity.setSurgicalOrNonSurgical(randomStringforSurgicalOrNonSurgical);
		// % protected region % [Add customisation for Surgical Or Non Surgical here] end
		// % protected region % [Add customisation for Case Specification here] off begin
		String randomStringforCaseSpecification = mock
				.strings()
				.get();
		newEntity.setCaseSpecification(randomStringforCaseSpecification);
		// % protected region % [Add customisation for Case Specification here] end
		// % protected region % [Add customisation for Accident Type here] off begin
		String randomStringforAccidentType = mock
				.strings()
				.get();
		newEntity.setAccidentType(randomStringforAccidentType);
		// % protected region % [Add customisation for Accident Type here] end
		// % protected region % [Add customisation for Accident Cause here] off begin
		String randomStringforAccidentCause = mock
				.strings()
				.get();
		newEntity.setAccidentCause(randomStringforAccidentCause);
		// % protected region % [Add customisation for Accident Cause here] end
		// % protected region % [Add customisation for Emergency Level here] off begin
		String randomStringforEmergencyLevel = mock
				.strings()
				.get();
		newEntity.setEmergencyLevel(randomStringforEmergencyLevel);
		// % protected region % [Add customisation for Emergency Level here] end
		// % protected region % [Add customisation for Date Time of Instructions here] off begin
		newEntity.setDateTimeOfInstructions(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Time of Instructions here] end
		// % protected region % [Add customisation for Is Doctor Taking Over here] off begin
		newEntity.setIsDoctorTakingOver(mock.bools().get());
		// % protected region % [Add customisation for Is Doctor Taking Over here] end
		// % protected region % [Add customisation for Date Time of Drug Administration here] off begin
		newEntity.setDateTimeOfDrugAdministration(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Time of Drug Administration here] end
		// % protected region % [Add customisation for Is Autopay here] off begin
		newEntity.setIsAutopay(mock.bools().get());
		// % protected region % [Add customisation for Is Autopay here] end
		// % protected region % [Add customisation for Response Time here] off begin
		newEntity.setResponseTime(mock.ints().get());
		// % protected region % [Add customisation for Response Time here] end

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordWithNoRef after the main body here] end

		log.trace("Created entity of type EmergencyMedicalExaminationRecordEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Emergency Medical Examination Record entities with no reference at all.
	 */
	@Provides
	@Named("emergencyMedicalExaminationRecordEntitiesWithNoRef")
	public Collection<EmergencyMedicalExaminationRecordEntity> emergencyMedicalExaminationRecordEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for emergencyMedicalExaminationRecordEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for emergencyMedicalExaminationRecordEntitiesWithNoRef here] end
		EmergencyMedicalExaminationRecordEntityFactory emergencyMedicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type EmergencyMedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntitiesWithNoRef before the main body here] end

		Collection<EmergencyMedicalExaminationRecordEntity> newEntities = emergencyMedicalExaminationRecordEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type EmergencyMedicalExaminationRecordEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Emergency Medical Examination Record entity with all references set.
	 */
	@Provides
	@Named("emergencyMedicalExaminationRecordEntityWithRefs")
	public EmergencyMedicalExaminationRecordEntity emergencyMedicalExaminationRecordEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for emergencyMedicalExaminationRecordEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for emergencyMedicalExaminationRecordEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type EmergencyMedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntityWithRefs before the main body here] end

		EmergencyMedicalExaminationRecordEntity emergencyMedicalExaminationRecordEntity = injector.getInstance(Key.get(EmergencyMedicalExaminationRecordEntity.class, Names.named("emergencyMedicalExaminationRecordEntityWithNoRef")));

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntityWithRefs after the main body here] end

		log.trace("Created entity of type EmergencyMedicalExaminationRecordEntity with references");

		return emergencyMedicalExaminationRecordEntity;
	}

	/**
	 * Return a collection of Emergency Medical Examination Record entities with all references set.
	 */
	@Provides
	@Named("emergencyMedicalExaminationRecordEntitiesWithRefs")
	public Collection<EmergencyMedicalExaminationRecordEntity> emergencyMedicalExaminationRecordEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for emergencyMedicalExaminationRecordEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for emergencyMedicalExaminationRecordEntitiesWithRefs here] end
		EmergencyMedicalExaminationRecordEntityFactory emergencyMedicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type EmergencyMedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntitiesWithRefs before the main body here] end

		Collection<EmergencyMedicalExaminationRecordEntity> newEntities = emergencyMedicalExaminationRecordEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type EmergencyMedicalExaminationRecordEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
