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
package kmsweb.repositories;

import kmsweb.entities.EntExaminationEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface EntExaminationRepository extends AbstractRepository<EntExaminationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Right External Ear Subjective.
	 *
	 * @param rightExternalEarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right External Ear Subjective
	 */
	List<EntExaminationEntity> findByRightExternalEarSubjective(@NotNull String rightExternalEarSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right External Ear Objective.
	 *
	 * @param rightExternalEarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right External Ear Objective
	 */
	List<EntExaminationEntity> findByRightExternalEarObjective(@NotNull String rightExternalEarObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Concha Subjective.
	 *
	 * @param rightConchaSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Concha Subjective
	 */
	List<EntExaminationEntity> findByRightConchaSubjective(@NotNull String rightConchaSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Concha Objective.
	 *
	 * @param rightConchaObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Concha Objective
	 */
	List<EntExaminationEntity> findByRightConchaObjective(@NotNull String rightConchaObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Earlobe Subjective.
	 *
	 * @param rightEarlobeSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Earlobe Subjective
	 */
	List<EntExaminationEntity> findByRightEarlobeSubjective(@NotNull String rightEarlobeSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Earlobe Objective.
	 *
	 * @param rightEarlobeObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Earlobe Objective
	 */
	List<EntExaminationEntity> findByRightEarlobeObjective(@NotNull String rightEarlobeObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Ear Canal Subjective.
	 *
	 * @param rightEarCanalSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ear Canal Subjective
	 */
	List<EntExaminationEntity> findByRightEarCanalSubjective(@NotNull String rightEarCanalSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Ear Canal Objective.
	 *
	 * @param rightEarCanalObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ear Canal Objective
	 */
	List<EntExaminationEntity> findByRightEarCanalObjective(@NotNull String rightEarCanalObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Eardrum Subjective.
	 *
	 * @param rightEardrumSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Eardrum Subjective
	 */
	List<EntExaminationEntity> findByRightEardrumSubjective(@NotNull String rightEardrumSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Eardrum Objective.
	 *
	 * @param rightEardrumObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Eardrum Objective
	 */
	List<EntExaminationEntity> findByRightEardrumObjective(@NotNull String rightEardrumObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left External Ear Subjective.
	 *
	 * @param leftExternalEarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left External Ear Subjective
	 */
	List<EntExaminationEntity> findByLeftExternalEarSubjective(@NotNull String leftExternalEarSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left External Ear Objective.
	 *
	 * @param leftExternalEarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left External Ear Objective
	 */
	List<EntExaminationEntity> findByLeftExternalEarObjective(@NotNull String leftExternalEarObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Concha Subjective.
	 *
	 * @param leftConchaSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Concha Subjective
	 */
	List<EntExaminationEntity> findByLeftConchaSubjective(@NotNull String leftConchaSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Concha Objective.
	 *
	 * @param leftConchaObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Concha Objective
	 */
	List<EntExaminationEntity> findByLeftConchaObjective(@NotNull String leftConchaObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Earlobe Subjective.
	 *
	 * @param leftEarlobeSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Earlobe Subjective
	 */
	List<EntExaminationEntity> findByLeftEarlobeSubjective(@NotNull String leftEarlobeSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Earlobe Objective.
	 *
	 * @param leftEarlobeObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Earlobe Objective
	 */
	List<EntExaminationEntity> findByLeftEarlobeObjective(@NotNull String leftEarlobeObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Ear Canal Subjective.
	 *
	 * @param leftEarCanalSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ear Canal Subjective
	 */
	List<EntExaminationEntity> findByLeftEarCanalSubjective(@NotNull String leftEarCanalSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Ear Canal Objective.
	 *
	 * @param leftEarCanalObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ear Canal Objective
	 */
	List<EntExaminationEntity> findByLeftEarCanalObjective(@NotNull String leftEarCanalObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Eardrum Subjective.
	 *
	 * @param leftEardrumSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Eardrum Subjective
	 */
	List<EntExaminationEntity> findByLeftEardrumSubjective(@NotNull String leftEardrumSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Eardrum Objective.
	 *
	 * @param leftEardrumObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Eardrum Objective
	 */
	List<EntExaminationEntity> findByLeftEardrumObjective(@NotNull String leftEardrumObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Nasal Bone Subjective.
	 *
	 * @param nasalBoneSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nasal Bone Subjective
	 */
	List<EntExaminationEntity> findByNasalBoneSubjective(@NotNull String nasalBoneSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Nasal Bone Objective.
	 *
	 * @param nasalBoneObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nasal Bone Objective
	 */
	List<EntExaminationEntity> findByNasalBoneObjective(@NotNull String nasalBoneObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Frontal Sinus Subjective.
	 *
	 * @param rightFrontalSinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Frontal Sinus Subjective
	 */
	List<EntExaminationEntity> findByRightFrontalSinusSubjective(@NotNull String rightFrontalSinusSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Frontal Sinus Objective.
	 *
	 * @param rightFrontalSinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Frontal Sinus Objective
	 */
	List<EntExaminationEntity> findByRightFrontalSinusObjective(@NotNull String rightFrontalSinusObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Ethmoid Sinus Subjective.
	 *
	 * @param rightEthmoidSinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ethmoid Sinus Subjective
	 */
	List<EntExaminationEntity> findByRightEthmoidSinusSubjective(@NotNull String rightEthmoidSinusSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Ethmoid Sinus Objective.
	 *
	 * @param rightEthmoidSinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ethmoid Sinus Objective
	 */
	List<EntExaminationEntity> findByRightEthmoidSinusObjective(@NotNull String rightEthmoidSinusObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Superior Turbinate Subjective.
	 *
	 * @param rightSuperiorTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Superior Turbinate Subjective
	 */
	List<EntExaminationEntity> findByRightSuperiorTurbinateSubjective(@NotNull String rightSuperiorTurbinateSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Superior Turbinate Objective.
	 *
	 * @param rightSuperiorTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Superior Turbinate Objective
	 */
	List<EntExaminationEntity> findByRightSuperiorTurbinateObjective(@NotNull String rightSuperiorTurbinateObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Middle Turbinate Subjective.
	 *
	 * @param rightMiddleTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Middle Turbinate Subjective
	 */
	List<EntExaminationEntity> findByRightMiddleTurbinateSubjective(@NotNull String rightMiddleTurbinateSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Middle Turbinate Objective.
	 *
	 * @param rightMiddleTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Middle Turbinate Objective
	 */
	List<EntExaminationEntity> findByRightMiddleTurbinateObjective(@NotNull String rightMiddleTurbinateObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Maxillary Sinus Subjective.
	 *
	 * @param rightMaxillarySinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Maxillary Sinus Subjective
	 */
	List<EntExaminationEntity> findByRightMaxillarySinusSubjective(@NotNull String rightMaxillarySinusSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Maxillary Sinus Objective.
	 *
	 * @param rightMaxillarySinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Maxillary Sinus Objective
	 */
	List<EntExaminationEntity> findByRightMaxillarySinusObjective(@NotNull String rightMaxillarySinusObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Nasal Cavity Subjective.
	 *
	 * @param rightNasalCavitySubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Nasal Cavity Subjective
	 */
	List<EntExaminationEntity> findByRightNasalCavitySubjective(@NotNull String rightNasalCavitySubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Nasal Cavity Objective.
	 *
	 * @param rightNasalCavityObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Nasal Cavity Objective
	 */
	List<EntExaminationEntity> findByRightNasalCavityObjective(@NotNull String rightNasalCavityObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Inferior Turbinate Subjective.
	 *
	 * @param rightInferiorTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Inferior Turbinate Subjective
	 */
	List<EntExaminationEntity> findByRightInferiorTurbinateSubjective(@NotNull String rightInferiorTurbinateSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Inferior Turbinate Objective.
	 *
	 * @param rightInferiorTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Inferior Turbinate Objective
	 */
	List<EntExaminationEntity> findByRightInferiorTurbinateObjective(@NotNull String rightInferiorTurbinateObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Frontal Sinus Subjective.
	 *
	 * @param leftFrontalSinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Frontal Sinus Subjective
	 */
	List<EntExaminationEntity> findByLeftFrontalSinusSubjective(@NotNull String leftFrontalSinusSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Frontal Sinus Objective.
	 *
	 * @param leftFrontalSinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Frontal Sinus Objective
	 */
	List<EntExaminationEntity> findByLeftFrontalSinusObjective(@NotNull String leftFrontalSinusObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Ethmoid Sinus Subjective.
	 *
	 * @param leftEthmoidSinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ethmoid Sinus Subjective
	 */
	List<EntExaminationEntity> findByLeftEthmoidSinusSubjective(@NotNull String leftEthmoidSinusSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Ethmoid Sinus Objective.
	 *
	 * @param leftEthmoidSinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ethmoid Sinus Objective
	 */
	List<EntExaminationEntity> findByLeftEthmoidSinusObjective(@NotNull String leftEthmoidSinusObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Superior Turbinate Subjective.
	 *
	 * @param leftSuperiorTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Superior Turbinate Subjective
	 */
	List<EntExaminationEntity> findByLeftSuperiorTurbinateSubjective(@NotNull String leftSuperiorTurbinateSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Superior Turbinate Objective.
	 *
	 * @param leftSuperiorTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Superior Turbinate Objective
	 */
	List<EntExaminationEntity> findByLeftSuperiorTurbinateObjective(@NotNull String leftSuperiorTurbinateObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Middle Turbinate Subjective.
	 *
	 * @param leftMiddleTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Middle Turbinate Subjective
	 */
	List<EntExaminationEntity> findByLeftMiddleTurbinateSubjective(@NotNull String leftMiddleTurbinateSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Middle Turbinate Objective.
	 *
	 * @param leftMiddleTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Middle Turbinate Objective
	 */
	List<EntExaminationEntity> findByLeftMiddleTurbinateObjective(@NotNull String leftMiddleTurbinateObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Maxillary Sinus Subjective.
	 *
	 * @param leftMaxillarySinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Maxillary Sinus Subjective
	 */
	List<EntExaminationEntity> findByLeftMaxillarySinusSubjective(@NotNull String leftMaxillarySinusSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Maxillary Sinus Objective.
	 *
	 * @param leftMaxillarySinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Maxillary Sinus Objective
	 */
	List<EntExaminationEntity> findByLeftMaxillarySinusObjective(@NotNull String leftMaxillarySinusObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Nasal Cavity Subjective.
	 *
	 * @param leftNasalCavitySubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Nasal Cavity Subjective
	 */
	List<EntExaminationEntity> findByLeftNasalCavitySubjective(@NotNull String leftNasalCavitySubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Nasal Cavity Objective.
	 *
	 * @param leftNasalCavityObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Nasal Cavity Objective
	 */
	List<EntExaminationEntity> findByLeftNasalCavityObjective(@NotNull String leftNasalCavityObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Inferior Turbinate Subjective.
	 *
	 * @param leftInferiorTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Inferior Turbinate Subjective
	 */
	List<EntExaminationEntity> findByLeftInferiorTurbinateSubjective(@NotNull String leftInferiorTurbinateSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Inferior Turbinate Objective.
	 *
	 * @param leftInferiorTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Inferior Turbinate Objective
	 */
	List<EntExaminationEntity> findByLeftInferiorTurbinateObjective(@NotNull String leftInferiorTurbinateObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Lingual Tonsil Subjective.
	 *
	 * @param lingualTonsilSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lingual Tonsil Subjective
	 */
	List<EntExaminationEntity> findByLingualTonsilSubjective(@NotNull String lingualTonsilSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Lingual Tonsil Objective.
	 *
	 * @param lingualTonsilObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lingual Tonsil Objective
	 */
	List<EntExaminationEntity> findByLingualTonsilObjective(@NotNull String lingualTonsilObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Epiglottis Subjective.
	 *
	 * @param epiglottisSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Epiglottis Subjective
	 */
	List<EntExaminationEntity> findByEpiglottisSubjective(@NotNull String epiglottisSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Epiglottis Objective.
	 *
	 * @param epiglottisObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Epiglottis Objective
	 */
	List<EntExaminationEntity> findByEpiglottisObjective(@NotNull String epiglottisObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Vocal Fold Subjective.
	 *
	 * @param rightVocalFoldSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Vocal Fold Subjective
	 */
	List<EntExaminationEntity> findByRightVocalFoldSubjective(@NotNull String rightVocalFoldSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Vocal Fold Objective.
	 *
	 * @param rightVocalFoldObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Vocal Fold Objective
	 */
	List<EntExaminationEntity> findByRightVocalFoldObjective(@NotNull String rightVocalFoldObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Ventricular Fold Subjective.
	 *
	 * @param rightVentricularFoldSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ventricular Fold Subjective
	 */
	List<EntExaminationEntity> findByRightVentricularFoldSubjective(@NotNull String rightVentricularFoldSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Ventricular Fold Objective.
	 *
	 * @param rightVentricularFoldObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ventricular Fold Objective
	 */
	List<EntExaminationEntity> findByRightVentricularFoldObjective(@NotNull String rightVentricularFoldObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Glottis Subjective.
	 *
	 * @param glottisSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Glottis Subjective
	 */
	List<EntExaminationEntity> findByGlottisSubjective(@NotNull String glottisSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Glottis Objective.
	 *
	 * @param glottisObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Glottis Objective
	 */
	List<EntExaminationEntity> findByGlottisObjective(@NotNull String glottisObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Cuneiform Cartilage Subjective.
	 *
	 * @param rightCuneiformCartilageSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Cuneiform Cartilage Subjective
	 */
	List<EntExaminationEntity> findByRightCuneiformCartilageSubjective(@NotNull String rightCuneiformCartilageSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Cuneiform Cartilage Objective.
	 *
	 * @param rightCuneiformCartilageObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Cuneiform Cartilage Objective
	 */
	List<EntExaminationEntity> findByRightCuneiformCartilageObjective(@NotNull String rightCuneiformCartilageObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Corniculate Cartilage Subjective.
	 *
	 * @param rightCorniculateCartilageSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Corniculate Cartilage Subjective
	 */
	List<EntExaminationEntity> findByRightCorniculateCartilageSubjective(@NotNull String rightCorniculateCartilageSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Corniculate Cartilage Objective.
	 *
	 * @param rightCorniculateCartilageObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Corniculate Cartilage Objective
	 */
	List<EntExaminationEntity> findByRightCorniculateCartilageObjective(@NotNull String rightCorniculateCartilageObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Trachea Subjective.
	 *
	 * @param tracheaSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trachea Subjective
	 */
	List<EntExaminationEntity> findByTracheaSubjective(@NotNull String tracheaSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Trachea Objective.
	 *
	 * @param tracheaObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trachea Objective
	 */
	List<EntExaminationEntity> findByTracheaObjective(@NotNull String tracheaObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Vocal Fold Subjective.
	 *
	 * @param leftVocalFoldSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Vocal Fold Subjective
	 */
	List<EntExaminationEntity> findByLeftVocalFoldSubjective(@NotNull String leftVocalFoldSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Vocal Fold Objective.
	 *
	 * @param leftVocalFoldObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Vocal Fold Objective
	 */
	List<EntExaminationEntity> findByLeftVocalFoldObjective(@NotNull String leftVocalFoldObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Ventricular Fold Subjective.
	 *
	 * @param leftVentricularFoldSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ventricular Fold Subjective
	 */
	List<EntExaminationEntity> findByLeftVentricularFoldSubjective(@NotNull String leftVentricularFoldSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Ventricular Fold Objective.
	 *
	 * @param leftVentricularFoldObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ventricular Fold Objective
	 */
	List<EntExaminationEntity> findByLeftVentricularFoldObjective(@NotNull String leftVentricularFoldObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Cuneiform Cartilage Subjective.
	 *
	 * @param leftCuneiformCartilageSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Cuneiform Cartilage Subjective
	 */
	List<EntExaminationEntity> findByLeftCuneiformCartilageSubjective(@NotNull String leftCuneiformCartilageSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Cuneiform Cartilage Objective.
	 *
	 * @param leftCuneiformCartilageObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Cuneiform Cartilage Objective
	 */
	List<EntExaminationEntity> findByLeftCuneiformCartilageObjective(@NotNull String leftCuneiformCartilageObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Corniculate Cartilage Subjective.
	 *
	 * @param leftCorniculateCartilageSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Corniculate Cartilage Subjective
	 */
	List<EntExaminationEntity> findByLeftCorniculateCartilageSubjective(@NotNull String leftCorniculateCartilageSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Corniculate Cartilage Objective.
	 *
	 * @param leftCorniculateCartilageObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Corniculate Cartilage Objective
	 */
	List<EntExaminationEntity> findByLeftCorniculateCartilageObjective(@NotNull String leftCorniculateCartilageObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Soft Palate Subjective.
	 *
	 * @param softPalateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Soft Palate Subjective
	 */
	List<EntExaminationEntity> findBySoftPalateSubjective(@NotNull String softPalateSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Soft Palate Objective.
	 *
	 * @param softPalateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Soft Palate Objective
	 */
	List<EntExaminationEntity> findBySoftPalateObjective(@NotNull String softPalateObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Anterior Pillar Subjective.
	 *
	 * @param rightAnteriorPillarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Anterior Pillar Subjective
	 */
	List<EntExaminationEntity> findByRightAnteriorPillarSubjective(@NotNull String rightAnteriorPillarSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Anterior Pillar Objective.
	 *
	 * @param rightAnteriorPillarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Anterior Pillar Objective
	 */
	List<EntExaminationEntity> findByRightAnteriorPillarObjective(@NotNull String rightAnteriorPillarObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Uvula Subjective.
	 *
	 * @param uvulaSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uvula Subjective
	 */
	List<EntExaminationEntity> findByUvulaSubjective(@NotNull String uvulaSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Uvula Objective.
	 *
	 * @param uvulaObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uvula Objective
	 */
	List<EntExaminationEntity> findByUvulaObjective(@NotNull String uvulaObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Posterior Pillar Subjective.
	 *
	 * @param rightPosteriorPillarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Posterior Pillar Subjective
	 */
	List<EntExaminationEntity> findByRightPosteriorPillarSubjective(@NotNull String rightPosteriorPillarSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Posterior Pillar Objective.
	 *
	 * @param rightPosteriorPillarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Posterior Pillar Objective
	 */
	List<EntExaminationEntity> findByRightPosteriorPillarObjective(@NotNull String rightPosteriorPillarObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Tonsil Subjective.
	 *
	 * @param rightTonsilSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Tonsil Subjective
	 */
	List<EntExaminationEntity> findByRightTonsilSubjective(@NotNull String rightTonsilSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Tonsil Objective.
	 *
	 * @param rightTonsilObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Tonsil Objective
	 */
	List<EntExaminationEntity> findByRightTonsilObjective(@NotNull String rightTonsilObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Posterior Subjective.
	 *
	 * @param rightPosteriorSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Posterior Subjective
	 */
	List<EntExaminationEntity> findByRightPosteriorSubjective(@NotNull String rightPosteriorSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Right Posterior Objective.
	 *
	 * @param rightPosteriorObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Posterior Objective
	 */
	List<EntExaminationEntity> findByRightPosteriorObjective(@NotNull String rightPosteriorObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Upper Tongue Subjective.
	 *
	 * @param upperTongueSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upper Tongue Subjective
	 */
	List<EntExaminationEntity> findByUpperTongueSubjective(@NotNull String upperTongueSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Upper Tongue Objective.
	 *
	 * @param upperTongueObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upper Tongue Objective
	 */
	List<EntExaminationEntity> findByUpperTongueObjective(@NotNull String upperTongueObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Anterior Pillar Subjective.
	 *
	 * @param leftAnteriorPillarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Anterior Pillar Subjective
	 */
	List<EntExaminationEntity> findByLeftAnteriorPillarSubjective(@NotNull String leftAnteriorPillarSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Anterior Pillar Objective.
	 *
	 * @param leftAnteriorPillarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Anterior Pillar Objective
	 */
	List<EntExaminationEntity> findByLeftAnteriorPillarObjective(@NotNull String leftAnteriorPillarObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Posterior Pillar Subjective.
	 *
	 * @param leftPosteriorPillarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Posterior Pillar Subjective
	 */
	List<EntExaminationEntity> findByLeftPosteriorPillarSubjective(@NotNull String leftPosteriorPillarSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Posterior Pillar Objective.
	 *
	 * @param leftPosteriorPillarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Posterior Pillar Objective
	 */
	List<EntExaminationEntity> findByLeftPosteriorPillarObjective(@NotNull String leftPosteriorPillarObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Tonsil Subjective.
	 *
	 * @param leftTonsilSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Tonsil Subjective
	 */
	List<EntExaminationEntity> findByLeftTonsilSubjective(@NotNull String leftTonsilSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Tonsil Objective.
	 *
	 * @param leftTonsilObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Tonsil Objective
	 */
	List<EntExaminationEntity> findByLeftTonsilObjective(@NotNull String leftTonsilObjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Posterior Wall Subjective.
	 *
	 * @param leftPosteriorWallSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Posterior Wall Subjective
	 */
	List<EntExaminationEntity> findByLeftPosteriorWallSubjective(@NotNull String leftPosteriorWallSubjective);
	/**
	 * Return an entity or a list of entities that have the given attribute Left Posterior Wall Objective.
	 *
	 * @param leftPosteriorWallObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Posterior Wall Objective
	 */
	List<EntExaminationEntity> findByLeftPosteriorWallObjective(@NotNull String leftPosteriorWallObjective);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<EntExaminationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<EntExaminationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}