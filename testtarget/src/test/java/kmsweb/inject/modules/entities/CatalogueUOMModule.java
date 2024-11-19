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
 * Guice module for Catalogue UOM used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class CatalogueUOMModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring CatalogueUOMModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured CatalogueUOMModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public CatalogueUOMEntityFactory catalogueUOMEntityFactory(
			// % protected region % [Apply any additional injected arguments for catalogueUOMEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for catalogueUOMEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating CatalogueUOMEntityFactory");

		// % protected region % [Apply any additional logic for catalogueUOMEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMEntityFactory before the main body here] end

		CatalogueUOMEntityFactory entityFactory = new CatalogueUOMEntityFactory(
				// % protected region % [Apply any additional constructor arguments for CatalogueUOMEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for CatalogueUOMEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for catalogueUOMEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMEntityFactory after the main body here] end

		log.trace("Created CatalogueUOMEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Catalogue UOM entity with no references set.
	 */
	@Provides
	@Named("catalogueUOMEntityWithNoRef")
	public CatalogueUOMEntity catalogueUOMEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for catalogueUOMEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for catalogueUOMEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type CatalogueUOMEntity with no reference");

		// % protected region % [Apply any additional logic for catalogueUOMWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMWithNoRef before the main body here] end

		CatalogueUOMEntity newEntity = new CatalogueUOMEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Unit Name here] off begin
		String randomStringforUnitName = mock
				.strings()
				.get();
		newEntity.setUnitName(randomStringforUnitName);
		// % protected region % [Add customisation for Unit Name here] end
		// % protected region % [Add customisation for Conversion here] off begin
		String randomStringforConversion = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setConversion(randomStringforConversion);
		// % protected region % [Add customisation for Conversion here] end
		// % protected region % [Add customisation for Default Transaction here] off begin
		newEntity.setDefaultTransaction(mock.bools().get());
		// % protected region % [Add customisation for Default Transaction here] end
		// % protected region % [Add customisation for Default Stock Card here] off begin
		newEntity.setDefaultStockCard(mock.bools().get());
		// % protected region % [Add customisation for Default Stock Card here] end
		// % protected region % [Add customisation for Default Purchasing here] off begin
		newEntity.setDefaultPurchasing(mock.bools().get());
		// % protected region % [Add customisation for Default Purchasing here] end

		// % protected region % [Apply any additional logic for catalogueUOMWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMWithNoRef after the main body here] end

		log.trace("Created entity of type CatalogueUOMEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Catalogue UOM entities with no reference at all.
	 */
	@Provides
	@Named("catalogueUOMEntitiesWithNoRef")
	public Collection<CatalogueUOMEntity> catalogueUOMEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for catalogueUOMEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for catalogueUOMEntitiesWithNoRef here] end
		CatalogueUOMEntityFactory catalogueUOMEntityFactory
	) {
		log.trace("Creating entities of type CatalogueUOMEntity with no reference");

		// % protected region % [Apply any additional logic for catalogueUOMEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMEntitiesWithNoRef before the main body here] end

		Collection<CatalogueUOMEntity> newEntities = catalogueUOMEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for catalogueUOMEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type CatalogueUOMEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Catalogue UOM entity with all references set.
	 */
	@Provides
	@Named("catalogueUOMEntityWithRefs")
	public CatalogueUOMEntity catalogueUOMEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for catalogueUOMEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for catalogueUOMEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type CatalogueUOMEntity with references");

		// % protected region % [Apply any additional logic for catalogueUOMEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMEntityWithRefs before the main body here] end

		CatalogueUOMEntity catalogueUOMEntity = injector.getInstance(Key.get(CatalogueUOMEntity.class, Names.named("catalogueUOMEntityWithNoRef")));

		// % protected region % [Apply any additional logic for catalogueUOMEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMEntityWithRefs after the main body here] end

		log.trace("Created entity of type CatalogueUOMEntity with references");

		return catalogueUOMEntity;
	}

	/**
	 * Return a collection of Catalogue UOM entities with all references set.
	 */
	@Provides
	@Named("catalogueUOMEntitiesWithRefs")
	public Collection<CatalogueUOMEntity> catalogueUOMEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for catalogueUOMEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for catalogueUOMEntitiesWithRefs here] end
		CatalogueUOMEntityFactory catalogueUOMEntityFactory
	) {
		log.trace("Creating entities of type CatalogueUOMEntity with references");

		// % protected region % [Apply any additional logic for catalogueUOMEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMEntitiesWithRefs before the main body here] end

		Collection<CatalogueUOMEntity> newEntities = catalogueUOMEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for catalogueUOMEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueUOMEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type CatalogueUOMEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
