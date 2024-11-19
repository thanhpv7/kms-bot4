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
 * Guice module for Newborn Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NewbornDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NewbornDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NewbornDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NewbornDetailEntityFactory newbornDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for newbornDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for newbornDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NewbornDetailEntityFactory");

		// % protected region % [Apply any additional logic for newbornDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailEntityFactory before the main body here] end

		NewbornDetailEntityFactory entityFactory = new NewbornDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NewbornDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NewbornDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for newbornDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailEntityFactory after the main body here] end

		log.trace("Created NewbornDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Newborn Detail entity with no references set.
	 */
	@Provides
	@Named("newbornDetailEntityWithNoRef")
	public NewbornDetailEntity newbornDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for newbornDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for newbornDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NewbornDetailEntity with no reference");

		// % protected region % [Apply any additional logic for newbornDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailWithNoRef before the main body here] end

		NewbornDetailEntity newEntity = new NewbornDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Newborn First Name here] off begin
		String randomStringforNewbornFirstName = mock
				.strings()
				.get();
		newEntity.setNewbornFirstName(randomStringforNewbornFirstName);
		// % protected region % [Add customisation for Newborn First Name here] end
		// % protected region % [Add customisation for Newborn Last Name here] off begin
		String randomStringforNewbornLastName = mock
				.strings()
				.get();
		newEntity.setNewbornLastName(randomStringforNewbornLastName);
		// % protected region % [Add customisation for Newborn Last Name here] end
		// % protected region % [Add customisation for Date Time Of Birth here] off begin
		newEntity.setDateTimeOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Time Of Birth here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringforGender = mock
				.strings()
				.get();
		newEntity.setGender(randomStringforGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Delivery Type here] off begin
		String randomStringforDeliveryType = mock
				.strings()
				.get();
		newEntity.setDeliveryType(randomStringforDeliveryType);
		// % protected region % [Add customisation for Delivery Type here] end
		// % protected region % [Add customisation for Delivery Type Indication here] off begin
		String randomStringforDeliveryTypeIndication = mock
				.strings()
				.get();
		newEntity.setDeliveryTypeIndication(randomStringforDeliveryTypeIndication);
		// % protected region % [Add customisation for Delivery Type Indication here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mock.ints().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Length here] off begin
		newEntity.setLength(mock.ints().get());
		// % protected region % [Add customisation for Length here] end
		// % protected region % [Add customisation for Weight Of Gestational Age here] off begin
		String randomStringforWeightOfGestationalAge = mock
				.strings()
				.get();
		newEntity.setWeightOfGestationalAge(randomStringforWeightOfGestationalAge);
		// % protected region % [Add customisation for Weight Of Gestational Age here] end
		// % protected region % [Add customisation for Head Circumference here] off begin
		newEntity.setHeadCircumference(mock.ints().get());
		// % protected region % [Add customisation for Head Circumference here] end
		// % protected region % [Add customisation for Chest Circumference here] off begin
		newEntity.setChestCircumference(mock.ints().get());
		// % protected region % [Add customisation for Chest Circumference here] end
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
		// % protected region % [Add customisation for Congenital Condition here] off begin
		String randomStringforCongenitalCondition = mock
				.strings()
				.get();
		newEntity.setCongenitalCondition(randomStringforCongenitalCondition);
		// % protected region % [Add customisation for Congenital Condition here] end
		// % protected region % [Add customisation for Physical Examination here] off begin
		String randomStringforPhysicalExamination = mock
				.strings()
				.get();
		newEntity.setPhysicalExamination(randomStringforPhysicalExamination);
		// % protected region % [Add customisation for Physical Examination here] end
		// % protected region % [Add customisation for APGAR 1 Minute Appearance here] off begin
		String randomStringforApgar1MinuteAppearance = mock
				.strings()
				.get();
		newEntity.setApgar1MinuteAppearance(randomStringforApgar1MinuteAppearance);
		// % protected region % [Add customisation for APGAR 1 Minute Appearance here] end
		// % protected region % [Add customisation for APGAR 5 Minute Appearance here] off begin
		String randomStringforApgar5MinuteAppearance = mock
				.strings()
				.get();
		newEntity.setApgar5MinuteAppearance(randomStringforApgar5MinuteAppearance);
		// % protected region % [Add customisation for APGAR 5 Minute Appearance here] end
		// % protected region % [Add customisation for APGAR 10 Minute Appearance here] off begin
		String randomStringforApgar10MinuteAppearance = mock
				.strings()
				.get();
		newEntity.setApgar10MinuteAppearance(randomStringforApgar10MinuteAppearance);
		// % protected region % [Add customisation for APGAR 10 Minute Appearance here] end
		// % protected region % [Add customisation for APGAR 1 Minute Pulse here] off begin
		String randomStringforApgar1MinutePulse = mock
				.strings()
				.get();
		newEntity.setApgar1MinutePulse(randomStringforApgar1MinutePulse);
		// % protected region % [Add customisation for APGAR 1 Minute Pulse here] end
		// % protected region % [Add customisation for APGAR 5 Minute Pulse here] off begin
		String randomStringforApgar5MinutePulse = mock
				.strings()
				.get();
		newEntity.setApgar5MinutePulse(randomStringforApgar5MinutePulse);
		// % protected region % [Add customisation for APGAR 5 Minute Pulse here] end
		// % protected region % [Add customisation for APGAR 10 Minute Pulse here] off begin
		String randomStringforApgar10MinutePulse = mock
				.strings()
				.get();
		newEntity.setApgar10MinutePulse(randomStringforApgar10MinutePulse);
		// % protected region % [Add customisation for APGAR 10 Minute Pulse here] end
		// % protected region % [Add customisation for APGAR 1 Minute Grimace here] off begin
		String randomStringforApgar1MinuteGrimace = mock
				.strings()
				.get();
		newEntity.setApgar1MinuteGrimace(randomStringforApgar1MinuteGrimace);
		// % protected region % [Add customisation for APGAR 1 Minute Grimace here] end
		// % protected region % [Add customisation for APGAR 5 Minute Grimace here] off begin
		String randomStringforApgar5MinuteGrimace = mock
				.strings()
				.get();
		newEntity.setApgar5MinuteGrimace(randomStringforApgar5MinuteGrimace);
		// % protected region % [Add customisation for APGAR 5 Minute Grimace here] end
		// % protected region % [Add customisation for APGAR 10 Minute Grimace here] off begin
		String randomStringforApgar10MinuteGrimace = mock
				.strings()
				.get();
		newEntity.setApgar10MinuteGrimace(randomStringforApgar10MinuteGrimace);
		// % protected region % [Add customisation for APGAR 10 Minute Grimace here] end
		// % protected region % [Add customisation for APGAR 1 Minute Activity here] off begin
		String randomStringforApgar1MinuteActivity = mock
				.strings()
				.get();
		newEntity.setApgar1MinuteActivity(randomStringforApgar1MinuteActivity);
		// % protected region % [Add customisation for APGAR 1 Minute Activity here] end
		// % protected region % [Add customisation for APGAR 5 Minute Activity here] off begin
		String randomStringforApgar5MinuteActivity = mock
				.strings()
				.get();
		newEntity.setApgar5MinuteActivity(randomStringforApgar5MinuteActivity);
		// % protected region % [Add customisation for APGAR 5 Minute Activity here] end
		// % protected region % [Add customisation for APGAR 10 Minute Activity here] off begin
		String randomStringforApgar10MinuteActivity = mock
				.strings()
				.get();
		newEntity.setApgar10MinuteActivity(randomStringforApgar10MinuteActivity);
		// % protected region % [Add customisation for APGAR 10 Minute Activity here] end
		// % protected region % [Add customisation for APGAR 1 Minute Respiration here] off begin
		String randomStringforApgar1MinuteRespiration = mock
				.strings()
				.get();
		newEntity.setApgar1MinuteRespiration(randomStringforApgar1MinuteRespiration);
		// % protected region % [Add customisation for APGAR 1 Minute Respiration here] end
		// % protected region % [Add customisation for APGAR 5 Minute Respiration here] off begin
		String randomStringforApgar5MinuteRespiration = mock
				.strings()
				.get();
		newEntity.setApgar5MinuteRespiration(randomStringforApgar5MinuteRespiration);
		// % protected region % [Add customisation for APGAR 5 Minute Respiration here] end
		// % protected region % [Add customisation for APGAR 10 Minute Respiration here] off begin
		String randomStringforApgar10MinuteRespiration = mock
				.strings()
				.get();
		newEntity.setApgar10MinuteRespiration(randomStringforApgar10MinuteRespiration);
		// % protected region % [Add customisation for APGAR 10 Minute Respiration here] end
		// % protected region % [Add customisation for APGAR 1 Minute Score here] off begin
		String randomStringforApgar1MinuteScore = mock
				.strings()
				.get();
		newEntity.setApgar1MinuteScore(randomStringforApgar1MinuteScore);
		// % protected region % [Add customisation for APGAR 1 Minute Score here] end
		// % protected region % [Add customisation for APGAR 5 Minute Score here] off begin
		String randomStringforApgar5MinuteScore = mock
				.strings()
				.get();
		newEntity.setApgar5MinuteScore(randomStringforApgar5MinuteScore);
		// % protected region % [Add customisation for APGAR 5 Minute Score here] end
		// % protected region % [Add customisation for APGAR 10 Minute Score here] off begin
		String randomStringforApgar10MinuteScore = mock
				.strings()
				.get();
		newEntity.setApgar10MinuteScore(randomStringforApgar10MinuteScore);
		// % protected region % [Add customisation for APGAR 10 Minute Score here] end
		// % protected region % [Add customisation for Pediatric Nurse here] off begin
		String randomStringforPediatricNurse = mock
				.strings()
				.get();
		newEntity.setPediatricNurse(randomStringforPediatricNurse);
		// % protected region % [Add customisation for Pediatric Nurse here] end
		// % protected region % [Add customisation for Patient Id here] off begin
		String randomStringforPatientId = mock
				.strings()
				.get();
		newEntity.setPatientId(randomStringforPatientId);
		// % protected region % [Add customisation for Patient Id here] end
		// % protected region % [Add customisation for Registration Id here] off begin
		String randomStringforRegistrationId = mock
				.strings()
				.get();
		newEntity.setRegistrationId(randomStringforRegistrationId);
		// % protected region % [Add customisation for Registration Id here] end

		// % protected region % [Apply any additional logic for newbornDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailWithNoRef after the main body here] end

		log.trace("Created entity of type NewbornDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Newborn Detail entities with no reference at all.
	 */
	@Provides
	@Named("newbornDetailEntitiesWithNoRef")
	public Collection<NewbornDetailEntity> newbornDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for newbornDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for newbornDetailEntitiesWithNoRef here] end
		NewbornDetailEntityFactory newbornDetailEntityFactory
	) {
		log.trace("Creating entities of type NewbornDetailEntity with no reference");

		// % protected region % [Apply any additional logic for newbornDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailEntitiesWithNoRef before the main body here] end

		Collection<NewbornDetailEntity> newEntities = newbornDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for newbornDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NewbornDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Newborn Detail entity with all references set.
	 */
	@Provides
	@Named("newbornDetailEntityWithRefs")
	public NewbornDetailEntity newbornDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for newbornDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for newbornDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NewbornDetailEntity with references");

		// % protected region % [Apply any additional logic for newbornDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailEntityWithRefs before the main body here] end

		NewbornDetailEntity newbornDetailEntity = injector.getInstance(Key.get(NewbornDetailEntity.class, Names.named("newbornDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for newbornDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type NewbornDetailEntity with references");

		return newbornDetailEntity;
	}

	/**
	 * Return a collection of Newborn Detail entities with all references set.
	 */
	@Provides
	@Named("newbornDetailEntitiesWithRefs")
	public Collection<NewbornDetailEntity> newbornDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for newbornDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for newbornDetailEntitiesWithRefs here] end
		NewbornDetailEntityFactory newbornDetailEntityFactory
	) {
		log.trace("Creating entities of type NewbornDetailEntity with references");

		// % protected region % [Apply any additional logic for newbornDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailEntitiesWithRefs before the main body here] end

		Collection<NewbornDetailEntity> newEntities = newbornDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for newbornDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NewbornDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
