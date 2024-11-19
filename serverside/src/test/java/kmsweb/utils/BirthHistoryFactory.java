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
import kmsweb.entities.BirthHistoryEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BirthHistoryFactory implements FactoryBean<BirthHistoryEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BirthHistoryEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BirthHistoryEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BirthHistoryEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for birthHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryWithNoRef before the main body here] end

		BirthHistoryEntity newEntity = new BirthHistoryEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Gestational Age Weeks here] off begin
		newEntity.setGestationalAgeWeeks(mockNeat.ints().get());
		// % protected region % [Add customisation for Gestational Age Weeks here] end
		// % protected region % [Add customisation for Gestational Age Days here] off begin
		newEntity.setGestationalAgeDays(mockNeat.ints().get());
		// % protected region % [Add customisation for Gestational Age Days here] end
		// % protected region % [Add customisation for Delivery Type here] off begin
		String randomStringForDeliveryType = mockNeat
				.strings()
				.get();
		newEntity.setDeliveryType(randomStringForDeliveryType);
		// % protected region % [Add customisation for Delivery Type here] end
		// % protected region % [Add customisation for Length here] off begin
		newEntity.setLength(mockNeat.doubles().get());
		// % protected region % [Add customisation for Length here] end
		// % protected region % [Add customisation for Length Unit here] off begin
		String randomStringForLengthUnit = mockNeat
				.strings()
				.get();
		newEntity.setLengthUnit(randomStringForLengthUnit);
		// % protected region % [Add customisation for Length Unit here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Weight Unit here] off begin
		String randomStringForWeightUnit = mockNeat
				.strings()
				.get();
		newEntity.setWeightUnit(randomStringForWeightUnit);
		// % protected region % [Add customisation for Weight Unit here] end
		// % protected region % [Add customisation for Head Circumference Birth here] off begin
		newEntity.setHeadCircumferenceBirth(mockNeat.doubles().get());
		// % protected region % [Add customisation for Head Circumference Birth here] end
		// % protected region % [Add customisation for Head Circumference Birth Unit here] off begin
		String randomStringForHeadCircumferenceBirthUnit = mockNeat
				.strings()
				.get();
		newEntity.setHeadCircumferenceBirthUnit(randomStringForHeadCircumferenceBirthUnit);
		// % protected region % [Add customisation for Head Circumference Birth Unit here] end
		// % protected region % [Add customisation for Chest Circumference here] off begin
		newEntity.setChestCircumference(mockNeat.doubles().get());
		// % protected region % [Add customisation for Chest Circumference here] end
		// % protected region % [Add customisation for Chest Circumference Unit here] off begin
		String randomStringForChestCircumferenceUnit = mockNeat
				.strings()
				.get();
		newEntity.setChestCircumferenceUnit(randomStringForChestCircumferenceUnit);
		// % protected region % [Add customisation for Chest Circumference Unit here] end
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
		// % protected region % [Add customisation for Pediatric Case here] off begin
		String randomStringForPediatricCase = mockNeat
				.strings()
				.get();
		newEntity.setPediatricCase(randomStringForPediatricCase);
		// % protected region % [Add customisation for Pediatric Case here] end
		// % protected region % [Add customisation for Food Type here] off begin
		String randomStringForFoodType = mockNeat
				.strings()
				.get();
		newEntity.setFoodType(randomStringForFoodType);
		// % protected region % [Add customisation for Food Type here] end
		// % protected region % [Add customisation for Head Circumference here] off begin
		newEntity.setHeadCircumference(mockNeat.doubles().get());
		// % protected region % [Add customisation for Head Circumference here] end
		// % protected region % [Add customisation for Head Circumference Unit here] off begin
		String randomStringForHeadCircumferenceUnit = mockNeat
				.strings()
				.get();
		newEntity.setHeadCircumferenceUnit(randomStringForHeadCircumferenceUnit);
		// % protected region % [Add customisation for Head Circumference Unit here] end
		// % protected region % [Add customisation for Upper Arm Circumference here] off begin
		newEntity.setUpperArmCircumference(mockNeat.doubles().get());
		// % protected region % [Add customisation for Upper Arm Circumference here] end
		// % protected region % [Add customisation for Upper Arm Circumference Unit here] off begin
		String randomStringForUpperArmCircumferenceUnit = mockNeat
				.strings()
				.get();
		newEntity.setUpperArmCircumferenceUnit(randomStringForUpperArmCircumferenceUnit);
		// % protected region % [Add customisation for Upper Arm Circumference Unit here] end
		// % protected region % [Add customisation for Action Taken here] off begin
		String randomStringForActionTaken = mockNeat
				.strings()
				.get();
		newEntity.setActionTaken(randomStringForActionTaken);
		// % protected region % [Add customisation for Action Taken here] end
		// % protected region % [Add customisation for Weight Gestational Age here] off begin
		String randomStringForWeightGestationalAge = mockNeat
				.strings()
				.get();
		newEntity.setWeightGestationalAge(randomStringForWeightGestationalAge);
		// % protected region % [Add customisation for Weight Gestational Age here] end

		// % protected region % [Apply any additional logic for birthHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for birthHistoryWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
		}

		// % protected region % [Apply any additional logic for birthHistory with ref here] off begin
		// % protected region % [Apply any additional logic for birthHistory with ref here] end

		return newEntity;
	}

	@Override
	public Class<BirthHistoryEntity> getObjectType() {
		return BirthHistoryEntity.class;
	}
}