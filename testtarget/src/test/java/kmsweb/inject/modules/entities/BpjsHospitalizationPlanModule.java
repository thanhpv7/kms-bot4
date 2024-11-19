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
 * Guice module for BPJS Hospitalization Plan used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsHospitalizationPlanModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsHospitalizationPlanModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsHospitalizationPlanModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsHospitalizationPlanEntityFactory bpjsHospitalizationPlanEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsHospitalizationPlanEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsHospitalizationPlanEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsHospitalizationPlanEntityFactory");

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntityFactory before the main body here] end

		BpjsHospitalizationPlanEntityFactory entityFactory = new BpjsHospitalizationPlanEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsHospitalizationPlanEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsHospitalizationPlanEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntityFactory after the main body here] end

		log.trace("Created BpjsHospitalizationPlanEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Hospitalization Plan entity with no references set.
	 */
	@Provides
	@Named("bpjsHospitalizationPlanEntityWithNoRef")
	public BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsHospitalizationPlanEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsHospitalizationPlanEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsHospitalizationPlanEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanWithNoRef before the main body here] end

		BpjsHospitalizationPlanEntity newEntity = new BpjsHospitalizationPlanEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noKartu here] off begin
		String randomStringforNokartu = mock
				.strings()
				.get();
		newEntity.setNokartu(randomStringforNokartu);
		// % protected region % [Add customisation for noKartu here] end
		// % protected region % [Add customisation for tglRencanaKontrol here] off begin
		newEntity.setTglrencanakontrol(OffsetDateTime.now());
		// % protected region % [Add customisation for tglRencanaKontrol here] end
		// % protected region % [Add customisation for noSPRI here] off begin
		String randomStringforNospri = mock
				.strings()
				.get();
		newEntity.setNospri(randomStringforNospri);
		// % protected region % [Add customisation for noSPRI here] end
		// % protected region % [Add customisation for diagnosa here] off begin
		String randomStringforDiagnosa = mock
				.strings()
				.get();
		newEntity.setDiagnosa(randomStringforDiagnosa);
		// % protected region % [Add customisation for diagnosa here] end

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsHospitalizationPlanEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Hospitalization Plan entities with no reference at all.
	 */
	@Provides
	@Named("bpjsHospitalizationPlanEntitiesWithNoRef")
	public Collection<BpjsHospitalizationPlanEntity> bpjsHospitalizationPlanEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsHospitalizationPlanEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsHospitalizationPlanEntitiesWithNoRef here] end
		BpjsHospitalizationPlanEntityFactory bpjsHospitalizationPlanEntityFactory
	) {
		log.trace("Creating entities of type BpjsHospitalizationPlanEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntitiesWithNoRef before the main body here] end

		Collection<BpjsHospitalizationPlanEntity> newEntities = bpjsHospitalizationPlanEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsHospitalizationPlanEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Hospitalization Plan entity with all references set.
	 */
	@Provides
	@Named("bpjsHospitalizationPlanEntityWithRefs")
	public BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsHospitalizationPlanEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsHospitalizationPlanEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsHospitalizationPlanEntity with references");

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntityWithRefs before the main body here] end

		BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntity = injector.getInstance(Key.get(BpjsHospitalizationPlanEntity.class, Names.named("bpjsHospitalizationPlanEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsHospitalizationPlanEntity with references");

		return bpjsHospitalizationPlanEntity;
	}

	/**
	 * Return a collection of BPJS Hospitalization Plan entities with all references set.
	 */
	@Provides
	@Named("bpjsHospitalizationPlanEntitiesWithRefs")
	public Collection<BpjsHospitalizationPlanEntity> bpjsHospitalizationPlanEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsHospitalizationPlanEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsHospitalizationPlanEntitiesWithRefs here] end
		BpjsHospitalizationPlanEntityFactory bpjsHospitalizationPlanEntityFactory
	) {
		log.trace("Creating entities of type BpjsHospitalizationPlanEntity with references");

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntitiesWithRefs before the main body here] end

		Collection<BpjsHospitalizationPlanEntity> newEntities = bpjsHospitalizationPlanEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsHospitalizationPlanEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsHospitalizationPlanEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
