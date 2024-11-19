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
 * Guice module for Obstetric And Gynecology History used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class ObstetricAndGynecologyHistoryModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring ObstetricAndGynecologyHistoryModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured ObstetricAndGynecologyHistoryModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public ObstetricAndGynecologyHistoryEntityFactory obstetricAndGynecologyHistoryEntityFactory(
			// % protected region % [Apply any additional injected arguments for obstetricAndGynecologyHistoryEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for obstetricAndGynecologyHistoryEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating ObstetricAndGynecologyHistoryEntityFactory");

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntityFactory before the main body here] end

		ObstetricAndGynecologyHistoryEntityFactory entityFactory = new ObstetricAndGynecologyHistoryEntityFactory(
				// % protected region % [Apply any additional constructor arguments for ObstetricAndGynecologyHistoryEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for ObstetricAndGynecologyHistoryEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntityFactory after the main body here] end

		log.trace("Created ObstetricAndGynecologyHistoryEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Obstetric And Gynecology History entity with no references set.
	 */
	@Provides
	@Named("obstetricAndGynecologyHistoryEntityWithNoRef")
	public ObstetricAndGynecologyHistoryEntity obstetricAndGynecologyHistoryEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for obstetricAndGynecologyHistoryEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for obstetricAndGynecologyHistoryEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type ObstetricAndGynecologyHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryWithNoRef before the main body here] end

		ObstetricAndGynecologyHistoryEntity newEntity = new ObstetricAndGynecologyHistoryEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Pregnancy History Gravida here] off begin
		String randomStringforPregnancyHistoryGravida = mock
				.strings()
				.get();
		newEntity.setPregnancyHistoryGravida(randomStringforPregnancyHistoryGravida);
		// % protected region % [Add customisation for Pregnancy History Gravida here] end
		// % protected region % [Add customisation for Patient History Para here] off begin
		String randomStringforPatientHistoryPara = mock
				.strings()
				.get();
		newEntity.setPatientHistoryPara(randomStringforPatientHistoryPara);
		// % protected region % [Add customisation for Patient History Para here] end
		// % protected region % [Add customisation for Patient History Abortus here] off begin
		String randomStringforPatientHistoryAbortus = mock
				.strings()
				.get();
		newEntity.setPatientHistoryAbortus(randomStringforPatientHistoryAbortus);
		// % protected region % [Add customisation for Patient History Abortus here] end
		// % protected region % [Add customisation for Pregnancy History Notes here] off begin
		String randomStringforPregnancyHistoryNotes = mock
				.strings()
				.get();
		newEntity.setPregnancyHistoryNotes(randomStringforPregnancyHistoryNotes);
		// % protected region % [Add customisation for Pregnancy History Notes here] end
		// % protected region % [Add customisation for Age of Menarche here] off begin
		String randomStringforAgeOfMenarche = mock
				.strings()
				.get();
		newEntity.setAgeOfMenarche(randomStringforAgeOfMenarche);
		// % protected region % [Add customisation for Age of Menarche here] end
		// % protected region % [Add customisation for Age of First Sexual Contact here] off begin
		String randomStringforAgeOfFirstSexualContact = mock
				.strings()
				.get();
		newEntity.setAgeOfFirstSexualContact(randomStringforAgeOfFirstSexualContact);
		// % protected region % [Add customisation for Age of First Sexual Contact here] end
		// % protected region % [Add customisation for Start Date here] off begin
		newEntity.setStartDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date here] end
		// % protected region % [Add customisation for End Date here] off begin
		newEntity.setEndDate(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date here] end
		// % protected region % [Add customisation for Approximate Birth Date here] off begin
		newEntity.setApproximateBirthDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Approximate Birth Date here] end
		// % protected region % [Add customisation for Gestation Age Weeks here] off begin
		String randomStringforGestationAgeWeeks = mock
				.strings()
				.get();
		newEntity.setGestationAgeWeeks(randomStringforGestationAgeWeeks);
		// % protected region % [Add customisation for Gestation Age Weeks here] end
		// % protected region % [Add customisation for Gestation Age Days here] off begin
		String randomStringforGestationAgeDays = mock
				.strings()
				.get();
		newEntity.setGestationAgeDays(randomStringforGestationAgeDays);
		// % protected region % [Add customisation for Gestation Age Days here] end
		// % protected region % [Add customisation for Maternity History here] off begin
		String randomStringforMaternityHistory = mock
				.strings()
				.get();
		newEntity.setMaternityHistory(randomStringforMaternityHistory);
		// % protected region % [Add customisation for Maternity History here] end
		// % protected region % [Add customisation for Gynecology History here] off begin
		String randomStringforGynecologyHistory = mock
				.strings()
				.get();
		newEntity.setGynecologyHistory(randomStringforGynecologyHistory);
		// % protected region % [Add customisation for Gynecology History here] end
		// % protected region % [Add customisation for Family Plan History here] off begin
		String randomStringforFamilyPlanHistory = mock
				.strings()
				.get();
		newEntity.setFamilyPlanHistory(randomStringforFamilyPlanHistory);
		// % protected region % [Add customisation for Family Plan History here] end
		// % protected region % [Add customisation for Other Notes here] off begin
		String randomStringforOtherNotes = mock
				.strings()
				.get();
		newEntity.setOtherNotes(randomStringforOtherNotes);
		// % protected region % [Add customisation for Other Notes here] end
		// % protected region % [Add customisation for Education Level of Patient here] off begin
		String randomStringforEducationLevelOfPatient = mock
				.strings()
				.get();
		newEntity.setEducationLevelOfPatient(randomStringforEducationLevelOfPatient);
		// % protected region % [Add customisation for Education Level of Patient here] end
		// % protected region % [Add customisation for Name of Husband or Wife here] off begin
		String randomStringforNameOfHusbandOrWife = mock
				.strings()
				.get();
		newEntity.setNameOfHusbandOrWife(randomStringforNameOfHusbandOrWife);
		// % protected region % [Add customisation for Name of Husband or Wife here] end
		// % protected region % [Add customisation for Education Level of Husband or Wife here] off begin
		String randomStringforEducationLevelOfHusbandOrWife = mock
				.strings()
				.get();
		newEntity.setEducationLevelOfHusbandOrWife(randomStringforEducationLevelOfHusbandOrWife);
		// % protected region % [Add customisation for Education Level of Husband or Wife here] end
		// % protected region % [Add customisation for Occupation of Husband or Wife here] off begin
		String randomStringforOccupationOfHusbandOrWife = mock
				.strings()
				.get();
		newEntity.setOccupationOfHusbandOrWife(randomStringforOccupationOfHusbandOrWife);
		// % protected region % [Add customisation for Occupation of Husband or Wife here] end
		// % protected region % [Add customisation for Rupture Of Membrane here] off begin
		newEntity.setRuptureOfMembrane(OffsetDateTime.now());
		// % protected region % [Add customisation for Rupture Of Membrane here] end

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryWithNoRef after the main body here] end

		log.trace("Created entity of type ObstetricAndGynecologyHistoryEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Obstetric And Gynecology History entities with no reference at all.
	 */
	@Provides
	@Named("obstetricAndGynecologyHistoryEntitiesWithNoRef")
	public Collection<ObstetricAndGynecologyHistoryEntity> obstetricAndGynecologyHistoryEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for obstetricAndGynecologyHistoryEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for obstetricAndGynecologyHistoryEntitiesWithNoRef here] end
		ObstetricAndGynecologyHistoryEntityFactory obstetricAndGynecologyHistoryEntityFactory
	) {
		log.trace("Creating entities of type ObstetricAndGynecologyHistoryEntity with no reference");

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntitiesWithNoRef before the main body here] end

		Collection<ObstetricAndGynecologyHistoryEntity> newEntities = obstetricAndGynecologyHistoryEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type ObstetricAndGynecologyHistoryEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Obstetric And Gynecology History entity with all references set.
	 */
	@Provides
	@Named("obstetricAndGynecologyHistoryEntityWithRefs")
	public ObstetricAndGynecologyHistoryEntity obstetricAndGynecologyHistoryEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for obstetricAndGynecologyHistoryEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for obstetricAndGynecologyHistoryEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type ObstetricAndGynecologyHistoryEntity with references");

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntityWithRefs before the main body here] end

		ObstetricAndGynecologyHistoryEntity obstetricAndGynecologyHistoryEntity = injector.getInstance(Key.get(ObstetricAndGynecologyHistoryEntity.class, Names.named("obstetricAndGynecologyHistoryEntityWithNoRef")));

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntityWithRefs after the main body here] end

		log.trace("Created entity of type ObstetricAndGynecologyHistoryEntity with references");

		return obstetricAndGynecologyHistoryEntity;
	}

	/**
	 * Return a collection of Obstetric And Gynecology History entities with all references set.
	 */
	@Provides
	@Named("obstetricAndGynecologyHistoryEntitiesWithRefs")
	public Collection<ObstetricAndGynecologyHistoryEntity> obstetricAndGynecologyHistoryEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for obstetricAndGynecologyHistoryEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for obstetricAndGynecologyHistoryEntitiesWithRefs here] end
		ObstetricAndGynecologyHistoryEntityFactory obstetricAndGynecologyHistoryEntityFactory
	) {
		log.trace("Creating entities of type ObstetricAndGynecologyHistoryEntity with references");

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntitiesWithRefs before the main body here] end

		Collection<ObstetricAndGynecologyHistoryEntity> newEntities = obstetricAndGynecologyHistoryEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for obstetricAndGynecologyHistoryEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type ObstetricAndGynecologyHistoryEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
