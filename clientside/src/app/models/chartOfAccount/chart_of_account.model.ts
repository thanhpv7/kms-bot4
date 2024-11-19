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
import {ChartOfAccountMappingModel} from '../chartOfAccountMapping/chart_of_account_mapping.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class ChartOfAccountModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'accountCode',
		'accountName',
		'accountType',
		'taxCode',
		'dashboard',
		'expenseClaim',
		'enablePayment',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'accountCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ChartOfAccountModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ChartOfAccountModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	accountCode: string;

	/**
	 * .
	 */
	accountName: string;

	/**
	 * .
	 */
	accountType: string;

	/**
	 * .
	 */
	taxCode: string;

	/**
	 * .
	 */
	dashboard: boolean = false;

	/**
	 * .
	 */
	expenseClaim: boolean = false;

	/**
	 * .
	 */
	enablePayment: boolean = false;

	/**
	 * .
	 */
	description: string;

	chartOfAccountMappingsIds: string[] = [];

	chartOfAccountMappings: ChartOfAccountMappingModel[];

	modelPropGroups: { [s: string]: Group } = ChartOfAccountModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'accountCode',
				// % protected region % [Set displayName for Account Code here] off begin
				displayName: 'Account Code',
				// % protected region % [Set displayName for Account Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Account Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Account Code here] end
				// % protected region % [Set isSensitive for Account Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Account Code here] end
				// % protected region % [Set readonly for Account Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Account Code here] end
				validators: [
					// % protected region % [Add other validators for Account Code here] off begin
					// % protected region % [Add other validators for Account Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Account Code here] off begin
				// % protected region % [Add any additional model attribute properties for Account Code here] end
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
					// % protected region % [Add other validators for Account Name here] off begin
					// % protected region % [Add other validators for Account Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Account Name here] off begin
				// % protected region % [Add any additional model attribute properties for Account Name here] end
			},
			{
				name: 'accountType',
				// % protected region % [Set displayName for Account Type here] off begin
				displayName: 'Account Type',
				// % protected region % [Set displayName for Account Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Account Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Account Type here] end
				// % protected region % [Set isSensitive for Account Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Account Type here] end
				// % protected region % [Set readonly for Account Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Account Type here] end
				validators: [
					// % protected region % [Add other validators for Account Type here] off begin
					// % protected region % [Add other validators for Account Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Account Type here] off begin
				// % protected region % [Add any additional model attribute properties for Account Type here] end
			},
			{
				name: 'taxCode',
				// % protected region % [Set displayName for Tax Code here] off begin
				displayName: 'Tax Code',
				// % protected region % [Set displayName for Tax Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tax Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tax Code here] end
				// % protected region % [Set isSensitive for Tax Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax Code here] end
				// % protected region % [Set readonly for Tax Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax Code here] end
				validators: [
					// % protected region % [Add other validators for Tax Code here] off begin
					// % protected region % [Add other validators for Tax Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax Code here] off begin
				// % protected region % [Add any additional model attribute properties for Tax Code here] end
			},
			{
				name: 'dashboard',
				// % protected region % [Set displayName for Dashboard here] off begin
				displayName: 'Dashboard',
				// % protected region % [Set displayName for Dashboard here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Dashboard here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Dashboard here] end
				// % protected region % [Set isSensitive for Dashboard here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dashboard here] end
				// % protected region % [Set readonly for Dashboard here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dashboard here] end
				validators: [
					// % protected region % [Add other validators for Dashboard here] off begin
					// % protected region % [Add other validators for Dashboard here] end
				],
				// % protected region % [Add any additional model attribute properties for Dashboard here] off begin
				// % protected region % [Add any additional model attribute properties for Dashboard here] end
			},
			{
				name: 'expenseClaim',
				// % protected region % [Set displayName for Expense Claim here] off begin
				displayName: 'Expense Claim',
				// % protected region % [Set displayName for Expense Claim here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Expense Claim here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Expense Claim here] end
				// % protected region % [Set isSensitive for Expense Claim here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Expense Claim here] end
				// % protected region % [Set readonly for Expense Claim here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Expense Claim here] end
				validators: [
					// % protected region % [Add other validators for Expense Claim here] off begin
					// % protected region % [Add other validators for Expense Claim here] end
				],
				// % protected region % [Add any additional model attribute properties for Expense Claim here] off begin
				// % protected region % [Add any additional model attribute properties for Expense Claim here] end
			},
			{
				name: 'enablePayment',
				// % protected region % [Set displayName for Enable Payment here] off begin
				displayName: 'Enable Payment',
				// % protected region % [Set displayName for Enable Payment here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Enable Payment here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Enable Payment here] end
				// % protected region % [Set isSensitive for Enable Payment here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Enable Payment here] end
				// % protected region % [Set readonly for Enable Payment here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Enable Payment here] end
				validators: [
					// % protected region % [Add other validators for Enable Payment here] off begin
					// % protected region % [Add other validators for Enable Payment here] end
				],
				// % protected region % [Add any additional model attribute properties for Enable Payment here] off begin
				// % protected region % [Add any additional model attribute properties for Enable Payment here] end
			},
			{
				name: 'description',
				// % protected region % [Set displayName for Description here] off begin
				displayName: 'Description',
				// % protected region % [Set displayName for Description here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Description here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Description here] end
				// % protected region % [Set isSensitive for Description here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Description here] end
				// % protected region % [Set readonly for Description here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Description here] end
				validators: [
					// % protected region % [Add other validators for Description here] off begin
					// % protected region % [Add other validators for Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Description here] off begin
				// % protected region % [Add any additional model attribute properties for Description here] end
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
				id: 'chartOfAccountMappings',
				type: ModelRelationType.MANY,
				name: 'chartOfAccountMappingsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Chart of Account Mappings here] off begin
				label: 'Chart of Account Mappings',
				// % protected region % [Customise your 1-1 or 1-M label for Chart of Account Mappings here] end
				entityName: 'ChartOfAccountMappingModel',
				// % protected region % [Customise your display name for Chart of Account Mappings here] off begin
				displayName: 'accountType',
				// % protected region % [Customise your display name for Chart of Account Mappings here] end
				validators: [
					// % protected region % [Add other validators for Chart of Account Mappings here] off begin
					// % protected region % [Add other validators for Chart of Account Mappings here] end
				],
				// % protected region % [Add any additional field for relation Chart of Account Mappings here] off begin
				// % protected region % [Add any additional field for relation Chart of Account Mappings here] end
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
				case 'accountCode':
					break;
				case 'accountName':
					break;
				case 'accountType':
					break;
				case 'taxCode':
					break;
				case 'dashboard':
					break;
				case 'expenseClaim':
					break;
				case 'enablePayment':
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
	static deepParse(data: string | { [K in keyof ChartOfAccountModel]?: ChartOfAccountModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ChartOfAccountModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.chartOfAccountMappings) {
			currentModel.chartOfAccountMappingsIds = json.chartOfAccountMappings.map(model => model.id);
			returned = _.union(returned, _.flatten(json.chartOfAccountMappings.map(model => ChartOfAccountMappingModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let chartOfAccountModel = new ChartOfAccountModel(data);`
	 *
	 * @param data The input data to be initialised as the ChartOfAccountModel,
	 *    it is expected as a JSON string or as a nullable ChartOfAccountModel.
	 */
	constructor(data?: string | Partial<ChartOfAccountModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ChartOfAccountModel>
				: data;

			this.accountCode = json.accountCode;
			this.accountName = json.accountName;
			this.accountType = json.accountType;
			this.taxCode = json.taxCode;
			this.dashboard = json.dashboard;
			this.expenseClaim = json.expenseClaim;
			this.enablePayment = json.enablePayment;
			this.description = json.description;
			this.chartOfAccountMappingsIds = json.chartOfAccountMappingsIds;
			this.chartOfAccountMappings = json.chartOfAccountMappings;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			accountCode: this.accountCode,
			accountName: this.accountName,
			accountType: this.accountType,
			taxCode: this.taxCode,
			dashboard: this.dashboard,
			expenseClaim: this.expenseClaim,
			enablePayment: this.enablePayment,
			description: this.description,
			chartOfAccountMappingsIds: this.chartOfAccountMappingsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ChartOfAccountModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ChartOfAccountModel {
		let newModelJson = this.toJSON();

		if (updates.accountCode) {
			newModelJson.accountCode = updates.accountCode;
		}

		if (updates.accountName) {
			newModelJson.accountName = updates.accountName;
		}

		if (updates.accountType) {
			newModelJson.accountType = updates.accountType;
		}

		if (updates.taxCode) {
			newModelJson.taxCode = updates.taxCode;
		}

		if (updates.dashboard) {
			newModelJson.dashboard = updates.dashboard;
		}

		if (updates.expenseClaim) {
			newModelJson.expenseClaim = updates.expenseClaim;
		}

		if (updates.enablePayment) {
			newModelJson.enablePayment = updates.enablePayment;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.chartOfAccountMappingsIds) {
			newModelJson.chartOfAccountMappingsIds = updates.chartOfAccountMappingsIds;
		}

		return new ChartOfAccountModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ChartOfAccountModel)) {
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
			'chartOfAccountMappingsIds',
			'chartOfAccountMappings',
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
