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
 * Guice module for Medical Certificate Medical Attendance used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalCertificateMedicalAttendanceModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalCertificateMedicalAttendanceModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalCertificateMedicalAttendanceModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalCertificateMedicalAttendanceEntityFactory medicalCertificateMedicalAttendanceEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalCertificateMedicalAttendanceEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalCertificateMedicalAttendanceEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalCertificateMedicalAttendanceEntityFactory");

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntityFactory before the main body here] end

		MedicalCertificateMedicalAttendanceEntityFactory entityFactory = new MedicalCertificateMedicalAttendanceEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateMedicalAttendanceEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateMedicalAttendanceEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntityFactory after the main body here] end

		log.trace("Created MedicalCertificateMedicalAttendanceEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Certificate Medical Attendance entity with no references set.
	 */
	@Provides
	@Named("medicalCertificateMedicalAttendanceEntityWithNoRef")
	public MedicalCertificateMedicalAttendanceEntity medicalCertificateMedicalAttendanceEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateMedicalAttendanceEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateMedicalAttendanceEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalCertificateMedicalAttendanceEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceWithNoRef before the main body here] end

		MedicalCertificateMedicalAttendanceEntity newEntity = new MedicalCertificateMedicalAttendanceEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Date here] off begin
		newEntity.setDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Date here] end
		// % protected region % [Add customisation for Start Time here] off begin
		newEntity.setStartTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Time here] end
		// % protected region % [Add customisation for End Time here] off begin
		newEntity.setEndTime(OffsetDateTime.now());
		// % protected region % [Add customisation for End Time here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalCertificateMedicalAttendanceEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Certificate Medical Attendance entities with no reference at all.
	 */
	@Provides
	@Named("medicalCertificateMedicalAttendanceEntitiesWithNoRef")
	public Collection<MedicalCertificateMedicalAttendanceEntity> medicalCertificateMedicalAttendanceEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateMedicalAttendanceEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateMedicalAttendanceEntitiesWithNoRef here] end
		MedicalCertificateMedicalAttendanceEntityFactory medicalCertificateMedicalAttendanceEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateMedicalAttendanceEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntitiesWithNoRef before the main body here] end

		Collection<MedicalCertificateMedicalAttendanceEntity> newEntities = medicalCertificateMedicalAttendanceEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalCertificateMedicalAttendanceEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Certificate Medical Attendance entity with all references set.
	 */
	@Provides
	@Named("medicalCertificateMedicalAttendanceEntityWithRefs")
	public MedicalCertificateMedicalAttendanceEntity medicalCertificateMedicalAttendanceEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateMedicalAttendanceEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateMedicalAttendanceEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalCertificateMedicalAttendanceEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntityWithRefs before the main body here] end

		MedicalCertificateMedicalAttendanceEntity medicalCertificateMedicalAttendanceEntity = injector.getInstance(Key.get(MedicalCertificateMedicalAttendanceEntity.class, Names.named("medicalCertificateMedicalAttendanceEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalCertificateMedicalAttendanceEntity with references");

		return medicalCertificateMedicalAttendanceEntity;
	}

	/**
	 * Return a collection of Medical Certificate Medical Attendance entities with all references set.
	 */
	@Provides
	@Named("medicalCertificateMedicalAttendanceEntitiesWithRefs")
	public Collection<MedicalCertificateMedicalAttendanceEntity> medicalCertificateMedicalAttendanceEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateMedicalAttendanceEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateMedicalAttendanceEntitiesWithRefs here] end
		MedicalCertificateMedicalAttendanceEntityFactory medicalCertificateMedicalAttendanceEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateMedicalAttendanceEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntitiesWithRefs before the main body here] end

		Collection<MedicalCertificateMedicalAttendanceEntity> newEntities = medicalCertificateMedicalAttendanceEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMedicalAttendanceEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalCertificateMedicalAttendanceEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
