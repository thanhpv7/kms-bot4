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
 * Guice module for Medical Certificate Hospitalization used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalCertificateHospitalizationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalCertificateHospitalizationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalCertificateHospitalizationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalCertificateHospitalizationEntityFactory medicalCertificateHospitalizationEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalCertificateHospitalizationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalCertificateHospitalizationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalCertificateHospitalizationEntityFactory");

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntityFactory before the main body here] end

		MedicalCertificateHospitalizationEntityFactory entityFactory = new MedicalCertificateHospitalizationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateHospitalizationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateHospitalizationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntityFactory after the main body here] end

		log.trace("Created MedicalCertificateHospitalizationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Certificate Hospitalization entity with no references set.
	 */
	@Provides
	@Named("medicalCertificateHospitalizationEntityWithNoRef")
	public MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateHospitalizationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateHospitalizationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalCertificateHospitalizationEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationWithNoRef before the main body here] end

		MedicalCertificateHospitalizationEntity newEntity = new MedicalCertificateHospitalizationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date Time here] off begin
		newEntity.setAdmissionDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date Time here] end
		// % protected region % [Add customisation for Discharge Date Time here] off begin
		newEntity.setDischargeDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Discharge Date Time here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalCertificateHospitalizationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Certificate Hospitalization entities with no reference at all.
	 */
	@Provides
	@Named("medicalCertificateHospitalizationEntitiesWithNoRef")
	public Collection<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateHospitalizationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateHospitalizationEntitiesWithNoRef here] end
		MedicalCertificateHospitalizationEntityFactory medicalCertificateHospitalizationEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateHospitalizationEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntitiesWithNoRef before the main body here] end

		Collection<MedicalCertificateHospitalizationEntity> newEntities = medicalCertificateHospitalizationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalCertificateHospitalizationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Certificate Hospitalization entity with all references set.
	 */
	@Provides
	@Named("medicalCertificateHospitalizationEntityWithRefs")
	public MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateHospitalizationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateHospitalizationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalCertificateHospitalizationEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntityWithRefs before the main body here] end

		MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity = injector.getInstance(Key.get(MedicalCertificateHospitalizationEntity.class, Names.named("medicalCertificateHospitalizationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalCertificateHospitalizationEntity with references");

		return medicalCertificateHospitalizationEntity;
	}

	/**
	 * Return a collection of Medical Certificate Hospitalization entities with all references set.
	 */
	@Provides
	@Named("medicalCertificateHospitalizationEntitiesWithRefs")
	public Collection<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateHospitalizationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateHospitalizationEntitiesWithRefs here] end
		MedicalCertificateHospitalizationEntityFactory medicalCertificateHospitalizationEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateHospitalizationEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntitiesWithRefs before the main body here] end

		Collection<MedicalCertificateHospitalizationEntity> newEntities = medicalCertificateHospitalizationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateHospitalizationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalCertificateHospitalizationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
