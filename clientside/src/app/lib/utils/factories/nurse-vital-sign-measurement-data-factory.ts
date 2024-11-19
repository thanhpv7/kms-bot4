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
import {NurseVitalSignMeasurementModel} from '../../../models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model';
import * as faker from 'faker';

export class NurseVitalSignMeasurementDataFactory extends AbstractDataFactory<NurseVitalSignMeasurementModel> {

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

	create(): NurseVitalSignMeasurementModel {
		let newModel = new NurseVitalSignMeasurementModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): NurseVitalSignMeasurementModel[] {
		let newModels: NurseVitalSignMeasurementModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Nurse Vital Sign Measurement, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: NurseVitalSignMeasurementModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.diastole = faker.random.number();
		model.systole = faker.random.number();
		model.temperature = faker.random.number();
		model.temperatureScale = faker.random.words();
		model.consciousness = faker.random.words();
		model.pulse = faker.random.number();
		model.pulseRegularity = faker.random.words();
		model.pulseStrength = faker.random.words();
		model.gcsEyes = faker.random.words();
		model.gcsVerbal = faker.random.words();
		model.gcsMotor = faker.random.words();
		model.totalGCSScore = faker.random.number();
		model.height = faker.random.number();
		model.heightScale = faker.random.words();
		model.weight = faker.random.number();
		model.weightScale = faker.random.words();
		model.bmi = faker.random.number();
		model.respiratory = faker.random.number();
		model.oxygenSaturation = faker.random.number();
		model.nutritionStatus = faker.random.words();
		model.waistCircumference = faker.random.number();
		model.waistCircumferenceUnit = faker.random.words();
		model.painScale = faker.random.number();
		model.painScaleUsed = faker.random.words();
		model.riskFallScale = faker.random.number();
		model.riskFallScaleUsed = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
