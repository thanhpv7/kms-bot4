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

import kmsweb.entities.InformedConsentEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class InformedConsentSerializer extends AbstractSerializer<InformedConsentEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public InformedConsentSerializer() {
		super(InformedConsentEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(InformedConsentEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "patientFamilyGuardianName", value.getPatientFamilyGuardianName());
		writeStringField(gen, "patientFamilyGuardianRelationship", value.getPatientFamilyGuardianRelationship());
		writeStringField(gen, "procedureToBePerformed", value.getProcedureToBePerformed());
		writeStringField(gen, "consequenceOfProcedure", value.getConsequenceOfProcedure());
		writeStringField(gen, "consentOnProcedure", value.getConsentOnProcedure());
		writeOffsetDateTimeField(gen, "consentDateTime", value.getConsentDateTime());
		writeStringField(gen, "informingStaffSignature", value.getInformingStaffSignature());
		writeStringField(gen, "consentingPartySignature", value.getConsentingPartySignature());
		writeStringField(gen, "consentingPartyType", value.getConsentingPartyType());
		writeStringField(gen, "consentingPartyName", value.getConsentingPartyName());
		writeStringField(gen, "witnessSignature1", value.getWitnessSignature1());
		writeStringField(gen, "witnessName1", value.getWitnessName1());
		writeStringField(gen, "witnessSignature2", value.getWitnessSignature2());
		writeStringField(gen, "witnessName2", value.getWitnessName2());
		writeStringField(gen, "notes", value.getNotes());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}