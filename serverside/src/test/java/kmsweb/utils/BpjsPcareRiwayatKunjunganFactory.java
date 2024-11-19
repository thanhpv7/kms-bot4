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
import kmsweb.entities.BpjsPcareRiwayatKunjunganEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsPcareRiwayatKunjunganFactory implements FactoryBean<BpjsPcareRiwayatKunjunganEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsPcareRiwayatKunjunganEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsPcareRiwayatKunjunganEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsPcareRiwayatKunjunganEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganWithNoRef before the main body here] end

		BpjsPcareRiwayatKunjunganEntity newEntity = new BpjsPcareRiwayatKunjunganEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noKunjungan here] off begin
		String randomStringForNokunjungan = mockNeat
				.strings()
				.get();
		newEntity.setNokunjungan(randomStringForNokunjungan);
		// % protected region % [Add customisation for noKunjungan here] end
		// % protected region % [Add customisation for tglkunjungan here] off begin
		String randomStringForTglkunjungan = mockNeat
				.strings()
				.get();
		newEntity.setTglkunjungan(randomStringForTglkunjungan);
		// % protected region % [Add customisation for tglkunjungan here] end
		// % protected region % [Add customisation for providerPelayanan here] off begin
		String randomStringForProviderpelayanan = mockNeat
				.strings()
				.get();
		newEntity.setProviderpelayanan(randomStringForProviderpelayanan);
		// % protected region % [Add customisation for providerPelayanan here] end
		// % protected region % [Add customisation for noKartu here] off begin
		String randomStringForNokartu = mockNeat
				.strings()
				.get();
		newEntity.setNokartu(randomStringForNokartu);
		// % protected region % [Add customisation for noKartu here] end
		// % protected region % [Add customisation for nama here] off begin
		String randomStringForNama = mockNeat
				.strings()
				.get();
		newEntity.setNama(randomStringForNama);
		// % protected region % [Add customisation for nama here] end
		// % protected region % [Add customisation for hubunganKeluarga here] off begin
		String randomStringForHubungankeluarga = mockNeat
				.strings()
				.get();
		newEntity.setHubungankeluarga(randomStringForHubungankeluarga);
		// % protected region % [Add customisation for hubunganKeluarga here] end
		// % protected region % [Add customisation for sex here] off begin
		String randomStringForSex = mockNeat
				.strings()
				.get();
		newEntity.setSex(randomStringForSex);
		// % protected region % [Add customisation for sex here] end
		// % protected region % [Add customisation for tglLahir here] off begin
		String randomStringForTgllahir = mockNeat
				.strings()
				.get();
		newEntity.setTgllahir(randomStringForTgllahir);
		// % protected region % [Add customisation for tglLahir here] end
		// % protected region % [Add customisation for tglMulaiAktif here] off begin
		String randomStringForTglmulaiaktif = mockNeat
				.strings()
				.get();
		newEntity.setTglmulaiaktif(randomStringForTglmulaiaktif);
		// % protected region % [Add customisation for tglMulaiAktif here] end
		// % protected region % [Add customisation for tglAkhirBerlaku here] off begin
		String randomStringForTglakhirberlaku = mockNeat
				.strings()
				.get();
		newEntity.setTglakhirberlaku(randomStringForTglakhirberlaku);
		// % protected region % [Add customisation for tglAkhirBerlaku here] end
		// % protected region % [Add customisation for kodePPKPeserta here] off begin
		String randomStringForKodeppkpeserta = mockNeat
				.strings()
				.get();
		newEntity.setKodeppkpeserta(randomStringForKodeppkpeserta);
		// % protected region % [Add customisation for kodePPKPeserta here] end
		// % protected region % [Add customisation for kodePPKGigi here] off begin
		String randomStringForKodeppkgigi = mockNeat
				.strings()
				.get();
		newEntity.setKodeppkgigi(randomStringForKodeppkgigi);
		// % protected region % [Add customisation for kodePPKGigi here] end
		// % protected region % [Add customisation for jenisKelas here] off begin
		String randomStringForJeniskelas = mockNeat
				.strings()
				.get();
		newEntity.setJeniskelas(randomStringForJeniskelas);
		// % protected region % [Add customisation for jenisKelas here] end
		// % protected region % [Add customisation for jenisPeserta here] off begin
		String randomStringForJenispeserta = mockNeat
				.strings()
				.get();
		newEntity.setJenispeserta(randomStringForJenispeserta);
		// % protected region % [Add customisation for jenisPeserta here] end
		// % protected region % [Add customisation for golDarah here] off begin
		String randomStringForGoldarah = mockNeat
				.strings()
				.get();
		newEntity.setGoldarah(randomStringForGoldarah);
		// % protected region % [Add customisation for golDarah here] end
		// % protected region % [Add customisation for noHP here] off begin
		String randomStringForNohp = mockNeat
				.strings()
				.get();
		newEntity.setNohp(randomStringForNohp);
		// % protected region % [Add customisation for noHP here] end
		// % protected region % [Add customisation for noKTP here] off begin
		String randomStringForNoktp = mockNeat
				.strings()
				.get();
		newEntity.setNoktp(randomStringForNoktp);
		// % protected region % [Add customisation for noKTP here] end
		// % protected region % [Add customisation for asuransi here] off begin
		String randomStringForAsuransi = mockNeat
				.strings()
				.get();
		newEntity.setAsuransi(randomStringForAsuransi);
		// % protected region % [Add customisation for asuransi here] end
		// % protected region % [Add customisation for poli here] off begin
		String randomStringForPoli = mockNeat
				.strings()
				.get();
		newEntity.setPoli(randomStringForPoli);
		// % protected region % [Add customisation for poli here] end
		// % protected region % [Add customisation for jenisKunjungan here] off begin
		String randomStringForJeniskunjungan = mockNeat
				.strings()
				.get();
		newEntity.setJeniskunjungan(randomStringForJeniskunjungan);
		// % protected region % [Add customisation for jenisKunjungan here] end
		// % protected region % [Add customisation for progProlanis here] off begin
		String randomStringForProgprolanis = mockNeat
				.strings()
				.get();
		newEntity.setProgprolanis(randomStringForProgprolanis);
		// % protected region % [Add customisation for progProlanis here] end
		// % protected region % [Add customisation for keluhan here] off begin
		String randomStringForKeluhan = mockNeat
				.strings()
				.get();
		newEntity.setKeluhan(randomStringForKeluhan);
		// % protected region % [Add customisation for keluhan here] end
		// % protected region % [Add customisation for diagnosa here] off begin
		String randomStringForDiagnosa = mockNeat
				.strings()
				.get();
		newEntity.setDiagnosa(randomStringForDiagnosa);
		// % protected region % [Add customisation for diagnosa here] end
		// % protected region % [Add customisation for diagnosa2 here] off begin
		String randomStringForDiagnosa2 = mockNeat
				.strings()
				.get();
		newEntity.setDiagnosa2(randomStringForDiagnosa2);
		// % protected region % [Add customisation for diagnosa2 here] end
		// % protected region % [Add customisation for diagnosa3 here] off begin
		String randomStringForDiagnosa3 = mockNeat
				.strings()
				.get();
		newEntity.setDiagnosa3(randomStringForDiagnosa3);
		// % protected region % [Add customisation for diagnosa3 here] end
		// % protected region % [Add customisation for kesadaran here] off begin
		String randomStringForKesadaran = mockNeat
				.strings()
				.get();
		newEntity.setKesadaran(randomStringForKesadaran);
		// % protected region % [Add customisation for kesadaran here] end
		// % protected region % [Add customisation for sistole here] off begin
		String randomStringForSistole = mockNeat
				.strings()
				.get();
		newEntity.setSistole(randomStringForSistole);
		// % protected region % [Add customisation for sistole here] end
		// % protected region % [Add customisation for diastole here] off begin
		String randomStringForDiastole = mockNeat
				.strings()
				.get();
		newEntity.setDiastole(randomStringForDiastole);
		// % protected region % [Add customisation for diastole here] end
		// % protected region % [Add customisation for beratBadan here] off begin
		String randomStringForBeratbadan = mockNeat
				.strings()
				.get();
		newEntity.setBeratbadan(randomStringForBeratbadan);
		// % protected region % [Add customisation for beratBadan here] end
		// % protected region % [Add customisation for tinggiBadan here] off begin
		String randomStringForTinggibadan = mockNeat
				.strings()
				.get();
		newEntity.setTinggibadan(randomStringForTinggibadan);
		// % protected region % [Add customisation for tinggiBadan here] end
		// % protected region % [Add customisation for respiratoryRate here] off begin
		String randomStringForRespiratoryrate = mockNeat
				.strings()
				.get();
		newEntity.setRespiratoryrate(randomStringForRespiratoryrate);
		// % protected region % [Add customisation for respiratoryRate here] end
		// % protected region % [Add customisation for heartRate here] off begin
		String randomStringForHeartrate = mockNeat
				.strings()
				.get();
		newEntity.setHeartrate(randomStringForHeartrate);
		// % protected region % [Add customisation for heartRate here] end
		// % protected region % [Add customisation for catatan here] off begin
		String randomStringForCatatan = mockNeat
				.strings()
				.get();
		newEntity.setCatatan(randomStringForCatatan);
		// % protected region % [Add customisation for catatan here] end
		// % protected region % [Add customisation for pemeriksaanFisikLain here] off begin
		String randomStringForPemeriksaanfisiklain = mockNeat
				.strings()
				.get();
		newEntity.setPemeriksaanfisiklain(randomStringForPemeriksaanfisiklain);
		// % protected region % [Add customisation for pemeriksaanFisikLain here] end
		// % protected region % [Add customisation for tglPulang here] off begin
		String randomStringForTglpulang = mockNeat
				.strings()
				.get();
		newEntity.setTglpulang(randomStringForTglpulang);
		// % protected region % [Add customisation for tglPulang here] end
		// % protected region % [Add customisation for dokter here] off begin
		String randomStringForDokter = mockNeat
				.strings()
				.get();
		newEntity.setDokter(randomStringForDokter);
		// % protected region % [Add customisation for dokter here] end
		// % protected region % [Add customisation for statusPulang here] off begin
		String randomStringForStatuspulang = mockNeat
				.strings()
				.get();
		newEntity.setStatuspulang(randomStringForStatuspulang);
		// % protected region % [Add customisation for statusPulang here] end
		// % protected region % [Add customisation for tingkatPelayanan here] off begin
		String randomStringForTingkatpelayanan = mockNeat
				.strings()
				.get();
		newEntity.setTingkatpelayanan(randomStringForTingkatpelayanan);
		// % protected region % [Add customisation for tingkatPelayanan here] end
		// % protected region % [Add customisation for rujukBalik here] off begin
		String randomStringForRujukbalik = mockNeat
				.strings()
				.get();
		newEntity.setRujukbalik(randomStringForRujukbalik);
		// % protected region % [Add customisation for rujukBalik here] end
		// % protected region % [Add customisation for providerAsalRujuk here] off begin
		String randomStringForProviderasalrujuk = mockNeat
				.strings()
				.get();
		newEntity.setProviderasalrujuk(randomStringForProviderasalrujuk);
		// % protected region % [Add customisation for providerAsalRujuk here] end
		// % protected region % [Add customisation for providerRujukLanjut here] off begin
		String randomStringForProviderrujuklanjut = mockNeat
				.strings()
				.get();
		newEntity.setProviderrujuklanjut(randomStringForProviderrujuklanjut);
		// % protected region % [Add customisation for providerRujukLanjut here] end
		// % protected region % [Add customisation for poliRujukInternal here] off begin
		String randomStringForPolirujukinternal = mockNeat
				.strings()
				.get();
		newEntity.setPolirujukinternal(randomStringForPolirujukinternal);
		// % protected region % [Add customisation for poliRujukInternal here] end
		// % protected region % [Add customisation for poliRujukLanjut here] off begin
		String randomStringForPolirujuklanjut = mockNeat
				.strings()
				.get();
		newEntity.setPolirujuklanjut(randomStringForPolirujuklanjut);
		// % protected region % [Add customisation for poliRujukLanjut here] end

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsPcareRiwayatKunjunganEntity> getObjectType() {
		return BpjsPcareRiwayatKunjunganEntity.class;
	}
}