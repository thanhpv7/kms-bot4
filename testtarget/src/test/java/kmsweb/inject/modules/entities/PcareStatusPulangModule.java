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
 * Guice module for PCare Status Pulang used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareStatusPulangModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareStatusPulangModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareStatusPulangModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareStatusPulangEntityFactory pcareStatusPulangEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareStatusPulangEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareStatusPulangEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareStatusPulangEntityFactory");

		// % protected region % [Apply any additional logic for pcareStatusPulangEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangEntityFactory before the main body here] end

		PcareStatusPulangEntityFactory entityFactory = new PcareStatusPulangEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareStatusPulangEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareStatusPulangEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareStatusPulangEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangEntityFactory after the main body here] end

		log.trace("Created PcareStatusPulangEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Status Pulang entity with no references set.
	 */
	@Provides
	@Named("pcareStatusPulangEntityWithNoRef")
	public PcareStatusPulangEntity pcareStatusPulangEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareStatusPulangEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareStatusPulangEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareStatusPulangEntity with no reference");

		// % protected region % [Apply any additional logic for pcareStatusPulangWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangWithNoRef before the main body here] end

		PcareStatusPulangEntity newEntity = new PcareStatusPulangEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kode Status Pulang here] off begin
		String randomStringforKodeStatusPulang = mock
				.strings()
				.get();
		newEntity.setKodeStatusPulang(randomStringforKodeStatusPulang);
		// % protected region % [Add customisation for Kode Status Pulang here] end
		// % protected region % [Add customisation for Nama Status Pulang here] off begin
		String randomStringforNamaStatusPulang = mock
				.strings()
				.get();
		newEntity.setNamaStatusPulang(randomStringforNamaStatusPulang);
		// % protected region % [Add customisation for Nama Status Pulang here] end
		// % protected region % [Add customisation for Kode Referensi Internal here] off begin
		String randomStringforKodeReferensiInternal = mock
				.strings()
				.get();
		newEntity.setKodeReferensiInternal(randomStringforKodeReferensiInternal);
		// % protected region % [Add customisation for Kode Referensi Internal here] end

		// % protected region % [Apply any additional logic for pcareStatusPulangWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangWithNoRef after the main body here] end

		log.trace("Created entity of type PcareStatusPulangEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Status Pulang entities with no reference at all.
	 */
	@Provides
	@Named("pcareStatusPulangEntitiesWithNoRef")
	public Collection<PcareStatusPulangEntity> pcareStatusPulangEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareStatusPulangEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareStatusPulangEntitiesWithNoRef here] end
		PcareStatusPulangEntityFactory pcareStatusPulangEntityFactory
	) {
		log.trace("Creating entities of type PcareStatusPulangEntity with no reference");

		// % protected region % [Apply any additional logic for pcareStatusPulangEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangEntitiesWithNoRef before the main body here] end

		Collection<PcareStatusPulangEntity> newEntities = pcareStatusPulangEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareStatusPulangEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareStatusPulangEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Status Pulang entity with all references set.
	 */
	@Provides
	@Named("pcareStatusPulangEntityWithRefs")
	public PcareStatusPulangEntity pcareStatusPulangEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareStatusPulangEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareStatusPulangEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareStatusPulangEntity with references");

		// % protected region % [Apply any additional logic for pcareStatusPulangEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangEntityWithRefs before the main body here] end

		PcareStatusPulangEntity pcareStatusPulangEntity = injector.getInstance(Key.get(PcareStatusPulangEntity.class, Names.named("pcareStatusPulangEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareStatusPulangEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareStatusPulangEntity with references");

		return pcareStatusPulangEntity;
	}

	/**
	 * Return a collection of PCare Status Pulang entities with all references set.
	 */
	@Provides
	@Named("pcareStatusPulangEntitiesWithRefs")
	public Collection<PcareStatusPulangEntity> pcareStatusPulangEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareStatusPulangEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareStatusPulangEntitiesWithRefs here] end
		PcareStatusPulangEntityFactory pcareStatusPulangEntityFactory
	) {
		log.trace("Creating entities of type PcareStatusPulangEntity with references");

		// % protected region % [Apply any additional logic for pcareStatusPulangEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangEntitiesWithRefs before the main body here] end

		Collection<PcareStatusPulangEntity> newEntities = pcareStatusPulangEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareStatusPulangEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareStatusPulangEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareStatusPulangEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
