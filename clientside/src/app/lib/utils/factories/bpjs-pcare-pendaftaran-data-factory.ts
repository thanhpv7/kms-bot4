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
import {BpjsPcarePendaftaranModel} from '../../../models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model';
import * as faker from 'faker';

export class BpjsPcarePendaftaranDataFactory extends AbstractDataFactory<BpjsPcarePendaftaranModel> {

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

	create(): BpjsPcarePendaftaranModel {
		let newModel = new BpjsPcarePendaftaranModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): BpjsPcarePendaftaranModel[] {
		let newModels: BpjsPcarePendaftaranModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Bpjs Pcare Pendaftaran, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: BpjsPcarePendaftaranModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.nourut = faker.random.words();
		model.tgldaftar = faker.random.words();
		model.providerpelayanan = faker.random.words();
		model.nokartu = faker.random.words();
		model.nama = faker.random.words();
		model.hubungankeluarga = faker.random.words();
		model.sex = faker.random.words();
		model.tgllahir = faker.random.words();
		model.tglmulaiaktif = faker.random.words();
		model.tglakhirberlaku = faker.random.words();
		model.kdproviderpst = faker.random.words();
		model.kdprovidergigi = faker.random.words();
		model.jnskelas = faker.random.words();
		model.jnspeserta = faker.random.words();
		model.goldarah = faker.random.words();
		model.nohp = faker.random.words();
		model.noktp = faker.random.words();
		model.aktif = faker.random.words();
		model.ketaktif = faker.random.words();
		model.asuransi = faker.random.words();
		model.kdpoli = faker.random.words();
		model.nmpoli = faker.random.words();
		model.polisakit = faker.random.words();
		model.keluhan = faker.random.words();
		model.kunjsakit = faker.random.words();
		model.status = faker.random.words();
		model.sistole = faker.random.words();
		model.diastole = faker.random.words();
		model.beratbadan = faker.random.words();
		model.tinggibadan = faker.random.words();
		model.resprate = faker.random.words();
		model.heartrate = faker.random.words();
		model.kdtkp = faker.random.words();
		model.nmtkp = faker.random.words();
		model.kdproviderpelayanan = faker.random.words();
		model.nmproviderpelayanan = faker.random.words();
		model.nmproviderpst = faker.random.words();
		model.nmprovidergigi = faker.random.words();
		model.kodekls = faker.random.words();
		model.namakls = faker.random.words();
		model.kodepeserta = faker.random.words();
		model.namapeserta = faker.random.words();
		model.kdasuransi = faker.random.words();
		model.nmasuransi = faker.random.words();
		model.noasuransi = faker.random.words();
		model.lingkarperut = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
