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
 * Guice module for Diagnostic Staff Examination Summary used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DiagnosticStaffExaminationSummaryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DiagnosticStaffExaminationSummaryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DiagnosticStaffExaminationSummaryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DiagnosticStaffExaminationSummaryEntityFactory diagnosticStaffExaminationSummaryEntityFactory(
			// % protected region % [Apply any additional injected arguments for diagnosticStaffExaminationSummaryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for diagnosticStaffExaminationSummaryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DiagnosticStaffExaminationSummaryEntityFactory");

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntityFactory before the main body here] end

		DiagnosticStaffExaminationSummaryEntityFactory entityFactory = new DiagnosticStaffExaminationSummaryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DiagnosticStaffExaminationSummaryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DiagnosticStaffExaminationSummaryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntityFactory after the main body here] end

		log.trace("Created DiagnosticStaffExaminationSummaryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Diagnostic Staff Examination Summary entity with no references set.
	 */
	@Provides
	@Named("diagnosticStaffExaminationSummaryEntityWithNoRef")
	public DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummaryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for diagnosticStaffExaminationSummaryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosticStaffExaminationSummaryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DiagnosticStaffExaminationSummaryEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryWithNoRef before the main body here] end

		DiagnosticStaffExaminationSummaryEntity newEntity = new DiagnosticStaffExaminationSummaryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Responsible Doctor here] off begin
		String randomStringforResponsibleDoctor = mock
				.strings()
				.get();
		newEntity.setResponsibleDoctor(randomStringforResponsibleDoctor);
		// % protected region % [Add customisation for Responsible Doctor here] end
		// % protected region % [Add customisation for Medical Transcriber here] off begin
		String randomStringforMedicalTranscriber = mock
				.strings()
				.get();
		newEntity.setMedicalTranscriber(randomStringforMedicalTranscriber);
		// % protected region % [Add customisation for Medical Transcriber here] end
		// % protected region % [Add customisation for Referring Room here] off begin
		String randomStringforReferringRoom = mock
				.strings()
				.get();
		newEntity.setReferringRoom(randomStringforReferringRoom);
		// % protected region % [Add customisation for Referring Room here] end
		// % protected region % [Add customisation for Refering Unit here] off begin
		String randomStringforReferingUnit = mock
				.strings()
				.get();
		newEntity.setReferingUnit(randomStringforReferingUnit);
		// % protected region % [Add customisation for Refering Unit here] end
		// % protected region % [Add customisation for Examination Location here] off begin
		String randomStringforExaminationLocation = mock
				.strings()
				.get();
		newEntity.setExaminationLocation(randomStringforExaminationLocation);
		// % protected region % [Add customisation for Examination Location here] end
		// % protected region % [Add customisation for Additional Notes here] off begin
		String randomStringforAdditionalNotes = mock
				.strings()
				.get();
		newEntity.setAdditionalNotes(randomStringforAdditionalNotes);
		// % protected region % [Add customisation for Additional Notes here] end
		// % protected region % [Add customisation for Conclusion here] off begin
		String randomStringforConclusion = mock
				.strings()
				.get();
		newEntity.setConclusion(randomStringforConclusion);
		// % protected region % [Add customisation for Conclusion here] end

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryWithNoRef after the main body here] end

		log.trace("Created entity of type DiagnosticStaffExaminationSummaryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Diagnostic Staff Examination Summary entities with no reference at all.
	 */
	@Provides
	@Named("diagnosticStaffExaminationSummaryEntitiesWithNoRef")
	public Collection<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for diagnosticStaffExaminationSummaryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosticStaffExaminationSummaryEntitiesWithNoRef here] end
		DiagnosticStaffExaminationSummaryEntityFactory diagnosticStaffExaminationSummaryEntityFactory
	) {
		log.trace("Creating entities of type DiagnosticStaffExaminationSummaryEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntitiesWithNoRef before the main body here] end

		Collection<DiagnosticStaffExaminationSummaryEntity> newEntities = diagnosticStaffExaminationSummaryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DiagnosticStaffExaminationSummaryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Diagnostic Staff Examination Summary entity with all references set.
	 */
	@Provides
	@Named("diagnosticStaffExaminationSummaryEntityWithRefs")
	public DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummaryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for diagnosticStaffExaminationSummaryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosticStaffExaminationSummaryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DiagnosticStaffExaminationSummaryEntity with references");

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntityWithRefs before the main body here] end

		DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummaryEntity = injector.getInstance(Key.get(DiagnosticStaffExaminationSummaryEntity.class, Names.named("diagnosticStaffExaminationSummaryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntityWithRefs after the main body here] end

		log.trace("Created entity of type DiagnosticStaffExaminationSummaryEntity with references");

		return diagnosticStaffExaminationSummaryEntity;
	}

	/**
	 * Return a collection of Diagnostic Staff Examination Summary entities with all references set.
	 */
	@Provides
	@Named("diagnosticStaffExaminationSummaryEntitiesWithRefs")
	public Collection<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for diagnosticStaffExaminationSummaryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosticStaffExaminationSummaryEntitiesWithRefs here] end
		DiagnosticStaffExaminationSummaryEntityFactory diagnosticStaffExaminationSummaryEntityFactory
	) {
		log.trace("Creating entities of type DiagnosticStaffExaminationSummaryEntity with references");

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntitiesWithRefs before the main body here] end

		Collection<DiagnosticStaffExaminationSummaryEntity> newEntities = diagnosticStaffExaminationSummaryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DiagnosticStaffExaminationSummaryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
