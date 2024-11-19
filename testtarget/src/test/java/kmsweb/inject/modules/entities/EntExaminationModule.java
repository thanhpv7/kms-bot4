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
 * Guice module for ENT Examination used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class EntExaminationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring EntExaminationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured EntExaminationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public EntExaminationEntityFactory entExaminationEntityFactory(
			// % protected region % [Apply any additional injected arguments for entExaminationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for entExaminationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating EntExaminationEntityFactory");

		// % protected region % [Apply any additional logic for entExaminationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationEntityFactory before the main body here] end

		EntExaminationEntityFactory entityFactory = new EntExaminationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for EntExaminationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for EntExaminationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for entExaminationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationEntityFactory after the main body here] end

		log.trace("Created EntExaminationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty ENT Examination entity with no references set.
	 */
	@Provides
	@Named("entExaminationEntityWithNoRef")
	public EntExaminationEntity entExaminationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for entExaminationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for entExaminationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type EntExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for entExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationWithNoRef before the main body here] end

		EntExaminationEntity newEntity = new EntExaminationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Right External Ear Subjective here] off begin
		String randomStringforRightExternalEarSubjective = mock
				.strings()
				.get();
		newEntity.setRightExternalEarSubjective(randomStringforRightExternalEarSubjective);
		// % protected region % [Add customisation for Right External Ear Subjective here] end
		// % protected region % [Add customisation for Right External Ear Objective here] off begin
		String randomStringforRightExternalEarObjective = mock
				.strings()
				.get();
		newEntity.setRightExternalEarObjective(randomStringforRightExternalEarObjective);
		// % protected region % [Add customisation for Right External Ear Objective here] end
		// % protected region % [Add customisation for Right Concha Subjective here] off begin
		String randomStringforRightConchaSubjective = mock
				.strings()
				.get();
		newEntity.setRightConchaSubjective(randomStringforRightConchaSubjective);
		// % protected region % [Add customisation for Right Concha Subjective here] end
		// % protected region % [Add customisation for Right Concha Objective here] off begin
		String randomStringforRightConchaObjective = mock
				.strings()
				.get();
		newEntity.setRightConchaObjective(randomStringforRightConchaObjective);
		// % protected region % [Add customisation for Right Concha Objective here] end
		// % protected region % [Add customisation for Right Earlobe Subjective here] off begin
		String randomStringforRightEarlobeSubjective = mock
				.strings()
				.get();
		newEntity.setRightEarlobeSubjective(randomStringforRightEarlobeSubjective);
		// % protected region % [Add customisation for Right Earlobe Subjective here] end
		// % protected region % [Add customisation for Right Earlobe Objective here] off begin
		String randomStringforRightEarlobeObjective = mock
				.strings()
				.get();
		newEntity.setRightEarlobeObjective(randomStringforRightEarlobeObjective);
		// % protected region % [Add customisation for Right Earlobe Objective here] end
		// % protected region % [Add customisation for Right Ear Canal Subjective here] off begin
		String randomStringforRightEarCanalSubjective = mock
				.strings()
				.get();
		newEntity.setRightEarCanalSubjective(randomStringforRightEarCanalSubjective);
		// % protected region % [Add customisation for Right Ear Canal Subjective here] end
		// % protected region % [Add customisation for Right Ear Canal Objective here] off begin
		String randomStringforRightEarCanalObjective = mock
				.strings()
				.get();
		newEntity.setRightEarCanalObjective(randomStringforRightEarCanalObjective);
		// % protected region % [Add customisation for Right Ear Canal Objective here] end
		// % protected region % [Add customisation for Right Eardrum Subjective here] off begin
		String randomStringforRightEardrumSubjective = mock
				.strings()
				.get();
		newEntity.setRightEardrumSubjective(randomStringforRightEardrumSubjective);
		// % protected region % [Add customisation for Right Eardrum Subjective here] end
		// % protected region % [Add customisation for Right Eardrum Objective here] off begin
		String randomStringforRightEardrumObjective = mock
				.strings()
				.get();
		newEntity.setRightEardrumObjective(randomStringforRightEardrumObjective);
		// % protected region % [Add customisation for Right Eardrum Objective here] end
		// % protected region % [Add customisation for Left External Ear Subjective here] off begin
		String randomStringforLeftExternalEarSubjective = mock
				.strings()
				.get();
		newEntity.setLeftExternalEarSubjective(randomStringforLeftExternalEarSubjective);
		// % protected region % [Add customisation for Left External Ear Subjective here] end
		// % protected region % [Add customisation for Left External Ear Objective here] off begin
		String randomStringforLeftExternalEarObjective = mock
				.strings()
				.get();
		newEntity.setLeftExternalEarObjective(randomStringforLeftExternalEarObjective);
		// % protected region % [Add customisation for Left External Ear Objective here] end
		// % protected region % [Add customisation for Left Concha Subjective here] off begin
		String randomStringforLeftConchaSubjective = mock
				.strings()
				.get();
		newEntity.setLeftConchaSubjective(randomStringforLeftConchaSubjective);
		// % protected region % [Add customisation for Left Concha Subjective here] end
		// % protected region % [Add customisation for Left Concha Objective here] off begin
		String randomStringforLeftConchaObjective = mock
				.strings()
				.get();
		newEntity.setLeftConchaObjective(randomStringforLeftConchaObjective);
		// % protected region % [Add customisation for Left Concha Objective here] end
		// % protected region % [Add customisation for Left Earlobe Subjective here] off begin
		String randomStringforLeftEarlobeSubjective = mock
				.strings()
				.get();
		newEntity.setLeftEarlobeSubjective(randomStringforLeftEarlobeSubjective);
		// % protected region % [Add customisation for Left Earlobe Subjective here] end
		// % protected region % [Add customisation for Left Earlobe Objective here] off begin
		String randomStringforLeftEarlobeObjective = mock
				.strings()
				.get();
		newEntity.setLeftEarlobeObjective(randomStringforLeftEarlobeObjective);
		// % protected region % [Add customisation for Left Earlobe Objective here] end
		// % protected region % [Add customisation for Left Ear Canal Subjective here] off begin
		String randomStringforLeftEarCanalSubjective = mock
				.strings()
				.get();
		newEntity.setLeftEarCanalSubjective(randomStringforLeftEarCanalSubjective);
		// % protected region % [Add customisation for Left Ear Canal Subjective here] end
		// % protected region % [Add customisation for Left Ear Canal Objective here] off begin
		String randomStringforLeftEarCanalObjective = mock
				.strings()
				.get();
		newEntity.setLeftEarCanalObjective(randomStringforLeftEarCanalObjective);
		// % protected region % [Add customisation for Left Ear Canal Objective here] end
		// % protected region % [Add customisation for Left Eardrum Subjective here] off begin
		String randomStringforLeftEardrumSubjective = mock
				.strings()
				.get();
		newEntity.setLeftEardrumSubjective(randomStringforLeftEardrumSubjective);
		// % protected region % [Add customisation for Left Eardrum Subjective here] end
		// % protected region % [Add customisation for Left Eardrum Objective here] off begin
		String randomStringforLeftEardrumObjective = mock
				.strings()
				.get();
		newEntity.setLeftEardrumObjective(randomStringforLeftEardrumObjective);
		// % protected region % [Add customisation for Left Eardrum Objective here] end
		// % protected region % [Add customisation for Nasal Bone Subjective here] off begin
		String randomStringforNasalBoneSubjective = mock
				.strings()
				.get();
		newEntity.setNasalBoneSubjective(randomStringforNasalBoneSubjective);
		// % protected region % [Add customisation for Nasal Bone Subjective here] end
		// % protected region % [Add customisation for Nasal Bone Objective here] off begin
		String randomStringforNasalBoneObjective = mock
				.strings()
				.get();
		newEntity.setNasalBoneObjective(randomStringforNasalBoneObjective);
		// % protected region % [Add customisation for Nasal Bone Objective here] end
		// % protected region % [Add customisation for Right Frontal Sinus Subjective here] off begin
		String randomStringforRightFrontalSinusSubjective = mock
				.strings()
				.get();
		newEntity.setRightFrontalSinusSubjective(randomStringforRightFrontalSinusSubjective);
		// % protected region % [Add customisation for Right Frontal Sinus Subjective here] end
		// % protected region % [Add customisation for Right Frontal Sinus Objective here] off begin
		String randomStringforRightFrontalSinusObjective = mock
				.strings()
				.get();
		newEntity.setRightFrontalSinusObjective(randomStringforRightFrontalSinusObjective);
		// % protected region % [Add customisation for Right Frontal Sinus Objective here] end
		// % protected region % [Add customisation for Right Ethmoid Sinus Subjective here] off begin
		String randomStringforRightEthmoidSinusSubjective = mock
				.strings()
				.get();
		newEntity.setRightEthmoidSinusSubjective(randomStringforRightEthmoidSinusSubjective);
		// % protected region % [Add customisation for Right Ethmoid Sinus Subjective here] end
		// % protected region % [Add customisation for Right Ethmoid Sinus Objective here] off begin
		String randomStringforRightEthmoidSinusObjective = mock
				.strings()
				.get();
		newEntity.setRightEthmoidSinusObjective(randomStringforRightEthmoidSinusObjective);
		// % protected region % [Add customisation for Right Ethmoid Sinus Objective here] end
		// % protected region % [Add customisation for Right Superior Turbinate Subjective here] off begin
		String randomStringforRightSuperiorTurbinateSubjective = mock
				.strings()
				.get();
		newEntity.setRightSuperiorTurbinateSubjective(randomStringforRightSuperiorTurbinateSubjective);
		// % protected region % [Add customisation for Right Superior Turbinate Subjective here] end
		// % protected region % [Add customisation for Right Superior Turbinate Objective here] off begin
		String randomStringforRightSuperiorTurbinateObjective = mock
				.strings()
				.get();
		newEntity.setRightSuperiorTurbinateObjective(randomStringforRightSuperiorTurbinateObjective);
		// % protected region % [Add customisation for Right Superior Turbinate Objective here] end
		// % protected region % [Add customisation for Right Middle Turbinate Subjective here] off begin
		String randomStringforRightMiddleTurbinateSubjective = mock
				.strings()
				.get();
		newEntity.setRightMiddleTurbinateSubjective(randomStringforRightMiddleTurbinateSubjective);
		// % protected region % [Add customisation for Right Middle Turbinate Subjective here] end
		// % protected region % [Add customisation for Right Middle Turbinate Objective here] off begin
		String randomStringforRightMiddleTurbinateObjective = mock
				.strings()
				.get();
		newEntity.setRightMiddleTurbinateObjective(randomStringforRightMiddleTurbinateObjective);
		// % protected region % [Add customisation for Right Middle Turbinate Objective here] end
		// % protected region % [Add customisation for Right Maxillary Sinus Subjective here] off begin
		String randomStringforRightMaxillarySinusSubjective = mock
				.strings()
				.get();
		newEntity.setRightMaxillarySinusSubjective(randomStringforRightMaxillarySinusSubjective);
		// % protected region % [Add customisation for Right Maxillary Sinus Subjective here] end
		// % protected region % [Add customisation for Right Maxillary Sinus Objective here] off begin
		String randomStringforRightMaxillarySinusObjective = mock
				.strings()
				.get();
		newEntity.setRightMaxillarySinusObjective(randomStringforRightMaxillarySinusObjective);
		// % protected region % [Add customisation for Right Maxillary Sinus Objective here] end
		// % protected region % [Add customisation for Right Nasal Cavity Subjective here] off begin
		String randomStringforRightNasalCavitySubjective = mock
				.strings()
				.get();
		newEntity.setRightNasalCavitySubjective(randomStringforRightNasalCavitySubjective);
		// % protected region % [Add customisation for Right Nasal Cavity Subjective here] end
		// % protected region % [Add customisation for Right Nasal Cavity Objective here] off begin
		String randomStringforRightNasalCavityObjective = mock
				.strings()
				.get();
		newEntity.setRightNasalCavityObjective(randomStringforRightNasalCavityObjective);
		// % protected region % [Add customisation for Right Nasal Cavity Objective here] end
		// % protected region % [Add customisation for Right Inferior Turbinate Subjective here] off begin
		String randomStringforRightInferiorTurbinateSubjective = mock
				.strings()
				.get();
		newEntity.setRightInferiorTurbinateSubjective(randomStringforRightInferiorTurbinateSubjective);
		// % protected region % [Add customisation for Right Inferior Turbinate Subjective here] end
		// % protected region % [Add customisation for Right Inferior Turbinate Objective here] off begin
		String randomStringforRightInferiorTurbinateObjective = mock
				.strings()
				.get();
		newEntity.setRightInferiorTurbinateObjective(randomStringforRightInferiorTurbinateObjective);
		// % protected region % [Add customisation for Right Inferior Turbinate Objective here] end
		// % protected region % [Add customisation for Left Frontal Sinus Subjective here] off begin
		String randomStringforLeftFrontalSinusSubjective = mock
				.strings()
				.get();
		newEntity.setLeftFrontalSinusSubjective(randomStringforLeftFrontalSinusSubjective);
		// % protected region % [Add customisation for Left Frontal Sinus Subjective here] end
		// % protected region % [Add customisation for Left Frontal Sinus Objective here] off begin
		String randomStringforLeftFrontalSinusObjective = mock
				.strings()
				.get();
		newEntity.setLeftFrontalSinusObjective(randomStringforLeftFrontalSinusObjective);
		// % protected region % [Add customisation for Left Frontal Sinus Objective here] end
		// % protected region % [Add customisation for Left Ethmoid Sinus Subjective here] off begin
		String randomStringforLeftEthmoidSinusSubjective = mock
				.strings()
				.get();
		newEntity.setLeftEthmoidSinusSubjective(randomStringforLeftEthmoidSinusSubjective);
		// % protected region % [Add customisation for Left Ethmoid Sinus Subjective here] end
		// % protected region % [Add customisation for Left Ethmoid Sinus Objective here] off begin
		String randomStringforLeftEthmoidSinusObjective = mock
				.strings()
				.get();
		newEntity.setLeftEthmoidSinusObjective(randomStringforLeftEthmoidSinusObjective);
		// % protected region % [Add customisation for Left Ethmoid Sinus Objective here] end
		// % protected region % [Add customisation for Left Superior Turbinate Subjective here] off begin
		String randomStringforLeftSuperiorTurbinateSubjective = mock
				.strings()
				.get();
		newEntity.setLeftSuperiorTurbinateSubjective(randomStringforLeftSuperiorTurbinateSubjective);
		// % protected region % [Add customisation for Left Superior Turbinate Subjective here] end
		// % protected region % [Add customisation for Left Superior Turbinate Objective here] off begin
		String randomStringforLeftSuperiorTurbinateObjective = mock
				.strings()
				.get();
		newEntity.setLeftSuperiorTurbinateObjective(randomStringforLeftSuperiorTurbinateObjective);
		// % protected region % [Add customisation for Left Superior Turbinate Objective here] end
		// % protected region % [Add customisation for Left Middle Turbinate Subjective here] off begin
		String randomStringforLeftMiddleTurbinateSubjective = mock
				.strings()
				.get();
		newEntity.setLeftMiddleTurbinateSubjective(randomStringforLeftMiddleTurbinateSubjective);
		// % protected region % [Add customisation for Left Middle Turbinate Subjective here] end
		// % protected region % [Add customisation for Left Middle Turbinate Objective here] off begin
		String randomStringforLeftMiddleTurbinateObjective = mock
				.strings()
				.get();
		newEntity.setLeftMiddleTurbinateObjective(randomStringforLeftMiddleTurbinateObjective);
		// % protected region % [Add customisation for Left Middle Turbinate Objective here] end
		// % protected region % [Add customisation for Left Maxillary Sinus Subjective here] off begin
		String randomStringforLeftMaxillarySinusSubjective = mock
				.strings()
				.get();
		newEntity.setLeftMaxillarySinusSubjective(randomStringforLeftMaxillarySinusSubjective);
		// % protected region % [Add customisation for Left Maxillary Sinus Subjective here] end
		// % protected region % [Add customisation for Left Maxillary Sinus Objective here] off begin
		String randomStringforLeftMaxillarySinusObjective = mock
				.strings()
				.get();
		newEntity.setLeftMaxillarySinusObjective(randomStringforLeftMaxillarySinusObjective);
		// % protected region % [Add customisation for Left Maxillary Sinus Objective here] end
		// % protected region % [Add customisation for Left Nasal Cavity Subjective here] off begin
		String randomStringforLeftNasalCavitySubjective = mock
				.strings()
				.get();
		newEntity.setLeftNasalCavitySubjective(randomStringforLeftNasalCavitySubjective);
		// % protected region % [Add customisation for Left Nasal Cavity Subjective here] end
		// % protected region % [Add customisation for Left Nasal Cavity Objective here] off begin
		String randomStringforLeftNasalCavityObjective = mock
				.strings()
				.get();
		newEntity.setLeftNasalCavityObjective(randomStringforLeftNasalCavityObjective);
		// % protected region % [Add customisation for Left Nasal Cavity Objective here] end
		// % protected region % [Add customisation for Left Inferior Turbinate Subjective here] off begin
		String randomStringforLeftInferiorTurbinateSubjective = mock
				.strings()
				.get();
		newEntity.setLeftInferiorTurbinateSubjective(randomStringforLeftInferiorTurbinateSubjective);
		// % protected region % [Add customisation for Left Inferior Turbinate Subjective here] end
		// % protected region % [Add customisation for Left Inferior Turbinate Objective here] off begin
		String randomStringforLeftInferiorTurbinateObjective = mock
				.strings()
				.get();
		newEntity.setLeftInferiorTurbinateObjective(randomStringforLeftInferiorTurbinateObjective);
		// % protected region % [Add customisation for Left Inferior Turbinate Objective here] end
		// % protected region % [Add customisation for Lingual Tonsil Subjective here] off begin
		String randomStringforLingualTonsilSubjective = mock
				.strings()
				.get();
		newEntity.setLingualTonsilSubjective(randomStringforLingualTonsilSubjective);
		// % protected region % [Add customisation for Lingual Tonsil Subjective here] end
		// % protected region % [Add customisation for Lingual Tonsil Objective here] off begin
		String randomStringforLingualTonsilObjective = mock
				.strings()
				.get();
		newEntity.setLingualTonsilObjective(randomStringforLingualTonsilObjective);
		// % protected region % [Add customisation for Lingual Tonsil Objective here] end
		// % protected region % [Add customisation for Epiglottis Subjective here] off begin
		String randomStringforEpiglottisSubjective = mock
				.strings()
				.get();
		newEntity.setEpiglottisSubjective(randomStringforEpiglottisSubjective);
		// % protected region % [Add customisation for Epiglottis Subjective here] end
		// % protected region % [Add customisation for Epiglottis Objective here] off begin
		String randomStringforEpiglottisObjective = mock
				.strings()
				.get();
		newEntity.setEpiglottisObjective(randomStringforEpiglottisObjective);
		// % protected region % [Add customisation for Epiglottis Objective here] end
		// % protected region % [Add customisation for Right Vocal Fold Subjective here] off begin
		String randomStringforRightVocalFoldSubjective = mock
				.strings()
				.get();
		newEntity.setRightVocalFoldSubjective(randomStringforRightVocalFoldSubjective);
		// % protected region % [Add customisation for Right Vocal Fold Subjective here] end
		// % protected region % [Add customisation for Right Vocal Fold Objective here] off begin
		String randomStringforRightVocalFoldObjective = mock
				.strings()
				.get();
		newEntity.setRightVocalFoldObjective(randomStringforRightVocalFoldObjective);
		// % protected region % [Add customisation for Right Vocal Fold Objective here] end
		// % protected region % [Add customisation for Right Ventricular Fold Subjective here] off begin
		String randomStringforRightVentricularFoldSubjective = mock
				.strings()
				.get();
		newEntity.setRightVentricularFoldSubjective(randomStringforRightVentricularFoldSubjective);
		// % protected region % [Add customisation for Right Ventricular Fold Subjective here] end
		// % protected region % [Add customisation for Right Ventricular Fold Objective here] off begin
		String randomStringforRightVentricularFoldObjective = mock
				.strings()
				.get();
		newEntity.setRightVentricularFoldObjective(randomStringforRightVentricularFoldObjective);
		// % protected region % [Add customisation for Right Ventricular Fold Objective here] end
		// % protected region % [Add customisation for Glottis Subjective here] off begin
		String randomStringforGlottisSubjective = mock
				.strings()
				.get();
		newEntity.setGlottisSubjective(randomStringforGlottisSubjective);
		// % protected region % [Add customisation for Glottis Subjective here] end
		// % protected region % [Add customisation for Glottis Objective here] off begin
		String randomStringforGlottisObjective = mock
				.strings()
				.get();
		newEntity.setGlottisObjective(randomStringforGlottisObjective);
		// % protected region % [Add customisation for Glottis Objective here] end
		// % protected region % [Add customisation for Right Cuneiform Cartilage Subjective here] off begin
		String randomStringforRightCuneiformCartilageSubjective = mock
				.strings()
				.get();
		newEntity.setRightCuneiformCartilageSubjective(randomStringforRightCuneiformCartilageSubjective);
		// % protected region % [Add customisation for Right Cuneiform Cartilage Subjective here] end
		// % protected region % [Add customisation for Right Cuneiform Cartilage Objective here] off begin
		String randomStringforRightCuneiformCartilageObjective = mock
				.strings()
				.get();
		newEntity.setRightCuneiformCartilageObjective(randomStringforRightCuneiformCartilageObjective);
		// % protected region % [Add customisation for Right Cuneiform Cartilage Objective here] end
		// % protected region % [Add customisation for Right Corniculate Cartilage Subjective here] off begin
		String randomStringforRightCorniculateCartilageSubjective = mock
				.strings()
				.get();
		newEntity.setRightCorniculateCartilageSubjective(randomStringforRightCorniculateCartilageSubjective);
		// % protected region % [Add customisation for Right Corniculate Cartilage Subjective here] end
		// % protected region % [Add customisation for Right Corniculate Cartilage Objective here] off begin
		String randomStringforRightCorniculateCartilageObjective = mock
				.strings()
				.get();
		newEntity.setRightCorniculateCartilageObjective(randomStringforRightCorniculateCartilageObjective);
		// % protected region % [Add customisation for Right Corniculate Cartilage Objective here] end
		// % protected region % [Add customisation for Trachea Subjective here] off begin
		String randomStringforTracheaSubjective = mock
				.strings()
				.get();
		newEntity.setTracheaSubjective(randomStringforTracheaSubjective);
		// % protected region % [Add customisation for Trachea Subjective here] end
		// % protected region % [Add customisation for Trachea Objective here] off begin
		String randomStringforTracheaObjective = mock
				.strings()
				.get();
		newEntity.setTracheaObjective(randomStringforTracheaObjective);
		// % protected region % [Add customisation for Trachea Objective here] end
		// % protected region % [Add customisation for Left Vocal Fold Subjective here] off begin
		String randomStringforLeftVocalFoldSubjective = mock
				.strings()
				.get();
		newEntity.setLeftVocalFoldSubjective(randomStringforLeftVocalFoldSubjective);
		// % protected region % [Add customisation for Left Vocal Fold Subjective here] end
		// % protected region % [Add customisation for Left Vocal Fold Objective here] off begin
		String randomStringforLeftVocalFoldObjective = mock
				.strings()
				.get();
		newEntity.setLeftVocalFoldObjective(randomStringforLeftVocalFoldObjective);
		// % protected region % [Add customisation for Left Vocal Fold Objective here] end
		// % protected region % [Add customisation for Left Ventricular Fold Subjective here] off begin
		String randomStringforLeftVentricularFoldSubjective = mock
				.strings()
				.get();
		newEntity.setLeftVentricularFoldSubjective(randomStringforLeftVentricularFoldSubjective);
		// % protected region % [Add customisation for Left Ventricular Fold Subjective here] end
		// % protected region % [Add customisation for Left Ventricular Fold Objective here] off begin
		String randomStringforLeftVentricularFoldObjective = mock
				.strings()
				.get();
		newEntity.setLeftVentricularFoldObjective(randomStringforLeftVentricularFoldObjective);
		// % protected region % [Add customisation for Left Ventricular Fold Objective here] end
		// % protected region % [Add customisation for Left Cuneiform Cartilage Subjective here] off begin
		String randomStringforLeftCuneiformCartilageSubjective = mock
				.strings()
				.get();
		newEntity.setLeftCuneiformCartilageSubjective(randomStringforLeftCuneiformCartilageSubjective);
		// % protected region % [Add customisation for Left Cuneiform Cartilage Subjective here] end
		// % protected region % [Add customisation for Left Cuneiform Cartilage Objective here] off begin
		String randomStringforLeftCuneiformCartilageObjective = mock
				.strings()
				.get();
		newEntity.setLeftCuneiformCartilageObjective(randomStringforLeftCuneiformCartilageObjective);
		// % protected region % [Add customisation for Left Cuneiform Cartilage Objective here] end
		// % protected region % [Add customisation for Left Corniculate Cartilage Subjective here] off begin
		String randomStringforLeftCorniculateCartilageSubjective = mock
				.strings()
				.get();
		newEntity.setLeftCorniculateCartilageSubjective(randomStringforLeftCorniculateCartilageSubjective);
		// % protected region % [Add customisation for Left Corniculate Cartilage Subjective here] end
		// % protected region % [Add customisation for Left Corniculate Cartilage Objective here] off begin
		String randomStringforLeftCorniculateCartilageObjective = mock
				.strings()
				.get();
		newEntity.setLeftCorniculateCartilageObjective(randomStringforLeftCorniculateCartilageObjective);
		// % protected region % [Add customisation for Left Corniculate Cartilage Objective here] end
		// % protected region % [Add customisation for Soft Palate Subjective here] off begin
		String randomStringforSoftPalateSubjective = mock
				.strings()
				.get();
		newEntity.setSoftPalateSubjective(randomStringforSoftPalateSubjective);
		// % protected region % [Add customisation for Soft Palate Subjective here] end
		// % protected region % [Add customisation for Soft Palate Objective here] off begin
		String randomStringforSoftPalateObjective = mock
				.strings()
				.get();
		newEntity.setSoftPalateObjective(randomStringforSoftPalateObjective);
		// % protected region % [Add customisation for Soft Palate Objective here] end
		// % protected region % [Add customisation for Right Anterior Pillar Subjective here] off begin
		String randomStringforRightAnteriorPillarSubjective = mock
				.strings()
				.get();
		newEntity.setRightAnteriorPillarSubjective(randomStringforRightAnteriorPillarSubjective);
		// % protected region % [Add customisation for Right Anterior Pillar Subjective here] end
		// % protected region % [Add customisation for Right Anterior Pillar Objective here] off begin
		String randomStringforRightAnteriorPillarObjective = mock
				.strings()
				.get();
		newEntity.setRightAnteriorPillarObjective(randomStringforRightAnteriorPillarObjective);
		// % protected region % [Add customisation for Right Anterior Pillar Objective here] end
		// % protected region % [Add customisation for Uvula Subjective here] off begin
		String randomStringforUvulaSubjective = mock
				.strings()
				.get();
		newEntity.setUvulaSubjective(randomStringforUvulaSubjective);
		// % protected region % [Add customisation for Uvula Subjective here] end
		// % protected region % [Add customisation for Uvula Objective here] off begin
		String randomStringforUvulaObjective = mock
				.strings()
				.get();
		newEntity.setUvulaObjective(randomStringforUvulaObjective);
		// % protected region % [Add customisation for Uvula Objective here] end
		// % protected region % [Add customisation for Right Posterior Pillar Subjective here] off begin
		String randomStringforRightPosteriorPillarSubjective = mock
				.strings()
				.get();
		newEntity.setRightPosteriorPillarSubjective(randomStringforRightPosteriorPillarSubjective);
		// % protected region % [Add customisation for Right Posterior Pillar Subjective here] end
		// % protected region % [Add customisation for Right Posterior Pillar Objective here] off begin
		String randomStringforRightPosteriorPillarObjective = mock
				.strings()
				.get();
		newEntity.setRightPosteriorPillarObjective(randomStringforRightPosteriorPillarObjective);
		// % protected region % [Add customisation for Right Posterior Pillar Objective here] end
		// % protected region % [Add customisation for Right Tonsil Subjective here] off begin
		String randomStringforRightTonsilSubjective = mock
				.strings()
				.get();
		newEntity.setRightTonsilSubjective(randomStringforRightTonsilSubjective);
		// % protected region % [Add customisation for Right Tonsil Subjective here] end
		// % protected region % [Add customisation for Right Tonsil Objective here] off begin
		String randomStringforRightTonsilObjective = mock
				.strings()
				.get();
		newEntity.setRightTonsilObjective(randomStringforRightTonsilObjective);
		// % protected region % [Add customisation for Right Tonsil Objective here] end
		// % protected region % [Add customisation for Right Posterior Subjective here] off begin
		String randomStringforRightPosteriorSubjective = mock
				.strings()
				.get();
		newEntity.setRightPosteriorSubjective(randomStringforRightPosteriorSubjective);
		// % protected region % [Add customisation for Right Posterior Subjective here] end
		// % protected region % [Add customisation for Right Posterior Objective here] off begin
		String randomStringforRightPosteriorObjective = mock
				.strings()
				.get();
		newEntity.setRightPosteriorObjective(randomStringforRightPosteriorObjective);
		// % protected region % [Add customisation for Right Posterior Objective here] end
		// % protected region % [Add customisation for Upper Tongue Subjective here] off begin
		String randomStringforUpperTongueSubjective = mock
				.strings()
				.get();
		newEntity.setUpperTongueSubjective(randomStringforUpperTongueSubjective);
		// % protected region % [Add customisation for Upper Tongue Subjective here] end
		// % protected region % [Add customisation for Upper Tongue Objective here] off begin
		String randomStringforUpperTongueObjective = mock
				.strings()
				.get();
		newEntity.setUpperTongueObjective(randomStringforUpperTongueObjective);
		// % protected region % [Add customisation for Upper Tongue Objective here] end
		// % protected region % [Add customisation for Left Anterior Pillar Subjective here] off begin
		String randomStringforLeftAnteriorPillarSubjective = mock
				.strings()
				.get();
		newEntity.setLeftAnteriorPillarSubjective(randomStringforLeftAnteriorPillarSubjective);
		// % protected region % [Add customisation for Left Anterior Pillar Subjective here] end
		// % protected region % [Add customisation for Left Anterior Pillar Objective here] off begin
		String randomStringforLeftAnteriorPillarObjective = mock
				.strings()
				.get();
		newEntity.setLeftAnteriorPillarObjective(randomStringforLeftAnteriorPillarObjective);
		// % protected region % [Add customisation for Left Anterior Pillar Objective here] end
		// % protected region % [Add customisation for Left Posterior Pillar Subjective here] off begin
		String randomStringforLeftPosteriorPillarSubjective = mock
				.strings()
				.get();
		newEntity.setLeftPosteriorPillarSubjective(randomStringforLeftPosteriorPillarSubjective);
		// % protected region % [Add customisation for Left Posterior Pillar Subjective here] end
		// % protected region % [Add customisation for Left Posterior Pillar Objective here] off begin
		String randomStringforLeftPosteriorPillarObjective = mock
				.strings()
				.get();
		newEntity.setLeftPosteriorPillarObjective(randomStringforLeftPosteriorPillarObjective);
		// % protected region % [Add customisation for Left Posterior Pillar Objective here] end
		// % protected region % [Add customisation for Left Tonsil Subjective here] off begin
		String randomStringforLeftTonsilSubjective = mock
				.strings()
				.get();
		newEntity.setLeftTonsilSubjective(randomStringforLeftTonsilSubjective);
		// % protected region % [Add customisation for Left Tonsil Subjective here] end
		// % protected region % [Add customisation for Left Tonsil Objective here] off begin
		String randomStringforLeftTonsilObjective = mock
				.strings()
				.get();
		newEntity.setLeftTonsilObjective(randomStringforLeftTonsilObjective);
		// % protected region % [Add customisation for Left Tonsil Objective here] end
		// % protected region % [Add customisation for Left Posterior Wall Subjective here] off begin
		String randomStringforLeftPosteriorWallSubjective = mock
				.strings()
				.get();
		newEntity.setLeftPosteriorWallSubjective(randomStringforLeftPosteriorWallSubjective);
		// % protected region % [Add customisation for Left Posterior Wall Subjective here] end
		// % protected region % [Add customisation for Left Posterior Wall Objective here] off begin
		String randomStringforLeftPosteriorWallObjective = mock
				.strings()
				.get();
		newEntity.setLeftPosteriorWallObjective(randomStringforLeftPosteriorWallObjective);
		// % protected region % [Add customisation for Left Posterior Wall Objective here] end

		// % protected region % [Apply any additional logic for entExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationWithNoRef after the main body here] end

		log.trace("Created entity of type EntExaminationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of ENT Examination entities with no reference at all.
	 */
	@Provides
	@Named("entExaminationEntitiesWithNoRef")
	public Collection<EntExaminationEntity> entExaminationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for entExaminationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for entExaminationEntitiesWithNoRef here] end
		EntExaminationEntityFactory entExaminationEntityFactory
	) {
		log.trace("Creating entities of type EntExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for entExaminationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationEntitiesWithNoRef before the main body here] end

		Collection<EntExaminationEntity> newEntities = entExaminationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for entExaminationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type EntExaminationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a ENT Examination entity with all references set.
	 */
	@Provides
	@Named("entExaminationEntityWithRefs")
	public EntExaminationEntity entExaminationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for entExaminationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for entExaminationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type EntExaminationEntity with references");

		// % protected region % [Apply any additional logic for entExaminationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationEntityWithRefs before the main body here] end

		EntExaminationEntity entExaminationEntity = injector.getInstance(Key.get(EntExaminationEntity.class, Names.named("entExaminationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for entExaminationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationEntityWithRefs after the main body here] end

		log.trace("Created entity of type EntExaminationEntity with references");

		return entExaminationEntity;
	}

	/**
	 * Return a collection of ENT Examination entities with all references set.
	 */
	@Provides
	@Named("entExaminationEntitiesWithRefs")
	public Collection<EntExaminationEntity> entExaminationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for entExaminationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for entExaminationEntitiesWithRefs here] end
		EntExaminationEntityFactory entExaminationEntityFactory
	) {
		log.trace("Creating entities of type EntExaminationEntity with references");

		// % protected region % [Apply any additional logic for entExaminationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationEntitiesWithRefs before the main body here] end

		Collection<EntExaminationEntity> newEntities = entExaminationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for entExaminationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type EntExaminationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
