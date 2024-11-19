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
 * Guice module for BPJS Finger Print used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsFingerPrintModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsFingerPrintModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsFingerPrintModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsFingerPrintEntityFactory bpjsFingerPrintEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsFingerPrintEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsFingerPrintEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsFingerPrintEntityFactory");

		// % protected region % [Apply any additional logic for bpjsFingerPrintEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintEntityFactory before the main body here] end

		BpjsFingerPrintEntityFactory entityFactory = new BpjsFingerPrintEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsFingerPrintEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsFingerPrintEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsFingerPrintEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintEntityFactory after the main body here] end

		log.trace("Created BpjsFingerPrintEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Finger Print entity with no references set.
	 */
	@Provides
	@Named("bpjsFingerPrintEntityWithNoRef")
	public BpjsFingerPrintEntity bpjsFingerPrintEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsFingerPrintEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsFingerPrintEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsFingerPrintEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsFingerPrintWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintWithNoRef before the main body here] end

		BpjsFingerPrintEntity newEntity = new BpjsFingerPrintEntity();
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
		// % protected region % [Add customisation for Code here] off begin
		String randomStringforCode = mock
				.strings()
				.get();
		newEntity.setCode(randomStringforCode);
		// % protected region % [Add customisation for Code here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for Status here] end

		// % protected region % [Apply any additional logic for bpjsFingerPrintWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsFingerPrintEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Finger Print entities with no reference at all.
	 */
	@Provides
	@Named("bpjsFingerPrintEntitiesWithNoRef")
	public Collection<BpjsFingerPrintEntity> bpjsFingerPrintEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsFingerPrintEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsFingerPrintEntitiesWithNoRef here] end
		BpjsFingerPrintEntityFactory bpjsFingerPrintEntityFactory
	) {
		log.trace("Creating entities of type BpjsFingerPrintEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsFingerPrintEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintEntitiesWithNoRef before the main body here] end

		Collection<BpjsFingerPrintEntity> newEntities = bpjsFingerPrintEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsFingerPrintEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsFingerPrintEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Finger Print entity with all references set.
	 */
	@Provides
	@Named("bpjsFingerPrintEntityWithRefs")
	public BpjsFingerPrintEntity bpjsFingerPrintEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsFingerPrintEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsFingerPrintEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsFingerPrintEntity with references");

		// % protected region % [Apply any additional logic for bpjsFingerPrintEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintEntityWithRefs before the main body here] end

		BpjsFingerPrintEntity bpjsFingerPrintEntity = injector.getInstance(Key.get(BpjsFingerPrintEntity.class, Names.named("bpjsFingerPrintEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsFingerPrintEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsFingerPrintEntity with references");

		return bpjsFingerPrintEntity;
	}

	/**
	 * Return a collection of BPJS Finger Print entities with all references set.
	 */
	@Provides
	@Named("bpjsFingerPrintEntitiesWithRefs")
	public Collection<BpjsFingerPrintEntity> bpjsFingerPrintEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsFingerPrintEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsFingerPrintEntitiesWithRefs here] end
		BpjsFingerPrintEntityFactory bpjsFingerPrintEntityFactory
	) {
		log.trace("Creating entities of type BpjsFingerPrintEntity with references");

		// % protected region % [Apply any additional logic for bpjsFingerPrintEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintEntitiesWithRefs before the main body here] end

		Collection<BpjsFingerPrintEntity> newEntities = bpjsFingerPrintEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsFingerPrintEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsFingerPrintEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsFingerPrintEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
