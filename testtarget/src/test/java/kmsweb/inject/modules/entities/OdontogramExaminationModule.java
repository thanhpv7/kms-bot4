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
 * Guice module for Odontogram Examination used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class OdontogramExaminationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring OdontogramExaminationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured OdontogramExaminationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public OdontogramExaminationEntityFactory odontogramExaminationEntityFactory(
			// % protected region % [Apply any additional injected arguments for odontogramExaminationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for odontogramExaminationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating OdontogramExaminationEntityFactory");

		// % protected region % [Apply any additional logic for odontogramExaminationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationEntityFactory before the main body here] end

		OdontogramExaminationEntityFactory entityFactory = new OdontogramExaminationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for OdontogramExaminationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for OdontogramExaminationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for odontogramExaminationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationEntityFactory after the main body here] end

		log.trace("Created OdontogramExaminationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Odontogram Examination entity with no references set.
	 */
	@Provides
	@Named("odontogramExaminationEntityWithNoRef")
	public OdontogramExaminationEntity odontogramExaminationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for odontogramExaminationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for odontogramExaminationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type OdontogramExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for odontogramExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationWithNoRef before the main body here] end

		OdontogramExaminationEntity newEntity = new OdontogramExaminationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Odontogram Data here] off begin
		String randomStringforOdontogramData = mock
				.strings()
				.get();
		newEntity.setOdontogramData(randomStringforOdontogramData);
		// % protected region % [Add customisation for Odontogram Data here] end
		// % protected region % [Add customisation for Is Permanent here] off begin
		newEntity.setIsPermanent(mock.bools().get());
		// % protected region % [Add customisation for Is Permanent here] end

		// % protected region % [Apply any additional logic for odontogramExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationWithNoRef after the main body here] end

		log.trace("Created entity of type OdontogramExaminationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Odontogram Examination entities with no reference at all.
	 */
	@Provides
	@Named("odontogramExaminationEntitiesWithNoRef")
	public Collection<OdontogramExaminationEntity> odontogramExaminationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for odontogramExaminationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for odontogramExaminationEntitiesWithNoRef here] end
		OdontogramExaminationEntityFactory odontogramExaminationEntityFactory
	) {
		log.trace("Creating entities of type OdontogramExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for odontogramExaminationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationEntitiesWithNoRef before the main body here] end

		Collection<OdontogramExaminationEntity> newEntities = odontogramExaminationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for odontogramExaminationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type OdontogramExaminationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Odontogram Examination entity with all references set.
	 */
	@Provides
	@Named("odontogramExaminationEntityWithRefs")
	public OdontogramExaminationEntity odontogramExaminationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for odontogramExaminationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for odontogramExaminationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type OdontogramExaminationEntity with references");

		// % protected region % [Apply any additional logic for odontogramExaminationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationEntityWithRefs before the main body here] end

		OdontogramExaminationEntity odontogramExaminationEntity = injector.getInstance(Key.get(OdontogramExaminationEntity.class, Names.named("odontogramExaminationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for odontogramExaminationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationEntityWithRefs after the main body here] end

		log.trace("Created entity of type OdontogramExaminationEntity with references");

		return odontogramExaminationEntity;
	}

	/**
	 * Return a collection of Odontogram Examination entities with all references set.
	 */
	@Provides
	@Named("odontogramExaminationEntitiesWithRefs")
	public Collection<OdontogramExaminationEntity> odontogramExaminationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for odontogramExaminationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for odontogramExaminationEntitiesWithRefs here] end
		OdontogramExaminationEntityFactory odontogramExaminationEntityFactory
	) {
		log.trace("Creating entities of type OdontogramExaminationEntity with references");

		// % protected region % [Apply any additional logic for odontogramExaminationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationEntitiesWithRefs before the main body here] end

		Collection<OdontogramExaminationEntity> newEntities = odontogramExaminationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for odontogramExaminationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for odontogramExaminationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type OdontogramExaminationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
