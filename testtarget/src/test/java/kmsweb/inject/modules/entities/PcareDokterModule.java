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
 * Guice module for PCare Dokter used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareDokterModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareDokterModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareDokterModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareDokterEntityFactory pcareDokterEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareDokterEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareDokterEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareDokterEntityFactory");

		// % protected region % [Apply any additional logic for pcareDokterEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterEntityFactory before the main body here] end

		PcareDokterEntityFactory entityFactory = new PcareDokterEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareDokterEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareDokterEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareDokterEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterEntityFactory after the main body here] end

		log.trace("Created PcareDokterEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Dokter entity with no references set.
	 */
	@Provides
	@Named("pcareDokterEntityWithNoRef")
	public PcareDokterEntity pcareDokterEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareDokterEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareDokterEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareDokterEntity with no reference");

		// % protected region % [Apply any additional logic for pcareDokterWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterWithNoRef before the main body here] end

		PcareDokterEntity newEntity = new PcareDokterEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kode Dokter here] off begin
		String randomStringforKodeDokter = mock
				.strings()
				.get();
		newEntity.setKodeDokter(randomStringforKodeDokter);
		// % protected region % [Add customisation for Kode Dokter here] end
		// % protected region % [Add customisation for Nama Dokter here] off begin
		String randomStringforNamaDokter = mock
				.strings()
				.get();
		newEntity.setNamaDokter(randomStringforNamaDokter);
		// % protected region % [Add customisation for Nama Dokter here] end

		// % protected region % [Apply any additional logic for pcareDokterWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterWithNoRef after the main body here] end

		log.trace("Created entity of type PcareDokterEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Dokter entities with no reference at all.
	 */
	@Provides
	@Named("pcareDokterEntitiesWithNoRef")
	public Collection<PcareDokterEntity> pcareDokterEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareDokterEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareDokterEntitiesWithNoRef here] end
		PcareDokterEntityFactory pcareDokterEntityFactory
	) {
		log.trace("Creating entities of type PcareDokterEntity with no reference");

		// % protected region % [Apply any additional logic for pcareDokterEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterEntitiesWithNoRef before the main body here] end

		Collection<PcareDokterEntity> newEntities = pcareDokterEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareDokterEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareDokterEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Dokter entity with all references set.
	 */
	@Provides
	@Named("pcareDokterEntityWithRefs")
	public PcareDokterEntity pcareDokterEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareDokterEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareDokterEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareDokterEntity with references");

		// % protected region % [Apply any additional logic for pcareDokterEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterEntityWithRefs before the main body here] end

		PcareDokterEntity pcareDokterEntity = injector.getInstance(Key.get(PcareDokterEntity.class, Names.named("pcareDokterEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareDokterEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareDokterEntity with references");

		return pcareDokterEntity;
	}

	/**
	 * Return a collection of PCare Dokter entities with all references set.
	 */
	@Provides
	@Named("pcareDokterEntitiesWithRefs")
	public Collection<PcareDokterEntity> pcareDokterEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareDokterEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareDokterEntitiesWithRefs here] end
		PcareDokterEntityFactory pcareDokterEntityFactory
	) {
		log.trace("Creating entities of type PcareDokterEntity with references");

		// % protected region % [Apply any additional logic for pcareDokterEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterEntitiesWithRefs before the main body here] end

		Collection<PcareDokterEntity> newEntities = pcareDokterEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareDokterEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDokterEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareDokterEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
