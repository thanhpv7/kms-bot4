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

import kmsweb.entities.BpjsPcareKunjunganRujukanEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class BpjsPcareKunjunganRujukanSerializer extends AbstractSerializer<BpjsPcareKunjunganRujukanEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public BpjsPcareKunjunganRujukanSerializer() {
		super(BpjsPcareKunjunganRujukanEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(BpjsPcareKunjunganRujukanEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "norujukan", value.getNorujukan());
		writeStringField(gen, "kdppk", value.getKdppk());
		writeStringField(gen, "nmppk", value.getNmppk());
		writeStringField(gen, "alamat", value.getAlamat());
		writeStringField(gen, "kdkc", value.getKdkc());
		writeStringField(gen, "nmkc", value.getNmkc());
		writeStringField(gen, "alamatkc", value.getAlamatkc());
		writeStringField(gen, "telpkc", value.getTelpkc());
		writeStringField(gen, "faxkc", value.getFaxkc());
		writeStringField(gen, "kdprop", value.getKdprop());
		writeStringField(gen, "kddati", value.getKddati());
		writeStringField(gen, "nmdati", value.getNmdati());
		writeStringField(gen, "kdkr", value.getKdkr());
		writeStringField(gen, "nmkr", value.getNmkr());
		writeStringField(gen, "alamatkr", value.getAlamatkr());
		writeStringField(gen, "telpkr", value.getTelpkr());
		writeStringField(gen, "faxkr", value.getFaxkr());
		writeStringField(gen, "tglkunjungan", value.getTglkunjungan());
		writeStringField(gen, "kdpoli", value.getKdpoli());
		writeStringField(gen, "nmpoli", value.getNmpoli());
		writeStringField(gen, "nokapst", value.getNokapst());
		writeStringField(gen, "nmpst", value.getNmpst());
		writeStringField(gen, "tgllahir", value.getTgllahir());
		writeStringField(gen, "pisa", value.getPisa());
		writeStringField(gen, "ketpisa", value.getKetpisa());
		writeStringField(gen, "sex", value.getSex());
		writeStringField(gen, "kddiag1", value.getKddiag1());
		writeStringField(gen, "nmdiag1", value.getNmdiag1());
		writeStringField(gen, "kddiag2", value.getKddiag2());
		writeStringField(gen, "nmdiag2", value.getNmdiag2());
		writeStringField(gen, "kddiag3", value.getKddiag3());
		writeStringField(gen, "nmdiag3", value.getNmdiag3());
		writeStringField(gen, "catatan", value.getCatatan());
		writeStringField(gen, "kddokter", value.getKddokter());
		writeStringField(gen, "nmdokter", value.getNmdokter());
		writeStringField(gen, "nmtacc", value.getNmtacc());
		writeStringField(gen, "alasantacc", value.getAlasantacc());
		writeStringField(gen, "infodenda", value.getInfodenda());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}