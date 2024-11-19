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
 * Guice module for Birth History used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BirthHistoryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BirthHistoryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BirthHistoryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BirthHistoryEntityFactory birthHistoryEntityFactory(
			// % protected region % [Apply any additional injected arguments for birthHistoryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for birthHistoryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BirthHistoryEntityFactory");

		// % protected region % [Apply any additional logic for birthHistoryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryEntityFactory before the main body here] end

		BirthHistoryEntityFactory entityFactory = new BirthHistoryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BirthHistoryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BirthHistoryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for birthHistoryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryEntityFactory after the main body here] end

		log.trace("Created BirthHistoryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Birth History entity with no references set.
	 */
	@Provides
	@Named("birthHistoryEntityWithNoRef")
	public BirthHistoryEntity birthHistoryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for birthHistoryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for birthHistoryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BirthHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for birthHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryWithNoRef before the main body here] end

		BirthHistoryEntity newEntity = new BirthHistoryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Gestational Age Weeks here] off begin
		newEntity.setGestationalAgeWeeks(mock.ints().get());
		// % protected region % [Add customisation for Gestational Age Weeks here] end
		// % protected region % [Add customisation for Gestational Age Days here] off begin
		newEntity.setGestationalAgeDays(mock.ints().get());
		// % protected region % [Add customisation for Gestational Age Days here] end
		// % protected region % [Add customisation for Delivery Type here] off begin
		String randomStringforDeliveryType = mock
				.strings()
				.get();
		newEntity.setDeliveryType(randomStringforDeliveryType);
		// % protected region % [Add customisation for Delivery Type here] end
		// % protected region % [Add customisation for Length here] off begin
		newEntity.setLength(mock.doubles().get());
		// % protected region % [Add customisation for Length here] end
		// % protected region % [Add customisation for Length Unit here] off begin
		String randomStringforLengthUnit = mock
				.strings()
				.get();
		newEntity.setLengthUnit(randomStringforLengthUnit);
		// % protected region % [Add customisation for Length Unit here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mock.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Weight Unit here] off begin
		String randomStringforWeightUnit = mock
				.strings()
				.get();
		newEntity.setWeightUnit(randomStringforWeightUnit);
		// % protected region % [Add customisation for Weight Unit here] end
		// % protected region % [Add customisation for Head Circumference Birth here] off begin
		newEntity.setHeadCircumferenceBirth(mock.doubles().get());
		// % protected region % [Add customisation for Head Circumference Birth here] end
		// % protected region % [Add customisation for Head Circumference Birth Unit here] off begin
		String randomStringforHeadCircumferenceBirthUnit = mock
				.strings()
				.get();
		newEntity.setHeadCircumferenceBirthUnit(randomStringforHeadCircumferenceBirthUnit);
		// % protected region % [Add customisation for Head Circumference Birth Unit here] end
		// % protected region % [Add customisation for Chest Circumference here] off begin
		newEntity.setChestCircumference(mock.doubles().get());
		// % protected region % [Add customisation for Chest Circumference here] end
		// % protected region % [Add customisation for Chest Circumference Unit here] off begin
		String randomStringforChestCircumferenceUnit = mock
				.strings()
				.get();
		newEntity.setChestCircumferenceUnit(randomStringforChestCircumferenceUnit);
		// % protected region % [Add customisation for Chest Circumference Unit here] end
		// % protected region % [Add customisation for Birth Condition here] off begin
		String randomStringforBirthCondition = mock
				.strings()
				.get();
		newEntity.setBirthCondition(randomStringforBirthCondition);
		// % protected region % [Add customisation for Birth Condition here] end
		// % protected region % [Add customisation for Neonatal Case here] off begin
		String randomStringforNeonatalCase = mock
				.strings()
				.get();
		newEntity.setNeonatalCase(randomStringforNeonatalCase);
		// % protected region % [Add customisation for Neonatal Case here] end
		// % protected region % [Add customisation for Pediatric Case here] off begin
		String randomStringforPediatricCase = mock
				.strings()
				.get();
		newEntity.setPediatricCase(randomStringforPediatricCase);
		// % protected region % [Add customisation for Pediatric Case here] end
		// % protected region % [Add customisation for Food Type here] off begin
		String randomStringforFoodType = mock
				.strings()
				.get();
		newEntity.setFoodType(randomStringforFoodType);
		// % protected region % [Add customisation for Food Type here] end
		// % protected region % [Add customisation for Head Circumference here] off begin
		newEntity.setHeadCircumference(mock.doubles().get());
		// % protected region % [Add customisation for Head Circumference here] end
		// % protected region % [Add customisation for Head Circumference Unit here] off begin
		String randomStringforHeadCircumferenceUnit = mock
				.strings()
				.get();
		newEntity.setHeadCircumferenceUnit(randomStringforHeadCircumferenceUnit);
		// % protected region % [Add customisation for Head Circumference Unit here] end
		// % protected region % [Add customisation for Upper Arm Circumference here] off begin
		newEntity.setUpperArmCircumference(mock.doubles().get());
		// % protected region % [Add customisation for Upper Arm Circumference here] end
		// % protected region % [Add customisation for Upper Arm Circumference Unit here] off begin
		String randomStringforUpperArmCircumferenceUnit = mock
				.strings()
				.get();
		newEntity.setUpperArmCircumferenceUnit(randomStringforUpperArmCircumferenceUnit);
		// % protected region % [Add customisation for Upper Arm Circumference Unit here] end
		// % protected region % [Add customisation for Action Taken here] off begin
		String randomStringforActionTaken = mock
				.strings()
				.get();
		newEntity.setActionTaken(randomStringforActionTaken);
		// % protected region % [Add customisation for Action Taken here] end
		// % protected region % [Add customisation for Weight Gestational Age here] off begin
		String randomStringforWeightGestationalAge = mock
				.strings()
				.get();
		newEntity.setWeightGestationalAge(randomStringforWeightGestationalAge);
		// % protected region % [Add customisation for Weight Gestational Age here] end

		// % protected region % [Apply any additional logic for birthHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryWithNoRef after the main body here] end

		log.trace("Created entity of type BirthHistoryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Birth History entities with no reference at all.
	 */
	@Provides
	@Named("birthHistoryEntitiesWithNoRef")
	public Collection<BirthHistoryEntity> birthHistoryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for birthHistoryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for birthHistoryEntitiesWithNoRef here] end
		BirthHistoryEntityFactory birthHistoryEntityFactory
	) {
		log.trace("Creating entities of type BirthHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for birthHistoryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryEntitiesWithNoRef before the main body here] end

		Collection<BirthHistoryEntity> newEntities = birthHistoryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for birthHistoryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BirthHistoryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Birth History entity with all references set.
	 */
	@Provides
	@Named("birthHistoryEntityWithRefs")
	public BirthHistoryEntity birthHistoryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for birthHistoryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for birthHistoryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BirthHistoryEntity with references");

		// % protected region % [Apply any additional logic for birthHistoryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryEntityWithRefs before the main body here] end

		BirthHistoryEntity birthHistoryEntity = injector.getInstance(Key.get(BirthHistoryEntity.class, Names.named("birthHistoryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for birthHistoryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryEntityWithRefs after the main body here] end

		log.trace("Created entity of type BirthHistoryEntity with references");

		return birthHistoryEntity;
	}

	/**
	 * Return a collection of Birth History entities with all references set.
	 */
	@Provides
	@Named("birthHistoryEntitiesWithRefs")
	public Collection<BirthHistoryEntity> birthHistoryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for birthHistoryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for birthHistoryEntitiesWithRefs here] end
		BirthHistoryEntityFactory birthHistoryEntityFactory
	) {
		log.trace("Creating entities of type BirthHistoryEntity with references");

		// % protected region % [Apply any additional logic for birthHistoryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryEntitiesWithRefs before the main body here] end

		Collection<BirthHistoryEntity> newEntities = birthHistoryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for birthHistoryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BirthHistoryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
