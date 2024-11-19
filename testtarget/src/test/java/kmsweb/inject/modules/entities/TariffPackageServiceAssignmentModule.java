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
 * Guice module for Tariff Package Service Assignment used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class TariffPackageServiceAssignmentModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring TariffPackageServiceAssignmentModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured TariffPackageServiceAssignmentModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public TariffPackageServiceAssignmentEntityFactory tariffPackageServiceAssignmentEntityFactory(
			// % protected region % [Apply any additional injected arguments for tariffPackageServiceAssignmentEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for tariffPackageServiceAssignmentEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating TariffPackageServiceAssignmentEntityFactory");

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntityFactory before the main body here] end

		TariffPackageServiceAssignmentEntityFactory entityFactory = new TariffPackageServiceAssignmentEntityFactory(
				// % protected region % [Apply any additional constructor arguments for TariffPackageServiceAssignmentEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for TariffPackageServiceAssignmentEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntityFactory after the main body here] end

		log.trace("Created TariffPackageServiceAssignmentEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Tariff Package Service Assignment entity with no references set.
	 */
	@Provides
	@Named("tariffPackageServiceAssignmentEntityWithNoRef")
	public TariffPackageServiceAssignmentEntity tariffPackageServiceAssignmentEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for tariffPackageServiceAssignmentEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffPackageServiceAssignmentEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type TariffPackageServiceAssignmentEntity with no reference");

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentWithNoRef before the main body here] end

		TariffPackageServiceAssignmentEntity newEntity = new TariffPackageServiceAssignmentEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Assign Code here] off begin
		String randomStringforAssignCode = mock
				.strings()
				.get();
		newEntity.setAssignCode(randomStringforAssignCode);
		// % protected region % [Add customisation for Assign Code here] end

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentWithNoRef after the main body here] end

		log.trace("Created entity of type TariffPackageServiceAssignmentEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Tariff Package Service Assignment entities with no reference at all.
	 */
	@Provides
	@Named("tariffPackageServiceAssignmentEntitiesWithNoRef")
	public Collection<TariffPackageServiceAssignmentEntity> tariffPackageServiceAssignmentEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for tariffPackageServiceAssignmentEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffPackageServiceAssignmentEntitiesWithNoRef here] end
		TariffPackageServiceAssignmentEntityFactory tariffPackageServiceAssignmentEntityFactory
	) {
		log.trace("Creating entities of type TariffPackageServiceAssignmentEntity with no reference");

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntitiesWithNoRef before the main body here] end

		Collection<TariffPackageServiceAssignmentEntity> newEntities = tariffPackageServiceAssignmentEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type TariffPackageServiceAssignmentEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Tariff Package Service Assignment entity with all references set.
	 */
	@Provides
	@Named("tariffPackageServiceAssignmentEntityWithRefs")
	public TariffPackageServiceAssignmentEntity tariffPackageServiceAssignmentEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for tariffPackageServiceAssignmentEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for tariffPackageServiceAssignmentEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type TariffPackageServiceAssignmentEntity with references");

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntityWithRefs before the main body here] end

		TariffPackageServiceAssignmentEntity tariffPackageServiceAssignmentEntity = injector.getInstance(Key.get(TariffPackageServiceAssignmentEntity.class, Names.named("tariffPackageServiceAssignmentEntityWithNoRef")));

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntityWithRefs after the main body here] end

		log.trace("Created entity of type TariffPackageServiceAssignmentEntity with references");

		return tariffPackageServiceAssignmentEntity;
	}

	/**
	 * Return a collection of Tariff Package Service Assignment entities with all references set.
	 */
	@Provides
	@Named("tariffPackageServiceAssignmentEntitiesWithRefs")
	public Collection<TariffPackageServiceAssignmentEntity> tariffPackageServiceAssignmentEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for tariffPackageServiceAssignmentEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for tariffPackageServiceAssignmentEntitiesWithRefs here] end
		TariffPackageServiceAssignmentEntityFactory tariffPackageServiceAssignmentEntityFactory
	) {
		log.trace("Creating entities of type TariffPackageServiceAssignmentEntity with references");

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntitiesWithRefs before the main body here] end

		Collection<TariffPackageServiceAssignmentEntity> newEntities = tariffPackageServiceAssignmentEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for tariffPackageServiceAssignmentEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type TariffPackageServiceAssignmentEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
