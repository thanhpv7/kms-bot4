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
import {BpjsPcarePesertaKegiatanKelompokModel} from '../../../models/bpjsPcarePesertaKegiatanKelompok/bpjs_pcare_peserta_kegiatan_kelompok.model';
import * as faker from 'faker';

export class BpjsPcarePesertaKegiatanKelompokDataFactory extends AbstractDataFactory<BpjsPcarePesertaKegiatanKelompokModel> {

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

	create(): BpjsPcarePesertaKegiatanKelompokModel {
		let newModel = new BpjsPcarePesertaKegiatanKelompokModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): BpjsPcarePesertaKegiatanKelompokModel[] {
		let newModels: BpjsPcarePesertaKegiatanKelompokModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type BPJS Pcare Peserta Kegiatan Kelompok, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: BpjsPcarePesertaKegiatanKelompokModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.eduid = faker.random.words();
		model.nokartu = faker.random.words();
		model.nama = faker.random.words();
		model.hubungankeluarga = faker.random.words();
		model.sex = faker.random.words();
		model.tgllahir = faker.random.words();
		model.tglmulaiaktif = faker.random.words();
		model.tglakhirberlaku = faker.random.words();
		model.kdprovider = faker.random.words();
		model.nmprovider = faker.random.words();
		model.kdprovidergigi = faker.random.words();
		model.nmprovidergigi = faker.random.words();
		model.namakelas = faker.random.words();
		model.kodekelas = faker.random.words();
		model.namapeserta = faker.random.words();
		model.kodepeserta = faker.random.words();
		model.goldarah = faker.random.words();
		model.nohp = faker.random.words();
		model.noktp = faker.random.words();
		model.pstprol = faker.random.words();
		model.pstprb = faker.random.words();
		model.ketaktif = faker.random.words();
		model.kdasuransi = faker.random.words();
		model.nmasuransi = faker.random.words();
		model.noasuransi = faker.random.words();
		model.cob = faker.random.words();
		model.tunggakan = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
