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
 * Guice module for BPJS Update Dismissal Date used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsUpdateDismissalDateModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsUpdateDismissalDateModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsUpdateDismissalDateModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsUpdateDismissalDateEntityFactory bpjsUpdateDismissalDateEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsUpdateDismissalDateEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsUpdateDismissalDateEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsUpdateDismissalDateEntityFactory");

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntityFactory before the main body here] end

		BpjsUpdateDismissalDateEntityFactory entityFactory = new BpjsUpdateDismissalDateEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsUpdateDismissalDateEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsUpdateDismissalDateEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntityFactory after the main body here] end

		log.trace("Created BpjsUpdateDismissalDateEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS Update Dismissal Date entity with no references set.
	 */
	@Provides
	@Named("bpjsUpdateDismissalDateEntityWithNoRef")
	public BpjsUpdateDismissalDateEntity bpjsUpdateDismissalDateEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsUpdateDismissalDateEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsUpdateDismissalDateEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsUpdateDismissalDateEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateWithNoRef before the main body here] end

		BpjsUpdateDismissalDateEntity newEntity = new BpjsUpdateDismissalDateEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Dismissal Type here] off begin
		String randomStringforDismissalType = mock
				.strings()
				.get();
		newEntity.setDismissalType(randomStringforDismissalType);
		// % protected region % [Add customisation for Dismissal Type here] end
		// % protected region % [Add customisation for Death Certificate Letter No here] off begin
		String randomStringforDeathCertificateLetterNo = mock
				.strings()
				.get();
		newEntity.setDeathCertificateLetterNo(randomStringforDeathCertificateLetterNo);
		// % protected region % [Add customisation for Death Certificate Letter No here] end
		// % protected region % [Add customisation for Time Of Death here] off begin
		newEntity.setTimeOfDeath(OffsetDateTime.now());
		// % protected region % [Add customisation for Time Of Death here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for Police Report No here] off begin
		String randomStringforPoliceReportNo = mock
				.strings()
				.get();
		newEntity.setPoliceReportNo(randomStringforPoliceReportNo);
		// % protected region % [Add customisation for Police Report No here] end

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsUpdateDismissalDateEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS Update Dismissal Date entities with no reference at all.
	 */
	@Provides
	@Named("bpjsUpdateDismissalDateEntitiesWithNoRef")
	public Collection<BpjsUpdateDismissalDateEntity> bpjsUpdateDismissalDateEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsUpdateDismissalDateEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsUpdateDismissalDateEntitiesWithNoRef here] end
		BpjsUpdateDismissalDateEntityFactory bpjsUpdateDismissalDateEntityFactory
	) {
		log.trace("Creating entities of type BpjsUpdateDismissalDateEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntitiesWithNoRef before the main body here] end

		Collection<BpjsUpdateDismissalDateEntity> newEntities = bpjsUpdateDismissalDateEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsUpdateDismissalDateEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS Update Dismissal Date entity with all references set.
	 */
	@Provides
	@Named("bpjsUpdateDismissalDateEntityWithRefs")
	public BpjsUpdateDismissalDateEntity bpjsUpdateDismissalDateEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsUpdateDismissalDateEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsUpdateDismissalDateEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsUpdateDismissalDateEntity with references");

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntityWithRefs before the main body here] end

		BpjsUpdateDismissalDateEntity bpjsUpdateDismissalDateEntity = injector.getInstance(Key.get(BpjsUpdateDismissalDateEntity.class, Names.named("bpjsUpdateDismissalDateEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsUpdateDismissalDateEntity with references");

		return bpjsUpdateDismissalDateEntity;
	}

	/**
	 * Return a collection of BPJS Update Dismissal Date entities with all references set.
	 */
	@Provides
	@Named("bpjsUpdateDismissalDateEntitiesWithRefs")
	public Collection<BpjsUpdateDismissalDateEntity> bpjsUpdateDismissalDateEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsUpdateDismissalDateEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsUpdateDismissalDateEntitiesWithRefs here] end
		BpjsUpdateDismissalDateEntityFactory bpjsUpdateDismissalDateEntityFactory
	) {
		log.trace("Creating entities of type BpjsUpdateDismissalDateEntity with references");

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntitiesWithRefs before the main body here] end

		Collection<BpjsUpdateDismissalDateEntity> newEntities = bpjsUpdateDismissalDateEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsUpdateDismissalDateEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsUpdateDismissalDateEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}