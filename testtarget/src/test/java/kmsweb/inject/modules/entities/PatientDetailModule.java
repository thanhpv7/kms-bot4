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
 * Guice module for Patient Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientDetailEntityFactory patientDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientDetailEntityFactory");

		// % protected region % [Apply any additional logic for patientDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailEntityFactory before the main body here] end

		PatientDetailEntityFactory entityFactory = new PatientDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailEntityFactory after the main body here] end

		log.trace("Created PatientDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Detail entity with no references set.
	 */
	@Provides
	@Named("patientDetailEntityWithNoRef")
	public PatientDetailEntity patientDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientDetailEntity with no reference");

		// % protected region % [Apply any additional logic for patientDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailWithNoRef before the main body here] end

		PatientDetailEntity newEntity = new PatientDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Active Patient ID here] off begin
		String randomStringforActivePatientID = mock
				.strings()
				.get();
		newEntity.setActivePatientID(randomStringforActivePatientID);
		// % protected region % [Add customisation for Active Patient ID here] end
		// % protected region % [Add customisation for Patient Classification here] off begin
		String randomStringforPatientClassification = mock
				.strings()
				.get();
		newEntity.setPatientClassification(randomStringforPatientClassification);
		// % protected region % [Add customisation for Patient Classification here] end
		// % protected region % [Add customisation for Patient Type here] off begin
		String randomStringforPatientType = mock
				.strings()
				.get();
		newEntity.setPatientType(randomStringforPatientType);
		// % protected region % [Add customisation for Patient Type here] end
		// % protected region % [Add customisation for Marital Status here] off begin
		String randomStringforMaritalStatus = mock
				.strings()
				.get();
		newEntity.setMaritalStatus(randomStringforMaritalStatus);
		// % protected region % [Add customisation for Marital Status here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for patientDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailWithNoRef after the main body here] end

		log.trace("Created entity of type PatientDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Detail entities with no reference at all.
	 */
	@Provides
	@Named("patientDetailEntitiesWithNoRef")
	public Collection<PatientDetailEntity> patientDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientDetailEntitiesWithNoRef here] end
		PatientDetailEntityFactory patientDetailEntityFactory
	) {
		log.trace("Creating entities of type PatientDetailEntity with no reference");

		// % protected region % [Apply any additional logic for patientDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailEntitiesWithNoRef before the main body here] end

		Collection<PatientDetailEntity> newEntities = patientDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Detail entity with all references set.
	 */
	@Provides
	@Named("patientDetailEntityWithRefs")
	public PatientDetailEntity patientDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientDetailEntity with references");

		// % protected region % [Apply any additional logic for patientDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailEntityWithRefs before the main body here] end

		PatientDetailEntity patientDetailEntity = injector.getInstance(Key.get(PatientDetailEntity.class, Names.named("patientDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientDetailEntity with references");

		return patientDetailEntity;
	}

	/**
	 * Return a collection of Patient Detail entities with all references set.
	 */
	@Provides
	@Named("patientDetailEntitiesWithRefs")
	public Collection<PatientDetailEntity> patientDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientDetailEntitiesWithRefs here] end
		PatientDetailEntityFactory patientDetailEntityFactory
	) {
		log.trace("Creating entities of type PatientDetailEntity with references");

		// % protected region % [Apply any additional logic for patientDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailEntitiesWithRefs before the main body here] end

		Collection<PatientDetailEntity> newEntities = patientDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
