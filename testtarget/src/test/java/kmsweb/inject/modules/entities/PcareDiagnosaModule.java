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
 * Guice module for PCare Diagnosa used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareDiagnosaModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareDiagnosaModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareDiagnosaModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareDiagnosaEntityFactory pcareDiagnosaEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareDiagnosaEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareDiagnosaEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareDiagnosaEntityFactory");

		// % protected region % [Apply any additional logic for pcareDiagnosaEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaEntityFactory before the main body here] end

		PcareDiagnosaEntityFactory entityFactory = new PcareDiagnosaEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareDiagnosaEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareDiagnosaEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareDiagnosaEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaEntityFactory after the main body here] end

		log.trace("Created PcareDiagnosaEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Diagnosa entity with no references set.
	 */
	@Provides
	@Named("pcareDiagnosaEntityWithNoRef")
	public PcareDiagnosaEntity pcareDiagnosaEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareDiagnosaEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareDiagnosaEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareDiagnosaEntity with no reference");

		// % protected region % [Apply any additional logic for pcareDiagnosaWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaWithNoRef before the main body here] end

		PcareDiagnosaEntity newEntity = new PcareDiagnosaEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kode Diagnosa here] off begin
		String randomStringforKodeDiagnosa = mock
				.strings()
				.get();
		newEntity.setKodeDiagnosa(randomStringforKodeDiagnosa);
		// % protected region % [Add customisation for Kode Diagnosa here] end
		// % protected region % [Add customisation for Nama Diagnosa here] off begin
		String randomStringforNamaDiagnosa = mock
				.strings()
				.get();
		newEntity.setNamaDiagnosa(randomStringforNamaDiagnosa);
		// % protected region % [Add customisation for Nama Diagnosa here] end
		// % protected region % [Add customisation for Non Spesialis here] off begin
		newEntity.setNonSpesialis(mock.bools().get());
		// % protected region % [Add customisation for Non Spesialis here] end

		// % protected region % [Apply any additional logic for pcareDiagnosaWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaWithNoRef after the main body here] end

		log.trace("Created entity of type PcareDiagnosaEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Diagnosa entities with no reference at all.
	 */
	@Provides
	@Named("pcareDiagnosaEntitiesWithNoRef")
	public Collection<PcareDiagnosaEntity> pcareDiagnosaEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareDiagnosaEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareDiagnosaEntitiesWithNoRef here] end
		PcareDiagnosaEntityFactory pcareDiagnosaEntityFactory
	) {
		log.trace("Creating entities of type PcareDiagnosaEntity with no reference");

		// % protected region % [Apply any additional logic for pcareDiagnosaEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaEntitiesWithNoRef before the main body here] end

		Collection<PcareDiagnosaEntity> newEntities = pcareDiagnosaEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareDiagnosaEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareDiagnosaEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Diagnosa entity with all references set.
	 */
	@Provides
	@Named("pcareDiagnosaEntityWithRefs")
	public PcareDiagnosaEntity pcareDiagnosaEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareDiagnosaEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareDiagnosaEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareDiagnosaEntity with references");

		// % protected region % [Apply any additional logic for pcareDiagnosaEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaEntityWithRefs before the main body here] end

		PcareDiagnosaEntity pcareDiagnosaEntity = injector.getInstance(Key.get(PcareDiagnosaEntity.class, Names.named("pcareDiagnosaEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareDiagnosaEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareDiagnosaEntity with references");

		return pcareDiagnosaEntity;
	}

	/**
	 * Return a collection of PCare Diagnosa entities with all references set.
	 */
	@Provides
	@Named("pcareDiagnosaEntitiesWithRefs")
	public Collection<PcareDiagnosaEntity> pcareDiagnosaEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareDiagnosaEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareDiagnosaEntitiesWithRefs here] end
		PcareDiagnosaEntityFactory pcareDiagnosaEntityFactory
	) {
		log.trace("Creating entities of type PcareDiagnosaEntity with references");

		// % protected region % [Apply any additional logic for pcareDiagnosaEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaEntitiesWithRefs before the main body here] end

		Collection<PcareDiagnosaEntity> newEntities = pcareDiagnosaEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareDiagnosaEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareDiagnosaEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareDiagnosaEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
