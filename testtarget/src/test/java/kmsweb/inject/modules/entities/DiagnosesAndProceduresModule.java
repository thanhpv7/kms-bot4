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
 * Guice module for Diagnoses and Procedures used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DiagnosesAndProceduresModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DiagnosesAndProceduresModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DiagnosesAndProceduresModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DiagnosesAndProceduresEntityFactory diagnosesAndProceduresEntityFactory(
			// % protected region % [Apply any additional injected arguments for diagnosesAndProceduresEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for diagnosesAndProceduresEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DiagnosesAndProceduresEntityFactory");

		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntityFactory before the main body here] end

		DiagnosesAndProceduresEntityFactory entityFactory = new DiagnosesAndProceduresEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DiagnosesAndProceduresEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DiagnosesAndProceduresEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntityFactory after the main body here] end

		log.trace("Created DiagnosesAndProceduresEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Diagnoses and Procedures entity with no references set.
	 */
	@Provides
	@Named("diagnosesAndProceduresEntityWithNoRef")
	public DiagnosesAndProceduresEntity diagnosesAndProceduresEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for diagnosesAndProceduresEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosesAndProceduresEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DiagnosesAndProceduresEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosesAndProceduresWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresWithNoRef before the main body here] end

		DiagnosesAndProceduresEntity newEntity = new DiagnosesAndProceduresEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Item Type here] off begin
		String randomStringforItemType = mock
				.strings()
				.get();
		newEntity.setItemType(randomStringforItemType);
		// % protected region % [Add customisation for Item Type here] end
		// % protected region % [Add customisation for Item Code here] off begin
		String randomStringforItemCode = mock
				.strings()
				.get();
		newEntity.setItemCode(randomStringforItemCode);
		// % protected region % [Add customisation for Item Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for diagnosesAndProceduresWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresWithNoRef after the main body here] end

		log.trace("Created entity of type DiagnosesAndProceduresEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Diagnoses and Procedures entities with no reference at all.
	 */
	@Provides
	@Named("diagnosesAndProceduresEntitiesWithNoRef")
	public Collection<DiagnosesAndProceduresEntity> diagnosesAndProceduresEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for diagnosesAndProceduresEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosesAndProceduresEntitiesWithNoRef here] end
		DiagnosesAndProceduresEntityFactory diagnosesAndProceduresEntityFactory
	) {
		log.trace("Creating entities of type DiagnosesAndProceduresEntity with no reference");

		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntitiesWithNoRef before the main body here] end

		Collection<DiagnosesAndProceduresEntity> newEntities = diagnosesAndProceduresEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DiagnosesAndProceduresEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Diagnoses and Procedures entity with all references set.
	 */
	@Provides
	@Named("diagnosesAndProceduresEntityWithRefs")
	public DiagnosesAndProceduresEntity diagnosesAndProceduresEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for diagnosesAndProceduresEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for diagnosesAndProceduresEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DiagnosesAndProceduresEntity with references");

		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntityWithRefs before the main body here] end

		DiagnosesAndProceduresEntity diagnosesAndProceduresEntity = injector.getInstance(Key.get(DiagnosesAndProceduresEntity.class, Names.named("diagnosesAndProceduresEntityWithNoRef")));

		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntityWithRefs after the main body here] end

		log.trace("Created entity of type DiagnosesAndProceduresEntity with references");

		return diagnosesAndProceduresEntity;
	}

	/**
	 * Return a collection of Diagnoses and Procedures entities with all references set.
	 */
	@Provides
	@Named("diagnosesAndProceduresEntitiesWithRefs")
	public Collection<DiagnosesAndProceduresEntity> diagnosesAndProceduresEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for diagnosesAndProceduresEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for diagnosesAndProceduresEntitiesWithRefs here] end
		DiagnosesAndProceduresEntityFactory diagnosesAndProceduresEntityFactory
	) {
		log.trace("Creating entities of type DiagnosesAndProceduresEntity with references");

		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntitiesWithRefs before the main body here] end

		Collection<DiagnosesAndProceduresEntity> newEntities = diagnosesAndProceduresEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosesAndProceduresEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DiagnosesAndProceduresEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
