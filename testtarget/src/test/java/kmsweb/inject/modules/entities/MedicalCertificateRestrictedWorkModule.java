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
 * Guice module for Medical Certificate Restricted Work used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalCertificateRestrictedWorkModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalCertificateRestrictedWorkModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalCertificateRestrictedWorkModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalCertificateRestrictedWorkEntityFactory medicalCertificateRestrictedWorkEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalCertificateRestrictedWorkEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalCertificateRestrictedWorkEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalCertificateRestrictedWorkEntityFactory");

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntityFactory before the main body here] end

		MedicalCertificateRestrictedWorkEntityFactory entityFactory = new MedicalCertificateRestrictedWorkEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateRestrictedWorkEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateRestrictedWorkEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntityFactory after the main body here] end

		log.trace("Created MedicalCertificateRestrictedWorkEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Certificate Restricted Work entity with no references set.
	 */
	@Provides
	@Named("medicalCertificateRestrictedWorkEntityWithNoRef")
	public MedicalCertificateRestrictedWorkEntity medicalCertificateRestrictedWorkEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateRestrictedWorkEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateRestrictedWorkEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalCertificateRestrictedWorkEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkWithNoRef before the main body here] end

		MedicalCertificateRestrictedWorkEntity newEntity = new MedicalCertificateRestrictedWorkEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Period here] off begin
		newEntity.setPeriod(mock.ints().get());
		// % protected region % [Add customisation for Period here] end
		// % protected region % [Add customisation for Start Date here] off begin
		newEntity.setStartDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date here] end
		// % protected region % [Add customisation for End Date here] off begin
		newEntity.setEndDate(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalCertificateRestrictedWorkEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Certificate Restricted Work entities with no reference at all.
	 */
	@Provides
	@Named("medicalCertificateRestrictedWorkEntitiesWithNoRef")
	public Collection<MedicalCertificateRestrictedWorkEntity> medicalCertificateRestrictedWorkEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateRestrictedWorkEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateRestrictedWorkEntitiesWithNoRef here] end
		MedicalCertificateRestrictedWorkEntityFactory medicalCertificateRestrictedWorkEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateRestrictedWorkEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntitiesWithNoRef before the main body here] end

		Collection<MedicalCertificateRestrictedWorkEntity> newEntities = medicalCertificateRestrictedWorkEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalCertificateRestrictedWorkEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Certificate Restricted Work entity with all references set.
	 */
	@Provides
	@Named("medicalCertificateRestrictedWorkEntityWithRefs")
	public MedicalCertificateRestrictedWorkEntity medicalCertificateRestrictedWorkEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateRestrictedWorkEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateRestrictedWorkEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalCertificateRestrictedWorkEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntityWithRefs before the main body here] end

		MedicalCertificateRestrictedWorkEntity medicalCertificateRestrictedWorkEntity = injector.getInstance(Key.get(MedicalCertificateRestrictedWorkEntity.class, Names.named("medicalCertificateRestrictedWorkEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalCertificateRestrictedWorkEntity with references");

		return medicalCertificateRestrictedWorkEntity;
	}

	/**
	 * Return a collection of Medical Certificate Restricted Work entities with all references set.
	 */
	@Provides
	@Named("medicalCertificateRestrictedWorkEntitiesWithRefs")
	public Collection<MedicalCertificateRestrictedWorkEntity> medicalCertificateRestrictedWorkEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateRestrictedWorkEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateRestrictedWorkEntitiesWithRefs here] end
		MedicalCertificateRestrictedWorkEntityFactory medicalCertificateRestrictedWorkEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateRestrictedWorkEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntitiesWithRefs before the main body here] end

		Collection<MedicalCertificateRestrictedWorkEntity> newEntities = medicalCertificateRestrictedWorkEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateRestrictedWorkEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalCertificateRestrictedWorkEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
