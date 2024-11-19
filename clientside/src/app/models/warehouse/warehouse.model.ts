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
import {BatchStockBalanceModel} from '../batchStockBalance/batch_stock_balance.model';
import {BatchStockBalancePerDateModel} from '../batchStockBalancePerDate/batch_stock_balance_per_date.model';
import {BatchStockTransactionDetailModel} from '../batchStockTransactionDetail/batch_stock_transaction_detail.model';
import {GoodsReceiveNoteModel} from '../goodsReceiveNote/goods_receive_note.model';
import {GoodsReceiveNoteBatchModel} from '../goodsReceiveNoteBatch/goods_receive_note_batch.model';
import {InternalOrderModel} from '../internalOrder/internal_order.model';
import {InventoryAdjusmentBatchModel} from '../inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import {InventoryAdjustmentModel} from '../inventoryAdjustment/inventory_adjustment.model';
import {InventoryBatchCorrectionModel} from '../inventoryBatchCorrection/inventory_batch_correction.model';
import {LocationModel} from '../location/location.model';
import {MedicalFeeModel} from '../medicalFee/medical_fee.model';
import {MedicationHeaderModel} from '../medicationHeader/medication_header.model';
import {PrescriptionHeaderModel} from '../prescriptionHeader/prescription_header.model';
import {PurchaseOrderModel} from '../purchaseOrder/purchase_order.model';
import {PurchaseRequisitionModel} from '../purchaseRequisition/purchase_requisition.model';
import {RetailPharmacyModel} from '../retailPharmacy/retail_pharmacy.model';
import {ReturnSupplierModel} from '../returnSupplier/return_supplier.model';
import {StockCatalogueModel} from '../stockCatalogue/stock_catalogue.model';
import {StockControlModel} from '../stockControl/stock_control.model';
import {StockTransactionDetailModel} from '../stockTransactionDetail/stock_transaction_detail.model';
import {StockTransactionPerDateModel} from '../stockTransactionPerDate/stock_transaction_per_date.model';
import {StockTransactionPerDateTypeModel} from '../stockTransactionPerDateType/stock_transaction_per_date_type.model';
import {TransferOrderModel} from '../transferOrder/transfer_order.model';
import {VaccinationOrderDetailModel} from '../vaccinationOrderDetail/vaccination_order_detail.model';
import {WarehouseInitialStockModel} from '../warehouseInitialStock/warehouse_initial_stock.model';
import {WarehouseInventoryModel} from '../warehouseInventory/warehouse_inventory.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class WarehouseModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'warehouseNumber',
		'warehouseName',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'warehouseNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'WarehouseModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return WarehouseModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Warehouse Number (Max Length: 50).
	 */
	warehouseNumber: string;

	/**
	 * Warehouse Name (Max Length: 250).
	 */
	warehouseName: string;

	/**
	 * .
	 */
	description: string;

	/**
	 * .
	 */
	address: string;

	/**
	 * .
	 */
	contactPerson: string;

	/**
	 * .
	 */
	phoneNumber: string;

	/**
	 * .
	 */
	ext: string;

	/**
	 * .
	 */
	mobilePhoneNumber: string;

	/**
	 * .
	 */
	email: string;

	/**
	 * .
	 */
	revenueCenter: string;

	batchStockBalancesWarehouseIds: string[] = [];

	batchStockBalancesWarehouse: BatchStockBalanceModel[];

	batchStockBalancesIds: string[] = [];

	batchStockBalances: BatchStockBalancePerDateModel[];

	batchStockTransactionDetailsIds: string[] = [];

	batchStockTransactionDetails: BatchStockTransactionDetailModel[];

	destinationWarehousesIds: string[] = [];

	destinationWarehouses: TransferOrderModel[];

	goodsReceiveNoteBatchsIds: string[] = [];

	goodsReceiveNoteBatchs: GoodsReceiveNoteBatchModel[];

	goodsReceiveNotesIds: string[] = [];

	goodsReceiveNotes: GoodsReceiveNoteModel[];

	internalOrdersIds: string[] = [];

	internalOrders: InternalOrderModel[];

	inventoryAdjusmentBatchsIds: string[] = [];

	inventoryAdjusmentBatchs: InventoryAdjusmentBatchModel[];

	inventoryAdjustmentsIds: string[] = [];

	inventoryAdjustments: InventoryAdjustmentModel[];

	inventoryBatchCorrectionsIds: string[] = [];

	inventoryBatchCorrections: InventoryBatchCorrectionModel[];

	locationsIds: string[] = [];

	locations: LocationModel[];

	medicalFeesIds: string[] = [];

	medicalFees: MedicalFeeModel[];

	medicationHeadersIds: string[] = [];

	medicationHeaders: MedicationHeaderModel[];

	prescriptionHeadersIds: string[] = [];

	prescriptionHeaders: PrescriptionHeaderModel[];

	purchaseOrdersIds: string[] = [];

	purchaseOrders: PurchaseOrderModel[];

	purchaseRequisitionsIds: string[] = [];

	purchaseRequisitions: PurchaseRequisitionModel[];

	retailPharmaciesIds: string[] = [];

	retailPharmacies: RetailPharmacyModel[];

	returnSuppliersIds: string[] = [];

	returnSuppliers: ReturnSupplierModel[];

	sourceWarehousesIds: string[] = [];

	sourceWarehouses: TransferOrderModel[];

	stockCataloguesIds: string[] = [];

	stockCatalogues: StockCatalogueModel[];

	stockControlsIds: string[] = [];

	stockControls: StockControlModel[];

	stockTransactionDetailsIds: string[] = [];

	stockTransactionDetails: StockTransactionDetailModel[];

	stockTransactionPerDateTypesIds: string[] = [];

	stockTransactionPerDateTypes: StockTransactionPerDateTypeModel[];

	stockTransactionPerDatesIds: string[] = [];

	stockTransactionPerDates: StockTransactionPerDateModel[];

	vaccinationOrderDetailsIds: string[] = [];

	vaccinationOrderDetails: VaccinationOrderDetailModel[];

	warehouseInitialStockSIds: string[] = [];

	warehouseInitialStockS: WarehouseInitialStockModel[];

	warehouseInventoriesIds: string[] = [];

	warehouseInventories: WarehouseInventoryModel[];

	modelPropGroups: { [s: string]: Group } = WarehouseModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'warehouseNumber',
				// % protected region % [Set displayName for Warehouse Number here] off begin
				displayName: 'Warehouse Number',
				// % protected region % [Set displayName for Warehouse Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Warehouse Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Warehouse Number here] end
				// % protected region % [Set isSensitive for Warehouse Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Warehouse Number here] end
				// % protected region % [Set readonly for Warehouse Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Warehouse Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Warehouse Number here] off begin
					// % protected region % [Add other validators for Warehouse Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Warehouse Number here] off begin
				// % protected region % [Add any additional model attribute properties for Warehouse Number here] end
			},
			{
				name: 'warehouseName',
				// % protected region % [Set displayName for Warehouse Name here] off begin
				displayName: 'Warehouse Name',
				// % protected region % [Set displayName for Warehouse Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Warehouse Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Warehouse Name here] end
				// % protected region % [Set isSensitive for Warehouse Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Warehouse Name here] end
				// % protected region % [Set readonly for Warehouse Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Warehouse Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Warehouse Name here] off begin
					// % protected region % [Add other validators for Warehouse Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Warehouse Name here] off begin
				// % protected region % [Add any additional model attribute properties for Warehouse Name here] end
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
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(2000),
					// % protected region % [Add other validators for Description here] off begin
					// % protected region % [Add other validators for Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Description here] off begin
				// % protected region % [Add any additional model attribute properties for Description here] end
			},
			{
				name: 'address',
				// % protected region % [Set displayName for Address here] off begin
				displayName: 'Address',
				// % protected region % [Set displayName for Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Address here] end
				// % protected region % [Set isSensitive for Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Address here] end
				// % protected region % [Set readonly for Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Address here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Address here] off begin
					// % protected region % [Add other validators for Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Address here] off begin
				// % protected region % [Add any additional model attribute properties for Address here] end
			},
			{
				name: 'contactPerson',
				// % protected region % [Set displayName for Contact Person here] off begin
				displayName: 'Contact Person',
				// % protected region % [Set displayName for Contact Person here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Contact Person here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Contact Person here] end
				// % protected region % [Set isSensitive for Contact Person here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contact Person here] end
				// % protected region % [Set readonly for Contact Person here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contact Person here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Contact Person here] off begin
					// % protected region % [Add other validators for Contact Person here] end
				],
				// % protected region % [Add any additional model attribute properties for Contact Person here] off begin
				// % protected region % [Add any additional model attribute properties for Contact Person here] end
			},
			{
				name: 'phoneNumber',
				// % protected region % [Set displayName for Phone Number here] off begin
				displayName: 'Phone Number',
				// % protected region % [Set displayName for Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Phone Number here] end
				// % protected region % [Set isSensitive for Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Phone Number here] end
				// % protected region % [Set readonly for Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Phone Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Phone Number here] off begin
					// % protected region % [Add other validators for Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Phone Number here] end
			},
			{
				name: 'ext',
				// % protected region % [Set displayName for Ext here] off begin
				displayName: 'Ext',
				// % protected region % [Set displayName for Ext here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ext here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ext here] end
				// % protected region % [Set isSensitive for Ext here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ext here] end
				// % protected region % [Set readonly for Ext here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ext here] end
				validators: [
					// % protected region % [Add other validators for Ext here] off begin
					// % protected region % [Add other validators for Ext here] end
				],
				// % protected region % [Add any additional model attribute properties for Ext here] off begin
				// % protected region % [Add any additional model attribute properties for Ext here] end
			},
			{
				name: 'mobilePhoneNumber',
				// % protected region % [Set displayName for Mobile Phone Number here] off begin
				displayName: 'Mobile Phone Number',
				// % protected region % [Set displayName for Mobile Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Mobile Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Mobile Phone Number here] end
				// % protected region % [Set isSensitive for Mobile Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Mobile Phone Number here] end
				// % protected region % [Set readonly for Mobile Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Mobile Phone Number here] end
				validators: [
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Mobile Phone Number here] off begin
					// % protected region % [Add other validators for Mobile Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Mobile Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Mobile Phone Number here] end
			},
			{
				name: 'email',
				// % protected region % [Set displayName for Email here] off begin
				displayName: 'Email',
				// % protected region % [Set displayName for Email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Email here] end
				// % protected region % [Set isSensitive for Email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Email here] end
				// % protected region % [Set readonly for Email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Email here] end
				validators: [
					Validators.email,
					// % protected region % [Add other validators for Email here] off begin
					// % protected region % [Add other validators for Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Email here] off begin
				// % protected region % [Add any additional model attribute properties for Email here] end
			},
			{
				name: 'revenueCenter',
				// % protected region % [Set displayName for Revenue Center here] off begin
				displayName: 'Revenue Center',
				// % protected region % [Set displayName for Revenue Center here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Revenue Center here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Revenue Center here] end
				// % protected region % [Set isSensitive for Revenue Center here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Revenue Center here] end
				// % protected region % [Set readonly for Revenue Center here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Revenue Center here] end
				validators: [
					// % protected region % [Add other validators for Revenue Center here] off begin
					// % protected region % [Add other validators for Revenue Center here] end
				],
				// % protected region % [Add any additional model attribute properties for Revenue Center here] off begin
				// % protected region % [Add any additional model attribute properties for Revenue Center here] end
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
				id: 'batchStockBalancesWarehouse',
				type: ModelRelationType.MANY,
				name: 'batchStockBalancesWarehouseIds',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Balances Warehouse here] off begin
				label: 'Batch Stock Balances Warehouse',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Balances Warehouse here] end
				entityName: 'BatchStockBalanceModel',
				// % protected region % [Customise your display name for Batch Stock Balances Warehouse here] off begin
				displayName: 'sourceNumber',
				// % protected region % [Customise your display name for Batch Stock Balances Warehouse here] end
				validators: [
					// % protected region % [Add other validators for Batch Stock Balances Warehouse here] off begin
					// % protected region % [Add other validators for Batch Stock Balances Warehouse here] end
				],
				// % protected region % [Add any additional field for relation Batch Stock Balances Warehouse here] off begin
				// % protected region % [Add any additional field for relation Batch Stock Balances Warehouse here] end
			},
			{
				id: 'batchStockBalances',
				type: ModelRelationType.MANY,
				name: 'batchStockBalancesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Balances here] off begin
				label: 'Batch Stock Balances',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Balances here] end
				entityName: 'BatchStockBalancePerDateModel',
				// % protected region % [Customise your display name for Batch Stock Balances here] off begin
				displayName: 'batchNo',
				// % protected region % [Customise your display name for Batch Stock Balances here] end
				validators: [
					// % protected region % [Add other validators for Batch Stock Balances here] off begin
					// % protected region % [Add other validators for Batch Stock Balances here] end
				],
				// % protected region % [Add any additional field for relation Batch Stock Balances here] off begin
				// % protected region % [Add any additional field for relation Batch Stock Balances here] end
			},
			{
				id: 'batchStockTransactionDetails',
				type: ModelRelationType.MANY,
				name: 'batchStockTransactionDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Transaction Details here] off begin
				label: 'Batch Stock Transaction Details',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Transaction Details here] end
				entityName: 'BatchStockTransactionDetailModel',
				// % protected region % [Customise your display name for Batch Stock Transaction Details here] off begin
				displayName: 'batchNo',
				// % protected region % [Customise your display name for Batch Stock Transaction Details here] end
				validators: [
					// % protected region % [Add other validators for Batch Stock Transaction Details here] off begin
					// % protected region % [Add other validators for Batch Stock Transaction Details here] end
				],
				// % protected region % [Add any additional field for relation Batch Stock Transaction Details here] off begin
				// % protected region % [Add any additional field for relation Batch Stock Transaction Details here] end
			},
			{
				id: 'destinationWarehouses',
				type: ModelRelationType.MANY,
				name: 'destinationWarehousesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Destination Warehouses here] off begin
				label: 'Destination Warehouses',
				// % protected region % [Customise your 1-1 or 1-M label for Destination Warehouses here] end
				entityName: 'TransferOrderModel',
				// % protected region % [Customise your display name for Destination Warehouses here] off begin
				displayName: 'transferOrderNumber',
				// % protected region % [Customise your display name for Destination Warehouses here] end
				validators: [
					// % protected region % [Add other validators for Destination Warehouses here] off begin
					// % protected region % [Add other validators for Destination Warehouses here] end
				],
				// % protected region % [Add any additional field for relation Destination Warehouses here] off begin
				// % protected region % [Add any additional field for relation Destination Warehouses here] end
			},
			{
				id: 'goodsReceiveNoteBatchs',
				type: ModelRelationType.MANY,
				name: 'goodsReceiveNoteBatchsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Batchs here] off begin
				label: 'Goods Receive Note Batchs',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Batchs here] end
				entityName: 'GoodsReceiveNoteBatchModel',
				// % protected region % [Customise your display name for Goods Receive Note Batchs here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Goods Receive Note Batchs here] end
				validators: [
					// % protected region % [Add other validators for Goods Receive Note Batchs here] off begin
					// % protected region % [Add other validators for Goods Receive Note Batchs here] end
				],
				// % protected region % [Add any additional field for relation Goods Receive Note Batchs here] off begin
				// % protected region % [Add any additional field for relation Goods Receive Note Batchs here] end
			},
			{
				id: 'goodsReceiveNotes',
				type: ModelRelationType.MANY,
				name: 'goodsReceiveNotesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Notes here] off begin
				label: 'Goods Receive Notes',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Notes here] end
				entityName: 'GoodsReceiveNoteModel',
				// % protected region % [Customise your display name for Goods Receive Notes here] off begin
				displayName: 'receiveNumber',
				// % protected region % [Customise your display name for Goods Receive Notes here] end
				validators: [
					// % protected region % [Add other validators for Goods Receive Notes here] off begin
					// % protected region % [Add other validators for Goods Receive Notes here] end
				],
				// % protected region % [Add any additional field for relation Goods Receive Notes here] off begin
				// % protected region % [Add any additional field for relation Goods Receive Notes here] end
			},
			{
				id: 'internalOrders',
				type: ModelRelationType.MANY,
				name: 'internalOrdersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Internal Orders here] off begin
				label: 'Internal Orders',
				// % protected region % [Customise your 1-1 or 1-M label for Internal Orders here] end
				entityName: 'InternalOrderModel',
				// % protected region % [Customise your display name for Internal Orders here] off begin
				displayName: 'internalOrderNumber',
				// % protected region % [Customise your display name for Internal Orders here] end
				validators: [
					// % protected region % [Add other validators for Internal Orders here] off begin
					// % protected region % [Add other validators for Internal Orders here] end
				],
				// % protected region % [Add any additional field for relation Internal Orders here] off begin
				// % protected region % [Add any additional field for relation Internal Orders here] end
			},
			{
				id: 'inventoryAdjusmentBatchs',
				type: ModelRelationType.MANY,
				name: 'inventoryAdjusmentBatchsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjusment Batchs here] off begin
				label: 'Inventory Adjusment Batchs',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjusment Batchs here] end
				entityName: 'InventoryAdjusmentBatchModel',
				// % protected region % [Customise your display name for Inventory Adjusment Batchs here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Inventory Adjusment Batchs here] end
				validators: [
					// % protected region % [Add other validators for Inventory Adjusment Batchs here] off begin
					// % protected region % [Add other validators for Inventory Adjusment Batchs here] end
				],
				// % protected region % [Add any additional field for relation Inventory Adjusment Batchs here] off begin
				// % protected region % [Add any additional field for relation Inventory Adjusment Batchs here] end
			},
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
				id: 'inventoryBatchCorrections',
				type: ModelRelationType.MANY,
				name: 'inventoryBatchCorrectionsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Batch Corrections here] off begin
				label: 'Inventory Batch Corrections',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Batch Corrections here] end
				entityName: 'InventoryBatchCorrectionModel',
				// % protected region % [Customise your display name for Inventory Batch Corrections here] off begin
				displayName: 'batchCorrectionNumber',
				// % protected region % [Customise your display name for Inventory Batch Corrections here] end
				validators: [
					// % protected region % [Add other validators for Inventory Batch Corrections here] off begin
					// % protected region % [Add other validators for Inventory Batch Corrections here] end
				],
				// % protected region % [Add any additional field for relation Inventory Batch Corrections here] off begin
				// % protected region % [Add any additional field for relation Inventory Batch Corrections here] end
			},
			{
				id: 'locations',
				type: ModelRelationType.MANY,
				name: 'locationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Locations here] off begin
				label: 'Locations',
				// % protected region % [Customise your 1-1 or 1-M label for Locations here] end
				entityName: 'LocationModel',
				// % protected region % [Customise your display name for Locations here] off begin
				displayName: 'locationName',
				// % protected region % [Customise your display name for Locations here] end
				validators: [
					// % protected region % [Add other validators for Locations here] off begin
					// % protected region % [Add other validators for Locations here] end
				],
				// % protected region % [Add any additional field for relation Locations here] off begin
				// % protected region % [Add any additional field for relation Locations here] end
			},
			{
				id: 'medicalFees',
				type: ModelRelationType.MANY,
				name: 'medicalFeesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Fees here] off begin
				label: 'Medical Fees',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Fees here] end
				entityName: 'MedicalFeeModel',
				// % protected region % [Customise your display name for Medical Fees here] off begin
				displayName: 'tariffType',
				// % protected region % [Customise your display name for Medical Fees here] end
				validators: [
					// % protected region % [Add other validators for Medical Fees here] off begin
					// % protected region % [Add other validators for Medical Fees here] end
				],
				// % protected region % [Add any additional field for relation Medical Fees here] off begin
				// % protected region % [Add any additional field for relation Medical Fees here] end
			},
			{
				id: 'medicationHeaders',
				type: ModelRelationType.MANY,
				name: 'medicationHeadersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Headers here] off begin
				label: 'Medication Headers',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Headers here] end
				entityName: 'MedicationHeaderModel',
				// % protected region % [Customise your display name for Medication Headers here] off begin
				displayName: 'medicationNumber',
				// % protected region % [Customise your display name for Medication Headers here] end
				validators: [
					// % protected region % [Add other validators for Medication Headers here] off begin
					// % protected region % [Add other validators for Medication Headers here] end
				],
				// % protected region % [Add any additional field for relation Medication Headers here] off begin
				// % protected region % [Add any additional field for relation Medication Headers here] end
			},
			{
				id: 'prescriptionHeaders',
				type: ModelRelationType.MANY,
				name: 'prescriptionHeadersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Headers here] off begin
				label: 'Prescription Headers',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Headers here] end
				entityName: 'PrescriptionHeaderModel',
				// % protected region % [Customise your display name for Prescription Headers here] off begin
				displayName: 'prescriptionNumber',
				// % protected region % [Customise your display name for Prescription Headers here] end
				validators: [
					// % protected region % [Add other validators for Prescription Headers here] off begin
					// % protected region % [Add other validators for Prescription Headers here] end
				],
				// % protected region % [Add any additional field for relation Prescription Headers here] off begin
				// % protected region % [Add any additional field for relation Prescription Headers here] end
			},
			{
				id: 'purchaseOrders',
				type: ModelRelationType.MANY,
				name: 'purchaseOrdersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Orders here] off begin
				label: 'Purchase Orders',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Orders here] end
				entityName: 'PurchaseOrderModel',
				// % protected region % [Customise your display name for Purchase Orders here] off begin
				displayName: 'purchaseOrderType',
				// % protected region % [Customise your display name for Purchase Orders here] end
				validators: [
					// % protected region % [Add other validators for Purchase Orders here] off begin
					// % protected region % [Add other validators for Purchase Orders here] end
				],
				// % protected region % [Add any additional field for relation Purchase Orders here] off begin
				// % protected region % [Add any additional field for relation Purchase Orders here] end
			},
			{
				id: 'purchaseRequisitions',
				type: ModelRelationType.MANY,
				name: 'purchaseRequisitionsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisitions here] off begin
				label: 'Purchase Requisitions',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisitions here] end
				entityName: 'PurchaseRequisitionModel',
				// % protected region % [Customise your display name for Purchase Requisitions here] off begin
				displayName: 'purchaseRequisitionNumber',
				// % protected region % [Customise your display name for Purchase Requisitions here] end
				validators: [
					// % protected region % [Add other validators for Purchase Requisitions here] off begin
					// % protected region % [Add other validators for Purchase Requisitions here] end
				],
				// % protected region % [Add any additional field for relation Purchase Requisitions here] off begin
				// % protected region % [Add any additional field for relation Purchase Requisitions here] end
			},
			{
				id: 'retailPharmacies',
				type: ModelRelationType.MANY,
				name: 'retailPharmaciesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacies here] off begin
				label: 'Retail Pharmacies',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacies here] end
				entityName: 'RetailPharmacyModel',
				// % protected region % [Customise your display name for Retail Pharmacies here] off begin
				displayName: 'customerType',
				// % protected region % [Customise your display name for Retail Pharmacies here] end
				validators: [
					// % protected region % [Add other validators for Retail Pharmacies here] off begin
					// % protected region % [Add other validators for Retail Pharmacies here] end
				],
				// % protected region % [Add any additional field for relation Retail Pharmacies here] off begin
				// % protected region % [Add any additional field for relation Retail Pharmacies here] end
			},
			{
				id: 'returnSuppliers',
				type: ModelRelationType.MANY,
				name: 'returnSuppliersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Return Suppliers here] off begin
				label: 'Return Suppliers',
				// % protected region % [Customise your 1-1 or 1-M label for Return Suppliers here] end
				entityName: 'ReturnSupplierModel',
				// % protected region % [Customise your display name for Return Suppliers here] off begin
				displayName: 'returnNumber',
				// % protected region % [Customise your display name for Return Suppliers here] end
				validators: [
					// % protected region % [Add other validators for Return Suppliers here] off begin
					// % protected region % [Add other validators for Return Suppliers here] end
				],
				// % protected region % [Add any additional field for relation Return Suppliers here] off begin
				// % protected region % [Add any additional field for relation Return Suppliers here] end
			},
			{
				id: 'sourceWarehouses',
				type: ModelRelationType.MANY,
				name: 'sourceWarehousesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Source Warehouses here] off begin
				label: 'Source Warehouses',
				// % protected region % [Customise your 1-1 or 1-M label for Source Warehouses here] end
				entityName: 'TransferOrderModel',
				// % protected region % [Customise your display name for Source Warehouses here] off begin
				displayName: 'transferOrderNumber',
				// % protected region % [Customise your display name for Source Warehouses here] end
				validators: [
					// % protected region % [Add other validators for Source Warehouses here] off begin
					// % protected region % [Add other validators for Source Warehouses here] end
				],
				// % protected region % [Add any additional field for relation Source Warehouses here] off begin
				// % protected region % [Add any additional field for relation Source Warehouses here] end
			},
			{
				id: 'stockCatalogues',
				type: ModelRelationType.MANY,
				name: 'stockCataloguesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Catalogues here] off begin
				label: 'Stock Catalogues',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Catalogues here] end
				entityName: 'StockCatalogueModel',
				// % protected region % [Customise your display name for Stock Catalogues here] off begin
				displayName: 'trackable',
				// % protected region % [Customise your display name for Stock Catalogues here] end
				validators: [
					// % protected region % [Add other validators for Stock Catalogues here] off begin
					// % protected region % [Add other validators for Stock Catalogues here] end
				],
				// % protected region % [Add any additional field for relation Stock Catalogues here] off begin
				// % protected region % [Add any additional field for relation Stock Catalogues here] end
			},
			{
				id: 'stockControls',
				type: ModelRelationType.MANY,
				name: 'stockControlsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Controls here] off begin
				label: 'Stock Controls',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Controls here] end
				entityName: 'StockControlModel',
				// % protected region % [Customise your display name for Stock Controls here] off begin
				displayName: 'onHandQty',
				// % protected region % [Customise your display name for Stock Controls here] end
				validators: [
					// % protected region % [Add other validators for Stock Controls here] off begin
					// % protected region % [Add other validators for Stock Controls here] end
				],
				// % protected region % [Add any additional field for relation Stock Controls here] off begin
				// % protected region % [Add any additional field for relation Stock Controls here] end
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
				id: 'stockTransactionPerDates',
				type: ModelRelationType.MANY,
				name: 'stockTransactionPerDatesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Per Dates here] off begin
				label: 'Stock Transaction Per Dates',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Per Dates here] end
				entityName: 'StockTransactionPerDateModel',
				// % protected region % [Customise your display name for Stock Transaction Per Dates here] off begin
				displayName: 'asOfDate',
				// % protected region % [Customise your display name for Stock Transaction Per Dates here] end
				validators: [
					// % protected region % [Add other validators for Stock Transaction Per Dates here] off begin
					// % protected region % [Add other validators for Stock Transaction Per Dates here] end
				],
				// % protected region % [Add any additional field for relation Stock Transaction Per Dates here] off begin
				// % protected region % [Add any additional field for relation Stock Transaction Per Dates here] end
			},
			{
				id: 'vaccinationOrderDetails',
				type: ModelRelationType.MANY,
				name: 'vaccinationOrderDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Vaccination Order Details here] off begin
				label: 'Vaccination Order Details',
				// % protected region % [Customise your 1-1 or 1-M label for Vaccination Order Details here] end
				entityName: 'VaccinationOrderDetailModel',
				// % protected region % [Customise your display name for Vaccination Order Details here] off begin
				displayName: 'vaccinationDate',
				// % protected region % [Customise your display name for Vaccination Order Details here] end
				validators: [
					// % protected region % [Add other validators for Vaccination Order Details here] off begin
					// % protected region % [Add other validators for Vaccination Order Details here] end
				],
				// % protected region % [Add any additional field for relation Vaccination Order Details here] off begin
				// % protected region % [Add any additional field for relation Vaccination Order Details here] end
			},
			{
				id: 'warehouseInitialStockS',
				type: ModelRelationType.MANY,
				name: 'warehouseInitialStockSIds',
				// % protected region % [Customise your 1-1 or 1-M label for Warehouse Initial Stock s here] off begin
				label: 'Warehouse Initial Stock s',
				// % protected region % [Customise your 1-1 or 1-M label for Warehouse Initial Stock s here] end
				entityName: 'WarehouseInitialStockModel',
				// % protected region % [Customise your display name for Warehouse Initial Stock s here] off begin
				displayName: 'minimumLevel',
				// % protected region % [Customise your display name for Warehouse Initial Stock s here] end
				validators: [
					// % protected region % [Add other validators for Warehouse Initial Stock s here] off begin
					// % protected region % [Add other validators for Warehouse Initial Stock s here] end
				],
				// % protected region % [Add any additional field for relation Warehouse Initial Stock s here] off begin
				// % protected region % [Add any additional field for relation Warehouse Initial Stock s here] end
			},
			{
				id: 'warehouseInventories',
				type: ModelRelationType.MANY,
				name: 'warehouseInventoriesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Warehouse Inventories here] off begin
				label: 'Warehouse Inventories',
				// % protected region % [Customise your 1-1 or 1-M label for Warehouse Inventories here] end
				entityName: 'WarehouseInventoryModel',
				// % protected region % [Customise your display name for Warehouse Inventories here] off begin
				displayName: 'soh',
				// % protected region % [Customise your display name for Warehouse Inventories here] end
				validators: [
					// % protected region % [Add other validators for Warehouse Inventories here] off begin
					// % protected region % [Add other validators for Warehouse Inventories here] end
				],
				// % protected region % [Add any additional field for relation Warehouse Inventories here] off begin
				// % protected region % [Add any additional field for relation Warehouse Inventories here] end
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
				case 'warehouseNumber':
					break;
				case 'warehouseName':
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
	static deepParse(data: string | { [K in keyof WarehouseModel]?: WarehouseModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new WarehouseModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.batchStockBalancesWarehouse) {
			currentModel.batchStockBalancesWarehouseIds = json.batchStockBalancesWarehouse.map(model => model.id);
			returned = _.union(returned, _.flatten(json.batchStockBalancesWarehouse.map(model => BatchStockBalanceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.batchStockBalances) {
			currentModel.batchStockBalancesIds = json.batchStockBalances.map(model => model.id);
			returned = _.union(returned, _.flatten(json.batchStockBalances.map(model => BatchStockBalancePerDateModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.batchStockTransactionDetails) {
			currentModel.batchStockTransactionDetailsIds = json.batchStockTransactionDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.batchStockTransactionDetails.map(model => BatchStockTransactionDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.destinationWarehouses) {
			currentModel.destinationWarehousesIds = json.destinationWarehouses.map(model => model.id);
			returned = _.union(returned, _.flatten(json.destinationWarehouses.map(model => TransferOrderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.goodsReceiveNoteBatchs) {
			currentModel.goodsReceiveNoteBatchsIds = json.goodsReceiveNoteBatchs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.goodsReceiveNoteBatchs.map(model => GoodsReceiveNoteBatchModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.goodsReceiveNotes) {
			currentModel.goodsReceiveNotesIds = json.goodsReceiveNotes.map(model => model.id);
			returned = _.union(returned, _.flatten(json.goodsReceiveNotes.map(model => GoodsReceiveNoteModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.internalOrders) {
			currentModel.internalOrdersIds = json.internalOrders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.internalOrders.map(model => InternalOrderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.inventoryAdjusmentBatchs) {
			currentModel.inventoryAdjusmentBatchsIds = json.inventoryAdjusmentBatchs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inventoryAdjusmentBatchs.map(model => InventoryAdjusmentBatchModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.inventoryAdjustments) {
			currentModel.inventoryAdjustmentsIds = json.inventoryAdjustments.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inventoryAdjustments.map(model => InventoryAdjustmentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.inventoryBatchCorrections) {
			currentModel.inventoryBatchCorrectionsIds = json.inventoryBatchCorrections.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inventoryBatchCorrections.map(model => InventoryBatchCorrectionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.locations) {
			currentModel.locationsIds = json.locations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.locations.map(model => LocationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalFees) {
			currentModel.medicalFeesIds = json.medicalFees.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalFees.map(model => MedicalFeeModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationHeaders) {
			currentModel.medicationHeadersIds = json.medicationHeaders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationHeaders.map(model => MedicationHeaderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.prescriptionHeaders) {
			currentModel.prescriptionHeadersIds = json.prescriptionHeaders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.prescriptionHeaders.map(model => PrescriptionHeaderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.purchaseOrders) {
			currentModel.purchaseOrdersIds = json.purchaseOrders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseOrders.map(model => PurchaseOrderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.purchaseRequisitions) {
			currentModel.purchaseRequisitionsIds = json.purchaseRequisitions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseRequisitions.map(model => PurchaseRequisitionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.retailPharmacies) {
			currentModel.retailPharmaciesIds = json.retailPharmacies.map(model => model.id);
			returned = _.union(returned, _.flatten(json.retailPharmacies.map(model => RetailPharmacyModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.returnSuppliers) {
			currentModel.returnSuppliersIds = json.returnSuppliers.map(model => model.id);
			returned = _.union(returned, _.flatten(json.returnSuppliers.map(model => ReturnSupplierModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.sourceWarehouses) {
			currentModel.sourceWarehousesIds = json.sourceWarehouses.map(model => model.id);
			returned = _.union(returned, _.flatten(json.sourceWarehouses.map(model => TransferOrderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.stockCatalogues) {
			currentModel.stockCataloguesIds = json.stockCatalogues.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockCatalogues.map(model => StockCatalogueModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.stockControls) {
			currentModel.stockControlsIds = json.stockControls.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockControls.map(model => StockControlModel.deepParse(model))));
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
		if (json.stockTransactionPerDates) {
			currentModel.stockTransactionPerDatesIds = json.stockTransactionPerDates.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockTransactionPerDates.map(model => StockTransactionPerDateModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.vaccinationOrderDetails) {
			currentModel.vaccinationOrderDetailsIds = json.vaccinationOrderDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.vaccinationOrderDetails.map(model => VaccinationOrderDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.warehouseInitialStockS) {
			currentModel.warehouseInitialStockSIds = json.warehouseInitialStockS.map(model => model.id);
			returned = _.union(returned, _.flatten(json.warehouseInitialStockS.map(model => WarehouseInitialStockModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.warehouseInventories) {
			currentModel.warehouseInventoriesIds = json.warehouseInventories.map(model => model.id);
			returned = _.union(returned, _.flatten(json.warehouseInventories.map(model => WarehouseInventoryModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let warehouseModel = new WarehouseModel(data);`
	 *
	 * @param data The input data to be initialised as the WarehouseModel,
	 *    it is expected as a JSON string or as a nullable WarehouseModel.
	 */
	constructor(data?: string | Partial<WarehouseModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<WarehouseModel>
				: data;

			this.warehouseNumber = json.warehouseNumber;
			this.warehouseName = json.warehouseName;
			this.description = json.description;
			this.address = json.address;
			this.contactPerson = json.contactPerson;
			this.phoneNumber = json.phoneNumber;
			this.ext = json.ext;
			this.mobilePhoneNumber = json.mobilePhoneNumber;
			this.email = json.email;
			this.revenueCenter = json.revenueCenter;
			this.batchStockBalancesWarehouseIds = json.batchStockBalancesWarehouseIds;
			this.batchStockBalancesWarehouse = json.batchStockBalancesWarehouse;
			this.batchStockBalancesIds = json.batchStockBalancesIds;
			this.batchStockBalances = json.batchStockBalances;
			this.batchStockTransactionDetailsIds = json.batchStockTransactionDetailsIds;
			this.batchStockTransactionDetails = json.batchStockTransactionDetails;
			this.destinationWarehousesIds = json.destinationWarehousesIds;
			this.destinationWarehouses = json.destinationWarehouses;
			this.goodsReceiveNoteBatchsIds = json.goodsReceiveNoteBatchsIds;
			this.goodsReceiveNoteBatchs = json.goodsReceiveNoteBatchs;
			this.goodsReceiveNotesIds = json.goodsReceiveNotesIds;
			this.goodsReceiveNotes = json.goodsReceiveNotes;
			this.internalOrdersIds = json.internalOrdersIds;
			this.internalOrders = json.internalOrders;
			this.inventoryAdjusmentBatchsIds = json.inventoryAdjusmentBatchsIds;
			this.inventoryAdjusmentBatchs = json.inventoryAdjusmentBatchs;
			this.inventoryAdjustmentsIds = json.inventoryAdjustmentsIds;
			this.inventoryAdjustments = json.inventoryAdjustments;
			this.inventoryBatchCorrectionsIds = json.inventoryBatchCorrectionsIds;
			this.inventoryBatchCorrections = json.inventoryBatchCorrections;
			this.locationsIds = json.locationsIds;
			this.locations = json.locations;
			this.medicalFeesIds = json.medicalFeesIds;
			this.medicalFees = json.medicalFees;
			this.medicationHeadersIds = json.medicationHeadersIds;
			this.medicationHeaders = json.medicationHeaders;
			this.prescriptionHeadersIds = json.prescriptionHeadersIds;
			this.prescriptionHeaders = json.prescriptionHeaders;
			this.purchaseOrdersIds = json.purchaseOrdersIds;
			this.purchaseOrders = json.purchaseOrders;
			this.purchaseRequisitionsIds = json.purchaseRequisitionsIds;
			this.purchaseRequisitions = json.purchaseRequisitions;
			this.retailPharmaciesIds = json.retailPharmaciesIds;
			this.retailPharmacies = json.retailPharmacies;
			this.returnSuppliersIds = json.returnSuppliersIds;
			this.returnSuppliers = json.returnSuppliers;
			this.sourceWarehousesIds = json.sourceWarehousesIds;
			this.sourceWarehouses = json.sourceWarehouses;
			this.stockCataloguesIds = json.stockCataloguesIds;
			this.stockCatalogues = json.stockCatalogues;
			this.stockControlsIds = json.stockControlsIds;
			this.stockControls = json.stockControls;
			this.stockTransactionDetailsIds = json.stockTransactionDetailsIds;
			this.stockTransactionDetails = json.stockTransactionDetails;
			this.stockTransactionPerDateTypesIds = json.stockTransactionPerDateTypesIds;
			this.stockTransactionPerDateTypes = json.stockTransactionPerDateTypes;
			this.stockTransactionPerDatesIds = json.stockTransactionPerDatesIds;
			this.stockTransactionPerDates = json.stockTransactionPerDates;
			this.vaccinationOrderDetailsIds = json.vaccinationOrderDetailsIds;
			this.vaccinationOrderDetails = json.vaccinationOrderDetails;
			this.warehouseInitialStockSIds = json.warehouseInitialStockSIds;
			this.warehouseInitialStockS = json.warehouseInitialStockS;
			this.warehouseInventoriesIds = json.warehouseInventoriesIds;
			this.warehouseInventories = json.warehouseInventories;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			warehouseNumber: this.warehouseNumber,
			warehouseName: this.warehouseName,
			description: this.description,
			address: this.address,
			contactPerson: this.contactPerson,
			phoneNumber: this.phoneNumber,
			ext: this.ext,
			mobilePhoneNumber: this.mobilePhoneNumber,
			email: this.email,
			revenueCenter: this.revenueCenter,
			batchStockBalancesWarehouseIds: this.batchStockBalancesWarehouseIds,
			batchStockBalancesIds: this.batchStockBalancesIds,
			batchStockTransactionDetailsIds: this.batchStockTransactionDetailsIds,
			destinationWarehousesIds: this.destinationWarehousesIds,
			goodsReceiveNoteBatchsIds: this.goodsReceiveNoteBatchsIds,
			goodsReceiveNotesIds: this.goodsReceiveNotesIds,
			internalOrdersIds: this.internalOrdersIds,
			inventoryAdjusmentBatchsIds: this.inventoryAdjusmentBatchsIds,
			inventoryAdjustmentsIds: this.inventoryAdjustmentsIds,
			inventoryBatchCorrectionsIds: this.inventoryBatchCorrectionsIds,
			locationsIds: this.locationsIds,
			medicalFeesIds: this.medicalFeesIds,
			medicationHeadersIds: this.medicationHeadersIds,
			prescriptionHeadersIds: this.prescriptionHeadersIds,
			purchaseOrdersIds: this.purchaseOrdersIds,
			purchaseRequisitionsIds: this.purchaseRequisitionsIds,
			retailPharmaciesIds: this.retailPharmaciesIds,
			returnSuppliersIds: this.returnSuppliersIds,
			sourceWarehousesIds: this.sourceWarehousesIds,
			stockCataloguesIds: this.stockCataloguesIds,
			stockControlsIds: this.stockControlsIds,
			stockTransactionDetailsIds: this.stockTransactionDetailsIds,
			stockTransactionPerDateTypesIds: this.stockTransactionPerDateTypesIds,
			stockTransactionPerDatesIds: this.stockTransactionPerDatesIds,
			vaccinationOrderDetailsIds: this.vaccinationOrderDetailsIds,
			warehouseInitialStockSIds: this.warehouseInitialStockSIds,
			warehouseInventoriesIds: this.warehouseInventoriesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		WarehouseModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): WarehouseModel {
		let newModelJson = this.toJSON();

		if (updates.warehouseNumber) {
			newModelJson.warehouseNumber = updates.warehouseNumber;
		}

		if (updates.warehouseName) {
			newModelJson.warehouseName = updates.warehouseName;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.address) {
			newModelJson.address = updates.address;
		}

		if (updates.contactPerson) {
			newModelJson.contactPerson = updates.contactPerson;
		}

		if (updates.phoneNumber) {
			newModelJson.phoneNumber = updates.phoneNumber;
		}

		if (updates.ext) {
			newModelJson.ext = updates.ext;
		}

		if (updates.mobilePhoneNumber) {
			newModelJson.mobilePhoneNumber = updates.mobilePhoneNumber;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.revenueCenter) {
			newModelJson.revenueCenter = updates.revenueCenter;
		}

		if (updates.batchStockBalancesWarehouseIds) {
			newModelJson.batchStockBalancesWarehouseIds = updates.batchStockBalancesWarehouseIds;
		}

		if (updates.batchStockBalancesIds) {
			newModelJson.batchStockBalancesIds = updates.batchStockBalancesIds;
		}

		if (updates.batchStockTransactionDetailsIds) {
			newModelJson.batchStockTransactionDetailsIds = updates.batchStockTransactionDetailsIds;
		}

		if (updates.destinationWarehousesIds) {
			newModelJson.destinationWarehousesIds = updates.destinationWarehousesIds;
		}

		if (updates.goodsReceiveNoteBatchsIds) {
			newModelJson.goodsReceiveNoteBatchsIds = updates.goodsReceiveNoteBatchsIds;
		}

		if (updates.goodsReceiveNotesIds) {
			newModelJson.goodsReceiveNotesIds = updates.goodsReceiveNotesIds;
		}

		if (updates.internalOrdersIds) {
			newModelJson.internalOrdersIds = updates.internalOrdersIds;
		}

		if (updates.inventoryAdjusmentBatchsIds) {
			newModelJson.inventoryAdjusmentBatchsIds = updates.inventoryAdjusmentBatchsIds;
		}

		if (updates.inventoryAdjustmentsIds) {
			newModelJson.inventoryAdjustmentsIds = updates.inventoryAdjustmentsIds;
		}

		if (updates.inventoryBatchCorrectionsIds) {
			newModelJson.inventoryBatchCorrectionsIds = updates.inventoryBatchCorrectionsIds;
		}

		if (updates.locationsIds) {
			newModelJson.locationsIds = updates.locationsIds;
		}

		if (updates.medicalFeesIds) {
			newModelJson.medicalFeesIds = updates.medicalFeesIds;
		}

		if (updates.medicationHeadersIds) {
			newModelJson.medicationHeadersIds = updates.medicationHeadersIds;
		}

		if (updates.prescriptionHeadersIds) {
			newModelJson.prescriptionHeadersIds = updates.prescriptionHeadersIds;
		}

		if (updates.purchaseOrdersIds) {
			newModelJson.purchaseOrdersIds = updates.purchaseOrdersIds;
		}

		if (updates.purchaseRequisitionsIds) {
			newModelJson.purchaseRequisitionsIds = updates.purchaseRequisitionsIds;
		}

		if (updates.retailPharmaciesIds) {
			newModelJson.retailPharmaciesIds = updates.retailPharmaciesIds;
		}

		if (updates.returnSuppliersIds) {
			newModelJson.returnSuppliersIds = updates.returnSuppliersIds;
		}

		if (updates.sourceWarehousesIds) {
			newModelJson.sourceWarehousesIds = updates.sourceWarehousesIds;
		}

		if (updates.stockCataloguesIds) {
			newModelJson.stockCataloguesIds = updates.stockCataloguesIds;
		}

		if (updates.stockControlsIds) {
			newModelJson.stockControlsIds = updates.stockControlsIds;
		}

		if (updates.stockTransactionDetailsIds) {
			newModelJson.stockTransactionDetailsIds = updates.stockTransactionDetailsIds;
		}

		if (updates.stockTransactionPerDateTypesIds) {
			newModelJson.stockTransactionPerDateTypesIds = updates.stockTransactionPerDateTypesIds;
		}

		if (updates.stockTransactionPerDatesIds) {
			newModelJson.stockTransactionPerDatesIds = updates.stockTransactionPerDatesIds;
		}

		if (updates.vaccinationOrderDetailsIds) {
			newModelJson.vaccinationOrderDetailsIds = updates.vaccinationOrderDetailsIds;
		}

		if (updates.warehouseInitialStockSIds) {
			newModelJson.warehouseInitialStockSIds = updates.warehouseInitialStockSIds;
		}

		if (updates.warehouseInventoriesIds) {
			newModelJson.warehouseInventoriesIds = updates.warehouseInventoriesIds;
		}

		return new WarehouseModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof WarehouseModel)) {
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
			'batchStockBalancesWarehouseIds',
			'batchStockBalancesWarehouse',
			'batchStockBalancesIds',
			'batchStockBalances',
			'batchStockTransactionDetailsIds',
			'batchStockTransactionDetails',
			'destinationWarehousesIds',
			'destinationWarehouses',
			'goodsReceiveNoteBatchsIds',
			'goodsReceiveNoteBatchs',
			'goodsReceiveNotesIds',
			'goodsReceiveNotes',
			'internalOrdersIds',
			'internalOrders',
			'inventoryAdjusmentBatchsIds',
			'inventoryAdjusmentBatchs',
			'inventoryAdjustmentsIds',
			'inventoryAdjustments',
			'inventoryBatchCorrectionsIds',
			'inventoryBatchCorrections',
			'locationsIds',
			'locations',
			'medicalFeesIds',
			'medicalFees',
			'medicationHeadersIds',
			'medicationHeaders',
			'prescriptionHeadersIds',
			'prescriptionHeaders',
			'purchaseOrdersIds',
			'purchaseOrders',
			'purchaseRequisitionsIds',
			'purchaseRequisitions',
			'retailPharmaciesIds',
			'retailPharmacies',
			'returnSuppliersIds',
			'returnSuppliers',
			'sourceWarehousesIds',
			'sourceWarehouses',
			'stockCataloguesIds',
			'stockCatalogues',
			'stockControlsIds',
			'stockControls',
			'stockTransactionDetailsIds',
			'stockTransactionDetails',
			'stockTransactionPerDateTypesIds',
			'stockTransactionPerDateTypes',
			'stockTransactionPerDatesIds',
			'stockTransactionPerDates',
			'vaccinationOrderDetailsIds',
			'vaccinationOrderDetails',
			'warehouseInitialStockSIds',
			'warehouseInitialStockS',
			'warehouseInventoriesIds',
			'warehouseInventories',
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
