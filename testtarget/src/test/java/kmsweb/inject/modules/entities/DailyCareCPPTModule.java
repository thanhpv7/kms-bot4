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
 * Guice module for Daily Care CPPT used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DailyCareCPPTModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DailyCareCPPTModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DailyCareCPPTModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DailyCareCPPTEntityFactory dailyCareCPPTEntityFactory(
			// % protected region % [Apply any additional injected arguments for dailyCareCPPTEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for dailyCareCPPTEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DailyCareCPPTEntityFactory");

		// % protected region % [Apply any additional logic for dailyCareCPPTEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTEntityFactory before the main body here] end

		DailyCareCPPTEntityFactory entityFactory = new DailyCareCPPTEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DailyCareCPPTEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DailyCareCPPTEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for dailyCareCPPTEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTEntityFactory after the main body here] end

		log.trace("Created DailyCareCPPTEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Daily Care CPPT entity with no references set.
	 */
	@Provides
	@Named("dailyCareCPPTEntityWithNoRef")
	public DailyCareCPPTEntity dailyCareCPPTEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for dailyCareCPPTEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for dailyCareCPPTEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DailyCareCPPTEntity with no reference");

		// % protected region % [Apply any additional logic for dailyCareCPPTWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTWithNoRef before the main body here] end

		DailyCareCPPTEntity newEntity = new DailyCareCPPTEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Subjective here] off begin
		String randomStringforSubjective = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setSubjective(randomStringforSubjective);
		// % protected region % [Add customisation for Subjective here] end
		// % protected region % [Add customisation for Objective here] off begin
		String randomStringforObjective = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setObjective(randomStringforObjective);
		// % protected region % [Add customisation for Objective here] end
		// % protected region % [Add customisation for Diagnose here] off begin
		String randomStringforDiagnose = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setDiagnose(randomStringforDiagnose);
		// % protected region % [Add customisation for Diagnose here] end
		// % protected region % [Add customisation for Plan here] off begin
		String randomStringforPlan = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setPlan(randomStringforPlan);
		// % protected region % [Add customisation for Plan here] end
		// % protected region % [Add customisation for Instruction here] off begin
		String randomStringforInstruction = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setInstruction(randomStringforInstruction);
		// % protected region % [Add customisation for Instruction here] end
		// % protected region % [Add customisation for Verified Date here] off begin
		newEntity.setVerifiedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Verified Date here] end
		// % protected region % [Add customisation for Verified By here] off begin
		String randomStringforVerifiedBy = mock
				.strings()
				.get();
		newEntity.setVerifiedBy(randomStringforVerifiedBy);
		// % protected region % [Add customisation for Verified By here] end
		// % protected region % [Add customisation for Canceled Date here] off begin
		newEntity.setCanceledDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Canceled Date here] end
		// % protected region % [Add customisation for Canceled By here] off begin
		String randomStringforCanceledBy = mock
				.strings()
				.get();
		newEntity.setCanceledBy(randomStringforCanceledBy);
		// % protected region % [Add customisation for Canceled By here] end
		// % protected region % [Add customisation for Status here] off begin
		String randomStringforStatus = mock
				.strings()
				.get();
		newEntity.setStatus(randomStringforStatus);
		// % protected region % [Add customisation for Status here] end
		// % protected region % [Add customisation for CPPT Date Time here] off begin
		newEntity.setCpptDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for CPPT Date Time here] end

		// % protected region % [Apply any additional logic for dailyCareCPPTWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTWithNoRef after the main body here] end

		log.trace("Created entity of type DailyCareCPPTEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Daily Care CPPT entities with no reference at all.
	 */
	@Provides
	@Named("dailyCareCPPTEntitiesWithNoRef")
	public Collection<DailyCareCPPTEntity> dailyCareCPPTEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for dailyCareCPPTEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for dailyCareCPPTEntitiesWithNoRef here] end
		DailyCareCPPTEntityFactory dailyCareCPPTEntityFactory
	) {
		log.trace("Creating entities of type DailyCareCPPTEntity with no reference");

		// % protected region % [Apply any additional logic for dailyCareCPPTEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTEntitiesWithNoRef before the main body here] end

		Collection<DailyCareCPPTEntity> newEntities = dailyCareCPPTEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for dailyCareCPPTEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DailyCareCPPTEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Daily Care CPPT entity with all references set.
	 */
	@Provides
	@Named("dailyCareCPPTEntityWithRefs")
	public DailyCareCPPTEntity dailyCareCPPTEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for dailyCareCPPTEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for dailyCareCPPTEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DailyCareCPPTEntity with references");

		// % protected region % [Apply any additional logic for dailyCareCPPTEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTEntityWithRefs before the main body here] end

		DailyCareCPPTEntity dailyCareCPPTEntity = injector.getInstance(Key.get(DailyCareCPPTEntity.class, Names.named("dailyCareCPPTEntityWithNoRef")));

		// % protected region % [Apply any additional logic for dailyCareCPPTEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTEntityWithRefs after the main body here] end

		log.trace("Created entity of type DailyCareCPPTEntity with references");

		return dailyCareCPPTEntity;
	}

	/**
	 * Return a collection of Daily Care CPPT entities with all references set.
	 */
	@Provides
	@Named("dailyCareCPPTEntitiesWithRefs")
	public Collection<DailyCareCPPTEntity> dailyCareCPPTEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for dailyCareCPPTEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for dailyCareCPPTEntitiesWithRefs here] end
		DailyCareCPPTEntityFactory dailyCareCPPTEntityFactory
	) {
		log.trace("Creating entities of type DailyCareCPPTEntity with references");

		// % protected region % [Apply any additional logic for dailyCareCPPTEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTEntitiesWithRefs before the main body here] end

		Collection<DailyCareCPPTEntity> newEntities = dailyCareCPPTEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for dailyCareCPPTEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for dailyCareCPPTEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DailyCareCPPTEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
