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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.NewbornDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class NewbornDetailFactory implements FactoryBean<NewbornDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public NewbornDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public NewbornDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public NewbornDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for newbornDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailWithNoRef before the main body here] end

		NewbornDetailEntity newEntity = new NewbornDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Newborn First Name here] off begin
		String randomStringForNewbornFirstName = mockNeat
				.strings()
				.get();
		newEntity.setNewbornFirstName(randomStringForNewbornFirstName);
		// % protected region % [Add customisation for Newborn First Name here] end
		// % protected region % [Add customisation for Newborn Last Name here] off begin
		String randomStringForNewbornLastName = mockNeat
				.strings()
				.get();
		newEntity.setNewbornLastName(randomStringForNewbornLastName);
		// % protected region % [Add customisation for Newborn Last Name here] end
		// % protected region % [Add customisation for Date Time Of Birth here] off begin
		newEntity.setDateTimeOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Time Of Birth here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringForGender = mockNeat
				.strings()
				.get();
		newEntity.setGender(randomStringForGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Delivery Type here] off begin
		String randomStringForDeliveryType = mockNeat
				.strings()
				.get();
		newEntity.setDeliveryType(randomStringForDeliveryType);
		// % protected region % [Add customisation for Delivery Type here] end
		// % protected region % [Add customisation for Delivery Type Indication here] off begin
		String randomStringForDeliveryTypeIndication = mockNeat
				.strings()
				.get();
		newEntity.setDeliveryTypeIndication(randomStringForDeliveryTypeIndication);
		// % protected region % [Add customisation for Delivery Type Indication here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mockNeat.ints().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Length here] off begin
		newEntity.setLength(mockNeat.ints().get());
		// % protected region % [Add customisation for Length here] end
		// % protected region % [Add customisation for Weight Of Gestational Age here] off begin
		String randomStringForWeightOfGestationalAge = mockNeat
				.strings()
				.get();
		newEntity.setWeightOfGestationalAge(randomStringForWeightOfGestationalAge);
		// % protected region % [Add customisation for Weight Of Gestational Age here] end
		// % protected region % [Add customisation for Head Circumference here] off begin
		newEntity.setHeadCircumference(mockNeat.ints().get());
		// % protected region % [Add customisation for Head Circumference here] end
		// % protected region % [Add customisation for Chest Circumference here] off begin
		newEntity.setChestCircumference(mockNeat.ints().get());
		// % protected region % [Add customisation for Chest Circumference here] end
		// % protected region % [Add customisation for Birth Condition here] off begin
		String randomStringForBirthCondition = mockNeat
				.strings()
				.get();
		newEntity.setBirthCondition(randomStringForBirthCondition);
		// % protected region % [Add customisation for Birth Condition here] end
		// % protected region % [Add customisation for Neonatal Case here] off begin
		String randomStringForNeonatalCase = mockNeat
				.strings()
				.get();
		newEntity.setNeonatalCase(randomStringForNeonatalCase);
		// % protected region % [Add customisation for Neonatal Case here] end
		// % protected region % [Add customisation for Congenital Condition here] off begin
		String randomStringForCongenitalCondition = mockNeat
				.strings()
				.get();
		newEntity.setCongenitalCondition(randomStringForCongenitalCondition);
		// % protected region % [Add customisation for Congenital Condition here] end
		// % protected region % [Add customisation for Physical Examination here] off begin
		String randomStringForPhysicalExamination = mockNeat
				.strings()
				.get();
		newEntity.setPhysicalExamination(randomStringForPhysicalExamination);
		// % protected region % [Add customisation for Physical Examination here] end
		// % protected region % [Add customisation for APGAR 1 Minute Appearance here] off begin
		String randomStringForApgar1MinuteAppearance = mockNeat
				.strings()
				.get();
		newEntity.setApgar1MinuteAppearance(randomStringForApgar1MinuteAppearance);
		// % protected region % [Add customisation for APGAR 1 Minute Appearance here] end
		// % protected region % [Add customisation for APGAR 5 Minute Appearance here] off begin
		String randomStringForApgar5MinuteAppearance = mockNeat
				.strings()
				.get();
		newEntity.setApgar5MinuteAppearance(randomStringForApgar5MinuteAppearance);
		// % protected region % [Add customisation for APGAR 5 Minute Appearance here] end
		// % protected region % [Add customisation for APGAR 10 Minute Appearance here] off begin
		String randomStringForApgar10MinuteAppearance = mockNeat
				.strings()
				.get();
		newEntity.setApgar10MinuteAppearance(randomStringForApgar10MinuteAppearance);
		// % protected region % [Add customisation for APGAR 10 Minute Appearance here] end
		// % protected region % [Add customisation for APGAR 1 Minute Pulse here] off begin
		String randomStringForApgar1MinutePulse = mockNeat
				.strings()
				.get();
		newEntity.setApgar1MinutePulse(randomStringForApgar1MinutePulse);
		// % protected region % [Add customisation for APGAR 1 Minute Pulse here] end
		// % protected region % [Add customisation for APGAR 5 Minute Pulse here] off begin
		String randomStringForApgar5MinutePulse = mockNeat
				.strings()
				.get();
		newEntity.setApgar5MinutePulse(randomStringForApgar5MinutePulse);
		// % protected region % [Add customisation for APGAR 5 Minute Pulse here] end
		// % protected region % [Add customisation for APGAR 10 Minute Pulse here] off begin
		String randomStringForApgar10MinutePulse = mockNeat
				.strings()
				.get();
		newEntity.setApgar10MinutePulse(randomStringForApgar10MinutePulse);
		// % protected region % [Add customisation for APGAR 10 Minute Pulse here] end
		// % protected region % [Add customisation for APGAR 1 Minute Grimace here] off begin
		String randomStringForApgar1MinuteGrimace = mockNeat
				.strings()
				.get();
		newEntity.setApgar1MinuteGrimace(randomStringForApgar1MinuteGrimace);
		// % protected region % [Add customisation for APGAR 1 Minute Grimace here] end
		// % protected region % [Add customisation for APGAR 5 Minute Grimace here] off begin
		String randomStringForApgar5MinuteGrimace = mockNeat
				.strings()
				.get();
		newEntity.setApgar5MinuteGrimace(randomStringForApgar5MinuteGrimace);
		// % protected region % [Add customisation for APGAR 5 Minute Grimace here] end
		// % protected region % [Add customisation for APGAR 10 Minute Grimace here] off begin
		String randomStringForApgar10MinuteGrimace = mockNeat
				.strings()
				.get();
		newEntity.setApgar10MinuteGrimace(randomStringForApgar10MinuteGrimace);
		// % protected region % [Add customisation for APGAR 10 Minute Grimace here] end
		// % protected region % [Add customisation for APGAR 1 Minute Activity here] off begin
		String randomStringForApgar1MinuteActivity = mockNeat
				.strings()
				.get();
		newEntity.setApgar1MinuteActivity(randomStringForApgar1MinuteActivity);
		// % protected region % [Add customisation for APGAR 1 Minute Activity here] end
		// % protected region % [Add customisation for APGAR 5 Minute Activity here] off begin
		String randomStringForApgar5MinuteActivity = mockNeat
				.strings()
				.get();
		newEntity.setApgar5MinuteActivity(randomStringForApgar5MinuteActivity);
		// % protected region % [Add customisation for APGAR 5 Minute Activity here] end
		// % protected region % [Add customisation for APGAR 10 Minute Activity here] off begin
		String randomStringForApgar10MinuteActivity = mockNeat
				.strings()
				.get();
		newEntity.setApgar10MinuteActivity(randomStringForApgar10MinuteActivity);
		// % protected region % [Add customisation for APGAR 10 Minute Activity here] end
		// % protected region % [Add customisation for APGAR 1 Minute Respiration here] off begin
		String randomStringForApgar1MinuteRespiration = mockNeat
				.strings()
				.get();
		newEntity.setApgar1MinuteRespiration(randomStringForApgar1MinuteRespiration);
		// % protected region % [Add customisation for APGAR 1 Minute Respiration here] end
		// % protected region % [Add customisation for APGAR 5 Minute Respiration here] off begin
		String randomStringForApgar5MinuteRespiration = mockNeat
				.strings()
				.get();
		newEntity.setApgar5MinuteRespiration(randomStringForApgar5MinuteRespiration);
		// % protected region % [Add customisation for APGAR 5 Minute Respiration here] end
		// % protected region % [Add customisation for APGAR 10 Minute Respiration here] off begin
		String randomStringForApgar10MinuteRespiration = mockNeat
				.strings()
				.get();
		newEntity.setApgar10MinuteRespiration(randomStringForApgar10MinuteRespiration);
		// % protected region % [Add customisation for APGAR 10 Minute Respiration here] end
		// % protected region % [Add customisation for APGAR 1 Minute Score here] off begin
		String randomStringForApgar1MinuteScore = mockNeat
				.strings()
				.get();
		newEntity.setApgar1MinuteScore(randomStringForApgar1MinuteScore);
		// % protected region % [Add customisation for APGAR 1 Minute Score here] end
		// % protected region % [Add customisation for APGAR 5 Minute Score here] off begin
		String randomStringForApgar5MinuteScore = mockNeat
				.strings()
				.get();
		newEntity.setApgar5MinuteScore(randomStringForApgar5MinuteScore);
		// % protected region % [Add customisation for APGAR 5 Minute Score here] end
		// % protected region % [Add customisation for APGAR 10 Minute Score here] off begin
		String randomStringForApgar10MinuteScore = mockNeat
				.strings()
				.get();
		newEntity.setApgar10MinuteScore(randomStringForApgar10MinuteScore);
		// % protected region % [Add customisation for APGAR 10 Minute Score here] end
		// % protected region % [Add customisation for Pediatric Nurse here] off begin
		String randomStringForPediatricNurse = mockNeat
				.strings()
				.get();
		newEntity.setPediatricNurse(randomStringForPediatricNurse);
		// % protected region % [Add customisation for Pediatric Nurse here] end
		// % protected region % [Add customisation for Patient Id here] off begin
		String randomStringForPatientId = mockNeat
				.strings()
				.get();
		newEntity.setPatientId(randomStringForPatientId);
		// % protected region % [Add customisation for Patient Id here] end
		// % protected region % [Add customisation for Registration Id here] off begin
		String randomStringForRegistrationId = mockNeat
				.strings()
				.get();
		newEntity.setRegistrationId(randomStringForRegistrationId);
		// % protected region % [Add customisation for Registration Id here] end

		// % protected region % [Apply any additional logic for newbornDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for newbornDetailWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDelivery Medical Examination Record here] off begin
			var deliveryMedicalExaminationRecordFactory = new DeliveryMedicalExaminationRecordFactory();
			newEntity.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDelivery Medical Examination Record here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Vital Signs here] off begin
			// Outgoing one to many reference
			var vitalSignsFactory = new VitalSignsFactory();
			newEntity.setVitalSigns(Collections.singletonList(vitalSignsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Vital Signs here] end

		}

		// % protected region % [Apply any additional logic for newbornDetail with ref here] off begin
		// % protected region % [Apply any additional logic for newbornDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<NewbornDetailEntity> getObjectType() {
		return NewbornDetailEntity.class;
	}
}