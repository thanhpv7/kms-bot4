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
 * Guice module for Vital Signs used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class VitalSignsModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring VitalSignsModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured VitalSignsModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public VitalSignsEntityFactory vitalSignsEntityFactory(
			// % protected region % [Apply any additional injected arguments for vitalSignsEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for vitalSignsEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating VitalSignsEntityFactory");

		// % protected region % [Apply any additional logic for vitalSignsEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsEntityFactory before the main body here] end

		VitalSignsEntityFactory entityFactory = new VitalSignsEntityFactory(
				// % protected region % [Apply any additional constructor arguments for VitalSignsEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for VitalSignsEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for vitalSignsEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsEntityFactory after the main body here] end

		log.trace("Created VitalSignsEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Vital Signs entity with no references set.
	 */
	@Provides
	@Named("vitalSignsEntityWithNoRef")
	public VitalSignsEntity vitalSignsEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for vitalSignsEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for vitalSignsEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type VitalSignsEntity with no reference");

		// % protected region % [Apply any additional logic for vitalSignsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsWithNoRef before the main body here] end

		VitalSignsEntity newEntity = new VitalSignsEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Time here] off begin
		String randomStringforTime = mock
				.strings()
				.get();
		newEntity.setTime(randomStringforTime);
		// % protected region % [Add customisation for Time here] end
		// % protected region % [Add customisation for HR here] off begin
		String randomStringforHr = mock
				.strings()
				.get();
		newEntity.setHr(randomStringforHr);
		// % protected region % [Add customisation for HR here] end
		// % protected region % [Add customisation for RR here] off begin
		String randomStringforRr = mock
				.strings()
				.get();
		newEntity.setRr(randomStringforRr);
		// % protected region % [Add customisation for RR here] end
		// % protected region % [Add customisation for Temprature here] off begin
		String randomStringforTemprature = mock
				.strings()
				.get();
		newEntity.setTemprature(randomStringforTemprature);
		// % protected region % [Add customisation for Temprature here] end
		// % protected region % [Add customisation for O2 Saturation here] off begin
		String randomStringforO2Saturation = mock
				.strings()
				.get();
		newEntity.setO2Saturation(randomStringforO2Saturation);
		// % protected region % [Add customisation for O2 Saturation here] end
		// % protected region % [Add customisation for Remarks here] off begin
		String randomStringforRemarks = mock
				.strings()
				.get();
		newEntity.setRemarks(randomStringforRemarks);
		// % protected region % [Add customisation for Remarks here] end

		// % protected region % [Apply any additional logic for vitalSignsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsWithNoRef after the main body here] end

		log.trace("Created entity of type VitalSignsEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Vital Signs entities with no reference at all.
	 */
	@Provides
	@Named("vitalSignsEntitiesWithNoRef")
	public Collection<VitalSignsEntity> vitalSignsEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for vitalSignsEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for vitalSignsEntitiesWithNoRef here] end
		VitalSignsEntityFactory vitalSignsEntityFactory
	) {
		log.trace("Creating entities of type VitalSignsEntity with no reference");

		// % protected region % [Apply any additional logic for vitalSignsEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsEntitiesWithNoRef before the main body here] end

		Collection<VitalSignsEntity> newEntities = vitalSignsEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for vitalSignsEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type VitalSignsEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Vital Signs entity with all references set.
	 */
	@Provides
	@Named("vitalSignsEntityWithRefs")
	public VitalSignsEntity vitalSignsEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for vitalSignsEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for vitalSignsEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type VitalSignsEntity with references");

		// % protected region % [Apply any additional logic for vitalSignsEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsEntityWithRefs before the main body here] end

		VitalSignsEntity vitalSignsEntity = injector.getInstance(Key.get(VitalSignsEntity.class, Names.named("vitalSignsEntityWithNoRef")));

		// % protected region % [Apply any additional logic for vitalSignsEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsEntityWithRefs after the main body here] end

		log.trace("Created entity of type VitalSignsEntity with references");

		return vitalSignsEntity;
	}

	/**
	 * Return a collection of Vital Signs entities with all references set.
	 */
	@Provides
	@Named("vitalSignsEntitiesWithRefs")
	public Collection<VitalSignsEntity> vitalSignsEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for vitalSignsEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for vitalSignsEntitiesWithRefs here] end
		VitalSignsEntityFactory vitalSignsEntityFactory
	) {
		log.trace("Creating entities of type VitalSignsEntity with references");

		// % protected region % [Apply any additional logic for vitalSignsEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsEntitiesWithRefs before the main body here] end

		Collection<VitalSignsEntity> newEntities = vitalSignsEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for vitalSignsEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type VitalSignsEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
