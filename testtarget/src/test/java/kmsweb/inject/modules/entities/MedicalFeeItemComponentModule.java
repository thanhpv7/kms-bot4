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
 * Guice module for Medical Fee Item Component used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class MedicalFeeItemComponentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring MedicalFeeItemComponentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured MedicalFeeItemComponentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public MedicalFeeItemComponentEntityFactory medicalFeeItemComponentEntityFactory(
			// % protected region % [Apply any additional injected arguments for medicalFeeItemComponentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for medicalFeeItemComponentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating MedicalFeeItemComponentEntityFactory");

		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntityFactory before the main body here] end

		MedicalFeeItemComponentEntityFactory entityFactory = new MedicalFeeItemComponentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for MedicalFeeItemComponentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for MedicalFeeItemComponentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntityFactory after the main body here] end

		log.trace("Created MedicalFeeItemComponentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Medical Fee Item Component entity with no references set.
	 */
	@Provides
	@Named("medicalFeeItemComponentEntityWithNoRef")
	public MedicalFeeItemComponentEntity medicalFeeItemComponentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for medicalFeeItemComponentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalFeeItemComponentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type MedicalFeeItemComponentEntity with no reference");

		// % protected region % [Apply any additional logic for medicalFeeItemComponentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentWithNoRef before the main body here] end

		MedicalFeeItemComponentEntity newEntity = new MedicalFeeItemComponentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mock.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Medical Staff Code here] off begin
		String randomStringforMedicalStaffCode = mock
				.strings()
				.get();
		newEntity.setMedicalStaffCode(randomStringforMedicalStaffCode);
		// % protected region % [Add customisation for Medical Staff Code here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for medicalFeeItemComponentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentWithNoRef after the main body here] end

		log.trace("Created entity of type MedicalFeeItemComponentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Medical Fee Item Component entities with no reference at all.
	 */
	@Provides
	@Named("medicalFeeItemComponentEntitiesWithNoRef")
	public Collection<MedicalFeeItemComponentEntity> medicalFeeItemComponentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for medicalFeeItemComponentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalFeeItemComponentEntitiesWithNoRef here] end
		MedicalFeeItemComponentEntityFactory medicalFeeItemComponentEntityFactory
	) {
		log.trace("Creating entities of type MedicalFeeItemComponentEntity with no reference");

		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntitiesWithNoRef before the main body here] end

		Collection<MedicalFeeItemComponentEntity> newEntities = medicalFeeItemComponentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type MedicalFeeItemComponentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Medical Fee Item Component entity with all references set.
	 */
	@Provides
	@Named("medicalFeeItemComponentEntityWithRefs")
	public MedicalFeeItemComponentEntity medicalFeeItemComponentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for medicalFeeItemComponentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for medicalFeeItemComponentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type MedicalFeeItemComponentEntity with references");

		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntityWithRefs before the main body here] end

		MedicalFeeItemComponentEntity medicalFeeItemComponentEntity = injector.getInstance(Key.get(MedicalFeeItemComponentEntity.class, Names.named("medicalFeeItemComponentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntityWithRefs after the main body here] end

		log.trace("Created entity of type MedicalFeeItemComponentEntity with references");

		return medicalFeeItemComponentEntity;
	}

	/**
	 * Return a collection of Medical Fee Item Component entities with all references set.
	 */
	@Provides
	@Named("medicalFeeItemComponentEntitiesWithRefs")
	public Collection<MedicalFeeItemComponentEntity> medicalFeeItemComponentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for medicalFeeItemComponentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for medicalFeeItemComponentEntitiesWithRefs here] end
		MedicalFeeItemComponentEntityFactory medicalFeeItemComponentEntityFactory
	) {
		log.trace("Creating entities of type MedicalFeeItemComponentEntity with references");

		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntitiesWithRefs before the main body here] end

		Collection<MedicalFeeItemComponentEntity> newEntities = medicalFeeItemComponentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalFeeItemComponentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type MedicalFeeItemComponentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
