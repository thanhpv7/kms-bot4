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
import {InvoiceModel} from '../../../models/invoice/invoice.model';
import {InvoiceTypeEnum, invoiceTypeEnumArray} from '../../../enums/invoice-type.enum';
import * as faker from 'faker';

export class InvoiceDataFactory extends AbstractDataFactory<InvoiceModel> {

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

	create(): InvoiceModel {
		let newModel = new InvoiceModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): InvoiceModel[] {
		let newModels: InvoiceModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Invoice, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: InvoiceModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.invoiceNumber = faker.random.words();
		model.revisionNumber = faker.random.number();
		model.invoiceStatus = faker.random.words();
		// % protected region % [Add Invoice Typecustom enum randomisation here] off begin
		// Always initialise to the first enum literal. Turn on the protected region and put in your own custom enum
		// initialisation logic.
		model.invoiceType = InvoiceTypeEnum.OUTPATIENT;
		// % protected region % [Add Invoice Typecustom enum randomisation here] end
		model.invoiceDate = new Date();
		model.cancelDate = new Date();
		model.billingLocation = faker.random.words();
		model.notes = faker.random.words();
		model.patientPaymentType = faker.random.words();
		model.verificationDate = new Date();
		model.displayDoctorOnPrint = faker.random.boolean();
		model.displayICD10OnPrint = faker.random.boolean();
		model.displayICD9CMOnPrint = faker.random.boolean();
		model.doctorCode = faker.random.words();
		model.treatmentClass = faker.random.words();
		model.admissionDate = new Date();
		model.dischargedDate = new Date();
		model.claimNo = faker.random.words();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
