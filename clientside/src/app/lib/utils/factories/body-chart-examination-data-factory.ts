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
import {BodyChartExaminationModel} from '../../../models/bodyChartExamination/body_chart_examination.model';
import * as faker from 'faker';

export class BodyChartExaminationDataFactory extends AbstractDataFactory<BodyChartExaminationModel> {

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

	create(): BodyChartExaminationModel {
		let newModel = new BodyChartExaminationModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): BodyChartExaminationModel[] {
		let newModels: BodyChartExaminationModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Body Chart Examination, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: BodyChartExaminationModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.bc01Subjective = faker.random.words();
		model.bc01Objective = faker.random.words();
		model.bc02Subjective = faker.random.words();
		model.bc02Objective = faker.random.words();
		model.bc03Subjective = faker.random.words();
		model.bc03Objective = faker.random.words();
		model.bc04Subjective = faker.random.words();
		model.bc04Objective = faker.random.words();
		model.bc05Subjective = faker.random.words();
		model.bc05Objective = faker.random.words();
		model.bc06Subjective = faker.random.words();
		model.bc06Objective = faker.random.words();
		model.bc07Subjective = faker.random.words();
		model.bc07Objective = faker.random.words();
		model.bc08Subjective = faker.random.words();
		model.bc08Objective = faker.random.words();
		model.bc09Subjective = faker.random.words();
		model.bc09Objective = faker.random.words();
		model.bc10Subjective = faker.random.words();
		model.bc10Objective = faker.random.words();
		model.bc11Subjective = faker.random.words();
		model.bc11Objective = faker.random.words();
		model.bc12Subjective = faker.random.words();
		model.bc12Objective = faker.random.words();
		model.bc13Subjective = faker.random.words();
		model.bc13Objective = faker.random.words();
		model.bc14Subjective = faker.random.words();
		model.bc14Objective = faker.random.words();
		model.bc15Subjective = faker.random.words();
		model.bc15Objective = faker.random.words();
		model.bc16Subjective = faker.random.words();
		model.bc16Objective = faker.random.words();
		model.bc17Subjective = faker.random.words();
		model.bc17Objective = faker.random.words();
		model.bc18Subjective = faker.random.words();
		model.bc18Objective = faker.random.words();
		model.bc19Subjective = faker.random.words();
		model.bc19Objective = faker.random.words();
		model.bc20Subjective = faker.random.words();
		model.bc20Objective = faker.random.words();
		model.bc21Subjective = faker.random.words();
		model.bc21Objective = faker.random.words();
		model.bc22Subjective = faker.random.words();
		model.bc22Objective = faker.random.words();
		model.bc23Subjective = faker.random.words();
		model.bc23Objective = faker.random.words();
		model.bc24Subjective = faker.random.words();
		model.bc24Objective = faker.random.words();
		model.bc25Subjective = faker.random.words();
		model.bc25Objective = faker.random.words();
		model.bc26Subjective = faker.random.words();
		model.bc26Objective = faker.random.words();
		model.bc27Subjective = faker.random.words();
		model.bc27Objective = faker.random.words();
		model.bc28Subjective = faker.random.words();
		model.bc28Objective = faker.random.words();
		model.bc29Subjective = faker.random.words();
		model.bc29Objective = faker.random.words();
		model.bc30Subjective = faker.random.words();
		model.bc30Objective = faker.random.words();
		model.bc31Subjective = faker.random.words();
		model.bc31Objective = faker.random.words();
		model.bc32Subjective = faker.random.words();
		model.bc32Objective = faker.random.words();
		model.bc33Subjective = faker.random.words();
		model.bc33Objective = faker.random.words();
		model.bc34Subjective = faker.random.words();
		model.bc34Objective = faker.random.words();
		model.bc35Subjective = faker.random.words();
		model.bc35Objective = faker.random.words();
		model.bc36Subjective = faker.random.words();
		model.bc36Objective = faker.random.words();
		model.bc37Subjective = faker.random.words();
		model.bc37Objective = faker.random.words();
		model.bc38Subjective = faker.random.words();
		model.bc38Objective = faker.random.words();
		model.bc39Subjective = faker.random.words();
		model.bc39Objective = faker.random.words();
		model.bc40Subjective = faker.random.words();
		model.bc40Objective = faker.random.words();
		model.bc41Subjective = faker.random.words();
		model.bc41Objective = faker.random.words();
		model.bc42Subjective = faker.random.words();
		model.bc42Objective = faker.random.words();
		model.bc43Subjective = faker.random.words();
		model.bc43Objective = faker.random.words();
		model.bc44Subjective = faker.random.words();
		model.bc44Objective = faker.random.words();
		model.bc45Subjective = faker.random.words();
		model.bc45Objective = faker.random.words();
		model.bc46Subjective = faker.random.words();
		model.bc46Objective = faker.random.words();
		model.bc47Subjective = faker.random.words();
		model.bc47Objective = faker.random.words();
		model.bc48Subjective = faker.random.words();
		model.bc48Objective = faker.random.words();
		model.bc49Subjective = faker.random.words();
		model.bc49Objective = faker.random.words();
		model.bc50Subjective = faker.random.words();
		model.bc50Objective = faker.random.words();
		model.bc51Subjective = faker.random.words();
		model.bc51Objective = faker.random.words();
		model.bc52Subjective = faker.random.words();
		model.bc52Objective = faker.random.words();
		model.bc53Subjective = faker.random.words();
		model.bc53Objective = faker.random.words();
		model.bc54Subjective = faker.random.words();
		model.bc54Objective = faker.random.words();
		model.bc55Subjective = faker.random.words();
		model.bc55Objective = faker.random.words();
		model.bc56Subjective = faker.random.words();
		model.bc56Objective = faker.random.words();
		model.bc57Subjective = faker.random.words();
		model.bc57Objective = faker.random.words();
		model.bc58Subjective = faker.random.words();
		model.bc58Objective = faker.random.words();
		model.bc59Subjective = faker.random.words();
		model.bc59Objective = faker.random.words();
		model.bc60Subjective = faker.random.words();
		model.bc60Objective = faker.random.words();
		model.bc61Subjective = faker.random.words();
		model.bc61Objective = faker.random.words();
		model.bc62Subjective = faker.random.words();
		model.bc62Objective = faker.random.words();
		model.bc63Subjective = faker.random.words();
		model.bc63Objective = faker.random.words();
		model.bc64Subjective = faker.random.words();
		model.bc64Objective = faker.random.words();
		model.bc65Subjective = faker.random.words();
		model.bc65Objective = faker.random.words();
		model.bc66Subjective = faker.random.words();
		model.bc66Objective = faker.random.words();
		model.bc67Subjective = faker.random.words();
		model.bc67Objective = faker.random.words();
		model.bc68Subjective = faker.random.words();
		model.bc68Objective = faker.random.words();
		model.bc69Subjective = faker.random.words();
		model.bc69Objective = faker.random.words();
		model.bc70Subjective = faker.random.words();
		model.bc70Objective = faker.random.words();
		model.bc71Subjective = faker.random.words();
		model.bc71Objective = faker.random.words();
		model.bc72Subjective = faker.random.words();
		model.bc72Objective = faker.random.words();
		model.bc73Subjective = faker.random.words();
		model.bc73Objective = faker.random.words();
		model.bc74Subjective = faker.random.words();
		model.bc74Objective = faker.random.words();
		model.bc75Subjective = faker.random.words();
		model.bc75Objective = faker.random.words();
		model.bc76Subjective = faker.random.words();
		model.bc76Objective = faker.random.words();
		model.bc77Subjective = faker.random.words();
		model.bc77Objective = faker.random.words();
		model.bc78Subjective = faker.random.words();
		model.bc78Objective = faker.random.words();
		model.bc79Subjective = faker.random.words();
		model.bc79Objective = faker.random.words();
		model.bc80Subjective = faker.random.words();
		model.bc80Objective = faker.random.words();
		model.bc81Subjective = faker.random.words();
		model.bc81Objective = faker.random.words();
		model.bc82Subjective = faker.random.words();
		model.bc82Objective = faker.random.words();
		model.bc83Subjective = faker.random.words();
		model.bc83Objective = faker.random.words();
		model.bc84Subjective = faker.random.words();
		model.bc84Objective = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
