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
import {MedicalFeeModel} from '../../../models/medicalFee/medical_fee.model';
import {PharmacyTypeEnum, pharmacyTypeEnumArray} from '../../../enums/pharmacy-type.enum';
import {TariffTypeEnum, tariffTypeEnumArray} from '../../../enums/tariff-type.enum';
import {MedicalFeeStatusEnum, medicalFeeStatusEnumArray} from '../../../enums/medical-fee-status.enum';
import * as faker from 'faker';

export class MedicalFeeDataFactory extends AbstractDataFactory<MedicalFeeModel> {

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

	create(): MedicalFeeModel {
		let newModel = new MedicalFeeModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): MedicalFeeModel[] {
		let newModels: MedicalFeeModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Medical Fee, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: MedicalFeeModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		// % protected region % [Add Tariff Typecustom enum randomisation here] off begin
		// Always initialise to the first enum literal. Turn on the protected region and put in your own custom enum
		// initialisation logic.
		model.tariffType = TariffTypeEnum.ROOM;
		// % protected region % [Add Tariff Typecustom enum randomisation here] end
		model.tariffCode = faker.random.words();
		model.name = faker.random.words();
		// % protected region % [Add Pharmacy Transaction Typecustom enum randomisation here] off begin
		// Always initialise to the first enum literal. Turn on the protected region and put in your own custom enum
		// initialisation logic.
		model.pharmacyTransactionType = PharmacyTypeEnum.MEDICATION;
		// % protected region % [Add Pharmacy Transaction Typecustom enum randomisation here] end
		model.pharmacyTransactionNumber = faker.random.words();
		model.medicationTransactionNumber = faker.random.words();
		model.transactionDate = new Date();
		model.quantity = faker.random.number();
		model.unit = faker.random.words();
		model.unitPrice = faker.random.number();
		model.hospitalPrice = faker.random.number();
		model.otherComponentPrice = faker.random.number();
		model.medicalStaffCode = faker.random.words();
		model.treatmentClass = faker.random.words();
		model.notes = faker.random.words();
		// % protected region % [Add medical fee statuscustom enum randomisation here] off begin
		// Always initialise to the first enum literal. Turn on the protected region and put in your own custom enum
		// initialisation logic.
		model.medicalFeeStatus = MedicalFeeStatusEnum.OPEN;
		// % protected region % [Add medical fee statuscustom enum randomisation here] end
		model.inventoryRoundingValue = faker.random.number();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
