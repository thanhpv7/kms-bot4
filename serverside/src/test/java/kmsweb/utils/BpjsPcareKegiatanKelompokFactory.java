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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.BpjsPcareKegiatanKelompokEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsPcareKegiatanKelompokFactory implements FactoryBean<BpjsPcareKegiatanKelompokEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsPcareKegiatanKelompokEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsPcareKegiatanKelompokEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public BpjsPcareKegiatanKelompokEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokWithNoRef before the main body here] end

		BpjsPcareKegiatanKelompokEntity newEntity = new BpjsPcareKegiatanKelompokEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for ketuaNama here] off begin
		String randomStringForKetuanama = mockNeat
				.strings()
				.get();
		newEntity.setKetuanama(randomStringForKetuanama);
		// % protected region % [Add customisation for ketuaNama here] end
		// % protected region % [Add customisation for nama here] off begin
		String randomStringForNama = mockNeat
				.strings()
				.get();
		newEntity.setNama(randomStringForNama);
		// % protected region % [Add customisation for nama here] end
		// % protected region % [Add customisation for eduId here] off begin
		String randomStringForEduid = mockNeat
				.strings()
				.get();
		newEntity.setEduid(randomStringForEduid);
		// % protected region % [Add customisation for eduId here] end
		// % protected region % [Add customisation for clubId here] off begin
		String randomStringForClubid = mockNeat
				.strings()
				.get();
		newEntity.setClubid(randomStringForClubid);
		// % protected region % [Add customisation for clubId here] end
		// % protected region % [Add customisation for kdProgram here] off begin
		String randomStringForKdprogram = mockNeat
				.strings()
				.get();
		newEntity.setKdprogram(randomStringForKdprogram);
		// % protected region % [Add customisation for kdProgram here] end
		// % protected region % [Add customisation for nmProgram here] off begin
		String randomStringForNmprogram = mockNeat
				.strings()
				.get();
		newEntity.setNmprogram(randomStringForNmprogram);
		// % protected region % [Add customisation for nmProgram here] end
		// % protected region % [Add customisation for tglMulai here] off begin
		String randomStringForTglmulai = mockNeat
				.strings()
				.get();
		newEntity.setTglmulai(randomStringForTglmulai);
		// % protected region % [Add customisation for tglMulai here] end
		// % protected region % [Add customisation for tglAkhir here] off begin
		String randomStringForTglakhir = mockNeat
				.strings()
				.get();
		newEntity.setTglakhir(randomStringForTglakhir);
		// % protected region % [Add customisation for tglAkhir here] end
		// % protected region % [Add customisation for alamat here] off begin
		String randomStringForAlamat = mockNeat
				.strings()
				.get();
		newEntity.setAlamat(randomStringForAlamat);
		// % protected region % [Add customisation for alamat here] end
		// % protected region % [Add customisation for ketuaNoHp here] off begin
		String randomStringForKetuanohp = mockNeat
				.strings()
				.get();
		newEntity.setKetuanohp(randomStringForKetuanohp);
		// % protected region % [Add customisation for ketuaNoHp here] end
		// % protected region % [Add customisation for tglPelayanan here] off begin
		String randomStringForTglpelayanan = mockNeat
				.strings()
				.get();
		newEntity.setTglpelayanan(randomStringForTglpelayanan);
		// % protected region % [Add customisation for tglPelayanan here] end
		// % protected region % [Add customisation for kegiatanNama here] off begin
		String randomStringForKegiatannama = mockNeat
				.strings()
				.get();
		newEntity.setKegiatannama(randomStringForKegiatannama);
		// % protected region % [Add customisation for kegiatanNama here] end
		// % protected region % [Add customisation for kegiatanKode here] off begin
		String randomStringForKegiatankode = mockNeat
				.strings()
				.get();
		newEntity.setKegiatankode(randomStringForKegiatankode);
		// % protected region % [Add customisation for kegiatanKode here] end
		// % protected region % [Add customisation for kelompokNama here] off begin
		String randomStringForKelompoknama = mockNeat
				.strings()
				.get();
		newEntity.setKelompoknama(randomStringForKelompoknama);
		// % protected region % [Add customisation for kelompokNama here] end
		// % protected region % [Add customisation for kelompokKode here] off begin
		String randomStringForKelompokkode = mockNeat
				.strings()
				.get();
		newEntity.setKelompokkode(randomStringForKelompokkode);
		// % protected region % [Add customisation for kelompokKode here] end
		// % protected region % [Add customisation for materi here] off begin
		String randomStringForMateri = mockNeat
				.strings()
				.get();
		newEntity.setMateri(randomStringForMateri);
		// % protected region % [Add customisation for materi here] end
		// % protected region % [Add customisation for pembicara here] off begin
		String randomStringForPembicara = mockNeat
				.strings()
				.get();
		newEntity.setPembicara(randomStringForPembicara);
		// % protected region % [Add customisation for pembicara here] end
		// % protected region % [Add customisation for lokasi here] off begin
		String randomStringForLokasi = mockNeat
				.strings()
				.get();
		newEntity.setLokasi(randomStringForLokasi);
		// % protected region % [Add customisation for lokasi here] end
		// % protected region % [Add customisation for keterangan here] off begin
		String randomStringForKeterangan = mockNeat
				.strings()
				.get();
		newEntity.setKeterangan(randomStringForKeterangan);
		// % protected region % [Add customisation for keterangan here] end
		// % protected region % [Add customisation for biaya here] off begin
		String randomStringForBiaya = mockNeat
				.strings()
				.get();
		newEntity.setBiaya(randomStringForBiaya);
		// % protected region % [Add customisation for biaya here] end

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsPcareKegiatanKelompokEntity> getObjectType() {
		return BpjsPcareKegiatanKelompokEntity.class;
	}
}