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
	getWarehouseCollectionModels,
	getCountWarehouseModels,
	getWarehouseModelWithId
} from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseCrudModule } from '../warehouse-crud.module';
import { WarehouseCrudEditComponent } from './warehouse-crud-edit.component';
import {
	WarehouseModelState,
	initialState as initialWarehouseModelState
} from 'src/app/models/warehouse/warehouse.model.state';
import { WarehouseDataFactory } from 'src/app/lib/utils/factories/warehouse-data-factory';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { CrudTileMode } from '../warehouse-crud.component';
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
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
import { getLocationModelWithId } from 'src/app/models/location/location.model.selector';
import { getLocationCollectionModels } from 'src/app/models/location/location.model.selector';
import { LocationModel } from 'src/app/models/location/location.model';
import { LocationDataFactory } from 'src/app/lib/utils/factories/location-data-factory';
import { getMedicalFeeModelWithId } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { getMedicalFeeCollectionModels } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { MedicalFeeModel } from 'src/app/models/medicalFee/medical_fee.model';
import { MedicalFeeDataFactory } from 'src/app/lib/utils/factories/medical-fee-data-factory';
import { getMedicalFeeItemComponentModelWithId } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model.selector';
import { getMedicalFeeItemComponentCollectionModels } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model.selector';
import { MedicalFeeItemComponentModel } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model';
import { MedicalFeeItemComponentDataFactory } from 'src/app/lib/utils/factories/medical-fee-item-component-data-factory';
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
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
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
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getRetailPharmacyModelWithId } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { getRetailPharmacyCollectionModels } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { RetailPharmacyModel } from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import { RetailPharmacyDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-data-factory';
import { getRetailPharmacyInvoiceModelWithId } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { getRetailPharmacyInvoiceCollectionModels } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { RetailPharmacyInvoiceModel } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model';
import { RetailPharmacyInvoiceDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-invoice-data-factory';
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
import { getVaccinationOrderModelWithId } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { getVaccinationOrderCollectionModels } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { VaccinationOrderModel } from 'src/app/models/vaccinationOrder/vaccination_order.model';
import { VaccinationOrderDataFactory } from 'src/app/lib/utils/factories/vaccination-order-data-factory';
import { getVaccinationOrderDetailModelWithId } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import { getVaccinationOrderDetailCollectionModels } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import { VaccinationOrderDetailModel } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model';
import { VaccinationOrderDetailDataFactory } from 'src/app/lib/utils/factories/vaccination-order-detail-data-factory';
import { getWarehouseInitialStockModelWithId } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model.selector';
import { getWarehouseInitialStockCollectionModels } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model.selector';
import { WarehouseInitialStockModel } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model';
import { WarehouseInitialStockDataFactory } from 'src/app/lib/utils/factories/warehouse-initial-stock-data-factory';
import { getWarehouseInventoryModelWithId } from 'src/app/models/warehouseInventory/warehouse_inventory.model.selector';
import { getWarehouseInventoryCollectionModels } from 'src/app/models/warehouseInventory/warehouse_inventory.model.selector';
import { WarehouseInventoryModel } from 'src/app/models/warehouseInventory/warehouse_inventory.model';
import { WarehouseInventoryDataFactory } from 'src/app/lib/utils/factories/warehouse-inventory-data-factory';

describe('Warehouse CRUD Edit component tests', () => {
	let fixture: ComponentFixture<WarehouseCrudEditComponent>
	let component: WarehouseCrudEditComponent;

	let warehouseModelState: WarehouseModelState;

	let store: MockStore<{ model: WarehouseModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let warehouseCountBehaviorSubject: BehaviorSubject<number>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;
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
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let locationModelsBehaviorSubject: BehaviorSubject<LocationModel[]>;
	let medicalFeeModelsBehaviorSubject: BehaviorSubject<MedicalFeeModel[]>;
	let medicalFeeItemComponentModelsBehaviorSubject: BehaviorSubject<MedicalFeeItemComponentModel[]>;
	let medicationCompoundModelsBehaviorSubject: BehaviorSubject<MedicationCompoundModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let medicationItemModelsBehaviorSubject: BehaviorSubject<MedicationItemModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let prescriptionCompoundModelsBehaviorSubject: BehaviorSubject<PrescriptionCompoundModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let prescriptionItemModelsBehaviorSubject: BehaviorSubject<PrescriptionItemModel[]>;
	let purchaseOrderModelsBehaviorSubject: BehaviorSubject<PurchaseOrderModel[]>;
	let purchaseOrderStockDetailModelsBehaviorSubject: BehaviorSubject<PurchaseOrderStockDetailModel[]>;
	let purchaseRequisitionModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionModel[]>;
	let purchaseRequisitionStockDetailModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionStockDetailModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let retailPharmacyModelsBehaviorSubject: BehaviorSubject<RetailPharmacyModel[]>;
	let retailPharmacyInvoiceModelsBehaviorSubject: BehaviorSubject<RetailPharmacyInvoiceModel[]>;
	let retailPharmacyStockDetailModelsBehaviorSubject: BehaviorSubject<RetailPharmacyStockDetailModel[]>;
	let returnSupplierModelsBehaviorSubject: BehaviorSubject<ReturnSupplierModel[]>;
	let returnSupplierStockDetailModelsBehaviorSubject: BehaviorSubject<ReturnSupplierStockDetailModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let stockCatalogueModelsBehaviorSubject: BehaviorSubject<StockCatalogueModel[]>;
	let stockControlModelsBehaviorSubject: BehaviorSubject<StockControlModel[]>;
	let stockTransactionDetailModelsBehaviorSubject: BehaviorSubject<StockTransactionDetailModel[]>;
	let stockTransactionPerDateModelsBehaviorSubject: BehaviorSubject<StockTransactionPerDateModel[]>;
	let stockTransactionPerDateTypeModelsBehaviorSubject: BehaviorSubject<StockTransactionPerDateTypeModel[]>;
	let supplierModelsBehaviorSubject: BehaviorSubject<SupplierModel[]>;
	let supplierProductDetailModelsBehaviorSubject: BehaviorSubject<SupplierProductDetailModel[]>;
	let transactionDetailTypeModelsBehaviorSubject: BehaviorSubject<TransactionDetailTypeModel[]>;
	let transferOrderModelsBehaviorSubject: BehaviorSubject<TransferOrderModel[]>;
	let transferOrderStockDetailModelsBehaviorSubject: BehaviorSubject<TransferOrderStockDetailModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;
	let vaccinationOrderDetailModelsBehaviorSubject: BehaviorSubject<VaccinationOrderDetailModel[]>;
	let warehouseInitialStockModelsBehaviorSubject: BehaviorSubject<WarehouseInitialStockModel[]>;
	let warehouseInventoryModelsBehaviorSubject: BehaviorSubject<WarehouseInventoryModel[]>;

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);

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

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const locationFactory: LocationDataFactory = new LocationDataFactory();
	const defaultLocationCount: number = 10;
	const defaultLocationEntities: LocationModel[] = locationFactory.createAll(defaultLocationCount);

	const medicalFeeFactory: MedicalFeeDataFactory = new MedicalFeeDataFactory();
	const defaultMedicalFeeCount: number = 10;
	const defaultMedicalFeeEntities: MedicalFeeModel[] = medicalFeeFactory.createAll(defaultMedicalFeeCount);

	const medicalFeeItemComponentFactory: MedicalFeeItemComponentDataFactory = new MedicalFeeItemComponentDataFactory();
	const defaultMedicalFeeItemComponentCount: number = 10;
	const defaultMedicalFeeItemComponentEntities: MedicalFeeItemComponentModel[] = medicalFeeItemComponentFactory.createAll(defaultMedicalFeeItemComponentCount);

	const medicationCompoundFactory: MedicationCompoundDataFactory = new MedicationCompoundDataFactory();
	const defaultMedicationCompoundCount: number = 10;
	const defaultMedicationCompoundEntities: MedicationCompoundModel[] = medicationCompoundFactory.createAll(defaultMedicationCompoundCount);

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const medicationItemFactory: MedicationItemDataFactory = new MedicationItemDataFactory();
	const defaultMedicationItemCount: number = 10;
	const defaultMedicationItemEntities: MedicationItemModel[] = medicationItemFactory.createAll(defaultMedicationItemCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

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

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const retailPharmacyFactory: RetailPharmacyDataFactory = new RetailPharmacyDataFactory();
	const defaultRetailPharmacyCount: number = 10;
	const defaultRetailPharmacyEntities: RetailPharmacyModel[] = retailPharmacyFactory.createAll(defaultRetailPharmacyCount);

	const retailPharmacyInvoiceFactory: RetailPharmacyInvoiceDataFactory = new RetailPharmacyInvoiceDataFactory();
	const defaultRetailPharmacyInvoiceCount: number = 10;
	const defaultRetailPharmacyInvoiceEntities: RetailPharmacyInvoiceModel[] = retailPharmacyInvoiceFactory.createAll(defaultRetailPharmacyInvoiceCount);

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

	const vaccinationOrderFactory: VaccinationOrderDataFactory = new VaccinationOrderDataFactory();
	const defaultVaccinationOrderCount: number = 10;
	const defaultVaccinationOrderEntities: VaccinationOrderModel[] = vaccinationOrderFactory.createAll(defaultVaccinationOrderCount);

	const vaccinationOrderDetailFactory: VaccinationOrderDetailDataFactory = new VaccinationOrderDetailDataFactory();
	const defaultVaccinationOrderDetailCount: number = 10;
	const defaultVaccinationOrderDetailEntities: VaccinationOrderDetailModel[] = vaccinationOrderDetailFactory.createAll(defaultVaccinationOrderDetailCount);

	const warehouseInitialStockFactory: WarehouseInitialStockDataFactory = new WarehouseInitialStockDataFactory();
	const defaultWarehouseInitialStockCount: number = 10;
	const defaultWarehouseInitialStockEntities: WarehouseInitialStockModel[] = warehouseInitialStockFactory.createAll(defaultWarehouseInitialStockCount);

	const warehouseInventoryFactory: WarehouseInventoryDataFactory = new WarehouseInventoryDataFactory();
	const defaultWarehouseInventoryCount: number = 10;
	const defaultWarehouseInventoryEntities: WarehouseInventoryModel[] = warehouseInventoryFactory.createAll(defaultWarehouseInventoryCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let warehouseWithId: WarehouseModel = defaultWarehouseEntities[0];
	let warehouseModelWithIdBehaviorSubject: BehaviorSubject<WarehouseModel>;

	warehouseWithId.batchStockBalancesWarehouse = defaultBatchStockBalanceEntities;
	warehouseWithId.batchStockBalancesWarehouseIds = warehouseWithId.batchStockBalancesWarehouse.map(batchStockBalancesWarehouse => batchStockBalancesWarehouse.id);

	warehouseWithId.batchStockBalances = defaultBatchStockBalancePerDateEntities;
	warehouseWithId.batchStockBalancesIds = warehouseWithId.batchStockBalances.map(batchStockBalances => batchStockBalances.id);

	warehouseWithId.batchStockTransactionDetails = defaultBatchStockTransactionDetailEntities;
	warehouseWithId.batchStockTransactionDetailsIds = warehouseWithId.batchStockTransactionDetails.map(batchStockTransactionDetails => batchStockTransactionDetails.id);

	warehouseWithId.destinationWarehouses = defaultTransferOrderEntities;
	warehouseWithId.destinationWarehousesIds = warehouseWithId.destinationWarehouses.map(destinationWarehouses => destinationWarehouses.id);

	warehouseWithId.goodsReceiveNoteBatchs = defaultGoodsReceiveNoteBatchEntities;
	warehouseWithId.goodsReceiveNoteBatchsIds = warehouseWithId.goodsReceiveNoteBatchs.map(goodsReceiveNoteBatchs => goodsReceiveNoteBatchs.id);

	warehouseWithId.goodsReceiveNotes = defaultGoodsReceiveNoteEntities;
	warehouseWithId.goodsReceiveNotesIds = warehouseWithId.goodsReceiveNotes.map(goodsReceiveNotes => goodsReceiveNotes.id);

	warehouseWithId.internalOrders = defaultInternalOrderEntities;
	warehouseWithId.internalOrdersIds = warehouseWithId.internalOrders.map(internalOrders => internalOrders.id);

	warehouseWithId.inventoryAdjusmentBatchs = defaultInventoryAdjusmentBatchEntities;
	warehouseWithId.inventoryAdjusmentBatchsIds = warehouseWithId.inventoryAdjusmentBatchs.map(inventoryAdjusmentBatchs => inventoryAdjusmentBatchs.id);

	warehouseWithId.inventoryAdjustments = defaultInventoryAdjustmentEntities;
	warehouseWithId.inventoryAdjustmentsIds = warehouseWithId.inventoryAdjustments.map(inventoryAdjustments => inventoryAdjustments.id);

	warehouseWithId.inventoryBatchCorrections = defaultInventoryBatchCorrectionEntities;
	warehouseWithId.inventoryBatchCorrectionsIds = warehouseWithId.inventoryBatchCorrections.map(inventoryBatchCorrections => inventoryBatchCorrections.id);

	warehouseWithId.locations = defaultLocationEntities;
	warehouseWithId.locationsIds = warehouseWithId.locations.map(locations => locations.id);

	warehouseWithId.medicalFees = defaultMedicalFeeEntities;
	warehouseWithId.medicalFeesIds = warehouseWithId.medicalFees.map(medicalFees => medicalFees.id);

	warehouseWithId.medicationHeaders = defaultMedicationHeaderEntities;
	warehouseWithId.medicationHeadersIds = warehouseWithId.medicationHeaders.map(medicationHeaders => medicationHeaders.id);

	warehouseWithId.prescriptionHeaders = defaultPrescriptionHeaderEntities;
	warehouseWithId.prescriptionHeadersIds = warehouseWithId.prescriptionHeaders.map(prescriptionHeaders => prescriptionHeaders.id);

	warehouseWithId.purchaseOrders = defaultPurchaseOrderEntities;
	warehouseWithId.purchaseOrdersIds = warehouseWithId.purchaseOrders.map(purchaseOrders => purchaseOrders.id);

	warehouseWithId.purchaseRequisitions = defaultPurchaseRequisitionEntities;
	warehouseWithId.purchaseRequisitionsIds = warehouseWithId.purchaseRequisitions.map(purchaseRequisitions => purchaseRequisitions.id);

	warehouseWithId.retailPharmacies = defaultRetailPharmacyEntities;
	warehouseWithId.retailPharmaciesIds = warehouseWithId.retailPharmacies.map(retailPharmacies => retailPharmacies.id);

	warehouseWithId.returnSuppliers = defaultReturnSupplierEntities;
	warehouseWithId.returnSuppliersIds = warehouseWithId.returnSuppliers.map(returnSuppliers => returnSuppliers.id);

	warehouseWithId.sourceWarehouses = defaultTransferOrderEntities;
	warehouseWithId.sourceWarehousesIds = warehouseWithId.sourceWarehouses.map(sourceWarehouses => sourceWarehouses.id);

	warehouseWithId.stockCatalogues = defaultStockCatalogueEntities;
	warehouseWithId.stockCataloguesIds = warehouseWithId.stockCatalogues.map(stockCatalogues => stockCatalogues.id);

	warehouseWithId.stockControls = defaultStockControlEntities;
	warehouseWithId.stockControlsIds = warehouseWithId.stockControls.map(stockControls => stockControls.id);

	warehouseWithId.stockTransactionDetails = defaultStockTransactionDetailEntities;
	warehouseWithId.stockTransactionDetailsIds = warehouseWithId.stockTransactionDetails.map(stockTransactionDetails => stockTransactionDetails.id);

	warehouseWithId.stockTransactionPerDateTypes = defaultStockTransactionPerDateTypeEntities;
	warehouseWithId.stockTransactionPerDateTypesIds = warehouseWithId.stockTransactionPerDateTypes.map(stockTransactionPerDateTypes => stockTransactionPerDateTypes.id);

	warehouseWithId.stockTransactionPerDates = defaultStockTransactionPerDateEntities;
	warehouseWithId.stockTransactionPerDatesIds = warehouseWithId.stockTransactionPerDates.map(stockTransactionPerDates => stockTransactionPerDates.id);

	warehouseWithId.vaccinationOrderDetails = defaultVaccinationOrderDetailEntities;
	warehouseWithId.vaccinationOrderDetailsIds = warehouseWithId.vaccinationOrderDetails.map(vaccinationOrderDetails => vaccinationOrderDetails.id);

	warehouseWithId.warehouseInitialStockS = defaultWarehouseInitialStockEntities;
	warehouseWithId.warehouseInitialStockSIds = warehouseWithId.warehouseInitialStockS.map(warehouseInitialStockS => warehouseInitialStockS.id);

	warehouseWithId.warehouseInventories = defaultWarehouseInventoryEntities;
	warehouseWithId.warehouseInventoriesIds = warehouseWithId.warehouseInventories.map(warehouseInventories => warehouseInventories.id);


	const routerState: RouterState = {
		url: 'warehouse-crud',
		urls: ['warehouse-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: WarehouseModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		warehouseModelState = initialWarehouseModelState;
		store.setState({model: warehouseModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		warehouseCountBehaviorSubject = new BehaviorSubject(defaultWarehouseCount);

		// selectors for all references
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);
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
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		locationModelsBehaviorSubject = new BehaviorSubject(defaultLocationEntities);
		medicalFeeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeEntities);
		medicalFeeItemComponentModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeItemComponentEntities);
		medicationCompoundModelsBehaviorSubject = new BehaviorSubject(defaultMedicationCompoundEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		medicationItemModelsBehaviorSubject = new BehaviorSubject(defaultMedicationItemEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		prescriptionCompoundModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionCompoundEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		prescriptionItemModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionItemEntities);
		purchaseOrderModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderEntities);
		purchaseOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderStockDetailEntities);
		purchaseRequisitionModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionEntities);
		purchaseRequisitionStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionStockDetailEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		retailPharmacyModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyEntities);
		retailPharmacyInvoiceModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyInvoiceEntities);
		retailPharmacyStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyStockDetailEntities);
		returnSupplierModelsBehaviorSubject = new BehaviorSubject(defaultReturnSupplierEntities);
		returnSupplierStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultReturnSupplierStockDetailEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		stockCatalogueModelsBehaviorSubject = new BehaviorSubject(defaultStockCatalogueEntities);
		stockControlModelsBehaviorSubject = new BehaviorSubject(defaultStockControlEntities);
		stockTransactionDetailModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionDetailEntities);
		stockTransactionPerDateModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionPerDateEntities);
		stockTransactionPerDateTypeModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionPerDateTypeEntities);
		supplierModelsBehaviorSubject = new BehaviorSubject(defaultSupplierEntities);
		supplierProductDetailModelsBehaviorSubject = new BehaviorSubject(defaultSupplierProductDetailEntities);
		transactionDetailTypeModelsBehaviorSubject = new BehaviorSubject(defaultTransactionDetailTypeEntities);
		transferOrderModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderEntities);
		transferOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderStockDetailEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);
		vaccinationOrderDetailModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderDetailEntities);
		warehouseInitialStockModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseInitialStockEntities);
		warehouseInventoryModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseInventoryEntities);

		// selectors for target entity and its related entity
		warehouseModelWithIdBehaviorSubject = new BehaviorSubject(warehouseWithId);

		spyOn(store, 'select')
			.withArgs(getCountWarehouseModels).and.returnValue(warehouseCountBehaviorSubject)
			.withArgs(getWarehouseModelWithId, warehouseWithId.id).and.returnValue(warehouseModelWithIdBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
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
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getLocationCollectionModels, jasmine.any(String)).and.returnValue(locationModelsBehaviorSubject)
			.withArgs(getMedicalFeeCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeModelsBehaviorSubject)
			.withArgs(getMedicalFeeItemComponentCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeItemComponentModelsBehaviorSubject)
			.withArgs(getMedicationCompoundCollectionModels, jasmine.any(String)).and.returnValue(medicationCompoundModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getMedicationItemCollectionModels, jasmine.any(String)).and.returnValue(medicationItemModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPrescriptionCompoundCollectionModels, jasmine.any(String)).and.returnValue(prescriptionCompoundModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getPrescriptionItemCollectionModels, jasmine.any(String)).and.returnValue(prescriptionItemModelsBehaviorSubject)
			.withArgs(getPurchaseOrderCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderModelsBehaviorSubject)
			.withArgs(getPurchaseOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderStockDetailModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionStockDetailCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionStockDetailModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRetailPharmacyCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyModelsBehaviorSubject)
			.withArgs(getRetailPharmacyInvoiceCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyInvoiceModelsBehaviorSubject)
			.withArgs(getRetailPharmacyStockDetailCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyStockDetailModelsBehaviorSubject)
			.withArgs(getReturnSupplierCollectionModels, jasmine.any(String)).and.returnValue(returnSupplierModelsBehaviorSubject)
			.withArgs(getReturnSupplierStockDetailCollectionModels, jasmine.any(String)).and.returnValue(returnSupplierStockDetailModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getStockCatalogueCollectionModels, jasmine.any(String)).and.returnValue(stockCatalogueModelsBehaviorSubject)
			.withArgs(getStockControlCollectionModels, jasmine.any(String)).and.returnValue(stockControlModelsBehaviorSubject)
			.withArgs(getStockTransactionDetailCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionDetailModelsBehaviorSubject)
			.withArgs(getStockTransactionPerDateCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionPerDateModelsBehaviorSubject)
			.withArgs(getStockTransactionPerDateTypeCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionPerDateTypeModelsBehaviorSubject)
			.withArgs(getSupplierCollectionModels, jasmine.any(String)).and.returnValue(supplierModelsBehaviorSubject)
			.withArgs(getSupplierProductDetailCollectionModels, jasmine.any(String)).and.returnValue(supplierProductDetailModelsBehaviorSubject)
			.withArgs(getTransactionDetailTypeCollectionModels, jasmine.any(String)).and.returnValue(transactionDetailTypeModelsBehaviorSubject)
			.withArgs(getTransferOrderCollectionModels, jasmine.any(String)).and.returnValue(transferOrderModelsBehaviorSubject)
			.withArgs(getTransferOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(transferOrderStockDetailModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getVaccinationOrderDetailCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderDetailModelsBehaviorSubject)
			.withArgs(getWarehouseInitialStockCollectionModels, jasmine.any(String)).and.returnValue(warehouseInitialStockModelsBehaviorSubject)
			.withArgs(getWarehouseInventoryCollectionModels, jasmine.any(String)).and.returnValue(warehouseInventoryModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				WarehouseCrudModule,
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

			fixture = TestBed.createComponent(WarehouseCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new WarehouseModel();
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
	it ('Renders the Warehouse CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Batch Stock Balances Warehouse relation.
	*
	* The button should only exist if batchStockBalancesWarehouseMultiCrudActive is true
	*/
	it ('Renders Batch Stock Balances Warehouse Add Entity button in create mode', fakeAsync(() => {
		const batchStockBalancesWarehouseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesWarehouseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!batchStockBalancesWarehouseButton).toEqual(component.batchStockBalancesWarehouseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Batch Stock Balances Warehouse', fakeAsync(() => {
		const batchStockBalancesWarehouseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesWarehouseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockBalancesWarehouseButton).toEqual(component.batchStockBalancesWarehouseMultiCrudActive);

		if (component.batchStockBalancesWarehouseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBatchStockBalancesWarehouseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesWarehouseDisplayName + ' from Model')).length;

			batchStockBalancesWarehouseButton.nativeElement.click();
			fixture.detectChanges();

			const actualBatchStockBalancesWarehouseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesWarehouseDisplayName + ' from Model')).length;

			expect(actualBatchStockBalancesWarehouseRemoveButtonCount).toEqual(initialBatchStockBalancesWarehouseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Batch Stock Balances Warehouse button', () => {
		const batchStockBalancesWarehouseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesWarehouseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockBalancesWarehouseButton).toEqual(component.batchStockBalancesWarehouseMultiCrudActive);

		if (component.batchStockBalancesWarehouseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			batchStockBalancesWarehouseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBatchStockBalancesWarehouseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesWarehouseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBatchStockBalancesWarehouseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBatchStockBalancesWarehouseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesWarehouseDisplayName + ' from Model'));

			expect(actualBatchStockBalancesWarehouseRemoveButtons.length).toEqual(initialBatchStockBalancesWarehouseRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Batch Stock Balances Warehouse button when one has already been added', () => {

		const batchStockBalancesWarehouseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesWarehouseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!batchStockBalancesWarehouseButton).toEqual(component.batchStockBalancesWarehouseMultiCrudActive);

		if (component.batchStockBalancesWarehouseMultiCrudActive) {
			batchStockBalancesWarehouseButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbatchStockBalancesWarehouseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.batchStockBalancesWarehouseDisplayName + ' to Model'));

			expect(updatedbatchStockBalancesWarehouseButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Batch Stock Balances Warehouse entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.batchStockBalancesWarehouseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const batchStockBalancesWarehouseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.batchStockBalancesWarehouseDisplayName + ' from Model')).length;

			expect(batchStockBalancesWarehouseRemoveButtonCount).toEqual(warehouseWithId.batchStockBalancesWarehouse.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(batchStockBalancesRemoveButtonCount).toEqual(warehouseWithId.batchStockBalances.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(batchStockTransactionDetailsRemoveButtonCount).toEqual(warehouseWithId.batchStockTransactionDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Destination Warehouses relation.
	*
	* The button should only exist if destinationWarehousesMultiCrudActive is true
	*/
	it ('Renders Destination Warehouses Add Entity button in create mode', fakeAsync(() => {
		const destinationWarehousesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.destinationWarehousesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!destinationWarehousesButton).toEqual(component.destinationWarehousesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Destination Warehouses', fakeAsync(() => {
		const destinationWarehousesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.destinationWarehousesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!destinationWarehousesButton).toEqual(component.destinationWarehousesMultiCrudActive);

		if (component.destinationWarehousesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDestinationWarehousesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.destinationWarehousesDisplayName + ' from Model')).length;

			destinationWarehousesButton.nativeElement.click();
			fixture.detectChanges();

			const actualDestinationWarehousesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.destinationWarehousesDisplayName + ' from Model')).length;

			expect(actualDestinationWarehousesRemoveButtonCount).toEqual(initialDestinationWarehousesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Destination Warehouses button', () => {
		const destinationWarehousesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.destinationWarehousesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!destinationWarehousesButton).toEqual(component.destinationWarehousesMultiCrudActive);

		if (component.destinationWarehousesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			destinationWarehousesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDestinationWarehousesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.destinationWarehousesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDestinationWarehousesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDestinationWarehousesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.destinationWarehousesDisplayName + ' from Model'));

			expect(actualDestinationWarehousesRemoveButtons.length).toEqual(initialDestinationWarehousesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Destination Warehouses button when one has already been added', () => {

		const destinationWarehousesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.destinationWarehousesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!destinationWarehousesButton).toEqual(component.destinationWarehousesMultiCrudActive);

		if (component.destinationWarehousesMultiCrudActive) {
			destinationWarehousesButton.nativeElement.click();
			fixture.detectChanges();

			const updateddestinationWarehousesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.destinationWarehousesDisplayName + ' to Model'));

			expect(updateddestinationWarehousesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Destination Warehouses entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.destinationWarehousesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const destinationWarehousesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.destinationWarehousesDisplayName + ' from Model')).length;

			expect(destinationWarehousesRemoveButtonCount).toEqual(warehouseWithId.destinationWarehouses.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(goodsReceiveNoteBatchsRemoveButtonCount).toEqual(warehouseWithId.goodsReceiveNoteBatchs.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Goods Receive Notes relation.
	*
	* The button should only exist if goodsReceiveNotesMultiCrudActive is true
	*/
	it ('Renders Goods Receive Notes Add Entity button in create mode', fakeAsync(() => {
		const goodsReceiveNotesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!goodsReceiveNotesButton).toEqual(component.goodsReceiveNotesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Goods Receive Notes', fakeAsync(() => {
		const goodsReceiveNotesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNotesButton).toEqual(component.goodsReceiveNotesMultiCrudActive);

		if (component.goodsReceiveNotesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialGoodsReceiveNotesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model')).length;

			goodsReceiveNotesButton.nativeElement.click();
			fixture.detectChanges();

			const actualGoodsReceiveNotesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model')).length;

			expect(actualGoodsReceiveNotesRemoveButtonCount).toEqual(initialGoodsReceiveNotesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Goods Receive Notes button', () => {
		const goodsReceiveNotesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNotesButton).toEqual(component.goodsReceiveNotesMultiCrudActive);

		if (component.goodsReceiveNotesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			goodsReceiveNotesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialGoodsReceiveNotesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialGoodsReceiveNotesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualGoodsReceiveNotesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model'));

			expect(actualGoodsReceiveNotesRemoveButtons.length).toEqual(initialGoodsReceiveNotesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Goods Receive Notes button when one has already been added', () => {

		const goodsReceiveNotesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNotesButton).toEqual(component.goodsReceiveNotesMultiCrudActive);

		if (component.goodsReceiveNotesMultiCrudActive) {
			goodsReceiveNotesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedgoodsReceiveNotesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

			expect(updatedgoodsReceiveNotesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Goods Receive Notes entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.goodsReceiveNotesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const goodsReceiveNotesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model')).length;

			expect(goodsReceiveNotesRemoveButtonCount).toEqual(warehouseWithId.goodsReceiveNotes.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Internal Orders relation.
	*
	* The button should only exist if internalOrdersMultiCrudActive is true
	*/
	it ('Renders Internal Orders Add Entity button in create mode', fakeAsync(() => {
		const internalOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrdersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!internalOrdersButton).toEqual(component.internalOrdersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Internal Orders', fakeAsync(() => {
		const internalOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!internalOrdersButton).toEqual(component.internalOrdersMultiCrudActive);

		if (component.internalOrdersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInternalOrdersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrdersDisplayName + ' from Model')).length;

			internalOrdersButton.nativeElement.click();
			fixture.detectChanges();

			const actualInternalOrdersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrdersDisplayName + ' from Model')).length;

			expect(actualInternalOrdersRemoveButtonCount).toEqual(initialInternalOrdersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Internal Orders button', () => {
		const internalOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!internalOrdersButton).toEqual(component.internalOrdersMultiCrudActive);

		if (component.internalOrdersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			internalOrdersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInternalOrdersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrdersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInternalOrdersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInternalOrdersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrdersDisplayName + ' from Model'));

			expect(actualInternalOrdersRemoveButtons.length).toEqual(initialInternalOrdersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Internal Orders button when one has already been added', () => {

		const internalOrdersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!internalOrdersButton).toEqual(component.internalOrdersMultiCrudActive);

		if (component.internalOrdersMultiCrudActive) {
			internalOrdersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinternalOrdersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.internalOrdersDisplayName + ' to Model'));

			expect(updatedinternalOrdersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Internal Orders entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.internalOrdersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const internalOrdersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.internalOrdersDisplayName + ' from Model')).length;

			expect(internalOrdersRemoveButtonCount).toEqual(warehouseWithId.internalOrders.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(inventoryAdjusmentBatchsRemoveButtonCount).toEqual(warehouseWithId.inventoryAdjusmentBatchs.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Inventory Adjustments relation.
	*
	* The button should only exist if inventoryAdjustmentsMultiCrudActive is true
	*/
	it ('Renders Inventory Adjustments Add Entity button in create mode', fakeAsync(() => {
		const inventoryAdjustmentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!inventoryAdjustmentsButton).toEqual(component.inventoryAdjustmentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Inventory Adjustments', fakeAsync(() => {
		const inventoryAdjustmentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjustmentsButton).toEqual(component.inventoryAdjustmentsMultiCrudActive);

		if (component.inventoryAdjustmentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInventoryAdjustmentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model')).length;

			inventoryAdjustmentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInventoryAdjustmentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model')).length;

			expect(actualInventoryAdjustmentsRemoveButtonCount).toEqual(initialInventoryAdjustmentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Inventory Adjustments button', () => {
		const inventoryAdjustmentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjustmentsButton).toEqual(component.inventoryAdjustmentsMultiCrudActive);

		if (component.inventoryAdjustmentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			inventoryAdjustmentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInventoryAdjustmentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInventoryAdjustmentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInventoryAdjustmentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model'));

			expect(actualInventoryAdjustmentsRemoveButtons.length).toEqual(initialInventoryAdjustmentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Inventory Adjustments button when one has already been added', () => {

		const inventoryAdjustmentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjustmentsButton).toEqual(component.inventoryAdjustmentsMultiCrudActive);

		if (component.inventoryAdjustmentsMultiCrudActive) {
			inventoryAdjustmentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinventoryAdjustmentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

			expect(updatedinventoryAdjustmentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Inventory Adjustments entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.inventoryAdjustmentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const inventoryAdjustmentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model')).length;

			expect(inventoryAdjustmentsRemoveButtonCount).toEqual(warehouseWithId.inventoryAdjustments.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Inventory Batch Corrections relation.
	*
	* The button should only exist if inventoryBatchCorrectionsMultiCrudActive is true
	*/
	it ('Renders Inventory Batch Corrections Add Entity button in create mode', fakeAsync(() => {
		const inventoryBatchCorrectionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!inventoryBatchCorrectionsButton).toEqual(component.inventoryBatchCorrectionsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Inventory Batch Corrections', fakeAsync(() => {
		const inventoryBatchCorrectionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryBatchCorrectionsButton).toEqual(component.inventoryBatchCorrectionsMultiCrudActive);

		if (component.inventoryBatchCorrectionsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInventoryBatchCorrectionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionsDisplayName + ' from Model')).length;

			inventoryBatchCorrectionsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInventoryBatchCorrectionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionsDisplayName + ' from Model')).length;

			expect(actualInventoryBatchCorrectionsRemoveButtonCount).toEqual(initialInventoryBatchCorrectionsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Inventory Batch Corrections button', () => {
		const inventoryBatchCorrectionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryBatchCorrectionsButton).toEqual(component.inventoryBatchCorrectionsMultiCrudActive);

		if (component.inventoryBatchCorrectionsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			inventoryBatchCorrectionsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInventoryBatchCorrectionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInventoryBatchCorrectionsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInventoryBatchCorrectionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionsDisplayName + ' from Model'));

			expect(actualInventoryBatchCorrectionsRemoveButtons.length).toEqual(initialInventoryBatchCorrectionsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Inventory Batch Corrections button when one has already been added', () => {

		const inventoryBatchCorrectionsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryBatchCorrectionsButton).toEqual(component.inventoryBatchCorrectionsMultiCrudActive);

		if (component.inventoryBatchCorrectionsMultiCrudActive) {
			inventoryBatchCorrectionsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinventoryBatchCorrectionsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryBatchCorrectionsDisplayName + ' to Model'));

			expect(updatedinventoryBatchCorrectionsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Inventory Batch Corrections entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.inventoryBatchCorrectionsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const inventoryBatchCorrectionsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryBatchCorrectionsDisplayName + ' from Model')).length;

			expect(inventoryBatchCorrectionsRemoveButtonCount).toEqual(warehouseWithId.inventoryBatchCorrections.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Locations relation.
	*
	* The button should only exist if locationsMultiCrudActive is true
	*/
	it ('Renders Locations Add Entity button in create mode', fakeAsync(() => {
		const locationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.locationsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!locationsButton).toEqual(component.locationsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Locations', fakeAsync(() => {
		const locationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.locationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!locationsButton).toEqual(component.locationsMultiCrudActive);

		if (component.locationsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialLocationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.locationsDisplayName + ' from Model')).length;

			locationsButton.nativeElement.click();
			fixture.detectChanges();

			const actualLocationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.locationsDisplayName + ' from Model')).length;

			expect(actualLocationsRemoveButtonCount).toEqual(initialLocationsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Locations button', () => {
		const locationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.locationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!locationsButton).toEqual(component.locationsMultiCrudActive);

		if (component.locationsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			locationsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialLocationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.locationsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialLocationsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualLocationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.locationsDisplayName + ' from Model'));

			expect(actualLocationsRemoveButtons.length).toEqual(initialLocationsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Locations button when one has already been added', () => {

		const locationsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.locationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!locationsButton).toEqual(component.locationsMultiCrudActive);

		if (component.locationsMultiCrudActive) {
			locationsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedlocationsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.locationsDisplayName + ' to Model'));

			expect(updatedlocationsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Locations entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.locationsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const locationsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.locationsDisplayName + ' from Model')).length;

			expect(locationsRemoveButtonCount).toEqual(warehouseWithId.locations.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Fees relation.
	*
	* The button should only exist if medicalFeesMultiCrudActive is true
	*/
	it ('Renders Medical Fees Add Entity button in create mode', fakeAsync(() => {
		const medicalFeesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalFeesButton).toEqual(component.medicalFeesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Fees', fakeAsync(() => {
		const medicalFeesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalFeesButton).toEqual(component.medicalFeesMultiCrudActive);

		if (component.medicalFeesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalFeesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeesDisplayName + ' from Model')).length;

			medicalFeesButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalFeesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeesDisplayName + ' from Model')).length;

			expect(actualMedicalFeesRemoveButtonCount).toEqual(initialMedicalFeesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Fees button', () => {
		const medicalFeesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalFeesButton).toEqual(component.medicalFeesMultiCrudActive);

		if (component.medicalFeesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalFeesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalFeesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalFeesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalFeesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeesDisplayName + ' from Model'));

			expect(actualMedicalFeesRemoveButtons.length).toEqual(initialMedicalFeesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Fees button when one has already been added', () => {

		const medicalFeesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalFeesButton).toEqual(component.medicalFeesMultiCrudActive);

		if (component.medicalFeesMultiCrudActive) {
			medicalFeesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalFeesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeesDisplayName + ' to Model'));

			expect(updatedmedicalFeesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Fees entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalFeesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalFeesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeesDisplayName + ' from Model')).length;

			expect(medicalFeesRemoveButtonCount).toEqual(warehouseWithId.medicalFees.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medication Headers relation.
	*
	* The button should only exist if medicationHeadersMultiCrudActive is true
	*/
	it ('Renders Medication Headers Add Entity button in create mode', fakeAsync(() => {
		const medicationHeadersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeadersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicationHeadersButton).toEqual(component.medicationHeadersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medication Headers', fakeAsync(() => {
		const medicationHeadersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeadersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationHeadersButton).toEqual(component.medicationHeadersMultiCrudActive);

		if (component.medicationHeadersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicationHeadersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeadersDisplayName + ' from Model')).length;

			medicationHeadersButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicationHeadersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeadersDisplayName + ' from Model')).length;

			expect(actualMedicationHeadersRemoveButtonCount).toEqual(initialMedicationHeadersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medication Headers button', () => {
		const medicationHeadersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeadersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationHeadersButton).toEqual(component.medicationHeadersMultiCrudActive);

		if (component.medicationHeadersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicationHeadersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicationHeadersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeadersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicationHeadersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicationHeadersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeadersDisplayName + ' from Model'));

			expect(actualMedicationHeadersRemoveButtons.length).toEqual(initialMedicationHeadersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medication Headers button when one has already been added', () => {

		const medicationHeadersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeadersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationHeadersButton).toEqual(component.medicationHeadersMultiCrudActive);

		if (component.medicationHeadersMultiCrudActive) {
			medicationHeadersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicationHeadersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeadersDisplayName + ' to Model'));

			expect(updatedmedicationHeadersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medication Headers entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicationHeadersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicationHeadersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeadersDisplayName + ' from Model')).length;

			expect(medicationHeadersRemoveButtonCount).toEqual(warehouseWithId.medicationHeaders.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Prescription Headers relation.
	*
	* The button should only exist if prescriptionHeadersMultiCrudActive is true
	*/
	it ('Renders Prescription Headers Add Entity button in create mode', fakeAsync(() => {
		const prescriptionHeadersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeadersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!prescriptionHeadersButton).toEqual(component.prescriptionHeadersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Prescription Headers', fakeAsync(() => {
		const prescriptionHeadersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeadersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionHeadersButton).toEqual(component.prescriptionHeadersMultiCrudActive);

		if (component.prescriptionHeadersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPrescriptionHeadersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeadersDisplayName + ' from Model')).length;

			prescriptionHeadersButton.nativeElement.click();
			fixture.detectChanges();

			const actualPrescriptionHeadersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeadersDisplayName + ' from Model')).length;

			expect(actualPrescriptionHeadersRemoveButtonCount).toEqual(initialPrescriptionHeadersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Prescription Headers button', () => {
		const prescriptionHeadersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeadersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionHeadersButton).toEqual(component.prescriptionHeadersMultiCrudActive);

		if (component.prescriptionHeadersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			prescriptionHeadersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPrescriptionHeadersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeadersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPrescriptionHeadersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPrescriptionHeadersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeadersDisplayName + ' from Model'));

			expect(actualPrescriptionHeadersRemoveButtons.length).toEqual(initialPrescriptionHeadersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Prescription Headers button when one has already been added', () => {

		const prescriptionHeadersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeadersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionHeadersButton).toEqual(component.prescriptionHeadersMultiCrudActive);

		if (component.prescriptionHeadersMultiCrudActive) {
			prescriptionHeadersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedprescriptionHeadersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeadersDisplayName + ' to Model'));

			expect(updatedprescriptionHeadersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Prescription Headers entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.prescriptionHeadersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const prescriptionHeadersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeadersDisplayName + ' from Model')).length;

			expect(prescriptionHeadersRemoveButtonCount).toEqual(warehouseWithId.prescriptionHeaders.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Purchase Orders relation.
	*
	* The button should only exist if purchaseOrdersMultiCrudActive is true
	*/
	it ('Renders Purchase Orders Add Entity button in create mode', fakeAsync(() => {
		const purchaseOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!purchaseOrdersButton).toEqual(component.purchaseOrdersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Purchase Orders', fakeAsync(() => {
		const purchaseOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseOrdersButton).toEqual(component.purchaseOrdersMultiCrudActive);

		if (component.purchaseOrdersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPurchaseOrdersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model')).length;

			purchaseOrdersButton.nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseOrdersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model')).length;

			expect(actualPurchaseOrdersRemoveButtonCount).toEqual(initialPurchaseOrdersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Purchase Orders button', () => {
		const purchaseOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseOrdersButton).toEqual(component.purchaseOrdersMultiCrudActive);

		if (component.purchaseOrdersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			purchaseOrdersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPurchaseOrdersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPurchaseOrdersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseOrdersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model'));

			expect(actualPurchaseOrdersRemoveButtons.length).toEqual(initialPurchaseOrdersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Purchase Orders button when one has already been added', () => {

		const purchaseOrdersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseOrdersButton).toEqual(component.purchaseOrdersMultiCrudActive);

		if (component.purchaseOrdersMultiCrudActive) {
			purchaseOrdersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpurchaseOrdersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

			expect(updatedpurchaseOrdersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Purchase Orders entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.purchaseOrdersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const purchaseOrdersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model')).length;

			expect(purchaseOrdersRemoveButtonCount).toEqual(warehouseWithId.purchaseOrders.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Purchase Requisitions relation.
	*
	* The button should only exist if purchaseRequisitionsMultiCrudActive is true
	*/
	it ('Renders Purchase Requisitions Add Entity button in create mode', fakeAsync(() => {
		const purchaseRequisitionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!purchaseRequisitionsButton).toEqual(component.purchaseRequisitionsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Purchase Requisitions', fakeAsync(() => {
		const purchaseRequisitionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseRequisitionsButton).toEqual(component.purchaseRequisitionsMultiCrudActive);

		if (component.purchaseRequisitionsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPurchaseRequisitionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model')).length;

			purchaseRequisitionsButton.nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseRequisitionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model')).length;

			expect(actualPurchaseRequisitionsRemoveButtonCount).toEqual(initialPurchaseRequisitionsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Purchase Requisitions button', () => {
		const purchaseRequisitionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseRequisitionsButton).toEqual(component.purchaseRequisitionsMultiCrudActive);

		if (component.purchaseRequisitionsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			purchaseRequisitionsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPurchaseRequisitionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPurchaseRequisitionsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseRequisitionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model'));

			expect(actualPurchaseRequisitionsRemoveButtons.length).toEqual(initialPurchaseRequisitionsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Purchase Requisitions button when one has already been added', () => {

		const purchaseRequisitionsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseRequisitionsButton).toEqual(component.purchaseRequisitionsMultiCrudActive);

		if (component.purchaseRequisitionsMultiCrudActive) {
			purchaseRequisitionsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpurchaseRequisitionsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

			expect(updatedpurchaseRequisitionsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Purchase Requisitions entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.purchaseRequisitionsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const purchaseRequisitionsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model')).length;

			expect(purchaseRequisitionsRemoveButtonCount).toEqual(warehouseWithId.purchaseRequisitions.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Retail Pharmacies relation.
	*
	* The button should only exist if retailPharmaciesMultiCrudActive is true
	*/
	it ('Renders Retail Pharmacies Add Entity button in create mode', fakeAsync(() => {
		const retailPharmaciesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmaciesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!retailPharmaciesButton).toEqual(component.retailPharmaciesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Retail Pharmacies', fakeAsync(() => {
		const retailPharmaciesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmaciesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmaciesButton).toEqual(component.retailPharmaciesMultiCrudActive);

		if (component.retailPharmaciesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRetailPharmaciesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmaciesDisplayName + ' from Model')).length;

			retailPharmaciesButton.nativeElement.click();
			fixture.detectChanges();

			const actualRetailPharmaciesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmaciesDisplayName + ' from Model')).length;

			expect(actualRetailPharmaciesRemoveButtonCount).toEqual(initialRetailPharmaciesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Retail Pharmacies button', () => {
		const retailPharmaciesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmaciesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmaciesButton).toEqual(component.retailPharmaciesMultiCrudActive);

		if (component.retailPharmaciesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			retailPharmaciesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRetailPharmaciesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmaciesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRetailPharmaciesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRetailPharmaciesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmaciesDisplayName + ' from Model'));

			expect(actualRetailPharmaciesRemoveButtons.length).toEqual(initialRetailPharmaciesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Retail Pharmacies button when one has already been added', () => {

		const retailPharmaciesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmaciesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmaciesButton).toEqual(component.retailPharmaciesMultiCrudActive);

		if (component.retailPharmaciesMultiCrudActive) {
			retailPharmaciesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedretailPharmaciesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmaciesDisplayName + ' to Model'));

			expect(updatedretailPharmaciesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Retail Pharmacies entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.retailPharmaciesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const retailPharmaciesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmaciesDisplayName + ' from Model')).length;

			expect(retailPharmaciesRemoveButtonCount).toEqual(warehouseWithId.retailPharmacies.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Return Suppliers relation.
	*
	* The button should only exist if returnSuppliersMultiCrudActive is true
	*/
	it ('Renders Return Suppliers Add Entity button in create mode', fakeAsync(() => {
		const returnSuppliersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!returnSuppliersButton).toEqual(component.returnSuppliersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Return Suppliers', fakeAsync(() => {
		const returnSuppliersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!returnSuppliersButton).toEqual(component.returnSuppliersMultiCrudActive);

		if (component.returnSuppliersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialReturnSuppliersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model')).length;

			returnSuppliersButton.nativeElement.click();
			fixture.detectChanges();

			const actualReturnSuppliersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model')).length;

			expect(actualReturnSuppliersRemoveButtonCount).toEqual(initialReturnSuppliersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Return Suppliers button', () => {
		const returnSuppliersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!returnSuppliersButton).toEqual(component.returnSuppliersMultiCrudActive);

		if (component.returnSuppliersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			returnSuppliersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialReturnSuppliersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialReturnSuppliersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualReturnSuppliersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model'));

			expect(actualReturnSuppliersRemoveButtons.length).toEqual(initialReturnSuppliersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Return Suppliers button when one has already been added', () => {

		const returnSuppliersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!returnSuppliersButton).toEqual(component.returnSuppliersMultiCrudActive);

		if (component.returnSuppliersMultiCrudActive) {
			returnSuppliersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedreturnSuppliersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

			expect(updatedreturnSuppliersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Return Suppliers entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.returnSuppliersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const returnSuppliersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model')).length;

			expect(returnSuppliersRemoveButtonCount).toEqual(warehouseWithId.returnSuppliers.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Source Warehouses relation.
	*
	* The button should only exist if sourceWarehousesMultiCrudActive is true
	*/
	it ('Renders Source Warehouses Add Entity button in create mode', fakeAsync(() => {
		const sourceWarehousesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sourceWarehousesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!sourceWarehousesButton).toEqual(component.sourceWarehousesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Source Warehouses', fakeAsync(() => {
		const sourceWarehousesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sourceWarehousesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sourceWarehousesButton).toEqual(component.sourceWarehousesMultiCrudActive);

		if (component.sourceWarehousesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSourceWarehousesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sourceWarehousesDisplayName + ' from Model')).length;

			sourceWarehousesButton.nativeElement.click();
			fixture.detectChanges();

			const actualSourceWarehousesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sourceWarehousesDisplayName + ' from Model')).length;

			expect(actualSourceWarehousesRemoveButtonCount).toEqual(initialSourceWarehousesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Source Warehouses button', () => {
		const sourceWarehousesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sourceWarehousesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sourceWarehousesButton).toEqual(component.sourceWarehousesMultiCrudActive);

		if (component.sourceWarehousesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			sourceWarehousesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSourceWarehousesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sourceWarehousesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSourceWarehousesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSourceWarehousesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sourceWarehousesDisplayName + ' from Model'));

			expect(actualSourceWarehousesRemoveButtons.length).toEqual(initialSourceWarehousesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Source Warehouses button when one has already been added', () => {

		const sourceWarehousesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.sourceWarehousesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sourceWarehousesButton).toEqual(component.sourceWarehousesMultiCrudActive);

		if (component.sourceWarehousesMultiCrudActive) {
			sourceWarehousesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsourceWarehousesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.sourceWarehousesDisplayName + ' to Model'));

			expect(updatedsourceWarehousesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Source Warehouses entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.sourceWarehousesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const sourceWarehousesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sourceWarehousesDisplayName + ' from Model')).length;

			expect(sourceWarehousesRemoveButtonCount).toEqual(warehouseWithId.sourceWarehouses.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Stock Catalogues relation.
	*
	* The button should only exist if stockCataloguesMultiCrudActive is true
	*/
	it ('Renders Stock Catalogues Add Entity button in create mode', fakeAsync(() => {
		const stockCataloguesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCataloguesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockCataloguesButton).toEqual(component.stockCataloguesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Catalogues', fakeAsync(() => {
		const stockCataloguesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCataloguesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCataloguesButton).toEqual(component.stockCataloguesMultiCrudActive);

		if (component.stockCataloguesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockCataloguesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCataloguesDisplayName + ' from Model')).length;

			stockCataloguesButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockCataloguesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCataloguesDisplayName + ' from Model')).length;

			expect(actualStockCataloguesRemoveButtonCount).toEqual(initialStockCataloguesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Catalogues button', () => {
		const stockCataloguesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCataloguesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCataloguesButton).toEqual(component.stockCataloguesMultiCrudActive);

		if (component.stockCataloguesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockCataloguesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockCataloguesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCataloguesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockCataloguesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockCataloguesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCataloguesDisplayName + ' from Model'));

			expect(actualStockCataloguesRemoveButtons.length).toEqual(initialStockCataloguesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Stock Catalogues button when one has already been added', () => {

		const stockCataloguesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCataloguesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockCataloguesButton).toEqual(component.stockCataloguesMultiCrudActive);

		if (component.stockCataloguesMultiCrudActive) {
			stockCataloguesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockCataloguesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockCataloguesDisplayName + ' to Model'));

			expect(updatedstockCataloguesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Stock Catalogues entities from model when loading in edit mode', () => {
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockCataloguesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockCataloguesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockCataloguesDisplayName + ' from Model')).length;

			expect(stockCataloguesRemoveButtonCount).toEqual(warehouseWithId.stockCatalogues.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(stockControlsRemoveButtonCount).toEqual(warehouseWithId.stockControls.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(stockTransactionDetailsRemoveButtonCount).toEqual(warehouseWithId.stockTransactionDetails.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(stockTransactionPerDateTypesRemoveButtonCount).toEqual(warehouseWithId.stockTransactionPerDateTypes.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(stockTransactionPerDatesRemoveButtonCount).toEqual(warehouseWithId.stockTransactionPerDates.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(vaccinationOrderDetailsRemoveButtonCount).toEqual(warehouseWithId.vaccinationOrderDetails.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(warehouseInitialStockSRemoveButtonCount).toEqual(warehouseWithId.warehouseInitialStockS.length);
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
		component.targetModel = warehouseWithId;
		component.targetModelId = warehouseWithId.id;
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

			expect(warehouseInventoriesRemoveButtonCount).toEqual(warehouseWithId.warehouseInventories.length);
		}
	});

});
