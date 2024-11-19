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
 * Guice module for BPJS Pcare Peserta Kegiatan Kelompok used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPcarePesertaKegiatanKelompokModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPcarePesertaKegiatanKelompokModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPcarePesertaKegiatanKelompokModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPcarePesertaKegiatanKelompokEntityFactory bpjsPcarePesertaKegiatanKelompokEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPcarePesertaKegiatanKelompokEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPcarePesertaKegiatanKelompokEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPcarePesertaKegiatanKelompokEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntityFactory before the main body here] end

		BpjsPcarePesertaKegiatanKelompokEntityFactory entityFactory = new BpjsPcarePesertaKegiatanKelompokEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPcarePesertaKegiatanKelompokEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPcarePesertaKegiatanKelompokEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntityFactory after the main body here] end

		log.trace("Created BpjsPcarePesertaKegiatanKelompokEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Pcare Peserta Kegiatan Kelompok entity with no references set.
	 */
	@Provides
	@Named("bpjsPcarePesertaKegiatanKelompokEntityWithNoRef")
	public BpjsPcarePesertaKegiatanKelompokEntity bpjsPcarePesertaKegiatanKelompokEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPcarePesertaKegiatanKelompokEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcarePesertaKegiatanKelompokEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPcarePesertaKegiatanKelompokEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokWithNoRef before the main body here] end

		BpjsPcarePesertaKegiatanKelompokEntity newEntity = new BpjsPcarePesertaKegiatanKelompokEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for eduId here] off begin
		String randomStringforEduid = mock
				.strings()
				.get();
		newEntity.setEduid(randomStringforEduid);
		// % protected region % [Add customisation for eduId here] end
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
		// % protected region % [Add customisation for kdProvider here] off begin
		String randomStringforKdprovider = mock
				.strings()
				.get();
		newEntity.setKdprovider(randomStringforKdprovider);
		// % protected region % [Add customisation for kdProvider here] end
		// % protected region % [Add customisation for nmProvider here] off begin
		String randomStringforNmprovider = mock
				.strings()
				.get();
		newEntity.setNmprovider(randomStringforNmprovider);
		// % protected region % [Add customisation for nmProvider here] end
		// % protected region % [Add customisation for kdProviderGigi here] off begin
		String randomStringforKdprovidergigi = mock
				.strings()
				.get();
		newEntity.setKdprovidergigi(randomStringforKdprovidergigi);
		// % protected region % [Add customisation for kdProviderGigi here] end
		// % protected region % [Add customisation for nmProviderGigi here] off begin
		String randomStringforNmprovidergigi = mock
				.strings()
				.get();
		newEntity.setNmprovidergigi(randomStringforNmprovidergigi);
		// % protected region % [Add customisation for nmProviderGigi here] end
		// % protected region % [Add customisation for namaKelas here] off begin
		String randomStringforNamakelas = mock
				.strings()
				.get();
		newEntity.setNamakelas(randomStringforNamakelas);
		// % protected region % [Add customisation for namaKelas here] end
		// % protected region % [Add customisation for kodeKelas here] off begin
		String randomStringforKodekelas = mock
				.strings()
				.get();
		newEntity.setKodekelas(randomStringforKodekelas);
		// % protected region % [Add customisation for kodeKelas here] end
		// % protected region % [Add customisation for namaPeserta here] off begin
		String randomStringforNamapeserta = mock
				.strings()
				.get();
		newEntity.setNamapeserta(randomStringforNamapeserta);
		// % protected region % [Add customisation for namaPeserta here] end
		// % protected region % [Add customisation for kodePeserta here] off begin
		String randomStringforKodepeserta = mock
				.strings()
				.get();
		newEntity.setKodepeserta(randomStringforKodepeserta);
		// % protected region % [Add customisation for kodePeserta here] end
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
		// % protected region % [Add customisation for pstProl here] off begin
		String randomStringforPstprol = mock
				.strings()
				.get();
		newEntity.setPstprol(randomStringforPstprol);
		// % protected region % [Add customisation for pstProl here] end
		// % protected region % [Add customisation for pstPrb here] off begin
		String randomStringforPstprb = mock
				.strings()
				.get();
		newEntity.setPstprb(randomStringforPstprb);
		// % protected region % [Add customisation for pstPrb here] end
		// % protected region % [Add customisation for ketAktif here] off begin
		String randomStringforKetaktif = mock
				.strings()
				.get();
		newEntity.setKetaktif(randomStringforKetaktif);
		// % protected region % [Add customisation for ketAktif here] end
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
		// % protected region % [Add customisation for cob here] off begin
		String randomStringforCob = mock
				.strings()
				.get();
		newEntity.setCob(randomStringforCob);
		// % protected region % [Add customisation for cob here] end
		// % protected region % [Add customisation for tunggakan here] off begin
		String randomStringforTunggakan = mock
				.strings()
				.get();
		newEntity.setTunggakan(randomStringforTunggakan);
		// % protected region % [Add customisation for tunggakan here] end

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPcarePesertaKegiatanKelompokEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Peserta Kegiatan Kelompok entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPcarePesertaKegiatanKelompokEntitiesWithNoRef")
	public Collection<BpjsPcarePesertaKegiatanKelompokEntity> bpjsPcarePesertaKegiatanKelompokEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPcarePesertaKegiatanKelompokEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcarePesertaKegiatanKelompokEntitiesWithNoRef here] end
		BpjsPcarePesertaKegiatanKelompokEntityFactory bpjsPcarePesertaKegiatanKelompokEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcarePesertaKegiatanKelompokEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntitiesWithNoRef before the main body here] end

		Collection<BpjsPcarePesertaKegiatanKelompokEntity> newEntities = bpjsPcarePesertaKegiatanKelompokEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPcarePesertaKegiatanKelompokEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Pcare Peserta Kegiatan Kelompok entity with all references set.
	 */
	@Provides
	@Named("bpjsPcarePesertaKegiatanKelompokEntityWithRefs")
	public BpjsPcarePesertaKegiatanKelompokEntity bpjsPcarePesertaKegiatanKelompokEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPcarePesertaKegiatanKelompokEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcarePesertaKegiatanKelompokEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPcarePesertaKegiatanKelompokEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntityWithRefs before the main body here] end

		BpjsPcarePesertaKegiatanKelompokEntity bpjsPcarePesertaKegiatanKelompokEntity = injector.getInstance(Key.get(BpjsPcarePesertaKegiatanKelompokEntity.class, Names.named("bpjsPcarePesertaKegiatanKelompokEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPcarePesertaKegiatanKelompokEntity with references");

		return bpjsPcarePesertaKegiatanKelompokEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Peserta Kegiatan Kelompok entities with all references set.
	 */
	@Provides
	@Named("bpjsPcarePesertaKegiatanKelompokEntitiesWithRefs")
	public Collection<BpjsPcarePesertaKegiatanKelompokEntity> bpjsPcarePesertaKegiatanKelompokEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPcarePesertaKegiatanKelompokEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcarePesertaKegiatanKelompokEntitiesWithRefs here] end
		BpjsPcarePesertaKegiatanKelompokEntityFactory bpjsPcarePesertaKegiatanKelompokEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcarePesertaKegiatanKelompokEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntitiesWithRefs before the main body here] end

		Collection<BpjsPcarePesertaKegiatanKelompokEntity> newEntities = bpjsPcarePesertaKegiatanKelompokEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcarePesertaKegiatanKelompokEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPcarePesertaKegiatanKelompokEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
