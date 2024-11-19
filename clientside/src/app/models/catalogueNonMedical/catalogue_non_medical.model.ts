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
import {StockCatalogueModel} from '../stockCatalogue/stock_catalogue.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class CatalogueNonMedicalModel extends AbstractModel {
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
		'manufacturer',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'CatalogueNonMedicalModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return CatalogueNonMedicalModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Manufacturer (Max Length: 250).
	 */
	manufacturer: string;

	/**
	 * Manufacturer Item Number (Max Length: 50).
	 */
	manufacturerItemNumber: string;

	/**
	 * Indicator of Expensive Item.
	 */
	isExpensiveItem: boolean = false;

	/**
	 * Indicator of Consignment Item.
	 */
	isConsignmentItem: boolean = false;

	/**
	 * .
	 */
	model: string;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	modelPropGroups: { [s: string]: Group } = CatalogueNonMedicalModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'manufacturer',
				// % protected region % [Set displayName for Manufacturer here] off begin
				displayName: 'Manufacturer',
				// % protected region % [Set displayName for Manufacturer here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Manufacturer here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Manufacturer here] end
				// % protected region % [Set isSensitive for Manufacturer here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Manufacturer here] end
				// % protected region % [Set readonly for Manufacturer here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Manufacturer here] end
				validators: [
					// % protected region % [Add other validators for Manufacturer here] off begin
					// % protected region % [Add other validators for Manufacturer here] end
				],
				// % protected region % [Add any additional model attribute properties for Manufacturer here] off begin
				// % protected region % [Add any additional model attribute properties for Manufacturer here] end
			},
			{
				name: 'manufacturerItemNumber',
				// % protected region % [Set displayName for Manufacturer Item Number here] off begin
				displayName: 'Manufacturer Item Number',
				// % protected region % [Set displayName for Manufacturer Item Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Manufacturer Item Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Manufacturer Item Number here] end
				// % protected region % [Set isSensitive for Manufacturer Item Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Manufacturer Item Number here] end
				// % protected region % [Set readonly for Manufacturer Item Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Manufacturer Item Number here] end
				validators: [
					// % protected region % [Add other validators for Manufacturer Item Number here] off begin
					// % protected region % [Add other validators for Manufacturer Item Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Manufacturer Item Number here] off begin
				// % protected region % [Add any additional model attribute properties for Manufacturer Item Number here] end
			},
			{
				name: 'isExpensiveItem',
				// % protected region % [Set displayName for Is Expensive Item here] off begin
				displayName: 'Is Expensive Item',
				// % protected region % [Set displayName for Is Expensive Item here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Expensive Item here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Expensive Item here] end
				// % protected region % [Set isSensitive for Is Expensive Item here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Expensive Item here] end
				// % protected region % [Set readonly for Is Expensive Item here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Expensive Item here] end
				validators: [
					// % protected region % [Add other validators for Is Expensive Item here] off begin
					// % protected region % [Add other validators for Is Expensive Item here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Expensive Item here] off begin
				// % protected region % [Add any additional model attribute properties for Is Expensive Item here] end
			},
			{
				name: 'isConsignmentItem',
				// % protected region % [Set displayName for Is Consignment Item here] off begin
				displayName: 'Is Consignment Item',
				// % protected region % [Set displayName for Is Consignment Item here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Consignment Item here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Consignment Item here] end
				// % protected region % [Set isSensitive for Is Consignment Item here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Consignment Item here] end
				// % protected region % [Set readonly for Is Consignment Item here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Consignment Item here] end
				validators: [
					// % protected region % [Add other validators for Is Consignment Item here] off begin
					// % protected region % [Add other validators for Is Consignment Item here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Consignment Item here] off begin
				// % protected region % [Add any additional model attribute properties for Is Consignment Item here] end
			},
			{
				name: 'model',
				// % protected region % [Set displayName for Model here] off begin
				displayName: 'Model',
				// % protected region % [Set displayName for Model here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Model here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Model here] end
				// % protected region % [Set isSensitive for Model here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Model here] end
				// % protected region % [Set readonly for Model here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Model here] end
				validators: [
					// % protected region % [Add other validators for Model here] off begin
					// % protected region % [Add other validators for Model here] end
				],
				// % protected region % [Add any additional model attribute properties for Model here] off begin
				// % protected region % [Add any additional model attribute properties for Model here] end
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
				id: 'stockCatalogue',
				type: ModelRelationType.ONE,
				name: 'stockCatalogueId',
				// % protected region % [Customise your label for Stock Catalogue here] off begin
				label: 'Stock Catalogue',
				// % protected region % [Customise your label for Stock Catalogue here] end
				entityName: 'StockCatalogueModel',
				// % protected region % [Customise your display name for Stock Catalogue here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'trackable',
				// % protected region % [Customise your display name for Stock Catalogue here] end
				validators: [
					// % protected region % [Add other validators for Stock Catalogue here] off begin
					// % protected region % [Add other validators for Stock Catalogue here] end
				],
				// % protected region % [Add any additional field for relation Stock Catalogue here] off begin
				// % protected region % [Add any additional field for relation Stock Catalogue here] end
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
	static deepParse(data: string | { [K in keyof CatalogueNonMedicalModel]?: CatalogueNonMedicalModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new CatalogueNonMedicalModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let catalogueNonMedicalModel = new CatalogueNonMedicalModel(data);`
	 *
	 * @param data The input data to be initialised as the CatalogueNonMedicalModel,
	 *    it is expected as a JSON string or as a nullable CatalogueNonMedicalModel.
	 */
	constructor(data?: string | Partial<CatalogueNonMedicalModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<CatalogueNonMedicalModel>
				: data;

			this.manufacturer = json.manufacturer;
			this.manufacturerItemNumber = json.manufacturerItemNumber;
			this.isExpensiveItem = json.isExpensiveItem;
			this.isConsignmentItem = json.isConsignmentItem;
			this.model = json.model;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			manufacturer: this.manufacturer,
			manufacturerItemNumber: this.manufacturerItemNumber,
			isExpensiveItem: this.isExpensiveItem,
			isConsignmentItem: this.isConsignmentItem,
			model: this.model,
			stockCatalogueId: this.stockCatalogueId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		CatalogueNonMedicalModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): CatalogueNonMedicalModel {
		let newModelJson = this.toJSON();

		if (updates.manufacturer) {
			newModelJson.manufacturer = updates.manufacturer;
		}

		if (updates.manufacturerItemNumber) {
			newModelJson.manufacturerItemNumber = updates.manufacturerItemNumber;
		}

		if (updates.isExpensiveItem) {
			newModelJson.isExpensiveItem = updates.isExpensiveItem;
		}

		if (updates.isConsignmentItem) {
			newModelJson.isConsignmentItem = updates.isConsignmentItem;
		}

		if (updates.model) {
			newModelJson.model = updates.model;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		return new CatalogueNonMedicalModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof CatalogueNonMedicalModel)) {
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
			'stockCatalogueId',
			'stockCatalogue',
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
		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
