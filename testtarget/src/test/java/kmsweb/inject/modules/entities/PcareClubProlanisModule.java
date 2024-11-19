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
 * Guice module for PCare Club Prolanis used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareClubProlanisModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareClubProlanisModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareClubProlanisModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareClubProlanisEntityFactory pcareClubProlanisEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareClubProlanisEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareClubProlanisEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareClubProlanisEntityFactory");

		// % protected region % [Apply any additional logic for pcareClubProlanisEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisEntityFactory before the main body here] end

		PcareClubProlanisEntityFactory entityFactory = new PcareClubProlanisEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareClubProlanisEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareClubProlanisEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareClubProlanisEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisEntityFactory after the main body here] end

		log.trace("Created PcareClubProlanisEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Club Prolanis entity with no references set.
	 */
	@Provides
	@Named("pcareClubProlanisEntityWithNoRef")
	public PcareClubProlanisEntity pcareClubProlanisEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareClubProlanisEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareClubProlanisEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareClubProlanisEntity with no reference");

		// % protected region % [Apply any additional logic for pcareClubProlanisWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisWithNoRef before the main body here] end

		PcareClubProlanisEntity newEntity = new PcareClubProlanisEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Club ID here] off begin
		String randomStringforClubID = mock
				.strings()
				.get();
		newEntity.setClubID(randomStringforClubID);
		// % protected region % [Add customisation for Club ID here] end
		// % protected region % [Add customisation for Kode Program here] off begin
		String randomStringforKodeProgram = mock
				.strings()
				.get();
		newEntity.setKodeProgram(randomStringforKodeProgram);
		// % protected region % [Add customisation for Kode Program here] end
		// % protected region % [Add customisation for Nama Program here] off begin
		String randomStringforNamaProgram = mock
				.strings()
				.get();
		newEntity.setNamaProgram(randomStringforNamaProgram);
		// % protected region % [Add customisation for Nama Program here] end
		// % protected region % [Add customisation for Tanggal Mulai here] off begin
		String randomStringforTanggalMulai = mock
				.strings()
				.get();
		newEntity.setTanggalMulai(randomStringforTanggalMulai);
		// % protected region % [Add customisation for Tanggal Mulai here] end
		// % protected region % [Add customisation for Tanggal Akhir here] off begin
		String randomStringforTanggalAkhir = mock
				.strings()
				.get();
		newEntity.setTanggalAkhir(randomStringforTanggalAkhir);
		// % protected region % [Add customisation for Tanggal Akhir here] end
		// % protected region % [Add customisation for Alamat Club here] off begin
		String randomStringforAlamatClub = mock
				.strings()
				.get();
		newEntity.setAlamatClub(randomStringforAlamatClub);
		// % protected region % [Add customisation for Alamat Club here] end
		// % protected region % [Add customisation for Nama Club here] off begin
		String randomStringforNamaClub = mock
				.strings()
				.get();
		newEntity.setNamaClub(randomStringforNamaClub);
		// % protected region % [Add customisation for Nama Club here] end
		// % protected region % [Add customisation for No HP Ketua here] off begin
		String randomStringforNoHPKetua = mock
				.strings()
				.get();
		newEntity.setNoHPKetua(randomStringforNoHPKetua);
		// % protected region % [Add customisation for No HP Ketua here] end
		// % protected region % [Add customisation for Nama Ketua here] off begin
		String randomStringforNamaKetua = mock
				.strings()
				.get();
		newEntity.setNamaKetua(randomStringforNamaKetua);
		// % protected region % [Add customisation for Nama Ketua here] end

		// % protected region % [Apply any additional logic for pcareClubProlanisWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisWithNoRef after the main body here] end

		log.trace("Created entity of type PcareClubProlanisEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Club Prolanis entities with no reference at all.
	 */
	@Provides
	@Named("pcareClubProlanisEntitiesWithNoRef")
	public Collection<PcareClubProlanisEntity> pcareClubProlanisEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareClubProlanisEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareClubProlanisEntitiesWithNoRef here] end
		PcareClubProlanisEntityFactory pcareClubProlanisEntityFactory
	) {
		log.trace("Creating entities of type PcareClubProlanisEntity with no reference");

		// % protected region % [Apply any additional logic for pcareClubProlanisEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisEntitiesWithNoRef before the main body here] end

		Collection<PcareClubProlanisEntity> newEntities = pcareClubProlanisEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareClubProlanisEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareClubProlanisEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Club Prolanis entity with all references set.
	 */
	@Provides
	@Named("pcareClubProlanisEntityWithRefs")
	public PcareClubProlanisEntity pcareClubProlanisEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareClubProlanisEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareClubProlanisEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareClubProlanisEntity with references");

		// % protected region % [Apply any additional logic for pcareClubProlanisEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisEntityWithRefs before the main body here] end

		PcareClubProlanisEntity pcareClubProlanisEntity = injector.getInstance(Key.get(PcareClubProlanisEntity.class, Names.named("pcareClubProlanisEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareClubProlanisEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareClubProlanisEntity with references");

		return pcareClubProlanisEntity;
	}

	/**
	 * Return a collection of PCare Club Prolanis entities with all references set.
	 */
	@Provides
	@Named("pcareClubProlanisEntitiesWithRefs")
	public Collection<PcareClubProlanisEntity> pcareClubProlanisEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareClubProlanisEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareClubProlanisEntitiesWithRefs here] end
		PcareClubProlanisEntityFactory pcareClubProlanisEntityFactory
	) {
		log.trace("Creating entities of type PcareClubProlanisEntity with references");

		// % protected region % [Apply any additional logic for pcareClubProlanisEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisEntitiesWithRefs before the main body here] end

		Collection<PcareClubProlanisEntity> newEntities = pcareClubProlanisEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareClubProlanisEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareClubProlanisEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareClubProlanisEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
