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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.EntExaminationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class EntExaminationFactory implements FactoryBean<EntExaminationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public EntExaminationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public EntExaminationEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public EntExaminationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for entExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationWithNoRef before the main body here] end

		EntExaminationEntity newEntity = new EntExaminationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Right External Ear Subjective here] off begin
		String randomStringForRightExternalEarSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightExternalEarSubjective(randomStringForRightExternalEarSubjective);
		// % protected region % [Add customisation for Right External Ear Subjective here] end
		// % protected region % [Add customisation for Right External Ear Objective here] off begin
		String randomStringForRightExternalEarObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightExternalEarObjective(randomStringForRightExternalEarObjective);
		// % protected region % [Add customisation for Right External Ear Objective here] end
		// % protected region % [Add customisation for Right Concha Subjective here] off begin
		String randomStringForRightConchaSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightConchaSubjective(randomStringForRightConchaSubjective);
		// % protected region % [Add customisation for Right Concha Subjective here] end
		// % protected region % [Add customisation for Right Concha Objective here] off begin
		String randomStringForRightConchaObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightConchaObjective(randomStringForRightConchaObjective);
		// % protected region % [Add customisation for Right Concha Objective here] end
		// % protected region % [Add customisation for Right Earlobe Subjective here] off begin
		String randomStringForRightEarlobeSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEarlobeSubjective(randomStringForRightEarlobeSubjective);
		// % protected region % [Add customisation for Right Earlobe Subjective here] end
		// % protected region % [Add customisation for Right Earlobe Objective here] off begin
		String randomStringForRightEarlobeObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEarlobeObjective(randomStringForRightEarlobeObjective);
		// % protected region % [Add customisation for Right Earlobe Objective here] end
		// % protected region % [Add customisation for Right Ear Canal Subjective here] off begin
		String randomStringForRightEarCanalSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEarCanalSubjective(randomStringForRightEarCanalSubjective);
		// % protected region % [Add customisation for Right Ear Canal Subjective here] end
		// % protected region % [Add customisation for Right Ear Canal Objective here] off begin
		String randomStringForRightEarCanalObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEarCanalObjective(randomStringForRightEarCanalObjective);
		// % protected region % [Add customisation for Right Ear Canal Objective here] end
		// % protected region % [Add customisation for Right Eardrum Subjective here] off begin
		String randomStringForRightEardrumSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEardrumSubjective(randomStringForRightEardrumSubjective);
		// % protected region % [Add customisation for Right Eardrum Subjective here] end
		// % protected region % [Add customisation for Right Eardrum Objective here] off begin
		String randomStringForRightEardrumObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEardrumObjective(randomStringForRightEardrumObjective);
		// % protected region % [Add customisation for Right Eardrum Objective here] end
		// % protected region % [Add customisation for Left External Ear Subjective here] off begin
		String randomStringForLeftExternalEarSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftExternalEarSubjective(randomStringForLeftExternalEarSubjective);
		// % protected region % [Add customisation for Left External Ear Subjective here] end
		// % protected region % [Add customisation for Left External Ear Objective here] off begin
		String randomStringForLeftExternalEarObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftExternalEarObjective(randomStringForLeftExternalEarObjective);
		// % protected region % [Add customisation for Left External Ear Objective here] end
		// % protected region % [Add customisation for Left Concha Subjective here] off begin
		String randomStringForLeftConchaSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftConchaSubjective(randomStringForLeftConchaSubjective);
		// % protected region % [Add customisation for Left Concha Subjective here] end
		// % protected region % [Add customisation for Left Concha Objective here] off begin
		String randomStringForLeftConchaObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftConchaObjective(randomStringForLeftConchaObjective);
		// % protected region % [Add customisation for Left Concha Objective here] end
		// % protected region % [Add customisation for Left Earlobe Subjective here] off begin
		String randomStringForLeftEarlobeSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEarlobeSubjective(randomStringForLeftEarlobeSubjective);
		// % protected region % [Add customisation for Left Earlobe Subjective here] end
		// % protected region % [Add customisation for Left Earlobe Objective here] off begin
		String randomStringForLeftEarlobeObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEarlobeObjective(randomStringForLeftEarlobeObjective);
		// % protected region % [Add customisation for Left Earlobe Objective here] end
		// % protected region % [Add customisation for Left Ear Canal Subjective here] off begin
		String randomStringForLeftEarCanalSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEarCanalSubjective(randomStringForLeftEarCanalSubjective);
		// % protected region % [Add customisation for Left Ear Canal Subjective here] end
		// % protected region % [Add customisation for Left Ear Canal Objective here] off begin
		String randomStringForLeftEarCanalObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEarCanalObjective(randomStringForLeftEarCanalObjective);
		// % protected region % [Add customisation for Left Ear Canal Objective here] end
		// % protected region % [Add customisation for Left Eardrum Subjective here] off begin
		String randomStringForLeftEardrumSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEardrumSubjective(randomStringForLeftEardrumSubjective);
		// % protected region % [Add customisation for Left Eardrum Subjective here] end
		// % protected region % [Add customisation for Left Eardrum Objective here] off begin
		String randomStringForLeftEardrumObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEardrumObjective(randomStringForLeftEardrumObjective);
		// % protected region % [Add customisation for Left Eardrum Objective here] end
		// % protected region % [Add customisation for Nasal Bone Subjective here] off begin
		String randomStringForNasalBoneSubjective = mockNeat
				.strings()
				.get();
		newEntity.setNasalBoneSubjective(randomStringForNasalBoneSubjective);
		// % protected region % [Add customisation for Nasal Bone Subjective here] end
		// % protected region % [Add customisation for Nasal Bone Objective here] off begin
		String randomStringForNasalBoneObjective = mockNeat
				.strings()
				.get();
		newEntity.setNasalBoneObjective(randomStringForNasalBoneObjective);
		// % protected region % [Add customisation for Nasal Bone Objective here] end
		// % protected region % [Add customisation for Right Frontal Sinus Subjective here] off begin
		String randomStringForRightFrontalSinusSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightFrontalSinusSubjective(randomStringForRightFrontalSinusSubjective);
		// % protected region % [Add customisation for Right Frontal Sinus Subjective here] end
		// % protected region % [Add customisation for Right Frontal Sinus Objective here] off begin
		String randomStringForRightFrontalSinusObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightFrontalSinusObjective(randomStringForRightFrontalSinusObjective);
		// % protected region % [Add customisation for Right Frontal Sinus Objective here] end
		// % protected region % [Add customisation for Right Ethmoid Sinus Subjective here] off begin
		String randomStringForRightEthmoidSinusSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEthmoidSinusSubjective(randomStringForRightEthmoidSinusSubjective);
		// % protected region % [Add customisation for Right Ethmoid Sinus Subjective here] end
		// % protected region % [Add customisation for Right Ethmoid Sinus Objective here] off begin
		String randomStringForRightEthmoidSinusObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEthmoidSinusObjective(randomStringForRightEthmoidSinusObjective);
		// % protected region % [Add customisation for Right Ethmoid Sinus Objective here] end
		// % protected region % [Add customisation for Right Superior Turbinate Subjective here] off begin
		String randomStringForRightSuperiorTurbinateSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightSuperiorTurbinateSubjective(randomStringForRightSuperiorTurbinateSubjective);
		// % protected region % [Add customisation for Right Superior Turbinate Subjective here] end
		// % protected region % [Add customisation for Right Superior Turbinate Objective here] off begin
		String randomStringForRightSuperiorTurbinateObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightSuperiorTurbinateObjective(randomStringForRightSuperiorTurbinateObjective);
		// % protected region % [Add customisation for Right Superior Turbinate Objective here] end
		// % protected region % [Add customisation for Right Middle Turbinate Subjective here] off begin
		String randomStringForRightMiddleTurbinateSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightMiddleTurbinateSubjective(randomStringForRightMiddleTurbinateSubjective);
		// % protected region % [Add customisation for Right Middle Turbinate Subjective here] end
		// % protected region % [Add customisation for Right Middle Turbinate Objective here] off begin
		String randomStringForRightMiddleTurbinateObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightMiddleTurbinateObjective(randomStringForRightMiddleTurbinateObjective);
		// % protected region % [Add customisation for Right Middle Turbinate Objective here] end
		// % protected region % [Add customisation for Right Maxillary Sinus Subjective here] off begin
		String randomStringForRightMaxillarySinusSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightMaxillarySinusSubjective(randomStringForRightMaxillarySinusSubjective);
		// % protected region % [Add customisation for Right Maxillary Sinus Subjective here] end
		// % protected region % [Add customisation for Right Maxillary Sinus Objective here] off begin
		String randomStringForRightMaxillarySinusObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightMaxillarySinusObjective(randomStringForRightMaxillarySinusObjective);
		// % protected region % [Add customisation for Right Maxillary Sinus Objective here] end
		// % protected region % [Add customisation for Right Nasal Cavity Subjective here] off begin
		String randomStringForRightNasalCavitySubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightNasalCavitySubjective(randomStringForRightNasalCavitySubjective);
		// % protected region % [Add customisation for Right Nasal Cavity Subjective here] end
		// % protected region % [Add customisation for Right Nasal Cavity Objective here] off begin
		String randomStringForRightNasalCavityObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightNasalCavityObjective(randomStringForRightNasalCavityObjective);
		// % protected region % [Add customisation for Right Nasal Cavity Objective here] end
		// % protected region % [Add customisation for Right Inferior Turbinate Subjective here] off begin
		String randomStringForRightInferiorTurbinateSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightInferiorTurbinateSubjective(randomStringForRightInferiorTurbinateSubjective);
		// % protected region % [Add customisation for Right Inferior Turbinate Subjective here] end
		// % protected region % [Add customisation for Right Inferior Turbinate Objective here] off begin
		String randomStringForRightInferiorTurbinateObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightInferiorTurbinateObjective(randomStringForRightInferiorTurbinateObjective);
		// % protected region % [Add customisation for Right Inferior Turbinate Objective here] end
		// % protected region % [Add customisation for Left Frontal Sinus Subjective here] off begin
		String randomStringForLeftFrontalSinusSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftFrontalSinusSubjective(randomStringForLeftFrontalSinusSubjective);
		// % protected region % [Add customisation for Left Frontal Sinus Subjective here] end
		// % protected region % [Add customisation for Left Frontal Sinus Objective here] off begin
		String randomStringForLeftFrontalSinusObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftFrontalSinusObjective(randomStringForLeftFrontalSinusObjective);
		// % protected region % [Add customisation for Left Frontal Sinus Objective here] end
		// % protected region % [Add customisation for Left Ethmoid Sinus Subjective here] off begin
		String randomStringForLeftEthmoidSinusSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEthmoidSinusSubjective(randomStringForLeftEthmoidSinusSubjective);
		// % protected region % [Add customisation for Left Ethmoid Sinus Subjective here] end
		// % protected region % [Add customisation for Left Ethmoid Sinus Objective here] off begin
		String randomStringForLeftEthmoidSinusObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEthmoidSinusObjective(randomStringForLeftEthmoidSinusObjective);
		// % protected region % [Add customisation for Left Ethmoid Sinus Objective here] end
		// % protected region % [Add customisation for Left Superior Turbinate Subjective here] off begin
		String randomStringForLeftSuperiorTurbinateSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftSuperiorTurbinateSubjective(randomStringForLeftSuperiorTurbinateSubjective);
		// % protected region % [Add customisation for Left Superior Turbinate Subjective here] end
		// % protected region % [Add customisation for Left Superior Turbinate Objective here] off begin
		String randomStringForLeftSuperiorTurbinateObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftSuperiorTurbinateObjective(randomStringForLeftSuperiorTurbinateObjective);
		// % protected region % [Add customisation for Left Superior Turbinate Objective here] end
		// % protected region % [Add customisation for Left Middle Turbinate Subjective here] off begin
		String randomStringForLeftMiddleTurbinateSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftMiddleTurbinateSubjective(randomStringForLeftMiddleTurbinateSubjective);
		// % protected region % [Add customisation for Left Middle Turbinate Subjective here] end
		// % protected region % [Add customisation for Left Middle Turbinate Objective here] off begin
		String randomStringForLeftMiddleTurbinateObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftMiddleTurbinateObjective(randomStringForLeftMiddleTurbinateObjective);
		// % protected region % [Add customisation for Left Middle Turbinate Objective here] end
		// % protected region % [Add customisation for Left Maxillary Sinus Subjective here] off begin
		String randomStringForLeftMaxillarySinusSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftMaxillarySinusSubjective(randomStringForLeftMaxillarySinusSubjective);
		// % protected region % [Add customisation for Left Maxillary Sinus Subjective here] end
		// % protected region % [Add customisation for Left Maxillary Sinus Objective here] off begin
		String randomStringForLeftMaxillarySinusObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftMaxillarySinusObjective(randomStringForLeftMaxillarySinusObjective);
		// % protected region % [Add customisation for Left Maxillary Sinus Objective here] end
		// % protected region % [Add customisation for Left Nasal Cavity Subjective here] off begin
		String randomStringForLeftNasalCavitySubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftNasalCavitySubjective(randomStringForLeftNasalCavitySubjective);
		// % protected region % [Add customisation for Left Nasal Cavity Subjective here] end
		// % protected region % [Add customisation for Left Nasal Cavity Objective here] off begin
		String randomStringForLeftNasalCavityObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftNasalCavityObjective(randomStringForLeftNasalCavityObjective);
		// % protected region % [Add customisation for Left Nasal Cavity Objective here] end
		// % protected region % [Add customisation for Left Inferior Turbinate Subjective here] off begin
		String randomStringForLeftInferiorTurbinateSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftInferiorTurbinateSubjective(randomStringForLeftInferiorTurbinateSubjective);
		// % protected region % [Add customisation for Left Inferior Turbinate Subjective here] end
		// % protected region % [Add customisation for Left Inferior Turbinate Objective here] off begin
		String randomStringForLeftInferiorTurbinateObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftInferiorTurbinateObjective(randomStringForLeftInferiorTurbinateObjective);
		// % protected region % [Add customisation for Left Inferior Turbinate Objective here] end
		// % protected region % [Add customisation for Lingual Tonsil Subjective here] off begin
		String randomStringForLingualTonsilSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLingualTonsilSubjective(randomStringForLingualTonsilSubjective);
		// % protected region % [Add customisation for Lingual Tonsil Subjective here] end
		// % protected region % [Add customisation for Lingual Tonsil Objective here] off begin
		String randomStringForLingualTonsilObjective = mockNeat
				.strings()
				.get();
		newEntity.setLingualTonsilObjective(randomStringForLingualTonsilObjective);
		// % protected region % [Add customisation for Lingual Tonsil Objective here] end
		// % protected region % [Add customisation for Epiglottis Subjective here] off begin
		String randomStringForEpiglottisSubjective = mockNeat
				.strings()
				.get();
		newEntity.setEpiglottisSubjective(randomStringForEpiglottisSubjective);
		// % protected region % [Add customisation for Epiglottis Subjective here] end
		// % protected region % [Add customisation for Epiglottis Objective here] off begin
		String randomStringForEpiglottisObjective = mockNeat
				.strings()
				.get();
		newEntity.setEpiglottisObjective(randomStringForEpiglottisObjective);
		// % protected region % [Add customisation for Epiglottis Objective here] end
		// % protected region % [Add customisation for Right Vocal Fold Subjective here] off begin
		String randomStringForRightVocalFoldSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightVocalFoldSubjective(randomStringForRightVocalFoldSubjective);
		// % protected region % [Add customisation for Right Vocal Fold Subjective here] end
		// % protected region % [Add customisation for Right Vocal Fold Objective here] off begin
		String randomStringForRightVocalFoldObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightVocalFoldObjective(randomStringForRightVocalFoldObjective);
		// % protected region % [Add customisation for Right Vocal Fold Objective here] end
		// % protected region % [Add customisation for Right Ventricular Fold Subjective here] off begin
		String randomStringForRightVentricularFoldSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightVentricularFoldSubjective(randomStringForRightVentricularFoldSubjective);
		// % protected region % [Add customisation for Right Ventricular Fold Subjective here] end
		// % protected region % [Add customisation for Right Ventricular Fold Objective here] off begin
		String randomStringForRightVentricularFoldObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightVentricularFoldObjective(randomStringForRightVentricularFoldObjective);
		// % protected region % [Add customisation for Right Ventricular Fold Objective here] end
		// % protected region % [Add customisation for Glottis Subjective here] off begin
		String randomStringForGlottisSubjective = mockNeat
				.strings()
				.get();
		newEntity.setGlottisSubjective(randomStringForGlottisSubjective);
		// % protected region % [Add customisation for Glottis Subjective here] end
		// % protected region % [Add customisation for Glottis Objective here] off begin
		String randomStringForGlottisObjective = mockNeat
				.strings()
				.get();
		newEntity.setGlottisObjective(randomStringForGlottisObjective);
		// % protected region % [Add customisation for Glottis Objective here] end
		// % protected region % [Add customisation for Right Cuneiform Cartilage Subjective here] off begin
		String randomStringForRightCuneiformCartilageSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightCuneiformCartilageSubjective(randomStringForRightCuneiformCartilageSubjective);
		// % protected region % [Add customisation for Right Cuneiform Cartilage Subjective here] end
		// % protected region % [Add customisation for Right Cuneiform Cartilage Objective here] off begin
		String randomStringForRightCuneiformCartilageObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightCuneiformCartilageObjective(randomStringForRightCuneiformCartilageObjective);
		// % protected region % [Add customisation for Right Cuneiform Cartilage Objective here] end
		// % protected region % [Add customisation for Right Corniculate Cartilage Subjective here] off begin
		String randomStringForRightCorniculateCartilageSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightCorniculateCartilageSubjective(randomStringForRightCorniculateCartilageSubjective);
		// % protected region % [Add customisation for Right Corniculate Cartilage Subjective here] end
		// % protected region % [Add customisation for Right Corniculate Cartilage Objective here] off begin
		String randomStringForRightCorniculateCartilageObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightCorniculateCartilageObjective(randomStringForRightCorniculateCartilageObjective);
		// % protected region % [Add customisation for Right Corniculate Cartilage Objective here] end
		// % protected region % [Add customisation for Trachea Subjective here] off begin
		String randomStringForTracheaSubjective = mockNeat
				.strings()
				.get();
		newEntity.setTracheaSubjective(randomStringForTracheaSubjective);
		// % protected region % [Add customisation for Trachea Subjective here] end
		// % protected region % [Add customisation for Trachea Objective here] off begin
		String randomStringForTracheaObjective = mockNeat
				.strings()
				.get();
		newEntity.setTracheaObjective(randomStringForTracheaObjective);
		// % protected region % [Add customisation for Trachea Objective here] end
		// % protected region % [Add customisation for Left Vocal Fold Subjective here] off begin
		String randomStringForLeftVocalFoldSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftVocalFoldSubjective(randomStringForLeftVocalFoldSubjective);
		// % protected region % [Add customisation for Left Vocal Fold Subjective here] end
		// % protected region % [Add customisation for Left Vocal Fold Objective here] off begin
		String randomStringForLeftVocalFoldObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftVocalFoldObjective(randomStringForLeftVocalFoldObjective);
		// % protected region % [Add customisation for Left Vocal Fold Objective here] end
		// % protected region % [Add customisation for Left Ventricular Fold Subjective here] off begin
		String randomStringForLeftVentricularFoldSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftVentricularFoldSubjective(randomStringForLeftVentricularFoldSubjective);
		// % protected region % [Add customisation for Left Ventricular Fold Subjective here] end
		// % protected region % [Add customisation for Left Ventricular Fold Objective here] off begin
		String randomStringForLeftVentricularFoldObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftVentricularFoldObjective(randomStringForLeftVentricularFoldObjective);
		// % protected region % [Add customisation for Left Ventricular Fold Objective here] end
		// % protected region % [Add customisation for Left Cuneiform Cartilage Subjective here] off begin
		String randomStringForLeftCuneiformCartilageSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftCuneiformCartilageSubjective(randomStringForLeftCuneiformCartilageSubjective);
		// % protected region % [Add customisation for Left Cuneiform Cartilage Subjective here] end
		// % protected region % [Add customisation for Left Cuneiform Cartilage Objective here] off begin
		String randomStringForLeftCuneiformCartilageObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftCuneiformCartilageObjective(randomStringForLeftCuneiformCartilageObjective);
		// % protected region % [Add customisation for Left Cuneiform Cartilage Objective here] end
		// % protected region % [Add customisation for Left Corniculate Cartilage Subjective here] off begin
		String randomStringForLeftCorniculateCartilageSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftCorniculateCartilageSubjective(randomStringForLeftCorniculateCartilageSubjective);
		// % protected region % [Add customisation for Left Corniculate Cartilage Subjective here] end
		// % protected region % [Add customisation for Left Corniculate Cartilage Objective here] off begin
		String randomStringForLeftCorniculateCartilageObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftCorniculateCartilageObjective(randomStringForLeftCorniculateCartilageObjective);
		// % protected region % [Add customisation for Left Corniculate Cartilage Objective here] end
		// % protected region % [Add customisation for Soft Palate Subjective here] off begin
		String randomStringForSoftPalateSubjective = mockNeat
				.strings()
				.get();
		newEntity.setSoftPalateSubjective(randomStringForSoftPalateSubjective);
		// % protected region % [Add customisation for Soft Palate Subjective here] end
		// % protected region % [Add customisation for Soft Palate Objective here] off begin
		String randomStringForSoftPalateObjective = mockNeat
				.strings()
				.get();
		newEntity.setSoftPalateObjective(randomStringForSoftPalateObjective);
		// % protected region % [Add customisation for Soft Palate Objective here] end
		// % protected region % [Add customisation for Right Anterior Pillar Subjective here] off begin
		String randomStringForRightAnteriorPillarSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightAnteriorPillarSubjective(randomStringForRightAnteriorPillarSubjective);
		// % protected region % [Add customisation for Right Anterior Pillar Subjective here] end
		// % protected region % [Add customisation for Right Anterior Pillar Objective here] off begin
		String randomStringForRightAnteriorPillarObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightAnteriorPillarObjective(randomStringForRightAnteriorPillarObjective);
		// % protected region % [Add customisation for Right Anterior Pillar Objective here] end
		// % protected region % [Add customisation for Uvula Subjective here] off begin
		String randomStringForUvulaSubjective = mockNeat
				.strings()
				.get();
		newEntity.setUvulaSubjective(randomStringForUvulaSubjective);
		// % protected region % [Add customisation for Uvula Subjective here] end
		// % protected region % [Add customisation for Uvula Objective here] off begin
		String randomStringForUvulaObjective = mockNeat
				.strings()
				.get();
		newEntity.setUvulaObjective(randomStringForUvulaObjective);
		// % protected region % [Add customisation for Uvula Objective here] end
		// % protected region % [Add customisation for Right Posterior Pillar Subjective here] off begin
		String randomStringForRightPosteriorPillarSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightPosteriorPillarSubjective(randomStringForRightPosteriorPillarSubjective);
		// % protected region % [Add customisation for Right Posterior Pillar Subjective here] end
		// % protected region % [Add customisation for Right Posterior Pillar Objective here] off begin
		String randomStringForRightPosteriorPillarObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightPosteriorPillarObjective(randomStringForRightPosteriorPillarObjective);
		// % protected region % [Add customisation for Right Posterior Pillar Objective here] end
		// % protected region % [Add customisation for Right Tonsil Subjective here] off begin
		String randomStringForRightTonsilSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightTonsilSubjective(randomStringForRightTonsilSubjective);
		// % protected region % [Add customisation for Right Tonsil Subjective here] end
		// % protected region % [Add customisation for Right Tonsil Objective here] off begin
		String randomStringForRightTonsilObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightTonsilObjective(randomStringForRightTonsilObjective);
		// % protected region % [Add customisation for Right Tonsil Objective here] end
		// % protected region % [Add customisation for Right Posterior Subjective here] off begin
		String randomStringForRightPosteriorSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightPosteriorSubjective(randomStringForRightPosteriorSubjective);
		// % protected region % [Add customisation for Right Posterior Subjective here] end
		// % protected region % [Add customisation for Right Posterior Objective here] off begin
		String randomStringForRightPosteriorObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightPosteriorObjective(randomStringForRightPosteriorObjective);
		// % protected region % [Add customisation for Right Posterior Objective here] end
		// % protected region % [Add customisation for Upper Tongue Subjective here] off begin
		String randomStringForUpperTongueSubjective = mockNeat
				.strings()
				.get();
		newEntity.setUpperTongueSubjective(randomStringForUpperTongueSubjective);
		// % protected region % [Add customisation for Upper Tongue Subjective here] end
		// % protected region % [Add customisation for Upper Tongue Objective here] off begin
		String randomStringForUpperTongueObjective = mockNeat
				.strings()
				.get();
		newEntity.setUpperTongueObjective(randomStringForUpperTongueObjective);
		// % protected region % [Add customisation for Upper Tongue Objective here] end
		// % protected region % [Add customisation for Left Anterior Pillar Subjective here] off begin
		String randomStringForLeftAnteriorPillarSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftAnteriorPillarSubjective(randomStringForLeftAnteriorPillarSubjective);
		// % protected region % [Add customisation for Left Anterior Pillar Subjective here] end
		// % protected region % [Add customisation for Left Anterior Pillar Objective here] off begin
		String randomStringForLeftAnteriorPillarObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftAnteriorPillarObjective(randomStringForLeftAnteriorPillarObjective);
		// % protected region % [Add customisation for Left Anterior Pillar Objective here] end
		// % protected region % [Add customisation for Left Posterior Pillar Subjective here] off begin
		String randomStringForLeftPosteriorPillarSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftPosteriorPillarSubjective(randomStringForLeftPosteriorPillarSubjective);
		// % protected region % [Add customisation for Left Posterior Pillar Subjective here] end
		// % protected region % [Add customisation for Left Posterior Pillar Objective here] off begin
		String randomStringForLeftPosteriorPillarObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftPosteriorPillarObjective(randomStringForLeftPosteriorPillarObjective);
		// % protected region % [Add customisation for Left Posterior Pillar Objective here] end
		// % protected region % [Add customisation for Left Tonsil Subjective here] off begin
		String randomStringForLeftTonsilSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftTonsilSubjective(randomStringForLeftTonsilSubjective);
		// % protected region % [Add customisation for Left Tonsil Subjective here] end
		// % protected region % [Add customisation for Left Tonsil Objective here] off begin
		String randomStringForLeftTonsilObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftTonsilObjective(randomStringForLeftTonsilObjective);
		// % protected region % [Add customisation for Left Tonsil Objective here] end
		// % protected region % [Add customisation for Left Posterior Wall Subjective here] off begin
		String randomStringForLeftPosteriorWallSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftPosteriorWallSubjective(randomStringForLeftPosteriorWallSubjective);
		// % protected region % [Add customisation for Left Posterior Wall Subjective here] end
		// % protected region % [Add customisation for Left Posterior Wall Objective here] off begin
		String randomStringForLeftPosteriorWallObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftPosteriorWallObjective(randomStringForLeftPosteriorWallObjective);
		// % protected region % [Add customisation for Left Posterior Wall Objective here] end

		// % protected region % [Apply any additional logic for entExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for entExaminationWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
		}

		// % protected region % [Apply any additional logic for entExamination with ref here] off begin
		// % protected region % [Apply any additional logic for entExamination with ref here] end

		return newEntity;
	}

	@Override
	public Class<EntExaminationEntity> getObjectType() {
		return EntExaminationEntity.class;
	}
}