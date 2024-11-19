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
 * Guice module for Ophthalmology Examination used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class OphthalmologyExaminationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring OphthalmologyExaminationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured OphthalmologyExaminationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public OphthalmologyExaminationEntityFactory ophthalmologyExaminationEntityFactory(
			// % protected region % [Apply any additional injected arguments for ophthalmologyExaminationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for ophthalmologyExaminationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating OphthalmologyExaminationEntityFactory");

		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntityFactory before the main body here] end

		OphthalmologyExaminationEntityFactory entityFactory = new OphthalmologyExaminationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for OphthalmologyExaminationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for OphthalmologyExaminationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntityFactory after the main body here] end

		log.trace("Created OphthalmologyExaminationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Ophthalmology Examination entity with no references set.
	 */
	@Provides
	@Named("ophthalmologyExaminationEntityWithNoRef")
	public OphthalmologyExaminationEntity ophthalmologyExaminationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for ophthalmologyExaminationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for ophthalmologyExaminationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type OphthalmologyExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for ophthalmologyExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationWithNoRef before the main body here] end

		OphthalmologyExaminationEntity newEntity = new OphthalmologyExaminationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Right Eyelid Subjective here] off begin
		String randomStringforRightEyelidSubjective = mock
				.strings()
				.get();
		newEntity.setRightEyelidSubjective(randomStringforRightEyelidSubjective);
		// % protected region % [Add customisation for Right Eyelid Subjective here] end
		// % protected region % [Add customisation for Right Eyelid Objective here] off begin
		String randomStringforRightEyelidObjective = mock
				.strings()
				.get();
		newEntity.setRightEyelidObjective(randomStringforRightEyelidObjective);
		// % protected region % [Add customisation for Right Eyelid Objective here] end
		// % protected region % [Add customisation for Right Pupil Subjective here] off begin
		String randomStringforRightPupilSubjective = mock
				.strings()
				.get();
		newEntity.setRightPupilSubjective(randomStringforRightPupilSubjective);
		// % protected region % [Add customisation for Right Pupil Subjective here] end
		// % protected region % [Add customisation for Right Pupil Objective here] off begin
		String randomStringforRightPupilObjective = mock
				.strings()
				.get();
		newEntity.setRightPupilObjective(randomStringforRightPupilObjective);
		// % protected region % [Add customisation for Right Pupil Objective here] end
		// % protected region % [Add customisation for Right Sclera Subjective here] off begin
		String randomStringforRightScleraSubjective = mock
				.strings()
				.get();
		newEntity.setRightScleraSubjective(randomStringforRightScleraSubjective);
		// % protected region % [Add customisation for Right Sclera Subjective here] end
		// % protected region % [Add customisation for Right Sclera Objective here] off begin
		String randomStringforRightScleraObjective = mock
				.strings()
				.get();
		newEntity.setRightScleraObjective(randomStringforRightScleraObjective);
		// % protected region % [Add customisation for Right Sclera Objective here] end
		// % protected region % [Add customisation for Right Iris Subjective here] off begin
		String randomStringforRightIrisSubjective = mock
				.strings()
				.get();
		newEntity.setRightIrisSubjective(randomStringforRightIrisSubjective);
		// % protected region % [Add customisation for Right Iris Subjective here] end
		// % protected region % [Add customisation for Right Iris Objective here] off begin
		String randomStringforRightIrisObjective = mock
				.strings()
				.get();
		newEntity.setRightIrisObjective(randomStringforRightIrisObjective);
		// % protected region % [Add customisation for Right Iris Objective here] end
		// % protected region % [Add customisation for Left Eyelid Subjective here] off begin
		String randomStringforLeftEyelidSubjective = mock
				.strings()
				.get();
		newEntity.setLeftEyelidSubjective(randomStringforLeftEyelidSubjective);
		// % protected region % [Add customisation for Left Eyelid Subjective here] end
		// % protected region % [Add customisation for Left Eyelid Objective here] off begin
		String randomStringforLeftEyelidObjective = mock
				.strings()
				.get();
		newEntity.setLeftEyelidObjective(randomStringforLeftEyelidObjective);
		// % protected region % [Add customisation for Left Eyelid Objective here] end
		// % protected region % [Add customisation for Left Pupil Subjective here] off begin
		String randomStringforLeftPupilSubjective = mock
				.strings()
				.get();
		newEntity.setLeftPupilSubjective(randomStringforLeftPupilSubjective);
		// % protected region % [Add customisation for Left Pupil Subjective here] end
		// % protected region % [Add customisation for Left Pupil Objective here] off begin
		String randomStringforLeftPupilObjective = mock
				.strings()
				.get();
		newEntity.setLeftPupilObjective(randomStringforLeftPupilObjective);
		// % protected region % [Add customisation for Left Pupil Objective here] end
		// % protected region % [Add customisation for Left Sclera Subjective here] off begin
		String randomStringforLeftScleraSubjective = mock
				.strings()
				.get();
		newEntity.setLeftScleraSubjective(randomStringforLeftScleraSubjective);
		// % protected region % [Add customisation for Left Sclera Subjective here] end
		// % protected region % [Add customisation for Left Sclera Objective here] off begin
		String randomStringforLeftScleraObjective = mock
				.strings()
				.get();
		newEntity.setLeftScleraObjective(randomStringforLeftScleraObjective);
		// % protected region % [Add customisation for Left Sclera Objective here] end
		// % protected region % [Add customisation for Left Iris Subjective here] off begin
		String randomStringforLeftIrisSubjective = mock
				.strings()
				.get();
		newEntity.setLeftIrisSubjective(randomStringforLeftIrisSubjective);
		// % protected region % [Add customisation for Left Iris Subjective here] end
		// % protected region % [Add customisation for Left Iris Objective here] off begin
		String randomStringforLeftIrisObjective = mock
				.strings()
				.get();
		newEntity.setLeftIrisObjective(randomStringforLeftIrisObjective);
		// % protected region % [Add customisation for Left Iris Objective here] end

		// % protected region % [Apply any additional logic for ophthalmologyExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationWithNoRef after the main body here] end

		log.trace("Created entity of type OphthalmologyExaminationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Ophthalmology Examination entities with no reference at all.
	 */
	@Provides
	@Named("ophthalmologyExaminationEntitiesWithNoRef")
	public Collection<OphthalmologyExaminationEntity> ophthalmologyExaminationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for ophthalmologyExaminationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for ophthalmologyExaminationEntitiesWithNoRef here] end
		OphthalmologyExaminationEntityFactory ophthalmologyExaminationEntityFactory
	) {
		log.trace("Creating entities of type OphthalmologyExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntitiesWithNoRef before the main body here] end

		Collection<OphthalmologyExaminationEntity> newEntities = ophthalmologyExaminationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type OphthalmologyExaminationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Ophthalmology Examination entity with all references set.
	 */
	@Provides
	@Named("ophthalmologyExaminationEntityWithRefs")
	public OphthalmologyExaminationEntity ophthalmologyExaminationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for ophthalmologyExaminationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for ophthalmologyExaminationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type OphthalmologyExaminationEntity with references");

		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntityWithRefs before the main body here] end

		OphthalmologyExaminationEntity ophthalmologyExaminationEntity = injector.getInstance(Key.get(OphthalmologyExaminationEntity.class, Names.named("ophthalmologyExaminationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntityWithRefs after the main body here] end

		log.trace("Created entity of type OphthalmologyExaminationEntity with references");

		return ophthalmologyExaminationEntity;
	}

	/**
	 * Return a collection of Ophthalmology Examination entities with all references set.
	 */
	@Provides
	@Named("ophthalmologyExaminationEntitiesWithRefs")
	public Collection<OphthalmologyExaminationEntity> ophthalmologyExaminationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for ophthalmologyExaminationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for ophthalmologyExaminationEntitiesWithRefs here] end
		OphthalmologyExaminationEntityFactory ophthalmologyExaminationEntityFactory
	) {
		log.trace("Creating entities of type OphthalmologyExaminationEntity with references");

		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntitiesWithRefs before the main body here] end

		Collection<OphthalmologyExaminationEntity> newEntities = ophthalmologyExaminationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type OphthalmologyExaminationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
