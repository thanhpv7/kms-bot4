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
import kmsweb.entities.MedicalRecordInitialChecklistEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class MedicalRecordInitialChecklistFactory implements FactoryBean<MedicalRecordInitialChecklistEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public MedicalRecordInitialChecklistEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public MedicalRecordInitialChecklistEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public MedicalRecordInitialChecklistEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistWithNoRef before the main body here] end

		MedicalRecordInitialChecklistEntity newEntity = new MedicalRecordInitialChecklistEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Out Vital Sign here] off begin
		newEntity.setOutVitalSign(mockNeat.bools().get());
		// % protected region % [Add customisation for Out Vital Sign here] end
		// % protected region % [Add customisation for Out Anamnesis here] off begin
		newEntity.setOutAnamnesis(mockNeat.bools().get());
		// % protected region % [Add customisation for Out Anamnesis here] end
		// % protected region % [Add customisation for Out Physical Examination here] off begin
		newEntity.setOutPhysicalExamination(mockNeat.bools().get());
		// % protected region % [Add customisation for Out Physical Examination here] end
		// % protected region % [Add customisation for Out Diagnosis here] off begin
		newEntity.setOutDiagnosis(mockNeat.bools().get());
		// % protected region % [Add customisation for Out Diagnosis here] end
		// % protected region % [Add customisation for Out Dismissal Type here] off begin
		newEntity.setOutDismissalType(mockNeat.bools().get());
		// % protected region % [Add customisation for Out Dismissal Type here] end
		// % protected region % [Add customisation for Out Dismissal Date and Time here] off begin
		newEntity.setOutDismissalDateAndTime(mockNeat.bools().get());
		// % protected region % [Add customisation for Out Dismissal Date and Time here] end
		// % protected region % [Add customisation for Inp Vital Sign here] off begin
		newEntity.setInpVitalSign(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Vital Sign here] end
		// % protected region % [Add customisation for Inp Daily Care Doctor Notes here] off begin
		newEntity.setInpDailyCareDoctorNotes(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Doctor Notes here] end
		// % protected region % [Add customisation for Inp Daily Care Doctor Notes NA here] off begin
		newEntity.setInpDailyCareDoctorNotesNA(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Doctor Notes NA here] end
		// % protected region % [Add customisation for Inp Daily Care Nursing Notes here] off begin
		newEntity.setInpDailyCareNursingNotes(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Nursing Notes here] end
		// % protected region % [Add customisation for Inp Daily Care Nursing Notes NA here] off begin
		newEntity.setInpDailyCareNursingNotesNA(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Nursing Notes NA here] end
		// % protected region % [Add customisation for Inp Daily Care Progress Notes here] off begin
		newEntity.setInpDailyCareProgressNotes(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Progress Notes here] end
		// % protected region % [Add customisation for Inp Daily Care Progress Notes NA here] off begin
		newEntity.setInpDailyCareProgressNotesNA(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Daily Care Progress Notes NA here] end
		// % protected region % [Add customisation for Inp Dismissal Diagnosis here] off begin
		newEntity.setInpDismissalDiagnosis(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Dismissal Diagnosis here] end
		// % protected region % [Add customisation for Inp Dismissal Type here] off begin
		newEntity.setInpDismissalType(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Dismissal Type here] end
		// % protected region % [Add customisation for Inp Dismissal Date and Time here] off begin
		newEntity.setInpDismissalDateAndTime(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Dismissal Date and Time here] end
		// % protected region % [Add customisation for Inp Dismissal Condition here] off begin
		newEntity.setInpDismissalCondition(mockNeat.bools().get());
		// % protected region % [Add customisation for Inp Dismissal Condition here] end
		// % protected region % [Add customisation for DR Admission Diagnosis here] off begin
		newEntity.setDrAdmissionDiagnosis(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Admission Diagnosis here] end
		// % protected region % [Add customisation for DR Observation Doctor Notes here] off begin
		newEntity.setDrObservationDoctorNotes(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Observation Doctor Notes here] end
		// % protected region % [Add customisation for DR Observation Doctor Notes NA here] off begin
		newEntity.setDrObservationDoctorNotesNA(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Observation Doctor Notes NA here] end
		// % protected region % [Add customisation for DR Observation Nursing Notes here] off begin
		newEntity.setDrObservationNursingNotes(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Observation Nursing Notes here] end
		// % protected region % [Add customisation for DR Observation Nursing Notes NA here] off begin
		newEntity.setDrObservationNursingNotesNA(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Observation Nursing Notes NA here] end
		// % protected region % [Add customisation for DR Observation Progress Notes here] off begin
		newEntity.setDrObservationProgressNotes(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Observation Progress Notes here] end
		// % protected region % [Add customisation for DR Observation Progress Notes NA here] off begin
		newEntity.setDrObservationProgressNotesNA(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Observation Progress Notes NA here] end
		// % protected region % [Add customisation for DR Dismissal Diagnosis here] off begin
		newEntity.setDrDismissalDiagnosis(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Dismissal Diagnosis here] end
		// % protected region % [Add customisation for DR Dismissal Type here] off begin
		newEntity.setDrDismissalType(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Dismissal Type here] end
		// % protected region % [Add customisation for DR Dismissal Date and Time here] off begin
		newEntity.setDrDismissalDateAndTime(mockNeat.bools().get());
		// % protected region % [Add customisation for DR Dismissal Date and Time here] end
		// % protected region % [Add customisation for OT Pre Operative Diagnosis here] off begin
		newEntity.setOtPreOperativeDiagnosis(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Pre Operative Diagnosis here] end
		// % protected region % [Add customisation for OT Pre Operative Notes Surgery here] off begin
		newEntity.setOtPreOperativeNotesSurgery(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Pre Operative Notes Surgery here] end
		// % protected region % [Add customisation for OT Pre Operative Notes Anaesthesiology here] off begin
		newEntity.setOtPreOperativeNotesAnaesthesiology(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Pre Operative Notes Anaesthesiology here] end
		// % protected region % [Add customisation for OT Intra Operative Notes Surgery here] off begin
		newEntity.setOtIntraOperativeNotesSurgery(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Intra Operative Notes Surgery here] end
		// % protected region % [Add customisation for OT Intra Operative Notes Anaesthesiology here] off begin
		newEntity.setOtIntraOperativeNotesAnaesthesiology(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Intra Operative Notes Anaesthesiology here] end
		// % protected region % [Add customisation for OT Post Operative Notes Surgery here] off begin
		newEntity.setOtPostOperativeNotesSurgery(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Post Operative Notes Surgery here] end
		// % protected region % [Add customisation for OT Post Operative Notes Anaesthesiology here] off begin
		newEntity.setOtPostOperativeNotesAnaesthesiology(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Post Operative Notes Anaesthesiology here] end
		// % protected region % [Add customisation for OT Post Operative Diagnosis here] off begin
		newEntity.setOtPostOperativeDiagnosis(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Post Operative Diagnosis here] end
		// % protected region % [Add customisation for OT Dismissal Type here] off begin
		newEntity.setOtDismissalType(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Dismissal Type here] end
		// % protected region % [Add customisation for OT Dismissal Date and Time here] off begin
		newEntity.setOtDismissalDateAndTime(mockNeat.bools().get());
		// % protected region % [Add customisation for OT Dismissal Date and Time here] end
		// % protected region % [Add customisation for DS Responsible Staff here] off begin
		newEntity.setDsResponsibleStaff(mockNeat.bools().get());
		// % protected region % [Add customisation for DS Responsible Staff here] end
		// % protected region % [Add customisation for DS Interpretation here] off begin
		newEntity.setDsInterpretation(mockNeat.bools().get());
		// % protected region % [Add customisation for DS Interpretation here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklistWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
		}

		// % protected region % [Apply any additional logic for medicalRecordInitialChecklist with ref here] off begin
		// % protected region % [Apply any additional logic for medicalRecordInitialChecklist with ref here] end

		return newEntity;
	}

	@Override
	public Class<MedicalRecordInitialChecklistEntity> getObjectType() {
		return MedicalRecordInitialChecklistEntity.class;
	}
}