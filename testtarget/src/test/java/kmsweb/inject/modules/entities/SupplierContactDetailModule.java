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
 * Guice module for Supplier Contact Detail used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class SupplierContactDetailModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring SupplierContactDetailModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured SupplierContactDetailModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public SupplierContactDetailEntityFactory supplierContactDetailEntityFactory(
			// % protected region % [Apply any additional injected arguments for supplierContactDetailEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for supplierContactDetailEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating SupplierContactDetailEntityFactory");

		// % protected region % [Apply any additional logic for supplierContactDetailEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailEntityFactory before the main body here] end

		SupplierContactDetailEntityFactory entityFactory = new SupplierContactDetailEntityFactory(
				// % protected region % [Apply any additional constructor arguments for SupplierContactDetailEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for SupplierContactDetailEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for supplierContactDetailEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailEntityFactory after the main body here] end

		log.trace("Created SupplierContactDetailEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Supplier Contact Detail entity with no references set.
	 */
	@Provides
	@Named("supplierContactDetailEntityWithNoRef")
	public SupplierContactDetailEntity supplierContactDetailEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for supplierContactDetailEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for supplierContactDetailEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type SupplierContactDetailEntity with no reference");

		// % protected region % [Apply any additional logic for supplierContactDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailWithNoRef before the main body here] end

		SupplierContactDetailEntity newEntity = new SupplierContactDetailEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Name here] off begin
		String randomStringforName = mock
				.strings()
				.get();
		newEntity.setName(randomStringforName);
		// % protected region % [Add customisation for Name here] end
		// % protected region % [Add customisation for Position here] off begin
		String randomStringforPosition = mock
				.strings()
				.get();
		newEntity.setPosition(randomStringforPosition);
		// % protected region % [Add customisation for Position here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringforPhoneNumber = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setPhoneNumber(randomStringforPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Mobile Phone Number here] off begin
		String randomStringforMobilePhoneNumber = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setMobilePhoneNumber(randomStringforMobilePhoneNumber);
		// % protected region % [Add customisation for Mobile Phone Number here] end
		// % protected region % [Add customisation for Ext here] off begin
		String randomStringforExt = mock
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setExt(randomStringforExt);
		// % protected region % [Add customisation for Ext here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.emails()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end

		// % protected region % [Apply any additional logic for supplierContactDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailWithNoRef after the main body here] end

		log.trace("Created entity of type SupplierContactDetailEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Supplier Contact Detail entities with no reference at all.
	 */
	@Provides
	@Named("supplierContactDetailEntitiesWithNoRef")
	public Collection<SupplierContactDetailEntity> supplierContactDetailEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for supplierContactDetailEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for supplierContactDetailEntitiesWithNoRef here] end
		SupplierContactDetailEntityFactory supplierContactDetailEntityFactory
	) {
		log.trace("Creating entities of type SupplierContactDetailEntity with no reference");

		// % protected region % [Apply any additional logic for supplierContactDetailEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailEntitiesWithNoRef before the main body here] end

		Collection<SupplierContactDetailEntity> newEntities = supplierContactDetailEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for supplierContactDetailEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type SupplierContactDetailEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Supplier Contact Detail entity with all references set.
	 */
	@Provides
	@Named("supplierContactDetailEntityWithRefs")
	public SupplierContactDetailEntity supplierContactDetailEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for supplierContactDetailEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for supplierContactDetailEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type SupplierContactDetailEntity with references");

		// % protected region % [Apply any additional logic for supplierContactDetailEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailEntityWithRefs before the main body here] end

		SupplierContactDetailEntity supplierContactDetailEntity = injector.getInstance(Key.get(SupplierContactDetailEntity.class, Names.named("supplierContactDetailEntityWithNoRef")));

		// % protected region % [Apply any additional logic for supplierContactDetailEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailEntityWithRefs after the main body here] end

		log.trace("Created entity of type SupplierContactDetailEntity with references");

		return supplierContactDetailEntity;
	}

	/**
	 * Return a collection of Supplier Contact Detail entities with all references set.
	 */
	@Provides
	@Named("supplierContactDetailEntitiesWithRefs")
	public Collection<SupplierContactDetailEntity> supplierContactDetailEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for supplierContactDetailEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for supplierContactDetailEntitiesWithRefs here] end
		SupplierContactDetailEntityFactory supplierContactDetailEntityFactory
	) {
		log.trace("Creating entities of type SupplierContactDetailEntity with references");

		// % protected region % [Apply any additional logic for supplierContactDetailEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailEntitiesWithRefs before the main body here] end

		Collection<SupplierContactDetailEntity> newEntities = supplierContactDetailEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for supplierContactDetailEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for supplierContactDetailEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type SupplierContactDetailEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
