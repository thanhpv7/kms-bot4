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
 * Guice module for NHIS GDRG used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NhisGDRGModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NhisGDRGModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NhisGDRGModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NhisGDRGEntityFactory nhisGDRGEntityFactory(
			// % protected region % [Apply any additional injected arguments for nhisGDRGEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nhisGDRGEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NhisGDRGEntityFactory");

		// % protected region % [Apply any additional logic for nhisGDRGEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGEntityFactory before the main body here] end

		NhisGDRGEntityFactory entityFactory = new NhisGDRGEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NhisGDRGEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NhisGDRGEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nhisGDRGEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGEntityFactory after the main body here] end

		log.trace("Created NhisGDRGEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty NHIS GDRG entity with no references set.
	 */
	@Provides
	@Named("nhisGDRGEntityWithNoRef")
	public NhisGDRGEntity nhisGDRGEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nhisGDRGEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisGDRGEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NhisGDRGEntity with no reference");

		// % protected region % [Apply any additional logic for nhisGDRGWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGWithNoRef before the main body here] end

		NhisGDRGEntity newEntity = new NhisGDRGEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Core GDRG Code here] off begin
		String randomStringforCoreGDRGCode = mock
				.strings()
				.get();
		newEntity.setCoreGDRGCode(randomStringforCoreGDRGCode);
		// % protected region % [Add customisation for Core GDRG Code here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Category here] off begin
		String randomStringforCategory = mock
				.strings()
				.get();
		newEntity.setCategory(randomStringforCategory);
		// % protected region % [Add customisation for Category here] end
		// % protected region % [Add customisation for Level of Healthcare here] off begin
		String randomStringforLevelOfHealthcare = mock
				.strings()
				.get();
		newEntity.setLevelOfHealthcare(randomStringforLevelOfHealthcare);
		// % protected region % [Add customisation for Level of Healthcare here] end
		// % protected region % [Add customisation for Investigation Code here] off begin
		String randomStringforInvestigationCode = mock
				.strings()
				.get();
		newEntity.setInvestigationCode(randomStringforInvestigationCode);
		// % protected region % [Add customisation for Investigation Code here] end
		// % protected region % [Add customisation for icd10s here] off begin
		String randomStringforIcd10s = mock
				.strings()
				.get();
		newEntity.setIcd10s(randomStringforIcd10s);
		// % protected region % [Add customisation for icd10s here] end

		// % protected region % [Apply any additional logic for nhisGDRGWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGWithNoRef after the main body here] end

		log.trace("Created entity of type NhisGDRGEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of NHIS GDRG entities with no reference at all.
	 */
	@Provides
	@Named("nhisGDRGEntitiesWithNoRef")
	public Collection<NhisGDRGEntity> nhisGDRGEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nhisGDRGEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisGDRGEntitiesWithNoRef here] end
		NhisGDRGEntityFactory nhisGDRGEntityFactory
	) {
		log.trace("Creating entities of type NhisGDRGEntity with no reference");

		// % protected region % [Apply any additional logic for nhisGDRGEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGEntitiesWithNoRef before the main body here] end

		Collection<NhisGDRGEntity> newEntities = nhisGDRGEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nhisGDRGEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NhisGDRGEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a NHIS GDRG entity with all references set.
	 */
	@Provides
	@Named("nhisGDRGEntityWithRefs")
	public NhisGDRGEntity nhisGDRGEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nhisGDRGEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisGDRGEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NhisGDRGEntity with references");

		// % protected region % [Apply any additional logic for nhisGDRGEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGEntityWithRefs before the main body here] end

		NhisGDRGEntity nhisGDRGEntity = injector.getInstance(Key.get(NhisGDRGEntity.class, Names.named("nhisGDRGEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nhisGDRGEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGEntityWithRefs after the main body here] end

		log.trace("Created entity of type NhisGDRGEntity with references");

		return nhisGDRGEntity;
	}

	/**
	 * Return a collection of NHIS GDRG entities with all references set.
	 */
	@Provides
	@Named("nhisGDRGEntitiesWithRefs")
	public Collection<NhisGDRGEntity> nhisGDRGEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nhisGDRGEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisGDRGEntitiesWithRefs here] end
		NhisGDRGEntityFactory nhisGDRGEntityFactory
	) {
		log.trace("Creating entities of type NhisGDRGEntity with references");

		// % protected region % [Apply any additional logic for nhisGDRGEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGEntitiesWithRefs before the main body here] end

		Collection<NhisGDRGEntity> newEntities = nhisGDRGEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nhisGDRGEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisGDRGEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NhisGDRGEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
