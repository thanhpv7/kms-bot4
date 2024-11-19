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
 * Guice module for PCare Tindakan used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareTindakanModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareTindakanModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareTindakanModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareTindakanEntityFactory pcareTindakanEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareTindakanEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareTindakanEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareTindakanEntityFactory");

		// % protected region % [Apply any additional logic for pcareTindakanEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanEntityFactory before the main body here] end

		PcareTindakanEntityFactory entityFactory = new PcareTindakanEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareTindakanEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareTindakanEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareTindakanEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanEntityFactory after the main body here] end

		log.trace("Created PcareTindakanEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Tindakan entity with no references set.
	 */
	@Provides
	@Named("pcareTindakanEntityWithNoRef")
	public PcareTindakanEntity pcareTindakanEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareTindakanEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareTindakanEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareTindakanEntity with no reference");

		// % protected region % [Apply any additional logic for pcareTindakanWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanWithNoRef before the main body here] end

		PcareTindakanEntity newEntity = new PcareTindakanEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Kode Tindakan here] off begin
		String randomStringforKodeTindakan = mock
				.strings()
				.get();
		newEntity.setKodeTindakan(randomStringforKodeTindakan);
		// % protected region % [Add customisation for Kode Tindakan here] end
		// % protected region % [Add customisation for Nama Tindakan here] off begin
		String randomStringforNamaTindakan = mock
				.strings()
				.get();
		newEntity.setNamaTindakan(randomStringforNamaTindakan);
		// % protected region % [Add customisation for Nama Tindakan here] end
		// % protected region % [Add customisation for Maksimal Tarif here] off begin
		String randomStringforMaksimalTarif = mock
				.strings()
				.get();
		newEntity.setMaksimalTarif(randomStringforMaksimalTarif);
		// % protected region % [Add customisation for Maksimal Tarif here] end
		// % protected region % [Add customisation for withValue here] off begin
		newEntity.setWithvalue(mock.bools().get());
		// % protected region % [Add customisation for withValue here] end
		// % protected region % [Add customisation for Tindakan Internal here] off begin
		String randomStringforTindakanInternal = mock
				.strings()
				.get();
		newEntity.setTindakanInternal(randomStringforTindakanInternal);
		// % protected region % [Add customisation for Tindakan Internal here] end

		// % protected region % [Apply any additional logic for pcareTindakanWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanWithNoRef after the main body here] end

		log.trace("Created entity of type PcareTindakanEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Tindakan entities with no reference at all.
	 */
	@Provides
	@Named("pcareTindakanEntitiesWithNoRef")
	public Collection<PcareTindakanEntity> pcareTindakanEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareTindakanEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareTindakanEntitiesWithNoRef here] end
		PcareTindakanEntityFactory pcareTindakanEntityFactory
	) {
		log.trace("Creating entities of type PcareTindakanEntity with no reference");

		// % protected region % [Apply any additional logic for pcareTindakanEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanEntitiesWithNoRef before the main body here] end

		Collection<PcareTindakanEntity> newEntities = pcareTindakanEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareTindakanEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareTindakanEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Tindakan entity with all references set.
	 */
	@Provides
	@Named("pcareTindakanEntityWithRefs")
	public PcareTindakanEntity pcareTindakanEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareTindakanEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareTindakanEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareTindakanEntity with references");

		// % protected region % [Apply any additional logic for pcareTindakanEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanEntityWithRefs before the main body here] end

		PcareTindakanEntity pcareTindakanEntity = injector.getInstance(Key.get(PcareTindakanEntity.class, Names.named("pcareTindakanEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareTindakanEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareTindakanEntity with references");

		return pcareTindakanEntity;
	}

	/**
	 * Return a collection of PCare Tindakan entities with all references set.
	 */
	@Provides
	@Named("pcareTindakanEntitiesWithRefs")
	public Collection<PcareTindakanEntity> pcareTindakanEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareTindakanEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareTindakanEntitiesWithRefs here] end
		PcareTindakanEntityFactory pcareTindakanEntityFactory
	) {
		log.trace("Creating entities of type PcareTindakanEntity with references");

		// % protected region % [Apply any additional logic for pcareTindakanEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanEntitiesWithRefs before the main body here] end

		Collection<PcareTindakanEntity> newEntities = pcareTindakanEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareTindakanEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareTindakanEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareTindakanEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
