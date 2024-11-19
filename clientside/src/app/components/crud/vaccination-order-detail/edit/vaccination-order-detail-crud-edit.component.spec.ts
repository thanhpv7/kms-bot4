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
	getVaccinationOrderDetailCollectionModels,
	getCountVaccinationOrderDetailModels,
	getVaccinationOrderDetailModelWithId
} from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import { VaccinationOrderDetailCrudModule } from '../vaccination-order-detail-crud.module';
import { VaccinationOrderDetailCrudEditComponent } from './vaccination-order-detail-crud-edit.component';
import {
	VaccinationOrderDetailModelState,
	initialState as initialVaccinationOrderDetailModelState
} from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.state';
import { VaccinationOrderDetailDataFactory } from 'src/app/lib/utils/factories/vaccination-order-detail-data-factory';
import { VaccinationOrderDetailModel } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model';
import { CrudTileMode } from '../vaccination-order-detail-crud.component';
import { getBpjsDrugGenericPRBModelWithId } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.selector';
import { getBpjsDrugGenericPRBCollectionModels } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.selector';
import { BpjsDrugGenericPRBModel } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model';
import { BpjsDrugGenericPRBDataFactory } from 'src/app/lib/utils/factories/bpjs-drug-generic-prb-data-factory';
import { getBpjsPcareDPHOModelWithId } from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model.selector';
import { getBpjsPcareDPHOCollectionModels } from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model.selector';
import { BpjsPcareDPHOModel } from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model';
import { BpjsPcareDPHODataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-dpho-data-factory';
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
import { getCatalogueMedicalModelWithId } from 'src/app/models/catalogueMedical/catalogue_medical.model.selector';
import { getCatalogueMedicalCollectionModels } from 'src/app/models/catalogueMedical/catalogue_medical.model.selector';
import { CatalogueMedicalModel } from 'src/app/models/catalogueMedical/catalogue_medical.model';
import { CatalogueMedicalDataFactory } from 'src/app/lib/utils/factories/catalogue-medical-data-factory';
import { getCatalogueNonMedicalModelWithId } from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model.selector';
import { getCatalogueNonMedicalCollectionModels } from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model.selector';
import { CatalogueNonMedicalModel } from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model';
import { CatalogueNonMedicalDataFactory } from 'src/app/lib/utils/factories/catalogue-non-medical-data-factory';
import { getCatalogueUOMModelWithId } from 'src/app/models/catalogueUOM/catalogue_uom.model.selector';
import { getCatalogueUOMCollectionModels } from 'src/app/models/catalogueUOM/catalogue_uom.model.selector';
import { CatalogueUOMModel } from 'src/app/models/catalogueUOM/catalogue_uom.model';
import { CatalogueUOMDataFactory } from 'src/app/lib/utils/factories/catalogue-uom-data-factory';
import { getCompoundPrescriptionItemModelWithId } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.selector';
import { getCompoundPrescriptionItemCollectionModels } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.selector';
import { CompoundPrescriptionItemModel } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model';
import { CompoundPrescriptionItemDataFactory } from 'src/app/lib/utils/factories/compound-prescription-item-data-factory';
import { getGoodsReceiveNoteModelWithId } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import { getGoodsReceiveNoteCollectionModels } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import { GoodsReceiveNoteModel } from 'src/app/models/goodsReceiveNote/goods_receive_note.model';
import { GoodsReceiveNoteDataFactory } from 'src/app/lib/utils/factories/goods-receive-note-data-factory';
import { getGoodsReceiveNoteBatchModelWithId } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.selector';
import { getGoodsReceiveNoteBatchCollectionModels } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.selector';
import { GoodsReceiveNoteBatchModel } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model';
import { GoodsReceiveNoteBatchDataFactory } from 'src/app/lib/utils/factories/goods-receive-note-batch-data-factory';
import { getGoodsReceiveNoteItemModelWithId } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model.selector';
import { getGoodsReceiveNoteItemCollectionModels } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model.selector';
import { GoodsReceiveNoteItemModel } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model';
import { GoodsReceiveNoteItemDataFactory } from 'src/app/lib/utils/factories/goods-receive-note-item-data-factory';
import { getInternalOrderModelWithId } from 'src/app/models/internalOrder/internal_order.model.selector';
import { getInternalOrderCollectionModels } from 'src/app/models/internalOrder/internal_order.model.selector';
import { InternalOrderModel } from 'src/app/models/internalOrder/internal_order.model';
import { InternalOrderDataFactory } from 'src/app/lib/utils/factories/internal-order-data-factory';
import { getInternalOrderStockDetailModelWithId } from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model.selector';
import { getInternalOrderStockDetailCollectionModels } from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model.selector';
import { InternalOrderStockDetailModel } from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model';
import { InternalOrderStockDetailDataFactory } from 'src/app/lib/utils/factories/internal-order-stock-detail-data-factory';
import { getInventoryAdjusmentBatchModelWithId } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.selector';
import { getInventoryAdjusmentBatchCollectionModels } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.selector';
import { InventoryAdjusmentBatchModel } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import { InventoryAdjusmentBatchDataFactory } from 'src/app/lib/utils/factories/inventory-adjusment-batch-data-factory';
import { getInventoryAdjustmentModelWithId } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.selector';
import { getInventoryAdjustmentCollectionModels } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.selector';
import { InventoryAdjustmentModel } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model';
import { InventoryAdjustmentDataFactory } from 'src/app/lib/utils/factories/inventory-adjustment-data-factory';
import { getInventoryAdjustmentItemModelWithId } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model.selector';
import { getInventoryAdjustmentItemCollectionModels } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model.selector';
import { InventoryAdjustmentItemModel } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model';
import { InventoryAdjustmentItemDataFactory } from 'src/app/lib/utils/factories/inventory-adjustment-item-data-factory';
import { getInventoryBatchCorrectionModelWithId } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.selector';
import { getInventoryBatchCorrectionCollectionModels } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.selector';
import { InventoryBatchCorrectionModel } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model';
import { InventoryBatchCorrectionDataFactory } from 'src/app/lib/utils/factories/inventory-batch-correction-data-factory';
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
import { getMedicationItemModelWithId } from 'src/app/models/medicationItem/medication_item.model.selector';
import { getMedicationItemCollectionModels } from 'src/app/models/medicationItem/medication_item.model.selector';
import { MedicationItemModel } from 'src/app/models/medicationItem/medication_item.model';
import { MedicationItemDataFactory } from 'src/app/lib/utils/factories/medication-item-data-factory';
import { getPrescriptionHeaderModelWithId } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderDataFactory } from 'src/app/lib/utils/factories/prescription-header-data-factory';
import { getPrescriptionItemModelWithId } from 'src/app/models/prescriptionItem/prescription_item.model.selector';
import { getPrescriptionItemCollectionModels } from 'src/app/models/prescriptionItem/prescription_item.model.selector';
import { PrescriptionItemModel } from 'src/app/models/prescriptionItem/prescription_item.model';
import { PrescriptionItemDataFactory } from 'src/app/lib/utils/factories/prescription-item-data-factory';
import { getPurchaseOrderModelWithId } from 'src/app/models/purchaseOrder/purchase_order.model.selector';
import { getPurchaseOrderCollectionModels } from 'src/app/models/purchaseOrder/purchase_order.model.selector';
import { PurchaseOrderModel } from 'src/app/models/purchaseOrder/purchase_order.model';
import { PurchaseOrderDataFactory } from 'src/app/lib/utils/factories/purchase-order-data-factory';
import { getPurchaseOrderStockDetailModelWithId } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model.selector';
import { getPurchaseOrderStockDetailCollectionModels } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model.selector';
import { PurchaseOrderStockDetailModel } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model';
import { PurchaseOrderStockDetailDataFactory } from 'src/app/lib/utils/factories/purchase-order-stock-detail-data-factory';
import { getPurchaseRequisitionModelWithId } from 'src/app/models/purchaseRequisition/purchase_requisition.model.selector';
import { getPurchaseRequisitionCollectionModels } from 'src/app/models/purchaseRequisition/purchase_requisition.model.selector';
import { PurchaseRequisitionModel } from 'src/app/models/purchaseRequisition/purchase_requisition.model';
import { PurchaseRequisitionDataFactory } from 'src/app/lib/utils/factories/purchase-requisition-data-factory';
import { getPurchaseRequisitionStockDetailModelWithId } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.selector';
import { getPurchaseRequisitionStockDetailCollectionModels } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.selector';
import { PurchaseRequisitionStockDetailModel } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model';
import { PurchaseRequisitionStockDetailDataFactory } from 'src/app/lib/utils/factories/purchase-requisition-stock-detail-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getRetailPharmacyModelWithId } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { getRetailPharmacyCollectionModels } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { RetailPharmacyModel } from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import { RetailPharmacyDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-data-factory';
import { getRetailPharmacyStockDetailModelWithId } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.selector';
import { getRetailPharmacyStockDetailCollectionModels } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.selector';
import { RetailPharmacyStockDetailModel } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model';
import { RetailPharmacyStockDetailDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-stock-detail-data-factory';
import { getReturnSupplierModelWithId } from 'src/app/models/returnSupplier/return_supplier.model.selector';
import { getReturnSupplierCollectionModels } from 'src/app/models/returnSupplier/return_supplier.model.selector';
import { ReturnSupplierModel } from 'src/app/models/returnSupplier/return_supplier.model';
import { ReturnSupplierDataFactory } from 'src/app/lib/utils/factories/return-supplier-data-factory';
import { getReturnSupplierStockDetailModelWithId } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model.selector';
import { getReturnSupplierStockDetailCollectionModels } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model.selector';
import { ReturnSupplierStockDetailModel } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model';
import { ReturnSupplierStockDetailDataFactory } from 'src/app/lib/utils/factories/return-supplier-stock-detail-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
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
import { getSupplierProductDetailModelWithId } from 'src/app/models/supplierProductDetail/supplier_product_detail.model.selector';
import { getSupplierProductDetailCollectionModels } from 'src/app/models/supplierProductDetail/supplier_product_detail.model.selector';
import { SupplierProductDetailModel } from 'src/app/models/supplierProductDetail/supplier_product_detail.model';
import { SupplierProductDetailDataFactory } from 'src/app/lib/utils/factories/supplier-product-detail-data-factory';
import { getTransferOrderModelWithId } from 'src/app/models/transferOrder/transfer_order.model.selector';
import { getTransferOrderCollectionModels } from 'src/app/models/transferOrder/transfer_order.model.selector';
import { TransferOrderModel } from 'src/app/models/transferOrder/transfer_order.model';
import { TransferOrderDataFactory } from 'src/app/lib/utils/factories/transfer-order-data-factory';
import { getTransferOrderStockDetailModelWithId } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.selector';
import { getTransferOrderStockDetailCollectionModels } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.selector';
import { TransferOrderStockDetailModel } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model';
import { TransferOrderStockDetailDataFactory } from 'src/app/lib/utils/factories/transfer-order-stock-detail-data-factory';
import { getVaccinationOrderModelWithId } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { getVaccinationOrderCollectionModels } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { VaccinationOrderModel } from 'src/app/models/vaccinationOrder/vaccination_order.model';
import { VaccinationOrderDataFactory } from 'src/app/lib/utils/factories/vaccination-order-data-factory';
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

describe('Vaccination Order Detail CRUD Edit component tests', () => {
	let fixture: ComponentFixture<VaccinationOrderDetailCrudEditComponent>
	let component: VaccinationOrderDetailCrudEditComponent;

	let vaccinationOrderDetailModelState: VaccinationOrderDetailModelState;

	let store: MockStore<{ model: VaccinationOrderDetailModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let vaccinationOrderDetailCountBehaviorSubject: BehaviorSubject<number>;
	let vaccinationOrderDetailModelsBehaviorSubject: BehaviorSubject<VaccinationOrderDetailModel[]>;
	let bpjsDrugGenericPRBModelsBehaviorSubject: BehaviorSubject<BpjsDrugGenericPRBModel[]>;
	let bpjsPcareDPHOModelsBehaviorSubject: BehaviorSubject<BpjsPcareDPHOModel[]>;
	let batchStockBalanceModelsBehaviorSubject: BehaviorSubject<BatchStockBalanceModel[]>;
	let batchStockBalancePerDateModelsBehaviorSubject: BehaviorSubject<BatchStockBalancePerDateModel[]>;
	let batchStockTransactionDetailModelsBehaviorSubject: BehaviorSubject<BatchStockTransactionDetailModel[]>;
	let catalogueMedicalModelsBehaviorSubject: BehaviorSubject<CatalogueMedicalModel[]>;
	let catalogueNonMedicalModelsBehaviorSubject: BehaviorSubject<CatalogueNonMedicalModel[]>;
	let catalogueUOMModelsBehaviorSubject: BehaviorSubject<CatalogueUOMModel[]>;
	let compoundPrescriptionItemModelsBehaviorSubject: BehaviorSubject<CompoundPrescriptionItemModel[]>;
	let goodsReceiveNoteModelsBehaviorSubject: BehaviorSubject<GoodsReceiveNoteModel[]>;
	let goodsReceiveNoteBatchModelsBehaviorSubject: BehaviorSubject<GoodsReceiveNoteBatchModel[]>;
	let goodsReceiveNoteItemModelsBehaviorSubject: BehaviorSubject<GoodsReceiveNoteItemModel[]>;
	let internalOrderModelsBehaviorSubject: BehaviorSubject<InternalOrderModel[]>;
	let internalOrderStockDetailModelsBehaviorSubject: BehaviorSubject<InternalOrderStockDetailModel[]>;
	let inventoryAdjusmentBatchModelsBehaviorSubject: BehaviorSubject<InventoryAdjusmentBatchModel[]>;
	let inventoryAdjustmentModelsBehaviorSubject: BehaviorSubject<InventoryAdjustmentModel[]>;
	let inventoryAdjustmentItemModelsBehaviorSubject: BehaviorSubject<InventoryAdjustmentItemModel[]>;
	let inventoryBatchCorrectionModelsBehaviorSubject: BehaviorSubject<InventoryBatchCorrectionModel[]>;
	let inventoryBatchCorrectionItemModelsBehaviorSubject: BehaviorSubject<InventoryBatchCorrectionItemModel[]>;
	let locationModelsBehaviorSubject: BehaviorSubject<LocationModel[]>;
	let medicalFeeModelsBehaviorSubject: BehaviorSubject<MedicalFeeModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let medicationItemModelsBehaviorSubject: BehaviorSubject<MedicationItemModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let prescriptionItemModelsBehaviorSubject: BehaviorSubject<PrescriptionItemModel[]>;
	let purchaseOrderModelsBehaviorSubject: BehaviorSubject<PurchaseOrderModel[]>;
	let purchaseOrderStockDetailModelsBehaviorSubject: BehaviorSubject<PurchaseOrderStockDetailModel[]>;
	let purchaseRequisitionModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionModel[]>;
	let purchaseRequisitionStockDetailModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionStockDetailModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let retailPharmacyModelsBehaviorSubject: BehaviorSubject<RetailPharmacyModel[]>;
	let retailPharmacyStockDetailModelsBehaviorSubject: BehaviorSubject<RetailPharmacyStockDetailModel[]>;
	let returnSupplierModelsBehaviorSubject: BehaviorSubject<ReturnSupplierModel[]>;
	let returnSupplierStockDetailModelsBehaviorSubject: BehaviorSubject<ReturnSupplierStockDetailModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let stockCatalogueModelsBehaviorSubject: BehaviorSubject<StockCatalogueModel[]>;
	let stockControlModelsBehaviorSubject: BehaviorSubject<StockControlModel[]>;
	let stockTransactionDetailModelsBehaviorSubject: BehaviorSubject<StockTransactionDetailModel[]>;
	let stockTransactionPerDateModelsBehaviorSubject: BehaviorSubject<StockTransactionPerDateModel[]>;
	let stockTransactionPerDateTypeModelsBehaviorSubject: BehaviorSubject<StockTransactionPerDateTypeModel[]>;
	let supplierProductDetailModelsBehaviorSubject: BehaviorSubject<SupplierProductDetailModel[]>;
	let transferOrderModelsBehaviorSubject: BehaviorSubject<TransferOrderModel[]>;
	let transferOrderStockDetailModelsBehaviorSubject: BehaviorSubject<TransferOrderStockDetailModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;
	let warehouseInitialStockModelsBehaviorSubject: BehaviorSubject<WarehouseInitialStockModel[]>;
	let warehouseInventoryModelsBehaviorSubject: BehaviorSubject<WarehouseInventoryModel[]>;

	const vaccinationOrderDetailFactory: VaccinationOrderDetailDataFactory = new VaccinationOrderDetailDataFactory();
	const defaultVaccinationOrderDetailCount: number = 10;
	const defaultVaccinationOrderDetailEntities: VaccinationOrderDetailModel[] = vaccinationOrderDetailFactory.createAll(defaultVaccinationOrderDetailCount);

	const bpjsDrugGenericPRBFactory: BpjsDrugGenericPRBDataFactory = new BpjsDrugGenericPRBDataFactory();
	const defaultBpjsDrugGenericPRBCount: number = 10;
	const defaultBpjsDrugGenericPRBEntities: BpjsDrugGenericPRBModel[] = bpjsDrugGenericPRBFactory.createAll(defaultBpjsDrugGenericPRBCount);

	const bpjsPcareDPHOFactory: BpjsPcareDPHODataFactory = new BpjsPcareDPHODataFactory();
	const defaultBpjsPcareDPHOCount: number = 10;
	const defaultBpjsPcareDPHOEntities: BpjsPcareDPHOModel[] = bpjsPcareDPHOFactory.createAll(defaultBpjsPcareDPHOCount);

	const batchStockBalanceFactory: BatchStockBalanceDataFactory = new BatchStockBalanceDataFactory();
	const defaultBatchStockBalanceCount: number = 10;
	const defaultBatchStockBalanceEntities: BatchStockBalanceModel[] = batchStockBalanceFactory.createAll(defaultBatchStockBalanceCount);

	const batchStockBalancePerDateFactory: BatchStockBalancePerDateDataFactory = new BatchStockBalancePerDateDataFactory();
	const defaultBatchStockBalancePerDateCount: number = 10;
	const defaultBatchStockBalancePerDateEntities: BatchStockBalancePerDateModel[] = batchStockBalancePerDateFactory.createAll(defaultBatchStockBalancePerDateCount);

	const batchStockTransactionDetailFactory: BatchStockTransactionDetailDataFactory = new BatchStockTransactionDetailDataFactory();
	const defaultBatchStockTransactionDetailCount: number = 10;
	const defaultBatchStockTransactionDetailEntities: BatchStockTransactionDetailModel[] = batchStockTransactionDetailFactory.createAll(defaultBatchStockTransactionDetailCount);

	const catalogueMedicalFactory: CatalogueMedicalDataFactory = new CatalogueMedicalDataFactory();
	const defaultCatalogueMedicalCount: number = 10;
	const defaultCatalogueMedicalEntities: CatalogueMedicalModel[] = catalogueMedicalFactory.createAll(defaultCatalogueMedicalCount);

	const catalogueNonMedicalFactory: CatalogueNonMedicalDataFactory = new CatalogueNonMedicalDataFactory();
	const defaultCatalogueNonMedicalCount: number = 10;
	const defaultCatalogueNonMedicalEntities: CatalogueNonMedicalModel[] = catalogueNonMedicalFactory.createAll(defaultCatalogueNonMedicalCount);

	const catalogueUOMFactory: CatalogueUOMDataFactory = new CatalogueUOMDataFactory();
	const defaultCatalogueUOMCount: number = 10;
	const defaultCatalogueUOMEntities: CatalogueUOMModel[] = catalogueUOMFactory.createAll(defaultCatalogueUOMCount);

	const compoundPrescriptionItemFactory: CompoundPrescriptionItemDataFactory = new CompoundPrescriptionItemDataFactory();
	const defaultCompoundPrescriptionItemCount: number = 10;
	const defaultCompoundPrescriptionItemEntities: CompoundPrescriptionItemModel[] = compoundPrescriptionItemFactory.createAll(defaultCompoundPrescriptionItemCount);

	const goodsReceiveNoteFactory: GoodsReceiveNoteDataFactory = new GoodsReceiveNoteDataFactory();
	const defaultGoodsReceiveNoteCount: number = 10;
	const defaultGoodsReceiveNoteEntities: GoodsReceiveNoteModel[] = goodsReceiveNoteFactory.createAll(defaultGoodsReceiveNoteCount);

	const goodsReceiveNoteBatchFactory: GoodsReceiveNoteBatchDataFactory = new GoodsReceiveNoteBatchDataFactory();
	const defaultGoodsReceiveNoteBatchCount: number = 10;
	const defaultGoodsReceiveNoteBatchEntities: GoodsReceiveNoteBatchModel[] = goodsReceiveNoteBatchFactory.createAll(defaultGoodsReceiveNoteBatchCount);

	const goodsReceiveNoteItemFactory: GoodsReceiveNoteItemDataFactory = new GoodsReceiveNoteItemDataFactory();
	const defaultGoodsReceiveNoteItemCount: number = 10;
	const defaultGoodsReceiveNoteItemEntities: GoodsReceiveNoteItemModel[] = goodsReceiveNoteItemFactory.createAll(defaultGoodsReceiveNoteItemCount);

	const internalOrderFactory: InternalOrderDataFactory = new InternalOrderDataFactory();
	const defaultInternalOrderCount: number = 10;
	const defaultInternalOrderEntities: InternalOrderModel[] = internalOrderFactory.createAll(defaultInternalOrderCount);

	const internalOrderStockDetailFactory: InternalOrderStockDetailDataFactory = new InternalOrderStockDetailDataFactory();
	const defaultInternalOrderStockDetailCount: number = 10;
	const defaultInternalOrderStockDetailEntities: InternalOrderStockDetailModel[] = internalOrderStockDetailFactory.createAll(defaultInternalOrderStockDetailCount);

	const inventoryAdjusmentBatchFactory: InventoryAdjusmentBatchDataFactory = new InventoryAdjusmentBatchDataFactory();
	const defaultInventoryAdjusmentBatchCount: number = 10;
	const defaultInventoryAdjusmentBatchEntities: InventoryAdjusmentBatchModel[] = inventoryAdjusmentBatchFactory.createAll(defaultInventoryAdjusmentBatchCount);

	const inventoryAdjustmentFactory: InventoryAdjustmentDataFactory = new InventoryAdjustmentDataFactory();
	const defaultInventoryAdjustmentCount: number = 10;
	const defaultInventoryAdjustmentEntities: InventoryAdjustmentModel[] = inventoryAdjustmentFactory.createAll(defaultInventoryAdjustmentCount);

	const inventoryAdjustmentItemFactory: InventoryAdjustmentItemDataFactory = new InventoryAdjustmentItemDataFactory();
	const defaultInventoryAdjustmentItemCount: number = 10;
	const defaultInventoryAdjustmentItemEntities: InventoryAdjustmentItemModel[] = inventoryAdjustmentItemFactory.createAll(defaultInventoryAdjustmentItemCount);

	const inventoryBatchCorrectionFactory: InventoryBatchCorrectionDataFactory = new InventoryBatchCorrectionDataFactory();
	const defaultInventoryBatchCorrectionCount: number = 10;
	const defaultInventoryBatchCorrectionEntities: InventoryBatchCorrectionModel[] = inventoryBatchCorrectionFactory.createAll(defaultInventoryBatchCorrectionCount);

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

	const medicationItemFactory: MedicationItemDataFactory = new MedicationItemDataFactory();
	const defaultMedicationItemCount: number = 10;
	const defaultMedicationItemEntities: MedicationItemModel[] = medicationItemFactory.createAll(defaultMedicationItemCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const prescriptionItemFactory: PrescriptionItemDataFactory = new PrescriptionItemDataFactory();
	const defaultPrescriptionItemCount: number = 10;
	const defaultPrescriptionItemEntities: PrescriptionItemModel[] = prescriptionItemFactory.createAll(defaultPrescriptionItemCount);

	const purchaseOrderFactory: PurchaseOrderDataFactory = new PurchaseOrderDataFactory();
	const defaultPurchaseOrderCount: number = 10;
	const defaultPurchaseOrderEntities: PurchaseOrderModel[] = purchaseOrderFactory.createAll(defaultPurchaseOrderCount);

	const purchaseOrderStockDetailFactory: PurchaseOrderStockDetailDataFactory = new PurchaseOrderStockDetailDataFactory();
	const defaultPurchaseOrderStockDetailCount: number = 10;
	const defaultPurchaseOrderStockDetailEntities: PurchaseOrderStockDetailModel[] = purchaseOrderStockDetailFactory.createAll(defaultPurchaseOrderStockDetailCount);

	const purchaseRequisitionFactory: PurchaseRequisitionDataFactory = new PurchaseRequisitionDataFactory();
	const defaultPurchaseRequisitionCount: number = 10;
	const defaultPurchaseRequisitionEntities: PurchaseRequisitionModel[] = purchaseRequisitionFactory.createAll(defaultPurchaseRequisitionCount);

	const purchaseRequisitionStockDetailFactory: PurchaseRequisitionStockDetailDataFactory = new PurchaseRequisitionStockDetailDataFactory();
	const defaultPurchaseRequisitionStockDetailCount: number = 10;
	const defaultPurchaseRequisitionStockDetailEntities: PurchaseRequisitionStockDetailModel[] = purchaseRequisitionStockDetailFactory.createAll(defaultPurchaseRequisitionStockDetailCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const retailPharmacyFactory: RetailPharmacyDataFactory = new RetailPharmacyDataFactory();
	const defaultRetailPharmacyCount: number = 10;
	const defaultRetailPharmacyEntities: RetailPharmacyModel[] = retailPharmacyFactory.createAll(defaultRetailPharmacyCount);

	const retailPharmacyStockDetailFactory: RetailPharmacyStockDetailDataFactory = new RetailPharmacyStockDetailDataFactory();
	const defaultRetailPharmacyStockDetailCount: number = 10;
	const defaultRetailPharmacyStockDetailEntities: RetailPharmacyStockDetailModel[] = retailPharmacyStockDetailFactory.createAll(defaultRetailPharmacyStockDetailCount);

	const returnSupplierFactory: ReturnSupplierDataFactory = new ReturnSupplierDataFactory();
	const defaultReturnSupplierCount: number = 10;
	const defaultReturnSupplierEntities: ReturnSupplierModel[] = returnSupplierFactory.createAll(defaultReturnSupplierCount);

	const returnSupplierStockDetailFactory: ReturnSupplierStockDetailDataFactory = new ReturnSupplierStockDetailDataFactory();
	const defaultReturnSupplierStockDetailCount: number = 10;
	const defaultReturnSupplierStockDetailEntities: ReturnSupplierStockDetailModel[] = returnSupplierStockDetailFactory.createAll(defaultReturnSupplierStockDetailCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

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

	const supplierProductDetailFactory: SupplierProductDetailDataFactory = new SupplierProductDetailDataFactory();
	const defaultSupplierProductDetailCount: number = 10;
	const defaultSupplierProductDetailEntities: SupplierProductDetailModel[] = supplierProductDetailFactory.createAll(defaultSupplierProductDetailCount);

	const transferOrderFactory: TransferOrderDataFactory = new TransferOrderDataFactory();
	const defaultTransferOrderCount: number = 10;
	const defaultTransferOrderEntities: TransferOrderModel[] = transferOrderFactory.createAll(defaultTransferOrderCount);

	const transferOrderStockDetailFactory: TransferOrderStockDetailDataFactory = new TransferOrderStockDetailDataFactory();
	const defaultTransferOrderStockDetailCount: number = 10;
	const defaultTransferOrderStockDetailEntities: TransferOrderStockDetailModel[] = transferOrderStockDetailFactory.createAll(defaultTransferOrderStockDetailCount);

	const vaccinationOrderFactory: VaccinationOrderDataFactory = new VaccinationOrderDataFactory();
	const defaultVaccinationOrderCount: number = 10;
	const defaultVaccinationOrderEntities: VaccinationOrderModel[] = vaccinationOrderFactory.createAll(defaultVaccinationOrderCount);

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
	let vaccinationOrderDetailWithId: VaccinationOrderDetailModel = defaultVaccinationOrderDetailEntities[0];
	let vaccinationOrderDetailModelWithIdBehaviorSubject: BehaviorSubject<VaccinationOrderDetailModel>;

	vaccinationOrderDetailWithId.stockCatalogue = defaultStockCatalogueEntities[0];
	vaccinationOrderDetailWithId.stockCatalogueId = vaccinationOrderDetailWithId.stockCatalogue.id;
	let stockCatalogueWithIdBehaviorSubject: BehaviorSubject<StockCatalogueModel>;

	vaccinationOrderDetailWithId.vaccinationOrder = defaultVaccinationOrderEntities[0];
	vaccinationOrderDetailWithId.vaccinationOrderId = vaccinationOrderDetailWithId.vaccinationOrder.id;
	let vaccinationOrderWithIdBehaviorSubject: BehaviorSubject<VaccinationOrderModel>;

	vaccinationOrderDetailWithId.warehouse = defaultWarehouseEntities[0];
	vaccinationOrderDetailWithId.warehouseId = vaccinationOrderDetailWithId.warehouse.id;
	let warehouseWithIdBehaviorSubject: BehaviorSubject<WarehouseModel>;


	const routerState: RouterState = {
		url: 'vaccination-order-detail-crud',
		urls: ['vaccination-order-detail-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: VaccinationOrderDetailModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		vaccinationOrderDetailModelState = initialVaccinationOrderDetailModelState;
		store.setState({model: vaccinationOrderDetailModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		vaccinationOrderDetailCountBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderDetailCount);

		// selectors for all references
		vaccinationOrderDetailModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderDetailEntities);
		bpjsDrugGenericPRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDrugGenericPRBEntities);
		bpjsPcareDPHOModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareDPHOEntities);
		batchStockBalanceModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockBalanceEntities);
		batchStockBalancePerDateModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockBalancePerDateEntities);
		batchStockTransactionDetailModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockTransactionDetailEntities);
		catalogueMedicalModelsBehaviorSubject = new BehaviorSubject(defaultCatalogueMedicalEntities);
		catalogueNonMedicalModelsBehaviorSubject = new BehaviorSubject(defaultCatalogueNonMedicalEntities);
		catalogueUOMModelsBehaviorSubject = new BehaviorSubject(defaultCatalogueUOMEntities);
		compoundPrescriptionItemModelsBehaviorSubject = new BehaviorSubject(defaultCompoundPrescriptionItemEntities);
		goodsReceiveNoteModelsBehaviorSubject = new BehaviorSubject(defaultGoodsReceiveNoteEntities);
		goodsReceiveNoteBatchModelsBehaviorSubject = new BehaviorSubject(defaultGoodsReceiveNoteBatchEntities);
		goodsReceiveNoteItemModelsBehaviorSubject = new BehaviorSubject(defaultGoodsReceiveNoteItemEntities);
		internalOrderModelsBehaviorSubject = new BehaviorSubject(defaultInternalOrderEntities);
		internalOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultInternalOrderStockDetailEntities);
		inventoryAdjusmentBatchModelsBehaviorSubject = new BehaviorSubject(defaultInventoryAdjusmentBatchEntities);
		inventoryAdjustmentModelsBehaviorSubject = new BehaviorSubject(defaultInventoryAdjustmentEntities);
		inventoryAdjustmentItemModelsBehaviorSubject = new BehaviorSubject(defaultInventoryAdjustmentItemEntities);
		inventoryBatchCorrectionModelsBehaviorSubject = new BehaviorSubject(defaultInventoryBatchCorrectionEntities);
		inventoryBatchCorrectionItemModelsBehaviorSubject = new BehaviorSubject(defaultInventoryBatchCorrectionItemEntities);
		locationModelsBehaviorSubject = new BehaviorSubject(defaultLocationEntities);
		medicalFeeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		medicationItemModelsBehaviorSubject = new BehaviorSubject(defaultMedicationItemEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		prescriptionItemModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionItemEntities);
		purchaseOrderModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderEntities);
		purchaseOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderStockDetailEntities);
		purchaseRequisitionModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionEntities);
		purchaseRequisitionStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionStockDetailEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		retailPharmacyModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyEntities);
		retailPharmacyStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyStockDetailEntities);
		returnSupplierModelsBehaviorSubject = new BehaviorSubject(defaultReturnSupplierEntities);
		returnSupplierStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultReturnSupplierStockDetailEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		stockCatalogueModelsBehaviorSubject = new BehaviorSubject(defaultStockCatalogueEntities);
		stockControlModelsBehaviorSubject = new BehaviorSubject(defaultStockControlEntities);
		stockTransactionDetailModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionDetailEntities);
		stockTransactionPerDateModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionPerDateEntities);
		stockTransactionPerDateTypeModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionPerDateTypeEntities);
		supplierProductDetailModelsBehaviorSubject = new BehaviorSubject(defaultSupplierProductDetailEntities);
		transferOrderModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderEntities);
		transferOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderStockDetailEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);
		warehouseInitialStockModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseInitialStockEntities);
		warehouseInventoryModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseInventoryEntities);

		// selectors for target entity and its related entity
		vaccinationOrderDetailModelWithIdBehaviorSubject = new BehaviorSubject(vaccinationOrderDetailWithId);
		stockCatalogueWithIdBehaviorSubject = new BehaviorSubject(vaccinationOrderDetailWithId.stockCatalogue);
		vaccinationOrderWithIdBehaviorSubject = new BehaviorSubject(vaccinationOrderDetailWithId.vaccinationOrder);
		warehouseWithIdBehaviorSubject = new BehaviorSubject(vaccinationOrderDetailWithId.warehouse);

		spyOn(store, 'select')
			.withArgs(getCountVaccinationOrderDetailModels).and.returnValue(vaccinationOrderDetailCountBehaviorSubject)
			.withArgs(getVaccinationOrderDetailModelWithId, vaccinationOrderDetailWithId.id).and.returnValue(vaccinationOrderDetailModelWithIdBehaviorSubject)
			.withArgs(getVaccinationOrderDetailCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderDetailModelsBehaviorSubject)
			.withArgs(getBpjsDrugGenericPRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsDrugGenericPRBModelsBehaviorSubject)
			.withArgs(getBpjsPcareDPHOCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareDPHOModelsBehaviorSubject)
			.withArgs(getBatchStockBalanceCollectionModels, jasmine.any(String)).and.returnValue(batchStockBalanceModelsBehaviorSubject)
			.withArgs(getBatchStockBalancePerDateCollectionModels, jasmine.any(String)).and.returnValue(batchStockBalancePerDateModelsBehaviorSubject)
			.withArgs(getBatchStockTransactionDetailCollectionModels, jasmine.any(String)).and.returnValue(batchStockTransactionDetailModelsBehaviorSubject)
			.withArgs(getCatalogueMedicalCollectionModels, jasmine.any(String)).and.returnValue(catalogueMedicalModelsBehaviorSubject)
			.withArgs(getCatalogueNonMedicalCollectionModels, jasmine.any(String)).and.returnValue(catalogueNonMedicalModelsBehaviorSubject)
			.withArgs(getCatalogueUOMCollectionModels, jasmine.any(String)).and.returnValue(catalogueUOMModelsBehaviorSubject)
			.withArgs(getCompoundPrescriptionItemCollectionModels, jasmine.any(String)).and.returnValue(compoundPrescriptionItemModelsBehaviorSubject)
			.withArgs(getGoodsReceiveNoteCollectionModels, jasmine.any(String)).and.returnValue(goodsReceiveNoteModelsBehaviorSubject)
			.withArgs(getGoodsReceiveNoteBatchCollectionModels, jasmine.any(String)).and.returnValue(goodsReceiveNoteBatchModelsBehaviorSubject)
			.withArgs(getGoodsReceiveNoteItemCollectionModels, jasmine.any(String)).and.returnValue(goodsReceiveNoteItemModelsBehaviorSubject)
			.withArgs(getInternalOrderCollectionModels, jasmine.any(String)).and.returnValue(internalOrderModelsBehaviorSubject)
			.withArgs(getInternalOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(internalOrderStockDetailModelsBehaviorSubject)
			.withArgs(getInventoryAdjusmentBatchCollectionModels, jasmine.any(String)).and.returnValue(inventoryAdjusmentBatchModelsBehaviorSubject)
			.withArgs(getInventoryAdjustmentCollectionModels, jasmine.any(String)).and.returnValue(inventoryAdjustmentModelsBehaviorSubject)
			.withArgs(getInventoryAdjustmentItemCollectionModels, jasmine.any(String)).and.returnValue(inventoryAdjustmentItemModelsBehaviorSubject)
			.withArgs(getInventoryBatchCorrectionCollectionModels, jasmine.any(String)).and.returnValue(inventoryBatchCorrectionModelsBehaviorSubject)
			.withArgs(getInventoryBatchCorrectionItemCollectionModels, jasmine.any(String)).and.returnValue(inventoryBatchCorrectionItemModelsBehaviorSubject)
			.withArgs(getLocationCollectionModels, jasmine.any(String)).and.returnValue(locationModelsBehaviorSubject)
			.withArgs(getMedicalFeeCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getMedicationItemCollectionModels, jasmine.any(String)).and.returnValue(medicationItemModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getPrescriptionItemCollectionModels, jasmine.any(String)).and.returnValue(prescriptionItemModelsBehaviorSubject)
			.withArgs(getPurchaseOrderCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderModelsBehaviorSubject)
			.withArgs(getPurchaseOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderStockDetailModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionStockDetailCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionStockDetailModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRetailPharmacyCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyModelsBehaviorSubject)
			.withArgs(getRetailPharmacyStockDetailCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyStockDetailModelsBehaviorSubject)
			.withArgs(getReturnSupplierCollectionModels, jasmine.any(String)).and.returnValue(returnSupplierModelsBehaviorSubject)
			.withArgs(getReturnSupplierStockDetailCollectionModels, jasmine.any(String)).and.returnValue(returnSupplierStockDetailModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getStockCatalogueCollectionModels, jasmine.any(String)).and.returnValue(stockCatalogueModelsBehaviorSubject)
			.withArgs(getStockControlCollectionModels, jasmine.any(String)).and.returnValue(stockControlModelsBehaviorSubject)
			.withArgs(getStockTransactionDetailCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionDetailModelsBehaviorSubject)
			.withArgs(getStockTransactionPerDateCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionPerDateModelsBehaviorSubject)
			.withArgs(getStockTransactionPerDateTypeCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionPerDateTypeModelsBehaviorSubject)
			.withArgs(getSupplierProductDetailCollectionModels, jasmine.any(String)).and.returnValue(supplierProductDetailModelsBehaviorSubject)
			.withArgs(getTransferOrderCollectionModels, jasmine.any(String)).and.returnValue(transferOrderModelsBehaviorSubject)
			.withArgs(getTransferOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(transferOrderStockDetailModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getWarehouseInitialStockCollectionModels, jasmine.any(String)).and.returnValue(warehouseInitialStockModelsBehaviorSubject)
			.withArgs(getWarehouseInventoryCollectionModels, jasmine.any(String)).and.returnValue(warehouseInventoryModelsBehaviorSubject)
			.withArgs(getStockCatalogueModelWithId, vaccinationOrderDetailWithId.stockCatalogueId).and.returnValue(stockCatalogueWithIdBehaviorSubject)
			.withArgs(getVaccinationOrderModelWithId, vaccinationOrderDetailWithId.vaccinationOrderId).and.returnValue(vaccinationOrderWithIdBehaviorSubject)
			.withArgs(getWarehouseModelWithId, vaccinationOrderDetailWithId.warehouseId).and.returnValue(warehouseWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				VaccinationOrderDetailCrudModule,
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

			fixture = TestBed.createComponent(VaccinationOrderDetailCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new VaccinationOrderDetailModel();
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
	it ('Renders the Vaccination Order Detail CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Stock Catalogue relation.
	*
	* The button should only exist if stockCatalogueMultiCrudActive is true
	*/
	it ('Renders Stock Catalogue Add Entity button in create mode', fakeAsync(() => {
		const stockCatalogueButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockCatalogueButton).toEqual(component.stockCatalogueMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Catalogue', fakeAsync(() => {
		const stockCatalogueButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCatalogueButton).toEqual(component.stockCatalogueMultiCrudActive);

		if (component.stockCatalogueMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockCatalogueRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueDisplayName + ' from Model')).length;

			stockCatalogueButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockCatalogueRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueDisplayName + ' from Model')).length;

			expect(actualStockCatalogueRemoveButtonCount).toEqual(initialStockCatalogueRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Catalogue button', () => {
		const stockCatalogueButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCatalogueButton).toEqual(component.stockCatalogueMultiCrudActive);

		if (component.stockCatalogueMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockCatalogueButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockCatalogueRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockCatalogueRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockCatalogueRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueDisplayName + ' from Model'));

			expect(actualStockCatalogueRemoveButtons.length).toEqual(initialStockCatalogueRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Stock Catalogue button when one has already been added', () => {

		const stockCatalogueButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCatalogueButton).toEqual(component.stockCatalogueMultiCrudActive);

		if (component.stockCatalogueMultiCrudActive) {
			stockCatalogueButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockCatalogueButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueDisplayName + ' to Model'));

			expect(updatedstockCatalogueButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Stock Catalogue entities from model when loading in edit mode', () => {
		component.targetModel = vaccinationOrderDetailWithId;
		component.targetModelId = vaccinationOrderDetailWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockCatalogueMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockCatalogueRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueDisplayName + ' from Model')).length;

			expect(stockCatalogueRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Vaccination Order relation.
	*
	* The button should only exist if vaccinationOrderMultiCrudActive is true
	*/
	it ('Renders Vaccination Order Add Entity button in create mode', fakeAsync(() => {
		const vaccinationOrderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!vaccinationOrderButton).toEqual(component.vaccinationOrderMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Vaccination Order', fakeAsync(() => {
		const vaccinationOrderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!vaccinationOrderButton).toEqual(component.vaccinationOrderMultiCrudActive);

		if (component.vaccinationOrderMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialVaccinationOrderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDisplayName + ' from Model')).length;

			vaccinationOrderButton.nativeElement.click();
			fixture.detectChanges();

			const actualVaccinationOrderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDisplayName + ' from Model')).length;

			expect(actualVaccinationOrderRemoveButtonCount).toEqual(initialVaccinationOrderRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Vaccination Order button', () => {
		const vaccinationOrderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!vaccinationOrderButton).toEqual(component.vaccinationOrderMultiCrudActive);

		if (component.vaccinationOrderMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			vaccinationOrderButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialVaccinationOrderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialVaccinationOrderRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualVaccinationOrderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDisplayName + ' from Model'));

			expect(actualVaccinationOrderRemoveButtons.length).toEqual(initialVaccinationOrderRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Vaccination Order button when one has already been added', () => {

		const vaccinationOrderButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!vaccinationOrderButton).toEqual(component.vaccinationOrderMultiCrudActive);

		if (component.vaccinationOrderMultiCrudActive) {
			vaccinationOrderButton.nativeElement.click();
			fixture.detectChanges();

			const updatedvaccinationOrderButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDisplayName + ' to Model'));

			expect(updatedvaccinationOrderButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Vaccination Order entities from model when loading in edit mode', () => {
		component.targetModel = vaccinationOrderDetailWithId;
		component.targetModelId = vaccinationOrderDetailWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.vaccinationOrderMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const vaccinationOrderRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDisplayName + ' from Model')).length;

			expect(vaccinationOrderRemoveButtonCount).toEqual(1);
		}
	});

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
		component.targetModel = vaccinationOrderDetailWithId;
		component.targetModelId = vaccinationOrderDetailWithId.id;
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

});
