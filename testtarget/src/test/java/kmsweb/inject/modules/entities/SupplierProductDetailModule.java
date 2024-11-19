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
 * Guice module for Supplier Product Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class SupplierProductDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring SupplierProductDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured SupplierProductDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public SupplierProductDetailEntityFactory supplierProductDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for supplierProductDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for supplierProductDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating SupplierProductDetailEntityFactory");

		// % protected region % [Apply any additional logic for supplierProductDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailEntityFactory before the main body here] end

		SupplierProductDetailEntityFactory entityFactory = new SupplierProductDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for SupplierProductDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for SupplierProductDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for supplierProductDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailEntityFactory after the main body here] end

		log.trace("Created SupplierProductDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Supplier Product Detail entity with no references set.
	 */
	@Provides
	@Named("supplierProductDetailEntityWithNoRef")
	public SupplierProductDetailEntity supplierProductDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for supplierProductDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for supplierProductDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type SupplierProductDetailEntity with no reference");

		// % protected region % [Apply any additional logic for supplierProductDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailWithNoRef before the main body here] end

		SupplierProductDetailEntity newEntity = new SupplierProductDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Unit Code here] off begin
		String randomStringforUnitCode = mock
				.strings()
				.get();
		newEntity.setUnitCode(randomStringforUnitCode);
		// % protected region % [Add customisation for Unit Code here] end
		// % protected region % [Add customisation for Unit Name here] off begin
		String randomStringforUnitName = mock
				.strings()
				.get();
		newEntity.setUnitName(randomStringforUnitName);
		// % protected region % [Add customisation for Unit Name here] end
		// % protected region % [Add customisation for Price here] off begin
		newEntity.setPrice(mock.doubles().get());
		// % protected region % [Add customisation for Price here] end
		// % protected region % [Add customisation for Discount here] off begin
		newEntity.setDiscount(mock.doubles().get());
		// % protected region % [Add customisation for Discount here] end

		// % protected region % [Apply any additional logic for supplierProductDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailWithNoRef after the main body here] end

		log.trace("Created entity of type SupplierProductDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Supplier Product Detail entities with no reference at all.
	 */
	@Provides
	@Named("supplierProductDetailEntitiesWithNoRef")
	public Collection<SupplierProductDetailEntity> supplierProductDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for supplierProductDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for supplierProductDetailEntitiesWithNoRef here] end
		SupplierProductDetailEntityFactory supplierProductDetailEntityFactory
	) {
		log.trace("Creating entities of type SupplierProductDetailEntity with no reference");

		// % protected region % [Apply any additional logic for supplierProductDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailEntitiesWithNoRef before the main body here] end

		Collection<SupplierProductDetailEntity> newEntities = supplierProductDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for supplierProductDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type SupplierProductDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Supplier Product Detail entity with all references set.
	 */
	@Provides
	@Named("supplierProductDetailEntityWithRefs")
	public SupplierProductDetailEntity supplierProductDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for supplierProductDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for supplierProductDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type SupplierProductDetailEntity with references");

		// % protected region % [Apply any additional logic for supplierProductDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailEntityWithRefs before the main body here] end

		SupplierProductDetailEntity supplierProductDetailEntity = injector.getInstance(Key.get(SupplierProductDetailEntity.class, Names.named("supplierProductDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for supplierProductDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type SupplierProductDetailEntity with references");

		return supplierProductDetailEntity;
	}

	/**
	 * Return a collection of Supplier Product Detail entities with all references set.
	 */
	@Provides
	@Named("supplierProductDetailEntitiesWithRefs")
	public Collection<SupplierProductDetailEntity> supplierProductDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for supplierProductDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for supplierProductDetailEntitiesWithRefs here] end
		SupplierProductDetailEntityFactory supplierProductDetailEntityFactory
	) {
		log.trace("Creating entities of type SupplierProductDetailEntity with references");

		// % protected region % [Apply any additional logic for supplierProductDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailEntitiesWithRefs before the main body here] end

		Collection<SupplierProductDetailEntity> newEntities = supplierProductDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for supplierProductDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierProductDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type SupplierProductDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
