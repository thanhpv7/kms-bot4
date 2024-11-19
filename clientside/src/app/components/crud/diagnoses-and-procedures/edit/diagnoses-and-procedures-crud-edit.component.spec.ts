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
	getDiagnosesAndProceduresCollectionModels,
	getCountDiagnosesAndProceduresModels,
	getDiagnosesAndProceduresModelWithId
} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosesAndProceduresCrudModule } from '../diagnoses-and-procedures-crud.module';
import { DiagnosesAndProceduresCrudEditComponent } from './diagnoses-and-procedures-crud-edit.component';
import {
	DiagnosesAndProceduresModelState,
	initialState as initialDiagnosesAndProceduresModelState
} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.state';
import { DiagnosesAndProceduresDataFactory } from 'src/app/lib/utils/factories/diagnoses-and-procedures-data-factory';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { CrudTileMode } from '../diagnoses-and-procedures-crud.component';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getBpjsDiagnoseModelWithId } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { getBpjsDiagnoseCollectionModels } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { BpjsDiagnoseModel } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import { BpjsDiagnoseDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-data-factory';
import { getBpjsDiagnosePRBModelWithId } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.selector';
import { getBpjsDiagnosePRBCollectionModels } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.selector';
import { BpjsDiagnosePRBModel } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model';
import { BpjsDiagnosePRBDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-prb-data-factory';
import { getBpjsPRBModelWithId } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { getBpjsPRBCollectionModels } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { BpjsPRBModel } from 'src/app/models/bpjsPRB/bpjs_prb.model';
import { BpjsPRBDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-data-factory';
import { getBpjsPRBDetailModelWithId } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { getBpjsPRBDetailCollectionModels } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { BpjsPRBDetailModel } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model';
import { BpjsPRBDetailDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-detail-data-factory';
import { getBpjsPatientReferralModelWithId } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { getBpjsPatientReferralCollectionModels } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { BpjsPatientReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-patient-referral-data-factory';
import { getBpjsPcareRegistrationsModelWithId } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { getBpjsPcareRegistrationsCollectionModels } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { BpjsPcareRegistrationsModel } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import { BpjsPcareRegistrationsDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-registrations-data-factory';
import { getBpjsSEPModelWithId } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { getBpjsSEPCollectionModels } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { BpjsSEPModel } from 'src/app/models/bpjsSEP/bpjs_sep.model';
import { BpjsSEPDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-data-factory';
import { getBpjsSpecialReferralModelWithId } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.selector';
import { getBpjsSpecialReferralCollectionModels } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.selector';
import { BpjsSpecialReferralModel } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model';
import { BpjsSpecialReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-special-referral-data-factory';
import { getBedFacilityModelWithId } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { getBedFacilityCollectionModels } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { BedFacilityModel } from 'src/app/models/bedFacility/bed_facility.model';
import { BedFacilityDataFactory } from 'src/app/lib/utils/factories/bed-facility-data-factory';
import { getBedReserveModelWithId } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { getBedReserveCollectionModels } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { BedReserveModel } from 'src/app/models/bedReserve/bed_reserve.model';
import { BedReserveDataFactory } from 'src/app/lib/utils/factories/bed-reserve-data-factory';
import { getCoTreatingDoctorModelWithId } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import { getCoTreatingDoctorCollectionModels } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import { CoTreatingDoctorModel } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import { CoTreatingDoctorDataFactory } from 'src/app/lib/utils/factories/co-treating-doctor-data-factory';
import { getDailyCareCPPTModelWithId } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import { getDailyCareCPPTCollectionModels } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import { DailyCareCPPTModel } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import { DailyCareCPPTDataFactory } from 'src/app/lib/utils/factories/daily-care-cppt-data-factory';
import { getDiagnosisExaminationRecordModelWithId } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import { getDiagnosisExaminationRecordCollectionModels } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import { DiagnosisExaminationRecordModel } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model';
import { DiagnosisExaminationRecordDataFactory } from 'src/app/lib/utils/factories/diagnosis-examination-record-data-factory';
import { getDiagnosisNandaModelWithId } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { getDiagnosisNandaCollectionModels } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { DiagnosisNandaModel } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import { DiagnosisNandaDataFactory } from 'src/app/lib/utils/factories/diagnosis-nanda-data-factory';
import { getDiagnosticExaminationResultsModelWithId } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { getDiagnosticExaminationResultsCollectionModels } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { DiagnosticExaminationResultsModel } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model';
import { DiagnosticExaminationResultsDataFactory } from 'src/app/lib/utils/factories/diagnostic-examination-results-data-factory';
import { getDiagnosticStaffExaminationSummaryModelWithId } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.selector';
import { getDiagnosticStaffExaminationSummaryCollectionModels } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.selector';
import { DiagnosticStaffExaminationSummaryModel } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import { DiagnosticStaffExaminationSummaryDataFactory } from 'src/app/lib/utils/factories/diagnostic-staff-examination-summary-data-factory';
import { getExaminationItemModelWithId } from 'src/app/models/examinationItem/examination_item.model.selector';
import { getExaminationItemCollectionModels } from 'src/app/models/examinationItem/examination_item.model.selector';
import { ExaminationItemModel } from 'src/app/models/examinationItem/examination_item.model';
import { ExaminationItemDataFactory } from 'src/app/lib/utils/factories/examination-item-data-factory';
import { getFluidBalanceDetailModelWithId } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { getFluidBalanceDetailCollectionModels } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { FluidBalanceDetailModel } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import { FluidBalanceDetailDataFactory } from 'src/app/lib/utils/factories/fluid-balance-detail-data-factory';
import { getHealthFacilityModelWithId } from 'src/app/models/healthFacility/health_facility.model.selector';
import { getHealthFacilityCollectionModels } from 'src/app/models/healthFacility/health_facility.model.selector';
import { HealthFacilityModel } from 'src/app/models/healthFacility/health_facility.model';
import { HealthFacilityDataFactory } from 'src/app/lib/utils/factories/health-facility-data-factory';
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
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
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
import { getMedicationHeaderModelWithId } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { getMedicationHeaderCollectionModels } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { MedicationHeaderModel } from 'src/app/models/medicationHeader/medication_header.model';
import { MedicationHeaderDataFactory } from 'src/app/lib/utils/factories/medication-header-data-factory';
import { getOperatingTheaterMedicalExaminationRecordModelWithId } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { getOperatingTheaterMedicalExaminationRecordCollectionModels } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { OperatingTheaterMedicalExaminationRecordModel } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import { OperatingTheaterMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/operating-theater-medical-examination-record-data-factory';
import { getPcareExaminationModelWithId } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { getPcareExaminationCollectionModels } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { PcareExaminationModel } from 'src/app/models/pcareExamination/pcare_examination.model';
import { PcareExaminationDataFactory } from 'src/app/lib/utils/factories/pcare-examination-data-factory';
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
import { getPatientVitalInformationModelWithId } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { getPatientVitalInformationCollectionModels } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { PatientVitalInformationModel } from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import { PatientVitalInformationDataFactory } from 'src/app/lib/utils/factories/patient-vital-information-data-factory';
import { getPostOperativeDetailsModelWithId } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { getPostOperativeDetailsCollectionModels } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { PostOperativeDetailsModel } from 'src/app/models/postOperativeDetails/post_operative_details.model';
import { PostOperativeDetailsDataFactory } from 'src/app/lib/utils/factories/post-operative-details-data-factory';
import { getPreoperativeRecordsModelWithId } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { getPreoperativeRecordsCollectionModels } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { PreoperativeRecordsModel } from 'src/app/models/preoperativeRecords/preoperative_records.model';
import { PreoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/preoperative-records-data-factory';
import { getPrescriptionHeaderModelWithId } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderDataFactory } from 'src/app/lib/utils/factories/prescription-header-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getRoomFacilityModelWithId } from 'src/app/models/roomFacility/room_facility.model.selector';
import { getRoomFacilityCollectionModels } from 'src/app/models/roomFacility/room_facility.model.selector';
import { RoomFacilityModel } from 'src/app/models/roomFacility/room_facility.model';
import { RoomFacilityDataFactory } from 'src/app/lib/utils/factories/room-facility-data-factory';
import { getSepModelWithId } from 'src/app/models/sep/sep.model.selector';
import { getSepCollectionModels } from 'src/app/models/sep/sep.model.selector';
import { SepModel } from 'src/app/models/sep/sep.model';
import { SepDataFactory } from 'src/app/lib/utils/factories/sep-data-factory';
import { getSampleCollectionInformationModelWithId } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.selector';
import { getSampleCollectionInformationCollectionModels } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.selector';
import { SampleCollectionInformationModel } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model';
import { SampleCollectionInformationDataFactory } from 'src/app/lib/utils/factories/sample-collection-information-data-factory';
import { getServiceModelWithId } from 'src/app/models/service/service.model.selector';
import { getServiceCollectionModels } from 'src/app/models/service/service.model.selector';
import { ServiceModel } from 'src/app/models/service/service.model';
import { ServiceDataFactory } from 'src/app/lib/utils/factories/service-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { getTariffSchemaModelWithId } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { getTariffSchemaCollectionModels } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { TariffSchemaModel } from 'src/app/models/tariffSchema/tariff_schema.model';
import { TariffSchemaDataFactory } from 'src/app/lib/utils/factories/tariff-schema-data-factory';
import { getVaccinationOrderModelWithId } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { getVaccinationOrderCollectionModels } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { VaccinationOrderModel } from 'src/app/models/vaccinationOrder/vaccination_order.model';
import { VaccinationOrderDataFactory } from 'src/app/lib/utils/factories/vaccination-order-data-factory';

describe('Diagnoses and Procedures CRUD Edit component tests', () => {
	let fixture: ComponentFixture<DiagnosesAndProceduresCrudEditComponent>
	let component: DiagnosesAndProceduresCrudEditComponent;

	let diagnosesAndProceduresModelState: DiagnosesAndProceduresModelState;

	let store: MockStore<{ model: DiagnosesAndProceduresModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let diagnosesAndProceduresCountBehaviorSubject: BehaviorSubject<number>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsDiagnosePRBModelsBehaviorSubject: BehaviorSubject<BpjsDiagnosePRBModel[]>;
	let bpjsPRBModelsBehaviorSubject: BehaviorSubject<BpjsPRBModel[]>;
	let bpjsPRBDetailModelsBehaviorSubject: BehaviorSubject<BpjsPRBDetailModel[]>;
	let bpjsPatientReferralModelsBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel[]>;
	let bpjsPcareRegistrationsModelsBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel[]>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bpjsSpecialReferralModelsBehaviorSubject: BehaviorSubject<BpjsSpecialReferralModel[]>;
	let bedFacilityModelsBehaviorSubject: BehaviorSubject<BedFacilityModel[]>;
	let bedReserveModelsBehaviorSubject: BehaviorSubject<BedReserveModel[]>;
	let coTreatingDoctorModelsBehaviorSubject: BehaviorSubject<CoTreatingDoctorModel[]>;
	let dailyCareCPPTModelsBehaviorSubject: BehaviorSubject<DailyCareCPPTModel[]>;
	let diagnosisExaminationRecordModelsBehaviorSubject: BehaviorSubject<DiagnosisExaminationRecordModel[]>;
	let diagnosisNandaModelsBehaviorSubject: BehaviorSubject<DiagnosisNandaModel[]>;
	let diagnosticExaminationResultsModelsBehaviorSubject: BehaviorSubject<DiagnosticExaminationResultsModel[]>;
	let diagnosticStaffExaminationSummaryModelsBehaviorSubject: BehaviorSubject<DiagnosticStaffExaminationSummaryModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let fluidBalanceDetailModelsBehaviorSubject: BehaviorSubject<FluidBalanceDetailModel[]>;
	let healthFacilityModelsBehaviorSubject: BehaviorSubject<HealthFacilityModel[]>;
	let icd10ModelsBehaviorSubject: BehaviorSubject<Icd10Model[]>;
	let icd9CMModelsBehaviorSubject: BehaviorSubject<Icd9CMModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let invoicePaymentInsuranceModelsBehaviorSubject: BehaviorSubject<InvoicePaymentInsuranceModel[]>;
	let invoicePaymentOtherModelsBehaviorSubject: BehaviorSubject<InvoicePaymentOtherModel[]>;
	let invoicePaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<InvoicePaymentSelfPayingModel[]>;
	let invoiceSummaryModelsBehaviorSubject: BehaviorSubject<InvoiceSummaryModel[]>;
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
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let operatingTheaterMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel[]>;
	let pcareExaminationModelsBehaviorSubject: BehaviorSubject<PcareExaminationModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let patientVitalInformationModelsBehaviorSubject: BehaviorSubject<PatientVitalInformationModel[]>;
	let postOperativeDetailsModelsBehaviorSubject: BehaviorSubject<PostOperativeDetailsModel[]>;
	let preoperativeRecordsModelsBehaviorSubject: BehaviorSubject<PreoperativeRecordsModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let roomFacilityModelsBehaviorSubject: BehaviorSubject<RoomFacilityModel[]>;
	let sepModelsBehaviorSubject: BehaviorSubject<SepModel[]>;
	let sampleCollectionInformationModelsBehaviorSubject: BehaviorSubject<SampleCollectionInformationModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let tariffSchemaModelsBehaviorSubject: BehaviorSubject<TariffSchemaModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;

	const diagnosesAndProceduresFactory: DiagnosesAndProceduresDataFactory = new DiagnosesAndProceduresDataFactory();
	const defaultDiagnosesAndProceduresCount: number = 10;
	const defaultDiagnosesAndProceduresEntities: DiagnosesAndProceduresModel[] = diagnosesAndProceduresFactory.createAll(defaultDiagnosesAndProceduresCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsDiagnoseFactory: BpjsDiagnoseDataFactory = new BpjsDiagnoseDataFactory();
	const defaultBpjsDiagnoseCount: number = 10;
	const defaultBpjsDiagnoseEntities: BpjsDiagnoseModel[] = bpjsDiagnoseFactory.createAll(defaultBpjsDiagnoseCount);

	const bpjsDiagnosePRBFactory: BpjsDiagnosePRBDataFactory = new BpjsDiagnosePRBDataFactory();
	const defaultBpjsDiagnosePRBCount: number = 10;
	const defaultBpjsDiagnosePRBEntities: BpjsDiagnosePRBModel[] = bpjsDiagnosePRBFactory.createAll(defaultBpjsDiagnosePRBCount);

	const bpjsPRBFactory: BpjsPRBDataFactory = new BpjsPRBDataFactory();
	const defaultBpjsPRBCount: number = 10;
	const defaultBpjsPRBEntities: BpjsPRBModel[] = bpjsPRBFactory.createAll(defaultBpjsPRBCount);

	const bpjsPRBDetailFactory: BpjsPRBDetailDataFactory = new BpjsPRBDetailDataFactory();
	const defaultBpjsPRBDetailCount: number = 10;
	const defaultBpjsPRBDetailEntities: BpjsPRBDetailModel[] = bpjsPRBDetailFactory.createAll(defaultBpjsPRBDetailCount);

	const bpjsPatientReferralFactory: BpjsPatientReferralDataFactory = new BpjsPatientReferralDataFactory();
	const defaultBpjsPatientReferralCount: number = 10;
	const defaultBpjsPatientReferralEntities: BpjsPatientReferralModel[] = bpjsPatientReferralFactory.createAll(defaultBpjsPatientReferralCount);

	const bpjsPcareRegistrationsFactory: BpjsPcareRegistrationsDataFactory = new BpjsPcareRegistrationsDataFactory();
	const defaultBpjsPcareRegistrationsCount: number = 10;
	const defaultBpjsPcareRegistrationsEntities: BpjsPcareRegistrationsModel[] = bpjsPcareRegistrationsFactory.createAll(defaultBpjsPcareRegistrationsCount);

	const bpjsSEPFactory: BpjsSEPDataFactory = new BpjsSEPDataFactory();
	const defaultBpjsSEPCount: number = 10;
	const defaultBpjsSEPEntities: BpjsSEPModel[] = bpjsSEPFactory.createAll(defaultBpjsSEPCount);

	const bpjsSpecialReferralFactory: BpjsSpecialReferralDataFactory = new BpjsSpecialReferralDataFactory();
	const defaultBpjsSpecialReferralCount: number = 10;
	const defaultBpjsSpecialReferralEntities: BpjsSpecialReferralModel[] = bpjsSpecialReferralFactory.createAll(defaultBpjsSpecialReferralCount);

	const bedFacilityFactory: BedFacilityDataFactory = new BedFacilityDataFactory();
	const defaultBedFacilityCount: number = 10;
	const defaultBedFacilityEntities: BedFacilityModel[] = bedFacilityFactory.createAll(defaultBedFacilityCount);

	const bedReserveFactory: BedReserveDataFactory = new BedReserveDataFactory();
	const defaultBedReserveCount: number = 10;
	const defaultBedReserveEntities: BedReserveModel[] = bedReserveFactory.createAll(defaultBedReserveCount);

	const coTreatingDoctorFactory: CoTreatingDoctorDataFactory = new CoTreatingDoctorDataFactory();
	const defaultCoTreatingDoctorCount: number = 10;
	const defaultCoTreatingDoctorEntities: CoTreatingDoctorModel[] = coTreatingDoctorFactory.createAll(defaultCoTreatingDoctorCount);

	const dailyCareCPPTFactory: DailyCareCPPTDataFactory = new DailyCareCPPTDataFactory();
	const defaultDailyCareCPPTCount: number = 10;
	const defaultDailyCareCPPTEntities: DailyCareCPPTModel[] = dailyCareCPPTFactory.createAll(defaultDailyCareCPPTCount);

	const diagnosisExaminationRecordFactory: DiagnosisExaminationRecordDataFactory = new DiagnosisExaminationRecordDataFactory();
	const defaultDiagnosisExaminationRecordCount: number = 10;
	const defaultDiagnosisExaminationRecordEntities: DiagnosisExaminationRecordModel[] = diagnosisExaminationRecordFactory.createAll(defaultDiagnosisExaminationRecordCount);

	const diagnosisNandaFactory: DiagnosisNandaDataFactory = new DiagnosisNandaDataFactory();
	const defaultDiagnosisNandaCount: number = 10;
	const defaultDiagnosisNandaEntities: DiagnosisNandaModel[] = diagnosisNandaFactory.createAll(defaultDiagnosisNandaCount);

	const diagnosticExaminationResultsFactory: DiagnosticExaminationResultsDataFactory = new DiagnosticExaminationResultsDataFactory();
	const defaultDiagnosticExaminationResultsCount: number = 10;
	const defaultDiagnosticExaminationResultsEntities: DiagnosticExaminationResultsModel[] = diagnosticExaminationResultsFactory.createAll(defaultDiagnosticExaminationResultsCount);

	const diagnosticStaffExaminationSummaryFactory: DiagnosticStaffExaminationSummaryDataFactory = new DiagnosticStaffExaminationSummaryDataFactory();
	const defaultDiagnosticStaffExaminationSummaryCount: number = 10;
	const defaultDiagnosticStaffExaminationSummaryEntities: DiagnosticStaffExaminationSummaryModel[] = diagnosticStaffExaminationSummaryFactory.createAll(defaultDiagnosticStaffExaminationSummaryCount);

	const examinationItemFactory: ExaminationItemDataFactory = new ExaminationItemDataFactory();
	const defaultExaminationItemCount: number = 10;
	const defaultExaminationItemEntities: ExaminationItemModel[] = examinationItemFactory.createAll(defaultExaminationItemCount);

	const fluidBalanceDetailFactory: FluidBalanceDetailDataFactory = new FluidBalanceDetailDataFactory();
	const defaultFluidBalanceDetailCount: number = 10;
	const defaultFluidBalanceDetailEntities: FluidBalanceDetailModel[] = fluidBalanceDetailFactory.createAll(defaultFluidBalanceDetailCount);

	const healthFacilityFactory: HealthFacilityDataFactory = new HealthFacilityDataFactory();
	const defaultHealthFacilityCount: number = 10;
	const defaultHealthFacilityEntities: HealthFacilityModel[] = healthFacilityFactory.createAll(defaultHealthFacilityCount);

	const icd10Factory: Icd10DataFactory = new Icd10DataFactory();
	const defaultIcd10Count: number = 10;
	const defaultIcd10Entities: Icd10Model[] = icd10Factory.createAll(defaultIcd10Count);

	const icd9CMFactory: Icd9CMDataFactory = new Icd9CMDataFactory();
	const defaultIcd9CMCount: number = 10;
	const defaultIcd9CMEntities: Icd9CMModel[] = icd9CMFactory.createAll(defaultIcd9CMCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

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

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const operatingTheaterMedicalExaminationRecordFactory: OperatingTheaterMedicalExaminationRecordDataFactory = new OperatingTheaterMedicalExaminationRecordDataFactory();
	const defaultOperatingTheaterMedicalExaminationRecordCount: number = 10;
	const defaultOperatingTheaterMedicalExaminationRecordEntities: OperatingTheaterMedicalExaminationRecordModel[] = operatingTheaterMedicalExaminationRecordFactory.createAll(defaultOperatingTheaterMedicalExaminationRecordCount);

	const pcareExaminationFactory: PcareExaminationDataFactory = new PcareExaminationDataFactory();
	const defaultPcareExaminationCount: number = 10;
	const defaultPcareExaminationEntities: PcareExaminationModel[] = pcareExaminationFactory.createAll(defaultPcareExaminationCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

	const patientVitalInformationFactory: PatientVitalInformationDataFactory = new PatientVitalInformationDataFactory();
	const defaultPatientVitalInformationCount: number = 10;
	const defaultPatientVitalInformationEntities: PatientVitalInformationModel[] = patientVitalInformationFactory.createAll(defaultPatientVitalInformationCount);

	const postOperativeDetailsFactory: PostOperativeDetailsDataFactory = new PostOperativeDetailsDataFactory();
	const defaultPostOperativeDetailsCount: number = 10;
	const defaultPostOperativeDetailsEntities: PostOperativeDetailsModel[] = postOperativeDetailsFactory.createAll(defaultPostOperativeDetailsCount);

	const preoperativeRecordsFactory: PreoperativeRecordsDataFactory = new PreoperativeRecordsDataFactory();
	const defaultPreoperativeRecordsCount: number = 10;
	const defaultPreoperativeRecordsEntities: PreoperativeRecordsModel[] = preoperativeRecordsFactory.createAll(defaultPreoperativeRecordsCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const roomFacilityFactory: RoomFacilityDataFactory = new RoomFacilityDataFactory();
	const defaultRoomFacilityCount: number = 10;
	const defaultRoomFacilityEntities: RoomFacilityModel[] = roomFacilityFactory.createAll(defaultRoomFacilityCount);

	const sepFactory: SepDataFactory = new SepDataFactory();
	const defaultSepCount: number = 10;
	const defaultSepEntities: SepModel[] = sepFactory.createAll(defaultSepCount);

	const sampleCollectionInformationFactory: SampleCollectionInformationDataFactory = new SampleCollectionInformationDataFactory();
	const defaultSampleCollectionInformationCount: number = 10;
	const defaultSampleCollectionInformationEntities: SampleCollectionInformationModel[] = sampleCollectionInformationFactory.createAll(defaultSampleCollectionInformationCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const tariffSchemaFactory: TariffSchemaDataFactory = new TariffSchemaDataFactory();
	const defaultTariffSchemaCount: number = 10;
	const defaultTariffSchemaEntities: TariffSchemaModel[] = tariffSchemaFactory.createAll(defaultTariffSchemaCount);

	const vaccinationOrderFactory: VaccinationOrderDataFactory = new VaccinationOrderDataFactory();
	const defaultVaccinationOrderCount: number = 10;
	const defaultVaccinationOrderEntities: VaccinationOrderModel[] = vaccinationOrderFactory.createAll(defaultVaccinationOrderCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let diagnosesAndProceduresWithId: DiagnosesAndProceduresModel = defaultDiagnosesAndProceduresEntities[0];
	let diagnosesAndProceduresModelWithIdBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel>;

	diagnosesAndProceduresWithId.masterICD10 = defaultIcd10Entities[0];
	diagnosesAndProceduresWithId.masterICD10Id = diagnosesAndProceduresWithId.masterICD10.id;
	let masterICD10WithIdBehaviorSubject: BehaviorSubject<Icd10Model>;

	diagnosesAndProceduresWithId.masterICD9CM = defaultIcd9CMEntities[0];
	diagnosesAndProceduresWithId.masterICD9CMId = diagnosesAndProceduresWithId.masterICD9CM.id;
	let masterICD9CMWithIdBehaviorSubject: BehaviorSubject<Icd9CMModel>;

	diagnosesAndProceduresWithId.bpjsDiagnose = defaultBpjsDiagnoseEntities[0];
	diagnosesAndProceduresWithId.bpjsDiagnoseId = diagnosesAndProceduresWithId.bpjsDiagnose.id;
	let bpjsDiagnoseWithIdBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel>;

	diagnosesAndProceduresWithId.bpjsDiagnosePRB = defaultBpjsDiagnosePRBEntities[0];
	diagnosesAndProceduresWithId.bpjsDiagnosePRBId = diagnosesAndProceduresWithId.bpjsDiagnosePRB.id;
	let bpjsDiagnosePRBWithIdBehaviorSubject: BehaviorSubject<BpjsDiagnosePRBModel>;

	diagnosesAndProceduresWithId.admissionICD10 = defaultRegistrationEntities;
	diagnosesAndProceduresWithId.admissionICD10Ids = diagnosesAndProceduresWithId.admissionICD10.map(admissionICD10 => admissionICD10.id);

	diagnosesAndProceduresWithId.admissionICD9CM = defaultRegistrationEntities;
	diagnosesAndProceduresWithId.admissionICD9CMIds = diagnosesAndProceduresWithId.admissionICD9CM.map(admissionICD9CM => admissionICD9CM.id);

	diagnosesAndProceduresWithId.cpptICD10 = defaultDailyCareCPPTEntities;
	diagnosesAndProceduresWithId.cpptICD10Ids = diagnosesAndProceduresWithId.cpptICD10.map(cpptICD10 => cpptICD10.id);

	diagnosesAndProceduresWithId.cpptICD9CM = defaultDailyCareCPPTEntities;
	diagnosesAndProceduresWithId.cpptICD9CMIds = diagnosesAndProceduresWithId.cpptICD9CM.map(cpptICD9CM => cpptICD9CM.id);

	diagnosesAndProceduresWithId.dischargeICD10 = defaultMedicalCertificateDischargeResumeEntities;
	diagnosesAndProceduresWithId.dischargeICD10Ids = diagnosesAndProceduresWithId.dischargeICD10.map(dischargeICD10 => dischargeICD10.id);

	diagnosesAndProceduresWithId.dischargeICD9CM = defaultMedicalCertificateDischargeResumeEntities;
	diagnosesAndProceduresWithId.dischargeICD9CMIds = diagnosesAndProceduresWithId.dischargeICD9CM.map(dischargeICD9CM => dischargeICD9CM.id);

	diagnosesAndProceduresWithId.icd10 = defaultDiagnosisExaminationRecordEntities;
	diagnosesAndProceduresWithId.icd10Ids = diagnosesAndProceduresWithId.icd10.map(icd10 => icd10.id);

	diagnosesAndProceduresWithId.icd9CM = defaultDiagnosisExaminationRecordEntities;
	diagnosesAndProceduresWithId.icd9CMIds = diagnosesAndProceduresWithId.icd9CM.map(icd9CM => icd9CM.id);

	diagnosesAndProceduresWithId.invoicesICD10 = defaultInvoiceEntities;
	diagnosesAndProceduresWithId.invoicesICD10Ids = diagnosesAndProceduresWithId.invoicesICD10.map(invoicesICD10 => invoicesICD10.id);

	diagnosesAndProceduresWithId.invoicesICD9CM = defaultInvoiceEntities;
	diagnosesAndProceduresWithId.invoicesICD9CMIds = diagnosesAndProceduresWithId.invoicesICD9CM.map(invoicesICD9CM => invoicesICD9CM.id);

	diagnosesAndProceduresWithId.postOperativeICD10 = defaultPostOperativeDetailsEntities;
	diagnosesAndProceduresWithId.postOperativeICD10Ids = diagnosesAndProceduresWithId.postOperativeICD10.map(postOperativeICD10 => postOperativeICD10.id);

	diagnosesAndProceduresWithId.postOperativeICD9CM = defaultPostOperativeDetailsEntities;
	diagnosesAndProceduresWithId.postOperativeICD9CMIds = diagnosesAndProceduresWithId.postOperativeICD9CM.map(postOperativeICD9CM => postOperativeICD9CM.id);

	diagnosesAndProceduresWithId.preSurgeryICD10 = defaultPreoperativeRecordsEntities;
	diagnosesAndProceduresWithId.preSurgeryICD10Ids = diagnosesAndProceduresWithId.preSurgeryICD10.map(preSurgeryICD10 => preSurgeryICD10.id);

	diagnosesAndProceduresWithId.preSurgeryICD9CM = defaultPreoperativeRecordsEntities;
	diagnosesAndProceduresWithId.preSurgeryICD9CMIds = diagnosesAndProceduresWithId.preSurgeryICD9CM.map(preSurgeryICD9CM => preSurgeryICD9CM.id);

	diagnosesAndProceduresWithId.diagnosisNandas = defaultDiagnosisNandaEntities;
	diagnosesAndProceduresWithId.diagnosisNandasIds = diagnosesAndProceduresWithId.diagnosisNandas.map(diagnosisNandas => diagnosisNandas.id);


	const routerState: RouterState = {
		url: 'diagnoses-and-procedures-crud',
		urls: ['diagnoses-and-procedures-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: DiagnosesAndProceduresModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		diagnosesAndProceduresModelState = initialDiagnosesAndProceduresModelState;
		store.setState({model: diagnosesAndProceduresModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		diagnosesAndProceduresCountBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresCount);

		// selectors for all references
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsDiagnosePRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnosePRBEntities);
		bpjsPRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBEntities);
		bpjsPRBDetailModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBDetailEntities);
		bpjsPatientReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralEntities);
		bpjsPcareRegistrationsModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareRegistrationsEntities);
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bpjsSpecialReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSpecialReferralEntities);
		bedFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBedFacilityEntities);
		bedReserveModelsBehaviorSubject = new BehaviorSubject(defaultBedReserveEntities);
		coTreatingDoctorModelsBehaviorSubject = new BehaviorSubject(defaultCoTreatingDoctorEntities);
		dailyCareCPPTModelsBehaviorSubject = new BehaviorSubject(defaultDailyCareCPPTEntities);
		diagnosisExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisExaminationRecordEntities);
		diagnosisNandaModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisNandaEntities);
		diagnosticExaminationResultsModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticExaminationResultsEntities);
		diagnosticStaffExaminationSummaryModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticStaffExaminationSummaryEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		fluidBalanceDetailModelsBehaviorSubject = new BehaviorSubject(defaultFluidBalanceDetailEntities);
		healthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultHealthFacilityEntities);
		icd10ModelsBehaviorSubject = new BehaviorSubject(defaultIcd10Entities);
		icd9CMModelsBehaviorSubject = new BehaviorSubject(defaultIcd9CMEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		invoicePaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentInsuranceEntities);
		invoicePaymentOtherModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentOtherEntities);
		invoicePaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentSelfPayingEntities);
		invoiceSummaryModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceSummaryEntities);
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
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		operatingTheaterMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultOperatingTheaterMedicalExaminationRecordEntities);
		pcareExaminationModelsBehaviorSubject = new BehaviorSubject(defaultPcareExaminationEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		patientVitalInformationModelsBehaviorSubject = new BehaviorSubject(defaultPatientVitalInformationEntities);
		postOperativeDetailsModelsBehaviorSubject = new BehaviorSubject(defaultPostOperativeDetailsEntities);
		preoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultPreoperativeRecordsEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		roomFacilityModelsBehaviorSubject = new BehaviorSubject(defaultRoomFacilityEntities);
		sepModelsBehaviorSubject = new BehaviorSubject(defaultSepEntities);
		sampleCollectionInformationModelsBehaviorSubject = new BehaviorSubject(defaultSampleCollectionInformationEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		tariffSchemaModelsBehaviorSubject = new BehaviorSubject(defaultTariffSchemaEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);

		// selectors for target entity and its related entity
		diagnosesAndProceduresModelWithIdBehaviorSubject = new BehaviorSubject(diagnosesAndProceduresWithId);
		masterICD10WithIdBehaviorSubject = new BehaviorSubject(diagnosesAndProceduresWithId.masterICD10);
		masterICD9CMWithIdBehaviorSubject = new BehaviorSubject(diagnosesAndProceduresWithId.masterICD9CM);
		bpjsDiagnoseWithIdBehaviorSubject = new BehaviorSubject(diagnosesAndProceduresWithId.bpjsDiagnose);
		bpjsDiagnosePRBWithIdBehaviorSubject = new BehaviorSubject(diagnosesAndProceduresWithId.bpjsDiagnosePRB);

		spyOn(store, 'select')
			.withArgs(getCountDiagnosesAndProceduresModels).and.returnValue(diagnosesAndProceduresCountBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresModelWithId, diagnosesAndProceduresWithId.id).and.returnValue(diagnosesAndProceduresModelWithIdBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsDiagnosePRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnosePRBModelsBehaviorSubject)
			.withArgs(getBpjsPRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBModelsBehaviorSubject)
			.withArgs(getBpjsPRBDetailCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBDetailModelsBehaviorSubject)
			.withArgs(getBpjsPatientReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsPatientReferralModelsBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareRegistrationsModelsBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBpjsSpecialReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsSpecialReferralModelsBehaviorSubject)
			.withArgs(getBedFacilityCollectionModels, jasmine.any(String)).and.returnValue(bedFacilityModelsBehaviorSubject)
			.withArgs(getBedReserveCollectionModels, jasmine.any(String)).and.returnValue(bedReserveModelsBehaviorSubject)
			.withArgs(getCoTreatingDoctorCollectionModels, jasmine.any(String)).and.returnValue(coTreatingDoctorModelsBehaviorSubject)
			.withArgs(getDailyCareCPPTCollectionModels, jasmine.any(String)).and.returnValue(dailyCareCPPTModelsBehaviorSubject)
			.withArgs(getDiagnosisExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(diagnosisExaminationRecordModelsBehaviorSubject)
			.withArgs(getDiagnosisNandaCollectionModels, jasmine.any(String)).and.returnValue(diagnosisNandaModelsBehaviorSubject)
			.withArgs(getDiagnosticExaminationResultsCollectionModels, jasmine.any(String)).and.returnValue(diagnosticExaminationResultsModelsBehaviorSubject)
			.withArgs(getDiagnosticStaffExaminationSummaryCollectionModels, jasmine.any(String)).and.returnValue(diagnosticStaffExaminationSummaryModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getFluidBalanceDetailCollectionModels, jasmine.any(String)).and.returnValue(fluidBalanceDetailModelsBehaviorSubject)
			.withArgs(getHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(healthFacilityModelsBehaviorSubject)
			.withArgs(getIcd10CollectionModels, jasmine.any(String)).and.returnValue(icd10ModelsBehaviorSubject)
			.withArgs(getIcd9CMCollectionModels, jasmine.any(String)).and.returnValue(icd9CMModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getInvoicePaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentInsuranceModelsBehaviorSubject)
			.withArgs(getInvoicePaymentOtherCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentOtherModelsBehaviorSubject)
			.withArgs(getInvoicePaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getInvoiceSummaryCollectionModels, jasmine.any(String)).and.returnValue(invoiceSummaryModelsBehaviorSubject)
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
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(operatingTheaterMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getPcareExaminationCollectionModels, jasmine.any(String)).and.returnValue(pcareExaminationModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPatientVitalInformationCollectionModels, jasmine.any(String)).and.returnValue(patientVitalInformationModelsBehaviorSubject)
			.withArgs(getPostOperativeDetailsCollectionModels, jasmine.any(String)).and.returnValue(postOperativeDetailsModelsBehaviorSubject)
			.withArgs(getPreoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(preoperativeRecordsModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRoomFacilityCollectionModels, jasmine.any(String)).and.returnValue(roomFacilityModelsBehaviorSubject)
			.withArgs(getSepCollectionModels, jasmine.any(String)).and.returnValue(sepModelsBehaviorSubject)
			.withArgs(getSampleCollectionInformationCollectionModels, jasmine.any(String)).and.returnValue(sampleCollectionInformationModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getTariffSchemaCollectionModels, jasmine.any(String)).and.returnValue(tariffSchemaModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getIcd10ModelWithId, diagnosesAndProceduresWithId.masterICD10Id).and.returnValue(masterICD10WithIdBehaviorSubject)
			.withArgs(getIcd9CMModelWithId, diagnosesAndProceduresWithId.masterICD9CMId).and.returnValue(masterICD9CMWithIdBehaviorSubject)
			.withArgs(getBpjsDiagnoseModelWithId, diagnosesAndProceduresWithId.bpjsDiagnoseId).and.returnValue(bpjsDiagnoseWithIdBehaviorSubject)
			.withArgs(getBpjsDiagnosePRBModelWithId, diagnosesAndProceduresWithId.bpjsDiagnosePRBId).and.returnValue(bpjsDiagnosePRBWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				DiagnosesAndProceduresCrudModule,
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

			fixture = TestBed.createComponent(DiagnosesAndProceduresCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new DiagnosesAndProceduresModel();
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
	it ('Renders the Diagnoses and Procedures CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Master ICD 10 relation.
	*
	* The button should only exist if masterICD10MultiCrudActive is true
	*/
	it ('Renders Master ICD 10 Add Entity button in create mode', fakeAsync(() => {
		const masterICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD10DisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!masterICD10Button).toEqual(component.masterICD10MultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Master ICD 10', fakeAsync(() => {
		const masterICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!masterICD10Button).toEqual(component.masterICD10MultiCrudActive);

		if (component.masterICD10MultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMasterICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD10DisplayName + ' from Model')).length;

			masterICD10Button.nativeElement.click();
			fixture.detectChanges();

			const actualMasterICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD10DisplayName + ' from Model')).length;

			expect(actualMasterICD10RemoveButtonCount).toEqual(initialMasterICD10RemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Master ICD 10 button', () => {
		const masterICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!masterICD10Button).toEqual(component.masterICD10MultiCrudActive);

		if (component.masterICD10MultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			masterICD10Button.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMasterICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD10DisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMasterICD10RemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMasterICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD10DisplayName + ' from Model'));

			expect(actualMasterICD10RemoveButtons.length).toEqual(initialMasterICD10RemoveButtons.length - 1);
		}
	});

	it ('should disable the add Master ICD 10 button when one has already been added', () => {

		const masterICD10Button: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!masterICD10Button).toEqual(component.masterICD10MultiCrudActive);

		if (component.masterICD10MultiCrudActive) {
			masterICD10Button.nativeElement.click();
			fixture.detectChanges();

			const updatedmasterICD10Button: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD10DisplayName + ' to Model'));

			expect(updatedmasterICD10Button.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Master ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.masterICD10MultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const masterICD10RemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD10DisplayName + ' from Model')).length;

			expect(masterICD10RemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Master ICD 9 CM relation.
	*
	* The button should only exist if masterICD9CMMultiCrudActive is true
	*/
	it ('Renders Master ICD 9 CM Add Entity button in create mode', fakeAsync(() => {
		const masterICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD9CMDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!masterICD9CMButton).toEqual(component.masterICD9CMMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Master ICD 9 CM', fakeAsync(() => {
		const masterICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!masterICD9CMButton).toEqual(component.masterICD9CMMultiCrudActive);

		if (component.masterICD9CMMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMasterICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD9CMDisplayName + ' from Model')).length;

			masterICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const actualMasterICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD9CMDisplayName + ' from Model')).length;

			expect(actualMasterICD9CMRemoveButtonCount).toEqual(initialMasterICD9CMRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Master ICD 9 CM button', () => {
		const masterICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!masterICD9CMButton).toEqual(component.masterICD9CMMultiCrudActive);

		if (component.masterICD9CMMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			masterICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMasterICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD9CMDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMasterICD9CMRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMasterICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD9CMDisplayName + ' from Model'));

			expect(actualMasterICD9CMRemoveButtons.length).toEqual(initialMasterICD9CMRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Master ICD 9 CM button when one has already been added', () => {

		const masterICD9CMButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!masterICD9CMButton).toEqual(component.masterICD9CMMultiCrudActive);

		if (component.masterICD9CMMultiCrudActive) {
			masterICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmasterICD9CMButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.masterICD9CMDisplayName + ' to Model'));

			expect(updatedmasterICD9CMButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Master ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.masterICD9CMMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const masterICD9CMRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.masterICD9CMDisplayName + ' from Model')).length;

			expect(masterICD9CMRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Diagnose relation.
	*
	* The button should only exist if bpjsDiagnoseMultiCrudActive is true
	*/
	it ('Renders BPJS Diagnose Add Entity button in create mode', fakeAsync(() => {
		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Diagnose', fakeAsync(() => {
		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);

		if (component.bpjsDiagnoseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model')).length;

			bpjsDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model')).length;

			expect(actualBpjsDiagnoseRemoveButtonCount).toEqual(initialBpjsDiagnoseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Diagnose button', () => {
		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);

		if (component.bpjsDiagnoseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDiagnoseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model'));

			expect(actualBpjsDiagnoseRemoveButtons.length).toEqual(initialBpjsDiagnoseRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Diagnose button when one has already been added', () => {

		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);

		if (component.bpjsDiagnoseMultiCrudActive) {
			bpjsDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDiagnoseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

			expect(updatedbpjsDiagnoseButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Diagnose entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDiagnoseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDiagnoseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model')).length;

			expect(bpjsDiagnoseRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Diagnose PRB relation.
	*
	* The button should only exist if bpjsDiagnosePRBMultiCrudActive is true
	*/
	it ('Renders BPJS Diagnose PRB Add Entity button in create mode', fakeAsync(() => {
		const bpjsDiagnosePRBButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDiagnosePRBButton).toEqual(component.bpjsDiagnosePRBMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Diagnose PRB', fakeAsync(() => {
		const bpjsDiagnosePRBButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnosePRBButton).toEqual(component.bpjsDiagnosePRBMultiCrudActive);

		if (component.bpjsDiagnosePRBMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDiagnosePRBRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model')).length;

			bpjsDiagnosePRBButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnosePRBRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model')).length;

			expect(actualBpjsDiagnosePRBRemoveButtonCount).toEqual(initialBpjsDiagnosePRBRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Diagnose PRB button', () => {
		const bpjsDiagnosePRBButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnosePRBButton).toEqual(component.bpjsDiagnosePRBMultiCrudActive);

		if (component.bpjsDiagnosePRBMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDiagnosePRBButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDiagnosePRBRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDiagnosePRBRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnosePRBRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model'));

			expect(actualBpjsDiagnosePRBRemoveButtons.length).toEqual(initialBpjsDiagnosePRBRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Diagnose PRB button when one has already been added', () => {

		const bpjsDiagnosePRBButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnosePRBButton).toEqual(component.bpjsDiagnosePRBMultiCrudActive);

		if (component.bpjsDiagnosePRBMultiCrudActive) {
			bpjsDiagnosePRBButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDiagnosePRBButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

			expect(updatedbpjsDiagnosePRBButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Diagnose PRB entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDiagnosePRBMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDiagnosePRBRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model')).length;

			expect(bpjsDiagnosePRBRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Admission ICD 10 relation.
	*
	* The button should only exist if admissionICD10MultiCrudActive is true
	*/
	it ('Renders Admission ICD 10 Add Entity button in create mode', fakeAsync(() => {
		const admissionICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD10DisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!admissionICD10Button).toEqual(component.admissionICD10MultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Admission ICD 10', fakeAsync(() => {
		const admissionICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!admissionICD10Button).toEqual(component.admissionICD10MultiCrudActive);

		if (component.admissionICD10MultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAdmissionICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD10DisplayName + ' from Model')).length;

			admissionICD10Button.nativeElement.click();
			fixture.detectChanges();

			const actualAdmissionICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD10DisplayName + ' from Model')).length;

			expect(actualAdmissionICD10RemoveButtonCount).toEqual(initialAdmissionICD10RemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Admission ICD 10 button', () => {
		const admissionICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!admissionICD10Button).toEqual(component.admissionICD10MultiCrudActive);

		if (component.admissionICD10MultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			admissionICD10Button.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAdmissionICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD10DisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAdmissionICD10RemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAdmissionICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD10DisplayName + ' from Model'));

			expect(actualAdmissionICD10RemoveButtons.length).toEqual(initialAdmissionICD10RemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Admission ICD 10 button when one has already been added', () => {

		const admissionICD10Button: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!admissionICD10Button).toEqual(component.admissionICD10MultiCrudActive);

		if (component.admissionICD10MultiCrudActive) {
			admissionICD10Button.nativeElement.click();
			fixture.detectChanges();

			const updatedadmissionICD10Button: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD10DisplayName + ' to Model'));

			expect(updatedadmissionICD10Button.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Admission ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.admissionICD10MultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const admissionICD10RemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD10DisplayName + ' from Model')).length;

			expect(admissionICD10RemoveButtonCount).toEqual(diagnosesAndProceduresWithId.admissionICD10.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Admission ICD 9 CM relation.
	*
	* The button should only exist if admissionICD9CMMultiCrudActive is true
	*/
	it ('Renders Admission ICD 9 CM Add Entity button in create mode', fakeAsync(() => {
		const admissionICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD9CMDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!admissionICD9CMButton).toEqual(component.admissionICD9CMMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Admission ICD 9 CM', fakeAsync(() => {
		const admissionICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!admissionICD9CMButton).toEqual(component.admissionICD9CMMultiCrudActive);

		if (component.admissionICD9CMMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAdmissionICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD9CMDisplayName + ' from Model')).length;

			admissionICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const actualAdmissionICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD9CMDisplayName + ' from Model')).length;

			expect(actualAdmissionICD9CMRemoveButtonCount).toEqual(initialAdmissionICD9CMRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Admission ICD 9 CM button', () => {
		const admissionICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!admissionICD9CMButton).toEqual(component.admissionICD9CMMultiCrudActive);

		if (component.admissionICD9CMMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			admissionICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAdmissionICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD9CMDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAdmissionICD9CMRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAdmissionICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD9CMDisplayName + ' from Model'));

			expect(actualAdmissionICD9CMRemoveButtons.length).toEqual(initialAdmissionICD9CMRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Admission ICD 9 CM button when one has already been added', () => {

		const admissionICD9CMButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!admissionICD9CMButton).toEqual(component.admissionICD9CMMultiCrudActive);

		if (component.admissionICD9CMMultiCrudActive) {
			admissionICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const updatedadmissionICD9CMButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.admissionICD9CMDisplayName + ' to Model'));

			expect(updatedadmissionICD9CMButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Admission ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.admissionICD9CMMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const admissionICD9CMRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.admissionICD9CMDisplayName + ' from Model')).length;

			expect(admissionICD9CMRemoveButtonCount).toEqual(diagnosesAndProceduresWithId.admissionICD9CM.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the CPPT ICD 10 relation.
	*
	* The button should only exist if cpptICD10MultiCrudActive is true
	*/
	it ('Renders CPPT ICD 10 Add Entity button in create mode', fakeAsync(() => {
		const cpptICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD10DisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!cpptICD10Button).toEqual(component.cpptICD10MultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new CPPT ICD 10', fakeAsync(() => {
		const cpptICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cpptICD10Button).toEqual(component.cpptICD10MultiCrudActive);

		if (component.cpptICD10MultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCpptICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD10DisplayName + ' from Model')).length;

			cpptICD10Button.nativeElement.click();
			fixture.detectChanges();

			const actualCpptICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD10DisplayName + ' from Model')).length;

			expect(actualCpptICD10RemoveButtonCount).toEqual(initialCpptICD10RemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove CPPT ICD 10 button', () => {
		const cpptICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cpptICD10Button).toEqual(component.cpptICD10MultiCrudActive);

		if (component.cpptICD10MultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			cpptICD10Button.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCpptICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD10DisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCpptICD10RemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCpptICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD10DisplayName + ' from Model'));

			expect(actualCpptICD10RemoveButtons.length).toEqual(initialCpptICD10RemoveButtons.length - 1);
		}
	});

	it ('should not disable the add CPPT ICD 10 button when one has already been added', () => {

		const cpptICD10Button: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cpptICD10Button).toEqual(component.cpptICD10MultiCrudActive);

		if (component.cpptICD10MultiCrudActive) {
			cpptICD10Button.nativeElement.click();
			fixture.detectChanges();

			const updatedcpptICD10Button: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD10DisplayName + ' to Model'));

			expect(updatedcpptICD10Button.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related CPPT ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.cpptICD10MultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const cpptICD10RemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD10DisplayName + ' from Model')).length;

			expect(cpptICD10RemoveButtonCount).toEqual(diagnosesAndProceduresWithId.cpptICD10.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the CPPT ICD 9 CM relation.
	*
	* The button should only exist if cpptICD9CMMultiCrudActive is true
	*/
	it ('Renders CPPT ICD 9 CM Add Entity button in create mode', fakeAsync(() => {
		const cpptICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD9CMDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!cpptICD9CMButton).toEqual(component.cpptICD9CMMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new CPPT ICD 9 CM', fakeAsync(() => {
		const cpptICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cpptICD9CMButton).toEqual(component.cpptICD9CMMultiCrudActive);

		if (component.cpptICD9CMMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCpptICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD9CMDisplayName + ' from Model')).length;

			cpptICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const actualCpptICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD9CMDisplayName + ' from Model')).length;

			expect(actualCpptICD9CMRemoveButtonCount).toEqual(initialCpptICD9CMRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove CPPT ICD 9 CM button', () => {
		const cpptICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cpptICD9CMButton).toEqual(component.cpptICD9CMMultiCrudActive);

		if (component.cpptICD9CMMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			cpptICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCpptICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD9CMDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCpptICD9CMRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCpptICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD9CMDisplayName + ' from Model'));

			expect(actualCpptICD9CMRemoveButtons.length).toEqual(initialCpptICD9CMRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add CPPT ICD 9 CM button when one has already been added', () => {

		const cpptICD9CMButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cpptICD9CMButton).toEqual(component.cpptICD9CMMultiCrudActive);

		if (component.cpptICD9CMMultiCrudActive) {
			cpptICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcpptICD9CMButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.cpptICD9CMDisplayName + ' to Model'));

			expect(updatedcpptICD9CMButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related CPPT ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.cpptICD9CMMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const cpptICD9CMRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cpptICD9CMDisplayName + ' from Model')).length;

			expect(cpptICD9CMRemoveButtonCount).toEqual(diagnosesAndProceduresWithId.cpptICD9CM.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Discharge ICD 10 relation.
	*
	* The button should only exist if dischargeICD10MultiCrudActive is true
	*/
	it ('Renders Discharge ICD 10 Add Entity button in create mode', fakeAsync(() => {
		const dischargeICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD10DisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!dischargeICD10Button).toEqual(component.dischargeICD10MultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Discharge ICD 10', fakeAsync(() => {
		const dischargeICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dischargeICD10Button).toEqual(component.dischargeICD10MultiCrudActive);

		if (component.dischargeICD10MultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDischargeICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD10DisplayName + ' from Model')).length;

			dischargeICD10Button.nativeElement.click();
			fixture.detectChanges();

			const actualDischargeICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD10DisplayName + ' from Model')).length;

			expect(actualDischargeICD10RemoveButtonCount).toEqual(initialDischargeICD10RemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Discharge ICD 10 button', () => {
		const dischargeICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dischargeICD10Button).toEqual(component.dischargeICD10MultiCrudActive);

		if (component.dischargeICD10MultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			dischargeICD10Button.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDischargeICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD10DisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDischargeICD10RemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDischargeICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD10DisplayName + ' from Model'));

			expect(actualDischargeICD10RemoveButtons.length).toEqual(initialDischargeICD10RemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Discharge ICD 10 button when one has already been added', () => {

		const dischargeICD10Button: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dischargeICD10Button).toEqual(component.dischargeICD10MultiCrudActive);

		if (component.dischargeICD10MultiCrudActive) {
			dischargeICD10Button.nativeElement.click();
			fixture.detectChanges();

			const updateddischargeICD10Button: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD10DisplayName + ' to Model'));

			expect(updateddischargeICD10Button.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Discharge ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.dischargeICD10MultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const dischargeICD10RemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD10DisplayName + ' from Model')).length;

			expect(dischargeICD10RemoveButtonCount).toEqual(diagnosesAndProceduresWithId.dischargeICD10.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Discharge ICD 9 CM relation.
	*
	* The button should only exist if dischargeICD9CMMultiCrudActive is true
	*/
	it ('Renders Discharge ICD 9 CM Add Entity button in create mode', fakeAsync(() => {
		const dischargeICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD9CMDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!dischargeICD9CMButton).toEqual(component.dischargeICD9CMMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Discharge ICD 9 CM', fakeAsync(() => {
		const dischargeICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dischargeICD9CMButton).toEqual(component.dischargeICD9CMMultiCrudActive);

		if (component.dischargeICD9CMMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDischargeICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD9CMDisplayName + ' from Model')).length;

			dischargeICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const actualDischargeICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD9CMDisplayName + ' from Model')).length;

			expect(actualDischargeICD9CMRemoveButtonCount).toEqual(initialDischargeICD9CMRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Discharge ICD 9 CM button', () => {
		const dischargeICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dischargeICD9CMButton).toEqual(component.dischargeICD9CMMultiCrudActive);

		if (component.dischargeICD9CMMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			dischargeICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDischargeICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD9CMDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDischargeICD9CMRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDischargeICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD9CMDisplayName + ' from Model'));

			expect(actualDischargeICD9CMRemoveButtons.length).toEqual(initialDischargeICD9CMRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Discharge ICD 9 CM button when one has already been added', () => {

		const dischargeICD9CMButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dischargeICD9CMButton).toEqual(component.dischargeICD9CMMultiCrudActive);

		if (component.dischargeICD9CMMultiCrudActive) {
			dischargeICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const updateddischargeICD9CMButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.dischargeICD9CMDisplayName + ' to Model'));

			expect(updateddischargeICD9CMButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Discharge ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.dischargeICD9CMMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const dischargeICD9CMRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dischargeICD9CMDisplayName + ' from Model')).length;

			expect(dischargeICD9CMRemoveButtonCount).toEqual(diagnosesAndProceduresWithId.dischargeICD9CM.length);
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

	it ('should not disable the add ICD 10 button when one has already been added', () => {

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

			expect(updatedicd10Button.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
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

			expect(icd10RemoveButtonCount).toEqual(diagnosesAndProceduresWithId.icd10.length);
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

	it ('should not disable the add ICD 9 CM button when one has already been added', () => {

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

			expect(updatedicd9CMButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
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

			expect(icd9CMRemoveButtonCount).toEqual(diagnosesAndProceduresWithId.icd9CM.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoices ICD 10 relation.
	*
	* The button should only exist if invoicesICD10MultiCrudActive is true
	*/
	it ('Renders Invoices ICD 10 Add Entity button in create mode', fakeAsync(() => {
		const invoicesICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD10DisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoicesICD10Button).toEqual(component.invoicesICD10MultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoices ICD 10', fakeAsync(() => {
		const invoicesICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesICD10Button).toEqual(component.invoicesICD10MultiCrudActive);

		if (component.invoicesICD10MultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoicesICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD10DisplayName + ' from Model')).length;

			invoicesICD10Button.nativeElement.click();
			fixture.detectChanges();

			const actualInvoicesICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD10DisplayName + ' from Model')).length;

			expect(actualInvoicesICD10RemoveButtonCount).toEqual(initialInvoicesICD10RemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoices ICD 10 button', () => {
		const invoicesICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesICD10Button).toEqual(component.invoicesICD10MultiCrudActive);

		if (component.invoicesICD10MultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoicesICD10Button.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoicesICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD10DisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoicesICD10RemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoicesICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD10DisplayName + ' from Model'));

			expect(actualInvoicesICD10RemoveButtons.length).toEqual(initialInvoicesICD10RemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoices ICD 10 button when one has already been added', () => {

		const invoicesICD10Button: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesICD10Button).toEqual(component.invoicesICD10MultiCrudActive);

		if (component.invoicesICD10MultiCrudActive) {
			invoicesICD10Button.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoicesICD10Button: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD10DisplayName + ' to Model'));

			expect(updatedinvoicesICD10Button.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoices ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoicesICD10MultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoicesICD10RemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD10DisplayName + ' from Model')).length;

			expect(invoicesICD10RemoveButtonCount).toEqual(diagnosesAndProceduresWithId.invoicesICD10.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoices ICD 9 CM relation.
	*
	* The button should only exist if invoicesICD9CMMultiCrudActive is true
	*/
	it ('Renders Invoices ICD 9 CM Add Entity button in create mode', fakeAsync(() => {
		const invoicesICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD9CMDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoicesICD9CMButton).toEqual(component.invoicesICD9CMMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoices ICD 9 CM', fakeAsync(() => {
		const invoicesICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesICD9CMButton).toEqual(component.invoicesICD9CMMultiCrudActive);

		if (component.invoicesICD9CMMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoicesICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD9CMDisplayName + ' from Model')).length;

			invoicesICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoicesICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD9CMDisplayName + ' from Model')).length;

			expect(actualInvoicesICD9CMRemoveButtonCount).toEqual(initialInvoicesICD9CMRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoices ICD 9 CM button', () => {
		const invoicesICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesICD9CMButton).toEqual(component.invoicesICD9CMMultiCrudActive);

		if (component.invoicesICD9CMMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoicesICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoicesICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD9CMDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoicesICD9CMRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoicesICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD9CMDisplayName + ' from Model'));

			expect(actualInvoicesICD9CMRemoveButtons.length).toEqual(initialInvoicesICD9CMRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoices ICD 9 CM button when one has already been added', () => {

		const invoicesICD9CMButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesICD9CMButton).toEqual(component.invoicesICD9CMMultiCrudActive);

		if (component.invoicesICD9CMMultiCrudActive) {
			invoicesICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoicesICD9CMButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesICD9CMDisplayName + ' to Model'));

			expect(updatedinvoicesICD9CMButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoices ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoicesICD9CMMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoicesICD9CMRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesICD9CMDisplayName + ' from Model')).length;

			expect(invoicesICD9CMRemoveButtonCount).toEqual(diagnosesAndProceduresWithId.invoicesICD9CM.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Post Operative ICD 10 relation.
	*
	* The button should only exist if postOperativeICD10MultiCrudActive is true
	*/
	it ('Renders Post Operative ICD 10 Add Entity button in create mode', fakeAsync(() => {
		const postOperativeICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD10DisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!postOperativeICD10Button).toEqual(component.postOperativeICD10MultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Post Operative ICD 10', fakeAsync(() => {
		const postOperativeICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!postOperativeICD10Button).toEqual(component.postOperativeICD10MultiCrudActive);

		if (component.postOperativeICD10MultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPostOperativeICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD10DisplayName + ' from Model')).length;

			postOperativeICD10Button.nativeElement.click();
			fixture.detectChanges();

			const actualPostOperativeICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD10DisplayName + ' from Model')).length;

			expect(actualPostOperativeICD10RemoveButtonCount).toEqual(initialPostOperativeICD10RemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Post Operative ICD 10 button', () => {
		const postOperativeICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!postOperativeICD10Button).toEqual(component.postOperativeICD10MultiCrudActive);

		if (component.postOperativeICD10MultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			postOperativeICD10Button.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPostOperativeICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD10DisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPostOperativeICD10RemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPostOperativeICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD10DisplayName + ' from Model'));

			expect(actualPostOperativeICD10RemoveButtons.length).toEqual(initialPostOperativeICD10RemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Post Operative ICD 10 button when one has already been added', () => {

		const postOperativeICD10Button: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!postOperativeICD10Button).toEqual(component.postOperativeICD10MultiCrudActive);

		if (component.postOperativeICD10MultiCrudActive) {
			postOperativeICD10Button.nativeElement.click();
			fixture.detectChanges();

			const updatedpostOperativeICD10Button: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD10DisplayName + ' to Model'));

			expect(updatedpostOperativeICD10Button.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Post Operative ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.postOperativeICD10MultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const postOperativeICD10RemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD10DisplayName + ' from Model')).length;

			expect(postOperativeICD10RemoveButtonCount).toEqual(diagnosesAndProceduresWithId.postOperativeICD10.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Post Operative ICD 9 CM relation.
	*
	* The button should only exist if postOperativeICD9CMMultiCrudActive is true
	*/
	it ('Renders Post Operative ICD 9 CM Add Entity button in create mode', fakeAsync(() => {
		const postOperativeICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD9CMDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!postOperativeICD9CMButton).toEqual(component.postOperativeICD9CMMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Post Operative ICD 9 CM', fakeAsync(() => {
		const postOperativeICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!postOperativeICD9CMButton).toEqual(component.postOperativeICD9CMMultiCrudActive);

		if (component.postOperativeICD9CMMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPostOperativeICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD9CMDisplayName + ' from Model')).length;

			postOperativeICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const actualPostOperativeICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD9CMDisplayName + ' from Model')).length;

			expect(actualPostOperativeICD9CMRemoveButtonCount).toEqual(initialPostOperativeICD9CMRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Post Operative ICD 9 CM button', () => {
		const postOperativeICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!postOperativeICD9CMButton).toEqual(component.postOperativeICD9CMMultiCrudActive);

		if (component.postOperativeICD9CMMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			postOperativeICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPostOperativeICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD9CMDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPostOperativeICD9CMRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPostOperativeICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD9CMDisplayName + ' from Model'));

			expect(actualPostOperativeICD9CMRemoveButtons.length).toEqual(initialPostOperativeICD9CMRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Post Operative ICD 9 CM button when one has already been added', () => {

		const postOperativeICD9CMButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!postOperativeICD9CMButton).toEqual(component.postOperativeICD9CMMultiCrudActive);

		if (component.postOperativeICD9CMMultiCrudActive) {
			postOperativeICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpostOperativeICD9CMButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeICD9CMDisplayName + ' to Model'));

			expect(updatedpostOperativeICD9CMButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Post Operative ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.postOperativeICD9CMMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const postOperativeICD9CMRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeICD9CMDisplayName + ' from Model')).length;

			expect(postOperativeICD9CMRemoveButtonCount).toEqual(diagnosesAndProceduresWithId.postOperativeICD9CM.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Pre Surgery ICD 10 relation.
	*
	* The button should only exist if preSurgeryICD10MultiCrudActive is true
	*/
	it ('Renders Pre Surgery ICD 10 Add Entity button in create mode', fakeAsync(() => {
		const preSurgeryICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD10DisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!preSurgeryICD10Button).toEqual(component.preSurgeryICD10MultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Pre Surgery ICD 10', fakeAsync(() => {
		const preSurgeryICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!preSurgeryICD10Button).toEqual(component.preSurgeryICD10MultiCrudActive);

		if (component.preSurgeryICD10MultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPreSurgeryICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD10DisplayName + ' from Model')).length;

			preSurgeryICD10Button.nativeElement.click();
			fixture.detectChanges();

			const actualPreSurgeryICD10RemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD10DisplayName + ' from Model')).length;

			expect(actualPreSurgeryICD10RemoveButtonCount).toEqual(initialPreSurgeryICD10RemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Pre Surgery ICD 10 button', () => {
		const preSurgeryICD10Button: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!preSurgeryICD10Button).toEqual(component.preSurgeryICD10MultiCrudActive);

		if (component.preSurgeryICD10MultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			preSurgeryICD10Button.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPreSurgeryICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD10DisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPreSurgeryICD10RemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPreSurgeryICD10RemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD10DisplayName + ' from Model'));

			expect(actualPreSurgeryICD10RemoveButtons.length).toEqual(initialPreSurgeryICD10RemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Pre Surgery ICD 10 button when one has already been added', () => {

		const preSurgeryICD10Button: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD10DisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!preSurgeryICD10Button).toEqual(component.preSurgeryICD10MultiCrudActive);

		if (component.preSurgeryICD10MultiCrudActive) {
			preSurgeryICD10Button.nativeElement.click();
			fixture.detectChanges();

			const updatedpreSurgeryICD10Button: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD10DisplayName + ' to Model'));

			expect(updatedpreSurgeryICD10Button.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Pre Surgery ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.preSurgeryICD10MultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const preSurgeryICD10RemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD10DisplayName + ' from Model')).length;

			expect(preSurgeryICD10RemoveButtonCount).toEqual(diagnosesAndProceduresWithId.preSurgeryICD10.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Pre Surgery ICD 9 CM relation.
	*
	* The button should only exist if preSurgeryICD9CMMultiCrudActive is true
	*/
	it ('Renders Pre Surgery ICD 9 CM Add Entity button in create mode', fakeAsync(() => {
		const preSurgeryICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD9CMDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!preSurgeryICD9CMButton).toEqual(component.preSurgeryICD9CMMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Pre Surgery ICD 9 CM', fakeAsync(() => {
		const preSurgeryICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!preSurgeryICD9CMButton).toEqual(component.preSurgeryICD9CMMultiCrudActive);

		if (component.preSurgeryICD9CMMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPreSurgeryICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD9CMDisplayName + ' from Model')).length;

			preSurgeryICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const actualPreSurgeryICD9CMRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD9CMDisplayName + ' from Model')).length;

			expect(actualPreSurgeryICD9CMRemoveButtonCount).toEqual(initialPreSurgeryICD9CMRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Pre Surgery ICD 9 CM button', () => {
		const preSurgeryICD9CMButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!preSurgeryICD9CMButton).toEqual(component.preSurgeryICD9CMMultiCrudActive);

		if (component.preSurgeryICD9CMMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			preSurgeryICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPreSurgeryICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD9CMDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPreSurgeryICD9CMRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPreSurgeryICD9CMRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD9CMDisplayName + ' from Model'));

			expect(actualPreSurgeryICD9CMRemoveButtons.length).toEqual(initialPreSurgeryICD9CMRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Pre Surgery ICD 9 CM button when one has already been added', () => {

		const preSurgeryICD9CMButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD9CMDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!preSurgeryICD9CMButton).toEqual(component.preSurgeryICD9CMMultiCrudActive);

		if (component.preSurgeryICD9CMMultiCrudActive) {
			preSurgeryICD9CMButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpreSurgeryICD9CMButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.preSurgeryICD9CMDisplayName + ' to Model'));

			expect(updatedpreSurgeryICD9CMButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Pre Surgery ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.preSurgeryICD9CMMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const preSurgeryICD9CMRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preSurgeryICD9CMDisplayName + ' from Model')).length;

			expect(preSurgeryICD9CMRemoveButtonCount).toEqual(diagnosesAndProceduresWithId.preSurgeryICD9CM.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Diagnosis Nandas relation.
	*
	* The button should only exist if diagnosisNandasMultiCrudActive is true
	*/
	it ('Renders Diagnosis Nandas Add Entity button in create mode', fakeAsync(() => {
		const diagnosisNandasButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosisNandasDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!diagnosisNandasButton).toEqual(component.diagnosisNandasMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Diagnosis Nandas', fakeAsync(() => {
		const diagnosisNandasButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosisNandasDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosisNandasButton).toEqual(component.diagnosisNandasMultiCrudActive);

		if (component.diagnosisNandasMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDiagnosisNandasRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosisNandasDisplayName + ' from Model')).length;

			diagnosisNandasButton.nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosisNandasRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosisNandasDisplayName + ' from Model')).length;

			expect(actualDiagnosisNandasRemoveButtonCount).toEqual(initialDiagnosisNandasRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Diagnosis Nandas button', () => {
		const diagnosisNandasButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosisNandasDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosisNandasButton).toEqual(component.diagnosisNandasMultiCrudActive);

		if (component.diagnosisNandasMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			diagnosisNandasButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDiagnosisNandasRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosisNandasDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDiagnosisNandasRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosisNandasRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosisNandasDisplayName + ' from Model'));

			expect(actualDiagnosisNandasRemoveButtons.length).toEqual(initialDiagnosisNandasRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Diagnosis Nandas button when one has already been added', () => {

		const diagnosisNandasButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosisNandasDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosisNandasButton).toEqual(component.diagnosisNandasMultiCrudActive);

		if (component.diagnosisNandasMultiCrudActive) {
			diagnosisNandasButton.nativeElement.click();
			fixture.detectChanges();

			const updateddiagnosisNandasButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosisNandasDisplayName + ' to Model'));

			expect(updateddiagnosisNandasButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Diagnosis Nandas entities from model when loading in edit mode', () => {
		component.targetModel = diagnosesAndProceduresWithId;
		component.targetModelId = diagnosesAndProceduresWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.diagnosisNandasMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const diagnosisNandasRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosisNandasDisplayName + ' from Model')).length;

			expect(diagnosisNandasRemoveButtonCount).toEqual(diagnosesAndProceduresWithId.diagnosisNandas.length);
		}
	});

});
