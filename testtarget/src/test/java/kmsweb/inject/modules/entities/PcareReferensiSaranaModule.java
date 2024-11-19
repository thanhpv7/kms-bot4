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
 * Guice module for PCare Referensi Sarana used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareReferensiSaranaModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareReferensiSaranaModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareReferensiSaranaModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareReferensiSaranaEntityFactory pcareReferensiSaranaEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareReferensiSaranaEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareReferensiSaranaEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareReferensiSaranaEntityFactory");

		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntityFactory before the main body here] end

		PcareReferensiSaranaEntityFactory entityFactory = new PcareReferensiSaranaEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareReferensiSaranaEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareReferensiSaranaEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntityFactory after the main body here] end

		log.trace("Created PcareReferensiSaranaEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Referensi Sarana entity with no references set.
	 */
	@Provides
	@Named("pcareReferensiSaranaEntityWithNoRef")
	public PcareReferensiSaranaEntity pcareReferensiSaranaEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareReferensiSaranaEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareReferensiSaranaEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareReferensiSaranaEntity with no reference");

		// % protected region % [Apply any additional logic for pcareReferensiSaranaWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaWithNoRef before the main body here] end

		PcareReferensiSaranaEntity newEntity = new PcareReferensiSaranaEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kode Sarana here] off begin
		String randomStringforKodeSarana = mock
				.strings()
				.get();
		newEntity.setKodeSarana(randomStringforKodeSarana);
		// % protected region % [Add customisation for Kode Sarana here] end
		// % protected region % [Add customisation for Nama Sarana here] off begin
		String randomStringforNamaSarana = mock
				.strings()
				.get();
		newEntity.setNamaSarana(randomStringforNamaSarana);
		// % protected region % [Add customisation for Nama Sarana here] end

		// % protected region % [Apply any additional logic for pcareReferensiSaranaWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaWithNoRef after the main body here] end

		log.trace("Created entity of type PcareReferensiSaranaEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Referensi Sarana entities with no reference at all.
	 */
	@Provides
	@Named("pcareReferensiSaranaEntitiesWithNoRef")
	public Collection<PcareReferensiSaranaEntity> pcareReferensiSaranaEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareReferensiSaranaEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareReferensiSaranaEntitiesWithNoRef here] end
		PcareReferensiSaranaEntityFactory pcareReferensiSaranaEntityFactory
	) {
		log.trace("Creating entities of type PcareReferensiSaranaEntity with no reference");

		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntitiesWithNoRef before the main body here] end

		Collection<PcareReferensiSaranaEntity> newEntities = pcareReferensiSaranaEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareReferensiSaranaEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Referensi Sarana entity with all references set.
	 */
	@Provides
	@Named("pcareReferensiSaranaEntityWithRefs")
	public PcareReferensiSaranaEntity pcareReferensiSaranaEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareReferensiSaranaEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareReferensiSaranaEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareReferensiSaranaEntity with references");

		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntityWithRefs before the main body here] end

		PcareReferensiSaranaEntity pcareReferensiSaranaEntity = injector.getInstance(Key.get(PcareReferensiSaranaEntity.class, Names.named("pcareReferensiSaranaEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareReferensiSaranaEntity with references");

		return pcareReferensiSaranaEntity;
	}

	/**
	 * Return a collection of PCare Referensi Sarana entities with all references set.
	 */
	@Provides
	@Named("pcareReferensiSaranaEntitiesWithRefs")
	public Collection<PcareReferensiSaranaEntity> pcareReferensiSaranaEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareReferensiSaranaEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareReferensiSaranaEntitiesWithRefs here] end
		PcareReferensiSaranaEntityFactory pcareReferensiSaranaEntityFactory
	) {
		log.trace("Creating entities of type PcareReferensiSaranaEntity with references");

		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntitiesWithRefs before the main body here] end

		Collection<PcareReferensiSaranaEntity> newEntities = pcareReferensiSaranaEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareReferensiSaranaEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareReferensiSaranaEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
