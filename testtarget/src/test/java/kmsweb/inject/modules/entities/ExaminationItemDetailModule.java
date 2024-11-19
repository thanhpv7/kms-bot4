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
 * Guice module for Examination Item Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ExaminationItemDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ExaminationItemDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ExaminationItemDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ExaminationItemDetailEntityFactory examinationItemDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for examinationItemDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for examinationItemDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ExaminationItemDetailEntityFactory");

		// % protected region % [Apply any additional logic for examinationItemDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailEntityFactory before the main body here] end

		ExaminationItemDetailEntityFactory entityFactory = new ExaminationItemDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ExaminationItemDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ExaminationItemDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for examinationItemDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailEntityFactory after the main body here] end

		log.trace("Created ExaminationItemDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Examination Item Detail entity with no references set.
	 */
	@Provides
	@Named("examinationItemDetailEntityWithNoRef")
	public ExaminationItemDetailEntity examinationItemDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for examinationItemDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for examinationItemDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ExaminationItemDetailEntity with no reference");

		// % protected region % [Apply any additional logic for examinationItemDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailWithNoRef before the main body here] end

		ExaminationItemDetailEntity newEntity = new ExaminationItemDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Age Minimum here] off begin
		newEntity.setAgeMinimum(mock.ints().get());
		// % protected region % [Add customisation for Age Minimum here] end
		// % protected region % [Add customisation for Age Maximum here] off begin
		newEntity.setAgeMaximum(mock.ints().get());
		// % protected region % [Add customisation for Age Maximum here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringforGender = mock
				.strings()
				.get();
		newEntity.setGender(randomStringforGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Normal Range Low here] off begin
		newEntity.setNormalRangeLow(mock.doubles().get());
		// % protected region % [Add customisation for Normal Range Low here] end
		// % protected region % [Add customisation for Normal Range High here] off begin
		newEntity.setNormalRangeHigh(mock.doubles().get());
		// % protected region % [Add customisation for Normal Range High here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringforUnit = mock
				.strings()
				.get();
		newEntity.setUnit(randomStringforUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Critical Value Low here] off begin
		newEntity.setCriticalValueLow(mock.doubles().get());
		// % protected region % [Add customisation for Critical Value Low here] end
		// % protected region % [Add customisation for Critical Value High here] off begin
		newEntity.setCriticalValueHigh(mock.doubles().get());
		// % protected region % [Add customisation for Critical Value High here] end
		// % protected region % [Add customisation for Age Min Unit here] off begin
		String randomStringforAgeMinUnit = mock
				.strings()
				.get();
		newEntity.setAgeMinUnit(randomStringforAgeMinUnit);
		// % protected region % [Add customisation for Age Min Unit here] end
		// % protected region % [Add customisation for Age Max Unit here] off begin
		String randomStringforAgeMaxUnit = mock
				.strings()
				.get();
		newEntity.setAgeMaxUnit(randomStringforAgeMaxUnit);
		// % protected region % [Add customisation for Age Max Unit here] end

		// % protected region % [Apply any additional logic for examinationItemDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailWithNoRef after the main body here] end

		log.trace("Created entity of type ExaminationItemDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Examination Item Detail entities with no reference at all.
	 */
	@Provides
	@Named("examinationItemDetailEntitiesWithNoRef")
	public Collection<ExaminationItemDetailEntity> examinationItemDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for examinationItemDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for examinationItemDetailEntitiesWithNoRef here] end
		ExaminationItemDetailEntityFactory examinationItemDetailEntityFactory
	) {
		log.trace("Creating entities of type ExaminationItemDetailEntity with no reference");

		// % protected region % [Apply any additional logic for examinationItemDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailEntitiesWithNoRef before the main body here] end

		Collection<ExaminationItemDetailEntity> newEntities = examinationItemDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for examinationItemDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ExaminationItemDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Examination Item Detail entity with all references set.
	 */
	@Provides
	@Named("examinationItemDetailEntityWithRefs")
	public ExaminationItemDetailEntity examinationItemDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for examinationItemDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for examinationItemDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ExaminationItemDetailEntity with references");

		// % protected region % [Apply any additional logic for examinationItemDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailEntityWithRefs before the main body here] end

		ExaminationItemDetailEntity examinationItemDetailEntity = injector.getInstance(Key.get(ExaminationItemDetailEntity.class, Names.named("examinationItemDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for examinationItemDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type ExaminationItemDetailEntity with references");

		return examinationItemDetailEntity;
	}

	/**
	 * Return a collection of Examination Item Detail entities with all references set.
	 */
	@Provides
	@Named("examinationItemDetailEntitiesWithRefs")
	public Collection<ExaminationItemDetailEntity> examinationItemDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for examinationItemDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for examinationItemDetailEntitiesWithRefs here] end
		ExaminationItemDetailEntityFactory examinationItemDetailEntityFactory
	) {
		log.trace("Creating entities of type ExaminationItemDetailEntity with references");

		// % protected region % [Apply any additional logic for examinationItemDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailEntitiesWithRefs before the main body here] end

		Collection<ExaminationItemDetailEntity> newEntities = examinationItemDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for examinationItemDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for examinationItemDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ExaminationItemDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
