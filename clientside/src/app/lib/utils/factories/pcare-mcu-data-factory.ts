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
import {PcareMCUModel} from '../../../models/pcareMCU/pcare_mcu.model';
import * as faker from 'faker';

export class PcareMCUDataFactory extends AbstractDataFactory<PcareMCUModel> {

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

	create(): PcareMCUModel {
		let newModel = new PcareMCUModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): PcareMCUModel[] {
		let newModels: PcareMCUModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type PCare MCU, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: PcareMCUModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.kodeMCU = faker.random.words();
		model.noKunjungan = faker.random.words();
		model.kodeProvider = faker.random.words();
		model.namaProvider = faker.random.words();
		model.tanggalPelayanan = faker.random.words();
		model.sistole = faker.random.words();
		model.diastole = faker.random.words();
		model.radiologiFoto = faker.random.words();
		model.hemoglobin = faker.random.words();
		model.leukosit = faker.random.words();
		model.eritrosit = faker.random.words();
		model.lajuEndapDarah = faker.random.words();
		model.hematokrit = faker.random.words();
		model.trombosit = faker.random.words();
		model.hdl = faker.random.words();
		model.ldl = faker.random.words();
		model.cholesterol = faker.random.words();
		model.trigliserida = faker.random.words();
		model.sewaktu = faker.random.words();
		model.puasa = faker.random.words();
		model.postPrandial = faker.random.words();
		model.hba1c = faker.random.words();
		model.sgot = faker.random.words();
		model.sgpt = faker.random.words();
		model.gamma = faker.random.words();
		model.proteinKualitatif = faker.random.words();
		model.albumin = faker.random.words();
		model.creatinine = faker.random.words();
		model.ureum = faker.random.words();
		model.asam = faker.random.words();
		model.abi = faker.random.words();
		model.ekg = faker.random.words();
		model.echo = faker.random.words();
		model.funduskopi = faker.random.words();
		model.pemeriksaanLain = faker.random.words();
		model.keterangan = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
