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
 * Guice module for Medical Certificate Physical Health used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalCertificatePhysicalHealthModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalCertificatePhysicalHealthModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalCertificatePhysicalHealthModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalCertificatePhysicalHealthEntityFactory medicalCertificatePhysicalHealthEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalCertificatePhysicalHealthEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalCertificatePhysicalHealthEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalCertificatePhysicalHealthEntityFactory");

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntityFactory before the main body here] end

		MedicalCertificatePhysicalHealthEntityFactory entityFactory = new MedicalCertificatePhysicalHealthEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalCertificatePhysicalHealthEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalCertificatePhysicalHealthEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntityFactory after the main body here] end

		log.trace("Created MedicalCertificatePhysicalHealthEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Certificate Physical Health entity with no references set.
	 */
	@Provides
	@Named("medicalCertificatePhysicalHealthEntityWithNoRef")
	public MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalCertificatePhysicalHealthEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificatePhysicalHealthEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalCertificatePhysicalHealthEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthWithNoRef before the main body here] end

		MedicalCertificatePhysicalHealthEntity newEntity = new MedicalCertificatePhysicalHealthEntity();
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

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalCertificatePhysicalHealthEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Certificate Physical Health entities with no reference at all.
	 */
	@Provides
	@Named("medicalCertificatePhysicalHealthEntitiesWithNoRef")
	public Collection<MedicalCertificatePhysicalHealthEntity> medicalCertificatePhysicalHealthEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalCertificatePhysicalHealthEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificatePhysicalHealthEntitiesWithNoRef here] end
		MedicalCertificatePhysicalHealthEntityFactory medicalCertificatePhysicalHealthEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificatePhysicalHealthEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntitiesWithNoRef before the main body here] end

		Collection<MedicalCertificatePhysicalHealthEntity> newEntities = medicalCertificatePhysicalHealthEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalCertificatePhysicalHealthEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Certificate Physical Health entity with all references set.
	 */
	@Provides
	@Named("medicalCertificatePhysicalHealthEntityWithRefs")
	public MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalCertificatePhysicalHealthEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificatePhysicalHealthEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalCertificatePhysicalHealthEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntityWithRefs before the main body here] end

		MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity = injector.getInstance(Key.get(MedicalCertificatePhysicalHealthEntity.class, Names.named("medicalCertificatePhysicalHealthEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalCertificatePhysicalHealthEntity with references");

		return medicalCertificatePhysicalHealthEntity;
	}

	/**
	 * Return a collection of Medical Certificate Physical Health entities with all references set.
	 */
	@Provides
	@Named("medicalCertificatePhysicalHealthEntitiesWithRefs")
	public Collection<MedicalCertificatePhysicalHealthEntity> medicalCertificatePhysicalHealthEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalCertificatePhysicalHealthEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificatePhysicalHealthEntitiesWithRefs here] end
		MedicalCertificatePhysicalHealthEntityFactory medicalCertificatePhysicalHealthEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificatePhysicalHealthEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntitiesWithRefs before the main body here] end

		Collection<MedicalCertificatePhysicalHealthEntity> newEntities = medicalCertificatePhysicalHealthEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificatePhysicalHealthEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalCertificatePhysicalHealthEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
