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
 * Guice module for Delivery Medical Examination Record used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class DeliveryMedicalExaminationRecordModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring DeliveryMedicalExaminationRecordModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured DeliveryMedicalExaminationRecordModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public DeliveryMedicalExaminationRecordEntityFactory deliveryMedicalExaminationRecordEntityFactory(
			// % protected region % [Apply any additional injected arguments for deliveryMedicalExaminationRecordEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for deliveryMedicalExaminationRecordEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating DeliveryMedicalExaminationRecordEntityFactory");

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntityFactory before the main body here] end

		DeliveryMedicalExaminationRecordEntityFactory entityFactory = new DeliveryMedicalExaminationRecordEntityFactory(
				// % protected region % [Apply any additional constructor arguments for DeliveryMedicalExaminationRecordEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for DeliveryMedicalExaminationRecordEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntityFactory after the main body here] end

		log.trace("Created DeliveryMedicalExaminationRecordEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Delivery Medical Examination Record entity with no references set.
	 */
	@Provides
	@Named("deliveryMedicalExaminationRecordEntityWithNoRef")
	public DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for deliveryMedicalExaminationRecordEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for deliveryMedicalExaminationRecordEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type DeliveryMedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordWithNoRef before the main body here] end

		DeliveryMedicalExaminationRecordEntity newEntity = new DeliveryMedicalExaminationRecordEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Pregnancy History Gravida here] off begin
		String randomStringforPregnancyHistoryGravida = mock
				.strings()
				.get();
		newEntity.setPregnancyHistoryGravida(randomStringforPregnancyHistoryGravida);
		// % protected region % [Add customisation for Pregnancy History Gravida here] end
		// % protected region % [Add customisation for Pregnancy History Partum  here] off begin
		String randomStringforPregnancyHistoryPartum = mock
				.strings()
				.get();
		newEntity.setPregnancyHistoryPartum(randomStringforPregnancyHistoryPartum);
		// % protected region % [Add customisation for Pregnancy History Partum  here] end
		// % protected region % [Add customisation for Pregnancy History Abortum  here] off begin
		String randomStringforPregnancyHistoryAbortum = mock
				.strings()
				.get();
		newEntity.setPregnancyHistoryAbortum(randomStringforPregnancyHistoryAbortum);
		// % protected region % [Add customisation for Pregnancy History Abortum  here] end
		// % protected region % [Add customisation for Pregnancy History Notes here] off begin
		String randomStringforPregnancyHistoryNotes = mock
				.strings()
				.get();
		newEntity.setPregnancyHistoryNotes(randomStringforPregnancyHistoryNotes);
		// % protected region % [Add customisation for Pregnancy History Notes here] end
		// % protected region % [Add customisation for LNMP Start Date here] off begin
		newEntity.setLnmpStartDate(OffsetDateTime.now());
		// % protected region % [Add customisation for LNMP Start Date here] end
		// % protected region % [Add customisation for LNMP End Date here] off begin
		newEntity.setLnmpEndDate(OffsetDateTime.now());
		// % protected region % [Add customisation for LNMP End Date here] end
		// % protected region % [Add customisation for Approximate Birth Date here] off begin
		newEntity.setApproximateBirthDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Approximate Birth Date here] end
		// % protected region % [Add customisation for Gestation Age Weeks here] off begin
		newEntity.setGestationAgeWeeks(mock.ints().get());
		// % protected region % [Add customisation for Gestation Age Weeks here] end
		// % protected region % [Add customisation for Gestation Age Days here] off begin
		newEntity.setGestationAgeDays(mock.ints().get());
		// % protected region % [Add customisation for Gestation Age Days here] end
		// % protected region % [Add customisation for Tetanus Vaccine 1 here] off begin
		newEntity.setTetanusVaccine1(mock.bools().get());
		// % protected region % [Add customisation for Tetanus Vaccine 1 here] end
		// % protected region % [Add customisation for Tetanus Vaccine 2 here] off begin
		newEntity.setTetanusVaccine2(mock.bools().get());
		// % protected region % [Add customisation for Tetanus Vaccine 2 here] end
		// % protected region % [Add customisation for Delivery Type here] off begin
		String randomStringforDeliveryType = mock
				.strings()
				.get();
		newEntity.setDeliveryType(randomStringforDeliveryType);
		// % protected region % [Add customisation for Delivery Type here] end
		// % protected region % [Add customisation for Complications In Pregnancy here] off begin
		String randomStringforComplicationsInPregnancy = mock
				.strings()
				.get();
		newEntity.setComplicationsInPregnancy(randomStringforComplicationsInPregnancy);
		// % protected region % [Add customisation for Complications In Pregnancy here] end
		// % protected region % [Add customisation for Risk Factor here] off begin
		String randomStringforRiskFactor = mock
				.strings()
				.get();
		newEntity.setRiskFactor(randomStringforRiskFactor);
		// % protected region % [Add customisation for Risk Factor here] end
		// % protected region % [Add customisation for Fetal Presentation here] off begin
		String randomStringforFetalPresentation = mock
				.strings()
				.get();
		newEntity.setFetalPresentation(randomStringforFetalPresentation);
		// % protected region % [Add customisation for Fetal Presentation here] end
		// % protected region % [Add customisation for Abdomen Examination here] off begin
		String randomStringforAbdomenExamination = mock
				.strings()
				.get();
		newEntity.setAbdomenExamination(randomStringforAbdomenExamination);
		// % protected region % [Add customisation for Abdomen Examination here] end
		// % protected region % [Add customisation for Fundal Height here] off begin
		String randomStringforFundalHeight = mock
				.strings()
				.get();
		newEntity.setFundalHeight(randomStringforFundalHeight);
		// % protected region % [Add customisation for Fundal Height here] end
		// % protected region % [Add customisation for FHR Per Minute here] off begin
		String randomStringforFhrPerMinute = mock
				.strings()
				.get();
		newEntity.setFhrPerMinute(randomStringforFhrPerMinute);
		// % protected region % [Add customisation for FHR Per Minute here] end
		// % protected region % [Add customisation for Estimated Fetal Weight here] off begin
		String randomStringforEstimatedFetalWeight = mock
				.strings()
				.get();
		newEntity.setEstimatedFetalWeight(randomStringforEstimatedFetalWeight);
		// % protected region % [Add customisation for Estimated Fetal Weight here] end
		// % protected region % [Add customisation for Leopold 1 here] off begin
		String randomStringforLeopold1 = mock
				.strings()
				.get();
		newEntity.setLeopold1(randomStringforLeopold1);
		// % protected region % [Add customisation for Leopold 1 here] end
		// % protected region % [Add customisation for Leopold 2 here] off begin
		String randomStringforLeopold2 = mock
				.strings()
				.get();
		newEntity.setLeopold2(randomStringforLeopold2);
		// % protected region % [Add customisation for Leopold 2 here] end
		// % protected region % [Add customisation for Leopold 3 here] off begin
		String randomStringforLeopold3 = mock
				.strings()
				.get();
		newEntity.setLeopold3(randomStringforLeopold3);
		// % protected region % [Add customisation for Leopold 3 here] end
		// % protected region % [Add customisation for Leopold 4 here] off begin
		String randomStringforLeopold4 = mock
				.strings()
				.get();
		newEntity.setLeopold4(randomStringforLeopold4);
		// % protected region % [Add customisation for Leopold 4 here] end
		// % protected region % [Add customisation for Genitelia Externa here] off begin
		String randomStringforGeniteliaExterna = mock
				.strings()
				.get();
		newEntity.setGeniteliaExterna(randomStringforGeniteliaExterna);
		// % protected region % [Add customisation for Genitelia Externa here] end
		// % protected region % [Add customisation for Genitelia Interna here] off begin
		String randomStringforGeniteliaInterna = mock
				.strings()
				.get();
		newEntity.setGeniteliaInterna(randomStringforGeniteliaInterna);
		// % protected region % [Add customisation for Genitelia Interna here] end
		// % protected region % [Add customisation for Vaginal Examination here] off begin
		String randomStringforVaginalExamination = mock
				.strings()
				.get();
		newEntity.setVaginalExamination(randomStringforVaginalExamination);
		// % protected region % [Add customisation for Vaginal Examination here] end
		// % protected region % [Add customisation for Delivery Complication here] off begin
		String randomStringforDeliveryComplication = mock
				.strings()
				.get();
		newEntity.setDeliveryComplication(randomStringforDeliveryComplication);
		// % protected region % [Add customisation for Delivery Complication here] end
		// % protected region % [Add customisation for Delivery Note here] off begin
		String randomStringforDeliveryNote = mock
				.strings()
				.get();
		newEntity.setDeliveryNote(randomStringforDeliveryNote);
		// % protected region % [Add customisation for Delivery Note here] end
		// % protected region % [Add customisation for Normal Delivery Case here] off begin
		newEntity.setNormalDeliveryCase(mock.bools().get());
		// % protected region % [Add customisation for Normal Delivery Case here] end
		// % protected region % [Add customisation for Stage 1 Hour here] off begin
		newEntity.setStage1Hour(mock.ints().get());
		// % protected region % [Add customisation for Stage 1 Hour here] end
		// % protected region % [Add customisation for Unnamed Integer 1 here] off begin
		newEntity.setUnnamedInteger1(mock.ints().get());
		// % protected region % [Add customisation for Unnamed Integer 1 here] end
		// % protected region % [Add customisation for Stage 3 Hour here] off begin
		newEntity.setStage3Hour(mock.ints().get());
		// % protected region % [Add customisation for Stage 3 Hour here] end
		// % protected region % [Add customisation for Stage 4 Hour here] off begin
		newEntity.setStage4Hour(mock.ints().get());
		// % protected region % [Add customisation for Stage 4 Hour here] end
		// % protected region % [Add customisation for Stage 1 Minute here] off begin
		newEntity.setStage1Minute(mock.ints().get());
		// % protected region % [Add customisation for Stage 1 Minute here] end
		// % protected region % [Add customisation for Stage 2 Minute here] off begin
		newEntity.setStage2Minute(mock.ints().get());
		// % protected region % [Add customisation for Stage 2 Minute here] end
		// % protected region % [Add customisation for Stage 3 Minute here] off begin
		newEntity.setStage3Minute(mock.ints().get());
		// % protected region % [Add customisation for Stage 3 Minute here] end
		// % protected region % [Add customisation for Stage 4 Minute here] off begin
		newEntity.setStage4Minute(mock.ints().get());
		// % protected region % [Add customisation for Stage 4 Minute here] end
		// % protected region % [Add customisation for Placenta here] off begin
		String randomStringforPlacenta = mock
				.strings()
				.get();
		newEntity.setPlacenta(randomStringforPlacenta);
		// % protected region % [Add customisation for Placenta here] end
		// % protected region % [Add customisation for Perineum here] off begin
		String randomStringforPerineum = mock
				.strings()
				.get();
		newEntity.setPerineum(randomStringforPerineum);
		// % protected region % [Add customisation for Perineum here] end
		// % protected region % [Add customisation for Bleeding here] off begin
		String randomStringforBleeding = mock
				.strings()
				.get();
		newEntity.setBleeding(randomStringforBleeding);
		// % protected region % [Add customisation for Bleeding here] end
		// % protected region % [Add customisation for Postpartum Complication here] off begin
		String randomStringforPostpartumComplication = mock
				.strings()
				.get();
		newEntity.setPostpartumComplication(randomStringforPostpartumComplication);
		// % protected region % [Add customisation for Postpartum Complication here] end
		// % protected region % [Add customisation for Newborn Delivered here] off begin
		newEntity.setNewbornDelivered(mock.ints().get());
		// % protected region % [Add customisation for Newborn Delivered here] end
		// % protected region % [Add customisation for Perineum Infection here] off begin
		newEntity.setPerineumInfection(mock.bools().get());
		// % protected region % [Add customisation for Perineum Infection here] end
		// % protected region % [Add customisation for Early Breastfeeding Intiation here] off begin
		newEntity.setEarlyBreastfeedingIntiation(mock.bools().get());
		// % protected region % [Add customisation for Early Breastfeeding Intiation here] end

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordWithNoRef after the main body here] end

		log.trace("Created entity of type DeliveryMedicalExaminationRecordEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Delivery Medical Examination Record entities with no reference at all.
	 */
	@Provides
	@Named("deliveryMedicalExaminationRecordEntitiesWithNoRef")
	public Collection<DeliveryMedicalExaminationRecordEntity> deliveryMedicalExaminationRecordEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for deliveryMedicalExaminationRecordEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for deliveryMedicalExaminationRecordEntitiesWithNoRef here] end
		DeliveryMedicalExaminationRecordEntityFactory deliveryMedicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type DeliveryMedicalExaminationRecordEntity with no reference");

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntitiesWithNoRef before the main body here] end

		Collection<DeliveryMedicalExaminationRecordEntity> newEntities = deliveryMedicalExaminationRecordEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type DeliveryMedicalExaminationRecordEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Delivery Medical Examination Record entity with all references set.
	 */
	@Provides
	@Named("deliveryMedicalExaminationRecordEntityWithRefs")
	public DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for deliveryMedicalExaminationRecordEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for deliveryMedicalExaminationRecordEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type DeliveryMedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntityWithRefs before the main body here] end

		DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity = injector.getInstance(Key.get(DeliveryMedicalExaminationRecordEntity.class, Names.named("deliveryMedicalExaminationRecordEntityWithNoRef")));

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntityWithRefs after the main body here] end

		log.trace("Created entity of type DeliveryMedicalExaminationRecordEntity with references");

		return deliveryMedicalExaminationRecordEntity;
	}

	/**
	 * Return a collection of Delivery Medical Examination Record entities with all references set.
	 */
	@Provides
	@Named("deliveryMedicalExaminationRecordEntitiesWithRefs")
	public Collection<DeliveryMedicalExaminationRecordEntity> deliveryMedicalExaminationRecordEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for deliveryMedicalExaminationRecordEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for deliveryMedicalExaminationRecordEntitiesWithRefs here] end
		DeliveryMedicalExaminationRecordEntityFactory deliveryMedicalExaminationRecordEntityFactory
	) {
		log.trace("Creating entities of type DeliveryMedicalExaminationRecordEntity with references");

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntitiesWithRefs before the main body here] end

		Collection<DeliveryMedicalExaminationRecordEntity> newEntities = deliveryMedicalExaminationRecordEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type DeliveryMedicalExaminationRecordEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
