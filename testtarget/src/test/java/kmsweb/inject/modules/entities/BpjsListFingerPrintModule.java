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
 * Guice module for BPJS List Finger Print used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsListFingerPrintModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsListFingerPrintModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsListFingerPrintModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsListFingerPrintEntityFactory bpjsListFingerPrintEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsListFingerPrintEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsListFingerPrintEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsListFingerPrintEntityFactory");

		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntityFactory before the main body here] end

		BpjsListFingerPrintEntityFactory entityFactory = new BpjsListFingerPrintEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsListFingerPrintEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsListFingerPrintEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntityFactory after the main body here] end

		log.trace("Created BpjsListFingerPrintEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS List Finger Print entity with no references set.
	 */
	@Provides
	@Named("bpjsListFingerPrintEntityWithNoRef")
	public BpjsListFingerPrintEntity bpjsListFingerPrintEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsListFingerPrintEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsListFingerPrintEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsListFingerPrintEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsListFingerPrintWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintWithNoRef before the main body here] end

		BpjsListFingerPrintEntity newEntity = new BpjsListFingerPrintEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Bpjs Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for Bpjs Card No here] end
		// % protected region % [Add customisation for Visit Date here] off begin
		newEntity.setVisitDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Visit Date here] end
		// % protected region % [Add customisation for Sep No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for Sep No here] end

		// % protected region % [Apply any additional logic for bpjsListFingerPrintWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsListFingerPrintEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS List Finger Print entities with no reference at all.
	 */
	@Provides
	@Named("bpjsListFingerPrintEntitiesWithNoRef")
	public Collection<BpjsListFingerPrintEntity> bpjsListFingerPrintEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsListFingerPrintEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsListFingerPrintEntitiesWithNoRef here] end
		BpjsListFingerPrintEntityFactory bpjsListFingerPrintEntityFactory
	) {
		log.trace("Creating entities of type BpjsListFingerPrintEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntitiesWithNoRef before the main body here] end

		Collection<BpjsListFingerPrintEntity> newEntities = bpjsListFingerPrintEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsListFingerPrintEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS List Finger Print entity with all references set.
	 */
	@Provides
	@Named("bpjsListFingerPrintEntityWithRefs")
	public BpjsListFingerPrintEntity bpjsListFingerPrintEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsListFingerPrintEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsListFingerPrintEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsListFingerPrintEntity with references");

		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntityWithRefs before the main body here] end

		BpjsListFingerPrintEntity bpjsListFingerPrintEntity = injector.getInstance(Key.get(BpjsListFingerPrintEntity.class, Names.named("bpjsListFingerPrintEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsListFingerPrintEntity with references");

		return bpjsListFingerPrintEntity;
	}

	/**
	 * Return a collection of BPJS List Finger Print entities with all references set.
	 */
	@Provides
	@Named("bpjsListFingerPrintEntitiesWithRefs")
	public Collection<BpjsListFingerPrintEntity> bpjsListFingerPrintEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsListFingerPrintEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsListFingerPrintEntitiesWithRefs here] end
		BpjsListFingerPrintEntityFactory bpjsListFingerPrintEntityFactory
	) {
		log.trace("Creating entities of type BpjsListFingerPrintEntity with references");

		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntitiesWithRefs before the main body here] end

		Collection<BpjsListFingerPrintEntity> newEntities = bpjsListFingerPrintEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsListFingerPrintEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsListFingerPrintEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
