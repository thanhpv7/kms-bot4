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
 * Guice module for Chart of Account Mapping used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ChartOfAccountMappingModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ChartOfAccountMappingModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ChartOfAccountMappingModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ChartOfAccountMappingEntityFactory chartOfAccountMappingEntityFactory(
			// % protected region % [Apply any additional injected arguments for chartOfAccountMappingEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for chartOfAccountMappingEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ChartOfAccountMappingEntityFactory");

		// % protected region % [Apply any additional logic for chartOfAccountMappingEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingEntityFactory before the main body here] end

		ChartOfAccountMappingEntityFactory entityFactory = new ChartOfAccountMappingEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ChartOfAccountMappingEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ChartOfAccountMappingEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for chartOfAccountMappingEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingEntityFactory after the main body here] end

		log.trace("Created ChartOfAccountMappingEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Chart of Account Mapping entity with no references set.
	 */
	@Provides
	@Named("chartOfAccountMappingEntityWithNoRef")
	public ChartOfAccountMappingEntity chartOfAccountMappingEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for chartOfAccountMappingEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for chartOfAccountMappingEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ChartOfAccountMappingEntity with no reference");

		// % protected region % [Apply any additional logic for chartOfAccountMappingWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingWithNoRef before the main body here] end

		ChartOfAccountMappingEntity newEntity = new ChartOfAccountMappingEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Account Type here] off begin
		String randomStringforAccountType = mock
				.strings()
				.get();
		newEntity.setAccountType(randomStringforAccountType);
		// % protected region % [Add customisation for Account Type here] end
		// % protected region % [Add customisation for Account Type Description here] off begin
		String randomStringforAccountTypeDescription = mock
				.strings()
				.get();
		newEntity.setAccountTypeDescription(randomStringforAccountTypeDescription);
		// % protected region % [Add customisation for Account Type Description here] end

		// % protected region % [Apply any additional logic for chartOfAccountMappingWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingWithNoRef after the main body here] end

		log.trace("Created entity of type ChartOfAccountMappingEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Chart of Account Mapping entities with no reference at all.
	 */
	@Provides
	@Named("chartOfAccountMappingEntitiesWithNoRef")
	public Collection<ChartOfAccountMappingEntity> chartOfAccountMappingEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for chartOfAccountMappingEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for chartOfAccountMappingEntitiesWithNoRef here] end
		ChartOfAccountMappingEntityFactory chartOfAccountMappingEntityFactory
	) {
		log.trace("Creating entities of type ChartOfAccountMappingEntity with no reference");

		// % protected region % [Apply any additional logic for chartOfAccountMappingEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingEntitiesWithNoRef before the main body here] end

		Collection<ChartOfAccountMappingEntity> newEntities = chartOfAccountMappingEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for chartOfAccountMappingEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ChartOfAccountMappingEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Chart of Account Mapping entity with all references set.
	 */
	@Provides
	@Named("chartOfAccountMappingEntityWithRefs")
	public ChartOfAccountMappingEntity chartOfAccountMappingEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for chartOfAccountMappingEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for chartOfAccountMappingEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ChartOfAccountMappingEntity with references");

		// % protected region % [Apply any additional logic for chartOfAccountMappingEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingEntityWithRefs before the main body here] end

		ChartOfAccountMappingEntity chartOfAccountMappingEntity = injector.getInstance(Key.get(ChartOfAccountMappingEntity.class, Names.named("chartOfAccountMappingEntityWithNoRef")));

		// % protected region % [Apply any additional logic for chartOfAccountMappingEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingEntityWithRefs after the main body here] end

		log.trace("Created entity of type ChartOfAccountMappingEntity with references");

		return chartOfAccountMappingEntity;
	}

	/**
	 * Return a collection of Chart of Account Mapping entities with all references set.
	 */
	@Provides
	@Named("chartOfAccountMappingEntitiesWithRefs")
	public Collection<ChartOfAccountMappingEntity> chartOfAccountMappingEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for chartOfAccountMappingEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for chartOfAccountMappingEntitiesWithRefs here] end
		ChartOfAccountMappingEntityFactory chartOfAccountMappingEntityFactory
	) {
		log.trace("Creating entities of type ChartOfAccountMappingEntity with references");

		// % protected region % [Apply any additional logic for chartOfAccountMappingEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingEntitiesWithRefs before the main body here] end

		Collection<ChartOfAccountMappingEntity> newEntities = chartOfAccountMappingEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for chartOfAccountMappingEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for chartOfAccountMappingEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ChartOfAccountMappingEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
