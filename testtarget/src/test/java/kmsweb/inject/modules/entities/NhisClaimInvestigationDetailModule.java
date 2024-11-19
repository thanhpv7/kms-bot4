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
 * Guice module for NHIS Claim Investigation Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NhisClaimInvestigationDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NhisClaimInvestigationDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NhisClaimInvestigationDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NhisClaimInvestigationDetailEntityFactory nhisClaimInvestigationDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for nhisClaimInvestigationDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nhisClaimInvestigationDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NhisClaimInvestigationDetailEntityFactory");

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntityFactory before the main body here] end

		NhisClaimInvestigationDetailEntityFactory entityFactory = new NhisClaimInvestigationDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NhisClaimInvestigationDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NhisClaimInvestigationDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntityFactory after the main body here] end

		log.trace("Created NhisClaimInvestigationDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty NHIS Claim Investigation Detail entity with no references set.
	 */
	@Provides
	@Named("nhisClaimInvestigationDetailEntityWithNoRef")
	public NhisClaimInvestigationDetailEntity nhisClaimInvestigationDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nhisClaimInvestigationDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisClaimInvestigationDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NhisClaimInvestigationDetailEntity with no reference");

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailWithNoRef before the main body here] end

		NhisClaimInvestigationDetailEntity newEntity = new NhisClaimInvestigationDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Date here] off begin
		newEntity.setDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Date here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailWithNoRef after the main body here] end

		log.trace("Created entity of type NhisClaimInvestigationDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of NHIS Claim Investigation Detail entities with no reference at all.
	 */
	@Provides
	@Named("nhisClaimInvestigationDetailEntitiesWithNoRef")
	public Collection<NhisClaimInvestigationDetailEntity> nhisClaimInvestigationDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nhisClaimInvestigationDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisClaimInvestigationDetailEntitiesWithNoRef here] end
		NhisClaimInvestigationDetailEntityFactory nhisClaimInvestigationDetailEntityFactory
	) {
		log.trace("Creating entities of type NhisClaimInvestigationDetailEntity with no reference");

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntitiesWithNoRef before the main body here] end

		Collection<NhisClaimInvestigationDetailEntity> newEntities = nhisClaimInvestigationDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NhisClaimInvestigationDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a NHIS Claim Investigation Detail entity with all references set.
	 */
	@Provides
	@Named("nhisClaimInvestigationDetailEntityWithRefs")
	public NhisClaimInvestigationDetailEntity nhisClaimInvestigationDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nhisClaimInvestigationDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisClaimInvestigationDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NhisClaimInvestigationDetailEntity with references");

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntityWithRefs before the main body here] end

		NhisClaimInvestigationDetailEntity nhisClaimInvestigationDetailEntity = injector.getInstance(Key.get(NhisClaimInvestigationDetailEntity.class, Names.named("nhisClaimInvestigationDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type NhisClaimInvestigationDetailEntity with references");

		return nhisClaimInvestigationDetailEntity;
	}

	/**
	 * Return a collection of NHIS Claim Investigation Detail entities with all references set.
	 */
	@Provides
	@Named("nhisClaimInvestigationDetailEntitiesWithRefs")
	public Collection<NhisClaimInvestigationDetailEntity> nhisClaimInvestigationDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nhisClaimInvestigationDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisClaimInvestigationDetailEntitiesWithRefs here] end
		NhisClaimInvestigationDetailEntityFactory nhisClaimInvestigationDetailEntityFactory
	) {
		log.trace("Creating entities of type NhisClaimInvestigationDetailEntity with references");

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntitiesWithRefs before the main body here] end

		Collection<NhisClaimInvestigationDetailEntity> newEntities = nhisClaimInvestigationDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimInvestigationDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NhisClaimInvestigationDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
