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
import kmsweb.entities.DailyCareCPPTEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class DailyCareCPPTFactory implements FactoryBean<DailyCareCPPTEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public DailyCareCPPTEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public DailyCareCPPTEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public DailyCareCPPTEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for dailyCareCPPTWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTWithNoRef before the main body here] end

		DailyCareCPPTEntity newEntity = new DailyCareCPPTEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Subjective here] off begin
		String randomStringForSubjective = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setSubjective(randomStringForSubjective);
		// % protected region % [Add customisation for Subjective here] end
		// % protected region % [Add customisation for Objective here] off begin
		String randomStringForObjective = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setObjective(randomStringForObjective);
		// % protected region % [Add customisation for Objective here] end
		// % protected region % [Add customisation for Diagnose here] off begin
		String randomStringForDiagnose = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setDiagnose(randomStringForDiagnose);
		// % protected region % [Add customisation for Diagnose here] end
		// % protected region % [Add customisation for Plan here] off begin
		String randomStringForPlan = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setPlan(randomStringForPlan);
		// % protected region % [Add customisation for Plan here] end
		// % protected region % [Add customisation for Instruction here] off begin
		String randomStringForInstruction = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setInstruction(randomStringForInstruction);
		// % protected region % [Add customisation for Instruction here] end
		// % protected region % [Add customisation for Verified Date here] off begin
		newEntity.setVerifiedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Verified Date here] end
		// % protected region % [Add customisation for Verified By here] off begin
		String randomStringForVerifiedBy = mockNeat
				.strings()
				.get();
		newEntity.setVerifiedBy(randomStringForVerifiedBy);
		// % protected region % [Add customisation for Verified By here] end
		// % protected region % [Add customisation for Canceled Date here] off begin
		newEntity.setCanceledDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Canceled Date here] end
		// % protected region % [Add customisation for Canceled By here] off begin
		String randomStringForCanceledBy = mockNeat
				.strings()
				.get();
		newEntity.setCanceledBy(randomStringForCanceledBy);
		// % protected region % [Add customisation for Canceled By here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringForStatus = mockNeat
				.strings()
				.get();
		newEntity.setStatus(randomStringForStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for CPPT Date Time here] off begin
		newEntity.setCpptDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for CPPT Date Time here] end

		// % protected region % [Apply any additional logic for dailyCareCPPTWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 10 here] off begin
			var icd10Factory = new DiagnosesAndProceduresFactory();
			newEntity.setIcd10(icd10Factory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 10 here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 9 CM here] off begin
			var icd9CMFactory = new DiagnosesAndProceduresFactory();
			newEntity.setIcd9CM(icd9CMFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 9 CM here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyCreated By Staff here] off begin
			var createdByStaffFactory = new StaffFactory();
			newEntity.setCreatedByStaff(createdByStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyCreated By Staff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDoctor in Charge here] off begin
			var doctorInChargeFactory = new StaffFactory();
			newEntity.setDoctorInCharge(doctorInChargeFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDoctor in Charge here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Transcriber here] off begin
			var medicalTranscriberFactory = new StaffFactory();
			newEntity.setMedicalTranscriber(medicalTranscriberFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Transcriber here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Examination Record here] off begin
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Examination Record here] end

		}

		// % protected region % [Apply any additional logic for dailyCareCPPT with ref here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPT with ref here] end

		return newEntity;
	}

	@Override
	public Class<DailyCareCPPTEntity> getObjectType() {
		return DailyCareCPPTEntity.class;
	}
}