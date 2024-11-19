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
import {PcareExaminationModel} from '../../../models/pcareExamination/pcare_examination.model';
import * as faker from 'faker';

export class PcareExaminationDataFactory extends AbstractDataFactory<PcareExaminationModel> {

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

	create(): PcareExaminationModel {
		let newModel = new PcareExaminationModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): PcareExaminationModel[] {
		let newModels: PcareExaminationModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type PCare Examination, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: PcareExaminationModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.visitType = faker.random.words();
		model.treatment = faker.random.words();
		model.destinationPolyclinic = faker.random.words();
		model.disease = faker.random.words();
		model.diagnosis = faker.random.words();
		model.diagnosis2 = faker.random.words();
		model.diagnosis3 = faker.random.words();
		model.therapy = faker.random.words();
		model.consciousness = faker.random.words();
		model.dischargeStatus = faker.random.words();
		model.internalReferralPolyclinic = faker.random.words();
		model.referringDate = new Date();
		model.pkk = faker.random.words();
		model.subSpecialist = faker.random.words();
		model.facility = faker.random.words();
		model.tacc = faker.random.words();
		model.taccReason = faker.random.words();
		model.special = faker.random.words();
		model.height = faker.random.number();
		model.weight = faker.random.number();
		model.waistCircumference = faker.random.number();
		model.bmi = faker.random.number();
		model.systole = faker.random.number();
		model.diastole = faker.random.number();
		model.respiratoryRate = faker.random.number();
		model.heartRate = faker.random.number();
		model.medicalStaff = faker.random.words();
		model.tglpulang = faker.random.words();
		model.kdsubspesialis1 = faker.random.words();
		model.rujuklanjut = faker.random.words();
		model.catatan = faker.random.words();
		model.nokunjungan = faker.random.words();
		model.jsoninsert = faker.random.words();
		model.jsonupdate = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
