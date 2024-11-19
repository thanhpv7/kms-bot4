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

import kmsweb.entities.PcareMCUEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class PcareMCUSerializer extends AbstractSerializer<PcareMCUEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public PcareMCUSerializer() {
		super(PcareMCUEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(PcareMCUEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "kodeMCU", value.getKodeMCU());
		writeStringField(gen, "noKunjungan", value.getNoKunjungan());
		writeStringField(gen, "kodeProvider", value.getKodeProvider());
		writeStringField(gen, "namaProvider", value.getNamaProvider());
		writeStringField(gen, "tanggalPelayanan", value.getTanggalPelayanan());
		writeStringField(gen, "sistole", value.getSistole());
		writeStringField(gen, "diastole", value.getDiastole());
		writeStringField(gen, "radiologiFoto", value.getRadiologiFoto());
		writeStringField(gen, "hemoglobin", value.getHemoglobin());
		writeStringField(gen, "leukosit", value.getLeukosit());
		writeStringField(gen, "eritrosit", value.getEritrosit());
		writeStringField(gen, "lajuEndapDarah", value.getLajuEndapDarah());
		writeStringField(gen, "hematokrit", value.getHematokrit());
		writeStringField(gen, "trombosit", value.getTrombosit());
		writeStringField(gen, "hdl", value.getHdl());
		writeStringField(gen, "ldl", value.getLdl());
		writeStringField(gen, "cholesterol", value.getCholesterol());
		writeStringField(gen, "trigliserida", value.getTrigliserida());
		writeStringField(gen, "sewaktu", value.getSewaktu());
		writeStringField(gen, "puasa", value.getPuasa());
		writeStringField(gen, "postPrandial", value.getPostPrandial());
		writeStringField(gen, "hba1c", value.getHba1c());
		writeStringField(gen, "sgot", value.getSgot());
		writeStringField(gen, "sgpt", value.getSgpt());
		writeStringField(gen, "gamma", value.getGamma());
		writeStringField(gen, "proteinKualitatif", value.getProteinKualitatif());
		writeStringField(gen, "albumin", value.getAlbumin());
		writeStringField(gen, "creatinine", value.getCreatinine());
		writeStringField(gen, "ureum", value.getUreum());
		writeStringField(gen, "asam", value.getAsam());
		writeStringField(gen, "abi", value.getAbi());
		writeStringField(gen, "ekg", value.getEkg());
		writeStringField(gen, "echo", value.getEcho());
		writeStringField(gen, "funduskopi", value.getFunduskopi());
		writeStringField(gen, "pemeriksaanLain", value.getPemeriksaanLain());
		writeStringField(gen, "keterangan", value.getKeterangan());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}