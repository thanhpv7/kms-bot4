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
	getStockCatalogueCollectionModels,
	getCountStockCatalogueModels,
	getStockCatalogueModelWithId
} from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { StockCatalogueCrudModule } from '../stock-catalogue-crud.module';
import { StockCatalogueCrudEditComponent } from './stock-catalogue-crud-edit.component';
import {
	StockCatalogueModelState,
	initialState as initialStockCatalogueModelState
} from 'src/app/models/stockCatalogue/stock_catalogue.model.state';
import { StockCatalogueDataFactory } from 'src/app/lib/utils/factories/stock-catalogue-data-factory';
import { StockCatalogueModel } from 'src/app/models/stockCatalogue/stock_catalogue.model';
import { CrudTileMode } from '../stock-catalogue-crud.component';
import { getBpjsDrugGenericPRBModelWithId } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.selector';
import { getBpjsDrugGenericPRBCollectionModels } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.selector';
import { BpjsDrugGenericPRBModel } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model';
import { BpjsDrugGenericPRBDataFactory } from 'src/app/lib/utils/factories/bpjs-drug-generic-prb-data-factory';
import { getBpjsPRBDetailModelWithId } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { getBpjsPRBDetailCollectionModels } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { BpjsPRBDetailModel } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model';
import { BpjsPRBDetailDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-detail-data-factory';
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
import { getCompoundPrescriptionDetailModelWithId } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model.selector';
import { getCompoundPrescriptionDetailCollectionModels } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model.selector';
import { CompoundPrescriptionDetailModel } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model';
import { CompoundPrescriptionDetailDataFactory } from 'src/app/lib/utils/factories/compound-prescription-detail-data-factory';
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
import { getMedicationAdministeredHistoryModelWithId } from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model.selector';
import { getMedicationAdministeredHistoryCollectionModels } from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model.selector';
import { MedicationAdministeredHistoryModel } from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model';
import { MedicationAdministeredHistoryDataFactory } from 'src/app/lib/utils/factories/medication-administered-history-data-factory';
import { getMedicationCompoundModelWithId } from 'src/app/models/medicationCompound/medication_compound.model.selector';
import { getMedicationCompoundCollectionModels } from 'src/app/models/medicationCompound/medication_compound.model.selector';
import { MedicationCompoundModel } from 'src/app/models/medicationCompound/medication_compound.model';
import { MedicationCompoundDataFactory } from 'src/app/lib/utils/factories/medication-compound-data-factory';
import { getMedicationHeaderModelWithId } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { getMedicationHeaderCollectionModels } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { MedicationHeaderModel } from 'src/app/models/medicationHeader/medication_header.model';
import { MedicationHeaderDataFactory } from 'src/app/lib/utils/factories/medication-header-data-factory';
import { getMedicationItemModelWithId } from 'src/app/models/medicationItem/medication_item.model.selector';
import { getMedicationItemCollectionModels } from 'src/app/models/medicationItem/medication_item.model.selector';
import { MedicationItemModel } from 'src/app/models/medicationItem/medication_item.model';
import { MedicationItemDataFactory } from 'src/app/lib/utils/factories/medication-item-data-factory';
import { getPrescriptionCompoundModelWithId } from 'src/app/models/prescriptionCompound/prescription_compound.model.selector';
import { getPrescriptionCompoundCollectionModels } from 'src/app/models/prescriptionCompound/prescription_compound.model.selector';
import { PrescriptionCompoundModel } from 'src/app/models/prescriptionCompound/prescription_compound.model';
import { PrescriptionCompoundDataFactory } from 'src/app/lib/utils/factories/prescription-compound-data-factory';
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
import { getSupplierModelWithId } from 'src/app/models/supplier/supplier.model.selector';
import { getSupplierCollectionModels } from 'src/app/models/supplier/supplier.model.selector';
import { SupplierModel } from 'src/app/models/supplier/supplier.model';
import { SupplierDataFactory } from 'src/app/lib/utils/factories/supplier-data-factory';
import { getSupplierProductDetailModelWithId } from 'src/app/models/supplierProductDetail/supplier_product_detail.model.selector';
import { getSupplierProductDetailCollectionModels } from 'src/app/models/supplierProductDetail/supplier_product_detail.model.selector';
import { SupplierProductDetailModel } from 'src/app/models/supplierProductDetail/supplier_product_detail.model';
import { SupplierProductDetailDataFactory } from 'src/app/lib/utils/factories/supplier-product-detail-data-factory';
import { getTransactionDetailTypeModelWithId } from 'src/app/models/transactionDetailType/transaction_detail_type.model.selector';
import { getTransactionDetailTypeCollectionModels } from 'src/app/models/transactionDetailType/transaction_detail_type.model.selector';
import { TransactionDetailTypeModel } from 'src/app/models/transactionDetailType/transaction_detail_type.model';
import { TransactionDetailTypeDataFactory } from 'src/app/lib/utils/factories/transaction-detail-type-data-factory';
import { getTransferOrderModelWithId } from 'src/app/models/transferOrder/transfer_order.model.selector';
import { getTransferOrderCollectionModels } from 'src/app/models/transferOrder/transfer_order.model.selector';
import { TransferOrderModel } from 'src/app/models/transferOrder/transfer_order.model';
import { TransferOrderDataFactory } from 'src/app/lib/utils/factories/transfer-order-data-factory';
import { getTransferOrderStockDetailModelWithId } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.selector';
import { getTransferOrderStockDetailCollectionModels } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.selector';
import { TransferOrderStockDetailModel } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model';
import { TransferOrderStockDetailDataFactory } from 'src/app/lib/utils/factories/transfer-order-stock-detail-data-factory';
import { getUnitOfMeasurementModelWithId } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model.selector';
import { getUnitOfMeasurementCollectionModels } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model.selector';
import { UnitOfMeasurementModel } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model';
import { UnitOfMeasurementDataFactory } from 'src/app/lib/utils/factories/unit-of-measurement-data-factory';
import { getVaccinationOrderModelWithId } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { getVaccinationOrderCollectionModels } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { VaccinationOrderModel } from 'src/app/models/vaccinationOrder/vaccination_order.model';
import { VaccinationOrderDataFactory } from 'src/app/lib/utils/factories/vaccination-order-data-factory';
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

describe('Stock Catalogue CRUD Edit component tests', () => {
	let fixture: ComponentFixture<StockCatalogueCrudEditComponent>
	let component: StockCatalogueCrudEditComponent;

	let stockCatalogueModelState: StockCatalogueModelState;

	let store: MockStore<{ model: StockCatalogueModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let stockCatalogueCountBehaviorSubject: BehaviorSubject<number>;
	let stockCatalogueModelsBehaviorSubject: BehaviorSubject<StockCatalogueModel[]>;
	let bpjsDrugGenericPRBModelsBehaviorSubject: BehaviorSubject<BpjsDrugGenericPRBModel[]>;
	let bpjsPRBDetailModelsBehaviorSubject: BehaviorSubject<BpjsPRBDetailModel[]>;
	let bpjsPcareDPHOModelsBehaviorSubject: BehaviorSubject<BpjsPcareDPHOModel[]>;
	let batchStockBalanceModelsBehaviorSubject: BehaviorSubject<BatchStockBalanceModel[]>;
	let batchStockBalancePerDateModelsBehaviorSubject: BehaviorSubject<BatchStockBalancePerDateModel[]>;
	let batchStockTransactionDetailModelsBehaviorSubject: BehaviorSubject<BatchStockTransactionDetailModel[]>;
	let catalogueMedicalModelsBehaviorSubject: BehaviorSubject<CatalogueMedicalModel[]>;
	let catalogueNonMedicalModelsBehaviorSubject: BehaviorSubject<CatalogueNonMedicalModel[]>;
	let catalogueUOMModelsBehaviorSubject: BehaviorSubject<CatalogueUOMModel[]>;
	let compoundPrescriptionDetailModelsBehaviorSubject: BehaviorSubject<CompoundPrescriptionDetailModel[]>;
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
	let medicationAdministeredHistoryModelsBehaviorSubject: BehaviorSubject<MedicationAdministeredHistoryModel[]>;
	let medicationCompoundModelsBehaviorSubject: BehaviorSubject<MedicationCompoundModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let medicationItemModelsBehaviorSubject: BehaviorSubject<MedicationItemModel[]>;
	let prescriptionCompoundModelsBehaviorSubject: BehaviorSubject<PrescriptionCompoundModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let prescriptionItemModelsBehaviorSubject: BehaviorSubject<PrescriptionItemModel[]>;
	let purchaseOrderModelsBehaviorSubject: BehaviorSubject<PurchaseOrderModel[]>;
	let purchaseOrderStockDetailModelsBehaviorSubject: BehaviorSubject<PurchaseOrderStockDetailModel[]>;
	let purchaseRequisitionModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionModel[]>;
	let purchaseRequisitionStockDetailModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionStockDetailModel[]>;
	let retailPharmacyModelsBehaviorSubject: BehaviorSubject<RetailPharmacyModel[]>;
	let retailPharmacyStockDetailModelsBehaviorSubject: BehaviorSubject<RetailPharmacyStockDetailModel[]>;
	let returnSupplierModelsBehaviorSubject: BehaviorSubject<ReturnSupplierModel[]>;
	let returnSupplierStockDetailModelsBehaviorSubject: BehaviorSubject<ReturnSupplierStockDetailModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let stockControlModelsBehaviorSubject: BehaviorSubject<StockControlModel[]>;
	let stockTransactionDetailModelsBehaviorSubject: BehaviorSubject<StockTransactionDetailModel[]>;
	let stockTransactionPerDateModelsBehaviorSubject: BehaviorSubject<StockTransactionPerDateModel[]>;
	let stockTransactionPerDateTypeModelsBehaviorSubject: BehaviorSubject<StockTransactionPerDateTypeModel[]>;
	let supplierModelsBehaviorSubject: BehaviorSubject<SupplierModel[]>;
	let supplierProductDetailModelsBehaviorSubject: BehaviorSubject<SupplierProductDetailModel[]>;
	let transactionDetailTypeModelsBehaviorSubject: BehaviorSubject<TransactionDetailTypeModel[]>;
	let transferOrderModelsBehaviorSubject: BehaviorSubject<TransferOrderModel[]>;
	let transferOrderStockDetailModelsBehaviorSubject: BehaviorSubject<TransferOrderStockDetailModel[]>;
	let unitOfMeasurementModelsBehaviorSubject: BehaviorSubject<UnitOfMeasurementModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;
	let vaccinationOrderDetailModelsBehaviorSubject: BehaviorSubject<VaccinationOrderDetailModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;
	let warehouseInitialStockModelsBehaviorSubject: BehaviorSubject<WarehouseInitialStockModel[]>;
	let warehouseInventoryModelsBehaviorSubject: BehaviorSubject<WarehouseInventoryModel[]>;

	const stockCatalogueFactory: StockCatalogueDataFactory = new StockCatalogueDataFactory();
	const defaultStockCatalogueCount: number = 10;
	const defaultStockCatalogueEntities: StockCatalogueModel[] = stockCatalogueFactory.createAll(defaultStockCatalogueCount);

	const bpjsDrugGenericPRBFactory: BpjsDrugGenericPRBDataFactory = new BpjsDrugGenericPRBDataFactory();
	const defaultBpjsDrugGenericPRBCount: number = 10;
	const defaultBpjsDrugGenericPRBEntities: BpjsDrugGenericPRBModel[] = bpjsDrugGenericPRBFactory.createAll(defaultBpjsDrugGenericPRBCount);

	const bpjsPRBDetailFactory: BpjsPRBDetailDataFactory = new BpjsPRBDetailDataFactory();
	const defaultBpjsPRBDetailCount: number = 10;
	const defaultBpjsPRBDetailEntities: BpjsPRBDetailModel[] = bpjsPRBDetailFactory.createAll(defaultBpjsPRBDetailCount);

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

	const compoundPrescriptionDetailFactory: CompoundPrescriptionDetailDataFactory = new CompoundPrescriptionDetailDataFactory();
	const defaultCompoundPrescriptionDetailCount: number = 10;
	const defaultCompoundPrescriptionDetailEntities: CompoundPrescriptionDetailModel[] = compoundPrescriptionDetailFactory.createAll(defaultCompoundPrescriptionDetailCount);

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

	const medicationAdministeredHistoryFactory: MedicationAdministeredHistoryDataFactory = new MedicationAdministeredHistoryDataFactory();
	const defaultMedicationAdministeredHistoryCount: number = 10;
	const defaultMedicationAdministeredHistoryEntities: MedicationAdministeredHistoryModel[] = medicationAdministeredHistoryFactory.createAll(defaultMedicationAdministeredHistoryCount);

	const medicationCompoundFactory: MedicationCompoundDataFactory = new MedicationCompoundDataFactory();
	const defaultMedicationCompoundCount: number = 10;
	const defaultMedicationCompoundEntities: MedicationCompoundModel[] = medicationCompoundFactory.createAll(defaultMedicationCompoundCount);

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const medicationItemFactory: MedicationItemDataFactory = new MedicationItemDataFactory();
	const defaultMedicationItemCount: number = 10;
	const defaultMedicationItemEntities: MedicationItemModel[] = medicationItemFactory.createAll(defaultMedicationItemCount);

	const prescriptionCompoundFactory: PrescriptionCompoundDataFactory = new PrescriptionCompoundDataFactory();
	const defaultPrescriptionCompoundCount: number = 10;
	const defaultPrescriptionCompoundEntities: PrescriptionCompoundModel[] = prescriptionCompoundFactory.createAll(defaultPrescriptionCompoundCount);

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

	const supplierFactory: SupplierDataFactory = new SupplierDataFactory();
	const defaultSupplierCount: number = 10;
	const defaultSupplierEntities: SupplierModel[] = supplierFactory.createAll(defaultSupplierCount);

	const supplierProductDetailFactory: SupplierProductDetailDataFactory = new SupplierProductDetailDataFactory();
	const defaultSupplierProductDetailCount: number = 10;
	const defaultSupplierProductDetailEntities: SupplierProductDetailModel[] = supplierProductDetailFactory.createAll(defaultSupplierProductDetailCount);

	const transactionDetailTypeFactory: TransactionDetailTypeDataFactory = new TransactionDetailTypeDataFactory();
	const defaultTransactionDetailTypeCount: number = 10;
	const defaultTransactionDetailTypeEntities: TransactionDetailTypeModel[] = transactionDetailTypeFactory.createAll(defaultTransactionDetailTypeCount);

	const transferOrderFactory: TransferOrderDataFactory = new TransferOrderDataFactory();
	const defaultTransferOrderCount: number = 10;
	const defaultTransferOrderEntities: TransferOrderModel[] = transferOrderFactory.createAll(defaultTransferOrderCount);

	const transferOrderStockDetailFactory: TransferOrderStockDetailDataFactory = new TransferOrderStockDetailDataFactory();
	const defaultTransferOrderStockDetailCount: number = 10;
	const defaultTransferOrderStockDetailEntities: TransferOrderStockDetailModel[] = transferOrderStockDetailFactory.createAll(defaultTransferOrderStockDetailCount);

	const unitOfMeasurementFactory: UnitOfMeasurementDataFactory = new UnitOfMeasurementDataFactory();
	const defaultUnitOfMeasurementCount: number = 10;
	const defaultUnitOfMeasurementEntities: UnitOfMeasurementModel[] = unitOfMeasurementFactory.createAll(defaultUnitOfMeasurementCount);

	const vaccinationOrderFactory: VaccinationOrderDataFactory = new VaccinationOrderDataFactory();
	const defaultVaccinationOrderCount: number = 10;
	const defaultVaccinationOrderEntities: VaccinationOrderModel[] = vaccinationOrderFactory.createAll(defaultVaccinationOrderCount);

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
	let stockCatalogueWithId: StockCatalogueModel = defaultStockCatalogueEntities[0];
	let stockCatalogueModelWithIdBehaviorSubject: BehaviorSubject<StockCatalogueModel>;

	stockCatalogueWithId.stockCatalogueMedical = defaultCatalogueMedicalEntities[0];
	stockCatalogueWithId.stockCatalogueMedicalId = stockCatalogueWithId.stockCatalogueMedical.id;
	let stockCatalogueMedicalWithIdBehaviorSubject: BehaviorSubject<CatalogueMedicalModel>;

	stockCatalogueWithId.stockCatalogueNonMedical = defaultCatalogueNonMedicalEntities[0];
	stockCatalogueWithId.stockCatalogueNonMedicalId = stockCatalogueWithId.stockCatalogueNonMedical.id;
	let stockCatalogueNonMedicalWithIdBehaviorSubject: BehaviorSubject<CatalogueNonMedicalModel>;

	stockCatalogueWithId.bpjsDrugGenericPRB = defaultBpjsDrugGenericPRBEntities[0];
	stockCatalogueWithId.bpjsDrugGenericPRBId = stockCatalogueWithId.bpjsDrugGenericPRB.id;
	let bpjsDrugGenericPRBWithIdBehaviorSubject: BehaviorSubject<BpjsDrugGenericPRBModel>;

	stockCatalogueWithId.bpjsPcareDPHO = defaultBpjsPcareDPHOEntities[0];
	stockCatalogueWithId.bpjsPcareDPHOId = stockCatalogueWithId.bpjsPcareDPHO.id;
	let bpjsPcareDPHOWithIdBehaviorSubject: BehaviorSubject<BpjsPcareDPHOModel>;

	stockCatalogueWithId.warehouse = defaultWarehouseEntities[0];
	stockCatalogueWithId.warehouseId = stockCatalogueWithId.warehouse.id;
	let warehouseWithIdBehaviorSubject: BehaviorSubject<WarehouseModel>;

	stockCatalogueWithId.batchStockBalancesCatalogue = defaultBatchStockBalanceEntities;
	stockCatalogueWithId.batchStockBalancesCatalogueIds = stockCatalogueWithId.batchStockBalancesCatalogue.map(batchStockBalancesCatalogue => batchStockBalancesCatalogue.id);

	stockCatalogueWithId.batchStockBalances = defaultBatchStockBalancePerDateEntities;
	stockCatalogueWithId.batchStockBalancesIds = stockCatalogueWithId.batchStockBalances.map(batchStockBalances => batchStockBalances.id);

	stockCatalogueWithId.batchStockTransactionDetails = defaultBatchStockTransactionDetailEntities;
	stockCatalogueWithId.batchStockTransactionDetailsIds = stockCatalogueWithId.batchStockTransactionDetails.map(batchStockTransactionDetails => batchStockTransactionDetails.id);

	stockCatalogueWithId.catalogueUOMs = defaultCatalogueUOMEntities;
	stockCatalogueWithId.catalogueUOMsIds = stockCatalogueWithId.catalogueUOMs.map(catalogueUOMs => catalogueUOMs.id);

	stockCatalogueWithId.compoundPrescriptionItems = defaultCompoundPrescriptionItemEntities;
	stockCatalogueWithId.compoundPrescriptionItemsIds = stockCatalogueWithId.compoundPrescriptionItems.map(compoundPrescriptionItems => compoundPrescriptionItems.id);

	stockCatalogueWithId.goodsReceiveNoteBatchs = defaultGoodsReceiveNoteBatchEntities;
	stockCatalogueWithId.goodsReceiveNoteBatchsIds = stockCatalogueWithId.goodsReceiveNoteBatchs.map(goodsReceiveNoteBatchs => goodsReceiveNoteBatchs.id);

	stockCatalogueWithId.goodsReceiveNoteItems = defaultGoodsReceiveNoteItemEntities;
	stockCatalogueWithId.goodsReceiveNoteItemsIds = stockCatalogueWithId.goodsReceiveNoteItems.map(goodsReceiveNoteItems => goodsReceiveNoteItems.id);

	stockCatalogueWithId.internalOrderStockDetails = defaultInternalOrderStockDetailEntities;
	stockCatalogueWithId.internalOrderStockDetailsIds = stockCatalogueWithId.internalOrderStockDetails.map(internalOrderStockDetails => internalOrderStockDetails.id);

	stockCatalogueWithId.inventoryAdjusmentBatchs = defaultInventoryAdjusmentBatchEntities;
	stockCatalogueWithId.inventoryAdjusmentBatchsIds = stockCatalogueWithId.inventoryAdjusmentBatchs.map(inventoryAdjusmentBatchs => inventoryAdjusmentBatchs.id);

	stockCatalogueWithId.inventoryAdjustmentItems = defaultInventoryAdjustmentItemEntities;
	stockCatalogueWithId.inventoryAdjustmentItemsIds = stockCatalogueWithId.inventoryAdjustmentItems.map(inventoryAdjustmentItems => inventoryAdjustmentItems.id);

	stockCatalogueWithId.inventoryBatchCorrectionItems = defaultInventoryBatchCorrectionItemEntities;
	stockCatalogueWithId.inventoryBatchCorrectionItemsIds = stockCatalogueWithId.inventoryBatchCorrectionItems.map(inventoryBatchCorrectionItems => inventoryBatchCorrectionItems.id);

	stockCatalogueWithId.medicationItems = defaultMedicationItemEntities;
	stockCatalogueWithId.medicationItemsIds = stockCatalogueWithId.medicationItems.map(medicationItems => medicationItems.id);

	stockCatalogueWithId.prescriptionItem = defaultPrescriptionItemEntities;
	stockCatalogueWithId.prescriptionItemIds = stockCatalogueWithId.prescriptionItem.map(prescriptionItem => prescriptionItem.id);

	stockCatalogueWithId.purchaseOrderStockDetails = defaultPurchaseOrderStockDetailEntities;
	stockCatalogueWithId.purchaseOrderStockDetailsIds = stockCatalogueWithId.purchaseOrderStockDetails.map(purchaseOrderStockDetails => purchaseOrderStockDetails.id);

	stockCatalogueWithId.purchaseRequisitionStockDetails = defaultPurchaseRequisitionStockDetailEntities;
	stockCatalogueWithId.purchaseRequisitionStockDetailsIds = stockCatalogueWithId.purchaseRequisitionStockDetails.map(purchaseRequisitionStockDetails => purchaseRequisitionStockDetails.id);

	stockCatalogueWithId.retailPharmacyStockDetails = defaultRetailPharmacyStockDetailEntities;
	stockCatalogueWithId.retailPharmacyStockDetailsIds = stockCatalogueWithId.retailPharmacyStockDetails.map(retailPharmacyStockDetails => retailPharmacyStockDetails.id);

	stockCatalogueWithId.returnSupplierStockDetails = defaultReturnSupplierStockDetailEntities;
	stockCatalogueWithId.returnSupplierStockDetailsIds = stockCatalogueWithId.returnSupplierStockDetails.map(returnSupplierStockDetails => returnSupplierStockDetails.id);

	stockCatalogueWithId.stockControls = defaultStockControlEntities;
	stockCatalogueWithId.stockControlsIds = stockCatalogueWithId.stockControls.map(stockControls => stockControls.id);

	stockCatalogueWithId.stockTransactionDetails = defaultStockTransactionDetailEntities;
	stockCatalogueWithId.stockTransactionDetailsIds = stockCatalogueWithId.stockTransactionDetails.map(stockTransactionDetails => stockTransactionDetails.id);

	stockCatalogueWithId.stockTransactionPerDateTypes = defaultStockTransactionPerDateTypeEntities;
	stockCatalogueWithId.stockTransactionPerDateTypesIds = stockCatalogueWithId.stockTransactionPerDateTypes.map(stockTransactionPerDateTypes => stockTransactionPerDateTypes.id);

	stockCatalogueWithId.stockTransactionPerDates = defaultStockTransactionPerDateEntities;
	stockCatalogueWithId.stockTransactionPerDatesIds = stockCatalogueWithId.stockTransactionPerDates.map(stockTransactionPerDates => stockTransactionPerDates.id);

	stockCatalogueWithId.supplierProductDetails = defaultSupplierProductDetailEntities;
	stockCatalogueWithId.supplierProductDetailsIds = stockCatalogueWithId.supplierProductDetails.map(supplierProductDetails => supplierProductDetails.id);

	stockCatalogueWithId.transferOrderStockDetails = defaultTransferOrderStockDetailEntities;
	stockCatalogueWithId.transferOrderStockDetailsIds = stockCatalogueWithId.transferOrderStockDetails.map(transferOrderStockDetails => transferOrderStockDetails.id);

	stockCatalogueWithId.vaccinationOrderDetails = defaultVaccinationOrderDetailEntities;
	stockCatalogueWithId.vaccinationOrderDetailsIds = stockCatalogueWithId.vaccinationOrderDetails.map(vaccinationOrderDetails => vaccinationOrderDetails.id);

	stockCatalogueWithId.warehouseInitialStockS = defaultWarehouseInitialStockEntities;
	stockCatalogueWithId.warehouseInitialStockSIds = stockCatalogueWithId.warehouseInitialStockS.map(warehouseInitialStockS => warehouseInitialStockS.id);

	stockCatalogueWithId.warehouseInventories = defaultWarehouseInventoryEntities;
	stockCatalogueWithId.warehouseInventoriesIds = stockCatalogueWithId.warehouseInventories.map(warehouseInventories => warehouseInventories.id);


	const routerState: RouterState = {
		url: 'stock-catalogue-crud',
		urls: ['stock-catalogue-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: StockCatalogueModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		stockCatalogueModelState = initialStockCatalogueModelState;
		store.setState({model: stockCatalogueModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		stockCatalogueCountBehaviorSubject = new BehaviorSubject(defaultStockCatalogueCount);

		// selectors for all references
		stockCatalogueModelsBehaviorSubject = new BehaviorSubject(defaultStockCatalogueEntities);
		bpjsDrugGenericPRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDrugGenericPRBEntities);
		bpjsPRBDetailModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBDetailEntities);
		bpjsPcareDPHOModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareDPHOEntities);
		batchStockBalanceModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockBalanceEntities);
		batchStockBalancePerDateModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockBalancePerDateEntities);
		batchStockTransactionDetailModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockTransactionDetailEntities);
		catalogueMedicalModelsBehaviorSubject = new BehaviorSubject(defaultCatalogueMedicalEntities);
		catalogueNonMedicalModelsBehaviorSubject = new BehaviorSubject(defaultCatalogueNonMedicalEntities);
		catalogueUOMModelsBehaviorSubject = new BehaviorSubject(defaultCatalogueUOMEntities);
		compoundPrescriptionDetailModelsBehaviorSubject = new BehaviorSubject(defaultCompoundPrescriptionDetailEntities);
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
		medicationAdministeredHistoryModelsBehaviorSubject = new BehaviorSubject(defaultMedicationAdministeredHistoryEntities);
		medicationCompoundModelsBehaviorSubject = new BehaviorSubject(defaultMedicationCompoundEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		medicationItemModelsBehaviorSubject = new BehaviorSubject(defaultMedicationItemEntities);
		prescriptionCompoundModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionCompoundEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		prescriptionItemModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionItemEntities);
		purchaseOrderModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderEntities);
		purchaseOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderStockDetailEntities);
		purchaseRequisitionModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionEntities);
		purchaseRequisitionStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionStockDetailEntities);
		retailPharmacyModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyEntities);
		retailPharmacyStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyStockDetailEntities);
		returnSupplierModelsBehaviorSubject = new BehaviorSubject(defaultReturnSupplierEntities);
		returnSupplierStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultReturnSupplierStockDetailEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		stockControlModelsBehaviorSubject = new BehaviorSubject(defaultStockControlEntities);
		stockTransactionDetailModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionDetailEntities);
		stockTransactionPerDateModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionPerDateEntities);
		stockTransactionPerDateTypeModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionPerDateTypeEntities);
		supplierModelsBehaviorSubject = new BehaviorSubject(defaultSupplierEntities);
		supplierProductDetailModelsBehaviorSubject = new BehaviorSubject(defaultSupplierProductDetailEntities);
		transactionDetailTypeModelsBehaviorSubject = new BehaviorSubject(defaultTransactionDetailTypeEntities);
		transferOrderModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderEntities);
		transferOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderStockDetailEntities);
		unitOfMeasurementModelsBehaviorSubject = new BehaviorSubject(defaultUnitOfMeasurementEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);
		vaccinationOrderDetailModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderDetailEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);
		warehouseInitialStockModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseInitialStockEntities);
		warehouseInventoryModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseInventoryEntities);

		// selectors for target entity and its related entity
		stockCatalogueModelWithIdBehaviorSubject = new BehaviorSubject(stockCatalogueWithId);
		stockCatalogueMedicalWithIdBehaviorSubject = new BehaviorSubject(stockCatalogueWithId.stockCatalogueMedical);
		stockCatalogueNonMedicalWithIdBehaviorSubject = new BehaviorSubject(stockCatalogueWithId.stockCatalogueNonMedical);
		bpjsDrugGenericPRBWithIdBehaviorSubject = new BehaviorSubject(stockCatalogueWithId.bpjsDrugGenericPRB);
		bpjsPcareDPHOWithIdBehaviorSubject = new BehaviorSubject(stockCatalogueWithId.bpjsPcareDPHO);
		warehouseWithIdBehaviorSubject = new BehaviorSubject(stockCatalogueWithId.warehouse);

		spyOn(store, 'select')
			.withArgs(getCountStockCatalogueModels).and.returnValue(stockCatalogueCountBehaviorSubject)
			.withArgs(getStockCatalogueModelWithId, stockCatalogueWithId.id).and.returnValue(stockCatalogueModelWithIdBehaviorSubject)
			.withArgs(getStockCatalogueCollectionModels, jasmine.any(String)).and.returnValue(stockCatalogueModelsBehaviorSubject)
			.withArgs(getBpjsDrugGenericPRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsDrugGenericPRBModelsBehaviorSubject)
			.withArgs(getBpjsPRBDetailCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBDetailModelsBehaviorSubject)
			.withArgs(getBpjsPcareDPHOCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareDPHOModelsBehaviorSubject)
			.withArgs(getBatchStockBalanceCollectionModels, jasmine.any(String)).and.returnValue(batchStockBalanceModelsBehaviorSubject)
			.withArgs(getBatchStockBalancePerDateCollectionModels, jasmine.any(String)).and.returnValue(batchStockBalancePerDateModelsBehaviorSubject)
			.withArgs(getBatchStockTransactionDetailCollectionModels, jasmine.any(String)).and.returnValue(batchStockTransactionDetailModelsBehaviorSubject)
			.withArgs(getCatalogueMedicalCollectionModels, jasmine.any(String)).and.returnValue(catalogueMedicalModelsBehaviorSubject)
			.withArgs(getCatalogueNonMedicalCollectionModels, jasmine.any(String)).and.returnValue(catalogueNonMedicalModelsBehaviorSubject)
			.withArgs(getCatalogueUOMCollectionModels, jasmine.any(String)).and.returnValue(catalogueUOMModelsBehaviorSubject)
			.withArgs(getCompoundPrescriptionDetailCollectionModels, jasmine.any(String)).and.returnValue(compoundPrescriptionDetailModelsBehaviorSubject)
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
			.withArgs(getMedicationAdministeredHistoryCollectionModels, jasmine.any(String)).and.returnValue(medicationAdministeredHistoryModelsBehaviorSubject)
			.withArgs(getMedicationCompoundCollectionModels, jasmine.any(String)).and.returnValue(medicationCompoundModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getMedicationItemCollectionModels, jasmine.any(String)).and.returnValue(medicationItemModelsBehaviorSubject)
			.withArgs(getPrescriptionCompoundCollectionModels, jasmine.any(String)).and.returnValue(prescriptionCompoundModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getPrescriptionItemCollectionModels, jasmine.any(String)).and.returnValue(prescriptionItemModelsBehaviorSubject)
			.withArgs(getPurchaseOrderCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderModelsBehaviorSubject)
			.withArgs(getPurchaseOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderStockDetailModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionStockDetailCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionStockDetailModelsBehaviorSubject)
			.withArgs(getRetailPharmacyCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyModelsBehaviorSubject)
			.withArgs(getRetailPharmacyStockDetailCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyStockDetailModelsBehaviorSubject)
			.withArgs(getReturnSupplierCollectionModels, jasmine.any(String)).and.returnValue(returnSupplierModelsBehaviorSubject)
			.withArgs(getReturnSupplierStockDetailCollectionModels, jasmine.any(String)).and.returnValue(returnSupplierStockDetailModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getStockControlCollectionModels, jasmine.any(String)).and.returnValue(stockControlModelsBehaviorSubject)
			.withArgs(getStockTransactionDetailCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionDetailModelsBehaviorSubject)
			.withArgs(getStockTransactionPerDateCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionPerDateModelsBehaviorSubject)
			.withArgs(getStockTransactionPerDateTypeCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionPerDateTypeModelsBehaviorSubject)
			.withArgs(getSupplierCollectionModels, jasmine.any(String)).and.returnValue(supplierModelsBehaviorSubject)
			.withArgs(getSupplierProductDetailCollectionModels, jasmine.any(String)).and.returnValue(supplierProductDetailModelsBehaviorSubject)
			.withArgs(getTransactionDetailTypeCollectionModels, jasmine.any(String)).and.returnValue(transactionDetailTypeModelsBehaviorSubject)
			.withArgs(getTransferOrderCollectionModels, jasmine.any(String)).and.returnValue(transferOrderModelsBehaviorSubject)
			.withArgs(getTransferOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(transferOrderStockDetailModelsBehaviorSubject)
			.withArgs(getUnitOfMeasurementCollectionModels, jasmine.any(String)).and.returnValue(unitOfMeasurementModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getVaccinationOrderDetailCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderDetailModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getWarehouseInitialStockCollectionModels, jasmine.any(String)).and.returnValue(warehouseInitialStockModelsBehaviorSubject)
			.withArgs(getWarehouseInventoryCollectionModels, jasmine.any(String)).and.returnValue(warehouseInventoryModelsBehaviorSubject)
			.withArgs(getCatalogueMedicalModelWithId, stockCatalogueWithId.stockCatalogueMedicalId).and.returnValue(stockCatalogueMedicalWithIdBehaviorSubject)
			.withArgs(getCatalogueNonMedicalModelWithId, stockCatalogueWithId.stockCatalogueNonMedicalId).and.returnValue(stockCatalogueNonMedicalWithIdBehaviorSubject)
			.withArgs(getBpjsDrugGenericPRBModelWithId, stockCatalogueWithId.bpjsDrugGenericPRBId).and.returnValue(bpjsDrugGenericPRBWithIdBehaviorSubject)
			.withArgs(getBpjsPcareDPHOModelWithId, stockCatalogueWithId.bpjsPcareDPHOId).and.returnValue(bpjsPcareDPHOWithIdBehaviorSubject)
			.withArgs(getWarehouseModelWithId, stockCatalogueWithId.warehouseId).and.returnValue(warehouseWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				StockCatalogueCrudModule,
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

			fixture = TestBed.createComponent(StockCatalogueCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new StockCatalogueModel();
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
	it ('Renders the Stock Catalogue CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Stock Catalogue Medical  relation.
	*
	* The button should only exist if stockCatalogueMedicalMultiCrudActive is true
	*/
	it ('Renders Stock Catalogue Medical  Add Entity button in create mode', fakeAsync(() => {
		const stockCatalogueMedicalButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueMedicalDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockCatalogueMedicalButton).toEqual(component.stockCatalogueMedicalMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Catalogue Medical ', fakeAsync(() => {
		const stockCatalogueMedicalButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueMedicalDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCatalogueMedicalButton).toEqual(component.stockCatalogueMedicalMultiCrudActive);

		if (component.stockCatalogueMedicalMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockCatalogueMedicalRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueMedicalDisplayName + ' from Model')).length;

			stockCatalogueMedicalButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockCatalogueMedicalRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueMedicalDisplayName + ' from Model')).length;

			expect(actualStockCatalogueMedicalRemoveButtonCount).toEqual(initialStockCatalogueMedicalRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Catalogue Medical  button', () => {
		const stockCatalogueMedicalButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueMedicalDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCatalogueMedicalButton).toEqual(component.stockCatalogueMedicalMultiCrudActive);

		if (component.stockCatalogueMedicalMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockCatalogueMedicalButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockCatalogueMedicalRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueMedicalDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockCatalogueMedicalRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockCatalogueMedicalRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueMedicalDisplayName + ' from Model'));

			expect(actualStockCatalogueMedicalRemoveButtons.length).toEqual(initialStockCatalogueMedicalRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Stock Catalogue Medical  button when one has already been added', () => {

		const stockCatalogueMedicalButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueMedicalDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCatalogueMedicalButton).toEqual(component.stockCatalogueMedicalMultiCrudActive);

		if (component.stockCatalogueMedicalMultiCrudActive) {
			stockCatalogueMedicalButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockCatalogueMedicalButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueMedicalDisplayName + ' to Model'));

			expect(updatedstockCatalogueMedicalButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Stock Catalogue Medical  entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockCatalogueMedicalMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockCatalogueMedicalRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueMedicalDisplayName + ' from Model')).length;

			expect(stockCatalogueMedicalRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Stock Catalogue Non Medical relation.
	*
	* The button should only exist if stockCatalogueNonMedicalMultiCrudActive is true
	*/
	it ('Renders Stock Catalogue Non Medical Add Entity button in create mode', fakeAsync(() => {
		const stockCatalogueNonMedicalButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueNonMedicalDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockCatalogueNonMedicalButton).toEqual(component.stockCatalogueNonMedicalMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Catalogue Non Medical', fakeAsync(() => {
		const stockCatalogueNonMedicalButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueNonMedicalDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCatalogueNonMedicalButton).toEqual(component.stockCatalogueNonMedicalMultiCrudActive);

		if (component.stockCatalogueNonMedicalMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockCatalogueNonMedicalRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueNonMedicalDisplayName + ' from Model')).length;

			stockCatalogueNonMedicalButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockCatalogueNonMedicalRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueNonMedicalDisplayName + ' from Model')).length;

			expect(actualStockCatalogueNonMedicalRemoveButtonCount).toEqual(initialStockCatalogueNonMedicalRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Catalogue Non Medical button', () => {
		const stockCatalogueNonMedicalButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueNonMedicalDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCatalogueNonMedicalButton).toEqual(component.stockCatalogueNonMedicalMultiCrudActive);

		if (component.stockCatalogueNonMedicalMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockCatalogueNonMedicalButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockCatalogueNonMedicalRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueNonMedicalDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockCatalogueNonMedicalRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockCatalogueNonMedicalRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueNonMedicalDisplayName + ' from Model'));

			expect(actualStockCatalogueNonMedicalRemoveButtons.length).toEqual(initialStockCatalogueNonMedicalRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Stock Catalogue Non Medical button when one has already been added', () => {

		const stockCatalogueNonMedicalButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueNonMedicalDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCatalogueNonMedicalButton).toEqual(component.stockCatalogueNonMedicalMultiCrudActive);

		if (component.stockCatalogueNonMedicalMultiCrudActive) {
			stockCatalogueNonMedicalButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockCatalogueNonMedicalButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCatalogueNonMedicalDisplayName + ' to Model'));

			expect(updatedstockCatalogueNonMedicalButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Stock Catalogue Non Medical entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockCatalogueNonMedicalMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockCatalogueNonMedicalRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCatalogueNonMedicalDisplayName + ' from Model')).length;

			expect(stockCatalogueNonMedicalRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Drug Generic PRB relation.
	*
	* The button should only exist if bpjsDrugGenericPRBMultiCrudActive is true
	*/
	it ('Renders BPJS Drug Generic PRB Add Entity button in create mode', fakeAsync(() => {
		const bpjsDrugGenericPRBButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDrugGenericPRBDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDrugGenericPRBButton).toEqual(component.bpjsDrugGenericPRBMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Drug Generic PRB', fakeAsync(() => {
		const bpjsDrugGenericPRBButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDrugGenericPRBDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDrugGenericPRBButton).toEqual(component.bpjsDrugGenericPRBMultiCrudActive);

		if (component.bpjsDrugGenericPRBMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDrugGenericPRBRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDrugGenericPRBDisplayName + ' from Model')).length;

			bpjsDrugGenericPRBButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDrugGenericPRBRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDrugGenericPRBDisplayName + ' from Model')).length;

			expect(actualBpjsDrugGenericPRBRemoveButtonCount).toEqual(initialBpjsDrugGenericPRBRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Drug Generic PRB button', () => {
		const bpjsDrugGenericPRBButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDrugGenericPRBDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDrugGenericPRBButton).toEqual(component.bpjsDrugGenericPRBMultiCrudActive);

		if (component.bpjsDrugGenericPRBMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDrugGenericPRBButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDrugGenericPRBRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDrugGenericPRBDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDrugGenericPRBRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDrugGenericPRBRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDrugGenericPRBDisplayName + ' from Model'));

			expect(actualBpjsDrugGenericPRBRemoveButtons.length).toEqual(initialBpjsDrugGenericPRBRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Drug Generic PRB button when one has already been added', () => {

		const bpjsDrugGenericPRBButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDrugGenericPRBDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDrugGenericPRBButton).toEqual(component.bpjsDrugGenericPRBMultiCrudActive);

		if (component.bpjsDrugGenericPRBMultiCrudActive) {
			bpjsDrugGenericPRBButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDrugGenericPRBButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDrugGenericPRBDisplayName + ' to Model'));

			expect(updatedbpjsDrugGenericPRBButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Drug Generic PRB entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDrugGenericPRBMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDrugGenericPRBRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDrugGenericPRBDisplayName + ' from Model')).length;

			expect(bpjsDrugGenericPRBRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Pcare DPHO relation.
	*
	* The button should only exist if bpjsPcareDPHOMultiCrudActive is true
	*/
	it ('Renders BPJS Pcare DPHO Add Entity button in create mode', fakeAsync(() => {
		const bpjsPcareDPHOButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareDPHODisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsPcareDPHOButton).toEqual(component.bpjsPcareDPHOMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Pcare DPHO', fakeAsync(() => {
		const bpjsPcareDPHOButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareDPHODisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPcareDPHOButton).toEqual(component.bpjsPcareDPHOMultiCrudActive);

		if (component.bpjsPcareDPHOMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsPcareDPHORemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareDPHODisplayName + ' from Model')).length;

			bpjsPcareDPHOButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPcareDPHORemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareDPHODisplayName + ' from Model')).length;

			expect(actualBpjsPcareDPHORemoveButtonCount).toEqual(initialBpjsPcareDPHORemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Pcare DPHO button', () => {
		const bpjsPcareDPHOButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareDPHODisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPcareDPHOButton).toEqual(component.bpjsPcareDPHOMultiCrudActive);

		if (component.bpjsPcareDPHOMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsPcareDPHOButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsPcareDPHORemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareDPHODisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsPcareDPHORemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPcareDPHORemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareDPHODisplayName + ' from Model'));

			expect(actualBpjsPcareDPHORemoveButtons.length).toEqual(initialBpjsPcareDPHORemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Pcare DPHO button when one has already been added', () => {

		const bpjsPcareDPHOButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareDPHODisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPcareDPHOButton).toEqual(component.bpjsPcareDPHOMultiCrudActive);

		if (component.bpjsPcareDPHOMultiCrudActive) {
			bpjsPcareDPHOButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsPcareDPHOButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareDPHODisplayName + ' to Model'));

			expect(updatedbpjsPcareDPHOButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Pcare DPHO entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsPcareDPHOMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsPcareDPHORemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareDPHODisplayName + ' from Model')).length;

			expect(bpjsPcareDPHORemoveButtonCount).toEqual(1);
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
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
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
	* Checks that the status of the add model button matches the multi entity status for the Batch Stock Balances Catalogue relation.
	*
	* The button should only exist if batchStockBalancesCatalogueMultiCrudActive is true
	*/
	it ('Renders Batch Stock Balances Catalogue Add Entity button in create mode', fakeAsync(() => {
		const batchStockBalancesCatalogueButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesCatalogueDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!batchStockBalancesCatalogueButton).toEqual(component.batchStockBalancesCatalogueMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Batch Stock Balances Catalogue', fakeAsync(() => {
		const batchStockBalancesCatalogueButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesCatalogueDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockBalancesCatalogueButton).toEqual(component.batchStockBalancesCatalogueMultiCrudActive);

		if (component.batchStockBalancesCatalogueMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBatchStockBalancesCatalogueRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesCatalogueDisplayName + ' from Model')).length;

			batchStockBalancesCatalogueButton.nativeElement.click();
			fixture.detectChanges();

			const actualBatchStockBalancesCatalogueRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesCatalogueDisplayName + ' from Model')).length;

			expect(actualBatchStockBalancesCatalogueRemoveButtonCount).toEqual(initialBatchStockBalancesCatalogueRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Batch Stock Balances Catalogue button', () => {
		const batchStockBalancesCatalogueButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesCatalogueDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockBalancesCatalogueButton).toEqual(component.batchStockBalancesCatalogueMultiCrudActive);

		if (component.batchStockBalancesCatalogueMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			batchStockBalancesCatalogueButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBatchStockBalancesCatalogueRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesCatalogueDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBatchStockBalancesCatalogueRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBatchStockBalancesCatalogueRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesCatalogueDisplayName + ' from Model'));

			expect(actualBatchStockBalancesCatalogueRemoveButtons.length).toEqual(initialBatchStockBalancesCatalogueRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Batch Stock Balances Catalogue button when one has already been added', () => {

		const batchStockBalancesCatalogueButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesCatalogueDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockBalancesCatalogueButton).toEqual(component.batchStockBalancesCatalogueMultiCrudActive);

		if (component.batchStockBalancesCatalogueMultiCrudActive) {
			batchStockBalancesCatalogueButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbatchStockBalancesCatalogueButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesCatalogueDisplayName + ' to Model'));

			expect(updatedbatchStockBalancesCatalogueButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Batch Stock Balances Catalogue entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.batchStockBalancesCatalogueMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const batchStockBalancesCatalogueRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesCatalogueDisplayName + ' from Model')).length;

			expect(batchStockBalancesCatalogueRemoveButtonCount).toEqual(stockCatalogueWithId.batchStockBalancesCatalogue.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Batch Stock Balances relation.
	*
	* The button should only exist if batchStockBalancesMultiCrudActive is true
	*/
	it ('Renders Batch Stock Balances Add Entity button in create mode', fakeAsync(() => {
		const batchStockBalancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!batchStockBalancesButton).toEqual(component.batchStockBalancesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Batch Stock Balances', fakeAsync(() => {
		const batchStockBalancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockBalancesButton).toEqual(component.batchStockBalancesMultiCrudActive);

		if (component.batchStockBalancesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBatchStockBalancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesDisplayName + ' from Model')).length;

			batchStockBalancesButton.nativeElement.click();
			fixture.detectChanges();

			const actualBatchStockBalancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesDisplayName + ' from Model')).length;

			expect(actualBatchStockBalancesRemoveButtonCount).toEqual(initialBatchStockBalancesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Batch Stock Balances button', () => {
		const batchStockBalancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockBalancesButton).toEqual(component.batchStockBalancesMultiCrudActive);

		if (component.batchStockBalancesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			batchStockBalancesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBatchStockBalancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBatchStockBalancesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBatchStockBalancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesDisplayName + ' from Model'));

			expect(actualBatchStockBalancesRemoveButtons.length).toEqual(initialBatchStockBalancesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Batch Stock Balances button when one has already been added', () => {

		const batchStockBalancesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockBalancesButton).toEqual(component.batchStockBalancesMultiCrudActive);

		if (component.batchStockBalancesMultiCrudActive) {
			batchStockBalancesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbatchStockBalancesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesDisplayName + ' to Model'));

			expect(updatedbatchStockBalancesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Batch Stock Balances entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.batchStockBalancesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const batchStockBalancesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesDisplayName + ' from Model')).length;

			expect(batchStockBalancesRemoveButtonCount).toEqual(stockCatalogueWithId.batchStockBalances.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Batch Stock Transaction Details relation.
	*
	* The button should only exist if batchStockTransactionDetailsMultiCrudActive is true
	*/
	it ('Renders Batch Stock Transaction Details Add Entity button in create mode', fakeAsync(() => {
		const batchStockTransactionDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockTransactionDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!batchStockTransactionDetailsButton).toEqual(component.batchStockTransactionDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Batch Stock Transaction Details', fakeAsync(() => {
		const batchStockTransactionDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockTransactionDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockTransactionDetailsButton).toEqual(component.batchStockTransactionDetailsMultiCrudActive);

		if (component.batchStockTransactionDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBatchStockTransactionDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockTransactionDetailsDisplayName + ' from Model')).length;

			batchStockTransactionDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBatchStockTransactionDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockTransactionDetailsDisplayName + ' from Model')).length;

			expect(actualBatchStockTransactionDetailsRemoveButtonCount).toEqual(initialBatchStockTransactionDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Batch Stock Transaction Details button', () => {
		const batchStockTransactionDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockTransactionDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockTransactionDetailsButton).toEqual(component.batchStockTransactionDetailsMultiCrudActive);

		if (component.batchStockTransactionDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			batchStockTransactionDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBatchStockTransactionDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockTransactionDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBatchStockTransactionDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBatchStockTransactionDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockTransactionDetailsDisplayName + ' from Model'));

			expect(actualBatchStockTransactionDetailsRemoveButtons.length).toEqual(initialBatchStockTransactionDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Batch Stock Transaction Details button when one has already been added', () => {

		const batchStockTransactionDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockTransactionDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockTransactionDetailsButton).toEqual(component.batchStockTransactionDetailsMultiCrudActive);

		if (component.batchStockTransactionDetailsMultiCrudActive) {
			batchStockTransactionDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbatchStockTransactionDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockTransactionDetailsDisplayName + ' to Model'));

			expect(updatedbatchStockTransactionDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Batch Stock Transaction Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.batchStockTransactionDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const batchStockTransactionDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockTransactionDetailsDisplayName + ' from Model')).length;

			expect(batchStockTransactionDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.batchStockTransactionDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Catalogue UOMs relation.
	*
	* The button should only exist if catalogueUOMsMultiCrudActive is true
	*/
	it ('Renders Catalogue UOMs Add Entity button in create mode', fakeAsync(() => {
		const catalogueUOMsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.catalogueUOMsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!catalogueUOMsButton).toEqual(component.catalogueUOMsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Catalogue UOMs', fakeAsync(() => {
		const catalogueUOMsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.catalogueUOMsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!catalogueUOMsButton).toEqual(component.catalogueUOMsMultiCrudActive);

		if (component.catalogueUOMsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCatalogueUOMsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.catalogueUOMsDisplayName + ' from Model')).length;

			catalogueUOMsButton.nativeElement.click();
			fixture.detectChanges();

			const actualCatalogueUOMsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.catalogueUOMsDisplayName + ' from Model')).length;

			expect(actualCatalogueUOMsRemoveButtonCount).toEqual(initialCatalogueUOMsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Catalogue UOMs button', () => {
		const catalogueUOMsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.catalogueUOMsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!catalogueUOMsButton).toEqual(component.catalogueUOMsMultiCrudActive);

		if (component.catalogueUOMsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			catalogueUOMsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCatalogueUOMsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.catalogueUOMsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCatalogueUOMsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCatalogueUOMsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.catalogueUOMsDisplayName + ' from Model'));

			expect(actualCatalogueUOMsRemoveButtons.length).toEqual(initialCatalogueUOMsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Catalogue UOMs button when one has already been added', () => {

		const catalogueUOMsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.catalogueUOMsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!catalogueUOMsButton).toEqual(component.catalogueUOMsMultiCrudActive);

		if (component.catalogueUOMsMultiCrudActive) {
			catalogueUOMsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcatalogueUOMsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.catalogueUOMsDisplayName + ' to Model'));

			expect(updatedcatalogueUOMsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Catalogue UOMs entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.catalogueUOMsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const catalogueUOMsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.catalogueUOMsDisplayName + ' from Model')).length;

			expect(catalogueUOMsRemoveButtonCount).toEqual(stockCatalogueWithId.catalogueUOMs.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Compound Prescription Items relation.
	*
	* The button should only exist if compoundPrescriptionItemsMultiCrudActive is true
	*/
	it ('Renders Compound Prescription Items Add Entity button in create mode', fakeAsync(() => {
		const compoundPrescriptionItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!compoundPrescriptionItemsButton).toEqual(component.compoundPrescriptionItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Compound Prescription Items', fakeAsync(() => {
		const compoundPrescriptionItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!compoundPrescriptionItemsButton).toEqual(component.compoundPrescriptionItemsMultiCrudActive);

		if (component.compoundPrescriptionItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCompoundPrescriptionItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model')).length;

			compoundPrescriptionItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualCompoundPrescriptionItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model')).length;

			expect(actualCompoundPrescriptionItemsRemoveButtonCount).toEqual(initialCompoundPrescriptionItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Compound Prescription Items button', () => {
		const compoundPrescriptionItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!compoundPrescriptionItemsButton).toEqual(component.compoundPrescriptionItemsMultiCrudActive);

		if (component.compoundPrescriptionItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			compoundPrescriptionItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCompoundPrescriptionItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCompoundPrescriptionItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCompoundPrescriptionItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model'));

			expect(actualCompoundPrescriptionItemsRemoveButtons.length).toEqual(initialCompoundPrescriptionItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Compound Prescription Items button when one has already been added', () => {

		const compoundPrescriptionItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!compoundPrescriptionItemsButton).toEqual(component.compoundPrescriptionItemsMultiCrudActive);

		if (component.compoundPrescriptionItemsMultiCrudActive) {
			compoundPrescriptionItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcompoundPrescriptionItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

			expect(updatedcompoundPrescriptionItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Compound Prescription Items entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.compoundPrescriptionItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const compoundPrescriptionItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model')).length;

			expect(compoundPrescriptionItemsRemoveButtonCount).toEqual(stockCatalogueWithId.compoundPrescriptionItems.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Goods Receive Note Batchs relation.
	*
	* The button should only exist if goodsReceiveNoteBatchsMultiCrudActive is true
	*/
	it ('Renders Goods Receive Note Batchs Add Entity button in create mode', fakeAsync(() => {
		const goodsReceiveNoteBatchsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteBatchsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!goodsReceiveNoteBatchsButton).toEqual(component.goodsReceiveNoteBatchsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Goods Receive Note Batchs', fakeAsync(() => {
		const goodsReceiveNoteBatchsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteBatchsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNoteBatchsButton).toEqual(component.goodsReceiveNoteBatchsMultiCrudActive);

		if (component.goodsReceiveNoteBatchsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialGoodsReceiveNoteBatchsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteBatchsDisplayName + ' from Model')).length;

			goodsReceiveNoteBatchsButton.nativeElement.click();
			fixture.detectChanges();

			const actualGoodsReceiveNoteBatchsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteBatchsDisplayName + ' from Model')).length;

			expect(actualGoodsReceiveNoteBatchsRemoveButtonCount).toEqual(initialGoodsReceiveNoteBatchsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Goods Receive Note Batchs button', () => {
		const goodsReceiveNoteBatchsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteBatchsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNoteBatchsButton).toEqual(component.goodsReceiveNoteBatchsMultiCrudActive);

		if (component.goodsReceiveNoteBatchsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			goodsReceiveNoteBatchsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialGoodsReceiveNoteBatchsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteBatchsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialGoodsReceiveNoteBatchsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualGoodsReceiveNoteBatchsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteBatchsDisplayName + ' from Model'));

			expect(actualGoodsReceiveNoteBatchsRemoveButtons.length).toEqual(initialGoodsReceiveNoteBatchsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Goods Receive Note Batchs button when one has already been added', () => {

		const goodsReceiveNoteBatchsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteBatchsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNoteBatchsButton).toEqual(component.goodsReceiveNoteBatchsMultiCrudActive);

		if (component.goodsReceiveNoteBatchsMultiCrudActive) {
			goodsReceiveNoteBatchsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedgoodsReceiveNoteBatchsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteBatchsDisplayName + ' to Model'));

			expect(updatedgoodsReceiveNoteBatchsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Goods Receive Note Batchs entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.goodsReceiveNoteBatchsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const goodsReceiveNoteBatchsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteBatchsDisplayName + ' from Model')).length;

			expect(goodsReceiveNoteBatchsRemoveButtonCount).toEqual(stockCatalogueWithId.goodsReceiveNoteBatchs.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Goods Receive Note Items relation.
	*
	* The button should only exist if goodsReceiveNoteItemsMultiCrudActive is true
	*/
	it ('Renders Goods Receive Note Items Add Entity button in create mode', fakeAsync(() => {
		const goodsReceiveNoteItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!goodsReceiveNoteItemsButton).toEqual(component.goodsReceiveNoteItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Goods Receive Note Items', fakeAsync(() => {
		const goodsReceiveNoteItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNoteItemsButton).toEqual(component.goodsReceiveNoteItemsMultiCrudActive);

		if (component.goodsReceiveNoteItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialGoodsReceiveNoteItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteItemsDisplayName + ' from Model')).length;

			goodsReceiveNoteItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualGoodsReceiveNoteItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteItemsDisplayName + ' from Model')).length;

			expect(actualGoodsReceiveNoteItemsRemoveButtonCount).toEqual(initialGoodsReceiveNoteItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Goods Receive Note Items button', () => {
		const goodsReceiveNoteItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNoteItemsButton).toEqual(component.goodsReceiveNoteItemsMultiCrudActive);

		if (component.goodsReceiveNoteItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			goodsReceiveNoteItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialGoodsReceiveNoteItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialGoodsReceiveNoteItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualGoodsReceiveNoteItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteItemsDisplayName + ' from Model'));

			expect(actualGoodsReceiveNoteItemsRemoveButtons.length).toEqual(initialGoodsReceiveNoteItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Goods Receive Note Items button when one has already been added', () => {

		const goodsReceiveNoteItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNoteItemsButton).toEqual(component.goodsReceiveNoteItemsMultiCrudActive);

		if (component.goodsReceiveNoteItemsMultiCrudActive) {
			goodsReceiveNoteItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedgoodsReceiveNoteItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNoteItemsDisplayName + ' to Model'));

			expect(updatedgoodsReceiveNoteItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Goods Receive Note Items entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.goodsReceiveNoteItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const goodsReceiveNoteItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNoteItemsDisplayName + ' from Model')).length;

			expect(goodsReceiveNoteItemsRemoveButtonCount).toEqual(stockCatalogueWithId.goodsReceiveNoteItems.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Internal Order Stock Details relation.
	*
	* The button should only exist if internalOrderStockDetailsMultiCrudActive is true
	*/
	it ('Renders Internal Order Stock Details Add Entity button in create mode', fakeAsync(() => {
		const internalOrderStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrderStockDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!internalOrderStockDetailsButton).toEqual(component.internalOrderStockDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Internal Order Stock Details', fakeAsync(() => {
		const internalOrderStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrderStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!internalOrderStockDetailsButton).toEqual(component.internalOrderStockDetailsMultiCrudActive);

		if (component.internalOrderStockDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInternalOrderStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrderStockDetailsDisplayName + ' from Model')).length;

			internalOrderStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInternalOrderStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrderStockDetailsDisplayName + ' from Model')).length;

			expect(actualInternalOrderStockDetailsRemoveButtonCount).toEqual(initialInternalOrderStockDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Internal Order Stock Details button', () => {
		const internalOrderStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrderStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!internalOrderStockDetailsButton).toEqual(component.internalOrderStockDetailsMultiCrudActive);

		if (component.internalOrderStockDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			internalOrderStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInternalOrderStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrderStockDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInternalOrderStockDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInternalOrderStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrderStockDetailsDisplayName + ' from Model'));

			expect(actualInternalOrderStockDetailsRemoveButtons.length).toEqual(initialInternalOrderStockDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Internal Order Stock Details button when one has already been added', () => {

		const internalOrderStockDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrderStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!internalOrderStockDetailsButton).toEqual(component.internalOrderStockDetailsMultiCrudActive);

		if (component.internalOrderStockDetailsMultiCrudActive) {
			internalOrderStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinternalOrderStockDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrderStockDetailsDisplayName + ' to Model'));

			expect(updatedinternalOrderStockDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Internal Order Stock Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.internalOrderStockDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const internalOrderStockDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrderStockDetailsDisplayName + ' from Model')).length;

			expect(internalOrderStockDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.internalOrderStockDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Inventory Adjusment Batchs relation.
	*
	* The button should only exist if inventoryAdjusmentBatchsMultiCrudActive is true
	*/
	it ('Renders Inventory Adjusment Batchs Add Entity button in create mode', fakeAsync(() => {
		const inventoryAdjusmentBatchsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjusmentBatchsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!inventoryAdjusmentBatchsButton).toEqual(component.inventoryAdjusmentBatchsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Inventory Adjusment Batchs', fakeAsync(() => {
		const inventoryAdjusmentBatchsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjusmentBatchsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjusmentBatchsButton).toEqual(component.inventoryAdjusmentBatchsMultiCrudActive);

		if (component.inventoryAdjusmentBatchsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInventoryAdjusmentBatchsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjusmentBatchsDisplayName + ' from Model')).length;

			inventoryAdjusmentBatchsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInventoryAdjusmentBatchsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjusmentBatchsDisplayName + ' from Model')).length;

			expect(actualInventoryAdjusmentBatchsRemoveButtonCount).toEqual(initialInventoryAdjusmentBatchsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Inventory Adjusment Batchs button', () => {
		const inventoryAdjusmentBatchsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjusmentBatchsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjusmentBatchsButton).toEqual(component.inventoryAdjusmentBatchsMultiCrudActive);

		if (component.inventoryAdjusmentBatchsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			inventoryAdjusmentBatchsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInventoryAdjusmentBatchsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjusmentBatchsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInventoryAdjusmentBatchsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInventoryAdjusmentBatchsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjusmentBatchsDisplayName + ' from Model'));

			expect(actualInventoryAdjusmentBatchsRemoveButtons.length).toEqual(initialInventoryAdjusmentBatchsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Inventory Adjusment Batchs button when one has already been added', () => {

		const inventoryAdjusmentBatchsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjusmentBatchsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjusmentBatchsButton).toEqual(component.inventoryAdjusmentBatchsMultiCrudActive);

		if (component.inventoryAdjusmentBatchsMultiCrudActive) {
			inventoryAdjusmentBatchsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinventoryAdjusmentBatchsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjusmentBatchsDisplayName + ' to Model'));

			expect(updatedinventoryAdjusmentBatchsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Inventory Adjusment Batchs entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.inventoryAdjusmentBatchsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const inventoryAdjusmentBatchsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjusmentBatchsDisplayName + ' from Model')).length;

			expect(inventoryAdjusmentBatchsRemoveButtonCount).toEqual(stockCatalogueWithId.inventoryAdjusmentBatchs.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Inventory Adjustment Items relation.
	*
	* The button should only exist if inventoryAdjustmentItemsMultiCrudActive is true
	*/
	it ('Renders Inventory Adjustment Items Add Entity button in create mode', fakeAsync(() => {
		const inventoryAdjustmentItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!inventoryAdjustmentItemsButton).toEqual(component.inventoryAdjustmentItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Inventory Adjustment Items', fakeAsync(() => {
		const inventoryAdjustmentItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjustmentItemsButton).toEqual(component.inventoryAdjustmentItemsMultiCrudActive);

		if (component.inventoryAdjustmentItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInventoryAdjustmentItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentItemsDisplayName + ' from Model')).length;

			inventoryAdjustmentItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInventoryAdjustmentItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentItemsDisplayName + ' from Model')).length;

			expect(actualInventoryAdjustmentItemsRemoveButtonCount).toEqual(initialInventoryAdjustmentItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Inventory Adjustment Items button', () => {
		const inventoryAdjustmentItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjustmentItemsButton).toEqual(component.inventoryAdjustmentItemsMultiCrudActive);

		if (component.inventoryAdjustmentItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			inventoryAdjustmentItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInventoryAdjustmentItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInventoryAdjustmentItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInventoryAdjustmentItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentItemsDisplayName + ' from Model'));

			expect(actualInventoryAdjustmentItemsRemoveButtons.length).toEqual(initialInventoryAdjustmentItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Inventory Adjustment Items button when one has already been added', () => {

		const inventoryAdjustmentItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjustmentItemsButton).toEqual(component.inventoryAdjustmentItemsMultiCrudActive);

		if (component.inventoryAdjustmentItemsMultiCrudActive) {
			inventoryAdjustmentItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinventoryAdjustmentItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentItemsDisplayName + ' to Model'));

			expect(updatedinventoryAdjustmentItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Inventory Adjustment Items entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.inventoryAdjustmentItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const inventoryAdjustmentItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentItemsDisplayName + ' from Model')).length;

			expect(inventoryAdjustmentItemsRemoveButtonCount).toEqual(stockCatalogueWithId.inventoryAdjustmentItems.length);
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
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
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

			expect(inventoryBatchCorrectionItemsRemoveButtonCount).toEqual(stockCatalogueWithId.inventoryBatchCorrectionItems.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medication Items relation.
	*
	* The button should only exist if medicationItemsMultiCrudActive is true
	*/
	it ('Renders Medication Items Add Entity button in create mode', fakeAsync(() => {
		const medicationItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicationItemsButton).toEqual(component.medicationItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medication Items', fakeAsync(() => {
		const medicationItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationItemsButton).toEqual(component.medicationItemsMultiCrudActive);

		if (component.medicationItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicationItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationItemsDisplayName + ' from Model')).length;

			medicationItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicationItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationItemsDisplayName + ' from Model')).length;

			expect(actualMedicationItemsRemoveButtonCount).toEqual(initialMedicationItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medication Items button', () => {
		const medicationItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationItemsButton).toEqual(component.medicationItemsMultiCrudActive);

		if (component.medicationItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicationItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicationItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicationItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicationItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationItemsDisplayName + ' from Model'));

			expect(actualMedicationItemsRemoveButtons.length).toEqual(initialMedicationItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medication Items button when one has already been added', () => {

		const medicationItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationItemsButton).toEqual(component.medicationItemsMultiCrudActive);

		if (component.medicationItemsMultiCrudActive) {
			medicationItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicationItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationItemsDisplayName + ' to Model'));

			expect(updatedmedicationItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medication Items entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicationItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicationItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationItemsDisplayName + ' from Model')).length;

			expect(medicationItemsRemoveButtonCount).toEqual(stockCatalogueWithId.medicationItems.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Prescription Item relation.
	*
	* The button should only exist if prescriptionItemMultiCrudActive is true
	*/
	it ('Renders Prescription Item Add Entity button in create mode', fakeAsync(() => {
		const prescriptionItemButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionItemDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!prescriptionItemButton).toEqual(component.prescriptionItemMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Prescription Item', fakeAsync(() => {
		const prescriptionItemButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionItemDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionItemButton).toEqual(component.prescriptionItemMultiCrudActive);

		if (component.prescriptionItemMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPrescriptionItemRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionItemDisplayName + ' from Model')).length;

			prescriptionItemButton.nativeElement.click();
			fixture.detectChanges();

			const actualPrescriptionItemRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionItemDisplayName + ' from Model')).length;

			expect(actualPrescriptionItemRemoveButtonCount).toEqual(initialPrescriptionItemRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Prescription Item button', () => {
		const prescriptionItemButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionItemDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionItemButton).toEqual(component.prescriptionItemMultiCrudActive);

		if (component.prescriptionItemMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			prescriptionItemButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPrescriptionItemRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionItemDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPrescriptionItemRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPrescriptionItemRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionItemDisplayName + ' from Model'));

			expect(actualPrescriptionItemRemoveButtons.length).toEqual(initialPrescriptionItemRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Prescription Item button when one has already been added', () => {

		const prescriptionItemButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionItemDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionItemButton).toEqual(component.prescriptionItemMultiCrudActive);

		if (component.prescriptionItemMultiCrudActive) {
			prescriptionItemButton.nativeElement.click();
			fixture.detectChanges();

			const updatedprescriptionItemButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionItemDisplayName + ' to Model'));

			expect(updatedprescriptionItemButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Prescription Item entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.prescriptionItemMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const prescriptionItemRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionItemDisplayName + ' from Model')).length;

			expect(prescriptionItemRemoveButtonCount).toEqual(stockCatalogueWithId.prescriptionItem.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Purchase Order Stock Details relation.
	*
	* The button should only exist if purchaseOrderStockDetailsMultiCrudActive is true
	*/
	it ('Renders Purchase Order Stock Details Add Entity button in create mode', fakeAsync(() => {
		const purchaseOrderStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrderStockDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!purchaseOrderStockDetailsButton).toEqual(component.purchaseOrderStockDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Purchase Order Stock Details', fakeAsync(() => {
		const purchaseOrderStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrderStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseOrderStockDetailsButton).toEqual(component.purchaseOrderStockDetailsMultiCrudActive);

		if (component.purchaseOrderStockDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPurchaseOrderStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrderStockDetailsDisplayName + ' from Model')).length;

			purchaseOrderStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseOrderStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrderStockDetailsDisplayName + ' from Model')).length;

			expect(actualPurchaseOrderStockDetailsRemoveButtonCount).toEqual(initialPurchaseOrderStockDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Purchase Order Stock Details button', () => {
		const purchaseOrderStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrderStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseOrderStockDetailsButton).toEqual(component.purchaseOrderStockDetailsMultiCrudActive);

		if (component.purchaseOrderStockDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			purchaseOrderStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPurchaseOrderStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrderStockDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPurchaseOrderStockDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseOrderStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrderStockDetailsDisplayName + ' from Model'));

			expect(actualPurchaseOrderStockDetailsRemoveButtons.length).toEqual(initialPurchaseOrderStockDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Purchase Order Stock Details button when one has already been added', () => {

		const purchaseOrderStockDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrderStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseOrderStockDetailsButton).toEqual(component.purchaseOrderStockDetailsMultiCrudActive);

		if (component.purchaseOrderStockDetailsMultiCrudActive) {
			purchaseOrderStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpurchaseOrderStockDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrderStockDetailsDisplayName + ' to Model'));

			expect(updatedpurchaseOrderStockDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Purchase Order Stock Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.purchaseOrderStockDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const purchaseOrderStockDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrderStockDetailsDisplayName + ' from Model')).length;

			expect(purchaseOrderStockDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.purchaseOrderStockDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Purchase Requisition Stock Details relation.
	*
	* The button should only exist if purchaseRequisitionStockDetailsMultiCrudActive is true
	*/
	it ('Renders Purchase Requisition Stock Details Add Entity button in create mode', fakeAsync(() => {
		const purchaseRequisitionStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionStockDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!purchaseRequisitionStockDetailsButton).toEqual(component.purchaseRequisitionStockDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Purchase Requisition Stock Details', fakeAsync(() => {
		const purchaseRequisitionStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseRequisitionStockDetailsButton).toEqual(component.purchaseRequisitionStockDetailsMultiCrudActive);

		if (component.purchaseRequisitionStockDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPurchaseRequisitionStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionStockDetailsDisplayName + ' from Model')).length;

			purchaseRequisitionStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseRequisitionStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionStockDetailsDisplayName + ' from Model')).length;

			expect(actualPurchaseRequisitionStockDetailsRemoveButtonCount).toEqual(initialPurchaseRequisitionStockDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Purchase Requisition Stock Details button', () => {
		const purchaseRequisitionStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseRequisitionStockDetailsButton).toEqual(component.purchaseRequisitionStockDetailsMultiCrudActive);

		if (component.purchaseRequisitionStockDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			purchaseRequisitionStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPurchaseRequisitionStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionStockDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPurchaseRequisitionStockDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseRequisitionStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionStockDetailsDisplayName + ' from Model'));

			expect(actualPurchaseRequisitionStockDetailsRemoveButtons.length).toEqual(initialPurchaseRequisitionStockDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Purchase Requisition Stock Details button when one has already been added', () => {

		const purchaseRequisitionStockDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseRequisitionStockDetailsButton).toEqual(component.purchaseRequisitionStockDetailsMultiCrudActive);

		if (component.purchaseRequisitionStockDetailsMultiCrudActive) {
			purchaseRequisitionStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpurchaseRequisitionStockDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionStockDetailsDisplayName + ' to Model'));

			expect(updatedpurchaseRequisitionStockDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Purchase Requisition Stock Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.purchaseRequisitionStockDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const purchaseRequisitionStockDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionStockDetailsDisplayName + ' from Model')).length;

			expect(purchaseRequisitionStockDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.purchaseRequisitionStockDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Retail Pharmacy Stock Details relation.
	*
	* The button should only exist if retailPharmacyStockDetailsMultiCrudActive is true
	*/
	it ('Renders Retail Pharmacy Stock Details Add Entity button in create mode', fakeAsync(() => {
		const retailPharmacyStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyStockDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!retailPharmacyStockDetailsButton).toEqual(component.retailPharmacyStockDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Retail Pharmacy Stock Details', fakeAsync(() => {
		const retailPharmacyStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmacyStockDetailsButton).toEqual(component.retailPharmacyStockDetailsMultiCrudActive);

		if (component.retailPharmacyStockDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRetailPharmacyStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyStockDetailsDisplayName + ' from Model')).length;

			retailPharmacyStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualRetailPharmacyStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyStockDetailsDisplayName + ' from Model')).length;

			expect(actualRetailPharmacyStockDetailsRemoveButtonCount).toEqual(initialRetailPharmacyStockDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Retail Pharmacy Stock Details button', () => {
		const retailPharmacyStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmacyStockDetailsButton).toEqual(component.retailPharmacyStockDetailsMultiCrudActive);

		if (component.retailPharmacyStockDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			retailPharmacyStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRetailPharmacyStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyStockDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRetailPharmacyStockDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRetailPharmacyStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyStockDetailsDisplayName + ' from Model'));

			expect(actualRetailPharmacyStockDetailsRemoveButtons.length).toEqual(initialRetailPharmacyStockDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Retail Pharmacy Stock Details button when one has already been added', () => {

		const retailPharmacyStockDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmacyStockDetailsButton).toEqual(component.retailPharmacyStockDetailsMultiCrudActive);

		if (component.retailPharmacyStockDetailsMultiCrudActive) {
			retailPharmacyStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedretailPharmacyStockDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyStockDetailsDisplayName + ' to Model'));

			expect(updatedretailPharmacyStockDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Retail Pharmacy Stock Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.retailPharmacyStockDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const retailPharmacyStockDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyStockDetailsDisplayName + ' from Model')).length;

			expect(retailPharmacyStockDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.retailPharmacyStockDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Return Supplier Stock Details relation.
	*
	* The button should only exist if returnSupplierStockDetailsMultiCrudActive is true
	*/
	it ('Renders Return Supplier Stock Details Add Entity button in create mode', fakeAsync(() => {
		const returnSupplierStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSupplierStockDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!returnSupplierStockDetailsButton).toEqual(component.returnSupplierStockDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Return Supplier Stock Details', fakeAsync(() => {
		const returnSupplierStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSupplierStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!returnSupplierStockDetailsButton).toEqual(component.returnSupplierStockDetailsMultiCrudActive);

		if (component.returnSupplierStockDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialReturnSupplierStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSupplierStockDetailsDisplayName + ' from Model')).length;

			returnSupplierStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualReturnSupplierStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSupplierStockDetailsDisplayName + ' from Model')).length;

			expect(actualReturnSupplierStockDetailsRemoveButtonCount).toEqual(initialReturnSupplierStockDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Return Supplier Stock Details button', () => {
		const returnSupplierStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSupplierStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!returnSupplierStockDetailsButton).toEqual(component.returnSupplierStockDetailsMultiCrudActive);

		if (component.returnSupplierStockDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			returnSupplierStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialReturnSupplierStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSupplierStockDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialReturnSupplierStockDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualReturnSupplierStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSupplierStockDetailsDisplayName + ' from Model'));

			expect(actualReturnSupplierStockDetailsRemoveButtons.length).toEqual(initialReturnSupplierStockDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Return Supplier Stock Details button when one has already been added', () => {

		const returnSupplierStockDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSupplierStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!returnSupplierStockDetailsButton).toEqual(component.returnSupplierStockDetailsMultiCrudActive);

		if (component.returnSupplierStockDetailsMultiCrudActive) {
			returnSupplierStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedreturnSupplierStockDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSupplierStockDetailsDisplayName + ' to Model'));

			expect(updatedreturnSupplierStockDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Return Supplier Stock Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.returnSupplierStockDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const returnSupplierStockDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSupplierStockDetailsDisplayName + ' from Model')).length;

			expect(returnSupplierStockDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.returnSupplierStockDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Stock Controls relation.
	*
	* The button should only exist if stockControlsMultiCrudActive is true
	*/
	it ('Renders Stock Controls Add Entity button in create mode', fakeAsync(() => {
		const stockControlsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockControlsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockControlsButton).toEqual(component.stockControlsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Controls', fakeAsync(() => {
		const stockControlsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockControlsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockControlsButton).toEqual(component.stockControlsMultiCrudActive);

		if (component.stockControlsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockControlsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockControlsDisplayName + ' from Model')).length;

			stockControlsButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockControlsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockControlsDisplayName + ' from Model')).length;

			expect(actualStockControlsRemoveButtonCount).toEqual(initialStockControlsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Controls button', () => {
		const stockControlsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockControlsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockControlsButton).toEqual(component.stockControlsMultiCrudActive);

		if (component.stockControlsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockControlsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockControlsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockControlsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockControlsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockControlsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockControlsDisplayName + ' from Model'));

			expect(actualStockControlsRemoveButtons.length).toEqual(initialStockControlsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Stock Controls button when one has already been added', () => {

		const stockControlsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockControlsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockControlsButton).toEqual(component.stockControlsMultiCrudActive);

		if (component.stockControlsMultiCrudActive) {
			stockControlsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockControlsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockControlsDisplayName + ' to Model'));

			expect(updatedstockControlsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Stock Controls entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockControlsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockControlsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockControlsDisplayName + ' from Model')).length;

			expect(stockControlsRemoveButtonCount).toEqual(stockCatalogueWithId.stockControls.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Stock Transaction Details relation.
	*
	* The button should only exist if stockTransactionDetailsMultiCrudActive is true
	*/
	it ('Renders Stock Transaction Details Add Entity button in create mode', fakeAsync(() => {
		const stockTransactionDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockTransactionDetailsButton).toEqual(component.stockTransactionDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Transaction Details', fakeAsync(() => {
		const stockTransactionDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionDetailsButton).toEqual(component.stockTransactionDetailsMultiCrudActive);

		if (component.stockTransactionDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockTransactionDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model')).length;

			stockTransactionDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model')).length;

			expect(actualStockTransactionDetailsRemoveButtonCount).toEqual(initialStockTransactionDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Transaction Details button', () => {
		const stockTransactionDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionDetailsButton).toEqual(component.stockTransactionDetailsMultiCrudActive);

		if (component.stockTransactionDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockTransactionDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockTransactionDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockTransactionDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model'));

			expect(actualStockTransactionDetailsRemoveButtons.length).toEqual(initialStockTransactionDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Stock Transaction Details button when one has already been added', () => {

		const stockTransactionDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionDetailsButton).toEqual(component.stockTransactionDetailsMultiCrudActive);

		if (component.stockTransactionDetailsMultiCrudActive) {
			stockTransactionDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockTransactionDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

			expect(updatedstockTransactionDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Stock Transaction Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockTransactionDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockTransactionDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model')).length;

			expect(stockTransactionDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.stockTransactionDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Stock Transaction Per Date Types relation.
	*
	* The button should only exist if stockTransactionPerDateTypesMultiCrudActive is true
	*/
	it ('Renders Stock Transaction Per Date Types Add Entity button in create mode', fakeAsync(() => {
		const stockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockTransactionPerDateTypesButton).toEqual(component.stockTransactionPerDateTypesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Transaction Per Date Types', fakeAsync(() => {
		const stockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionPerDateTypesButton).toEqual(component.stockTransactionPerDateTypesMultiCrudActive);

		if (component.stockTransactionPerDateTypesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockTransactionPerDateTypesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model')).length;

			stockTransactionPerDateTypesButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionPerDateTypesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model')).length;

			expect(actualStockTransactionPerDateTypesRemoveButtonCount).toEqual(initialStockTransactionPerDateTypesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Transaction Per Date Types button', () => {
		const stockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionPerDateTypesButton).toEqual(component.stockTransactionPerDateTypesMultiCrudActive);

		if (component.stockTransactionPerDateTypesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockTransactionPerDateTypesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockTransactionPerDateTypesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockTransactionPerDateTypesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionPerDateTypesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model'));

			expect(actualStockTransactionPerDateTypesRemoveButtons.length).toEqual(initialStockTransactionPerDateTypesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Stock Transaction Per Date Types button when one has already been added', () => {

		const stockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionPerDateTypesButton).toEqual(component.stockTransactionPerDateTypesMultiCrudActive);

		if (component.stockTransactionPerDateTypesMultiCrudActive) {
			stockTransactionPerDateTypesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

			expect(updatedstockTransactionPerDateTypesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Stock Transaction Per Date Types entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockTransactionPerDateTypesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockTransactionPerDateTypesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model')).length;

			expect(stockTransactionPerDateTypesRemoveButtonCount).toEqual(stockCatalogueWithId.stockTransactionPerDateTypes.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Stock Transaction Per Dates relation.
	*
	* The button should only exist if stockTransactionPerDatesMultiCrudActive is true
	*/
	it ('Renders Stock Transaction Per Dates Add Entity button in create mode', fakeAsync(() => {
		const stockTransactionPerDatesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDatesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockTransactionPerDatesButton).toEqual(component.stockTransactionPerDatesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Transaction Per Dates', fakeAsync(() => {
		const stockTransactionPerDatesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDatesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionPerDatesButton).toEqual(component.stockTransactionPerDatesMultiCrudActive);

		if (component.stockTransactionPerDatesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockTransactionPerDatesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDatesDisplayName + ' from Model')).length;

			stockTransactionPerDatesButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionPerDatesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDatesDisplayName + ' from Model')).length;

			expect(actualStockTransactionPerDatesRemoveButtonCount).toEqual(initialStockTransactionPerDatesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Transaction Per Dates button', () => {
		const stockTransactionPerDatesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDatesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionPerDatesButton).toEqual(component.stockTransactionPerDatesMultiCrudActive);

		if (component.stockTransactionPerDatesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockTransactionPerDatesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockTransactionPerDatesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDatesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockTransactionPerDatesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionPerDatesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDatesDisplayName + ' from Model'));

			expect(actualStockTransactionPerDatesRemoveButtons.length).toEqual(initialStockTransactionPerDatesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Stock Transaction Per Dates button when one has already been added', () => {

		const stockTransactionPerDatesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDatesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionPerDatesButton).toEqual(component.stockTransactionPerDatesMultiCrudActive);

		if (component.stockTransactionPerDatesMultiCrudActive) {
			stockTransactionPerDatesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockTransactionPerDatesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDatesDisplayName + ' to Model'));

			expect(updatedstockTransactionPerDatesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Stock Transaction Per Dates entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockTransactionPerDatesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockTransactionPerDatesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDatesDisplayName + ' from Model')).length;

			expect(stockTransactionPerDatesRemoveButtonCount).toEqual(stockCatalogueWithId.stockTransactionPerDates.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Supplier Product Details relation.
	*
	* The button should only exist if supplierProductDetailsMultiCrudActive is true
	*/
	it ('Renders Supplier Product Details Add Entity button in create mode', fakeAsync(() => {
		const supplierProductDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!supplierProductDetailsButton).toEqual(component.supplierProductDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Supplier Product Details', fakeAsync(() => {
		const supplierProductDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!supplierProductDetailsButton).toEqual(component.supplierProductDetailsMultiCrudActive);

		if (component.supplierProductDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSupplierProductDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model')).length;

			supplierProductDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualSupplierProductDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model')).length;

			expect(actualSupplierProductDetailsRemoveButtonCount).toEqual(initialSupplierProductDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Supplier Product Details button', () => {
		const supplierProductDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!supplierProductDetailsButton).toEqual(component.supplierProductDetailsMultiCrudActive);

		if (component.supplierProductDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			supplierProductDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSupplierProductDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSupplierProductDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSupplierProductDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model'));

			expect(actualSupplierProductDetailsRemoveButtons.length).toEqual(initialSupplierProductDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Supplier Product Details button when one has already been added', () => {

		const supplierProductDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!supplierProductDetailsButton).toEqual(component.supplierProductDetailsMultiCrudActive);

		if (component.supplierProductDetailsMultiCrudActive) {
			supplierProductDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsupplierProductDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

			expect(updatedsupplierProductDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Supplier Product Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.supplierProductDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const supplierProductDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model')).length;

			expect(supplierProductDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.supplierProductDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Transfer Order Stock Details relation.
	*
	* The button should only exist if transferOrderStockDetailsMultiCrudActive is true
	*/
	it ('Renders Transfer Order Stock Details Add Entity button in create mode', fakeAsync(() => {
		const transferOrderStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.transferOrderStockDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!transferOrderStockDetailsButton).toEqual(component.transferOrderStockDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Transfer Order Stock Details', fakeAsync(() => {
		const transferOrderStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.transferOrderStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!transferOrderStockDetailsButton).toEqual(component.transferOrderStockDetailsMultiCrudActive);

		if (component.transferOrderStockDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialTransferOrderStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transferOrderStockDetailsDisplayName + ' from Model')).length;

			transferOrderStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualTransferOrderStockDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transferOrderStockDetailsDisplayName + ' from Model')).length;

			expect(actualTransferOrderStockDetailsRemoveButtonCount).toEqual(initialTransferOrderStockDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Transfer Order Stock Details button', () => {
		const transferOrderStockDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.transferOrderStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!transferOrderStockDetailsButton).toEqual(component.transferOrderStockDetailsMultiCrudActive);

		if (component.transferOrderStockDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			transferOrderStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialTransferOrderStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transferOrderStockDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialTransferOrderStockDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualTransferOrderStockDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transferOrderStockDetailsDisplayName + ' from Model'));

			expect(actualTransferOrderStockDetailsRemoveButtons.length).toEqual(initialTransferOrderStockDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Transfer Order Stock Details button when one has already been added', () => {

		const transferOrderStockDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.transferOrderStockDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!transferOrderStockDetailsButton).toEqual(component.transferOrderStockDetailsMultiCrudActive);

		if (component.transferOrderStockDetailsMultiCrudActive) {
			transferOrderStockDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedtransferOrderStockDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.transferOrderStockDetailsDisplayName + ' to Model'));

			expect(updatedtransferOrderStockDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Transfer Order Stock Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.transferOrderStockDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const transferOrderStockDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transferOrderStockDetailsDisplayName + ' from Model')).length;

			expect(transferOrderStockDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.transferOrderStockDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Vaccination Order Details relation.
	*
	* The button should only exist if vaccinationOrderDetailsMultiCrudActive is true
	*/
	it ('Renders Vaccination Order Details Add Entity button in create mode', fakeAsync(() => {
		const vaccinationOrderDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!vaccinationOrderDetailsButton).toEqual(component.vaccinationOrderDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Vaccination Order Details', fakeAsync(() => {
		const vaccinationOrderDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!vaccinationOrderDetailsButton).toEqual(component.vaccinationOrderDetailsMultiCrudActive);

		if (component.vaccinationOrderDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialVaccinationOrderDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDetailsDisplayName + ' from Model')).length;

			vaccinationOrderDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualVaccinationOrderDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDetailsDisplayName + ' from Model')).length;

			expect(actualVaccinationOrderDetailsRemoveButtonCount).toEqual(initialVaccinationOrderDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Vaccination Order Details button', () => {
		const vaccinationOrderDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!vaccinationOrderDetailsButton).toEqual(component.vaccinationOrderDetailsMultiCrudActive);

		if (component.vaccinationOrderDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			vaccinationOrderDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialVaccinationOrderDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialVaccinationOrderDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualVaccinationOrderDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDetailsDisplayName + ' from Model'));

			expect(actualVaccinationOrderDetailsRemoveButtons.length).toEqual(initialVaccinationOrderDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Vaccination Order Details button when one has already been added', () => {

		const vaccinationOrderDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!vaccinationOrderDetailsButton).toEqual(component.vaccinationOrderDetailsMultiCrudActive);

		if (component.vaccinationOrderDetailsMultiCrudActive) {
			vaccinationOrderDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedvaccinationOrderDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrderDetailsDisplayName + ' to Model'));

			expect(updatedvaccinationOrderDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Vaccination Order Details entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.vaccinationOrderDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const vaccinationOrderDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrderDetailsDisplayName + ' from Model')).length;

			expect(vaccinationOrderDetailsRemoveButtonCount).toEqual(stockCatalogueWithId.vaccinationOrderDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Warehouse Initial Stock s relation.
	*
	* The button should only exist if warehouseInitialStockSMultiCrudActive is true
	*/
	it ('Renders Warehouse Initial Stock s Add Entity button in create mode', fakeAsync(() => {
		const warehouseInitialStockSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInitialStockSDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!warehouseInitialStockSButton).toEqual(component.warehouseInitialStockSMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Warehouse Initial Stock s', fakeAsync(() => {
		const warehouseInitialStockSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInitialStockSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseInitialStockSButton).toEqual(component.warehouseInitialStockSMultiCrudActive);

		if (component.warehouseInitialStockSMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialWarehouseInitialStockSRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInitialStockSDisplayName + ' from Model')).length;

			warehouseInitialStockSButton.nativeElement.click();
			fixture.detectChanges();

			const actualWarehouseInitialStockSRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInitialStockSDisplayName + ' from Model')).length;

			expect(actualWarehouseInitialStockSRemoveButtonCount).toEqual(initialWarehouseInitialStockSRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Warehouse Initial Stock s button', () => {
		const warehouseInitialStockSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInitialStockSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseInitialStockSButton).toEqual(component.warehouseInitialStockSMultiCrudActive);

		if (component.warehouseInitialStockSMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			warehouseInitialStockSButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialWarehouseInitialStockSRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInitialStockSDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialWarehouseInitialStockSRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualWarehouseInitialStockSRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInitialStockSDisplayName + ' from Model'));

			expect(actualWarehouseInitialStockSRemoveButtons.length).toEqual(initialWarehouseInitialStockSRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Warehouse Initial Stock s button when one has already been added', () => {

		const warehouseInitialStockSButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInitialStockSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseInitialStockSButton).toEqual(component.warehouseInitialStockSMultiCrudActive);

		if (component.warehouseInitialStockSMultiCrudActive) {
			warehouseInitialStockSButton.nativeElement.click();
			fixture.detectChanges();

			const updatedwarehouseInitialStockSButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInitialStockSDisplayName + ' to Model'));

			expect(updatedwarehouseInitialStockSButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Warehouse Initial Stock s entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.warehouseInitialStockSMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const warehouseInitialStockSRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInitialStockSDisplayName + ' from Model')).length;

			expect(warehouseInitialStockSRemoveButtonCount).toEqual(stockCatalogueWithId.warehouseInitialStockS.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Warehouse Inventories relation.
	*
	* The button should only exist if warehouseInventoriesMultiCrudActive is true
	*/
	it ('Renders Warehouse Inventories Add Entity button in create mode', fakeAsync(() => {
		const warehouseInventoriesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInventoriesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!warehouseInventoriesButton).toEqual(component.warehouseInventoriesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Warehouse Inventories', fakeAsync(() => {
		const warehouseInventoriesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInventoriesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseInventoriesButton).toEqual(component.warehouseInventoriesMultiCrudActive);

		if (component.warehouseInventoriesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialWarehouseInventoriesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInventoriesDisplayName + ' from Model')).length;

			warehouseInventoriesButton.nativeElement.click();
			fixture.detectChanges();

			const actualWarehouseInventoriesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInventoriesDisplayName + ' from Model')).length;

			expect(actualWarehouseInventoriesRemoveButtonCount).toEqual(initialWarehouseInventoriesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Warehouse Inventories button', () => {
		const warehouseInventoriesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInventoriesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseInventoriesButton).toEqual(component.warehouseInventoriesMultiCrudActive);

		if (component.warehouseInventoriesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			warehouseInventoriesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialWarehouseInventoriesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInventoriesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialWarehouseInventoriesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualWarehouseInventoriesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInventoriesDisplayName + ' from Model'));

			expect(actualWarehouseInventoriesRemoveButtons.length).toEqual(initialWarehouseInventoriesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Warehouse Inventories button when one has already been added', () => {

		const warehouseInventoriesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInventoriesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseInventoriesButton).toEqual(component.warehouseInventoriesMultiCrudActive);

		if (component.warehouseInventoriesMultiCrudActive) {
			warehouseInventoriesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedwarehouseInventoriesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseInventoriesDisplayName + ' to Model'));

			expect(updatedwarehouseInventoriesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Warehouse Inventories entities from model when loading in edit mode', () => {
		component.targetModel = stockCatalogueWithId;
		component.targetModelId = stockCatalogueWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.warehouseInventoriesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const warehouseInventoriesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseInventoriesDisplayName + ' from Model')).length;

			expect(warehouseInventoriesRemoveButtonCount).toEqual(stockCatalogueWithId.warehouseInventories.length);
		}
	});

});
