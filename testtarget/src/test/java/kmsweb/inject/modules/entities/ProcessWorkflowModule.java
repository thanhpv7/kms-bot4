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
 * Guice module for Process Workflow used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ProcessWorkflowModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ProcessWorkflowModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ProcessWorkflowModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ProcessWorkflowEntityFactory processWorkflowEntityFactory(
			// % protected region % [Apply any additional injected arguments for processWorkflowEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for processWorkflowEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ProcessWorkflowEntityFactory");

		// % protected region % [Apply any additional logic for processWorkflowEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowEntityFactory before the main body here] end

		ProcessWorkflowEntityFactory entityFactory = new ProcessWorkflowEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ProcessWorkflowEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ProcessWorkflowEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for processWorkflowEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowEntityFactory after the main body here] end

		log.trace("Created ProcessWorkflowEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Process Workflow entity with no references set.
	 */
	@Provides
	@Named("processWorkflowEntityWithNoRef")
	public ProcessWorkflowEntity processWorkflowEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for processWorkflowEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for processWorkflowEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ProcessWorkflowEntity with no reference");

		// % protected region % [Apply any additional logic for processWorkflowWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowWithNoRef before the main body here] end

		ProcessWorkflowEntity newEntity = new ProcessWorkflowEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Step Number here] off begin
		newEntity.setStepNumber(mock.ints().get());
		// % protected region % [Add customisation for Step Number here] end
		// % protected region % [Add customisation for Module Name here] off begin
		newEntity.setModuleName(ModuleNameEnum.REGISTRATION);
		// % protected region % [Add customisation for Module Name here] end
		// % protected region % [Add customisation for Process Name here] off begin
		String randomStringforProcessName = mock
				.strings()
				.get();
		newEntity.setProcessName(randomStringforProcessName);
		// % protected region % [Add customisation for Process Name here] end
		// % protected region % [Add customisation for Reference ID here] off begin
		String randomStringforReferenceID = mock
				.strings()
				.get();
		newEntity.setReferenceID(randomStringforReferenceID);
		// % protected region % [Add customisation for Reference ID here] end
		// % protected region % [Add customisation for Process Date Time here] off begin
		newEntity.setProcessDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Process Date Time here] end

		// % protected region % [Apply any additional logic for processWorkflowWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowWithNoRef after the main body here] end

		log.trace("Created entity of type ProcessWorkflowEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Process Workflow entities with no reference at all.
	 */
	@Provides
	@Named("processWorkflowEntitiesWithNoRef")
	public Collection<ProcessWorkflowEntity> processWorkflowEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for processWorkflowEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for processWorkflowEntitiesWithNoRef here] end
		ProcessWorkflowEntityFactory processWorkflowEntityFactory
	) {
		log.trace("Creating entities of type ProcessWorkflowEntity with no reference");

		// % protected region % [Apply any additional logic for processWorkflowEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowEntitiesWithNoRef before the main body here] end

		Collection<ProcessWorkflowEntity> newEntities = processWorkflowEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for processWorkflowEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ProcessWorkflowEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Process Workflow entity with all references set.
	 */
	@Provides
	@Named("processWorkflowEntityWithRefs")
	public ProcessWorkflowEntity processWorkflowEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for processWorkflowEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for processWorkflowEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ProcessWorkflowEntity with references");

		// % protected region % [Apply any additional logic for processWorkflowEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowEntityWithRefs before the main body here] end

		ProcessWorkflowEntity processWorkflowEntity = injector.getInstance(Key.get(ProcessWorkflowEntity.class, Names.named("processWorkflowEntityWithNoRef")));

		// % protected region % [Apply any additional logic for processWorkflowEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowEntityWithRefs after the main body here] end

		log.trace("Created entity of type ProcessWorkflowEntity with references");

		return processWorkflowEntity;
	}

	/**
	 * Return a collection of Process Workflow entities with all references set.
	 */
	@Provides
	@Named("processWorkflowEntitiesWithRefs")
	public Collection<ProcessWorkflowEntity> processWorkflowEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for processWorkflowEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for processWorkflowEntitiesWithRefs here] end
		ProcessWorkflowEntityFactory processWorkflowEntityFactory
	) {
		log.trace("Creating entities of type ProcessWorkflowEntity with references");

		// % protected region % [Apply any additional logic for processWorkflowEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowEntitiesWithRefs before the main body here] end

		Collection<ProcessWorkflowEntity> newEntities = processWorkflowEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for processWorkflowEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for processWorkflowEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ProcessWorkflowEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
