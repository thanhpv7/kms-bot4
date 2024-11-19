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
 * Guice module for Diagnosis Examination Record used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DiagnosisExaminationRecordModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DiagnosisExaminationRecordModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DiagnosisExaminationRecordModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DiagnosisExaminationRecordEntityFactory diagnosisExaminationRecordEntityFactory(
			// % protected region % [Apply any additional injected arguments for diagnosisExaminationRecordEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for diagnosisExaminationRecordEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DiagnosisExaminationRecordEntityFactory");

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntityFactory before the main body here] end

		DiagnosisExaminationRecordEntityFactory entityFactory = new DiagnosisExaminationRecordEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DiagnosisExaminationRecordEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DiagnosisExaminationRecordEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntityFactory after the main body here] end

		log.trace("Created DiagnosisExaminationRecordEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Diagnosis Examination Record entity with no references set.
	 */
	@Provides
	@Named("diagnosisExaminationRecordEntityWithNoRef")
	public DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for diagnosisExaminationRecordEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosisExaminationRecordEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DiagnosisExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordWithNoRef before the main body here] end

		DiagnosisExaminationRecordEntity newEntity = new DiagnosisExaminationRecordEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Diagnosis Sequence here] off begin
		newEntity.setDiagnosisSequence(mock.ints().get());
		// % protected region % [Add customisation for Diagnosis Sequence here] end
		// % protected region % [Add customisation for Diagnosis Notes here] off begin
		String randomStringforDiagnosisNotes = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setDiagnosisNotes(randomStringforDiagnosisNotes);
		// % protected region % [Add customisation for Diagnosis Notes here] end
		// % protected region % [Add customisation for Action Notes here] off begin
		String randomStringforActionNotes = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setActionNotes(randomStringforActionNotes);
		// % protected region % [Add customisation for Action Notes here] end
		// % protected region % [Add customisation for New Case here] off begin
		newEntity.setNewCase(mock.bools().get());
		// % protected region % [Add customisation for New Case here] end
		// % protected region % [Add customisation for Printing Number here] off begin
		newEntity.setPrintingNumber(mock.ints().get());
		// % protected region % [Add customisation for Printing Number here] end

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordWithNoRef after the main body here] end

		log.trace("Created entity of type DiagnosisExaminationRecordEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Diagnosis Examination Record entities with no reference at all.
	 */
	@Provides
	@Named("diagnosisExaminationRecordEntitiesWithNoRef")
	public Collection<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for diagnosisExaminationRecordEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosisExaminationRecordEntitiesWithNoRef here] end
		DiagnosisExaminationRecordEntityFactory diagnosisExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type DiagnosisExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntitiesWithNoRef before the main body here] end

		Collection<DiagnosisExaminationRecordEntity> newEntities = diagnosisExaminationRecordEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DiagnosisExaminationRecordEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Diagnosis Examination Record entity with all references set.
	 */
	@Provides
	@Named("diagnosisExaminationRecordEntityWithRefs")
	public DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for diagnosisExaminationRecordEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosisExaminationRecordEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DiagnosisExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntityWithRefs before the main body here] end

		DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity = injector.getInstance(Key.get(DiagnosisExaminationRecordEntity.class, Names.named("diagnosisExaminationRecordEntityWithNoRef")));

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntityWithRefs after the main body here] end

		log.trace("Created entity of type DiagnosisExaminationRecordEntity with references");

		return diagnosisExaminationRecordEntity;
	}

	/**
	 * Return a collection of Diagnosis Examination Record entities with all references set.
	 */
	@Provides
	@Named("diagnosisExaminationRecordEntitiesWithRefs")
	public Collection<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for diagnosisExaminationRecordEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosisExaminationRecordEntitiesWithRefs here] end
		DiagnosisExaminationRecordEntityFactory diagnosisExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type DiagnosisExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntitiesWithRefs before the main body here] end

		Collection<DiagnosisExaminationRecordEntity> newEntities = diagnosisExaminationRecordEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DiagnosisExaminationRecordEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
