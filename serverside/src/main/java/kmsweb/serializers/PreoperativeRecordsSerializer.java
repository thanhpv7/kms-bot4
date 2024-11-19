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

import kmsweb.entities.PreoperativeRecordsEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class PreoperativeRecordsSerializer extends AbstractSerializer<PreoperativeRecordsEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public PreoperativeRecordsSerializer() {
		super(PreoperativeRecordsEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(PreoperativeRecordsEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeOffsetDateTimeField(gen, "startDateTime", value.getStartDateTime());
		writeOffsetDateTimeField(gen, "endDateTime", value.getEndDateTime());
		writeStringField(gen, "physicalStatusEvaluation", value.getPhysicalStatusEvaluation());
		writeStringField(gen, "surgeryRisk", value.getSurgeryRisk());
		writeStringField(gen, "psychologicalState", value.getPsychologicalState());
		writeStringField(gen, "anesthesiaSurgeryRisk", value.getAnesthesiaSurgeryRisk());
		writeStringField(gen, "preoperativeEvaluation", value.getPreoperativeEvaluation());
		writeStringField(gen, "anesthesiaNotes", value.getAnesthesiaNotes());
		writeStringField(gen, "surgicalSpecialty", value.getSurgicalSpecialty());
		writeStringField(gen, "antibioticProphylaxisGiven", value.getAntibioticProphylaxisGiven());
		writeStringField(gen, "surgeryType", value.getSurgeryType());
		writeStringField(gen, "surgeryClass", value.getSurgeryClass());
		writeStringField(gen, "surgicalSurgeryRisk", value.getSurgicalSurgeryRisk());
		writeStringField(gen, "physicalStatusClassification", value.getPhysicalStatusClassification());
		writeStringField(gen, "preSurgeryDiagnosis", value.getPreSurgeryDiagnosis());
		writeStringField(gen, "preoperativeInstructions", value.getPreoperativeInstructions());
		writeStringField(gen, "preoperativeSurgicalNotes", value.getPreoperativeSurgicalNotes());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}