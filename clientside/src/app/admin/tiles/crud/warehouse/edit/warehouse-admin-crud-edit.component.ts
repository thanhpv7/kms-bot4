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

import {Component, EventEmitter, Input, OnChanges, OnInit, OnDestroy, Output, SimpleChanges} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {Observable, Subject, Subscription} from 'rxjs';
import { ActivatedRoute, NavigationExtras } from '@angular/router';
import {debounceTime, distinctUntilChanged, map, filter} from 'rxjs/operators';
import {Store, Action as NgRxAction} from '@ngrx/store';
import * as routingAction from 'src/app/lib/routing/routing.action';
import {Group, ModelProperty, ModelRelation} from 'src/app/lib/models/abstract.model';
import * as modelAction from 'src/app/models/warehouse/warehouse.model.action';
import {WarehouseModelState, WarehouseModelAudit} from 'src/app/models/warehouse/warehouse.model.state';
import {WarehouseModel} from 'src/app/models/warehouse/warehouse.model';
import {
	getWarehouseModelAuditsByEntityId,
	getWarehouseModelWithId,
	getCountWarehouseModels,
} from 'src/app/models/warehouse/warehouse.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BatchStockBalanceModel} from 'src/app/models/batchStockBalance/batch_stock_balance.model';
import * as batchStockBalanceModelAction from 'src/app/models/batchStockBalance/batch_stock_balance.model.action';
import {
	getBatchStockBalanceCollectionModels, getBatchStockBalanceModelWithId,
} from 'src/app/models/batchStockBalance/batch_stock_balance.model.selector';
import {BatchStockBalancePerDateModel} from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model';
import * as batchStockBalancePerDateModelAction from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model.action';
import {
	getBatchStockBalancePerDateCollectionModels, getBatchStockBalancePerDateModelWithId,
} from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model.selector';
import {BatchStockTransactionDetailModel} from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model';
import * as batchStockTransactionDetailModelAction from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model.action';
import {
	getBatchStockTransactionDetailCollectionModels, getBatchStockTransactionDetailModelWithId,
} from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model.selector';
import {GoodsReceiveNoteModel} from 'src/app/models/goodsReceiveNote/goods_receive_note.model';
import * as goodsReceiveNoteModelAction from 'src/app/models/goodsReceiveNote/goods_receive_note.model.action';
import {
	getGoodsReceiveNoteCollectionModels, getGoodsReceiveNoteModelWithId,
} from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import {GoodsReceiveNoteBatchModel} from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model';
import * as goodsReceiveNoteBatchModelAction from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.action';
import {
	getGoodsReceiveNoteBatchCollectionModels, getGoodsReceiveNoteBatchModelWithId,
} from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.selector';
import {InternalOrderModel} from 'src/app/models/internalOrder/internal_order.model';
import * as internalOrderModelAction from 'src/app/models/internalOrder/internal_order.model.action';
import {
	getInternalOrderCollectionModels, getInternalOrderModelWithId,
} from 'src/app/models/internalOrder/internal_order.model.selector';
import {InventoryAdjusmentBatchModel} from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import * as inventoryAdjusmentBatchModelAction from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.action';
import {
	getInventoryAdjusmentBatchCollectionModels, getInventoryAdjusmentBatchModelWithId,
} from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.selector';
import {InventoryAdjustmentModel} from 'src/app/models/inventoryAdjustment/inventory_adjustment.model';
import * as inventoryAdjustmentModelAction from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.action';
import {
	getInventoryAdjustmentCollectionModels, getInventoryAdjustmentModelWithId,
} from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.selector';
import {InventoryBatchCorrectionModel} from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model';
import * as inventoryBatchCorrectionModelAction from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.action';
import {
	getInventoryBatchCorrectionCollectionModels, getInventoryBatchCorrectionModelWithId,
} from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.selector';
import {LocationModel} from 'src/app/models/location/location.model';
import * as locationModelAction from 'src/app/models/location/location.model.action';
import {
	getLocationCollectionModels, getLocationModelWithId,
} from 'src/app/models/location/location.model.selector';
import {MedicalFeeModel} from 'src/app/models/medicalFee/medical_fee.model';
import * as medicalFeeModelAction from 'src/app/models/medicalFee/medical_fee.model.action';
import {
	getMedicalFeeCollectionModels, getMedicalFeeModelWithId,
} from 'src/app/models/medicalFee/medical_fee.model.selector';
import {MedicationHeaderModel} from 'src/app/models/medicationHeader/medication_header.model';
import * as medicationHeaderModelAction from 'src/app/models/medicationHeader/medication_header.model.action';
import {
	getMedicationHeaderCollectionModels, getMedicationHeaderModelWithId,
} from 'src/app/models/medicationHeader/medication_header.model.selector';
import {PrescriptionHeaderModel} from 'src/app/models/prescriptionHeader/prescription_header.model';
import * as prescriptionHeaderModelAction from 'src/app/models/prescriptionHeader/prescription_header.model.action';
import {
	getPrescriptionHeaderCollectionModels, getPrescriptionHeaderModelWithId,
} from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import {PurchaseOrderModel} from 'src/app/models/purchaseOrder/purchase_order.model';
import * as purchaseOrderModelAction from 'src/app/models/purchaseOrder/purchase_order.model.action';
import {
	getPurchaseOrderCollectionModels, getPurchaseOrderModelWithId,
} from 'src/app/models/purchaseOrder/purchase_order.model.selector';
import {PurchaseRequisitionModel} from 'src/app/models/purchaseRequisition/purchase_requisition.model';
import * as purchaseRequisitionModelAction from 'src/app/models/purchaseRequisition/purchase_requisition.model.action';
import {
	getPurchaseRequisitionCollectionModels, getPurchaseRequisitionModelWithId,
} from 'src/app/models/purchaseRequisition/purchase_requisition.model.selector';
import {RetailPharmacyModel} from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import * as retailPharmacyModelAction from 'src/app/models/retailPharmacy/retail_pharmacy.model.action';
import {
	getRetailPharmacyCollectionModels, getRetailPharmacyModelWithId,
} from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import {ReturnSupplierModel} from 'src/app/models/returnSupplier/return_supplier.model';
import * as returnSupplierModelAction from 'src/app/models/returnSupplier/return_supplier.model.action';
import {
	getReturnSupplierCollectionModels, getReturnSupplierModelWithId,
} from 'src/app/models/returnSupplier/return_supplier.model.selector';
import {StockCatalogueModel} from 'src/app/models/stockCatalogue/stock_catalogue.model';
import * as stockCatalogueModelAction from 'src/app/models/stockCatalogue/stock_catalogue.model.action';
import {
	getStockCatalogueCollectionModels, getStockCatalogueModelWithId,
} from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import {StockControlModel} from 'src/app/models/stockControl/stock_control.model';
import * as stockControlModelAction from 'src/app/models/stockControl/stock_control.model.action';
import {
	getStockControlCollectionModels, getStockControlModelWithId,
} from 'src/app/models/stockControl/stock_control.model.selector';
import {StockTransactionDetailModel} from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model';
import * as stockTransactionDetailModelAction from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.action';
import {
	getStockTransactionDetailCollectionModels, getStockTransactionDetailModelWithId,
} from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.selector';
import {StockTransactionPerDateModel} from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model';
import * as stockTransactionPerDateModelAction from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model.action';
import {
	getStockTransactionPerDateCollectionModels, getStockTransactionPerDateModelWithId,
} from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model.selector';
import {StockTransactionPerDateTypeModel} from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model';
import * as stockTransactionPerDateTypeModelAction from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.action';
import {
	getStockTransactionPerDateTypeCollectionModels, getStockTransactionPerDateTypeModelWithId,
} from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.selector';
import {TransferOrderModel} from 'src/app/models/transferOrder/transfer_order.model';
import * as transferOrderModelAction from 'src/app/models/transferOrder/transfer_order.model.action';
import {
	getTransferOrderCollectionModels, getTransferOrderModelWithId,
} from 'src/app/models/transferOrder/transfer_order.model.selector';
import {VaccinationOrderDetailModel} from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model';
import * as vaccinationOrderDetailModelAction from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.action';
import {
	getVaccinationOrderDetailCollectionModels, getVaccinationOrderDetailModelWithId,
} from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import {WarehouseInitialStockModel} from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model';
import * as warehouseInitialStockModelAction from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model.action';
import {
	getWarehouseInitialStockCollectionModels, getWarehouseInitialStockModelWithId,
} from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model.selector';
import {WarehouseInventoryModel} from 'src/app/models/warehouseInventory/warehouse_inventory.model';
import * as warehouseInventoryModelAction from 'src/app/models/warehouseInventory/warehouse_inventory.model.action';
import {
	getWarehouseInventoryCollectionModels, getWarehouseInventoryModelWithId,
} from 'src/app/models/warehouseInventory/warehouse_inventory.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../warehouse-admin-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-warehouse-admin-crud-edit',
	templateUrl: './warehouse-admin-crud-edit.component.html',
	styleUrls: [
		'./warehouse-admin-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class AdminWarehouseCrudEditComponent
		// % protected region % [Add any additional interfaces to implement here] off begin
		implements OnInit, OnChanges, OnDestroy
		// % protected region % [Add any additional interfaces to implement here] end
{

	/************************************************************************
	 *	   _____             __ _         ______ _      _     _
	 *  / ____|           / _(_)       |  ____(_)    | |   | |
	 * | |     ___  _ __ | |_ _  __ _  | |__   _  ___| | __| |___
	 * | |    / _ \| '_ \|  _| |/ _` | |  __| | |/ _ \ |/ _` / __|
	 * | |___| (_) | | | | | | | (_| | | |    | |  __/ | (_| \__ \
	 *  \_____\___/|_| |_|_| |_|\__, | |_|    |_|\___|_|\__,_|___/
	 *                           __/ |
	 *                          |___/
	 ************************************************************************/
	/**
	 * Whether route component
	 */
	@Input()
	singlePageComponent = false;

	/**
	 * Whether in create/edit/view mode
	 * Only used when singlePageComponent is turned on
	 * Routing will overwrite this according to the url path
	 */
	@Input()
	tileMode: CrudTileMode = CrudTileMode.Create;

	/**
	 * Id of entity to display
	 * Only used when singlePageComponent is turned on
	 */
	@Input()
	targetModelId: string;

	/**
	 * How many items are included in this page.
	 */
	@Input()
	pageSize: number = 10;

	// % protected region % [Change your collection id if required here] off begin
	/**
	 * The collection id used in the store
	 * Default to be the uuid of the tile, you could change this to custom id you want to share in different component
	 *
	 */
	@Input()
	collectionId: string = 'ea2f2887-6641-46f1-a3d6-542d78c3c9c7';
	// % protected region % [Change your collection id if required here] end

	/**
	 * Event emitter when user clicking button to change mode of tile
	 */
	@Output()
	tileModeChange: EventEmitter<{tileMode: CrudTileMode, payload?: any}> = new EventEmitter();

	/**
	 * Whether componet is view only
	 */
	get isViewOnly(): boolean {
		return this.tileMode === CrudTileMode.View;
	}

	/**
	 * Entity audits to be fetched from the server.
	 */
	warehouseAudits$: Observable<WarehouseModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Batch Stock Balances Warehouse here] off begin
	batchStockBalancesWarehouseMultiCrudActive: boolean = false;
	batchStockBalancesWarehouseDisplayName = 'Batch Stock Balances Warehouse';
	batchStockBalancesWarehouseCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Batch Stock Balances Warehouse here] end
	batchStockBalancesWarehouseOppositeRelation = 'warehouse';
	batchStockBalancesWarehouseRelations: ModelRelation[] = this.batchStockBalancesWarehouseMultiCrudActive ? BatchStockBalanceModel.getRelations()
		.map(relation => {
			if (relation.id === this.batchStockBalancesWarehouseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Batch Stock Balances here] off begin
	batchStockBalancesMultiCrudActive: boolean = false;
	batchStockBalancesDisplayName = 'Batch Stock Balances';
	batchStockBalancesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Batch Stock Balances here] end
	batchStockBalancesOppositeRelation = 'warehouse';
	batchStockBalancesRelations: ModelRelation[] = this.batchStockBalancesMultiCrudActive ? BatchStockBalancePerDateModel.getRelations()
		.map(relation => {
			if (relation.id === this.batchStockBalancesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Batch Stock Transaction Details here] off begin
	batchStockTransactionDetailsMultiCrudActive: boolean = false;
	batchStockTransactionDetailsDisplayName = 'Batch Stock Transaction Details';
	batchStockTransactionDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Batch Stock Transaction Details here] end
	batchStockTransactionDetailsOppositeRelation = 'warehouse';
	batchStockTransactionDetailsRelations: ModelRelation[] = this.batchStockTransactionDetailsMultiCrudActive ? BatchStockTransactionDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.batchStockTransactionDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Destination Warehouse and Destination Warehouses here] off begin
	destinationWarehousesMultiCrudActive: boolean = false;
	destinationWarehousesDisplayName = 'Destination Warehouses';
	destinationWarehousesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Destination Warehouse and Destination Warehouses here] end
	destinationWarehousesOppositeRelation = 'destinationWarehouse';
	destinationWarehousesRelations: ModelRelation[] = this.destinationWarehousesMultiCrudActive ? TransferOrderModel.getRelations()
		.map(relation => {
			if (relation.id === this.destinationWarehousesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Goods Receive Note Batchs here] off begin
	goodsReceiveNoteBatchsMultiCrudActive: boolean = false;
	goodsReceiveNoteBatchsDisplayName = 'Goods Receive Note Batchs';
	goodsReceiveNoteBatchsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Goods Receive Note Batchs here] end
	goodsReceiveNoteBatchsOppositeRelation = 'warehouse';
	goodsReceiveNoteBatchsRelations: ModelRelation[] = this.goodsReceiveNoteBatchsMultiCrudActive ? GoodsReceiveNoteBatchModel.getRelations()
		.map(relation => {
			if (relation.id === this.goodsReceiveNoteBatchsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Goods Receive Notes here] off begin
	goodsReceiveNotesMultiCrudActive: boolean = false;
	goodsReceiveNotesDisplayName = 'Goods Receive Notes';
	goodsReceiveNotesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Goods Receive Notes here] end
	goodsReceiveNotesOppositeRelation = 'warehouse';
	goodsReceiveNotesRelations: ModelRelation[] = this.goodsReceiveNotesMultiCrudActive ? GoodsReceiveNoteModel.getRelations()
		.map(relation => {
			if (relation.id === this.goodsReceiveNotesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Internal Orders here] off begin
	internalOrdersMultiCrudActive: boolean = false;
	internalOrdersDisplayName = 'Internal Orders';
	internalOrdersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Internal Orders here] end
	internalOrdersOppositeRelation = 'warehouse';
	internalOrdersRelations: ModelRelation[] = this.internalOrdersMultiCrudActive ? InternalOrderModel.getRelations()
		.map(relation => {
			if (relation.id === this.internalOrdersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Inventory Adjusment Batchs here] off begin
	inventoryAdjusmentBatchsMultiCrudActive: boolean = false;
	inventoryAdjusmentBatchsDisplayName = 'Inventory Adjusment Batchs';
	inventoryAdjusmentBatchsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Inventory Adjusment Batchs here] end
	inventoryAdjusmentBatchsOppositeRelation = 'warehouse';
	inventoryAdjusmentBatchsRelations: ModelRelation[] = this.inventoryAdjusmentBatchsMultiCrudActive ? InventoryAdjusmentBatchModel.getRelations()
		.map(relation => {
			if (relation.id === this.inventoryAdjusmentBatchsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Inventory Adjustments here] off begin
	inventoryAdjustmentsMultiCrudActive: boolean = false;
	inventoryAdjustmentsDisplayName = 'Inventory Adjustments';
	inventoryAdjustmentsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Inventory Adjustments here] end
	inventoryAdjustmentsOppositeRelation = 'warehouse';
	inventoryAdjustmentsRelations: ModelRelation[] = this.inventoryAdjustmentsMultiCrudActive ? InventoryAdjustmentModel.getRelations()
		.map(relation => {
			if (relation.id === this.inventoryAdjustmentsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Inventory Batch Corrections here] off begin
	inventoryBatchCorrectionsMultiCrudActive: boolean = false;
	inventoryBatchCorrectionsDisplayName = 'Inventory Batch Corrections';
	inventoryBatchCorrectionsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Inventory Batch Corrections here] end
	inventoryBatchCorrectionsOppositeRelation = 'warehouse';
	inventoryBatchCorrectionsRelations: ModelRelation[] = this.inventoryBatchCorrectionsMultiCrudActive ? InventoryBatchCorrectionModel.getRelations()
		.map(relation => {
			if (relation.id === this.inventoryBatchCorrectionsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Locations here] off begin
	locationsMultiCrudActive: boolean = false;
	locationsDisplayName = 'Locations';
	locationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Locations here] end
	locationsOppositeRelation = 'warehouse';
	locationsRelations: ModelRelation[] = this.locationsMultiCrudActive ? LocationModel.getRelations()
		.map(relation => {
			if (relation.id === this.locationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Medical Fees here] off begin
	medicalFeesMultiCrudActive: boolean = false;
	medicalFeesDisplayName = 'Medical Fees';
	medicalFeesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Medical Fees here] end
	medicalFeesOppositeRelation = 'warehouse';
	medicalFeesRelations: ModelRelation[] = this.medicalFeesMultiCrudActive ? MedicalFeeModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalFeesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Medication Headers here] off begin
	medicationHeadersMultiCrudActive: boolean = false;
	medicationHeadersDisplayName = 'Medication Headers';
	medicationHeadersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Medication Headers here] end
	medicationHeadersOppositeRelation = 'warehouse';
	medicationHeadersRelations: ModelRelation[] = this.medicationHeadersMultiCrudActive ? MedicationHeaderModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicationHeadersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Prescription Headers here] off begin
	prescriptionHeadersMultiCrudActive: boolean = false;
	prescriptionHeadersDisplayName = 'Prescription Headers';
	prescriptionHeadersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Prescription Headers here] end
	prescriptionHeadersOppositeRelation = 'warehouse';
	prescriptionHeadersRelations: ModelRelation[] = this.prescriptionHeadersMultiCrudActive ? PrescriptionHeaderModel.getRelations()
		.map(relation => {
			if (relation.id === this.prescriptionHeadersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Purchase Orders here] off begin
	purchaseOrdersMultiCrudActive: boolean = false;
	purchaseOrdersDisplayName = 'Purchase Orders';
	purchaseOrdersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Purchase Orders here] end
	purchaseOrdersOppositeRelation = 'warehouse';
	purchaseOrdersRelations: ModelRelation[] = this.purchaseOrdersMultiCrudActive ? PurchaseOrderModel.getRelations()
		.map(relation => {
			if (relation.id === this.purchaseOrdersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Purchase Requisitions here] off begin
	purchaseRequisitionsMultiCrudActive: boolean = false;
	purchaseRequisitionsDisplayName = 'Purchase Requisitions';
	purchaseRequisitionsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Purchase Requisitions here] end
	purchaseRequisitionsOppositeRelation = 'warehouse';
	purchaseRequisitionsRelations: ModelRelation[] = this.purchaseRequisitionsMultiCrudActive ? PurchaseRequisitionModel.getRelations()
		.map(relation => {
			if (relation.id === this.purchaseRequisitionsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Retail Pharmacies here] off begin
	retailPharmaciesMultiCrudActive: boolean = false;
	retailPharmaciesDisplayName = 'Retail Pharmacies';
	retailPharmaciesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Retail Pharmacies here] end
	retailPharmaciesOppositeRelation = 'warehouse';
	retailPharmaciesRelations: ModelRelation[] = this.retailPharmaciesMultiCrudActive ? RetailPharmacyModel.getRelations()
		.map(relation => {
			if (relation.id === this.retailPharmaciesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Return Suppliers here] off begin
	returnSuppliersMultiCrudActive: boolean = false;
	returnSuppliersDisplayName = 'Return Suppliers';
	returnSuppliersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Return Suppliers here] end
	returnSuppliersOppositeRelation = 'warehouse';
	returnSuppliersRelations: ModelRelation[] = this.returnSuppliersMultiCrudActive ? ReturnSupplierModel.getRelations()
		.map(relation => {
			if (relation.id === this.returnSuppliersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Source Warehouse and Source Warehouses here] off begin
	sourceWarehousesMultiCrudActive: boolean = false;
	sourceWarehousesDisplayName = 'Source Warehouses';
	sourceWarehousesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Source Warehouse and Source Warehouses here] end
	sourceWarehousesOppositeRelation = 'sourceWarehouse';
	sourceWarehousesRelations: ModelRelation[] = this.sourceWarehousesMultiCrudActive ? TransferOrderModel.getRelations()
		.map(relation => {
			if (relation.id === this.sourceWarehousesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Catalogues here] off begin
	stockCataloguesMultiCrudActive: boolean = false;
	stockCataloguesDisplayName = 'Stock Catalogues';
	stockCataloguesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Catalogues here] end
	stockCataloguesOppositeRelation = 'warehouse';
	stockCataloguesRelations: ModelRelation[] = this.stockCataloguesMultiCrudActive ? StockCatalogueModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockCataloguesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Controls here] off begin
	stockControlsMultiCrudActive: boolean = false;
	stockControlsDisplayName = 'Stock Controls';
	stockControlsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Controls here] end
	stockControlsOppositeRelation = 'warehouse';
	stockControlsRelations: ModelRelation[] = this.stockControlsMultiCrudActive ? StockControlModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockControlsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Transaction Details here] off begin
	stockTransactionDetailsMultiCrudActive: boolean = false;
	stockTransactionDetailsDisplayName = 'Stock Transaction Details';
	stockTransactionDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Transaction Details here] end
	stockTransactionDetailsOppositeRelation = 'warehouse';
	stockTransactionDetailsRelations: ModelRelation[] = this.stockTransactionDetailsMultiCrudActive ? StockTransactionDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockTransactionDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Transaction Per Date Types here] off begin
	stockTransactionPerDateTypesMultiCrudActive: boolean = false;
	stockTransactionPerDateTypesDisplayName = 'Stock Transaction Per Date Types';
	stockTransactionPerDateTypesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Transaction Per Date Types here] end
	stockTransactionPerDateTypesOppositeRelation = 'warehouse';
	stockTransactionPerDateTypesRelations: ModelRelation[] = this.stockTransactionPerDateTypesMultiCrudActive ? StockTransactionPerDateTypeModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockTransactionPerDateTypesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Transaction Per Dates here] off begin
	stockTransactionPerDatesMultiCrudActive: boolean = false;
	stockTransactionPerDatesDisplayName = 'Stock Transaction Per Dates';
	stockTransactionPerDatesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Transaction Per Dates here] end
	stockTransactionPerDatesOppositeRelation = 'warehouse';
	stockTransactionPerDatesRelations: ModelRelation[] = this.stockTransactionPerDatesMultiCrudActive ? StockTransactionPerDateModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockTransactionPerDatesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Vaccination Order Details here] off begin
	vaccinationOrderDetailsMultiCrudActive: boolean = false;
	vaccinationOrderDetailsDisplayName = 'Vaccination Order Details';
	vaccinationOrderDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Vaccination Order Details here] end
	vaccinationOrderDetailsOppositeRelation = 'warehouse';
	vaccinationOrderDetailsRelations: ModelRelation[] = this.vaccinationOrderDetailsMultiCrudActive ? VaccinationOrderDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.vaccinationOrderDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Warehouse Initial Stock s here] off begin
	warehouseInitialStockSMultiCrudActive: boolean = false;
	warehouseInitialStockSDisplayName = 'Warehouse Initial Stock s';
	warehouseInitialStockSCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Warehouse Initial Stock s here] end
	warehouseInitialStockSOppositeRelation = 'warehouse';
	warehouseInitialStockSRelations: ModelRelation[] = this.warehouseInitialStockSMultiCrudActive ? WarehouseInitialStockModel.getRelations()
		.map(relation => {
			if (relation.id === this.warehouseInitialStockSOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Warehouse Inventories here] off begin
	warehouseInventoriesMultiCrudActive: boolean = false;
	warehouseInventoriesDisplayName = 'Warehouse Inventories';
	warehouseInventoriesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Warehouse Inventories here] end
	warehouseInventoriesOppositeRelation = 'warehouse';
	warehouseInventoriesRelations: ModelRelation[] = this.warehouseInventoriesMultiCrudActive ? WarehouseInventoryModel.getRelations()
		.map(relation => {
			if (relation.id === this.warehouseInventoriesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = WarehouseModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = WarehouseModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = WarehouseModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'batchStockBalancesWarehouse' && this.batchStockBalancesWarehouseMultiCrudActive) {
					exp.fields = BatchStockBalanceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'batchStockBalances' && this.batchStockBalancesMultiCrudActive) {
					exp.fields = BatchStockBalancePerDateModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'batchStockTransactionDetails' && this.batchStockTransactionDetailsMultiCrudActive) {
					exp.fields = BatchStockTransactionDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'destinationWarehouses' && this.destinationWarehousesMultiCrudActive) {
					exp.fields = TransferOrderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'goodsReceiveNoteBatchs' && this.goodsReceiveNoteBatchsMultiCrudActive) {
					exp.fields = GoodsReceiveNoteBatchModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'goodsReceiveNotes' && this.goodsReceiveNotesMultiCrudActive) {
					exp.fields = GoodsReceiveNoteModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'internalOrders' && this.internalOrdersMultiCrudActive) {
					exp.fields = InternalOrderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'inventoryAdjusmentBatchs' && this.inventoryAdjusmentBatchsMultiCrudActive) {
					exp.fields = InventoryAdjusmentBatchModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'inventoryAdjustments' && this.inventoryAdjustmentsMultiCrudActive) {
					exp.fields = InventoryAdjustmentModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'inventoryBatchCorrections' && this.inventoryBatchCorrectionsMultiCrudActive) {
					exp.fields = InventoryBatchCorrectionModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'locations' && this.locationsMultiCrudActive) {
					exp.fields = LocationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalFees' && this.medicalFeesMultiCrudActive) {
					exp.fields = MedicalFeeModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicationHeaders' && this.medicationHeadersMultiCrudActive) {
					exp.fields = MedicationHeaderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'prescriptionHeaders' && this.prescriptionHeadersMultiCrudActive) {
					exp.fields = PrescriptionHeaderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'purchaseOrders' && this.purchaseOrdersMultiCrudActive) {
					exp.fields = PurchaseOrderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'purchaseRequisitions' && this.purchaseRequisitionsMultiCrudActive) {
					exp.fields = PurchaseRequisitionModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'retailPharmacies' && this.retailPharmaciesMultiCrudActive) {
					exp.fields = RetailPharmacyModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'returnSuppliers' && this.returnSuppliersMultiCrudActive) {
					exp.fields = ReturnSupplierModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'sourceWarehouses' && this.sourceWarehousesMultiCrudActive) {
					exp.fields = TransferOrderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'stockCatalogues' && this.stockCataloguesMultiCrudActive) {
					exp.fields = StockCatalogueModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'stockControls' && this.stockControlsMultiCrudActive) {
					exp.fields = StockControlModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'stockTransactionDetails' && this.stockTransactionDetailsMultiCrudActive) {
					exp.fields = StockTransactionDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'stockTransactionPerDateTypes' && this.stockTransactionPerDateTypesMultiCrudActive) {
					exp.fields = StockTransactionPerDateTypeModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'stockTransactionPerDates' && this.stockTransactionPerDatesMultiCrudActive) {
					exp.fields = StockTransactionPerDateModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'vaccinationOrderDetails' && this.vaccinationOrderDetailsMultiCrudActive) {
					exp.fields = VaccinationOrderDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'warehouseInitialStockS' && this.warehouseInitialStockSMultiCrudActive) {
					exp.fields = WarehouseInitialStockModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'warehouseInventories' && this.warehouseInventoriesMultiCrudActive) {
					exp.fields = WarehouseInventoryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				return exp;
			}
		);
		return expands;
	}
	// % protected region % [Change your default expands if required here] end

	/**
	 * The model to be created or edited depending on what the model currently is.
	 */
	targetModel: WarehouseModel;

	/**
	 * The form group created from the target model
	 */
	modelFormGroup: FormGroup;

	/**
	 * The current router state when this page is displayed.
	 */
	routerState: RouterState;

	/**
	 * Unsubscribe from this subscription when the crud component is destroyed
	 */
	routerStateSubscription$: Subscription;

	/**
	 * The Names of the buttons to be passed to the crud edit page for adding additional entities to the multi crud view.
	 * This requires a list of strings, where each string will become a button which sends an event back to onMultiEntityAction()
	 */
	defaultMultiEntityButtons: {name: string, many: boolean}[] = [];


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private readonly store: Store<{ model: WarehouseModelState }>,
		private readonly routerStore: Store<{ router: RouterState }>,
		private readonly activatedRoute: ActivatedRoute,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnChanges(changes: SimpleChanges) {
		// % protected region % [Add any additional ngOnChanges logic before the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic before the main body here] end

		// % protected region % [Customise the ngOnChanges main body here] off begin
		if (changes.hasOwnProperty('tileMode') || changes.hasOwnProperty('targetModelId')) {
			this.initializeTargetModel();
		}
		// % protected region % [Customise the ngOnChanges main body here] end

		// % protected region % [Add any additional ngOnChanges logic after the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnInit() {
		// % protected region % [Add any additional ngOnInit logic before the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before the main body here] end

		this.initialiseMultiEntityCollections();

		this.routerStateSubscription$ = this.routerStore.select(getRouterState).subscribe(routerState => {
				this.routerState = routerState;
				this.initializeTargetModel();
			}
		);

		let firstTime = true; // ensures that the user isn't instantly navigated back to the list page
		/**
		 * Tile Mode Change will not be triggered until the creation action has been dispatched and completed
		 * Subscribing in ngOnInit ensures that a count models action can be passed as an afterwards action, so the
		 * subscribed code will not be triggered until after the creation has been completed
		 */
		this.creationNavigationSubscription$.add(this.store.select(getCountWarehouseModels).subscribe(count => {
			if (this.singlePageComponent && !firstTime) {
				this.triggerTileModeChange(CrudTileMode.List);
			}

			firstTime = false;
		}));

		// % protected region % [Add any additional ngOnInit logic after the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnDestroy() {
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] end

		if (this.routerStateSubscription$) {
			this.routerStateSubscription$.unsubscribe();
		}

		if (this.creationNavigationSubscription$) {
			this.creationNavigationSubscription$.unsubscribe();
		}

		// % protected region % [Add any additional ngOnDestroy logic after the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic after the main body here] end
	}

	/**
	 * Initialize target model when input fields changed or router changed
	 */
	private initializeTargetModel() {
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] end

		if (!this.singlePageComponent) {
			this.initWithRouting();
		}

		// When tile mode is not defiend, reutrn directly without fetching data
		if (this.tileMode === undefined) {
			return;
		}

		this.resetPropsAndRels();
		this.prepareReferenceCollections();
		this.createReactiveForm();

		if (this.tileMode === CrudTileMode.Edit || this.tileMode === CrudTileMode.View) {
			// % protected region % [Add additional processing for View and Edit mode before the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode before the main body here] end

			this.fetchEntity();

			// % protected region % [Add additional processing for View and Edit mode after the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode after the main body here] end
		} else if (this.tileMode === CrudTileMode.Create) {
			// % protected region % [Add additional processing for Create mode before the main body here] off begin
			// % protected region % [Add additional processing for Create mode before the main body here] end

			this.targetModel = new WarehouseModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.warehouseAudits$ = this.store.select(getWarehouseModelAuditsByEntityId, this.targetModelId);
		}

		// % protected region % [Add any additional initializeTargetModel logic after the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic after the main body here] end
	}

	/**
	 * Function to initialize the component fields according to the routing
	 * Method only be invoked when routing is enabled
	 */
	private initWithRouting() {
		// % protected region % [Override the initWithRouting method body here] off begin
		this.targetModelId = this.routerState.params.id;
		if (this.routerState.urls.includes('view')) {
			this.tileMode = CrudTileMode.View;
		} else if (this.routerState.urls.includes('edit')) {
			this.tileMode = CrudTileMode.Edit;
		} else if (this.routerState.urls.includes('create')) {
			this.tileMode = CrudTileMode.Create;
		} else {
			this.tileMode = undefined;
		}
		// % protected region % [Override the initWithRouting method body here] end
	}

	/**
	 * Initialize and dispatch event to fetch data from serverside
	 */
	private fetchEntity() {
		const stateConfig: PassableStateConfig<WarehouseModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.WarehouseAction(
			modelAction.WarehouseModelActionTypes.FETCH_WAREHOUSE,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getWarehouseModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new WarehouseModel(model);
			model.syncRelations();

			this.targetModel = model;
			if (this.targetModel) {
				this.modelFormGroup.patchValue(this.targetModel);
			}

			this.multiCrudFetchAdditionalEntities();

			// % protected region % [Add additional actions after setting targetModel here] off begin
			// % protected region % [Add additional actions after setting targetModel here] end
		}));
	}

	/**
	 * This method iterates through all of the relations in the relations array and performs logic to fetch all of the entities to be shown
	 * in the dropdowns. This method does not need to be modified if you add additional entities to your crud list, as it will process all
	 * relations given to it
	 */
	private prepareReferenceCollections() {
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] end

		let updatedRelationsArray: ModelRelation[] = [];

		this.modelRelations.forEach(relation => {
			updatedRelationsArray.push(this.prepareSingleReferenceCollection(relation));
		});

		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] end

		this.modelRelations = updatedRelationsArray;
	}

	/**
	 * Prepare the collection for a single Model Relation.  This method is called once for each relation in the modelRelations array,
	 * although there are use cases for processing other relations individually.  Calling prepareReferenceCollections within a subscription
	 * is not recommended, as it will cause a feedback loop which will require a reload to fix.  Therefore, abstracting this logic out allows
	 * for preparing reference collections for multi entity crud for 1:M relations.
	 *
	 * @param relation The relation to prepare the collection for
	 * @returns the same relation, with some additional parameters added following the creation of the collection
	 */
	prepareSingleReferenceCollection(relation: ModelRelation, uniqueCollectionId?: string) {
		let referenceRequirements: PrepareReferenceRequirements;
		referenceRequirements = fetchPrepareReferenceRequirements(relation.entityName);
		relation.stateConfig = {
			pageIndex: 0,
			pageSize: this.pageSize,
			collectionId: uniqueCollectionId ? uniqueCollectionId : this.collectionId
		} as PassableStateConfig<any>;

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.initCollectionAction,
			relation.stateConfig
		));

		this.addSearchFunction(relation,
				referenceRequirements.collectionModelsSelector,
				referenceRequirements.baseAction,
				referenceRequirements.fetchWithQueryAction);

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.fetchAllAction,
			relation.stateConfig
		));

		return relation;
	}

	/**
	 * Add the search function for each of the relations.
	 *
	 */
	private addSearchFunction(modelRelation: ModelRelation, modelSelector: any, action: new (...args: any[]) => NgRxAction, actionType: string) {
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] end

		modelRelation.searchFunction = new Subject<string>();
		modelRelation.collection = this.store.select(modelSelector, this.collectionId);
		this.creationNavigationSubscription$.add(modelRelation.searchFunction.pipe(
			debounceTime(500),
			distinctUntilChanged(),
			filter(value => value != null)
		).subscribe(
			(term: string) => {
				modelRelation.stateConfig.queryParams = {
					pageSize: this.pageSize,
					pageIndex: 0,
					where: [
						[
							{
								path: modelRelation.displayName,
								operation: QueryOperation.CONTAINS,
								value: term
							}
						]
					]
				};

				// % protected region % [Add any additional logic to the search subscription before dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription before dispatch here] end

				this.store.dispatch(new action(
					actionType,
					modelRelation.stateConfig
				));

				// % protected region % [Add any additional logic to the search subscription after dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription after dispatch here] end
			}
		));

		// % protected region % [Add any additional code after the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code after the main logic of addSearchFunction here] end
	}

	/**
	 * Chang tile mode based on action and whether using routing
	 */
	private triggerTileModeChange(tileMode: CrudTileMode, id?: string, other?: object) {
		if (this.singlePageComponent) {
			this.tileModeChange.emit({
				tileMode: tileMode,
				payload: {
					id: id,
					...other
				}
			});
		} else {
			let extras: NavigationExtras = {};

			if (this.routerState.queryParams.listPage) {
				extras.queryParams = {listPage: this.routerState.queryParams.listPage};
			}

			const commands = [];

			commands.push('admin');
			commands.push('entities');
			commands.push('warehouse');

			if (tileMode !== CrudTileMode.List) {
				commands.push(tileMode.toString());
			}

			if (id) {
				commands.push(id);
			}

			this.routerStore.dispatch(new routingAction.NavigateRoutingAction(commands, extras));
		}
	}

	/**
	 * Triggered when the user clicks on the "View History" button.
	 */
	onViewHistory() {
		// % protected region % [Add any additional onViewHistory logic before the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic before the main body here] end

		this.store.dispatch(new modelAction.WarehouseAction(
			modelAction.WarehouseModelActionTypes.FETCH_WAREHOUSE_AUDITS_BY_ENTITY_ID,
			{
				targetModelId: this.targetModelId
			}
		));

		// % protected region % [Add any additional onViewHistory logic after the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic after the main body here] end
	}

	/**
	 * Triggered when the `Create` or `Save` button is clicked in the child create/edit view.
	 */
	onCreateOrSaveClicked(event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }) {
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] end

		this.targetModel = this.addAdditionalEntitiesToModel(this.targetModel, event);

		if (event.isCreate) {
			let stateConfig: PassableStateConfig<WarehouseModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.batchStockBalancesWarehouseMultiCrudActive || this.batchStockBalancesMultiCrudActive || this.batchStockTransactionDetailsMultiCrudActive || this.destinationWarehousesMultiCrudActive || this.goodsReceiveNoteBatchsMultiCrudActive || this.goodsReceiveNotesMultiCrudActive || this.internalOrdersMultiCrudActive || this.inventoryAdjusmentBatchsMultiCrudActive || this.inventoryAdjustmentsMultiCrudActive || this.inventoryBatchCorrectionsMultiCrudActive || this.locationsMultiCrudActive || this.medicalFeesMultiCrudActive || this.medicationHeadersMultiCrudActive || this.prescriptionHeadersMultiCrudActive || this.purchaseOrdersMultiCrudActive || this.purchaseRequisitionsMultiCrudActive || this.retailPharmaciesMultiCrudActive || this.returnSuppliersMultiCrudActive || this.sourceWarehousesMultiCrudActive || this.stockCataloguesMultiCrudActive || this.stockControlsMultiCrudActive || this.stockTransactionDetailsMultiCrudActive || this.stockTransactionPerDateTypesMultiCrudActive || this.stockTransactionPerDatesMultiCrudActive || this.vaccinationOrderDetailsMultiCrudActive || this.warehouseInitialStockSMultiCrudActive || this.warehouseInventoriesMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the creation state config here] off begin
				// % protected region % [Add any additional attributes to the creation state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for single page creation here] off begin
					// % protected region % [Add any additional afterwards actions for single page creation here] end
					// Count the models to trigger the tile mode change, as the count will have changed after creation
					new modelAction.WarehouseAction(
						modelAction.WarehouseModelActionTypes.COUNT_WAREHOUSES,
						null
					)
				];
			} else {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for creation here] off begin
					// % protected region % [Add any additional afterwards actions for creation here] end
					new routingAction.BackRoutingAction()
				];
			}

			// % protected region % [Add any additional logic before creating a new model here] off begin
			// % protected region % [Add any additional logic before creating a new model here] end

			this.store.dispatch(new modelAction.WarehouseAction(
				modelAction.WarehouseModelActionTypes.CREATE_WAREHOUSE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<WarehouseModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.batchStockBalancesWarehouseMultiCrudActive || this.batchStockBalancesMultiCrudActive || this.batchStockTransactionDetailsMultiCrudActive || this.destinationWarehousesMultiCrudActive || this.goodsReceiveNoteBatchsMultiCrudActive || this.goodsReceiveNotesMultiCrudActive || this.internalOrdersMultiCrudActive || this.inventoryAdjusmentBatchsMultiCrudActive || this.inventoryAdjustmentsMultiCrudActive || this.inventoryBatchCorrectionsMultiCrudActive || this.locationsMultiCrudActive || this.medicalFeesMultiCrudActive || this.medicationHeadersMultiCrudActive || this.prescriptionHeadersMultiCrudActive || this.purchaseOrdersMultiCrudActive || this.purchaseRequisitionsMultiCrudActive || this.retailPharmaciesMultiCrudActive || this.returnSuppliersMultiCrudActive || this.sourceWarehousesMultiCrudActive || this.stockCataloguesMultiCrudActive || this.stockControlsMultiCrudActive || this.stockTransactionDetailsMultiCrudActive || this.stockTransactionPerDateTypesMultiCrudActive || this.stockTransactionPerDatesMultiCrudActive || this.vaccinationOrderDetailsMultiCrudActive || this.warehouseInitialStockSMultiCrudActive || this.warehouseInventoriesMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.WarehouseAction(
					modelAction.WarehouseModelActionTypes.FETCH_WAREHOUSE,
					{
						targetModelId: this.targetModelId,
						queryParams: {
							expands: this.defaultExpands
						}
					}
				));
			} else {
				afterwardActions = [
					new routingAction.BackRoutingAction(),
					// % protected region % [Add any additional afterwards actions for updates here] off begin
					// % protected region % [Add any additional afterwards actions for updates here] end
				];
			}

			// % protected region % [Add any additional logic before update the current model here] off begin
			// % protected region % [Add any additional logic before update the current model here] end

			this.store.dispatch(new modelAction.WarehouseAction(
				modelAction.WarehouseModelActionTypes.UPDATE_WAREHOUSE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: WarehouseModel = new WarehouseModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getWarehouseModelWithId, this.targetModelId).subscribe(model => {
					let differences = new WarehouseModel(model).difference(updatedModel);

					// Object has been updated when differences is empty.
					// Differences excludes values such as references.  As these aren't visible on the list they do not need to be checked
					// When the user naivgates to a page which displays references, they will be fetched from the database with the correct values
					if (Object.keys(differences).length === 0) {
						this.triggerTileModeChange(CrudTileMode.List);
					}
				}));
			}
		}

		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] end
	}

	/**
	 * Removes form elements whose group id matches the group Id passed into the event, or adds a new
	 * group based on the entityName parameter
	 *
	 * @param event The event emitted from the base crud edit page
	 */
	onMultiEntityAction(event: { groupId: string, entityName: string, payload?: { [s: string]: any } }) {
		if (event.groupId) { // This path deletes the group with the specified id from the list
			this.modelProperties = this.modelProperties.filter(prop => {
				if (prop.group) {
					return prop.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});

			this.modelRelations = this.modelRelations.filter(relation => {
				if (relation.group) {
					return relation.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});
		} else {
			// This will add a new entity of the specified type to the list of props/relations
			if (event.entityName === this.batchStockBalancesWarehouseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BatchStockBalanceModel.getProps(), this.batchStockBalancesWarehouseRelations, this.isViewOnly),
					new BatchStockBalanceModel(),
					BatchStockBalanceModel,
					this.batchStockBalancesWarehouseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.batchStockBalancesWarehouseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.batchStockBalancesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BatchStockBalancePerDateModel.getProps(), this.batchStockBalancesRelations, this.isViewOnly),
					new BatchStockBalancePerDateModel(),
					BatchStockBalancePerDateModel,
					this.batchStockBalancesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.batchStockBalancesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.batchStockTransactionDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BatchStockTransactionDetailModel.getProps(), this.batchStockTransactionDetailsRelations, this.isViewOnly),
					new BatchStockTransactionDetailModel(),
					BatchStockTransactionDetailModel,
					this.batchStockTransactionDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.batchStockTransactionDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.destinationWarehousesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(TransferOrderModel.getProps(), this.destinationWarehousesRelations, this.isViewOnly),
					new TransferOrderModel(),
					TransferOrderModel,
					this.destinationWarehousesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.destinationWarehousesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.goodsReceiveNoteBatchsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(GoodsReceiveNoteBatchModel.getProps(), this.goodsReceiveNoteBatchsRelations, this.isViewOnly),
					new GoodsReceiveNoteBatchModel(),
					GoodsReceiveNoteBatchModel,
					this.goodsReceiveNoteBatchsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.goodsReceiveNoteBatchsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.goodsReceiveNotesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(GoodsReceiveNoteModel.getProps(), this.goodsReceiveNotesRelations, this.isViewOnly),
					new GoodsReceiveNoteModel(),
					GoodsReceiveNoteModel,
					this.goodsReceiveNotesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.goodsReceiveNotesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.internalOrdersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InternalOrderModel.getProps(), this.internalOrdersRelations, this.isViewOnly),
					new InternalOrderModel(),
					InternalOrderModel,
					this.internalOrdersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.internalOrdersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.inventoryAdjusmentBatchsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InventoryAdjusmentBatchModel.getProps(), this.inventoryAdjusmentBatchsRelations, this.isViewOnly),
					new InventoryAdjusmentBatchModel(),
					InventoryAdjusmentBatchModel,
					this.inventoryAdjusmentBatchsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.inventoryAdjusmentBatchsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.inventoryAdjustmentsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InventoryAdjustmentModel.getProps(), this.inventoryAdjustmentsRelations, this.isViewOnly),
					new InventoryAdjustmentModel(),
					InventoryAdjustmentModel,
					this.inventoryAdjustmentsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.inventoryAdjustmentsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.inventoryBatchCorrectionsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InventoryBatchCorrectionModel.getProps(), this.inventoryBatchCorrectionsRelations, this.isViewOnly),
					new InventoryBatchCorrectionModel(),
					InventoryBatchCorrectionModel,
					this.inventoryBatchCorrectionsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.inventoryBatchCorrectionsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.locationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(LocationModel.getProps(), this.locationsRelations, this.isViewOnly),
					new LocationModel(),
					LocationModel,
					this.locationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.locationsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalFeesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalFeeModel.getProps(), this.medicalFeesRelations, this.isViewOnly),
					new MedicalFeeModel(),
					MedicalFeeModel,
					this.medicalFeesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalFeesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicationHeadersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicationHeaderModel.getProps(), this.medicationHeadersRelations, this.isViewOnly),
					new MedicationHeaderModel(),
					MedicationHeaderModel,
					this.medicationHeadersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicationHeadersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.prescriptionHeadersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PrescriptionHeaderModel.getProps(), this.prescriptionHeadersRelations, this.isViewOnly),
					new PrescriptionHeaderModel(),
					PrescriptionHeaderModel,
					this.prescriptionHeadersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.prescriptionHeadersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.purchaseOrdersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PurchaseOrderModel.getProps(), this.purchaseOrdersRelations, this.isViewOnly),
					new PurchaseOrderModel(),
					PurchaseOrderModel,
					this.purchaseOrdersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.purchaseOrdersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.purchaseRequisitionsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PurchaseRequisitionModel.getProps(), this.purchaseRequisitionsRelations, this.isViewOnly),
					new PurchaseRequisitionModel(),
					PurchaseRequisitionModel,
					this.purchaseRequisitionsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.purchaseRequisitionsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.retailPharmaciesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RetailPharmacyModel.getProps(), this.retailPharmaciesRelations, this.isViewOnly),
					new RetailPharmacyModel(),
					RetailPharmacyModel,
					this.retailPharmaciesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.retailPharmaciesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.returnSuppliersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ReturnSupplierModel.getProps(), this.returnSuppliersRelations, this.isViewOnly),
					new ReturnSupplierModel(),
					ReturnSupplierModel,
					this.returnSuppliersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.returnSuppliersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.sourceWarehousesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(TransferOrderModel.getProps(), this.sourceWarehousesRelations, this.isViewOnly),
					new TransferOrderModel(),
					TransferOrderModel,
					this.sourceWarehousesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.sourceWarehousesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.stockCataloguesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StockCatalogueModel.getProps(), this.stockCataloguesRelations, this.isViewOnly),
					new StockCatalogueModel(),
					StockCatalogueModel,
					this.stockCataloguesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockCataloguesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.stockControlsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StockControlModel.getProps(), this.stockControlsRelations, this.isViewOnly),
					new StockControlModel(),
					StockControlModel,
					this.stockControlsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockControlsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.stockTransactionDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StockTransactionDetailModel.getProps(), this.stockTransactionDetailsRelations, this.isViewOnly),
					new StockTransactionDetailModel(),
					StockTransactionDetailModel,
					this.stockTransactionDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockTransactionDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.stockTransactionPerDateTypesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StockTransactionPerDateTypeModel.getProps(), this.stockTransactionPerDateTypesRelations, this.isViewOnly),
					new StockTransactionPerDateTypeModel(),
					StockTransactionPerDateTypeModel,
					this.stockTransactionPerDateTypesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockTransactionPerDateTypesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.stockTransactionPerDatesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StockTransactionPerDateModel.getProps(), this.stockTransactionPerDatesRelations, this.isViewOnly),
					new StockTransactionPerDateModel(),
					StockTransactionPerDateModel,
					this.stockTransactionPerDatesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockTransactionPerDatesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.vaccinationOrderDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(VaccinationOrderDetailModel.getProps(), this.vaccinationOrderDetailsRelations, this.isViewOnly),
					new VaccinationOrderDetailModel(),
					VaccinationOrderDetailModel,
					this.vaccinationOrderDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.vaccinationOrderDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.warehouseInitialStockSDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(WarehouseInitialStockModel.getProps(), this.warehouseInitialStockSRelations, this.isViewOnly),
					new WarehouseInitialStockModel(),
					WarehouseInitialStockModel,
					this.warehouseInitialStockSDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.warehouseInitialStockSRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.warehouseInventoriesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(WarehouseInventoryModel.getProps(), this.warehouseInventoriesRelations, this.isViewOnly),
					new WarehouseInventoryModel(),
					WarehouseInventoryModel,
					this.warehouseInventoriesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.warehouseInventoriesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			}
	}

	/**
	 * Triggered when the user switches from view mode to edit mode.
	 */
	onSwitchEdit() {
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.Edit, this.targetModelId);

		// % protected region % [Add any additional onSwitchEdit logic after the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic after the main body here] end
	}

	/**
	 * Triggered whenever the `Cancel` of the create/edit child component is clicked.
	 */
	onCancelClicked() {
		// % protected region % [Add any additional onCancelClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.List);

		// % protected region % [Add any additional onCancelClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic after the main body here] end
	}

	/**
	 * Create the reactive form from the input model
	 */
	createReactiveForm() {
		// % protected region % [Add any additional createReactiveForm logic before the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic before the main body here] end

		this.modelFormGroup = createReactiveFormFromModel(this.modelProperties, this.modelRelations, this.isViewOnly);

		// % protected region % [Add any additional createReactiveForm logic after the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic after the main body here] end
	}

	/**
	 * Returns the props and relations lists back to their default state.  This is called in fetchEntity to ensure that
	 * any time the entity changes these lists remain stable.  If you are adding additional entities to your crud page the
	 * placement of this method ensures that no duplicate attributes will be added on repeat runs of fetch entity
	 */
	resetPropsAndRels() {
		this.modelProperties = WarehouseModel.getProps();
		this.modelRelations = WarehouseModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'batchStockBalancesWarehouse';
		}).hideElement = this.batchStockBalancesWarehouseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'batchStockBalancesWarehouse').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'batchStockBalances';
		}).hideElement = this.batchStockBalancesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'batchStockBalances').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'batchStockTransactionDetails';
		}).hideElement = this.batchStockTransactionDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'batchStockTransactionDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'destinationWarehouses';
		}).hideElement = this.destinationWarehousesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'destinationWarehouses').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'goodsReceiveNoteBatchs';
		}).hideElement = this.goodsReceiveNoteBatchsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'goodsReceiveNoteBatchs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'goodsReceiveNotes';
		}).hideElement = this.goodsReceiveNotesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'goodsReceiveNotes').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'internalOrders';
		}).hideElement = this.internalOrdersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'internalOrders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'inventoryAdjusmentBatchs';
		}).hideElement = this.inventoryAdjusmentBatchsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'inventoryAdjusmentBatchs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'inventoryAdjustments';
		}).hideElement = this.inventoryAdjustmentsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'inventoryAdjustments').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'inventoryBatchCorrections';
		}).hideElement = this.inventoryBatchCorrectionsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'inventoryBatchCorrections').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'locations';
		}).hideElement = this.locationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'locations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalFees';
		}).hideElement = this.medicalFeesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalFees').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicationHeaders';
		}).hideElement = this.medicationHeadersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicationHeaders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'prescriptionHeaders';
		}).hideElement = this.prescriptionHeadersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'prescriptionHeaders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'purchaseOrders';
		}).hideElement = this.purchaseOrdersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'purchaseOrders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'purchaseRequisitions';
		}).hideElement = this.purchaseRequisitionsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'purchaseRequisitions').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'retailPharmacies';
		}).hideElement = this.retailPharmaciesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'retailPharmacies').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'returnSuppliers';
		}).hideElement = this.returnSuppliersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'returnSuppliers').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'sourceWarehouses';
		}).hideElement = this.sourceWarehousesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'sourceWarehouses').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'stockCatalogues';
		}).hideElement = this.stockCataloguesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'stockCatalogues').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'stockControls';
		}).hideElement = this.stockControlsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'stockControls').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'stockTransactionDetails';
		}).hideElement = this.stockTransactionDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'stockTransactionDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'stockTransactionPerDateTypes';
		}).hideElement = this.stockTransactionPerDateTypesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'stockTransactionPerDateTypes').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'stockTransactionPerDates';
		}).hideElement = this.stockTransactionPerDatesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'stockTransactionPerDates').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'vaccinationOrderDetails';
		}).hideElement = this.vaccinationOrderDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'vaccinationOrderDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'warehouseInitialStockS';
		}).hideElement = this.warehouseInitialStockSMultiCrudActive || this.modelRelations.find(rel => rel.id === 'warehouseInitialStockS').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'warehouseInventories';
		}).hideElement = this.warehouseInventoriesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'warehouseInventories').hideElement;

	}

	/**
	 * Initialises the collections used for fetching the entities to display in multi entity crud for many relations.
	 * The same collection used to fetch entities for the relation dropdown cannot be reused, as we need to fetch a
	 * subset for these relations, and using the same collection will result in all entities being returned instead of the
	 * subset we are looking for.
	 *
	 * This method will only be populated if this entity has a many relation (i.e. it is the target of a 1:M relation, or is part of a
	 * M:M relation)
	 */
	initialiseMultiEntityCollections() {
		if (this.batchStockBalancesWarehouseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.batchStockBalancesWarehouseDisplayName, many: true});
			this.store.dispatch(new batchStockBalanceModelAction.BatchStockBalanceAction(
				batchStockBalanceModelAction.BatchStockBalanceModelActionTypes.INITIALISE_BATCH_STOCK_BALANCE_COLLECTION_STATE,
				{
					collectionId: this.batchStockBalancesWarehouseCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBatchStockBalanceCollectionModels, this.batchStockBalancesWarehouseCollectionId).subscribe(models => {
				models.forEach(batchStockBalancesWarehouse => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BatchStockBalanceModel.getProps(), this.batchStockBalancesWarehouseRelations, this.isViewOnly),
						batchStockBalancesWarehouse,
						BatchStockBalanceModel,
						this.batchStockBalancesWarehouseDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.batchStockBalancesWarehouseRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.batchStockBalancesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.batchStockBalancesDisplayName, many: true});
			this.store.dispatch(new batchStockBalancePerDateModelAction.BatchStockBalancePerDateAction(
				batchStockBalancePerDateModelAction.BatchStockBalancePerDateModelActionTypes.INITIALISE_BATCH_STOCK_BALANCE_PER_DATE_COLLECTION_STATE,
				{
					collectionId: this.batchStockBalancesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBatchStockBalancePerDateCollectionModels, this.batchStockBalancesCollectionId).subscribe(models => {
				models.forEach(batchStockBalances => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BatchStockBalancePerDateModel.getProps(), this.batchStockBalancesRelations, this.isViewOnly),
						batchStockBalances,
						BatchStockBalancePerDateModel,
						this.batchStockBalancesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.batchStockBalancesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.batchStockTransactionDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.batchStockTransactionDetailsDisplayName, many: true});
			this.store.dispatch(new batchStockTransactionDetailModelAction.BatchStockTransactionDetailAction(
				batchStockTransactionDetailModelAction.BatchStockTransactionDetailModelActionTypes.INITIALISE_BATCH_STOCK_TRANSACTION_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.batchStockTransactionDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBatchStockTransactionDetailCollectionModels, this.batchStockTransactionDetailsCollectionId).subscribe(models => {
				models.forEach(batchStockTransactionDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BatchStockTransactionDetailModel.getProps(), this.batchStockTransactionDetailsRelations, this.isViewOnly),
						batchStockTransactionDetails,
						BatchStockTransactionDetailModel,
						this.batchStockTransactionDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.batchStockTransactionDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.destinationWarehousesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.destinationWarehousesDisplayName, many: true});
			this.store.dispatch(new transferOrderModelAction.TransferOrderAction(
				transferOrderModelAction.TransferOrderModelActionTypes.INITIALISE_TRANSFER_ORDER_COLLECTION_STATE,
				{
					collectionId: this.destinationWarehousesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getTransferOrderCollectionModels, this.destinationWarehousesCollectionId).subscribe(models => {
				models.forEach(destinationWarehouses => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(TransferOrderModel.getProps(), this.destinationWarehousesRelations, this.isViewOnly),
						destinationWarehouses,
						TransferOrderModel,
						this.destinationWarehousesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.destinationWarehousesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.goodsReceiveNoteBatchsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.goodsReceiveNoteBatchsDisplayName, many: true});
			this.store.dispatch(new goodsReceiveNoteBatchModelAction.GoodsReceiveNoteBatchAction(
				goodsReceiveNoteBatchModelAction.GoodsReceiveNoteBatchModelActionTypes.INITIALISE_GOODS_RECEIVE_NOTE_BATCH_COLLECTION_STATE,
				{
					collectionId: this.goodsReceiveNoteBatchsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getGoodsReceiveNoteBatchCollectionModels, this.goodsReceiveNoteBatchsCollectionId).subscribe(models => {
				models.forEach(goodsReceiveNoteBatchs => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(GoodsReceiveNoteBatchModel.getProps(), this.goodsReceiveNoteBatchsRelations, this.isViewOnly),
						goodsReceiveNoteBatchs,
						GoodsReceiveNoteBatchModel,
						this.goodsReceiveNoteBatchsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.goodsReceiveNoteBatchsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.goodsReceiveNotesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.goodsReceiveNotesDisplayName, many: true});
			this.store.dispatch(new goodsReceiveNoteModelAction.GoodsReceiveNoteAction(
				goodsReceiveNoteModelAction.GoodsReceiveNoteModelActionTypes.INITIALISE_GOODS_RECEIVE_NOTE_COLLECTION_STATE,
				{
					collectionId: this.goodsReceiveNotesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getGoodsReceiveNoteCollectionModels, this.goodsReceiveNotesCollectionId).subscribe(models => {
				models.forEach(goodsReceiveNotes => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(GoodsReceiveNoteModel.getProps(), this.goodsReceiveNotesRelations, this.isViewOnly),
						goodsReceiveNotes,
						GoodsReceiveNoteModel,
						this.goodsReceiveNotesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.goodsReceiveNotesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.internalOrdersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.internalOrdersDisplayName, many: true});
			this.store.dispatch(new internalOrderModelAction.InternalOrderAction(
				internalOrderModelAction.InternalOrderModelActionTypes.INITIALISE_INTERNAL_ORDER_COLLECTION_STATE,
				{
					collectionId: this.internalOrdersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInternalOrderCollectionModels, this.internalOrdersCollectionId).subscribe(models => {
				models.forEach(internalOrders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InternalOrderModel.getProps(), this.internalOrdersRelations, this.isViewOnly),
						internalOrders,
						InternalOrderModel,
						this.internalOrdersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.internalOrdersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.inventoryAdjusmentBatchsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.inventoryAdjusmentBatchsDisplayName, many: true});
			this.store.dispatch(new inventoryAdjusmentBatchModelAction.InventoryAdjusmentBatchAction(
				inventoryAdjusmentBatchModelAction.InventoryAdjusmentBatchModelActionTypes.INITIALISE_INVENTORY_ADJUSMENT_BATCH_COLLECTION_STATE,
				{
					collectionId: this.inventoryAdjusmentBatchsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInventoryAdjusmentBatchCollectionModels, this.inventoryAdjusmentBatchsCollectionId).subscribe(models => {
				models.forEach(inventoryAdjusmentBatchs => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InventoryAdjusmentBatchModel.getProps(), this.inventoryAdjusmentBatchsRelations, this.isViewOnly),
						inventoryAdjusmentBatchs,
						InventoryAdjusmentBatchModel,
						this.inventoryAdjusmentBatchsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.inventoryAdjusmentBatchsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.inventoryAdjustmentsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.inventoryAdjustmentsDisplayName, many: true});
			this.store.dispatch(new inventoryAdjustmentModelAction.InventoryAdjustmentAction(
				inventoryAdjustmentModelAction.InventoryAdjustmentModelActionTypes.INITIALISE_INVENTORY_ADJUSTMENT_COLLECTION_STATE,
				{
					collectionId: this.inventoryAdjustmentsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInventoryAdjustmentCollectionModels, this.inventoryAdjustmentsCollectionId).subscribe(models => {
				models.forEach(inventoryAdjustments => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InventoryAdjustmentModel.getProps(), this.inventoryAdjustmentsRelations, this.isViewOnly),
						inventoryAdjustments,
						InventoryAdjustmentModel,
						this.inventoryAdjustmentsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.inventoryAdjustmentsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.inventoryBatchCorrectionsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.inventoryBatchCorrectionsDisplayName, many: true});
			this.store.dispatch(new inventoryBatchCorrectionModelAction.InventoryBatchCorrectionAction(
				inventoryBatchCorrectionModelAction.InventoryBatchCorrectionModelActionTypes.INITIALISE_INVENTORY_BATCH_CORRECTION_COLLECTION_STATE,
				{
					collectionId: this.inventoryBatchCorrectionsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInventoryBatchCorrectionCollectionModels, this.inventoryBatchCorrectionsCollectionId).subscribe(models => {
				models.forEach(inventoryBatchCorrections => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InventoryBatchCorrectionModel.getProps(), this.inventoryBatchCorrectionsRelations, this.isViewOnly),
						inventoryBatchCorrections,
						InventoryBatchCorrectionModel,
						this.inventoryBatchCorrectionsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.inventoryBatchCorrectionsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.locationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.locationsDisplayName, many: true});
			this.store.dispatch(new locationModelAction.LocationAction(
				locationModelAction.LocationModelActionTypes.INITIALISE_LOCATION_COLLECTION_STATE,
				{
					collectionId: this.locationsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getLocationCollectionModels, this.locationsCollectionId).subscribe(models => {
				models.forEach(locations => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(LocationModel.getProps(), this.locationsRelations, this.isViewOnly),
						locations,
						LocationModel,
						this.locationsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.locationsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalFeesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalFeesDisplayName, many: true});
			this.store.dispatch(new medicalFeeModelAction.MedicalFeeAction(
				medicalFeeModelAction.MedicalFeeModelActionTypes.INITIALISE_MEDICAL_FEE_COLLECTION_STATE,
				{
					collectionId: this.medicalFeesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalFeeCollectionModels, this.medicalFeesCollectionId).subscribe(models => {
				models.forEach(medicalFees => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalFeeModel.getProps(), this.medicalFeesRelations, this.isViewOnly),
						medicalFees,
						MedicalFeeModel,
						this.medicalFeesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalFeesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicationHeadersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicationHeadersDisplayName, many: true});
			this.store.dispatch(new medicationHeaderModelAction.MedicationHeaderAction(
				medicationHeaderModelAction.MedicationHeaderModelActionTypes.INITIALISE_MEDICATION_HEADER_COLLECTION_STATE,
				{
					collectionId: this.medicationHeadersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicationHeaderCollectionModels, this.medicationHeadersCollectionId).subscribe(models => {
				models.forEach(medicationHeaders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicationHeaderModel.getProps(), this.medicationHeadersRelations, this.isViewOnly),
						medicationHeaders,
						MedicationHeaderModel,
						this.medicationHeadersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicationHeadersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.prescriptionHeadersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.prescriptionHeadersDisplayName, many: true});
			this.store.dispatch(new prescriptionHeaderModelAction.PrescriptionHeaderAction(
				prescriptionHeaderModelAction.PrescriptionHeaderModelActionTypes.INITIALISE_PRESCRIPTION_HEADER_COLLECTION_STATE,
				{
					collectionId: this.prescriptionHeadersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPrescriptionHeaderCollectionModels, this.prescriptionHeadersCollectionId).subscribe(models => {
				models.forEach(prescriptionHeaders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PrescriptionHeaderModel.getProps(), this.prescriptionHeadersRelations, this.isViewOnly),
						prescriptionHeaders,
						PrescriptionHeaderModel,
						this.prescriptionHeadersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.prescriptionHeadersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.purchaseOrdersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.purchaseOrdersDisplayName, many: true});
			this.store.dispatch(new purchaseOrderModelAction.PurchaseOrderAction(
				purchaseOrderModelAction.PurchaseOrderModelActionTypes.INITIALISE_PURCHASE_ORDER_COLLECTION_STATE,
				{
					collectionId: this.purchaseOrdersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPurchaseOrderCollectionModels, this.purchaseOrdersCollectionId).subscribe(models => {
				models.forEach(purchaseOrders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PurchaseOrderModel.getProps(), this.purchaseOrdersRelations, this.isViewOnly),
						purchaseOrders,
						PurchaseOrderModel,
						this.purchaseOrdersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.purchaseOrdersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.purchaseRequisitionsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.purchaseRequisitionsDisplayName, many: true});
			this.store.dispatch(new purchaseRequisitionModelAction.PurchaseRequisitionAction(
				purchaseRequisitionModelAction.PurchaseRequisitionModelActionTypes.INITIALISE_PURCHASE_REQUISITION_COLLECTION_STATE,
				{
					collectionId: this.purchaseRequisitionsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPurchaseRequisitionCollectionModels, this.purchaseRequisitionsCollectionId).subscribe(models => {
				models.forEach(purchaseRequisitions => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PurchaseRequisitionModel.getProps(), this.purchaseRequisitionsRelations, this.isViewOnly),
						purchaseRequisitions,
						PurchaseRequisitionModel,
						this.purchaseRequisitionsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.purchaseRequisitionsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.retailPharmaciesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.retailPharmaciesDisplayName, many: true});
			this.store.dispatch(new retailPharmacyModelAction.RetailPharmacyAction(
				retailPharmacyModelAction.RetailPharmacyModelActionTypes.INITIALISE_RETAIL_PHARMACY_COLLECTION_STATE,
				{
					collectionId: this.retailPharmaciesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRetailPharmacyCollectionModels, this.retailPharmaciesCollectionId).subscribe(models => {
				models.forEach(retailPharmacies => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RetailPharmacyModel.getProps(), this.retailPharmaciesRelations, this.isViewOnly),
						retailPharmacies,
						RetailPharmacyModel,
						this.retailPharmaciesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.retailPharmaciesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.returnSuppliersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.returnSuppliersDisplayName, many: true});
			this.store.dispatch(new returnSupplierModelAction.ReturnSupplierAction(
				returnSupplierModelAction.ReturnSupplierModelActionTypes.INITIALISE_RETURN_SUPPLIER_COLLECTION_STATE,
				{
					collectionId: this.returnSuppliersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getReturnSupplierCollectionModels, this.returnSuppliersCollectionId).subscribe(models => {
				models.forEach(returnSuppliers => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(ReturnSupplierModel.getProps(), this.returnSuppliersRelations, this.isViewOnly),
						returnSuppliers,
						ReturnSupplierModel,
						this.returnSuppliersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.returnSuppliersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.sourceWarehousesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.sourceWarehousesDisplayName, many: true});
			this.store.dispatch(new transferOrderModelAction.TransferOrderAction(
				transferOrderModelAction.TransferOrderModelActionTypes.INITIALISE_TRANSFER_ORDER_COLLECTION_STATE,
				{
					collectionId: this.sourceWarehousesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getTransferOrderCollectionModels, this.sourceWarehousesCollectionId).subscribe(models => {
				models.forEach(sourceWarehouses => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(TransferOrderModel.getProps(), this.sourceWarehousesRelations, this.isViewOnly),
						sourceWarehouses,
						TransferOrderModel,
						this.sourceWarehousesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.sourceWarehousesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.stockCataloguesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.stockCataloguesDisplayName, many: true});
			this.store.dispatch(new stockCatalogueModelAction.StockCatalogueAction(
				stockCatalogueModelAction.StockCatalogueModelActionTypes.INITIALISE_STOCK_CATALOGUE_COLLECTION_STATE,
				{
					collectionId: this.stockCataloguesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getStockCatalogueCollectionModels, this.stockCataloguesCollectionId).subscribe(models => {
				models.forEach(stockCatalogues => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(StockCatalogueModel.getProps(), this.stockCataloguesRelations, this.isViewOnly),
						stockCatalogues,
						StockCatalogueModel,
						this.stockCataloguesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.stockCataloguesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.stockControlsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.stockControlsDisplayName, many: true});
			this.store.dispatch(new stockControlModelAction.StockControlAction(
				stockControlModelAction.StockControlModelActionTypes.INITIALISE_STOCK_CONTROL_COLLECTION_STATE,
				{
					collectionId: this.stockControlsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getStockControlCollectionModels, this.stockControlsCollectionId).subscribe(models => {
				models.forEach(stockControls => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(StockControlModel.getProps(), this.stockControlsRelations, this.isViewOnly),
						stockControls,
						StockControlModel,
						this.stockControlsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.stockControlsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.stockTransactionDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.stockTransactionDetailsDisplayName, many: true});
			this.store.dispatch(new stockTransactionDetailModelAction.StockTransactionDetailAction(
				stockTransactionDetailModelAction.StockTransactionDetailModelActionTypes.INITIALISE_STOCK_TRANSACTION_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.stockTransactionDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getStockTransactionDetailCollectionModels, this.stockTransactionDetailsCollectionId).subscribe(models => {
				models.forEach(stockTransactionDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(StockTransactionDetailModel.getProps(), this.stockTransactionDetailsRelations, this.isViewOnly),
						stockTransactionDetails,
						StockTransactionDetailModel,
						this.stockTransactionDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.stockTransactionDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.stockTransactionPerDateTypesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.stockTransactionPerDateTypesDisplayName, many: true});
			this.store.dispatch(new stockTransactionPerDateTypeModelAction.StockTransactionPerDateTypeAction(
				stockTransactionPerDateTypeModelAction.StockTransactionPerDateTypeModelActionTypes.INITIALISE_STOCK_TRANSACTION_PER_DATE_TYPE_COLLECTION_STATE,
				{
					collectionId: this.stockTransactionPerDateTypesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getStockTransactionPerDateTypeCollectionModels, this.stockTransactionPerDateTypesCollectionId).subscribe(models => {
				models.forEach(stockTransactionPerDateTypes => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(StockTransactionPerDateTypeModel.getProps(), this.stockTransactionPerDateTypesRelations, this.isViewOnly),
						stockTransactionPerDateTypes,
						StockTransactionPerDateTypeModel,
						this.stockTransactionPerDateTypesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.stockTransactionPerDateTypesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.stockTransactionPerDatesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.stockTransactionPerDatesDisplayName, many: true});
			this.store.dispatch(new stockTransactionPerDateModelAction.StockTransactionPerDateAction(
				stockTransactionPerDateModelAction.StockTransactionPerDateModelActionTypes.INITIALISE_STOCK_TRANSACTION_PER_DATE_COLLECTION_STATE,
				{
					collectionId: this.stockTransactionPerDatesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getStockTransactionPerDateCollectionModels, this.stockTransactionPerDatesCollectionId).subscribe(models => {
				models.forEach(stockTransactionPerDates => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(StockTransactionPerDateModel.getProps(), this.stockTransactionPerDatesRelations, this.isViewOnly),
						stockTransactionPerDates,
						StockTransactionPerDateModel,
						this.stockTransactionPerDatesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.stockTransactionPerDatesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.vaccinationOrderDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.vaccinationOrderDetailsDisplayName, many: true});
			this.store.dispatch(new vaccinationOrderDetailModelAction.VaccinationOrderDetailAction(
				vaccinationOrderDetailModelAction.VaccinationOrderDetailModelActionTypes.INITIALISE_VACCINATION_ORDER_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.vaccinationOrderDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getVaccinationOrderDetailCollectionModels, this.vaccinationOrderDetailsCollectionId).subscribe(models => {
				models.forEach(vaccinationOrderDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(VaccinationOrderDetailModel.getProps(), this.vaccinationOrderDetailsRelations, this.isViewOnly),
						vaccinationOrderDetails,
						VaccinationOrderDetailModel,
						this.vaccinationOrderDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.vaccinationOrderDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.warehouseInitialStockSMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.warehouseInitialStockSDisplayName, many: true});
			this.store.dispatch(new warehouseInitialStockModelAction.WarehouseInitialStockAction(
				warehouseInitialStockModelAction.WarehouseInitialStockModelActionTypes.INITIALISE_WAREHOUSE_INITIAL_STOCK_COLLECTION_STATE,
				{
					collectionId: this.warehouseInitialStockSCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getWarehouseInitialStockCollectionModels, this.warehouseInitialStockSCollectionId).subscribe(models => {
				models.forEach(warehouseInitialStockS => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(WarehouseInitialStockModel.getProps(), this.warehouseInitialStockSRelations, this.isViewOnly),
						warehouseInitialStockS,
						WarehouseInitialStockModel,
						this.warehouseInitialStockSDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.warehouseInitialStockSRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.warehouseInventoriesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.warehouseInventoriesDisplayName, many: true});
			this.store.dispatch(new warehouseInventoryModelAction.WarehouseInventoryAction(
				warehouseInventoryModelAction.WarehouseInventoryModelActionTypes.INITIALISE_WAREHOUSE_INVENTORY_COLLECTION_STATE,
				{
					collectionId: this.warehouseInventoriesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getWarehouseInventoryCollectionModels, this.warehouseInventoriesCollectionId).subscribe(models => {
				models.forEach(warehouseInventories => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(WarehouseInventoryModel.getProps(), this.warehouseInventoriesRelations, this.isViewOnly),
						warehouseInventories,
						WarehouseInventoryModel,
						this.warehouseInventoriesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.warehouseInventoriesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

	}

	/**
	 * Fetches the entities for any activated multi entity crud selections, and adds groups to the form for every additional
	 * related entity.
	 *
	 * May be empty if the entity for this crud page has no related entities
	 */
	multiCrudFetchAdditionalEntities() {
		if (this.targetModel.batchStockBalancesWarehouseIds && this.targetModel.batchStockBalancesWarehouseIds.length > 0 && this.batchStockBalancesWarehouseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BatchStockBalanceModel,
				this.batchStockBalancesWarehouseOppositeRelation,
				this.batchStockBalancesWarehouseCollectionId,
				this.targetModel.batchStockBalancesWarehouseIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.batchStockBalancesIds && this.targetModel.batchStockBalancesIds.length > 0 && this.batchStockBalancesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BatchStockBalancePerDateModel,
				this.batchStockBalancesOppositeRelation,
				this.batchStockBalancesCollectionId,
				this.targetModel.batchStockBalancesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.batchStockTransactionDetailsIds && this.targetModel.batchStockTransactionDetailsIds.length > 0 && this.batchStockTransactionDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BatchStockTransactionDetailModel,
				this.batchStockTransactionDetailsOppositeRelation,
				this.batchStockTransactionDetailsCollectionId,
				this.targetModel.batchStockTransactionDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.destinationWarehousesIds && this.targetModel.destinationWarehousesIds.length > 0 && this.destinationWarehousesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				TransferOrderModel,
				this.destinationWarehousesOppositeRelation,
				this.destinationWarehousesCollectionId,
				this.targetModel.destinationWarehousesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.goodsReceiveNoteBatchsIds && this.targetModel.goodsReceiveNoteBatchsIds.length > 0 && this.goodsReceiveNoteBatchsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				GoodsReceiveNoteBatchModel,
				this.goodsReceiveNoteBatchsOppositeRelation,
				this.goodsReceiveNoteBatchsCollectionId,
				this.targetModel.goodsReceiveNoteBatchsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.goodsReceiveNotesIds && this.targetModel.goodsReceiveNotesIds.length > 0 && this.goodsReceiveNotesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				GoodsReceiveNoteModel,
				this.goodsReceiveNotesOppositeRelation,
				this.goodsReceiveNotesCollectionId,
				this.targetModel.goodsReceiveNotesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.internalOrdersIds && this.targetModel.internalOrdersIds.length > 0 && this.internalOrdersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InternalOrderModel,
				this.internalOrdersOppositeRelation,
				this.internalOrdersCollectionId,
				this.targetModel.internalOrdersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.inventoryAdjusmentBatchsIds && this.targetModel.inventoryAdjusmentBatchsIds.length > 0 && this.inventoryAdjusmentBatchsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InventoryAdjusmentBatchModel,
				this.inventoryAdjusmentBatchsOppositeRelation,
				this.inventoryAdjusmentBatchsCollectionId,
				this.targetModel.inventoryAdjusmentBatchsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.inventoryAdjustmentsIds && this.targetModel.inventoryAdjustmentsIds.length > 0 && this.inventoryAdjustmentsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InventoryAdjustmentModel,
				this.inventoryAdjustmentsOppositeRelation,
				this.inventoryAdjustmentsCollectionId,
				this.targetModel.inventoryAdjustmentsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.inventoryBatchCorrectionsIds && this.targetModel.inventoryBatchCorrectionsIds.length > 0 && this.inventoryBatchCorrectionsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InventoryBatchCorrectionModel,
				this.inventoryBatchCorrectionsOppositeRelation,
				this.inventoryBatchCorrectionsCollectionId,
				this.targetModel.inventoryBatchCorrectionsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.locationsIds && this.targetModel.locationsIds.length > 0 && this.locationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				LocationModel,
				this.locationsOppositeRelation,
				this.locationsCollectionId,
				this.targetModel.locationsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalFeesIds && this.targetModel.medicalFeesIds.length > 0 && this.medicalFeesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalFeeModel,
				this.medicalFeesOppositeRelation,
				this.medicalFeesCollectionId,
				this.targetModel.medicalFeesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicationHeadersIds && this.targetModel.medicationHeadersIds.length > 0 && this.medicationHeadersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicationHeaderModel,
				this.medicationHeadersOppositeRelation,
				this.medicationHeadersCollectionId,
				this.targetModel.medicationHeadersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.prescriptionHeadersIds && this.targetModel.prescriptionHeadersIds.length > 0 && this.prescriptionHeadersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PrescriptionHeaderModel,
				this.prescriptionHeadersOppositeRelation,
				this.prescriptionHeadersCollectionId,
				this.targetModel.prescriptionHeadersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.purchaseOrdersIds && this.targetModel.purchaseOrdersIds.length > 0 && this.purchaseOrdersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PurchaseOrderModel,
				this.purchaseOrdersOppositeRelation,
				this.purchaseOrdersCollectionId,
				this.targetModel.purchaseOrdersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.purchaseRequisitionsIds && this.targetModel.purchaseRequisitionsIds.length > 0 && this.purchaseRequisitionsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PurchaseRequisitionModel,
				this.purchaseRequisitionsOppositeRelation,
				this.purchaseRequisitionsCollectionId,
				this.targetModel.purchaseRequisitionsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.retailPharmaciesIds && this.targetModel.retailPharmaciesIds.length > 0 && this.retailPharmaciesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RetailPharmacyModel,
				this.retailPharmaciesOppositeRelation,
				this.retailPharmaciesCollectionId,
				this.targetModel.retailPharmaciesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.returnSuppliersIds && this.targetModel.returnSuppliersIds.length > 0 && this.returnSuppliersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ReturnSupplierModel,
				this.returnSuppliersOppositeRelation,
				this.returnSuppliersCollectionId,
				this.targetModel.returnSuppliersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.sourceWarehousesIds && this.targetModel.sourceWarehousesIds.length > 0 && this.sourceWarehousesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				TransferOrderModel,
				this.sourceWarehousesOppositeRelation,
				this.sourceWarehousesCollectionId,
				this.targetModel.sourceWarehousesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.stockCataloguesIds && this.targetModel.stockCataloguesIds.length > 0 && this.stockCataloguesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StockCatalogueModel,
				this.stockCataloguesOppositeRelation,
				this.stockCataloguesCollectionId,
				this.targetModel.stockCataloguesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.stockControlsIds && this.targetModel.stockControlsIds.length > 0 && this.stockControlsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StockControlModel,
				this.stockControlsOppositeRelation,
				this.stockControlsCollectionId,
				this.targetModel.stockControlsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.stockTransactionDetailsIds && this.targetModel.stockTransactionDetailsIds.length > 0 && this.stockTransactionDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StockTransactionDetailModel,
				this.stockTransactionDetailsOppositeRelation,
				this.stockTransactionDetailsCollectionId,
				this.targetModel.stockTransactionDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.stockTransactionPerDateTypesIds && this.targetModel.stockTransactionPerDateTypesIds.length > 0 && this.stockTransactionPerDateTypesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StockTransactionPerDateTypeModel,
				this.stockTransactionPerDateTypesOppositeRelation,
				this.stockTransactionPerDateTypesCollectionId,
				this.targetModel.stockTransactionPerDateTypesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.stockTransactionPerDatesIds && this.targetModel.stockTransactionPerDatesIds.length > 0 && this.stockTransactionPerDatesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StockTransactionPerDateModel,
				this.stockTransactionPerDatesOppositeRelation,
				this.stockTransactionPerDatesCollectionId,
				this.targetModel.stockTransactionPerDatesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.vaccinationOrderDetailsIds && this.targetModel.vaccinationOrderDetailsIds.length > 0 && this.vaccinationOrderDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				VaccinationOrderDetailModel,
				this.vaccinationOrderDetailsOppositeRelation,
				this.vaccinationOrderDetailsCollectionId,
				this.targetModel.vaccinationOrderDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.warehouseInitialStockSIds && this.targetModel.warehouseInitialStockSIds.length > 0 && this.warehouseInitialStockSMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				WarehouseInitialStockModel,
				this.warehouseInitialStockSOppositeRelation,
				this.warehouseInitialStockSCollectionId,
				this.targetModel.warehouseInitialStockSIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.warehouseInventoriesIds && this.targetModel.warehouseInventoriesIds.length > 0 && this.warehouseInventoriesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				WarehouseInventoryModel,
				this.warehouseInventoriesOppositeRelation,
				this.warehouseInventoriesCollectionId,
				this.targetModel.warehouseInventoriesIds.length,
				this.targetModel.id,
				true
			));
		}

	}

	/**
	 * The crud create edit page will handle all potential multi entity crud permutations by returning an
	 * `additionalEntities` parameter in its returned event.  This attribute will contain any entities which
	 * were added to the crud edit page for multi entity model.  Once this attribute has been returned, we need
	 * to process it, and transfer any additional entities from this attribute into the target model, so that these
	 * additional entities can be sent to the serverside for processing.
	 *
	 * @param model The model to inject the additional entities into.  This will usually be the targetModel attribute for this component
	 * @param event The event returned from the crud edit page when clicking create or save.  We only care about the additionalEntities param here
	 * @returns the model passed in as input, but with the entities from the additionalEntities attribute added to that model.
	 */
	addAdditionalEntitiesToModel(model: WarehouseModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): WarehouseModel {
		let updatedModel: WarehouseModel = new WarehouseModel(model);

		updatedModel.batchStockBalancesWarehouse = [];
		if (this.batchStockBalancesWarehouseMultiCrudActive) {
			if (event.additionalEntities.batchStockBalancesWarehouse) {
				event.additionalEntities.batchStockBalancesWarehouse.forEach(entity => {
					updatedModel.batchStockBalancesWarehouse.push(entity);
				});
			}

			if (!updatedModel.batchStockBalancesWarehouse.length) {
				updatedModel.batchStockBalancesWarehouseIds = [];
			}
		}
		updatedModel.batchStockBalances = [];
		if (this.batchStockBalancesMultiCrudActive) {
			if (event.additionalEntities.batchStockBalances) {
				event.additionalEntities.batchStockBalances.forEach(entity => {
					updatedModel.batchStockBalances.push(entity);
				});
			}

			if (!updatedModel.batchStockBalances.length) {
				updatedModel.batchStockBalancesIds = [];
			}
		}
		updatedModel.batchStockTransactionDetails = [];
		if (this.batchStockTransactionDetailsMultiCrudActive) {
			if (event.additionalEntities.batchStockTransactionDetails) {
				event.additionalEntities.batchStockTransactionDetails.forEach(entity => {
					updatedModel.batchStockTransactionDetails.push(entity);
				});
			}

			if (!updatedModel.batchStockTransactionDetails.length) {
				updatedModel.batchStockTransactionDetailsIds = [];
			}
		}
		updatedModel.destinationWarehouses = [];
		if (this.destinationWarehousesMultiCrudActive) {
			if (event.additionalEntities.destinationWarehouses) {
				event.additionalEntities.destinationWarehouses.forEach(entity => {
					updatedModel.destinationWarehouses.push(entity);
				});
			}

			if (!updatedModel.destinationWarehouses.length) {
				updatedModel.destinationWarehousesIds = [];
			}
		}
		updatedModel.goodsReceiveNoteBatchs = [];
		if (this.goodsReceiveNoteBatchsMultiCrudActive) {
			if (event.additionalEntities.goodsReceiveNoteBatchs) {
				event.additionalEntities.goodsReceiveNoteBatchs.forEach(entity => {
					updatedModel.goodsReceiveNoteBatchs.push(entity);
				});
			}

			if (!updatedModel.goodsReceiveNoteBatchs.length) {
				updatedModel.goodsReceiveNoteBatchsIds = [];
			}
		}
		updatedModel.goodsReceiveNotes = [];
		if (this.goodsReceiveNotesMultiCrudActive) {
			if (event.additionalEntities.goodsReceiveNotes) {
				event.additionalEntities.goodsReceiveNotes.forEach(entity => {
					updatedModel.goodsReceiveNotes.push(entity);
				});
			}

			if (!updatedModel.goodsReceiveNotes.length) {
				updatedModel.goodsReceiveNotesIds = [];
			}
		}
		updatedModel.internalOrders = [];
		if (this.internalOrdersMultiCrudActive) {
			if (event.additionalEntities.internalOrders) {
				event.additionalEntities.internalOrders.forEach(entity => {
					updatedModel.internalOrders.push(entity);
				});
			}

			if (!updatedModel.internalOrders.length) {
				updatedModel.internalOrdersIds = [];
			}
		}
		updatedModel.inventoryAdjusmentBatchs = [];
		if (this.inventoryAdjusmentBatchsMultiCrudActive) {
			if (event.additionalEntities.inventoryAdjusmentBatchs) {
				event.additionalEntities.inventoryAdjusmentBatchs.forEach(entity => {
					updatedModel.inventoryAdjusmentBatchs.push(entity);
				});
			}

			if (!updatedModel.inventoryAdjusmentBatchs.length) {
				updatedModel.inventoryAdjusmentBatchsIds = [];
			}
		}
		updatedModel.inventoryAdjustments = [];
		if (this.inventoryAdjustmentsMultiCrudActive) {
			if (event.additionalEntities.inventoryAdjustments) {
				event.additionalEntities.inventoryAdjustments.forEach(entity => {
					updatedModel.inventoryAdjustments.push(entity);
				});
			}

			if (!updatedModel.inventoryAdjustments.length) {
				updatedModel.inventoryAdjustmentsIds = [];
			}
		}
		updatedModel.inventoryBatchCorrections = [];
		if (this.inventoryBatchCorrectionsMultiCrudActive) {
			if (event.additionalEntities.inventoryBatchCorrections) {
				event.additionalEntities.inventoryBatchCorrections.forEach(entity => {
					updatedModel.inventoryBatchCorrections.push(entity);
				});
			}

			if (!updatedModel.inventoryBatchCorrections.length) {
				updatedModel.inventoryBatchCorrectionsIds = [];
			}
		}
		updatedModel.locations = [];
		if (this.locationsMultiCrudActive) {
			if (event.additionalEntities.locations) {
				event.additionalEntities.locations.forEach(entity => {
					updatedModel.locations.push(entity);
				});
			}

			if (!updatedModel.locations.length) {
				updatedModel.locationsIds = [];
			}
		}
		updatedModel.medicalFees = [];
		if (this.medicalFeesMultiCrudActive) {
			if (event.additionalEntities.medicalFees) {
				event.additionalEntities.medicalFees.forEach(entity => {
					updatedModel.medicalFees.push(entity);
				});
			}

			if (!updatedModel.medicalFees.length) {
				updatedModel.medicalFeesIds = [];
			}
		}
		updatedModel.medicationHeaders = [];
		if (this.medicationHeadersMultiCrudActive) {
			if (event.additionalEntities.medicationHeaders) {
				event.additionalEntities.medicationHeaders.forEach(entity => {
					updatedModel.medicationHeaders.push(entity);
				});
			}

			if (!updatedModel.medicationHeaders.length) {
				updatedModel.medicationHeadersIds = [];
			}
		}
		updatedModel.prescriptionHeaders = [];
		if (this.prescriptionHeadersMultiCrudActive) {
			if (event.additionalEntities.prescriptionHeaders) {
				event.additionalEntities.prescriptionHeaders.forEach(entity => {
					updatedModel.prescriptionHeaders.push(entity);
				});
			}

			if (!updatedModel.prescriptionHeaders.length) {
				updatedModel.prescriptionHeadersIds = [];
			}
		}
		updatedModel.purchaseOrders = [];
		if (this.purchaseOrdersMultiCrudActive) {
			if (event.additionalEntities.purchaseOrders) {
				event.additionalEntities.purchaseOrders.forEach(entity => {
					updatedModel.purchaseOrders.push(entity);
				});
			}

			if (!updatedModel.purchaseOrders.length) {
				updatedModel.purchaseOrdersIds = [];
			}
		}
		updatedModel.purchaseRequisitions = [];
		if (this.purchaseRequisitionsMultiCrudActive) {
			if (event.additionalEntities.purchaseRequisitions) {
				event.additionalEntities.purchaseRequisitions.forEach(entity => {
					updatedModel.purchaseRequisitions.push(entity);
				});
			}

			if (!updatedModel.purchaseRequisitions.length) {
				updatedModel.purchaseRequisitionsIds = [];
			}
		}
		updatedModel.retailPharmacies = [];
		if (this.retailPharmaciesMultiCrudActive) {
			if (event.additionalEntities.retailPharmacies) {
				event.additionalEntities.retailPharmacies.forEach(entity => {
					updatedModel.retailPharmacies.push(entity);
				});
			}

			if (!updatedModel.retailPharmacies.length) {
				updatedModel.retailPharmaciesIds = [];
			}
		}
		updatedModel.returnSuppliers = [];
		if (this.returnSuppliersMultiCrudActive) {
			if (event.additionalEntities.returnSuppliers) {
				event.additionalEntities.returnSuppliers.forEach(entity => {
					updatedModel.returnSuppliers.push(entity);
				});
			}

			if (!updatedModel.returnSuppliers.length) {
				updatedModel.returnSuppliersIds = [];
			}
		}
		updatedModel.sourceWarehouses = [];
		if (this.sourceWarehousesMultiCrudActive) {
			if (event.additionalEntities.sourceWarehouses) {
				event.additionalEntities.sourceWarehouses.forEach(entity => {
					updatedModel.sourceWarehouses.push(entity);
				});
			}

			if (!updatedModel.sourceWarehouses.length) {
				updatedModel.sourceWarehousesIds = [];
			}
		}
		updatedModel.stockCatalogues = [];
		if (this.stockCataloguesMultiCrudActive) {
			if (event.additionalEntities.stockCatalogues) {
				event.additionalEntities.stockCatalogues.forEach(entity => {
					updatedModel.stockCatalogues.push(entity);
				});
			}

			if (!updatedModel.stockCatalogues.length) {
				updatedModel.stockCataloguesIds = [];
			}
		}
		updatedModel.stockControls = [];
		if (this.stockControlsMultiCrudActive) {
			if (event.additionalEntities.stockControls) {
				event.additionalEntities.stockControls.forEach(entity => {
					updatedModel.stockControls.push(entity);
				});
			}

			if (!updatedModel.stockControls.length) {
				updatedModel.stockControlsIds = [];
			}
		}
		updatedModel.stockTransactionDetails = [];
		if (this.stockTransactionDetailsMultiCrudActive) {
			if (event.additionalEntities.stockTransactionDetails) {
				event.additionalEntities.stockTransactionDetails.forEach(entity => {
					updatedModel.stockTransactionDetails.push(entity);
				});
			}

			if (!updatedModel.stockTransactionDetails.length) {
				updatedModel.stockTransactionDetailsIds = [];
			}
		}
		updatedModel.stockTransactionPerDateTypes = [];
		if (this.stockTransactionPerDateTypesMultiCrudActive) {
			if (event.additionalEntities.stockTransactionPerDateTypes) {
				event.additionalEntities.stockTransactionPerDateTypes.forEach(entity => {
					updatedModel.stockTransactionPerDateTypes.push(entity);
				});
			}

			if (!updatedModel.stockTransactionPerDateTypes.length) {
				updatedModel.stockTransactionPerDateTypesIds = [];
			}
		}
		updatedModel.stockTransactionPerDates = [];
		if (this.stockTransactionPerDatesMultiCrudActive) {
			if (event.additionalEntities.stockTransactionPerDates) {
				event.additionalEntities.stockTransactionPerDates.forEach(entity => {
					updatedModel.stockTransactionPerDates.push(entity);
				});
			}

			if (!updatedModel.stockTransactionPerDates.length) {
				updatedModel.stockTransactionPerDatesIds = [];
			}
		}
		updatedModel.vaccinationOrderDetails = [];
		if (this.vaccinationOrderDetailsMultiCrudActive) {
			if (event.additionalEntities.vaccinationOrderDetails) {
				event.additionalEntities.vaccinationOrderDetails.forEach(entity => {
					updatedModel.vaccinationOrderDetails.push(entity);
				});
			}

			if (!updatedModel.vaccinationOrderDetails.length) {
				updatedModel.vaccinationOrderDetailsIds = [];
			}
		}
		updatedModel.warehouseInitialStockS = [];
		if (this.warehouseInitialStockSMultiCrudActive) {
			if (event.additionalEntities.warehouseInitialStockS) {
				event.additionalEntities.warehouseInitialStockS.forEach(entity => {
					updatedModel.warehouseInitialStockS.push(entity);
				});
			}

			if (!updatedModel.warehouseInitialStockS.length) {
				updatedModel.warehouseInitialStockSIds = [];
			}
		}
		updatedModel.warehouseInventories = [];
		if (this.warehouseInventoriesMultiCrudActive) {
			if (event.additionalEntities.warehouseInventories) {
				event.additionalEntities.warehouseInventories.forEach(entity => {
					updatedModel.warehouseInventories.push(entity);
				});
			}

			if (!updatedModel.warehouseInventories.length) {
				updatedModel.warehouseInventoriesIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
