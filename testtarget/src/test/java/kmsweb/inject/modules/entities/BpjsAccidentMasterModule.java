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
 * Guice module for BPJS Accident Master used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsAccidentMasterModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsAccidentMasterModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsAccidentMasterModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsAccidentMasterEntityFactory bpjsAccidentMasterEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsAccidentMasterEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsAccidentMasterEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsAccidentMasterEntityFactory");

		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntityFactory before the main body here] end

		BpjsAccidentMasterEntityFactory entityFactory = new BpjsAccidentMasterEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsAccidentMasterEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsAccidentMasterEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntityFactory after the main body here] end

		log.trace("Created BpjsAccidentMasterEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Accident Master entity with no references set.
	 */
	@Provides
	@Named("bpjsAccidentMasterEntityWithNoRef")
	public BpjsAccidentMasterEntity bpjsAccidentMasterEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsAccidentMasterEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsAccidentMasterEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsAccidentMasterEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsAccidentMasterWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterWithNoRef before the main body here] end

		BpjsAccidentMasterEntity newEntity = new BpjsAccidentMasterEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for noSEP here] off begin
		String randomStringforNosep = mock
				.strings()
				.get();
		newEntity.setNosep(randomStringforNosep);
		// % protected region % [Add customisation for noSEP here] end
		// % protected region % [Add customisation for tglKejadian here] off begin
		String randomStringforTglkejadian = mock
				.strings()
				.get();
		newEntity.setTglkejadian(randomStringforTglkejadian);
		// % protected region % [Add customisation for tglKejadian here] end
		// % protected region % [Add customisation for ppkPelSEP here] off begin
		String randomStringforPpkpelsep = mock
				.strings()
				.get();
		newEntity.setPpkpelsep(randomStringforPpkpelsep);
		// % protected region % [Add customisation for ppkPelSEP here] end
		// % protected region % [Add customisation for kdProp here] off begin
		String randomStringforKdprop = mock
				.strings()
				.get();
		newEntity.setKdprop(randomStringforKdprop);
		// % protected region % [Add customisation for kdProp here] end
		// % protected region % [Add customisation for kdKab here] off begin
		String randomStringforKdkab = mock
				.strings()
				.get();
		newEntity.setKdkab(randomStringforKdkab);
		// % protected region % [Add customisation for kdKab here] end
		// % protected region % [Add customisation for kdKec here] off begin
		String randomStringforKdkec = mock
				.strings()
				.get();
		newEntity.setKdkec(randomStringforKdkec);
		// % protected region % [Add customisation for kdKec here] end
		// % protected region % [Add customisation for ketKejadian here] off begin
		String randomStringforKetkejadian = mock
				.strings()
				.get();
		newEntity.setKetkejadian(randomStringforKetkejadian);
		// % protected region % [Add customisation for ketKejadian here] end
		// % protected region % [Add customisation for noSEPSuplesi here] off begin
		String randomStringforNosepsuplesi = mock
				.strings()
				.get();
		newEntity.setNosepsuplesi(randomStringforNosepsuplesi);
		// % protected region % [Add customisation for noSEPSuplesi here] end

		// % protected region % [Apply any additional logic for bpjsAccidentMasterWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsAccidentMasterEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Accident Master entities with no reference at all.
	 */
	@Provides
	@Named("bpjsAccidentMasterEntitiesWithNoRef")
	public Collection<BpjsAccidentMasterEntity> bpjsAccidentMasterEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsAccidentMasterEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsAccidentMasterEntitiesWithNoRef here] end
		BpjsAccidentMasterEntityFactory bpjsAccidentMasterEntityFactory
	) {
		log.trace("Creating entities of type BpjsAccidentMasterEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntitiesWithNoRef before the main body here] end

		Collection<BpjsAccidentMasterEntity> newEntities = bpjsAccidentMasterEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsAccidentMasterEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Accident Master entity with all references set.
	 */
	@Provides
	@Named("bpjsAccidentMasterEntityWithRefs")
	public BpjsAccidentMasterEntity bpjsAccidentMasterEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsAccidentMasterEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsAccidentMasterEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsAccidentMasterEntity with references");

		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntityWithRefs before the main body here] end

		BpjsAccidentMasterEntity bpjsAccidentMasterEntity = injector.getInstance(Key.get(BpjsAccidentMasterEntity.class, Names.named("bpjsAccidentMasterEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsAccidentMasterEntity with references");

		return bpjsAccidentMasterEntity;
	}

	/**
	 * Return a collection of BPJS Accident Master entities with all references set.
	 */
	@Provides
	@Named("bpjsAccidentMasterEntitiesWithRefs")
	public Collection<BpjsAccidentMasterEntity> bpjsAccidentMasterEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsAccidentMasterEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsAccidentMasterEntitiesWithRefs here] end
		BpjsAccidentMasterEntityFactory bpjsAccidentMasterEntityFactory
	) {
		log.trace("Creating entities of type BpjsAccidentMasterEntity with references");

		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntitiesWithRefs before the main body here] end

		Collection<BpjsAccidentMasterEntity> newEntities = bpjsAccidentMasterEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsAccidentMasterEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsAccidentMasterEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
