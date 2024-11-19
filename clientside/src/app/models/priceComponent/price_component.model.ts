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
import {InvoiceItemComponentModel} from '../invoiceItemComponent/invoice_item_component.model';
import {MedicalFeeItemComponentModel} from '../medicalFeeItemComponent/medical_fee_item_component.model';
import {TariffDefinitionOtherComponentModel} from '../tariffDefinitionOtherComponent/tariff_definition_other_component.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PriceComponentModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'componentCode',
		'componentName',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'componentCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PriceComponentModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PriceComponentModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Component Code (Max Length: 50).
	 */
	componentCode: string;

	/**
	 * Component Name (Max Length: 250).
	 */
	componentName: string;

	/**
	 * .
	 */
	coaCOGS: string;

	/**
	 * .
	 */
	coaSell: string;

	/**
	 * .
	 */
	coaInventory: string;

	invoiceItemComponentsIds: string[] = [];

	invoiceItemComponents: InvoiceItemComponentModel[];

	medicalFeeItemComponentsIds: string[] = [];

	medicalFeeItemComponents: MedicalFeeItemComponentModel[];

	tariffDefinitionOtherComponentsIds: string[] = [];

	tariffDefinitionOtherComponents: TariffDefinitionOtherComponentModel[];

	modelPropGroups: { [s: string]: Group } = PriceComponentModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'componentCode',
				// % protected region % [Set displayName for Component Code here] off begin
				displayName: 'Component Code',
				// % protected region % [Set displayName for Component Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Component Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Component Code here] end
				// % protected region % [Set isSensitive for Component Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Component Code here] end
				// % protected region % [Set readonly for Component Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Component Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Component Code here] off begin
					// % protected region % [Add other validators for Component Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Component Code here] off begin
				// % protected region % [Add any additional model attribute properties for Component Code here] end
			},
			{
				name: 'componentName',
				// % protected region % [Set displayName for Component Name here] off begin
				displayName: 'Component Name',
				// % protected region % [Set displayName for Component Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Component Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Component Name here] end
				// % protected region % [Set isSensitive for Component Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Component Name here] end
				// % protected region % [Set readonly for Component Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Component Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Component Name here] off begin
					// % protected region % [Add other validators for Component Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Component Name here] off begin
				// % protected region % [Add any additional model attribute properties for Component Name here] end
			},
			{
				name: 'coaCOGS',
				// % protected region % [Set displayName for COA COGS here] off begin
				displayName: 'COA COGS',
				// % protected region % [Set displayName for COA COGS here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for COA COGS here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for COA COGS here] end
				// % protected region % [Set isSensitive for COA COGS here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for COA COGS here] end
				// % protected region % [Set readonly for COA COGS here] off begin
				readOnly: false,
				// % protected region % [Set readonly for COA COGS here] end
				validators: [
					// % protected region % [Add other validators for COA COGS here] off begin
					// % protected region % [Add other validators for COA COGS here] end
				],
				// % protected region % [Add any additional model attribute properties for COA COGS here] off begin
				// % protected region % [Add any additional model attribute properties for COA COGS here] end
			},
			{
				name: 'coaSell',
				// % protected region % [Set displayName for COA Sell here] off begin
				displayName: 'COA Sell',
				// % protected region % [Set displayName for COA Sell here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for COA Sell here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for COA Sell here] end
				// % protected region % [Set isSensitive for COA Sell here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for COA Sell here] end
				// % protected region % [Set readonly for COA Sell here] off begin
				readOnly: false,
				// % protected region % [Set readonly for COA Sell here] end
				validators: [
					// % protected region % [Add other validators for COA Sell here] off begin
					// % protected region % [Add other validators for COA Sell here] end
				],
				// % protected region % [Add any additional model attribute properties for COA Sell here] off begin
				// % protected region % [Add any additional model attribute properties for COA Sell here] end
			},
			{
				name: 'coaInventory',
				// % protected region % [Set displayName for COA Inventory here] off begin
				displayName: 'COA Inventory',
				// % protected region % [Set displayName for COA Inventory here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for COA Inventory here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for COA Inventory here] end
				// % protected region % [Set isSensitive for COA Inventory here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for COA Inventory here] end
				// % protected region % [Set readonly for COA Inventory here] off begin
				readOnly: false,
				// % protected region % [Set readonly for COA Inventory here] end
				validators: [
					// % protected region % [Add other validators for COA Inventory here] off begin
					// % protected region % [Add other validators for COA Inventory here] end
				],
				// % protected region % [Add any additional model attribute properties for COA Inventory here] off begin
				// % protected region % [Add any additional model attribute properties for COA Inventory here] end
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
				id: 'invoiceItemComponents',
				type: ModelRelationType.MANY,
				name: 'invoiceItemComponentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Item Components here] off begin
				label: 'Invoice Item Components',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Item Components here] end
				entityName: 'InvoiceItemComponentModel',
				// % protected region % [Customise your display name for Invoice Item Components here] off begin
				displayName: 'price',
				// % protected region % [Customise your display name for Invoice Item Components here] end
				validators: [
					// % protected region % [Add other validators for Invoice Item Components here] off begin
					// % protected region % [Add other validators for Invoice Item Components here] end
				],
				// % protected region % [Add any additional field for relation Invoice Item Components here] off begin
				// % protected region % [Add any additional field for relation Invoice Item Components here] end
			},
			{
				id: 'medicalFeeItemComponents',
				type: ModelRelationType.MANY,
				name: 'medicalFeeItemComponentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Fee Item Components here] off begin
				label: 'Medical Fee Item Components',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Fee Item Components here] end
				entityName: 'MedicalFeeItemComponentModel',
				// % protected region % [Customise your display name for Medical Fee Item Components here] off begin
				displayName: 'price',
				// % protected region % [Customise your display name for Medical Fee Item Components here] end
				validators: [
					// % protected region % [Add other validators for Medical Fee Item Components here] off begin
					// % protected region % [Add other validators for Medical Fee Item Components here] end
				],
				// % protected region % [Add any additional field for relation Medical Fee Item Components here] off begin
				// % protected region % [Add any additional field for relation Medical Fee Item Components here] end
			},
			{
				id: 'tariffDefinitionOtherComponents',
				type: ModelRelationType.MANY,
				name: 'tariffDefinitionOtherComponentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Definition Other Components here] off begin
				label: 'Tariff Definition Other Components',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Definition Other Components here] end
				entityName: 'TariffDefinitionOtherComponentModel',
				// % protected region % [Customise your display name for Tariff Definition Other Components here] off begin
				displayName: 'price',
				// % protected region % [Customise your display name for Tariff Definition Other Components here] end
				validators: [
					// % protected region % [Add other validators for Tariff Definition Other Components here] off begin
					// % protected region % [Add other validators for Tariff Definition Other Components here] end
				],
				// % protected region % [Add any additional field for relation Tariff Definition Other Components here] off begin
				// % protected region % [Add any additional field for relation Tariff Definition Other Components here] end
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
				case 'componentCode':
					break;
				case 'componentName':
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
	static deepParse(data: string | { [K in keyof PriceComponentModel]?: PriceComponentModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PriceComponentModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.invoiceItemComponents) {
			currentModel.invoiceItemComponentsIds = json.invoiceItemComponents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoiceItemComponents.map(model => InvoiceItemComponentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalFeeItemComponents) {
			currentModel.medicalFeeItemComponentsIds = json.medicalFeeItemComponents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalFeeItemComponents.map(model => MedicalFeeItemComponentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.tariffDefinitionOtherComponents) {
			currentModel.tariffDefinitionOtherComponentsIds = json.tariffDefinitionOtherComponents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.tariffDefinitionOtherComponents.map(model => TariffDefinitionOtherComponentModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let priceComponentModel = new PriceComponentModel(data);`
	 *
	 * @param data The input data to be initialised as the PriceComponentModel,
	 *    it is expected as a JSON string or as a nullable PriceComponentModel.
	 */
	constructor(data?: string | Partial<PriceComponentModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PriceComponentModel>
				: data;

			this.componentCode = json.componentCode;
			this.componentName = json.componentName;
			this.coaCOGS = json.coaCOGS;
			this.coaSell = json.coaSell;
			this.coaInventory = json.coaInventory;
			this.invoiceItemComponentsIds = json.invoiceItemComponentsIds;
			this.invoiceItemComponents = json.invoiceItemComponents;
			this.medicalFeeItemComponentsIds = json.medicalFeeItemComponentsIds;
			this.medicalFeeItemComponents = json.medicalFeeItemComponents;
			this.tariffDefinitionOtherComponentsIds = json.tariffDefinitionOtherComponentsIds;
			this.tariffDefinitionOtherComponents = json.tariffDefinitionOtherComponents;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			componentCode: this.componentCode,
			componentName: this.componentName,
			coaCOGS: this.coaCOGS,
			coaSell: this.coaSell,
			coaInventory: this.coaInventory,
			invoiceItemComponentsIds: this.invoiceItemComponentsIds,
			medicalFeeItemComponentsIds: this.medicalFeeItemComponentsIds,
			tariffDefinitionOtherComponentsIds: this.tariffDefinitionOtherComponentsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PriceComponentModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PriceComponentModel {
		let newModelJson = this.toJSON();

		if (updates.componentCode) {
			newModelJson.componentCode = updates.componentCode;
		}

		if (updates.componentName) {
			newModelJson.componentName = updates.componentName;
		}

		if (updates.coaCOGS) {
			newModelJson.coaCOGS = updates.coaCOGS;
		}

		if (updates.coaSell) {
			newModelJson.coaSell = updates.coaSell;
		}

		if (updates.coaInventory) {
			newModelJson.coaInventory = updates.coaInventory;
		}

		if (updates.invoiceItemComponentsIds) {
			newModelJson.invoiceItemComponentsIds = updates.invoiceItemComponentsIds;
		}

		if (updates.medicalFeeItemComponentsIds) {
			newModelJson.medicalFeeItemComponentsIds = updates.medicalFeeItemComponentsIds;
		}

		if (updates.tariffDefinitionOtherComponentsIds) {
			newModelJson.tariffDefinitionOtherComponentsIds = updates.tariffDefinitionOtherComponentsIds;
		}

		return new PriceComponentModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PriceComponentModel)) {
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
			'invoiceItemComponentsIds',
			'invoiceItemComponents',
			'medicalFeeItemComponentsIds',
			'medicalFeeItemComponents',
			'tariffDefinitionOtherComponentsIds',
			'tariffDefinitionOtherComponents',
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
