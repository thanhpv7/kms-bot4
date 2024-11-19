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
 * Guice module for PCare Compound Drug used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareCompoundDrugModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareCompoundDrugModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareCompoundDrugModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareCompoundDrugEntityFactory pcareCompoundDrugEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareCompoundDrugEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareCompoundDrugEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareCompoundDrugEntityFactory");

		// % protected region % [Apply any additional logic for pcareCompoundDrugEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugEntityFactory before the main body here] end

		PcareCompoundDrugEntityFactory entityFactory = new PcareCompoundDrugEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareCompoundDrugEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareCompoundDrugEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareCompoundDrugEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugEntityFactory after the main body here] end

		log.trace("Created PcareCompoundDrugEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Compound Drug entity with no references set.
	 */
	@Provides
	@Named("pcareCompoundDrugEntityWithNoRef")
	public PcareCompoundDrugEntity pcareCompoundDrugEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareCompoundDrugEntity with no reference");

		// % protected region % [Apply any additional logic for pcareCompoundDrugWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugWithNoRef before the main body here] end

		PcareCompoundDrugEntity newEntity = new PcareCompoundDrugEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Compound Name here] off begin
		String randomStringforCompoundName = mock
				.strings()
				.get();
		newEntity.setCompoundName(randomStringforCompoundName);
		// % protected region % [Add customisation for Compound Name here] end
		// % protected region % [Add customisation for Signa Days here] off begin
		newEntity.setSignaDays(mock.doubles().get());
		// % protected region % [Add customisation for Signa Days here] end
		// % protected region % [Add customisation for Signa Times here] off begin
		newEntity.setSignaTimes(mock.ints().get());
		// % protected region % [Add customisation for Signa Times here] end
		// % protected region % [Add customisation for Package Qty here] off begin
		newEntity.setPackageQty(mock.doubles().get());
		// % protected region % [Add customisation for Package Qty here] end
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
		// % protected region % [Add customisation for Nama Obat Non DPHO here] off begin
		String randomStringforNamaObatNonDPHO = mock
				.strings()
				.get();
		newEntity.setNamaObatNonDPHO(randomStringforNamaObatNonDPHO);
		// % protected region % [Add customisation for Nama Obat Non DPHO here] end
		// % protected region % [Add customisation for Drug Qty here] off begin
		newEntity.setDrugQty(mock.doubles().get());
		// % protected region % [Add customisation for Drug Qty here] end

		// % protected region % [Apply any additional logic for pcareCompoundDrugWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugWithNoRef after the main body here] end

		log.trace("Created entity of type PcareCompoundDrugEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Compound Drug entities with no reference at all.
	 */
	@Provides
	@Named("pcareCompoundDrugEntitiesWithNoRef")
	public Collection<PcareCompoundDrugEntity> pcareCompoundDrugEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugEntitiesWithNoRef here] end
		PcareCompoundDrugEntityFactory pcareCompoundDrugEntityFactory
	) {
		log.trace("Creating entities of type PcareCompoundDrugEntity with no reference");

		// % protected region % [Apply any additional logic for pcareCompoundDrugEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugEntitiesWithNoRef before the main body here] end

		Collection<PcareCompoundDrugEntity> newEntities = pcareCompoundDrugEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareCompoundDrugEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareCompoundDrugEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Compound Drug entity with all references set.
	 */
	@Provides
	@Named("pcareCompoundDrugEntityWithRefs")
	public PcareCompoundDrugEntity pcareCompoundDrugEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareCompoundDrugEntity with references");

		// % protected region % [Apply any additional logic for pcareCompoundDrugEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugEntityWithRefs before the main body here] end

		PcareCompoundDrugEntity pcareCompoundDrugEntity = injector.getInstance(Key.get(PcareCompoundDrugEntity.class, Names.named("pcareCompoundDrugEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareCompoundDrugEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareCompoundDrugEntity with references");

		return pcareCompoundDrugEntity;
	}

	/**
	 * Return a collection of PCare Compound Drug entities with all references set.
	 */
	@Provides
	@Named("pcareCompoundDrugEntitiesWithRefs")
	public Collection<PcareCompoundDrugEntity> pcareCompoundDrugEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugEntitiesWithRefs here] end
		PcareCompoundDrugEntityFactory pcareCompoundDrugEntityFactory
	) {
		log.trace("Creating entities of type PcareCompoundDrugEntity with references");

		// % protected region % [Apply any additional logic for pcareCompoundDrugEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugEntitiesWithRefs before the main body here] end

		Collection<PcareCompoundDrugEntity> newEntities = pcareCompoundDrugEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareCompoundDrugEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareCompoundDrugEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
