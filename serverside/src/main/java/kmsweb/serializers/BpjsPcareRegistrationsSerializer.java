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

import kmsweb.entities.BpjsPcareRegistrationsEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class BpjsPcareRegistrationsSerializer extends AbstractSerializer<BpjsPcareRegistrationsEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public BpjsPcareRegistrationsSerializer() {
		super(BpjsPcareRegistrationsEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(BpjsPcareRegistrationsEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "kdproviderpeserta", value.getKdproviderpeserta());
		writeStringField(gen, "tgldaftar", value.getTgldaftar());
		writeStringField(gen, "nokartu", value.getNokartu());
		writeStringField(gen, "kdpoli", value.getKdpoli());
		writeStringField(gen, "keluhan", value.getKeluhan());
		writeStringField(gen, "kunjsakit", value.getKunjsakit());
		writeStringField(gen, "sistole", value.getSistole());
		writeStringField(gen, "diastole", value.getDiastole());
		writeStringField(gen, "beratbadan", value.getBeratbadan());
		writeStringField(gen, "tinggibadan", value.getTinggibadan());
		writeStringField(gen, "resprate", value.getResprate());
		writeStringField(gen, "lingkarperut", value.getLingkarperut());
		writeStringField(gen, "rujukinternal", value.getRujukinternal());
		writeStringField(gen, "heartrate", value.getHeartrate());
		writeStringField(gen, "rujukbalik", value.getRujukbalik());
		writeStringField(gen, "kdtkp", value.getKdtkp());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}