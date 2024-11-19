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
export class BpjsPcareDPHOModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'kdobat',
		'nmobat',
		'sedia',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'kdobat',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPcareDPHOModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPcareDPHOModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	kdobat: string;

	/**
	 * .
	 */
	nmobat: string;

	/**
	 * .
	 */
	sedia: string;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	modelPropGroups: { [s: string]: Group } = BpjsPcareDPHOModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'kdobat',
				// % protected region % [Set displayName for kdObat here] off begin
				displayName: 'kdObat',
				// % protected region % [Set displayName for kdObat here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdObat here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdObat here] end
				// % protected region % [Set isSensitive for kdObat here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdObat here] end
				// % protected region % [Set readonly for kdObat here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdObat here] end
				validators: [
					// % protected region % [Add other validators for kdObat here] off begin
					// % protected region % [Add other validators for kdObat here] end
				],
				// % protected region % [Add any additional model attribute properties for kdObat here] off begin
				// % protected region % [Add any additional model attribute properties for kdObat here] end
			},
			{
				name: 'nmobat',
				// % protected region % [Set displayName for nmObat here] off begin
				displayName: 'nmObat',
				// % protected region % [Set displayName for nmObat here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmObat here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmObat here] end
				// % protected region % [Set isSensitive for nmObat here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmObat here] end
				// % protected region % [Set readonly for nmObat here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmObat here] end
				validators: [
					// % protected region % [Add other validators for nmObat here] off begin
					// % protected region % [Add other validators for nmObat here] end
				],
				// % protected region % [Add any additional model attribute properties for nmObat here] off begin
				// % protected region % [Add any additional model attribute properties for nmObat here] end
			},
			{
				name: 'sedia',
				// % protected region % [Set displayName for Sedia here] off begin
				displayName: 'Sedia',
				// % protected region % [Set displayName for Sedia here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sedia here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sedia here] end
				// % protected region % [Set isSensitive for Sedia here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sedia here] end
				// % protected region % [Set readonly for Sedia here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sedia here] end
				validators: [
					// % protected region % [Add other validators for Sedia here] off begin
					// % protected region % [Add other validators for Sedia here] end
				],
				// % protected region % [Add any additional model attribute properties for Sedia here] off begin
				// % protected region % [Add any additional model attribute properties for Sedia here] end
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
				// % protected region % [Customise your 1-1 or 1-M label for Stock Catalogue here] off begin
				label: 'Stock Catalogue',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Catalogue here] end
				entityName: 'StockCatalogueModel',
				// % protected region % [Customise your display name for Stock Catalogue here] off begin
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
				case 'kdobat':
					break;
				case 'nmobat':
					break;
				case 'sedia':
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
	static deepParse(data: string | { [K in keyof BpjsPcareDPHOModel]?: BpjsPcareDPHOModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPcareDPHOModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
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
	 * `let bpjsPcareDPHOModel = new BpjsPcareDPHOModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPcareDPHOModel,
	 *    it is expected as a JSON string or as a nullable BpjsPcareDPHOModel.
	 */
	constructor(data?: string | Partial<BpjsPcareDPHOModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPcareDPHOModel>
				: data;

			this.kdobat = json.kdobat;
			this.nmobat = json.nmobat;
			this.sedia = json.sedia;
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
			kdobat: this.kdobat,
			nmobat: this.nmobat,
			sedia: this.sedia,
			stockCatalogueId: this.stockCatalogueId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPcareDPHOModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPcareDPHOModel {
		let newModelJson = this.toJSON();

		if (updates.kdobat) {
			newModelJson.kdobat = updates.kdobat;
		}

		if (updates.nmobat) {
			newModelJson.nmobat = updates.nmobat;
		}

		if (updates.sedia) {
			newModelJson.sedia = updates.sedia;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		return new BpjsPcareDPHOModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPcareDPHOModel)) {
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
