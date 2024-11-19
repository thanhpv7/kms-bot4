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
import {BpjsPRBDetailModel} from '../bpjsPRBDetail/bpjs_prb_detail.model';
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
export class BpjsDrugGenericPRBModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'refDrugCode',
		'refDrugName',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'refDrugCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsDrugGenericPRBModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsDrugGenericPRBModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Kode.
	 */
	refDrugCode: string;

	/**
	 * Nama.
	 */
	refDrugName: string;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	bpjsPRBDetailsIds: string[] = [];

	bpjsPRBDetails: BpjsPRBDetailModel[];

	modelPropGroups: { [s: string]: Group } = BpjsDrugGenericPRBModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'refDrugCode',
				// % protected region % [Set displayName for Ref Drug Code here] off begin
				displayName: 'Ref Drug Code',
				// % protected region % [Set displayName for Ref Drug Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ref Drug Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ref Drug Code here] end
				// % protected region % [Set isSensitive for Ref Drug Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ref Drug Code here] end
				// % protected region % [Set readonly for Ref Drug Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ref Drug Code here] end
				validators: [
					// % protected region % [Add other validators for Ref Drug Code here] off begin
					// % protected region % [Add other validators for Ref Drug Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Drug Code here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Drug Code here] end
			},
			{
				name: 'refDrugName',
				// % protected region % [Set displayName for Ref Drug Name here] off begin
				displayName: 'Ref Drug Name',
				// % protected region % [Set displayName for Ref Drug Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ref Drug Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ref Drug Name here] end
				// % protected region % [Set isSensitive for Ref Drug Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ref Drug Name here] end
				// % protected region % [Set readonly for Ref Drug Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ref Drug Name here] end
				validators: [
					// % protected region % [Add other validators for Ref Drug Name here] off begin
					// % protected region % [Add other validators for Ref Drug Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Drug Name here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Drug Name here] end
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
				id: 'bpjsPRBDetails',
				type: ModelRelationType.MANY,
				name: 'bpjsPRBDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS PRB Details here] off begin
				label: 'BPJS PRB Details',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS PRB Details here] end
				entityName: 'BpjsPRBDetailModel',
				// % protected region % [Customise your display name for BPJS PRB Details here] off begin
				displayName: 'srbNo',
				// % protected region % [Customise your display name for BPJS PRB Details here] end
				validators: [
					// % protected region % [Add other validators for BPJS PRB Details here] off begin
					// % protected region % [Add other validators for BPJS PRB Details here] end
				],
				// % protected region % [Add any additional field for relation BPJS PRB Details here] off begin
				// % protected region % [Add any additional field for relation BPJS PRB Details here] end
			},
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
				case 'refDrugCode':
					break;
				case 'refDrugName':
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
	static deepParse(data: string | { [K in keyof BpjsDrugGenericPRBModel]?: BpjsDrugGenericPRBModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsDrugGenericPRBModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Outgoing one to many
		if (json.bpjsPRBDetails) {
			currentModel.bpjsPRBDetailsIds = json.bpjsPRBDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsPRBDetails.map(model => BpjsPRBDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsDrugGenericPRBModel = new BpjsDrugGenericPRBModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsDrugGenericPRBModel,
	 *    it is expected as a JSON string or as a nullable BpjsDrugGenericPRBModel.
	 */
	constructor(data?: string | Partial<BpjsDrugGenericPRBModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsDrugGenericPRBModel>
				: data;

			this.refDrugCode = json.refDrugCode;
			this.refDrugName = json.refDrugName;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.bpjsPRBDetailsIds = json.bpjsPRBDetailsIds;
			this.bpjsPRBDetails = json.bpjsPRBDetails;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			refDrugCode: this.refDrugCode,
			refDrugName: this.refDrugName,
			stockCatalogueId: this.stockCatalogueId,
			bpjsPRBDetailsIds: this.bpjsPRBDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsDrugGenericPRBModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsDrugGenericPRBModel {
		let newModelJson = this.toJSON();

		if (updates.refDrugCode) {
			newModelJson.refDrugCode = updates.refDrugCode;
		}

		if (updates.refDrugName) {
			newModelJson.refDrugName = updates.refDrugName;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.bpjsPRBDetailsIds) {
			newModelJson.bpjsPRBDetailsIds = updates.bpjsPRBDetailsIds;
		}

		return new BpjsDrugGenericPRBModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsDrugGenericPRBModel)) {
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
			'bpjsPRBDetailsIds',
			'bpjsPRBDetails',
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
