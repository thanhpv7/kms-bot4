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
 * Guice module for Hemodialysis Examination used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class HemodialysisExaminationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring HemodialysisExaminationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured HemodialysisExaminationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public HemodialysisExaminationEntityFactory hemodialysisExaminationEntityFactory(
			// % protected region % [Apply any additional injected arguments for hemodialysisExaminationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for hemodialysisExaminationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating HemodialysisExaminationEntityFactory");

		// % protected region % [Apply any additional logic for hemodialysisExaminationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationEntityFactory before the main body here] end

		HemodialysisExaminationEntityFactory entityFactory = new HemodialysisExaminationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for HemodialysisExaminationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for HemodialysisExaminationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for hemodialysisExaminationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationEntityFactory after the main body here] end

		log.trace("Created HemodialysisExaminationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Hemodialysis Examination entity with no references set.
	 */
	@Provides
	@Named("hemodialysisExaminationEntityWithNoRef")
	public HemodialysisExaminationEntity hemodialysisExaminationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for hemodialysisExaminationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for hemodialysisExaminationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type HemodialysisExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for hemodialysisExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationWithNoRef before the main body here] end

		HemodialysisExaminationEntity newEntity = new HemodialysisExaminationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for First Dialysis here] off begin
		newEntity.setFirstDialysis(OffsetDateTime.now());
		// % protected region % [Add customisation for First Dialysis here] end
		// % protected region % [Add customisation for Dialysis Frequency here] off begin
		String randomStringforDialysisFrequency = mock
				.strings()
				.get();
		newEntity.setDialysisFrequency(randomStringforDialysisFrequency);
		// % protected region % [Add customisation for Dialysis Frequency here] end
		// % protected region % [Add customisation for Dialysis No here] off begin
		String randomStringforDialysisNo = mock
				.strings()
				.get();
		newEntity.setDialysisNo(randomStringforDialysisNo);
		// % protected region % [Add customisation for Dialysis No here] end
		// % protected region % [Add customisation for Hemodialysis Type here] off begin
		String randomStringforHemodialysisType = mock
				.strings()
				.get();
		newEntity.setHemodialysisType(randomStringforHemodialysisType);
		// % protected region % [Add customisation for Hemodialysis Type here] end
		// % protected region % [Add customisation for Condition here] off begin
		String randomStringforCondition = mock
				.strings()
				.get();
		newEntity.setCondition(randomStringforCondition);
		// % protected region % [Add customisation for Condition here] end
		// % protected region % [Add customisation for Vascular Access here] off begin
		String randomStringforVascularAccess = mock
				.strings()
				.get();
		newEntity.setVascularAccess(randomStringforVascularAccess);
		// % protected region % [Add customisation for Vascular Access here] end
		// % protected region % [Add customisation for Heparinization here] off begin
		String randomStringforHeparinization = mock
				.strings()
				.get();
		newEntity.setHeparinization(randomStringforHeparinization);
		// % protected region % [Add customisation for Heparinization here] end
		// % protected region % [Add customisation for Heparinization Initial Dose here] off begin
		String randomStringforHeparinizationInitialDose = mock
				.strings()
				.get();
		newEntity.setHeparinizationInitialDose(randomStringforHeparinizationInitialDose);
		// % protected region % [Add customisation for Heparinization Initial Dose here] end
		// % protected region % [Add customisation for Heparinization Follow Up Dose here] off begin
		String randomStringforHeparinizationFollowUpDose = mock
				.strings()
				.get();
		newEntity.setHeparinizationFollowUpDose(randomStringforHeparinizationFollowUpDose);
		// % protected region % [Add customisation for Heparinization Follow Up Dose here] end
		// % protected region % [Add customisation for Dialyzer here] off begin
		String randomStringforDialyzer = mock
				.strings()
				.get();
		newEntity.setDialyzer(randomStringforDialyzer);
		// % protected region % [Add customisation for Dialyzer here] end
		// % protected region % [Add customisation for Dialyzer Type here] off begin
		String randomStringforDialyzerType = mock
				.strings()
				.get();
		newEntity.setDialyzerType(randomStringforDialyzerType);
		// % protected region % [Add customisation for Dialyzer Type here] end
		// % protected region % [Add customisation for Dialysis Fluid here] off begin
		String randomStringforDialysisFluid = mock
				.strings()
				.get();
		newEntity.setDialysisFluid(randomStringforDialysisFluid);
		// % protected region % [Add customisation for Dialysis Fluid here] end
		// % protected region % [Add customisation for Dry Weight here] off begin
		newEntity.setDryWeight(mock.doubles().get());
		// % protected region % [Add customisation for Dry Weight here] end
		// % protected region % [Add customisation for Dry Weight Unit here] off begin
		String randomStringforDryWeightUnit = mock
				.strings()
				.get();
		newEntity.setDryWeightUnit(randomStringforDryWeightUnit);
		// % protected region % [Add customisation for Dry Weight Unit here] end
		// % protected region % [Add customisation for Weight Upon Arrival here] off begin
		newEntity.setWeightUponArrival(mock.doubles().get());
		// % protected region % [Add customisation for Weight Upon Arrival here] end
		// % protected region % [Add customisation for Weight Upon Arrival Unit here] off begin
		String randomStringforWeightUponArrivalUnit = mock
				.strings()
				.get();
		newEntity.setWeightUponArrivalUnit(randomStringforWeightUponArrivalUnit);
		// % protected region % [Add customisation for Weight Upon Arrival Unit here] end
		// % protected region % [Add customisation for Weight During Previous Hemodialysis here] off begin
		newEntity.setWeightDuringPreviousHemodialysis(mock.doubles().get());
		// % protected region % [Add customisation for Weight During Previous Hemodialysis here] end
		// % protected region % [Add customisation for Weight During Previous Hemodialysis Unit here] off begin
		String randomStringforWeightDuringPreviousHemodialysisUnit = mock
				.strings()
				.get();
		newEntity.setWeightDuringPreviousHemodialysisUnit(randomStringforWeightDuringPreviousHemodialysisUnit);
		// % protected region % [Add customisation for Weight During Previous Hemodialysis Unit here] end
		// % protected region % [Add customisation for Anti HIV here] off begin
		newEntity.setAntiHIV(mock.bools().get());
		// % protected region % [Add customisation for Anti HIV here] end
		// % protected region % [Add customisation for HbsAg here] off begin
		newEntity.setHbsag(mock.bools().get());
		// % protected region % [Add customisation for HbsAg here] end
		// % protected region % [Add customisation for Anti HCV here] off begin
		newEntity.setAntiHCV(mock.bools().get());
		// % protected region % [Add customisation for Anti HCV here] end
		// % protected region % [Add customisation for Hemodialysis Start Time here] off begin
		newEntity.setHemodialysisStartTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Hemodialysis Start Time here] end
		// % protected region % [Add customisation for Hemodialysis End Time here] off begin
		newEntity.setHemodialysisEndTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Hemodialysis End Time here] end
		// % protected region % [Add customisation for Target here] off begin
		String randomStringforTarget = mock
				.strings()
				.get();
		newEntity.setTarget(randomStringforTarget);
		// % protected region % [Add customisation for Target here] end
		// % protected region % [Add customisation for Priming Volume here] off begin
		String randomStringforPrimingVolume = mock
				.strings()
				.get();
		newEntity.setPrimingVolume(randomStringforPrimingVolume);
		// % protected region % [Add customisation for Priming Volume here] end
		// % protected region % [Add customisation for Remaining Priming here] off begin
		String randomStringforRemainingPriming = mock
				.strings()
				.get();
		newEntity.setRemainingPriming(randomStringforRemainingPriming);
		// % protected region % [Add customisation for Remaining Priming here] end
		// % protected region % [Add customisation for Complication here] off begin
		String randomStringforComplication = mock
				.strings()
				.get();
		newEntity.setComplication(randomStringforComplication);
		// % protected region % [Add customisation for Complication here] end
		// % protected region % [Add customisation for Hemodialysis Details here] off begin
		String randomStringforHemodialysisDetails = mock
				.strings()
				.get();
		newEntity.setHemodialysisDetails(randomStringforHemodialysisDetails);
		// % protected region % [Add customisation for Hemodialysis Details here] end
		// % protected region % [Add customisation for Weight Upon Dismissal here] off begin
		newEntity.setWeightUponDismissal(mock.doubles().get());
		// % protected region % [Add customisation for Weight Upon Dismissal here] end
		// % protected region % [Add customisation for Weight Upon Dismissal Unit here] off begin
		String randomStringforWeightUponDismissalUnit = mock
				.strings()
				.get();
		newEntity.setWeightUponDismissalUnit(randomStringforWeightUponDismissalUnit);
		// % protected region % [Add customisation for Weight Upon Dismissal Unit here] end
		// % protected region % [Add customisation for Priming here] off begin
		newEntity.setPriming(mock.doubles().get());
		// % protected region % [Add customisation for Priming here] end
		// % protected region % [Add customisation for Blood here] off begin
		newEntity.setBlood(mock.doubles().get());
		// % protected region % [Add customisation for Blood here] end
		// % protected region % [Add customisation for IV Line here] off begin
		newEntity.setIvLine(mock.doubles().get());
		// % protected region % [Add customisation for IV Line here] end
		// % protected region % [Add customisation for Oral here] off begin
		newEntity.setOral(mock.doubles().get());
		// % protected region % [Add customisation for Oral here] end
		// % protected region % [Add customisation for Wash Out here] off begin
		newEntity.setWashOut(mock.doubles().get());
		// % protected region % [Add customisation for Wash Out here] end
		// % protected region % [Add customisation for Total Fluid Intake here] off begin
		newEntity.setTotalFluidIntake(mock.doubles().get());
		// % protected region % [Add customisation for Total Fluid Intake here] end
		// % protected region % [Add customisation for Urine here] off begin
		newEntity.setUrine(mock.doubles().get());
		// % protected region % [Add customisation for Urine here] end
		// % protected region % [Add customisation for Others here] off begin
		newEntity.setOthers(mock.doubles().get());
		// % protected region % [Add customisation for Others here] end
		// % protected region % [Add customisation for Total Fluid Output here] off begin
		newEntity.setTotalFluidOutput(mock.doubles().get());
		// % protected region % [Add customisation for Total Fluid Output here] end
		// % protected region % [Add customisation for Fluid Balance here] off begin
		newEntity.setFluidBalance(mock.doubles().get());
		// % protected region % [Add customisation for Fluid Balance here] end
		// % protected region % [Add customisation for Post Hemodialysis Evaluation here] off begin
		String randomStringforPostHemodialysisEvaluation = mock
				.strings()
				.size(500)
				.get();
		newEntity.setPostHemodialysisEvaluation(randomStringforPostHemodialysisEvaluation);
		// % protected region % [Add customisation for Post Hemodialysis Evaluation here] end

		// % protected region % [Apply any additional logic for hemodialysisExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationWithNoRef after the main body here] end

		log.trace("Created entity of type HemodialysisExaminationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Hemodialysis Examination entities with no reference at all.
	 */
	@Provides
	@Named("hemodialysisExaminationEntitiesWithNoRef")
	public Collection<HemodialysisExaminationEntity> hemodialysisExaminationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for hemodialysisExaminationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for hemodialysisExaminationEntitiesWithNoRef here] end
		HemodialysisExaminationEntityFactory hemodialysisExaminationEntityFactory
	) {
		log.trace("Creating entities of type HemodialysisExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for hemodialysisExaminationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationEntitiesWithNoRef before the main body here] end

		Collection<HemodialysisExaminationEntity> newEntities = hemodialysisExaminationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for hemodialysisExaminationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type HemodialysisExaminationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Hemodialysis Examination entity with all references set.
	 */
	@Provides
	@Named("hemodialysisExaminationEntityWithRefs")
	public HemodialysisExaminationEntity hemodialysisExaminationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for hemodialysisExaminationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for hemodialysisExaminationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type HemodialysisExaminationEntity with references");

		// % protected region % [Apply any additional logic for hemodialysisExaminationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationEntityWithRefs before the main body here] end

		HemodialysisExaminationEntity hemodialysisExaminationEntity = injector.getInstance(Key.get(HemodialysisExaminationEntity.class, Names.named("hemodialysisExaminationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for hemodialysisExaminationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationEntityWithRefs after the main body here] end

		log.trace("Created entity of type HemodialysisExaminationEntity with references");

		return hemodialysisExaminationEntity;
	}

	/**
	 * Return a collection of Hemodialysis Examination entities with all references set.
	 */
	@Provides
	@Named("hemodialysisExaminationEntitiesWithRefs")
	public Collection<HemodialysisExaminationEntity> hemodialysisExaminationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for hemodialysisExaminationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for hemodialysisExaminationEntitiesWithRefs here] end
		HemodialysisExaminationEntityFactory hemodialysisExaminationEntityFactory
	) {
		log.trace("Creating entities of type HemodialysisExaminationEntity with references");

		// % protected region % [Apply any additional logic for hemodialysisExaminationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationEntitiesWithRefs before the main body here] end

		Collection<HemodialysisExaminationEntity> newEntities = hemodialysisExaminationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for hemodialysisExaminationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisExaminationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type HemodialysisExaminationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
