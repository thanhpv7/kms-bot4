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
 * Guice module for PCare Action Examination used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareActionExaminationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareActionExaminationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareActionExaminationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareActionExaminationEntityFactory pcareActionExaminationEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareActionExaminationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareActionExaminationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareActionExaminationEntityFactory");

		// % protected region % [Apply any additional logic for pcareActionExaminationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationEntityFactory before the main body here] end

		PcareActionExaminationEntityFactory entityFactory = new PcareActionExaminationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareActionExaminationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareActionExaminationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareActionExaminationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationEntityFactory after the main body here] end

		log.trace("Created PcareActionExaminationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Action Examination entity with no references set.
	 */
	@Provides
	@Named("pcareActionExaminationEntityWithNoRef")
	public PcareActionExaminationEntity pcareActionExaminationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareActionExaminationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareActionExaminationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareActionExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for pcareActionExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationWithNoRef before the main body here] end

		PcareActionExaminationEntity newEntity = new PcareActionExaminationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Action Code here] off begin
		String randomStringforActionCode = mock
				.strings()
				.get();
		newEntity.setActionCode(randomStringforActionCode);
		// % protected region % [Add customisation for Action Code here] end
		// % protected region % [Add customisation for Fee here] off begin
		newEntity.setFee(mock.doubles().get());
		// % protected region % [Add customisation for Fee here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for kdTindakanSK here] off begin
		String randomStringforKdtindakansk = mock
				.strings()
				.get();
		newEntity.setKdtindakansk(randomStringforKdtindakansk);
		// % protected region % [Add customisation for kdTindakanSK here] end
		// % protected region % [Add customisation for hasil here] off begin
		newEntity.setHasil(mock.ints().get());
		// % protected region % [Add customisation for hasil here] end

		// % protected region % [Apply any additional logic for pcareActionExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationWithNoRef after the main body here] end

		log.trace("Created entity of type PcareActionExaminationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Action Examination entities with no reference at all.
	 */
	@Provides
	@Named("pcareActionExaminationEntitiesWithNoRef")
	public Collection<PcareActionExaminationEntity> pcareActionExaminationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareActionExaminationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareActionExaminationEntitiesWithNoRef here] end
		PcareActionExaminationEntityFactory pcareActionExaminationEntityFactory
	) {
		log.trace("Creating entities of type PcareActionExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for pcareActionExaminationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationEntitiesWithNoRef before the main body here] end

		Collection<PcareActionExaminationEntity> newEntities = pcareActionExaminationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareActionExaminationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareActionExaminationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Action Examination entity with all references set.
	 */
	@Provides
	@Named("pcareActionExaminationEntityWithRefs")
	public PcareActionExaminationEntity pcareActionExaminationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareActionExaminationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareActionExaminationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareActionExaminationEntity with references");

		// % protected region % [Apply any additional logic for pcareActionExaminationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationEntityWithRefs before the main body here] end

		PcareActionExaminationEntity pcareActionExaminationEntity = injector.getInstance(Key.get(PcareActionExaminationEntity.class, Names.named("pcareActionExaminationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareActionExaminationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareActionExaminationEntity with references");

		return pcareActionExaminationEntity;
	}

	/**
	 * Return a collection of PCare Action Examination entities with all references set.
	 */
	@Provides
	@Named("pcareActionExaminationEntitiesWithRefs")
	public Collection<PcareActionExaminationEntity> pcareActionExaminationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareActionExaminationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareActionExaminationEntitiesWithRefs here] end
		PcareActionExaminationEntityFactory pcareActionExaminationEntityFactory
	) {
		log.trace("Creating entities of type PcareActionExaminationEntity with references");

		// % protected region % [Apply any additional logic for pcareActionExaminationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationEntitiesWithRefs before the main body here] end

		Collection<PcareActionExaminationEntity> newEntities = pcareActionExaminationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareActionExaminationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareActionExaminationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareActionExaminationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
