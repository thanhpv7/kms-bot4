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
 * Guice module for Diagnostic Examination Results used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DiagnosticExaminationResultsModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DiagnosticExaminationResultsModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DiagnosticExaminationResultsModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DiagnosticExaminationResultsEntityFactory diagnosticExaminationResultsEntityFactory(
			// % protected region % [Apply any additional injected arguments for diagnosticExaminationResultsEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for diagnosticExaminationResultsEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DiagnosticExaminationResultsEntityFactory");

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntityFactory before the main body here] end

		DiagnosticExaminationResultsEntityFactory entityFactory = new DiagnosticExaminationResultsEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DiagnosticExaminationResultsEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DiagnosticExaminationResultsEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntityFactory after the main body here] end

		log.trace("Created DiagnosticExaminationResultsEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Diagnostic Examination Results entity with no references set.
	 */
	@Provides
	@Named("diagnosticExaminationResultsEntityWithNoRef")
	public DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for diagnosticExaminationResultsEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosticExaminationResultsEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DiagnosticExaminationResultsEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsWithNoRef before the main body here] end

		DiagnosticExaminationResultsEntity newEntity = new DiagnosticExaminationResultsEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Result here] off begin
		String randomStringforResult = mock
				.strings()
				.size(1000)
				.get();
		newEntity.setResult(randomStringforResult);
		// % protected region % [Add customisation for Result here] end
		// % protected region % [Add customisation for Outside Range here] off begin
		newEntity.setOutsideRange(mock.bools().get());
		// % protected region % [Add customisation for Outside Range here] end
		// % protected region % [Add customisation for Low here] off begin
		newEntity.setLow(mock.doubles().get());
		// % protected region % [Add customisation for Low here] end
		// % protected region % [Add customisation for High here] off begin
		newEntity.setHigh(mock.doubles().get());
		// % protected region % [Add customisation for High here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringforUnit = mock
				.strings()
				.get();
		newEntity.setUnit(randomStringforUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Sample No here] off begin
		String randomStringforSampleNo = mock
				.strings()
				.get();
		newEntity.setSampleNo(randomStringforSampleNo);
		// % protected region % [Add customisation for Sample No here] end
		// % protected region % [Add customisation for Sample Type here] off begin
		String randomStringforSampleType = mock
				.strings()
				.get();
		newEntity.setSampleType(randomStringforSampleType);
		// % protected region % [Add customisation for Sample Type here] end
		// % protected region % [Add customisation for repeated here] off begin
		newEntity.setRepeated(mock.bools().get());
		// % protected region % [Add customisation for repeated here] end
		// % protected region % [Add customisation for status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for status here] end

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsWithNoRef after the main body here] end

		log.trace("Created entity of type DiagnosticExaminationResultsEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Diagnostic Examination Results entities with no reference at all.
	 */
	@Provides
	@Named("diagnosticExaminationResultsEntitiesWithNoRef")
	public Collection<DiagnosticExaminationResultsEntity> diagnosticExaminationResultsEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for diagnosticExaminationResultsEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosticExaminationResultsEntitiesWithNoRef here] end
		DiagnosticExaminationResultsEntityFactory diagnosticExaminationResultsEntityFactory
	) {
		log.trace("Creating entities of type DiagnosticExaminationResultsEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntitiesWithNoRef before the main body here] end

		Collection<DiagnosticExaminationResultsEntity> newEntities = diagnosticExaminationResultsEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DiagnosticExaminationResultsEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Diagnostic Examination Results entity with all references set.
	 */
	@Provides
	@Named("diagnosticExaminationResultsEntityWithRefs")
	public DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for diagnosticExaminationResultsEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosticExaminationResultsEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DiagnosticExaminationResultsEntity with references");

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntityWithRefs before the main body here] end

		DiagnosticExaminationResultsEntity diagnosticExaminationResultsEntity = injector.getInstance(Key.get(DiagnosticExaminationResultsEntity.class, Names.named("diagnosticExaminationResultsEntityWithNoRef")));

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntityWithRefs after the main body here] end

		log.trace("Created entity of type DiagnosticExaminationResultsEntity with references");

		return diagnosticExaminationResultsEntity;
	}

	/**
	 * Return a collection of Diagnostic Examination Results entities with all references set.
	 */
	@Provides
	@Named("diagnosticExaminationResultsEntitiesWithRefs")
	public Collection<DiagnosticExaminationResultsEntity> diagnosticExaminationResultsEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for diagnosticExaminationResultsEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosticExaminationResultsEntitiesWithRefs here] end
		DiagnosticExaminationResultsEntityFactory diagnosticExaminationResultsEntityFactory
	) {
		log.trace("Creating entities of type DiagnosticExaminationResultsEntity with references");

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntitiesWithRefs before the main body here] end

		Collection<DiagnosticExaminationResultsEntity> newEntities = diagnosticExaminationResultsEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DiagnosticExaminationResultsEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
