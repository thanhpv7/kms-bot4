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
 * Guice module for BPJS Bed Availability used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsBedAvailabilityModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsBedAvailabilityModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsBedAvailabilityModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsBedAvailabilityEntityFactory bpjsBedAvailabilityEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsBedAvailabilityEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsBedAvailabilityEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsBedAvailabilityEntityFactory");

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntityFactory before the main body here] end

		BpjsBedAvailabilityEntityFactory entityFactory = new BpjsBedAvailabilityEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsBedAvailabilityEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsBedAvailabilityEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntityFactory after the main body here] end

		log.trace("Created BpjsBedAvailabilityEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Bed Availability entity with no references set.
	 */
	@Provides
	@Named("bpjsBedAvailabilityEntityWithNoRef")
	public BpjsBedAvailabilityEntity bpjsBedAvailabilityEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsBedAvailabilityEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsBedAvailabilityEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsBedAvailabilityEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityWithNoRef before the main body here] end

		BpjsBedAvailabilityEntity newEntity = new BpjsBedAvailabilityEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for koderuang here] off begin
		String randomStringforKoderuang = mock
				.strings()
				.get();
		newEntity.setKoderuang(randomStringforKoderuang);
		// % protected region % [Add customisation for koderuang here] end
		// % protected region % [Add customisation for namaruang here] off begin
		String randomStringforNamaruang = mock
				.strings()
				.get();
		newEntity.setNamaruang(randomStringforNamaruang);
		// % protected region % [Add customisation for namaruang here] end
		// % protected region % [Add customisation for kodekelas here] off begin
		String randomStringforKodekelas = mock
				.strings()
				.get();
		newEntity.setKodekelas(randomStringforKodekelas);
		// % protected region % [Add customisation for kodekelas here] end
		// % protected region % [Add customisation for namakelas here] off begin
		String randomStringforNamakelas = mock
				.strings()
				.get();
		newEntity.setNamakelas(randomStringforNamakelas);
		// % protected region % [Add customisation for namakelas here] end
		// % protected region % [Add customisation for lastupdate here] off begin
		String randomStringforLastupdate = mock
				.strings()
				.get();
		newEntity.setLastupdate(randomStringforLastupdate);
		// % protected region % [Add customisation for lastupdate here] end
		// % protected region % [Add customisation for kapasitas here] off begin
		newEntity.setKapasitas(mock.ints().get());
		// % protected region % [Add customisation for kapasitas here] end
		// % protected region % [Add customisation for tersedia here] off begin
		newEntity.setTersedia(mock.ints().get());
		// % protected region % [Add customisation for tersedia here] end
		// % protected region % [Add customisation for tersediapria here] off begin
		newEntity.setTersediapria(mock.ints().get());
		// % protected region % [Add customisation for tersediapria here] end
		// % protected region % [Add customisation for tersediawanita here] off begin
		newEntity.setTersediawanita(mock.ints().get());
		// % protected region % [Add customisation for tersediawanita here] end
		// % protected region % [Add customisation for tersediapriawanita here] off begin
		newEntity.setTersediapriawanita(mock.ints().get());
		// % protected region % [Add customisation for tersediapriawanita here] end

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsBedAvailabilityEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Bed Availability entities with no reference at all.
	 */
	@Provides
	@Named("bpjsBedAvailabilityEntitiesWithNoRef")
	public Collection<BpjsBedAvailabilityEntity> bpjsBedAvailabilityEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsBedAvailabilityEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsBedAvailabilityEntitiesWithNoRef here] end
		BpjsBedAvailabilityEntityFactory bpjsBedAvailabilityEntityFactory
	) {
		log.trace("Creating entities of type BpjsBedAvailabilityEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntitiesWithNoRef before the main body here] end

		Collection<BpjsBedAvailabilityEntity> newEntities = bpjsBedAvailabilityEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsBedAvailabilityEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Bed Availability entity with all references set.
	 */
	@Provides
	@Named("bpjsBedAvailabilityEntityWithRefs")
	public BpjsBedAvailabilityEntity bpjsBedAvailabilityEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsBedAvailabilityEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsBedAvailabilityEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsBedAvailabilityEntity with references");

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntityWithRefs before the main body here] end

		BpjsBedAvailabilityEntity bpjsBedAvailabilityEntity = injector.getInstance(Key.get(BpjsBedAvailabilityEntity.class, Names.named("bpjsBedAvailabilityEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsBedAvailabilityEntity with references");

		return bpjsBedAvailabilityEntity;
	}

	/**
	 * Return a collection of BPJS Bed Availability entities with all references set.
	 */
	@Provides
	@Named("bpjsBedAvailabilityEntitiesWithRefs")
	public Collection<BpjsBedAvailabilityEntity> bpjsBedAvailabilityEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsBedAvailabilityEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsBedAvailabilityEntitiesWithRefs here] end
		BpjsBedAvailabilityEntityFactory bpjsBedAvailabilityEntityFactory
	) {
		log.trace("Creating entities of type BpjsBedAvailabilityEntity with references");

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntitiesWithRefs before the main body here] end

		Collection<BpjsBedAvailabilityEntity> newEntities = bpjsBedAvailabilityEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsBedAvailabilityEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsBedAvailabilityEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
