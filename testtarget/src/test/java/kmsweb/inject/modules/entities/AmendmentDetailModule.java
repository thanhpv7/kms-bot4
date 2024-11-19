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
 * Guice module for Amendment Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class AmendmentDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring AmendmentDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured AmendmentDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public AmendmentDetailEntityFactory amendmentDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for amendmentDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for amendmentDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating AmendmentDetailEntityFactory");

		// % protected region % [Apply any additional logic for amendmentDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailEntityFactory before the main body here] end

		AmendmentDetailEntityFactory entityFactory = new AmendmentDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for AmendmentDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for AmendmentDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for amendmentDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailEntityFactory after the main body here] end

		log.trace("Created AmendmentDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Amendment Detail entity with no references set.
	 */
	@Provides
	@Named("amendmentDetailEntityWithNoRef")
	public AmendmentDetailEntity amendmentDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for amendmentDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for amendmentDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type AmendmentDetailEntity with no reference");

		// % protected region % [Apply any additional logic for amendmentDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailWithNoRef before the main body here] end

		AmendmentDetailEntity newEntity = new AmendmentDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Date here] off begin
		newEntity.setDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Date here] end
		// % protected region % [Add customisation for Reason here] off begin
		String randomStringforReason = mock
				.strings()
				.get();
		newEntity.setReason(randomStringforReason);
		// % protected region % [Add customisation for Reason here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for Status here] end

		// % protected region % [Apply any additional logic for amendmentDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailWithNoRef after the main body here] end

		log.trace("Created entity of type AmendmentDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Amendment Detail entities with no reference at all.
	 */
	@Provides
	@Named("amendmentDetailEntitiesWithNoRef")
	public Collection<AmendmentDetailEntity> amendmentDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for amendmentDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for amendmentDetailEntitiesWithNoRef here] end
		AmendmentDetailEntityFactory amendmentDetailEntityFactory
	) {
		log.trace("Creating entities of type AmendmentDetailEntity with no reference");

		// % protected region % [Apply any additional logic for amendmentDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailEntitiesWithNoRef before the main body here] end

		Collection<AmendmentDetailEntity> newEntities = amendmentDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for amendmentDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type AmendmentDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Amendment Detail entity with all references set.
	 */
	@Provides
	@Named("amendmentDetailEntityWithRefs")
	public AmendmentDetailEntity amendmentDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for amendmentDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for amendmentDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type AmendmentDetailEntity with references");

		// % protected region % [Apply any additional logic for amendmentDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailEntityWithRefs before the main body here] end

		AmendmentDetailEntity amendmentDetailEntity = injector.getInstance(Key.get(AmendmentDetailEntity.class, Names.named("amendmentDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for amendmentDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type AmendmentDetailEntity with references");

		return amendmentDetailEntity;
	}

	/**
	 * Return a collection of Amendment Detail entities with all references set.
	 */
	@Provides
	@Named("amendmentDetailEntitiesWithRefs")
	public Collection<AmendmentDetailEntity> amendmentDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for amendmentDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for amendmentDetailEntitiesWithRefs here] end
		AmendmentDetailEntityFactory amendmentDetailEntityFactory
	) {
		log.trace("Creating entities of type AmendmentDetailEntity with references");

		// % protected region % [Apply any additional logic for amendmentDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailEntitiesWithRefs before the main body here] end

		Collection<AmendmentDetailEntity> newEntities = amendmentDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for amendmentDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for amendmentDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type AmendmentDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
