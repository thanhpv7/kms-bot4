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
 * Guice module for Facility History used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class FacilityHistoryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring FacilityHistoryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured FacilityHistoryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public FacilityHistoryEntityFactory facilityHistoryEntityFactory(
			// % protected region % [Apply any additional injected arguments for facilityHistoryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for facilityHistoryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating FacilityHistoryEntityFactory");

		// % protected region % [Apply any additional logic for facilityHistoryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryEntityFactory before the main body here] end

		FacilityHistoryEntityFactory entityFactory = new FacilityHistoryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for FacilityHistoryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for FacilityHistoryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for facilityHistoryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryEntityFactory after the main body here] end

		log.trace("Created FacilityHistoryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Facility History entity with no references set.
	 */
	@Provides
	@Named("facilityHistoryEntityWithNoRef")
	public FacilityHistoryEntity facilityHistoryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for facilityHistoryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for facilityHistoryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type FacilityHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for facilityHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryWithNoRef before the main body here] end

		FacilityHistoryEntity newEntity = new FacilityHistoryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Change Date here] off begin
		newEntity.setChangeDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Change Date here] end
		// % protected region % [Add customisation for Facility No here] off begin
		String randomStringforFacilityNo = mock
				.strings()
				.get();
		newEntity.setFacilityNo(randomStringforFacilityNo);
		// % protected region % [Add customisation for Facility No here] end
		// % protected region % [Add customisation for Current Qty here] off begin
		newEntity.setCurrentQty(mock.ints().get());
		// % protected region % [Add customisation for Current Qty here] end
		// % protected region % [Add customisation for Changed Qty here] off begin
		newEntity.setChangedQty(mock.ints().get());
		// % protected region % [Add customisation for Changed Qty here] end
		// % protected region % [Add customisation for Facility Status here] off begin
		String randomStringforFacilityStatus = mock
				.strings()
				.get();
		newEntity.setFacilityStatus(randomStringforFacilityStatus);
		// % protected region % [Add customisation for Facility Status here] end
		// % protected region % [Add customisation for Facility Class here] off begin
		String randomStringforFacilityClass = mock
				.strings()
				.get();
		newEntity.setFacilityClass(randomStringforFacilityClass);
		// % protected region % [Add customisation for Facility Class here] end
		// % protected region % [Add customisation for Facility Type here] off begin
		String randomStringforFacilityType = mock
				.strings()
				.get();
		newEntity.setFacilityType(randomStringforFacilityType);
		// % protected region % [Add customisation for Facility Type here] end
		// % protected region % [Add customisation for Facility Service here] off begin
		String randomStringforFacilityService = mock
				.strings()
				.get();
		newEntity.setFacilityService(randomStringforFacilityService);
		// % protected region % [Add customisation for Facility Service here] end
		// % protected region % [Add customisation for Bed Facility Id here] off begin
		String randomStringforBedFacilityId = mock
				.strings()
				.get();
		newEntity.setBedFacilityId(randomStringforBedFacilityId);
		// % protected region % [Add customisation for Bed Facility Id here] end
		// % protected region % [Add customisation for Registration Id here] off begin
		String randomStringforRegistrationId = mock
				.strings()
				.get();
		newEntity.setRegistrationId(randomStringforRegistrationId);
		// % protected region % [Add customisation for Registration Id here] end

		// % protected region % [Apply any additional logic for facilityHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryWithNoRef after the main body here] end

		log.trace("Created entity of type FacilityHistoryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Facility History entities with no reference at all.
	 */
	@Provides
	@Named("facilityHistoryEntitiesWithNoRef")
	public Collection<FacilityHistoryEntity> facilityHistoryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for facilityHistoryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for facilityHistoryEntitiesWithNoRef here] end
		FacilityHistoryEntityFactory facilityHistoryEntityFactory
	) {
		log.trace("Creating entities of type FacilityHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for facilityHistoryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryEntitiesWithNoRef before the main body here] end

		Collection<FacilityHistoryEntity> newEntities = facilityHistoryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for facilityHistoryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type FacilityHistoryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Facility History entity with all references set.
	 */
	@Provides
	@Named("facilityHistoryEntityWithRefs")
	public FacilityHistoryEntity facilityHistoryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for facilityHistoryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for facilityHistoryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type FacilityHistoryEntity with references");

		// % protected region % [Apply any additional logic for facilityHistoryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryEntityWithRefs before the main body here] end

		FacilityHistoryEntity facilityHistoryEntity = injector.getInstance(Key.get(FacilityHistoryEntity.class, Names.named("facilityHistoryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for facilityHistoryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryEntityWithRefs after the main body here] end

		log.trace("Created entity of type FacilityHistoryEntity with references");

		return facilityHistoryEntity;
	}

	/**
	 * Return a collection of Facility History entities with all references set.
	 */
	@Provides
	@Named("facilityHistoryEntitiesWithRefs")
	public Collection<FacilityHistoryEntity> facilityHistoryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for facilityHistoryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for facilityHistoryEntitiesWithRefs here] end
		FacilityHistoryEntityFactory facilityHistoryEntityFactory
	) {
		log.trace("Creating entities of type FacilityHistoryEntity with references");

		// % protected region % [Apply any additional logic for facilityHistoryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryEntitiesWithRefs before the main body here] end

		Collection<FacilityHistoryEntity> newEntities = facilityHistoryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for facilityHistoryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type FacilityHistoryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
