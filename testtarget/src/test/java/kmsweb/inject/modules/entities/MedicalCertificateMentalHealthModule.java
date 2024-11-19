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
 * Guice module for Medical Certificate Mental Health used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalCertificateMentalHealthModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalCertificateMentalHealthModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalCertificateMentalHealthModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalCertificateMentalHealthEntityFactory medicalCertificateMentalHealthEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalCertificateMentalHealthEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalCertificateMentalHealthEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalCertificateMentalHealthEntityFactory");

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntityFactory before the main body here] end

		MedicalCertificateMentalHealthEntityFactory entityFactory = new MedicalCertificateMentalHealthEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateMentalHealthEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateMentalHealthEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntityFactory after the main body here] end

		log.trace("Created MedicalCertificateMentalHealthEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Certificate Mental Health entity with no references set.
	 */
	@Provides
	@Named("medicalCertificateMentalHealthEntityWithNoRef")
	public MedicalCertificateMentalHealthEntity medicalCertificateMentalHealthEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateMentalHealthEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateMentalHealthEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalCertificateMentalHealthEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthWithNoRef before the main body here] end

		MedicalCertificateMentalHealthEntity newEntity = new MedicalCertificateMentalHealthEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Examination Date Time here] off begin
		newEntity.setExaminationDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Examination Date Time here] end
		// % protected region % [Add customisation for Examination Result here] off begin
		newEntity.setExaminationResult(mock.bools().get());
		// % protected region % [Add customisation for Examination Result here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Purpose here] off begin
		String randomStringforPurpose = mock
				.strings()
				.get();
		newEntity.setPurpose(randomStringforPurpose);
		// % protected region % [Add customisation for Purpose here] end

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalCertificateMentalHealthEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Certificate Mental Health entities with no reference at all.
	 */
	@Provides
	@Named("medicalCertificateMentalHealthEntitiesWithNoRef")
	public Collection<MedicalCertificateMentalHealthEntity> medicalCertificateMentalHealthEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateMentalHealthEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateMentalHealthEntitiesWithNoRef here] end
		MedicalCertificateMentalHealthEntityFactory medicalCertificateMentalHealthEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateMentalHealthEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntitiesWithNoRef before the main body here] end

		Collection<MedicalCertificateMentalHealthEntity> newEntities = medicalCertificateMentalHealthEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalCertificateMentalHealthEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Certificate Mental Health entity with all references set.
	 */
	@Provides
	@Named("medicalCertificateMentalHealthEntityWithRefs")
	public MedicalCertificateMentalHealthEntity medicalCertificateMentalHealthEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateMentalHealthEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateMentalHealthEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalCertificateMentalHealthEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntityWithRefs before the main body here] end

		MedicalCertificateMentalHealthEntity medicalCertificateMentalHealthEntity = injector.getInstance(Key.get(MedicalCertificateMentalHealthEntity.class, Names.named("medicalCertificateMentalHealthEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalCertificateMentalHealthEntity with references");

		return medicalCertificateMentalHealthEntity;
	}

	/**
	 * Return a collection of Medical Certificate Mental Health entities with all references set.
	 */
	@Provides
	@Named("medicalCertificateMentalHealthEntitiesWithRefs")
	public Collection<MedicalCertificateMentalHealthEntity> medicalCertificateMentalHealthEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateMentalHealthEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateMentalHealthEntitiesWithRefs here] end
		MedicalCertificateMentalHealthEntityFactory medicalCertificateMentalHealthEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateMentalHealthEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntitiesWithRefs before the main body here] end

		Collection<MedicalCertificateMentalHealthEntity> newEntities = medicalCertificateMentalHealthEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateMentalHealthEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalCertificateMentalHealthEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
