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
 * Guice module for Operating Theater Medical Examination Record used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class OperatingTheaterMedicalExaminationRecordModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring OperatingTheaterMedicalExaminationRecordModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured OperatingTheaterMedicalExaminationRecordModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public OperatingTheaterMedicalExaminationRecordEntityFactory operatingTheaterMedicalExaminationRecordEntityFactory(
			// % protected region % [Apply any additional injected arguments for operatingTheaterMedicalExaminationRecordEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for operatingTheaterMedicalExaminationRecordEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating OperatingTheaterMedicalExaminationRecordEntityFactory");

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntityFactory before the main body here] end

		OperatingTheaterMedicalExaminationRecordEntityFactory entityFactory = new OperatingTheaterMedicalExaminationRecordEntityFactory(
				// % protected region % [Apply any additional constructor arguments for OperatingTheaterMedicalExaminationRecordEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for OperatingTheaterMedicalExaminationRecordEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntityFactory after the main body here] end

		log.trace("Created OperatingTheaterMedicalExaminationRecordEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Operating Theater Medical Examination Record entity with no references set.
	 */
	@Provides
	@Named("operatingTheaterMedicalExaminationRecordEntityWithNoRef")
	public OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for operatingTheaterMedicalExaminationRecordEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for operatingTheaterMedicalExaminationRecordEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type OperatingTheaterMedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordWithNoRef before the main body here] end

		OperatingTheaterMedicalExaminationRecordEntity newEntity = new OperatingTheaterMedicalExaminationRecordEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Has Confirmed Identity here] off begin
		newEntity.setHasConfirmedIdentity(mock.bools().get());
		// % protected region % [Add customisation for Has Confirmed Identity here] end
		// % protected region % [Add customisation for Anesthesia Safety Check Completed here] off begin
		newEntity.setAnesthesiaSafetyCheckCompleted(mock.bools().get());
		// % protected region % [Add customisation for Anesthesia Safety Check Completed here] end
		// % protected region % [Add customisation for Pulse Oxymeter Functioning here] off begin
		newEntity.setPulseOxymeterFunctioning(mock.bools().get());
		// % protected region % [Add customisation for Pulse Oxymeter Functioning here] end
		// % protected region % [Add customisation for Site Marked here] off begin
		String randomStringforSiteMarked = mock
				.strings()
				.get();
		newEntity.setSiteMarked(randomStringforSiteMarked);
		// % protected region % [Add customisation for Site Marked here] end
		// % protected region % [Add customisation for Has Known Allergy here] off begin
		String randomStringforHasKnownAllergy = mock
				.strings()
				.get();
		newEntity.setHasKnownAllergy(randomStringforHasKnownAllergy);
		// % protected region % [Add customisation for Has Known Allergy here] end
		// % protected region % [Add customisation for Has Difficult Airway Risk here] off begin
		String randomStringforHasDifficultAirwayRisk = mock
				.strings()
				.get();
		newEntity.setHasDifficultAirwayRisk(randomStringforHasDifficultAirwayRisk);
		// % protected region % [Add customisation for Has Difficult Airway Risk here] end
		// % protected region % [Add customisation for Has Risk Of Blood Loss here] off begin
		String randomStringforHasRiskOfBloodLoss = mock
				.strings()
				.get();
		newEntity.setHasRiskOfBloodLoss(randomStringforHasRiskOfBloodLoss);
		// % protected region % [Add customisation for Has Risk Of Blood Loss here] end
		// % protected region % [Add customisation for Team Member Introduced here] off begin
		newEntity.setTeamMemberIntroduced(mock.bools().get());
		// % protected region % [Add customisation for Team Member Introduced here] end
		// % protected region % [Add customisation for Professional Confirmed Patient here] off begin
		newEntity.setProfessionalConfirmedPatient(mock.bools().get());
		// % protected region % [Add customisation for Professional Confirmed Patient here] end
		// % protected region % [Add customisation for Antibiotic Prophylaxis Given here] off begin
		String randomStringforAntibioticProphylaxisGiven = mock
				.strings()
				.get();
		newEntity.setAntibioticProphylaxisGiven(randomStringforAntibioticProphylaxisGiven);
		// % protected region % [Add customisation for Antibiotic Prophylaxis Given here] end
		// % protected region % [Add customisation for Essential Imaging Displayed here] off begin
		String randomStringforEssentialImagingDisplayed = mock
				.strings()
				.get();
		newEntity.setEssentialImagingDisplayed(randomStringforEssentialImagingDisplayed);
		// % protected region % [Add customisation for Essential Imaging Displayed here] end
		// % protected region % [Add customisation for Whare Are Critical Steps here] off begin
		newEntity.setWhareAreCriticalSteps(mock.bools().get());
		// % protected region % [Add customisation for Whare Are Critical Steps here] end
		// % protected region % [Add customisation for How Long Case Take here] off begin
		newEntity.setHowLongCaseTake(mock.bools().get());
		// % protected region % [Add customisation for How Long Case Take here] end
		// % protected region % [Add customisation for What Is Anticipated Blood Loss here] off begin
		newEntity.setWhatIsAnticipatedBloodLoss(mock.bools().get());
		// % protected region % [Add customisation for What Is Anticipated Blood Loss here] end
		// % protected region % [Add customisation for Any Patient Specific Concerns here] off begin
		newEntity.setAnyPatientSpecificConcerns(mock.bools().get());
		// % protected region % [Add customisation for Any Patient Specific Concerns here] end
		// % protected region % [Add customisation for Sterlity Been Confirmed here] off begin
		newEntity.setSterlityBeenConfirmed(mock.bools().get());
		// % protected region % [Add customisation for Sterlity Been Confirmed here] end
		// % protected region % [Add customisation for Equipment Issues Any Concern here] off begin
		newEntity.setEquipmentIssuesAnyConcern(mock.bools().get());
		// % protected region % [Add customisation for Equipment Issues Any Concern here] end
		// % protected region % [Add customisation for Name Of Procedure here] off begin
		newEntity.setNameOfProcedure(mock.bools().get());
		// % protected region % [Add customisation for Name Of Procedure here] end
		// % protected region % [Add customisation for Instruments Need Count Correct here] off begin
		newEntity.setInstrumentsNeedCountCorrect(mock.bools().get());
		// % protected region % [Add customisation for Instruments Need Count Correct here] end
		// % protected region % [Add customisation for Specimen Is Labeled here] off begin
		newEntity.setSpecimenIsLabeled(mock.bools().get());
		// % protected region % [Add customisation for Specimen Is Labeled here] end
		// % protected region % [Add customisation for Equipment Problems Addressed here] off begin
		newEntity.setEquipmentProblemsAddressed(mock.bools().get());
		// % protected region % [Add customisation for Equipment Problems Addressed here] end
		// % protected region % [Add customisation for Key Concerns For Recovery here] off begin
		newEntity.setKeyConcernsForRecovery(mock.bools().get());
		// % protected region % [Add customisation for Key Concerns For Recovery here] end

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordWithNoRef after the main body here] end

		log.trace("Created entity of type OperatingTheaterMedicalExaminationRecordEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Operating Theater Medical Examination Record entities with no reference at all.
	 */
	@Provides
	@Named("operatingTheaterMedicalExaminationRecordEntitiesWithNoRef")
	public Collection<OperatingTheaterMedicalExaminationRecordEntity> operatingTheaterMedicalExaminationRecordEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for operatingTheaterMedicalExaminationRecordEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for operatingTheaterMedicalExaminationRecordEntitiesWithNoRef here] end
		OperatingTheaterMedicalExaminationRecordEntityFactory operatingTheaterMedicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type OperatingTheaterMedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntitiesWithNoRef before the main body here] end

		Collection<OperatingTheaterMedicalExaminationRecordEntity> newEntities = operatingTheaterMedicalExaminationRecordEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type OperatingTheaterMedicalExaminationRecordEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Operating Theater Medical Examination Record entity with all references set.
	 */
	@Provides
	@Named("operatingTheaterMedicalExaminationRecordEntityWithRefs")
	public OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for operatingTheaterMedicalExaminationRecordEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for operatingTheaterMedicalExaminationRecordEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type OperatingTheaterMedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntityWithRefs before the main body here] end

		OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity = injector.getInstance(Key.get(OperatingTheaterMedicalExaminationRecordEntity.class, Names.named("operatingTheaterMedicalExaminationRecordEntityWithNoRef")));

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntityWithRefs after the main body here] end

		log.trace("Created entity of type OperatingTheaterMedicalExaminationRecordEntity with references");

		return operatingTheaterMedicalExaminationRecordEntity;
	}

	/**
	 * Return a collection of Operating Theater Medical Examination Record entities with all references set.
	 */
	@Provides
	@Named("operatingTheaterMedicalExaminationRecordEntitiesWithRefs")
	public Collection<OperatingTheaterMedicalExaminationRecordEntity> operatingTheaterMedicalExaminationRecordEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for operatingTheaterMedicalExaminationRecordEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for operatingTheaterMedicalExaminationRecordEntitiesWithRefs here] end
		OperatingTheaterMedicalExaminationRecordEntityFactory operatingTheaterMedicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type OperatingTheaterMedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntitiesWithRefs before the main body here] end

		Collection<OperatingTheaterMedicalExaminationRecordEntity> newEntities = operatingTheaterMedicalExaminationRecordEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type OperatingTheaterMedicalExaminationRecordEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
