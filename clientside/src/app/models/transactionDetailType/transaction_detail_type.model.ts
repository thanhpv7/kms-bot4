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
import {InventoryAdjustmentModel} from '../inventoryAdjustment/inventory_adjustment.model';
import {StockTransactionDetailModel} from '../stockTransactionDetail/stock_transaction_detail.model';
import {StockTransactionPerDateTypeModel} from '../stockTransactionPerDateType/stock_transaction_per_date_type.model';
import {TransactionDetailTypeMappingModel} from '../transactionDetailTypeMapping/transaction_detail_type_mapping.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class TransactionDetailTypeModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'transactionDetail',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'transactionDetail',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'TransactionDetailTypeModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TransactionDetailTypeModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	transactionDetail: string;

	/**
	 * .
	 */
	notes: string;

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

	inventoryAdjustmentsIds: string[] = [];

	inventoryAdjustments: InventoryAdjustmentModel[];

	stockTransactionDetailsIds: string[] = [];

	stockTransactionDetails: StockTransactionDetailModel[];

	stockTransactionPerDateTypesIds: string[] = [];

	stockTransactionPerDateTypes: StockTransactionPerDateTypeModel[];

	transactionDetailTypeMappingsIds: string[] = [];

	transactionDetailTypeMappings: TransactionDetailTypeMappingModel[];

	modelPropGroups: { [s: string]: Group } = TransactionDetailTypeModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'transactionDetail',
				// % protected region % [Set displayName for Transaction Detail here] off begin
				displayName: 'Transaction Detail',
				// % protected region % [Set displayName for Transaction Detail here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Detail here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Detail here] end
				// % protected region % [Set isSensitive for Transaction Detail here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Detail here] end
				// % protected region % [Set readonly for Transaction Detail here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Detail here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Transaction Detail here] off begin
					// % protected region % [Add other validators for Transaction Detail here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Detail here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Detail here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.INPUT,
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
				id: 'inventoryAdjustments',
				type: ModelRelationType.MANY,
				name: 'inventoryAdjustmentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjustments here] off begin
				label: 'Inventory Adjustments',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjustments here] end
				entityName: 'InventoryAdjustmentModel',
				// % protected region % [Customise your display name for Inventory Adjustments here] off begin
				displayName: 'adjustmentNumber',
				// % protected region % [Customise your display name for Inventory Adjustments here] end
				validators: [
					// % protected region % [Add other validators for Inventory Adjustments here] off begin
					// % protected region % [Add other validators for Inventory Adjustments here] end
				],
				// % protected region % [Add any additional field for relation Inventory Adjustments here] off begin
				// % protected region % [Add any additional field for relation Inventory Adjustments here] end
			},
			{
				id: 'stockTransactionDetails',
				type: ModelRelationType.MANY,
				name: 'stockTransactionDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Details here] off begin
				label: 'Stock Transaction Details',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Details here] end
				entityName: 'StockTransactionDetailModel',
				// % protected region % [Customise your display name for Stock Transaction Details here] off begin
				displayName: 'transactionNumber',
				// % protected region % [Customise your display name for Stock Transaction Details here] end
				validators: [
					// % protected region % [Add other validators for Stock Transaction Details here] off begin
					// % protected region % [Add other validators for Stock Transaction Details here] end
				],
				// % protected region % [Add any additional field for relation Stock Transaction Details here] off begin
				// % protected region % [Add any additional field for relation Stock Transaction Details here] end
			},
			{
				id: 'stockTransactionPerDateTypes',
				type: ModelRelationType.MANY,
				name: 'stockTransactionPerDateTypesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Per Date Types here] off begin
				label: 'Stock Transaction Per Date Types',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Per Date Types here] end
				entityName: 'StockTransactionPerDateTypeModel',
				// % protected region % [Customise your display name for Stock Transaction Per Date Types here] off begin
				displayName: 'asOfDate',
				// % protected region % [Customise your display name for Stock Transaction Per Date Types here] end
				validators: [
					// % protected region % [Add other validators for Stock Transaction Per Date Types here] off begin
					// % protected region % [Add other validators for Stock Transaction Per Date Types here] end
				],
				// % protected region % [Add any additional field for relation Stock Transaction Per Date Types here] off begin
				// % protected region % [Add any additional field for relation Stock Transaction Per Date Types here] end
			},
			{
				id: 'transactionDetailTypeMappings',
				type: ModelRelationType.MANY,
				name: 'transactionDetailTypeMappingsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Transaction Detail Type Mappings here] off begin
				label: 'Transaction Detail Type Mappings',
				// % protected region % [Customise your 1-1 or 1-M label for Transaction Detail Type Mappings here] end
				entityName: 'TransactionDetailTypeMappingModel',
				// % protected region % [Customise your display name for Transaction Detail Type Mappings here] off begin
				displayName: 'transactionType',
				// % protected region % [Customise your display name for Transaction Detail Type Mappings here] end
				validators: [
					// % protected region % [Add other validators for Transaction Detail Type Mappings here] off begin
					// % protected region % [Add other validators for Transaction Detail Type Mappings here] end
				],
				// % protected region % [Add any additional field for relation Transaction Detail Type Mappings here] off begin
				// % protected region % [Add any additional field for relation Transaction Detail Type Mappings here] end
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
				case 'transactionDetail':
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
	static deepParse(data: string | { [K in keyof TransactionDetailTypeModel]?: TransactionDetailTypeModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TransactionDetailTypeModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.inventoryAdjustments) {
			currentModel.inventoryAdjustmentsIds = json.inventoryAdjustments.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inventoryAdjustments.map(model => InventoryAdjustmentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.stockTransactionDetails) {
			currentModel.stockTransactionDetailsIds = json.stockTransactionDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockTransactionDetails.map(model => StockTransactionDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.stockTransactionPerDateTypes) {
			currentModel.stockTransactionPerDateTypesIds = json.stockTransactionPerDateTypes.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockTransactionPerDateTypes.map(model => StockTransactionPerDateTypeModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.transactionDetailTypeMappings) {
			currentModel.transactionDetailTypeMappingsIds = json.transactionDetailTypeMappings.map(model => model.id);
			returned = _.union(returned, _.flatten(json.transactionDetailTypeMappings.map(model => TransactionDetailTypeMappingModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let transactionDetailTypeModel = new TransactionDetailTypeModel(data);`
	 *
	 * @param data The input data to be initialised as the TransactionDetailTypeModel,
	 *    it is expected as a JSON string or as a nullable TransactionDetailTypeModel.
	 */
	constructor(data?: string | Partial<TransactionDetailTypeModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TransactionDetailTypeModel>
				: data;

			this.transactionDetail = json.transactionDetail;
			this.notes = json.notes;
			this.coaCOGS = json.coaCOGS;
			this.coaSell = json.coaSell;
			this.coaInventory = json.coaInventory;
			this.inventoryAdjustmentsIds = json.inventoryAdjustmentsIds;
			this.inventoryAdjustments = json.inventoryAdjustments;
			this.stockTransactionDetailsIds = json.stockTransactionDetailsIds;
			this.stockTransactionDetails = json.stockTransactionDetails;
			this.stockTransactionPerDateTypesIds = json.stockTransactionPerDateTypesIds;
			this.stockTransactionPerDateTypes = json.stockTransactionPerDateTypes;
			this.transactionDetailTypeMappingsIds = json.transactionDetailTypeMappingsIds;
			this.transactionDetailTypeMappings = json.transactionDetailTypeMappings;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			transactionDetail: this.transactionDetail,
			notes: this.notes,
			coaCOGS: this.coaCOGS,
			coaSell: this.coaSell,
			coaInventory: this.coaInventory,
			inventoryAdjustmentsIds: this.inventoryAdjustmentsIds,
			stockTransactionDetailsIds: this.stockTransactionDetailsIds,
			stockTransactionPerDateTypesIds: this.stockTransactionPerDateTypesIds,
			transactionDetailTypeMappingsIds: this.transactionDetailTypeMappingsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TransactionDetailTypeModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TransactionDetailTypeModel {
		let newModelJson = this.toJSON();

		if (updates.transactionDetail) {
			newModelJson.transactionDetail = updates.transactionDetail;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
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

		if (updates.inventoryAdjustmentsIds) {
			newModelJson.inventoryAdjustmentsIds = updates.inventoryAdjustmentsIds;
		}

		if (updates.stockTransactionDetailsIds) {
			newModelJson.stockTransactionDetailsIds = updates.stockTransactionDetailsIds;
		}

		if (updates.stockTransactionPerDateTypesIds) {
			newModelJson.stockTransactionPerDateTypesIds = updates.stockTransactionPerDateTypesIds;
		}

		if (updates.transactionDetailTypeMappingsIds) {
			newModelJson.transactionDetailTypeMappingsIds = updates.transactionDetailTypeMappingsIds;
		}

		return new TransactionDetailTypeModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TransactionDetailTypeModel)) {
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
			'inventoryAdjustmentsIds',
			'inventoryAdjustments',
			'stockTransactionDetailsIds',
			'stockTransactionDetails',
			'stockTransactionPerDateTypesIds',
			'stockTransactionPerDateTypes',
			'transactionDetailTypeMappingsIds',
			'transactionDetailTypeMappings',
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
