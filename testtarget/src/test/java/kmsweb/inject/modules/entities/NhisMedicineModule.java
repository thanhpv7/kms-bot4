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
 * Guice module for NHIS Medicine used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NhisMedicineModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NhisMedicineModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NhisMedicineModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NhisMedicineEntityFactory nhisMedicineEntityFactory(
			// % protected region % [Apply any additional injected arguments for nhisMedicineEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nhisMedicineEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NhisMedicineEntityFactory");

		// % protected region % [Apply any additional logic for nhisMedicineEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineEntityFactory before the main body here] end

		NhisMedicineEntityFactory entityFactory = new NhisMedicineEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NhisMedicineEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NhisMedicineEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nhisMedicineEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineEntityFactory after the main body here] end

		log.trace("Created NhisMedicineEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty NHIS Medicine entity with no references set.
	 */
	@Provides
	@Named("nhisMedicineEntityWithNoRef")
	public NhisMedicineEntity nhisMedicineEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nhisMedicineEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisMedicineEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NhisMedicineEntity with no reference");

		// % protected region % [Apply any additional logic for nhisMedicineWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineWithNoRef before the main body here] end

		NhisMedicineEntity newEntity = new NhisMedicineEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Medicine Code here] off begin
		String randomStringforMedicineCode = mock
				.strings()
				.get();
		newEntity.setMedicineCode(randomStringforMedicineCode);
		// % protected region % [Add customisation for Medicine Code here] end
		// % protected region % [Add customisation for Medicine Name here] off begin
		String randomStringforMedicineName = mock
				.strings()
				.get();
		newEntity.setMedicineName(randomStringforMedicineName);
		// % protected region % [Add customisation for Medicine Name here] end
		// % protected region % [Add customisation for Dose here] off begin
		newEntity.setDose(mock.doubles().get());
		// % protected region % [Add customisation for Dose here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Frequency here] off begin
		String randomStringforFrequency = mock
				.strings()
				.get();
		newEntity.setFrequency(randomStringforFrequency);
		// % protected region % [Add customisation for Frequency here] end
		// % protected region % [Add customisation for Duration here] off begin
		newEntity.setDuration(mock.doubles().get());
		// % protected region % [Add customisation for Duration here] end
		// % protected region % [Add customisation for Unit Price here] off begin
		newEntity.setUnitPrice(mock.doubles().get());
		// % protected region % [Add customisation for Unit Price here] end
		// % protected region % [Add customisation for Dispensed Qty here] off begin
		newEntity.setDispensedQty(mock.doubles().get());
		// % protected region % [Add customisation for Dispensed Qty here] end
		// % protected region % [Add customisation for Total Cost here] off begin
		newEntity.setTotalCost(mock.doubles().get());
		// % protected region % [Add customisation for Total Cost here] end
		// % protected region % [Add customisation for Service Date here] off begin
		newEntity.setServiceDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Service Date here] end

		// % protected region % [Apply any additional logic for nhisMedicineWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineWithNoRef after the main body here] end

		log.trace("Created entity of type NhisMedicineEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of NHIS Medicine entities with no reference at all.
	 */
	@Provides
	@Named("nhisMedicineEntitiesWithNoRef")
	public Collection<NhisMedicineEntity> nhisMedicineEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nhisMedicineEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisMedicineEntitiesWithNoRef here] end
		NhisMedicineEntityFactory nhisMedicineEntityFactory
	) {
		log.trace("Creating entities of type NhisMedicineEntity with no reference");

		// % protected region % [Apply any additional logic for nhisMedicineEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineEntitiesWithNoRef before the main body here] end

		Collection<NhisMedicineEntity> newEntities = nhisMedicineEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nhisMedicineEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NhisMedicineEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a NHIS Medicine entity with all references set.
	 */
	@Provides
	@Named("nhisMedicineEntityWithRefs")
	public NhisMedicineEntity nhisMedicineEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nhisMedicineEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisMedicineEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NhisMedicineEntity with references");

		// % protected region % [Apply any additional logic for nhisMedicineEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineEntityWithRefs before the main body here] end

		NhisMedicineEntity nhisMedicineEntity = injector.getInstance(Key.get(NhisMedicineEntity.class, Names.named("nhisMedicineEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nhisMedicineEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineEntityWithRefs after the main body here] end

		log.trace("Created entity of type NhisMedicineEntity with references");

		return nhisMedicineEntity;
	}

	/**
	 * Return a collection of NHIS Medicine entities with all references set.
	 */
	@Provides
	@Named("nhisMedicineEntitiesWithRefs")
	public Collection<NhisMedicineEntity> nhisMedicineEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nhisMedicineEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisMedicineEntitiesWithRefs here] end
		NhisMedicineEntityFactory nhisMedicineEntityFactory
	) {
		log.trace("Creating entities of type NhisMedicineEntity with references");

		// % protected region % [Apply any additional logic for nhisMedicineEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineEntitiesWithRefs before the main body here] end

		Collection<NhisMedicineEntity> newEntities = nhisMedicineEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nhisMedicineEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisMedicineEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NhisMedicineEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
