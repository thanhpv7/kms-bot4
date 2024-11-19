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
 * Guice module for Hemodialysis Monitoring used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class HemodialysisMonitoringModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring HemodialysisMonitoringModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured HemodialysisMonitoringModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public HemodialysisMonitoringEntityFactory hemodialysisMonitoringEntityFactory(
			// % protected region % [Apply any additional injected arguments for hemodialysisMonitoringEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for hemodialysisMonitoringEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating HemodialysisMonitoringEntityFactory");

		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntityFactory before the main body here] end

		HemodialysisMonitoringEntityFactory entityFactory = new HemodialysisMonitoringEntityFactory(
				// % protected region % [Apply any additional constructor arguments for HemodialysisMonitoringEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for HemodialysisMonitoringEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntityFactory after the main body here] end

		log.trace("Created HemodialysisMonitoringEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Hemodialysis Monitoring entity with no references set.
	 */
	@Provides
	@Named("hemodialysisMonitoringEntityWithNoRef")
	public HemodialysisMonitoringEntity hemodialysisMonitoringEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for hemodialysisMonitoringEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for hemodialysisMonitoringEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type HemodialysisMonitoringEntity with no reference");

		// % protected region % [Apply any additional logic for hemodialysisMonitoringWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringWithNoRef before the main body here] end

		HemodialysisMonitoringEntity newEntity = new HemodialysisMonitoringEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for DateTime here] off begin
		newEntity.setDatetime(OffsetDateTime.now());
		// % protected region % [Add customisation for DateTime here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mock.doubles().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mock.doubles().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Heart Rate here] off begin
		newEntity.setHeartRate(mock.doubles().get());
		// % protected region % [Add customisation for Heart Rate here] end
		// % protected region % [Add customisation for Temperature here] off begin
		newEntity.setTemperature(mock.doubles().get());
		// % protected region % [Add customisation for Temperature here] end
		// % protected region % [Add customisation for Temperature Unit here] off begin
		String randomStringforTemperatureUnit = mock
				.strings()
				.get();
		newEntity.setTemperatureUnit(randomStringforTemperatureUnit);
		// % protected region % [Add customisation for Temperature Unit here] end
		// % protected region % [Add customisation for Respiratory here] off begin
		newEntity.setRespiratory(mock.doubles().get());
		// % protected region % [Add customisation for Respiratory here] end
		// % protected region % [Add customisation for QB here] off begin
		newEntity.setQb(mock.doubles().get());
		// % protected region % [Add customisation for QB here] end
		// % protected region % [Add customisation for QD here] off begin
		newEntity.setQd(mock.doubles().get());
		// % protected region % [Add customisation for QD here] end
		// % protected region % [Add customisation for Venous Pressure here] off begin
		newEntity.setVenousPressure(mock.doubles().get());
		// % protected region % [Add customisation for Venous Pressure here] end
		// % protected region % [Add customisation for TMP here] off begin
		newEntity.setTmp(mock.doubles().get());
		// % protected region % [Add customisation for TMP here] end
		// % protected region % [Add customisation for UFG here] off begin
		newEntity.setUfg(mock.doubles().get());
		// % protected region % [Add customisation for UFG here] end
		// % protected region % [Add customisation for UFR here] off begin
		newEntity.setUfr(mock.doubles().get());
		// % protected region % [Add customisation for UFR here] end
		// % protected region % [Add customisation for UF here] off begin
		newEntity.setUf(mock.doubles().get());
		// % protected region % [Add customisation for UF here] end

		// % protected region % [Apply any additional logic for hemodialysisMonitoringWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringWithNoRef after the main body here] end

		log.trace("Created entity of type HemodialysisMonitoringEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Hemodialysis Monitoring entities with no reference at all.
	 */
	@Provides
	@Named("hemodialysisMonitoringEntitiesWithNoRef")
	public Collection<HemodialysisMonitoringEntity> hemodialysisMonitoringEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for hemodialysisMonitoringEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for hemodialysisMonitoringEntitiesWithNoRef here] end
		HemodialysisMonitoringEntityFactory hemodialysisMonitoringEntityFactory
	) {
		log.trace("Creating entities of type HemodialysisMonitoringEntity with no reference");

		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntitiesWithNoRef before the main body here] end

		Collection<HemodialysisMonitoringEntity> newEntities = hemodialysisMonitoringEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type HemodialysisMonitoringEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Hemodialysis Monitoring entity with all references set.
	 */
	@Provides
	@Named("hemodialysisMonitoringEntityWithRefs")
	public HemodialysisMonitoringEntity hemodialysisMonitoringEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for hemodialysisMonitoringEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for hemodialysisMonitoringEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type HemodialysisMonitoringEntity with references");

		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntityWithRefs before the main body here] end

		HemodialysisMonitoringEntity hemodialysisMonitoringEntity = injector.getInstance(Key.get(HemodialysisMonitoringEntity.class, Names.named("hemodialysisMonitoringEntityWithNoRef")));

		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntityWithRefs after the main body here] end

		log.trace("Created entity of type HemodialysisMonitoringEntity with references");

		return hemodialysisMonitoringEntity;
	}

	/**
	 * Return a collection of Hemodialysis Monitoring entities with all references set.
	 */
	@Provides
	@Named("hemodialysisMonitoringEntitiesWithRefs")
	public Collection<HemodialysisMonitoringEntity> hemodialysisMonitoringEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for hemodialysisMonitoringEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for hemodialysisMonitoringEntitiesWithRefs here] end
		HemodialysisMonitoringEntityFactory hemodialysisMonitoringEntityFactory
	) {
		log.trace("Creating entities of type HemodialysisMonitoringEntity with references");

		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntitiesWithRefs before the main body here] end

		Collection<HemodialysisMonitoringEntity> newEntities = hemodialysisMonitoringEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type HemodialysisMonitoringEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
