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
 * Guice module for Inpatient Medical Examination Record used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class InpatientMedicalExaminationRecordModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring InpatientMedicalExaminationRecordModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured InpatientMedicalExaminationRecordModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public InpatientMedicalExaminationRecordEntityFactory inpatientMedicalExaminationRecordEntityFactory(
			// % protected region % [Apply any additional injected arguments for inpatientMedicalExaminationRecordEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for inpatientMedicalExaminationRecordEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating InpatientMedicalExaminationRecordEntityFactory");

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntityFactory before the main body here] end

		InpatientMedicalExaminationRecordEntityFactory entityFactory = new InpatientMedicalExaminationRecordEntityFactory(
				// % protected region % [Apply any additional constructor arguments for InpatientMedicalExaminationRecordEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for InpatientMedicalExaminationRecordEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntityFactory after the main body here] end

		log.trace("Created InpatientMedicalExaminationRecordEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Inpatient Medical Examination Record entity with no references set.
	 */
	@Provides
	@Named("inpatientMedicalExaminationRecordEntityWithNoRef")
	public InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for inpatientMedicalExaminationRecordEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for inpatientMedicalExaminationRecordEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type InpatientMedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordWithNoRef before the main body here] end

		InpatientMedicalExaminationRecordEntity newEntity = new InpatientMedicalExaminationRecordEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] off begin
		newEntity.setStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] end
		// % protected region % [Add customisation for End Date Time here] off begin
		newEntity.setEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date Time here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Inpatient Case here] off begin
		String randomStringforInpatientCase = mock
				.strings()
				.get();
		newEntity.setInpatientCase(randomStringforInpatientCase);
		// % protected region % [Add customisation for Inpatient Case here] end
		// % protected region % [Add customisation for Service Case here] off begin
		String randomStringforServiceCase = mock
				.strings()
				.get();
		newEntity.setServiceCase(randomStringforServiceCase);
		// % protected region % [Add customisation for Service Case here] end
		// % protected region % [Add customisation for Dependency Level here] off begin
		String randomStringforDependencyLevel = mock
				.strings()
				.get();
		newEntity.setDependencyLevel(randomStringforDependencyLevel);
		// % protected region % [Add customisation for Dependency Level here] end
		// % protected region % [Add customisation for Current Dependency here] off begin
		String randomStringforCurrentDependency = mock
				.strings()
				.get();
		newEntity.setCurrentDependency(randomStringforCurrentDependency);
		// % protected region % [Add customisation for Current Dependency here] end
		// % protected region % [Add customisation for Infant Condition here] off begin
		String randomStringforInfantCondition = mock
				.strings()
				.get();
		newEntity.setInfantCondition(randomStringforInfantCondition);
		// % protected region % [Add customisation for Infant Condition here] end
		// % protected region % [Add customisation for Neonatal Case here] off begin
		String randomStringforNeonatalCase = mock
				.strings()
				.get();
		newEntity.setNeonatalCase(randomStringforNeonatalCase);
		// % protected region % [Add customisation for Neonatal Case here] end

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordWithNoRef after the main body here] end

		log.trace("Created entity of type InpatientMedicalExaminationRecordEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Inpatient Medical Examination Record entities with no reference at all.
	 */
	@Provides
	@Named("inpatientMedicalExaminationRecordEntitiesWithNoRef")
	public Collection<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecordEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for inpatientMedicalExaminationRecordEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for inpatientMedicalExaminationRecordEntitiesWithNoRef here] end
		InpatientMedicalExaminationRecordEntityFactory inpatientMedicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type InpatientMedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntitiesWithNoRef before the main body here] end

		Collection<InpatientMedicalExaminationRecordEntity> newEntities = inpatientMedicalExaminationRecordEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type InpatientMedicalExaminationRecordEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Inpatient Medical Examination Record entity with all references set.
	 */
	@Provides
	@Named("inpatientMedicalExaminationRecordEntityWithRefs")
	public InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for inpatientMedicalExaminationRecordEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for inpatientMedicalExaminationRecordEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type InpatientMedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntityWithRefs before the main body here] end

		InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity = injector.getInstance(Key.get(InpatientMedicalExaminationRecordEntity.class, Names.named("inpatientMedicalExaminationRecordEntityWithNoRef")));

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntityWithRefs after the main body here] end

		log.trace("Created entity of type InpatientMedicalExaminationRecordEntity with references");

		return inpatientMedicalExaminationRecordEntity;
	}

	/**
	 * Return a collection of Inpatient Medical Examination Record entities with all references set.
	 */
	@Provides
	@Named("inpatientMedicalExaminationRecordEntitiesWithRefs")
	public Collection<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecordEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for inpatientMedicalExaminationRecordEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for inpatientMedicalExaminationRecordEntitiesWithRefs here] end
		InpatientMedicalExaminationRecordEntityFactory inpatientMedicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type InpatientMedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntitiesWithRefs before the main body here] end

		Collection<InpatientMedicalExaminationRecordEntity> newEntities = inpatientMedicalExaminationRecordEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type InpatientMedicalExaminationRecordEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
