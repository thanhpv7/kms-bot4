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
 * Guice module for PCare Compound Drug Item used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareCompoundDrugItemModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareCompoundDrugItemModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareCompoundDrugItemModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareCompoundDrugItemEntityFactory pcareCompoundDrugItemEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareCompoundDrugItemEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareCompoundDrugItemEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareCompoundDrugItemEntityFactory");

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntityFactory before the main body here] end

		PcareCompoundDrugItemEntityFactory entityFactory = new PcareCompoundDrugItemEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareCompoundDrugItemEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareCompoundDrugItemEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntityFactory after the main body here] end

		log.trace("Created PcareCompoundDrugItemEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Compound Drug Item entity with no references set.
	 */
	@Provides
	@Named("pcareCompoundDrugItemEntityWithNoRef")
	public PcareCompoundDrugItemEntity pcareCompoundDrugItemEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugItemEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugItemEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareCompoundDrugItemEntity with no reference");

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemWithNoRef before the main body here] end

		PcareCompoundDrugItemEntity newEntity = new PcareCompoundDrugItemEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Drug Code here] off begin
		String randomStringforDrugCode = mock
				.strings()
				.get();
		newEntity.setDrugCode(randomStringforDrugCode);
		// % protected region % [Add customisation for Drug Code here] end
		// % protected region % [Add customisation for Drug Qty here] off begin
		newEntity.setDrugQty(mock.doubles().get());
		// % protected region % [Add customisation for Drug Qty here] end
		// % protected region % [Add customisation for Request here] off begin
		newEntity.setRequest(mock.doubles().get());
		// % protected region % [Add customisation for Request here] end
		// % protected region % [Add customisation for Dose here] off begin
		newEntity.setDose(mock.doubles().get());
		// % protected region % [Add customisation for Dose here] end

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemWithNoRef after the main body here] end

		log.trace("Created entity of type PcareCompoundDrugItemEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Compound Drug Item entities with no reference at all.
	 */
	@Provides
	@Named("pcareCompoundDrugItemEntitiesWithNoRef")
	public Collection<PcareCompoundDrugItemEntity> pcareCompoundDrugItemEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugItemEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugItemEntitiesWithNoRef here] end
		PcareCompoundDrugItemEntityFactory pcareCompoundDrugItemEntityFactory
	) {
		log.trace("Creating entities of type PcareCompoundDrugItemEntity with no reference");

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntitiesWithNoRef before the main body here] end

		Collection<PcareCompoundDrugItemEntity> newEntities = pcareCompoundDrugItemEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareCompoundDrugItemEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Compound Drug Item entity with all references set.
	 */
	@Provides
	@Named("pcareCompoundDrugItemEntityWithRefs")
	public PcareCompoundDrugItemEntity pcareCompoundDrugItemEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugItemEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugItemEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareCompoundDrugItemEntity with references");

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntityWithRefs before the main body here] end

		PcareCompoundDrugItemEntity pcareCompoundDrugItemEntity = injector.getInstance(Key.get(PcareCompoundDrugItemEntity.class, Names.named("pcareCompoundDrugItemEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareCompoundDrugItemEntity with references");

		return pcareCompoundDrugItemEntity;
	}

	/**
	 * Return a collection of PCare Compound Drug Item entities with all references set.
	 */
	@Provides
	@Named("pcareCompoundDrugItemEntitiesWithRefs")
	public Collection<PcareCompoundDrugItemEntity> pcareCompoundDrugItemEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugItemEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareCompoundDrugItemEntitiesWithRefs here] end
		PcareCompoundDrugItemEntityFactory pcareCompoundDrugItemEntityFactory
	) {
		log.trace("Creating entities of type PcareCompoundDrugItemEntity with references");

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntitiesWithRefs before the main body here] end

		Collection<PcareCompoundDrugItemEntity> newEntities = pcareCompoundDrugItemEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareCompoundDrugItemEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareCompoundDrugItemEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
