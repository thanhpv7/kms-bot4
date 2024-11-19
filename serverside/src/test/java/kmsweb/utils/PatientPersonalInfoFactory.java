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
import kmsweb.entities.PatientPersonalInfoEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientPersonalInfoFactory implements FactoryBean<PatientPersonalInfoEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientPersonalInfoEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientPersonalInfoEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientPersonalInfoEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientPersonalInfoWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoWithNoRef before the main body here] end

		PatientPersonalInfoEntity newEntity = new PatientPersonalInfoEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Religion here] off begin
		String randomStringForReligion = mockNeat
				.strings()
				.get();
		newEntity.setReligion(randomStringForReligion);
		// % protected region % [Add customisation for Religion here] end
		// % protected region % [Add customisation for Nationality here] off begin
		String randomStringForNationality = mockNeat
				.strings()
				.get();
		newEntity.setNationality(randomStringForNationality);
		// % protected region % [Add customisation for Nationality here] end
		// % protected region % [Add customisation for Ethnicity here] off begin
		String randomStringForEthnicity = mockNeat
				.strings()
				.get();
		newEntity.setEthnicity(randomStringForEthnicity);
		// % protected region % [Add customisation for Ethnicity here] end
		// % protected region % [Add customisation for Blood Type here] off begin
		newEntity.setBloodType(BloodTypeEnum.A);
		// % protected region % [Add customisation for Blood Type here] end
		// % protected region % [Add customisation for Rhesus here] off begin
		newEntity.setRhesus(RhesusEnum.POSITIVE);
		// % protected region % [Add customisation for Rhesus here] end
		// % protected region % [Add customisation for ID Number here] off begin
		String randomStringForIdNumber = mockNeat
				.strings()
				.get();
		newEntity.setIdNumber(randomStringForIdNumber);
		// % protected region % [Add customisation for ID Number here] end
		// % protected region % [Add customisation for Occupation here] off begin
		String randomStringForOccupation = mockNeat
				.strings()
				.get();
		newEntity.setOccupation(randomStringForOccupation);
		// % protected region % [Add customisation for Occupation here] end
		// % protected region % [Add customisation for External Patient here] off begin
		newEntity.setExternalPatient(mockNeat.bools().get());
		// % protected region % [Add customisation for External Patient here] end
		// % protected region % [Add customisation for Is Dead here] off begin
		newEntity.setIsDead(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Dead here] end
		// % protected region % [Add customisation for External Notes here] off begin
		String randomStringForExternalNotes = mockNeat
				.strings()
				.get();
		newEntity.setExternalNotes(randomStringForExternalNotes);
		// % protected region % [Add customisation for External Notes here] end
		// % protected region % [Add customisation for Other ID Number here] off begin
		String randomStringForOtherIDNumber = mockNeat
				.strings()
				.get();
		newEntity.setOtherIDNumber(randomStringForOtherIDNumber);
		// % protected region % [Add customisation for Other ID Number here] end

		// % protected region % [Apply any additional logic for patientPersonalInfoWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfoWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Information here] off begin
			// Incoming One to One reference
			var patientGeneralInformationFactory = new PatientGeneralInfoFactory();
			newEntity.setPatientGeneralInformation(patientGeneralInformationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Patient General Information here] end
		}

		// % protected region % [Apply any additional logic for patientPersonalInfo with ref here] off begin
		// % protected region % [Apply any additional logic for patientPersonalInfo with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientPersonalInfoEntity> getObjectType() {
		return PatientPersonalInfoEntity.class;
	}
}