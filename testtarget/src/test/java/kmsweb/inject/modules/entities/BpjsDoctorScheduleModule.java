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
 * Guice module for BPJS Doctor Schedule used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsDoctorScheduleModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsDoctorScheduleModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsDoctorScheduleModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsDoctorScheduleEntityFactory bpjsDoctorScheduleEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsDoctorScheduleEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsDoctorScheduleEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsDoctorScheduleEntityFactory");

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntityFactory before the main body here] end

		BpjsDoctorScheduleEntityFactory entityFactory = new BpjsDoctorScheduleEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsDoctorScheduleEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsDoctorScheduleEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntityFactory after the main body here] end

		log.trace("Created BpjsDoctorScheduleEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Doctor Schedule entity with no references set.
	 */
	@Provides
	@Named("bpjsDoctorScheduleEntityWithNoRef")
	public BpjsDoctorScheduleEntity bpjsDoctorScheduleEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsDoctorScheduleEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDoctorScheduleEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsDoctorScheduleEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleWithNoRef before the main body here] end

		BpjsDoctorScheduleEntity newEntity = new BpjsDoctorScheduleEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Hari here] off begin
		newEntity.setHari(mock.ints().get());
		// % protected region % [Add customisation for Hari here] end
		// % protected region % [Add customisation for Nama Hari here] off begin
		String randomStringforNamaHari = mock
				.strings()
				.get();
		newEntity.setNamaHari(randomStringforNamaHari);
		// % protected region % [Add customisation for Nama Hari here] end
		// % protected region % [Add customisation for Kapasitas here] off begin
		newEntity.setKapasitas(mock.ints().get());
		// % protected region % [Add customisation for Kapasitas here] end
		// % protected region % [Add customisation for JKN Quota here] off begin
		newEntity.setJknQuota(mock.ints().get());
		// % protected region % [Add customisation for JKN Quota here] end
		// % protected region % [Add customisation for JKN Non Quota here] off begin
		newEntity.setJknNonQuota(mock.ints().get());
		// % protected region % [Add customisation for JKN Non Quota here] end
		// % protected region % [Add customisation for Interval here] off begin
		newEntity.setInterval(mock.ints().get());
		// % protected region % [Add customisation for Interval here] end
		// % protected region % [Add customisation for Libur here] off begin
		newEntity.setLibur(mock.bools().get());
		// % protected region % [Add customisation for Libur here] end
		// % protected region % [Add customisation for Jam Buka here] off begin
		String randomStringforJamBuka = mock
				.strings()
				.get();
		newEntity.setJamBuka(randomStringforJamBuka);
		// % protected region % [Add customisation for Jam Buka here] end
		// % protected region % [Add customisation for Jam Tutup here] off begin
		String randomStringforJamTutup = mock
				.strings()
				.get();
		newEntity.setJamTutup(randomStringforJamTutup);
		// % protected region % [Add customisation for Jam Tutup here] end
		// % protected region % [Add customisation for kodepoli here] off begin
		String randomStringforKodepoli = mock
				.strings()
				.get();
		newEntity.setKodepoli(randomStringforKodepoli);
		// % protected region % [Add customisation for kodepoli here] end
		// % protected region % [Add customisation for namapoli here] off begin
		String randomStringforNamapoli = mock
				.strings()
				.get();
		newEntity.setNamapoli(randomStringforNamapoli);
		// % protected region % [Add customisation for namapoli here] end
		// % protected region % [Add customisation for kodesubspesialis here] off begin
		String randomStringforKodesubspesialis = mock
				.strings()
				.get();
		newEntity.setKodesubspesialis(randomStringforKodesubspesialis);
		// % protected region % [Add customisation for kodesubspesialis here] end
		// % protected region % [Add customisation for namasubspesialis here] off begin
		String randomStringforNamasubspesialis = mock
				.strings()
				.get();
		newEntity.setNamasubspesialis(randomStringforNamasubspesialis);
		// % protected region % [Add customisation for namasubspesialis here] end
		// % protected region % [Add customisation for kodedokter here] off begin
		String randomStringforKodedokter = mock
				.strings()
				.get();
		newEntity.setKodedokter(randomStringforKodedokter);
		// % protected region % [Add customisation for kodedokter here] end
		// % protected region % [Add customisation for namadokter here] off begin
		String randomStringforNamadokter = mock
				.strings()
				.get();
		newEntity.setNamadokter(randomStringforNamadokter);
		// % protected region % [Add customisation for namadokter here] end

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsDoctorScheduleEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Doctor Schedule entities with no reference at all.
	 */
	@Provides
	@Named("bpjsDoctorScheduleEntitiesWithNoRef")
	public Collection<BpjsDoctorScheduleEntity> bpjsDoctorScheduleEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsDoctorScheduleEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDoctorScheduleEntitiesWithNoRef here] end
		BpjsDoctorScheduleEntityFactory bpjsDoctorScheduleEntityFactory
	) {
		log.trace("Creating entities of type BpjsDoctorScheduleEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntitiesWithNoRef before the main body here] end

		Collection<BpjsDoctorScheduleEntity> newEntities = bpjsDoctorScheduleEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsDoctorScheduleEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Doctor Schedule entity with all references set.
	 */
	@Provides
	@Named("bpjsDoctorScheduleEntityWithRefs")
	public BpjsDoctorScheduleEntity bpjsDoctorScheduleEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsDoctorScheduleEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsDoctorScheduleEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsDoctorScheduleEntity with references");

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntityWithRefs before the main body here] end

		BpjsDoctorScheduleEntity bpjsDoctorScheduleEntity = injector.getInstance(Key.get(BpjsDoctorScheduleEntity.class, Names.named("bpjsDoctorScheduleEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsDoctorScheduleEntity with references");

		return bpjsDoctorScheduleEntity;
	}

	/**
	 * Return a collection of BPJS Doctor Schedule entities with all references set.
	 */
	@Provides
	@Named("bpjsDoctorScheduleEntitiesWithRefs")
	public Collection<BpjsDoctorScheduleEntity> bpjsDoctorScheduleEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsDoctorScheduleEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsDoctorScheduleEntitiesWithRefs here] end
		BpjsDoctorScheduleEntityFactory bpjsDoctorScheduleEntityFactory
	) {
		log.trace("Creating entities of type BpjsDoctorScheduleEntity with references");

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntitiesWithRefs before the main body here] end

		Collection<BpjsDoctorScheduleEntity> newEntities = bpjsDoctorScheduleEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsDoctorScheduleEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsDoctorScheduleEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
