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
 * Guice module for Intraoperative Records used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class IntraoperativeRecordsModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring IntraoperativeRecordsModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured IntraoperativeRecordsModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public IntraoperativeRecordsEntityFactory intraoperativeRecordsEntityFactory(
			// % protected region % [Apply any additional injected arguments for intraoperativeRecordsEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for intraoperativeRecordsEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating IntraoperativeRecordsEntityFactory");

		// % protected region % [Apply any additional logic for intraoperativeRecordsEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsEntityFactory before the main body here] end

		IntraoperativeRecordsEntityFactory entityFactory = new IntraoperativeRecordsEntityFactory(
				// % protected region % [Apply any additional constructor arguments for IntraoperativeRecordsEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for IntraoperativeRecordsEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for intraoperativeRecordsEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsEntityFactory after the main body here] end

		log.trace("Created IntraoperativeRecordsEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Intraoperative Records entity with no references set.
	 */
	@Provides
	@Named("intraoperativeRecordsEntityWithNoRef")
	public IntraoperativeRecordsEntity intraoperativeRecordsEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for intraoperativeRecordsEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for intraoperativeRecordsEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type IntraoperativeRecordsEntity with no reference");

		// % protected region % [Apply any additional logic for intraoperativeRecordsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsWithNoRef before the main body here] end

		IntraoperativeRecordsEntity newEntity = new IntraoperativeRecordsEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] off begin
		newEntity.setStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] end
		// % protected region % [Add customisation for End Date Time here] off begin
		newEntity.setEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date Time here] end
		// % protected region % [Add customisation for Surgery Start Date Time here] off begin
		newEntity.setSurgeryStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Surgery Start Date Time here] end
		// % protected region % [Add customisation for Surgery End Date Time here] off begin
		newEntity.setSurgeryEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Surgery End Date Time here] end
		// % protected region % [Add customisation for Surgery Details here] off begin
		String randomStringforSurgeryDetails = mock
				.strings()
				.get();
		newEntity.setSurgeryDetails(randomStringforSurgeryDetails);
		// % protected region % [Add customisation for Surgery Details here] end
		// % protected region % [Add customisation for Blood Transfusion here] off begin
		String randomStringforBloodTransfusion = mock
				.strings()
				.get();
		newEntity.setBloodTransfusion(randomStringforBloodTransfusion);
		// % protected region % [Add customisation for Blood Transfusion here] end
		// % protected region % [Add customisation for Instruments Used here] off begin
		String randomStringforInstrumentsUsed = mock
				.strings()
				.get();
		newEntity.setInstrumentsUsed(randomStringforInstrumentsUsed);
		// % protected region % [Add customisation for Instruments Used here] end
		// % protected region % [Add customisation for Anesthesia Start Date Time here] off begin
		newEntity.setAnesthesiaStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Anesthesia Start Date Time here] end
		// % protected region % [Add customisation for Anesthesia Type here] off begin
		String randomStringforAnesthesiaType = mock
				.strings()
				.get();
		newEntity.setAnesthesiaType(randomStringforAnesthesiaType);
		// % protected region % [Add customisation for Anesthesia Type here] end
		// % protected region % [Add customisation for Anesthesia Method here] off begin
		String randomStringforAnesthesiaMethod = mock
				.strings()
				.get();
		newEntity.setAnesthesiaMethod(randomStringforAnesthesiaMethod);
		// % protected region % [Add customisation for Anesthesia Method here] end
		// % protected region % [Add customisation for Anesthesia Agents here] off begin
		String randomStringforAnesthesiaAgents = mock
				.strings()
				.get();
		newEntity.setAnesthesiaAgents(randomStringforAnesthesiaAgents);
		// % protected region % [Add customisation for Anesthesia Agents here] end
		// % protected region % [Add customisation for Anesthesia Observations here] off begin
		String randomStringforAnesthesiaObservations = mock
				.strings()
				.get();
		newEntity.setAnesthesiaObservations(randomStringforAnesthesiaObservations);
		// % protected region % [Add customisation for Anesthesia Observations here] end
		// % protected region % [Add customisation for Anesthesia Notes here] off begin
		String randomStringforAnesthesiaNotes = mock
				.strings()
				.get();
		newEntity.setAnesthesiaNotes(randomStringforAnesthesiaNotes);
		// % protected region % [Add customisation for Anesthesia Notes here] end
		// % protected region % [Add customisation for Anesthesia End Date Time here] off begin
		newEntity.setAnesthesiaEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Anesthesia End Date Time here] end

		// % protected region % [Apply any additional logic for intraoperativeRecordsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsWithNoRef after the main body here] end

		log.trace("Created entity of type IntraoperativeRecordsEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Intraoperative Records entities with no reference at all.
	 */
	@Provides
	@Named("intraoperativeRecordsEntitiesWithNoRef")
	public Collection<IntraoperativeRecordsEntity> intraoperativeRecordsEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for intraoperativeRecordsEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for intraoperativeRecordsEntitiesWithNoRef here] end
		IntraoperativeRecordsEntityFactory intraoperativeRecordsEntityFactory
	) {
		log.trace("Creating entities of type IntraoperativeRecordsEntity with no reference");

		// % protected region % [Apply any additional logic for intraoperativeRecordsEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsEntitiesWithNoRef before the main body here] end

		Collection<IntraoperativeRecordsEntity> newEntities = intraoperativeRecordsEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for intraoperativeRecordsEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type IntraoperativeRecordsEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Intraoperative Records entity with all references set.
	 */
	@Provides
	@Named("intraoperativeRecordsEntityWithRefs")
	public IntraoperativeRecordsEntity intraoperativeRecordsEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for intraoperativeRecordsEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for intraoperativeRecordsEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type IntraoperativeRecordsEntity with references");

		// % protected region % [Apply any additional logic for intraoperativeRecordsEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsEntityWithRefs before the main body here] end

		IntraoperativeRecordsEntity intraoperativeRecordsEntity = injector.getInstance(Key.get(IntraoperativeRecordsEntity.class, Names.named("intraoperativeRecordsEntityWithNoRef")));

		// % protected region % [Apply any additional logic for intraoperativeRecordsEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsEntityWithRefs after the main body here] end

		log.trace("Created entity of type IntraoperativeRecordsEntity with references");

		return intraoperativeRecordsEntity;
	}

	/**
	 * Return a collection of Intraoperative Records entities with all references set.
	 */
	@Provides
	@Named("intraoperativeRecordsEntitiesWithRefs")
	public Collection<IntraoperativeRecordsEntity> intraoperativeRecordsEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for intraoperativeRecordsEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for intraoperativeRecordsEntitiesWithRefs here] end
		IntraoperativeRecordsEntityFactory intraoperativeRecordsEntityFactory
	) {
		log.trace("Creating entities of type IntraoperativeRecordsEntity with references");

		// % protected region % [Apply any additional logic for intraoperativeRecordsEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsEntitiesWithRefs before the main body here] end

		Collection<IntraoperativeRecordsEntity> newEntities = intraoperativeRecordsEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for intraoperativeRecordsEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type IntraoperativeRecordsEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
