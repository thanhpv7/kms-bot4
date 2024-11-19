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

import kmsweb.entities.NewbornDetailEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class NewbornDetailSerializer extends AbstractSerializer<NewbornDetailEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public NewbornDetailSerializer() {
		super(NewbornDetailEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(NewbornDetailEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "newbornFirstName", value.getNewbornFirstName());
		writeStringField(gen, "newbornLastName", value.getNewbornLastName());
		writeOffsetDateTimeField(gen, "dateTimeOfBirth", value.getDateTimeOfBirth());
		writeStringField(gen, "gender", value.getGender());
		writeStringField(gen, "deliveryType", value.getDeliveryType());
		writeStringField(gen, "deliveryTypeIndication", value.getDeliveryTypeIndication());
		writeIntegerField(gen, "weight", value.getWeight());
		writeIntegerField(gen, "length", value.getLength());
		writeStringField(gen, "weightOfGestationalAge", value.getWeightOfGestationalAge());
		writeIntegerField(gen, "headCircumference", value.getHeadCircumference());
		writeIntegerField(gen, "chestCircumference", value.getChestCircumference());
		writeStringField(gen, "birthCondition", value.getBirthCondition());
		writeStringField(gen, "neonatalCase", value.getNeonatalCase());
		writeStringField(gen, "congenitalCondition", value.getCongenitalCondition());
		writeStringField(gen, "physicalExamination", value.getPhysicalExamination());
		writeStringField(gen, "apgar1MinuteAppearance", value.getApgar1MinuteAppearance());
		writeStringField(gen, "apgar5MinuteAppearance", value.getApgar5MinuteAppearance());
		writeStringField(gen, "apgar10MinuteAppearance", value.getApgar10MinuteAppearance());
		writeStringField(gen, "apgar1MinutePulse", value.getApgar1MinutePulse());
		writeStringField(gen, "apgar5MinutePulse", value.getApgar5MinutePulse());
		writeStringField(gen, "apgar10MinutePulse", value.getApgar10MinutePulse());
		writeStringField(gen, "apgar1MinuteGrimace", value.getApgar1MinuteGrimace());
		writeStringField(gen, "apgar5MinuteGrimace", value.getApgar5MinuteGrimace());
		writeStringField(gen, "apgar10MinuteGrimace", value.getApgar10MinuteGrimace());
		writeStringField(gen, "apgar1MinuteActivity", value.getApgar1MinuteActivity());
		writeStringField(gen, "apgar5MinuteActivity", value.getApgar5MinuteActivity());
		writeStringField(gen, "apgar10MinuteActivity", value.getApgar10MinuteActivity());
		writeStringField(gen, "apgar1MinuteRespiration", value.getApgar1MinuteRespiration());
		writeStringField(gen, "apgar5MinuteRespiration", value.getApgar5MinuteRespiration());
		writeStringField(gen, "apgar10MinuteRespiration", value.getApgar10MinuteRespiration());
		writeStringField(gen, "apgar1MinuteScore", value.getApgar1MinuteScore());
		writeStringField(gen, "apgar5MinuteScore", value.getApgar5MinuteScore());
		writeStringField(gen, "apgar10MinuteScore", value.getApgar10MinuteScore());
		writeStringField(gen, "pediatricNurse", value.getPediatricNurse());
		writeStringField(gen, "patientId", value.getPatientId());
		writeStringField(gen, "registrationId", value.getRegistrationId());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}