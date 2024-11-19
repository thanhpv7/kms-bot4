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

import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { By } from '@angular/platform-browser';
import { ComponentFixture, TestBed, waitForAsync, fakeAsync } from '@angular/core/testing';
import { CookieService } from 'ngx-cookie-service';
import { DebugElement } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Store } from '@ngrx/store';
import { MockStore, provideMockStore } from '@ngrx/store/testing';
import { ModalDialogService, ModalDialogInstanceService } from '@preeco-privacy/ngx-modal-dialog';
import { ActivatedRouteStub } from 'src/testing/helpers/activated-route-stub';
import { CommonComponentModule } from 'src/app/lib/components/common.component.module';
import { getRouterState } from 'src/app/models/model.selector';
import { RouterState } from 'src/app/models/model.state';
import { 
	getInventoryBatchCorrectionCollectionModels,
	getCountInventoryBatchCorrectionModels,
	getInventoryBatchCorrectionModelWithId
} from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.selector';
import { InventoryBatchCorrectionCrudModule } from '../inventory-batch-correction-crud.module';
import { InventoryBatchCorrectionCrudEditComponent } from './inventory-batch-correction-crud-edit.component';
import {
	InventoryBatchCorrectionModelState,
	initialState as initialInventoryBatchCorrectionModelState
} from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.state';
import { InventoryBatchCorrectionDataFactory } from 'src/app/lib/utils/factories/inventory-batch-correction-data-factory';
import { InventoryBatchCorrectionModel } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model';
import { CrudTileMode } from '../inventory-batch-correction-crud.component';
import { getBatchStockBalanceModelWithId } from 'src/app/models/batchStockBalance/batch_stock_balance.model.selector';
import { getBatchStockBalanceCollectionModels } from 'src/app/models/batchStockBalance/batch_stock_balance.model.selector';
import { BatchStockBalanceModel } from 'src/app/models/batchStockBalance/batch_stock_balance.model';
import { BatchStockBalanceDataFactory } from 'src/app/lib/utils/factories/batch-stock-balance-data-factory';
import { getBatchStockBalancePerDateModelWithId } from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model.selector';
import { getBatchStockBalancePerDateCollectionModels } from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model.selector';
import { BatchStockBalancePerDateModel } from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model';
import { BatchStockBalancePerDateDataFactory } from 'src/app/lib/utils/factories/batch-stock-balance-per-date-data-factory';
import { getBatchStockTransactionDetailModelWithId } from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model.selector';
import { getBatchStockTransactionDetailCollectionModels } from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model.selector';
import { BatchStockTransactionDetailModel } from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model';
import { BatchStockTransactionDetailDataFactory } from 'src/app/lib/utils/factories/batch-stock-transaction-detail-data-factory';
import { getGoodsReceiveNoteModelWithId } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import { getGoodsReceiveNoteCollectionModels } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import { GoodsReceiveNoteModel } from 'src/app/models/goodsReceiveNote/goods_receive_note.model';
import { GoodsReceiveNoteDataFactory } from 'src/app/lib/utils/factories/goods-receive-note-data-factory';
import { getGoodsReceiveNoteBatchModelWithId } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.selector';
import { getGoodsReceiveNoteBatchCollectionModels } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.selector';
import { GoodsReceiveNoteBatchModel } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model';
import { GoodsReceiveNoteBatchDataFactory } from 'src/app/lib/utils/factories/goods-receive-note-batch-data-factory';
import { getInternalOrderModelWithId } from 'src/app/models/internalOrder/internal_order.model.selector';
import { getInternalOrderCollectionModels } from 'src/app/models/internalOrder/internal_order.model.selector';
import { InternalOrderModel } from 'src/app/models/internalOrder/internal_order.model';
import { InternalOrderDataFactory } from 'src/app/lib/utils/factories/internal-order-data-factory';
import { getInventoryAdjusmentBatchModelWithId } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.selector';
import { getInventoryAdjusmentBatchCollectionModels } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.selector';
import { InventoryAdjusmentBatchModel } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import { InventoryAdjusmentBatchDataFactory } from 'src/app/lib/utils/factories/inventory-adjusment-batch-data-factory';
import { getInventoryAdjustmentModelWithId } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.selector';
import { getInventoryAdjustmentCollectionModels } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.selector';
import { InventoryAdjustmentModel } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model';
import { InventoryAdjustmentDataFactory } from 'src/app/lib/utils/factories/inventory-adjustment-data-factory';
import { getInventoryBatchCorrectionItemModelWithId } from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model.selector';
import { getInventoryBatchCorrectionItemCollectionModels } from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model.selector';
import { InventoryBatchCorrectionItemModel } from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model';
import { InventoryBatchCorrectionItemDataFactory } from 'src/app/lib/utils/factories/inventory-batch-correction-item-data-factory';
import { getLocationModelWithId } from 'src/app/models/location/location.model.selector';
import { getLocationCollectionModels } from 'src/app/models/location/location.model.selector';
import { LocationModel } from 'src/app/models/location/location.model';
import { LocationDataFactory } from 'src/app/lib/utils/factories/location-data-factory';
import { getMedicalFeeModelWithId } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { getMedicalFeeCollectionModels } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { MedicalFeeModel } from 'src/app/models/medicalFee/medical_fee.model';
import { MedicalFeeDataFactory } from 'src/app/lib/utils/factories/medical-fee-data-factory';
import { getMedicationHeaderModelWithId } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { getMedicationHeaderCollectionModels } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { MedicationHeaderModel } from 'src/app/models/medicationHeader/medication_header.model';
import { MedicationHeaderDataFactory } from 'src/app/lib/utils/factories/medication-header-data-factory';
import { getPrescriptionHeaderModelWithId } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderDataFactory } from 'src/app/lib/utils/factories/prescription-header-data-factory';
import { getPurchaseOrderModelWithId } from 'src/app/models/purchaseOrder/purchase_order.model.selector';
import { getPurchaseOrderCollectionModels } from 'src/app/models/purchaseOrder/purchase_order.model.selector';
import { PurchaseOrderModel } from 'src/app/models/purchaseOrder/purchase_order.model';
import { PurchaseOrderDataFactory } from 'src/app/lib/utils/factories/purchase-order-data-factory';
import { getPurchaseRequisitionModelWithId } from 'src/app/models/purchaseRequisition/purchase_requisition.model.selector';
import { getPurchaseRequisitionCollectionModels } from 'src/app/models/purchaseRequisition/purchase_requisition.model.selector';
import { PurchaseRequisitionModel } from 'src/app/models/purchaseRequisition/purchase_requisition.model';
import { PurchaseRequisitionDataFactory } from 'src/app/lib/utils/factories/purchase-requisition-data-factory';
import { getRetailPharmacyModelWithId } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { getRetailPharmacyCollectionModels } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { RetailPharmacyModel } from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import { RetailPharmacyDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-data-factory';
import { getReturnSupplierModelWithId } from 'src/app/models/returnSupplier/return_supplier.model.selector';
import { getReturnSupplierCollectionModels } from 'src/app/models/returnSupplier/return_supplier.model.selector';
import { ReturnSupplierModel } from 'src/app/models/returnSupplier/return_supplier.model';
import { ReturnSupplierDataFactory } from 'src/app/lib/utils/factories/return-supplier-data-factory';
import { getStockCatalogueModelWithId } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { getStockCatalogueCollectionModels } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { StockCatalogueModel } from 'src/app/models/stockCatalogue/stock_catalogue.model';
import { StockCatalogueDataFactory } from 'src/app/lib/utils/factories/stock-catalogue-data-factory';
import { getStockControlModelWithId } from 'src/app/models/stockControl/stock_control.model.selector';
import { getStockControlCollectionModels } from 'src/app/models/stockControl/stock_control.model.selector';
import { StockControlModel } from 'src/app/models/stockControl/stock_control.model';
import { StockControlDataFactory } from 'src/app/lib/utils/factories/stock-control-data-factory';
import { getStockTransactionDetailModelWithId } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.selector';
import { getStockTransactionDetailCollectionModels } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.selector';
import { StockTransactionDetailModel } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model';
import { StockTransactionDetailDataFactory } from 'src/app/lib/utils/factories/stock-transaction-detail-data-factory';
import { getStockTransactionPerDateModelWithId } from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model.selector';
import { getStockTransactionPerDateCollectionModels } from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model.selector';
import { StockTransactionPerDateModel } from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model';
import { StockTransactionPerDateDataFactory } from 'src/app/lib/utils/factories/stock-transaction-per-date-data-factory';
import { getStockTransactionPerDateTypeModelWithId } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.selector';
import { getStockTransactionPerDateTypeCollectionModels } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.selector';
import { StockTransactionPerDateTypeModel } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model';
import { StockTransactionPerDateTypeDataFactory } from 'src/app/lib/utils/factories/stock-transaction-per-date-type-data-factory';
import { getTransferOrderModelWithId } from 'src/app/models/transferOrder/transfer_order.model.selector';
import { getTransferOrderCollectionModels } from 'src/app/models/transferOrder/transfer_order.model.selector';
import { TransferOrderModel } from 'src/app/models/transferOrder/transfer_order.model';
import { TransferOrderDataFactory } from 'src/app/lib/utils/factories/transfer-order-data-factory';
import { getVaccinationOrderDetailModelWithId } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import { getVaccinationOrderDetailCollectionModels } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import { VaccinationOrderDetailModel } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model';
import { VaccinationOrderDetailDataFactory } from 'src/app/lib/utils/factories/vaccination-order-detail-data-factory';
import { getWarehouseModelWithId } from 'src/app/models/warehouse/warehouse.model.selector';
import { getWarehouseCollectionModels } from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { WarehouseDataFactory } from 'src/app/lib/utils/factories/warehouse-data-factory';
import { getWarehouseInitialStockModelWithId } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model.selector';
import { getWarehouseInitialStockCollectionModels } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model.selector';
import { WarehouseInitialStockModel } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model';
import { WarehouseInitialStockDataFactory } from 'src/app/lib/utils/factories/warehouse-initial-stock-data-factory';
import { getWarehouseInventoryModelWithId } from 'src/app/models/warehouseInventory/warehouse_inventory.model.selector';
import { getWarehouseInventoryCollectionModels } from 'src/app/models/warehouseInventory/warehouse_inventory.model.selector';
import { WarehouseInventoryModel } from 'src/app/models/warehouseInventory/warehouse_inventory.model';
import { WarehouseInventoryDataFactory } from 'src/app/lib/utils/factories/warehouse-inventory-data-factory';

describe('Inventory Batch Correction CRUD Edit component tests', () => {
	let fixture: ComponentFixture<InventoryBatchCorrectionCrudEditComponent>
	let component: InventoryBatchCorrectionCrudEditComponent;

	let inventoryBatchCorrectionModelState: InventoryBatchCorrectionModelState;

	let store: MockStore<{ model: InventoryBatchCorrectionModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let inventoryBatchCorrectionCountBehaviorSubject: BehaviorSubject<number>;
	let inventoryBatchCorrectionModelsBehaviorSubject: BehaviorSubject<InventoryBatchCorrectionModel[]>;
	let batchStockBalanceModelsBehaviorSubject: BehaviorSubject<BatchStockBalanceModel[]>;
	let batchStockBalancePerDateModelsBehaviorSubject: BehaviorSubject<BatchStockBalancePerDateModel[]>;
	let batchStockTransactionDetailModelsBehaviorSubject: BehaviorSubject<BatchStockTransactionDetailModel[]>;
	let goodsReceiveNoteModelsBehaviorSubject: BehaviorSubject<GoodsReceiveNoteModel[]>;
	let goodsReceiveNoteBatchModelsBehaviorSubject: BehaviorSubject<GoodsReceiveNoteBatchModel[]>;
	let internalOrderModelsBehaviorSubject: BehaviorSubject<InternalOrderModel[]>;
	let inventoryAdjusmentBatchModelsBehaviorSubject: BehaviorSubject<InventoryAdjusmentBatchModel[]>;
	let inventoryAdjustmentModelsBehaviorSubject: BehaviorSubject<InventoryAdjustmentModel[]>;
	let inventoryBatchCorrectionItemModelsBehaviorSubject: BehaviorSubject<InventoryBatchCorrectionItemModel[]>;
	let locationModelsBehaviorSubject: BehaviorSubject<LocationModel[]>;
	let medicalFeeModelsBehaviorSubject: BehaviorSubject<MedicalFeeModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let purchaseOrderModelsBehaviorSubject: BehaviorSubject<PurchaseOrderModel[]>;
	let purchaseRequisitionModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionModel[]>;
	let retailPharmacyModelsBehaviorSubject: BehaviorSubject<RetailPharmacyModel[]>;
	let returnSupplierModelsBehaviorSubject: BehaviorSubject<ReturnSupplierModel[]>;
	let stockCatalogueModelsBehaviorSubject: BehaviorSubject<StockCatalogueModel[]>;
	let stockControlModelsBehaviorSubject: BehaviorSubject<StockControlModel[]>;
	let stockTransactionDetailModelsBehaviorSubject: BehaviorSubject<StockTransactionDetailModel[]>;
	let stockTransactionPerDateModelsBehaviorSubject: BehaviorSubject<StockTransactionPerDateModel[]>;
	let stockTransactionPerDateTypeModelsBehaviorSubject: BehaviorSubject<StockTransactionPerDateTypeModel[]>;
	let transferOrderModelsBehaviorSubject: BehaviorSubject<TransferOrderModel[]>;
	let vaccinationOrderDetailModelsBehaviorSubject: BehaviorSubject<VaccinationOrderDetailModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;
	let warehouseInitialStockModelsBehaviorSubject: BehaviorSubject<WarehouseInitialStockModel[]>;
	let warehouseInventoryModelsBehaviorSubject: BehaviorSubject<WarehouseInventoryModel[]>;

	const inventoryBatchCorrectionFactory: InventoryBatchCorrectionDataFactory = new InventoryBatchCorrectionDataFactory();
	const defaultInventoryBatchCorrectionCount: number = 10;
	const defaultInventoryBatchCorrectionEntities: InventoryBatchCorrectionModel[] = inventoryBatchCorrectionFactory.createAll(defaultInventoryBatchCorrectionCount);

	const batchStockBalanceFactory: BatchStockBalanceDataFactory = new BatchStockBalanceDataFactory();
	const defaultBatchStockBalanceCount: number = 10;
	const defaultBatchStockBalanceEntities: BatchStockBalanceModel[] = batchStockBalanceFactory.createAll(defaultBatchStockBalanceCount);

	const batchStockBalancePerDateFactory: BatchStockBalancePerDateDataFactory = new BatchStockBalancePerDateDataFactory();
	const defaultBatchStockBalancePerDateCount: number = 10;
	const defaultBatchStockBalancePerDateEntities: BatchStockBalancePerDateModel[] = batchStockBalancePerDateFactory.createAll(defaultBatchStockBalancePerDateCount);

	const batchStockTransactionDetailFactory: BatchStockTransactionDetailDataFactory = new BatchStockTransactionDetailDataFactory();
	const defaultBatchStockTransactionDetailCount: number = 10;
	const defaultBatchStockTransactionDetailEntities: BatchStockTransactionDetailModel[] = batchStockTransactionDetailFactory.createAll(defaultBatchStockTransactionDetailCount);

	const goodsReceiveNoteFactory: GoodsReceiveNoteDataFactory = new GoodsReceiveNoteDataFactory();
	const defaultGoodsReceiveNoteCount: number = 10;
	const defaultGoodsReceiveNoteEntities: GoodsReceiveNoteModel[] = goodsReceiveNoteFactory.createAll(defaultGoodsReceiveNoteCount);

	const goodsReceiveNoteBatchFactory: GoodsReceiveNoteBatchDataFactory = new GoodsReceiveNoteBatchDataFactory();
	const defaultGoodsReceiveNoteBatchCount: number = 10;
	const defaultGoodsReceiveNoteBatchEntities: GoodsReceiveNoteBatchModel[] = goodsReceiveNoteBatchFactory.createAll(defaultGoodsReceiveNoteBatchCount);

	const internalOrderFactory: InternalOrderDataFactory = new InternalOrderDataFactory();
	const defaultInternalOrderCount: number = 10;
	const defaultInternalOrderEntities: InternalOrderModel[] = internalOrderFactory.createAll(defaultInternalOrderCount);

	const inventoryAdjusmentBatchFactory: InventoryAdjusmentBatchDataFactory = new InventoryAdjusmentBatchDataFactory();
	const defaultInventoryAdjusmentBatchCount: number = 10;
	const defaultInventoryAdjusmentBatchEntities: InventoryAdjusmentBatchModel[] = inventoryAdjusmentBatchFactory.createAll(defaultInventoryAdjusmentBatchCount);

	const inventoryAdjustmentFactory: InventoryAdjustmentDataFactory = new InventoryAdjustmentDataFactory();
	const defaultInventoryAdjustmentCount: number = 10;
	const defaultInventoryAdjustmentEntities: InventoryAdjustmentModel[] = inventoryAdjustmentFactory.createAll(defaultInventoryAdjustmentCount);

	const inventoryBatchCorrectionItemFactory: InventoryBatchCorrectionItemDataFactory = new InventoryBatchCorrectionItemDataFactory();
	const defaultInventoryBatchCorrectionItemCount: number = 10;
	const defaultInventoryBatchCorrectionItemEntities: InventoryBatchCorrectionItemModel[] = inventoryBatchCorrectionItemFactory.createAll(defaultInventoryBatchCorrectionItemCount);

	const locationFactory: LocationDataFactory = new LocationDataFactory();
	const defaultLocationCount: number = 10;
	const defaultLocationEntities: LocationModel[] = locationFactory.createAll(defaultLocationCount);

	const medicalFeeFactory: MedicalFeeDataFactory = new MedicalFeeDataFactory();
	const defaultMedicalFeeCount: number = 10;
	const defaultMedicalFeeEntities: MedicalFeeModel[] = medicalFeeFactory.createAll(defaultMedicalFeeCount);

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const purchaseOrderFactory: PurchaseOrderDataFactory = new PurchaseOrderDataFactory();
	const defaultPurchaseOrderCount: number = 10;
	const defaultPurchaseOrderEntities: PurchaseOrderModel[] = purchaseOrderFactory.createAll(defaultPurchaseOrderCount);

	const purchaseRequisitionFactory: PurchaseRequisitionDataFactory = new PurchaseRequisitionDataFactory();
	const defaultPurchaseRequisitionCount: number = 10;
	const defaultPurchaseRequisitionEntities: PurchaseRequisitionModel[] = purchaseRequisitionFactory.createAll(defaultPurchaseRequisitionCount);

	const retailPharmacyFactory: RetailPharmacyDataFactory = new RetailPharmacyDataFactory();
	const defaultRetailPharmacyCount: number = 10;
	const defaultRetailPharmacyEntities: RetailPharmacyModel[] = retailPharmacyFactory.createAll(defaultRetailPharmacyCount);

	const returnSupplierFactory: ReturnSupplierDataFactory = new ReturnSupplierDataFactory();
	const defaultReturnSupplierCount: number = 10;
	const defaultReturnSupplierEntities: ReturnSupplierModel[] = returnSupplierFactory.createAll(defaultReturnSupplierCount);

	const stockCatalogueFactory: StockCatalogueDataFactory = new StockCatalogueDataFactory();
	const defaultStockCatalogueCount: number = 10;
	const defaultStockCatalogueEntities: StockCatalogueModel[] = stockCatalogueFactory.createAll(defaultStockCatalogueCount);

	const stockControlFactory: StockControlDataFactory = new StockControlDataFactory();
	const defaultStockControlCount: number = 10;
	const defaultStockControlEntities: StockControlModel[] = stockControlFactory.createAll(defaultStockControlCount);

	const stockTransactionDetailFactory: StockTransactionDetailDataFactory = new StockTransactionDetailDataFactory();
	const defaultStockTransactionDetailCount: number = 10;
	const defaultStockTransactionDetailEntities: StockTransactionDetailModel[] = stockTransactionDetailFactory.createAll(defaultStockTransactionDetailCount);

	const stockTransactionPerDateFactory: StockTransactionPerDateDataFactory = new StockTransactionPerDateDataFactory();
	const defaultStockTransactionPerDateCount: number = 10;
	const defaultStockTransactionPerDateEntities: StockTransactionPerDateModel[] = stockTransactionPerDateFactory.createAll(defaultStockTransactionPerDateCount);

	const stockTransactionPerDateTypeFactory: StockTransactionPerDateTypeDataFactory = new StockTransactionPerDateTypeDataFactory();
	const defaultStockTransactionPerDateTypeCount: number = 10;
	const defaultStockTransactionPerDateTypeEntities: StockTransactionPerDateTypeModel[] = stockTransactionPerDateTypeFactory.createAll(defaultStockTransactionPerDateTypeCount);

	const transferOrderFactory: TransferOrderDataFactory = new TransferOrderDataFactory();
	const defaultTransferOrderCount: number = 10;
	const defaultTransferOrderEntities: TransferOrderModel[] = transferOrderFactory.createAll(defaultTransferOrderCount);

	const vaccinationOrderDetailFactory: VaccinationOrderDetailDataFactory = new VaccinationOrderDetailDataFactory();
	const defaultVaccinationOrderDetailCount: number = 10;
	const defaultVaccinationOrderDetailEntities: VaccinationOrderDetailModel[] = vaccinationOrderDetailFactory.createAll(defaultVaccinationOrderDetailCount);

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);

	const warehouseInitialStockFactory: WarehouseInitialStockDataFactory = new WarehouseInitialStockDataFactory();
	const defaultWarehouseInitialStockCount: number = 10;
	const defaultWarehouseInitialStockEntities: WarehouseInitialStockModel[] = warehouseInitialStockFactory.createAll(defaultWarehouseInitialStockCount);

	const warehouseInventoryFactory: WarehouseInventoryDataFactory = new WarehouseInventoryDataFactory();
	const defaultWarehouseInventoryCount: number = 10;
	const defaultWarehouseInventoryEntities: WarehouseInventoryModel[] = warehouseInventoryFactory.createAll(defaultWarehouseInventoryCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let inventoryBatchCorrectionWithId: InventoryBatchCorrectionModel = defaultInventoryBatchCorrectionEntities[0];
	let inventoryBatchCorrectionModelWithIdBehaviorSubject: BehaviorSubject<InventoryBatchCorrectionModel>;

	inventoryBatchCorrectionWithId.warehouse = defaultWarehouseEntities[0];
	inventoryBatchCorrectionWithId.warehouseId = inventoryBatchCorrectionWithId.warehouse.id;
	let warehouseWithIdBehaviorSubject: BehaviorSubject<WarehouseModel>;

	inventoryBatchCorrectionWithId.inventoryBatchCorrectionItems = defaultInventoryBatchCorrectionItemEntities;
	inventoryBatchCorrectionWithId.inventoryBatchCorrectionItemsIds = inventoryBatchCorrectionWithId.inventoryBatchCorrectionItems.map(inventoryBatchCorrectionItems => inventoryBatchCorrectionItems.id);


	const routerState: RouterState = {
		url: 'inventory-batch-correction-crud',
		urls: ['inventory-batch-correction-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: InventoryBatchCorrectionModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		inventoryBatchCorrectionModelState = initialInventoryBatchCorrectionModelState;
		store.setState({model: inventoryBatchCorrectionModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		inventoryBatchCorrectionCountBehaviorSubject = new BehaviorSubject(defaultInventoryBatchCorrectionCount);

		// selectors for all references
		inventoryBatchCorrectionModelsBehaviorSubject = new BehaviorSubject(defaultInventoryBatchCorrectionEntities);
		batchStockBalanceModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockBalanceEntities);
		batchStockBalancePerDateModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockBalancePerDateEntities);
		batchStockTransactionDetailModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockTransactionDetailEntities);
		goodsReceiveNoteModelsBehaviorSubject = new BehaviorSubject(defaultGoodsReceiveNoteEntities);
		goodsReceiveNoteBatchModelsBehaviorSubject = new BehaviorSubject(defaultGoodsReceiveNoteBatchEntities);
		internalOrderModelsBehaviorSubject = new BehaviorSubject(defaultInternalOrderEntities);
		inventoryAdjusmentBatchModelsBehaviorSubject = new BehaviorSubject(defaultInventoryAdjusmentBatchEntities);
		inventoryAdjustmentModelsBehaviorSubject = new BehaviorSubject(defaultInventoryAdjustmentEntities);
		inventoryBatchCorrectionItemModelsBehaviorSubject = new BehaviorSubject(defaultInventoryBatchCorrectionItemEntities);
		locationModelsBehaviorSubject = new BehaviorSubject(defaultLocationEntities);
		medicalFeeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		purchaseOrderModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderEntities);
		purchaseRequisitionModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionEntities);
		retailPharmacyModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyEntities);
		returnSupplierModelsBehaviorSubject = new BehaviorSubject(defaultReturnSupplierEntities);
		stockCatalogueModelsBehaviorSubject = new BehaviorSubject(defaultStockCatalogueEntities);
		stockControlModelsBehaviorSubject = new BehaviorSubject(defaultStockControlEntities);
		stockTransactionDetailModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionDetailEntities);
		stockTransactionPerDateModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionPerDateEntities);
		stockTransactionPerDateTypeModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionPerDateTypeEntities);
		transferOrderModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderEntities);
		vaccinationOrderDetailModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderDetailEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);
		warehouseInitialStockModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseInitialStockEntities);
		warehouseInventoryModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseInventoryEntities);

		// selectors for target entity and its related entity
		inventoryBatchCorrectionModelWithIdBehaviorSubject = new BehaviorSubject(inventoryBatchCorrectionWithId);
		warehouseWithIdBehaviorSubject = new BehaviorSubject(inventoryBatchCorrectionWithId.warehouse);

		spyOn(store, 'select')
			.withArgs(getCountInventoryBatchCorrectionModels).and.returnValue(inventoryBatchCorrectionCountBehaviorSubject)
			.withArgs(getInventoryBatchCorrectionModelWithId, inventoryBatchCorrectionWithId.id).and.returnValue(inventoryBatchCorrectionModelWithIdBehaviorSubject)
			.withArgs(getInventoryBatchCorrectionCollectionModels, jasmine.any(String)).and.returnValue(inventoryBatchCorrectionModelsBehaviorSubject)
			.withArgs(getBatchStockBalanceCollectionModels, jasmine.any(String)).and.returnValue(batchStockBalanceModelsBehaviorSubject)
			.withArgs(getBatchStockBalancePerDateCollectionModels, jasmine.any(String)).and.returnValue(batchStockBalancePerDateModelsBehaviorSubject)
			.withArgs(getBatchStockTransactionDetailCollectionModels, jasmine.any(String)).and.returnValue(batchStockTransactionDetailModelsBehaviorSubject)
			.withArgs(getGoodsReceiveNoteCollectionModels, jasmine.any(String)).and.returnValue(goodsReceiveNoteModelsBehaviorSubject)
			.withArgs(getGoodsReceiveNoteBatchCollectionModels, jasmine.any(String)).and.returnValue(goodsReceiveNoteBatchModelsBehaviorSubject)
			.withArgs(getInternalOrderCollectionModels, jasmine.any(String)).and.returnValue(internalOrderModelsBehaviorSubject)
			.withArgs(getInventoryAdjusmentBatchCollectionModels, jasmine.any(String)).and.returnValue(inventoryAdjusmentBatchModelsBehaviorSubject)
			.withArgs(getInventoryAdjustmentCollectionModels, jasmine.any(String)).and.returnValue(inventoryAdjustmentModelsBehaviorSubject)
			.withArgs(getInventoryBatchCorrectionItemCollectionModels, jasmine.any(String)).and.returnValue(inventoryBatchCorrectionItemModelsBehaviorSubject)
			.withArgs(getLocationCollectionModels, jasmine.any(String)).and.returnValue(locationModelsBehaviorSubject)
			.withArgs(getMedicalFeeCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getPurchaseOrderCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionModelsBehaviorSubject)
			.withArgs(getRetailPharmacyCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyModelsBehaviorSubject)
			.withArgs(getReturnSupplierCollectionModels, jasmine.any(String)).and.returnValue(returnSupplierModelsBehaviorSubject)
			.withArgs(getStockCatalogueCollectionModels, jasmine.any(String)).and.returnValue(stockCatalogueModelsBehaviorSubject)
			.withArgs(getStockControlCollectionModels, jasmine.any(String)).and.returnValue(stockControlModelsBehaviorSubject)
			.withArgs(getStockTransactionDetailCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionDetailModelsBehaviorSubject)
			.withArgs(getStockTransactionPerDateCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionPerDateModelsBehaviorSubject)
			.withArgs(getStockTransactionPerDateTypeCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionPerDateTypeModelsBehaviorSubject)
			.withArgs(getTransferOrderCollectionModels, jasmine.any(String)).and.returnValue(transferOrderModelsBehaviorSubject)
			.withArgs(getVaccinationOrderDetailCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderDetailModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getWarehouseInitialStockCollectionModels, jasmine.any(String)).and.returnValue(warehouseInitialStockModelsBehaviorSubject)
			.withArgs(getWarehouseInventoryCollectionModels, jasmine.any(String)).and.returnValue(warehouseInventoryModelsBehaviorSubject)
			.withArgs(getWarehouseModelWithId, inventoryBatchCorrectionWithId.warehouseId).and.returnValue(warehouseWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				InventoryBatchCorrectionCrudModule,
				CommonComponentModule,
				FormsModule,
				ReactiveFormsModule,
			],
			providers: [
				provideMockStore(),
				{
					provide: ActivatedRoute,
					useValue: activatedRouteStub,
				},
				CookieService,
				ModalDialogService,
				ModalDialogInstanceService,
			]
		}).compileComponents().then(() => {

			spySelectorsInStore();

			fixture = TestBed.createComponent(InventoryBatchCorrectionCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new InventoryBatchCorrectionModel();
			component.createReactiveForm();
			fixture.detectChanges();


		});
	}));

	afterEach(() => {
		// Need to do this since for some reason the last component queried from the fixture will be rendered on the
		// browser
		if (fixture.nativeElement instanceof HTMLElement) {
			(fixture.nativeElement as HTMLElement).remove();
		}
		component.ngOnDestroy();
	});

	/**
	 * Checks that the component is created by the test initialisation
	 */
	it ('Renders the Inventory Batch Correction CRUD Edit Component', () => {
		expect(component).toBeTruthy();
	});

	/**
	 * Checks that there are no add additional model buttons present in the component when in view mode.
	 *
	 * This test does not require checking whether multi crud is active for a given relation, as the expected outcome
	 * is identical for components with multi entity crud active and for components without it
	 */
	it ('Does not render any add entity buttons when in view mode', fakeAsync(() => {
		component.tileMode = CrudTileMode.View;
		fixture.detectChanges();

		const addEntityButtons: DebugElement[] = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'));

		expect(addEntityButtons.length).toEqual(0);
	}));

	/**
	* Checks that the status of the add model button matches the multi entity status for the Warehouse relation.
	*
	* The button should only exist if warehouseMultiCrudActive is true
	*/
	it ('Renders Warehouse Add Entity button in create mode', fakeAsync(() => {
		const warehouseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!warehouseButton).toEqual(component.warehouseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Warehouse', fakeAsync(() => {
		const warehouseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseButton).toEqual(component.warehouseMultiCrudActive);

		if (component.warehouseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialWarehouseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseDisplayName + ' from Model')).length;

			warehouseButton.nativeElement.click();
			fixture.detectChanges();

			const actualWarehouseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseDisplayName + ' from Model')).length;

			expect(actualWarehouseRemoveButtonCount).toEqual(initialWarehouseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Warehouse button', () => {
		const warehouseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseButton).toEqual(component.warehouseMultiCrudActive);

		if (component.warehouseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			warehouseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialWarehouseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialWarehouseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualWarehouseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseDisplayName + ' from Model'));

			expect(actualWarehouseRemoveButtons.length).toEqual(initialWarehouseRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Warehouse button when one has already been added', () => {

		const warehouseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseButton).toEqual(component.warehouseMultiCrudActive);

		if (component.warehouseMultiCrudActive) {
			warehouseButton.nativeElement.click();
			fixture.detectChanges();

			const updatedwarehouseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseDisplayName + ' to Model'));

			expect(updatedwarehouseButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Warehouse entities from model when loading in edit mode', () => {
		component.targetModel = inventoryBatchCorrectionWithId;
		component.targetModelId = inventoryBatchCorrectionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.warehouseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const warehouseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseDisplayName + ' from Model')).length;

			expect(warehouseRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Inventory Batch Correction Items relation.
	*
	* The button should only exist if inventoryBatchCorrectionItemsMultiCrudActive is true
	*/
	it ('Renders Inventory Batch Correction Items Add Entity button in create mode', fakeAsync(() => {
		const inventoryBatchCorrectionItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!inventoryBatchCorrectionItemsButton).toEqual(component.inventoryBatchCorrectionItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Inventory Batch Correction Items', fakeAsync(() => {
		const inventoryBatchCorrectionItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryBatchCorrectionItemsButton).toEqual(component.inventoryBatchCorrectionItemsMultiCrudActive);

		if (component.inventoryBatchCorrectionItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInventoryBatchCorrectionItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionItemsDisplayName + ' from Model')).length;

			inventoryBatchCorrectionItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInventoryBatchCorrectionItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionItemsDisplayName + ' from Model')).length;

			expect(actualInventoryBatchCorrectionItemsRemoveButtonCount).toEqual(initialInventoryBatchCorrectionItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Inventory Batch Correction Items button', () => {
		const inventoryBatchCorrectionItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryBatchCorrectionItemsButton).toEqual(component.inventoryBatchCorrectionItemsMultiCrudActive);

		if (component.inventoryBatchCorrectionItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			inventoryBatchCorrectionItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInventoryBatchCorrectionItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInventoryBatchCorrectionItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInventoryBatchCorrectionItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionItemsDisplayName + ' from Model'));

			expect(actualInventoryBatchCorrectionItemsRemoveButtons.length).toEqual(initialInventoryBatchCorrectionItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Inventory Batch Correction Items button when one has already been added', () => {

		const inventoryBatchCorrectionItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryBatchCorrectionItemsButton).toEqual(component.inventoryBatchCorrectionItemsMultiCrudActive);

		if (component.inventoryBatchCorrectionItemsMultiCrudActive) {
			inventoryBatchCorrectionItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinventoryBatchCorrectionItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionItemsDisplayName + ' to Model'));

			expect(updatedinventoryBatchCorrectionItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Inventory Batch Correction Items entities from model when loading in edit mode', () => {
		component.targetModel = inventoryBatchCorrectionWithId;
		component.targetModelId = inventoryBatchCorrectionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.inventoryBatchCorrectionItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const inventoryBatchCorrectionItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionItemsDisplayName + ' from Model')).length;

			expect(inventoryBatchCorrectionItemsRemoveButtonCount).toEqual(inventoryBatchCorrectionWithId.inventoryBatchCorrectionItems.length);
		}
	});

});
