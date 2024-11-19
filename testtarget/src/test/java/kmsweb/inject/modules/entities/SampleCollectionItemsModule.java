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
 * Guice module for Sample Collection Items used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class SampleCollectionItemsModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring SampleCollectionItemsModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured SampleCollectionItemsModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public SampleCollectionItemsEntityFactory sampleCollectionItemsEntityFactory(
			// % protected region % [Apply any additional injected arguments for sampleCollectionItemsEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for sampleCollectionItemsEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating SampleCollectionItemsEntityFactory");

		// % protected region % [Apply any additional logic for sampleCollectionItemsEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsEntityFactory before the main body here] end

		SampleCollectionItemsEntityFactory entityFactory = new SampleCollectionItemsEntityFactory(
				// % protected region % [Apply any additional constructor arguments for SampleCollectionItemsEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for SampleCollectionItemsEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for sampleCollectionItemsEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsEntityFactory after the main body here] end

		log.trace("Created SampleCollectionItemsEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Sample Collection Items entity with no references set.
	 */
	@Provides
	@Named("sampleCollectionItemsEntityWithNoRef")
	public SampleCollectionItemsEntity sampleCollectionItemsEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for sampleCollectionItemsEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for sampleCollectionItemsEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type SampleCollectionItemsEntity with no reference");

		// % protected region % [Apply any additional logic for sampleCollectionItemsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsWithNoRef before the main body here] end

		SampleCollectionItemsEntity newEntity = new SampleCollectionItemsEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Sample Type here] off begin
		String randomStringforSampleType = mock
				.strings()
				.get();
		newEntity.setSampleType(randomStringforSampleType);
		// % protected region % [Add customisation for Sample Type here] end
		// % protected region % [Add customisation for Sample Number here] off begin
		String randomStringforSampleNumber = mock
				.strings()
				.get();
		newEntity.setSampleNumber(randomStringforSampleNumber);
		// % protected region % [Add customisation for Sample Number here] end
		// % protected region % [Add customisation for Sample Taking Location here] off begin
		String randomStringforSampleTakingLocation = mock
				.strings()
				.get();
		newEntity.setSampleTakingLocation(randomStringforSampleTakingLocation);
		// % protected region % [Add customisation for Sample Taking Location here] end
		// % protected region % [Add customisation for Volume here] off begin
		String randomStringforVolume = mock
				.strings()
				.get();
		newEntity.setVolume(randomStringforVolume);
		// % protected region % [Add customisation for Volume here] end
		// % protected region % [Add customisation for Container here] off begin
		String randomStringforContainer = mock
				.strings()
				.get();
		newEntity.setContainer(randomStringforContainer);
		// % protected region % [Add customisation for Container here] end
		// % protected region % [Add customisation for Transport here] off begin
		String randomStringforTransport = mock
				.strings()
				.get();
		newEntity.setTransport(randomStringforTransport);
		// % protected region % [Add customisation for Transport here] end
		// % protected region % [Add customisation for Sample Collection Date Time here] off begin
		newEntity.setSampleCollectionDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Sample Collection Date Time here] end
		// % protected region % [Add customisation for Sample Processing Date Time here] off begin
		newEntity.setSampleProcessingDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Sample Processing Date Time here] end
		// % protected region % [Add customisation for Sample Delivery Date Time here] off begin
		newEntity.setSampleDeliveryDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Sample Delivery Date Time here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for sampleCollectionItemsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsWithNoRef after the main body here] end

		log.trace("Created entity of type SampleCollectionItemsEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Sample Collection Items entities with no reference at all.
	 */
	@Provides
	@Named("sampleCollectionItemsEntitiesWithNoRef")
	public Collection<SampleCollectionItemsEntity> sampleCollectionItemsEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for sampleCollectionItemsEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for sampleCollectionItemsEntitiesWithNoRef here] end
		SampleCollectionItemsEntityFactory sampleCollectionItemsEntityFactory
	) {
		log.trace("Creating entities of type SampleCollectionItemsEntity with no reference");

		// % protected region % [Apply any additional logic for sampleCollectionItemsEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsEntitiesWithNoRef before the main body here] end

		Collection<SampleCollectionItemsEntity> newEntities = sampleCollectionItemsEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for sampleCollectionItemsEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type SampleCollectionItemsEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Sample Collection Items entity with all references set.
	 */
	@Provides
	@Named("sampleCollectionItemsEntityWithRefs")
	public SampleCollectionItemsEntity sampleCollectionItemsEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for sampleCollectionItemsEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for sampleCollectionItemsEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type SampleCollectionItemsEntity with references");

		// % protected region % [Apply any additional logic for sampleCollectionItemsEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsEntityWithRefs before the main body here] end

		SampleCollectionItemsEntity sampleCollectionItemsEntity = injector.getInstance(Key.get(SampleCollectionItemsEntity.class, Names.named("sampleCollectionItemsEntityWithNoRef")));

		// % protected region % [Apply any additional logic for sampleCollectionItemsEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsEntityWithRefs after the main body here] end

		log.trace("Created entity of type SampleCollectionItemsEntity with references");

		return sampleCollectionItemsEntity;
	}

	/**
	 * Return a collection of Sample Collection Items entities with all references set.
	 */
	@Provides
	@Named("sampleCollectionItemsEntitiesWithRefs")
	public Collection<SampleCollectionItemsEntity> sampleCollectionItemsEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for sampleCollectionItemsEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for sampleCollectionItemsEntitiesWithRefs here] end
		SampleCollectionItemsEntityFactory sampleCollectionItemsEntityFactory
	) {
		log.trace("Creating entities of type SampleCollectionItemsEntity with references");

		// % protected region % [Apply any additional logic for sampleCollectionItemsEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsEntitiesWithRefs before the main body here] end

		Collection<SampleCollectionItemsEntity> newEntities = sampleCollectionItemsEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for sampleCollectionItemsEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type SampleCollectionItemsEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
