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
import {UnitOfMeasurementModel} from '../unitOfMeasurement/unit_of_measurement.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class CatalogueUOMModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'defaultTransaction',
		'defaultStockCard',
		'defaultPurchasing',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'unitName',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'CatalogueUOMModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return CatalogueUOMModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	unitName: string;

	/**
	 * .
	 */
	conversion: string;

	/**
	 * .
	 */
	defaultTransaction: boolean = false;

	/**
	 * .
	 */
	defaultStockCard: boolean = false;

	/**
	 * .
	 */
	defaultPurchasing: boolean = false;

	unitOfMeasurementId: string;

	unitOfMeasurement: UnitOfMeasurementModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	modelPropGroups: { [s: string]: Group } = CatalogueUOMModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'unitName',
				// % protected region % [Set displayName for Unit Name here] off begin
				displayName: 'Unit Name',
				// % protected region % [Set displayName for Unit Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Unit Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Unit Name here] end
				// % protected region % [Set isSensitive for Unit Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit Name here] end
				// % protected region % [Set readonly for Unit Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit Name here] end
				validators: [
					// % protected region % [Add other validators for Unit Name here] off begin
					// % protected region % [Add other validators for Unit Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit Name here] off begin
				// % protected region % [Add any additional model attribute properties for Unit Name here] end
			},
			{
				name: 'conversion',
				// % protected region % [Set displayName for Conversion here] off begin
				displayName: 'Conversion',
				// % protected region % [Set displayName for Conversion here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Conversion here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Conversion here] end
				// % protected region % [Set isSensitive for Conversion here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Conversion here] end
				// % protected region % [Set readonly for Conversion here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Conversion here] end
				validators: [
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Conversion here] off begin
					// % protected region % [Add other validators for Conversion here] end
				],
				// % protected region % [Add any additional model attribute properties for Conversion here] off begin
				// % protected region % [Add any additional model attribute properties for Conversion here] end
			},
			{
				name: 'defaultTransaction',
				// % protected region % [Set displayName for Default Transaction here] off begin
				displayName: 'Default Transaction',
				// % protected region % [Set displayName for Default Transaction here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Default Transaction here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Default Transaction here] end
				// % protected region % [Set isSensitive for Default Transaction here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Default Transaction here] end
				// % protected region % [Set readonly for Default Transaction here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Default Transaction here] end
				validators: [
					// % protected region % [Add other validators for Default Transaction here] off begin
					// % protected region % [Add other validators for Default Transaction here] end
				],
				// % protected region % [Add any additional model attribute properties for Default Transaction here] off begin
				// % protected region % [Add any additional model attribute properties for Default Transaction here] end
			},
			{
				name: 'defaultStockCard',
				// % protected region % [Set displayName for Default Stock Card here] off begin
				displayName: 'Default Stock Card',
				// % protected region % [Set displayName for Default Stock Card here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Default Stock Card here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Default Stock Card here] end
				// % protected region % [Set isSensitive for Default Stock Card here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Default Stock Card here] end
				// % protected region % [Set readonly for Default Stock Card here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Default Stock Card here] end
				validators: [
					// % protected region % [Add other validators for Default Stock Card here] off begin
					// % protected region % [Add other validators for Default Stock Card here] end
				],
				// % protected region % [Add any additional model attribute properties for Default Stock Card here] off begin
				// % protected region % [Add any additional model attribute properties for Default Stock Card here] end
			},
			{
				name: 'defaultPurchasing',
				// % protected region % [Set displayName for Default Purchasing here] off begin
				displayName: 'Default Purchasing',
				// % protected region % [Set displayName for Default Purchasing here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Default Purchasing here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Default Purchasing here] end
				// % protected region % [Set isSensitive for Default Purchasing here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Default Purchasing here] end
				// % protected region % [Set readonly for Default Purchasing here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Default Purchasing here] end
				validators: [
					// % protected region % [Add other validators for Default Purchasing here] off begin
					// % protected region % [Add other validators for Default Purchasing here] end
				],
				// % protected region % [Add any additional model attribute properties for Default Purchasing here] off begin
				// % protected region % [Add any additional model attribute properties for Default Purchasing here] end
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
				id: 'unitOfMeasurement',
				type: ModelRelationType.ONE,
				name: 'unitOfMeasurementId',
				// % protected region % [Customise your 1-1 or 1-M label for Unit Of Measurement here] off begin
				label: 'Unit Of Measurement',
				// % protected region % [Customise your 1-1 or 1-M label for Unit Of Measurement here] end
				entityName: 'UnitOfMeasurementModel',
				// % protected region % [Customise your display name for Unit Of Measurement here] off begin
				displayName: 'unitName',
				// % protected region % [Customise your display name for Unit Of Measurement here] end
				validators: [
					// % protected region % [Add other validators for Unit Of Measurement here] off begin
					// % protected region % [Add other validators for Unit Of Measurement here] end
				],
				// % protected region % [Add any additional field for relation Unit Of Measurement here] off begin
				// % protected region % [Add any additional field for relation Unit Of Measurement here] end
			},
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
				case 'defaultTransaction':
					break;
				case 'defaultStockCard':
					break;
				case 'defaultPurchasing':
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
	static deepParse(data: string | { [K in keyof CatalogueUOMModel]?: CatalogueUOMModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new CatalogueUOMModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.unitOfMeasurement) {
			currentModel.unitOfMeasurementId = json.unitOfMeasurement.id;
			returned = _.union(returned, UnitOfMeasurementModel.deepParse(json.unitOfMeasurement));
		}

		// Incoming one to many
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
	 * `let catalogueUOMModel = new CatalogueUOMModel(data);`
	 *
	 * @param data The input data to be initialised as the CatalogueUOMModel,
	 *    it is expected as a JSON string or as a nullable CatalogueUOMModel.
	 */
	constructor(data?: string | Partial<CatalogueUOMModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<CatalogueUOMModel>
				: data;

			this.unitName = json.unitName;
			this.conversion = json.conversion;
			this.defaultTransaction = json.defaultTransaction;
			this.defaultStockCard = json.defaultStockCard;
			this.defaultPurchasing = json.defaultPurchasing;
			this.unitOfMeasurementId = json.unitOfMeasurementId;
			this.unitOfMeasurement = json.unitOfMeasurement;
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
			unitName: this.unitName,
			conversion: this.conversion,
			defaultTransaction: this.defaultTransaction,
			defaultStockCard: this.defaultStockCard,
			defaultPurchasing: this.defaultPurchasing,
			unitOfMeasurementId: this.unitOfMeasurementId,
			stockCatalogueId: this.stockCatalogueId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		CatalogueUOMModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): CatalogueUOMModel {
		let newModelJson = this.toJSON();

		if (updates.unitName) {
			newModelJson.unitName = updates.unitName;
		}

		if (updates.conversion) {
			newModelJson.conversion = updates.conversion;
		}

		if (updates.defaultTransaction) {
			newModelJson.defaultTransaction = updates.defaultTransaction;
		}

		if (updates.defaultStockCard) {
			newModelJson.defaultStockCard = updates.defaultStockCard;
		}

		if (updates.defaultPurchasing) {
			newModelJson.defaultPurchasing = updates.defaultPurchasing;
		}

		if (updates.unitOfMeasurementId) {
			newModelJson.unitOfMeasurementId = updates.unitOfMeasurementId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		return new CatalogueUOMModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof CatalogueUOMModel)) {
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
			'unitOfMeasurementId',
			'unitOfMeasurement',
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
		if (!this.unitOfMeasurement) {
			this.unitOfMeasurementId = null;
		} else {
			this.unitOfMeasurementId = this.unitOfMeasurement.id;
		}

		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
