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
import {BpjsPcareRiwayatKunjunganModel} from '../../../models/bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.model';
import * as faker from 'faker';

export class BpjsPcareRiwayatKunjunganDataFactory extends AbstractDataFactory<BpjsPcareRiwayatKunjunganModel> {

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

	create(): BpjsPcareRiwayatKunjunganModel {
		let newModel = new BpjsPcareRiwayatKunjunganModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): BpjsPcareRiwayatKunjunganModel[] {
		let newModels: BpjsPcareRiwayatKunjunganModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Bpjs Pcare Riwayat Kunjungan, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: BpjsPcareRiwayatKunjunganModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.nokunjungan = faker.random.words();
		model.tglkunjungan = faker.random.words();
		model.providerpelayanan = faker.random.words();
		model.nokartu = faker.random.words();
		model.nama = faker.random.words();
		model.hubungankeluarga = faker.random.words();
		model.sex = faker.random.words();
		model.tgllahir = faker.random.words();
		model.tglmulaiaktif = faker.random.words();
		model.tglakhirberlaku = faker.random.words();
		model.kodeppkpeserta = faker.random.words();
		model.kodeppkgigi = faker.random.words();
		model.jeniskelas = faker.random.words();
		model.jenispeserta = faker.random.words();
		model.goldarah = faker.random.words();
		model.nohp = faker.random.words();
		model.noktp = faker.random.words();
		model.asuransi = faker.random.words();
		model.poli = faker.random.words();
		model.jeniskunjungan = faker.random.words();
		model.progprolanis = faker.random.words();
		model.keluhan = faker.random.words();
		model.diagnosa = faker.random.words();
		model.diagnosa2 = faker.random.words();
		model.diagnosa3 = faker.random.words();
		model.kesadaran = faker.random.words();
		model.sistole = faker.random.words();
		model.diastole = faker.random.words();
		model.beratbadan = faker.random.words();
		model.tinggibadan = faker.random.words();
		model.respiratoryrate = faker.random.words();
		model.heartrate = faker.random.words();
		model.catatan = faker.random.words();
		model.pemeriksaanfisiklain = faker.random.words();
		model.tglpulang = faker.random.words();
		model.dokter = faker.random.words();
		model.statuspulang = faker.random.words();
		model.tingkatpelayanan = faker.random.words();
		model.rujukbalik = faker.random.words();
		model.providerasalrujuk = faker.random.words();
		model.providerrujuklanjut = faker.random.words();
		model.polirujukinternal = faker.random.words();
		model.polirujuklanjut = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
