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
 * Guice module for BPJS Pcare Registrations used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPcareRegistrationsModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPcareRegistrationsModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPcareRegistrationsModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPcareRegistrationsEntityFactory bpjsPcareRegistrationsEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPcareRegistrationsEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPcareRegistrationsEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPcareRegistrationsEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntityFactory before the main body here] end

		BpjsPcareRegistrationsEntityFactory entityFactory = new BpjsPcareRegistrationsEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPcareRegistrationsEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPcareRegistrationsEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntityFactory after the main body here] end

		log.trace("Created BpjsPcareRegistrationsEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Pcare Registrations entity with no references set.
	 */
	@Provides
	@Named("bpjsPcareRegistrationsEntityWithNoRef")
	public BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareRegistrationsEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareRegistrationsEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPcareRegistrationsEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsWithNoRef before the main body here] end

		BpjsPcareRegistrationsEntity newEntity = new BpjsPcareRegistrationsEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for kdProviderPeserta here] off begin
		String randomStringforKdproviderpeserta = mock
				.strings()
				.get();
		newEntity.setKdproviderpeserta(randomStringforKdproviderpeserta);
		// % protected region % [Add customisation for kdProviderPeserta here] end
		// % protected region % [Add customisation for tglDaftar here] off begin
		String randomStringforTgldaftar = mock
				.strings()
				.get();
		newEntity.setTgldaftar(randomStringforTgldaftar);
		// % protected region % [Add customisation for tglDaftar here] end
		// % protected region % [Add customisation for noKartu here] off begin
		String randomStringforNokartu = mock
				.strings()
				.get();
		newEntity.setNokartu(randomStringforNokartu);
		// % protected region % [Add customisation for noKartu here] end
		// % protected region % [Add customisation for kdPoli here] off begin
		String randomStringforKdpoli = mock
				.strings()
				.get();
		newEntity.setKdpoli(randomStringforKdpoli);
		// % protected region % [Add customisation for kdPoli here] end
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
		// % protected region % [Add customisation for lingkarPerut here] off begin
		String randomStringforLingkarperut = mock
				.strings()
				.get();
		newEntity.setLingkarperut(randomStringforLingkarperut);
		// % protected region % [Add customisation for lingkarPerut here] end
		// % protected region % [Add customisation for rujukInternal here] off begin
		String randomStringforRujukinternal = mock
				.strings()
				.get();
		newEntity.setRujukinternal(randomStringforRujukinternal);
		// % protected region % [Add customisation for rujukInternal here] end
		// % protected region % [Add customisation for heartRate here] off begin
		String randomStringforHeartrate = mock
				.strings()
				.get();
		newEntity.setHeartrate(randomStringforHeartrate);
		// % protected region % [Add customisation for heartRate here] end
		// % protected region % [Add customisation for rujukBalik here] off begin
		String randomStringforRujukbalik = mock
				.strings()
				.get();
		newEntity.setRujukbalik(randomStringforRujukbalik);
		// % protected region % [Add customisation for rujukBalik here] end
		// % protected region % [Add customisation for kdTkp here] off begin
		String randomStringforKdtkp = mock
				.strings()
				.get();
		newEntity.setKdtkp(randomStringforKdtkp);
		// % protected region % [Add customisation for kdTkp here] end

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPcareRegistrationsEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Registrations entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPcareRegistrationsEntitiesWithNoRef")
	public Collection<BpjsPcareRegistrationsEntity> bpjsPcareRegistrationsEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareRegistrationsEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareRegistrationsEntitiesWithNoRef here] end
		BpjsPcareRegistrationsEntityFactory bpjsPcareRegistrationsEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareRegistrationsEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntitiesWithNoRef before the main body here] end

		Collection<BpjsPcareRegistrationsEntity> newEntities = bpjsPcareRegistrationsEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPcareRegistrationsEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Pcare Registrations entity with all references set.
	 */
	@Provides
	@Named("bpjsPcareRegistrationsEntityWithRefs")
	public BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareRegistrationsEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareRegistrationsEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPcareRegistrationsEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntityWithRefs before the main body here] end

		BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity = injector.getInstance(Key.get(BpjsPcareRegistrationsEntity.class, Names.named("bpjsPcareRegistrationsEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPcareRegistrationsEntity with references");

		return bpjsPcareRegistrationsEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Registrations entities with all references set.
	 */
	@Provides
	@Named("bpjsPcareRegistrationsEntitiesWithRefs")
	public Collection<BpjsPcareRegistrationsEntity> bpjsPcareRegistrationsEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareRegistrationsEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareRegistrationsEntitiesWithRefs here] end
		BpjsPcareRegistrationsEntityFactory bpjsPcareRegistrationsEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareRegistrationsEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntitiesWithRefs before the main body here] end

		Collection<BpjsPcareRegistrationsEntity> newEntities = bpjsPcareRegistrationsEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareRegistrationsEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPcareRegistrationsEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
