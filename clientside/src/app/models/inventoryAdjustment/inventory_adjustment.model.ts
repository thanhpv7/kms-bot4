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
import {InventoryAdjustmentItemModel} from '../inventoryAdjustmentItem/inventory_adjustment_item.model';
import {TransactionDetailTypeModel} from '../transactionDetailType/transaction_detail_type.model';
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
export class InventoryAdjustmentModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'adjustmentNumber',
		'transactionType',
		'referenceNumber',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'adjustmentNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InventoryAdjustmentModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InventoryAdjustmentModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	adjustmentNumber: string;

	/**
	 * Ref Data.
	 */
	approvalStatus: string;

	/**
	 * .
	 */
	transactionDate: Date;

	/**
	 * Can be refer to transaction detail type mapping list.
	 */
	transactionType: string;

	/**
	 * .
	 */
	referenceNumber: string;

	/**
	 * .
	 */
	notes: string;

	/**
	 * .
	 */
	voidDate: Date;

	/**
	 * .
	 */
	voidReason: string;

	/**
	 * .
	 */
	adjustmentType: string;

	transactionDetailTypeId: string;

	transactionDetailType: TransactionDetailTypeModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	inventoryAdjustmentItemsIds: string[] = [];

	inventoryAdjustmentItems: InventoryAdjustmentItemModel[];

	modelPropGroups: { [s: string]: Group } = InventoryAdjustmentModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'adjustmentNumber',
				// % protected region % [Set displayName for Adjustment Number here] off begin
				displayName: 'Adjustment Number',
				// % protected region % [Set displayName for Adjustment Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Adjustment Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Adjustment Number here] end
				// % protected region % [Set isSensitive for Adjustment Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Adjustment Number here] end
				// % protected region % [Set readonly for Adjustment Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Adjustment Number here] end
				validators: [
					// % protected region % [Add other validators for Adjustment Number here] off begin
					// % protected region % [Add other validators for Adjustment Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Adjustment Number here] off begin
				// % protected region % [Add any additional model attribute properties for Adjustment Number here] end
			},
			{
				name: 'approvalStatus',
				// % protected region % [Set displayName for Approval Status here] off begin
				displayName: 'Approval Status',
				// % protected region % [Set displayName for Approval Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Approval Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Approval Status here] end
				// % protected region % [Set isSensitive for Approval Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approval Status here] end
				// % protected region % [Set readonly for Approval Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approval Status here] end
				validators: [
					// % protected region % [Add other validators for Approval Status here] off begin
					// % protected region % [Add other validators for Approval Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Approval Status here] off begin
				// % protected region % [Add any additional model attribute properties for Approval Status here] end
			},
			{
				name: 'transactionDate',
				// % protected region % [Set displayName for Transaction Date here] off begin
				displayName: 'Transaction Date',
				// % protected region % [Set displayName for Transaction Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Transaction Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Transaction Date here] end
				// % protected region % [Set isSensitive for Transaction Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Date here] end
				// % protected region % [Set readonly for Transaction Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Date here] end
				validators: [
					// % protected region % [Add other validators for Transaction Date here] off begin
					// % protected region % [Add other validators for Transaction Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Date here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Date here] end
			},
			{
				name: 'transactionType',
				// % protected region % [Set displayName for Transaction Type here] off begin
				displayName: 'Transaction Type',
				// % protected region % [Set displayName for Transaction Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Type here] end
				// % protected region % [Set isSensitive for Transaction Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Type here] end
				// % protected region % [Set readonly for Transaction Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Type here] end
				validators: [
					// % protected region % [Add other validators for Transaction Type here] off begin
					// % protected region % [Add other validators for Transaction Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Type here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Type here] end
			},
			{
				name: 'referenceNumber',
				// % protected region % [Set displayName for Reference Number here] off begin
				displayName: 'Reference Number',
				// % protected region % [Set displayName for Reference Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Reference Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Reference Number here] end
				// % protected region % [Set isSensitive for Reference Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reference Number here] end
				// % protected region % [Set readonly for Reference Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reference Number here] end
				validators: [
					// % protected region % [Add other validators for Reference Number here] off begin
					// % protected region % [Add other validators for Reference Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Reference Number here] off begin
				// % protected region % [Add any additional model attribute properties for Reference Number here] end
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
				name: 'voidDate',
				// % protected region % [Set displayName for Void Date here] off begin
				displayName: 'Void Date',
				// % protected region % [Set displayName for Void Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Void Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Void Date here] end
				// % protected region % [Set isSensitive for Void Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Void Date here] end
				// % protected region % [Set readonly for Void Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Void Date here] end
				validators: [
					// % protected region % [Add other validators for Void Date here] off begin
					// % protected region % [Add other validators for Void Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Void Date here] off begin
				// % protected region % [Add any additional model attribute properties for Void Date here] end
			},
			{
				name: 'voidReason',
				// % protected region % [Set displayName for Void Reason here] off begin
				displayName: 'Void Reason',
				// % protected region % [Set displayName for Void Reason here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Void Reason here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Void Reason here] end
				// % protected region % [Set isSensitive for Void Reason here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Void Reason here] end
				// % protected region % [Set readonly for Void Reason here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Void Reason here] end
				validators: [
					// % protected region % [Add other validators for Void Reason here] off begin
					// % protected region % [Add other validators for Void Reason here] end
				],
				// % protected region % [Add any additional model attribute properties for Void Reason here] off begin
				// % protected region % [Add any additional model attribute properties for Void Reason here] end
			},
			{
				name: 'adjustmentType',
				// % protected region % [Set displayName for Adjustment Type here] off begin
				displayName: 'Adjustment Type',
				// % protected region % [Set displayName for Adjustment Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Adjustment Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Adjustment Type here] end
				// % protected region % [Set isSensitive for Adjustment Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Adjustment Type here] end
				// % protected region % [Set readonly for Adjustment Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Adjustment Type here] end
				validators: [
					// % protected region % [Add other validators for Adjustment Type here] off begin
					// % protected region % [Add other validators for Adjustment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Adjustment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Adjustment Type here] end
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
				id: 'inventoryAdjustmentItems',
				type: ModelRelationType.MANY,
				name: 'inventoryAdjustmentItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjustment Items here] off begin
				label: 'Inventory Adjustment Items',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjustment Items here] end
				entityName: 'InventoryAdjustmentItemModel',
				// % protected region % [Customise your display name for Inventory Adjustment Items here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Inventory Adjustment Items here] end
				validators: [
					// % protected region % [Add other validators for Inventory Adjustment Items here] off begin
					// % protected region % [Add other validators for Inventory Adjustment Items here] end
				],
				// % protected region % [Add any additional field for relation Inventory Adjustment Items here] off begin
				// % protected region % [Add any additional field for relation Inventory Adjustment Items here] end
			},
			{
				id: 'transactionDetailType',
				type: ModelRelationType.ONE,
				name: 'transactionDetailTypeId',
				// % protected region % [Customise your label for Transaction Detail Type here] off begin
				label: 'Transaction Detail Type',
				// % protected region % [Customise your label for Transaction Detail Type here] end
				entityName: 'TransactionDetailTypeModel',
				// % protected region % [Customise your display name for Transaction Detail Type here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'transactionDetail',
				// % protected region % [Customise your display name for Transaction Detail Type here] end
				validators: [
					// % protected region % [Add other validators for Transaction Detail Type here] off begin
					// % protected region % [Add other validators for Transaction Detail Type here] end
				],
				// % protected region % [Add any additional field for relation Transaction Detail Type here] off begin
				// % protected region % [Add any additional field for relation Transaction Detail Type here] end
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
				case 'adjustmentNumber':
					break;
				case 'transactionType':
					break;
				case 'referenceNumber':
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
	static deepParse(data: string | { [K in keyof InventoryAdjustmentModel]?: InventoryAdjustmentModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InventoryAdjustmentModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.transactionDetailType) {
			currentModel.transactionDetailTypeId = json.transactionDetailType.id;
			returned = _.union(returned, TransactionDetailTypeModel.deepParse(json.transactionDetailType));
		}

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}

		// Outgoing one to many
		if (json.inventoryAdjustmentItems) {
			currentModel.inventoryAdjustmentItemsIds = json.inventoryAdjustmentItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inventoryAdjustmentItems.map(model => InventoryAdjustmentItemModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let inventoryAdjustmentModel = new InventoryAdjustmentModel(data);`
	 *
	 * @param data The input data to be initialised as the InventoryAdjustmentModel,
	 *    it is expected as a JSON string or as a nullable InventoryAdjustmentModel.
	 */
	constructor(data?: string | Partial<InventoryAdjustmentModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InventoryAdjustmentModel>
				: data;

			this.adjustmentNumber = json.adjustmentNumber;
			this.approvalStatus = json.approvalStatus;
			if (json.transactionDate) {
				this.transactionDate = new Date(json.transactionDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.transactionDate = json.transactionDate;
			}
			this.transactionType = json.transactionType;
			this.referenceNumber = json.referenceNumber;
			this.notes = json.notes;
			if (json.voidDate) {
				this.voidDate = new Date(json.voidDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.voidDate = json.voidDate;
			}
			this.voidReason = json.voidReason;
			this.adjustmentType = json.adjustmentType;
			this.transactionDetailTypeId = json.transactionDetailTypeId;
			this.transactionDetailType = json.transactionDetailType;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.inventoryAdjustmentItemsIds = json.inventoryAdjustmentItemsIds;
			this.inventoryAdjustmentItems = json.inventoryAdjustmentItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			adjustmentNumber: this.adjustmentNumber,
			approvalStatus: this.approvalStatus,
			transactionDate: this.transactionDate,
			transactionType: this.transactionType,
			referenceNumber: this.referenceNumber,
			notes: this.notes,
			voidDate: this.voidDate,
			voidReason: this.voidReason,
			adjustmentType: this.adjustmentType,
			transactionDetailTypeId: this.transactionDetailTypeId,
			warehouseId: this.warehouseId,
			inventoryAdjustmentItemsIds: this.inventoryAdjustmentItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InventoryAdjustmentModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InventoryAdjustmentModel {
		let newModelJson = this.toJSON();

		if (updates.adjustmentNumber) {
			newModelJson.adjustmentNumber = updates.adjustmentNumber;
		}

		if (updates.approvalStatus) {
			newModelJson.approvalStatus = updates.approvalStatus;
		}

		if (updates.transactionDate) {
			newModelJson.transactionDate = updates.transactionDate;
		}

		if (updates.transactionType) {
			newModelJson.transactionType = updates.transactionType;
		}

		if (updates.referenceNumber) {
			newModelJson.referenceNumber = updates.referenceNumber;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.voidDate) {
			newModelJson.voidDate = updates.voidDate;
		}

		if (updates.voidReason) {
			newModelJson.voidReason = updates.voidReason;
		}

		if (updates.adjustmentType) {
			newModelJson.adjustmentType = updates.adjustmentType;
		}

		if (updates.transactionDetailTypeId) {
			newModelJson.transactionDetailTypeId = updates.transactionDetailTypeId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.inventoryAdjustmentItemsIds) {
			newModelJson.inventoryAdjustmentItemsIds = updates.inventoryAdjustmentItemsIds;
		}

		return new InventoryAdjustmentModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InventoryAdjustmentModel)) {
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
			'transactionDetailTypeId',
			'transactionDetailType',
			'warehouseId',
			'warehouse',
			'inventoryAdjustmentItemsIds',
			'inventoryAdjustmentItems',
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
		if (!this.transactionDetailType) {
			this.transactionDetailTypeId = null;
		} else {
			this.transactionDetailTypeId = this.transactionDetailType.id;
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