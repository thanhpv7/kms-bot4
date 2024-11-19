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
import * as modelAction from 'src/app/models/stockCatalogue/stock_catalogue.model.action';
import {StockCatalogueModelState, StockCatalogueModelAudit} from 'src/app/models/stockCatalogue/stock_catalogue.model.state';
import {StockCatalogueModel} from 'src/app/models/stockCatalogue/stock_catalogue.model';
import {
	getStockCatalogueModelAuditsByEntityId,
	getStockCatalogueModelWithId,
	getCountStockCatalogueModels,
} from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsDrugGenericPRBModel} from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model';
import * as bpjsDrugGenericPRBModelAction from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.action';
import {
	getBpjsDrugGenericPRBCollectionModels, getBpjsDrugGenericPRBModelWithId,
} from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.selector';
import {BpjsPcareDPHOModel} from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model';
import * as bpjsPcareDPHOModelAction from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model.action';
import {
	getBpjsPcareDPHOCollectionModels, getBpjsPcareDPHOModelWithId,
} from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model.selector';
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
import {CatalogueMedicalModel} from 'src/app/models/catalogueMedical/catalogue_medical.model';
import * as catalogueMedicalModelAction from 'src/app/models/catalogueMedical/catalogue_medical.model.action';
import {
	getCatalogueMedicalCollectionModels, getCatalogueMedicalModelWithId,
} from 'src/app/models/catalogueMedical/catalogue_medical.model.selector';
import {CatalogueNonMedicalModel} from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model';
import * as catalogueNonMedicalModelAction from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model.action';
import {
	getCatalogueNonMedicalCollectionModels, getCatalogueNonMedicalModelWithId,
} from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model.selector';
import {CatalogueUOMModel} from 'src/app/models/catalogueUOM/catalogue_uom.model';
import * as catalogueUOMModelAction from 'src/app/models/catalogueUOM/catalogue_uom.model.action';
import {
	getCatalogueUOMCollectionModels, getCatalogueUOMModelWithId,
} from 'src/app/models/catalogueUOM/catalogue_uom.model.selector';
import {CompoundPrescriptionItemModel} from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model';
import * as compoundPrescriptionItemModelAction from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.action';
import {
	getCompoundPrescriptionItemCollectionModels, getCompoundPrescriptionItemModelWithId,
} from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.selector';
import {GoodsReceiveNoteBatchModel} from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model';
import * as goodsReceiveNoteBatchModelAction from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.action';
import {
	getGoodsReceiveNoteBatchCollectionModels, getGoodsReceiveNoteBatchModelWithId,
} from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.selector';
import {GoodsReceiveNoteItemModel} from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model';
import * as goodsReceiveNoteItemModelAction from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model.action';
import {
	getGoodsReceiveNoteItemCollectionModels, getGoodsReceiveNoteItemModelWithId,
} from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model.selector';
import {InternalOrderStockDetailModel} from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model';
import * as internalOrderStockDetailModelAction from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model.action';
import {
	getInternalOrderStockDetailCollectionModels, getInternalOrderStockDetailModelWithId,
} from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model.selector';
import {InventoryAdjusmentBatchModel} from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import * as inventoryAdjusmentBatchModelAction from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.action';
import {
	getInventoryAdjusmentBatchCollectionModels, getInventoryAdjusmentBatchModelWithId,
} from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.selector';
import {InventoryAdjustmentItemModel} from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model';
import * as inventoryAdjustmentItemModelAction from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model.action';
import {
	getInventoryAdjustmentItemCollectionModels, getInventoryAdjustmentItemModelWithId,
} from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model.selector';
import {InventoryBatchCorrectionItemModel} from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model';
import * as inventoryBatchCorrectionItemModelAction from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model.action';
import {
	getInventoryBatchCorrectionItemCollectionModels, getInventoryBatchCorrectionItemModelWithId,
} from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model.selector';
import {MedicationItemModel} from 'src/app/models/medicationItem/medication_item.model';
import * as medicationItemModelAction from 'src/app/models/medicationItem/medication_item.model.action';
import {
	getMedicationItemCollectionModels, getMedicationItemModelWithId,
} from 'src/app/models/medicationItem/medication_item.model.selector';
import {PrescriptionItemModel} from 'src/app/models/prescriptionItem/prescription_item.model';
import * as prescriptionItemModelAction from 'src/app/models/prescriptionItem/prescription_item.model.action';
import {
	getPrescriptionItemCollectionModels, getPrescriptionItemModelWithId,
} from 'src/app/models/prescriptionItem/prescription_item.model.selector';
import {PurchaseOrderStockDetailModel} from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model';
import * as purchaseOrderStockDetailModelAction from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model.action';
import {
	getPurchaseOrderStockDetailCollectionModels, getPurchaseOrderStockDetailModelWithId,
} from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model.selector';
import {PurchaseRequisitionStockDetailModel} from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model';
import * as purchaseRequisitionStockDetailModelAction from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.action';
import {
	getPurchaseRequisitionStockDetailCollectionModels, getPurchaseRequisitionStockDetailModelWithId,
} from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.selector';
import {RetailPharmacyStockDetailModel} from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model';
import * as retailPharmacyStockDetailModelAction from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.action';
import {
	getRetailPharmacyStockDetailCollectionModels, getRetailPharmacyStockDetailModelWithId,
} from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.selector';
import {ReturnSupplierStockDetailModel} from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model';
import * as returnSupplierStockDetailModelAction from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model.action';
import {
	getReturnSupplierStockDetailCollectionModels, getReturnSupplierStockDetailModelWithId,
} from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model.selector';
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
import {SupplierProductDetailModel} from 'src/app/models/supplierProductDetail/supplier_product_detail.model';
import * as supplierProductDetailModelAction from 'src/app/models/supplierProductDetail/supplier_product_detail.model.action';
import {
	getSupplierProductDetailCollectionModels, getSupplierProductDetailModelWithId,
} from 'src/app/models/supplierProductDetail/supplier_product_detail.model.selector';
import {TransferOrderStockDetailModel} from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model';
import * as transferOrderStockDetailModelAction from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.action';
import {
	getTransferOrderStockDetailCollectionModels, getTransferOrderStockDetailModelWithId,
} from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.selector';
import {VaccinationOrderDetailModel} from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model';
import * as vaccinationOrderDetailModelAction from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.action';
import {
	getVaccinationOrderDetailCollectionModels, getVaccinationOrderDetailModelWithId,
} from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import {WarehouseModel} from 'src/app/models/warehouse/warehouse.model';
import * as warehouseModelAction from 'src/app/models/warehouse/warehouse.model.action';
import {
	getWarehouseCollectionModels, getWarehouseModelWithId,
} from 'src/app/models/warehouse/warehouse.model.selector';
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
import {CrudTileMode} from '../stock-catalogue-admin-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-stock-catalogue-admin-crud-edit',
	templateUrl: './stock-catalogue-admin-crud-edit.component.html',
	styleUrls: [
		'./stock-catalogue-admin-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class AdminStockCatalogueCrudEditComponent
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
	collectionId: string = '10b7b151-3aae-483b-a38f-17d0a96741de';
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
	stockCatalogueAudits$: Observable<StockCatalogueModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Catalogue Medical  here] off begin
	stockCatalogueMedicalMultiCrudActive: boolean = false;
	stockCatalogueMedicalDisplayName = 'Stock Catalogue Medical ';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Catalogue Medical  here] end
	stockCatalogueMedicalOppositeRelation = 'stockCatalogue';
	stockCatalogueMedicalRelations: ModelRelation[] = this.stockCatalogueMedicalMultiCrudActive ? CatalogueMedicalModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockCatalogueMedicalOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Catalogue Non Medical here] off begin
	stockCatalogueNonMedicalMultiCrudActive: boolean = false;
	stockCatalogueNonMedicalDisplayName = 'Stock Catalogue Non Medical';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Catalogue Non Medical here] end
	stockCatalogueNonMedicalOppositeRelation = 'stockCatalogue';
	stockCatalogueNonMedicalRelations: ModelRelation[] = this.stockCatalogueNonMedicalMultiCrudActive ? CatalogueNonMedicalModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockCatalogueNonMedicalOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Drug Generic PRB and Stock Catalogue here] off begin
	bpjsDrugGenericPRBMultiCrudActive: boolean = false;
	bpjsDrugGenericPRBDisplayName = 'BPJS Drug Generic PRB';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Drug Generic PRB and Stock Catalogue here] end
	bpjsDrugGenericPRBOppositeRelation = 'stockCatalogue';
	bpjsDrugGenericPRBRelations: ModelRelation[] = this.bpjsDrugGenericPRBMultiCrudActive ? BpjsDrugGenericPRBModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsDrugGenericPRBOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Pcare DPHO and Stock Catalogue here] off begin
	bpjsPcareDPHOMultiCrudActive: boolean = false;
	bpjsPcareDPHODisplayName = 'BPJS Pcare DPHO';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Pcare DPHO and Stock Catalogue here] end
	bpjsPcareDPHOOppositeRelation = 'stockCatalogue';
	bpjsPcareDPHORelations: ModelRelation[] = this.bpjsPcareDPHOMultiCrudActive ? BpjsPcareDPHOModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsPcareDPHOOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Catalogues here] off begin
	warehouseMultiCrudActive: boolean = false;
	warehouseDisplayName = 'Warehouse';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse and Stock Catalogues here] end
	warehouseOppositeRelation = 'stockCatalogues';
	warehouseRelations: ModelRelation[] = this.warehouseMultiCrudActive ? WarehouseModel.getRelations()
		.map(relation => {
			if (relation.id === this.warehouseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Batch Stock Balances Catalogue here] off begin
	batchStockBalancesCatalogueMultiCrudActive: boolean = false;
	batchStockBalancesCatalogueDisplayName = 'Batch Stock Balances Catalogue';
	batchStockBalancesCatalogueCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Batch Stock Balances Catalogue here] end
	batchStockBalancesCatalogueOppositeRelation = 'stockCatalogue';
	batchStockBalancesCatalogueRelations: ModelRelation[] = this.batchStockBalancesCatalogueMultiCrudActive ? BatchStockBalanceModel.getRelations()
		.map(relation => {
			if (relation.id === this.batchStockBalancesCatalogueOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Batch Stock Balances here] off begin
	batchStockBalancesMultiCrudActive: boolean = false;
	batchStockBalancesDisplayName = 'Batch Stock Balances';
	batchStockBalancesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Batch Stock Balances here] end
	batchStockBalancesOppositeRelation = 'stockCatalogue';
	batchStockBalancesRelations: ModelRelation[] = this.batchStockBalancesMultiCrudActive ? BatchStockBalancePerDateModel.getRelations()
		.map(relation => {
			if (relation.id === this.batchStockBalancesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Batch Stock Transaction Details here] off begin
	batchStockTransactionDetailsMultiCrudActive: boolean = false;
	batchStockTransactionDetailsDisplayName = 'Batch Stock Transaction Details';
	batchStockTransactionDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Batch Stock Transaction Details here] end
	batchStockTransactionDetailsOppositeRelation = 'stockCatalogue';
	batchStockTransactionDetailsRelations: ModelRelation[] = this.batchStockTransactionDetailsMultiCrudActive ? BatchStockTransactionDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.batchStockTransactionDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Catalogue UOMs here] off begin
	catalogueUOMsMultiCrudActive: boolean = false;
	catalogueUOMsDisplayName = 'Catalogue UOMs';
	catalogueUOMsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Catalogue UOMs here] end
	catalogueUOMsOppositeRelation = 'stockCatalogue';
	catalogueUOMsRelations: ModelRelation[] = this.catalogueUOMsMultiCrudActive ? CatalogueUOMModel.getRelations()
		.map(relation => {
			if (relation.id === this.catalogueUOMsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Compound Prescription Items here] off begin
	compoundPrescriptionItemsMultiCrudActive: boolean = false;
	compoundPrescriptionItemsDisplayName = 'Compound Prescription Items';
	compoundPrescriptionItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Compound Prescription Items here] end
	compoundPrescriptionItemsOppositeRelation = 'stockCatalogue';
	compoundPrescriptionItemsRelations: ModelRelation[] = this.compoundPrescriptionItemsMultiCrudActive ? CompoundPrescriptionItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.compoundPrescriptionItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Goods Receive Note Batchs here] off begin
	goodsReceiveNoteBatchsMultiCrudActive: boolean = false;
	goodsReceiveNoteBatchsDisplayName = 'Goods Receive Note Batchs';
	goodsReceiveNoteBatchsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Goods Receive Note Batchs here] end
	goodsReceiveNoteBatchsOppositeRelation = 'stockCatalogue';
	goodsReceiveNoteBatchsRelations: ModelRelation[] = this.goodsReceiveNoteBatchsMultiCrudActive ? GoodsReceiveNoteBatchModel.getRelations()
		.map(relation => {
			if (relation.id === this.goodsReceiveNoteBatchsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Goods Receive Note Items here] off begin
	goodsReceiveNoteItemsMultiCrudActive: boolean = false;
	goodsReceiveNoteItemsDisplayName = 'Goods Receive Note Items';
	goodsReceiveNoteItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Goods Receive Note Items here] end
	goodsReceiveNoteItemsOppositeRelation = 'stockCatalogue';
	goodsReceiveNoteItemsRelations: ModelRelation[] = this.goodsReceiveNoteItemsMultiCrudActive ? GoodsReceiveNoteItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.goodsReceiveNoteItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Internal Order Stock Details here] off begin
	internalOrderStockDetailsMultiCrudActive: boolean = false;
	internalOrderStockDetailsDisplayName = 'Internal Order Stock Details';
	internalOrderStockDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Internal Order Stock Details here] end
	internalOrderStockDetailsOppositeRelation = 'stockCatalogue';
	internalOrderStockDetailsRelations: ModelRelation[] = this.internalOrderStockDetailsMultiCrudActive ? InternalOrderStockDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.internalOrderStockDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Inventory Adjusment Batchs here] off begin
	inventoryAdjusmentBatchsMultiCrudActive: boolean = false;
	inventoryAdjusmentBatchsDisplayName = 'Inventory Adjusment Batchs';
	inventoryAdjusmentBatchsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Inventory Adjusment Batchs here] end
	inventoryAdjusmentBatchsOppositeRelation = 'stockCatalogue';
	inventoryAdjusmentBatchsRelations: ModelRelation[] = this.inventoryAdjusmentBatchsMultiCrudActive ? InventoryAdjusmentBatchModel.getRelations()
		.map(relation => {
			if (relation.id === this.inventoryAdjusmentBatchsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Inventory Adjustment Items here] off begin
	inventoryAdjustmentItemsMultiCrudActive: boolean = false;
	inventoryAdjustmentItemsDisplayName = 'Inventory Adjustment Items';
	inventoryAdjustmentItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Inventory Adjustment Items here] end
	inventoryAdjustmentItemsOppositeRelation = 'stockCatalogue';
	inventoryAdjustmentItemsRelations: ModelRelation[] = this.inventoryAdjustmentItemsMultiCrudActive ? InventoryAdjustmentItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.inventoryAdjustmentItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Inventory Batch Correction Items here] off begin
	inventoryBatchCorrectionItemsMultiCrudActive: boolean = false;
	inventoryBatchCorrectionItemsDisplayName = 'Inventory Batch Correction Items';
	inventoryBatchCorrectionItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Inventory Batch Correction Items here] end
	inventoryBatchCorrectionItemsOppositeRelation = 'stockCatalogue';
	inventoryBatchCorrectionItemsRelations: ModelRelation[] = this.inventoryBatchCorrectionItemsMultiCrudActive ? InventoryBatchCorrectionItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.inventoryBatchCorrectionItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Medication Items here] off begin
	medicationItemsMultiCrudActive: boolean = false;
	medicationItemsDisplayName = 'Medication Items';
	medicationItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Medication Items here] end
	medicationItemsOppositeRelation = 'stockCatalogue';
	medicationItemsRelations: ModelRelation[] = this.medicationItemsMultiCrudActive ? MedicationItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicationItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue Id and Prescription Item here] off begin
	prescriptionItemMultiCrudActive: boolean = false;
	prescriptionItemDisplayName = 'Prescription Item';
	prescriptionItemCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue Id and Prescription Item here] end
	prescriptionItemOppositeRelation = 'stockCatalogueId';
	prescriptionItemRelations: ModelRelation[] = this.prescriptionItemMultiCrudActive ? PrescriptionItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.prescriptionItemOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Purchase Order Stock Details here] off begin
	purchaseOrderStockDetailsMultiCrudActive: boolean = false;
	purchaseOrderStockDetailsDisplayName = 'Purchase Order Stock Details';
	purchaseOrderStockDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Purchase Order Stock Details here] end
	purchaseOrderStockDetailsOppositeRelation = 'stockCatalogue';
	purchaseOrderStockDetailsRelations: ModelRelation[] = this.purchaseOrderStockDetailsMultiCrudActive ? PurchaseOrderStockDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.purchaseOrderStockDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Purchase Requisition Stock Details here] off begin
	purchaseRequisitionStockDetailsMultiCrudActive: boolean = false;
	purchaseRequisitionStockDetailsDisplayName = 'Purchase Requisition Stock Details';
	purchaseRequisitionStockDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Purchase Requisition Stock Details here] end
	purchaseRequisitionStockDetailsOppositeRelation = 'stockCatalogue';
	purchaseRequisitionStockDetailsRelations: ModelRelation[] = this.purchaseRequisitionStockDetailsMultiCrudActive ? PurchaseRequisitionStockDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.purchaseRequisitionStockDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Retail Pharmacy Stock Details here] off begin
	retailPharmacyStockDetailsMultiCrudActive: boolean = false;
	retailPharmacyStockDetailsDisplayName = 'Retail Pharmacy Stock Details';
	retailPharmacyStockDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Retail Pharmacy Stock Details here] end
	retailPharmacyStockDetailsOppositeRelation = 'stockCatalogue';
	retailPharmacyStockDetailsRelations: ModelRelation[] = this.retailPharmacyStockDetailsMultiCrudActive ? RetailPharmacyStockDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.retailPharmacyStockDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Return Supplier Stock Details here] off begin
	returnSupplierStockDetailsMultiCrudActive: boolean = false;
	returnSupplierStockDetailsDisplayName = 'Return Supplier Stock Details';
	returnSupplierStockDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Return Supplier Stock Details here] end
	returnSupplierStockDetailsOppositeRelation = 'stockCatalogue';
	returnSupplierStockDetailsRelations: ModelRelation[] = this.returnSupplierStockDetailsMultiCrudActive ? ReturnSupplierStockDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.returnSupplierStockDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Controls here] off begin
	stockControlsMultiCrudActive: boolean = false;
	stockControlsDisplayName = 'Stock Controls';
	stockControlsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Controls here] end
	stockControlsOppositeRelation = 'stockCatalogue';
	stockControlsRelations: ModelRelation[] = this.stockControlsMultiCrudActive ? StockControlModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockControlsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Transaction Details here] off begin
	stockTransactionDetailsMultiCrudActive: boolean = false;
	stockTransactionDetailsDisplayName = 'Stock Transaction Details';
	stockTransactionDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Transaction Details here] end
	stockTransactionDetailsOppositeRelation = 'stockCatalogue';
	stockTransactionDetailsRelations: ModelRelation[] = this.stockTransactionDetailsMultiCrudActive ? StockTransactionDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockTransactionDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Transaction Per Date Types here] off begin
	stockTransactionPerDateTypesMultiCrudActive: boolean = false;
	stockTransactionPerDateTypesDisplayName = 'Stock Transaction Per Date Types';
	stockTransactionPerDateTypesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Transaction Per Date Types here] end
	stockTransactionPerDateTypesOppositeRelation = 'stockCatalogue';
	stockTransactionPerDateTypesRelations: ModelRelation[] = this.stockTransactionPerDateTypesMultiCrudActive ? StockTransactionPerDateTypeModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockTransactionPerDateTypesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Transaction Per Dates here] off begin
	stockTransactionPerDatesMultiCrudActive: boolean = false;
	stockTransactionPerDatesDisplayName = 'Stock Transaction Per Dates';
	stockTransactionPerDatesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Stock Transaction Per Dates here] end
	stockTransactionPerDatesOppositeRelation = 'stockCatalogue';
	stockTransactionPerDatesRelations: ModelRelation[] = this.stockTransactionPerDatesMultiCrudActive ? StockTransactionPerDateModel.getRelations()
		.map(relation => {
			if (relation.id === this.stockTransactionPerDatesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Supplier Product Details here] off begin
	supplierProductDetailsMultiCrudActive: boolean = false;
	supplierProductDetailsDisplayName = 'Supplier Product Details';
	supplierProductDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Supplier Product Details here] end
	supplierProductDetailsOppositeRelation = 'stockCatalogue';
	supplierProductDetailsRelations: ModelRelation[] = this.supplierProductDetailsMultiCrudActive ? SupplierProductDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.supplierProductDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Transfer Order Stock Details here] off begin
	transferOrderStockDetailsMultiCrudActive: boolean = false;
	transferOrderStockDetailsDisplayName = 'Transfer Order Stock Details';
	transferOrderStockDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Transfer Order Stock Details here] end
	transferOrderStockDetailsOppositeRelation = 'stockCatalogue';
	transferOrderStockDetailsRelations: ModelRelation[] = this.transferOrderStockDetailsMultiCrudActive ? TransferOrderStockDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.transferOrderStockDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Vaccination Order Details here] off begin
	vaccinationOrderDetailsMultiCrudActive: boolean = false;
	vaccinationOrderDetailsDisplayName = 'Vaccination Order Details';
	vaccinationOrderDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Vaccination Order Details here] end
	vaccinationOrderDetailsOppositeRelation = 'stockCatalogue';
	vaccinationOrderDetailsRelations: ModelRelation[] = this.vaccinationOrderDetailsMultiCrudActive ? VaccinationOrderDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.vaccinationOrderDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Warehouse Initial Stock s here] off begin
	warehouseInitialStockSMultiCrudActive: boolean = false;
	warehouseInitialStockSDisplayName = 'Warehouse Initial Stock s';
	warehouseInitialStockSCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Warehouse Initial Stock s here] end
	warehouseInitialStockSOppositeRelation = 'stockCatalogue';
	warehouseInitialStockSRelations: ModelRelation[] = this.warehouseInitialStockSMultiCrudActive ? WarehouseInitialStockModel.getRelations()
		.map(relation => {
			if (relation.id === this.warehouseInitialStockSOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Warehouse Inventories here] off begin
	warehouseInventoriesMultiCrudActive: boolean = false;
	warehouseInventoriesDisplayName = 'Warehouse Inventories';
	warehouseInventoriesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Stock Catalogue and Warehouse Inventories here] end
	warehouseInventoriesOppositeRelation = 'stockCatalogue';
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
	modelProperties: ModelProperty[] = StockCatalogueModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = StockCatalogueModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = StockCatalogueModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'stockCatalogueMedical' && this.stockCatalogueMedicalMultiCrudActive) {
					exp.fields = CatalogueMedicalModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'stockCatalogueNonMedical' && this.stockCatalogueNonMedicalMultiCrudActive) {
					exp.fields = CatalogueNonMedicalModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsDrugGenericPRB' && this.bpjsDrugGenericPRBMultiCrudActive) {
					exp.fields = BpjsDrugGenericPRBModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsPcareDPHO' && this.bpjsPcareDPHOMultiCrudActive) {
					exp.fields = BpjsPcareDPHOModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'warehouse' && this.warehouseMultiCrudActive) {
					exp.fields = WarehouseModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'batchStockBalancesCatalogue' && this.batchStockBalancesCatalogueMultiCrudActive) {
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

				if (relation.id === 'catalogueUOMs' && this.catalogueUOMsMultiCrudActive) {
					exp.fields = CatalogueUOMModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'compoundPrescriptionItems' && this.compoundPrescriptionItemsMultiCrudActive) {
					exp.fields = CompoundPrescriptionItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'goodsReceiveNoteBatchs' && this.goodsReceiveNoteBatchsMultiCrudActive) {
					exp.fields = GoodsReceiveNoteBatchModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'goodsReceiveNoteItems' && this.goodsReceiveNoteItemsMultiCrudActive) {
					exp.fields = GoodsReceiveNoteItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'internalOrderStockDetails' && this.internalOrderStockDetailsMultiCrudActive) {
					exp.fields = InternalOrderStockDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'inventoryAdjusmentBatchs' && this.inventoryAdjusmentBatchsMultiCrudActive) {
					exp.fields = InventoryAdjusmentBatchModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'inventoryAdjustmentItems' && this.inventoryAdjustmentItemsMultiCrudActive) {
					exp.fields = InventoryAdjustmentItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'inventoryBatchCorrectionItems' && this.inventoryBatchCorrectionItemsMultiCrudActive) {
					exp.fields = InventoryBatchCorrectionItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicationItems' && this.medicationItemsMultiCrudActive) {
					exp.fields = MedicationItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'prescriptionItem' && this.prescriptionItemMultiCrudActive) {
					exp.fields = PrescriptionItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'purchaseOrderStockDetails' && this.purchaseOrderStockDetailsMultiCrudActive) {
					exp.fields = PurchaseOrderStockDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'purchaseRequisitionStockDetails' && this.purchaseRequisitionStockDetailsMultiCrudActive) {
					exp.fields = PurchaseRequisitionStockDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'retailPharmacyStockDetails' && this.retailPharmacyStockDetailsMultiCrudActive) {
					exp.fields = RetailPharmacyStockDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'returnSupplierStockDetails' && this.returnSupplierStockDetailsMultiCrudActive) {
					exp.fields = ReturnSupplierStockDetailModel.getProps().map(prop => {
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

				if (relation.id === 'supplierProductDetails' && this.supplierProductDetailsMultiCrudActive) {
					exp.fields = SupplierProductDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'transferOrderStockDetails' && this.transferOrderStockDetailsMultiCrudActive) {
					exp.fields = TransferOrderStockDetailModel.getProps().map(prop => {
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
	targetModel: StockCatalogueModel;

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
		private readonly store: Store<{ model: StockCatalogueModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountStockCatalogueModels).subscribe(count => {
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

			this.targetModel = new StockCatalogueModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.stockCatalogueAudits$ = this.store.select(getStockCatalogueModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<StockCatalogueModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.StockCatalogueAction(
			modelAction.StockCatalogueModelActionTypes.FETCH_STOCK_CATALOGUE,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getStockCatalogueModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new StockCatalogueModel(model);
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
			commands.push('stock-catalogue');

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

		this.store.dispatch(new modelAction.StockCatalogueAction(
			modelAction.StockCatalogueModelActionTypes.FETCH_STOCK_CATALOGUE_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<StockCatalogueModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.bpjsDrugGenericPRBMultiCrudActive || this.bpjsPcareDPHOMultiCrudActive || this.stockCatalogueMedicalMultiCrudActive || this.stockCatalogueNonMedicalMultiCrudActive || this.warehouseMultiCrudActive || this.batchStockBalancesCatalogueMultiCrudActive || this.batchStockBalancesMultiCrudActive || this.batchStockTransactionDetailsMultiCrudActive || this.catalogueUOMsMultiCrudActive || this.compoundPrescriptionItemsMultiCrudActive || this.goodsReceiveNoteBatchsMultiCrudActive || this.goodsReceiveNoteItemsMultiCrudActive || this.internalOrderStockDetailsMultiCrudActive || this.inventoryAdjusmentBatchsMultiCrudActive || this.inventoryAdjustmentItemsMultiCrudActive || this.inventoryBatchCorrectionItemsMultiCrudActive || this.medicationItemsMultiCrudActive || this.prescriptionItemMultiCrudActive || this.purchaseOrderStockDetailsMultiCrudActive || this.purchaseRequisitionStockDetailsMultiCrudActive || this.retailPharmacyStockDetailsMultiCrudActive || this.returnSupplierStockDetailsMultiCrudActive || this.stockControlsMultiCrudActive || this.stockTransactionDetailsMultiCrudActive || this.stockTransactionPerDateTypesMultiCrudActive || this.stockTransactionPerDatesMultiCrudActive || this.supplierProductDetailsMultiCrudActive || this.transferOrderStockDetailsMultiCrudActive || this.vaccinationOrderDetailsMultiCrudActive || this.warehouseInitialStockSMultiCrudActive || this.warehouseInventoriesMultiCrudActive,
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
					new modelAction.StockCatalogueAction(
						modelAction.StockCatalogueModelActionTypes.COUNT_STOCK_CATALOGUES,
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

			this.store.dispatch(new modelAction.StockCatalogueAction(
				modelAction.StockCatalogueModelActionTypes.CREATE_STOCK_CATALOGUE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<StockCatalogueModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.bpjsDrugGenericPRBMultiCrudActive || this.bpjsPcareDPHOMultiCrudActive || this.stockCatalogueMedicalMultiCrudActive || this.stockCatalogueNonMedicalMultiCrudActive || this.warehouseMultiCrudActive || this.batchStockBalancesCatalogueMultiCrudActive || this.batchStockBalancesMultiCrudActive || this.batchStockTransactionDetailsMultiCrudActive || this.catalogueUOMsMultiCrudActive || this.compoundPrescriptionItemsMultiCrudActive || this.goodsReceiveNoteBatchsMultiCrudActive || this.goodsReceiveNoteItemsMultiCrudActive || this.internalOrderStockDetailsMultiCrudActive || this.inventoryAdjusmentBatchsMultiCrudActive || this.inventoryAdjustmentItemsMultiCrudActive || this.inventoryBatchCorrectionItemsMultiCrudActive || this.medicationItemsMultiCrudActive || this.prescriptionItemMultiCrudActive || this.purchaseOrderStockDetailsMultiCrudActive || this.purchaseRequisitionStockDetailsMultiCrudActive || this.retailPharmacyStockDetailsMultiCrudActive || this.returnSupplierStockDetailsMultiCrudActive || this.stockControlsMultiCrudActive || this.stockTransactionDetailsMultiCrudActive || this.stockTransactionPerDateTypesMultiCrudActive || this.stockTransactionPerDatesMultiCrudActive || this.supplierProductDetailsMultiCrudActive || this.transferOrderStockDetailsMultiCrudActive || this.vaccinationOrderDetailsMultiCrudActive || this.warehouseInitialStockSMultiCrudActive || this.warehouseInventoriesMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.StockCatalogueAction(
					modelAction.StockCatalogueModelActionTypes.FETCH_STOCK_CATALOGUE,
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

			this.store.dispatch(new modelAction.StockCatalogueAction(
				modelAction.StockCatalogueModelActionTypes.UPDATE_STOCK_CATALOGUE,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: StockCatalogueModel = new StockCatalogueModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getStockCatalogueModelWithId, this.targetModelId).subscribe(model => {
					let differences = new StockCatalogueModel(model).difference(updatedModel);

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
			if (event.entityName === this.bpjsDrugGenericPRBDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDrugGenericPRBModel.getProps(), this.bpjsDrugGenericPRBRelations, this.isViewOnly),
					new BpjsDrugGenericPRBModel(),
					BpjsDrugGenericPRBModel,
					this.bpjsDrugGenericPRBDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDrugGenericPRBRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsPcareDPHODisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPcareDPHOModel.getProps(), this.bpjsPcareDPHORelations, this.isViewOnly),
					new BpjsPcareDPHOModel(),
					BpjsPcareDPHOModel,
					this.bpjsPcareDPHODisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPcareDPHORelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.stockCatalogueMedicalDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CatalogueMedicalModel.getProps(), this.stockCatalogueMedicalRelations, this.isViewOnly),
					new CatalogueMedicalModel(),
					CatalogueMedicalModel,
					this.stockCatalogueMedicalDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockCatalogueMedicalRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.stockCatalogueNonMedicalDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CatalogueNonMedicalModel.getProps(), this.stockCatalogueNonMedicalRelations, this.isViewOnly),
					new CatalogueNonMedicalModel(),
					CatalogueNonMedicalModel,
					this.stockCatalogueNonMedicalDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockCatalogueNonMedicalRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.warehouseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(WarehouseModel.getProps(), this.warehouseRelations, this.isViewOnly),
					new WarehouseModel(),
					WarehouseModel,
					this.warehouseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.warehouseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.batchStockBalancesCatalogueDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BatchStockBalanceModel.getProps(), this.batchStockBalancesCatalogueRelations, this.isViewOnly),
					new BatchStockBalanceModel(),
					BatchStockBalanceModel,
					this.batchStockBalancesCatalogueDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.batchStockBalancesCatalogueRelations,
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

			if (event.entityName === this.catalogueUOMsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CatalogueUOMModel.getProps(), this.catalogueUOMsRelations, this.isViewOnly),
					new CatalogueUOMModel(),
					CatalogueUOMModel,
					this.catalogueUOMsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.catalogueUOMsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.compoundPrescriptionItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CompoundPrescriptionItemModel.getProps(), this.compoundPrescriptionItemsRelations, this.isViewOnly),
					new CompoundPrescriptionItemModel(),
					CompoundPrescriptionItemModel,
					this.compoundPrescriptionItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.compoundPrescriptionItemsRelations,
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

			if (event.entityName === this.goodsReceiveNoteItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(GoodsReceiveNoteItemModel.getProps(), this.goodsReceiveNoteItemsRelations, this.isViewOnly),
					new GoodsReceiveNoteItemModel(),
					GoodsReceiveNoteItemModel,
					this.goodsReceiveNoteItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.goodsReceiveNoteItemsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.internalOrderStockDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InternalOrderStockDetailModel.getProps(), this.internalOrderStockDetailsRelations, this.isViewOnly),
					new InternalOrderStockDetailModel(),
					InternalOrderStockDetailModel,
					this.internalOrderStockDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.internalOrderStockDetailsRelations,
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

			if (event.entityName === this.inventoryAdjustmentItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InventoryAdjustmentItemModel.getProps(), this.inventoryAdjustmentItemsRelations, this.isViewOnly),
					new InventoryAdjustmentItemModel(),
					InventoryAdjustmentItemModel,
					this.inventoryAdjustmentItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.inventoryAdjustmentItemsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.inventoryBatchCorrectionItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InventoryBatchCorrectionItemModel.getProps(), this.inventoryBatchCorrectionItemsRelations, this.isViewOnly),
					new InventoryBatchCorrectionItemModel(),
					InventoryBatchCorrectionItemModel,
					this.inventoryBatchCorrectionItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.inventoryBatchCorrectionItemsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicationItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicationItemModel.getProps(), this.medicationItemsRelations, this.isViewOnly),
					new MedicationItemModel(),
					MedicationItemModel,
					this.medicationItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicationItemsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.prescriptionItemDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PrescriptionItemModel.getProps(), this.prescriptionItemRelations, this.isViewOnly),
					new PrescriptionItemModel(),
					PrescriptionItemModel,
					this.prescriptionItemDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.prescriptionItemRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.purchaseOrderStockDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PurchaseOrderStockDetailModel.getProps(), this.purchaseOrderStockDetailsRelations, this.isViewOnly),
					new PurchaseOrderStockDetailModel(),
					PurchaseOrderStockDetailModel,
					this.purchaseOrderStockDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.purchaseOrderStockDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.purchaseRequisitionStockDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PurchaseRequisitionStockDetailModel.getProps(), this.purchaseRequisitionStockDetailsRelations, this.isViewOnly),
					new PurchaseRequisitionStockDetailModel(),
					PurchaseRequisitionStockDetailModel,
					this.purchaseRequisitionStockDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.purchaseRequisitionStockDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.retailPharmacyStockDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RetailPharmacyStockDetailModel.getProps(), this.retailPharmacyStockDetailsRelations, this.isViewOnly),
					new RetailPharmacyStockDetailModel(),
					RetailPharmacyStockDetailModel,
					this.retailPharmacyStockDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.retailPharmacyStockDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.returnSupplierStockDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ReturnSupplierStockDetailModel.getProps(), this.returnSupplierStockDetailsRelations, this.isViewOnly),
					new ReturnSupplierStockDetailModel(),
					ReturnSupplierStockDetailModel,
					this.returnSupplierStockDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.returnSupplierStockDetailsRelations,
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

			if (event.entityName === this.supplierProductDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SupplierProductDetailModel.getProps(), this.supplierProductDetailsRelations, this.isViewOnly),
					new SupplierProductDetailModel(),
					SupplierProductDetailModel,
					this.supplierProductDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.supplierProductDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.transferOrderStockDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(TransferOrderStockDetailModel.getProps(), this.transferOrderStockDetailsRelations, this.isViewOnly),
					new TransferOrderStockDetailModel(),
					TransferOrderStockDetailModel,
					this.transferOrderStockDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.transferOrderStockDetailsRelations,
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
		this.modelProperties = StockCatalogueModel.getProps();
		this.modelRelations = StockCatalogueModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'bpjsDrugGenericPRB';
		}).hideElement = this.bpjsDrugGenericPRBMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsDrugGenericPRB').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsPcareDPHO';
		}).hideElement = this.bpjsPcareDPHOMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsPcareDPHO').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'stockCatalogueMedical';
		}).hideElement = this.stockCatalogueMedicalMultiCrudActive || this.modelRelations.find(rel => rel.id === 'stockCatalogueMedical').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'stockCatalogueNonMedical';
		}).hideElement = this.stockCatalogueNonMedicalMultiCrudActive || this.modelRelations.find(rel => rel.id === 'stockCatalogueNonMedical').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'warehouse';
		}).hideElement = this.warehouseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'warehouse').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'batchStockBalancesCatalogue';
		}).hideElement = this.batchStockBalancesCatalogueMultiCrudActive || this.modelRelations.find(rel => rel.id === 'batchStockBalancesCatalogue').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'batchStockBalances';
		}).hideElement = this.batchStockBalancesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'batchStockBalances').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'batchStockTransactionDetails';
		}).hideElement = this.batchStockTransactionDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'batchStockTransactionDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'catalogueUOMs';
		}).hideElement = this.catalogueUOMsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'catalogueUOMs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'compoundPrescriptionItems';
		}).hideElement = this.compoundPrescriptionItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'compoundPrescriptionItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'goodsReceiveNoteBatchs';
		}).hideElement = this.goodsReceiveNoteBatchsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'goodsReceiveNoteBatchs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'goodsReceiveNoteItems';
		}).hideElement = this.goodsReceiveNoteItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'goodsReceiveNoteItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'internalOrderStockDetails';
		}).hideElement = this.internalOrderStockDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'internalOrderStockDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'inventoryAdjusmentBatchs';
		}).hideElement = this.inventoryAdjusmentBatchsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'inventoryAdjusmentBatchs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'inventoryAdjustmentItems';
		}).hideElement = this.inventoryAdjustmentItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'inventoryAdjustmentItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'inventoryBatchCorrectionItems';
		}).hideElement = this.inventoryBatchCorrectionItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'inventoryBatchCorrectionItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicationItems';
		}).hideElement = this.medicationItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicationItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'prescriptionItem';
		}).hideElement = this.prescriptionItemMultiCrudActive || this.modelRelations.find(rel => rel.id === 'prescriptionItem').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'purchaseOrderStockDetails';
		}).hideElement = this.purchaseOrderStockDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'purchaseOrderStockDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'purchaseRequisitionStockDetails';
		}).hideElement = this.purchaseRequisitionStockDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'purchaseRequisitionStockDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'retailPharmacyStockDetails';
		}).hideElement = this.retailPharmacyStockDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'retailPharmacyStockDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'returnSupplierStockDetails';
		}).hideElement = this.returnSupplierStockDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'returnSupplierStockDetails').hideElement;

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
			return rel.id === 'supplierProductDetails';
		}).hideElement = this.supplierProductDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'supplierProductDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'transferOrderStockDetails';
		}).hideElement = this.transferOrderStockDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'transferOrderStockDetails').hideElement;

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
		if (this.bpjsDrugGenericPRBMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsDrugGenericPRBDisplayName, many: false});
		}

		if (this.bpjsPcareDPHOMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsPcareDPHODisplayName, many: false});
		}

		if (this.stockCatalogueMedicalMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.stockCatalogueMedicalDisplayName, many: false});
		}

		if (this.stockCatalogueNonMedicalMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.stockCatalogueNonMedicalDisplayName, many: false});
		}

		if (this.warehouseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.warehouseDisplayName, many: false});
		}

		if (this.batchStockBalancesCatalogueMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.batchStockBalancesCatalogueDisplayName, many: true});
			this.store.dispatch(new batchStockBalanceModelAction.BatchStockBalanceAction(
				batchStockBalanceModelAction.BatchStockBalanceModelActionTypes.INITIALISE_BATCH_STOCK_BALANCE_COLLECTION_STATE,
				{
					collectionId: this.batchStockBalancesCatalogueCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBatchStockBalanceCollectionModels, this.batchStockBalancesCatalogueCollectionId).subscribe(models => {
				models.forEach(batchStockBalancesCatalogue => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BatchStockBalanceModel.getProps(), this.batchStockBalancesCatalogueRelations, this.isViewOnly),
						batchStockBalancesCatalogue,
						BatchStockBalanceModel,
						this.batchStockBalancesCatalogueDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.batchStockBalancesCatalogueRelations,
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

		if (this.catalogueUOMsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.catalogueUOMsDisplayName, many: true});
			this.store.dispatch(new catalogueUOMModelAction.CatalogueUOMAction(
				catalogueUOMModelAction.CatalogueUOMModelActionTypes.INITIALISE_CATALOGUE_UOM_COLLECTION_STATE,
				{
					collectionId: this.catalogueUOMsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCatalogueUOMCollectionModels, this.catalogueUOMsCollectionId).subscribe(models => {
				models.forEach(catalogueUOMs => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CatalogueUOMModel.getProps(), this.catalogueUOMsRelations, this.isViewOnly),
						catalogueUOMs,
						CatalogueUOMModel,
						this.catalogueUOMsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.catalogueUOMsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.compoundPrescriptionItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.compoundPrescriptionItemsDisplayName, many: true});
			this.store.dispatch(new compoundPrescriptionItemModelAction.CompoundPrescriptionItemAction(
				compoundPrescriptionItemModelAction.CompoundPrescriptionItemModelActionTypes.INITIALISE_COMPOUND_PRESCRIPTION_ITEM_COLLECTION_STATE,
				{
					collectionId: this.compoundPrescriptionItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCompoundPrescriptionItemCollectionModels, this.compoundPrescriptionItemsCollectionId).subscribe(models => {
				models.forEach(compoundPrescriptionItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CompoundPrescriptionItemModel.getProps(), this.compoundPrescriptionItemsRelations, this.isViewOnly),
						compoundPrescriptionItems,
						CompoundPrescriptionItemModel,
						this.compoundPrescriptionItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.compoundPrescriptionItemsRelations,
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

		if (this.goodsReceiveNoteItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.goodsReceiveNoteItemsDisplayName, many: true});
			this.store.dispatch(new goodsReceiveNoteItemModelAction.GoodsReceiveNoteItemAction(
				goodsReceiveNoteItemModelAction.GoodsReceiveNoteItemModelActionTypes.INITIALISE_GOODS_RECEIVE_NOTE_ITEM_COLLECTION_STATE,
				{
					collectionId: this.goodsReceiveNoteItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getGoodsReceiveNoteItemCollectionModels, this.goodsReceiveNoteItemsCollectionId).subscribe(models => {
				models.forEach(goodsReceiveNoteItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(GoodsReceiveNoteItemModel.getProps(), this.goodsReceiveNoteItemsRelations, this.isViewOnly),
						goodsReceiveNoteItems,
						GoodsReceiveNoteItemModel,
						this.goodsReceiveNoteItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.goodsReceiveNoteItemsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.internalOrderStockDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.internalOrderStockDetailsDisplayName, many: true});
			this.store.dispatch(new internalOrderStockDetailModelAction.InternalOrderStockDetailAction(
				internalOrderStockDetailModelAction.InternalOrderStockDetailModelActionTypes.INITIALISE_INTERNAL_ORDER_STOCK_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.internalOrderStockDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInternalOrderStockDetailCollectionModels, this.internalOrderStockDetailsCollectionId).subscribe(models => {
				models.forEach(internalOrderStockDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InternalOrderStockDetailModel.getProps(), this.internalOrderStockDetailsRelations, this.isViewOnly),
						internalOrderStockDetails,
						InternalOrderStockDetailModel,
						this.internalOrderStockDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.internalOrderStockDetailsRelations,
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

		if (this.inventoryAdjustmentItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.inventoryAdjustmentItemsDisplayName, many: true});
			this.store.dispatch(new inventoryAdjustmentItemModelAction.InventoryAdjustmentItemAction(
				inventoryAdjustmentItemModelAction.InventoryAdjustmentItemModelActionTypes.INITIALISE_INVENTORY_ADJUSTMENT_ITEM_COLLECTION_STATE,
				{
					collectionId: this.inventoryAdjustmentItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInventoryAdjustmentItemCollectionModels, this.inventoryAdjustmentItemsCollectionId).subscribe(models => {
				models.forEach(inventoryAdjustmentItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InventoryAdjustmentItemModel.getProps(), this.inventoryAdjustmentItemsRelations, this.isViewOnly),
						inventoryAdjustmentItems,
						InventoryAdjustmentItemModel,
						this.inventoryAdjustmentItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.inventoryAdjustmentItemsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.inventoryBatchCorrectionItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.inventoryBatchCorrectionItemsDisplayName, many: true});
			this.store.dispatch(new inventoryBatchCorrectionItemModelAction.InventoryBatchCorrectionItemAction(
				inventoryBatchCorrectionItemModelAction.InventoryBatchCorrectionItemModelActionTypes.INITIALISE_INVENTORY_BATCH_CORRECTION_ITEM_COLLECTION_STATE,
				{
					collectionId: this.inventoryBatchCorrectionItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInventoryBatchCorrectionItemCollectionModels, this.inventoryBatchCorrectionItemsCollectionId).subscribe(models => {
				models.forEach(inventoryBatchCorrectionItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InventoryBatchCorrectionItemModel.getProps(), this.inventoryBatchCorrectionItemsRelations, this.isViewOnly),
						inventoryBatchCorrectionItems,
						InventoryBatchCorrectionItemModel,
						this.inventoryBatchCorrectionItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.inventoryBatchCorrectionItemsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicationItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicationItemsDisplayName, many: true});
			this.store.dispatch(new medicationItemModelAction.MedicationItemAction(
				medicationItemModelAction.MedicationItemModelActionTypes.INITIALISE_MEDICATION_ITEM_COLLECTION_STATE,
				{
					collectionId: this.medicationItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicationItemCollectionModels, this.medicationItemsCollectionId).subscribe(models => {
				models.forEach(medicationItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicationItemModel.getProps(), this.medicationItemsRelations, this.isViewOnly),
						medicationItems,
						MedicationItemModel,
						this.medicationItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicationItemsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.prescriptionItemMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.prescriptionItemDisplayName, many: true});
			this.store.dispatch(new prescriptionItemModelAction.PrescriptionItemAction(
				prescriptionItemModelAction.PrescriptionItemModelActionTypes.INITIALISE_PRESCRIPTION_ITEM_COLLECTION_STATE,
				{
					collectionId: this.prescriptionItemCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPrescriptionItemCollectionModels, this.prescriptionItemCollectionId).subscribe(models => {
				models.forEach(prescriptionItem => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PrescriptionItemModel.getProps(), this.prescriptionItemRelations, this.isViewOnly),
						prescriptionItem,
						PrescriptionItemModel,
						this.prescriptionItemDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.prescriptionItemRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.purchaseOrderStockDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.purchaseOrderStockDetailsDisplayName, many: true});
			this.store.dispatch(new purchaseOrderStockDetailModelAction.PurchaseOrderStockDetailAction(
				purchaseOrderStockDetailModelAction.PurchaseOrderStockDetailModelActionTypes.INITIALISE_PURCHASE_ORDER_STOCK_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.purchaseOrderStockDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPurchaseOrderStockDetailCollectionModels, this.purchaseOrderStockDetailsCollectionId).subscribe(models => {
				models.forEach(purchaseOrderStockDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PurchaseOrderStockDetailModel.getProps(), this.purchaseOrderStockDetailsRelations, this.isViewOnly),
						purchaseOrderStockDetails,
						PurchaseOrderStockDetailModel,
						this.purchaseOrderStockDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.purchaseOrderStockDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.purchaseRequisitionStockDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.purchaseRequisitionStockDetailsDisplayName, many: true});
			this.store.dispatch(new purchaseRequisitionStockDetailModelAction.PurchaseRequisitionStockDetailAction(
				purchaseRequisitionStockDetailModelAction.PurchaseRequisitionStockDetailModelActionTypes.INITIALISE_PURCHASE_REQUISITION_STOCK_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.purchaseRequisitionStockDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPurchaseRequisitionStockDetailCollectionModels, this.purchaseRequisitionStockDetailsCollectionId).subscribe(models => {
				models.forEach(purchaseRequisitionStockDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PurchaseRequisitionStockDetailModel.getProps(), this.purchaseRequisitionStockDetailsRelations, this.isViewOnly),
						purchaseRequisitionStockDetails,
						PurchaseRequisitionStockDetailModel,
						this.purchaseRequisitionStockDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.purchaseRequisitionStockDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.retailPharmacyStockDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.retailPharmacyStockDetailsDisplayName, many: true});
			this.store.dispatch(new retailPharmacyStockDetailModelAction.RetailPharmacyStockDetailAction(
				retailPharmacyStockDetailModelAction.RetailPharmacyStockDetailModelActionTypes.INITIALISE_RETAIL_PHARMACY_STOCK_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.retailPharmacyStockDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRetailPharmacyStockDetailCollectionModels, this.retailPharmacyStockDetailsCollectionId).subscribe(models => {
				models.forEach(retailPharmacyStockDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RetailPharmacyStockDetailModel.getProps(), this.retailPharmacyStockDetailsRelations, this.isViewOnly),
						retailPharmacyStockDetails,
						RetailPharmacyStockDetailModel,
						this.retailPharmacyStockDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.retailPharmacyStockDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.returnSupplierStockDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.returnSupplierStockDetailsDisplayName, many: true});
			this.store.dispatch(new returnSupplierStockDetailModelAction.ReturnSupplierStockDetailAction(
				returnSupplierStockDetailModelAction.ReturnSupplierStockDetailModelActionTypes.INITIALISE_RETURN_SUPPLIER_STOCK_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.returnSupplierStockDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getReturnSupplierStockDetailCollectionModels, this.returnSupplierStockDetailsCollectionId).subscribe(models => {
				models.forEach(returnSupplierStockDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(ReturnSupplierStockDetailModel.getProps(), this.returnSupplierStockDetailsRelations, this.isViewOnly),
						returnSupplierStockDetails,
						ReturnSupplierStockDetailModel,
						this.returnSupplierStockDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.returnSupplierStockDetailsRelations,
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

		if (this.supplierProductDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.supplierProductDetailsDisplayName, many: true});
			this.store.dispatch(new supplierProductDetailModelAction.SupplierProductDetailAction(
				supplierProductDetailModelAction.SupplierProductDetailModelActionTypes.INITIALISE_SUPPLIER_PRODUCT_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.supplierProductDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getSupplierProductDetailCollectionModels, this.supplierProductDetailsCollectionId).subscribe(models => {
				models.forEach(supplierProductDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(SupplierProductDetailModel.getProps(), this.supplierProductDetailsRelations, this.isViewOnly),
						supplierProductDetails,
						SupplierProductDetailModel,
						this.supplierProductDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.supplierProductDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.transferOrderStockDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.transferOrderStockDetailsDisplayName, many: true});
			this.store.dispatch(new transferOrderStockDetailModelAction.TransferOrderStockDetailAction(
				transferOrderStockDetailModelAction.TransferOrderStockDetailModelActionTypes.INITIALISE_TRANSFER_ORDER_STOCK_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.transferOrderStockDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getTransferOrderStockDetailCollectionModels, this.transferOrderStockDetailsCollectionId).subscribe(models => {
				models.forEach(transferOrderStockDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(TransferOrderStockDetailModel.getProps(), this.transferOrderStockDetailsRelations, this.isViewOnly),
						transferOrderStockDetails,
						TransferOrderStockDetailModel,
						this.transferOrderStockDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.transferOrderStockDetailsRelations,
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
		if (this.targetModel.stockCatalogueMedical && this.targetModel.stockCatalogueMedical.id && this.stockCatalogueMedicalMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CatalogueMedicalModel,
				this.stockCatalogueMedicalOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.stockCatalogueMedical.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getCatalogueMedicalModelWithId, this.targetModel.stockCatalogueMedicalId).subscribe(stockCatalogueMedical => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CatalogueMedicalModel.getProps(), this.stockCatalogueMedicalRelations, this.isViewOnly),
					stockCatalogueMedical,
					CatalogueMedicalModel,
					this.stockCatalogueMedicalDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockCatalogueMedicalRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.stockCatalogueNonMedical && this.targetModel.stockCatalogueNonMedical.id && this.stockCatalogueNonMedicalMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CatalogueNonMedicalModel,
				this.stockCatalogueNonMedicalOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.stockCatalogueNonMedical.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getCatalogueNonMedicalModelWithId, this.targetModel.stockCatalogueNonMedicalId).subscribe(stockCatalogueNonMedical => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CatalogueNonMedicalModel.getProps(), this.stockCatalogueNonMedicalRelations, this.isViewOnly),
					stockCatalogueNonMedical,
					CatalogueNonMedicalModel,
					this.stockCatalogueNonMedicalDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.stockCatalogueNonMedicalRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsDrugGenericPRB && this.targetModel.bpjsDrugGenericPRB.id && this.bpjsDrugGenericPRBMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsDrugGenericPRBModel,
				this.bpjsDrugGenericPRBOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsDrugGenericPRB.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsDrugGenericPRBModelWithId, this.targetModel.bpjsDrugGenericPRBId).subscribe(bpjsDrugGenericPRB => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDrugGenericPRBModel.getProps(), this.bpjsDrugGenericPRBRelations, this.isViewOnly),
					bpjsDrugGenericPRB,
					BpjsDrugGenericPRBModel,
					this.bpjsDrugGenericPRBDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDrugGenericPRBRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsPcareDPHO && this.targetModel.bpjsPcareDPHO.id && this.bpjsPcareDPHOMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsPcareDPHOModel,
				this.bpjsPcareDPHOOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsPcareDPHO.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsPcareDPHOModelWithId, this.targetModel.bpjsPcareDPHOId).subscribe(bpjsPcareDPHO => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPcareDPHOModel.getProps(), this.bpjsPcareDPHORelations, this.isViewOnly),
					bpjsPcareDPHO,
					BpjsPcareDPHOModel,
					this.bpjsPcareDPHODisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPcareDPHORelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.warehouse && this.targetModel.warehouse.id && this.warehouseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				WarehouseModel,
				this.warehouseOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.warehouse.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getWarehouseModelWithId, this.targetModel.warehouseId).subscribe(warehouse => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(WarehouseModel.getProps(), this.warehouseRelations, this.isViewOnly),
					warehouse,
					WarehouseModel,
					this.warehouseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.warehouseRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.batchStockBalancesCatalogueIds && this.targetModel.batchStockBalancesCatalogueIds.length > 0 && this.batchStockBalancesCatalogueMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BatchStockBalanceModel,
				this.batchStockBalancesCatalogueOppositeRelation,
				this.batchStockBalancesCatalogueCollectionId,
				this.targetModel.batchStockBalancesCatalogueIds.length,
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

		if (this.targetModel.catalogueUOMsIds && this.targetModel.catalogueUOMsIds.length > 0 && this.catalogueUOMsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CatalogueUOMModel,
				this.catalogueUOMsOppositeRelation,
				this.catalogueUOMsCollectionId,
				this.targetModel.catalogueUOMsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.compoundPrescriptionItemsIds && this.targetModel.compoundPrescriptionItemsIds.length > 0 && this.compoundPrescriptionItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CompoundPrescriptionItemModel,
				this.compoundPrescriptionItemsOppositeRelation,
				this.compoundPrescriptionItemsCollectionId,
				this.targetModel.compoundPrescriptionItemsIds.length,
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

		if (this.targetModel.goodsReceiveNoteItemsIds && this.targetModel.goodsReceiveNoteItemsIds.length > 0 && this.goodsReceiveNoteItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				GoodsReceiveNoteItemModel,
				this.goodsReceiveNoteItemsOppositeRelation,
				this.goodsReceiveNoteItemsCollectionId,
				this.targetModel.goodsReceiveNoteItemsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.internalOrderStockDetailsIds && this.targetModel.internalOrderStockDetailsIds.length > 0 && this.internalOrderStockDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InternalOrderStockDetailModel,
				this.internalOrderStockDetailsOppositeRelation,
				this.internalOrderStockDetailsCollectionId,
				this.targetModel.internalOrderStockDetailsIds.length,
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

		if (this.targetModel.inventoryAdjustmentItemsIds && this.targetModel.inventoryAdjustmentItemsIds.length > 0 && this.inventoryAdjustmentItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InventoryAdjustmentItemModel,
				this.inventoryAdjustmentItemsOppositeRelation,
				this.inventoryAdjustmentItemsCollectionId,
				this.targetModel.inventoryAdjustmentItemsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.inventoryBatchCorrectionItemsIds && this.targetModel.inventoryBatchCorrectionItemsIds.length > 0 && this.inventoryBatchCorrectionItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InventoryBatchCorrectionItemModel,
				this.inventoryBatchCorrectionItemsOppositeRelation,
				this.inventoryBatchCorrectionItemsCollectionId,
				this.targetModel.inventoryBatchCorrectionItemsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicationItemsIds && this.targetModel.medicationItemsIds.length > 0 && this.medicationItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicationItemModel,
				this.medicationItemsOppositeRelation,
				this.medicationItemsCollectionId,
				this.targetModel.medicationItemsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.prescriptionItemIds && this.targetModel.prescriptionItemIds.length > 0 && this.prescriptionItemMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PrescriptionItemModel,
				this.prescriptionItemOppositeRelation,
				this.prescriptionItemCollectionId,
				this.targetModel.prescriptionItemIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.purchaseOrderStockDetailsIds && this.targetModel.purchaseOrderStockDetailsIds.length > 0 && this.purchaseOrderStockDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PurchaseOrderStockDetailModel,
				this.purchaseOrderStockDetailsOppositeRelation,
				this.purchaseOrderStockDetailsCollectionId,
				this.targetModel.purchaseOrderStockDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.purchaseRequisitionStockDetailsIds && this.targetModel.purchaseRequisitionStockDetailsIds.length > 0 && this.purchaseRequisitionStockDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PurchaseRequisitionStockDetailModel,
				this.purchaseRequisitionStockDetailsOppositeRelation,
				this.purchaseRequisitionStockDetailsCollectionId,
				this.targetModel.purchaseRequisitionStockDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.retailPharmacyStockDetailsIds && this.targetModel.retailPharmacyStockDetailsIds.length > 0 && this.retailPharmacyStockDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RetailPharmacyStockDetailModel,
				this.retailPharmacyStockDetailsOppositeRelation,
				this.retailPharmacyStockDetailsCollectionId,
				this.targetModel.retailPharmacyStockDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.returnSupplierStockDetailsIds && this.targetModel.returnSupplierStockDetailsIds.length > 0 && this.returnSupplierStockDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ReturnSupplierStockDetailModel,
				this.returnSupplierStockDetailsOppositeRelation,
				this.returnSupplierStockDetailsCollectionId,
				this.targetModel.returnSupplierStockDetailsIds.length,
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

		if (this.targetModel.supplierProductDetailsIds && this.targetModel.supplierProductDetailsIds.length > 0 && this.supplierProductDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SupplierProductDetailModel,
				this.supplierProductDetailsOppositeRelation,
				this.supplierProductDetailsCollectionId,
				this.targetModel.supplierProductDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.transferOrderStockDetailsIds && this.targetModel.transferOrderStockDetailsIds.length > 0 && this.transferOrderStockDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				TransferOrderStockDetailModel,
				this.transferOrderStockDetailsOppositeRelation,
				this.transferOrderStockDetailsCollectionId,
				this.targetModel.transferOrderStockDetailsIds.length,
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
	addAdditionalEntitiesToModel(model: StockCatalogueModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): StockCatalogueModel {
		let updatedModel: StockCatalogueModel = new StockCatalogueModel(model);

		if (this.bpjsDrugGenericPRBMultiCrudActive) {
			updatedModel.bpjsDrugGenericPRB = event.additionalEntities.bpjsDrugGenericPRB ? event.additionalEntities.bpjsDrugGenericPRB : undefined;

			if (!updatedModel.bpjsDrugGenericPRB && event.payload) {
				event.payload.bpjsDrugGenericPRBId = null;
			}
		} else if (event.payload?.bpjsDrugGenericPRBId !== undefined) {
			event.payload.bpjsDrugGenericPRB = null;
			updatedModel.bpjsDrugGenericPRB = null;
		}

		if (this.bpjsPcareDPHOMultiCrudActive) {
			updatedModel.bpjsPcareDPHO = event.additionalEntities.bpjsPcareDPHO ? event.additionalEntities.bpjsPcareDPHO : undefined;

			if (!updatedModel.bpjsPcareDPHO && event.payload) {
				event.payload.bpjsPcareDPHOId = null;
			}
		} else if (event.payload?.bpjsPcareDPHOId !== undefined) {
			event.payload.bpjsPcareDPHO = null;
			updatedModel.bpjsPcareDPHO = null;
		}

		if (this.stockCatalogueMedicalMultiCrudActive) {
			updatedModel.stockCatalogueMedical = event.additionalEntities.stockCatalogueMedical ? event.additionalEntities.stockCatalogueMedical : undefined;

			if (!updatedModel.stockCatalogueMedical && event.payload) {
				event.payload.stockCatalogueMedicalId = null;
			}
		} else if (event.payload?.stockCatalogueMedicalId !== undefined) {
			event.payload.stockCatalogueMedical = null;
			updatedModel.stockCatalogueMedical = null;
		}

		if (this.stockCatalogueNonMedicalMultiCrudActive) {
			updatedModel.stockCatalogueNonMedical = event.additionalEntities.stockCatalogueNonMedical ? event.additionalEntities.stockCatalogueNonMedical : undefined;

			if (!updatedModel.stockCatalogueNonMedical && event.payload) {
				event.payload.stockCatalogueNonMedicalId = null;
			}
		} else if (event.payload?.stockCatalogueNonMedicalId !== undefined) {
			event.payload.stockCatalogueNonMedical = null;
			updatedModel.stockCatalogueNonMedical = null;
		}

		if (this.warehouseMultiCrudActive) {
			updatedModel.warehouse = event.additionalEntities.warehouse ? event.additionalEntities.warehouse : undefined;

			if (!updatedModel.warehouse && event.payload) {
				event.payload.warehouseId = null;
			}
		} else if (event.payload?.warehouseId !== undefined) {
			event.payload.warehouse = null;
			updatedModel.warehouse = null;
		}

		updatedModel.batchStockBalancesCatalogue = [];
		if (this.batchStockBalancesCatalogueMultiCrudActive) {
			if (event.additionalEntities.batchStockBalancesCatalogue) {
				event.additionalEntities.batchStockBalancesCatalogue.forEach(entity => {
					updatedModel.batchStockBalancesCatalogue.push(entity);
				});
			}

			if (!updatedModel.batchStockBalancesCatalogue.length) {
				updatedModel.batchStockBalancesCatalogueIds = [];
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
		updatedModel.catalogueUOMs = [];
		if (this.catalogueUOMsMultiCrudActive) {
			if (event.additionalEntities.catalogueUOMs) {
				event.additionalEntities.catalogueUOMs.forEach(entity => {
					updatedModel.catalogueUOMs.push(entity);
				});
			}

			if (!updatedModel.catalogueUOMs.length) {
				updatedModel.catalogueUOMsIds = [];
			}
		}
		updatedModel.compoundPrescriptionItems = [];
		if (this.compoundPrescriptionItemsMultiCrudActive) {
			if (event.additionalEntities.compoundPrescriptionItems) {
				event.additionalEntities.compoundPrescriptionItems.forEach(entity => {
					updatedModel.compoundPrescriptionItems.push(entity);
				});
			}

			if (!updatedModel.compoundPrescriptionItems.length) {
				updatedModel.compoundPrescriptionItemsIds = [];
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
		updatedModel.goodsReceiveNoteItems = [];
		if (this.goodsReceiveNoteItemsMultiCrudActive) {
			if (event.additionalEntities.goodsReceiveNoteItems) {
				event.additionalEntities.goodsReceiveNoteItems.forEach(entity => {
					updatedModel.goodsReceiveNoteItems.push(entity);
				});
			}

			if (!updatedModel.goodsReceiveNoteItems.length) {
				updatedModel.goodsReceiveNoteItemsIds = [];
			}
		}
		updatedModel.internalOrderStockDetails = [];
		if (this.internalOrderStockDetailsMultiCrudActive) {
			if (event.additionalEntities.internalOrderStockDetails) {
				event.additionalEntities.internalOrderStockDetails.forEach(entity => {
					updatedModel.internalOrderStockDetails.push(entity);
				});
			}

			if (!updatedModel.internalOrderStockDetails.length) {
				updatedModel.internalOrderStockDetailsIds = [];
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
		updatedModel.inventoryAdjustmentItems = [];
		if (this.inventoryAdjustmentItemsMultiCrudActive) {
			if (event.additionalEntities.inventoryAdjustmentItems) {
				event.additionalEntities.inventoryAdjustmentItems.forEach(entity => {
					updatedModel.inventoryAdjustmentItems.push(entity);
				});
			}

			if (!updatedModel.inventoryAdjustmentItems.length) {
				updatedModel.inventoryAdjustmentItemsIds = [];
			}
		}
		updatedModel.inventoryBatchCorrectionItems = [];
		if (this.inventoryBatchCorrectionItemsMultiCrudActive) {
			if (event.additionalEntities.inventoryBatchCorrectionItems) {
				event.additionalEntities.inventoryBatchCorrectionItems.forEach(entity => {
					updatedModel.inventoryBatchCorrectionItems.push(entity);
				});
			}

			if (!updatedModel.inventoryBatchCorrectionItems.length) {
				updatedModel.inventoryBatchCorrectionItemsIds = [];
			}
		}
		updatedModel.medicationItems = [];
		if (this.medicationItemsMultiCrudActive) {
			if (event.additionalEntities.medicationItems) {
				event.additionalEntities.medicationItems.forEach(entity => {
					updatedModel.medicationItems.push(entity);
				});
			}

			if (!updatedModel.medicationItems.length) {
				updatedModel.medicationItemsIds = [];
			}
		}
		updatedModel.prescriptionItem = [];
		if (this.prescriptionItemMultiCrudActive) {
			if (event.additionalEntities.prescriptionItem) {
				event.additionalEntities.prescriptionItem.forEach(entity => {
					updatedModel.prescriptionItem.push(entity);
				});
			}

			if (!updatedModel.prescriptionItem.length) {
				updatedModel.prescriptionItemIds = [];
			}
		}
		updatedModel.purchaseOrderStockDetails = [];
		if (this.purchaseOrderStockDetailsMultiCrudActive) {
			if (event.additionalEntities.purchaseOrderStockDetails) {
				event.additionalEntities.purchaseOrderStockDetails.forEach(entity => {
					updatedModel.purchaseOrderStockDetails.push(entity);
				});
			}

			if (!updatedModel.purchaseOrderStockDetails.length) {
				updatedModel.purchaseOrderStockDetailsIds = [];
			}
		}
		updatedModel.purchaseRequisitionStockDetails = [];
		if (this.purchaseRequisitionStockDetailsMultiCrudActive) {
			if (event.additionalEntities.purchaseRequisitionStockDetails) {
				event.additionalEntities.purchaseRequisitionStockDetails.forEach(entity => {
					updatedModel.purchaseRequisitionStockDetails.push(entity);
				});
			}

			if (!updatedModel.purchaseRequisitionStockDetails.length) {
				updatedModel.purchaseRequisitionStockDetailsIds = [];
			}
		}
		updatedModel.retailPharmacyStockDetails = [];
		if (this.retailPharmacyStockDetailsMultiCrudActive) {
			if (event.additionalEntities.retailPharmacyStockDetails) {
				event.additionalEntities.retailPharmacyStockDetails.forEach(entity => {
					updatedModel.retailPharmacyStockDetails.push(entity);
				});
			}

			if (!updatedModel.retailPharmacyStockDetails.length) {
				updatedModel.retailPharmacyStockDetailsIds = [];
			}
		}
		updatedModel.returnSupplierStockDetails = [];
		if (this.returnSupplierStockDetailsMultiCrudActive) {
			if (event.additionalEntities.returnSupplierStockDetails) {
				event.additionalEntities.returnSupplierStockDetails.forEach(entity => {
					updatedModel.returnSupplierStockDetails.push(entity);
				});
			}

			if (!updatedModel.returnSupplierStockDetails.length) {
				updatedModel.returnSupplierStockDetailsIds = [];
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
		updatedModel.supplierProductDetails = [];
		if (this.supplierProductDetailsMultiCrudActive) {
			if (event.additionalEntities.supplierProductDetails) {
				event.additionalEntities.supplierProductDetails.forEach(entity => {
					updatedModel.supplierProductDetails.push(entity);
				});
			}

			if (!updatedModel.supplierProductDetails.length) {
				updatedModel.supplierProductDetailsIds = [];
			}
		}
		updatedModel.transferOrderStockDetails = [];
		if (this.transferOrderStockDetailsMultiCrudActive) {
			if (event.additionalEntities.transferOrderStockDetails) {
				event.additionalEntities.transferOrderStockDetails.forEach(entity => {
					updatedModel.transferOrderStockDetails.push(entity);
				});
			}

			if (!updatedModel.transferOrderStockDetails.length) {
				updatedModel.transferOrderStockDetailsIds = [];
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
