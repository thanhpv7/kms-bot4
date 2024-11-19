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

import kmsweb.entities.NhisClaimEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class NhisClaimSerializer extends AbstractSerializer<NhisClaimEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public NhisClaimSerializer() {
		super(NhisClaimEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(NhisClaimEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "systemClaimID", value.getSystemClaimID());
		writeStringField(gen, "refInvoiceNo", value.getRefInvoiceNo());
		writeStringField(gen, "formNo", value.getFormNo());
		writeStringField(gen, "claimID", value.getClaimID());
		writeStringField(gen, "claimCheckCode", value.getClaimCheckCode());
		writeStringField(gen, "batchNumber", value.getBatchNumber());
		writeStringField(gen, "surname", value.getSurname());
		writeStringField(gen, "otherNames", value.getOtherNames());
		writeStringField(gen, "gender", value.getGender());
		writeOffsetDateTimeField(gen, "dateOfBirth", value.getDateOfBirth());
		writeStringField(gen, "memberNo", value.getMemberNo());
		writeStringField(gen, "hospitalRecordNo", value.getHospitalRecordNo());
		writeStringField(gen, "cardSerialNumber", value.getCardSerialNumber());
		writeBooleanField(gen, "dependant", value.getDependant());
		writeBooleanField(gen, "unbundled", value.getUnbundled());
		writeBooleanField(gen, "includesPharmacy", value.getIncludesPharmacy());
		writeStringField(gen, "typeOfAttendance", value.getTypeOfAttendance());
		writeOffsetDateTimeField(gen, "firstVisitAdmission", value.getFirstVisitAdmission());
		writeOffsetDateTimeField(gen, "secondVisitDischarge", value.getSecondVisitDischarge());
		writeOffsetDateTimeField(gen, "thirdVisit", value.getThirdVisit());
		writeOffsetDateTimeField(gen, "fourthVisit", value.getFourthVisit());
		writeStringField(gen, "physicianName", value.getPhysicianName());
		writeStringField(gen, "physicianCode", value.getPhysicianCode());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}