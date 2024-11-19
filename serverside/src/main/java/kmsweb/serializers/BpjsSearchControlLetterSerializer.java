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

import kmsweb.entities.BpjsSearchControlLetterEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class BpjsSearchControlLetterSerializer extends AbstractSerializer<BpjsSearchControlLetterEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public BpjsSearchControlLetterSerializer() {
		super(BpjsSearchControlLetterEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(BpjsSearchControlLetterEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "controlLetterNo", value.getControlLetterNo());
		writeStringField(gen, "controlPlanDate", value.getControlPlanDate());
		writeStringField(gen, "date", value.getDate());
		writeStringField(gen, "controlType", value.getControlType());
		writeStringField(gen, "polyclinic", value.getPolyclinic());
		writeStringField(gen, "doctor", value.getDoctor());
		writeStringField(gen, "sepNo", value.getSepNo());
		writeStringField(gen, "bpjsCardNo", value.getBpjsCardNo());
		writeStringField(gen, "polyclinicDestination", value.getPolyclinicDestination());
		writeStringField(gen, "doctorDestination", value.getDoctorDestination());
		writeStringField(gen, "polyclinicSource", value.getPolyclinicSource());
		writeStringField(gen, "doctorSource", value.getDoctorSource());
		writeStringField(gen, "sepDate", value.getSepDate());
		writeStringField(gen, "treatmentType", value.getTreatmentType());
		writeStringField(gen, "treatmentClass", value.getTreatmentClass());
		writeStringField(gen, "name", value.getName());
		writeStringField(gen, "gender", value.getGender());
		writeStringField(gen, "dateOfBirth", value.getDateOfBirth());
		writeStringField(gen, "provider", value.getProvider());
		writeStringField(gen, "referralProvider", value.getReferralProvider());
		writeStringField(gen, "referralSource", value.getReferralSource());
		writeStringField(gen, "referralNo", value.getReferralNo());
		writeStringField(gen, "referralDate", value.getReferralDate());
		writeStringField(gen, "diagnose", value.getDiagnose());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}