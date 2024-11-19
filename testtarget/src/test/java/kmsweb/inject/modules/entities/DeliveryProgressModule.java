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
 * Guice module for Delivery Progress used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DeliveryProgressModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DeliveryProgressModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DeliveryProgressModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DeliveryProgressEntityFactory deliveryProgressEntityFactory(
			// % protected region % [Apply any additional injected arguments for deliveryProgressEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for deliveryProgressEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DeliveryProgressEntityFactory");

		// % protected region % [Apply any additional logic for deliveryProgressEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressEntityFactory before the main body here] end

		DeliveryProgressEntityFactory entityFactory = new DeliveryProgressEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DeliveryProgressEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DeliveryProgressEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for deliveryProgressEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressEntityFactory after the main body here] end

		log.trace("Created DeliveryProgressEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Delivery Progress entity with no references set.
	 */
	@Provides
	@Named("deliveryProgressEntityWithNoRef")
	public DeliveryProgressEntity deliveryProgressEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for deliveryProgressEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for deliveryProgressEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DeliveryProgressEntity with no reference");

		// % protected region % [Apply any additional logic for deliveryProgressWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressWithNoRef before the main body here] end

		DeliveryProgressEntity newEntity = new DeliveryProgressEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Progress Date Time here] off begin
		newEntity.setProgressDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Progress Date Time here] end
		// % protected region % [Add customisation for FHR Per Minute here] off begin
		newEntity.setFhrPerMinute(mock.ints().get());
		// % protected region % [Add customisation for FHR Per Minute here] end
		// % protected region % [Add customisation for Amniotic Fluid here] off begin
		String randomStringforAmnioticFluid = mock
				.strings()
				.get();
		newEntity.setAmnioticFluid(randomStringforAmnioticFluid);
		// % protected region % [Add customisation for Amniotic Fluid here] end
		// % protected region % [Add customisation for Moulding here] off begin
		String randomStringforMoulding = mock
				.strings()
				.get();
		newEntity.setMoulding(randomStringforMoulding);
		// % protected region % [Add customisation for Moulding here] end
		// % protected region % [Add customisation for Cervical Dilatation here] off begin
		newEntity.setCervicalDilatation(mock.ints().get());
		// % protected region % [Add customisation for Cervical Dilatation here] end
		// % protected region % [Add customisation for Fetal Head Descent here] off begin
		String randomStringforFetalHeadDescent = mock
				.strings()
				.get();
		newEntity.setFetalHeadDescent(randomStringforFetalHeadDescent);
		// % protected region % [Add customisation for Fetal Head Descent here] end
		// % protected region % [Add customisation for Contraction Qty here] off begin
		newEntity.setContractionQty(mock.ints().get());
		// % protected region % [Add customisation for Contraction Qty here] end
		// % protected region % [Add customisation for Contraction Mins here] off begin
		String randomStringforContractionMins = mock
				.strings()
				.get();
		newEntity.setContractionMins(randomStringforContractionMins);
		// % protected region % [Add customisation for Contraction Mins here] end
		// % protected region % [Add customisation for Drip Strength here] off begin
		newEntity.setDripStrength(mock.ints().get());
		// % protected region % [Add customisation for Drip Strength here] end
		// % protected region % [Add customisation for Drip Number here] off begin
		newEntity.setDripNumber(mock.ints().get());
		// % protected region % [Add customisation for Drip Number here] end
		// % protected region % [Add customisation for Drug IV here] off begin
		String randomStringforDrugIV = mock
				.strings()
				.get();
		newEntity.setDrugIV(randomStringforDrugIV);
		// % protected region % [Add customisation for Drug IV here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mock.ints().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mock.ints().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Pulse here] off begin
		newEntity.setPulse(mock.ints().get());
		// % protected region % [Add customisation for Pulse here] end
		// % protected region % [Add customisation for Temperature here] off begin
		newEntity.setTemperature(mock.doubles().get());
		// % protected region % [Add customisation for Temperature here] end
		// % protected region % [Add customisation for Temperature Unit here] off begin
		String randomStringforTemperatureUnit = mock
				.strings()
				.get();
		newEntity.setTemperatureUnit(randomStringforTemperatureUnit);
		// % protected region % [Add customisation for Temperature Unit here] end
		// % protected region % [Add customisation for Urine Protein here] off begin
		String randomStringforUrineProtein = mock
				.strings()
				.get();
		newEntity.setUrineProtein(randomStringforUrineProtein);
		// % protected region % [Add customisation for Urine Protein here] end
		// % protected region % [Add customisation for Urine Acetone here] off begin
		String randomStringforUrineAcetone = mock
				.strings()
				.get();
		newEntity.setUrineAcetone(randomStringforUrineAcetone);
		// % protected region % [Add customisation for Urine Acetone here] end
		// % protected region % [Add customisation for Urine Volume here] off begin
		newEntity.setUrineVolume(mock.doubles().get());
		// % protected region % [Add customisation for Urine Volume here] end
		// % protected region % [Add customisation for Progress Notes here] off begin
		String randomStringforProgressNotes = mock
				.strings()
				.get();
		newEntity.setProgressNotes(randomStringforProgressNotes);
		// % protected region % [Add customisation for Progress Notes here] end

		// % protected region % [Apply any additional logic for deliveryProgressWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressWithNoRef after the main body here] end

		log.trace("Created entity of type DeliveryProgressEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Delivery Progress entities with no reference at all.
	 */
	@Provides
	@Named("deliveryProgressEntitiesWithNoRef")
	public Collection<DeliveryProgressEntity> deliveryProgressEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for deliveryProgressEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for deliveryProgressEntitiesWithNoRef here] end
		DeliveryProgressEntityFactory deliveryProgressEntityFactory
	) {
		log.trace("Creating entities of type DeliveryProgressEntity with no reference");

		// % protected region % [Apply any additional logic for deliveryProgressEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressEntitiesWithNoRef before the main body here] end

		Collection<DeliveryProgressEntity> newEntities = deliveryProgressEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for deliveryProgressEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DeliveryProgressEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Delivery Progress entity with all references set.
	 */
	@Provides
	@Named("deliveryProgressEntityWithRefs")
	public DeliveryProgressEntity deliveryProgressEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for deliveryProgressEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for deliveryProgressEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DeliveryProgressEntity with references");

		// % protected region % [Apply any additional logic for deliveryProgressEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressEntityWithRefs before the main body here] end

		DeliveryProgressEntity deliveryProgressEntity = injector.getInstance(Key.get(DeliveryProgressEntity.class, Names.named("deliveryProgressEntityWithNoRef")));

		// % protected region % [Apply any additional logic for deliveryProgressEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressEntityWithRefs after the main body here] end

		log.trace("Created entity of type DeliveryProgressEntity with references");

		return deliveryProgressEntity;
	}

	/**
	 * Return a collection of Delivery Progress entities with all references set.
	 */
	@Provides
	@Named("deliveryProgressEntitiesWithRefs")
	public Collection<DeliveryProgressEntity> deliveryProgressEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for deliveryProgressEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for deliveryProgressEntitiesWithRefs here] end
		DeliveryProgressEntityFactory deliveryProgressEntityFactory
	) {
		log.trace("Creating entities of type DeliveryProgressEntity with references");

		// % protected region % [Apply any additional logic for deliveryProgressEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressEntitiesWithRefs before the main body here] end

		Collection<DeliveryProgressEntity> newEntities = deliveryProgressEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for deliveryProgressEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DeliveryProgressEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
