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
package kmsweb.entities;

import lombok.*;
import javax.validation.constraints.NotNull;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class EntExaminationEntity extends AbstractEntity {

	public EntExaminationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "EntExamination";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Right External Ear Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right External Ear Subjective here] end
	private String rightExternalEarSubjective;

	// % protected region % [Modify attribute annotation for Right External Ear Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right External Ear Objective here] end
	private String rightExternalEarObjective;

	// % protected region % [Modify attribute annotation for Right Concha Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Concha Subjective here] end
	private String rightConchaSubjective;

	// % protected region % [Modify attribute annotation for Right Concha Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Concha Objective here] end
	private String rightConchaObjective;

	// % protected region % [Modify attribute annotation for Right Earlobe Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Earlobe Subjective here] end
	private String rightEarlobeSubjective;

	// % protected region % [Modify attribute annotation for Right Earlobe Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Earlobe Objective here] end
	private String rightEarlobeObjective;

	// % protected region % [Modify attribute annotation for Right Ear Canal Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Ear Canal Subjective here] end
	private String rightEarCanalSubjective;

	// % protected region % [Modify attribute annotation for Right Ear Canal Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Ear Canal Objective here] end
	private String rightEarCanalObjective;

	// % protected region % [Modify attribute annotation for Right Eardrum Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Eardrum Subjective here] end
	private String rightEardrumSubjective;

	// % protected region % [Modify attribute annotation for Right Eardrum Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Eardrum Objective here] end
	private String rightEardrumObjective;

	// % protected region % [Modify attribute annotation for Left External Ear Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left External Ear Subjective here] end
	private String leftExternalEarSubjective;

	// % protected region % [Modify attribute annotation for Left External Ear Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left External Ear Objective here] end
	private String leftExternalEarObjective;

	// % protected region % [Modify attribute annotation for Left Concha Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Concha Subjective here] end
	private String leftConchaSubjective;

	// % protected region % [Modify attribute annotation for Left Concha Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Concha Objective here] end
	private String leftConchaObjective;

	// % protected region % [Modify attribute annotation for Left Earlobe Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Earlobe Subjective here] end
	private String leftEarlobeSubjective;

	// % protected region % [Modify attribute annotation for Left Earlobe Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Earlobe Objective here] end
	private String leftEarlobeObjective;

	// % protected region % [Modify attribute annotation for Left Ear Canal Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Ear Canal Subjective here] end
	private String leftEarCanalSubjective;

	// % protected region % [Modify attribute annotation for Left Ear Canal Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Ear Canal Objective here] end
	private String leftEarCanalObjective;

	// % protected region % [Modify attribute annotation for Left Eardrum Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Eardrum Subjective here] end
	private String leftEardrumSubjective;

	// % protected region % [Modify attribute annotation for Left Eardrum Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Eardrum Objective here] end
	private String leftEardrumObjective;

	// % protected region % [Modify attribute annotation for Nasal Bone Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nasal Bone Subjective here] end
	private String nasalBoneSubjective;

	// % protected region % [Modify attribute annotation for Nasal Bone Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nasal Bone Objective here] end
	private String nasalBoneObjective;

	// % protected region % [Modify attribute annotation for Right Frontal Sinus Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Frontal Sinus Subjective here] end
	private String rightFrontalSinusSubjective;

	// % protected region % [Modify attribute annotation for Right Frontal Sinus Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Frontal Sinus Objective here] end
	private String rightFrontalSinusObjective;

	// % protected region % [Modify attribute annotation for Right Ethmoid Sinus Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Ethmoid Sinus Subjective here] end
	private String rightEthmoidSinusSubjective;

	// % protected region % [Modify attribute annotation for Right Ethmoid Sinus Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Ethmoid Sinus Objective here] end
	private String rightEthmoidSinusObjective;

	// % protected region % [Modify attribute annotation for Right Superior Turbinate Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Superior Turbinate Subjective here] end
	private String rightSuperiorTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Right Superior Turbinate Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Superior Turbinate Objective here] end
	private String rightSuperiorTurbinateObjective;

	// % protected region % [Modify attribute annotation for Right Middle Turbinate Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Middle Turbinate Subjective here] end
	private String rightMiddleTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Right Middle Turbinate Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Middle Turbinate Objective here] end
	private String rightMiddleTurbinateObjective;

	// % protected region % [Modify attribute annotation for Right Maxillary Sinus Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Maxillary Sinus Subjective here] end
	private String rightMaxillarySinusSubjective;

	// % protected region % [Modify attribute annotation for Right Maxillary Sinus Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Maxillary Sinus Objective here] end
	private String rightMaxillarySinusObjective;

	// % protected region % [Modify attribute annotation for Right Nasal Cavity Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Nasal Cavity Subjective here] end
	private String rightNasalCavitySubjective;

	// % protected region % [Modify attribute annotation for Right Nasal Cavity Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Nasal Cavity Objective here] end
	private String rightNasalCavityObjective;

	// % protected region % [Modify attribute annotation for Right Inferior Turbinate Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Inferior Turbinate Subjective here] end
	private String rightInferiorTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Right Inferior Turbinate Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Inferior Turbinate Objective here] end
	private String rightInferiorTurbinateObjective;

	// % protected region % [Modify attribute annotation for Left Frontal Sinus Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Frontal Sinus Subjective here] end
	private String leftFrontalSinusSubjective;

	// % protected region % [Modify attribute annotation for Left Frontal Sinus Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Frontal Sinus Objective here] end
	private String leftFrontalSinusObjective;

	// % protected region % [Modify attribute annotation for Left Ethmoid Sinus Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Ethmoid Sinus Subjective here] end
	private String leftEthmoidSinusSubjective;

	// % protected region % [Modify attribute annotation for Left Ethmoid Sinus Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Ethmoid Sinus Objective here] end
	private String leftEthmoidSinusObjective;

	// % protected region % [Modify attribute annotation for Left Superior Turbinate Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Superior Turbinate Subjective here] end
	private String leftSuperiorTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Left Superior Turbinate Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Superior Turbinate Objective here] end
	private String leftSuperiorTurbinateObjective;

	// % protected region % [Modify attribute annotation for Left Middle Turbinate Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Middle Turbinate Subjective here] end
	private String leftMiddleTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Left Middle Turbinate Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Middle Turbinate Objective here] end
	private String leftMiddleTurbinateObjective;

	// % protected region % [Modify attribute annotation for Left Maxillary Sinus Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Maxillary Sinus Subjective here] end
	private String leftMaxillarySinusSubjective;

	// % protected region % [Modify attribute annotation for Left Maxillary Sinus Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Maxillary Sinus Objective here] end
	private String leftMaxillarySinusObjective;

	// % protected region % [Modify attribute annotation for Left Nasal Cavity Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Nasal Cavity Subjective here] end
	private String leftNasalCavitySubjective;

	// % protected region % [Modify attribute annotation for Left Nasal Cavity Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Nasal Cavity Objective here] end
	private String leftNasalCavityObjective;

	// % protected region % [Modify attribute annotation for Left Inferior Turbinate Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Inferior Turbinate Subjective here] end
	private String leftInferiorTurbinateSubjective;

	// % protected region % [Modify attribute annotation for Left Inferior Turbinate Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Inferior Turbinate Objective here] end
	private String leftInferiorTurbinateObjective;

	// % protected region % [Modify attribute annotation for Lingual Tonsil Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lingual Tonsil Subjective here] end
	private String lingualTonsilSubjective;

	// % protected region % [Modify attribute annotation for Lingual Tonsil Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lingual Tonsil Objective here] end
	private String lingualTonsilObjective;

	// % protected region % [Modify attribute annotation for Epiglottis Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Epiglottis Subjective here] end
	private String epiglottisSubjective;

	// % protected region % [Modify attribute annotation for Epiglottis Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Epiglottis Objective here] end
	private String epiglottisObjective;

	// % protected region % [Modify attribute annotation for Right Vocal Fold Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Vocal Fold Subjective here] end
	private String rightVocalFoldSubjective;

	// % protected region % [Modify attribute annotation for Right Vocal Fold Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Vocal Fold Objective here] end
	private String rightVocalFoldObjective;

	// % protected region % [Modify attribute annotation for Right Ventricular Fold Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Ventricular Fold Subjective here] end
	private String rightVentricularFoldSubjective;

	// % protected region % [Modify attribute annotation for Right Ventricular Fold Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Ventricular Fold Objective here] end
	private String rightVentricularFoldObjective;

	// % protected region % [Modify attribute annotation for Glottis Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Glottis Subjective here] end
	private String glottisSubjective;

	// % protected region % [Modify attribute annotation for Glottis Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Glottis Objective here] end
	private String glottisObjective;

	// % protected region % [Modify attribute annotation for Right Cuneiform Cartilage Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Cuneiform Cartilage Subjective here] end
	private String rightCuneiformCartilageSubjective;

	// % protected region % [Modify attribute annotation for Right Cuneiform Cartilage Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Cuneiform Cartilage Objective here] end
	private String rightCuneiformCartilageObjective;

	// % protected region % [Modify attribute annotation for Right Corniculate Cartilage Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Corniculate Cartilage Subjective here] end
	private String rightCorniculateCartilageSubjective;

	// % protected region % [Modify attribute annotation for Right Corniculate Cartilage Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Corniculate Cartilage Objective here] end
	private String rightCorniculateCartilageObjective;

	// % protected region % [Modify attribute annotation for Trachea Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Trachea Subjective here] end
	private String tracheaSubjective;

	// % protected region % [Modify attribute annotation for Trachea Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Trachea Objective here] end
	private String tracheaObjective;

	// % protected region % [Modify attribute annotation for Left Vocal Fold Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Vocal Fold Subjective here] end
	private String leftVocalFoldSubjective;

	// % protected region % [Modify attribute annotation for Left Vocal Fold Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Vocal Fold Objective here] end
	private String leftVocalFoldObjective;

	// % protected region % [Modify attribute annotation for Left Ventricular Fold Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Ventricular Fold Subjective here] end
	private String leftVentricularFoldSubjective;

	// % protected region % [Modify attribute annotation for Left Ventricular Fold Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Ventricular Fold Objective here] end
	private String leftVentricularFoldObjective;

	// % protected region % [Modify attribute annotation for Left Cuneiform Cartilage Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Cuneiform Cartilage Subjective here] end
	private String leftCuneiformCartilageSubjective;

	// % protected region % [Modify attribute annotation for Left Cuneiform Cartilage Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Cuneiform Cartilage Objective here] end
	private String leftCuneiformCartilageObjective;

	// % protected region % [Modify attribute annotation for Left Corniculate Cartilage Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Corniculate Cartilage Subjective here] end
	private String leftCorniculateCartilageSubjective;

	// % protected region % [Modify attribute annotation for Left Corniculate Cartilage Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Corniculate Cartilage Objective here] end
	private String leftCorniculateCartilageObjective;

	// % protected region % [Modify attribute annotation for Soft Palate Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Soft Palate Subjective here] end
	private String softPalateSubjective;

	// % protected region % [Modify attribute annotation for Soft Palate Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Soft Palate Objective here] end
	private String softPalateObjective;

	// % protected region % [Modify attribute annotation for Right Anterior Pillar Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Anterior Pillar Subjective here] end
	private String rightAnteriorPillarSubjective;

	// % protected region % [Modify attribute annotation for Right Anterior Pillar Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Anterior Pillar Objective here] end
	private String rightAnteriorPillarObjective;

	// % protected region % [Modify attribute annotation for Uvula Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Uvula Subjective here] end
	private String uvulaSubjective;

	// % protected region % [Modify attribute annotation for Uvula Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Uvula Objective here] end
	private String uvulaObjective;

	// % protected region % [Modify attribute annotation for Right Posterior Pillar Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Posterior Pillar Subjective here] end
	private String rightPosteriorPillarSubjective;

	// % protected region % [Modify attribute annotation for Right Posterior Pillar Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Posterior Pillar Objective here] end
	private String rightPosteriorPillarObjective;

	// % protected region % [Modify attribute annotation for Right Tonsil Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Tonsil Subjective here] end
	private String rightTonsilSubjective;

	// % protected region % [Modify attribute annotation for Right Tonsil Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Tonsil Objective here] end
	private String rightTonsilObjective;

	// % protected region % [Modify attribute annotation for Right Posterior Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Posterior Subjective here] end
	private String rightPosteriorSubjective;

	// % protected region % [Modify attribute annotation for Right Posterior Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Posterior Objective here] end
	private String rightPosteriorObjective;

	// % protected region % [Modify attribute annotation for Upper Tongue Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Upper Tongue Subjective here] end
	private String upperTongueSubjective;

	// % protected region % [Modify attribute annotation for Upper Tongue Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Upper Tongue Objective here] end
	private String upperTongueObjective;

	// % protected region % [Modify attribute annotation for Left Anterior Pillar Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Anterior Pillar Subjective here] end
	private String leftAnteriorPillarSubjective;

	// % protected region % [Modify attribute annotation for Left Anterior Pillar Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Anterior Pillar Objective here] end
	private String leftAnteriorPillarObjective;

	// % protected region % [Modify attribute annotation for Left Posterior Pillar Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Posterior Pillar Subjective here] end
	private String leftPosteriorPillarSubjective;

	// % protected region % [Modify attribute annotation for Left Posterior Pillar Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Posterior Pillar Objective here] end
	private String leftPosteriorPillarObjective;

	// % protected region % [Modify attribute annotation for Left Tonsil Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Tonsil Subjective here] end
	private String leftTonsilSubjective;

	// % protected region % [Modify attribute annotation for Left Tonsil Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Tonsil Objective here] end
	private String leftTonsilObjective;

	// % protected region % [Modify attribute annotation for Left Posterior Wall Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Posterior Wall Subjective here] end
	private String leftPosteriorWallSubjective;

	// % protected region % [Modify attribute annotation for Left Posterior Wall Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Posterior Wall Objective here] end
	private String leftPosteriorWallObjective;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetEntExamination(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setEntExamination(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity of medicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetEntExamination();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
