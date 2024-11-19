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
 * Guice module for NHIS Claim GDRG Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NhisClaimGDRGDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NhisClaimGDRGDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NhisClaimGDRGDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NhisClaimGDRGDetailEntityFactory nhisClaimGDRGDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for nhisClaimGDRGDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nhisClaimGDRGDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NhisClaimGDRGDetailEntityFactory");

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntityFactory before the main body here] end

		NhisClaimGDRGDetailEntityFactory entityFactory = new NhisClaimGDRGDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NhisClaimGDRGDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NhisClaimGDRGDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntityFactory after the main body here] end

		log.trace("Created NhisClaimGDRGDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty NHIS Claim GDRG Detail entity with no references set.
	 */
	@Provides
	@Named("nhisClaimGDRGDetailEntityWithNoRef")
	public NhisClaimGDRGDetailEntity nhisClaimGDRGDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nhisClaimGDRGDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisClaimGDRGDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NhisClaimGDRGDetailEntity with no reference");

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailWithNoRef before the main body here] end

		NhisClaimGDRGDetailEntity newEntity = new NhisClaimGDRGDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailWithNoRef after the main body here] end

		log.trace("Created entity of type NhisClaimGDRGDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of NHIS Claim GDRG Detail entities with no reference at all.
	 */
	@Provides
	@Named("nhisClaimGDRGDetailEntitiesWithNoRef")
	public Collection<NhisClaimGDRGDetailEntity> nhisClaimGDRGDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nhisClaimGDRGDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisClaimGDRGDetailEntitiesWithNoRef here] end
		NhisClaimGDRGDetailEntityFactory nhisClaimGDRGDetailEntityFactory
	) {
		log.trace("Creating entities of type NhisClaimGDRGDetailEntity with no reference");

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntitiesWithNoRef before the main body here] end

		Collection<NhisClaimGDRGDetailEntity> newEntities = nhisClaimGDRGDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NhisClaimGDRGDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a NHIS Claim GDRG Detail entity with all references set.
	 */
	@Provides
	@Named("nhisClaimGDRGDetailEntityWithRefs")
	public NhisClaimGDRGDetailEntity nhisClaimGDRGDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nhisClaimGDRGDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisClaimGDRGDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NhisClaimGDRGDetailEntity with references");

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntityWithRefs before the main body here] end

		NhisClaimGDRGDetailEntity nhisClaimGDRGDetailEntity = injector.getInstance(Key.get(NhisClaimGDRGDetailEntity.class, Names.named("nhisClaimGDRGDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type NhisClaimGDRGDetailEntity with references");

		return nhisClaimGDRGDetailEntity;
	}

	/**
	 * Return a collection of NHIS Claim GDRG Detail entities with all references set.
	 */
	@Provides
	@Named("nhisClaimGDRGDetailEntitiesWithRefs")
	public Collection<NhisClaimGDRGDetailEntity> nhisClaimGDRGDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nhisClaimGDRGDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisClaimGDRGDetailEntitiesWithRefs here] end
		NhisClaimGDRGDetailEntityFactory nhisClaimGDRGDetailEntityFactory
	) {
		log.trace("Creating entities of type NhisClaimGDRGDetailEntity with references");

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntitiesWithRefs before the main body here] end

		Collection<NhisClaimGDRGDetailEntity> newEntities = nhisClaimGDRGDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimGDRGDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NhisClaimGDRGDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
