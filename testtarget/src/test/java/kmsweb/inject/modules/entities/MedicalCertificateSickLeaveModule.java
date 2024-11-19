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
 * Guice module for Medical Certificate Sick Leave used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalCertificateSickLeaveModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalCertificateSickLeaveModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalCertificateSickLeaveModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalCertificateSickLeaveEntityFactory medicalCertificateSickLeaveEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalCertificateSickLeaveEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalCertificateSickLeaveEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalCertificateSickLeaveEntityFactory");

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntityFactory before the main body here] end

		MedicalCertificateSickLeaveEntityFactory entityFactory = new MedicalCertificateSickLeaveEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateSickLeaveEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalCertificateSickLeaveEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntityFactory after the main body here] end

		log.trace("Created MedicalCertificateSickLeaveEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Certificate Sick Leave entity with no references set.
	 */
	@Provides
	@Named("medicalCertificateSickLeaveEntityWithNoRef")
	public MedicalCertificateSickLeaveEntity medicalCertificateSickLeaveEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateSickLeaveEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateSickLeaveEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalCertificateSickLeaveEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveWithNoRef before the main body here] end

		MedicalCertificateSickLeaveEntity newEntity = new MedicalCertificateSickLeaveEntity();
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

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalCertificateSickLeaveEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Certificate Sick Leave entities with no reference at all.
	 */
	@Provides
	@Named("medicalCertificateSickLeaveEntitiesWithNoRef")
	public Collection<MedicalCertificateSickLeaveEntity> medicalCertificateSickLeaveEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateSickLeaveEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateSickLeaveEntitiesWithNoRef here] end
		MedicalCertificateSickLeaveEntityFactory medicalCertificateSickLeaveEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateSickLeaveEntity with no reference");

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntitiesWithNoRef before the main body here] end

		Collection<MedicalCertificateSickLeaveEntity> newEntities = medicalCertificateSickLeaveEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalCertificateSickLeaveEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Certificate Sick Leave entity with all references set.
	 */
	@Provides
	@Named("medicalCertificateSickLeaveEntityWithRefs")
	public MedicalCertificateSickLeaveEntity medicalCertificateSickLeaveEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalCertificateSickLeaveEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalCertificateSickLeaveEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalCertificateSickLeaveEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntityWithRefs before the main body here] end

		MedicalCertificateSickLeaveEntity medicalCertificateSickLeaveEntity = injector.getInstance(Key.get(MedicalCertificateSickLeaveEntity.class, Names.named("medicalCertificateSickLeaveEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalCertificateSickLeaveEntity with references");

		return medicalCertificateSickLeaveEntity;
	}

	/**
	 * Return a collection of Medical Certificate Sick Leave entities with all references set.
	 */
	@Provides
	@Named("medicalCertificateSickLeaveEntitiesWithRefs")
	public Collection<MedicalCertificateSickLeaveEntity> medicalCertificateSickLeaveEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalCertificateSickLeaveEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalCertificateSickLeaveEntitiesWithRefs here] end
		MedicalCertificateSickLeaveEntityFactory medicalCertificateSickLeaveEntityFactory
	) {
		log.trace("Creating entities of type MedicalCertificateSickLeaveEntity with references");

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntitiesWithRefs before the main body here] end

		Collection<MedicalCertificateSickLeaveEntity> newEntities = medicalCertificateSickLeaveEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateSickLeaveEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalCertificateSickLeaveEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
