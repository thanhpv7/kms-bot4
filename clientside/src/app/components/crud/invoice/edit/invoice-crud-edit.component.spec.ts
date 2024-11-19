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
	getInvoiceCollectionModels,
	getCountInvoiceModels,
	getInvoiceModelWithId
} from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceCrudModule } from '../invoice-crud.module';
import { InvoiceCrudEditComponent } from './invoice-crud-edit.component';
import {
	InvoiceModelState,
	initialState as initialInvoiceModelState
} from 'src/app/models/invoice/invoice.model.state';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { CrudTileMode } from '../invoice-crud.component';
import { getAdministrationUserModelWithId } from 'src/app/models/administrationUser/administration_user.model.selector';
import { getAdministrationUserCollectionModels } from 'src/app/models/administrationUser/administration_user.model.selector';
import { AdministrationUserModel } from 'src/app/models/administrationUser/administration_user.model';
import { AdministrationUserDataFactory } from 'src/app/lib/utils/factories/administration-user-data-factory';
import { getAdministratorModelWithId } from 'src/app/models/administrator/administrator.model.selector';
import { getAdministratorCollectionModels } from 'src/app/models/administrator/administrator.model.selector';
import { AdministratorModel } from 'src/app/models/administrator/administrator.model';
import { AdministratorDataFactory } from 'src/app/lib/utils/factories/administrator-data-factory';
import { getAmendmentDetailModelWithId } from 'src/app/models/amendmentDetail/amendment_detail.model.selector';
import { getAmendmentDetailCollectionModels } from 'src/app/models/amendmentDetail/amendment_detail.model.selector';
import { AmendmentDetailModel } from 'src/app/models/amendmentDetail/amendment_detail.model';
import { AmendmentDetailDataFactory } from 'src/app/lib/utils/factories/amendment-detail-data-factory';
import { getBpjsDiagnoseModelWithId } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { getBpjsDiagnoseCollectionModels } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { BpjsDiagnoseModel } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import { BpjsDiagnoseDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-data-factory';
import { getBpjsDiagnosePRBModelWithId } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.selector';
import { getBpjsDiagnosePRBCollectionModels } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.selector';
import { BpjsDiagnosePRBModel } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model';
import { BpjsDiagnosePRBDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-prb-data-factory';
import { getBpjsDoctorMappingModelWithId } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-doctor-mapping-data-factory';
import { getBpjsPcareRegistrationsModelWithId } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { getBpjsPcareRegistrationsCollectionModels } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { BpjsPcareRegistrationsModel } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import { BpjsPcareRegistrationsDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-registrations-data-factory';
import { getBpjsVisitDataModelWithId } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.selector';
import { getBpjsVisitDataCollectionModels } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.selector';
import { BpjsVisitDataModel } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model';
import { BpjsVisitDataDataFactory } from 'src/app/lib/utils/factories/bpjs-visit-data-data-factory';
import { getBedFacilityModelWithId } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { getBedFacilityCollectionModels } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { BedFacilityModel } from 'src/app/models/bedFacility/bed_facility.model';
import { BedFacilityDataFactory } from 'src/app/lib/utils/factories/bed-facility-data-factory';
import { getBedReserveModelWithId } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { getBedReserveCollectionModels } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { BedReserveModel } from 'src/app/models/bedReserve/bed_reserve.model';
import { BedReserveDataFactory } from 'src/app/lib/utils/factories/bed-reserve-data-factory';
import { getBpjsPcarePendaftaranModelWithId } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.selector';
import { getBpjsPcarePendaftaranCollectionModels } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.selector';
import { BpjsPcarePendaftaranModel } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model';
import { BpjsPcarePendaftaranDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-pendaftaran-data-factory';
import { getCashReceiptModelWithId } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { getCashReceiptCollectionModels } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { CashReceiptModel } from 'src/app/models/cashReceipt/cash_receipt.model';
import { CashReceiptDataFactory } from 'src/app/lib/utils/factories/cash-receipt-data-factory';
import { getCashierUserModelWithId } from 'src/app/models/cashierUser/cashier_user.model.selector';
import { getCashierUserCollectionModels } from 'src/app/models/cashierUser/cashier_user.model.selector';
import { CashierUserModel } from 'src/app/models/cashierUser/cashier_user.model';
import { CashierUserDataFactory } from 'src/app/lib/utils/factories/cashier-user-data-factory';
import { getClaimUserModelWithId } from 'src/app/models/claimUser/claim_user.model.selector';
import { getClaimUserCollectionModels } from 'src/app/models/claimUser/claim_user.model.selector';
import { ClaimUserModel } from 'src/app/models/claimUser/claim_user.model';
import { ClaimUserDataFactory } from 'src/app/lib/utils/factories/claim-user-data-factory';
import { getCoTreatingDoctorModelWithId } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import { getCoTreatingDoctorCollectionModels } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import { CoTreatingDoctorModel } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import { CoTreatingDoctorDataFactory } from 'src/app/lib/utils/factories/co-treating-doctor-data-factory';
import { getDailyCareCPPTModelWithId } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import { getDailyCareCPPTCollectionModels } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import { DailyCareCPPTModel } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import { DailyCareCPPTDataFactory } from 'src/app/lib/utils/factories/daily-care-cppt-data-factory';
import { getDeliveryMedicalExaminationRecordModelWithId } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import { getDeliveryMedicalExaminationRecordCollectionModels } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import { DeliveryMedicalExaminationRecordModel } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import { DeliveryMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/delivery-medical-examination-record-data-factory';
import { getDeliveryProgressModelWithId } from 'src/app/models/deliveryProgress/delivery_progress.model.selector';
import { getDeliveryProgressCollectionModels } from 'src/app/models/deliveryProgress/delivery_progress.model.selector';
import { DeliveryProgressModel } from 'src/app/models/deliveryProgress/delivery_progress.model';
import { DeliveryProgressDataFactory } from 'src/app/lib/utils/factories/delivery-progress-data-factory';
import { getDiagnosesAndProceduresModelWithId } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { getDiagnosesAndProceduresCollectionModels } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { DiagnosesAndProceduresDataFactory } from 'src/app/lib/utils/factories/diagnoses-and-procedures-data-factory';
import { getDiagnosisExaminationRecordModelWithId } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import { getDiagnosisExaminationRecordCollectionModels } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import { DiagnosisExaminationRecordModel } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model';
import { DiagnosisExaminationRecordDataFactory } from 'src/app/lib/utils/factories/diagnosis-examination-record-data-factory';
import { getDiagnosisNandaModelWithId } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { getDiagnosisNandaCollectionModels } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { DiagnosisNandaModel } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import { DiagnosisNandaDataFactory } from 'src/app/lib/utils/factories/diagnosis-nanda-data-factory';
import { getDiagnosticStaffExaminationSummaryModelWithId } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.selector';
import { getDiagnosticStaffExaminationSummaryCollectionModels } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.selector';
import { DiagnosticStaffExaminationSummaryModel } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import { DiagnosticStaffExaminationSummaryDataFactory } from 'src/app/lib/utils/factories/diagnostic-staff-examination-summary-data-factory';
import { getDiagnosticSupportUserModelWithId } from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model.selector';
import { getDiagnosticSupportUserCollectionModels } from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model.selector';
import { DiagnosticSupportUserModel } from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model';
import { DiagnosticSupportUserDataFactory } from 'src/app/lib/utils/factories/diagnostic-support-user-data-factory';
import { getDoctorScheduleModelWithId } from 'src/app/models/doctorSchedule/doctor_schedule.model.selector';
import { getDoctorScheduleCollectionModels } from 'src/app/models/doctorSchedule/doctor_schedule.model.selector';
import { DoctorScheduleModel } from 'src/app/models/doctorSchedule/doctor_schedule.model';
import { DoctorScheduleDataFactory } from 'src/app/lib/utils/factories/doctor-schedule-data-factory';
import { getDoctorUserModelWithId } from 'src/app/models/doctorUser/doctor_user.model.selector';
import { getDoctorUserCollectionModels } from 'src/app/models/doctorUser/doctor_user.model.selector';
import { DoctorUserModel } from 'src/app/models/doctorUser/doctor_user.model';
import { DoctorUserDataFactory } from 'src/app/lib/utils/factories/doctor-user-data-factory';
import { getFacilityUserModelWithId } from 'src/app/models/facilityUser/facility_user.model.selector';
import { getFacilityUserCollectionModels } from 'src/app/models/facilityUser/facility_user.model.selector';
import { FacilityUserModel } from 'src/app/models/facilityUser/facility_user.model';
import { FacilityUserDataFactory } from 'src/app/lib/utils/factories/facility-user-data-factory';
import { getFluidBalanceDetailModelWithId } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { getFluidBalanceDetailCollectionModels } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { FluidBalanceDetailModel } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import { FluidBalanceDetailDataFactory } from 'src/app/lib/utils/factories/fluid-balance-detail-data-factory';
import { getHemodialysisMonitoringModelWithId } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model.selector';
import { getHemodialysisMonitoringCollectionModels } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model.selector';
import { HemodialysisMonitoringModel } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model';
import { HemodialysisMonitoringDataFactory } from 'src/app/lib/utils/factories/hemodialysis-monitoring-data-factory';
import { getHospitalBranchInformationModelWithId } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.selector';
import { getHospitalBranchInformationCollectionModels } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.selector';
import { HospitalBranchInformationModel } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model';
import { HospitalBranchInformationDataFactory } from 'src/app/lib/utils/factories/hospital-branch-information-data-factory';
import { getIcd10ModelWithId } from 'src/app/models/icd10/icd_10.model.selector';
import { getIcd10CollectionModels } from 'src/app/models/icd10/icd_10.model.selector';
import { Icd10Model } from 'src/app/models/icd10/icd_10.model';
import { Icd10DataFactory } from 'src/app/lib/utils/factories/icd-10-data-factory';
import { getIcd9CMModelWithId } from 'src/app/models/icd9CM/icd_9_cm.model.selector';
import { getIcd9CMCollectionModels } from 'src/app/models/icd9CM/icd_9_cm.model.selector';
import { Icd9CMModel } from 'src/app/models/icd9CM/icd_9_cm.model';
import { Icd9CMDataFactory } from 'src/app/lib/utils/factories/icd-9-cm-data-factory';
import { getInformedConsentModelWithId } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { getInformedConsentCollectionModels } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { InformedConsentModel } from 'src/app/models/informedConsent/informed_consent.model';
import { InformedConsentDataFactory } from 'src/app/lib/utils/factories/informed-consent-data-factory';
import { getInpatientMedicalExaminationRecordModelWithId } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { getInpatientMedicalExaminationRecordCollectionModels } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { InpatientMedicalExaminationRecordModel } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import { InpatientMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/inpatient-medical-examination-record-data-factory';
import { getInsuranceBenefitPlanModelWithId } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.selector';
import { getInsuranceBenefitPlanCollectionModels } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.selector';
import { InsuranceBenefitPlanModel } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model';
import { InsuranceBenefitPlanDataFactory } from 'src/app/lib/utils/factories/insurance-benefit-plan-data-factory';
import { getIntraoperativeRecordsModelWithId } from 'src/app/models/intraoperativeRecords/intraoperative_records.model.selector';
import { getIntraoperativeRecordsCollectionModels } from 'src/app/models/intraoperativeRecords/intraoperative_records.model.selector';
import { IntraoperativeRecordsModel } from 'src/app/models/intraoperativeRecords/intraoperative_records.model';
import { IntraoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/intraoperative-records-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
import { getInvoiceItemComponentModelWithId } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.selector';
import { getInvoiceItemComponentCollectionModels } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.selector';
import { InvoiceItemComponentModel } from 'src/app/models/invoiceItemComponent/invoice_item_component.model';
import { InvoiceItemComponentDataFactory } from 'src/app/lib/utils/factories/invoice-item-component-data-factory';
import { getInvoicePaymentInsuranceModelWithId } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import { getInvoicePaymentInsuranceCollectionModels } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import { InvoicePaymentInsuranceModel } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model';
import { InvoicePaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/invoice-payment-insurance-data-factory';
import { getInvoicePaymentOtherModelWithId } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model.selector';
import { getInvoicePaymentOtherCollectionModels } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model.selector';
import { InvoicePaymentOtherModel } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model';
import { InvoicePaymentOtherDataFactory } from 'src/app/lib/utils/factories/invoice-payment-other-data-factory';
import { getInvoicePaymentSelfPayingModelWithId } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model.selector';
import { getInvoicePaymentSelfPayingCollectionModels } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model.selector';
import { InvoicePaymentSelfPayingModel } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model';
import { InvoicePaymentSelfPayingDataFactory } from 'src/app/lib/utils/factories/invoice-payment-self-paying-data-factory';
import { getInvoiceSummaryModelWithId } from 'src/app/models/invoiceSummary/invoice_summary.model.selector';
import { getInvoiceSummaryCollectionModels } from 'src/app/models/invoiceSummary/invoice_summary.model.selector';
import { InvoiceSummaryModel } from 'src/app/models/invoiceSummary/invoice_summary.model';
import { InvoiceSummaryDataFactory } from 'src/app/lib/utils/factories/invoice-summary-data-factory';
import { getMcuPackageItemModelWithId } from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import { getMcuPackageItemCollectionModels } from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import { McuPackageItemModel } from 'src/app/models/mcuPackageItem/mcu_package_item.model';
import { McuPackageItemDataFactory } from 'src/app/lib/utils/factories/mcu-package-item-data-factory';
import { getManagementUserModelWithId } from 'src/app/models/managementUser/management_user.model.selector';
import { getManagementUserCollectionModels } from 'src/app/models/managementUser/management_user.model.selector';
import { ManagementUserModel } from 'src/app/models/managementUser/management_user.model';
import { ManagementUserDataFactory } from 'src/app/lib/utils/factories/management-user-data-factory';
import { getMedicalCertificateDischargeResumeModelWithId } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import { getMedicalCertificateDischargeResumeCollectionModels } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import { MedicalCertificateDischargeResumeModel } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import { MedicalCertificateDischargeResumeDataFactory } from 'src/app/lib/utils/factories/medical-certificate-discharge-resume-data-factory';
import { getMedicalCertificateBirthModelWithId } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.selector';
import { getMedicalCertificateBirthCollectionModels } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.selector';
import { MedicalCertificateBirthModel } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model';
import { MedicalCertificateBirthDataFactory } from 'src/app/lib/utils/factories/medical-certificate-birth-data-factory';
import { getMedicalCertificateHospitalizationModelWithId } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.selector';
import { getMedicalCertificateHospitalizationCollectionModels } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.selector';
import { MedicalCertificateHospitalizationModel } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model';
import { MedicalCertificateHospitalizationDataFactory } from 'src/app/lib/utils/factories/medical-certificate-hospitalization-data-factory';
import { getMedicalCertificateMedicalAttendanceModelWithId } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.selector';
import { getMedicalCertificateMedicalAttendanceCollectionModels } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.selector';
import { MedicalCertificateMedicalAttendanceModel } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model';
import { MedicalCertificateMedicalAttendanceDataFactory } from 'src/app/lib/utils/factories/medical-certificate-medical-attendance-data-factory';
import { getMedicalCertificateMentalHealthModelWithId } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.selector';
import { getMedicalCertificateMentalHealthCollectionModels } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.selector';
import { MedicalCertificateMentalHealthModel } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model';
import { MedicalCertificateMentalHealthDataFactory } from 'src/app/lib/utils/factories/medical-certificate-mental-health-data-factory';
import { getMedicalCertificatePhysicalHealthModelWithId } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.selector';
import { getMedicalCertificatePhysicalHealthCollectionModels } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.selector';
import { MedicalCertificatePhysicalHealthModel } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model';
import { MedicalCertificatePhysicalHealthDataFactory } from 'src/app/lib/utils/factories/medical-certificate-physical-health-data-factory';
import { getMedicalCertificateRestrictedWorkModelWithId } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.selector';
import { getMedicalCertificateRestrictedWorkCollectionModels } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.selector';
import { MedicalCertificateRestrictedWorkModel } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model';
import { MedicalCertificateRestrictedWorkDataFactory } from 'src/app/lib/utils/factories/medical-certificate-restricted-work-data-factory';
import { getMedicalCertificateSickLeaveModelWithId } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.selector';
import { getMedicalCertificateSickLeaveCollectionModels } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.selector';
import { MedicalCertificateSickLeaveModel } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model';
import { MedicalCertificateSickLeaveDataFactory } from 'src/app/lib/utils/factories/medical-certificate-sick-leave-data-factory';
import { getMedicalExaminationRecordModelWithId } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import { getMedicalExaminationRecordCollectionModels } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import { MedicalExaminationRecordModel } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import { MedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/medical-examination-record-data-factory';
import { getMedicalExaminationRecordDischargeSummaryModelWithId } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.selector';
import { getMedicalExaminationRecordDischargeSummaryCollectionModels } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.selector';
import { MedicalExaminationRecordDischargeSummaryModel } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model';
import { MedicalExaminationRecordDischargeSummaryDataFactory } from 'src/app/lib/utils/factories/medical-examination-record-discharge-summary-data-factory';
import { getMedicalFeeModelWithId } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { getMedicalFeeCollectionModels } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { MedicalFeeModel } from 'src/app/models/medicalFee/medical_fee.model';
import { MedicalFeeDataFactory } from 'src/app/lib/utils/factories/medical-fee-data-factory';
import { getMedicalRecordUserModelWithId } from 'src/app/models/medicalRecordUser/medical_record_user.model.selector';
import { getMedicalRecordUserCollectionModels } from 'src/app/models/medicalRecordUser/medical_record_user.model.selector';
import { MedicalRecordUserModel } from 'src/app/models/medicalRecordUser/medical_record_user.model';
import { MedicalRecordUserDataFactory } from 'src/app/lib/utils/factories/medical-record-user-data-factory';
import { getMedicalTranscriberUserModelWithId } from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model.selector';
import { getMedicalTranscriberUserCollectionModels } from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model.selector';
import { MedicalTranscriberUserModel } from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model';
import { MedicalTranscriberUserDataFactory } from 'src/app/lib/utils/factories/medical-transcriber-user-data-factory';
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
import { getNewbornDetailModelWithId } from 'src/app/models/newbornDetail/newborn_detail.model.selector';
import { getNewbornDetailCollectionModels } from 'src/app/models/newbornDetail/newborn_detail.model.selector';
import { NewbornDetailModel } from 'src/app/models/newbornDetail/newborn_detail.model';
import { NewbornDetailDataFactory } from 'src/app/lib/utils/factories/newborn-detail-data-factory';
import { getNurseUserModelWithId } from 'src/app/models/nurseUser/nurse_user.model.selector';
import { getNurseUserCollectionModels } from 'src/app/models/nurseUser/nurse_user.model.selector';
import { NurseUserModel } from 'src/app/models/nurseUser/nurse_user.model';
import { NurseUserDataFactory } from 'src/app/lib/utils/factories/nurse-user-data-factory';
import { getOperatingTheaterMedicalExaminationRecordModelWithId } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { getOperatingTheaterMedicalExaminationRecordCollectionModels } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { OperatingTheaterMedicalExaminationRecordModel } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import { OperatingTheaterMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/operating-theater-medical-examination-record-data-factory';
import { getPcareDokterModelWithId } from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import { getPcareDokterCollectionModels } from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import { PcareDokterModel } from 'src/app/models/pcareDokter/pcare_dokter.model';
import { PcareDokterDataFactory } from 'src/app/lib/utils/factories/pcare-dokter-data-factory';
import { getPatientConsentModelWithId } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { getPatientConsentCollectionModels } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { PatientConsentModel } from 'src/app/models/patientConsent/patient_consent.model';
import { PatientConsentDataFactory } from 'src/app/lib/utils/factories/patient-consent-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
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
import { getPatientVitalInformationModelWithId } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { getPatientVitalInformationCollectionModels } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { PatientVitalInformationModel } from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import { PatientVitalInformationDataFactory } from 'src/app/lib/utils/factories/patient-vital-information-data-factory';
import { getPharmacyUserModelWithId } from 'src/app/models/pharmacyUser/pharmacy_user.model.selector';
import { getPharmacyUserCollectionModels } from 'src/app/models/pharmacyUser/pharmacy_user.model.selector';
import { PharmacyUserModel } from 'src/app/models/pharmacyUser/pharmacy_user.model';
import { PharmacyUserDataFactory } from 'src/app/lib/utils/factories/pharmacy-user-data-factory';
import { getPostOperativeDetailsModelWithId } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { getPostOperativeDetailsCollectionModels } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { PostOperativeDetailsModel } from 'src/app/models/postOperativeDetails/post_operative_details.model';
import { PostOperativeDetailsDataFactory } from 'src/app/lib/utils/factories/post-operative-details-data-factory';
import { getPreoperativeRecordsModelWithId } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { getPreoperativeRecordsCollectionModels } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { PreoperativeRecordsModel } from 'src/app/models/preoperativeRecords/preoperative_records.model';
import { PreoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/preoperative-records-data-factory';
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
import { getProcessWorkflowModelWithId } from 'src/app/models/processWorkflow/process_workflow.model.selector';
import { getProcessWorkflowCollectionModels } from 'src/app/models/processWorkflow/process_workflow.model.selector';
import { ProcessWorkflowModel } from 'src/app/models/processWorkflow/process_workflow.model';
import { ProcessWorkflowDataFactory } from 'src/app/lib/utils/factories/process-workflow-data-factory';
import { getPurchasingUserModelWithId } from 'src/app/models/purchasingUser/purchasing_user.model.selector';
import { getPurchasingUserCollectionModels } from 'src/app/models/purchasingUser/purchasing_user.model.selector';
import { PurchasingUserModel } from 'src/app/models/purchasingUser/purchasing_user.model';
import { PurchasingUserDataFactory } from 'src/app/lib/utils/factories/purchasing-user-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getRegistrationUserModelWithId } from 'src/app/models/registrationUser/registration_user.model.selector';
import { getRegistrationUserCollectionModels } from 'src/app/models/registrationUser/registration_user.model.selector';
import { RegistrationUserModel } from 'src/app/models/registrationUser/registration_user.model';
import { RegistrationUserDataFactory } from 'src/app/lib/utils/factories/registration-user-data-factory';
import { getRetailPharmacyInvoiceModelWithId } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { getRetailPharmacyInvoiceCollectionModels } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { RetailPharmacyInvoiceModel } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model';
import { RetailPharmacyInvoiceDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-invoice-data-factory';
import { getRoomFacilityModelWithId } from 'src/app/models/roomFacility/room_facility.model.selector';
import { getRoomFacilityCollectionModels } from 'src/app/models/roomFacility/room_facility.model.selector';
import { RoomFacilityModel } from 'src/app/models/roomFacility/room_facility.model';
import { RoomFacilityDataFactory } from 'src/app/lib/utils/factories/room-facility-data-factory';
import { getRoomTransferModelWithId } from 'src/app/models/roomTransfer/room_transfer.model.selector';
import { getRoomTransferCollectionModels } from 'src/app/models/roomTransfer/room_transfer.model.selector';
import { RoomTransferModel } from 'src/app/models/roomTransfer/room_transfer.model';
import { RoomTransferDataFactory } from 'src/app/lib/utils/factories/room-transfer-data-factory';
import { getSampleCollectionItemsModelWithId } from 'src/app/models/sampleCollectionItems/sample_collection_items.model.selector';
import { getSampleCollectionItemsCollectionModels } from 'src/app/models/sampleCollectionItems/sample_collection_items.model.selector';
import { SampleCollectionItemsModel } from 'src/app/models/sampleCollectionItems/sample_collection_items.model';
import { SampleCollectionItemsDataFactory } from 'src/app/lib/utils/factories/sample-collection-items-data-factory';
import { getServiceModelWithId } from 'src/app/models/service/service.model.selector';
import { getServiceCollectionModels } from 'src/app/models/service/service.model.selector';
import { ServiceModel } from 'src/app/models/service/service.model';
import { ServiceDataFactory } from 'src/app/lib/utils/factories/service-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { getSystemAdminUserModelWithId } from 'src/app/models/systemAdminUser/system_admin_user.model.selector';
import { getSystemAdminUserCollectionModels } from 'src/app/models/systemAdminUser/system_admin_user.model.selector';
import { SystemAdminUserModel } from 'src/app/models/systemAdminUser/system_admin_user.model';
import { SystemAdminUserDataFactory } from 'src/app/lib/utils/factories/system-admin-user-data-factory';
import { getTariffDefinitionModelWithId } from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { getTariffDefinitionCollectionModels } from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { TariffDefinitionModel } from 'src/app/models/tariffDefinition/tariff_definition.model';
import { TariffDefinitionDataFactory } from 'src/app/lib/utils/factories/tariff-definition-data-factory';
import { getTariffFormulaModelWithId } from 'src/app/models/tariffFormula/tariff_formula.model.selector';
import { getTariffFormulaCollectionModels } from 'src/app/models/tariffFormula/tariff_formula.model.selector';
import { TariffFormulaModel } from 'src/app/models/tariffFormula/tariff_formula.model';
import { TariffFormulaDataFactory } from 'src/app/lib/utils/factories/tariff-formula-data-factory';
import { getTariffSchemaModelWithId } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { getTariffSchemaCollectionModels } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { TariffSchemaModel } from 'src/app/models/tariffSchema/tariff_schema.model';
import { TariffSchemaDataFactory } from 'src/app/lib/utils/factories/tariff-schema-data-factory';
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
import { getWarehouseUserModelWithId } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { getWarehouseUserCollectionModels } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { WarehouseUserModel } from 'src/app/models/warehouseUser/warehouse_user.model';
import { WarehouseUserDataFactory } from 'src/app/lib/utils/factories/warehouse-user-data-factory';

describe('Invoice CRUD Edit component tests', () => {
	let fixture: ComponentFixture<InvoiceCrudEditComponent>
	let component: InvoiceCrudEditComponent;

	let invoiceModelState: InvoiceModelState;

	let store: MockStore<{ model: InvoiceModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let invoiceCountBehaviorSubject: BehaviorSubject<number>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let administrationUserModelsBehaviorSubject: BehaviorSubject<AdministrationUserModel[]>;
	let administratorModelsBehaviorSubject: BehaviorSubject<AdministratorModel[]>;
	let amendmentDetailModelsBehaviorSubject: BehaviorSubject<AmendmentDetailModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsDiagnosePRBModelsBehaviorSubject: BehaviorSubject<BpjsDiagnosePRBModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsPcareRegistrationsModelsBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel[]>;
	let bpjsVisitDataModelsBehaviorSubject: BehaviorSubject<BpjsVisitDataModel[]>;
	let bedFacilityModelsBehaviorSubject: BehaviorSubject<BedFacilityModel[]>;
	let bedReserveModelsBehaviorSubject: BehaviorSubject<BedReserveModel[]>;
	let bpjsPcarePendaftaranModelsBehaviorSubject: BehaviorSubject<BpjsPcarePendaftaranModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let cashierUserModelsBehaviorSubject: BehaviorSubject<CashierUserModel[]>;
	let claimUserModelsBehaviorSubject: BehaviorSubject<ClaimUserModel[]>;
	let coTreatingDoctorModelsBehaviorSubject: BehaviorSubject<CoTreatingDoctorModel[]>;
	let dailyCareCPPTModelsBehaviorSubject: BehaviorSubject<DailyCareCPPTModel[]>;
	let deliveryMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<DeliveryMedicalExaminationRecordModel[]>;
	let deliveryProgressModelsBehaviorSubject: BehaviorSubject<DeliveryProgressModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let diagnosisExaminationRecordModelsBehaviorSubject: BehaviorSubject<DiagnosisExaminationRecordModel[]>;
	let diagnosisNandaModelsBehaviorSubject: BehaviorSubject<DiagnosisNandaModel[]>;
	let diagnosticStaffExaminationSummaryModelsBehaviorSubject: BehaviorSubject<DiagnosticStaffExaminationSummaryModel[]>;
	let diagnosticSupportUserModelsBehaviorSubject: BehaviorSubject<DiagnosticSupportUserModel[]>;
	let doctorScheduleModelsBehaviorSubject: BehaviorSubject<DoctorScheduleModel[]>;
	let doctorUserModelsBehaviorSubject: BehaviorSubject<DoctorUserModel[]>;
	let facilityUserModelsBehaviorSubject: BehaviorSubject<FacilityUserModel[]>;
	let fluidBalanceDetailModelsBehaviorSubject: BehaviorSubject<FluidBalanceDetailModel[]>;
	let hemodialysisMonitoringModelsBehaviorSubject: BehaviorSubject<HemodialysisMonitoringModel[]>;
	let hospitalBranchInformationModelsBehaviorSubject: BehaviorSubject<HospitalBranchInformationModel[]>;
	let icd10ModelsBehaviorSubject: BehaviorSubject<Icd10Model[]>;
	let icd9CMModelsBehaviorSubject: BehaviorSubject<Icd9CMModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let inpatientMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<InpatientMedicalExaminationRecordModel[]>;
	let insuranceBenefitPlanModelsBehaviorSubject: BehaviorSubject<InsuranceBenefitPlanModel[]>;
	let intraoperativeRecordsModelsBehaviorSubject: BehaviorSubject<IntraoperativeRecordsModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let invoiceItemComponentModelsBehaviorSubject: BehaviorSubject<InvoiceItemComponentModel[]>;
	let invoicePaymentInsuranceModelsBehaviorSubject: BehaviorSubject<InvoicePaymentInsuranceModel[]>;
	let invoicePaymentOtherModelsBehaviorSubject: BehaviorSubject<InvoicePaymentOtherModel[]>;
	let invoicePaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<InvoicePaymentSelfPayingModel[]>;
	let invoiceSummaryModelsBehaviorSubject: BehaviorSubject<InvoiceSummaryModel[]>;
	let mcuPackageItemModelsBehaviorSubject: BehaviorSubject<McuPackageItemModel[]>;
	let managementUserModelsBehaviorSubject: BehaviorSubject<ManagementUserModel[]>;
	let medicalCertificateDischargeResumeModelsBehaviorSubject: BehaviorSubject<MedicalCertificateDischargeResumeModel[]>;
	let medicalCertificateBirthModelsBehaviorSubject: BehaviorSubject<MedicalCertificateBirthModel[]>;
	let medicalCertificateHospitalizationModelsBehaviorSubject: BehaviorSubject<MedicalCertificateHospitalizationModel[]>;
	let medicalCertificateMedicalAttendanceModelsBehaviorSubject: BehaviorSubject<MedicalCertificateMedicalAttendanceModel[]>;
	let medicalCertificateMentalHealthModelsBehaviorSubject: BehaviorSubject<MedicalCertificateMentalHealthModel[]>;
	let medicalCertificatePhysicalHealthModelsBehaviorSubject: BehaviorSubject<MedicalCertificatePhysicalHealthModel[]>;
	let medicalCertificateRestrictedWorkModelsBehaviorSubject: BehaviorSubject<MedicalCertificateRestrictedWorkModel[]>;
	let medicalCertificateSickLeaveModelsBehaviorSubject: BehaviorSubject<MedicalCertificateSickLeaveModel[]>;
	let medicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<MedicalExaminationRecordModel[]>;
	let medicalExaminationRecordDischargeSummaryModelsBehaviorSubject: BehaviorSubject<MedicalExaminationRecordDischargeSummaryModel[]>;
	let medicalFeeModelsBehaviorSubject: BehaviorSubject<MedicalFeeModel[]>;
	let medicalRecordUserModelsBehaviorSubject: BehaviorSubject<MedicalRecordUserModel[]>;
	let medicalTranscriberUserModelsBehaviorSubject: BehaviorSubject<MedicalTranscriberUserModel[]>;
	let medicationAdministeredHistoryModelsBehaviorSubject: BehaviorSubject<MedicationAdministeredHistoryModel[]>;
	let medicationCompoundModelsBehaviorSubject: BehaviorSubject<MedicationCompoundModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let medicationItemModelsBehaviorSubject: BehaviorSubject<MedicationItemModel[]>;
	let newbornDetailModelsBehaviorSubject: BehaviorSubject<NewbornDetailModel[]>;
	let nurseUserModelsBehaviorSubject: BehaviorSubject<NurseUserModel[]>;
	let operatingTheaterMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel[]>;
	let pcareDokterModelsBehaviorSubject: BehaviorSubject<PcareDokterModel[]>;
	let patientConsentModelsBehaviorSubject: BehaviorSubject<PatientConsentModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let patientVisitPatientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientVisitPatientPaymentInsuranceModel[]>;
	let patientVisitPatientPaymentOthersModelsBehaviorSubject: BehaviorSubject<PatientVisitPatientPaymentOthersModel[]>;
	let patientVisitPaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<PatientVisitPaymentSelfPayingModel[]>;
	let patientVitalInformationModelsBehaviorSubject: BehaviorSubject<PatientVitalInformationModel[]>;
	let pharmacyUserModelsBehaviorSubject: BehaviorSubject<PharmacyUserModel[]>;
	let postOperativeDetailsModelsBehaviorSubject: BehaviorSubject<PostOperativeDetailsModel[]>;
	let preoperativeRecordsModelsBehaviorSubject: BehaviorSubject<PreoperativeRecordsModel[]>;
	let prescriptionCompoundModelsBehaviorSubject: BehaviorSubject<PrescriptionCompoundModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let prescriptionItemModelsBehaviorSubject: BehaviorSubject<PrescriptionItemModel[]>;
	let processWorkflowModelsBehaviorSubject: BehaviorSubject<ProcessWorkflowModel[]>;
	let purchasingUserModelsBehaviorSubject: BehaviorSubject<PurchasingUserModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let registrationUserModelsBehaviorSubject: BehaviorSubject<RegistrationUserModel[]>;
	let retailPharmacyInvoiceModelsBehaviorSubject: BehaviorSubject<RetailPharmacyInvoiceModel[]>;
	let roomFacilityModelsBehaviorSubject: BehaviorSubject<RoomFacilityModel[]>;
	let roomTransferModelsBehaviorSubject: BehaviorSubject<RoomTransferModel[]>;
	let sampleCollectionItemsModelsBehaviorSubject: BehaviorSubject<SampleCollectionItemsModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let systemAdminUserModelsBehaviorSubject: BehaviorSubject<SystemAdminUserModel[]>;
	let tariffDefinitionModelsBehaviorSubject: BehaviorSubject<TariffDefinitionModel[]>;
	let tariffFormulaModelsBehaviorSubject: BehaviorSubject<TariffFormulaModel[]>;
	let tariffSchemaModelsBehaviorSubject: BehaviorSubject<TariffSchemaModel[]>;
	let transferOrderStockDetailModelsBehaviorSubject: BehaviorSubject<TransferOrderStockDetailModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;
	let warehouseUserModelsBehaviorSubject: BehaviorSubject<WarehouseUserModel[]>;

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const administrationUserFactory: AdministrationUserDataFactory = new AdministrationUserDataFactory();
	const defaultAdministrationUserCount: number = 10;
	const defaultAdministrationUserEntities: AdministrationUserModel[] = administrationUserFactory.createAll(defaultAdministrationUserCount);

	const administratorFactory: AdministratorDataFactory = new AdministratorDataFactory();
	const defaultAdministratorCount: number = 10;
	const defaultAdministratorEntities: AdministratorModel[] = administratorFactory.createAll(defaultAdministratorCount);

	const amendmentDetailFactory: AmendmentDetailDataFactory = new AmendmentDetailDataFactory();
	const defaultAmendmentDetailCount: number = 10;
	const defaultAmendmentDetailEntities: AmendmentDetailModel[] = amendmentDetailFactory.createAll(defaultAmendmentDetailCount);

	const bpjsDiagnoseFactory: BpjsDiagnoseDataFactory = new BpjsDiagnoseDataFactory();
	const defaultBpjsDiagnoseCount: number = 10;
	const defaultBpjsDiagnoseEntities: BpjsDiagnoseModel[] = bpjsDiagnoseFactory.createAll(defaultBpjsDiagnoseCount);

	const bpjsDiagnosePRBFactory: BpjsDiagnosePRBDataFactory = new BpjsDiagnosePRBDataFactory();
	const defaultBpjsDiagnosePRBCount: number = 10;
	const defaultBpjsDiagnosePRBEntities: BpjsDiagnosePRBModel[] = bpjsDiagnosePRBFactory.createAll(defaultBpjsDiagnosePRBCount);

	const bpjsDoctorMappingFactory: BpjsDoctorMappingDataFactory = new BpjsDoctorMappingDataFactory();
	const defaultBpjsDoctorMappingCount: number = 10;
	const defaultBpjsDoctorMappingEntities: BpjsDoctorMappingModel[] = bpjsDoctorMappingFactory.createAll(defaultBpjsDoctorMappingCount);

	const bpjsPcareRegistrationsFactory: BpjsPcareRegistrationsDataFactory = new BpjsPcareRegistrationsDataFactory();
	const defaultBpjsPcareRegistrationsCount: number = 10;
	const defaultBpjsPcareRegistrationsEntities: BpjsPcareRegistrationsModel[] = bpjsPcareRegistrationsFactory.createAll(defaultBpjsPcareRegistrationsCount);

	const bpjsVisitDataFactory: BpjsVisitDataDataFactory = new BpjsVisitDataDataFactory();
	const defaultBpjsVisitDataCount: number = 10;
	const defaultBpjsVisitDataEntities: BpjsVisitDataModel[] = bpjsVisitDataFactory.createAll(defaultBpjsVisitDataCount);

	const bedFacilityFactory: BedFacilityDataFactory = new BedFacilityDataFactory();
	const defaultBedFacilityCount: number = 10;
	const defaultBedFacilityEntities: BedFacilityModel[] = bedFacilityFactory.createAll(defaultBedFacilityCount);

	const bedReserveFactory: BedReserveDataFactory = new BedReserveDataFactory();
	const defaultBedReserveCount: number = 10;
	const defaultBedReserveEntities: BedReserveModel[] = bedReserveFactory.createAll(defaultBedReserveCount);

	const bpjsPcarePendaftaranFactory: BpjsPcarePendaftaranDataFactory = new BpjsPcarePendaftaranDataFactory();
	const defaultBpjsPcarePendaftaranCount: number = 10;
	const defaultBpjsPcarePendaftaranEntities: BpjsPcarePendaftaranModel[] = bpjsPcarePendaftaranFactory.createAll(defaultBpjsPcarePendaftaranCount);

	const cashReceiptFactory: CashReceiptDataFactory = new CashReceiptDataFactory();
	const defaultCashReceiptCount: number = 10;
	const defaultCashReceiptEntities: CashReceiptModel[] = cashReceiptFactory.createAll(defaultCashReceiptCount);

	const cashierUserFactory: CashierUserDataFactory = new CashierUserDataFactory();
	const defaultCashierUserCount: number = 10;
	const defaultCashierUserEntities: CashierUserModel[] = cashierUserFactory.createAll(defaultCashierUserCount);

	const claimUserFactory: ClaimUserDataFactory = new ClaimUserDataFactory();
	const defaultClaimUserCount: number = 10;
	const defaultClaimUserEntities: ClaimUserModel[] = claimUserFactory.createAll(defaultClaimUserCount);

	const coTreatingDoctorFactory: CoTreatingDoctorDataFactory = new CoTreatingDoctorDataFactory();
	const defaultCoTreatingDoctorCount: number = 10;
	const defaultCoTreatingDoctorEntities: CoTreatingDoctorModel[] = coTreatingDoctorFactory.createAll(defaultCoTreatingDoctorCount);

	const dailyCareCPPTFactory: DailyCareCPPTDataFactory = new DailyCareCPPTDataFactory();
	const defaultDailyCareCPPTCount: number = 10;
	const defaultDailyCareCPPTEntities: DailyCareCPPTModel[] = dailyCareCPPTFactory.createAll(defaultDailyCareCPPTCount);

	const deliveryMedicalExaminationRecordFactory: DeliveryMedicalExaminationRecordDataFactory = new DeliveryMedicalExaminationRecordDataFactory();
	const defaultDeliveryMedicalExaminationRecordCount: number = 10;
	const defaultDeliveryMedicalExaminationRecordEntities: DeliveryMedicalExaminationRecordModel[] = deliveryMedicalExaminationRecordFactory.createAll(defaultDeliveryMedicalExaminationRecordCount);

	const deliveryProgressFactory: DeliveryProgressDataFactory = new DeliveryProgressDataFactory();
	const defaultDeliveryProgressCount: number = 10;
	const defaultDeliveryProgressEntities: DeliveryProgressModel[] = deliveryProgressFactory.createAll(defaultDeliveryProgressCount);

	const diagnosesAndProceduresFactory: DiagnosesAndProceduresDataFactory = new DiagnosesAndProceduresDataFactory();
	const defaultDiagnosesAndProceduresCount: number = 10;
	const defaultDiagnosesAndProceduresEntities: DiagnosesAndProceduresModel[] = diagnosesAndProceduresFactory.createAll(defaultDiagnosesAndProceduresCount);

	const diagnosisExaminationRecordFactory: DiagnosisExaminationRecordDataFactory = new DiagnosisExaminationRecordDataFactory();
	const defaultDiagnosisExaminationRecordCount: number = 10;
	const defaultDiagnosisExaminationRecordEntities: DiagnosisExaminationRecordModel[] = diagnosisExaminationRecordFactory.createAll(defaultDiagnosisExaminationRecordCount);

	const diagnosisNandaFactory: DiagnosisNandaDataFactory = new DiagnosisNandaDataFactory();
	const defaultDiagnosisNandaCount: number = 10;
	const defaultDiagnosisNandaEntities: DiagnosisNandaModel[] = diagnosisNandaFactory.createAll(defaultDiagnosisNandaCount);

	const diagnosticStaffExaminationSummaryFactory: DiagnosticStaffExaminationSummaryDataFactory = new DiagnosticStaffExaminationSummaryDataFactory();
	const defaultDiagnosticStaffExaminationSummaryCount: number = 10;
	const defaultDiagnosticStaffExaminationSummaryEntities: DiagnosticStaffExaminationSummaryModel[] = diagnosticStaffExaminationSummaryFactory.createAll(defaultDiagnosticStaffExaminationSummaryCount);

	const diagnosticSupportUserFactory: DiagnosticSupportUserDataFactory = new DiagnosticSupportUserDataFactory();
	const defaultDiagnosticSupportUserCount: number = 10;
	const defaultDiagnosticSupportUserEntities: DiagnosticSupportUserModel[] = diagnosticSupportUserFactory.createAll(defaultDiagnosticSupportUserCount);

	const doctorScheduleFactory: DoctorScheduleDataFactory = new DoctorScheduleDataFactory();
	const defaultDoctorScheduleCount: number = 10;
	const defaultDoctorScheduleEntities: DoctorScheduleModel[] = doctorScheduleFactory.createAll(defaultDoctorScheduleCount);

	const doctorUserFactory: DoctorUserDataFactory = new DoctorUserDataFactory();
	const defaultDoctorUserCount: number = 10;
	const defaultDoctorUserEntities: DoctorUserModel[] = doctorUserFactory.createAll(defaultDoctorUserCount);

	const facilityUserFactory: FacilityUserDataFactory = new FacilityUserDataFactory();
	const defaultFacilityUserCount: number = 10;
	const defaultFacilityUserEntities: FacilityUserModel[] = facilityUserFactory.createAll(defaultFacilityUserCount);

	const fluidBalanceDetailFactory: FluidBalanceDetailDataFactory = new FluidBalanceDetailDataFactory();
	const defaultFluidBalanceDetailCount: number = 10;
	const defaultFluidBalanceDetailEntities: FluidBalanceDetailModel[] = fluidBalanceDetailFactory.createAll(defaultFluidBalanceDetailCount);

	const hemodialysisMonitoringFactory: HemodialysisMonitoringDataFactory = new HemodialysisMonitoringDataFactory();
	const defaultHemodialysisMonitoringCount: number = 10;
	const defaultHemodialysisMonitoringEntities: HemodialysisMonitoringModel[] = hemodialysisMonitoringFactory.createAll(defaultHemodialysisMonitoringCount);

	const hospitalBranchInformationFactory: HospitalBranchInformationDataFactory = new HospitalBranchInformationDataFactory();
	const defaultHospitalBranchInformationCount: number = 10;
	const defaultHospitalBranchInformationEntities: HospitalBranchInformationModel[] = hospitalBranchInformationFactory.createAll(defaultHospitalBranchInformationCount);

	const icd10Factory: Icd10DataFactory = new Icd10DataFactory();
	const defaultIcd10Count: number = 10;
	const defaultIcd10Entities: Icd10Model[] = icd10Factory.createAll(defaultIcd10Count);

	const icd9CMFactory: Icd9CMDataFactory = new Icd9CMDataFactory();
	const defaultIcd9CMCount: number = 10;
	const defaultIcd9CMEntities: Icd9CMModel[] = icd9CMFactory.createAll(defaultIcd9CMCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const inpatientMedicalExaminationRecordFactory: InpatientMedicalExaminationRecordDataFactory = new InpatientMedicalExaminationRecordDataFactory();
	const defaultInpatientMedicalExaminationRecordCount: number = 10;
	const defaultInpatientMedicalExaminationRecordEntities: InpatientMedicalExaminationRecordModel[] = inpatientMedicalExaminationRecordFactory.createAll(defaultInpatientMedicalExaminationRecordCount);

	const insuranceBenefitPlanFactory: InsuranceBenefitPlanDataFactory = new InsuranceBenefitPlanDataFactory();
	const defaultInsuranceBenefitPlanCount: number = 10;
	const defaultInsuranceBenefitPlanEntities: InsuranceBenefitPlanModel[] = insuranceBenefitPlanFactory.createAll(defaultInsuranceBenefitPlanCount);

	const intraoperativeRecordsFactory: IntraoperativeRecordsDataFactory = new IntraoperativeRecordsDataFactory();
	const defaultIntraoperativeRecordsCount: number = 10;
	const defaultIntraoperativeRecordsEntities: IntraoperativeRecordsModel[] = intraoperativeRecordsFactory.createAll(defaultIntraoperativeRecordsCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const invoiceItemComponentFactory: InvoiceItemComponentDataFactory = new InvoiceItemComponentDataFactory();
	const defaultInvoiceItemComponentCount: number = 10;
	const defaultInvoiceItemComponentEntities: InvoiceItemComponentModel[] = invoiceItemComponentFactory.createAll(defaultInvoiceItemComponentCount);

	const invoicePaymentInsuranceFactory: InvoicePaymentInsuranceDataFactory = new InvoicePaymentInsuranceDataFactory();
	const defaultInvoicePaymentInsuranceCount: number = 10;
	const defaultInvoicePaymentInsuranceEntities: InvoicePaymentInsuranceModel[] = invoicePaymentInsuranceFactory.createAll(defaultInvoicePaymentInsuranceCount);

	const invoicePaymentOtherFactory: InvoicePaymentOtherDataFactory = new InvoicePaymentOtherDataFactory();
	const defaultInvoicePaymentOtherCount: number = 10;
	const defaultInvoicePaymentOtherEntities: InvoicePaymentOtherModel[] = invoicePaymentOtherFactory.createAll(defaultInvoicePaymentOtherCount);

	const invoicePaymentSelfPayingFactory: InvoicePaymentSelfPayingDataFactory = new InvoicePaymentSelfPayingDataFactory();
	const defaultInvoicePaymentSelfPayingCount: number = 10;
	const defaultInvoicePaymentSelfPayingEntities: InvoicePaymentSelfPayingModel[] = invoicePaymentSelfPayingFactory.createAll(defaultInvoicePaymentSelfPayingCount);

	const invoiceSummaryFactory: InvoiceSummaryDataFactory = new InvoiceSummaryDataFactory();
	const defaultInvoiceSummaryCount: number = 10;
	const defaultInvoiceSummaryEntities: InvoiceSummaryModel[] = invoiceSummaryFactory.createAll(defaultInvoiceSummaryCount);

	const mcuPackageItemFactory: McuPackageItemDataFactory = new McuPackageItemDataFactory();
	const defaultMcuPackageItemCount: number = 10;
	const defaultMcuPackageItemEntities: McuPackageItemModel[] = mcuPackageItemFactory.createAll(defaultMcuPackageItemCount);

	const managementUserFactory: ManagementUserDataFactory = new ManagementUserDataFactory();
	const defaultManagementUserCount: number = 10;
	const defaultManagementUserEntities: ManagementUserModel[] = managementUserFactory.createAll(defaultManagementUserCount);

	const medicalCertificateDischargeResumeFactory: MedicalCertificateDischargeResumeDataFactory = new MedicalCertificateDischargeResumeDataFactory();
	const defaultMedicalCertificateDischargeResumeCount: number = 10;
	const defaultMedicalCertificateDischargeResumeEntities: MedicalCertificateDischargeResumeModel[] = medicalCertificateDischargeResumeFactory.createAll(defaultMedicalCertificateDischargeResumeCount);

	const medicalCertificateBirthFactory: MedicalCertificateBirthDataFactory = new MedicalCertificateBirthDataFactory();
	const defaultMedicalCertificateBirthCount: number = 10;
	const defaultMedicalCertificateBirthEntities: MedicalCertificateBirthModel[] = medicalCertificateBirthFactory.createAll(defaultMedicalCertificateBirthCount);

	const medicalCertificateHospitalizationFactory: MedicalCertificateHospitalizationDataFactory = new MedicalCertificateHospitalizationDataFactory();
	const defaultMedicalCertificateHospitalizationCount: number = 10;
	const defaultMedicalCertificateHospitalizationEntities: MedicalCertificateHospitalizationModel[] = medicalCertificateHospitalizationFactory.createAll(defaultMedicalCertificateHospitalizationCount);

	const medicalCertificateMedicalAttendanceFactory: MedicalCertificateMedicalAttendanceDataFactory = new MedicalCertificateMedicalAttendanceDataFactory();
	const defaultMedicalCertificateMedicalAttendanceCount: number = 10;
	const defaultMedicalCertificateMedicalAttendanceEntities: MedicalCertificateMedicalAttendanceModel[] = medicalCertificateMedicalAttendanceFactory.createAll(defaultMedicalCertificateMedicalAttendanceCount);

	const medicalCertificateMentalHealthFactory: MedicalCertificateMentalHealthDataFactory = new MedicalCertificateMentalHealthDataFactory();
	const defaultMedicalCertificateMentalHealthCount: number = 10;
	const defaultMedicalCertificateMentalHealthEntities: MedicalCertificateMentalHealthModel[] = medicalCertificateMentalHealthFactory.createAll(defaultMedicalCertificateMentalHealthCount);

	const medicalCertificatePhysicalHealthFactory: MedicalCertificatePhysicalHealthDataFactory = new MedicalCertificatePhysicalHealthDataFactory();
	const defaultMedicalCertificatePhysicalHealthCount: number = 10;
	const defaultMedicalCertificatePhysicalHealthEntities: MedicalCertificatePhysicalHealthModel[] = medicalCertificatePhysicalHealthFactory.createAll(defaultMedicalCertificatePhysicalHealthCount);

	const medicalCertificateRestrictedWorkFactory: MedicalCertificateRestrictedWorkDataFactory = new MedicalCertificateRestrictedWorkDataFactory();
	const defaultMedicalCertificateRestrictedWorkCount: number = 10;
	const defaultMedicalCertificateRestrictedWorkEntities: MedicalCertificateRestrictedWorkModel[] = medicalCertificateRestrictedWorkFactory.createAll(defaultMedicalCertificateRestrictedWorkCount);

	const medicalCertificateSickLeaveFactory: MedicalCertificateSickLeaveDataFactory = new MedicalCertificateSickLeaveDataFactory();
	const defaultMedicalCertificateSickLeaveCount: number = 10;
	const defaultMedicalCertificateSickLeaveEntities: MedicalCertificateSickLeaveModel[] = medicalCertificateSickLeaveFactory.createAll(defaultMedicalCertificateSickLeaveCount);

	const medicalExaminationRecordFactory: MedicalExaminationRecordDataFactory = new MedicalExaminationRecordDataFactory();
	const defaultMedicalExaminationRecordCount: number = 10;
	const defaultMedicalExaminationRecordEntities: MedicalExaminationRecordModel[] = medicalExaminationRecordFactory.createAll(defaultMedicalExaminationRecordCount);

	const medicalExaminationRecordDischargeSummaryFactory: MedicalExaminationRecordDischargeSummaryDataFactory = new MedicalExaminationRecordDischargeSummaryDataFactory();
	const defaultMedicalExaminationRecordDischargeSummaryCount: number = 10;
	const defaultMedicalExaminationRecordDischargeSummaryEntities: MedicalExaminationRecordDischargeSummaryModel[] = medicalExaminationRecordDischargeSummaryFactory.createAll(defaultMedicalExaminationRecordDischargeSummaryCount);

	const medicalFeeFactory: MedicalFeeDataFactory = new MedicalFeeDataFactory();
	const defaultMedicalFeeCount: number = 10;
	const defaultMedicalFeeEntities: MedicalFeeModel[] = medicalFeeFactory.createAll(defaultMedicalFeeCount);

	const medicalRecordUserFactory: MedicalRecordUserDataFactory = new MedicalRecordUserDataFactory();
	const defaultMedicalRecordUserCount: number = 10;
	const defaultMedicalRecordUserEntities: MedicalRecordUserModel[] = medicalRecordUserFactory.createAll(defaultMedicalRecordUserCount);

	const medicalTranscriberUserFactory: MedicalTranscriberUserDataFactory = new MedicalTranscriberUserDataFactory();
	const defaultMedicalTranscriberUserCount: number = 10;
	const defaultMedicalTranscriberUserEntities: MedicalTranscriberUserModel[] = medicalTranscriberUserFactory.createAll(defaultMedicalTranscriberUserCount);

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

	const newbornDetailFactory: NewbornDetailDataFactory = new NewbornDetailDataFactory();
	const defaultNewbornDetailCount: number = 10;
	const defaultNewbornDetailEntities: NewbornDetailModel[] = newbornDetailFactory.createAll(defaultNewbornDetailCount);

	const nurseUserFactory: NurseUserDataFactory = new NurseUserDataFactory();
	const defaultNurseUserCount: number = 10;
	const defaultNurseUserEntities: NurseUserModel[] = nurseUserFactory.createAll(defaultNurseUserCount);

	const operatingTheaterMedicalExaminationRecordFactory: OperatingTheaterMedicalExaminationRecordDataFactory = new OperatingTheaterMedicalExaminationRecordDataFactory();
	const defaultOperatingTheaterMedicalExaminationRecordCount: number = 10;
	const defaultOperatingTheaterMedicalExaminationRecordEntities: OperatingTheaterMedicalExaminationRecordModel[] = operatingTheaterMedicalExaminationRecordFactory.createAll(defaultOperatingTheaterMedicalExaminationRecordCount);

	const pcareDokterFactory: PcareDokterDataFactory = new PcareDokterDataFactory();
	const defaultPcareDokterCount: number = 10;
	const defaultPcareDokterEntities: PcareDokterModel[] = pcareDokterFactory.createAll(defaultPcareDokterCount);

	const patientConsentFactory: PatientConsentDataFactory = new PatientConsentDataFactory();
	const defaultPatientConsentCount: number = 10;
	const defaultPatientConsentEntities: PatientConsentModel[] = patientConsentFactory.createAll(defaultPatientConsentCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

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

	const patientVitalInformationFactory: PatientVitalInformationDataFactory = new PatientVitalInformationDataFactory();
	const defaultPatientVitalInformationCount: number = 10;
	const defaultPatientVitalInformationEntities: PatientVitalInformationModel[] = patientVitalInformationFactory.createAll(defaultPatientVitalInformationCount);

	const pharmacyUserFactory: PharmacyUserDataFactory = new PharmacyUserDataFactory();
	const defaultPharmacyUserCount: number = 10;
	const defaultPharmacyUserEntities: PharmacyUserModel[] = pharmacyUserFactory.createAll(defaultPharmacyUserCount);

	const postOperativeDetailsFactory: PostOperativeDetailsDataFactory = new PostOperativeDetailsDataFactory();
	const defaultPostOperativeDetailsCount: number = 10;
	const defaultPostOperativeDetailsEntities: PostOperativeDetailsModel[] = postOperativeDetailsFactory.createAll(defaultPostOperativeDetailsCount);

	const preoperativeRecordsFactory: PreoperativeRecordsDataFactory = new PreoperativeRecordsDataFactory();
	const defaultPreoperativeRecordsCount: number = 10;
	const defaultPreoperativeRecordsEntities: PreoperativeRecordsModel[] = preoperativeRecordsFactory.createAll(defaultPreoperativeRecordsCount);

	const prescriptionCompoundFactory: PrescriptionCompoundDataFactory = new PrescriptionCompoundDataFactory();
	const defaultPrescriptionCompoundCount: number = 10;
	const defaultPrescriptionCompoundEntities: PrescriptionCompoundModel[] = prescriptionCompoundFactory.createAll(defaultPrescriptionCompoundCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const prescriptionItemFactory: PrescriptionItemDataFactory = new PrescriptionItemDataFactory();
	const defaultPrescriptionItemCount: number = 10;
	const defaultPrescriptionItemEntities: PrescriptionItemModel[] = prescriptionItemFactory.createAll(defaultPrescriptionItemCount);

	const processWorkflowFactory: ProcessWorkflowDataFactory = new ProcessWorkflowDataFactory();
	const defaultProcessWorkflowCount: number = 10;
	const defaultProcessWorkflowEntities: ProcessWorkflowModel[] = processWorkflowFactory.createAll(defaultProcessWorkflowCount);

	const purchasingUserFactory: PurchasingUserDataFactory = new PurchasingUserDataFactory();
	const defaultPurchasingUserCount: number = 10;
	const defaultPurchasingUserEntities: PurchasingUserModel[] = purchasingUserFactory.createAll(defaultPurchasingUserCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const registrationUserFactory: RegistrationUserDataFactory = new RegistrationUserDataFactory();
	const defaultRegistrationUserCount: number = 10;
	const defaultRegistrationUserEntities: RegistrationUserModel[] = registrationUserFactory.createAll(defaultRegistrationUserCount);

	const retailPharmacyInvoiceFactory: RetailPharmacyInvoiceDataFactory = new RetailPharmacyInvoiceDataFactory();
	const defaultRetailPharmacyInvoiceCount: number = 10;
	const defaultRetailPharmacyInvoiceEntities: RetailPharmacyInvoiceModel[] = retailPharmacyInvoiceFactory.createAll(defaultRetailPharmacyInvoiceCount);

	const roomFacilityFactory: RoomFacilityDataFactory = new RoomFacilityDataFactory();
	const defaultRoomFacilityCount: number = 10;
	const defaultRoomFacilityEntities: RoomFacilityModel[] = roomFacilityFactory.createAll(defaultRoomFacilityCount);

	const roomTransferFactory: RoomTransferDataFactory = new RoomTransferDataFactory();
	const defaultRoomTransferCount: number = 10;
	const defaultRoomTransferEntities: RoomTransferModel[] = roomTransferFactory.createAll(defaultRoomTransferCount);

	const sampleCollectionItemsFactory: SampleCollectionItemsDataFactory = new SampleCollectionItemsDataFactory();
	const defaultSampleCollectionItemsCount: number = 10;
	const defaultSampleCollectionItemsEntities: SampleCollectionItemsModel[] = sampleCollectionItemsFactory.createAll(defaultSampleCollectionItemsCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const systemAdminUserFactory: SystemAdminUserDataFactory = new SystemAdminUserDataFactory();
	const defaultSystemAdminUserCount: number = 10;
	const defaultSystemAdminUserEntities: SystemAdminUserModel[] = systemAdminUserFactory.createAll(defaultSystemAdminUserCount);

	const tariffDefinitionFactory: TariffDefinitionDataFactory = new TariffDefinitionDataFactory();
	const defaultTariffDefinitionCount: number = 10;
	const defaultTariffDefinitionEntities: TariffDefinitionModel[] = tariffDefinitionFactory.createAll(defaultTariffDefinitionCount);

	const tariffFormulaFactory: TariffFormulaDataFactory = new TariffFormulaDataFactory();
	const defaultTariffFormulaCount: number = 10;
	const defaultTariffFormulaEntities: TariffFormulaModel[] = tariffFormulaFactory.createAll(defaultTariffFormulaCount);

	const tariffSchemaFactory: TariffSchemaDataFactory = new TariffSchemaDataFactory();
	const defaultTariffSchemaCount: number = 10;
	const defaultTariffSchemaEntities: TariffSchemaModel[] = tariffSchemaFactory.createAll(defaultTariffSchemaCount);

	const transferOrderStockDetailFactory: TransferOrderStockDetailDataFactory = new TransferOrderStockDetailDataFactory();
	const defaultTransferOrderStockDetailCount: number = 10;
	const defaultTransferOrderStockDetailEntities: TransferOrderStockDetailModel[] = transferOrderStockDetailFactory.createAll(defaultTransferOrderStockDetailCount);

	const vaccinationOrderFactory: VaccinationOrderDataFactory = new VaccinationOrderDataFactory();
	const defaultVaccinationOrderCount: number = 10;
	const defaultVaccinationOrderEntities: VaccinationOrderModel[] = vaccinationOrderFactory.createAll(defaultVaccinationOrderCount);

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);

	const warehouseUserFactory: WarehouseUserDataFactory = new WarehouseUserDataFactory();
	const defaultWarehouseUserCount: number = 10;
	const defaultWarehouseUserEntities: WarehouseUserModel[] = warehouseUserFactory.createAll(defaultWarehouseUserCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let invoiceWithId: InvoiceModel = defaultInvoiceEntities[0];
	let invoiceModelWithIdBehaviorSubject: BehaviorSubject<InvoiceModel>;

	invoiceWithId.invoicePaymentOther = defaultInvoicePaymentOtherEntities[0];
	invoiceWithId.invoicePaymentOtherId = invoiceWithId.invoicePaymentOther.id;
	let invoicePaymentOtherWithIdBehaviorSubject: BehaviorSubject<InvoicePaymentOtherModel>;

	invoiceWithId.invoicePaymentSelfPaying = defaultInvoicePaymentSelfPayingEntities[0];
	invoiceWithId.invoicePaymentSelfPayingId = invoiceWithId.invoicePaymentSelfPaying.id;
	let invoicePaymentSelfPayingWithIdBehaviorSubject: BehaviorSubject<InvoicePaymentSelfPayingModel>;

	invoiceWithId.invoiceSummary = defaultInvoiceSummaryEntities[0];
	invoiceWithId.invoiceSummaryId = invoiceWithId.invoiceSummary.id;
	let invoiceSummaryWithIdBehaviorSubject: BehaviorSubject<InvoiceSummaryModel>;

	invoiceWithId.prescriptionHeader = defaultPrescriptionHeaderEntities[0];
	invoiceWithId.prescriptionHeaderId = invoiceWithId.prescriptionHeader.id;
	let prescriptionHeaderWithIdBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel>;

	invoiceWithId.medicationHeader = defaultMedicationHeaderEntities[0];
	invoiceWithId.medicationHeaderId = invoiceWithId.medicationHeader.id;
	let medicationHeaderWithIdBehaviorSubject: BehaviorSubject<MedicationHeaderModel>;

	invoiceWithId.icd10 = defaultDiagnosesAndProceduresEntities[0];
	invoiceWithId.icd10Id = invoiceWithId.icd10.id;
	let icd10WithIdBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel>;

	invoiceWithId.icd9CM = defaultDiagnosesAndProceduresEntities[0];
	invoiceWithId.icd9CMId = invoiceWithId.icd9CM.id;
	let icd9CMWithIdBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel>;

	invoiceWithId.bedFacility = defaultBedFacilityEntities[0];
	invoiceWithId.bedFacilityId = invoiceWithId.bedFacility.id;
	let bedFacilityWithIdBehaviorSubject: BehaviorSubject<BedFacilityModel>;

	invoiceWithId.patientVisit = defaultPatientVisitEntities[0];
	invoiceWithId.patientVisitId = invoiceWithId.patientVisit.id;
	let patientVisitWithIdBehaviorSubject: BehaviorSubject<PatientVisitModel>;

	invoiceWithId.tariffSchema = defaultTariffSchemaEntities[0];
	invoiceWithId.tariffSchemaId = invoiceWithId.tariffSchema.id;
	let tariffSchemaWithIdBehaviorSubject: BehaviorSubject<TariffSchemaModel>;

	invoiceWithId.verifiedBy = defaultStaffEntities[0];
	invoiceWithId.verifiedById = invoiceWithId.verifiedBy.id;
	let verifiedByWithIdBehaviorSubject: BehaviorSubject<StaffModel>;

	invoiceWithId.invoiceItems = defaultInvoiceItemEntities;
	invoiceWithId.invoiceItemsIds = invoiceWithId.invoiceItems.map(invoiceItems => invoiceItems.id);

	invoiceWithId.invoicePaymentInsurances = defaultInvoicePaymentInsuranceEntities;
	invoiceWithId.invoicePaymentInsurancesIds = invoiceWithId.invoicePaymentInsurances.map(invoicePaymentInsurances => invoicePaymentInsurances.id);


	const routerState: RouterState = {
		url: 'invoice-crud',
		urls: ['invoice-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: InvoiceModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		invoiceModelState = initialInvoiceModelState;
		store.setState({model: invoiceModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		invoiceCountBehaviorSubject = new BehaviorSubject(defaultInvoiceCount);

		// selectors for all references
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		administrationUserModelsBehaviorSubject = new BehaviorSubject(defaultAdministrationUserEntities);
		administratorModelsBehaviorSubject = new BehaviorSubject(defaultAdministratorEntities);
		amendmentDetailModelsBehaviorSubject = new BehaviorSubject(defaultAmendmentDetailEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsDiagnosePRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnosePRBEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsPcareRegistrationsModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareRegistrationsEntities);
		bpjsVisitDataModelsBehaviorSubject = new BehaviorSubject(defaultBpjsVisitDataEntities);
		bedFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBedFacilityEntities);
		bedReserveModelsBehaviorSubject = new BehaviorSubject(defaultBedReserveEntities);
		bpjsPcarePendaftaranModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcarePendaftaranEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		cashierUserModelsBehaviorSubject = new BehaviorSubject(defaultCashierUserEntities);
		claimUserModelsBehaviorSubject = new BehaviorSubject(defaultClaimUserEntities);
		coTreatingDoctorModelsBehaviorSubject = new BehaviorSubject(defaultCoTreatingDoctorEntities);
		dailyCareCPPTModelsBehaviorSubject = new BehaviorSubject(defaultDailyCareCPPTEntities);
		deliveryMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDeliveryMedicalExaminationRecordEntities);
		deliveryProgressModelsBehaviorSubject = new BehaviorSubject(defaultDeliveryProgressEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		diagnosisExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisExaminationRecordEntities);
		diagnosisNandaModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisNandaEntities);
		diagnosticStaffExaminationSummaryModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticStaffExaminationSummaryEntities);
		diagnosticSupportUserModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticSupportUserEntities);
		doctorScheduleModelsBehaviorSubject = new BehaviorSubject(defaultDoctorScheduleEntities);
		doctorUserModelsBehaviorSubject = new BehaviorSubject(defaultDoctorUserEntities);
		facilityUserModelsBehaviorSubject = new BehaviorSubject(defaultFacilityUserEntities);
		fluidBalanceDetailModelsBehaviorSubject = new BehaviorSubject(defaultFluidBalanceDetailEntities);
		hemodialysisMonitoringModelsBehaviorSubject = new BehaviorSubject(defaultHemodialysisMonitoringEntities);
		hospitalBranchInformationModelsBehaviorSubject = new BehaviorSubject(defaultHospitalBranchInformationEntities);
		icd10ModelsBehaviorSubject = new BehaviorSubject(defaultIcd10Entities);
		icd9CMModelsBehaviorSubject = new BehaviorSubject(defaultIcd9CMEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		inpatientMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultInpatientMedicalExaminationRecordEntities);
		insuranceBenefitPlanModelsBehaviorSubject = new BehaviorSubject(defaultInsuranceBenefitPlanEntities);
		intraoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultIntraoperativeRecordsEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		invoiceItemComponentModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemComponentEntities);
		invoicePaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentInsuranceEntities);
		invoicePaymentOtherModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentOtherEntities);
		invoicePaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentSelfPayingEntities);
		invoiceSummaryModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceSummaryEntities);
		mcuPackageItemModelsBehaviorSubject = new BehaviorSubject(defaultMcuPackageItemEntities);
		managementUserModelsBehaviorSubject = new BehaviorSubject(defaultManagementUserEntities);
		medicalCertificateDischargeResumeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateDischargeResumeEntities);
		medicalCertificateBirthModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateBirthEntities);
		medicalCertificateHospitalizationModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateHospitalizationEntities);
		medicalCertificateMedicalAttendanceModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateMedicalAttendanceEntities);
		medicalCertificateMentalHealthModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateMentalHealthEntities);
		medicalCertificatePhysicalHealthModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificatePhysicalHealthEntities);
		medicalCertificateRestrictedWorkModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateRestrictedWorkEntities);
		medicalCertificateSickLeaveModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateSickLeaveEntities);
		medicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultMedicalExaminationRecordEntities);
		medicalExaminationRecordDischargeSummaryModelsBehaviorSubject = new BehaviorSubject(defaultMedicalExaminationRecordDischargeSummaryEntities);
		medicalFeeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeEntities);
		medicalRecordUserModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordUserEntities);
		medicalTranscriberUserModelsBehaviorSubject = new BehaviorSubject(defaultMedicalTranscriberUserEntities);
		medicationAdministeredHistoryModelsBehaviorSubject = new BehaviorSubject(defaultMedicationAdministeredHistoryEntities);
		medicationCompoundModelsBehaviorSubject = new BehaviorSubject(defaultMedicationCompoundEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		medicationItemModelsBehaviorSubject = new BehaviorSubject(defaultMedicationItemEntities);
		newbornDetailModelsBehaviorSubject = new BehaviorSubject(defaultNewbornDetailEntities);
		nurseUserModelsBehaviorSubject = new BehaviorSubject(defaultNurseUserEntities);
		operatingTheaterMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultOperatingTheaterMedicalExaminationRecordEntities);
		pcareDokterModelsBehaviorSubject = new BehaviorSubject(defaultPcareDokterEntities);
		patientConsentModelsBehaviorSubject = new BehaviorSubject(defaultPatientConsentEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		patientVisitPatientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPatientPaymentInsuranceEntities);
		patientVisitPatientPaymentOthersModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPatientPaymentOthersEntities);
		patientVisitPaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitPaymentSelfPayingEntities);
		patientVitalInformationModelsBehaviorSubject = new BehaviorSubject(defaultPatientVitalInformationEntities);
		pharmacyUserModelsBehaviorSubject = new BehaviorSubject(defaultPharmacyUserEntities);
		postOperativeDetailsModelsBehaviorSubject = new BehaviorSubject(defaultPostOperativeDetailsEntities);
		preoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultPreoperativeRecordsEntities);
		prescriptionCompoundModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionCompoundEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		prescriptionItemModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionItemEntities);
		processWorkflowModelsBehaviorSubject = new BehaviorSubject(defaultProcessWorkflowEntities);
		purchasingUserModelsBehaviorSubject = new BehaviorSubject(defaultPurchasingUserEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		registrationUserModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationUserEntities);
		retailPharmacyInvoiceModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyInvoiceEntities);
		roomFacilityModelsBehaviorSubject = new BehaviorSubject(defaultRoomFacilityEntities);
		roomTransferModelsBehaviorSubject = new BehaviorSubject(defaultRoomTransferEntities);
		sampleCollectionItemsModelsBehaviorSubject = new BehaviorSubject(defaultSampleCollectionItemsEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		systemAdminUserModelsBehaviorSubject = new BehaviorSubject(defaultSystemAdminUserEntities);
		tariffDefinitionModelsBehaviorSubject = new BehaviorSubject(defaultTariffDefinitionEntities);
		tariffFormulaModelsBehaviorSubject = new BehaviorSubject(defaultTariffFormulaEntities);
		tariffSchemaModelsBehaviorSubject = new BehaviorSubject(defaultTariffSchemaEntities);
		transferOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderStockDetailEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);
		warehouseUserModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseUserEntities);

		// selectors for target entity and its related entity
		invoiceModelWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId);
		invoicePaymentOtherWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.invoicePaymentOther);
		invoicePaymentSelfPayingWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.invoicePaymentSelfPaying);
		invoiceSummaryWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.invoiceSummary);
		prescriptionHeaderWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.prescriptionHeader);
		medicationHeaderWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.medicationHeader);
		icd10WithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.icd10);
		icd9CMWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.icd9CM);
		bedFacilityWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.bedFacility);
		patientVisitWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.patientVisit);
		tariffSchemaWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.tariffSchema);
		verifiedByWithIdBehaviorSubject = new BehaviorSubject(invoiceWithId.verifiedBy);

		spyOn(store, 'select')
			.withArgs(getCountInvoiceModels).and.returnValue(invoiceCountBehaviorSubject)
			.withArgs(getInvoiceModelWithId, invoiceWithId.id).and.returnValue(invoiceModelWithIdBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getAdministrationUserCollectionModels, jasmine.any(String)).and.returnValue(administrationUserModelsBehaviorSubject)
			.withArgs(getAdministratorCollectionModels, jasmine.any(String)).and.returnValue(administratorModelsBehaviorSubject)
			.withArgs(getAmendmentDetailCollectionModels, jasmine.any(String)).and.returnValue(amendmentDetailModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsDiagnosePRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnosePRBModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareRegistrationsModelsBehaviorSubject)
			.withArgs(getBpjsVisitDataCollectionModels, jasmine.any(String)).and.returnValue(bpjsVisitDataModelsBehaviorSubject)
			.withArgs(getBedFacilityCollectionModels, jasmine.any(String)).and.returnValue(bedFacilityModelsBehaviorSubject)
			.withArgs(getBedReserveCollectionModels, jasmine.any(String)).and.returnValue(bedReserveModelsBehaviorSubject)
			.withArgs(getBpjsPcarePendaftaranCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcarePendaftaranModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getCashierUserCollectionModels, jasmine.any(String)).and.returnValue(cashierUserModelsBehaviorSubject)
			.withArgs(getClaimUserCollectionModels, jasmine.any(String)).and.returnValue(claimUserModelsBehaviorSubject)
			.withArgs(getCoTreatingDoctorCollectionModels, jasmine.any(String)).and.returnValue(coTreatingDoctorModelsBehaviorSubject)
			.withArgs(getDailyCareCPPTCollectionModels, jasmine.any(String)).and.returnValue(dailyCareCPPTModelsBehaviorSubject)
			.withArgs(getDeliveryMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(deliveryMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getDeliveryProgressCollectionModels, jasmine.any(String)).and.returnValue(deliveryProgressModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getDiagnosisExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(diagnosisExaminationRecordModelsBehaviorSubject)
			.withArgs(getDiagnosisNandaCollectionModels, jasmine.any(String)).and.returnValue(diagnosisNandaModelsBehaviorSubject)
			.withArgs(getDiagnosticStaffExaminationSummaryCollectionModels, jasmine.any(String)).and.returnValue(diagnosticStaffExaminationSummaryModelsBehaviorSubject)
			.withArgs(getDiagnosticSupportUserCollectionModels, jasmine.any(String)).and.returnValue(diagnosticSupportUserModelsBehaviorSubject)
			.withArgs(getDoctorScheduleCollectionModels, jasmine.any(String)).and.returnValue(doctorScheduleModelsBehaviorSubject)
			.withArgs(getDoctorUserCollectionModels, jasmine.any(String)).and.returnValue(doctorUserModelsBehaviorSubject)
			.withArgs(getFacilityUserCollectionModels, jasmine.any(String)).and.returnValue(facilityUserModelsBehaviorSubject)
			.withArgs(getFluidBalanceDetailCollectionModels, jasmine.any(String)).and.returnValue(fluidBalanceDetailModelsBehaviorSubject)
			.withArgs(getHemodialysisMonitoringCollectionModels, jasmine.any(String)).and.returnValue(hemodialysisMonitoringModelsBehaviorSubject)
			.withArgs(getHospitalBranchInformationCollectionModels, jasmine.any(String)).and.returnValue(hospitalBranchInformationModelsBehaviorSubject)
			.withArgs(getIcd10CollectionModels, jasmine.any(String)).and.returnValue(icd10ModelsBehaviorSubject)
			.withArgs(getIcd9CMCollectionModels, jasmine.any(String)).and.returnValue(icd9CMModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInpatientMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(inpatientMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getInsuranceBenefitPlanCollectionModels, jasmine.any(String)).and.returnValue(insuranceBenefitPlanModelsBehaviorSubject)
			.withArgs(getIntraoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(intraoperativeRecordsModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getInvoiceItemComponentCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemComponentModelsBehaviorSubject)
			.withArgs(getInvoicePaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentInsuranceModelsBehaviorSubject)
			.withArgs(getInvoicePaymentOtherCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentOtherModelsBehaviorSubject)
			.withArgs(getInvoicePaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getInvoiceSummaryCollectionModels, jasmine.any(String)).and.returnValue(invoiceSummaryModelsBehaviorSubject)
			.withArgs(getMcuPackageItemCollectionModels, jasmine.any(String)).and.returnValue(mcuPackageItemModelsBehaviorSubject)
			.withArgs(getManagementUserCollectionModels, jasmine.any(String)).and.returnValue(managementUserModelsBehaviorSubject)
			.withArgs(getMedicalCertificateDischargeResumeCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateDischargeResumeModelsBehaviorSubject)
			.withArgs(getMedicalCertificateBirthCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateBirthModelsBehaviorSubject)
			.withArgs(getMedicalCertificateHospitalizationCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateHospitalizationModelsBehaviorSubject)
			.withArgs(getMedicalCertificateMedicalAttendanceCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateMedicalAttendanceModelsBehaviorSubject)
			.withArgs(getMedicalCertificateMentalHealthCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateMentalHealthModelsBehaviorSubject)
			.withArgs(getMedicalCertificatePhysicalHealthCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificatePhysicalHealthModelsBehaviorSubject)
			.withArgs(getMedicalCertificateRestrictedWorkCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateRestrictedWorkModelsBehaviorSubject)
			.withArgs(getMedicalCertificateSickLeaveCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateSickLeaveModelsBehaviorSubject)
			.withArgs(getMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(medicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getMedicalExaminationRecordDischargeSummaryCollectionModels, jasmine.any(String)).and.returnValue(medicalExaminationRecordDischargeSummaryModelsBehaviorSubject)
			.withArgs(getMedicalFeeCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeModelsBehaviorSubject)
			.withArgs(getMedicalRecordUserCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordUserModelsBehaviorSubject)
			.withArgs(getMedicalTranscriberUserCollectionModels, jasmine.any(String)).and.returnValue(medicalTranscriberUserModelsBehaviorSubject)
			.withArgs(getMedicationAdministeredHistoryCollectionModels, jasmine.any(String)).and.returnValue(medicationAdministeredHistoryModelsBehaviorSubject)
			.withArgs(getMedicationCompoundCollectionModels, jasmine.any(String)).and.returnValue(medicationCompoundModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getMedicationItemCollectionModels, jasmine.any(String)).and.returnValue(medicationItemModelsBehaviorSubject)
			.withArgs(getNewbornDetailCollectionModels, jasmine.any(String)).and.returnValue(newbornDetailModelsBehaviorSubject)
			.withArgs(getNurseUserCollectionModels, jasmine.any(String)).and.returnValue(nurseUserModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(operatingTheaterMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getPcareDokterCollectionModels, jasmine.any(String)).and.returnValue(pcareDokterModelsBehaviorSubject)
			.withArgs(getPatientConsentCollectionModels, jasmine.any(String)).and.returnValue(patientConsentModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPatientVisitPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPatientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientVisitPatientPaymentOthersCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPatientPaymentOthersModelsBehaviorSubject)
			.withArgs(getPatientVisitPaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(patientVisitPaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getPatientVitalInformationCollectionModels, jasmine.any(String)).and.returnValue(patientVitalInformationModelsBehaviorSubject)
			.withArgs(getPharmacyUserCollectionModels, jasmine.any(String)).and.returnValue(pharmacyUserModelsBehaviorSubject)
			.withArgs(getPostOperativeDetailsCollectionModels, jasmine.any(String)).and.returnValue(postOperativeDetailsModelsBehaviorSubject)
			.withArgs(getPreoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(preoperativeRecordsModelsBehaviorSubject)
			.withArgs(getPrescriptionCompoundCollectionModels, jasmine.any(String)).and.returnValue(prescriptionCompoundModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getPrescriptionItemCollectionModels, jasmine.any(String)).and.returnValue(prescriptionItemModelsBehaviorSubject)
			.withArgs(getProcessWorkflowCollectionModels, jasmine.any(String)).and.returnValue(processWorkflowModelsBehaviorSubject)
			.withArgs(getPurchasingUserCollectionModels, jasmine.any(String)).and.returnValue(purchasingUserModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRegistrationUserCollectionModels, jasmine.any(String)).and.returnValue(registrationUserModelsBehaviorSubject)
			.withArgs(getRetailPharmacyInvoiceCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyInvoiceModelsBehaviorSubject)
			.withArgs(getRoomFacilityCollectionModels, jasmine.any(String)).and.returnValue(roomFacilityModelsBehaviorSubject)
			.withArgs(getRoomTransferCollectionModels, jasmine.any(String)).and.returnValue(roomTransferModelsBehaviorSubject)
			.withArgs(getSampleCollectionItemsCollectionModels, jasmine.any(String)).and.returnValue(sampleCollectionItemsModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getSystemAdminUserCollectionModels, jasmine.any(String)).and.returnValue(systemAdminUserModelsBehaviorSubject)
			.withArgs(getTariffDefinitionCollectionModels, jasmine.any(String)).and.returnValue(tariffDefinitionModelsBehaviorSubject)
			.withArgs(getTariffFormulaCollectionModels, jasmine.any(String)).and.returnValue(tariffFormulaModelsBehaviorSubject)
			.withArgs(getTariffSchemaCollectionModels, jasmine.any(String)).and.returnValue(tariffSchemaModelsBehaviorSubject)
			.withArgs(getTransferOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(transferOrderStockDetailModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getWarehouseUserCollectionModels, jasmine.any(String)).and.returnValue(warehouseUserModelsBehaviorSubject)
			.withArgs(getInvoicePaymentOtherModelWithId, invoiceWithId.invoicePaymentOtherId).and.returnValue(invoicePaymentOtherWithIdBehaviorSubject)
			.withArgs(getInvoicePaymentSelfPayingModelWithId, invoiceWithId.invoicePaymentSelfPayingId).and.returnValue(invoicePaymentSelfPayingWithIdBehaviorSubject)
			.withArgs(getInvoiceSummaryModelWithId, invoiceWithId.invoiceSummaryId).and.returnValue(invoiceSummaryWithIdBehaviorSubject)
			.withArgs(getPrescriptionHeaderModelWithId, invoiceWithId.prescriptionHeaderId).and.returnValue(prescriptionHeaderWithIdBehaviorSubject)
			.withArgs(getMedicationHeaderModelWithId, invoiceWithId.medicationHeaderId).and.returnValue(medicationHeaderWithIdBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresModelWithId, invoiceWithId.icd10Id).and.returnValue(icd10WithIdBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresModelWithId, invoiceWithId.icd9CMId).and.returnValue(icd9CMWithIdBehaviorSubject)
			.withArgs(getBedFacilityModelWithId, invoiceWithId.bedFacilityId).and.returnValue(bedFacilityWithIdBehaviorSubject)
			.withArgs(getPatientVisitModelWithId, invoiceWithId.patientVisitId).and.returnValue(patientVisitWithIdBehaviorSubject)
			.withArgs(getTariffSchemaModelWithId, invoiceWithId.tariffSchemaId).and.returnValue(tariffSchemaWithIdBehaviorSubject)
			.withArgs(getStaffModelWithId, invoiceWithId.verifiedById).and.returnValue(verifiedByWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				InvoiceCrudModule,
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

			fixture = TestBed.createComponent(InvoiceCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new InvoiceModel();
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
	it ('Renders the Invoice CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Invoice Payment Other relation.
	*
	* The button should only exist if invoicePaymentOtherMultiCrudActive is true
	*/
	it ('Renders Invoice Payment Other Add Entity button in create mode', fakeAsync(() => {
		const invoicePaymentOtherButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentOtherDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoicePaymentOtherButton).toEqual(component.invoicePaymentOtherMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Payment Other', fakeAsync(() => {
		const invoicePaymentOtherButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentOtherDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentOtherButton).toEqual(component.invoicePaymentOtherMultiCrudActive);

		if (component.invoicePaymentOtherMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoicePaymentOtherRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentOtherDisplayName + ' from Model')).length;

			invoicePaymentOtherButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoicePaymentOtherRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentOtherDisplayName + ' from Model')).length;

			expect(actualInvoicePaymentOtherRemoveButtonCount).toEqual(initialInvoicePaymentOtherRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Payment Other button', () => {
		const invoicePaymentOtherButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentOtherDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentOtherButton).toEqual(component.invoicePaymentOtherMultiCrudActive);

		if (component.invoicePaymentOtherMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoicePaymentOtherButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoicePaymentOtherRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentOtherDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoicePaymentOtherRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoicePaymentOtherRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentOtherDisplayName + ' from Model'));

			expect(actualInvoicePaymentOtherRemoveButtons.length).toEqual(initialInvoicePaymentOtherRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Invoice Payment Other button when one has already been added', () => {

		const invoicePaymentOtherButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentOtherDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentOtherButton).toEqual(component.invoicePaymentOtherMultiCrudActive);

		if (component.invoicePaymentOtherMultiCrudActive) {
			invoicePaymentOtherButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoicePaymentOtherButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentOtherDisplayName + ' to Model'));

			expect(updatedinvoicePaymentOtherButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Invoice Payment Other entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoicePaymentOtherMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoicePaymentOtherRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentOtherDisplayName + ' from Model')).length;

			expect(invoicePaymentOtherRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoice Payment Self Paying relation.
	*
	* The button should only exist if invoicePaymentSelfPayingMultiCrudActive is true
	*/
	it ('Renders Invoice Payment Self Paying Add Entity button in create mode', fakeAsync(() => {
		const invoicePaymentSelfPayingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentSelfPayingDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoicePaymentSelfPayingButton).toEqual(component.invoicePaymentSelfPayingMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Payment Self Paying', fakeAsync(() => {
		const invoicePaymentSelfPayingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentSelfPayingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentSelfPayingButton).toEqual(component.invoicePaymentSelfPayingMultiCrudActive);

		if (component.invoicePaymentSelfPayingMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoicePaymentSelfPayingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentSelfPayingDisplayName + ' from Model')).length;

			invoicePaymentSelfPayingButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoicePaymentSelfPayingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentSelfPayingDisplayName + ' from Model')).length;

			expect(actualInvoicePaymentSelfPayingRemoveButtonCount).toEqual(initialInvoicePaymentSelfPayingRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Payment Self Paying button', () => {
		const invoicePaymentSelfPayingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentSelfPayingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentSelfPayingButton).toEqual(component.invoicePaymentSelfPayingMultiCrudActive);

		if (component.invoicePaymentSelfPayingMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoicePaymentSelfPayingButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoicePaymentSelfPayingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentSelfPayingDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoicePaymentSelfPayingRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoicePaymentSelfPayingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentSelfPayingDisplayName + ' from Model'));

			expect(actualInvoicePaymentSelfPayingRemoveButtons.length).toEqual(initialInvoicePaymentSelfPayingRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Invoice Payment Self Paying button when one has already been added', () => {

		const invoicePaymentSelfPayingButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentSelfPayingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentSelfPayingButton).toEqual(component.invoicePaymentSelfPayingMultiCrudActive);

		if (component.invoicePaymentSelfPayingMultiCrudActive) {
			invoicePaymentSelfPayingButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoicePaymentSelfPayingButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentSelfPayingDisplayName + ' to Model'));

			expect(updatedinvoicePaymentSelfPayingButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Invoice Payment Self Paying entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoicePaymentSelfPayingMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoicePaymentSelfPayingRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentSelfPayingDisplayName + ' from Model')).length;

			expect(invoicePaymentSelfPayingRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoice Summary relation.
	*
	* The button should only exist if invoiceSummaryMultiCrudActive is true
	*/
	it ('Renders Invoice Summary Add Entity button in create mode', fakeAsync(() => {
		const invoiceSummaryButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoiceSummaryButton).toEqual(component.invoiceSummaryMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Summary', fakeAsync(() => {
		const invoiceSummaryButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceSummaryButton).toEqual(component.invoiceSummaryMultiCrudActive);

		if (component.invoiceSummaryMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoiceSummaryRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model')).length;

			invoiceSummaryButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceSummaryRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model')).length;

			expect(actualInvoiceSummaryRemoveButtonCount).toEqual(initialInvoiceSummaryRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Summary button', () => {
		const invoiceSummaryButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceSummaryButton).toEqual(component.invoiceSummaryMultiCrudActive);

		if (component.invoiceSummaryMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoiceSummaryButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoiceSummaryRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoiceSummaryRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceSummaryRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model'));

			expect(actualInvoiceSummaryRemoveButtons.length).toEqual(initialInvoiceSummaryRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Invoice Summary button when one has already been added', () => {

		const invoiceSummaryButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceSummaryButton).toEqual(component.invoiceSummaryMultiCrudActive);

		if (component.invoiceSummaryMultiCrudActive) {
			invoiceSummaryButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoiceSummaryButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

			expect(updatedinvoiceSummaryButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Invoice Summary entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoiceSummaryMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoiceSummaryRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model')).length;

			expect(invoiceSummaryRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Prescription Header relation.
	*
	* The button should only exist if prescriptionHeaderMultiCrudActive is true
	*/
	it ('Renders Prescription Header Add Entity button in create mode', fakeAsync(() => {
		const prescriptionHeaderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!prescriptionHeaderButton).toEqual(component.prescriptionHeaderMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Prescription Header', fakeAsync(() => {
		const prescriptionHeaderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionHeaderButton).toEqual(component.prescriptionHeaderMultiCrudActive);

		if (component.prescriptionHeaderMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPrescriptionHeaderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model')).length;

			prescriptionHeaderButton.nativeElement.click();
			fixture.detectChanges();

			const actualPrescriptionHeaderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model')).length;

			expect(actualPrescriptionHeaderRemoveButtonCount).toEqual(initialPrescriptionHeaderRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Prescription Header button', () => {
		const prescriptionHeaderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionHeaderButton).toEqual(component.prescriptionHeaderMultiCrudActive);

		if (component.prescriptionHeaderMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			prescriptionHeaderButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPrescriptionHeaderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPrescriptionHeaderRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPrescriptionHeaderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model'));

			expect(actualPrescriptionHeaderRemoveButtons.length).toEqual(initialPrescriptionHeaderRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Prescription Header button when one has already been added', () => {

		const prescriptionHeaderButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionHeaderButton).toEqual(component.prescriptionHeaderMultiCrudActive);

		if (component.prescriptionHeaderMultiCrudActive) {
			prescriptionHeaderButton.nativeElement.click();
			fixture.detectChanges();

			const updatedprescriptionHeaderButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

			expect(updatedprescriptionHeaderButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Prescription Header entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.prescriptionHeaderMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const prescriptionHeaderRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model')).length;

			expect(prescriptionHeaderRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medication Header relation.
	*
	* The button should only exist if medicationHeaderMultiCrudActive is true
	*/
	it ('Renders Medication Header Add Entity button in create mode', fakeAsync(() => {
		const medicationHeaderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeaderDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicationHeaderButton).toEqual(component.medicationHeaderMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medication Header', fakeAsync(() => {
		const medicationHeaderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeaderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationHeaderButton).toEqual(component.medicationHeaderMultiCrudActive);

		if (component.medicationHeaderMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicationHeaderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeaderDisplayName + ' from Model')).length;

			medicationHeaderButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicationHeaderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeaderDisplayName + ' from Model')).length;

			expect(actualMedicationHeaderRemoveButtonCount).toEqual(initialMedicationHeaderRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medication Header button', () => {
		const medicationHeaderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeaderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationHeaderButton).toEqual(component.medicationHeaderMultiCrudActive);

		if (component.medicationHeaderMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicationHeaderButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicationHeaderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeaderDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicationHeaderRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicationHeaderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeaderDisplayName + ' from Model'));

			expect(actualMedicationHeaderRemoveButtons.length).toEqual(initialMedicationHeaderRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medication Header button when one has already been added', () => {

		const medicationHeaderButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeaderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationHeaderButton).toEqual(component.medicationHeaderMultiCrudActive);

		if (component.medicationHeaderMultiCrudActive) {
			medicationHeaderButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicationHeaderButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationHeaderDisplayName + ' to Model'));

			expect(updatedmedicationHeaderButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medication Header entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicationHeaderMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicationHeaderRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationHeaderDisplayName + ' from Model')).length;

			expect(medicationHeaderRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the ICD 10 relation.
	*
	* The button should only exist if icd10MultiCrudActive is true
	*/
	it ('Renders ICD 10 Add Entity button in create mode', fakeAsync(() => {
		const icd10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd10DisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!icd10Button).toEqual(component.icd10MultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new ICD 10', fakeAsync(() => {
		const icd10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!icd10Button).toEqual(component.icd10MultiCrudActive);

		if (component.icd10MultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialIcd10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd10DisplayName + ' from Model')).length;

			icd10Button.nativeElement.click();
			fixture.detectChanges();

			const actualIcd10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd10DisplayName + ' from Model')).length;

			expect(actualIcd10RemoveButtonCount).toEqual(initialIcd10RemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove ICD 10 button', () => {
		const icd10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!icd10Button).toEqual(component.icd10MultiCrudActive);

		if (component.icd10MultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			icd10Button.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialIcd10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd10DisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialIcd10RemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualIcd10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd10DisplayName + ' from Model'));

			expect(actualIcd10RemoveButtons.length).toEqual(initialIcd10RemoveButtons.length - 1);
		}
	});

	it ('should disable the add ICD 10 button when one has already been added', () => {

		const icd10Button: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!icd10Button).toEqual(component.icd10MultiCrudActive);

		if (component.icd10MultiCrudActive) {
			icd10Button.nativeElement.click();
			fixture.detectChanges();

			const updatedicd10Button: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd10DisplayName + ' to Model'));

			expect(updatedicd10Button.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.icd10MultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const icd10RemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd10DisplayName + ' from Model')).length;

			expect(icd10RemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the ICD 9 CM relation.
	*
	* The button should only exist if icd9CMMultiCrudActive is true
	*/
	it ('Renders ICD 9 CM Add Entity button in create mode', fakeAsync(() => {
		const icd9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd9CMDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!icd9CMButton).toEqual(component.icd9CMMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new ICD 9 CM', fakeAsync(() => {
		const icd9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!icd9CMButton).toEqual(component.icd9CMMultiCrudActive);

		if (component.icd9CMMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialIcd9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd9CMDisplayName + ' from Model')).length;

			icd9CMButton.nativeElement.click();
			fixture.detectChanges();

			const actualIcd9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd9CMDisplayName + ' from Model')).length;

			expect(actualIcd9CMRemoveButtonCount).toEqual(initialIcd9CMRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove ICD 9 CM button', () => {
		const icd9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!icd9CMButton).toEqual(component.icd9CMMultiCrudActive);

		if (component.icd9CMMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			icd9CMButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialIcd9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd9CMDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialIcd9CMRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualIcd9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd9CMDisplayName + ' from Model'));

			expect(actualIcd9CMRemoveButtons.length).toEqual(initialIcd9CMRemoveButtons.length - 1);
		}
	});

	it ('should disable the add ICD 9 CM button when one has already been added', () => {

		const icd9CMButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!icd9CMButton).toEqual(component.icd9CMMultiCrudActive);

		if (component.icd9CMMultiCrudActive) {
			icd9CMButton.nativeElement.click();
			fixture.detectChanges();

			const updatedicd9CMButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.icd9CMDisplayName + ' to Model'));

			expect(updatedicd9CMButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.icd9CMMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const icd9CMRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.icd9CMDisplayName + ' from Model')).length;

			expect(icd9CMRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Bed Facility relation.
	*
	* The button should only exist if bedFacilityMultiCrudActive is true
	*/
	it ('Renders Bed Facility Add Entity button in create mode', fakeAsync(() => {
		const bedFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilityDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bedFacilityButton).toEqual(component.bedFacilityMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Bed Facility', fakeAsync(() => {
		const bedFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedFacilityButton).toEqual(component.bedFacilityMultiCrudActive);

		if (component.bedFacilityMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBedFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilityDisplayName + ' from Model')).length;

			bedFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const actualBedFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilityDisplayName + ' from Model')).length;

			expect(actualBedFacilityRemoveButtonCount).toEqual(initialBedFacilityRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Bed Facility button', () => {
		const bedFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedFacilityButton).toEqual(component.bedFacilityMultiCrudActive);

		if (component.bedFacilityMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bedFacilityButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBedFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilityDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBedFacilityRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBedFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilityDisplayName + ' from Model'));

			expect(actualBedFacilityRemoveButtons.length).toEqual(initialBedFacilityRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Bed Facility button when one has already been added', () => {

		const bedFacilityButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedFacilityButton).toEqual(component.bedFacilityMultiCrudActive);

		if (component.bedFacilityMultiCrudActive) {
			bedFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbedFacilityButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedFacilityDisplayName + ' to Model'));

			expect(updatedbedFacilityButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Bed Facility entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bedFacilityMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bedFacilityRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedFacilityDisplayName + ' from Model')).length;

			expect(bedFacilityRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Visit relation.
	*
	* The button should only exist if patientVisitMultiCrudActive is true
	*/
	it ('Renders Patient Visit Add Entity button in create mode', fakeAsync(() => {
		const patientVisitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientVisitButton).toEqual(component.patientVisitMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Visit', fakeAsync(() => {
		const patientVisitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVisitButton).toEqual(component.patientVisitMultiCrudActive);

		if (component.patientVisitMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientVisitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model')).length;

			patientVisitButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientVisitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model')).length;

			expect(actualPatientVisitRemoveButtonCount).toEqual(initialPatientVisitRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Visit button', () => {
		const patientVisitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVisitButton).toEqual(component.patientVisitMultiCrudActive);

		if (component.patientVisitMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientVisitButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientVisitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientVisitRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientVisitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model'));

			expect(actualPatientVisitRemoveButtons.length).toEqual(initialPatientVisitRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Visit button when one has already been added', () => {

		const patientVisitButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVisitButton).toEqual(component.patientVisitMultiCrudActive);

		if (component.patientVisitMultiCrudActive) {
			patientVisitButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientVisitButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVisitDisplayName + ' to Model'));

			expect(updatedpatientVisitButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Visit entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientVisitMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientVisitRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVisitDisplayName + ' from Model')).length;

			expect(patientVisitRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Tariff Schema relation.
	*
	* The button should only exist if tariffSchemaMultiCrudActive is true
	*/
	it ('Renders Tariff Schema Add Entity button in create mode', fakeAsync(() => {
		const tariffSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!tariffSchemaButton).toEqual(component.tariffSchemaMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Tariff Schema', fakeAsync(() => {
		const tariffSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffSchemaButton).toEqual(component.tariffSchemaMultiCrudActive);

		if (component.tariffSchemaMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialTariffSchemaRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model')).length;

			tariffSchemaButton.nativeElement.click();
			fixture.detectChanges();

			const actualTariffSchemaRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model')).length;

			expect(actualTariffSchemaRemoveButtonCount).toEqual(initialTariffSchemaRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Tariff Schema button', () => {
		const tariffSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffSchemaButton).toEqual(component.tariffSchemaMultiCrudActive);

		if (component.tariffSchemaMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			tariffSchemaButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialTariffSchemaRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialTariffSchemaRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualTariffSchemaRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model'));

			expect(actualTariffSchemaRemoveButtons.length).toEqual(initialTariffSchemaRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Tariff Schema button when one has already been added', () => {

		const tariffSchemaButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffSchemaButton).toEqual(component.tariffSchemaMultiCrudActive);

		if (component.tariffSchemaMultiCrudActive) {
			tariffSchemaButton.nativeElement.click();
			fixture.detectChanges();

			const updatedtariffSchemaButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

			expect(updatedtariffSchemaButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Tariff Schema entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.tariffSchemaMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const tariffSchemaRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model')).length;

			expect(tariffSchemaRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Verified By relation.
	*
	* The button should only exist if verifiedByMultiCrudActive is true
	*/
	it ('Renders Verified By Add Entity button in create mode', fakeAsync(() => {
		const verifiedByButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.verifiedByDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!verifiedByButton).toEqual(component.verifiedByMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Verified By', fakeAsync(() => {
		const verifiedByButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.verifiedByDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!verifiedByButton).toEqual(component.verifiedByMultiCrudActive);

		if (component.verifiedByMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialVerifiedByRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.verifiedByDisplayName + ' from Model')).length;

			verifiedByButton.nativeElement.click();
			fixture.detectChanges();

			const actualVerifiedByRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.verifiedByDisplayName + ' from Model')).length;

			expect(actualVerifiedByRemoveButtonCount).toEqual(initialVerifiedByRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Verified By button', () => {
		const verifiedByButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.verifiedByDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!verifiedByButton).toEqual(component.verifiedByMultiCrudActive);

		if (component.verifiedByMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			verifiedByButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialVerifiedByRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.verifiedByDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialVerifiedByRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualVerifiedByRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.verifiedByDisplayName + ' from Model'));

			expect(actualVerifiedByRemoveButtons.length).toEqual(initialVerifiedByRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Verified By button when one has already been added', () => {

		const verifiedByButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.verifiedByDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!verifiedByButton).toEqual(component.verifiedByMultiCrudActive);

		if (component.verifiedByMultiCrudActive) {
			verifiedByButton.nativeElement.click();
			fixture.detectChanges();

			const updatedverifiedByButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.verifiedByDisplayName + ' to Model'));

			expect(updatedverifiedByButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Verified By entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.verifiedByMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const verifiedByRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.verifiedByDisplayName + ' from Model')).length;

			expect(verifiedByRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoice Items relation.
	*
	* The button should only exist if invoiceItemsMultiCrudActive is true
	*/
	it ('Renders Invoice Items Add Entity button in create mode', fakeAsync(() => {
		const invoiceItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoiceItemsButton).toEqual(component.invoiceItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Items', fakeAsync(() => {
		const invoiceItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceItemsButton).toEqual(component.invoiceItemsMultiCrudActive);

		if (component.invoiceItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoiceItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model')).length;

			invoiceItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model')).length;

			expect(actualInvoiceItemsRemoveButtonCount).toEqual(initialInvoiceItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Items button', () => {
		const invoiceItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceItemsButton).toEqual(component.invoiceItemsMultiCrudActive);

		if (component.invoiceItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoiceItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoiceItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoiceItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model'));

			expect(actualInvoiceItemsRemoveButtons.length).toEqual(initialInvoiceItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoice Items button when one has already been added', () => {

		const invoiceItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceItemsButton).toEqual(component.invoiceItemsMultiCrudActive);

		if (component.invoiceItemsMultiCrudActive) {
			invoiceItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoiceItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

			expect(updatedinvoiceItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoice Items entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoiceItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoiceItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model')).length;

			expect(invoiceItemsRemoveButtonCount).toEqual(invoiceWithId.invoiceItems.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoice Payment Insurances relation.
	*
	* The button should only exist if invoicePaymentInsurancesMultiCrudActive is true
	*/
	it ('Renders Invoice Payment Insurances Add Entity button in create mode', fakeAsync(() => {
		const invoicePaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoicePaymentInsurancesButton).toEqual(component.invoicePaymentInsurancesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Payment Insurances', fakeAsync(() => {
		const invoicePaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentInsurancesButton).toEqual(component.invoicePaymentInsurancesMultiCrudActive);

		if (component.invoicePaymentInsurancesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoicePaymentInsurancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model')).length;

			invoicePaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoicePaymentInsurancesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model')).length;

			expect(actualInvoicePaymentInsurancesRemoveButtonCount).toEqual(initialInvoicePaymentInsurancesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Payment Insurances button', () => {
		const invoicePaymentInsurancesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentInsurancesButton).toEqual(component.invoicePaymentInsurancesMultiCrudActive);

		if (component.invoicePaymentInsurancesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoicePaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoicePaymentInsurancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoicePaymentInsurancesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoicePaymentInsurancesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model'));

			expect(actualInvoicePaymentInsurancesRemoveButtons.length).toEqual(initialInvoicePaymentInsurancesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoice Payment Insurances button when one has already been added', () => {

		const invoicePaymentInsurancesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicePaymentInsurancesButton).toEqual(component.invoicePaymentInsurancesMultiCrudActive);

		if (component.invoicePaymentInsurancesMultiCrudActive) {
			invoicePaymentInsurancesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoicePaymentInsurancesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicePaymentInsurancesDisplayName + ' to Model'));

			expect(updatedinvoicePaymentInsurancesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoice Payment Insurances entities from model when loading in edit mode', () => {
		component.targetModel = invoiceWithId;
		component.targetModelId = invoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoicePaymentInsurancesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoicePaymentInsurancesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicePaymentInsurancesDisplayName + ' from Model')).length;

			expect(invoicePaymentInsurancesRemoveButtonCount).toEqual(invoiceWithId.invoicePaymentInsurances.length);
		}
	});

});
