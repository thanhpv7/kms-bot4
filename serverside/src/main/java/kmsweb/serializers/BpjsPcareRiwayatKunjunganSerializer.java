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

import kmsweb.entities.BpjsPcareRiwayatKunjunganEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class BpjsPcareRiwayatKunjunganSerializer extends AbstractSerializer<BpjsPcareRiwayatKunjunganEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public BpjsPcareRiwayatKunjunganSerializer() {
		super(BpjsPcareRiwayatKunjunganEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(BpjsPcareRiwayatKunjunganEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "nokunjungan", value.getNokunjungan());
		writeStringField(gen, "tglkunjungan", value.getTglkunjungan());
		writeStringField(gen, "providerpelayanan", value.getProviderpelayanan());
		writeStringField(gen, "nokartu", value.getNokartu());
		writeStringField(gen, "nama", value.getNama());
		writeStringField(gen, "hubungankeluarga", value.getHubungankeluarga());
		writeStringField(gen, "sex", value.getSex());
		writeStringField(gen, "tgllahir", value.getTgllahir());
		writeStringField(gen, "tglmulaiaktif", value.getTglmulaiaktif());
		writeStringField(gen, "tglakhirberlaku", value.getTglakhirberlaku());
		writeStringField(gen, "kodeppkpeserta", value.getKodeppkpeserta());
		writeStringField(gen, "kodeppkgigi", value.getKodeppkgigi());
		writeStringField(gen, "jeniskelas", value.getJeniskelas());
		writeStringField(gen, "jenispeserta", value.getJenispeserta());
		writeStringField(gen, "goldarah", value.getGoldarah());
		writeStringField(gen, "nohp", value.getNohp());
		writeStringField(gen, "noktp", value.getNoktp());
		writeStringField(gen, "asuransi", value.getAsuransi());
		writeStringField(gen, "poli", value.getPoli());
		writeStringField(gen, "jeniskunjungan", value.getJeniskunjungan());
		writeStringField(gen, "progprolanis", value.getProgprolanis());
		writeStringField(gen, "keluhan", value.getKeluhan());
		writeStringField(gen, "diagnosa", value.getDiagnosa());
		writeStringField(gen, "diagnosa2", value.getDiagnosa2());
		writeStringField(gen, "diagnosa3", value.getDiagnosa3());
		writeStringField(gen, "kesadaran", value.getKesadaran());
		writeStringField(gen, "sistole", value.getSistole());
		writeStringField(gen, "diastole", value.getDiastole());
		writeStringField(gen, "beratbadan", value.getBeratbadan());
		writeStringField(gen, "tinggibadan", value.getTinggibadan());
		writeStringField(gen, "respiratoryrate", value.getRespiratoryrate());
		writeStringField(gen, "heartrate", value.getHeartrate());
		writeStringField(gen, "catatan", value.getCatatan());
		writeStringField(gen, "pemeriksaanfisiklain", value.getPemeriksaanfisiklain());
		writeStringField(gen, "tglpulang", value.getTglpulang());
		writeStringField(gen, "dokter", value.getDokter());
		writeStringField(gen, "statuspulang", value.getStatuspulang());
		writeStringField(gen, "tingkatpelayanan", value.getTingkatpelayanan());
		writeStringField(gen, "rujukbalik", value.getRujukbalik());
		writeStringField(gen, "providerasalrujuk", value.getProviderasalrujuk());
		writeStringField(gen, "providerrujuklanjut", value.getProviderrujuklanjut());
		writeStringField(gen, "polirujukinternal", value.getPolirujukinternal());
		writeStringField(gen, "polirujuklanjut", value.getPolirujuklanjut());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}