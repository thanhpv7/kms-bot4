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
import {BpjsPcareKunjunganRujukanModel} from '../../../models/bpjsPcareKunjunganRujukan/bpjs_pcare_kunjungan_rujukan.model';
import * as faker from 'faker';

export class BpjsPcareKunjunganRujukanDataFactory extends AbstractDataFactory<BpjsPcareKunjunganRujukanModel> {

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

	create(): BpjsPcareKunjunganRujukanModel {
		let newModel = new BpjsPcareKunjunganRujukanModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): BpjsPcareKunjunganRujukanModel[] {
		let newModels: BpjsPcareKunjunganRujukanModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Bpjs Pcare Kunjungan Rujukan, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: BpjsPcareKunjunganRujukanModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.norujukan = faker.random.words();
		model.kdppk = faker.random.words();
		model.nmppk = faker.random.words();
		model.alamat = faker.random.words();
		model.kdkc = faker.random.words();
		model.nmkc = faker.random.words();
		model.alamatkc = faker.random.words();
		model.telpkc = faker.random.words();
		model.faxkc = faker.random.words();
		model.kdprop = faker.random.words();
		model.kddati = faker.random.words();
		model.nmdati = faker.random.words();
		model.kdkr = faker.random.words();
		model.nmkr = faker.random.words();
		model.alamatkr = faker.random.words();
		model.telpkr = faker.random.words();
		model.faxkr = faker.random.words();
		model.tglkunjungan = faker.random.words();
		model.kdpoli = faker.random.words();
		model.nmpoli = faker.random.words();
		model.nokapst = faker.random.words();
		model.nmpst = faker.random.words();
		model.tgllahir = faker.random.words();
		model.pisa = faker.random.words();
		model.ketpisa = faker.random.words();
		model.sex = faker.random.words();
		model.kddiag1 = faker.random.words();
		model.nmdiag1 = faker.random.words();
		model.kddiag2 = faker.random.words();
		model.nmdiag2 = faker.random.words();
		model.kddiag3 = faker.random.words();
		model.nmdiag3 = faker.random.words();
		model.catatan = faker.random.words();
		model.kddokter = faker.random.words();
		model.nmdokter = faker.random.words();
		model.nmtacc = faker.random.words();
		model.alasantacc = faker.random.words();
		model.infodenda = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
