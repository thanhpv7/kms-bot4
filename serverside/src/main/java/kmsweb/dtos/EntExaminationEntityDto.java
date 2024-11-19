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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.*;
import lombok.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for EntExaminationEntity")
@EqualsAndHashCode(callSuper = false)
public class EntExaminationEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String rightExternalEarSubjective;

	private String rightExternalEarObjective;

	private String rightConchaSubjective;

	private String rightConchaObjective;

	private String rightEarlobeSubjective;

	private String rightEarlobeObjective;

	private String rightEarCanalSubjective;

	private String rightEarCanalObjective;

	private String rightEardrumSubjective;

	private String rightEardrumObjective;

	private String leftExternalEarSubjective;

	private String leftExternalEarObjective;

	private String leftConchaSubjective;

	private String leftConchaObjective;

	private String leftEarlobeSubjective;

	private String leftEarlobeObjective;

	private String leftEarCanalSubjective;

	private String leftEarCanalObjective;

	private String leftEardrumSubjective;

	private String leftEardrumObjective;

	private String nasalBoneSubjective;

	private String nasalBoneObjective;

	private String rightFrontalSinusSubjective;

	private String rightFrontalSinusObjective;

	private String rightEthmoidSinusSubjective;

	private String rightEthmoidSinusObjective;

	private String rightSuperiorTurbinateSubjective;

	private String rightSuperiorTurbinateObjective;

	private String rightMiddleTurbinateSubjective;

	private String rightMiddleTurbinateObjective;

	private String rightMaxillarySinusSubjective;

	private String rightMaxillarySinusObjective;

	private String rightNasalCavitySubjective;

	private String rightNasalCavityObjective;

	private String rightInferiorTurbinateSubjective;

	private String rightInferiorTurbinateObjective;

	private String leftFrontalSinusSubjective;

	private String leftFrontalSinusObjective;

	private String leftEthmoidSinusSubjective;

	private String leftEthmoidSinusObjective;

	private String leftSuperiorTurbinateSubjective;

	private String leftSuperiorTurbinateObjective;

	private String leftMiddleTurbinateSubjective;

	private String leftMiddleTurbinateObjective;

	private String leftMaxillarySinusSubjective;

	private String leftMaxillarySinusObjective;

	private String leftNasalCavitySubjective;

	private String leftNasalCavityObjective;

	private String leftInferiorTurbinateSubjective;

	private String leftInferiorTurbinateObjective;

	private String lingualTonsilSubjective;

	private String lingualTonsilObjective;

	private String epiglottisSubjective;

	private String epiglottisObjective;

	private String rightVocalFoldSubjective;

	private String rightVocalFoldObjective;

	private String rightVentricularFoldSubjective;

	private String rightVentricularFoldObjective;

	private String glottisSubjective;

	private String glottisObjective;

	private String rightCuneiformCartilageSubjective;

	private String rightCuneiformCartilageObjective;

	private String rightCorniculateCartilageSubjective;

	private String rightCorniculateCartilageObjective;

	private String tracheaSubjective;

	private String tracheaObjective;

	private String leftVocalFoldSubjective;

	private String leftVocalFoldObjective;

	private String leftVentricularFoldSubjective;

	private String leftVentricularFoldObjective;

	private String leftCuneiformCartilageSubjective;

	private String leftCuneiformCartilageObjective;

	private String leftCorniculateCartilageSubjective;

	private String leftCorniculateCartilageObjective;

	private String softPalateSubjective;

	private String softPalateObjective;

	private String rightAnteriorPillarSubjective;

	private String rightAnteriorPillarObjective;

	private String uvulaSubjective;

	private String uvulaObjective;

	private String rightPosteriorPillarSubjective;

	private String rightPosteriorPillarObjective;

	private String rightTonsilSubjective;

	private String rightTonsilObjective;

	private String rightPosteriorSubjective;

	private String rightPosteriorObjective;

	private String upperTongueSubjective;

	private String upperTongueObjective;

	private String leftAnteriorPillarSubjective;

	private String leftAnteriorPillarObjective;

	private String leftPosteriorPillarSubjective;

	private String leftPosteriorPillarObjective;

	private String leftTonsilSubjective;

	private String leftTonsilObjective;

	private String leftPosteriorWallSubjective;

	private String leftPosteriorWallObjective;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
