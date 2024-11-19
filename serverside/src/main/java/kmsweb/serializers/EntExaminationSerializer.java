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
package kmsweb.serializers;

import kmsweb.entities.EntExaminationEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class EntExaminationSerializer extends AbstractSerializer<EntExaminationEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public EntExaminationSerializer() {
		super(EntExaminationEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(EntExaminationEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "rightExternalEarSubjective", value.getRightExternalEarSubjective());
		writeStringField(gen, "rightExternalEarObjective", value.getRightExternalEarObjective());
		writeStringField(gen, "rightConchaSubjective", value.getRightConchaSubjective());
		writeStringField(gen, "rightConchaObjective", value.getRightConchaObjective());
		writeStringField(gen, "rightEarlobeSubjective", value.getRightEarlobeSubjective());
		writeStringField(gen, "rightEarlobeObjective", value.getRightEarlobeObjective());
		writeStringField(gen, "rightEarCanalSubjective", value.getRightEarCanalSubjective());
		writeStringField(gen, "rightEarCanalObjective", value.getRightEarCanalObjective());
		writeStringField(gen, "rightEardrumSubjective", value.getRightEardrumSubjective());
		writeStringField(gen, "rightEardrumObjective", value.getRightEardrumObjective());
		writeStringField(gen, "leftExternalEarSubjective", value.getLeftExternalEarSubjective());
		writeStringField(gen, "leftExternalEarObjective", value.getLeftExternalEarObjective());
		writeStringField(gen, "leftConchaSubjective", value.getLeftConchaSubjective());
		writeStringField(gen, "leftConchaObjective", value.getLeftConchaObjective());
		writeStringField(gen, "leftEarlobeSubjective", value.getLeftEarlobeSubjective());
		writeStringField(gen, "leftEarlobeObjective", value.getLeftEarlobeObjective());
		writeStringField(gen, "leftEarCanalSubjective", value.getLeftEarCanalSubjective());
		writeStringField(gen, "leftEarCanalObjective", value.getLeftEarCanalObjective());
		writeStringField(gen, "leftEardrumSubjective", value.getLeftEardrumSubjective());
		writeStringField(gen, "leftEardrumObjective", value.getLeftEardrumObjective());
		writeStringField(gen, "nasalBoneSubjective", value.getNasalBoneSubjective());
		writeStringField(gen, "nasalBoneObjective", value.getNasalBoneObjective());
		writeStringField(gen, "rightFrontalSinusSubjective", value.getRightFrontalSinusSubjective());
		writeStringField(gen, "rightFrontalSinusObjective", value.getRightFrontalSinusObjective());
		writeStringField(gen, "rightEthmoidSinusSubjective", value.getRightEthmoidSinusSubjective());
		writeStringField(gen, "rightEthmoidSinusObjective", value.getRightEthmoidSinusObjective());
		writeStringField(gen, "rightSuperiorTurbinateSubjective", value.getRightSuperiorTurbinateSubjective());
		writeStringField(gen, "rightSuperiorTurbinateObjective", value.getRightSuperiorTurbinateObjective());
		writeStringField(gen, "rightMiddleTurbinateSubjective", value.getRightMiddleTurbinateSubjective());
		writeStringField(gen, "rightMiddleTurbinateObjective", value.getRightMiddleTurbinateObjective());
		writeStringField(gen, "rightMaxillarySinusSubjective", value.getRightMaxillarySinusSubjective());
		writeStringField(gen, "rightMaxillarySinusObjective", value.getRightMaxillarySinusObjective());
		writeStringField(gen, "rightNasalCavitySubjective", value.getRightNasalCavitySubjective());
		writeStringField(gen, "rightNasalCavityObjective", value.getRightNasalCavityObjective());
		writeStringField(gen, "rightInferiorTurbinateSubjective", value.getRightInferiorTurbinateSubjective());
		writeStringField(gen, "rightInferiorTurbinateObjective", value.getRightInferiorTurbinateObjective());
		writeStringField(gen, "leftFrontalSinusSubjective", value.getLeftFrontalSinusSubjective());
		writeStringField(gen, "leftFrontalSinusObjective", value.getLeftFrontalSinusObjective());
		writeStringField(gen, "leftEthmoidSinusSubjective", value.getLeftEthmoidSinusSubjective());
		writeStringField(gen, "leftEthmoidSinusObjective", value.getLeftEthmoidSinusObjective());
		writeStringField(gen, "leftSuperiorTurbinateSubjective", value.getLeftSuperiorTurbinateSubjective());
		writeStringField(gen, "leftSuperiorTurbinateObjective", value.getLeftSuperiorTurbinateObjective());
		writeStringField(gen, "leftMiddleTurbinateSubjective", value.getLeftMiddleTurbinateSubjective());
		writeStringField(gen, "leftMiddleTurbinateObjective", value.getLeftMiddleTurbinateObjective());
		writeStringField(gen, "leftMaxillarySinusSubjective", value.getLeftMaxillarySinusSubjective());
		writeStringField(gen, "leftMaxillarySinusObjective", value.getLeftMaxillarySinusObjective());
		writeStringField(gen, "leftNasalCavitySubjective", value.getLeftNasalCavitySubjective());
		writeStringField(gen, "leftNasalCavityObjective", value.getLeftNasalCavityObjective());
		writeStringField(gen, "leftInferiorTurbinateSubjective", value.getLeftInferiorTurbinateSubjective());
		writeStringField(gen, "leftInferiorTurbinateObjective", value.getLeftInferiorTurbinateObjective());
		writeStringField(gen, "lingualTonsilSubjective", value.getLingualTonsilSubjective());
		writeStringField(gen, "lingualTonsilObjective", value.getLingualTonsilObjective());
		writeStringField(gen, "epiglottisSubjective", value.getEpiglottisSubjective());
		writeStringField(gen, "epiglottisObjective", value.getEpiglottisObjective());
		writeStringField(gen, "rightVocalFoldSubjective", value.getRightVocalFoldSubjective());
		writeStringField(gen, "rightVocalFoldObjective", value.getRightVocalFoldObjective());
		writeStringField(gen, "rightVentricularFoldSubjective", value.getRightVentricularFoldSubjective());
		writeStringField(gen, "rightVentricularFoldObjective", value.getRightVentricularFoldObjective());
		writeStringField(gen, "glottisSubjective", value.getGlottisSubjective());
		writeStringField(gen, "glottisObjective", value.getGlottisObjective());
		writeStringField(gen, "rightCuneiformCartilageSubjective", value.getRightCuneiformCartilageSubjective());
		writeStringField(gen, "rightCuneiformCartilageObjective", value.getRightCuneiformCartilageObjective());
		writeStringField(gen, "rightCorniculateCartilageSubjective", value.getRightCorniculateCartilageSubjective());
		writeStringField(gen, "rightCorniculateCartilageObjective", value.getRightCorniculateCartilageObjective());
		writeStringField(gen, "tracheaSubjective", value.getTracheaSubjective());
		writeStringField(gen, "tracheaObjective", value.getTracheaObjective());
		writeStringField(gen, "leftVocalFoldSubjective", value.getLeftVocalFoldSubjective());
		writeStringField(gen, "leftVocalFoldObjective", value.getLeftVocalFoldObjective());
		writeStringField(gen, "leftVentricularFoldSubjective", value.getLeftVentricularFoldSubjective());
		writeStringField(gen, "leftVentricularFoldObjective", value.getLeftVentricularFoldObjective());
		writeStringField(gen, "leftCuneiformCartilageSubjective", value.getLeftCuneiformCartilageSubjective());
		writeStringField(gen, "leftCuneiformCartilageObjective", value.getLeftCuneiformCartilageObjective());
		writeStringField(gen, "leftCorniculateCartilageSubjective", value.getLeftCorniculateCartilageSubjective());
		writeStringField(gen, "leftCorniculateCartilageObjective", value.getLeftCorniculateCartilageObjective());
		writeStringField(gen, "softPalateSubjective", value.getSoftPalateSubjective());
		writeStringField(gen, "softPalateObjective", value.getSoftPalateObjective());
		writeStringField(gen, "rightAnteriorPillarSubjective", value.getRightAnteriorPillarSubjective());
		writeStringField(gen, "rightAnteriorPillarObjective", value.getRightAnteriorPillarObjective());
		writeStringField(gen, "uvulaSubjective", value.getUvulaSubjective());
		writeStringField(gen, "uvulaObjective", value.getUvulaObjective());
		writeStringField(gen, "rightPosteriorPillarSubjective", value.getRightPosteriorPillarSubjective());
		writeStringField(gen, "rightPosteriorPillarObjective", value.getRightPosteriorPillarObjective());
		writeStringField(gen, "rightTonsilSubjective", value.getRightTonsilSubjective());
		writeStringField(gen, "rightTonsilObjective", value.getRightTonsilObjective());
		writeStringField(gen, "rightPosteriorSubjective", value.getRightPosteriorSubjective());
		writeStringField(gen, "rightPosteriorObjective", value.getRightPosteriorObjective());
		writeStringField(gen, "upperTongueSubjective", value.getUpperTongueSubjective());
		writeStringField(gen, "upperTongueObjective", value.getUpperTongueObjective());
		writeStringField(gen, "leftAnteriorPillarSubjective", value.getLeftAnteriorPillarSubjective());
		writeStringField(gen, "leftAnteriorPillarObjective", value.getLeftAnteriorPillarObjective());
		writeStringField(gen, "leftPosteriorPillarSubjective", value.getLeftPosteriorPillarSubjective());
		writeStringField(gen, "leftPosteriorPillarObjective", value.getLeftPosteriorPillarObjective());
		writeStringField(gen, "leftTonsilSubjective", value.getLeftTonsilSubjective());
		writeStringField(gen, "leftTonsilObjective", value.getLeftTonsilObjective());
		writeStringField(gen, "leftPosteriorWallSubjective", value.getLeftPosteriorWallSubjective());
		writeStringField(gen, "leftPosteriorWallObjective", value.getLeftPosteriorWallObjective());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}