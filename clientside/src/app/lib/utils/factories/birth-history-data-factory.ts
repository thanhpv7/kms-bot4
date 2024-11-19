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
import {BirthHistoryModel} from '../../../models/birthHistory/birth_history.model';
import * as faker from 'faker';

export class BirthHistoryDataFactory extends AbstractDataFactory<BirthHistoryModel> {

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

	create(): BirthHistoryModel {
		let newModel = new BirthHistoryModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): BirthHistoryModel[] {
		let newModels: BirthHistoryModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Birth History, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: BirthHistoryModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.gestationalAgeWeeks = faker.random.number();
		model.gestationalAgeDays = faker.random.number();
		model.deliveryType = faker.random.words();
		model.length = faker.random.number();
		model.lengthUnit = faker.random.words();
		model.weight = faker.random.number();
		model.weightUnit = faker.random.words();
		model.headCircumferenceBirth = faker.random.number();
		model.headCircumferenceBirthUnit = faker.random.words();
		model.chestCircumference = faker.random.number();
		model.chestCircumferenceUnit = faker.random.words();
		model.birthCondition = faker.random.words();
		model.neonatalCase = faker.random.words();
		model.pediatricCase = faker.random.words();
		model.foodType = faker.random.words();
		model.headCircumference = faker.random.number();
		model.headCircumferenceUnit = faker.random.words();
		model.upperArmCircumference = faker.random.number();
		model.upperArmCircumferenceUnit = faker.random.words();
		model.actionTaken = faker.random.words();
		model.weightGestationalAge = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
