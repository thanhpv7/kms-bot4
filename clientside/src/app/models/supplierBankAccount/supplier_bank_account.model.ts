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
import {SupplierModel} from '../supplier/supplier.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class SupplierBankAccountModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'bankName',
		'accountName',
		'accountNumber',
		'city',
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

	readonly className = 'SupplierBankAccountModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return SupplierBankAccountModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	bankName: string;

	/**
	 * .
	 */
	accountName: string;

	/**
	 * .
	 */
	accountNumber: string;

	/**
	 * .
	 */
	city: string;

	/**
	 * .
	 */
	branch: string;

	/**
	 * .
	 */
	notes: string;

	supplierId: string;

	supplier: SupplierModel;

	modelPropGroups: { [s: string]: Group } = SupplierBankAccountModel.modelPropGroups;

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
				name: 'accountName',
				// % protected region % [Set displayName for Account Name here] off begin
				displayName: 'Account Name',
				// % protected region % [Set displayName for Account Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Account Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Account Name here] end
				// % protected region % [Set isSensitive for Account Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Account Name here] end
				// % protected region % [Set readonly for Account Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Account Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Account Name here] off begin
					// % protected region % [Add other validators for Account Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Account Name here] off begin
				// % protected region % [Add any additional model attribute properties for Account Name here] end
			},
			{
				name: 'accountNumber',
				// % protected region % [Set displayName for Account Number here] off begin
				displayName: 'Account Number',
				// % protected region % [Set displayName for Account Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Account Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Account Number here] end
				// % protected region % [Set isSensitive for Account Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Account Number here] end
				// % protected region % [Set readonly for Account Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Account Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Account Number here] off begin
					// % protected region % [Add other validators for Account Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Account Number here] off begin
				// % protected region % [Add any additional model attribute properties for Account Number here] end
			},
			{
				name: 'city',
				// % protected region % [Set displayName for City here] off begin
				displayName: 'City',
				// % protected region % [Set displayName for City here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for City here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for City here] end
				// % protected region % [Set isSensitive for City here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for City here] end
				// % protected region % [Set readonly for City here] off begin
				readOnly: false,
				// % protected region % [Set readonly for City here] end
				validators: [
					// % protected region % [Add other validators for City here] off begin
					// % protected region % [Add other validators for City here] end
				],
				// % protected region % [Add any additional model attribute properties for City here] off begin
				// % protected region % [Add any additional model attribute properties for City here] end
			},
			{
				name: 'branch',
				// % protected region % [Set displayName for Branch here] off begin
				displayName: 'Branch',
				// % protected region % [Set displayName for Branch here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Branch here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Branch here] end
				// % protected region % [Set isSensitive for Branch here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Branch here] end
				// % protected region % [Set readonly for Branch here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Branch here] end
				validators: [
					// % protected region % [Add other validators for Branch here] off begin
					// % protected region % [Add other validators for Branch here] end
				],
				// % protected region % [Add any additional model attribute properties for Branch here] off begin
				// % protected region % [Add any additional model attribute properties for Branch here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Notes here] end
				// % protected region % [Set isSensitive for Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Notes here] end
				// % protected region % [Set readonly for Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Notes here] end
				validators: [
					// % protected region % [Add other validators for Notes here] off begin
					// % protected region % [Add other validators for Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Notes here] end
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
				id: 'supplier',
				type: ModelRelationType.ONE,
				name: 'supplierId',
				// % protected region % [Customise your label for Supplier here] off begin
				label: 'Supplier',
				// % protected region % [Customise your label for Supplier here] end
				entityName: 'SupplierModel',
				// % protected region % [Customise your display name for Supplier here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'supplierNumber',
				// % protected region % [Customise your display name for Supplier here] end
				validators: [
					// % protected region % [Add other validators for Supplier here] off begin
					// % protected region % [Add other validators for Supplier here] end
				],
				// % protected region % [Add any additional field for relation Supplier here] off begin
				// % protected region % [Add any additional field for relation Supplier here] end
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
				case 'bankName':
					break;
				case 'accountName':
					break;
				case 'accountNumber':
					break;
				case 'city':
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
	static deepParse(data: string | { [K in keyof SupplierBankAccountModel]?: SupplierBankAccountModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new SupplierBankAccountModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.supplier) {
			currentModel.supplierId = json.supplier.id;
			returned = _.union(returned, SupplierModel.deepParse(json.supplier));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let supplierBankAccountModel = new SupplierBankAccountModel(data);`
	 *
	 * @param data The input data to be initialised as the SupplierBankAccountModel,
	 *    it is expected as a JSON string or as a nullable SupplierBankAccountModel.
	 */
	constructor(data?: string | Partial<SupplierBankAccountModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<SupplierBankAccountModel>
				: data;

			this.bankName = json.bankName;
			this.accountName = json.accountName;
			this.accountNumber = json.accountNumber;
			this.city = json.city;
			this.branch = json.branch;
			this.notes = json.notes;
			this.supplierId = json.supplierId;
			this.supplier = json.supplier;
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
			accountName: this.accountName,
			accountNumber: this.accountNumber,
			city: this.city,
			branch: this.branch,
			notes: this.notes,
			supplierId: this.supplierId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		SupplierBankAccountModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): SupplierBankAccountModel {
		let newModelJson = this.toJSON();

		if (updates.bankName) {
			newModelJson.bankName = updates.bankName;
		}

		if (updates.accountName) {
			newModelJson.accountName = updates.accountName;
		}

		if (updates.accountNumber) {
			newModelJson.accountNumber = updates.accountNumber;
		}

		if (updates.city) {
			newModelJson.city = updates.city;
		}

		if (updates.branch) {
			newModelJson.branch = updates.branch;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.supplierId) {
			newModelJson.supplierId = updates.supplierId;
		}

		return new SupplierBankAccountModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof SupplierBankAccountModel)) {
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
			'supplierId',
			'supplier',
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
		if (!this.supplier) {
			this.supplierId = null;
		} else {
			this.supplierId = this.supplier.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
