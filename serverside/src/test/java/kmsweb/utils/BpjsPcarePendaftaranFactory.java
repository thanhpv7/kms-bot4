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
import kmsweb.entities.BpjsPcarePendaftaranEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsPcarePendaftaranFactory implements FactoryBean<BpjsPcarePendaftaranEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsPcarePendaftaranEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsPcarePendaftaranEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public BpjsPcarePendaftaranEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranWithNoRef before the main body here] end

		BpjsPcarePendaftaranEntity newEntity = new BpjsPcarePendaftaranEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noUrut here] off begin
		String randomStringForNourut = mockNeat
				.strings()
				.get();
		newEntity.setNourut(randomStringForNourut);
		// % protected region % [Add customisation for noUrut here] end
		// % protected region % [Add customisation for tgldaftar here] off begin
		String randomStringForTgldaftar = mockNeat
				.strings()
				.get();
		newEntity.setTgldaftar(randomStringForTgldaftar);
		// % protected region % [Add customisation for tgldaftar here] end
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
		// % protected region % [Add customisation for kdProviderPst here] off begin
		String randomStringForKdproviderpst = mockNeat
				.strings()
				.get();
		newEntity.setKdproviderpst(randomStringForKdproviderpst);
		// % protected region % [Add customisation for kdProviderPst here] end
		// % protected region % [Add customisation for kdProviderGigi here] off begin
		String randomStringForKdprovidergigi = mockNeat
				.strings()
				.get();
		newEntity.setKdprovidergigi(randomStringForKdprovidergigi);
		// % protected region % [Add customisation for kdProviderGigi here] end
		// % protected region % [Add customisation for jnsKelas here] off begin
		String randomStringForJnskelas = mockNeat
				.strings()
				.get();
		newEntity.setJnskelas(randomStringForJnskelas);
		// % protected region % [Add customisation for jnsKelas here] end
		// % protected region % [Add customisation for jnsPeserta here] off begin
		String randomStringForJnspeserta = mockNeat
				.strings()
				.get();
		newEntity.setJnspeserta(randomStringForJnspeserta);
		// % protected region % [Add customisation for jnsPeserta here] end
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
		// % protected region % [Add customisation for aktif here] off begin
		String randomStringForAktif = mockNeat
				.strings()
				.get();
		newEntity.setAktif(randomStringForAktif);
		// % protected region % [Add customisation for aktif here] end
		// % protected region % [Add customisation for ketAktif here] off begin
		String randomStringForKetaktif = mockNeat
				.strings()
				.get();
		newEntity.setKetaktif(randomStringForKetaktif);
		// % protected region % [Add customisation for ketAktif here] end
		// % protected region % [Add customisation for asuransi here] off begin
		String randomStringForAsuransi = mockNeat
				.strings()
				.get();
		newEntity.setAsuransi(randomStringForAsuransi);
		// % protected region % [Add customisation for asuransi here] end
		// % protected region % [Add customisation for kdPoli here] off begin
		String randomStringForKdpoli = mockNeat
				.strings()
				.get();
		newEntity.setKdpoli(randomStringForKdpoli);
		// % protected region % [Add customisation for kdPoli here] end
		// % protected region % [Add customisation for nmPoli here] off begin
		String randomStringForNmpoli = mockNeat
				.strings()
				.get();
		newEntity.setNmpoli(randomStringForNmpoli);
		// % protected region % [Add customisation for nmPoli here] end
		// % protected region % [Add customisation for poliSakit here] off begin
		String randomStringForPolisakit = mockNeat
				.strings()
				.get();
		newEntity.setPolisakit(randomStringForPolisakit);
		// % protected region % [Add customisation for poliSakit here] end
		// % protected region % [Add customisation for keluhan here] off begin
		String randomStringForKeluhan = mockNeat
				.strings()
				.get();
		newEntity.setKeluhan(randomStringForKeluhan);
		// % protected region % [Add customisation for keluhan here] end
		// % protected region % [Add customisation for kunjSakit here] off begin
		String randomStringForKunjsakit = mockNeat
				.strings()
				.get();
		newEntity.setKunjsakit(randomStringForKunjsakit);
		// % protected region % [Add customisation for kunjSakit here] end
		// % protected region % [Add customisation for status here] off begin
		String randomStringForStatus = mockNeat
				.strings()
				.get();
		newEntity.setStatus(randomStringForStatus);
		// % protected region % [Add customisation for status here] end
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
		// % protected region % [Add customisation for respRate here] off begin
		String randomStringForResprate = mockNeat
				.strings()
				.get();
		newEntity.setResprate(randomStringForResprate);
		// % protected region % [Add customisation for respRate here] end
		// % protected region % [Add customisation for heartRate here] off begin
		String randomStringForHeartrate = mockNeat
				.strings()
				.get();
		newEntity.setHeartrate(randomStringForHeartrate);
		// % protected region % [Add customisation for heartRate here] end
		// % protected region % [Add customisation for kdTkp here] off begin
		String randomStringForKdtkp = mockNeat
				.strings()
				.get();
		newEntity.setKdtkp(randomStringForKdtkp);
		// % protected region % [Add customisation for kdTkp here] end
		// % protected region % [Add customisation for nmTkp here] off begin
		String randomStringForNmtkp = mockNeat
				.strings()
				.get();
		newEntity.setNmtkp(randomStringForNmtkp);
		// % protected region % [Add customisation for nmTkp here] end
		// % protected region % [Add customisation for kdProviderPelayanan here] off begin
		String randomStringForKdproviderpelayanan = mockNeat
				.strings()
				.get();
		newEntity.setKdproviderpelayanan(randomStringForKdproviderpelayanan);
		// % protected region % [Add customisation for kdProviderPelayanan here] end
		// % protected region % [Add customisation for nmProviderPelayanan here] off begin
		String randomStringForNmproviderpelayanan = mockNeat
				.strings()
				.get();
		newEntity.setNmproviderpelayanan(randomStringForNmproviderpelayanan);
		// % protected region % [Add customisation for nmProviderPelayanan here] end
		// % protected region % [Add customisation for nmProviderPst here] off begin
		String randomStringForNmproviderpst = mockNeat
				.strings()
				.get();
		newEntity.setNmproviderpst(randomStringForNmproviderpst);
		// % protected region % [Add customisation for nmProviderPst here] end
		// % protected region % [Add customisation for nmProviderGigi here] off begin
		String randomStringForNmprovidergigi = mockNeat
				.strings()
				.get();
		newEntity.setNmprovidergigi(randomStringForNmprovidergigi);
		// % protected region % [Add customisation for nmProviderGigi here] end
		// % protected region % [Add customisation for kodeKls here] off begin
		String randomStringForKodekls = mockNeat
				.strings()
				.get();
		newEntity.setKodekls(randomStringForKodekls);
		// % protected region % [Add customisation for kodeKls here] end
		// % protected region % [Add customisation for namaKls here] off begin
		String randomStringForNamakls = mockNeat
				.strings()
				.get();
		newEntity.setNamakls(randomStringForNamakls);
		// % protected region % [Add customisation for namaKls here] end
		// % protected region % [Add customisation for kodePeserta here] off begin
		String randomStringForKodepeserta = mockNeat
				.strings()
				.get();
		newEntity.setKodepeserta(randomStringForKodepeserta);
		// % protected region % [Add customisation for kodePeserta here] end
		// % protected region % [Add customisation for namaPeserta here] off begin
		String randomStringForNamapeserta = mockNeat
				.strings()
				.get();
		newEntity.setNamapeserta(randomStringForNamapeserta);
		// % protected region % [Add customisation for namaPeserta here] end
		// % protected region % [Add customisation for kdAsuransi here] off begin
		String randomStringForKdasuransi = mockNeat
				.strings()
				.get();
		newEntity.setKdasuransi(randomStringForKdasuransi);
		// % protected region % [Add customisation for kdAsuransi here] end
		// % protected region % [Add customisation for nmAsuransi here] off begin
		String randomStringForNmasuransi = mockNeat
				.strings()
				.get();
		newEntity.setNmasuransi(randomStringForNmasuransi);
		// % protected region % [Add customisation for nmAsuransi here] end
		// % protected region % [Add customisation for noAsuransi here] off begin
		String randomStringForNoasuransi = mockNeat
				.strings()
				.get();
		newEntity.setNoasuransi(randomStringForNoasuransi);
		// % protected region % [Add customisation for noAsuransi here] end
		// % protected region % [Add customisation for lingkarPerut here] off begin
		String randomStringForLingkarperut = mockNeat
				.strings()
				.get();
		newEntity.setLingkarperut(randomStringForLingkarperut);
		// % protected region % [Add customisation for lingkarPerut here] end

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Visit here] off begin
			var patientVisitFactory = new PatientVisitFactory();
			newEntity.setPatientVisit(patientVisitFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Visit here] end

		}

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaran with ref here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaran with ref here] end

		return newEntity;
	}

	@Override
	public Class<BpjsPcarePendaftaranEntity> getObjectType() {
		return BpjsPcarePendaftaranEntity.class;
	}
}