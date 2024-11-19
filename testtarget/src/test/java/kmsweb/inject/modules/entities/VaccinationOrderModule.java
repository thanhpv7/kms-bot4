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
 * Guice module for Vaccination Order used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class VaccinationOrderModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring VaccinationOrderModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured VaccinationOrderModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public VaccinationOrderEntityFactory vaccinationOrderEntityFactory(
			// % protected region % [Apply any additional injected arguments for vaccinationOrderEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for vaccinationOrderEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating VaccinationOrderEntityFactory");

		// % protected region % [Apply any additional logic for vaccinationOrderEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderEntityFactory before the main body here] end

		VaccinationOrderEntityFactory entityFactory = new VaccinationOrderEntityFactory(
				// % protected region % [Apply any additional constructor arguments for VaccinationOrderEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for VaccinationOrderEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for vaccinationOrderEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderEntityFactory after the main body here] end

		log.trace("Created VaccinationOrderEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Vaccination Order entity with no references set.
	 */
	@Provides
	@Named("vaccinationOrderEntityWithNoRef")
	public VaccinationOrderEntity vaccinationOrderEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for vaccinationOrderEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for vaccinationOrderEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type VaccinationOrderEntity with no reference");

		// % protected region % [Apply any additional logic for vaccinationOrderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderWithNoRef before the main body here] end

		VaccinationOrderEntity newEntity = new VaccinationOrderEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Vaccination Location here] off begin
		String randomStringforVaccinationLocation = mock
				.strings()
				.get();
		newEntity.setVaccinationLocation(randomStringforVaccinationLocation);
		// % protected region % [Add customisation for Vaccination Location here] end
		// % protected region % [Add customisation for Vaccination Reaction here] off begin
		String randomStringforVaccinationReaction = mock
				.strings()
				.get();
		newEntity.setVaccinationReaction(randomStringforVaccinationReaction);
		// % protected region % [Add customisation for Vaccination Reaction here] end
		// % protected region % [Add customisation for Purpose here] off begin
		String randomStringforPurpose = mock
				.strings()
				.get();
		newEntity.setPurpose(randomStringforPurpose);
		// % protected region % [Add customisation for Purpose here] end
		// % protected region % [Add customisation for Vaccination Notes here] off begin
		String randomStringforVaccinationNotes = mock
				.strings()
				.get();
		newEntity.setVaccinationNotes(randomStringforVaccinationNotes);
		// % protected region % [Add customisation for Vaccination Notes here] end
		// % protected region % [Add customisation for Reaction Notes here] off begin
		String randomStringforReactionNotes = mock
				.strings()
				.get();
		newEntity.setReactionNotes(randomStringforReactionNotes);
		// % protected region % [Add customisation for Reaction Notes here] end

		// % protected region % [Apply any additional logic for vaccinationOrderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderWithNoRef after the main body here] end

		log.trace("Created entity of type VaccinationOrderEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Vaccination Order entities with no reference at all.
	 */
	@Provides
	@Named("vaccinationOrderEntitiesWithNoRef")
	public Collection<VaccinationOrderEntity> vaccinationOrderEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for vaccinationOrderEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for vaccinationOrderEntitiesWithNoRef here] end
		VaccinationOrderEntityFactory vaccinationOrderEntityFactory
	) {
		log.trace("Creating entities of type VaccinationOrderEntity with no reference");

		// % protected region % [Apply any additional logic for vaccinationOrderEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderEntitiesWithNoRef before the main body here] end

		Collection<VaccinationOrderEntity> newEntities = vaccinationOrderEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for vaccinationOrderEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type VaccinationOrderEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Vaccination Order entity with all references set.
	 */
	@Provides
	@Named("vaccinationOrderEntityWithRefs")
	public VaccinationOrderEntity vaccinationOrderEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for vaccinationOrderEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for vaccinationOrderEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type VaccinationOrderEntity with references");

		// % protected region % [Apply any additional logic for vaccinationOrderEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderEntityWithRefs before the main body here] end

		VaccinationOrderEntity vaccinationOrderEntity = injector.getInstance(Key.get(VaccinationOrderEntity.class, Names.named("vaccinationOrderEntityWithNoRef")));

		// % protected region % [Apply any additional logic for vaccinationOrderEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderEntityWithRefs after the main body here] end

		log.trace("Created entity of type VaccinationOrderEntity with references");

		return vaccinationOrderEntity;
	}

	/**
	 * Return a collection of Vaccination Order entities with all references set.
	 */
	@Provides
	@Named("vaccinationOrderEntitiesWithRefs")
	public Collection<VaccinationOrderEntity> vaccinationOrderEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for vaccinationOrderEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for vaccinationOrderEntitiesWithRefs here] end
		VaccinationOrderEntityFactory vaccinationOrderEntityFactory
	) {
		log.trace("Creating entities of type VaccinationOrderEntity with references");

		// % protected region % [Apply any additional logic for vaccinationOrderEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderEntitiesWithRefs before the main body here] end

		Collection<VaccinationOrderEntity> newEntities = vaccinationOrderEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for vaccinationOrderEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type VaccinationOrderEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
