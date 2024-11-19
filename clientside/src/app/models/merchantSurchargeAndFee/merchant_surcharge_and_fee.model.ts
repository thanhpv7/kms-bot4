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
import {MerchantModel} from '../merchant/merchant.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class MerchantSurchargeAndFeeModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'bankName',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MerchantSurchargeAndFeeModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MerchantSurchargeAndFeeModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Bank Name, get the Code from Reference Data where Type=BANK. (Max Length: 20).
	 */
	bankName: string;

	/**
	 * Card Type, , get the Code from Reference Data where Type=BANKCARD_TYPE. (Max Length: 20).
	 */
	cardType: string;

	/**
	 * Surcharge in percentage, with 2 digits decimal.
	 */
	surcharge: number;

	/**
	 * Fee in percentage, with 2 digits decimal.
	 */
	fee: string;

	merchantId: string;

	merchant: MerchantModel;

	modelPropGroups: { [s: string]: Group } = MerchantSurchargeAndFeeModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'bankName',
				// % protected region % [Set displayName for Bank Name here] off begin
				displayName: 'Bank Name',
				// % protected region % [Set displayName for Bank Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bank Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bank Name here] end
				// % protected region % [Set isSensitive for Bank Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bank Name here] end
				// % protected region % [Set readonly for Bank Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bank Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Bank Name here] off begin
					// % protected region % [Add other validators for Bank Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Bank Name here] off begin
				// % protected region % [Add any additional model attribute properties for Bank Name here] end
			},
			{
				name: 'cardType',
				// % protected region % [Set displayName for Card Type here] off begin
				displayName: 'Card Type',
				// % protected region % [Set displayName for Card Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Card Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Card Type here] end
				// % protected region % [Set isSensitive for Card Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Card Type here] end
				// % protected region % [Set readonly for Card Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Card Type here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Card Type here] off begin
					// % protected region % [Add other validators for Card Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Card Type here] off begin
				// % protected region % [Add any additional model attribute properties for Card Type here] end
			},
			{
				name: 'surcharge',
				// % protected region % [Set displayName for Surcharge here] off begin
				displayName: 'Surcharge',
				// % protected region % [Set displayName for Surcharge here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Surcharge here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Surcharge here] end
				// % protected region % [Set isSensitive for Surcharge here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surcharge here] end
				// % protected region % [Set readonly for Surcharge here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surcharge here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Surcharge here] off begin
					// % protected region % [Add other validators for Surcharge here] end
				],
				// % protected region % [Add any additional model attribute properties for Surcharge here] off begin
				// % protected region % [Add any additional model attribute properties for Surcharge here] end
			},
			{
				name: 'fee',
				// % protected region % [Set displayName for Fee here] off begin
				displayName: 'Fee',
				// % protected region % [Set displayName for Fee here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Fee here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Fee here] end
				// % protected region % [Set isSensitive for Fee here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fee here] end
				// % protected region % [Set readonly for Fee here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fee here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Fee here] off begin
					// % protected region % [Add other validators for Fee here] end
				],
				// % protected region % [Add any additional model attribute properties for Fee here] off begin
				// % protected region % [Add any additional model attribute properties for Fee here] end
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
				id: 'merchant',
				type: ModelRelationType.ONE,
				name: 'merchantId',
				// % protected region % [Customise your label for Merchant here] off begin
				label: 'Merchant',
				// % protected region % [Customise your label for Merchant here] end
				entityName: 'MerchantModel',
				// % protected region % [Customise your display name for Merchant here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'merchantName',
				// % protected region % [Customise your display name for Merchant here] end
				validators: [
					// % protected region % [Add other validators for Merchant here] off begin
					// % protected region % [Add other validators for Merchant here] end
				],
				// % protected region % [Add any additional field for relation Merchant here] off begin
				// % protected region % [Add any additional field for relation Merchant here] end
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
	static deepParse(data: string | { [K in keyof MerchantSurchargeAndFeeModel]?: MerchantSurchargeAndFeeModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MerchantSurchargeAndFeeModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.merchant) {
			currentModel.merchantId = json.merchant.id;
			returned = _.union(returned, MerchantModel.deepParse(json.merchant));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let merchantSurchargeAndFeeModel = new MerchantSurchargeAndFeeModel(data);`
	 *
	 * @param data The input data to be initialised as the MerchantSurchargeAndFeeModel,
	 *    it is expected as a JSON string or as a nullable MerchantSurchargeAndFeeModel.
	 */
	constructor(data?: string | Partial<MerchantSurchargeAndFeeModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MerchantSurchargeAndFeeModel>
				: data;

			this.bankName = json.bankName;
			this.cardType = json.cardType;
			this.surcharge = json.surcharge;
			this.fee = json.fee;
			this.merchantId = json.merchantId;
			this.merchant = json.merchant;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			bankName: this.bankName,
			cardType: this.cardType,
			surcharge: this.surcharge,
			fee: this.fee,
			merchantId: this.merchantId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MerchantSurchargeAndFeeModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MerchantSurchargeAndFeeModel {
		let newModelJson = this.toJSON();

		if (updates.bankName) {
			newModelJson.bankName = updates.bankName;
		}

		if (updates.cardType) {
			newModelJson.cardType = updates.cardType;
		}

		if (updates.surcharge) {
			newModelJson.surcharge = updates.surcharge;
		}

		if (updates.fee) {
			newModelJson.fee = updates.fee;
		}

		if (updates.merchantId) {
			newModelJson.merchantId = updates.merchantId;
		}

		return new MerchantSurchargeAndFeeModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MerchantSurchargeAndFeeModel)) {
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
			'merchantId',
			'merchant',
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
		if (!this.merchant) {
			this.merchantId = null;
		} else {
			this.merchantId = this.merchant.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
