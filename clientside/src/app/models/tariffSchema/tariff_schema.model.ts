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
import {InvoiceModel} from '../invoice/invoice.model';
import {InvoiceItemModel} from '../invoiceItem/invoice_item.model';
import {TariffDefinitionModel} from '../tariffDefinition/tariff_definition.model';
import {TariffFormulaModel} from '../tariffFormula/tariff_formula.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class TariffSchemaModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'schemaCode',
		'schemeName',
		'startDate',
		'endDate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'schemaCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'TariffSchemaModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TariffSchemaModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Scheme Code (Max Length: 50).
	 */
	schemaCode: string;

	/**
	 * Scheme Name (max length: 250).
	 */
	schemeName: string;

	/**
	 * Date when the schema is in valid period by referring Visit Date of patient.
	 */
	startDate: Date;

	/**
	 * It's nullable, which means if the End Period is blank/null then the schema is applicable for any time after Start Period.
	 */
	endDate: Date;

	baseSchemeIds: string[] = [];

	baseScheme: TariffFormulaModel[];

	invoiceItemsIds: string[] = [];

	invoiceItems: InvoiceItemModel[];

	invoicesIds: string[] = [];

	invoices: InvoiceModel[];

	tariffDefinitionsIds: string[] = [];

	tariffDefinitions: TariffDefinitionModel[];

	tariffSchemeIds: string[] = [];

	tariffScheme: TariffFormulaModel[];

	modelPropGroups: { [s: string]: Group } = TariffSchemaModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'schemaCode',
				// % protected region % [Set displayName for Schema Code here] off begin
				displayName: 'Schema Code',
				// % protected region % [Set displayName for Schema Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Schema Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Schema Code here] end
				// % protected region % [Set isSensitive for Schema Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Schema Code here] end
				// % protected region % [Set readonly for Schema Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Schema Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Schema Code here] off begin
					// % protected region % [Add other validators for Schema Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Schema Code here] off begin
				// % protected region % [Add any additional model attribute properties for Schema Code here] end
			},
			{
				name: 'schemeName',
				// % protected region % [Set displayName for Scheme Name here] off begin
				displayName: 'Scheme Name',
				// % protected region % [Set displayName for Scheme Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Scheme Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Scheme Name here] end
				// % protected region % [Set isSensitive for Scheme Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Scheme Name here] end
				// % protected region % [Set readonly for Scheme Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Scheme Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Scheme Name here] off begin
					// % protected region % [Add other validators for Scheme Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Scheme Name here] off begin
				// % protected region % [Add any additional model attribute properties for Scheme Name here] end
			},
			{
				name: 'startDate',
				// % protected region % [Set displayName for Start Date here] off begin
				displayName: 'Start Date',
				// % protected region % [Set displayName for Start Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Start Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Start Date here] end
				// % protected region % [Set isSensitive for Start Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Start Date here] end
				// % protected region % [Set readonly for Start Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Start Date here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Start Date here] off begin
					// % protected region % [Add other validators for Start Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Start Date here] off begin
				// % protected region % [Add any additional model attribute properties for Start Date here] end
			},
			{
				name: 'endDate',
				// % protected region % [Set displayName for End Date here] off begin
				displayName: 'End Date',
				// % protected region % [Set displayName for End Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for End Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for End Date here] end
				// % protected region % [Set isSensitive for End Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for End Date here] end
				// % protected region % [Set readonly for End Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for End Date here] end
				validators: [
					// % protected region % [Add other validators for End Date here] off begin
					// % protected region % [Add other validators for End Date here] end
				],
				// % protected region % [Add any additional model attribute properties for End Date here] off begin
				// % protected region % [Add any additional model attribute properties for End Date here] end
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
				id: 'baseScheme',
				type: ModelRelationType.MANY,
				name: 'baseSchemeIds',
				// % protected region % [Customise your 1-1 or 1-M label for Base Scheme here] off begin
				label: 'Base Scheme',
				// % protected region % [Customise your 1-1 or 1-M label for Base Scheme here] end
				entityName: 'TariffFormulaModel',
				// % protected region % [Customise your display name for Base Scheme here] off begin
				displayName: 'tariffType',
				// % protected region % [Customise your display name for Base Scheme here] end
				validators: [
					// % protected region % [Add other validators for Base Scheme here] off begin
					// % protected region % [Add other validators for Base Scheme here] end
				],
				// % protected region % [Add any additional field for relation Base Scheme here] off begin
				// % protected region % [Add any additional field for relation Base Scheme here] end
			},
			{
				id: 'invoiceItems',
				type: ModelRelationType.MANY,
				name: 'invoiceItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Items here] off begin
				label: 'Invoice Items',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Items here] end
				entityName: 'InvoiceItemModel',
				// % protected region % [Customise your display name for Invoice Items here] off begin
				displayName: 'transactionDate',
				// % protected region % [Customise your display name for Invoice Items here] end
				validators: [
					// % protected region % [Add other validators for Invoice Items here] off begin
					// % protected region % [Add other validators for Invoice Items here] end
				],
				// % protected region % [Add any additional field for relation Invoice Items here] off begin
				// % protected region % [Add any additional field for relation Invoice Items here] end
			},
			{
				id: 'invoices',
				type: ModelRelationType.MANY,
				name: 'invoicesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices here] off begin
				label: 'Invoices',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices here] end
				entityName: 'InvoiceModel',
				// % protected region % [Customise your display name for Invoices here] off begin
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Invoices here] end
				validators: [
					// % protected region % [Add other validators for Invoices here] off begin
					// % protected region % [Add other validators for Invoices here] end
				],
				// % protected region % [Add any additional field for relation Invoices here] off begin
				// % protected region % [Add any additional field for relation Invoices here] end
			},
			{
				id: 'tariffDefinitions',
				type: ModelRelationType.MANY,
				name: 'tariffDefinitionsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Definitions here] off begin
				label: 'Tariff Definitions',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Definitions here] end
				entityName: 'TariffDefinitionModel',
				// % protected region % [Customise your display name for Tariff Definitions here] off begin
				displayName: 'tariffType',
				// % protected region % [Customise your display name for Tariff Definitions here] end
				validators: [
					// % protected region % [Add other validators for Tariff Definitions here] off begin
					// % protected region % [Add other validators for Tariff Definitions here] end
				],
				// % protected region % [Add any additional field for relation Tariff Definitions here] off begin
				// % protected region % [Add any additional field for relation Tariff Definitions here] end
			},
			{
				id: 'tariffScheme',
				type: ModelRelationType.MANY,
				name: 'tariffSchemeIds',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Scheme here] off begin
				label: 'Tariff Scheme',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Scheme here] end
				entityName: 'TariffFormulaModel',
				// % protected region % [Customise your display name for Tariff Scheme here] off begin
				displayName: 'tariffType',
				// % protected region % [Customise your display name for Tariff Scheme here] end
				validators: [
					// % protected region % [Add other validators for Tariff Scheme here] off begin
					// % protected region % [Add other validators for Tariff Scheme here] end
				],
				// % protected region % [Add any additional field for relation Tariff Scheme here] off begin
				// % protected region % [Add any additional field for relation Tariff Scheme here] end
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
				case 'schemaCode':
					break;
				case 'schemeName':
					break;
				case 'startDate':
					break;
				case 'endDate':
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
	static deepParse(data: string | { [K in keyof TariffSchemaModel]?: TariffSchemaModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TariffSchemaModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.baseScheme) {
			currentModel.baseSchemeIds = json.baseScheme.map(model => model.id);
			returned = _.union(returned, _.flatten(json.baseScheme.map(model => TariffFormulaModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoiceItems) {
			currentModel.invoiceItemsIds = json.invoiceItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoiceItems.map(model => InvoiceItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoices) {
			currentModel.invoicesIds = json.invoices.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoices.map(model => InvoiceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.tariffDefinitions) {
			currentModel.tariffDefinitionsIds = json.tariffDefinitions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.tariffDefinitions.map(model => TariffDefinitionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.tariffScheme) {
			currentModel.tariffSchemeIds = json.tariffScheme.map(model => model.id);
			returned = _.union(returned, _.flatten(json.tariffScheme.map(model => TariffFormulaModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let tariffSchemaModel = new TariffSchemaModel(data);`
	 *
	 * @param data The input data to be initialised as the TariffSchemaModel,
	 *    it is expected as a JSON string or as a nullable TariffSchemaModel.
	 */
	constructor(data?: string | Partial<TariffSchemaModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TariffSchemaModel>
				: data;

			this.schemaCode = json.schemaCode;
			this.schemeName = json.schemeName;
			if (json.startDate) {
				this.startDate = new Date(json.startDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.startDate = json.startDate;
			}
			if (json.endDate) {
				this.endDate = new Date(json.endDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.endDate = json.endDate;
			}
			this.baseSchemeIds = json.baseSchemeIds;
			this.baseScheme = json.baseScheme;
			this.invoiceItemsIds = json.invoiceItemsIds;
			this.invoiceItems = json.invoiceItems;
			this.invoicesIds = json.invoicesIds;
			this.invoices = json.invoices;
			this.tariffDefinitionsIds = json.tariffDefinitionsIds;
			this.tariffDefinitions = json.tariffDefinitions;
			this.tariffSchemeIds = json.tariffSchemeIds;
			this.tariffScheme = json.tariffScheme;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			schemaCode: this.schemaCode,
			schemeName: this.schemeName,
			startDate: this.startDate,
			endDate: this.endDate,
			baseSchemeIds: this.baseSchemeIds,
			invoiceItemsIds: this.invoiceItemsIds,
			invoicesIds: this.invoicesIds,
			tariffDefinitionsIds: this.tariffDefinitionsIds,
			tariffSchemeIds: this.tariffSchemeIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TariffSchemaModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TariffSchemaModel {
		let newModelJson = this.toJSON();

		if (updates.schemaCode) {
			newModelJson.schemaCode = updates.schemaCode;
		}

		if (updates.schemeName) {
			newModelJson.schemeName = updates.schemeName;
		}

		if (updates.startDate) {
			newModelJson.startDate = updates.startDate;
		}

		if (updates.endDate) {
			newModelJson.endDate = updates.endDate;
		}

		if (updates.baseSchemeIds) {
			newModelJson.baseSchemeIds = updates.baseSchemeIds;
		}

		if (updates.invoiceItemsIds) {
			newModelJson.invoiceItemsIds = updates.invoiceItemsIds;
		}

		if (updates.invoicesIds) {
			newModelJson.invoicesIds = updates.invoicesIds;
		}

		if (updates.tariffDefinitionsIds) {
			newModelJson.tariffDefinitionsIds = updates.tariffDefinitionsIds;
		}

		if (updates.tariffSchemeIds) {
			newModelJson.tariffSchemeIds = updates.tariffSchemeIds;
		}

		return new TariffSchemaModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TariffSchemaModel)) {
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
			'baseSchemeIds',
			'baseScheme',
			'invoiceItemsIds',
			'invoiceItems',
			'invoicesIds',
			'invoices',
			'tariffDefinitionsIds',
			'tariffDefinitions',
			'tariffSchemeIds',
			'tariffScheme',
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
