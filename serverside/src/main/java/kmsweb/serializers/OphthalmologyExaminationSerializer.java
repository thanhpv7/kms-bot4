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

import kmsweb.entities.OphthalmologyExaminationEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class OphthalmologyExaminationSerializer extends AbstractSerializer<OphthalmologyExaminationEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public OphthalmologyExaminationSerializer() {
		super(OphthalmologyExaminationEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(OphthalmologyExaminationEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "rightEyelidSubjective", value.getRightEyelidSubjective());
		writeStringField(gen, "rightEyelidObjective", value.getRightEyelidObjective());
		writeStringField(gen, "rightPupilSubjective", value.getRightPupilSubjective());
		writeStringField(gen, "rightPupilObjective", value.getRightPupilObjective());
		writeStringField(gen, "rightScleraSubjective", value.getRightScleraSubjective());
		writeStringField(gen, "rightScleraObjective", value.getRightScleraObjective());
		writeStringField(gen, "rightIrisSubjective", value.getRightIrisSubjective());
		writeStringField(gen, "rightIrisObjective", value.getRightIrisObjective());
		writeStringField(gen, "leftEyelidSubjective", value.getLeftEyelidSubjective());
		writeStringField(gen, "leftEyelidObjective", value.getLeftEyelidObjective());
		writeStringField(gen, "leftPupilSubjective", value.getLeftPupilSubjective());
		writeStringField(gen, "leftPupilObjective", value.getLeftPupilObjective());
		writeStringField(gen, "leftScleraSubjective", value.getLeftScleraSubjective());
		writeStringField(gen, "leftScleraObjective", value.getLeftScleraObjective());
		writeStringField(gen, "leftIrisSubjective", value.getLeftIrisSubjective());
		writeStringField(gen, "leftIrisObjective", value.getLeftIrisObjective());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}