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
 * Guice module for Bed Facility used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BedFacilityModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BedFacilityModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BedFacilityModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BedFacilityEntityFactory bedFacilityEntityFactory(
			// % protected region % [Apply any additional injected arguments for bedFacilityEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bedFacilityEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BedFacilityEntityFactory");

		// % protected region % [Apply any additional logic for bedFacilityEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityEntityFactory before the main body here] end

		BedFacilityEntityFactory entityFactory = new BedFacilityEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BedFacilityEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BedFacilityEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bedFacilityEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityEntityFactory after the main body here] end

		log.trace("Created BedFacilityEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Bed Facility entity with no references set.
	 */
	@Provides
	@Named("bedFacilityEntityWithNoRef")
	public BedFacilityEntity bedFacilityEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bedFacilityEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bedFacilityEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BedFacilityEntity with no reference");

		// % protected region % [Apply any additional logic for bedFacilityWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityWithNoRef before the main body here] end

		BedFacilityEntity newEntity = new BedFacilityEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Bed Number here] off begin
		String randomStringforBedNumber = mock
				.strings()
				.get();
		newEntity.setBedNumber(randomStringforBedNumber);
		// % protected region % [Add customisation for Bed Number here] end
		// % protected region % [Add customisation for Bed Name here] off begin
		String randomStringforBedName = mock
				.strings()
				.get();
		newEntity.setBedName(randomStringforBedName);
		// % protected region % [Add customisation for Bed Name here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Availability here] off begin
		String randomStringforAvailability = mock
				.strings()
				.get();
		newEntity.setAvailability(randomStringforAvailability);
		// % protected region % [Add customisation for Availability here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for COA COGS here] off begin
		String randomStringforCoaCOGS = mock
				.strings()
				.get();
		newEntity.setCoaCOGS(randomStringforCoaCOGS);
		// % protected region % [Add customisation for COA COGS here] end
		// % protected region % [Add customisation for COA Sell here] off begin
		String randomStringforCoaSell = mock
				.strings()
				.get();
		newEntity.setCoaSell(randomStringforCoaSell);
		// % protected region % [Add customisation for COA Sell here] end
		// % protected region % [Add customisation for COA Inventory here] off begin
		String randomStringforCoaInventory = mock
				.strings()
				.get();
		newEntity.setCoaInventory(randomStringforCoaInventory);
		// % protected region % [Add customisation for COA Inventory here] end

		// % protected region % [Apply any additional logic for bedFacilityWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityWithNoRef after the main body here] end

		log.trace("Created entity of type BedFacilityEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Bed Facility entities with no reference at all.
	 */
	@Provides
	@Named("bedFacilityEntitiesWithNoRef")
	public Collection<BedFacilityEntity> bedFacilityEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bedFacilityEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bedFacilityEntitiesWithNoRef here] end
		BedFacilityEntityFactory bedFacilityEntityFactory
	) {
		log.trace("Creating entities of type BedFacilityEntity with no reference");

		// % protected region % [Apply any additional logic for bedFacilityEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityEntitiesWithNoRef before the main body here] end

		Collection<BedFacilityEntity> newEntities = bedFacilityEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bedFacilityEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BedFacilityEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Bed Facility entity with all references set.
	 */
	@Provides
	@Named("bedFacilityEntityWithRefs")
	public BedFacilityEntity bedFacilityEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bedFacilityEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bedFacilityEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BedFacilityEntity with references");

		// % protected region % [Apply any additional logic for bedFacilityEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityEntityWithRefs before the main body here] end

		BedFacilityEntity bedFacilityEntity = injector.getInstance(Key.get(BedFacilityEntity.class, Names.named("bedFacilityEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bedFacilityEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityEntityWithRefs after the main body here] end

		log.trace("Created entity of type BedFacilityEntity with references");

		return bedFacilityEntity;
	}

	/**
	 * Return a collection of Bed Facility entities with all references set.
	 */
	@Provides
	@Named("bedFacilityEntitiesWithRefs")
	public Collection<BedFacilityEntity> bedFacilityEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bedFacilityEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bedFacilityEntitiesWithRefs here] end
		BedFacilityEntityFactory bedFacilityEntityFactory
	) {
		log.trace("Creating entities of type BedFacilityEntity with references");

		// % protected region % [Apply any additional logic for bedFacilityEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityEntitiesWithRefs before the main body here] end

		Collection<BedFacilityEntity> newEntities = bedFacilityEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bedFacilityEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bedFacilityEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BedFacilityEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
