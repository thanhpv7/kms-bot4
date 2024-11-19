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
 * Guice module for Medical Certificate  Discharge Resume used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalCertificateDischargeResumeModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalCertificateDischargeResumeModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalCertificateDischargeResumeModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalCertificateDischargeResumeEntityFactory medicalCertificateDischargeResumeEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalCertificateDischargeResumeEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalCertificateDischargeResumeEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalCertificateDischargeResumeEntityFactory");

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntityFactory before the main body here] end

		MedicalCertificateDischargeResumeEntityFactory entityFactory = new MedicalCertificateDischargeResumeEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateDischargeResumeEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateDischargeResumeEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntityFactory after the main body here] end

		log.trace("Created MedicalCertificateDischargeResumeEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Certificate  Discharge Resume entity with no references set.
	 */
	@Provides
	@Named("medicalCertificateDischargeResumeEntityWithNoRef")
	public MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateDischargeResumeEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateDischargeResumeEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalCertificateDischargeResumeEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeWithNoRef before the main body here] end

		MedicalCertificateDischargeResumeEntity newEntity = new MedicalCertificateDischargeResumeEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date Time here] off begin
		newEntity.setAdmissionDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date Time here] end
		// % protected region % [Add customisation for Discharge Date Time here] off begin
		newEntity.setDischargeDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Discharge Date Time here] end
		// % protected region % [Add customisation for Condition here] off begin
		String randomStringforCondition = mock
				.strings()
				.get();
		newEntity.setCondition(randomStringforCondition);
		// % protected region % [Add customisation for Condition here] end
		// % protected region % [Add customisation for Main Diagnosis here] off begin
		String randomStringforMainDiagnosis = mock
				.strings()
				.get();
		newEntity.setMainDiagnosis(randomStringforMainDiagnosis);
		// % protected region % [Add customisation for Main Diagnosis here] end
		// % protected region % [Add customisation for Action here] off begin
		String randomStringforAction = mock
				.strings()
				.get();
		newEntity.setAction(randomStringforAction);
		// % protected region % [Add customisation for Action here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalCertificateDischargeResumeEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Certificate  Discharge Resume entities with no reference at all.
	 */
	@Provides
	@Named("medicalCertificateDischargeResumeEntitiesWithNoRef")
	public Collection<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumeEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateDischargeResumeEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateDischargeResumeEntitiesWithNoRef here] end
		MedicalCertificateDischargeResumeEntityFactory medicalCertificateDischargeResumeEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateDischargeResumeEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntitiesWithNoRef before the main body here] end

		Collection<MedicalCertificateDischargeResumeEntity> newEntities = medicalCertificateDischargeResumeEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalCertificateDischargeResumeEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Certificate  Discharge Resume entity with all references set.
	 */
	@Provides
	@Named("medicalCertificateDischargeResumeEntityWithRefs")
	public MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateDischargeResumeEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateDischargeResumeEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalCertificateDischargeResumeEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntityWithRefs before the main body here] end

		MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity = injector.getInstance(Key.get(MedicalCertificateDischargeResumeEntity.class, Names.named("medicalCertificateDischargeResumeEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalCertificateDischargeResumeEntity with references");

		return medicalCertificateDischargeResumeEntity;
	}

	/**
	 * Return a collection of Medical Certificate  Discharge Resume entities with all references set.
	 */
	@Provides
	@Named("medicalCertificateDischargeResumeEntitiesWithRefs")
	public Collection<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumeEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateDischargeResumeEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateDischargeResumeEntitiesWithRefs here] end
		MedicalCertificateDischargeResumeEntityFactory medicalCertificateDischargeResumeEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateDischargeResumeEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntitiesWithRefs before the main body here] end

		Collection<MedicalCertificateDischargeResumeEntity> newEntities = medicalCertificateDischargeResumeEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalCertificateDischargeResumeEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
