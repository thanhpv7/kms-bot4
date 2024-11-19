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
 * Guice module for BPJS Service Mapping used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsServiceMappingModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsServiceMappingModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsServiceMappingModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsServiceMappingEntityFactory bpjsServiceMappingEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsServiceMappingEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsServiceMappingEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsServiceMappingEntityFactory");

		// % protected region % [Apply any additional logic for bpjsServiceMappingEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingEntityFactory before the main body here] end

		BpjsServiceMappingEntityFactory entityFactory = new BpjsServiceMappingEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsServiceMappingEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsServiceMappingEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsServiceMappingEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingEntityFactory after the main body here] end

		log.trace("Created BpjsServiceMappingEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Service Mapping entity with no references set.
	 */
	@Provides
	@Named("bpjsServiceMappingEntityWithNoRef")
	public BpjsServiceMappingEntity bpjsServiceMappingEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsServiceMappingEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsServiceMappingEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsServiceMappingEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsServiceMappingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingWithNoRef before the main body here] end

		BpjsServiceMappingEntity newEntity = new BpjsServiceMappingEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Ref Code here] off begin
		String randomStringforRefCode = mock
				.strings()
				.size(25)
				.get();
		newEntity.setRefCode(randomStringforRefCode);
		// % protected region % [Add customisation for Ref Code here] end
		// % protected region % [Add customisation for Ref Service here] off begin
		String randomStringforRefService = mock
				.strings()
				.size(200)
				.get();
		newEntity.setRefService(randomStringforRefService);
		// % protected region % [Add customisation for Ref Service here] end
		// % protected region % [Add customisation for Kode Subspesialis here] off begin
		String randomStringforKodeSubspesialis = mock
				.strings()
				.get();
		newEntity.setKodeSubspesialis(randomStringforKodeSubspesialis);
		// % protected region % [Add customisation for Kode Subspesialis here] end
		// % protected region % [Add customisation for Nama Subspesialis here] off begin
		String randomStringforNamaSubspesialis = mock
				.strings()
				.get();
		newEntity.setNamaSubspesialis(randomStringforNamaSubspesialis);
		// % protected region % [Add customisation for Nama Subspesialis here] end
		// % protected region % [Add customisation for Categorized as Surgery here] off begin
		newEntity.setCategorizedAsSurgery(mock.bools().get());
		// % protected region % [Add customisation for Categorized as Surgery here] end

		// % protected region % [Apply any additional logic for bpjsServiceMappingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsServiceMappingEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Service Mapping entities with no reference at all.
	 */
	@Provides
	@Named("bpjsServiceMappingEntitiesWithNoRef")
	public Collection<BpjsServiceMappingEntity> bpjsServiceMappingEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsServiceMappingEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsServiceMappingEntitiesWithNoRef here] end
		BpjsServiceMappingEntityFactory bpjsServiceMappingEntityFactory
	) {
		log.trace("Creating entities of type BpjsServiceMappingEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsServiceMappingEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingEntitiesWithNoRef before the main body here] end

		Collection<BpjsServiceMappingEntity> newEntities = bpjsServiceMappingEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsServiceMappingEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsServiceMappingEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Service Mapping entity with all references set.
	 */
	@Provides
	@Named("bpjsServiceMappingEntityWithRefs")
	public BpjsServiceMappingEntity bpjsServiceMappingEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsServiceMappingEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsServiceMappingEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsServiceMappingEntity with references");

		// % protected region % [Apply any additional logic for bpjsServiceMappingEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingEntityWithRefs before the main body here] end

		BpjsServiceMappingEntity bpjsServiceMappingEntity = injector.getInstance(Key.get(BpjsServiceMappingEntity.class, Names.named("bpjsServiceMappingEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsServiceMappingEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsServiceMappingEntity with references");

		return bpjsServiceMappingEntity;
	}

	/**
	 * Return a collection of BPJS Service Mapping entities with all references set.
	 */
	@Provides
	@Named("bpjsServiceMappingEntitiesWithRefs")
	public Collection<BpjsServiceMappingEntity> bpjsServiceMappingEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsServiceMappingEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsServiceMappingEntitiesWithRefs here] end
		BpjsServiceMappingEntityFactory bpjsServiceMappingEntityFactory
	) {
		log.trace("Creating entities of type BpjsServiceMappingEntity with references");

		// % protected region % [Apply any additional logic for bpjsServiceMappingEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingEntitiesWithRefs before the main body here] end

		Collection<BpjsServiceMappingEntity> newEntities = bpjsServiceMappingEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsServiceMappingEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsServiceMappingEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsServiceMappingEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
