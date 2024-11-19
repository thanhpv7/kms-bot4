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
import kmsweb.entities.EmergencyMedicalExaminationRecordEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class EmergencyMedicalExaminationRecordFactory implements FactoryBean<EmergencyMedicalExaminationRecordEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public EmergencyMedicalExaminationRecordEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public EmergencyMedicalExaminationRecordEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public EmergencyMedicalExaminationRecordEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordWithNoRef before the main body here] end

		EmergencyMedicalExaminationRecordEntity newEntity = new EmergencyMedicalExaminationRecordEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Surgical Or Non Surgical here] off begin
		String randomStringForSurgicalOrNonSurgical = mockNeat
				.strings()
				.get();
		newEntity.setSurgicalOrNonSurgical(randomStringForSurgicalOrNonSurgical);
		// % protected region % [Add customisation for Surgical Or Non Surgical here] end
		// % protected region % [Add customisation for Case Specification here] off begin
		String randomStringForCaseSpecification = mockNeat
				.strings()
				.get();
		newEntity.setCaseSpecification(randomStringForCaseSpecification);
		// % protected region % [Add customisation for Case Specification here] end
		// % protected region % [Add customisation for Accident Type here] off begin
		String randomStringForAccidentType = mockNeat
				.strings()
				.get();
		newEntity.setAccidentType(randomStringForAccidentType);
		// % protected region % [Add customisation for Accident Type here] end
		// % protected region % [Add customisation for Accident Cause here] off begin
		String randomStringForAccidentCause = mockNeat
				.strings()
				.get();
		newEntity.setAccidentCause(randomStringForAccidentCause);
		// % protected region % [Add customisation for Accident Cause here] end
		// % protected region % [Add customisation for Emergency Level here] off begin
		String randomStringForEmergencyLevel = mockNeat
				.strings()
				.get();
		newEntity.setEmergencyLevel(randomStringForEmergencyLevel);
		// % protected region % [Add customisation for Emergency Level here] end
		// % protected region % [Add customisation for Date Time of Instructions here] off begin
		newEntity.setDateTimeOfInstructions(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Time of Instructions here] end
		// % protected region % [Add customisation for Is Doctor Taking Over here] off begin
		newEntity.setIsDoctorTakingOver(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Doctor Taking Over here] end
		// % protected region % [Add customisation for Date Time of Drug Administration here] off begin
		newEntity.setDateTimeOfDrugAdministration(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Time of Drug Administration here] end
		// % protected region % [Add customisation for Is Autopay here] off begin
		newEntity.setIsAutopay(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Autopay here] end
		// % protected region % [Add customisation for Response Time here] off begin
		newEntity.setResponseTime(mockNeat.ints().get());
		// % protected region % [Add customisation for Response Time here] end

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecordWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
		}

		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecord with ref here] off begin
		// % protected region % [Apply any additional logic for emergencyMedicalExaminationRecord with ref here] end

		return newEntity;
	}

	@Override
	public Class<EmergencyMedicalExaminationRecordEntity> getObjectType() {
		return EmergencyMedicalExaminationRecordEntity.class;
	}
}