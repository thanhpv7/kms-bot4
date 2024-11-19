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

import {AbstractDataFactory} from './abstract-data-factory';
import {EntExaminationModel} from '../../../models/entExamination/ent_examination.model';
import * as faker from 'faker';

export class EntExaminationDataFactory extends AbstractDataFactory<EntExaminationModel> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		super(
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	create(): EntExaminationModel {
		let newModel = new EntExaminationModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): EntExaminationModel[] {
		let newModels: EntExaminationModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type ENT Examination, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: EntExaminationModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.rightExternalEarSubjective = faker.random.words();
		model.rightExternalEarObjective = faker.random.words();
		model.rightConchaSubjective = faker.random.words();
		model.rightConchaObjective = faker.random.words();
		model.rightEarlobeSubjective = faker.random.words();
		model.rightEarlobeObjective = faker.random.words();
		model.rightEarCanalSubjective = faker.random.words();
		model.rightEarCanalObjective = faker.random.words();
		model.rightEardrumSubjective = faker.random.words();
		model.rightEardrumObjective = faker.random.words();
		model.leftExternalEarSubjective = faker.random.words();
		model.leftExternalEarObjective = faker.random.words();
		model.leftConchaSubjective = faker.random.words();
		model.leftConchaObjective = faker.random.words();
		model.leftEarlobeSubjective = faker.random.words();
		model.leftEarlobeObjective = faker.random.words();
		model.leftEarCanalSubjective = faker.random.words();
		model.leftEarCanalObjective = faker.random.words();
		model.leftEardrumSubjective = faker.random.words();
		model.leftEardrumObjective = faker.random.words();
		model.nasalBoneSubjective = faker.random.words();
		model.nasalBoneObjective = faker.random.words();
		model.rightFrontalSinusSubjective = faker.random.words();
		model.rightFrontalSinusObjective = faker.random.words();
		model.rightEthmoidSinusSubjective = faker.random.words();
		model.rightEthmoidSinusObjective = faker.random.words();
		model.rightSuperiorTurbinateSubjective = faker.random.words();
		model.rightSuperiorTurbinateObjective = faker.random.words();
		model.rightMiddleTurbinateSubjective = faker.random.words();
		model.rightMiddleTurbinateObjective = faker.random.words();
		model.rightMaxillarySinusSubjective = faker.random.words();
		model.rightMaxillarySinusObjective = faker.random.words();
		model.rightNasalCavitySubjective = faker.random.words();
		model.rightNasalCavityObjective = faker.random.words();
		model.rightInferiorTurbinateSubjective = faker.random.words();
		model.rightInferiorTurbinateObjective = faker.random.words();
		model.leftFrontalSinusSubjective = faker.random.words();
		model.leftFrontalSinusObjective = faker.random.words();
		model.leftEthmoidSinusSubjective = faker.random.words();
		model.leftEthmoidSinusObjective = faker.random.words();
		model.leftSuperiorTurbinateSubjective = faker.random.words();
		model.leftSuperiorTurbinateObjective = faker.random.words();
		model.leftMiddleTurbinateSubjective = faker.random.words();
		model.leftMiddleTurbinateObjective = faker.random.words();
		model.leftMaxillarySinusSubjective = faker.random.words();
		model.leftMaxillarySinusObjective = faker.random.words();
		model.leftNasalCavitySubjective = faker.random.words();
		model.leftNasalCavityObjective = faker.random.words();
		model.leftInferiorTurbinateSubjective = faker.random.words();
		model.leftInferiorTurbinateObjective = faker.random.words();
		model.lingualTonsilSubjective = faker.random.words();
		model.lingualTonsilObjective = faker.random.words();
		model.epiglottisSubjective = faker.random.words();
		model.epiglottisObjective = faker.random.words();
		model.rightVocalFoldSubjective = faker.random.words();
		model.rightVocalFoldObjective = faker.random.words();
		model.rightVentricularFoldSubjective = faker.random.words();
		model.rightVentricularFoldObjective = faker.random.words();
		model.glottisSubjective = faker.random.words();
		model.glottisObjective = faker.random.words();
		model.rightCuneiformCartilageSubjective = faker.random.words();
		model.rightCuneiformCartilageObjective = faker.random.words();
		model.rightCorniculateCartilageSubjective = faker.random.words();
		model.rightCorniculateCartilageObjective = faker.random.words();
		model.tracheaSubjective = faker.random.words();
		model.tracheaObjective = faker.random.words();
		model.leftVocalFoldSubjective = faker.random.words();
		model.leftVocalFoldObjective = faker.random.words();
		model.leftVentricularFoldSubjective = faker.random.words();
		model.leftVentricularFoldObjective = faker.random.words();
		model.leftCuneiformCartilageSubjective = faker.random.words();
		model.leftCuneiformCartilageObjective = faker.random.words();
		model.leftCorniculateCartilageSubjective = faker.random.words();
		model.leftCorniculateCartilageObjective = faker.random.words();
		model.softPalateSubjective = faker.random.words();
		model.softPalateObjective = faker.random.words();
		model.rightAnteriorPillarSubjective = faker.random.words();
		model.rightAnteriorPillarObjective = faker.random.words();
		model.uvulaSubjective = faker.random.words();
		model.uvulaObjective = faker.random.words();
		model.rightPosteriorPillarSubjective = faker.random.words();
		model.rightPosteriorPillarObjective = faker.random.words();
		model.rightTonsilSubjective = faker.random.words();
		model.rightTonsilObjective = faker.random.words();
		model.rightPosteriorSubjective = faker.random.words();
		model.rightPosteriorObjective = faker.random.words();
		model.upperTongueSubjective = faker.random.words();
		model.upperTongueObjective = faker.random.words();
		model.leftAnteriorPillarSubjective = faker.random.words();
		model.leftAnteriorPillarObjective = faker.random.words();
		model.leftPosteriorPillarSubjective = faker.random.words();
		model.leftPosteriorPillarObjective = faker.random.words();
		model.leftTonsilSubjective = faker.random.words();
		model.leftTonsilObjective = faker.random.words();
		model.leftPosteriorWallSubjective = faker.random.words();
		model.leftPosteriorWallObjective = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
