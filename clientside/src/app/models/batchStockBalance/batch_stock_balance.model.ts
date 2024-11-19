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
import {WarehouseModel} from '../warehouse/warehouse.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BatchStockBalanceModel extends AbstractModel {
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
		'sourceNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BatchStockBalanceModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BatchStockBalanceModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	sourceNumber: string;

	/**
	 * .
	 */
	batchNo: string;

	/**
	 * .
	 */
	expirationDate: Date;

	/**
	 * .
	 */
	batchQtyUoi: number;

	/**
	 * .
	 */
	uoi: string;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	modelPropGroups: { [s: string]: Group } = BatchStockBalanceModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'sourceNumber',
				// % protected region % [Set displayName for Source Number here] off begin
				displayName: 'Source Number',
				// % protected region % [Set displayName for Source Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Source Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Source Number here] end
				// % protected region % [Set isSensitive for Source Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Number here] end
				// % protected region % [Set readonly for Source Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Number here] end
				validators: [
					// % protected region % [Add other validators for Source Number here] off begin
					// % protected region % [Add other validators for Source Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Number here] off begin
				// % protected region % [Add any additional model attribute properties for Source Number here] end
			},
			{
				name: 'batchNo',
				// % protected region % [Set displayName for Batch No here] off begin
				displayName: 'Batch No',
				// % protected region % [Set displayName for Batch No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Batch No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Batch No here] end
				// % protected region % [Set isSensitive for Batch No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Batch No here] end
				// % protected region % [Set readonly for Batch No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Batch No here] end
				validators: [
					// % protected region % [Add other validators for Batch No here] off begin
					// % protected region % [Add other validators for Batch No here] end
				],
				// % protected region % [Add any additional model attribute properties for Batch No here] off begin
				// % protected region % [Add any additional model attribute properties for Batch No here] end
			},
			{
				name: 'expirationDate',
				// % protected region % [Set displayName for Expiration Date here] off begin
				displayName: 'Expiration Date',
				// % protected region % [Set displayName for Expiration Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Expiration Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Expiration Date here] end
				// % protected region % [Set isSensitive for Expiration Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Expiration Date here] end
				// % protected region % [Set readonly for Expiration Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Expiration Date here] end
				validators: [
					// % protected region % [Add other validators for Expiration Date here] off begin
					// % protected region % [Add other validators for Expiration Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Expiration Date here] off begin
				// % protected region % [Add any additional model attribute properties for Expiration Date here] end
			},
			{
				name: 'batchQtyUoi',
				// % protected region % [Set displayName for Batch Qty Uoi here] off begin
				displayName: 'Batch Qty Uoi',
				// % protected region % [Set displayName for Batch Qty Uoi here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Batch Qty Uoi here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Batch Qty Uoi here] end
				// % protected region % [Set isSensitive for Batch Qty Uoi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Batch Qty Uoi here] end
				// % protected region % [Set readonly for Batch Qty Uoi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Batch Qty Uoi here] end
				validators: [
					// % protected region % [Add other validators for Batch Qty Uoi here] off begin
					// % protected region % [Add other validators for Batch Qty Uoi here] end
				],
				// % protected region % [Add any additional model attribute properties for Batch Qty Uoi here] off begin
				// % protected region % [Add any additional model attribute properties for Batch Qty Uoi here] end
			},
			{
				name: 'uoi',
				// % protected region % [Set displayName for Uoi here] off begin
				displayName: 'Uoi',
				// % protected region % [Set displayName for Uoi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Uoi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Uoi here] end
				// % protected region % [Set isSensitive for Uoi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Uoi here] end
				// % protected region % [Set readonly for Uoi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Uoi here] end
				validators: [
					// % protected region % [Add other validators for Uoi here] off begin
					// % protected region % [Add other validators for Uoi here] end
				],
				// % protected region % [Add any additional model attribute properties for Uoi here] off begin
				// % protected region % [Add any additional model attribute properties for Uoi here] end
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
			{
				id: 'warehouse',
				type: ModelRelationType.ONE,
				name: 'warehouseId',
				// % protected region % [Customise your label for Warehouse here] off begin
				label: 'Warehouse',
				// % protected region % [Customise your label for Warehouse here] end
				entityName: 'WarehouseModel',
				// % protected region % [Customise your display name for Warehouse here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'warehouseNumber',
				// % protected region % [Customise your display name for Warehouse here] end
				validators: [
					// % protected region % [Add other validators for Warehouse here] off begin
					// % protected region % [Add other validators for Warehouse here] end
				],
				// % protected region % [Add any additional field for relation Warehouse here] off begin
				// % protected region % [Add any additional field for relation Warehouse here] end
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
	static deepParse(data: string | { [K in keyof BatchStockBalanceModel]?: BatchStockBalanceModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BatchStockBalanceModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let batchStockBalanceModel = new BatchStockBalanceModel(data);`
	 *
	 * @param data The input data to be initialised as the BatchStockBalanceModel,
	 *    it is expected as a JSON string or as a nullable BatchStockBalanceModel.
	 */
	constructor(data?: string | Partial<BatchStockBalanceModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BatchStockBalanceModel>
				: data;

			this.sourceNumber = json.sourceNumber;
			this.batchNo = json.batchNo;
			if (json.expirationDate) {
				this.expirationDate = new Date(json.expirationDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.expirationDate = json.expirationDate;
			}
			this.batchQtyUoi = json.batchQtyUoi;
			this.uoi = json.uoi;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			sourceNumber: this.sourceNumber,
			batchNo: this.batchNo,
			expirationDate: this.expirationDate,
			batchQtyUoi: this.batchQtyUoi,
			uoi: this.uoi,
			stockCatalogueId: this.stockCatalogueId,
			warehouseId: this.warehouseId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BatchStockBalanceModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BatchStockBalanceModel {
		let newModelJson = this.toJSON();

		if (updates.sourceNumber) {
			newModelJson.sourceNumber = updates.sourceNumber;
		}

		if (updates.batchNo) {
			newModelJson.batchNo = updates.batchNo;
		}

		if (updates.expirationDate) {
			newModelJson.expirationDate = updates.expirationDate;
		}

		if (updates.batchQtyUoi) {
			newModelJson.batchQtyUoi = updates.batchQtyUoi;
		}

		if (updates.uoi) {
			newModelJson.uoi = updates.uoi;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		return new BatchStockBalanceModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BatchStockBalanceModel)) {
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
			'warehouseId',
			'warehouse',
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

		if (!this.warehouse) {
			this.warehouseId = null;
		} else {
			this.warehouseId = this.warehouse.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
