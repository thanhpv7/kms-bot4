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
 * Guice module for ICD 10 used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class Icd10Module extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring Icd10Module");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured Icd10Module");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public Icd10EntityFactory icd10EntityFactory(
			// % protected region % [Apply any additional injected arguments for icd10EntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for icd10EntityFactory here] end
			Injector injector
	) {
		log.trace("Creating Icd10EntityFactory");

		// % protected region % [Apply any additional logic for icd10EntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for icd10EntityFactory before the main body here] end

		Icd10EntityFactory entityFactory = new Icd10EntityFactory(
				// % protected region % [Apply any additional constructor arguments for Icd10EntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for Icd10EntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for icd10EntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for icd10EntityFactory after the main body here] end

		log.trace("Created Icd10EntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty ICD 10 entity with no references set.
	 */
	@Provides
	@Named("icd10EntityWithNoRef")
	public Icd10Entity icd10EntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for icd10EntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for icd10EntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type Icd10Entity with no reference");

		// % protected region % [Apply any additional logic for icd10WithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for icd10WithNoRef before the main body here] end

		Icd10Entity newEntity = new Icd10Entity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Classification Disease here] off begin
		newEntity.setClassificationDisease(mock.bools().get());
		// % protected region % [Add customisation for Classification Disease here] end
		// % protected region % [Add customisation for Classification Infectious here] off begin
		newEntity.setClassificationInfectious(mock.bools().get());
		// % protected region % [Add customisation for Classification Infectious here] end
		// % protected region % [Add customisation for Classification Chronic here] off begin
		newEntity.setClassificationChronic(mock.bools().get());
		// % protected region % [Add customisation for Classification Chronic here] end
		// % protected region % [Add customisation for Classification Top Disease here] off begin
		newEntity.setClassificationTopDisease(mock.bools().get());
		// % protected region % [Add customisation for Classification Top Disease here] end
		// % protected region % [Add customisation for Classification Restricted Case here] off begin
		newEntity.setClassificationRestrictedCase(mock.bools().get());
		// % protected region % [Add customisation for Classification Restricted Case here] end
		// % protected region % [Add customisation for Classification Reportable Case here] off begin
		newEntity.setClassificationReportableCase(mock.bools().get());
		// % protected region % [Add customisation for Classification Reportable Case here] end
		// % protected region % [Add customisation for Classification Acute here] off begin
		newEntity.setClassificationAcute(mock.bools().get());
		// % protected region % [Add customisation for Classification Acute here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end

		// % protected region % [Apply any additional logic for icd10WithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for icd10WithNoRef after the main body here] end

		log.trace("Created entity of type Icd10Entity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of ICD 10 entities with no reference at all.
	 */
	@Provides
	@Named("icd10EntitiesWithNoRef")
	public Collection<Icd10Entity> icd10EntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for icd10EntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for icd10EntitiesWithNoRef here] end
		Icd10EntityFactory icd10EntityFactory
	) {
		log.trace("Creating entities of type Icd10Entity with no reference");

		// % protected region % [Apply any additional logic for icd10EntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for icd10EntitiesWithNoRef before the main body here] end

		Collection<Icd10Entity> newEntities = icd10EntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for icd10EntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for icd10EntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type Icd10Entity with no reference");

		return newEntities;
	}

	/**
	 * Return a ICD 10 entity with all references set.
	 */
	@Provides
	@Named("icd10EntityWithRefs")
	public Icd10Entity icd10EntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for icd10EntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for icd10EntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type Icd10Entity with references");

		// % protected region % [Apply any additional logic for icd10EntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for icd10EntityWithRefs before the main body here] end

		Icd10Entity icd10Entity = injector.getInstance(Key.get(Icd10Entity.class, Names.named("icd10EntityWithNoRef")));

		// % protected region % [Apply any additional logic for icd10EntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for icd10EntityWithRefs after the main body here] end

		log.trace("Created entity of type Icd10Entity with references");

		return icd10Entity;
	}

	/**
	 * Return a collection of ICD 10 entities with all references set.
	 */
	@Provides
	@Named("icd10EntitiesWithRefs")
	public Collection<Icd10Entity> icd10EntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for icd10EntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for icd10EntitiesWithRefs here] end
		Icd10EntityFactory icd10EntityFactory
	) {
		log.trace("Creating entities of type Icd10Entity with references");

		// % protected region % [Apply any additional logic for icd10EntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for icd10EntitiesWithRefs before the main body here] end

		Collection<Icd10Entity> newEntities = icd10EntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for icd10EntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for icd10EntitiesWithRefs after the main body here] end

		log.trace("Created entities of type Icd10Entity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
