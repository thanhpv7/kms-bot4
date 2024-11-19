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
import kmsweb.entities.ObstetricAndGynecologyHistoryEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class ObstetricAndGynecologyHistoryFactory implements FactoryBean<ObstetricAndGynecologyHistoryEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public ObstetricAndGynecologyHistoryEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public ObstetricAndGynecologyHistoryEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public ObstetricAndGynecologyHistoryEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryWithNoRef before the main body here] end

		ObstetricAndGynecologyHistoryEntity newEntity = new ObstetricAndGynecologyHistoryEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Pregnancy History Gravida here] off begin
		String randomStringForPregnancyHistoryGravida = mockNeat
				.strings()
				.get();
		newEntity.setPregnancyHistoryGravida(randomStringForPregnancyHistoryGravida);
		// % protected region % [Add customisation for Pregnancy History Gravida here] end
		// % protected region % [Add customisation for Patient History Para here] off begin
		String randomStringForPatientHistoryPara = mockNeat
				.strings()
				.get();
		newEntity.setPatientHistoryPara(randomStringForPatientHistoryPara);
		// % protected region % [Add customisation for Patient History Para here] end
		// % protected region % [Add customisation for Patient History Abortus here] off begin
		String randomStringForPatientHistoryAbortus = mockNeat
				.strings()
				.get();
		newEntity.setPatientHistoryAbortus(randomStringForPatientHistoryAbortus);
		// % protected region % [Add customisation for Patient History Abortus here] end
		// % protected region % [Add customisation for Pregnancy History Notes here] off begin
		String randomStringForPregnancyHistoryNotes = mockNeat
				.strings()
				.get();
		newEntity.setPregnancyHistoryNotes(randomStringForPregnancyHistoryNotes);
		// % protected region % [Add customisation for Pregnancy History Notes here] end
		// % protected region % [Add customisation for Age of Menarche here] off begin
		String randomStringForAgeOfMenarche = mockNeat
				.strings()
				.get();
		newEntity.setAgeOfMenarche(randomStringForAgeOfMenarche);
		// % protected region % [Add customisation for Age of Menarche here] end
		// % protected region % [Add customisation for Age of First Sexual Contact here] off begin
		String randomStringForAgeOfFirstSexualContact = mockNeat
				.strings()
				.get();
		newEntity.setAgeOfFirstSexualContact(randomStringForAgeOfFirstSexualContact);
		// % protected region % [Add customisation for Age of First Sexual Contact here] end
		// % protected region % [Add customisation for Start Date here] off begin
		newEntity.setStartDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date here] end
		// % protected region % [Add customisation for End Date here] off begin
		newEntity.setEndDate(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date here] end
		// % protected region % [Add customisation for Approximate Birth Date here] off begin
		newEntity.setApproximateBirthDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Approximate Birth Date here] end
		// % protected region % [Add customisation for Gestation Age Weeks here] off begin
		String randomStringForGestationAgeWeeks = mockNeat
				.strings()
				.get();
		newEntity.setGestationAgeWeeks(randomStringForGestationAgeWeeks);
		// % protected region % [Add customisation for Gestation Age Weeks here] end
		// % protected region % [Add customisation for Gestation Age Days here] off begin
		String randomStringForGestationAgeDays = mockNeat
				.strings()
				.get();
		newEntity.setGestationAgeDays(randomStringForGestationAgeDays);
		// % protected region % [Add customisation for Gestation Age Days here] end
		// % protected region % [Add customisation for Maternity History here] off begin
		String randomStringForMaternityHistory = mockNeat
				.strings()
				.get();
		newEntity.setMaternityHistory(randomStringForMaternityHistory);
		// % protected region % [Add customisation for Maternity History here] end
		// % protected region % [Add customisation for Gynecology History here] off begin
		String randomStringForGynecologyHistory = mockNeat
				.strings()
				.get();
		newEntity.setGynecologyHistory(randomStringForGynecologyHistory);
		// % protected region % [Add customisation for Gynecology History here] end
		// % protected region % [Add customisation for Family Plan History here] off begin
		String randomStringForFamilyPlanHistory = mockNeat
				.strings()
				.get();
		newEntity.setFamilyPlanHistory(randomStringForFamilyPlanHistory);
		// % protected region % [Add customisation for Family Plan History here] end
		// % protected region % [Add customisation for Other Notes here] off begin
		String randomStringForOtherNotes = mockNeat
				.strings()
				.get();
		newEntity.setOtherNotes(randomStringForOtherNotes);
		// % protected region % [Add customisation for Other Notes here] end
		// % protected region % [Add customisation for Education Level of Patient here] off begin
		String randomStringForEducationLevelOfPatient = mockNeat
				.strings()
				.get();
		newEntity.setEducationLevelOfPatient(randomStringForEducationLevelOfPatient);
		// % protected region % [Add customisation for Education Level of Patient here] end
		// % protected region % [Add customisation for Name of Husband or Wife here] off begin
		String randomStringForNameOfHusbandOrWife = mockNeat
				.strings()
				.get();
		newEntity.setNameOfHusbandOrWife(randomStringForNameOfHusbandOrWife);
		// % protected region % [Add customisation for Name of Husband or Wife here] end
		// % protected region % [Add customisation for Education Level of Husband or Wife here] off begin
		String randomStringForEducationLevelOfHusbandOrWife = mockNeat
				.strings()
				.get();
		newEntity.setEducationLevelOfHusbandOrWife(randomStringForEducationLevelOfHusbandOrWife);
		// % protected region % [Add customisation for Education Level of Husband or Wife here] end
		// % protected region % [Add customisation for Occupation of Husband or Wife here] off begin
		String randomStringForOccupationOfHusbandOrWife = mockNeat
				.strings()
				.get();
		newEntity.setOccupationOfHusbandOrWife(randomStringForOccupationOfHusbandOrWife);
		// % protected region % [Add customisation for Occupation of Husband or Wife here] end
		// % protected region % [Add customisation for Rupture Of Membrane here] off begin
		newEntity.setRuptureOfMembrane(OffsetDateTime.now());
		// % protected region % [Add customisation for Rupture Of Membrane here] end

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
		}

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistory with ref here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistory with ref here] end

		return newEntity;
	}

	@Override
	public Class<ObstetricAndGynecologyHistoryEntity> getObjectType() {
		return ObstetricAndGynecologyHistoryEntity.class;
	}
}