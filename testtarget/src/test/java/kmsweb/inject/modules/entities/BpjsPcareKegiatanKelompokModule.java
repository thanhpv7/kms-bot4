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
 * Guice module for BPJS Pcare Kegiatan Kelompok used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPcareKegiatanKelompokModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPcareKegiatanKelompokModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPcareKegiatanKelompokModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPcareKegiatanKelompokEntityFactory bpjsPcareKegiatanKelompokEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPcareKegiatanKelompokEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPcareKegiatanKelompokEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPcareKegiatanKelompokEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntityFactory before the main body here] end

		BpjsPcareKegiatanKelompokEntityFactory entityFactory = new BpjsPcareKegiatanKelompokEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPcareKegiatanKelompokEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPcareKegiatanKelompokEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntityFactory after the main body here] end

		log.trace("Created BpjsPcareKegiatanKelompokEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Pcare Kegiatan Kelompok entity with no references set.
	 */
	@Provides
	@Named("bpjsPcareKegiatanKelompokEntityWithNoRef")
	public BpjsPcareKegiatanKelompokEntity bpjsPcareKegiatanKelompokEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKegiatanKelompokEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKegiatanKelompokEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPcareKegiatanKelompokEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokWithNoRef before the main body here] end

		BpjsPcareKegiatanKelompokEntity newEntity = new BpjsPcareKegiatanKelompokEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for ketuaNama here] off begin
		String randomStringforKetuanama = mock
				.strings()
				.get();
		newEntity.setKetuanama(randomStringforKetuanama);
		// % protected region % [Add customisation for ketuaNama here] end
		// % protected region % [Add customisation for nama here] off begin
		String randomStringforNama = mock
				.strings()
				.get();
		newEntity.setNama(randomStringforNama);
		// % protected region % [Add customisation for nama here] end
		// % protected region % [Add customisation for eduId here] off begin
		String randomStringforEduid = mock
				.strings()
				.get();
		newEntity.setEduid(randomStringforEduid);
		// % protected region % [Add customisation for eduId here] end
		// % protected region % [Add customisation for clubId here] off begin
		String randomStringforClubid = mock
				.strings()
				.get();
		newEntity.setClubid(randomStringforClubid);
		// % protected region % [Add customisation for clubId here] end
		// % protected region % [Add customisation for kdProgram here] off begin
		String randomStringforKdprogram = mock
				.strings()
				.get();
		newEntity.setKdprogram(randomStringforKdprogram);
		// % protected region % [Add customisation for kdProgram here] end
		// % protected region % [Add customisation for nmProgram here] off begin
		String randomStringforNmprogram = mock
				.strings()
				.get();
		newEntity.setNmprogram(randomStringforNmprogram);
		// % protected region % [Add customisation for nmProgram here] end
		// % protected region % [Add customisation for tglMulai here] off begin
		String randomStringforTglmulai = mock
				.strings()
				.get();
		newEntity.setTglmulai(randomStringforTglmulai);
		// % protected region % [Add customisation for tglMulai here] end
		// % protected region % [Add customisation for tglAkhir here] off begin
		String randomStringforTglakhir = mock
				.strings()
				.get();
		newEntity.setTglakhir(randomStringforTglakhir);
		// % protected region % [Add customisation for tglAkhir here] end
		// % protected region % [Add customisation for alamat here] off begin
		String randomStringforAlamat = mock
				.strings()
				.get();
		newEntity.setAlamat(randomStringforAlamat);
		// % protected region % [Add customisation for alamat here] end
		// % protected region % [Add customisation for ketuaNoHp here] off begin
		String randomStringforKetuanohp = mock
				.strings()
				.get();
		newEntity.setKetuanohp(randomStringforKetuanohp);
		// % protected region % [Add customisation for ketuaNoHp here] end
		// % protected region % [Add customisation for tglPelayanan here] off begin
		String randomStringforTglpelayanan = mock
				.strings()
				.get();
		newEntity.setTglpelayanan(randomStringforTglpelayanan);
		// % protected region % [Add customisation for tglPelayanan here] end
		// % protected region % [Add customisation for kegiatanNama here] off begin
		String randomStringforKegiatannama = mock
				.strings()
				.get();
		newEntity.setKegiatannama(randomStringforKegiatannama);
		// % protected region % [Add customisation for kegiatanNama here] end
		// % protected region % [Add customisation for kegiatanKode here] off begin
		String randomStringforKegiatankode = mock
				.strings()
				.get();
		newEntity.setKegiatankode(randomStringforKegiatankode);
		// % protected region % [Add customisation for kegiatanKode here] end
		// % protected region % [Add customisation for kelompokNama here] off begin
		String randomStringforKelompoknama = mock
				.strings()
				.get();
		newEntity.setKelompoknama(randomStringforKelompoknama);
		// % protected region % [Add customisation for kelompokNama here] end
		// % protected region % [Add customisation for kelompokKode here] off begin
		String randomStringforKelompokkode = mock
				.strings()
				.get();
		newEntity.setKelompokkode(randomStringforKelompokkode);
		// % protected region % [Add customisation for kelompokKode here] end
		// % protected region % [Add customisation for materi here] off begin
		String randomStringforMateri = mock
				.strings()
				.get();
		newEntity.setMateri(randomStringforMateri);
		// % protected region % [Add customisation for materi here] end
		// % protected region % [Add customisation for pembicara here] off begin
		String randomStringforPembicara = mock
				.strings()
				.get();
		newEntity.setPembicara(randomStringforPembicara);
		// % protected region % [Add customisation for pembicara here] end
		// % protected region % [Add customisation for lokasi here] off begin
		String randomStringforLokasi = mock
				.strings()
				.get();
		newEntity.setLokasi(randomStringforLokasi);
		// % protected region % [Add customisation for lokasi here] end
		// % protected region % [Add customisation for keterangan here] off begin
		String randomStringforKeterangan = mock
				.strings()
				.get();
		newEntity.setKeterangan(randomStringforKeterangan);
		// % protected region % [Add customisation for keterangan here] end
		// % protected region % [Add customisation for biaya here] off begin
		String randomStringforBiaya = mock
				.strings()
				.get();
		newEntity.setBiaya(randomStringforBiaya);
		// % protected region % [Add customisation for biaya here] end

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPcareKegiatanKelompokEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Kegiatan Kelompok entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPcareKegiatanKelompokEntitiesWithNoRef")
	public Collection<BpjsPcareKegiatanKelompokEntity> bpjsPcareKegiatanKelompokEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKegiatanKelompokEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKegiatanKelompokEntitiesWithNoRef here] end
		BpjsPcareKegiatanKelompokEntityFactory bpjsPcareKegiatanKelompokEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareKegiatanKelompokEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntitiesWithNoRef before the main body here] end

		Collection<BpjsPcareKegiatanKelompokEntity> newEntities = bpjsPcareKegiatanKelompokEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPcareKegiatanKelompokEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Pcare Kegiatan Kelompok entity with all references set.
	 */
	@Provides
	@Named("bpjsPcareKegiatanKelompokEntityWithRefs")
	public BpjsPcareKegiatanKelompokEntity bpjsPcareKegiatanKelompokEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKegiatanKelompokEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareKegiatanKelompokEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPcareKegiatanKelompokEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntityWithRefs before the main body here] end

		BpjsPcareKegiatanKelompokEntity bpjsPcareKegiatanKelompokEntity = injector.getInstance(Key.get(BpjsPcareKegiatanKelompokEntity.class, Names.named("bpjsPcareKegiatanKelompokEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPcareKegiatanKelompokEntity with references");

		return bpjsPcareKegiatanKelompokEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Kegiatan Kelompok entities with all references set.
	 */
	@Provides
	@Named("bpjsPcareKegiatanKelompokEntitiesWithRefs")
	public Collection<BpjsPcareKegiatanKelompokEntity> bpjsPcareKegiatanKelompokEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKegiatanKelompokEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareKegiatanKelompokEntitiesWithRefs here] end
		BpjsPcareKegiatanKelompokEntityFactory bpjsPcareKegiatanKelompokEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareKegiatanKelompokEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntitiesWithRefs before the main body here] end

		Collection<BpjsPcareKegiatanKelompokEntity> newEntities = bpjsPcareKegiatanKelompokEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareKegiatanKelompokEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPcareKegiatanKelompokEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
