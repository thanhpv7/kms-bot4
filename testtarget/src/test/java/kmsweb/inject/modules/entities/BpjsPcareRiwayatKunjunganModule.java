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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for Bpjs Pcare Riwayat Kunjungan used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPcareRiwayatKunjunganModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPcareRiwayatKunjunganModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPcareRiwayatKunjunganModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPcareRiwayatKunjunganEntityFactory bpjsPcareRiwayatKunjunganEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPcareRiwayatKunjunganEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPcareRiwayatKunjunganEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPcareRiwayatKunjunganEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntityFactory before the main body here] end

		BpjsPcareRiwayatKunjunganEntityFactory entityFactory = new BpjsPcareRiwayatKunjunganEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPcareRiwayatKunjunganEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPcareRiwayatKunjunganEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntityFactory after the main body here] end

		log.trace("Created BpjsPcareRiwayatKunjunganEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Bpjs Pcare Riwayat Kunjungan entity with no references set.
	 */
	@Provides
	@Named("bpjsPcareRiwayatKunjunganEntityWithNoRef")
	public BpjsPcareRiwayatKunjunganEntity bpjsPcareRiwayatKunjunganEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareRiwayatKunjunganEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareRiwayatKunjunganEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPcareRiwayatKunjunganEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganWithNoRef before the main body here] end

		BpjsPcareRiwayatKunjunganEntity newEntity = new BpjsPcareRiwayatKunjunganEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noKunjungan here] off begin
		String randomStringforNokunjungan = mock
				.strings()
				.get();
		newEntity.setNokunjungan(randomStringforNokunjungan);
		// % protected region % [Add customisation for noKunjungan here] end
		// % protected region % [Add customisation for tglkunjungan here] off begin
		String randomStringforTglkunjungan = mock
				.strings()
				.get();
		newEntity.setTglkunjungan(randomStringforTglkunjungan);
		// % protected region % [Add customisation for tglkunjungan here] end
		// % protected region % [Add customisation for providerPelayanan here] off begin
		String randomStringforProviderpelayanan = mock
				.strings()
				.get();
		newEntity.setProviderpelayanan(randomStringforProviderpelayanan);
		// % protected region % [Add customisation for providerPelayanan here] end
		// % protected region % [Add customisation for noKartu here] off begin
		String randomStringforNokartu = mock
				.strings()
				.get();
		newEntity.setNokartu(randomStringforNokartu);
		// % protected region % [Add customisation for noKartu here] end
		// % protected region % [Add customisation for nama here] off begin
		String randomStringforNama = mock
				.strings()
				.get();
		newEntity.setNama(randomStringforNama);
		// % protected region % [Add customisation for nama here] end
		// % protected region % [Add customisation for hubunganKeluarga here] off begin
		String randomStringforHubungankeluarga = mock
				.strings()
				.get();
		newEntity.setHubungankeluarga(randomStringforHubungankeluarga);
		// % protected region % [Add customisation for hubunganKeluarga here] end
		// % protected region % [Add customisation for sex here] off begin
		String randomStringforSex = mock
				.strings()
				.get();
		newEntity.setSex(randomStringforSex);
		// % protected region % [Add customisation for sex here] end
		// % protected region % [Add customisation for tglLahir here] off begin
		String randomStringforTgllahir = mock
				.strings()
				.get();
		newEntity.setTgllahir(randomStringforTgllahir);
		// % protected region % [Add customisation for tglLahir here] end
		// % protected region % [Add customisation for tglMulaiAktif here] off begin
		String randomStringforTglmulaiaktif = mock
				.strings()
				.get();
		newEntity.setTglmulaiaktif(randomStringforTglmulaiaktif);
		// % protected region % [Add customisation for tglMulaiAktif here] end
		// % protected region % [Add customisation for tglAkhirBerlaku here] off begin
		String randomStringforTglakhirberlaku = mock
				.strings()
				.get();
		newEntity.setTglakhirberlaku(randomStringforTglakhirberlaku);
		// % protected region % [Add customisation for tglAkhirBerlaku here] end
		// % protected region % [Add customisation for kodePPKPeserta here] off begin
		String randomStringforKodeppkpeserta = mock
				.strings()
				.get();
		newEntity.setKodeppkpeserta(randomStringforKodeppkpeserta);
		// % protected region % [Add customisation for kodePPKPeserta here] end
		// % protected region % [Add customisation for kodePPKGigi here] off begin
		String randomStringforKodeppkgigi = mock
				.strings()
				.get();
		newEntity.setKodeppkgigi(randomStringforKodeppkgigi);
		// % protected region % [Add customisation for kodePPKGigi here] end
		// % protected region % [Add customisation for jenisKelas here] off begin
		String randomStringforJeniskelas = mock
				.strings()
				.get();
		newEntity.setJeniskelas(randomStringforJeniskelas);
		// % protected region % [Add customisation for jenisKelas here] end
		// % protected region % [Add customisation for jenisPeserta here] off begin
		String randomStringforJenispeserta = mock
				.strings()
				.get();
		newEntity.setJenispeserta(randomStringforJenispeserta);
		// % protected region % [Add customisation for jenisPeserta here] end
		// % protected region % [Add customisation for golDarah here] off begin
		String randomStringforGoldarah = mock
				.strings()
				.get();
		newEntity.setGoldarah(randomStringforGoldarah);
		// % protected region % [Add customisation for golDarah here] end
		// % protected region % [Add customisation for noHP here] off begin
		String randomStringforNohp = mock
				.strings()
				.get();
		newEntity.setNohp(randomStringforNohp);
		// % protected region % [Add customisation for noHP here] end
		// % protected region % [Add customisation for noKTP here] off begin
		String randomStringforNoktp = mock
				.strings()
				.get();
		newEntity.setNoktp(randomStringforNoktp);
		// % protected region % [Add customisation for noKTP here] end
		// % protected region % [Add customisation for asuransi here] off begin
		String randomStringforAsuransi = mock
				.strings()
				.get();
		newEntity.setAsuransi(randomStringforAsuransi);
		// % protected region % [Add customisation for asuransi here] end
		// % protected region % [Add customisation for poli here] off begin
		String randomStringforPoli = mock
				.strings()
				.get();
		newEntity.setPoli(randomStringforPoli);
		// % protected region % [Add customisation for poli here] end
		// % protected region % [Add customisation for jenisKunjungan here] off begin
		String randomStringforJeniskunjungan = mock
				.strings()
				.get();
		newEntity.setJeniskunjungan(randomStringforJeniskunjungan);
		// % protected region % [Add customisation for jenisKunjungan here] end
		// % protected region % [Add customisation for progProlanis here] off begin
		String randomStringforProgprolanis = mock
				.strings()
				.get();
		newEntity.setProgprolanis(randomStringforProgprolanis);
		// % protected region % [Add customisation for progProlanis here] end
		// % protected region % [Add customisation for keluhan here] off begin
		String randomStringforKeluhan = mock
				.strings()
				.get();
		newEntity.setKeluhan(randomStringforKeluhan);
		// % protected region % [Add customisation for keluhan here] end
		// % protected region % [Add customisation for diagnosa here] off begin
		String randomStringforDiagnosa = mock
				.strings()
				.get();
		newEntity.setDiagnosa(randomStringforDiagnosa);
		// % protected region % [Add customisation for diagnosa here] end
		// % protected region % [Add customisation for diagnosa2 here] off begin
		String randomStringforDiagnosa2 = mock
				.strings()
				.get();
		newEntity.setDiagnosa2(randomStringforDiagnosa2);
		// % protected region % [Add customisation for diagnosa2 here] end
		// % protected region % [Add customisation for diagnosa3 here] off begin
		String randomStringforDiagnosa3 = mock
				.strings()
				.get();
		newEntity.setDiagnosa3(randomStringforDiagnosa3);
		// % protected region % [Add customisation for diagnosa3 here] end
		// % protected region % [Add customisation for kesadaran here] off begin
		String randomStringforKesadaran = mock
				.strings()
				.get();
		newEntity.setKesadaran(randomStringforKesadaran);
		// % protected region % [Add customisation for kesadaran here] end
		// % protected region % [Add customisation for sistole here] off begin
		String randomStringforSistole = mock
				.strings()
				.get();
		newEntity.setSistole(randomStringforSistole);
		// % protected region % [Add customisation for sistole here] end
		// % protected region % [Add customisation for diastole here] off begin
		String randomStringforDiastole = mock
				.strings()
				.get();
		newEntity.setDiastole(randomStringforDiastole);
		// % protected region % [Add customisation for diastole here] end
		// % protected region % [Add customisation for beratBadan here] off begin
		String randomStringforBeratbadan = mock
				.strings()
				.get();
		newEntity.setBeratbadan(randomStringforBeratbadan);
		// % protected region % [Add customisation for beratBadan here] end
		// % protected region % [Add customisation for tinggiBadan here] off begin
		String randomStringforTinggibadan = mock
				.strings()
				.get();
		newEntity.setTinggibadan(randomStringforTinggibadan);
		// % protected region % [Add customisation for tinggiBadan here] end
		// % protected region % [Add customisation for respiratoryRate here] off begin
		String randomStringforRespiratoryrate = mock
				.strings()
				.get();
		newEntity.setRespiratoryrate(randomStringforRespiratoryrate);
		// % protected region % [Add customisation for respiratoryRate here] end
		// % protected region % [Add customisation for heartRate here] off begin
		String randomStringforHeartrate = mock
				.strings()
				.get();
		newEntity.setHeartrate(randomStringforHeartrate);
		// % protected region % [Add customisation for heartRate here] end
		// % protected region % [Add customisation for catatan here] off begin
		String randomStringforCatatan = mock
				.strings()
				.get();
		newEntity.setCatatan(randomStringforCatatan);
		// % protected region % [Add customisation for catatan here] end
		// % protected region % [Add customisation for pemeriksaanFisikLain here] off begin
		String randomStringforPemeriksaanfisiklain = mock
				.strings()
				.get();
		newEntity.setPemeriksaanfisiklain(randomStringforPemeriksaanfisiklain);
		// % protected region % [Add customisation for pemeriksaanFisikLain here] end
		// % protected region % [Add customisation for tglPulang here] off begin
		String randomStringforTglpulang = mock
				.strings()
				.get();
		newEntity.setTglpulang(randomStringforTglpulang);
		// % protected region % [Add customisation for tglPulang here] end
		// % protected region % [Add customisation for dokter here] off begin
		String randomStringforDokter = mock
				.strings()
				.get();
		newEntity.setDokter(randomStringforDokter);
		// % protected region % [Add customisation for dokter here] end
		// % protected region % [Add customisation for statusPulang here] off begin
		String randomStringforStatuspulang = mock
				.strings()
				.get();
		newEntity.setStatuspulang(randomStringforStatuspulang);
		// % protected region % [Add customisation for statusPulang here] end
		// % protected region % [Add customisation for tingkatPelayanan here] off begin
		String randomStringforTingkatpelayanan = mock
				.strings()
				.get();
		newEntity.setTingkatpelayanan(randomStringforTingkatpelayanan);
		// % protected region % [Add customisation for tingkatPelayanan here] end
		// % protected region % [Add customisation for rujukBalik here] off begin
		String randomStringforRujukbalik = mock
				.strings()
				.get();
		newEntity.setRujukbalik(randomStringforRujukbalik);
		// % protected region % [Add customisation for rujukBalik here] end
		// % protected region % [Add customisation for providerAsalRujuk here] off begin
		String randomStringforProviderasalrujuk = mock
				.strings()
				.get();
		newEntity.setProviderasalrujuk(randomStringforProviderasalrujuk);
		// % protected region % [Add customisation for providerAsalRujuk here] end
		// % protected region % [Add customisation for providerRujukLanjut here] off begin
		String randomStringforProviderrujuklanjut = mock
				.strings()
				.get();
		newEntity.setProviderrujuklanjut(randomStringforProviderrujuklanjut);
		// % protected region % [Add customisation for providerRujukLanjut here] end
		// % protected region % [Add customisation for poliRujukInternal here] off begin
		String randomStringforPolirujukinternal = mock
				.strings()
				.get();
		newEntity.setPolirujukinternal(randomStringforPolirujukinternal);
		// % protected region % [Add customisation for poliRujukInternal here] end
		// % protected region % [Add customisation for poliRujukLanjut here] off begin
		String randomStringforPolirujuklanjut = mock
				.strings()
				.get();
		newEntity.setPolirujuklanjut(randomStringforPolirujuklanjut);
		// % protected region % [Add customisation for poliRujukLanjut here] end

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPcareRiwayatKunjunganEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Bpjs Pcare Riwayat Kunjungan entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPcareRiwayatKunjunganEntitiesWithNoRef")
	public Collection<BpjsPcareRiwayatKunjunganEntity> bpjsPcareRiwayatKunjunganEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareRiwayatKunjunganEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareRiwayatKunjunganEntitiesWithNoRef here] end
		BpjsPcareRiwayatKunjunganEntityFactory bpjsPcareRiwayatKunjunganEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareRiwayatKunjunganEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntitiesWithNoRef before the main body here] end

		Collection<BpjsPcareRiwayatKunjunganEntity> newEntities = bpjsPcareRiwayatKunjunganEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPcareRiwayatKunjunganEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Bpjs Pcare Riwayat Kunjungan entity with all references set.
	 */
	@Provides
	@Named("bpjsPcareRiwayatKunjunganEntityWithRefs")
	public BpjsPcareRiwayatKunjunganEntity bpjsPcareRiwayatKunjunganEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareRiwayatKunjunganEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareRiwayatKunjunganEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPcareRiwayatKunjunganEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntityWithRefs before the main body here] end

		BpjsPcareRiwayatKunjunganEntity bpjsPcareRiwayatKunjunganEntity = injector.getInstance(Key.get(BpjsPcareRiwayatKunjunganEntity.class, Names.named("bpjsPcareRiwayatKunjunganEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPcareRiwayatKunjunganEntity with references");

		return bpjsPcareRiwayatKunjunganEntity;
	}

	/**
	 * Return a collection of Bpjs Pcare Riwayat Kunjungan entities with all references set.
	 */
	@Provides
	@Named("bpjsPcareRiwayatKunjunganEntitiesWithRefs")
	public Collection<BpjsPcareRiwayatKunjunganEntity> bpjsPcareRiwayatKunjunganEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareRiwayatKunjunganEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareRiwayatKunjunganEntitiesWithRefs here] end
		BpjsPcareRiwayatKunjunganEntityFactory bpjsPcareRiwayatKunjunganEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareRiwayatKunjunganEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntitiesWithRefs before the main body here] end

		Collection<BpjsPcareRiwayatKunjunganEntity> newEntities = bpjsPcareRiwayatKunjunganEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRiwayatKunjunganEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPcareRiwayatKunjunganEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
