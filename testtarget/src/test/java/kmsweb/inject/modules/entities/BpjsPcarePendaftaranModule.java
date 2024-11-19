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
 * Guice module for Bpjs Pcare Pendaftaran used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPcarePendaftaranModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPcarePendaftaranModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPcarePendaftaranModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPcarePendaftaranEntityFactory bpjsPcarePendaftaranEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPcarePendaftaranEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPcarePendaftaranEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPcarePendaftaranEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntityFactory before the main body here] end

		BpjsPcarePendaftaranEntityFactory entityFactory = new BpjsPcarePendaftaranEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPcarePendaftaranEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPcarePendaftaranEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntityFactory after the main body here] end

		log.trace("Created BpjsPcarePendaftaranEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Bpjs Pcare Pendaftaran entity with no references set.
	 */
	@Provides
	@Named("bpjsPcarePendaftaranEntityWithNoRef")
	public BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPcarePendaftaranEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcarePendaftaranEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPcarePendaftaranEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranWithNoRef before the main body here] end

		BpjsPcarePendaftaranEntity newEntity = new BpjsPcarePendaftaranEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noUrut here] off begin
		String randomStringforNourut = mock
				.strings()
				.get();
		newEntity.setNourut(randomStringforNourut);
		// % protected region % [Add customisation for noUrut here] end
		// % protected region % [Add customisation for tgldaftar here] off begin
		String randomStringforTgldaftar = mock
				.strings()
				.get();
		newEntity.setTgldaftar(randomStringforTgldaftar);
		// % protected region % [Add customisation for tgldaftar here] end
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
		// % protected region % [Add customisation for kdProviderPst here] off begin
		String randomStringforKdproviderpst = mock
				.strings()
				.get();
		newEntity.setKdproviderpst(randomStringforKdproviderpst);
		// % protected region % [Add customisation for kdProviderPst here] end
		// % protected region % [Add customisation for kdProviderGigi here] off begin
		String randomStringforKdprovidergigi = mock
				.strings()
				.get();
		newEntity.setKdprovidergigi(randomStringforKdprovidergigi);
		// % protected region % [Add customisation for kdProviderGigi here] end
		// % protected region % [Add customisation for jnsKelas here] off begin
		String randomStringforJnskelas = mock
				.strings()
				.get();
		newEntity.setJnskelas(randomStringforJnskelas);
		// % protected region % [Add customisation for jnsKelas here] end
		// % protected region % [Add customisation for jnsPeserta here] off begin
		String randomStringforJnspeserta = mock
				.strings()
				.get();
		newEntity.setJnspeserta(randomStringforJnspeserta);
		// % protected region % [Add customisation for jnsPeserta here] end
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
		// % protected region % [Add customisation for aktif here] off begin
		String randomStringforAktif = mock
				.strings()
				.get();
		newEntity.setAktif(randomStringforAktif);
		// % protected region % [Add customisation for aktif here] end
		// % protected region % [Add customisation for ketAktif here] off begin
		String randomStringforKetaktif = mock
				.strings()
				.get();
		newEntity.setKetaktif(randomStringforKetaktif);
		// % protected region % [Add customisation for ketAktif here] end
		// % protected region % [Add customisation for asuransi here] off begin
		String randomStringforAsuransi = mock
				.strings()
				.get();
		newEntity.setAsuransi(randomStringforAsuransi);
		// % protected region % [Add customisation for asuransi here] end
		// % protected region % [Add customisation for kdPoli here] off begin
		String randomStringforKdpoli = mock
				.strings()
				.get();
		newEntity.setKdpoli(randomStringforKdpoli);
		// % protected region % [Add customisation for kdPoli here] end
		// % protected region % [Add customisation for nmPoli here] off begin
		String randomStringforNmpoli = mock
				.strings()
				.get();
		newEntity.setNmpoli(randomStringforNmpoli);
		// % protected region % [Add customisation for nmPoli here] end
		// % protected region % [Add customisation for poliSakit here] off begin
		String randomStringforPolisakit = mock
				.strings()
				.get();
		newEntity.setPolisakit(randomStringforPolisakit);
		// % protected region % [Add customisation for poliSakit here] end
		// % protected region % [Add customisation for keluhan here] off begin
		String randomStringforKeluhan = mock
				.strings()
				.get();
		newEntity.setKeluhan(randomStringforKeluhan);
		// % protected region % [Add customisation for keluhan here] end
		// % protected region % [Add customisation for kunjSakit here] off begin
		String randomStringforKunjsakit = mock
				.strings()
				.get();
		newEntity.setKunjsakit(randomStringforKunjsakit);
		// % protected region % [Add customisation for kunjSakit here] end
		// % protected region % [Add customisation for status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for status here] end
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
		// % protected region % [Add customisation for respRate here] off begin
		String randomStringforResprate = mock
				.strings()
				.get();
		newEntity.setResprate(randomStringforResprate);
		// % protected region % [Add customisation for respRate here] end
		// % protected region % [Add customisation for heartRate here] off begin
		String randomStringforHeartrate = mock
				.strings()
				.get();
		newEntity.setHeartrate(randomStringforHeartrate);
		// % protected region % [Add customisation for heartRate here] end
		// % protected region % [Add customisation for kdTkp here] off begin
		String randomStringforKdtkp = mock
				.strings()
				.get();
		newEntity.setKdtkp(randomStringforKdtkp);
		// % protected region % [Add customisation for kdTkp here] end
		// % protected region % [Add customisation for nmTkp here] off begin
		String randomStringforNmtkp = mock
				.strings()
				.get();
		newEntity.setNmtkp(randomStringforNmtkp);
		// % protected region % [Add customisation for nmTkp here] end
		// % protected region % [Add customisation for kdProviderPelayanan here] off begin
		String randomStringforKdproviderpelayanan = mock
				.strings()
				.get();
		newEntity.setKdproviderpelayanan(randomStringforKdproviderpelayanan);
		// % protected region % [Add customisation for kdProviderPelayanan here] end
		// % protected region % [Add customisation for nmProviderPelayanan here] off begin
		String randomStringforNmproviderpelayanan = mock
				.strings()
				.get();
		newEntity.setNmproviderpelayanan(randomStringforNmproviderpelayanan);
		// % protected region % [Add customisation for nmProviderPelayanan here] end
		// % protected region % [Add customisation for nmProviderPst here] off begin
		String randomStringforNmproviderpst = mock
				.strings()
				.get();
		newEntity.setNmproviderpst(randomStringforNmproviderpst);
		// % protected region % [Add customisation for nmProviderPst here] end
		// % protected region % [Add customisation for nmProviderGigi here] off begin
		String randomStringforNmprovidergigi = mock
				.strings()
				.get();
		newEntity.setNmprovidergigi(randomStringforNmprovidergigi);
		// % protected region % [Add customisation for nmProviderGigi here] end
		// % protected region % [Add customisation for kodeKls here] off begin
		String randomStringforKodekls = mock
				.strings()
				.get();
		newEntity.setKodekls(randomStringforKodekls);
		// % protected region % [Add customisation for kodeKls here] end
		// % protected region % [Add customisation for namaKls here] off begin
		String randomStringforNamakls = mock
				.strings()
				.get();
		newEntity.setNamakls(randomStringforNamakls);
		// % protected region % [Add customisation for namaKls here] end
		// % protected region % [Add customisation for kodePeserta here] off begin
		String randomStringforKodepeserta = mock
				.strings()
				.get();
		newEntity.setKodepeserta(randomStringforKodepeserta);
		// % protected region % [Add customisation for kodePeserta here] end
		// % protected region % [Add customisation for namaPeserta here] off begin
		String randomStringforNamapeserta = mock
				.strings()
				.get();
		newEntity.setNamapeserta(randomStringforNamapeserta);
		// % protected region % [Add customisation for namaPeserta here] end
		// % protected region % [Add customisation for kdAsuransi here] off begin
		String randomStringforKdasuransi = mock
				.strings()
				.get();
		newEntity.setKdasuransi(randomStringforKdasuransi);
		// % protected region % [Add customisation for kdAsuransi here] end
		// % protected region % [Add customisation for nmAsuransi here] off begin
		String randomStringforNmasuransi = mock
				.strings()
				.get();
		newEntity.setNmasuransi(randomStringforNmasuransi);
		// % protected region % [Add customisation for nmAsuransi here] end
		// % protected region % [Add customisation for noAsuransi here] off begin
		String randomStringforNoasuransi = mock
				.strings()
				.get();
		newEntity.setNoasuransi(randomStringforNoasuransi);
		// % protected region % [Add customisation for noAsuransi here] end
		// % protected region % [Add customisation for lingkarPerut here] off begin
		String randomStringforLingkarperut = mock
				.strings()
				.get();
		newEntity.setLingkarperut(randomStringforLingkarperut);
		// % protected region % [Add customisation for lingkarPerut here] end

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPcarePendaftaranEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Bpjs Pcare Pendaftaran entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPcarePendaftaranEntitiesWithNoRef")
	public Collection<BpjsPcarePendaftaranEntity> bpjsPcarePendaftaranEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPcarePendaftaranEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcarePendaftaranEntitiesWithNoRef here] end
		BpjsPcarePendaftaranEntityFactory bpjsPcarePendaftaranEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcarePendaftaranEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntitiesWithNoRef before the main body here] end

		Collection<BpjsPcarePendaftaranEntity> newEntities = bpjsPcarePendaftaranEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPcarePendaftaranEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Bpjs Pcare Pendaftaran entity with all references set.
	 */
	@Provides
	@Named("bpjsPcarePendaftaranEntityWithRefs")
	public BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPcarePendaftaranEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcarePendaftaranEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPcarePendaftaranEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntityWithRefs before the main body here] end

		BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntity = injector.getInstance(Key.get(BpjsPcarePendaftaranEntity.class, Names.named("bpjsPcarePendaftaranEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPcarePendaftaranEntity with references");

		return bpjsPcarePendaftaranEntity;
	}

	/**
	 * Return a collection of Bpjs Pcare Pendaftaran entities with all references set.
	 */
	@Provides
	@Named("bpjsPcarePendaftaranEntitiesWithRefs")
	public Collection<BpjsPcarePendaftaranEntity> bpjsPcarePendaftaranEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPcarePendaftaranEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcarePendaftaranEntitiesWithRefs here] end
		BpjsPcarePendaftaranEntityFactory bpjsPcarePendaftaranEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcarePendaftaranEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntitiesWithRefs before the main body here] end

		Collection<BpjsPcarePendaftaranEntity> newEntities = bpjsPcarePendaftaranEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePendaftaranEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPcarePendaftaranEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
