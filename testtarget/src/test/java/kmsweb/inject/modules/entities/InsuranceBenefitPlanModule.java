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
 * Guice module for Insurance Benefit Plan used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InsuranceBenefitPlanModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InsuranceBenefitPlanModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InsuranceBenefitPlanModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InsuranceBenefitPlanEntityFactory insuranceBenefitPlanEntityFactory(
			// % protected region % [Apply any additional injected arguments for insuranceBenefitPlanEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for insuranceBenefitPlanEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InsuranceBenefitPlanEntityFactory");

		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntityFactory before the main body here] end

		InsuranceBenefitPlanEntityFactory entityFactory = new InsuranceBenefitPlanEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InsuranceBenefitPlanEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InsuranceBenefitPlanEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntityFactory after the main body here] end

		log.trace("Created InsuranceBenefitPlanEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Insurance Benefit Plan entity with no references set.
	 */
	@Provides
	@Named("insuranceBenefitPlanEntityWithNoRef")
	public InsuranceBenefitPlanEntity insuranceBenefitPlanEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for insuranceBenefitPlanEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for insuranceBenefitPlanEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InsuranceBenefitPlanEntity with no reference");

		// % protected region % [Apply any additional logic for insuranceBenefitPlanWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanWithNoRef before the main body here] end

		InsuranceBenefitPlanEntity newEntity = new InsuranceBenefitPlanEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Benefit Plan No here] off begin
		String randomStringforBenefitPlanNo = mock
				.strings()
				.get();
		newEntity.setBenefitPlanNo(randomStringforBenefitPlanNo);
		// % protected region % [Add customisation for Benefit Plan No here] end
		// % protected region % [Add customisation for Benefit Plan Name here] off begin
		String randomStringforBenefitPlanName = mock
				.strings()
				.get();
		newEntity.setBenefitPlanName(randomStringforBenefitPlanName);
		// % protected region % [Add customisation for Benefit Plan Name here] end
		// % protected region % [Add customisation for Maximum Coverage per Treatment here] off begin
		newEntity.setMaximumCoveragePerTreatment(mock.doubles().get());
		// % protected region % [Add customisation for Maximum Coverage per Treatment here] end
		// % protected region % [Add customisation for Maximum Coverage per Year here] off begin
		newEntity.setMaximumCoveragePerYear(mock.doubles().get());
		// % protected region % [Add customisation for Maximum Coverage per Year here] end
		// % protected region % [Add customisation for Created Date here] off begin
		newEntity.setCreatedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Created Date here] end
		// % protected region % [Add customisation for Updated Date here] off begin
		newEntity.setUpdatedDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Updated Date here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for insuranceBenefitPlanWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanWithNoRef after the main body here] end

		log.trace("Created entity of type InsuranceBenefitPlanEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Insurance Benefit Plan entities with no reference at all.
	 */
	@Provides
	@Named("insuranceBenefitPlanEntitiesWithNoRef")
	public Collection<InsuranceBenefitPlanEntity> insuranceBenefitPlanEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for insuranceBenefitPlanEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for insuranceBenefitPlanEntitiesWithNoRef here] end
		InsuranceBenefitPlanEntityFactory insuranceBenefitPlanEntityFactory
	) {
		log.trace("Creating entities of type InsuranceBenefitPlanEntity with no reference");

		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntitiesWithNoRef before the main body here] end

		Collection<InsuranceBenefitPlanEntity> newEntities = insuranceBenefitPlanEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InsuranceBenefitPlanEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Insurance Benefit Plan entity with all references set.
	 */
	@Provides
	@Named("insuranceBenefitPlanEntityWithRefs")
	public InsuranceBenefitPlanEntity insuranceBenefitPlanEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for insuranceBenefitPlanEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for insuranceBenefitPlanEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InsuranceBenefitPlanEntity with references");

		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntityWithRefs before the main body here] end

		InsuranceBenefitPlanEntity insuranceBenefitPlanEntity = injector.getInstance(Key.get(InsuranceBenefitPlanEntity.class, Names.named("insuranceBenefitPlanEntityWithNoRef")));

		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntityWithRefs after the main body here] end

		log.trace("Created entity of type InsuranceBenefitPlanEntity with references");

		return insuranceBenefitPlanEntity;
	}

	/**
	 * Return a collection of Insurance Benefit Plan entities with all references set.
	 */
	@Provides
	@Named("insuranceBenefitPlanEntitiesWithRefs")
	public Collection<InsuranceBenefitPlanEntity> insuranceBenefitPlanEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for insuranceBenefitPlanEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for insuranceBenefitPlanEntitiesWithRefs here] end
		InsuranceBenefitPlanEntityFactory insuranceBenefitPlanEntityFactory
	) {
		log.trace("Creating entities of type InsuranceBenefitPlanEntity with references");

		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntitiesWithRefs before the main body here] end

		Collection<InsuranceBenefitPlanEntity> newEntities = insuranceBenefitPlanEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for insuranceBenefitPlanEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InsuranceBenefitPlanEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
