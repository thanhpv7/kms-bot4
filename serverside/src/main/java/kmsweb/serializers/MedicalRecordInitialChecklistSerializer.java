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
package kmsweb.serializers;

import kmsweb.entities.MedicalRecordInitialChecklistEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class MedicalRecordInitialChecklistSerializer extends AbstractSerializer<MedicalRecordInitialChecklistEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public MedicalRecordInitialChecklistSerializer() {
		super(MedicalRecordInitialChecklistEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(MedicalRecordInitialChecklistEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeBooleanField(gen, "outVitalSign", value.getOutVitalSign());
		writeBooleanField(gen, "outAnamnesis", value.getOutAnamnesis());
		writeBooleanField(gen, "outPhysicalExamination", value.getOutPhysicalExamination());
		writeBooleanField(gen, "outDiagnosis", value.getOutDiagnosis());
		writeBooleanField(gen, "outDismissalType", value.getOutDismissalType());
		writeBooleanField(gen, "outDismissalDateAndTime", value.getOutDismissalDateAndTime());
		writeBooleanField(gen, "inpVitalSign", value.getInpVitalSign());
		writeBooleanField(gen, "inpDailyCareDoctorNotes", value.getInpDailyCareDoctorNotes());
		writeBooleanField(gen, "inpDailyCareDoctorNotesNA", value.getInpDailyCareDoctorNotesNA());
		writeBooleanField(gen, "inpDailyCareNursingNotes", value.getInpDailyCareNursingNotes());
		writeBooleanField(gen, "inpDailyCareNursingNotesNA", value.getInpDailyCareNursingNotesNA());
		writeBooleanField(gen, "inpDailyCareProgressNotes", value.getInpDailyCareProgressNotes());
		writeBooleanField(gen, "inpDailyCareProgressNotesNA", value.getInpDailyCareProgressNotesNA());
		writeBooleanField(gen, "inpDismissalDiagnosis", value.getInpDismissalDiagnosis());
		writeBooleanField(gen, "inpDismissalType", value.getInpDismissalType());
		writeBooleanField(gen, "inpDismissalDateAndTime", value.getInpDismissalDateAndTime());
		writeBooleanField(gen, "inpDismissalCondition", value.getInpDismissalCondition());
		writeBooleanField(gen, "drAdmissionDiagnosis", value.getDrAdmissionDiagnosis());
		writeBooleanField(gen, "drObservationDoctorNotes", value.getDrObservationDoctorNotes());
		writeBooleanField(gen, "drObservationDoctorNotesNA", value.getDrObservationDoctorNotesNA());
		writeBooleanField(gen, "drObservationNursingNotes", value.getDrObservationNursingNotes());
		writeBooleanField(gen, "drObservationNursingNotesNA", value.getDrObservationNursingNotesNA());
		writeBooleanField(gen, "drObservationProgressNotes", value.getDrObservationProgressNotes());
		writeBooleanField(gen, "drObservationProgressNotesNA", value.getDrObservationProgressNotesNA());
		writeBooleanField(gen, "drDismissalDiagnosis", value.getDrDismissalDiagnosis());
		writeBooleanField(gen, "drDismissalType", value.getDrDismissalType());
		writeBooleanField(gen, "drDismissalDateAndTime", value.getDrDismissalDateAndTime());
		writeBooleanField(gen, "otPreOperativeDiagnosis", value.getOtPreOperativeDiagnosis());
		writeBooleanField(gen, "otPreOperativeNotesSurgery", value.getOtPreOperativeNotesSurgery());
		writeBooleanField(gen, "otPreOperativeNotesAnaesthesiology", value.getOtPreOperativeNotesAnaesthesiology());
		writeBooleanField(gen, "otIntraOperativeNotesSurgery", value.getOtIntraOperativeNotesSurgery());
		writeBooleanField(gen, "otIntraOperativeNotesAnaesthesiology", value.getOtIntraOperativeNotesAnaesthesiology());
		writeBooleanField(gen, "otPostOperativeNotesSurgery", value.getOtPostOperativeNotesSurgery());
		writeBooleanField(gen, "otPostOperativeNotesAnaesthesiology", value.getOtPostOperativeNotesAnaesthesiology());
		writeBooleanField(gen, "otPostOperativeDiagnosis", value.getOtPostOperativeDiagnosis());
		writeBooleanField(gen, "otDismissalType", value.getOtDismissalType());
		writeBooleanField(gen, "otDismissalDateAndTime", value.getOtDismissalDateAndTime());
		writeBooleanField(gen, "dsResponsibleStaff", value.getDsResponsibleStaff());
		writeBooleanField(gen, "dsInterpretation", value.getDsInterpretation());
		writeStringField(gen, "notes", value.getNotes());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}