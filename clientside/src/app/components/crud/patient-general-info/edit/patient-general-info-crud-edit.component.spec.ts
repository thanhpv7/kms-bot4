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
	getPatientGeneralInfoCollectionModels,
	getCountPatientGeneralInfoModels,
	getPatientGeneralInfoModelWithId
} from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoCrudModule } from '../patient-general-info-crud.module';
import { PatientGeneralInfoCrudEditComponent } from './patient-general-info-crud-edit.component';
import {
	PatientGeneralInfoModelState,
	initialState as initialPatientGeneralInfoModelState
} from 'src/app/models/patientGeneralInfo/patient_general_info.model.state';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { CrudTileMode } from '../patient-general-info-crud.component';
import { getBpjsAccidentMasterModelWithId } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import { getBpjsAccidentMasterCollectionModels } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import { BpjsAccidentMasterModel } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model';
import { BpjsAccidentMasterDataFactory } from 'src/app/lib/utils/factories/bpjs-accident-master-data-factory';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getBpjsDiagnoseModelWithId } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { getBpjsDiagnoseCollectionModels } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { BpjsDiagnoseModel } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import { BpjsDiagnoseDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-data-factory';
import { getBpjsDismissalConditionModelWithId } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.selector';
import { getBpjsDismissalConditionCollectionModels } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.selector';
import { BpjsDismissalConditionModel } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model';
import { BpjsDismissalConditionDataFactory } from 'src/app/lib/utils/factories/bpjs-dismissal-condition-data-factory';
import { getBpjsDismissalMappingModelWithId } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.selector';
import { getBpjsDismissalMappingCollectionModels } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.selector';
import { BpjsDismissalMappingModel } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model';
import { BpjsDismissalMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-dismissal-mapping-data-factory';
import { getBpjsDoctorMappingModelWithId } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-doctor-mapping-data-factory';
import { getBpjsHealthFacilityModelWithId } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { getBpjsHealthFacilityCollectionModels } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { BpjsHealthFacilityModel } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model';
import { BpjsHealthFacilityDataFactory } from 'src/app/lib/utils/factories/bpjs-health-facility-data-factory';
import { getBpjsHospitalizationPlanModelWithId } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { getBpjsHospitalizationPlanCollectionModels } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { BpjsHospitalizationPlanModel } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import { BpjsHospitalizationPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-hospitalization-plan-data-factory';
import { getBpjsJasaRaharjaModelWithId } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { getBpjsJasaRaharjaCollectionModels } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { BpjsJasaRaharjaModel } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model';
import { BpjsJasaRaharjaDataFactory } from 'src/app/lib/utils/factories/bpjs-jasa-raharja-data-factory';
import { getBpjsPatientReferralModelWithId } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { getBpjsPatientReferralCollectionModels } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { BpjsPatientReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-patient-referral-data-factory';
import { getBpjsPcareRegistrationsModelWithId } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { getBpjsPcareRegistrationsCollectionModels } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { BpjsPcareRegistrationsModel } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import { BpjsPcareRegistrationsDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-registrations-data-factory';
import { getBpjsProcedureModelWithId } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { getBpjsProcedureCollectionModels } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { BpjsProcedureModel } from 'src/app/models/bpjsProcedure/bpjs_procedure.model';
import { BpjsProcedureDataFactory } from 'src/app/lib/utils/factories/bpjs-procedure-data-factory';
import { getBpjsSEPModelWithId } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { getBpjsSEPCollectionModels } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { BpjsSEPModel } from 'src/app/models/bpjsSEP/bpjs_sep.model';
import { BpjsSEPDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-data-factory';
import { getBpjsSEPSubmissionModelWithId } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import { getBpjsSEPSubmissionCollectionModels } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import { BpjsSEPSubmissionModel } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model';
import { BpjsSEPSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-submission-data-factory';
import { getBpjsServiceMappingModelWithId } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { getBpjsServiceMappingCollectionModels } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { BpjsServiceMappingModel } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import { BpjsServiceMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-service-mapping-data-factory';
import { getBpjsTreatmentRoomModelWithId } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.selector';
import { getBpjsTreatmentRoomCollectionModels } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.selector';
import { BpjsTreatmentRoomModel } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model';
import { BpjsTreatmentRoomDataFactory } from 'src/app/lib/utils/factories/bpjs-treatment-room-data-factory';
import { getBpjsVisitDataModelWithId } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.selector';
import { getBpjsVisitDataCollectionModels } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.selector';
import { BpjsVisitDataModel } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model';
import { BpjsVisitDataDataFactory } from 'src/app/lib/utils/factories/bpjs-visit-data-data-factory';
import { getBpjsPcarePendaftaranModelWithId } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.selector';
import { getBpjsPcarePendaftaranCollectionModels } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.selector';
import { BpjsPcarePendaftaranModel } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model';
import { BpjsPcarePendaftaranDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-pendaftaran-data-factory';
import { getCashReceiptModelWithId } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { getCashReceiptCollectionModels } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { CashReceiptModel } from 'src/app/models/cashReceipt/cash_receipt.model';
import { CashReceiptDataFactory } from 'src/app/lib/utils/factories/cash-receipt-data-factory';
import { getCashRefundModelWithId } from 'src/app/models/cashRefund/cash_refund.model.selector';
import { getCashRefundCollectionModels } from 'src/app/models/cashRefund/cash_refund.model.selector';
import { CashRefundModel } from 'src/app/models/cashRefund/cash_refund.model';
import { CashRefundDataFactory } from 'src/app/lib/utils/factories/cash-refund-data-factory';
import { getInformedConsentModelWithId } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { getInformedConsentCollectionModels } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { InformedConsentModel } from 'src/app/models/informedConsent/informed_consent.model';
import { InformedConsentDataFactory } from 'src/app/lib/utils/factories/informed-consent-data-factory';
import { getInsuranceBenefitPlanModelWithId } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.selector';
import { getInsuranceBenefitPlanCollectionModels } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.selector';
import { InsuranceBenefitPlanModel } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model';
import { InsuranceBenefitPlanDataFactory } from 'src/app/lib/utils/factories/insurance-benefit-plan-data-factory';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getMerchantModelWithId } from 'src/app/models/merchant/merchant.model.selector';
import { getMerchantCollectionModels } from 'src/app/models/merchant/merchant.model.selector';
import { MerchantModel } from 'src/app/models/merchant/merchant.model';
import { MerchantDataFactory } from 'src/app/lib/utils/factories/merchant-data-factory';
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
import { getPatientVisitPatientPaymentInsuranceModelWithId } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import { getPatientVisitPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import { PatientVisitPatientPaymentInsuranceModel } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model';
import { PatientVisitPatientPaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/patient-visit-patient-payment-insurance-data-factory';
import { getPatientVisitPatientPaymentOthersModelWithId } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.selector';
import { getPatientVisitPatientPaymentOthersCollectionModels } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.selector';
import { PatientVisitPatientPaymentOthersModel } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model';
import { PatientVisitPatientPaymentOthersDataFactory } from 'src/app/lib/utils/factories/patient-visit-patient-payment-others-data-factory';
import { getPatientVisitPaymentSelfPayingModelWithId } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.selector';
import { getPatientVisitPaymentSelfPayingCollectionModels } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.selector';
import { PatientVisitPaymentSelfPayingModel } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model';
import { PatientVisitPaymentSelfPayingDataFactory } from 'src/app/lib/utils/factories/patient-visit-payment-self-paying-data-factory';
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
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { getWarehouseModelWithId } from 'src/app/models/warehouse/warehouse.model.selector';
import { getWarehouseCollectionModels } from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { WarehouseDataFactory } from 'src/app/lib/utils/factories/warehouse-data-factory';

describe('Patient General Info CRUD Edit component tests', () => {
	let fixture: ComponentFixture<PatientGeneralInfoCrudEditComponent>
	let component: PatientGeneralInfoCrudEditComponent;

	let patientGeneralInfoModelState: PatientGeneralInfoModelState;

	let store: MockStore<{ model: PatientGeneralInfoModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let patientGeneralInfoCountBehaviorSubject: BehaviorSubject<number>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let bpjsAccidentMasterModelsBehaviorSubject: BehaviorSubject<BpjsAccidentMasterModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsDismissalConditionModelsBehaviorSubject: BehaviorSubject<BpjsDismissalConditionModel[]>;
	let bpjsDismissalMappingModelsBehaviorSubject: BehaviorSubject<BpjsDismissalMappingModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsHealthFacilityModelsBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel[]>;
	let bpjsHospitalizationPlanModelsBehaviorSubject: BehaviorSubject<BpjsHospitalizationPlanModel[]>;
	let bpjsJasaRaharjaModelsBehaviorSubject: BehaviorSubject<BpjsJasaRaharjaModel[]>;
	let bpjsPatientReferralModelsBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel[]>;
	let bpjsPcareRegistrationsModelsBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel[]>;
	let bpjsProcedureModelsBehaviorSubject: BehaviorSubject<BpjsProcedureModel[]>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bpjsSEPSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsSEPSubmissionModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let bpjsTreatmentRoomModelsBehaviorSubject: BehaviorSubject<BpjsTreatmentRoomModel[]>;
	let bpjsVisitDataModelsBehaviorSubject: BehaviorSubject<BpjsVisitDataModel[]>;
	let bpjsPcarePendaftaranModelsBehaviorSubject: BehaviorSubject<BpjsPcarePendaftaranModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let cashRefundModelsBehaviorSubject: BehaviorSubject<CashRefundModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let insuranceBenefitPlanModelsBehaviorSubject: BehaviorSubject<InsuranceBenefitPlanModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let merchantModelsBehaviorSubject: BehaviorSubject<MerchantModel[]>;
	let patientCaseHistoryModelsBehaviorSubject: BehaviorSubject<PatientCaseHistoryModel[]>;
	let patientConsentModelsBehaviorSubject: BehaviorSubject<PatientConsentModel[]>;
	let patientContactInfoModelsBehaviorSubject: BehaviorSubject<PatientContactInfoModel[]>;
	let patientDetailModelsBehaviorSubject: BehaviorSubject<PatientDetailModel[]>;
	let patientDetailAddressModelsBehaviorSubject: BehaviorSubject<PatientDetailAddressModel[]>;
	let patientEmergencyContactDetailModelsBehaviorSubject: BehaviorSubject<PatientEmergencyContactDetailModel[]>;
	let patientEmploymentDetailModelsBehaviorSubject: BehaviorSubject<PatientEmploymentDetailModel[]>;
	let patientPaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<PatientPaymentSelfPayingModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;
	let patientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientPaymentInsuranceModel[]>;
	let patientPaymentOthersModelsBehaviorSubject: BehaviorSubject<PatientPaymentOthersModel[]>;
	let patientPersonalInfoModelsBehaviorSubject: BehaviorSubject<PatientPersonalInfoModel[]>;
	let patientSupportingDocumentModelsBehaviorSubject: BehaviorSubject<PatientSupportingDocumentModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let patientVisitPatientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientVisitPatientPaymentInsuranceModel[]>;
	let patientVisitPatientPaymentOthersModelsBehaviorSubject: BehaviorSubject<PatientVisitPatientPaymentOthersModel[]>;
	let patientVisitPaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<PatientVisitPaymentSelfPayingModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let retailPharmacyModelsBehaviorSubject: BehaviorSubject<RetailPharmacyModel[]>;
	let retailPharmacyInvoiceModelsBehaviorSubject: BehaviorSubject<RetailPharmacyInvoiceModel[]>;
	let retailPharmacyStockDetailModelsBehaviorSubject: BehaviorSubject<RetailPharmacyStockDetailModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const bpjsAccidentMasterFactory: BpjsAccidentMasterDataFactory = new BpjsAccidentMasterDataFactory();
	const defaultBpjsAccidentMasterCount: number = 10;
	const defaultBpjsAccidentMasterEntities: BpjsAccidentMasterModel[] = bpjsAccidentMasterFactory.createAll(defaultBpjsAccidentMasterCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsDiagnoseFactory: BpjsDiagnoseDataFactory = new BpjsDiagnoseDataFactory();
	const defaultBpjsDiagnoseCount: number = 10;
	const defaultBpjsDiagnoseEntities: BpjsDiagnoseModel[] = bpjsDiagnoseFactory.createAll(defaultBpjsDiagnoseCount);

	const bpjsDismissalConditionFactory: BpjsDismissalConditionDataFactory = new BpjsDismissalConditionDataFactory();
	const defaultBpjsDismissalConditionCount: number = 10;
	const defaultBpjsDismissalConditionEntities: BpjsDismissalConditionModel[] = bpjsDismissalConditionFactory.createAll(defaultBpjsDismissalConditionCount);

	const bpjsDismissalMappingFactory: BpjsDismissalMappingDataFactory = new BpjsDismissalMappingDataFactory();
	const defaultBpjsDismissalMappingCount: number = 10;
	const defaultBpjsDismissalMappingEntities: BpjsDismissalMappingModel[] = bpjsDismissalMappingFactory.createAll(defaultBpjsDismissalMappingCount);

	const bpjsDoctorMappingFactory: BpjsDoctorMappingDataFactory = new BpjsDoctorMappingDataFactory();
	const defaultBpjsDoctorMappingCount: number = 10;
	const defaultBpjsDoctorMappingEntities: BpjsDoctorMappingModel[] = bpjsDoctorMappingFactory.createAll(defaultBpjsDoctorMappingCount);

	const bpjsHealthFacilityFactory: BpjsHealthFacilityDataFactory = new BpjsHealthFacilityDataFactory();
	const defaultBpjsHealthFacilityCount: number = 10;
	const defaultBpjsHealthFacilityEntities: BpjsHealthFacilityModel[] = bpjsHealthFacilityFactory.createAll(defaultBpjsHealthFacilityCount);

	const bpjsHospitalizationPlanFactory: BpjsHospitalizationPlanDataFactory = new BpjsHospitalizationPlanDataFactory();
	const defaultBpjsHospitalizationPlanCount: number = 10;
	const defaultBpjsHospitalizationPlanEntities: BpjsHospitalizationPlanModel[] = bpjsHospitalizationPlanFactory.createAll(defaultBpjsHospitalizationPlanCount);

	const bpjsJasaRaharjaFactory: BpjsJasaRaharjaDataFactory = new BpjsJasaRaharjaDataFactory();
	const defaultBpjsJasaRaharjaCount: number = 10;
	const defaultBpjsJasaRaharjaEntities: BpjsJasaRaharjaModel[] = bpjsJasaRaharjaFactory.createAll(defaultBpjsJasaRaharjaCount);

	const bpjsPatientReferralFactory: BpjsPatientReferralDataFactory = new BpjsPatientReferralDataFactory();
	const defaultBpjsPatientReferralCount: number = 10;
	const defaultBpjsPatientReferralEntities: BpjsPatientReferralModel[] = bpjsPatientReferralFactory.createAll(defaultBpjsPatientReferralCount);

	const bpjsPcareRegistrationsFactory: BpjsPcareRegistrationsDataFactory = new BpjsPcareRegistrationsDataFactory();
	const defaultBpjsPcareRegistrationsCount: number = 10;
	const defaultBpjsPcareRegistrationsEntities: BpjsPcareRegistrationsModel[] = bpjsPcareRegistrationsFactory.createAll(defaultBpjsPcareRegistrationsCount);

	const bpjsProcedureFactory: BpjsProcedureDataFactory = new BpjsProcedureDataFactory();
	const defaultBpjsProcedureCount: number = 10;
	const defaultBpjsProcedureEntities: BpjsProcedureModel[] = bpjsProcedureFactory.createAll(defaultBpjsProcedureCount);

	const bpjsSEPFactory: BpjsSEPDataFactory = new BpjsSEPDataFactory();
	const defaultBpjsSEPCount: number = 10;
	const defaultBpjsSEPEntities: BpjsSEPModel[] = bpjsSEPFactory.createAll(defaultBpjsSEPCount);

	const bpjsSEPSubmissionFactory: BpjsSEPSubmissionDataFactory = new BpjsSEPSubmissionDataFactory();
	const defaultBpjsSEPSubmissionCount: number = 10;
	const defaultBpjsSEPSubmissionEntities: BpjsSEPSubmissionModel[] = bpjsSEPSubmissionFactory.createAll(defaultBpjsSEPSubmissionCount);

	const bpjsServiceMappingFactory: BpjsServiceMappingDataFactory = new BpjsServiceMappingDataFactory();
	const defaultBpjsServiceMappingCount: number = 10;
	const defaultBpjsServiceMappingEntities: BpjsServiceMappingModel[] = bpjsServiceMappingFactory.createAll(defaultBpjsServiceMappingCount);

	const bpjsTreatmentRoomFactory: BpjsTreatmentRoomDataFactory = new BpjsTreatmentRoomDataFactory();
	const defaultBpjsTreatmentRoomCount: number = 10;
	const defaultBpjsTreatmentRoomEntities: BpjsTreatmentRoomModel[] = bpjsTreatmentRoomFactory.createAll(defaultBpjsTreatmentRoomCount);

	const bpjsVisitDataFactory: BpjsVisitDataDataFactory = new BpjsVisitDataDataFactory();
	const defaultBpjsVisitDataCount: number = 10;
	const defaultBpjsVisitDataEntities: BpjsVisitDataModel[] = bpjsVisitDataFactory.createAll(defaultBpjsVisitDataCount);

	const bpjsPcarePendaftaranFactory: BpjsPcarePendaftaranDataFactory = new BpjsPcarePendaftaranDataFactory();
	const defaultBpjsPcarePendaftaranCount: number = 10;
	const defaultBpjsPcarePendaftaranEntities: BpjsPcarePendaftaranModel[] = bpjsPcarePendaftaranFactory.createAll(defaultBpjsPcarePendaftaranCount);

	const cashReceiptFactory: CashReceiptDataFactory = new CashReceiptDataFactory();
	const defaultCashReceiptCount: number = 10;
	const defaultCashReceiptEntities: CashReceiptModel[] = cashReceiptFactory.createAll(defaultCashReceiptCount);

	const cashRefundFactory: CashRefundDataFactory = new CashRefundDataFactory();
	const defaultCashRefundCount: number = 10;
	const defaultCashRefundEntities: CashRefundModel[] = cashRefundFactory.createAll(defaultCashRefundCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const insuranceBenefitPlanFactory: InsuranceBenefitPlanDataFactory = new InsuranceBenefitPlanDataFactory();
	const defaultInsuranceBenefitPlanCount: number = 10;
	const defaultInsuranceBenefitPlanEntities: InsuranceBenefitPlanModel[] = insuranceBenefitPlanFactory.createAll(defaultInsuranceBenefitPlanCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const merchantFactory: MerchantDataFactory = new MerchantDataFactory();
	const defaultMerchantCount: number = 10;
	const defaultMerchantEntities: MerchantModel[] = merchantFactory.createAll(defaultMerchantCount);

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

	const patientVisitPatientPaymentInsuranceFactory: PatientVisitPatientPaymentInsuranceDataFactory = new PatientVisitPatientPaymentInsuranceDataFactory();
	const defaultPatientVisitPatientPaymentInsuranceCount: number = 10;
	const defaultPatientVisitPatientPaymentInsuranceEntities: PatientVisitPatientPaymentInsuranceModel[] = patientVisitPatientPaymentInsuranceFactory.createAll(defaultPatientVisitPatientPaymentInsuranceCount);

	const patientVisitPatientPaymentOthersFactory: PatientVisitPatientPaymentOthersDataFactory = new PatientVisitPatientPaymentOthersDataFactory();
	const defaultPatientVisitPatientPaymentOthersCount: number = 10;
	const defaultPatientVisitPatientPaymentOthersEntities: PatientVisitPatientPaymentOthersModel[] = patientVisitPatientPaymentOthersFactory.createAll(defaultPatientVisitPatientPaymentOthersCount);

	const patientVisitPaymentSelfPayingFactory: PatientVisitPaymentSelfPayingDataFactory = new PatientVisitPaymentSelfPayingDataFactory();
	const defaultPatientVisitPaymentSelfPayingCount: number = 10;
	const defaultPatientVisitPaymentSelfPayingEntities: PatientVisitPaymentSelfPayingModel[] = patientVisitPaymentSelfPayingFactory.createAll(defaultPatientVisitPaymentSelfPayingCount);

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

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let patientGeneralInfoWithId: PatientGeneralInfoModel = defaultPatientGeneralInfoEntities[0];
	let patientGeneralInfoModelWithIdBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel>;

	patientGeneralInfoWithId.patientContactInformation = defaultPatientContactInfoEntities[0];
	patientGeneralInfoWithId.patientContactInformationId = patientGeneralInfoWithId.patientContactInformation.id;
	let patientContactInformationWithIdBehaviorSubject: BehaviorSubject<PatientContactInfoModel>;

	patientGeneralInfoWithId.patientDetailAddress = defaultPatientDetailAddressEntities[0];
	patientGeneralInfoWithId.patientDetailAddressId = patientGeneralInfoWithId.patientDetailAddress.id;
	let patientDetailAddressWithIdBehaviorSubject: BehaviorSubject<PatientDetailAddressModel>;

	patientGeneralInfoWithId.patientDetail = defaultPatientDetailEntities[0];
	patientGeneralInfoWithId.patientDetailId = patientGeneralInfoWithId.patientDetail.id;
	let patientDetailWithIdBehaviorSubject: BehaviorSubject<PatientDetailModel>;

	patientGeneralInfoWithId.patientEmergencyContactDetail = defaultPatientEmergencyContactDetailEntities[0];
	patientGeneralInfoWithId.patientEmergencyContactDetailId = patientGeneralInfoWithId.patientEmergencyContactDetail.id;
	let patientEmergencyContactDetailWithIdBehaviorSubject: BehaviorSubject<PatientEmergencyContactDetailModel>;

	patientGeneralInfoWithId.patientEmploymentDetail = defaultPatientEmploymentDetailEntities[0];
	patientGeneralInfoWithId.patientEmploymentDetailId = patientGeneralInfoWithId.patientEmploymentDetail.id;
	let patientEmploymentDetailWithIdBehaviorSubject: BehaviorSubject<PatientEmploymentDetailModel>;

	patientGeneralInfoWithId.patientPaymentBPJS = defaultPatientPaymentBPJSEntities[0];
	patientGeneralInfoWithId.patientPaymentBPJSId = patientGeneralInfoWithId.patientPaymentBPJS.id;
	let patientPaymentBPJSWithIdBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel>;

	patientGeneralInfoWithId.patientPaymentTypeInsurance = defaultPatientPaymentInsuranceEntities[0];
	patientGeneralInfoWithId.patientPaymentTypeInsuranceId = patientGeneralInfoWithId.patientPaymentTypeInsurance.id;
	let patientPaymentTypeInsuranceWithIdBehaviorSubject: BehaviorSubject<PatientPaymentInsuranceModel>;

	patientGeneralInfoWithId.patientPaymentTypeOthers = defaultPatientPaymentOthersEntities[0];
	patientGeneralInfoWithId.patientPaymentTypeOthersId = patientGeneralInfoWithId.patientPaymentTypeOthers.id;
	let patientPaymentTypeOthersWithIdBehaviorSubject: BehaviorSubject<PatientPaymentOthersModel>;

	patientGeneralInfoWithId.patientPersonalInformation = defaultPatientPersonalInfoEntities[0];
	patientGeneralInfoWithId.patientPersonalInformationId = patientGeneralInfoWithId.patientPersonalInformation.id;
	let patientPersonalInformationWithIdBehaviorSubject: BehaviorSubject<PatientPersonalInfoModel>;

	patientGeneralInfoWithId.patientSelfPaying = defaultPatientPaymentSelfPayingEntities[0];
	patientGeneralInfoWithId.patientSelfPayingId = patientGeneralInfoWithId.patientSelfPaying.id;
	let patientSelfPayingWithIdBehaviorSubject: BehaviorSubject<PatientPaymentSelfPayingModel>;

	patientGeneralInfoWithId.bpjsClaimSubmissions = defaultBpjsClaimSubmissionEntities;
	patientGeneralInfoWithId.bpjsClaimSubmissionsIds = patientGeneralInfoWithId.bpjsClaimSubmissions.map(bpjsClaimSubmissions => bpjsClaimSubmissions.id);

	patientGeneralInfoWithId.cashRefunds = defaultCashRefundEntities;
	patientGeneralInfoWithId.cashRefundsIds = patientGeneralInfoWithId.cashRefunds.map(cashRefunds => cashRefunds.id);

	patientGeneralInfoWithId.informedConsents = defaultInformedConsentEntities;
	patientGeneralInfoWithId.informedConsentsIds = patientGeneralInfoWithId.informedConsents.map(informedConsents => informedConsents.id);

	patientGeneralInfoWithId.invoiceReceipts = defaultCashReceiptEntities;
	patientGeneralInfoWithId.invoiceReceiptsIds = patientGeneralInfoWithId.invoiceReceipts.map(invoiceReceipts => invoiceReceipts.id);

	patientGeneralInfoWithId.patientCaseHistories = defaultPatientCaseHistoryEntities;
	patientGeneralInfoWithId.patientCaseHistoriesIds = patientGeneralInfoWithId.patientCaseHistories.map(patientCaseHistories => patientCaseHistories.id);

	patientGeneralInfoWithId.patientConsents = defaultPatientConsentEntities;
	patientGeneralInfoWithId.patientConsentsIds = patientGeneralInfoWithId.patientConsents.map(patientConsents => patientConsents.id);

	patientGeneralInfoWithId.patientFinalizeProfiles = defaultPatientSupportingDocumentEntities;
	patientGeneralInfoWithId.patientFinalizeProfilesIds = patientGeneralInfoWithId.patientFinalizeProfiles.map(patientFinalizeProfiles => patientFinalizeProfiles.id);

	patientGeneralInfoWithId.retailPharmacies = defaultRetailPharmacyEntities;
	patientGeneralInfoWithId.retailPharmaciesIds = patientGeneralInfoWithId.retailPharmacies.map(retailPharmacies => retailPharmacies.id);

	patientGeneralInfoWithId.visits = defaultPatientVisitEntities;
	patientGeneralInfoWithId.visitsIds = patientGeneralInfoWithId.visits.map(visits => visits.id);


	const routerState: RouterState = {
		url: 'patient-general-info-crud',
		urls: ['patient-general-info-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: PatientGeneralInfoModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		patientGeneralInfoModelState = initialPatientGeneralInfoModelState;
		store.setState({model: patientGeneralInfoModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		patientGeneralInfoCountBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoCount);

		// selectors for all references
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		bpjsAccidentMasterModelsBehaviorSubject = new BehaviorSubject(defaultBpjsAccidentMasterEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsDismissalConditionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDismissalConditionEntities);
		bpjsDismissalMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDismissalMappingEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsHealthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHealthFacilityEntities);
		bpjsHospitalizationPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHospitalizationPlanEntities);
		bpjsJasaRaharjaModelsBehaviorSubject = new BehaviorSubject(defaultBpjsJasaRaharjaEntities);
		bpjsPatientReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralEntities);
		bpjsPcareRegistrationsModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareRegistrationsEntities);
		bpjsProcedureModelsBehaviorSubject = new BehaviorSubject(defaultBpjsProcedureEntities);
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bpjsSEPSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPSubmissionEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		bpjsTreatmentRoomModelsBehaviorSubject = new BehaviorSubject(defaultBpjsTreatmentRoomEntities);
		bpjsVisitDataModelsBehaviorSubject = new BehaviorSubject(defaultBpjsVisitDataEntities);
		bpjsPcarePendaftaranModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcarePendaftaranEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		cashRefundModelsBehaviorSubject = new BehaviorSubject(defaultCashRefundEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		insuranceBenefitPlanModelsBehaviorSubject = new BehaviorSubject(defaultInsuranceBenefitPlanEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		merchantModelsBehaviorSubject = new BehaviorSubject(defaultMerchantEntities);
		patientCaseHistoryModelsBehaviorSubject = new BehaviorSubject(defaultPatientCaseHistoryEntities);
		patientConsentModelsBehaviorSubject = new BehaviorSubject(defaultPatientConsentEntities);
		patientContactInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientContactInfoEntities);
		patientDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientDetailEntities);
		patientDetailAddressModelsBehaviorSubject = new BehaviorSubject(defaultPatientDetailAddressEntities);
		patientEmergencyContactDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientEmergencyContactDetailEntities);
		patientEmploymentDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientEmploymentDetailEntities);
		patientPaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentSelfPayingEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);
		patientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentInsuranceEntities);
		patientPaymentOthersModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentOthersEntities);
		patientPersonalInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientPersonalInfoEntities);
		patientSupportingDocumentModelsBehaviorSubject = new BehaviorSubject(defaultPatientSupportingDocumentEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		patientVisitPatientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPatientPaymentInsuranceEntities);
		patientVisitPatientPaymentOthersModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPatientPaymentOthersEntities);
		patientVisitPaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPaymentSelfPayingEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		retailPharmacyModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyEntities);
		retailPharmacyInvoiceModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyInvoiceEntities);
		retailPharmacyStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyStockDetailEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);

		// selectors for target entity and its related entity
		patientGeneralInfoModelWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId);
		patientContactInformationWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientContactInformation);
		patientDetailAddressWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientDetailAddress);
		patientDetailWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientDetail);
		patientEmergencyContactDetailWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientEmergencyContactDetail);
		patientEmploymentDetailWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientEmploymentDetail);
		patientPaymentBPJSWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientPaymentBPJS);
		patientPaymentTypeInsuranceWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientPaymentTypeInsurance);
		patientPaymentTypeOthersWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientPaymentTypeOthers);
		patientPersonalInformationWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientPersonalInformation);
		patientSelfPayingWithIdBehaviorSubject = new BehaviorSubject(patientGeneralInfoWithId.patientSelfPaying);

		spyOn(store, 'select')
			.withArgs(getCountPatientGeneralInfoModels).and.returnValue(patientGeneralInfoCountBehaviorSubject)
			.withArgs(getPatientGeneralInfoModelWithId, patientGeneralInfoWithId.id).and.returnValue(patientGeneralInfoModelWithIdBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getBpjsAccidentMasterCollectionModels, jasmine.any(String)).and.returnValue(bpjsAccidentMasterModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsDismissalConditionCollectionModels, jasmine.any(String)).and.returnValue(bpjsDismissalConditionModelsBehaviorSubject)
			.withArgs(getBpjsDismissalMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDismissalMappingModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(bpjsHealthFacilityModelsBehaviorSubject)
			.withArgs(getBpjsHospitalizationPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsHospitalizationPlanModelsBehaviorSubject)
			.withArgs(getBpjsJasaRaharjaCollectionModels, jasmine.any(String)).and.returnValue(bpjsJasaRaharjaModelsBehaviorSubject)
			.withArgs(getBpjsPatientReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsPatientReferralModelsBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareRegistrationsModelsBehaviorSubject)
			.withArgs(getBpjsProcedureCollectionModels, jasmine.any(String)).and.returnValue(bpjsProcedureModelsBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBpjsSEPSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getBpjsTreatmentRoomCollectionModels, jasmine.any(String)).and.returnValue(bpjsTreatmentRoomModelsBehaviorSubject)
			.withArgs(getBpjsVisitDataCollectionModels, jasmine.any(String)).and.returnValue(bpjsVisitDataModelsBehaviorSubject)
			.withArgs(getBpjsPcarePendaftaranCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcarePendaftaranModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getCashRefundCollectionModels, jasmine.any(String)).and.returnValue(cashRefundModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInsuranceBenefitPlanCollectionModels, jasmine.any(String)).and.returnValue(insuranceBenefitPlanModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getMerchantCollectionModels, jasmine.any(String)).and.returnValue(merchantModelsBehaviorSubject)
			.withArgs(getPatientCaseHistoryCollectionModels, jasmine.any(String)).and.returnValue(patientCaseHistoryModelsBehaviorSubject)
			.withArgs(getPatientConsentCollectionModels, jasmine.any(String)).and.returnValue(patientConsentModelsBehaviorSubject)
			.withArgs(getPatientContactInfoCollectionModels, jasmine.any(String)).and.returnValue(patientContactInfoModelsBehaviorSubject)
			.withArgs(getPatientDetailCollectionModels, jasmine.any(String)).and.returnValue(patientDetailModelsBehaviorSubject)
			.withArgs(getPatientDetailAddressCollectionModels, jasmine.any(String)).and.returnValue(patientDetailAddressModelsBehaviorSubject)
			.withArgs(getPatientEmergencyContactDetailCollectionModels, jasmine.any(String)).and.returnValue(patientEmergencyContactDetailModelsBehaviorSubject)
			.withArgs(getPatientEmploymentDetailCollectionModels, jasmine.any(String)).and.returnValue(patientEmploymentDetailModelsBehaviorSubject)
			.withArgs(getPatientPaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
			.withArgs(getPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientPaymentOthersCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentOthersModelsBehaviorSubject)
			.withArgs(getPatientPersonalInfoCollectionModels, jasmine.any(String)).and.returnValue(patientPersonalInfoModelsBehaviorSubject)
			.withArgs(getPatientSupportingDocumentCollectionModels, jasmine.any(String)).and.returnValue(patientSupportingDocumentModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPatientVisitPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPatientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientVisitPatientPaymentOthersCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPatientPaymentOthersModelsBehaviorSubject)
			.withArgs(getPatientVisitPaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRetailPharmacyCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyModelsBehaviorSubject)
			.withArgs(getRetailPharmacyInvoiceCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyInvoiceModelsBehaviorSubject)
			.withArgs(getRetailPharmacyStockDetailCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyStockDetailModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getPatientContactInfoModelWithId, patientGeneralInfoWithId.patientContactInformationId).and.returnValue(patientContactInformationWithIdBehaviorSubject)
			.withArgs(getPatientDetailAddressModelWithId, patientGeneralInfoWithId.patientDetailAddressId).and.returnValue(patientDetailAddressWithIdBehaviorSubject)
			.withArgs(getPatientDetailModelWithId, patientGeneralInfoWithId.patientDetailId).and.returnValue(patientDetailWithIdBehaviorSubject)
			.withArgs(getPatientEmergencyContactDetailModelWithId, patientGeneralInfoWithId.patientEmergencyContactDetailId).and.returnValue(patientEmergencyContactDetailWithIdBehaviorSubject)
			.withArgs(getPatientEmploymentDetailModelWithId, patientGeneralInfoWithId.patientEmploymentDetailId).and.returnValue(patientEmploymentDetailWithIdBehaviorSubject)
			.withArgs(getPatientPaymentBPJSModelWithId, patientGeneralInfoWithId.patientPaymentBPJSId).and.returnValue(patientPaymentBPJSWithIdBehaviorSubject)
			.withArgs(getPatientPaymentInsuranceModelWithId, patientGeneralInfoWithId.patientPaymentTypeInsuranceId).and.returnValue(patientPaymentTypeInsuranceWithIdBehaviorSubject)
			.withArgs(getPatientPaymentOthersModelWithId, patientGeneralInfoWithId.patientPaymentTypeOthersId).and.returnValue(patientPaymentTypeOthersWithIdBehaviorSubject)
			.withArgs(getPatientPersonalInfoModelWithId, patientGeneralInfoWithId.patientPersonalInformationId).and.returnValue(patientPersonalInformationWithIdBehaviorSubject)
			.withArgs(getPatientPaymentSelfPayingModelWithId, patientGeneralInfoWithId.patientSelfPayingId).and.returnValue(patientSelfPayingWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				PatientGeneralInfoCrudModule,
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

			fixture = TestBed.createComponent(PatientGeneralInfoCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new PatientGeneralInfoModel();
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
	it ('Renders the Patient General Info CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Patient Contact Information relation.
	*
	* The button should only exist if patientContactInformationMultiCrudActive is true
	*/
	it ('Renders Patient Contact Information Add Entity button in create mode', fakeAsync(() => {
		const patientContactInformationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientContactInformationDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientContactInformationButton).toEqual(component.patientContactInformationMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Contact Information', fakeAsync(() => {
		const patientContactInformationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientContactInformationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientContactInformationButton).toEqual(component.patientContactInformationMultiCrudActive);

		if (component.patientContactInformationMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientContactInformationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientContactInformationDisplayName + ' from Model')).length;

			patientContactInformationButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientContactInformationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientContactInformationDisplayName + ' from Model')).length;

			expect(actualPatientContactInformationRemoveButtonCount).toEqual(initialPatientContactInformationRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Contact Information button', () => {
		const patientContactInformationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientContactInformationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientContactInformationButton).toEqual(component.patientContactInformationMultiCrudActive);

		if (component.patientContactInformationMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientContactInformationButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientContactInformationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientContactInformationDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientContactInformationRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientContactInformationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientContactInformationDisplayName + ' from Model'));

			expect(actualPatientContactInformationRemoveButtons.length).toEqual(initialPatientContactInformationRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Contact Information button when one has already been added', () => {

		const patientContactInformationButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientContactInformationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientContactInformationButton).toEqual(component.patientContactInformationMultiCrudActive);

		if (component.patientContactInformationMultiCrudActive) {
			patientContactInformationButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientContactInformationButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientContactInformationDisplayName + ' to Model'));

			expect(updatedpatientContactInformationButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Contact Information entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientContactInformationMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientContactInformationRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientContactInformationDisplayName + ' from Model')).length;

			expect(patientContactInformationRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Detail Address relation.
	*
	* The button should only exist if patientDetailAddressMultiCrudActive is true
	*/
	it ('Renders Patient Detail Address Add Entity button in create mode', fakeAsync(() => {
		const patientDetailAddressButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailAddressDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientDetailAddressButton).toEqual(component.patientDetailAddressMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Detail Address', fakeAsync(() => {
		const patientDetailAddressButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailAddressDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientDetailAddressButton).toEqual(component.patientDetailAddressMultiCrudActive);

		if (component.patientDetailAddressMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientDetailAddressRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailAddressDisplayName + ' from Model')).length;

			patientDetailAddressButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientDetailAddressRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailAddressDisplayName + ' from Model')).length;

			expect(actualPatientDetailAddressRemoveButtonCount).toEqual(initialPatientDetailAddressRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Detail Address button', () => {
		const patientDetailAddressButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailAddressDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientDetailAddressButton).toEqual(component.patientDetailAddressMultiCrudActive);

		if (component.patientDetailAddressMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientDetailAddressButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientDetailAddressRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailAddressDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientDetailAddressRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientDetailAddressRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailAddressDisplayName + ' from Model'));

			expect(actualPatientDetailAddressRemoveButtons.length).toEqual(initialPatientDetailAddressRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Detail Address button when one has already been added', () => {

		const patientDetailAddressButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailAddressDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientDetailAddressButton).toEqual(component.patientDetailAddressMultiCrudActive);

		if (component.patientDetailAddressMultiCrudActive) {
			patientDetailAddressButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientDetailAddressButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailAddressDisplayName + ' to Model'));

			expect(updatedpatientDetailAddressButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Detail Address entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientDetailAddressMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientDetailAddressRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailAddressDisplayName + ' from Model')).length;

			expect(patientDetailAddressRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Detail relation.
	*
	* The button should only exist if patientDetailMultiCrudActive is true
	*/
	it ('Renders Patient Detail Add Entity button in create mode', fakeAsync(() => {
		const patientDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientDetailButton).toEqual(component.patientDetailMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Detail', fakeAsync(() => {
		const patientDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientDetailButton).toEqual(component.patientDetailMultiCrudActive);

		if (component.patientDetailMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailDisplayName + ' from Model')).length;

			patientDetailButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailDisplayName + ' from Model')).length;

			expect(actualPatientDetailRemoveButtonCount).toEqual(initialPatientDetailRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Detail button', () => {
		const patientDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientDetailButton).toEqual(component.patientDetailMultiCrudActive);

		if (component.patientDetailMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientDetailButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientDetailRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailDisplayName + ' from Model'));

			expect(actualPatientDetailRemoveButtons.length).toEqual(initialPatientDetailRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Detail button when one has already been added', () => {

		const patientDetailButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientDetailButton).toEqual(component.patientDetailMultiCrudActive);

		if (component.patientDetailMultiCrudActive) {
			patientDetailButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientDetailButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientDetailDisplayName + ' to Model'));

			expect(updatedpatientDetailButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Detail entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientDetailMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientDetailRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientDetailDisplayName + ' from Model')).length;

			expect(patientDetailRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Emergency Contact Detail relation.
	*
	* The button should only exist if patientEmergencyContactDetailMultiCrudActive is true
	*/
	it ('Renders Patient Emergency Contact Detail Add Entity button in create mode', fakeAsync(() => {
		const patientEmergencyContactDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmergencyContactDetailDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientEmergencyContactDetailButton).toEqual(component.patientEmergencyContactDetailMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Emergency Contact Detail', fakeAsync(() => {
		const patientEmergencyContactDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmergencyContactDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientEmergencyContactDetailButton).toEqual(component.patientEmergencyContactDetailMultiCrudActive);

		if (component.patientEmergencyContactDetailMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientEmergencyContactDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmergencyContactDetailDisplayName + ' from Model')).length;

			patientEmergencyContactDetailButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientEmergencyContactDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmergencyContactDetailDisplayName + ' from Model')).length;

			expect(actualPatientEmergencyContactDetailRemoveButtonCount).toEqual(initialPatientEmergencyContactDetailRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Emergency Contact Detail button', () => {
		const patientEmergencyContactDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmergencyContactDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientEmergencyContactDetailButton).toEqual(component.patientEmergencyContactDetailMultiCrudActive);

		if (component.patientEmergencyContactDetailMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientEmergencyContactDetailButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientEmergencyContactDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmergencyContactDetailDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientEmergencyContactDetailRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientEmergencyContactDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmergencyContactDetailDisplayName + ' from Model'));

			expect(actualPatientEmergencyContactDetailRemoveButtons.length).toEqual(initialPatientEmergencyContactDetailRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Emergency Contact Detail button when one has already been added', () => {

		const patientEmergencyContactDetailButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmergencyContactDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientEmergencyContactDetailButton).toEqual(component.patientEmergencyContactDetailMultiCrudActive);

		if (component.patientEmergencyContactDetailMultiCrudActive) {
			patientEmergencyContactDetailButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientEmergencyContactDetailButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmergencyContactDetailDisplayName + ' to Model'));

			expect(updatedpatientEmergencyContactDetailButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Emergency Contact Detail entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientEmergencyContactDetailMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientEmergencyContactDetailRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmergencyContactDetailDisplayName + ' from Model')).length;

			expect(patientEmergencyContactDetailRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Employment Detail  relation.
	*
	* The button should only exist if patientEmploymentDetailMultiCrudActive is true
	*/
	it ('Renders Patient Employment Detail  Add Entity button in create mode', fakeAsync(() => {
		const patientEmploymentDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmploymentDetailDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientEmploymentDetailButton).toEqual(component.patientEmploymentDetailMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Employment Detail ', fakeAsync(() => {
		const patientEmploymentDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmploymentDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientEmploymentDetailButton).toEqual(component.patientEmploymentDetailMultiCrudActive);

		if (component.patientEmploymentDetailMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientEmploymentDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmploymentDetailDisplayName + ' from Model')).length;

			patientEmploymentDetailButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientEmploymentDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmploymentDetailDisplayName + ' from Model')).length;

			expect(actualPatientEmploymentDetailRemoveButtonCount).toEqual(initialPatientEmploymentDetailRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Employment Detail  button', () => {
		const patientEmploymentDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmploymentDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientEmploymentDetailButton).toEqual(component.patientEmploymentDetailMultiCrudActive);

		if (component.patientEmploymentDetailMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientEmploymentDetailButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientEmploymentDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmploymentDetailDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientEmploymentDetailRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientEmploymentDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmploymentDetailDisplayName + ' from Model'));

			expect(actualPatientEmploymentDetailRemoveButtons.length).toEqual(initialPatientEmploymentDetailRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Employment Detail  button when one has already been added', () => {

		const patientEmploymentDetailButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmploymentDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientEmploymentDetailButton).toEqual(component.patientEmploymentDetailMultiCrudActive);

		if (component.patientEmploymentDetailMultiCrudActive) {
			patientEmploymentDetailButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientEmploymentDetailButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientEmploymentDetailDisplayName + ' to Model'));

			expect(updatedpatientEmploymentDetailButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Employment Detail  entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientEmploymentDetailMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientEmploymentDetailRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientEmploymentDetailDisplayName + ' from Model')).length;

			expect(patientEmploymentDetailRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Payment BPJS relation.
	*
	* The button should only exist if patientPaymentBPJSMultiCrudActive is true
	*/
	it ('Renders Patient Payment BPJS Add Entity button in create mode', fakeAsync(() => {
		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Payment BPJS', fakeAsync(() => {
		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);

		if (component.patientPaymentBPJSMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientPaymentBPJSRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model')).length;

			patientPaymentBPJSButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentBPJSRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model')).length;

			expect(actualPatientPaymentBPJSRemoveButtonCount).toEqual(initialPatientPaymentBPJSRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Payment BPJS button', () => {
		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);

		if (component.patientPaymentBPJSMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientPaymentBPJSButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientPaymentBPJSRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientPaymentBPJSRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentBPJSRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model'));

			expect(actualPatientPaymentBPJSRemoveButtons.length).toEqual(initialPatientPaymentBPJSRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Payment BPJS button when one has already been added', () => {

		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);

		if (component.patientPaymentBPJSMultiCrudActive) {
			patientPaymentBPJSButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientPaymentBPJSButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

			expect(updatedpatientPaymentBPJSButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Payment BPJS entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientPaymentBPJSMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientPaymentBPJSRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model')).length;

			expect(patientPaymentBPJSRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Payment Type Insurance relation.
	*
	* The button should only exist if patientPaymentTypeInsuranceMultiCrudActive is true
	*/
	it ('Renders Patient Payment Type Insurance Add Entity button in create mode', fakeAsync(() => {
		const patientPaymentTypeInsuranceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeInsuranceDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientPaymentTypeInsuranceButton).toEqual(component.patientPaymentTypeInsuranceMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Payment Type Insurance', fakeAsync(() => {
		const patientPaymentTypeInsuranceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeInsuranceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentTypeInsuranceButton).toEqual(component.patientPaymentTypeInsuranceMultiCrudActive);

		if (component.patientPaymentTypeInsuranceMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientPaymentTypeInsuranceRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeInsuranceDisplayName + ' from Model')).length;

			patientPaymentTypeInsuranceButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentTypeInsuranceRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeInsuranceDisplayName + ' from Model')).length;

			expect(actualPatientPaymentTypeInsuranceRemoveButtonCount).toEqual(initialPatientPaymentTypeInsuranceRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Payment Type Insurance button', () => {
		const patientPaymentTypeInsuranceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeInsuranceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentTypeInsuranceButton).toEqual(component.patientPaymentTypeInsuranceMultiCrudActive);

		if (component.patientPaymentTypeInsuranceMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientPaymentTypeInsuranceButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientPaymentTypeInsuranceRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeInsuranceDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientPaymentTypeInsuranceRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentTypeInsuranceRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeInsuranceDisplayName + ' from Model'));

			expect(actualPatientPaymentTypeInsuranceRemoveButtons.length).toEqual(initialPatientPaymentTypeInsuranceRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Payment Type Insurance button when one has already been added', () => {

		const patientPaymentTypeInsuranceButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeInsuranceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentTypeInsuranceButton).toEqual(component.patientPaymentTypeInsuranceMultiCrudActive);

		if (component.patientPaymentTypeInsuranceMultiCrudActive) {
			patientPaymentTypeInsuranceButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientPaymentTypeInsuranceButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeInsuranceDisplayName + ' to Model'));

			expect(updatedpatientPaymentTypeInsuranceButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Payment Type Insurance entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientPaymentTypeInsuranceMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientPaymentTypeInsuranceRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeInsuranceDisplayName + ' from Model')).length;

			expect(patientPaymentTypeInsuranceRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Payment Type Others relation.
	*
	* The button should only exist if patientPaymentTypeOthersMultiCrudActive is true
	*/
	it ('Renders Patient Payment Type Others Add Entity button in create mode', fakeAsync(() => {
		const patientPaymentTypeOthersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeOthersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientPaymentTypeOthersButton).toEqual(component.patientPaymentTypeOthersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Payment Type Others', fakeAsync(() => {
		const patientPaymentTypeOthersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeOthersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentTypeOthersButton).toEqual(component.patientPaymentTypeOthersMultiCrudActive);

		if (component.patientPaymentTypeOthersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientPaymentTypeOthersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeOthersDisplayName + ' from Model')).length;

			patientPaymentTypeOthersButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentTypeOthersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeOthersDisplayName + ' from Model')).length;

			expect(actualPatientPaymentTypeOthersRemoveButtonCount).toEqual(initialPatientPaymentTypeOthersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Payment Type Others button', () => {
		const patientPaymentTypeOthersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeOthersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentTypeOthersButton).toEqual(component.patientPaymentTypeOthersMultiCrudActive);

		if (component.patientPaymentTypeOthersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientPaymentTypeOthersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientPaymentTypeOthersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeOthersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientPaymentTypeOthersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentTypeOthersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeOthersDisplayName + ' from Model'));

			expect(actualPatientPaymentTypeOthersRemoveButtons.length).toEqual(initialPatientPaymentTypeOthersRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Payment Type Others button when one has already been added', () => {

		const patientPaymentTypeOthersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeOthersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentTypeOthersButton).toEqual(component.patientPaymentTypeOthersMultiCrudActive);

		if (component.patientPaymentTypeOthersMultiCrudActive) {
			patientPaymentTypeOthersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientPaymentTypeOthersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentTypeOthersDisplayName + ' to Model'));

			expect(updatedpatientPaymentTypeOthersButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Payment Type Others entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientPaymentTypeOthersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientPaymentTypeOthersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentTypeOthersDisplayName + ' from Model')).length;

			expect(patientPaymentTypeOthersRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Personal Information relation.
	*
	* The button should only exist if patientPersonalInformationMultiCrudActive is true
	*/
	it ('Renders Patient Personal Information Add Entity button in create mode', fakeAsync(() => {
		const patientPersonalInformationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPersonalInformationDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientPersonalInformationButton).toEqual(component.patientPersonalInformationMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Personal Information', fakeAsync(() => {
		const patientPersonalInformationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPersonalInformationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPersonalInformationButton).toEqual(component.patientPersonalInformationMultiCrudActive);

		if (component.patientPersonalInformationMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientPersonalInformationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPersonalInformationDisplayName + ' from Model')).length;

			patientPersonalInformationButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientPersonalInformationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPersonalInformationDisplayName + ' from Model')).length;

			expect(actualPatientPersonalInformationRemoveButtonCount).toEqual(initialPatientPersonalInformationRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Personal Information button', () => {
		const patientPersonalInformationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPersonalInformationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPersonalInformationButton).toEqual(component.patientPersonalInformationMultiCrudActive);

		if (component.patientPersonalInformationMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientPersonalInformationButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientPersonalInformationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPersonalInformationDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientPersonalInformationRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientPersonalInformationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPersonalInformationDisplayName + ' from Model'));

			expect(actualPatientPersonalInformationRemoveButtons.length).toEqual(initialPatientPersonalInformationRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Personal Information button when one has already been added', () => {

		const patientPersonalInformationButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPersonalInformationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPersonalInformationButton).toEqual(component.patientPersonalInformationMultiCrudActive);

		if (component.patientPersonalInformationMultiCrudActive) {
			patientPersonalInformationButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientPersonalInformationButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPersonalInformationDisplayName + ' to Model'));

			expect(updatedpatientPersonalInformationButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Personal Information entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientPersonalInformationMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientPersonalInformationRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPersonalInformationDisplayName + ' from Model')).length;

			expect(patientPersonalInformationRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Self Paying relation.
	*
	* The button should only exist if patientSelfPayingMultiCrudActive is true
	*/
	it ('Renders Patient Self Paying Add Entity button in create mode', fakeAsync(() => {
		const patientSelfPayingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientSelfPayingDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientSelfPayingButton).toEqual(component.patientSelfPayingMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Self Paying', fakeAsync(() => {
		const patientSelfPayingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientSelfPayingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientSelfPayingButton).toEqual(component.patientSelfPayingMultiCrudActive);

		if (component.patientSelfPayingMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientSelfPayingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientSelfPayingDisplayName + ' from Model')).length;

			patientSelfPayingButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientSelfPayingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientSelfPayingDisplayName + ' from Model')).length;

			expect(actualPatientSelfPayingRemoveButtonCount).toEqual(initialPatientSelfPayingRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Self Paying button', () => {
		const patientSelfPayingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientSelfPayingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientSelfPayingButton).toEqual(component.patientSelfPayingMultiCrudActive);

		if (component.patientSelfPayingMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientSelfPayingButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientSelfPayingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientSelfPayingDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientSelfPayingRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientSelfPayingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientSelfPayingDisplayName + ' from Model'));

			expect(actualPatientSelfPayingRemoveButtons.length).toEqual(initialPatientSelfPayingRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Self Paying button when one has already been added', () => {

		const patientSelfPayingButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientSelfPayingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientSelfPayingButton).toEqual(component.patientSelfPayingMultiCrudActive);

		if (component.patientSelfPayingMultiCrudActive) {
			patientSelfPayingButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientSelfPayingButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientSelfPayingDisplayName + ' to Model'));

			expect(updatedpatientSelfPayingButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Self Paying entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientSelfPayingMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientSelfPayingRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientSelfPayingDisplayName + ' from Model')).length;

			expect(patientSelfPayingRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Claim Submissions relation.
	*
	* The button should only exist if bpjsClaimSubmissionsMultiCrudActive is true
	*/
	it ('Renders BPJS Claim Submissions Add Entity button in create mode', fakeAsync(() => {
		const bpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsClaimSubmissionsButton).toEqual(component.bpjsClaimSubmissionsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Claim Submissions', fakeAsync(() => {
		const bpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsClaimSubmissionsButton).toEqual(component.bpjsClaimSubmissionsMultiCrudActive);

		if (component.bpjsClaimSubmissionsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsClaimSubmissionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model')).length;

			bpjsClaimSubmissionsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsClaimSubmissionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model')).length;

			expect(actualBpjsClaimSubmissionsRemoveButtonCount).toEqual(initialBpjsClaimSubmissionsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Claim Submissions button', () => {
		const bpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsClaimSubmissionsButton).toEqual(component.bpjsClaimSubmissionsMultiCrudActive);

		if (component.bpjsClaimSubmissionsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsClaimSubmissionsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsClaimSubmissionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsClaimSubmissionsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsClaimSubmissionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model'));

			expect(actualBpjsClaimSubmissionsRemoveButtons.length).toEqual(initialBpjsClaimSubmissionsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add BPJS Claim Submissions button when one has already been added', () => {

		const bpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsClaimSubmissionsButton).toEqual(component.bpjsClaimSubmissionsMultiCrudActive);

		if (component.bpjsClaimSubmissionsMultiCrudActive) {
			bpjsClaimSubmissionsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

			expect(updatedbpjsClaimSubmissionsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related BPJS Claim Submissions entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsClaimSubmissionsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsClaimSubmissionsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model')).length;

			expect(bpjsClaimSubmissionsRemoveButtonCount).toEqual(patientGeneralInfoWithId.bpjsClaimSubmissions.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Cash Refunds relation.
	*
	* The button should only exist if cashRefundsMultiCrudActive is true
	*/
	it ('Renders Cash Refunds Add Entity button in create mode', fakeAsync(() => {
		const cashRefundsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashRefundsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!cashRefundsButton).toEqual(component.cashRefundsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Cash Refunds', fakeAsync(() => {
		const cashRefundsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashRefundsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashRefundsButton).toEqual(component.cashRefundsMultiCrudActive);

		if (component.cashRefundsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCashRefundsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashRefundsDisplayName + ' from Model')).length;

			cashRefundsButton.nativeElement.click();
			fixture.detectChanges();

			const actualCashRefundsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashRefundsDisplayName + ' from Model')).length;

			expect(actualCashRefundsRemoveButtonCount).toEqual(initialCashRefundsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Cash Refunds button', () => {
		const cashRefundsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashRefundsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashRefundsButton).toEqual(component.cashRefundsMultiCrudActive);

		if (component.cashRefundsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			cashRefundsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCashRefundsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashRefundsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCashRefundsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCashRefundsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashRefundsDisplayName + ' from Model'));

			expect(actualCashRefundsRemoveButtons.length).toEqual(initialCashRefundsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Cash Refunds button when one has already been added', () => {

		const cashRefundsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashRefundsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashRefundsButton).toEqual(component.cashRefundsMultiCrudActive);

		if (component.cashRefundsMultiCrudActive) {
			cashRefundsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcashRefundsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashRefundsDisplayName + ' to Model'));

			expect(updatedcashRefundsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Cash Refunds entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.cashRefundsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const cashRefundsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashRefundsDisplayName + ' from Model')).length;

			expect(cashRefundsRemoveButtonCount).toEqual(patientGeneralInfoWithId.cashRefunds.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Informed Consents relation.
	*
	* The button should only exist if informedConsentsMultiCrudActive is true
	*/
	it ('Renders Informed Consents Add Entity button in create mode', fakeAsync(() => {
		const informedConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.informedConsentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!informedConsentsButton).toEqual(component.informedConsentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Informed Consents', fakeAsync(() => {
		const informedConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.informedConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!informedConsentsButton).toEqual(component.informedConsentsMultiCrudActive);

		if (component.informedConsentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInformedConsentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informedConsentsDisplayName + ' from Model')).length;

			informedConsentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInformedConsentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informedConsentsDisplayName + ' from Model')).length;

			expect(actualInformedConsentsRemoveButtonCount).toEqual(initialInformedConsentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Informed Consents button', () => {
		const informedConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.informedConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!informedConsentsButton).toEqual(component.informedConsentsMultiCrudActive);

		if (component.informedConsentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			informedConsentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInformedConsentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informedConsentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInformedConsentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInformedConsentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informedConsentsDisplayName + ' from Model'));

			expect(actualInformedConsentsRemoveButtons.length).toEqual(initialInformedConsentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Informed Consents button when one has already been added', () => {

		const informedConsentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.informedConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!informedConsentsButton).toEqual(component.informedConsentsMultiCrudActive);

		if (component.informedConsentsMultiCrudActive) {
			informedConsentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinformedConsentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.informedConsentsDisplayName + ' to Model'));

			expect(updatedinformedConsentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Informed Consents entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.informedConsentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const informedConsentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informedConsentsDisplayName + ' from Model')).length;

			expect(informedConsentsRemoveButtonCount).toEqual(patientGeneralInfoWithId.informedConsents.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoice Receipts relation.
	*
	* The button should only exist if invoiceReceiptsMultiCrudActive is true
	*/
	it ('Renders Invoice Receipts Add Entity button in create mode', fakeAsync(() => {
		const invoiceReceiptsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceReceiptsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoiceReceiptsButton).toEqual(component.invoiceReceiptsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Receipts', fakeAsync(() => {
		const invoiceReceiptsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceReceiptsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceReceiptsButton).toEqual(component.invoiceReceiptsMultiCrudActive);

		if (component.invoiceReceiptsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoiceReceiptsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceReceiptsDisplayName + ' from Model')).length;

			invoiceReceiptsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceReceiptsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceReceiptsDisplayName + ' from Model')).length;

			expect(actualInvoiceReceiptsRemoveButtonCount).toEqual(initialInvoiceReceiptsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Receipts button', () => {
		const invoiceReceiptsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceReceiptsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceReceiptsButton).toEqual(component.invoiceReceiptsMultiCrudActive);

		if (component.invoiceReceiptsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoiceReceiptsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoiceReceiptsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceReceiptsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoiceReceiptsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceReceiptsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceReceiptsDisplayName + ' from Model'));

			expect(actualInvoiceReceiptsRemoveButtons.length).toEqual(initialInvoiceReceiptsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoice Receipts button when one has already been added', () => {

		const invoiceReceiptsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceReceiptsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceReceiptsButton).toEqual(component.invoiceReceiptsMultiCrudActive);

		if (component.invoiceReceiptsMultiCrudActive) {
			invoiceReceiptsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoiceReceiptsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceReceiptsDisplayName + ' to Model'));

			expect(updatedinvoiceReceiptsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoice Receipts entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoiceReceiptsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoiceReceiptsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceReceiptsDisplayName + ' from Model')).length;

			expect(invoiceReceiptsRemoveButtonCount).toEqual(patientGeneralInfoWithId.invoiceReceipts.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Case Histories relation.
	*
	* The button should only exist if patientCaseHistoriesMultiCrudActive is true
	*/
	it ('Renders Patient Case Histories Add Entity button in create mode', fakeAsync(() => {
		const patientCaseHistoriesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientCaseHistoriesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientCaseHistoriesButton).toEqual(component.patientCaseHistoriesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Case Histories', fakeAsync(() => {
		const patientCaseHistoriesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientCaseHistoriesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientCaseHistoriesButton).toEqual(component.patientCaseHistoriesMultiCrudActive);

		if (component.patientCaseHistoriesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientCaseHistoriesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientCaseHistoriesDisplayName + ' from Model')).length;

			patientCaseHistoriesButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientCaseHistoriesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientCaseHistoriesDisplayName + ' from Model')).length;

			expect(actualPatientCaseHistoriesRemoveButtonCount).toEqual(initialPatientCaseHistoriesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Case Histories button', () => {
		const patientCaseHistoriesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientCaseHistoriesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientCaseHistoriesButton).toEqual(component.patientCaseHistoriesMultiCrudActive);

		if (component.patientCaseHistoriesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientCaseHistoriesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientCaseHistoriesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientCaseHistoriesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientCaseHistoriesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientCaseHistoriesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientCaseHistoriesDisplayName + ' from Model'));

			expect(actualPatientCaseHistoriesRemoveButtons.length).toEqual(initialPatientCaseHistoriesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Patient Case Histories button when one has already been added', () => {

		const patientCaseHistoriesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientCaseHistoriesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientCaseHistoriesButton).toEqual(component.patientCaseHistoriesMultiCrudActive);

		if (component.patientCaseHistoriesMultiCrudActive) {
			patientCaseHistoriesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientCaseHistoriesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientCaseHistoriesDisplayName + ' to Model'));

			expect(updatedpatientCaseHistoriesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Patient Case Histories entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientCaseHistoriesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientCaseHistoriesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientCaseHistoriesDisplayName + ' from Model')).length;

			expect(patientCaseHistoriesRemoveButtonCount).toEqual(patientGeneralInfoWithId.patientCaseHistories.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Consents relation.
	*
	* The button should only exist if patientConsentsMultiCrudActive is true
	*/
	it ('Renders Patient Consents Add Entity button in create mode', fakeAsync(() => {
		const patientConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientConsentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientConsentsButton).toEqual(component.patientConsentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Consents', fakeAsync(() => {
		const patientConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientConsentsButton).toEqual(component.patientConsentsMultiCrudActive);

		if (component.patientConsentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientConsentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientConsentsDisplayName + ' from Model')).length;

			patientConsentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientConsentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientConsentsDisplayName + ' from Model')).length;

			expect(actualPatientConsentsRemoveButtonCount).toEqual(initialPatientConsentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Consents button', () => {
		const patientConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientConsentsButton).toEqual(component.patientConsentsMultiCrudActive);

		if (component.patientConsentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientConsentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientConsentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientConsentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientConsentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientConsentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientConsentsDisplayName + ' from Model'));

			expect(actualPatientConsentsRemoveButtons.length).toEqual(initialPatientConsentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Patient Consents button when one has already been added', () => {

		const patientConsentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientConsentsButton).toEqual(component.patientConsentsMultiCrudActive);

		if (component.patientConsentsMultiCrudActive) {
			patientConsentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientConsentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientConsentsDisplayName + ' to Model'));

			expect(updatedpatientConsentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Patient Consents entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientConsentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientConsentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientConsentsDisplayName + ' from Model')).length;

			expect(patientConsentsRemoveButtonCount).toEqual(patientGeneralInfoWithId.patientConsents.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Finalize Profiles relation.
	*
	* The button should only exist if patientFinalizeProfilesMultiCrudActive is true
	*/
	it ('Renders Patient Finalize Profiles Add Entity button in create mode', fakeAsync(() => {
		const patientFinalizeProfilesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientFinalizeProfilesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientFinalizeProfilesButton).toEqual(component.patientFinalizeProfilesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Finalize Profiles', fakeAsync(() => {
		const patientFinalizeProfilesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientFinalizeProfilesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientFinalizeProfilesButton).toEqual(component.patientFinalizeProfilesMultiCrudActive);

		if (component.patientFinalizeProfilesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientFinalizeProfilesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientFinalizeProfilesDisplayName + ' from Model')).length;

			patientFinalizeProfilesButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientFinalizeProfilesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientFinalizeProfilesDisplayName + ' from Model')).length;

			expect(actualPatientFinalizeProfilesRemoveButtonCount).toEqual(initialPatientFinalizeProfilesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Finalize Profiles button', () => {
		const patientFinalizeProfilesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientFinalizeProfilesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientFinalizeProfilesButton).toEqual(component.patientFinalizeProfilesMultiCrudActive);

		if (component.patientFinalizeProfilesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientFinalizeProfilesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientFinalizeProfilesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientFinalizeProfilesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientFinalizeProfilesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientFinalizeProfilesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientFinalizeProfilesDisplayName + ' from Model'));

			expect(actualPatientFinalizeProfilesRemoveButtons.length).toEqual(initialPatientFinalizeProfilesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Patient Finalize Profiles button when one has already been added', () => {

		const patientFinalizeProfilesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientFinalizeProfilesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientFinalizeProfilesButton).toEqual(component.patientFinalizeProfilesMultiCrudActive);

		if (component.patientFinalizeProfilesMultiCrudActive) {
			patientFinalizeProfilesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientFinalizeProfilesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientFinalizeProfilesDisplayName + ' to Model'));

			expect(updatedpatientFinalizeProfilesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Patient Finalize Profiles entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientFinalizeProfilesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientFinalizeProfilesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientFinalizeProfilesDisplayName + ' from Model')).length;

			expect(patientFinalizeProfilesRemoveButtonCount).toEqual(patientGeneralInfoWithId.patientFinalizeProfiles.length);
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
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
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

			expect(retailPharmaciesRemoveButtonCount).toEqual(patientGeneralInfoWithId.retailPharmacies.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Visits relation.
	*
	* The button should only exist if visitsMultiCrudActive is true
	*/
	it ('Renders Visits Add Entity button in create mode', fakeAsync(() => {
		const visitsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.visitsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!visitsButton).toEqual(component.visitsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Visits', fakeAsync(() => {
		const visitsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.visitsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!visitsButton).toEqual(component.visitsMultiCrudActive);

		if (component.visitsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialVisitsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.visitsDisplayName + ' from Model')).length;

			visitsButton.nativeElement.click();
			fixture.detectChanges();

			const actualVisitsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.visitsDisplayName + ' from Model')).length;

			expect(actualVisitsRemoveButtonCount).toEqual(initialVisitsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Visits button', () => {
		const visitsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.visitsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!visitsButton).toEqual(component.visitsMultiCrudActive);

		if (component.visitsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			visitsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialVisitsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.visitsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialVisitsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualVisitsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.visitsDisplayName + ' from Model'));

			expect(actualVisitsRemoveButtons.length).toEqual(initialVisitsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Visits button when one has already been added', () => {

		const visitsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.visitsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!visitsButton).toEqual(component.visitsMultiCrudActive);

		if (component.visitsMultiCrudActive) {
			visitsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedvisitsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.visitsDisplayName + ' to Model'));

			expect(updatedvisitsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Visits entities from model when loading in edit mode', () => {
		component.targetModel = patientGeneralInfoWithId;
		component.targetModelId = patientGeneralInfoWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.visitsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const visitsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.visitsDisplayName + ' from Model')).length;

			expect(visitsRemoveButtonCount).toEqual(patientGeneralInfoWithId.visits.length);
		}
	});

});
