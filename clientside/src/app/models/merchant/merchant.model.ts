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
import {FormGroup, Validators} from '@angular/forms';
import {Group, AbstractModel, ModelProperty, ModelPropertyType, ModelRelation, ModelRelationType} from '../../lib/models/abstract.model';
import {CashReceiptModel} from '../cashReceipt/cash_receipt.model';
import {MerchantSurchargeAndFeeModel} from '../merchantSurchargeAndFee/merchant_surcharge_and_fee.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class MerchantModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'merchantName',
		'merchantNumber',
		'bankAccount',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'merchantName',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MerchantModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MerchantModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Merchant Name (Max Length: 200).
	 */
	merchantName: string;

	/**
	 * Merchant Number (Max Length: 50).
	 */
	merchantNumber: string;

	/**
	 * Bank Account, get the Code from Reference Data where Type=BANK_ACCT. (Max Length: 20).
	 */
	bankAccount: string;

	cashReceiptsIds: string[] = [];

	cashReceipts: CashReceiptModel[];

	merchantSurchargeAndFeesIds: string[] = [];

	merchantSurchargeAndFees: MerchantSurchargeAndFeeModel[];

	modelPropGroups: { [s: string]: Group } = MerchantModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'merchantName',
				// % protected region % [Set displayName for Merchant Name here] off begin
				displayName: 'Merchant Name',
				// % protected region % [Set displayName for Merchant Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Merchant Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Merchant Name here] end
				// % protected region % [Set isSensitive for Merchant Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Merchant Name here] end
				// % protected region % [Set readonly for Merchant Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Merchant Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Merchant Name here] off begin
					// % protected region % [Add other validators for Merchant Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Merchant Name here] off begin
				// % protected region % [Add any additional model attribute properties for Merchant Name here] end
			},
			{
				name: 'merchantNumber',
				// % protected region % [Set displayName for Merchant Number here] off begin
				displayName: 'Merchant Number',
				// % protected region % [Set displayName for Merchant Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Merchant Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Merchant Number here] end
				// % protected region % [Set isSensitive for Merchant Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Merchant Number here] end
				// % protected region % [Set readonly for Merchant Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Merchant Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Merchant Number here] off begin
					// % protected region % [Add other validators for Merchant Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Merchant Number here] off begin
				// % protected region % [Add any additional model attribute properties for Merchant Number here] end
			},
			{
				name: 'bankAccount',
				// % protected region % [Set displayName for Bank Account here] off begin
				displayName: 'Bank Account',
				// % protected region % [Set displayName for Bank Account here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bank Account here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bank Account here] end
				// % protected region % [Set isSensitive for Bank Account here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bank Account here] end
				// % protected region % [Set readonly for Bank Account here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bank Account here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Bank Account here] off begin
					// % protected region % [Add other validators for Bank Account here] end
				],
				// % protected region % [Add any additional model attribute properties for Bank Account here] off begin
				// % protected region % [Add any additional model attribute properties for Bank Account here] end
			},
			// % protected region % [Add any additional class field names here] off begin
			// % protected region % [Add any additional class field names here] end
		]);
	}

	/**
	 * The relations of the entity
	 */
	static getRelations(): ModelRelation[] {
		return super.getRelations().concat([
			{
				id: 'cashReceipts',
				type: ModelRelationType.MANY,
				name: 'cashReceiptsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Cash Receipts here] off begin
				label: 'Cash Receipts',
				// % protected region % [Customise your 1-1 or 1-M label for Cash Receipts here] end
				entityName: 'CashReceiptModel',
				// % protected region % [Customise your display name for Cash Receipts here] off begin
				displayName: 'receiptType',
				// % protected region % [Customise your display name for Cash Receipts here] end
				validators: [
					// % protected region % [Add other validators for Cash Receipts here] off begin
					// % protected region % [Add other validators for Cash Receipts here] end
				],
				// % protected region % [Add any additional field for relation Cash Receipts here] off begin
				// % protected region % [Add any additional field for relation Cash Receipts here] end
			},
			{
				id: 'merchantSurchargeAndFees',
				type: ModelRelationType.MANY,
				name: 'merchantSurchargeAndFeesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Merchant Surcharge and Fees here] off begin
				label: 'Merchant Surcharge and Fees',
				// % protected region % [Customise your 1-1 or 1-M label for Merchant Surcharge and Fees here] end
				entityName: 'MerchantSurchargeAndFeeModel',
				// % protected region % [Customise your display name for Merchant Surcharge and Fees here] off begin
				displayName: 'bankName',
				// % protected region % [Customise your display name for Merchant Surcharge and Fees here] end
				validators: [
					// % protected region % [Add other validators for Merchant Surcharge and Fees here] off begin
					// % protected region % [Add other validators for Merchant Surcharge and Fees here] end
				],
				// % protected region % [Add any additional field for relation Merchant Surcharge and Fees here] off begin
				// % protected region % [Add any additional field for relation Merchant Surcharge and Fees here] end
			},
		]);
	}

	/**
	 * Convert the form group to the query conditions
	 */
	static convertFilterToCondition(formGroup: FormGroup): Where[][] {
		let conditions: Where[][] = [];

		// % protected region % [Overide the default convertFilterToCondition here] off begin
		Object.keys(formGroup.value).forEach((key) => {
			switch (key) {
				case 'merchantName':
					break;
				case 'merchantNumber':
					break;
				case 'bankAccount':
					break;
				case 'created':
					const created = formGroup.value[key];
					// is the range of date
					if (created instanceof Array) {
						conditions.push([
							{
								path: key,
								operation: QueryOperation.GREATER_THAN_OR_EQUAL,
								value: created[0]
							}
						]);
						conditions.push([
							{
								path: key,
								operation: QueryOperation.LESS_THAN_OR_EQUAL,
								value: created[1]
							}
						]);
					}
			}
		});
		// % protected region % [Overide the default convertFilterToCondition here] end


		return conditions;
	}

	/**
	 * Convert a nested JSON object into an array of flatten objects.
	 */
	static deepParse(data: string | { [K in keyof MerchantModel]?: MerchantModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MerchantModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.cashReceipts) {
			currentModel.cashReceiptsIds = json.cashReceipts.map(model => model.id);
			returned = _.union(returned, _.flatten(json.cashReceipts.map(model => CashReceiptModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.merchantSurchargeAndFees) {
			currentModel.merchantSurchargeAndFeesIds = json.merchantSurchargeAndFees.map(model => model.id);
			returned = _.union(returned, _.flatten(json.merchantSurchargeAndFees.map(model => MerchantSurchargeAndFeeModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let merchantModel = new MerchantModel(data);`
	 *
	 * @param data The input data to be initialised as the MerchantModel,
	 *    it is expected as a JSON string or as a nullable MerchantModel.
	 */
	constructor(data?: string | Partial<MerchantModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MerchantModel>
				: data;

			this.merchantName = json.merchantName;
			this.merchantNumber = json.merchantNumber;
			this.bankAccount = json.bankAccount;
			this.cashReceiptsIds = json.cashReceiptsIds;
			this.cashReceipts = json.cashReceipts;
			this.merchantSurchargeAndFeesIds = json.merchantSurchargeAndFeesIds;
			this.merchantSurchargeAndFees = json.merchantSurchargeAndFees;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			merchantName: this.merchantName,
			merchantNumber: this.merchantNumber,
			bankAccount: this.bankAccount,
			cashReceiptsIds: this.cashReceiptsIds,
			merchantSurchargeAndFeesIds: this.merchantSurchargeAndFeesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MerchantModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MerchantModel {
		let newModelJson = this.toJSON();

		if (updates.merchantName) {
			newModelJson.merchantName = updates.merchantName;
		}

		if (updates.merchantNumber) {
			newModelJson.merchantNumber = updates.merchantNumber;
		}

		if (updates.bankAccount) {
			newModelJson.bankAccount = updates.bankAccount;
		}

		if (updates.cashReceiptsIds) {
			newModelJson.cashReceiptsIds = updates.cashReceiptsIds;
		}

		if (updates.merchantSurchargeAndFeesIds) {
			newModelJson.merchantSurchargeAndFeesIds = updates.merchantSurchargeAndFeesIds;
		}

		return new MerchantModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MerchantModel)) {
			return {};
		}

		const diff = {};

		for (const key of _.keys(this)) {
			const thisValue = this[key];
			const otherValue = other[key];

			// Handle dates differently
			if (thisValue instanceof Date) {
				let thisDate = (thisValue) ? thisValue.getTime() : null;
				let otherDate = (otherValue) ? otherValue.getTime() : null;

				if (thisDate !== otherDate) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			'cashReceiptsIds',
			'cashReceipts',
			'merchantSurchargeAndFeesIds',
			'merchantSurchargeAndFees',
			// % protected region % [Add any other fields to omit here] off begin
			// % protected region % [Add any other fields to omit here] end
		]);
	}

	/**
	 * Sets the relation ID parameters to be based on the ID's of the associated entities.
	 * 
	 * Fetching entities is based on the object, but updating relations is based on the id, so we need to
	 * make sure that they match
	 */
	syncRelations() {
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
