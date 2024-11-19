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

import kmsweb.entities.BpjsPcarePesertaKegiatanKelompokEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class BpjsPcarePesertaKegiatanKelompokSerializer extends AbstractSerializer<BpjsPcarePesertaKegiatanKelompokEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public BpjsPcarePesertaKegiatanKelompokSerializer() {
		super(BpjsPcarePesertaKegiatanKelompokEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(BpjsPcarePesertaKegiatanKelompokEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "eduid", value.getEduid());
		writeStringField(gen, "nokartu", value.getNokartu());
		writeStringField(gen, "nama", value.getNama());
		writeStringField(gen, "hubungankeluarga", value.getHubungankeluarga());
		writeStringField(gen, "sex", value.getSex());
		writeStringField(gen, "tgllahir", value.getTgllahir());
		writeStringField(gen, "tglmulaiaktif", value.getTglmulaiaktif());
		writeStringField(gen, "tglakhirberlaku", value.getTglakhirberlaku());
		writeStringField(gen, "kdprovider", value.getKdprovider());
		writeStringField(gen, "nmprovider", value.getNmprovider());
		writeStringField(gen, "kdprovidergigi", value.getKdprovidergigi());
		writeStringField(gen, "nmprovidergigi", value.getNmprovidergigi());
		writeStringField(gen, "namakelas", value.getNamakelas());
		writeStringField(gen, "kodekelas", value.getKodekelas());
		writeStringField(gen, "namapeserta", value.getNamapeserta());
		writeStringField(gen, "kodepeserta", value.getKodepeserta());
		writeStringField(gen, "goldarah", value.getGoldarah());
		writeStringField(gen, "nohp", value.getNohp());
		writeStringField(gen, "noktp", value.getNoktp());
		writeStringField(gen, "pstprol", value.getPstprol());
		writeStringField(gen, "pstprb", value.getPstprb());
		writeStringField(gen, "ketaktif", value.getKetaktif());
		writeStringField(gen, "kdasuransi", value.getKdasuransi());
		writeStringField(gen, "nmasuransi", value.getNmasuransi());
		writeStringField(gen, "noasuransi", value.getNoasuransi());
		writeStringField(gen, "cob", value.getCob());
		writeStringField(gen, "tunggakan", value.getTunggakan());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}