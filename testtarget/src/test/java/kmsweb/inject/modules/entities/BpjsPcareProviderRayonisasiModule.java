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
 * Guice module for BPJS Pcare Provider Rayonisasi used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsPcareProviderRayonisasiModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsPcareProviderRayonisasiModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsPcareProviderRayonisasiModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsPcareProviderRayonisasiEntityFactory bpjsPcareProviderRayonisasiEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsPcareProviderRayonisasiEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsPcareProviderRayonisasiEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsPcareProviderRayonisasiEntityFactory");

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntityFactory before the main body here] end

		BpjsPcareProviderRayonisasiEntityFactory entityFactory = new BpjsPcareProviderRayonisasiEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsPcareProviderRayonisasiEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsPcareProviderRayonisasiEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntityFactory after the main body here] end

		log.trace("Created BpjsPcareProviderRayonisasiEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Pcare Provider Rayonisasi entity with no references set.
	 */
	@Provides
	@Named("bpjsPcareProviderRayonisasiEntityWithNoRef")
	public BpjsPcareProviderRayonisasiEntity bpjsPcareProviderRayonisasiEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareProviderRayonisasiEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareProviderRayonisasiEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsPcareProviderRayonisasiEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiWithNoRef before the main body here] end

		BpjsPcareProviderRayonisasiEntity newEntity = new BpjsPcareProviderRayonisasiEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
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

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsPcareProviderRayonisasiEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Provider Rayonisasi entities with no reference at all.
	 */
	@Provides
	@Named("bpjsPcareProviderRayonisasiEntitiesWithNoRef")
	public Collection<BpjsPcareProviderRayonisasiEntity> bpjsPcareProviderRayonisasiEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareProviderRayonisasiEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareProviderRayonisasiEntitiesWithNoRef here] end
		BpjsPcareProviderRayonisasiEntityFactory bpjsPcareProviderRayonisasiEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareProviderRayonisasiEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntitiesWithNoRef before the main body here] end

		Collection<BpjsPcareProviderRayonisasiEntity> newEntities = bpjsPcareProviderRayonisasiEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsPcareProviderRayonisasiEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Pcare Provider Rayonisasi entity with all references set.
	 */
	@Provides
	@Named("bpjsPcareProviderRayonisasiEntityWithRefs")
	public BpjsPcareProviderRayonisasiEntity bpjsPcareProviderRayonisasiEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsPcareProviderRayonisasiEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsPcareProviderRayonisasiEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsPcareProviderRayonisasiEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntityWithRefs before the main body here] end

		BpjsPcareProviderRayonisasiEntity bpjsPcareProviderRayonisasiEntity = injector.getInstance(Key.get(BpjsPcareProviderRayonisasiEntity.class, Names.named("bpjsPcareProviderRayonisasiEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsPcareProviderRayonisasiEntity with references");

		return bpjsPcareProviderRayonisasiEntity;
	}

	/**
	 * Return a collection of BPJS Pcare Provider Rayonisasi entities with all references set.
	 */
	@Provides
	@Named("bpjsPcareProviderRayonisasiEntitiesWithRefs")
	public Collection<BpjsPcareProviderRayonisasiEntity> bpjsPcareProviderRayonisasiEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsPcareProviderRayonisasiEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsPcareProviderRayonisasiEntitiesWithRefs here] end
		BpjsPcareProviderRayonisasiEntityFactory bpjsPcareProviderRayonisasiEntityFactory
	) {
		log.trace("Creating entities of type BpjsPcareProviderRayonisasiEntity with references");

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntitiesWithRefs before the main body here] end

		Collection<BpjsPcareProviderRayonisasiEntity> newEntities = bpjsPcareProviderRayonisasiEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsPcareProviderRayonisasiEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsPcareProviderRayonisasiEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
