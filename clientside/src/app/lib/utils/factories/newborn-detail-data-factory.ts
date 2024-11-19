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
import {NewbornDetailModel} from '../../../models/newbornDetail/newborn_detail.model';
import * as faker from 'faker';

export class NewbornDetailDataFactory extends AbstractDataFactory<NewbornDetailModel> {

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

	create(): NewbornDetailModel {
		let newModel = new NewbornDetailModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): NewbornDetailModel[] {
		let newModels: NewbornDetailModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Newborn Detail, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: NewbornDetailModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.newbornFirstName = faker.random.words();
		model.newbornLastName = faker.random.words();
		model.dateTimeOfBirth = new Date();
		model.gender = faker.random.words();
		model.deliveryType = faker.random.words();
		model.deliveryTypeIndication = faker.random.words();
		model.weight = faker.random.number();
		model.length = faker.random.number();
		model.weightOfGestationalAge = faker.random.words();
		model.headCircumference = faker.random.number();
		model.chestCircumference = faker.random.number();
		model.birthCondition = faker.random.words();
		model.neonatalCase = faker.random.words();
		model.congenitalCondition = faker.random.words();
		model.physicalExamination = faker.random.words();
		model.apgar1MinuteAppearance = faker.random.words();
		model.apgar5MinuteAppearance = faker.random.words();
		model.apgar10MinuteAppearance = faker.random.words();
		model.apgar1MinutePulse = faker.random.words();
		model.apgar5MinutePulse = faker.random.words();
		model.apgar10MinutePulse = faker.random.words();
		model.apgar1MinuteGrimace = faker.random.words();
		model.apgar5MinuteGrimace = faker.random.words();
		model.apgar10MinuteGrimace = faker.random.words();
		model.apgar1MinuteActivity = faker.random.words();
		model.apgar5MinuteActivity = faker.random.words();
		model.apgar10MinuteActivity = faker.random.words();
		model.apgar1MinuteRespiration = faker.random.words();
		model.apgar5MinuteRespiration = faker.random.words();
		model.apgar10MinuteRespiration = faker.random.words();
		model.apgar1MinuteScore = faker.random.words();
		model.apgar5MinuteScore = faker.random.words();
		model.apgar10MinuteScore = faker.random.words();
		model.pediatricNurse = faker.random.words();
		model.patientId = faker.random.words();
		model.registrationId = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
