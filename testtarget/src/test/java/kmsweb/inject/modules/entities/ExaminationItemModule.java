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
 * Guice module for Examination Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ExaminationItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ExaminationItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ExaminationItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ExaminationItemEntityFactory examinationItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for examinationItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for examinationItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ExaminationItemEntityFactory");

		// % protected region % [Apply any additional logic for examinationItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemEntityFactory before the main body here] end

		ExaminationItemEntityFactory entityFactory = new ExaminationItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ExaminationItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ExaminationItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for examinationItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemEntityFactory after the main body here] end

		log.trace("Created ExaminationItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Examination Item entity with no references set.
	 */
	@Provides
	@Named("examinationItemEntityWithNoRef")
	public ExaminationItemEntity examinationItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for examinationItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for examinationItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ExaminationItemEntity with no reference");

		// % protected region % [Apply any additional logic for examinationItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemWithNoRef before the main body here] end

		ExaminationItemEntity newEntity = new ExaminationItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
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
		// % protected region % [Add customisation for Sample here] off begin
		String randomStringforSample = mock
				.strings()
				.get();
		newEntity.setSample(randomStringforSample);
		// % protected region % [Add customisation for Sample here] end
		// % protected region % [Add customisation for Examination Level here] off begin
		String randomStringforExaminationLevel = mock
				.strings()
				.get();
		newEntity.setExaminationLevel(randomStringforExaminationLevel);
		// % protected region % [Add customisation for Examination Level here] end
		// % protected region % [Add customisation for Examination Type here] off begin
		String randomStringforExaminationType = mock
				.strings()
				.get();
		newEntity.setExaminationType(randomStringforExaminationType);
		// % protected region % [Add customisation for Examination Type here] end

		// % protected region % [Apply any additional logic for examinationItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemWithNoRef after the main body here] end

		log.trace("Created entity of type ExaminationItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Examination Item entities with no reference at all.
	 */
	@Provides
	@Named("examinationItemEntitiesWithNoRef")
	public Collection<ExaminationItemEntity> examinationItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for examinationItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for examinationItemEntitiesWithNoRef here] end
		ExaminationItemEntityFactory examinationItemEntityFactory
	) {
		log.trace("Creating entities of type ExaminationItemEntity with no reference");

		// % protected region % [Apply any additional logic for examinationItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemEntitiesWithNoRef before the main body here] end

		Collection<ExaminationItemEntity> newEntities = examinationItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for examinationItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ExaminationItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Examination Item entity with all references set.
	 */
	@Provides
	@Named("examinationItemEntityWithRefs")
	public ExaminationItemEntity examinationItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for examinationItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for examinationItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ExaminationItemEntity with references");

		// % protected region % [Apply any additional logic for examinationItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemEntityWithRefs before the main body here] end

		ExaminationItemEntity examinationItemEntity = injector.getInstance(Key.get(ExaminationItemEntity.class, Names.named("examinationItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for examinationItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type ExaminationItemEntity with references");

		return examinationItemEntity;
	}

	/**
	 * Return a collection of Examination Item entities with all references set.
	 */
	@Provides
	@Named("examinationItemEntitiesWithRefs")
	public Collection<ExaminationItemEntity> examinationItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for examinationItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for examinationItemEntitiesWithRefs here] end
		ExaminationItemEntityFactory examinationItemEntityFactory
	) {
		log.trace("Creating entities of type ExaminationItemEntity with references");

		// % protected region % [Apply any additional logic for examinationItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemEntitiesWithRefs before the main body here] end

		Collection<ExaminationItemEntity> newEntities = examinationItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for examinationItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ExaminationItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
