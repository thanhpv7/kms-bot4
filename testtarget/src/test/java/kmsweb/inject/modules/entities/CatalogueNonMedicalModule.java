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
 * Guice module for Catalogue Non Medical used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class CatalogueNonMedicalModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring CatalogueNonMedicalModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured CatalogueNonMedicalModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public CatalogueNonMedicalEntityFactory catalogueNonMedicalEntityFactory(
			// % protected region % [Apply any additional injected arguments for catalogueNonMedicalEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for catalogueNonMedicalEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating CatalogueNonMedicalEntityFactory");

		// % protected region % [Apply any additional logic for catalogueNonMedicalEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalEntityFactory before the main body here] end

		CatalogueNonMedicalEntityFactory entityFactory = new CatalogueNonMedicalEntityFactory(
				// % protected region % [Apply any additional constructor arguments for CatalogueNonMedicalEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for CatalogueNonMedicalEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for catalogueNonMedicalEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalEntityFactory after the main body here] end

		log.trace("Created CatalogueNonMedicalEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Catalogue Non Medical entity with no references set.
	 */
	@Provides
	@Named("catalogueNonMedicalEntityWithNoRef")
	public CatalogueNonMedicalEntity catalogueNonMedicalEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for catalogueNonMedicalEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for catalogueNonMedicalEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type CatalogueNonMedicalEntity with no reference");

		// % protected region % [Apply any additional logic for catalogueNonMedicalWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalWithNoRef before the main body here] end

		CatalogueNonMedicalEntity newEntity = new CatalogueNonMedicalEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Manufacturer here] off begin
		String randomStringforManufacturer = mock
				.strings()
				.get();
		newEntity.setManufacturer(randomStringforManufacturer);
		// % protected region % [Add customisation for Manufacturer here] end
		// % protected region % [Add customisation for Manufacturer Item Number here] off begin
		String randomStringforManufacturerItemNumber = mock
				.strings()
				.get();
		newEntity.setManufacturerItemNumber(randomStringforManufacturerItemNumber);
		// % protected region % [Add customisation for Manufacturer Item Number here] end
		// % protected region % [Add customisation for Is Expensive Item here] off begin
		newEntity.setIsExpensiveItem(mock.bools().get());
		// % protected region % [Add customisation for Is Expensive Item here] end
		// % protected region % [Add customisation for Is Consignment Item here] off begin
		newEntity.setIsConsignmentItem(mock.bools().get());
		// % protected region % [Add customisation for Is Consignment Item here] end
		// % protected region % [Add customisation for Model here] off begin
		String randomStringforModel = mock
				.strings()
				.get();
		newEntity.setModel(randomStringforModel);
		// % protected region % [Add customisation for Model here] end

		// % protected region % [Apply any additional logic for catalogueNonMedicalWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalWithNoRef after the main body here] end

		log.trace("Created entity of type CatalogueNonMedicalEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Catalogue Non Medical entities with no reference at all.
	 */
	@Provides
	@Named("catalogueNonMedicalEntitiesWithNoRef")
	public Collection<CatalogueNonMedicalEntity> catalogueNonMedicalEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for catalogueNonMedicalEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for catalogueNonMedicalEntitiesWithNoRef here] end
		CatalogueNonMedicalEntityFactory catalogueNonMedicalEntityFactory
	) {
		log.trace("Creating entities of type CatalogueNonMedicalEntity with no reference");

		// % protected region % [Apply any additional logic for catalogueNonMedicalEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalEntitiesWithNoRef before the main body here] end

		Collection<CatalogueNonMedicalEntity> newEntities = catalogueNonMedicalEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for catalogueNonMedicalEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type CatalogueNonMedicalEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Catalogue Non Medical entity with all references set.
	 */
	@Provides
	@Named("catalogueNonMedicalEntityWithRefs")
	public CatalogueNonMedicalEntity catalogueNonMedicalEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for catalogueNonMedicalEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for catalogueNonMedicalEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type CatalogueNonMedicalEntity with references");

		// % protected region % [Apply any additional logic for catalogueNonMedicalEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalEntityWithRefs before the main body here] end

		CatalogueNonMedicalEntity catalogueNonMedicalEntity = injector.getInstance(Key.get(CatalogueNonMedicalEntity.class, Names.named("catalogueNonMedicalEntityWithNoRef")));

		// % protected region % [Apply any additional logic for catalogueNonMedicalEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalEntityWithRefs after the main body here] end

		log.trace("Created entity of type CatalogueNonMedicalEntity with references");

		return catalogueNonMedicalEntity;
	}

	/**
	 * Return a collection of Catalogue Non Medical entities with all references set.
	 */
	@Provides
	@Named("catalogueNonMedicalEntitiesWithRefs")
	public Collection<CatalogueNonMedicalEntity> catalogueNonMedicalEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for catalogueNonMedicalEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for catalogueNonMedicalEntitiesWithRefs here] end
		CatalogueNonMedicalEntityFactory catalogueNonMedicalEntityFactory
	) {
		log.trace("Creating entities of type CatalogueNonMedicalEntity with references");

		// % protected region % [Apply any additional logic for catalogueNonMedicalEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalEntitiesWithRefs before the main body here] end

		Collection<CatalogueNonMedicalEntity> newEntities = catalogueNonMedicalEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for catalogueNonMedicalEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for catalogueNonMedicalEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type CatalogueNonMedicalEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
