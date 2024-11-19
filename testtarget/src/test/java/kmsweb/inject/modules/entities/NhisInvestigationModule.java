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
 * Guice module for NHIS Investigation used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NhisInvestigationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NhisInvestigationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NhisInvestigationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NhisInvestigationEntityFactory nhisInvestigationEntityFactory(
			// % protected region % [Apply any additional injected arguments for nhisInvestigationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nhisInvestigationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NhisInvestigationEntityFactory");

		// % protected region % [Apply any additional logic for nhisInvestigationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationEntityFactory before the main body here] end

		NhisInvestigationEntityFactory entityFactory = new NhisInvestigationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NhisInvestigationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NhisInvestigationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nhisInvestigationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationEntityFactory after the main body here] end

		log.trace("Created NhisInvestigationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty NHIS Investigation entity with no references set.
	 */
	@Provides
	@Named("nhisInvestigationEntityWithNoRef")
	public NhisInvestigationEntity nhisInvestigationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nhisInvestigationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisInvestigationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NhisInvestigationEntity with no reference");

		// % protected region % [Apply any additional logic for nhisInvestigationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationWithNoRef before the main body here] end

		NhisInvestigationEntity newEntity = new NhisInvestigationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for GDRG Code here] off begin
		String randomStringforGdrgCode = mock
				.strings()
				.get();
		newEntity.setGdrgCode(randomStringforGdrgCode);
		// % protected region % [Add customisation for GDRG Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Category here] off begin
		String randomStringforCategory = mock
				.strings()
				.get();
		newEntity.setCategory(randomStringforCategory);
		// % protected region % [Add customisation for Category here] end
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mock.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Date here] off begin
		newEntity.setDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Date here] end

		// % protected region % [Apply any additional logic for nhisInvestigationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationWithNoRef after the main body here] end

		log.trace("Created entity of type NhisInvestigationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of NHIS Investigation entities with no reference at all.
	 */
	@Provides
	@Named("nhisInvestigationEntitiesWithNoRef")
	public Collection<NhisInvestigationEntity> nhisInvestigationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nhisInvestigationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisInvestigationEntitiesWithNoRef here] end
		NhisInvestigationEntityFactory nhisInvestigationEntityFactory
	) {
		log.trace("Creating entities of type NhisInvestigationEntity with no reference");

		// % protected region % [Apply any additional logic for nhisInvestigationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationEntitiesWithNoRef before the main body here] end

		Collection<NhisInvestigationEntity> newEntities = nhisInvestigationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nhisInvestigationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NhisInvestigationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a NHIS Investigation entity with all references set.
	 */
	@Provides
	@Named("nhisInvestigationEntityWithRefs")
	public NhisInvestigationEntity nhisInvestigationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nhisInvestigationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisInvestigationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NhisInvestigationEntity with references");

		// % protected region % [Apply any additional logic for nhisInvestigationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationEntityWithRefs before the main body here] end

		NhisInvestigationEntity nhisInvestigationEntity = injector.getInstance(Key.get(NhisInvestigationEntity.class, Names.named("nhisInvestigationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nhisInvestigationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationEntityWithRefs after the main body here] end

		log.trace("Created entity of type NhisInvestigationEntity with references");

		return nhisInvestigationEntity;
	}

	/**
	 * Return a collection of NHIS Investigation entities with all references set.
	 */
	@Provides
	@Named("nhisInvestigationEntitiesWithRefs")
	public Collection<NhisInvestigationEntity> nhisInvestigationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nhisInvestigationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisInvestigationEntitiesWithRefs here] end
		NhisInvestigationEntityFactory nhisInvestigationEntityFactory
	) {
		log.trace("Creating entities of type NhisInvestigationEntity with references");

		// % protected region % [Apply any additional logic for nhisInvestigationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationEntitiesWithRefs before the main body here] end

		Collection<NhisInvestigationEntity> newEntities = nhisInvestigationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nhisInvestigationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisInvestigationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NhisInvestigationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
