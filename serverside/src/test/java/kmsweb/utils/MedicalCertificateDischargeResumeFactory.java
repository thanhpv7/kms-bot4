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
import kmsweb.entities.MedicalCertificateDischargeResumeEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class MedicalCertificateDischargeResumeFactory implements FactoryBean<MedicalCertificateDischargeResumeEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public MedicalCertificateDischargeResumeEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public MedicalCertificateDischargeResumeEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public MedicalCertificateDischargeResumeEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeWithNoRef before the main body here] end

		MedicalCertificateDischargeResumeEntity newEntity = new MedicalCertificateDischargeResumeEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date Time here] off begin
		newEntity.setAdmissionDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date Time here] end
		// % protected region % [Add customisation for Discharge Date Time here] off begin
		newEntity.setDischargeDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Discharge Date Time here] end
		// % protected region % [Add customisation for Condition here] off begin
		String randomStringForCondition = mockNeat
				.strings()
				.get();
		newEntity.setCondition(randomStringForCondition);
		// % protected region % [Add customisation for Condition here] end
		// % protected region % [Add customisation for Main Diagnosis here] off begin
		String randomStringForMainDiagnosis = mockNeat
				.strings()
				.get();
		newEntity.setMainDiagnosis(randomStringForMainDiagnosis);
		// % protected region % [Add customisation for Main Diagnosis here] end
		// % protected region % [Add customisation for Action here] off begin
		String randomStringForAction = mockNeat
				.strings()
				.get();
		newEntity.setAction(randomStringForAction);
		// % protected region % [Add customisation for Action here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResumeWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] off begin
			// Incoming One to One reference
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] end
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDischarge ICD 10 here] off begin
			var dischargeICD10Factory = new DiagnosesAndProceduresFactory();
			newEntity.setDischargeICD10(dischargeICD10Factory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDischarge ICD 10 here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDischarge ICD 9 CM here] off begin
			var dischargeICD9CMFactory = new DiagnosesAndProceduresFactory();
			newEntity.setDischargeICD9CM(dischargeICD9CMFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDischarge ICD 9 CM here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Staff here] off begin
			var medicalStaffFactory = new StaffFactory();
			newEntity.setMedicalStaff(medicalStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Staff here] end

		}

		// % protected region % [Apply any additional logic for medicalCertificateDischargeResume with ref here] off begin
		// % protected region % [Apply any additional logic for medicalCertificateDischargeResume with ref here] end

		return newEntity;
	}

	@Override
	public Class<MedicalCertificateDischargeResumeEntity> getObjectType() {
		return MedicalCertificateDischargeResumeEntity.class;
	}
}