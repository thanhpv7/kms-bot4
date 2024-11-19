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
 * Guice module for Patient Supporting Document used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PatientSupportingDocumentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PatientSupportingDocumentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PatientSupportingDocumentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PatientSupportingDocumentEntityFactory patientSupportingDocumentEntityFactory(
			// % protected region % [Apply any additional injected arguments for patientSupportingDocumentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for patientSupportingDocumentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PatientSupportingDocumentEntityFactory");

		// % protected region % [Apply any additional logic for patientSupportingDocumentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentEntityFactory before the main body here] end

		PatientSupportingDocumentEntityFactory entityFactory = new PatientSupportingDocumentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PatientSupportingDocumentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PatientSupportingDocumentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for patientSupportingDocumentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentEntityFactory after the main body here] end

		log.trace("Created PatientSupportingDocumentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Patient Supporting Document entity with no references set.
	 */
	@Provides
	@Named("patientSupportingDocumentEntityWithNoRef")
	public PatientSupportingDocumentEntity patientSupportingDocumentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for patientSupportingDocumentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for patientSupportingDocumentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PatientSupportingDocumentEntity with no reference");

		// % protected region % [Apply any additional logic for patientSupportingDocumentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentWithNoRef before the main body here] end

		PatientSupportingDocumentEntity newEntity = new PatientSupportingDocumentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Supporting Document here] off begin
		// % protected region % [Add customisation for Supporting Document here] end
		// % protected region % [Add customisation for File Name here] off begin
		String randomStringforFileName = mock
				.strings()
				.get();
		newEntity.setFileName(randomStringforFileName);
		// % protected region % [Add customisation for File Name here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end

		// % protected region % [Apply any additional logic for patientSupportingDocumentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentWithNoRef after the main body here] end

		log.trace("Created entity of type PatientSupportingDocumentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Patient Supporting Document entities with no reference at all.
	 */
	@Provides
	@Named("patientSupportingDocumentEntitiesWithNoRef")
	public Collection<PatientSupportingDocumentEntity> patientSupportingDocumentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for patientSupportingDocumentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for patientSupportingDocumentEntitiesWithNoRef here] end
		PatientSupportingDocumentEntityFactory patientSupportingDocumentEntityFactory
	) {
		log.trace("Creating entities of type PatientSupportingDocumentEntity with no reference");

		// % protected region % [Apply any additional logic for patientSupportingDocumentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentEntitiesWithNoRef before the main body here] end

		Collection<PatientSupportingDocumentEntity> newEntities = patientSupportingDocumentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for patientSupportingDocumentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PatientSupportingDocumentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Patient Supporting Document entity with all references set.
	 */
	@Provides
	@Named("patientSupportingDocumentEntityWithRefs")
	public PatientSupportingDocumentEntity patientSupportingDocumentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for patientSupportingDocumentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for patientSupportingDocumentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PatientSupportingDocumentEntity with references");

		// % protected region % [Apply any additional logic for patientSupportingDocumentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentEntityWithRefs before the main body here] end

		PatientSupportingDocumentEntity patientSupportingDocumentEntity = injector.getInstance(Key.get(PatientSupportingDocumentEntity.class, Names.named("patientSupportingDocumentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for patientSupportingDocumentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentEntityWithRefs after the main body here] end

		log.trace("Created entity of type PatientSupportingDocumentEntity with references");

		return patientSupportingDocumentEntity;
	}

	/**
	 * Return a collection of Patient Supporting Document entities with all references set.
	 */
	@Provides
	@Named("patientSupportingDocumentEntitiesWithRefs")
	public Collection<PatientSupportingDocumentEntity> patientSupportingDocumentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for patientSupportingDocumentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for patientSupportingDocumentEntitiesWithRefs here] end
		PatientSupportingDocumentEntityFactory patientSupportingDocumentEntityFactory
	) {
		log.trace("Creating entities of type PatientSupportingDocumentEntity with references");

		// % protected region % [Apply any additional logic for patientSupportingDocumentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentEntitiesWithRefs before the main body here] end

		Collection<PatientSupportingDocumentEntity> newEntities = patientSupportingDocumentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for patientSupportingDocumentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for patientSupportingDocumentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PatientSupportingDocumentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
