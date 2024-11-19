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
import {DeliveryMedicalExaminationRecordModel} from '../../../models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import * as faker from 'faker';

export class DeliveryMedicalExaminationRecordDataFactory extends AbstractDataFactory<DeliveryMedicalExaminationRecordModel> {

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

	create(): DeliveryMedicalExaminationRecordModel {
		let newModel = new DeliveryMedicalExaminationRecordModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): DeliveryMedicalExaminationRecordModel[] {
		let newModels: DeliveryMedicalExaminationRecordModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Delivery Medical Examination Record, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: DeliveryMedicalExaminationRecordModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.pregnancyHistoryGravida = faker.random.words();
		model.pregnancyHistoryPartum = faker.random.words();
		model.pregnancyHistoryAbortum = faker.random.words();
		model.pregnancyHistoryNotes = faker.random.words();
		model.lnmpStartDate = new Date();
		model.lnmpEndDate = new Date();
		model.approximateBirthDate = new Date();
		model.gestationAgeWeeks = faker.random.number();
		model.gestationAgeDays = faker.random.number();
		model.tetanusVaccine1 = faker.random.boolean();
		model.tetanusVaccine2 = faker.random.boolean();
		model.deliveryType = faker.random.words();
		model.complicationsInPregnancy = faker.random.words();
		model.riskFactor = faker.random.words();
		model.fetalPresentation = faker.random.words();
		model.abdomenExamination = faker.random.words();
		model.fundalHeight = faker.random.words();
		model.fhrPerMinute = faker.random.words();
		model.estimatedFetalWeight = faker.random.words();
		model.leopold1 = faker.random.words();
		model.leopold2 = faker.random.words();
		model.leopold3 = faker.random.words();
		model.leopold4 = faker.random.words();
		model.geniteliaExterna = faker.random.words();
		model.geniteliaInterna = faker.random.words();
		model.vaginalExamination = faker.random.words();
		model.deliveryComplication = faker.random.words();
		model.deliveryNote = faker.random.words();
		model.normalDeliveryCase = faker.random.boolean();
		model.stage1Hour = faker.random.number();
		model.unnamedInteger1 = faker.random.number();
		model.stage3Hour = faker.random.number();
		model.stage4Hour = faker.random.number();
		model.stage1Minute = faker.random.number();
		model.stage2Minute = faker.random.number();
		model.stage3Minute = faker.random.number();
		model.stage4Minute = faker.random.number();
		model.placenta = faker.random.words();
		model.perineum = faker.random.words();
		model.bleeding = faker.random.words();
		model.postpartumComplication = faker.random.words();
		model.newbornDelivered = faker.random.number();
		model.perineumInfection = faker.random.boolean();
		model.earlyBreastfeedingIntiation = faker.random.boolean();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
