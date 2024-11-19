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
 * Guice module for Post Operative Details used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PostOperativeDetailsModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PostOperativeDetailsModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PostOperativeDetailsModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PostOperativeDetailsEntityFactory postOperativeDetailsEntityFactory(
			// % protected region % [Apply any additional injected arguments for postOperativeDetailsEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for postOperativeDetailsEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PostOperativeDetailsEntityFactory");

		// % protected region % [Apply any additional logic for postOperativeDetailsEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsEntityFactory before the main body here] end

		PostOperativeDetailsEntityFactory entityFactory = new PostOperativeDetailsEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PostOperativeDetailsEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PostOperativeDetailsEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for postOperativeDetailsEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsEntityFactory after the main body here] end

		log.trace("Created PostOperativeDetailsEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Post Operative Details entity with no references set.
	 */
	@Provides
	@Named("postOperativeDetailsEntityWithNoRef")
	public PostOperativeDetailsEntity postOperativeDetailsEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for postOperativeDetailsEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for postOperativeDetailsEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PostOperativeDetailsEntity with no reference");

		// % protected region % [Apply any additional logic for postOperativeDetailsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsWithNoRef before the main body here] end

		PostOperativeDetailsEntity newEntity = new PostOperativeDetailsEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Recovery Start Date Time here] off begin
		newEntity.setRecoveryStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Recovery Start Date Time here] end
		// % protected region % [Add customisation for Recovery End Date Time here] off begin
		newEntity.setRecoveryEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Recovery End Date Time here] end
		// % protected region % [Add customisation for Postoperative Main Diagnosis here] off begin
		String randomStringforPostoperativeMainDiagnosis = mock
				.strings()
				.get();
		newEntity.setPostoperativeMainDiagnosis(randomStringforPostoperativeMainDiagnosis);
		// % protected region % [Add customisation for Postoperative Main Diagnosis here] end
		// % protected region % [Add customisation for Postoperative Action here] off begin
		String randomStringforPostoperativeAction = mock
				.strings()
				.get();
		newEntity.setPostoperativeAction(randomStringforPostoperativeAction);
		// % protected region % [Add customisation for Postoperative Action here] end
		// % protected region % [Add customisation for New Case here] off begin
		newEntity.setNewCase(mock.bools().get());
		// % protected region % [Add customisation for New Case here] end
		// % protected region % [Add customisation for Postoperative Diagnosis Support Order here] off begin
		String randomStringforPostoperativeDiagnosisSupportOrder = mock
				.strings()
				.get();
		newEntity.setPostoperativeDiagnosisSupportOrder(randomStringforPostoperativeDiagnosisSupportOrder);
		// % protected region % [Add customisation for Postoperative Diagnosis Support Order here] end
		// % protected region % [Add customisation for Anesthesia Postoperative Monitoring here] off begin
		String randomStringforAnesthesiaPostoperativeMonitoring = mock
				.strings()
				.get();
		newEntity.setAnesthesiaPostoperativeMonitoring(randomStringforAnesthesiaPostoperativeMonitoring);
		// % protected region % [Add customisation for Anesthesia Postoperative Monitoring here] end
		// % protected region % [Add customisation for Anesthesia Postoperative Action here] off begin
		String randomStringforAnesthesiaPostoperativeAction = mock
				.strings()
				.get();
		newEntity.setAnesthesiaPostoperativeAction(randomStringforAnesthesiaPostoperativeAction);
		// % protected region % [Add customisation for Anesthesia Postoperative Action here] end

		// % protected region % [Apply any additional logic for postOperativeDetailsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsWithNoRef after the main body here] end

		log.trace("Created entity of type PostOperativeDetailsEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Post Operative Details entities with no reference at all.
	 */
	@Provides
	@Named("postOperativeDetailsEntitiesWithNoRef")
	public Collection<PostOperativeDetailsEntity> postOperativeDetailsEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for postOperativeDetailsEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for postOperativeDetailsEntitiesWithNoRef here] end
		PostOperativeDetailsEntityFactory postOperativeDetailsEntityFactory
	) {
		log.trace("Creating entities of type PostOperativeDetailsEntity with no reference");

		// % protected region % [Apply any additional logic for postOperativeDetailsEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsEntitiesWithNoRef before the main body here] end

		Collection<PostOperativeDetailsEntity> newEntities = postOperativeDetailsEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for postOperativeDetailsEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PostOperativeDetailsEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Post Operative Details entity with all references set.
	 */
	@Provides
	@Named("postOperativeDetailsEntityWithRefs")
	public PostOperativeDetailsEntity postOperativeDetailsEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for postOperativeDetailsEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for postOperativeDetailsEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PostOperativeDetailsEntity with references");

		// % protected region % [Apply any additional logic for postOperativeDetailsEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsEntityWithRefs before the main body here] end

		PostOperativeDetailsEntity postOperativeDetailsEntity = injector.getInstance(Key.get(PostOperativeDetailsEntity.class, Names.named("postOperativeDetailsEntityWithNoRef")));

		// % protected region % [Apply any additional logic for postOperativeDetailsEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsEntityWithRefs after the main body here] end

		log.trace("Created entity of type PostOperativeDetailsEntity with references");

		return postOperativeDetailsEntity;
	}

	/**
	 * Return a collection of Post Operative Details entities with all references set.
	 */
	@Provides
	@Named("postOperativeDetailsEntitiesWithRefs")
	public Collection<PostOperativeDetailsEntity> postOperativeDetailsEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for postOperativeDetailsEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for postOperativeDetailsEntitiesWithRefs here] end
		PostOperativeDetailsEntityFactory postOperativeDetailsEntityFactory
	) {
		log.trace("Creating entities of type PostOperativeDetailsEntity with references");

		// % protected region % [Apply any additional logic for postOperativeDetailsEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsEntitiesWithRefs before the main body here] end

		Collection<PostOperativeDetailsEntity> newEntities = postOperativeDetailsEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for postOperativeDetailsEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PostOperativeDetailsEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
