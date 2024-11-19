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
	getRetailPharmacyCollectionModels,
	getCountRetailPharmacyModels,
	getRetailPharmacyModelWithId
} from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { RetailPharmacyCrudModule } from '../retail-pharmacy-crud.module';
import { RetailPharmacyCrudEditComponent } from './retail-pharmacy-crud-edit.component';
import {
	RetailPharmacyModelState,
	initialState as initialRetailPharmacyModelState
} from 'src/app/models/retailPharmacy/retail_pharmacy.model.state';
import { RetailPharmacyDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-data-factory';
import { RetailPharmacyModel } from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import { CrudTileMode } from '../retail-pharmacy-crud.component';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
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
import { getCashReceiptModelWithId } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { getCashReceiptCollectionModels } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { CashReceiptModel } from 'src/app/models/cashReceipt/cash_receipt.model';
import { CashReceiptDataFactory } from 'src/app/lib/utils/factories/cash-receipt-data-factory';
import { getCashRefundModelWithId } from 'src/app/models/cashRefund/cash_refund.model.selector';
import { getCashRefundCollectionModels } from 'src/app/models/cashRefund/cash_refund.model.selector';
import { CashRefundModel } from 'src/app/models/cashRefund/cash_refund.model';
import { CashRefundDataFactory } from 'src/app/lib/utils/factories/cash-refund-data-factory';
import { getGoodsReceiveNoteModelWithId } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import { getGoodsReceiveNoteCollectionModels } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import { GoodsReceiveNoteModel } from 'src/app/models/goodsReceiveNote/goods_receive_note.model';
import { GoodsReceiveNoteDataFactory } from 'src/app/lib/utils/factories/goods-receive-note-data-factory';
import { getGoodsReceiveNoteBatchModelWithId } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.selector';
import { getGoodsReceiveNoteBatchCollectionModels } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.selector';
import { GoodsReceiveNoteBatchModel } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model';
import { GoodsReceiveNoteBatchDataFactory } from 'src/app/lib/utils/factories/goods-receive-note-batch-data-factory';
import { getInformedConsentModelWithId } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { getInformedConsentCollectionModels } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { InformedConsentModel } from 'src/app/models/informedConsent/informed_consent.model';
import { InformedConsentDataFactory } from 'src/app/lib/utils/factories/informed-consent-data-factory';
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
import { getInventoryBatchCorrectionModelWithId } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.selector';
import { getInventoryBatchCorrectionCollectionModels } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.selector';
import { InventoryBatchCorrectionModel } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model';
import { InventoryBatchCorrectionDataFactory } from 'src/app/lib/utils/factories/inventory-batch-correction-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
import { getInvoiceSummaryModelWithId } from 'src/app/models/invoiceSummary/invoice_summary.model.selector';
import { getInvoiceSummaryCollectionModels } from 'src/app/models/invoiceSummary/invoice_summary.model.selector';
import { InvoiceSummaryModel } from 'src/app/models/invoiceSummary/invoice_summary.model';
import { InvoiceSummaryDataFactory } from 'src/app/lib/utils/factories/invoice-summary-data-factory';
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
import { getPatientCaseHistoryModelWithId } from 'src/app/models/patientCaseHistory/patient_case_history.model.selector';
import { getPatientCaseHistoryCollectionModels } from 'src/app/models/patientCaseHistory/patient_case_history.model.selector';
import { PatientCaseHistoryModel } from 'src/app/models/patientCaseHistory/patient_case_history.model';
import { PatientCaseHistoryDataFactory } from 'src/app/lib/utils/factories/patient-case-history-data-factory';
import { getPatientConsentModelWithId } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { getPatientConsentCollectionModels } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { PatientConsentModel } from 'src/app/models/patientConsent/patient_consent.model';
import { PatientConsentDataFactory } from 'src/app/lib/utils/factories/patient-consent-data-factory';
import { getPatientContactInfoModelWithId } from 'src/app/models/patientContactInfo/patient_contact_info.model.selector';
import { getPatientContactInfoCollectionModels } from 'src/app/models/patientContactInfo/patient_contact_info.model.selector';
import { PatientContactInfoModel } from 'src/app/models/patientContactInfo/patient_contact_info.model';
import { PatientContactInfoDataFactory } from 'src/app/lib/utils/factories/patient-contact-info-data-factory';
import { getPatientDetailModelWithId } from 'src/app/models/patientDetail/patient_detail.model.selector';
import { getPatientDetailCollectionModels } from 'src/app/models/patientDetail/patient_detail.model.selector';
import { PatientDetailModel } from 'src/app/models/patientDetail/patient_detail.model';
import { PatientDetailDataFactory } from 'src/app/lib/utils/factories/patient-detail-data-factory';
import { getPatientDetailAddressModelWithId } from 'src/app/models/patientDetailAddress/patient_detail_address.model.selector';
import { getPatientDetailAddressCollectionModels } from 'src/app/models/patientDetailAddress/patient_detail_address.model.selector';
import { PatientDetailAddressModel } from 'src/app/models/patientDetailAddress/patient_detail_address.model';
import { PatientDetailAddressDataFactory } from 'src/app/lib/utils/factories/patient-detail-address-data-factory';
import { getPatientEmergencyContactDetailModelWithId } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.selector';
import { getPatientEmergencyContactDetailCollectionModels } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.selector';
import { PatientEmergencyContactDetailModel } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model';
import { PatientEmergencyContactDetailDataFactory } from 'src/app/lib/utils/factories/patient-emergency-contact-detail-data-factory';
import { getPatientEmploymentDetailModelWithId } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.selector';
import { getPatientEmploymentDetailCollectionModels } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.selector';
import { PatientEmploymentDetailModel } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model';
import { PatientEmploymentDetailDataFactory } from 'src/app/lib/utils/factories/patient-employment-detail-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPatientPaymentSelfPayingModelWithId } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.selector';
import { getPatientPaymentSelfPayingCollectionModels } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.selector';
import { PatientPaymentSelfPayingModel } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model';
import { PatientPaymentSelfPayingDataFactory } from 'src/app/lib/utils/factories/patient-payment-self-paying-data-factory';
import { getPatientPaymentBPJSModelWithId } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { getPatientPaymentBPJSCollectionModels } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { PatientPaymentBPJSModel } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import { PatientPaymentBPJSDataFactory } from 'src/app/lib/utils/factories/patient-payment-bpjs-data-factory';
import { getPatientPaymentInsuranceModelWithId } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { getPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { PatientPaymentInsuranceModel } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model';
import { PatientPaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/patient-payment-insurance-data-factory';
import { getPatientPaymentOthersModelWithId } from 'src/app/models/patientPaymentOthers/patient_payment_others.model.selector';
import { getPatientPaymentOthersCollectionModels } from 'src/app/models/patientPaymentOthers/patient_payment_others.model.selector';
import { PatientPaymentOthersModel } from 'src/app/models/patientPaymentOthers/patient_payment_others.model';
import { PatientPaymentOthersDataFactory } from 'src/app/lib/utils/factories/patient-payment-others-data-factory';
import { getPatientPersonalInfoModelWithId } from 'src/app/models/patientPersonalInfo/patient_personal_info.model.selector';
import { getPatientPersonalInfoCollectionModels } from 'src/app/models/patientPersonalInfo/patient_personal_info.model.selector';
import { PatientPersonalInfoModel } from 'src/app/models/patientPersonalInfo/patient_personal_info.model';
import { PatientPersonalInfoDataFactory } from 'src/app/lib/utils/factories/patient-personal-info-data-factory';
import { getPatientSupportingDocumentModelWithId } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.selector';
import { getPatientSupportingDocumentCollectionModels } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.selector';
import { PatientSupportingDocumentModel } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model';
import { PatientSupportingDocumentDataFactory } from 'src/app/lib/utils/factories/patient-supporting-document-data-factory';
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
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

describe('Retail Pharmacy CRUD Edit component tests', () => {
	let fixture: ComponentFixture<RetailPharmacyCrudEditComponent>
	let component: RetailPharmacyCrudEditComponent;

	let retailPharmacyModelState: RetailPharmacyModelState;

	let store: MockStore<{ model: RetailPharmacyModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let retailPharmacyCountBehaviorSubject: BehaviorSubject<number>;
	let retailPharmacyModelsBehaviorSubject: BehaviorSubject<RetailPharmacyModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let batchStockBalanceModelsBehaviorSubject: BehaviorSubject<BatchStockBalanceModel[]>;
	let batchStockBalancePerDateModelsBehaviorSubject: BehaviorSubject<BatchStockBalancePerDateModel[]>;
	let batchStockTransactionDetailModelsBehaviorSubject: BehaviorSubject<BatchStockTransactionDetailModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let cashRefundModelsBehaviorSubject: BehaviorSubject<CashRefundModel[]>;
	let goodsReceiveNoteModelsBehaviorSubject: BehaviorSubject<GoodsReceiveNoteModel[]>;
	let goodsReceiveNoteBatchModelsBehaviorSubject: BehaviorSubject<GoodsReceiveNoteBatchModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let internalOrderModelsBehaviorSubject: BehaviorSubject<InternalOrderModel[]>;
	let inventoryAdjusmentBatchModelsBehaviorSubject: BehaviorSubject<InventoryAdjusmentBatchModel[]>;
	let inventoryAdjustmentModelsBehaviorSubject: BehaviorSubject<InventoryAdjustmentModel[]>;
	let inventoryBatchCorrectionModelsBehaviorSubject: BehaviorSubject<InventoryBatchCorrectionModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let invoiceSummaryModelsBehaviorSubject: BehaviorSubject<InvoiceSummaryModel[]>;
	let locationModelsBehaviorSubject: BehaviorSubject<LocationModel[]>;
	let medicalFeeModelsBehaviorSubject: BehaviorSubject<MedicalFeeModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let patientCaseHistoryModelsBehaviorSubject: BehaviorSubject<PatientCaseHistoryModel[]>;
	let patientConsentModelsBehaviorSubject: BehaviorSubject<PatientConsentModel[]>;
	let patientContactInfoModelsBehaviorSubject: BehaviorSubject<PatientContactInfoModel[]>;
	let patientDetailModelsBehaviorSubject: BehaviorSubject<PatientDetailModel[]>;
	let patientDetailAddressModelsBehaviorSubject: BehaviorSubject<PatientDetailAddressModel[]>;
	let patientEmergencyContactDetailModelsBehaviorSubject: BehaviorSubject<PatientEmergencyContactDetailModel[]>;
	let patientEmploymentDetailModelsBehaviorSubject: BehaviorSubject<PatientEmploymentDetailModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<PatientPaymentSelfPayingModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;
	let patientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientPaymentInsuranceModel[]>;
	let patientPaymentOthersModelsBehaviorSubject: BehaviorSubject<PatientPaymentOthersModel[]>;
	let patientPersonalInfoModelsBehaviorSubject: BehaviorSubject<PatientPersonalInfoModel[]>;
	let patientSupportingDocumentModelsBehaviorSubject: BehaviorSubject<PatientSupportingDocumentModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let purchaseOrderModelsBehaviorSubject: BehaviorSubject<PurchaseOrderModel[]>;
	let purchaseRequisitionModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionModel[]>;
	let retailPharmacyInvoiceModelsBehaviorSubject: BehaviorSubject<RetailPharmacyInvoiceModel[]>;
	let retailPharmacyStockDetailModelsBehaviorSubject: BehaviorSubject<RetailPharmacyStockDetailModel[]>;
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

	const retailPharmacyFactory: RetailPharmacyDataFactory = new RetailPharmacyDataFactory();
	const defaultRetailPharmacyCount: number = 10;
	const defaultRetailPharmacyEntities: RetailPharmacyModel[] = retailPharmacyFactory.createAll(defaultRetailPharmacyCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const batchStockBalanceFactory: BatchStockBalanceDataFactory = new BatchStockBalanceDataFactory();
	const defaultBatchStockBalanceCount: number = 10;
	const defaultBatchStockBalanceEntities: BatchStockBalanceModel[] = batchStockBalanceFactory.createAll(defaultBatchStockBalanceCount);

	const batchStockBalancePerDateFactory: BatchStockBalancePerDateDataFactory = new BatchStockBalancePerDateDataFactory();
	const defaultBatchStockBalancePerDateCount: number = 10;
	const defaultBatchStockBalancePerDateEntities: BatchStockBalancePerDateModel[] = batchStockBalancePerDateFactory.createAll(defaultBatchStockBalancePerDateCount);

	const batchStockTransactionDetailFactory: BatchStockTransactionDetailDataFactory = new BatchStockTransactionDetailDataFactory();
	const defaultBatchStockTransactionDetailCount: number = 10;
	const defaultBatchStockTransactionDetailEntities: BatchStockTransactionDetailModel[] = batchStockTransactionDetailFactory.createAll(defaultBatchStockTransactionDetailCount);

	const cashReceiptFactory: CashReceiptDataFactory = new CashReceiptDataFactory();
	const defaultCashReceiptCount: number = 10;
	const defaultCashReceiptEntities: CashReceiptModel[] = cashReceiptFactory.createAll(defaultCashReceiptCount);

	const cashRefundFactory: CashRefundDataFactory = new CashRefundDataFactory();
	const defaultCashRefundCount: number = 10;
	const defaultCashRefundEntities: CashRefundModel[] = cashRefundFactory.createAll(defaultCashRefundCount);

	const goodsReceiveNoteFactory: GoodsReceiveNoteDataFactory = new GoodsReceiveNoteDataFactory();
	const defaultGoodsReceiveNoteCount: number = 10;
	const defaultGoodsReceiveNoteEntities: GoodsReceiveNoteModel[] = goodsReceiveNoteFactory.createAll(defaultGoodsReceiveNoteCount);

	const goodsReceiveNoteBatchFactory: GoodsReceiveNoteBatchDataFactory = new GoodsReceiveNoteBatchDataFactory();
	const defaultGoodsReceiveNoteBatchCount: number = 10;
	const defaultGoodsReceiveNoteBatchEntities: GoodsReceiveNoteBatchModel[] = goodsReceiveNoteBatchFactory.createAll(defaultGoodsReceiveNoteBatchCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const internalOrderFactory: InternalOrderDataFactory = new InternalOrderDataFactory();
	const defaultInternalOrderCount: number = 10;
	const defaultInternalOrderEntities: InternalOrderModel[] = internalOrderFactory.createAll(defaultInternalOrderCount);

	const inventoryAdjusmentBatchFactory: InventoryAdjusmentBatchDataFactory = new InventoryAdjusmentBatchDataFactory();
	const defaultInventoryAdjusmentBatchCount: number = 10;
	const defaultInventoryAdjusmentBatchEntities: InventoryAdjusmentBatchModel[] = inventoryAdjusmentBatchFactory.createAll(defaultInventoryAdjusmentBatchCount);

	const inventoryAdjustmentFactory: InventoryAdjustmentDataFactory = new InventoryAdjustmentDataFactory();
	const defaultInventoryAdjustmentCount: number = 10;
	const defaultInventoryAdjustmentEntities: InventoryAdjustmentModel[] = inventoryAdjustmentFactory.createAll(defaultInventoryAdjustmentCount);

	const inventoryBatchCorrectionFactory: InventoryBatchCorrectionDataFactory = new InventoryBatchCorrectionDataFactory();
	const defaultInventoryBatchCorrectionCount: number = 10;
	const defaultInventoryBatchCorrectionEntities: InventoryBatchCorrectionModel[] = inventoryBatchCorrectionFactory.createAll(defaultInventoryBatchCorrectionCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const invoiceSummaryFactory: InvoiceSummaryDataFactory = new InvoiceSummaryDataFactory();
	const defaultInvoiceSummaryCount: number = 10;
	const defaultInvoiceSummaryEntities: InvoiceSummaryModel[] = invoiceSummaryFactory.createAll(defaultInvoiceSummaryCount);

	const locationFactory: LocationDataFactory = new LocationDataFactory();
	const defaultLocationCount: number = 10;
	const defaultLocationEntities: LocationModel[] = locationFactory.createAll(defaultLocationCount);

	const medicalFeeFactory: MedicalFeeDataFactory = new MedicalFeeDataFactory();
	const defaultMedicalFeeCount: number = 10;
	const defaultMedicalFeeEntities: MedicalFeeModel[] = medicalFeeFactory.createAll(defaultMedicalFeeCount);

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const patientCaseHistoryFactory: PatientCaseHistoryDataFactory = new PatientCaseHistoryDataFactory();
	const defaultPatientCaseHistoryCount: number = 10;
	const defaultPatientCaseHistoryEntities: PatientCaseHistoryModel[] = patientCaseHistoryFactory.createAll(defaultPatientCaseHistoryCount);

	const patientConsentFactory: PatientConsentDataFactory = new PatientConsentDataFactory();
	const defaultPatientConsentCount: number = 10;
	const defaultPatientConsentEntities: PatientConsentModel[] = patientConsentFactory.createAll(defaultPatientConsentCount);

	const patientContactInfoFactory: PatientContactInfoDataFactory = new PatientContactInfoDataFactory();
	const defaultPatientContactInfoCount: number = 10;
	const defaultPatientContactInfoEntities: PatientContactInfoModel[] = patientContactInfoFactory.createAll(defaultPatientContactInfoCount);

	const patientDetailFactory: PatientDetailDataFactory = new PatientDetailDataFactory();
	const defaultPatientDetailCount: number = 10;
	const defaultPatientDetailEntities: PatientDetailModel[] = patientDetailFactory.createAll(defaultPatientDetailCount);

	const patientDetailAddressFactory: PatientDetailAddressDataFactory = new PatientDetailAddressDataFactory();
	const defaultPatientDetailAddressCount: number = 10;
	const defaultPatientDetailAddressEntities: PatientDetailAddressModel[] = patientDetailAddressFactory.createAll(defaultPatientDetailAddressCount);

	const patientEmergencyContactDetailFactory: PatientEmergencyContactDetailDataFactory = new PatientEmergencyContactDetailDataFactory();
	const defaultPatientEmergencyContactDetailCount: number = 10;
	const defaultPatientEmergencyContactDetailEntities: PatientEmergencyContactDetailModel[] = patientEmergencyContactDetailFactory.createAll(defaultPatientEmergencyContactDetailCount);

	const patientEmploymentDetailFactory: PatientEmploymentDetailDataFactory = new PatientEmploymentDetailDataFactory();
	const defaultPatientEmploymentDetailCount: number = 10;
	const defaultPatientEmploymentDetailEntities: PatientEmploymentDetailModel[] = patientEmploymentDetailFactory.createAll(defaultPatientEmploymentDetailCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentSelfPayingFactory: PatientPaymentSelfPayingDataFactory = new PatientPaymentSelfPayingDataFactory();
	const defaultPatientPaymentSelfPayingCount: number = 10;
	const defaultPatientPaymentSelfPayingEntities: PatientPaymentSelfPayingModel[] = patientPaymentSelfPayingFactory.createAll(defaultPatientPaymentSelfPayingCount);

	const patientPaymentBPJSFactory: PatientPaymentBPJSDataFactory = new PatientPaymentBPJSDataFactory();
	const defaultPatientPaymentBPJSCount: number = 10;
	const defaultPatientPaymentBPJSEntities: PatientPaymentBPJSModel[] = patientPaymentBPJSFactory.createAll(defaultPatientPaymentBPJSCount);

	const patientPaymentInsuranceFactory: PatientPaymentInsuranceDataFactory = new PatientPaymentInsuranceDataFactory();
	const defaultPatientPaymentInsuranceCount: number = 10;
	const defaultPatientPaymentInsuranceEntities: PatientPaymentInsuranceModel[] = patientPaymentInsuranceFactory.createAll(defaultPatientPaymentInsuranceCount);

	const patientPaymentOthersFactory: PatientPaymentOthersDataFactory = new PatientPaymentOthersDataFactory();
	const defaultPatientPaymentOthersCount: number = 10;
	const defaultPatientPaymentOthersEntities: PatientPaymentOthersModel[] = patientPaymentOthersFactory.createAll(defaultPatientPaymentOthersCount);

	const patientPersonalInfoFactory: PatientPersonalInfoDataFactory = new PatientPersonalInfoDataFactory();
	const defaultPatientPersonalInfoCount: number = 10;
	const defaultPatientPersonalInfoEntities: PatientPersonalInfoModel[] = patientPersonalInfoFactory.createAll(defaultPatientPersonalInfoCount);

	const patientSupportingDocumentFactory: PatientSupportingDocumentDataFactory = new PatientSupportingDocumentDataFactory();
	const defaultPatientSupportingDocumentCount: number = 10;
	const defaultPatientSupportingDocumentEntities: PatientSupportingDocumentModel[] = patientSupportingDocumentFactory.createAll(defaultPatientSupportingDocumentCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const purchaseOrderFactory: PurchaseOrderDataFactory = new PurchaseOrderDataFactory();
	const defaultPurchaseOrderCount: number = 10;
	const defaultPurchaseOrderEntities: PurchaseOrderModel[] = purchaseOrderFactory.createAll(defaultPurchaseOrderCount);

	const purchaseRequisitionFactory: PurchaseRequisitionDataFactory = new PurchaseRequisitionDataFactory();
	const defaultPurchaseRequisitionCount: number = 10;
	const defaultPurchaseRequisitionEntities: PurchaseRequisitionModel[] = purchaseRequisitionFactory.createAll(defaultPurchaseRequisitionCount);

	const retailPharmacyInvoiceFactory: RetailPharmacyInvoiceDataFactory = new RetailPharmacyInvoiceDataFactory();
	const defaultRetailPharmacyInvoiceCount: number = 10;
	const defaultRetailPharmacyInvoiceEntities: RetailPharmacyInvoiceModel[] = retailPharmacyInvoiceFactory.createAll(defaultRetailPharmacyInvoiceCount);

	const retailPharmacyStockDetailFactory: RetailPharmacyStockDetailDataFactory = new RetailPharmacyStockDetailDataFactory();
	const defaultRetailPharmacyStockDetailCount: number = 10;
	const defaultRetailPharmacyStockDetailEntities: RetailPharmacyStockDetailModel[] = retailPharmacyStockDetailFactory.createAll(defaultRetailPharmacyStockDetailCount);

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
	let retailPharmacyWithId: RetailPharmacyModel = defaultRetailPharmacyEntities[0];
	let retailPharmacyModelWithIdBehaviorSubject: BehaviorSubject<RetailPharmacyModel>;

	retailPharmacyWithId.patientGeneralInfo = defaultPatientGeneralInfoEntities[0];
	retailPharmacyWithId.patientGeneralInfoId = retailPharmacyWithId.patientGeneralInfo.id;
	let patientGeneralInfoWithIdBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel>;

	retailPharmacyWithId.warehouse = defaultWarehouseEntities[0];
	retailPharmacyWithId.warehouseId = retailPharmacyWithId.warehouse.id;
	let warehouseWithIdBehaviorSubject: BehaviorSubject<WarehouseModel>;

	retailPharmacyWithId.retailPharmacyInvoices = defaultRetailPharmacyInvoiceEntities;
	retailPharmacyWithId.retailPharmacyInvoicesIds = retailPharmacyWithId.retailPharmacyInvoices.map(retailPharmacyInvoices => retailPharmacyInvoices.id);

	retailPharmacyWithId.retailPharmacyStockDetails = defaultRetailPharmacyStockDetailEntities;
	retailPharmacyWithId.retailPharmacyStockDetailsIds = retailPharmacyWithId.retailPharmacyStockDetails.map(retailPharmacyStockDetails => retailPharmacyStockDetails.id);


	const routerState: RouterState = {
		url: 'retail-pharmacy-crud',
		urls: ['retail-pharmacy-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: RetailPharmacyModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		retailPharmacyModelState = initialRetailPharmacyModelState;
		store.setState({model: retailPharmacyModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		retailPharmacyCountBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyCount);

		// selectors for all references
		retailPharmacyModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		batchStockBalanceModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockBalanceEntities);
		batchStockBalancePerDateModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockBalancePerDateEntities);
		batchStockTransactionDetailModelsBehaviorSubject = new BehaviorSubject(defaultBatchStockTransactionDetailEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		cashRefundModelsBehaviorSubject = new BehaviorSubject(defaultCashRefundEntities);
		goodsReceiveNoteModelsBehaviorSubject = new BehaviorSubject(defaultGoodsReceiveNoteEntities);
		goodsReceiveNoteBatchModelsBehaviorSubject = new BehaviorSubject(defaultGoodsReceiveNoteBatchEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		internalOrderModelsBehaviorSubject = new BehaviorSubject(defaultInternalOrderEntities);
		inventoryAdjusmentBatchModelsBehaviorSubject = new BehaviorSubject(defaultInventoryAdjusmentBatchEntities);
		inventoryAdjustmentModelsBehaviorSubject = new BehaviorSubject(defaultInventoryAdjustmentEntities);
		inventoryBatchCorrectionModelsBehaviorSubject = new BehaviorSubject(defaultInventoryBatchCorrectionEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		invoiceSummaryModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceSummaryEntities);
		locationModelsBehaviorSubject = new BehaviorSubject(defaultLocationEntities);
		medicalFeeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		patientCaseHistoryModelsBehaviorSubject = new BehaviorSubject(defaultPatientCaseHistoryEntities);
		patientConsentModelsBehaviorSubject = new BehaviorSubject(defaultPatientConsentEntities);
		patientContactInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientContactInfoEntities);
		patientDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientDetailEntities);
		patientDetailAddressModelsBehaviorSubject = new BehaviorSubject(defaultPatientDetailAddressEntities);
		patientEmergencyContactDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientEmergencyContactDetailEntities);
		patientEmploymentDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientEmploymentDetailEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentSelfPayingEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);
		patientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentInsuranceEntities);
		patientPaymentOthersModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentOthersEntities);
		patientPersonalInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientPersonalInfoEntities);
		patientSupportingDocumentModelsBehaviorSubject = new BehaviorSubject(defaultPatientSupportingDocumentEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		purchaseOrderModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderEntities);
		purchaseRequisitionModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionEntities);
		retailPharmacyInvoiceModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyInvoiceEntities);
		retailPharmacyStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyStockDetailEntities);
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
		retailPharmacyModelWithIdBehaviorSubject = new BehaviorSubject(retailPharmacyWithId);
		patientGeneralInfoWithIdBehaviorSubject = new BehaviorSubject(retailPharmacyWithId.patientGeneralInfo);
		warehouseWithIdBehaviorSubject = new BehaviorSubject(retailPharmacyWithId.warehouse);

		spyOn(store, 'select')
			.withArgs(getCountRetailPharmacyModels).and.returnValue(retailPharmacyCountBehaviorSubject)
			.withArgs(getRetailPharmacyModelWithId, retailPharmacyWithId.id).and.returnValue(retailPharmacyModelWithIdBehaviorSubject)
			.withArgs(getRetailPharmacyCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBatchStockBalanceCollectionModels, jasmine.any(String)).and.returnValue(batchStockBalanceModelsBehaviorSubject)
			.withArgs(getBatchStockBalancePerDateCollectionModels, jasmine.any(String)).and.returnValue(batchStockBalancePerDateModelsBehaviorSubject)
			.withArgs(getBatchStockTransactionDetailCollectionModels, jasmine.any(String)).and.returnValue(batchStockTransactionDetailModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getCashRefundCollectionModels, jasmine.any(String)).and.returnValue(cashRefundModelsBehaviorSubject)
			.withArgs(getGoodsReceiveNoteCollectionModels, jasmine.any(String)).and.returnValue(goodsReceiveNoteModelsBehaviorSubject)
			.withArgs(getGoodsReceiveNoteBatchCollectionModels, jasmine.any(String)).and.returnValue(goodsReceiveNoteBatchModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInternalOrderCollectionModels, jasmine.any(String)).and.returnValue(internalOrderModelsBehaviorSubject)
			.withArgs(getInventoryAdjusmentBatchCollectionModels, jasmine.any(String)).and.returnValue(inventoryAdjusmentBatchModelsBehaviorSubject)
			.withArgs(getInventoryAdjustmentCollectionModels, jasmine.any(String)).and.returnValue(inventoryAdjustmentModelsBehaviorSubject)
			.withArgs(getInventoryBatchCorrectionCollectionModels, jasmine.any(String)).and.returnValue(inventoryBatchCorrectionModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getInvoiceSummaryCollectionModels, jasmine.any(String)).and.returnValue(invoiceSummaryModelsBehaviorSubject)
			.withArgs(getLocationCollectionModels, jasmine.any(String)).and.returnValue(locationModelsBehaviorSubject)
			.withArgs(getMedicalFeeCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getPatientCaseHistoryCollectionModels, jasmine.any(String)).and.returnValue(patientCaseHistoryModelsBehaviorSubject)
			.withArgs(getPatientConsentCollectionModels, jasmine.any(String)).and.returnValue(patientConsentModelsBehaviorSubject)
			.withArgs(getPatientContactInfoCollectionModels, jasmine.any(String)).and.returnValue(patientContactInfoModelsBehaviorSubject)
			.withArgs(getPatientDetailCollectionModels, jasmine.any(String)).and.returnValue(patientDetailModelsBehaviorSubject)
			.withArgs(getPatientDetailAddressCollectionModels, jasmine.any(String)).and.returnValue(patientDetailAddressModelsBehaviorSubject)
			.withArgs(getPatientEmergencyContactDetailCollectionModels, jasmine.any(String)).and.returnValue(patientEmergencyContactDetailModelsBehaviorSubject)
			.withArgs(getPatientEmploymentDetailCollectionModels, jasmine.any(String)).and.returnValue(patientEmploymentDetailModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
			.withArgs(getPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientPaymentOthersCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentOthersModelsBehaviorSubject)
			.withArgs(getPatientPersonalInfoCollectionModels, jasmine.any(String)).and.returnValue(patientPersonalInfoModelsBehaviorSubject)
			.withArgs(getPatientSupportingDocumentCollectionModels, jasmine.any(String)).and.returnValue(patientSupportingDocumentModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getPurchaseOrderCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionModelsBehaviorSubject)
			.withArgs(getRetailPharmacyInvoiceCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyInvoiceModelsBehaviorSubject)
			.withArgs(getRetailPharmacyStockDetailCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyStockDetailModelsBehaviorSubject)
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
			.withArgs(getPatientGeneralInfoModelWithId, retailPharmacyWithId.patientGeneralInfoId).and.returnValue(patientGeneralInfoWithIdBehaviorSubject)
			.withArgs(getWarehouseModelWithId, retailPharmacyWithId.warehouseId).and.returnValue(warehouseWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				RetailPharmacyCrudModule,
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

			fixture = TestBed.createComponent(RetailPharmacyCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new RetailPharmacyModel();
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
	it ('Renders the Retail Pharmacy CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Patient General Info relation.
	*
	* The button should only exist if patientGeneralInfoMultiCrudActive is true
	*/
	it ('Renders Patient General Info Add Entity button in create mode', fakeAsync(() => {
		const patientGeneralInfoButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient General Info', fakeAsync(() => {
		const patientGeneralInfoButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);

		if (component.patientGeneralInfoMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientGeneralInfoRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model')).length;

			patientGeneralInfoButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientGeneralInfoRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model')).length;

			expect(actualPatientGeneralInfoRemoveButtonCount).toEqual(initialPatientGeneralInfoRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient General Info button', () => {
		const patientGeneralInfoButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);

		if (component.patientGeneralInfoMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientGeneralInfoButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientGeneralInfoRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientGeneralInfoRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientGeneralInfoRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model'));

			expect(actualPatientGeneralInfoRemoveButtons.length).toEqual(initialPatientGeneralInfoRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient General Info button when one has already been added', () => {

		const patientGeneralInfoButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);

		if (component.patientGeneralInfoMultiCrudActive) {
			patientGeneralInfoButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientGeneralInfoButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

			expect(updatedpatientGeneralInfoButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient General Info entities from model when loading in edit mode', () => {
		component.targetModel = retailPharmacyWithId;
		component.targetModelId = retailPharmacyWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientGeneralInfoMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientGeneralInfoRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model')).length;

			expect(patientGeneralInfoRemoveButtonCount).toEqual(1);
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
		component.targetModel = retailPharmacyWithId;
		component.targetModelId = retailPharmacyWithId.id;
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
	* Checks that the status of the add model button matches the multi entity status for the Retail Pharmacy Invoices relation.
	*
	* The button should only exist if retailPharmacyInvoicesMultiCrudActive is true
	*/
	it ('Renders Retail Pharmacy Invoices Add Entity button in create mode', fakeAsync(() => {
		const retailPharmacyInvoicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyInvoicesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!retailPharmacyInvoicesButton).toEqual(component.retailPharmacyInvoicesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Retail Pharmacy Invoices', fakeAsync(() => {
		const retailPharmacyInvoicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyInvoicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmacyInvoicesButton).toEqual(component.retailPharmacyInvoicesMultiCrudActive);

		if (component.retailPharmacyInvoicesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRetailPharmacyInvoicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyInvoicesDisplayName + ' from Model')).length;

			retailPharmacyInvoicesButton.nativeElement.click();
			fixture.detectChanges();

			const actualRetailPharmacyInvoicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyInvoicesDisplayName + ' from Model')).length;

			expect(actualRetailPharmacyInvoicesRemoveButtonCount).toEqual(initialRetailPharmacyInvoicesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Retail Pharmacy Invoices button', () => {
		const retailPharmacyInvoicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyInvoicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmacyInvoicesButton).toEqual(component.retailPharmacyInvoicesMultiCrudActive);

		if (component.retailPharmacyInvoicesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			retailPharmacyInvoicesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRetailPharmacyInvoicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyInvoicesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRetailPharmacyInvoicesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRetailPharmacyInvoicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyInvoicesDisplayName + ' from Model'));

			expect(actualRetailPharmacyInvoicesRemoveButtons.length).toEqual(initialRetailPharmacyInvoicesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Retail Pharmacy Invoices button when one has already been added', () => {

		const retailPharmacyInvoicesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyInvoicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmacyInvoicesButton).toEqual(component.retailPharmacyInvoicesMultiCrudActive);

		if (component.retailPharmacyInvoicesMultiCrudActive) {
			retailPharmacyInvoicesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedretailPharmacyInvoicesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyInvoicesDisplayName + ' to Model'));

			expect(updatedretailPharmacyInvoicesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Retail Pharmacy Invoices entities from model when loading in edit mode', () => {
		component.targetModel = retailPharmacyWithId;
		component.targetModelId = retailPharmacyWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.retailPharmacyInvoicesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const retailPharmacyInvoicesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyInvoicesDisplayName + ' from Model')).length;

			expect(retailPharmacyInvoicesRemoveButtonCount).toEqual(retailPharmacyWithId.retailPharmacyInvoices.length);
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
		component.targetModel = retailPharmacyWithId;
		component.targetModelId = retailPharmacyWithId.id;
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

			expect(retailPharmacyStockDetailsRemoveButtonCount).toEqual(retailPharmacyWithId.retailPharmacyStockDetails.length);
		}
	});

});
