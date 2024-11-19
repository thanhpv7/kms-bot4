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
 * Guice module for Examination Group used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ExaminationGroupModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ExaminationGroupModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ExaminationGroupModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ExaminationGroupEntityFactory examinationGroupEntityFactory(
			// % protected region % [Apply any additional injected arguments for examinationGroupEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for examinationGroupEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ExaminationGroupEntityFactory");

		// % protected region % [Apply any additional logic for examinationGroupEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupEntityFactory before the main body here] end

		ExaminationGroupEntityFactory entityFactory = new ExaminationGroupEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ExaminationGroupEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ExaminationGroupEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for examinationGroupEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupEntityFactory after the main body here] end

		log.trace("Created ExaminationGroupEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Examination Group entity with no references set.
	 */
	@Provides
	@Named("examinationGroupEntityWithNoRef")
	public ExaminationGroupEntity examinationGroupEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for examinationGroupEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for examinationGroupEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ExaminationGroupEntity with no reference");

		// % protected region % [Apply any additional logic for examinationGroupWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupWithNoRef before the main body here] end

		ExaminationGroupEntity newEntity = new ExaminationGroupEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Diagnostic Group Code here] off begin
		String randomStringforDiagnosticGroupCode = mock
				.strings()
				.get();
		newEntity.setDiagnosticGroupCode(randomStringforDiagnosticGroupCode);
		// % protected region % [Add customisation for Diagnostic Group Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Sequence here] off begin
		newEntity.setSequence(mock.ints().get());
		// % protected region % [Add customisation for Sequence here] end

		// % protected region % [Apply any additional logic for examinationGroupWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupWithNoRef after the main body here] end

		log.trace("Created entity of type ExaminationGroupEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Examination Group entities with no reference at all.
	 */
	@Provides
	@Named("examinationGroupEntitiesWithNoRef")
	public Collection<ExaminationGroupEntity> examinationGroupEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for examinationGroupEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for examinationGroupEntitiesWithNoRef here] end
		ExaminationGroupEntityFactory examinationGroupEntityFactory
	) {
		log.trace("Creating entities of type ExaminationGroupEntity with no reference");

		// % protected region % [Apply any additional logic for examinationGroupEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupEntitiesWithNoRef before the main body here] end

		Collection<ExaminationGroupEntity> newEntities = examinationGroupEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for examinationGroupEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ExaminationGroupEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Examination Group entity with all references set.
	 */
	@Provides
	@Named("examinationGroupEntityWithRefs")
	public ExaminationGroupEntity examinationGroupEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for examinationGroupEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for examinationGroupEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ExaminationGroupEntity with references");

		// % protected region % [Apply any additional logic for examinationGroupEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupEntityWithRefs before the main body here] end

		ExaminationGroupEntity examinationGroupEntity = injector.getInstance(Key.get(ExaminationGroupEntity.class, Names.named("examinationGroupEntityWithNoRef")));

		// % protected region % [Apply any additional logic for examinationGroupEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupEntityWithRefs after the main body here] end

		log.trace("Created entity of type ExaminationGroupEntity with references");

		return examinationGroupEntity;
	}

	/**
	 * Return a collection of Examination Group entities with all references set.
	 */
	@Provides
	@Named("examinationGroupEntitiesWithRefs")
	public Collection<ExaminationGroupEntity> examinationGroupEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for examinationGroupEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for examinationGroupEntitiesWithRefs here] end
		ExaminationGroupEntityFactory examinationGroupEntityFactory
	) {
		log.trace("Creating entities of type ExaminationGroupEntity with references");

		// % protected region % [Apply any additional logic for examinationGroupEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupEntitiesWithRefs before the main body here] end

		Collection<ExaminationGroupEntity> newEntities = examinationGroupEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for examinationGroupEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationGroupEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ExaminationGroupEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
