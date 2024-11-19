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
 * Guice module for BPJS SEP Submission used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsSEPSubmissionModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsSEPSubmissionModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsSEPSubmissionModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsSEPSubmissionEntityFactory bpjsSEPSubmissionEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsSEPSubmissionEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsSEPSubmissionEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsSEPSubmissionEntityFactory");

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntityFactory before the main body here] end

		BpjsSEPSubmissionEntityFactory entityFactory = new BpjsSEPSubmissionEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsSEPSubmissionEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsSEPSubmissionEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntityFactory after the main body here] end

		log.trace("Created BpjsSEPSubmissionEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS SEP Submission entity with no references set.
	 */
	@Provides
	@Named("bpjsSEPSubmissionEntityWithNoRef")
	public BpjsSEPSubmissionEntity bpjsSEPSubmissionEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsSEPSubmissionEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSEPSubmissionEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsSEPSubmissionEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionWithNoRef before the main body here] end

		BpjsSEPSubmissionEntity newEntity = new BpjsSEPSubmissionEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for Submission Type here] off begin
		String randomStringforSubmissionType = mock
				.strings()
				.get();
		newEntity.setSubmissionType(randomStringforSubmissionType);
		// % protected region % [Add customisation for Submission Type here] end
		// % protected region % [Add customisation for SEP Date here] off begin
		String randomStringforSepDate = mock
				.strings()
				.get();
		newEntity.setSepDate(randomStringforSepDate);
		// % protected region % [Add customisation for SEP Date here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringforTreatmentType = mock
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringforTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsSEPSubmissionEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS SEP Submission entities with no reference at all.
	 */
	@Provides
	@Named("bpjsSEPSubmissionEntitiesWithNoRef")
	public Collection<BpjsSEPSubmissionEntity> bpjsSEPSubmissionEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsSEPSubmissionEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSEPSubmissionEntitiesWithNoRef here] end
		BpjsSEPSubmissionEntityFactory bpjsSEPSubmissionEntityFactory
	) {
		log.trace("Creating entities of type BpjsSEPSubmissionEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntitiesWithNoRef before the main body here] end

		Collection<BpjsSEPSubmissionEntity> newEntities = bpjsSEPSubmissionEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsSEPSubmissionEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS SEP Submission entity with all references set.
	 */
	@Provides
	@Named("bpjsSEPSubmissionEntityWithRefs")
	public BpjsSEPSubmissionEntity bpjsSEPSubmissionEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsSEPSubmissionEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsSEPSubmissionEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsSEPSubmissionEntity with references");

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntityWithRefs before the main body here] end

		BpjsSEPSubmissionEntity bpjsSEPSubmissionEntity = injector.getInstance(Key.get(BpjsSEPSubmissionEntity.class, Names.named("bpjsSEPSubmissionEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsSEPSubmissionEntity with references");

		return bpjsSEPSubmissionEntity;
	}

	/**
	 * Return a collection of BPJS SEP Submission entities with all references set.
	 */
	@Provides
	@Named("bpjsSEPSubmissionEntitiesWithRefs")
	public Collection<BpjsSEPSubmissionEntity> bpjsSEPSubmissionEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsSEPSubmissionEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsSEPSubmissionEntitiesWithRefs here] end
		BpjsSEPSubmissionEntityFactory bpjsSEPSubmissionEntityFactory
	) {
		log.trace("Creating entities of type BpjsSEPSubmissionEntity with references");

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntitiesWithRefs before the main body here] end

		Collection<BpjsSEPSubmissionEntity> newEntities = bpjsSEPSubmissionEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsSEPSubmissionEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsSEPSubmissionEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
