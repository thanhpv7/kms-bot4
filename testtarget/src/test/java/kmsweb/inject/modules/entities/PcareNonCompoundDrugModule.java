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
 * Guice module for PCare NonCompound Drug used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareNonCompoundDrugModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareNonCompoundDrugModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareNonCompoundDrugModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareNonCompoundDrugEntityFactory pcareNonCompoundDrugEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareNonCompoundDrugEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareNonCompoundDrugEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareNonCompoundDrugEntityFactory");

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntityFactory before the main body here] end

		PcareNonCompoundDrugEntityFactory entityFactory = new PcareNonCompoundDrugEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareNonCompoundDrugEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareNonCompoundDrugEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntityFactory after the main body here] end

		log.trace("Created PcareNonCompoundDrugEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare NonCompound Drug entity with no references set.
	 */
	@Provides
	@Named("pcareNonCompoundDrugEntityWithNoRef")
	public PcareNonCompoundDrugEntity pcareNonCompoundDrugEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareNonCompoundDrugEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareNonCompoundDrugEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareNonCompoundDrugEntity with no reference");

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugWithNoRef before the main body here] end

		PcareNonCompoundDrugEntity newEntity = new PcareNonCompoundDrugEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Drug Code here] off begin
		String randomStringforDrugCode = mock
				.strings()
				.get();
		newEntity.setDrugCode(randomStringforDrugCode);
		// % protected region % [Add customisation for Drug Code here] end
		// % protected region % [Add customisation for Drug Name here] off begin
		String randomStringforDrugName = mock
				.strings()
				.get();
		newEntity.setDrugName(randomStringforDrugName);
		// % protected region % [Add customisation for Drug Name here] end
		// % protected region % [Add customisation for Signa Days here] off begin
		newEntity.setSignaDays(mock.doubles().get());
		// % protected region % [Add customisation for Signa Days here] end
		// % protected region % [Add customisation for Signa Times here] off begin
		newEntity.setSignaTimes(mock.ints().get());
		// % protected region % [Add customisation for Signa Times here] end
		// % protected region % [Add customisation for Drug Qty here] off begin
		newEntity.setDrugQty(mock.doubles().get());
		// % protected region % [Add customisation for Drug Qty here] end
		// % protected region % [Add customisation for Day here] off begin
		newEntity.setDay(mock.doubles().get());
		// % protected region % [Add customisation for Day here] end
		// % protected region % [Add customisation for Request Qty here] off begin
		newEntity.setRequestQty(mock.ints().get());
		// % protected region % [Add customisation for Request Qty here] end
		// % protected region % [Add customisation for Kd Obat SK here] off begin
		String randomStringforKdObatSK = mock
				.strings()
				.get();
		newEntity.setKdObatSK(randomStringforKdObatSK);
		// % protected region % [Add customisation for Kd Obat SK here] end
		// % protected region % [Add customisation for Racikan here] off begin
		newEntity.setRacikan(mock.bools().get());
		// % protected region % [Add customisation for Racikan here] end
		// % protected region % [Add customisation for Kd Racikan here] off begin
		String randomStringforKdRacikan = mock
				.strings()
				.get();
		newEntity.setKdRacikan(randomStringforKdRacikan);
		// % protected region % [Add customisation for Kd Racikan here] end

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugWithNoRef after the main body here] end

		log.trace("Created entity of type PcareNonCompoundDrugEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare NonCompound Drug entities with no reference at all.
	 */
	@Provides
	@Named("pcareNonCompoundDrugEntitiesWithNoRef")
	public Collection<PcareNonCompoundDrugEntity> pcareNonCompoundDrugEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareNonCompoundDrugEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareNonCompoundDrugEntitiesWithNoRef here] end
		PcareNonCompoundDrugEntityFactory pcareNonCompoundDrugEntityFactory
	) {
		log.trace("Creating entities of type PcareNonCompoundDrugEntity with no reference");

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntitiesWithNoRef before the main body here] end

		Collection<PcareNonCompoundDrugEntity> newEntities = pcareNonCompoundDrugEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareNonCompoundDrugEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare NonCompound Drug entity with all references set.
	 */
	@Provides
	@Named("pcareNonCompoundDrugEntityWithRefs")
	public PcareNonCompoundDrugEntity pcareNonCompoundDrugEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareNonCompoundDrugEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareNonCompoundDrugEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareNonCompoundDrugEntity with references");

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntityWithRefs before the main body here] end

		PcareNonCompoundDrugEntity pcareNonCompoundDrugEntity = injector.getInstance(Key.get(PcareNonCompoundDrugEntity.class, Names.named("pcareNonCompoundDrugEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareNonCompoundDrugEntity with references");

		return pcareNonCompoundDrugEntity;
	}

	/**
	 * Return a collection of PCare NonCompound Drug entities with all references set.
	 */
	@Provides
	@Named("pcareNonCompoundDrugEntitiesWithRefs")
	public Collection<PcareNonCompoundDrugEntity> pcareNonCompoundDrugEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareNonCompoundDrugEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareNonCompoundDrugEntitiesWithRefs here] end
		PcareNonCompoundDrugEntityFactory pcareNonCompoundDrugEntityFactory
	) {
		log.trace("Creating entities of type PcareNonCompoundDrugEntity with references");

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntitiesWithRefs before the main body here] end

		Collection<PcareNonCompoundDrugEntity> newEntities = pcareNonCompoundDrugEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareNonCompoundDrugEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareNonCompoundDrugEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
