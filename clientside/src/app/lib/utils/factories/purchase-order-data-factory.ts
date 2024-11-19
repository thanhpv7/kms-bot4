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
import {PurchaseOrderModel} from '../../../models/purchaseOrder/purchase_order.model';
import * as faker from 'faker';

export class PurchaseOrderDataFactory extends AbstractDataFactory<PurchaseOrderModel> {

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

	create(): PurchaseOrderModel {
		let newModel = new PurchaseOrderModel();

		this.populate(newModel);

		// % protected region % [Add any additional modification to the new model here] off begin
		// % protected region % [Add any additional modification to the new model here] end

		return newModel;
	}

	createAll(size: number = 10): PurchaseOrderModel[] {
		let newModels: PurchaseOrderModel[] = [];

		for (let i: number = 0; i < size; ++i) {
			newModels.push(this.create());
		}

		// % protected region % [Add any additional modification to create new models here] off begin
		// % protected region % [Add any additional modification to create new models here] end

		return newModels;
	}


	/**
	 * Given a blank model of type Purchase Order, populate the model with its properties.
	 * By default, all chronic properties are set to the current timestamp.
	 *
	 * @param model the model whose properties will be populated
	 */
	populate(model: PurchaseOrderModel) {
		super.populate(model);

		// % protected region % [Add any additional populate logic before the main body here] off begin
		// % protected region % [Add any additional populate logic before the main body here] end

		model.purchaseOrderType = faker.random.words();
		model.purchaseOrderNumber = faker.random.words();
		model.status = faker.random.words();
		model.supplyStockGroup = faker.random.words();
		model.orderDate = new Date();
		model.expectedDate = new Date();
		model.priceVATIncluded = faker.random.boolean();
		model.inventoryVATIncluded = faker.random.boolean();
		model.referenceDocument = faker.random.words();
		model.supplierReferenceDocument = faker.random.words();
		model.paymentTerms = faker.random.words();
		model.shippingMethod = faker.random.words();
		model.notes = faker.random.words();
		model.subTotal = faker.random.number();
		model.extraDiscountInPercent = faker.random.boolean();
		model.extraDiscountIncludeTax = faker.random.boolean();
		model.extraDiscountValue = faker.random.number();
		model.freightFeeIncludeTax = faker.random.boolean();
		model.freightFeeValue = faker.random.number();
		model.otherFeeIncludeTax = faker.random.boolean();
		model.otherFeeValue = faker.random.number();
		model.taxBase = faker.random.number();
		model.taxAmount = faker.random.number();
		model.totalAmount = faker.random.number();

		// % protected region % [Add any additional populate logic after the main body here] off begin
		// % protected region % [Add any additional populate logic after the main body here] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end
