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
import {CashAllocationModel} from '../../../models/cashAllocation/cash_allocation.model';
import {CashTypeEnum, cashTypeEnumArray} from '../../../enums/cash-type.enum';
import {SourceDocumentTypeEnum, sourceDocumentTypeEnumArray} from '../../../enums/source-document-type.enum';
import * as faker from 'faker';

export class CashAllocationDataFactory extends AbstractDataFactory<CashAllocationModel> {

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

	create(): CashAllocationModel {
		let newModel = new CashAllocationModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): CashAllocationModel[] {
		let newModels: CashAllocationModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Cash Allocation, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: CashAllocationModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		// % protected region % [Add Cash Typecustom enum randomisation here] off begin
		// Always initialise to the first enum literal. Turn on the protected region and put in your own custom enum
		// initialisation logic.
		model.cashType = CashTypeEnum.REFUND;
		// % protected region % [Add Cash Typecustom enum randomisation here] end
		model.allocatedDate = new Date();
		model.sourceDate = new Date();
		model.cashNumber = faker.random.words();
		// % protected region % [Add Source Document Typecustom enum randomisation here] off begin
		// Always initialise to the first enum literal. Turn on the protected region and put in your own custom enum
		// initialisation logic.
		model.sourceDocumentType = SourceDocumentTypeEnum.PATIENT_RECEIPT;
		// % protected region % [Add Source Document Typecustom enum randomisation here] end
		model.sourceNumber = faker.random.words();
		model.sourceAmount = faker.random.number();
		model.outstandingAmount = faker.random.number();
		model.allocatedAmount = faker.random.number();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
