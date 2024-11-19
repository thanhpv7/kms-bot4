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
 * Guice module for Medical Certificate Birth used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalCertificateBirthModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalCertificateBirthModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalCertificateBirthModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalCertificateBirthEntityFactory medicalCertificateBirthEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalCertificateBirthEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalCertificateBirthEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalCertificateBirthEntityFactory");

		// % protected region % [Apply any additional logic for medicalCertificateBirthEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthEntityFactory before the main body here] end

		MedicalCertificateBirthEntityFactory entityFactory = new MedicalCertificateBirthEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateBirthEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateBirthEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalCertificateBirthEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthEntityFactory after the main body here] end

		log.trace("Created MedicalCertificateBirthEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Certificate Birth entity with no references set.
	 */
	@Provides
	@Named("medicalCertificateBirthEntityWithNoRef")
	public MedicalCertificateBirthEntity medicalCertificateBirthEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateBirthEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateBirthEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalCertificateBirthEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateBirthWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthWithNoRef before the main body here] end

		MedicalCertificateBirthEntity newEntity = new MedicalCertificateBirthEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Patient Name here] off begin
		String randomStringforPatientName = mock
				.strings()
				.get();
		newEntity.setPatientName(randomStringforPatientName);
		// % protected region % [Add customisation for Patient Name here] end
		// % protected region % [Add customisation for Spouse Name here] off begin
		String randomStringforSpouseName = mock
				.strings()
				.get();
		newEntity.setSpouseName(randomStringforSpouseName);
		// % protected region % [Add customisation for Spouse Name here] end
		// % protected region % [Add customisation for Number Of Children here] off begin
		newEntity.setNumberOfChildren(mock.ints().get());
		// % protected region % [Add customisation for Number Of Children here] end
		// % protected region % [Add customisation for Birth Notes here] off begin
		String randomStringforBirthNotes = mock
				.strings()
				.get();
		newEntity.setBirthNotes(randomStringforBirthNotes);
		// % protected region % [Add customisation for Birth Notes here] end

		// % protected region % [Apply any additional logic for medicalCertificateBirthWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalCertificateBirthEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Certificate Birth entities with no reference at all.
	 */
	@Provides
	@Named("medicalCertificateBirthEntitiesWithNoRef")
	public Collection<MedicalCertificateBirthEntity> medicalCertificateBirthEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateBirthEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateBirthEntitiesWithNoRef here] end
		MedicalCertificateBirthEntityFactory medicalCertificateBirthEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateBirthEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateBirthEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthEntitiesWithNoRef before the main body here] end

		Collection<MedicalCertificateBirthEntity> newEntities = medicalCertificateBirthEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalCertificateBirthEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalCertificateBirthEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Certificate Birth entity with all references set.
	 */
	@Provides
	@Named("medicalCertificateBirthEntityWithRefs")
	public MedicalCertificateBirthEntity medicalCertificateBirthEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateBirthEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateBirthEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalCertificateBirthEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateBirthEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthEntityWithRefs before the main body here] end

		MedicalCertificateBirthEntity medicalCertificateBirthEntity = injector.getInstance(Key.get(MedicalCertificateBirthEntity.class, Names.named("medicalCertificateBirthEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalCertificateBirthEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalCertificateBirthEntity with references");

		return medicalCertificateBirthEntity;
	}

	/**
	 * Return a collection of Medical Certificate Birth entities with all references set.
	 */
	@Provides
	@Named("medicalCertificateBirthEntitiesWithRefs")
	public Collection<MedicalCertificateBirthEntity> medicalCertificateBirthEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateBirthEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateBirthEntitiesWithRefs here] end
		MedicalCertificateBirthEntityFactory medicalCertificateBirthEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateBirthEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateBirthEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthEntitiesWithRefs before the main body here] end

		Collection<MedicalCertificateBirthEntity> newEntities = medicalCertificateBirthEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalCertificateBirthEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateBirthEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalCertificateBirthEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
