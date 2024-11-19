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

import kmsweb.entities.BpjsGeneralEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class BpjsGeneralSerializer extends AbstractSerializer<BpjsGeneralEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public BpjsGeneralSerializer() {
		super(BpjsGeneralEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(BpjsGeneralEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "consID", value.getConsID());
		writeStringField(gen, "secretKey", value.getSecretKey());
		writeStringField(gen, "bpjsWebServiceURL", value.getBpjsWebServiceURL());
		writeStringField(gen, "aplicareWebServiceURL", value.getAplicareWebServiceURL());
		writeStringField(gen, "healthFacilityCode", value.getHealthFacilityCode());
		writeStringField(gen, "healthFacilityName", value.getHealthFacilityName());
		writeStringField(gen, "mjknWSBPJSURL", value.getMjknWSBPJSURL());
		writeStringField(gen, "mjknWSBPJSUserKey", value.getMjknWSBPJSUserKey());
		writeStringField(gen, "vclaimUserKey", value.getVclaimUserKey());
		writeBooleanField(gen, "connectToOtherSystem", value.getConnectToOtherSystem());
		writeBooleanField(gen, "ismobilejkn", value.getIsmobilejkn());
		writeStringField(gen, "externalSystemURL", value.getExternalSystemURL());
		writeBooleanField(gen, "basicAuth", value.getBasicAuth());
		writeStringField(gen, "basicAuthUsername", value.getBasicAuthUsername());
		writeStringField(gen, "basicAuthPassword", value.getBasicAuthPassword());
		writeBooleanField(gen, "bypassSSLValidation", value.getBypassSSLValidation());
		writeBooleanField(gen, "claimStatus", value.getClaimStatus());
		writeStringField(gen, "facilityType", value.getFacilityType());
		writeBooleanField(gen, "sendNonJKN", value.getSendNonJKN());
		writeBooleanField(gen, "vclaimIntegration", value.getVclaimIntegration());
		writeStringField(gen, "externalVclaimServiceURL", value.getExternalVclaimServiceURL());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}