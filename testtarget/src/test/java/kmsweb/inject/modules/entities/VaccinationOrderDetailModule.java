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
 * Guice module for Vaccination Order Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class VaccinationOrderDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring VaccinationOrderDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured VaccinationOrderDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public VaccinationOrderDetailEntityFactory vaccinationOrderDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for vaccinationOrderDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for vaccinationOrderDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating VaccinationOrderDetailEntityFactory");

		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntityFactory before the main body here] end

		VaccinationOrderDetailEntityFactory entityFactory = new VaccinationOrderDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for VaccinationOrderDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for VaccinationOrderDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntityFactory after the main body here] end

		log.trace("Created VaccinationOrderDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Vaccination Order Detail entity with no references set.
	 */
	@Provides
	@Named("vaccinationOrderDetailEntityWithNoRef")
	public VaccinationOrderDetailEntity vaccinationOrderDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for vaccinationOrderDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for vaccinationOrderDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type VaccinationOrderDetailEntity with no reference");

		// % protected region % [Apply any additional logic for vaccinationOrderDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailWithNoRef before the main body here] end

		VaccinationOrderDetailEntity newEntity = new VaccinationOrderDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Vaccination Date here] off begin
		newEntity.setVaccinationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Vaccination Date here] end
		// % protected region % [Add customisation for Vaccination Type here] off begin
		String randomStringforVaccinationType = mock
				.strings()
				.get();
		newEntity.setVaccinationType(randomStringforVaccinationType);
		// % protected region % [Add customisation for Vaccination Type here] end
		// % protected region % [Add customisation for Vaccination Detail here] off begin
		String randomStringforVaccinationDetail = mock
				.strings()
				.get();
		newEntity.setVaccinationDetail(randomStringforVaccinationDetail);
		// % protected region % [Add customisation for Vaccination Detail here] end
		// % protected region % [Add customisation for Quantity here] off begin
		newEntity.setQuantity(mock.ints().get());
		// % protected region % [Add customisation for Quantity here] end

		// % protected region % [Apply any additional logic for vaccinationOrderDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailWithNoRef after the main body here] end

		log.trace("Created entity of type VaccinationOrderDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Vaccination Order Detail entities with no reference at all.
	 */
	@Provides
	@Named("vaccinationOrderDetailEntitiesWithNoRef")
	public Collection<VaccinationOrderDetailEntity> vaccinationOrderDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for vaccinationOrderDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for vaccinationOrderDetailEntitiesWithNoRef here] end
		VaccinationOrderDetailEntityFactory vaccinationOrderDetailEntityFactory
	) {
		log.trace("Creating entities of type VaccinationOrderDetailEntity with no reference");

		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntitiesWithNoRef before the main body here] end

		Collection<VaccinationOrderDetailEntity> newEntities = vaccinationOrderDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type VaccinationOrderDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Vaccination Order Detail entity with all references set.
	 */
	@Provides
	@Named("vaccinationOrderDetailEntityWithRefs")
	public VaccinationOrderDetailEntity vaccinationOrderDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for vaccinationOrderDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for vaccinationOrderDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type VaccinationOrderDetailEntity with references");

		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntityWithRefs before the main body here] end

		VaccinationOrderDetailEntity vaccinationOrderDetailEntity = injector.getInstance(Key.get(VaccinationOrderDetailEntity.class, Names.named("vaccinationOrderDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type VaccinationOrderDetailEntity with references");

		return vaccinationOrderDetailEntity;
	}

	/**
	 * Return a collection of Vaccination Order Detail entities with all references set.
	 */
	@Provides
	@Named("vaccinationOrderDetailEntitiesWithRefs")
	public Collection<VaccinationOrderDetailEntity> vaccinationOrderDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for vaccinationOrderDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for vaccinationOrderDetailEntitiesWithRefs here] end
		VaccinationOrderDetailEntityFactory vaccinationOrderDetailEntityFactory
	) {
		log.trace("Creating entities of type VaccinationOrderDetailEntity with references");

		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntitiesWithRefs before the main body here] end

		Collection<VaccinationOrderDetailEntity> newEntities = vaccinationOrderDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type VaccinationOrderDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
