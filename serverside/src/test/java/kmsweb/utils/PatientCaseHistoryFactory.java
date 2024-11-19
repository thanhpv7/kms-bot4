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
import kmsweb.entities.PatientCaseHistoryEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientCaseHistoryFactory implements FactoryBean<PatientCaseHistoryEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientCaseHistoryEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientCaseHistoryEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientCaseHistoryEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientCaseHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryWithNoRef before the main body here] end

		PatientCaseHistoryEntity newEntity = new PatientCaseHistoryEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Allergy here] off begin
		String randomStringForAllergy = mockNeat
				.strings()
				.get();
		newEntity.setAllergy(randomStringForAllergy);
		// % protected region % [Add customisation for Allergy here] end
		// % protected region % [Add customisation for Disability Notes here] off begin
		String randomStringForDisabilityNotes = mockNeat
				.strings()
				.get();
		newEntity.setDisabilityNotes(randomStringForDisabilityNotes);
		// % protected region % [Add customisation for Disability Notes here] end
		// % protected region % [Add customisation for History of Disease here] off begin
		String randomStringForHistoryOfDisease = mockNeat
				.strings()
				.get();
		newEntity.setHistoryOfDisease(randomStringForHistoryOfDisease);
		// % protected region % [Add customisation for History of Disease here] end
		// % protected region % [Add customisation for Case History Date Time here] off begin
		newEntity.setCaseHistoryDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Case History Date Time here] end
		// % protected region % [Add customisation for Patient Habits here] off begin
		String randomStringForPatientHabits = mockNeat
				.strings()
				.get();
		newEntity.setPatientHabits(randomStringForPatientHabits);
		// % protected region % [Add customisation for Patient Habits here] end
		// % protected region % [Add customisation for Nutrition HIstory here] off begin
		String randomStringForNutritionHIstory = mockNeat
				.strings()
				.get();
		newEntity.setNutritionHIstory(randomStringForNutritionHIstory);
		// % protected region % [Add customisation for Nutrition HIstory here] end
		// % protected region % [Add customisation for Family History here] off begin
		String randomStringForFamilyHistory = mockNeat
				.strings()
				.get();
		newEntity.setFamilyHistory(randomStringForFamilyHistory);
		// % protected region % [Add customisation for Family History here] end

		// % protected region % [Apply any additional logic for patientCaseHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistoryWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Information here] off begin
			var patientGeneralInformationFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInformation(patientGeneralInformationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient General Information here] end

		}

		// % protected region % [Apply any additional logic for patientCaseHistory with ref here] off begin
		// % protected region % [Apply any additional logic for patientCaseHistory with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientCaseHistoryEntity> getObjectType() {
		return PatientCaseHistoryEntity.class;
	}
}