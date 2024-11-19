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

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FrontendComponent} from './frontend.component';
import { RoleGuard } from 'src/app/lib/guards/role.guard';
import { AccidentAndEmergencyPageComponent } from 'src/app/pages/accident-and-emergency/accident-and-emergency.page.component';
import { AccountConfigurationPageComponent } from 'src/app/pages/account-configuration/account-configuration.page.component';
import { AmendmentDetailPageComponent } from 'src/app/pages/amendment-detail/amendment-detail.page.component';
import { AnalyticsPageComponent } from 'src/app/pages/analytics/analytics.page.component';
import { ApplicationLogoPageComponent } from 'src/app/pages/application-logo/application-logo.page.component';
import { BpjsTotalReferralSEPPageComponent } from 'src/app/pages/bpjs-total-referral-sep/bpjs-total-referral-sep.page.component';
import { BpjsAccidentMasterDataPageComponent } from 'src/app/pages/bpjs-accident-master-data/bpjs-accident-master-data.page.component';
import { BpjsBedAvailabilityPageComponent } from 'src/app/pages/bpjs-bed-availability/bpjs-bed-availability.page.component';
import { BpjsClaimDataPageComponent } from 'src/app/pages/bpjs-claim-data/bpjs-claim-data.page.component';
import { BpjsClaimSubmissionPageComponent } from 'src/app/pages/bpjs-claim-submission/bpjs-claim-submission.page.component';
import { BpjsConfigurationPageComponent } from 'src/app/pages/bpjs-configuration/bpjs-configuration.page.component';
import { BpjsControlPlanPageComponent } from 'src/app/pages/bpjs-control-plan/bpjs-control-plan.page.component';
import { BpjsControlPlanWrapperPageComponent } from 'src/app/pages/bpjs-control-plan-wrapper/bpjs-control-plan-wrapper.page.component';
import { BpjsControlSpecialistPageComponent } from 'src/app/pages/bpjs-control-specialist/bpjs-control-specialist.page.component';
import { BpjsDiagnosePageComponent } from 'src/app/pages/bpjs-diagnose/bpjs-diagnose.page.component';
import { BpjsDiagnosePRBPageComponent } from 'src/app/pages/bpjs-diagnose-prb/bpjs-diagnose-prb.page.component';
import { BpjsDismisalPageComponent } from 'src/app/pages/bpjs-dismisal/bpjs-dismisal.page.component';
import { BpjsDismissalMappingPageComponent } from 'src/app/pages/bpjs-dismissal-mapping/bpjs-dismissal-mapping.page.component';
import { BpjsDoctorMappingPageComponent } from 'src/app/pages/bpjs-doctor-mapping/bpjs-doctor-mapping.page.component';
import { BpjsDoctorSchedulePageComponent } from 'src/app/pages/bpjs-doctor-schedule/bpjs-doctor-schedule.page.component';
import { BpjsDrugGenericPRBPageComponent } from 'src/app/pages/bpjs-drug-generic-prb/bpjs-drug-generic-prb.page.component';
import { BpjsFacilityListPageComponent } from 'src/app/pages/bpjs-facility-list/bpjs-facility-list.page.component';
import { BpjsFingerPrintPageComponent } from 'src/app/pages/bpjs-finger-print/bpjs-finger-print.page.component';
import { BpjsGeneralPageComponent } from 'src/app/pages/bpjs-general/bpjs-general.page.component';
import { BpjsGetFingerPrintPageComponent } from 'src/app/pages/bpjs-get-finger-print/bpjs-get-finger-print.page.component';
import { BpjsHealthFacilityPageComponent } from 'src/app/pages/bpjs-health-facility/bpjs-health-facility.page.component';
import { BpjsHospitalizationPlanPageComponent } from 'src/app/pages/bpjs-hospitalization-plan/bpjs-hospitalization-plan.page.component';
import { BpjsINACBGPageComponent } from 'src/app/pages/bpjs-inacbg/bpjs-inacbg.page.component';
import { BpjsINACBGVariablesPageComponent } from 'src/app/pages/bpjs-inacbg-variables/bpjs-inacbg-variables.page.component';
import { BpjsJasaRaharjaPageComponent } from 'src/app/pages/bpjs-jasa-raharja/bpjs-jasa-raharja.page.component';
import { BpjsJasaRaharjaClaimPageComponent } from 'src/app/pages/bpjs-jasa-raharja-claim/bpjs-jasa-raharja-claim.page.component';
import { BpjsJasaRaharjaDetailPageComponent } from 'src/app/pages/bpjs-jasa-raharja-detail/bpjs-jasa-raharja-detail.page.component';
import { BpjsListFingerPrintPageComponent } from 'src/app/pages/bpjs-list-finger-print/bpjs-list-finger-print.page.component';
import { BpjsMonitoringPageComponent } from 'src/app/pages/bpjs-monitoring/bpjs-monitoring.page.component';
import { BpjsOutsideFacilityReferralPageComponent } from 'src/app/pages/bpjs-outside-facility-referral/bpjs-outside-facility-referral.page.component';
import { BpjsPatientReferralPageComponent } from 'src/app/pages/bpjs-patient-referral/bpjs-patient-referral.page.component';
import { BpjsPatientReferralDetailPageComponent } from 'src/app/pages/bpjs-patient-referral-detail/bpjs-patient-referral-detail.page.component';
import { BpjsProcedurePageComponent } from 'src/app/pages/bpjs-procedure/bpjs-procedure.page.component';
import { BpjsReferralSpecialistPageComponent } from 'src/app/pages/bpjs-referral-specialist/bpjs-referral-specialist.page.component';
import { BpjsReferredBackPageComponent } from 'src/app/pages/bpjs-referred-back/bpjs-referred-back.page.component';
import { BpjsReferredBackDetailPageComponent } from 'src/app/pages/bpjs-referred-back-detail/bpjs-referred-back-detail.page.component';
import { BpjsReferredBackWrapperPageComponent } from 'src/app/pages/bpjs-referred-back-wrapper/bpjs-referred-back-wrapper.page.component';
import { BpjsSEPPageComponent } from 'src/app/pages/bpjs-sep/bpjs-sep.page.component';
import { BpjsSEPInternalPageComponent } from 'src/app/pages/bpjs-sep-internal/bpjs-sep-internal.page.component';
import { BpjsSEPAndINACBGIntegrationPageComponent } from 'src/app/pages/bpjs-sep-and-inacbg-integration/bpjs-sep-and-inacbg-integration.page.component';
import { BpjsSearchControlLetterPageComponent } from 'src/app/pages/bpjs-search-control-letter/bpjs-search-control-letter.page.component';
import { BpjsSearchSEPPageComponent } from 'src/app/pages/bpjs-search-sep/bpjs-search-sep.page.component';
import { BpjsSepSubmissionPageComponent } from 'src/app/pages/bpjs-sep-submission/bpjs-sep-submission.page.component';
import { BpjsServiceMappingPageComponent } from 'src/app/pages/bpjs-service-mapping/bpjs-service-mapping.page.component';
import { BpjsSpecialReferralPageComponent } from 'src/app/pages/bpjs-special-referral/bpjs-special-referral.page.component';
import { BpjsTaskHistoryPageComponent } from 'src/app/pages/bpjs-task-history/bpjs-task-history.page.component';
import { BpjsTreatmentClassMappingPageComponent } from 'src/app/pages/bpjs-treatment-class-mapping/bpjs-treatment-class-mapping.page.component';
import { BpjsTreatmentHistoryPageComponent } from 'src/app/pages/bpjs-treatment-history/bpjs-treatment-history.page.component';
import { BpjsTreatmentRoomPageComponent } from 'src/app/pages/bpjs-treatment-room/bpjs-treatment-room.page.component';
import { BpjsUpdateDismissalDatePageComponent } from 'src/app/pages/bpjs-update-dismissal-date/bpjs-update-dismissal-date.page.component';
import { BpjsUpdateDismissalDateWrapperPageComponent } from 'src/app/pages/bpjs-update-dismissal-date-wrapper/bpjs-update-dismissal-date-wrapper.page.component';
import { BpjsVisitDataPageComponent } from 'src/app/pages/bpjs-visit-data/bpjs-visit-data.page.component';
import { BatchCorrectionPageComponent } from 'src/app/pages/batch-correction/batch-correction.page.component';
import { BedPageComponent } from 'src/app/pages/bed/bed.page.component';
import { BedAvailabilityPageComponent } from 'src/app/pages/bed-availability/bed-availability.page.component';
import { BedManagementPageComponent } from 'src/app/pages/bed-management/bed-management.page.component';
import { BenefitPlanPageComponent } from 'src/app/pages/benefit-plan/benefit-plan.page.component';
import { BirthHistoryPageComponent } from 'src/app/pages/birth-history/birth-history.page.component';
import { BpjsPageComponent } from 'src/app/pages/bpjs/bpjs.page.component';
import { BpjsHealthFacilityBedAvailabilityPageComponent } from 'src/app/pages/bpjs-health-facility-bed-availability/bpjs-health-facility-bed-availability.page.component';
import { BpjsSepClaimWrapperPageComponent } from 'src/app/pages/bpjs-sep-claim-wrapper/bpjs-sep-claim-wrapper.page.component';
import { BpjsSepSubmissionWrapperPageComponent } from 'src/app/pages/bpjs-sep-submission-wrapper/bpjs-sep-submission-wrapper.page.component';
import { CashReportPageComponent } from 'src/app/pages/cash-report/cash-report.page.component';
import { CataloguePageComponent } from 'src/app/pages/catalogue/catalogue.page.component';
import { ChartOfAccountPageComponent } from 'src/app/pages/chart-of-account/chart-of-account.page.component';
import { ChartOfAccountMappingPageComponent } from 'src/app/pages/chart-of-account-mapping/chart-of-account-mapping.page.component';
import { ClaimReportPageComponent } from 'src/app/pages/claim-report/claim-report.page.component';
import { ClaimsPageComponent } from 'src/app/pages/claims/claims.page.component';
import { ClinicalExamPageComponent } from 'src/app/pages/clinical-exam/clinical-exam.page.component';
import { ClinicalExamAmendmentHistoryPageComponent } from 'src/app/pages/clinical-exam-amendment-history/clinical-exam-amendment-history.page.component';
import { ClinicalExamDashboardPageComponent } from 'src/app/pages/clinical-exam-dashboard/clinical-exam-dashboard.page.component';
import { ClinicalExamDiagnosticStaffPageComponent } from 'src/app/pages/clinical-exam-diagnostic-staff/clinical-exam-diagnostic-staff.page.component';
import { ClinicalExamDoctorPageComponent } from 'src/app/pages/clinical-exam-doctor/clinical-exam-doctor.page.component';
import { ClinicalExamNursePageComponent } from 'src/app/pages/clinical-exam-nurse/clinical-exam-nurse.page.component';
import { ClinicalExamPatientDemographicPageComponent } from 'src/app/pages/clinical-exam-patient-demographic/clinical-exam-patient-demographic.page.component';
import { ClinicalExamPatientMedicalHistoryPageComponent } from 'src/app/pages/clinical-exam-patient-medical-history/clinical-exam-patient-medical-history.page.component';
import { CompoundPrescriptionPageComponent } from 'src/app/pages/compound-prescription/compound-prescription.page.component';
import { CompoundPrescriptionDetailPageComponent } from 'src/app/pages/compound-prescription-detail/compound-prescription-detail.page.component';
import { CriticalCarePageComponent } from 'src/app/pages/critical-care/critical-care.page.component';
import { DailyCareCPPTPageComponent } from 'src/app/pages/daily-care-cppt/daily-care-cppt.page.component';
import { DashboardPageComponent } from 'src/app/pages/dashboard/dashboard.page.component';
import { DeliveryMedicalExaminationRecordPageComponent } from 'src/app/pages/delivery-medical-examination-record/delivery-medical-examination-record.page.component';
import { DeliveryRoomPageComponent } from 'src/app/pages/delivery-room/delivery-room.page.component';
import { DentalOralServiceActivityReportPageComponent } from 'src/app/pages/dental-oral-service-activity-report/dental-oral-service-activity-report.page.component';
import { DiagAndProcPageComponent } from 'src/app/pages/diag-and-proc/diag-and-proc.page.component';
import { DiagnosesAndProceduresPageComponent } from 'src/app/pages/diagnoses-and-procedures/diagnoses-and-procedures.page.component';
import { DiagnosticConfigurationPageComponent } from 'src/app/pages/diagnostic-configuration/diagnostic-configuration.page.component';
import { DiagnosticSupportPageComponent } from 'src/app/pages/diagnostic-support/diagnostic-support.page.component';
import { DiagnosticSupportConfigurationPageComponent } from 'src/app/pages/diagnostic-support-configuration/diagnostic-support-configuration.page.component';
import { DiagnosticSupportGeneralConfigurationPageComponent } from 'src/app/pages/diagnostic-support-general-configuration/diagnostic-support-general-configuration.page.component';
import { DrugProcurementServiceReportPageComponent } from 'src/app/pages/drug-procurement-service-report/drug-procurement-service-report.page.component';
import { EmergencyMedicalExaminationRecordPageComponent } from 'src/app/pages/emergency-medical-examination-record/emergency-medical-examination-record.page.component';
import { EmergencyServiceActivityReportPageComponent } from 'src/app/pages/emergency-service-activity-report/emergency-service-activity-report.page.component';
import { ExaminationGroupPageComponent } from 'src/app/pages/examination-group/examination-group.page.component';
import { ExaminationItemPageComponent } from 'src/app/pages/examination-item/examination-item.page.component';
import { ExaminationItemDetailPageComponent } from 'src/app/pages/examination-item-detail/examination-item-detail.page.component';
import { FamilyPlanningServiceActivityReportPageComponent } from 'src/app/pages/family-planning-service-activity-report/family-planning-service-activity-report.page.component';
import { FluidBalanceDetailPageComponent } from 'src/app/pages/fluid-balance-detail/fluid-balance-detail.page.component';
import { GeneralConfigPageComponent } from 'src/app/pages/general-config/general-config.page.component';
import { GeneralReportPageComponent } from 'src/app/pages/general-report/general-report.page.component';
import { GoodsReceiveNoteItemsReportPageComponent } from 'src/app/pages/goods-receive-note-items-report/goods-receive-note-items-report.page.component';
import { GoodsReceivedNotePageComponent } from 'src/app/pages/goods-received-note/goods-received-note.page.component';
import { GoodsReceivedNoteDetailPageComponent } from 'src/app/pages/goods-received-note-detail/goods-received-note-detail.page.component';
import { GoodsReceivedNoteItemPageComponent } from 'src/app/pages/goods-received-note-item/goods-received-note-item.page.component';
import { HealthFacPageComponent } from 'src/app/pages/health-fac/health-fac.page.component';
import { HealthInsurancePageComponent } from 'src/app/pages/health-insurance/health-insurance.page.component';
import { HospitalBedInformationReportPageComponent } from 'src/app/pages/hospital-bed-information-report/hospital-bed-information-report.page.component';
import { HospitalBranchInformationConfigPageComponent } from 'src/app/pages/hospital-branch-information-config/hospital-branch-information-config.page.component';
import { HospitalGroupInformationConfigPageComponent } from 'src/app/pages/hospital-group-information-config/hospital-group-information-config.page.component';
import { HospitalInformationReportPageComponent } from 'src/app/pages/hospital-information-report/hospital-information-report.page.component';
import { HospitalPerformanceIndicatorsReportPageComponent } from 'src/app/pages/hospital-performance-indicators-report/hospital-performance-indicators-report.page.component';
import { HospitalStaffInformationReportPageComponent } from 'src/app/pages/hospital-staff-information-report/hospital-staff-information-report.page.component';
import { HospitalVisitorReportPageComponent } from 'src/app/pages/hospital-visitor-report/hospital-visitor-report.page.component';
import { Icd10PageComponent } from 'src/app/pages/icd10/icd10.page.component';
import { Icd9PageComponent } from 'src/app/pages/icd9/icd9.page.component';
import { IncomeReportPageComponent } from 'src/app/pages/income-report/income-report.page.component';
import { InpatientPageComponent } from 'src/app/pages/inpatient/inpatient.page.component';
import { InpatientAdmissionPageComponent } from 'src/app/pages/inpatient-admission/inpatient-admission.page.component';
import { InpatientDiseaseReportPageComponent } from 'src/app/pages/inpatient-disease-report/inpatient-disease-report.page.component';
import { InpatientExaminationPageComponent } from 'src/app/pages/inpatient-examination/inpatient-examination.page.component';
import { InpatientExaminationDetailPageComponent } from 'src/app/pages/inpatient-examination-detail/inpatient-examination-detail.page.component';
import { InpatientMorbidityData4A2ReportPageComponent } from 'src/app/pages/inpatient-morbidity-data-4a2-report/inpatient-morbidity-data-4a2-report.page.component';
import { InpatientMorbidityDataReportPageComponent } from 'src/app/pages/inpatient-morbidity-data-report/inpatient-morbidity-data-report.page.component';
import { InpatientOrderPageComponent } from 'src/app/pages/inpatient-order/inpatient-order.page.component';
import { InpatientServiceActivityReportPageComponent } from 'src/app/pages/inpatient-service-activity-report/inpatient-service-activity-report.page.component';
import { InternalOrderPageComponent } from 'src/app/pages/internal-order/internal-order.page.component';
import { InternalOrderStockDetailPageComponent } from 'src/app/pages/internal-order-stock-detail/internal-order-stock-detail.page.component';
import { IntraoperativeRecordsPageComponent } from 'src/app/pages/intraoperative-records/intraoperative-records.page.component';
import { InventoryPageComponent } from 'src/app/pages/inventory/inventory.page.component';
import { InventoryAdjusmentWrapperPageComponent } from 'src/app/pages/inventory-adjusment-wrapper/inventory-adjusment-wrapper.page.component';
import { InventoryAdjustmentPageComponent } from 'src/app/pages/inventory-adjustment/inventory-adjustment.page.component';
import { InventoryEnquiryPageComponent } from 'src/app/pages/inventory-enquiry/inventory-enquiry.page.component';
import { InventoryEnquiryInventoryTransactionPageComponent } from 'src/app/pages/inventory-enquiry-inventory-transaction/inventory-enquiry-inventory-transaction.page.component';
import { InventoryEnquiryStockExpirationBalancePageComponent } from 'src/app/pages/inventory-enquiry-stock-expiration-balance/inventory-enquiry-stock-expiration-balance.page.component';
import { InventoryEnquiryStockExpirationDetailPageComponent } from 'src/app/pages/inventory-enquiry-stock-expiration-detail/inventory-enquiry-stock-expiration-detail.page.component';
import { InventoryEnquiryStockExpirationHistoryPageComponent } from 'src/app/pages/inventory-enquiry-stock-expiration-history/inventory-enquiry-stock-expiration-history.page.component';
import { InventoryEnquiryStockMutationPageComponent } from 'src/app/pages/inventory-enquiry-stock-mutation/inventory-enquiry-stock-mutation.page.component';
import { InventoryEnquiryStockSummaryPageComponent } from 'src/app/pages/inventory-enquiry-stock-summary/inventory-enquiry-stock-summary.page.component';
import { InventoryEnquiryStockTransactionDetailPageComponent } from 'src/app/pages/inventory-enquiry-stock-transaction-detail/inventory-enquiry-stock-transaction-detail.page.component';
import { InvoiceComponentReportPageComponent } from 'src/app/pages/invoice-component-report/invoice-component-report.page.component';
import { InvoiceItemReportPageComponent } from 'src/app/pages/invoice-item-report/invoice-item-report.page.component';
import { InvoiceReportPageComponent } from 'src/app/pages/invoice-report/invoice-report.page.component';
import { JournalPageComponent } from 'src/app/pages/journal/journal.page.component';
import { KmsHomePageComponent } from 'src/app/pages/kms-home/kms-home.page.component';
import { LaboratoryServiceActivityReportPageComponent } from 'src/app/pages/laboratory-service-activity-report/laboratory-service-activity-report.page.component';
import { McuPackagePageComponent } from 'src/app/pages/mcu-package/mcu-package.page.component';
import { McuPackageDetailPageComponent } from 'src/app/pages/mcu-package-detail/mcu-package-detail.page.component';
import { McuPackageItemPageComponent } from 'src/app/pages/mcu-package-item/mcu-package-item.page.component';
import { MasterCatalogueReportPageComponent } from 'src/app/pages/master-catalogue-report/master-catalogue-report.page.component';
import { MasterPatientReportPageComponent } from 'src/app/pages/master-patient-report/master-patient-report.page.component';
import { MedicalExaminationRecordPageComponent } from 'src/app/pages/medical-examination-record/medical-examination-record.page.component';
import { MedicalFeePageComponent } from 'src/app/pages/medical-fee/medical-fee.page.component';
import { MedicalRecordChecklistPageComponent } from 'src/app/pages/medical-record-checklist/medical-record-checklist.page.component';
import { MedicalRecordReportPageComponent } from 'src/app/pages/medical-record-report/medical-record-report.page.component';
import { MedicalRehabilitationServiceActivityReportPageComponent } from 'src/app/pages/medical-rehabilitation-service-activity-report/medical-rehabilitation-service-activity-report.page.component';
import { MedicationAdministeredHistoryPageComponent } from 'src/app/pages/medication-administered-history/medication-administered-history.page.component';
import { MedicationCompoundPageComponent } from 'src/app/pages/medication-compound/medication-compound.page.component';
import { MedicationDetailPageComponent } from 'src/app/pages/medication-detail/medication-detail.page.component';
import { MedicationDispensingPageComponent } from 'src/app/pages/medication-dispensing/medication-dispensing.page.component';
import { MedicationItemPageComponent } from 'src/app/pages/medication-item/medication-item.page.component';
import { MerchantBankPageComponent } from 'src/app/pages/merchant-bank/merchant-bank.page.component';
import { MerchantSurchargeFeePageComponent } from 'src/app/pages/merchant-surcharge-fee/merchant-surcharge-fee.page.component';
import { NewbornDetailPageComponent } from 'src/app/pages/newborn-detail/newborn-detail.page.component';
import { NonCompoundDrugPageComponent } from 'src/app/pages/non-compound-drug/non-compound-drug.page.component';
import { NumberingSetupPageComponent } from 'src/app/pages/numbering-setup/numbering-setup.page.component';
import { NurseVitalSignMeasurementPageComponent } from 'src/app/pages/nurse-vital-sign-measurement/nurse-vital-sign-measurement.page.component';
import { ObstetricAndGynecologyHistoryPageComponent } from 'src/app/pages/obstetric-and-gynecology-history/obstetric-and-gynecology-history.page.component';
import { ObstetricServiceActivityReportPageComponent } from 'src/app/pages/obstetric-service-activity-report/obstetric-service-activity-report.page.component';
import { OperatingTheaterMedicalExaminationRecordPageComponent } from 'src/app/pages/operating-theater-medical-examination-record/operating-theater-medical-examination-record.page.component';
import { OperatingTheaterServiceActivityReportPageComponent } from 'src/app/pages/operating-theater-service-activity-report/operating-theater-service-activity-report.page.component';
import { OperatingTheatrePageComponent } from 'src/app/pages/operating-theatre/operating-theatre.page.component';
import { OperationalDashboardPageComponent } from 'src/app/pages/operational-dashboard/operational-dashboard.page.component';
import { OutpatientPageComponent } from 'src/app/pages/outpatient/outpatient.page.component';
import { OutpatientDiseaseReportPageComponent } from 'src/app/pages/outpatient-disease-report/outpatient-disease-report.page.component';
import { OutpatientExaminationPageComponent } from 'src/app/pages/outpatient-examination/outpatient-examination.page.component';
import { OutpatientExaminationDetailPageComponent } from 'src/app/pages/outpatient-examination-detail/outpatient-examination-detail.page.component';
import { OutpatientMorbidityData4BReportPageComponent } from 'src/app/pages/outpatient-morbidity-data-4b-report/outpatient-morbidity-data-4b-report.page.component';
import { OutpatientMorbidityData4B2ReportPageComponent } from 'src/app/pages/outpatient-morbidity-data-4b2-report/outpatient-morbidity-data-4b2-report.page.component';
import { OutpatientVisitReportPageComponent } from 'src/app/pages/outpatient-visit-report/outpatient-visit-report.page.component';
import { OutpatientVisitorInformationReportPageComponent } from 'src/app/pages/outpatient-visitor-information-report/outpatient-visitor-information-report.page.component';
import { PcarePageComponent } from 'src/app/pages/pcare/pcare.page.component';
import { PcareClubProlanisPageComponent } from 'src/app/pages/pcare-club-prolanis/pcare-club-prolanis.page.component';
import { PcareConfigurationPageComponent } from 'src/app/pages/pcare-configuration/pcare-configuration.page.component';
import { PcareDaftarPendaftaranPageComponent } from 'src/app/pages/pcare-daftar-pendaftaran/pcare-daftar-pendaftaran.page.component';
import { PcareDaftarRiwayatKunjunganPageComponent } from 'src/app/pages/pcare-daftar-riwayat-kunjungan/pcare-daftar-riwayat-kunjungan.page.component';
import { PcareDaftarRujukanPageComponent } from 'src/app/pages/pcare-daftar-rujukan/pcare-daftar-rujukan.page.component';
import { PcareDataKegiatanPageComponent } from 'src/app/pages/pcare-data-kegiatan/pcare-data-kegiatan.page.component';
import { PcareDiagnosaPageComponent } from 'src/app/pages/pcare-diagnosa/pcare-diagnosa.page.component';
import { PcareDokterPageComponent } from 'src/app/pages/pcare-dokter/pcare-dokter.page.component';
import { PcareKegiatanKelompokPageComponent } from 'src/app/pages/pcare-kegiatan-kelompok/pcare-kegiatan-kelompok.page.component';
import { PcareKegiatanKelompokWrapperPageComponent } from 'src/app/pages/pcare-kegiatan-kelompok-wrapper/pcare-kegiatan-kelompok-wrapper.page.component';
import { PcareKesadaranPageComponent } from 'src/app/pages/pcare-kesadaran/pcare-kesadaran.page.component';
import { PcareKunjunganWrapperPageComponent } from 'src/app/pages/pcare-kunjungan-wrapper/pcare-kunjungan-wrapper.page.component';
import { PcareMCUPageComponent } from 'src/app/pages/pcare-mcu/pcare-mcu.page.component';
import { PcareMCUWrapperPageComponent } from 'src/app/pages/pcare-mcu-wrapper/pcare-mcu-wrapper.page.component';
import { PcarePesertaKegiatanKelompokPageComponent } from 'src/app/pages/pcare-peserta-kegiatan-kelompok/pcare-peserta-kegiatan-kelompok.page.component';
import { PcareProviderRayonisasiPageComponent } from 'src/app/pages/pcare-provider-rayonisasi/pcare-provider-rayonisasi.page.component';
import { PcareStatusPulangPageComponent } from 'src/app/pages/pcare-status-pulang/pcare-status-pulang.page.component';
import { PcareTindakanPageComponent } from 'src/app/pages/pcare-tindakan/pcare-tindakan.page.component';
import { PcareTindakanKunjunganPageComponent } from 'src/app/pages/pcare-tindakan-kunjungan/pcare-tindakan-kunjungan.page.component';
import { PcareUmumPageComponent } from 'src/app/pages/pcare-umum/pcare-umum.page.component';
import { PatientBillingPageComponent } from 'src/app/pages/patient-billing/patient-billing.page.component';
import { PatientConfigurationPageComponent } from 'src/app/pages/patient-configuration/patient-configuration.page.component';
import { PatientDetailPageComponent } from 'src/app/pages/patient-detail/patient-detail.page.component';
import { PatientInvoicePageComponent } from 'src/app/pages/patient-invoice/patient-invoice.page.component';
import { PatientInvoiceDetailPageComponent } from 'src/app/pages/patient-invoice-detail/patient-invoice-detail.page.component';
import { PatientInvoiceItemDetailPageComponent } from 'src/app/pages/patient-invoice-item-detail/patient-invoice-item-detail.page.component';
import { PatientProfilePageComponent } from 'src/app/pages/patient-profile/patient-profile.page.component';
import { PatientReceiptPageComponent } from 'src/app/pages/patient-receipt/patient-receipt.page.component';
import { PatientReceiptDetailPageComponent } from 'src/app/pages/patient-receipt-detail/patient-receipt-detail.page.component';
import { PatientReceiptSetupPageComponent } from 'src/app/pages/patient-receipt-setup/patient-receipt-setup.page.component';
import { PatientRefundPageComponent } from 'src/app/pages/patient-refund/patient-refund.page.component';
import { PatientRefundSetupPageComponent } from 'src/app/pages/patient-refund-setup/patient-refund-setup.page.component';
import { PatientVitalInformationPageComponent } from 'src/app/pages/patient-vital-information/patient-vital-information.page.component';
import { PaymentMethodReportPageComponent } from 'src/app/pages/payment-method-report/payment-method-report.page.component';
import { PcareObatPageComponent } from 'src/app/pages/pcare-obat/pcare-obat.page.component';
import { PcarePoliPageComponent } from 'src/app/pages/pcare-poli/pcare-poli.page.component';
import { PcareReferensiSaranaPageComponent } from 'src/app/pages/pcare-referensi-sarana/pcare-referensi-sarana.page.component';
import { PerinatologyServiceActivityReportPageComponent } from 'src/app/pages/perinatology-service-activity-report/perinatology-service-activity-report.page.component';
import { PersonalizationPageComponent } from 'src/app/pages/personalization/personalization.page.component';
import { PharmacyPageComponent } from 'src/app/pages/pharmacy/pharmacy.page.component';
import { PharmacyConfigurationPageComponent } from 'src/app/pages/pharmacy-configuration/pharmacy-configuration.page.component';
import { PharmacyItemDetailReportPageComponent } from 'src/app/pages/pharmacy-item-detail-report/pharmacy-item-detail-report.page.component';
import { PharmacyReportPageComponent } from 'src/app/pages/pharmacy-report/pharmacy-report.page.component';
import { PostoperativeDetailsPageComponent } from 'src/app/pages/postoperative-details/postoperative-details.page.component';
import { PreoperativeRecordsPageComponent } from 'src/app/pages/preoperative-records/preoperative-records.page.component';
import { PrescriptionDetailPageComponent } from 'src/app/pages/prescription-detail/prescription-detail.page.component';
import { PrescriptionDispensingPageComponent } from 'src/app/pages/prescription-dispensing/prescription-dispensing.page.component';
import { PriceComponentPageComponent } from 'src/app/pages/price-component/price-component.page.component';
import { ProcessWorkflowPageComponent } from 'src/app/pages/process-workflow/process-workflow.page.component';
import { PsychiatryServiceActivityReportPageComponent } from 'src/app/pages/psychiatry-service-activity-report/psychiatry-service-activity-report.page.component';
import { PurchaseOrderPageComponent } from 'src/app/pages/purchase-order/purchase-order.page.component';
import { PurchaseOrderStockDetailPageComponent } from 'src/app/pages/purchase-order-stock-detail/purchase-order-stock-detail.page.component';
import { PurchaseRequisitionPageComponent } from 'src/app/pages/purchase-requisition/purchase-requisition.page.component';
import { PurchaseRequisitionStockDetailPageComponent } from 'src/app/pages/purchase-requisition-stock-detail/purchase-requisition-stock-detail.page.component';
import { PurchasingPageComponent } from 'src/app/pages/purchasing/purchasing.page.component';
import { RadiologyServiceActivityReportPageComponent } from 'src/app/pages/radiology-service-activity-report/radiology-service-activity-report.page.component';
import { ReferencePageComponent } from 'src/app/pages/reference/reference.page.component';
import { ReferenceDataPageComponent } from 'src/app/pages/reference-data/reference-data.page.component';
import { ReferenceDataDetailPageComponent } from 'src/app/pages/reference-data-detail/reference-data-detail.page.component';
import { ReferenceHeaderPageComponent } from 'src/app/pages/reference-header/reference-header.page.component';
import { ReferenceHeaderDetailPageComponent } from 'src/app/pages/reference-header-detail/reference-header-detail.page.component';
import { ReferralActivityReportPageComponent } from 'src/app/pages/referral-activity-report/referral-activity-report.page.component';
import { RefundDetailReportPageComponent } from 'src/app/pages/refund-detail-report/refund-detail-report.page.component';
import { RegistrationPageComponent } from 'src/app/pages/registration/registration.page.component';
import { RegistrationConfigurationPageComponent } from 'src/app/pages/registration-configuration/registration-configuration.page.component';
import { RegistrationReportPageComponent } from 'src/app/pages/registration-report/registration-report.page.component';
import { ReportLogoPageComponent } from 'src/app/pages/report-logo/report-logo.page.component';
import { RequestOrderPageComponent } from 'src/app/pages/request-order/request-order.page.component';
import { RetailPharmacyPageComponent } from 'src/app/pages/retail-pharmacy/retail-pharmacy.page.component';
import { RetailPharmacyInvoicePageComponent } from 'src/app/pages/retail-pharmacy-invoice/retail-pharmacy-invoice.page.component';
import { RetailPharmacyStockDetailPageComponent } from 'src/app/pages/retail-pharmacy-stock-detail/retail-pharmacy-stock-detail.page.component';
import { ReturnSupplierPageComponent } from 'src/app/pages/return-supplier/return-supplier.page.component';
import { ReturnSupplierStockDetailPageComponent } from 'src/app/pages/return-supplier-stock-detail/return-supplier-stock-detail.page.component';
import { RoomPageComponent } from 'src/app/pages/room/room.page.component';
import { SampleCollectionInformationPageComponent } from 'src/app/pages/sample-collection-information/sample-collection-information.page.component';
import { SampleCollectionItemsPageComponent } from 'src/app/pages/sample-collection-items/sample-collection-items.page.component';
import { SatuSehatPageComponent } from 'src/app/pages/satu-sehat/satu-sehat.page.component';
import { SatuSehatConfigurationPageComponent } from 'src/app/pages/satu-sehat-configuration/satu-sehat-configuration.page.component';
import { SatuSehatGeneralPageComponent } from 'src/app/pages/satu-sehat-general/satu-sehat-general.page.component';
import { ServicePageComponent } from 'src/app/pages/service/service.page.component';
import { ServiceDetailPageComponent } from 'src/app/pages/service-detail/service-detail.page.component';
import { ServiceFacilityCategoryPageComponent } from 'src/app/pages/service-facility-category/service-facility-category.page.component';
import { ServiceItemPageComponent } from 'src/app/pages/service-item/service-item.page.component';
import { ServiceItemAssignmentPageComponent } from 'src/app/pages/service-item-assignment/service-item-assignment.page.component';
import { ServiceItemWrapperPageComponent } from 'src/app/pages/service-item-wrapper/service-item-wrapper.page.component';
import { SettlementReportPageComponent } from 'src/app/pages/settlement-report/settlement-report.page.component';
import { SpecialServiceActivityReportPageComponent } from 'src/app/pages/special-service-activity-report/special-service-activity-report.page.component';
import { StaffSchedulePageComponent } from 'src/app/pages/staff-schedule/staff-schedule.page.component';
import { StaffAndUserPageComponent } from 'src/app/pages/staff-and-user/staff-and-user.page.component';
import { StockExpirationBalanceReportPageComponent } from 'src/app/pages/stock-expiration-balance-report/stock-expiration-balance-report.page.component';
import { StockExpirationTransactionDetailReportPageComponent } from 'src/app/pages/stock-expiration-transaction-detail-report/stock-expiration-transaction-detail-report.page.component';
import { StockMutationReportPageComponent } from 'src/app/pages/stock-mutation-report/stock-mutation-report.page.component';
import { StockSummaryReportPageComponent } from 'src/app/pages/stock-summary-report/stock-summary-report.page.component';
import { StockTransactionDetailReportPageComponent } from 'src/app/pages/stock-transaction-detail-report/stock-transaction-detail-report.page.component';
import { SupplierPageComponent } from 'src/app/pages/supplier/supplier.page.component';
import { SupplierProductDetailPageComponent } from 'src/app/pages/supplier-product-detail/supplier-product-detail.page.component';
import { SupplierWrapperPageComponent } from 'src/app/pages/supplier-wrapper/supplier-wrapper.page.component';
import { SystemConfigurationPageComponent } from 'src/app/pages/system-configuration/system-configuration.page.component';
import { TariffBillingConfigurationPageComponent } from 'src/app/pages/tariff-billing-configuration/tariff-billing-configuration.page.component';
import { TariffDefinitionPageComponent } from 'src/app/pages/tariff-definition/tariff-definition.page.component';
import { TariffFormulaPageComponent } from 'src/app/pages/tariff-formula/tariff-formula.page.component';
import { TariffManagementPageComponent } from 'src/app/pages/tariff-management/tariff-management.page.component';
import { TariffSchemePageComponent } from 'src/app/pages/tariff-scheme/tariff-scheme.page.component';
import { TaskDashboardPageComponent } from 'src/app/pages/task-dashboard/task-dashboard.page.component';
import { TopDiseaseReportPageComponent } from 'src/app/pages/top-disease-report/top-disease-report.page.component';
import { TransactionDetailTypePageComponent } from 'src/app/pages/transaction-detail-type/transaction-detail-type.page.component';
import { TransferOrderPageComponent } from 'src/app/pages/transfer-order/transfer-order.page.component';
import { TransferOrderStockDetailPageComponent } from 'src/app/pages/transfer-order-stock-detail/transfer-order-stock-detail.page.component';
import { VaccinationOrderPageComponent } from 'src/app/pages/vaccination-order/vaccination-order.page.component';
import { VaccinationOrderDetailPageComponent } from 'src/app/pages/vaccination-order-detail/vaccination-order-detail.page.component';
import { VitalSignsPageComponent } from 'src/app/pages/vital-signs/vital-signs.page.component';
import { WarehousePageComponent } from 'src/app/pages/warehouse/warehouse.page.component';
import { WarehouseInventoryPageComponent } from 'src/app/pages/warehouse-inventory/warehouse-inventory.page.component';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end


export const frontendRoutes: Routes = [
	{
		path: '',
		component: FrontendComponent,
		canActivate: [
			RoleGuard,
			// % protected region % [Add any extra guards for default page here] off begin
			// % protected region % [Add any extra guards for default page here] end
		],
		data: {
			expectedRoles: [
				'MANAGEMENT_USER',
				'NURSE_USER',
				'DIAGNOSTIC_SUPPORT_USER',
				'CASHIER_USER',
				'PURCHASING_USER',
				'WAREHOUSE_USER',
				'REGISTRATION_USER',
				'ADMINISTRATOR',
				'CLAIM_USER',
				'ADMINISTRATION_USER',
				'SYSTEM_ADMIN_USER',
				'MEDICAL_TRANSCRIBER_USER',
				'DOCTOR_USER',
				'PHARMACY_USER',
				'MEDICAL_RECORD_USER',
				'FACILITY_USER',
				// % protected region % [Add additional roles for default page here] off begin
				// % protected region % [Add additional roles for default page here] end
			],
			// % protected region % [Customise the data passed to default page here] off begin
			// % protected region % [Customise the data passed to default page here] end
		},
		children: [
			// Admin Crud tile for user and entities
			{
				path: '',
				pathMatch: 'full',
				redirectTo: 'kms-home',
			},
			{
				path: 'accident-and-emergency',
				loadChildren: () => import('../pages/accident-and-emergency/accident-and-emergency.page.module').then(m => m.AccidentAndEmergencyPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Accident and Emergency here] off begin
					// % protected region % [Add any additional guards for Accident and Emergency here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Accident and Emergency here] off begin
						// % protected region % [Add additional roles to Accident and Emergency here] end
					],
					// % protected region % [Customise your data passed to Accident and Emergency here] off begin
					// % protected region % [Customise your data passed to Accident and Emergency here] end
				},
				// % protected region % [Add additional route properties here for accident-and-emergency] off begin
				// % protected region % [Add additional route properties here for accident-and-emergency] end
			},
			{
				path: 'account-configuration',
				loadChildren: () => import('../pages/account-configuration/account-configuration.page.module').then(m => m.AccountConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Account Configuration here] off begin
					// % protected region % [Add any additional guards for Account Configuration here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Account Configuration here] off begin
						// % protected region % [Add additional roles to Account Configuration here] end
					],
					// % protected region % [Customise your data passed to Account Configuration here] off begin
					// % protected region % [Customise your data passed to Account Configuration here] end
				},
				// % protected region % [Add additional route properties here for account-configuration] off begin
				// % protected region % [Add additional route properties here for account-configuration] end
			},
			{
				path: 'amendment-detail',
				loadChildren: () => import('../pages/amendment-detail/amendment-detail.page.module').then(m => m.AmendmentDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Amendment Detail here] off begin
					// % protected region % [Add any additional guards for Amendment Detail here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Amendment Detail here] off begin
						// % protected region % [Add additional roles to Amendment Detail here] end
					],
					// % protected region % [Customise your data passed to Amendment Detail here] off begin
					// % protected region % [Customise your data passed to Amendment Detail here] end
				},
				// % protected region % [Add additional route properties here for amendment-detail] off begin
				// % protected region % [Add additional route properties here for amendment-detail] end
			},
			{
				path: 'analytics',
				loadChildren: () => import('../pages/analytics/analytics.page.module').then(m => m.AnalyticsPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Analytics here] off begin
					// % protected region % [Add any additional guards for Analytics here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Analytics here] off begin
						// % protected region % [Add additional roles to Analytics here] end
					],
					// % protected region % [Customise your data passed to Analytics here] off begin
					// % protected region % [Customise your data passed to Analytics here] end
				},
				// % protected region % [Add additional route properties here for analytics] off begin
				// % protected region % [Add additional route properties here for analytics] end
			},
			{
				path: 'application-logo',
				loadChildren: () => import('../pages/application-logo/application-logo.page.module').then(m => m.ApplicationLogoPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Application Logo here] off begin
					// % protected region % [Add any additional guards for Application Logo here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Application Logo here] off begin
						// % protected region % [Add additional roles to Application Logo here] end
					],
					// % protected region % [Customise your data passed to Application Logo here] off begin
					// % protected region % [Customise your data passed to Application Logo here] end
				},
				// % protected region % [Add additional route properties here for application-logo] off begin
				// % protected region % [Add additional route properties here for application-logo] end
			},
			{
				path: 'bpjs-total-referral-sep',
				loadChildren: () => import('../pages/bpjs-total-referral-sep/bpjs-total-referral-sep.page.module').then(m => m.BpjsTotalReferralSEPPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS  Total Referral SEP here] off begin
					// % protected region % [Add any additional guards for BPJS  Total Referral SEP here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to BPJS  Total Referral SEP here] off begin
						// % protected region % [Add additional roles to BPJS  Total Referral SEP here] end
					],
					// % protected region % [Customise your data passed to BPJS  Total Referral SEP here] off begin
					// % protected region % [Customise your data passed to BPJS  Total Referral SEP here] end
				},
				// % protected region % [Add additional route properties here for bpjs-total-referral-sep] off begin
				// % protected region % [Add additional route properties here for bpjs-total-referral-sep] end
			},
			{
				path: 'bpjs-accident-master-data',
				loadChildren: () => import('../pages/bpjs-accident-master-data/bpjs-accident-master-data.page.module').then(m => m.BpjsAccidentMasterDataPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Accident Master Data here] off begin
					// % protected region % [Add any additional guards for BPJS Accident Master Data here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to BPJS Accident Master Data here] off begin
						// % protected region % [Add additional roles to BPJS Accident Master Data here] end
					],
					// % protected region % [Customise your data passed to BPJS Accident Master Data here] off begin
					// % protected region % [Customise your data passed to BPJS Accident Master Data here] end
				},
				// % protected region % [Add additional route properties here for bpjs-accident-master-data] off begin
				// % protected region % [Add additional route properties here for bpjs-accident-master-data] end
			},
			{
				path: 'bpjs-bed-availability',
				loadChildren: () => import('../pages/bpjs-bed-availability/bpjs-bed-availability.page.module').then(m => m.BpjsBedAvailabilityPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Bed Availability here] off begin
					// % protected region % [Add any additional guards for BPJS Bed Availability here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to BPJS Bed Availability here] off begin
						// % protected region % [Add additional roles to BPJS Bed Availability here] end
					],
					// % protected region % [Customise your data passed to BPJS Bed Availability here] off begin
					// % protected region % [Customise your data passed to BPJS Bed Availability here] end
				},
				// % protected region % [Add additional route properties here for bpjs-bed-availability] off begin
				// % protected region % [Add additional route properties here for bpjs-bed-availability] end
			},
			{
				path: 'bpjs-claim-data',
				loadChildren: () => import('../pages/bpjs-claim-data/bpjs-claim-data.page.module').then(m => m.BpjsClaimDataPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Claim Data here] off begin
					// % protected region % [Add any additional guards for BPJS Claim Data here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to BPJS Claim Data here] off begin
						// % protected region % [Add additional roles to BPJS Claim Data here] end
					],
					// % protected region % [Customise your data passed to BPJS Claim Data here] off begin
					// % protected region % [Customise your data passed to BPJS Claim Data here] end
				},
				// % protected region % [Add additional route properties here for bpjs-claim-data] off begin
				// % protected region % [Add additional route properties here for bpjs-claim-data] end
			},
			{
				path: 'bpjs-claim-submission',
				loadChildren: () => import('../pages/bpjs-claim-submission/bpjs-claim-submission.page.module').then(m => m.BpjsClaimSubmissionPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Claim Submission here] off begin
					// % protected region % [Add any additional guards for BPJS Claim Submission here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to BPJS Claim Submission here] off begin
						// % protected region % [Add additional roles to BPJS Claim Submission here] end
					],
					// % protected region % [Customise your data passed to BPJS Claim Submission here] off begin
					// % protected region % [Customise your data passed to BPJS Claim Submission here] end
				},
				// % protected region % [Add additional route properties here for bpjs-claim-submission] off begin
				// % protected region % [Add additional route properties here for bpjs-claim-submission] end
			},
			{
				path: 'bpjs-configuration',
				loadChildren: () => import('../pages/bpjs-configuration/bpjs-configuration.page.module').then(m => m.BpjsConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Configuration here] off begin
					// % protected region % [Add any additional guards for BPJS Configuration here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to BPJS Configuration here] off begin
						// % protected region % [Add additional roles to BPJS Configuration here] end
					],
					// % protected region % [Customise your data passed to BPJS Configuration here] off begin
					// % protected region % [Customise your data passed to BPJS Configuration here] end
				},
				// % protected region % [Add additional route properties here for bpjs-configuration] off begin
				// % protected region % [Add additional route properties here for bpjs-configuration] end
			},
			{
				path: 'bpjs-control-plan',
				loadChildren: () => import('../pages/bpjs-control-plan/bpjs-control-plan.page.module').then(m => m.BpjsControlPlanPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Control Plan here] off begin
					// % protected region % [Add any additional guards for BPJS Control Plan here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to BPJS Control Plan here] off begin
						// % protected region % [Add additional roles to BPJS Control Plan here] end
					],
					// % protected region % [Customise your data passed to BPJS Control Plan here] off begin
					// % protected region % [Customise your data passed to BPJS Control Plan here] end
				},
				// % protected region % [Add additional route properties here for bpjs-control-plan] off begin
				// % protected region % [Add additional route properties here for bpjs-control-plan] end
			},
			{
				path: 'bpjs-control-plan-wrapper',
				loadChildren: () => import('../pages/bpjs-control-plan-wrapper/bpjs-control-plan-wrapper.page.module').then(m => m.BpjsControlPlanWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Control Plan Wrapper here] off begin
					// % protected region % [Add any additional guards for BPJS Control Plan Wrapper here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to BPJS Control Plan Wrapper here] off begin
						// % protected region % [Add additional roles to BPJS Control Plan Wrapper here] end
					],
					// % protected region % [Customise your data passed to BPJS Control Plan Wrapper here] off begin
					// % protected region % [Customise your data passed to BPJS Control Plan Wrapper here] end
				},
				// % protected region % [Add additional route properties here for bpjs-control-plan-wrapper] off begin
				// % protected region % [Add additional route properties here for bpjs-control-plan-wrapper] end
			},
			{
				path: 'bpjs-control-specialist',
				loadChildren: () => import('../pages/bpjs-control-specialist/bpjs-control-specialist.page.module').then(m => m.BpjsControlSpecialistPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Control Specialist here] off begin
					// % protected region % [Add any additional guards for BPJS Control Specialist here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to BPJS Control Specialist here] off begin
						// % protected region % [Add additional roles to BPJS Control Specialist here] end
					],
					// % protected region % [Customise your data passed to BPJS Control Specialist here] off begin
					// % protected region % [Customise your data passed to BPJS Control Specialist here] end
				},
				// % protected region % [Add additional route properties here for bpjs-control-specialist] off begin
				// % protected region % [Add additional route properties here for bpjs-control-specialist] end
			},
			{
				path: 'bpjs-diagnose',
				loadChildren: () => import('../pages/bpjs-diagnose/bpjs-diagnose.page.module').then(m => m.BpjsDiagnosePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Diagnose here] off begin
					// % protected region % [Add any additional guards for BPJS Diagnose here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to BPJS Diagnose here] off begin
						// % protected region % [Add additional roles to BPJS Diagnose here] end
					],
					// % protected region % [Customise your data passed to BPJS Diagnose here] off begin
					// % protected region % [Customise your data passed to BPJS Diagnose here] end
				},
				// % protected region % [Add additional route properties here for bpjs-diagnose] off begin
				// % protected region % [Add additional route properties here for bpjs-diagnose] end
			},
			{
				path: 'bpjs-diagnose-prb',
				loadChildren: () => import('../pages/bpjs-diagnose-prb/bpjs-diagnose-prb.page.module').then(m => m.BpjsDiagnosePRBPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Diagnose PRB here] off begin
					// % protected region % [Add any additional guards for BPJS Diagnose PRB here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to BPJS Diagnose PRB here] off begin
						// % protected region % [Add additional roles to BPJS Diagnose PRB here] end
					],
					// % protected region % [Customise your data passed to BPJS Diagnose PRB here] off begin
					// % protected region % [Customise your data passed to BPJS Diagnose PRB here] end
				},
				// % protected region % [Add additional route properties here for bpjs-diagnose-prb] off begin
				// % protected region % [Add additional route properties here for bpjs-diagnose-prb] end
			},
			{
				path: 'bpjs-dismisal',
				loadChildren: () => import('../pages/bpjs-dismisal/bpjs-dismisal.page.module').then(m => m.BpjsDismisalPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Dismisal here] off begin
					// % protected region % [Add any additional guards for BPJS Dismisal here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to BPJS Dismisal here] off begin
						// % protected region % [Add additional roles to BPJS Dismisal here] end
					],
					// % protected region % [Customise your data passed to BPJS Dismisal here] off begin
					// % protected region % [Customise your data passed to BPJS Dismisal here] end
				},
				// % protected region % [Add additional route properties here for bpjs-dismisal] off begin
				// % protected region % [Add additional route properties here for bpjs-dismisal] end
			},
			{
				path: 'bpjs-dismissal-mapping',
				loadChildren: () => import('../pages/bpjs-dismissal-mapping/bpjs-dismissal-mapping.page.module').then(m => m.BpjsDismissalMappingPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Dismissal Mapping here] off begin
					// % protected region % [Add any additional guards for BPJS Dismissal Mapping here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to BPJS Dismissal Mapping here] off begin
						// % protected region % [Add additional roles to BPJS Dismissal Mapping here] end
					],
					// % protected region % [Customise your data passed to BPJS Dismissal Mapping here] off begin
					// % protected region % [Customise your data passed to BPJS Dismissal Mapping here] end
				},
				// % protected region % [Add additional route properties here for bpjs-dismissal-mapping] off begin
				// % protected region % [Add additional route properties here for bpjs-dismissal-mapping] end
			},
			{
				path: 'bpjs-doctor-mapping',
				loadChildren: () => import('../pages/bpjs-doctor-mapping/bpjs-doctor-mapping.page.module').then(m => m.BpjsDoctorMappingPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Doctor Mapping here] off begin
					// % protected region % [Add any additional guards for BPJS Doctor Mapping here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to BPJS Doctor Mapping here] off begin
						// % protected region % [Add additional roles to BPJS Doctor Mapping here] end
					],
					// % protected region % [Customise your data passed to BPJS Doctor Mapping here] off begin
					// % protected region % [Customise your data passed to BPJS Doctor Mapping here] end
				},
				// % protected region % [Add additional route properties here for bpjs-doctor-mapping] off begin
				// % protected region % [Add additional route properties here for bpjs-doctor-mapping] end
			},
			{
				path: 'bpjs-doctor-schedule',
				loadChildren: () => import('../pages/bpjs-doctor-schedule/bpjs-doctor-schedule.page.module').then(m => m.BpjsDoctorSchedulePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Doctor Schedule here] off begin
					// % protected region % [Add any additional guards for BPJS Doctor Schedule here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to BPJS Doctor Schedule here] off begin
						// % protected region % [Add additional roles to BPJS Doctor Schedule here] end
					],
					// % protected region % [Customise your data passed to BPJS Doctor Schedule here] off begin
					// % protected region % [Customise your data passed to BPJS Doctor Schedule here] end
				},
				// % protected region % [Add additional route properties here for bpjs-doctor-schedule] off begin
				// % protected region % [Add additional route properties here for bpjs-doctor-schedule] end
			},
			{
				path: 'bpjs-drug-generic-prb',
				loadChildren: () => import('../pages/bpjs-drug-generic-prb/bpjs-drug-generic-prb.page.module').then(m => m.BpjsDrugGenericPRBPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Drug Generic PRB here] off begin
					// % protected region % [Add any additional guards for BPJS Drug Generic PRB here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to BPJS Drug Generic PRB here] off begin
						// % protected region % [Add additional roles to BPJS Drug Generic PRB here] end
					],
					// % protected region % [Customise your data passed to BPJS Drug Generic PRB here] off begin
					// % protected region % [Customise your data passed to BPJS Drug Generic PRB here] end
				},
				// % protected region % [Add additional route properties here for bpjs-drug-generic-prb] off begin
				// % protected region % [Add additional route properties here for bpjs-drug-generic-prb] end
			},
			{
				path: 'bpjs-facility-list',
				loadChildren: () => import('../pages/bpjs-facility-list/bpjs-facility-list.page.module').then(m => m.BpjsFacilityListPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Facility List here] off begin
					// % protected region % [Add any additional guards for BPJS Facility List here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to BPJS Facility List here] off begin
						// % protected region % [Add additional roles to BPJS Facility List here] end
					],
					// % protected region % [Customise your data passed to BPJS Facility List here] off begin
					// % protected region % [Customise your data passed to BPJS Facility List here] end
				},
				// % protected region % [Add additional route properties here for bpjs-facility-list] off begin
				// % protected region % [Add additional route properties here for bpjs-facility-list] end
			},
			{
				path: 'bpjs-finger-print',
				loadChildren: () => import('../pages/bpjs-finger-print/bpjs-finger-print.page.module').then(m => m.BpjsFingerPrintPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Finger Print here] off begin
					// % protected region % [Add any additional guards for BPJS Finger Print here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to BPJS Finger Print here] off begin
						// % protected region % [Add additional roles to BPJS Finger Print here] end
					],
					// % protected region % [Customise your data passed to BPJS Finger Print here] off begin
					// % protected region % [Customise your data passed to BPJS Finger Print here] end
				},
				// % protected region % [Add additional route properties here for bpjs-finger-print] off begin
				// % protected region % [Add additional route properties here for bpjs-finger-print] end
			},
			{
				path: 'bpjs-general',
				loadChildren: () => import('../pages/bpjs-general/bpjs-general.page.module').then(m => m.BpjsGeneralPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS General here] off begin
					// % protected region % [Add any additional guards for BPJS General here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to BPJS General here] off begin
						// % protected region % [Add additional roles to BPJS General here] end
					],
					// % protected region % [Customise your data passed to BPJS General here] off begin
					// % protected region % [Customise your data passed to BPJS General here] end
				},
				// % protected region % [Add additional route properties here for bpjs-general] off begin
				// % protected region % [Add additional route properties here for bpjs-general] end
			},
			{
				path: 'bpjs-get-finger-print',
				loadChildren: () => import('../pages/bpjs-get-finger-print/bpjs-get-finger-print.page.module').then(m => m.BpjsGetFingerPrintPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Get Finger Print here] off begin
					// % protected region % [Add any additional guards for BPJS Get Finger Print here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to BPJS Get Finger Print here] off begin
						// % protected region % [Add additional roles to BPJS Get Finger Print here] end
					],
					// % protected region % [Customise your data passed to BPJS Get Finger Print here] off begin
					// % protected region % [Customise your data passed to BPJS Get Finger Print here] end
				},
				// % protected region % [Add additional route properties here for bpjs-get-finger-print] off begin
				// % protected region % [Add additional route properties here for bpjs-get-finger-print] end
			},
			{
				path: 'bpjs-health-facility',
				loadChildren: () => import('../pages/bpjs-health-facility/bpjs-health-facility.page.module').then(m => m.BpjsHealthFacilityPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Health Facility here] off begin
					// % protected region % [Add any additional guards for BPJS Health Facility here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to BPJS Health Facility here] off begin
						// % protected region % [Add additional roles to BPJS Health Facility here] end
					],
					// % protected region % [Customise your data passed to BPJS Health Facility here] off begin
					// % protected region % [Customise your data passed to BPJS Health Facility here] end
				},
				// % protected region % [Add additional route properties here for bpjs-health-facility] off begin
				// % protected region % [Add additional route properties here for bpjs-health-facility] end
			},
			{
				path: 'bpjs-hospitalization-plan',
				loadChildren: () => import('../pages/bpjs-hospitalization-plan/bpjs-hospitalization-plan.page.module').then(m => m.BpjsHospitalizationPlanPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Hospitalization Plan here] off begin
					// % protected region % [Add any additional guards for BPJS Hospitalization Plan here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to BPJS Hospitalization Plan here] off begin
						// % protected region % [Add additional roles to BPJS Hospitalization Plan here] end
					],
					// % protected region % [Customise your data passed to BPJS Hospitalization Plan here] off begin
					// % protected region % [Customise your data passed to BPJS Hospitalization Plan here] end
				},
				// % protected region % [Add additional route properties here for bpjs-hospitalization-plan] off begin
				// % protected region % [Add additional route properties here for bpjs-hospitalization-plan] end
			},
			{
				path: 'bpjs-inacbg',
				loadChildren: () => import('../pages/bpjs-inacbg/bpjs-inacbg.page.module').then(m => m.BpjsINACBGPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS INACBG here] off begin
					// % protected region % [Add any additional guards for BPJS INACBG here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to BPJS INACBG here] off begin
						// % protected region % [Add additional roles to BPJS INACBG here] end
					],
					// % protected region % [Customise your data passed to BPJS INACBG here] off begin
					// % protected region % [Customise your data passed to BPJS INACBG here] end
				},
				// % protected region % [Add additional route properties here for bpjs-inacbg] off begin
				// % protected region % [Add additional route properties here for bpjs-inacbg] end
			},
			{
				path: 'bpjs-inacbg-variables',
				loadChildren: () => import('../pages/bpjs-inacbg-variables/bpjs-inacbg-variables.page.module').then(m => m.BpjsINACBGVariablesPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS INACBG Variables here] off begin
					// % protected region % [Add any additional guards for BPJS INACBG Variables here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to BPJS INACBG Variables here] off begin
						// % protected region % [Add additional roles to BPJS INACBG Variables here] end
					],
					// % protected region % [Customise your data passed to BPJS INACBG Variables here] off begin
					// % protected region % [Customise your data passed to BPJS INACBG Variables here] end
				},
				// % protected region % [Add additional route properties here for bpjs-inacbg-variables] off begin
				// % protected region % [Add additional route properties here for bpjs-inacbg-variables] end
			},
			{
				path: 'bpjs-jasa-raharja',
				loadChildren: () => import('../pages/bpjs-jasa-raharja/bpjs-jasa-raharja.page.module').then(m => m.BpjsJasaRaharjaPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Jasa Raharja here] off begin
					// % protected region % [Add any additional guards for BPJS Jasa Raharja here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to BPJS Jasa Raharja here] off begin
						// % protected region % [Add additional roles to BPJS Jasa Raharja here] end
					],
					// % protected region % [Customise your data passed to BPJS Jasa Raharja here] off begin
					// % protected region % [Customise your data passed to BPJS Jasa Raharja here] end
				},
				// % protected region % [Add additional route properties here for bpjs-jasa-raharja] off begin
				// % protected region % [Add additional route properties here for bpjs-jasa-raharja] end
			},
			{
				path: 'bpjs-jasa-raharja-claim',
				loadChildren: () => import('../pages/bpjs-jasa-raharja-claim/bpjs-jasa-raharja-claim.page.module').then(m => m.BpjsJasaRaharjaClaimPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Jasa Raharja Claim here] off begin
					// % protected region % [Add any additional guards for BPJS Jasa Raharja Claim here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to BPJS Jasa Raharja Claim here] off begin
						// % protected region % [Add additional roles to BPJS Jasa Raharja Claim here] end
					],
					// % protected region % [Customise your data passed to BPJS Jasa Raharja Claim here] off begin
					// % protected region % [Customise your data passed to BPJS Jasa Raharja Claim here] end
				},
				// % protected region % [Add additional route properties here for bpjs-jasa-raharja-claim] off begin
				// % protected region % [Add additional route properties here for bpjs-jasa-raharja-claim] end
			},
			{
				path: 'bpjs-jasa-raharja-detail',
				loadChildren: () => import('../pages/bpjs-jasa-raharja-detail/bpjs-jasa-raharja-detail.page.module').then(m => m.BpjsJasaRaharjaDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Jasa Raharja Detail here] off begin
					// % protected region % [Add any additional guards for BPJS Jasa Raharja Detail here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to BPJS Jasa Raharja Detail here] off begin
						// % protected region % [Add additional roles to BPJS Jasa Raharja Detail here] end
					],
					// % protected region % [Customise your data passed to BPJS Jasa Raharja Detail here] off begin
					// % protected region % [Customise your data passed to BPJS Jasa Raharja Detail here] end
				},
				// % protected region % [Add additional route properties here for bpjs-jasa-raharja-detail] off begin
				// % protected region % [Add additional route properties here for bpjs-jasa-raharja-detail] end
			},
			{
				path: 'bpjs-list-finger-print',
				loadChildren: () => import('../pages/bpjs-list-finger-print/bpjs-list-finger-print.page.module').then(m => m.BpjsListFingerPrintPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS List Finger Print here] off begin
					// % protected region % [Add any additional guards for BPJS List Finger Print here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to BPJS List Finger Print here] off begin
						// % protected region % [Add additional roles to BPJS List Finger Print here] end
					],
					// % protected region % [Customise your data passed to BPJS List Finger Print here] off begin
					// % protected region % [Customise your data passed to BPJS List Finger Print here] end
				},
				// % protected region % [Add additional route properties here for bpjs-list-finger-print] off begin
				// % protected region % [Add additional route properties here for bpjs-list-finger-print] end
			},
			{
				path: 'bpjs-monitoring',
				loadChildren: () => import('../pages/bpjs-monitoring/bpjs-monitoring.page.module').then(m => m.BpjsMonitoringPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Monitoring here] off begin
					// % protected region % [Add any additional guards for BPJS Monitoring here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to BPJS Monitoring here] off begin
						// % protected region % [Add additional roles to BPJS Monitoring here] end
					],
					// % protected region % [Customise your data passed to BPJS Monitoring here] off begin
					// % protected region % [Customise your data passed to BPJS Monitoring here] end
				},
				// % protected region % [Add additional route properties here for bpjs-monitoring] off begin
				// % protected region % [Add additional route properties here for bpjs-monitoring] end
			},
			{
				path: 'bpjs-outside-facility-referral',
				loadChildren: () => import('../pages/bpjs-outside-facility-referral/bpjs-outside-facility-referral.page.module').then(m => m.BpjsOutsideFacilityReferralPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Outside Facility Referral here] off begin
					// % protected region % [Add any additional guards for BPJS Outside Facility Referral here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to BPJS Outside Facility Referral here] off begin
						// % protected region % [Add additional roles to BPJS Outside Facility Referral here] end
					],
					// % protected region % [Customise your data passed to BPJS Outside Facility Referral here] off begin
					// % protected region % [Customise your data passed to BPJS Outside Facility Referral here] end
				},
				// % protected region % [Add additional route properties here for bpjs-outside-facility-referral] off begin
				// % protected region % [Add additional route properties here for bpjs-outside-facility-referral] end
			},
			{
				path: 'bpjs-patient-referral',
				loadChildren: () => import('../pages/bpjs-patient-referral/bpjs-patient-referral.page.module').then(m => m.BpjsPatientReferralPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Patient Referral here] off begin
					// % protected region % [Add any additional guards for BPJS Patient Referral here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						// % protected region % [Add additional roles to BPJS Patient Referral here] off begin
						// % protected region % [Add additional roles to BPJS Patient Referral here] end
					],
					// % protected region % [Customise your data passed to BPJS Patient Referral here] off begin
					// % protected region % [Customise your data passed to BPJS Patient Referral here] end
				},
				// % protected region % [Add additional route properties here for bpjs-patient-referral] off begin
				// % protected region % [Add additional route properties here for bpjs-patient-referral] end
			},
			{
				path: 'bpjs-patient-referral-detail',
				loadChildren: () => import('../pages/bpjs-patient-referral-detail/bpjs-patient-referral-detail.page.module').then(m => m.BpjsPatientReferralDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Patient Referral Detail here] off begin
					// % protected region % [Add any additional guards for BPJS Patient Referral Detail here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to BPJS Patient Referral Detail here] off begin
						// % protected region % [Add additional roles to BPJS Patient Referral Detail here] end
					],
					// % protected region % [Customise your data passed to BPJS Patient Referral Detail here] off begin
					// % protected region % [Customise your data passed to BPJS Patient Referral Detail here] end
				},
				// % protected region % [Add additional route properties here for bpjs-patient-referral-detail] off begin
				// % protected region % [Add additional route properties here for bpjs-patient-referral-detail] end
			},
			{
				path: 'bpjs-procedure',
				loadChildren: () => import('../pages/bpjs-procedure/bpjs-procedure.page.module').then(m => m.BpjsProcedurePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Procedure here] off begin
					// % protected region % [Add any additional guards for BPJS Procedure here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to BPJS Procedure here] off begin
						// % protected region % [Add additional roles to BPJS Procedure here] end
					],
					// % protected region % [Customise your data passed to BPJS Procedure here] off begin
					// % protected region % [Customise your data passed to BPJS Procedure here] end
				},
				// % protected region % [Add additional route properties here for bpjs-procedure] off begin
				// % protected region % [Add additional route properties here for bpjs-procedure] end
			},
			{
				path: 'bpjs-referral-specialist',
				loadChildren: () => import('../pages/bpjs-referral-specialist/bpjs-referral-specialist.page.module').then(m => m.BpjsReferralSpecialistPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Referral Specialist here] off begin
					// % protected region % [Add any additional guards for BPJS Referral Specialist here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to BPJS Referral Specialist here] off begin
						// % protected region % [Add additional roles to BPJS Referral Specialist here] end
					],
					// % protected region % [Customise your data passed to BPJS Referral Specialist here] off begin
					// % protected region % [Customise your data passed to BPJS Referral Specialist here] end
				},
				// % protected region % [Add additional route properties here for bpjs-referral-specialist] off begin
				// % protected region % [Add additional route properties here for bpjs-referral-specialist] end
			},
			{
				path: 'bpjs-referred-back',
				loadChildren: () => import('../pages/bpjs-referred-back/bpjs-referred-back.page.module').then(m => m.BpjsReferredBackPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Referred Back here] off begin
					// % protected region % [Add any additional guards for BPJS Referred Back here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to BPJS Referred Back here] off begin
						// % protected region % [Add additional roles to BPJS Referred Back here] end
					],
					// % protected region % [Customise your data passed to BPJS Referred Back here] off begin
					// % protected region % [Customise your data passed to BPJS Referred Back here] end
				},
				// % protected region % [Add additional route properties here for bpjs-referred-back] off begin
				// % protected region % [Add additional route properties here for bpjs-referred-back] end
			},
			{
				path: 'bpjs-referred-back-detail',
				loadChildren: () => import('../pages/bpjs-referred-back-detail/bpjs-referred-back-detail.page.module').then(m => m.BpjsReferredBackDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Referred Back Detail here] off begin
					// % protected region % [Add any additional guards for BPJS Referred Back Detail here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to BPJS Referred Back Detail here] off begin
						// % protected region % [Add additional roles to BPJS Referred Back Detail here] end
					],
					// % protected region % [Customise your data passed to BPJS Referred Back Detail here] off begin
					// % protected region % [Customise your data passed to BPJS Referred Back Detail here] end
				},
				// % protected region % [Add additional route properties here for bpjs-referred-back-detail] off begin
				// % protected region % [Add additional route properties here for bpjs-referred-back-detail] end
			},
			{
				path: 'bpjs-referred-back-wrapper',
				loadChildren: () => import('../pages/bpjs-referred-back-wrapper/bpjs-referred-back-wrapper.page.module').then(m => m.BpjsReferredBackWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Referred Back Wrapper here] off begin
					// % protected region % [Add any additional guards for BPJS Referred Back Wrapper here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to BPJS Referred Back Wrapper here] off begin
						// % protected region % [Add additional roles to BPJS Referred Back Wrapper here] end
					],
					// % protected region % [Customise your data passed to BPJS Referred Back Wrapper here] off begin
					// % protected region % [Customise your data passed to BPJS Referred Back Wrapper here] end
				},
				// % protected region % [Add additional route properties here for bpjs-referred-back-wrapper] off begin
				// % protected region % [Add additional route properties here for bpjs-referred-back-wrapper] end
			},
			{
				path: 'bpjs-sep',
				loadChildren: () => import('../pages/bpjs-sep/bpjs-sep.page.module').then(m => m.BpjsSEPPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS SEP here] off begin
					// % protected region % [Add any additional guards for BPJS SEP here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to BPJS SEP here] off begin
						// % protected region % [Add additional roles to BPJS SEP here] end
					],
					// % protected region % [Customise your data passed to BPJS SEP here] off begin
					// % protected region % [Customise your data passed to BPJS SEP here] end
				},
				// % protected region % [Add additional route properties here for bpjs-sep] off begin
				// % protected region % [Add additional route properties here for bpjs-sep] end
			},
			{
				path: 'bpjs-sep-internal',
				loadChildren: () => import('../pages/bpjs-sep-internal/bpjs-sep-internal.page.module').then(m => m.BpjsSEPInternalPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS SEP Internal here] off begin
					// % protected region % [Add any additional guards for BPJS SEP Internal here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to BPJS SEP Internal here] off begin
						// % protected region % [Add additional roles to BPJS SEP Internal here] end
					],
					// % protected region % [Customise your data passed to BPJS SEP Internal here] off begin
					// % protected region % [Customise your data passed to BPJS SEP Internal here] end
				},
				// % protected region % [Add additional route properties here for bpjs-sep-internal] off begin
				// % protected region % [Add additional route properties here for bpjs-sep-internal] end
			},
			{
				path: 'bpjs-sep-and-inacbg-integration',
				loadChildren: () => import('../pages/bpjs-sep-and-inacbg-integration/bpjs-sep-and-inacbg-integration.page.module').then(m => m.BpjsSEPAndINACBGIntegrationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS SEP and INACBG Integration here] off begin
					// % protected region % [Add any additional guards for BPJS SEP and INACBG Integration here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to BPJS SEP and INACBG Integration here] off begin
						// % protected region % [Add additional roles to BPJS SEP and INACBG Integration here] end
					],
					// % protected region % [Customise your data passed to BPJS SEP and INACBG Integration here] off begin
					// % protected region % [Customise your data passed to BPJS SEP and INACBG Integration here] end
				},
				// % protected region % [Add additional route properties here for bpjs-sep-and-inacbg-integration] off begin
				// % protected region % [Add additional route properties here for bpjs-sep-and-inacbg-integration] end
			},
			{
				path: 'bpjs-search-control-letter',
				loadChildren: () => import('../pages/bpjs-search-control-letter/bpjs-search-control-letter.page.module').then(m => m.BpjsSearchControlLetterPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Search Control Letter here] off begin
					// % protected region % [Add any additional guards for BPJS Search Control Letter here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to BPJS Search Control Letter here] off begin
						// % protected region % [Add additional roles to BPJS Search Control Letter here] end
					],
					// % protected region % [Customise your data passed to BPJS Search Control Letter here] off begin
					// % protected region % [Customise your data passed to BPJS Search Control Letter here] end
				},
				// % protected region % [Add additional route properties here for bpjs-search-control-letter] off begin
				// % protected region % [Add additional route properties here for bpjs-search-control-letter] end
			},
			{
				path: 'bpjs-search-sep',
				loadChildren: () => import('../pages/bpjs-search-sep/bpjs-search-sep.page.module').then(m => m.BpjsSearchSEPPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Search SEP here] off begin
					// % protected region % [Add any additional guards for BPJS Search SEP here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to BPJS Search SEP here] off begin
						// % protected region % [Add additional roles to BPJS Search SEP here] end
					],
					// % protected region % [Customise your data passed to BPJS Search SEP here] off begin
					// % protected region % [Customise your data passed to BPJS Search SEP here] end
				},
				// % protected region % [Add additional route properties here for bpjs-search-sep] off begin
				// % protected region % [Add additional route properties here for bpjs-search-sep] end
			},
			{
				path: 'bpjs-sep-submission',
				loadChildren: () => import('../pages/bpjs-sep-submission/bpjs-sep-submission.page.module').then(m => m.BpjsSepSubmissionPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Sep Submission here] off begin
					// % protected region % [Add any additional guards for BPJS Sep Submission here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to BPJS Sep Submission here] off begin
						// % protected region % [Add additional roles to BPJS Sep Submission here] end
					],
					// % protected region % [Customise your data passed to BPJS Sep Submission here] off begin
					// % protected region % [Customise your data passed to BPJS Sep Submission here] end
				},
				// % protected region % [Add additional route properties here for bpjs-sep-submission] off begin
				// % protected region % [Add additional route properties here for bpjs-sep-submission] end
			},
			{
				path: 'bpjs-service-mapping',
				loadChildren: () => import('../pages/bpjs-service-mapping/bpjs-service-mapping.page.module').then(m => m.BpjsServiceMappingPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Service Mapping here] off begin
					// % protected region % [Add any additional guards for BPJS Service Mapping here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'CASHIER_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to BPJS Service Mapping here] off begin
						// % protected region % [Add additional roles to BPJS Service Mapping here] end
					],
					// % protected region % [Customise your data passed to BPJS Service Mapping here] off begin
					// % protected region % [Customise your data passed to BPJS Service Mapping here] end
				},
				// % protected region % [Add additional route properties here for bpjs-service-mapping] off begin
				// % protected region % [Add additional route properties here for bpjs-service-mapping] end
			},
			{
				path: 'bpjs-special-referral',
				loadChildren: () => import('../pages/bpjs-special-referral/bpjs-special-referral.page.module').then(m => m.BpjsSpecialReferralPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Special Referral here] off begin
					// % protected region % [Add any additional guards for BPJS Special Referral here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to BPJS Special Referral here] off begin
						// % protected region % [Add additional roles to BPJS Special Referral here] end
					],
					// % protected region % [Customise your data passed to BPJS Special Referral here] off begin
					// % protected region % [Customise your data passed to BPJS Special Referral here] end
				},
				// % protected region % [Add additional route properties here for bpjs-special-referral] off begin
				// % protected region % [Add additional route properties here for bpjs-special-referral] end
			},
			{
				path: 'bpjs-task-history',
				loadChildren: () => import('../pages/bpjs-task-history/bpjs-task-history.page.module').then(m => m.BpjsTaskHistoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Task History here] off begin
					// % protected region % [Add any additional guards for BPJS Task History here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to BPJS Task History here] off begin
						// % protected region % [Add additional roles to BPJS Task History here] end
					],
					// % protected region % [Customise your data passed to BPJS Task History here] off begin
					// % protected region % [Customise your data passed to BPJS Task History here] end
				},
				// % protected region % [Add additional route properties here for bpjs-task-history] off begin
				// % protected region % [Add additional route properties here for bpjs-task-history] end
			},
			{
				path: 'bpjs-treatment-class-mapping',
				loadChildren: () => import('../pages/bpjs-treatment-class-mapping/bpjs-treatment-class-mapping.page.module').then(m => m.BpjsTreatmentClassMappingPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Treatment Class Mapping here] off begin
					// % protected region % [Add any additional guards for BPJS Treatment Class Mapping here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to BPJS Treatment Class Mapping here] off begin
						// % protected region % [Add additional roles to BPJS Treatment Class Mapping here] end
					],
					// % protected region % [Customise your data passed to BPJS Treatment Class Mapping here] off begin
					// % protected region % [Customise your data passed to BPJS Treatment Class Mapping here] end
				},
				// % protected region % [Add additional route properties here for bpjs-treatment-class-mapping] off begin
				// % protected region % [Add additional route properties here for bpjs-treatment-class-mapping] end
			},
			{
				path: 'bpjs-treatment-history',
				loadChildren: () => import('../pages/bpjs-treatment-history/bpjs-treatment-history.page.module').then(m => m.BpjsTreatmentHistoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Treatment History here] off begin
					// % protected region % [Add any additional guards for BPJS Treatment History here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to BPJS Treatment History here] off begin
						// % protected region % [Add additional roles to BPJS Treatment History here] end
					],
					// % protected region % [Customise your data passed to BPJS Treatment History here] off begin
					// % protected region % [Customise your data passed to BPJS Treatment History here] end
				},
				// % protected region % [Add additional route properties here for bpjs-treatment-history] off begin
				// % protected region % [Add additional route properties here for bpjs-treatment-history] end
			},
			{
				path: 'bpjs-treatment-room',
				loadChildren: () => import('../pages/bpjs-treatment-room/bpjs-treatment-room.page.module').then(m => m.BpjsTreatmentRoomPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Treatment Room here] off begin
					// % protected region % [Add any additional guards for BPJS Treatment Room here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to BPJS Treatment Room here] off begin
						// % protected region % [Add additional roles to BPJS Treatment Room here] end
					],
					// % protected region % [Customise your data passed to BPJS Treatment Room here] off begin
					// % protected region % [Customise your data passed to BPJS Treatment Room here] end
				},
				// % protected region % [Add additional route properties here for bpjs-treatment-room] off begin
				// % protected region % [Add additional route properties here for bpjs-treatment-room] end
			},
			{
				path: 'bpjs-update-dismissal-date',
				loadChildren: () => import('../pages/bpjs-update-dismissal-date/bpjs-update-dismissal-date.page.module').then(m => m.BpjsUpdateDismissalDatePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Update Dismissal Date here] off begin
					// % protected region % [Add any additional guards for BPJS Update Dismissal Date here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to BPJS Update Dismissal Date here] off begin
						// % protected region % [Add additional roles to BPJS Update Dismissal Date here] end
					],
					// % protected region % [Customise your data passed to BPJS Update Dismissal Date here] off begin
					// % protected region % [Customise your data passed to BPJS Update Dismissal Date here] end
				},
				// % protected region % [Add additional route properties here for bpjs-update-dismissal-date] off begin
				// % protected region % [Add additional route properties here for bpjs-update-dismissal-date] end
			},
			{
				path: 'bpjs-update-dismissal-date-wrapper',
				loadChildren: () => import('../pages/bpjs-update-dismissal-date-wrapper/bpjs-update-dismissal-date-wrapper.page.module').then(m => m.BpjsUpdateDismissalDateWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Update Dismissal Date Wrapper here] off begin
					// % protected region % [Add any additional guards for BPJS Update Dismissal Date Wrapper here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to BPJS Update Dismissal Date Wrapper here] off begin
						// % protected region % [Add additional roles to BPJS Update Dismissal Date Wrapper here] end
					],
					// % protected region % [Customise your data passed to BPJS Update Dismissal Date Wrapper here] off begin
					// % protected region % [Customise your data passed to BPJS Update Dismissal Date Wrapper here] end
				},
				// % protected region % [Add additional route properties here for bpjs-update-dismissal-date-wrapper] off begin
				// % protected region % [Add additional route properties here for bpjs-update-dismissal-date-wrapper] end
			},
			{
				path: 'bpjs-visit-data',
				loadChildren: () => import('../pages/bpjs-visit-data/bpjs-visit-data.page.module').then(m => m.BpjsVisitDataPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for BPJS Visit Data here] off begin
					// % protected region % [Add any additional guards for BPJS Visit Data here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to BPJS Visit Data here] off begin
						// % protected region % [Add additional roles to BPJS Visit Data here] end
					],
					// % protected region % [Customise your data passed to BPJS Visit Data here] off begin
					// % protected region % [Customise your data passed to BPJS Visit Data here] end
				},
				// % protected region % [Add additional route properties here for bpjs-visit-data] off begin
				// % protected region % [Add additional route properties here for bpjs-visit-data] end
			},
			{
				path: 'batch-correction',
				loadChildren: () => import('../pages/batch-correction/batch-correction.page.module').then(m => m.BatchCorrectionPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Batch Correction here] off begin
					// % protected region % [Add any additional guards for Batch Correction here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Batch Correction here] off begin
						// % protected region % [Add additional roles to Batch Correction here] end
					],
					// % protected region % [Customise your data passed to Batch Correction here] off begin
					// % protected region % [Customise your data passed to Batch Correction here] end
				},
				// % protected region % [Add additional route properties here for batch-correction] off begin
				// % protected region % [Add additional route properties here for batch-correction] end
			},
			{
				path: 'bed',
				loadChildren: () => import('../pages/bed/bed.page.module').then(m => m.BedPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Bed here] off begin
					// % protected region % [Add any additional guards for Bed here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Bed here] off begin
						// % protected region % [Add additional roles to Bed here] end
					],
					// % protected region % [Customise your data passed to Bed here] off begin
					// % protected region % [Customise your data passed to Bed here] end
				},
				// % protected region % [Add additional route properties here for bed] off begin
				// % protected region % [Add additional route properties here for bed] end
			},
			{
				path: 'bed-availability',
				loadChildren: () => import('../pages/bed-availability/bed-availability.page.module').then(m => m.BedAvailabilityPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Bed Availability here] off begin
					// % protected region % [Add any additional guards for Bed Availability here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to Bed Availability here] off begin
						// % protected region % [Add additional roles to Bed Availability here] end
					],
					// % protected region % [Customise your data passed to Bed Availability here] off begin
					// % protected region % [Customise your data passed to Bed Availability here] end
				},
				// % protected region % [Add additional route properties here for bed-availability] off begin
				// % protected region % [Add additional route properties here for bed-availability] end
			},
			{
				path: 'bed-management',
				loadChildren: () => import('../pages/bed-management/bed-management.page.module').then(m => m.BedManagementPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Bed Management here] off begin
					// % protected region % [Add any additional guards for Bed Management here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Bed Management here] off begin
						// % protected region % [Add additional roles to Bed Management here] end
					],
					// % protected region % [Customise your data passed to Bed Management here] off begin
					// % protected region % [Customise your data passed to Bed Management here] end
				},
				// % protected region % [Add additional route properties here for bed-management] off begin
				// % protected region % [Add additional route properties here for bed-management] end
			},
			{
				path: 'benefit-plan',
				loadChildren: () => import('../pages/benefit-plan/benefit-plan.page.module').then(m => m.BenefitPlanPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Benefit Plan here] off begin
					// % protected region % [Add any additional guards for Benefit Plan here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Benefit Plan here] off begin
						// % protected region % [Add additional roles to Benefit Plan here] end
					],
					// % protected region % [Customise your data passed to Benefit Plan here] off begin
					// % protected region % [Customise your data passed to Benefit Plan here] end
				},
				// % protected region % [Add additional route properties here for benefit-plan] off begin
				// % protected region % [Add additional route properties here for benefit-plan] end
			},
			{
				path: 'birth-history',
				loadChildren: () => import('../pages/birth-history/birth-history.page.module').then(m => m.BirthHistoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Birth History here] off begin
					// % protected region % [Add any additional guards for Birth History here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Birth History here] off begin
						// % protected region % [Add additional roles to Birth History here] end
					],
					// % protected region % [Customise your data passed to Birth History here] off begin
					// % protected region % [Customise your data passed to Birth History here] end
				},
				// % protected region % [Add additional route properties here for birth-history] off begin
				// % protected region % [Add additional route properties here for birth-history] end
			},
			{
				path: 'bpjs',
				loadChildren: () => import('../pages/bpjs/bpjs.page.module').then(m => m.BpjsPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Bpjs here] off begin
					// % protected region % [Add any additional guards for Bpjs here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Bpjs here] off begin
						// % protected region % [Add additional roles to Bpjs here] end
					],
					// % protected region % [Customise your data passed to Bpjs here] off begin
					// % protected region % [Customise your data passed to Bpjs here] end
				},
				// % protected region % [Add additional route properties here for bpjs] off begin
				// % protected region % [Add additional route properties here for bpjs] end
			},
			{
				path: 'bpjs-health-facility-bed-availability',
				loadChildren: () => import('../pages/bpjs-health-facility-bed-availability/bpjs-health-facility-bed-availability.page.module').then(m => m.BpjsHealthFacilityBedAvailabilityPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Bpjs Health Facility Bed Availability here] off begin
					// % protected region % [Add any additional guards for Bpjs Health Facility Bed Availability here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to Bpjs Health Facility Bed Availability here] off begin
						// % protected region % [Add additional roles to Bpjs Health Facility Bed Availability here] end
					],
					// % protected region % [Customise your data passed to Bpjs Health Facility Bed Availability here] off begin
					// % protected region % [Customise your data passed to Bpjs Health Facility Bed Availability here] end
				},
				// % protected region % [Add additional route properties here for bpjs-health-facility-bed-availability] off begin
				// % protected region % [Add additional route properties here for bpjs-health-facility-bed-availability] end
			},
			{
				path: 'bpjs-sep-claim-wrapper',
				loadChildren: () => import('../pages/bpjs-sep-claim-wrapper/bpjs-sep-claim-wrapper.page.module').then(m => m.BpjsSepClaimWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Bpjs Sep Claim Wrapper here] off begin
					// % protected region % [Add any additional guards for Bpjs Sep Claim Wrapper here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Bpjs Sep Claim Wrapper here] off begin
						// % protected region % [Add additional roles to Bpjs Sep Claim Wrapper here] end
					],
					// % protected region % [Customise your data passed to Bpjs Sep Claim Wrapper here] off begin
					// % protected region % [Customise your data passed to Bpjs Sep Claim Wrapper here] end
				},
				// % protected region % [Add additional route properties here for bpjs-sep-claim-wrapper] off begin
				// % protected region % [Add additional route properties here for bpjs-sep-claim-wrapper] end
			},
			{
				path: 'bpjs-sep-submission-wrapper',
				loadChildren: () => import('../pages/bpjs-sep-submission-wrapper/bpjs-sep-submission-wrapper.page.module').then(m => m.BpjsSepSubmissionWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Bpjs Sep Submission Wrapper here] off begin
					// % protected region % [Add any additional guards for Bpjs Sep Submission Wrapper here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Bpjs Sep Submission Wrapper here] off begin
						// % protected region % [Add additional roles to Bpjs Sep Submission Wrapper here] end
					],
					// % protected region % [Customise your data passed to Bpjs Sep Submission Wrapper here] off begin
					// % protected region % [Customise your data passed to Bpjs Sep Submission Wrapper here] end
				},
				// % protected region % [Add additional route properties here for bpjs-sep-submission-wrapper] off begin
				// % protected region % [Add additional route properties here for bpjs-sep-submission-wrapper] end
			},
			{
				path: 'cash-report',
				loadChildren: () => import('../pages/cash-report/cash-report.page.module').then(m => m.CashReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Cash Report here] off begin
					// % protected region % [Add any additional guards for Cash Report here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Cash Report here] off begin
						// % protected region % [Add additional roles to Cash Report here] end
					],
					// % protected region % [Customise your data passed to Cash Report here] off begin
					// % protected region % [Customise your data passed to Cash Report here] end
				},
				// % protected region % [Add additional route properties here for cash-report] off begin
				// % protected region % [Add additional route properties here for cash-report] end
			},
			{
				path: 'catalogue',
				loadChildren: () => import('../pages/catalogue/catalogue.page.module').then(m => m.CataloguePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Catalogue here] off begin
					// % protected region % [Add any additional guards for Catalogue here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Catalogue here] off begin
						// % protected region % [Add additional roles to Catalogue here] end
					],
					// % protected region % [Customise your data passed to Catalogue here] off begin
					// % protected region % [Customise your data passed to Catalogue here] end
				},
				// % protected region % [Add additional route properties here for catalogue] off begin
				// % protected region % [Add additional route properties here for catalogue] end
			},
			{
				path: 'chart-of-account',
				loadChildren: () => import('../pages/chart-of-account/chart-of-account.page.module').then(m => m.ChartOfAccountPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Chart of Account here] off begin
					// % protected region % [Add any additional guards for Chart of Account here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Chart of Account here] off begin
						// % protected region % [Add additional roles to Chart of Account here] end
					],
					// % protected region % [Customise your data passed to Chart of Account here] off begin
					// % protected region % [Customise your data passed to Chart of Account here] end
				},
				// % protected region % [Add additional route properties here for chart-of-account] off begin
				// % protected region % [Add additional route properties here for chart-of-account] end
			},
			{
				path: 'chart-of-account-mapping',
				loadChildren: () => import('../pages/chart-of-account-mapping/chart-of-account-mapping.page.module').then(m => m.ChartOfAccountMappingPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Chart of Account Mapping here] off begin
					// % protected region % [Add any additional guards for Chart of Account Mapping here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Chart of Account Mapping here] off begin
						// % protected region % [Add additional roles to Chart of Account Mapping here] end
					],
					// % protected region % [Customise your data passed to Chart of Account Mapping here] off begin
					// % protected region % [Customise your data passed to Chart of Account Mapping here] end
				},
				// % protected region % [Add additional route properties here for chart-of-account-mapping] off begin
				// % protected region % [Add additional route properties here for chart-of-account-mapping] end
			},
			{
				path: 'claim-report',
				loadChildren: () => import('../pages/claim-report/claim-report.page.module').then(m => m.ClaimReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Claim Report here] off begin
					// % protected region % [Add any additional guards for Claim Report here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to Claim Report here] off begin
						// % protected region % [Add additional roles to Claim Report here] end
					],
					// % protected region % [Customise your data passed to Claim Report here] off begin
					// % protected region % [Customise your data passed to Claim Report here] end
				},
				// % protected region % [Add additional route properties here for claim-report] off begin
				// % protected region % [Add additional route properties here for claim-report] end
			},
			{
				path: 'claims',
				loadChildren: () => import('../pages/claims/claims.page.module').then(m => m.ClaimsPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Claims here] off begin
					// % protected region % [Add any additional guards for Claims here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Claims here] off begin
						// % protected region % [Add additional roles to Claims here] end
					],
					// % protected region % [Customise your data passed to Claims here] off begin
					// % protected region % [Customise your data passed to Claims here] end
				},
				// % protected region % [Add additional route properties here for claims] off begin
				// % protected region % [Add additional route properties here for claims] end
			},
			{
				path: 'clinical-exam',
				loadChildren: () => import('../pages/clinical-exam/clinical-exam.page.module').then(m => m.ClinicalExamPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Clinical Exam here] off begin
					// % protected region % [Add any additional guards for Clinical Exam here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Clinical Exam here] off begin
						// % protected region % [Add additional roles to Clinical Exam here] end
					],
					// % protected region % [Customise your data passed to Clinical Exam here] off begin
					// % protected region % [Customise your data passed to Clinical Exam here] end
				},
				// % protected region % [Add additional route properties here for clinical-exam] off begin
				// % protected region % [Add additional route properties here for clinical-exam] end
			},
			{
				path: 'clinical-exam-amendment-history',
				loadChildren: () => import('../pages/clinical-exam-amendment-history/clinical-exam-amendment-history.page.module').then(m => m.ClinicalExamAmendmentHistoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Clinical Exam Amendment History here] off begin
					// % protected region % [Add any additional guards for Clinical Exam Amendment History here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Clinical Exam Amendment History here] off begin
						// % protected region % [Add additional roles to Clinical Exam Amendment History here] end
					],
					// % protected region % [Customise your data passed to Clinical Exam Amendment History here] off begin
					// % protected region % [Customise your data passed to Clinical Exam Amendment History here] end
				},
				// % protected region % [Add additional route properties here for clinical-exam-amendment-history] off begin
				// % protected region % [Add additional route properties here for clinical-exam-amendment-history] end
			},
			{
				path: 'clinical-exam-dashboard',
				loadChildren: () => import('../pages/clinical-exam-dashboard/clinical-exam-dashboard.page.module').then(m => m.ClinicalExamDashboardPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Clinical Exam Dashboard here] off begin
					// % protected region % [Add any additional guards for Clinical Exam Dashboard here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Clinical Exam Dashboard here] off begin
						// % protected region % [Add additional roles to Clinical Exam Dashboard here] end
					],
					// % protected region % [Customise your data passed to Clinical Exam Dashboard here] off begin
					// % protected region % [Customise your data passed to Clinical Exam Dashboard here] end
				},
				// % protected region % [Add additional route properties here for clinical-exam-dashboard] off begin
				// % protected region % [Add additional route properties here for clinical-exam-dashboard] end
			},
			{
				path: 'clinical-exam-diagnostic-staff',
				loadChildren: () => import('../pages/clinical-exam-diagnostic-staff/clinical-exam-diagnostic-staff.page.module').then(m => m.ClinicalExamDiagnosticStaffPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Clinical Exam Diagnostic Staff here] off begin
					// % protected region % [Add any additional guards for Clinical Exam Diagnostic Staff here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Clinical Exam Diagnostic Staff here] off begin
						// % protected region % [Add additional roles to Clinical Exam Diagnostic Staff here] end
					],
					// % protected region % [Customise your data passed to Clinical Exam Diagnostic Staff here] off begin
					// % protected region % [Customise your data passed to Clinical Exam Diagnostic Staff here] end
				},
				// % protected region % [Add additional route properties here for clinical-exam-diagnostic-staff] off begin
				// % protected region % [Add additional route properties here for clinical-exam-diagnostic-staff] end
			},
			{
				path: 'clinical-exam-doctor',
				loadChildren: () => import('../pages/clinical-exam-doctor/clinical-exam-doctor.page.module').then(m => m.ClinicalExamDoctorPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Clinical Exam Doctor here] off begin
					// % protected region % [Add any additional guards for Clinical Exam Doctor here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Clinical Exam Doctor here] off begin
						// % protected region % [Add additional roles to Clinical Exam Doctor here] end
					],
					// % protected region % [Customise your data passed to Clinical Exam Doctor here] off begin
					// % protected region % [Customise your data passed to Clinical Exam Doctor here] end
				},
				// % protected region % [Add additional route properties here for clinical-exam-doctor] off begin
				// % protected region % [Add additional route properties here for clinical-exam-doctor] end
			},
			{
				path: 'clinical-exam-nurse',
				loadChildren: () => import('../pages/clinical-exam-nurse/clinical-exam-nurse.page.module').then(m => m.ClinicalExamNursePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Clinical Exam Nurse here] off begin
					// % protected region % [Add any additional guards for Clinical Exam Nurse here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Clinical Exam Nurse here] off begin
						// % protected region % [Add additional roles to Clinical Exam Nurse here] end
					],
					// % protected region % [Customise your data passed to Clinical Exam Nurse here] off begin
					// % protected region % [Customise your data passed to Clinical Exam Nurse here] end
				},
				// % protected region % [Add additional route properties here for clinical-exam-nurse] off begin
				// % protected region % [Add additional route properties here for clinical-exam-nurse] end
			},
			{
				path: 'clinical-exam-patient-demographic',
				loadChildren: () => import('../pages/clinical-exam-patient-demographic/clinical-exam-patient-demographic.page.module').then(m => m.ClinicalExamPatientDemographicPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Clinical Exam Patient Demographic here] off begin
					// % protected region % [Add any additional guards for Clinical Exam Patient Demographic here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Clinical Exam Patient Demographic here] off begin
						// % protected region % [Add additional roles to Clinical Exam Patient Demographic here] end
					],
					// % protected region % [Customise your data passed to Clinical Exam Patient Demographic here] off begin
					// % protected region % [Customise your data passed to Clinical Exam Patient Demographic here] end
				},
				// % protected region % [Add additional route properties here for clinical-exam-patient-demographic] off begin
				// % protected region % [Add additional route properties here for clinical-exam-patient-demographic] end
			},
			{
				path: 'clinical-exam-patient-medical-history',
				loadChildren: () => import('../pages/clinical-exam-patient-medical-history/clinical-exam-patient-medical-history.page.module').then(m => m.ClinicalExamPatientMedicalHistoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Clinical Exam Patient Medical History here] off begin
					// % protected region % [Add any additional guards for Clinical Exam Patient Medical History here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Clinical Exam Patient Medical History here] off begin
						// % protected region % [Add additional roles to Clinical Exam Patient Medical History here] end
					],
					// % protected region % [Customise your data passed to Clinical Exam Patient Medical History here] off begin
					// % protected region % [Customise your data passed to Clinical Exam Patient Medical History here] end
				},
				// % protected region % [Add additional route properties here for clinical-exam-patient-medical-history] off begin
				// % protected region % [Add additional route properties here for clinical-exam-patient-medical-history] end
			},
			{
				path: 'compound-prescription',
				loadChildren: () => import('../pages/compound-prescription/compound-prescription.page.module').then(m => m.CompoundPrescriptionPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Compound Prescription here] off begin
					// % protected region % [Add any additional guards for Compound Prescription here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Compound Prescription here] off begin
						// % protected region % [Add additional roles to Compound Prescription here] end
					],
					// % protected region % [Customise your data passed to Compound Prescription here] off begin
					// % protected region % [Customise your data passed to Compound Prescription here] end
				},
				// % protected region % [Add additional route properties here for compound-prescription] off begin
				// % protected region % [Add additional route properties here for compound-prescription] end
			},
			{
				path: 'compound-prescription-detail',
				loadChildren: () => import('../pages/compound-prescription-detail/compound-prescription-detail.page.module').then(m => m.CompoundPrescriptionDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Compound Prescription Detail here] off begin
					// % protected region % [Add any additional guards for Compound Prescription Detail here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Compound Prescription Detail here] off begin
						// % protected region % [Add additional roles to Compound Prescription Detail here] end
					],
					// % protected region % [Customise your data passed to Compound Prescription Detail here] off begin
					// % protected region % [Customise your data passed to Compound Prescription Detail here] end
				},
				// % protected region % [Add additional route properties here for compound-prescription-detail] off begin
				// % protected region % [Add additional route properties here for compound-prescription-detail] end
			},
			{
				path: 'critical-care',
				loadChildren: () => import('../pages/critical-care/critical-care.page.module').then(m => m.CriticalCarePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Critical Care here] off begin
					// % protected region % [Add any additional guards for Critical Care here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Critical Care here] off begin
						// % protected region % [Add additional roles to Critical Care here] end
					],
					// % protected region % [Customise your data passed to Critical Care here] off begin
					// % protected region % [Customise your data passed to Critical Care here] end
				},
				// % protected region % [Add additional route properties here for critical-care] off begin
				// % protected region % [Add additional route properties here for critical-care] end
			},
			{
				path: 'daily-care-cppt',
				loadChildren: () => import('../pages/daily-care-cppt/daily-care-cppt.page.module').then(m => m.DailyCareCPPTPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Daily Care CPPT here] off begin
					// % protected region % [Add any additional guards for Daily Care CPPT here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Daily Care CPPT here] off begin
						// % protected region % [Add additional roles to Daily Care CPPT here] end
					],
					// % protected region % [Customise your data passed to Daily Care CPPT here] off begin
					// % protected region % [Customise your data passed to Daily Care CPPT here] end
				},
				// % protected region % [Add additional route properties here for daily-care-cppt] off begin
				// % protected region % [Add additional route properties here for daily-care-cppt] end
			},
			{
				path: 'dashboard',
				loadChildren: () => import('../pages/dashboard/dashboard.page.module').then(m => m.DashboardPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Dashboard here] off begin
					// % protected region % [Add any additional guards for Dashboard here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Dashboard here] off begin
						// % protected region % [Add additional roles to Dashboard here] end
					],
					// % protected region % [Customise your data passed to Dashboard here] off begin
					// % protected region % [Customise your data passed to Dashboard here] end
				},
				// % protected region % [Add additional route properties here for dashboard] off begin
				// % protected region % [Add additional route properties here for dashboard] end
			},
			{
				path: 'delivery-medical-examination-record',
				loadChildren: () => import('../pages/delivery-medical-examination-record/delivery-medical-examination-record.page.module').then(m => m.DeliveryMedicalExaminationRecordPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Delivery Medical Examination Record here] off begin
					// % protected region % [Add any additional guards for Delivery Medical Examination Record here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Delivery Medical Examination Record here] off begin
						// % protected region % [Add additional roles to Delivery Medical Examination Record here] end
					],
					// % protected region % [Customise your data passed to Delivery Medical Examination Record here] off begin
					// % protected region % [Customise your data passed to Delivery Medical Examination Record here] end
				},
				// % protected region % [Add additional route properties here for delivery-medical-examination-record] off begin
				// % protected region % [Add additional route properties here for delivery-medical-examination-record] end
			},
			{
				path: 'delivery-room',
				loadChildren: () => import('../pages/delivery-room/delivery-room.page.module').then(m => m.DeliveryRoomPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Delivery Room here] off begin
					// % protected region % [Add any additional guards for Delivery Room here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Delivery Room here] off begin
						// % protected region % [Add additional roles to Delivery Room here] end
					],
					// % protected region % [Customise your data passed to Delivery Room here] off begin
					// % protected region % [Customise your data passed to Delivery Room here] end
				},
				// % protected region % [Add additional route properties here for delivery-room] off begin
				// % protected region % [Add additional route properties here for delivery-room] end
			},
			{
				path: 'dental-oral-service-activity-report',
				loadChildren: () => import('../pages/dental-oral-service-activity-report/dental-oral-service-activity-report.page.module').then(m => m.DentalOralServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Dental Oral Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Dental Oral Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Dental Oral Service Activity Report here] off begin
						// % protected region % [Add additional roles to Dental Oral Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Dental Oral Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Dental Oral Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for dental-oral-service-activity-report] off begin
				// % protected region % [Add additional route properties here for dental-oral-service-activity-report] end
			},
			{
				path: 'diag-and-proc',
				loadChildren: () => import('../pages/diag-and-proc/diag-and-proc.page.module').then(m => m.DiagAndProcPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Diag and Proc here] off begin
					// % protected region % [Add any additional guards for Diag and Proc here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Diag and Proc here] off begin
						// % protected region % [Add additional roles to Diag and Proc here] end
					],
					// % protected region % [Customise your data passed to Diag and Proc here] off begin
					// % protected region % [Customise your data passed to Diag and Proc here] end
				},
				// % protected region % [Add additional route properties here for diag-and-proc] off begin
				// % protected region % [Add additional route properties here for diag-and-proc] end
			},
			{
				path: 'diagnoses-and-procedures',
				loadChildren: () => import('../pages/diagnoses-and-procedures/diagnoses-and-procedures.page.module').then(m => m.DiagnosesAndProceduresPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Diagnoses and Procedures here] off begin
					// % protected region % [Add any additional guards for Diagnoses and Procedures here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Diagnoses and Procedures here] off begin
						// % protected region % [Add additional roles to Diagnoses and Procedures here] end
					],
					// % protected region % [Customise your data passed to Diagnoses and Procedures here] off begin
					// % protected region % [Customise your data passed to Diagnoses and Procedures here] end
				},
				// % protected region % [Add additional route properties here for diagnoses-and-procedures] off begin
				// % protected region % [Add additional route properties here for diagnoses-and-procedures] end
			},
			{
				path: 'diagnostic-configuration',
				loadChildren: () => import('../pages/diagnostic-configuration/diagnostic-configuration.page.module').then(m => m.DiagnosticConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Diagnostic Configuration here] off begin
					// % protected region % [Add any additional guards for Diagnostic Configuration here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Diagnostic Configuration here] off begin
						// % protected region % [Add additional roles to Diagnostic Configuration here] end
					],
					// % protected region % [Customise your data passed to Diagnostic Configuration here] off begin
					// % protected region % [Customise your data passed to Diagnostic Configuration here] end
				},
				// % protected region % [Add additional route properties here for diagnostic-configuration] off begin
				// % protected region % [Add additional route properties here for diagnostic-configuration] end
			},
			{
				path: 'diagnostic-support',
				loadChildren: () => import('../pages/diagnostic-support/diagnostic-support.page.module').then(m => m.DiagnosticSupportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Diagnostic Support here] off begin
					// % protected region % [Add any additional guards for Diagnostic Support here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Diagnostic Support here] off begin
						// % protected region % [Add additional roles to Diagnostic Support here] end
					],
					// % protected region % [Customise your data passed to Diagnostic Support here] off begin
					// % protected region % [Customise your data passed to Diagnostic Support here] end
				},
				// % protected region % [Add additional route properties here for diagnostic-support] off begin
				// % protected region % [Add additional route properties here for diagnostic-support] end
			},
			{
				path: 'diagnostic-support-configuration',
				loadChildren: () => import('../pages/diagnostic-support-configuration/diagnostic-support-configuration.page.module').then(m => m.DiagnosticSupportConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Diagnostic Support Configuration here] off begin
					// % protected region % [Add any additional guards for Diagnostic Support Configuration here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Diagnostic Support Configuration here] off begin
						// % protected region % [Add additional roles to Diagnostic Support Configuration here] end
					],
					// % protected region % [Customise your data passed to Diagnostic Support Configuration here] off begin
					// % protected region % [Customise your data passed to Diagnostic Support Configuration here] end
				},
				// % protected region % [Add additional route properties here for diagnostic-support-configuration] off begin
				// % protected region % [Add additional route properties here for diagnostic-support-configuration] end
			},
			{
				path: 'diagnostic-support-general-configuration',
				loadChildren: () => import('../pages/diagnostic-support-general-configuration/diagnostic-support-general-configuration.page.module').then(m => m.DiagnosticSupportGeneralConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Diagnostic Support General Configuration here] off begin
					// % protected region % [Add any additional guards for Diagnostic Support General Configuration here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Diagnostic Support General Configuration here] off begin
						// % protected region % [Add additional roles to Diagnostic Support General Configuration here] end
					],
					// % protected region % [Customise your data passed to Diagnostic Support General Configuration here] off begin
					// % protected region % [Customise your data passed to Diagnostic Support General Configuration here] end
				},
				// % protected region % [Add additional route properties here for diagnostic-support-general-configuration] off begin
				// % protected region % [Add additional route properties here for diagnostic-support-general-configuration] end
			},
			{
				path: 'drug-procurement-service-report',
				loadChildren: () => import('../pages/drug-procurement-service-report/drug-procurement-service-report.page.module').then(m => m.DrugProcurementServiceReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Drug Procurement Service Report here] off begin
					// % protected region % [Add any additional guards for Drug Procurement Service Report here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Drug Procurement Service Report here] off begin
						// % protected region % [Add additional roles to Drug Procurement Service Report here] end
					],
					// % protected region % [Customise your data passed to Drug Procurement Service Report here] off begin
					// % protected region % [Customise your data passed to Drug Procurement Service Report here] end
				},
				// % protected region % [Add additional route properties here for drug-procurement-service-report] off begin
				// % protected region % [Add additional route properties here for drug-procurement-service-report] end
			},
			{
				path: 'emergency-medical-examination-record',
				loadChildren: () => import('../pages/emergency-medical-examination-record/emergency-medical-examination-record.page.module').then(m => m.EmergencyMedicalExaminationRecordPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Emergency Medical Examination Record here] off begin
					// % protected region % [Add any additional guards for Emergency Medical Examination Record here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Emergency Medical Examination Record here] off begin
						// % protected region % [Add additional roles to Emergency Medical Examination Record here] end
					],
					// % protected region % [Customise your data passed to Emergency Medical Examination Record here] off begin
					// % protected region % [Customise your data passed to Emergency Medical Examination Record here] end
				},
				// % protected region % [Add additional route properties here for emergency-medical-examination-record] off begin
				// % protected region % [Add additional route properties here for emergency-medical-examination-record] end
			},
			{
				path: 'emergency-service-activity-report',
				loadChildren: () => import('../pages/emergency-service-activity-report/emergency-service-activity-report.page.module').then(m => m.EmergencyServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Emergency Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Emergency Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Emergency Service Activity Report here] off begin
						// % protected region % [Add additional roles to Emergency Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Emergency Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Emergency Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for emergency-service-activity-report] off begin
				// % protected region % [Add additional route properties here for emergency-service-activity-report] end
			},
			{
				path: 'examination-group',
				loadChildren: () => import('../pages/examination-group/examination-group.page.module').then(m => m.ExaminationGroupPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Examination Group here] off begin
					// % protected region % [Add any additional guards for Examination Group here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Examination Group here] off begin
						// % protected region % [Add additional roles to Examination Group here] end
					],
					// % protected region % [Customise your data passed to Examination Group here] off begin
					// % protected region % [Customise your data passed to Examination Group here] end
				},
				// % protected region % [Add additional route properties here for examination-group] off begin
				// % protected region % [Add additional route properties here for examination-group] end
			},
			{
				path: 'examination-item',
				loadChildren: () => import('../pages/examination-item/examination-item.page.module').then(m => m.ExaminationItemPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Examination Item here] off begin
					// % protected region % [Add any additional guards for Examination Item here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Examination Item here] off begin
						// % protected region % [Add additional roles to Examination Item here] end
					],
					// % protected region % [Customise your data passed to Examination Item here] off begin
					// % protected region % [Customise your data passed to Examination Item here] end
				},
				// % protected region % [Add additional route properties here for examination-item] off begin
				// % protected region % [Add additional route properties here for examination-item] end
			},
			{
				path: 'examination-item-detail',
				loadChildren: () => import('../pages/examination-item-detail/examination-item-detail.page.module').then(m => m.ExaminationItemDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Examination Item Detail here] off begin
					// % protected region % [Add any additional guards for Examination Item Detail here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Examination Item Detail here] off begin
						// % protected region % [Add additional roles to Examination Item Detail here] end
					],
					// % protected region % [Customise your data passed to Examination Item Detail here] off begin
					// % protected region % [Customise your data passed to Examination Item Detail here] end
				},
				// % protected region % [Add additional route properties here for examination-item-detail] off begin
				// % protected region % [Add additional route properties here for examination-item-detail] end
			},
			{
				path: 'family-planning-service-activity-report',
				loadChildren: () => import('../pages/family-planning-service-activity-report/family-planning-service-activity-report.page.module').then(m => m.FamilyPlanningServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Family Planning Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Family Planning Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Family Planning Service Activity Report here] off begin
						// % protected region % [Add additional roles to Family Planning Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Family Planning Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Family Planning Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for family-planning-service-activity-report] off begin
				// % protected region % [Add additional route properties here for family-planning-service-activity-report] end
			},
			{
				path: 'fluid-balance-detail',
				loadChildren: () => import('../pages/fluid-balance-detail/fluid-balance-detail.page.module').then(m => m.FluidBalanceDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Fluid Balance Detail here] off begin
					// % protected region % [Add any additional guards for Fluid Balance Detail here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Fluid Balance Detail here] off begin
						// % protected region % [Add additional roles to Fluid Balance Detail here] end
					],
					// % protected region % [Customise your data passed to Fluid Balance Detail here] off begin
					// % protected region % [Customise your data passed to Fluid Balance Detail here] end
				},
				// % protected region % [Add additional route properties here for fluid-balance-detail] off begin
				// % protected region % [Add additional route properties here for fluid-balance-detail] end
			},
			{
				path: 'general-config',
				loadChildren: () => import('../pages/general-config/general-config.page.module').then(m => m.GeneralConfigPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for General Config here] off begin
					// % protected region % [Add any additional guards for General Config here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to General Config here] off begin
						// % protected region % [Add additional roles to General Config here] end
					],
					// % protected region % [Customise your data passed to General Config here] off begin
					// % protected region % [Customise your data passed to General Config here] end
				},
				// % protected region % [Add additional route properties here for general-config] off begin
				// % protected region % [Add additional route properties here for general-config] end
			},
			{
				path: 'general-report',
				loadChildren: () => import('../pages/general-report/general-report.page.module').then(m => m.GeneralReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for General Report here] off begin
					// % protected region % [Add any additional guards for General Report here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to General Report here] off begin
						// % protected region % [Add additional roles to General Report here] end
					],
					// % protected region % [Customise your data passed to General Report here] off begin
					// % protected region % [Customise your data passed to General Report here] end
				},
				// % protected region % [Add additional route properties here for general-report] off begin
				// % protected region % [Add additional route properties here for general-report] end
			},
			{
				path: 'goods-receive-note-items-report',
				loadChildren: () => import('../pages/goods-receive-note-items-report/goods-receive-note-items-report.page.module').then(m => m.GoodsReceiveNoteItemsReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Goods Receive Note Items Report here] off begin
					// % protected region % [Add any additional guards for Goods Receive Note Items Report here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Goods Receive Note Items Report here] off begin
						// % protected region % [Add additional roles to Goods Receive Note Items Report here] end
					],
					// % protected region % [Customise your data passed to Goods Receive Note Items Report here] off begin
					// % protected region % [Customise your data passed to Goods Receive Note Items Report here] end
				},
				// % protected region % [Add additional route properties here for goods-receive-note-items-report] off begin
				// % protected region % [Add additional route properties here for goods-receive-note-items-report] end
			},
			{
				path: 'goods-received-note',
				loadChildren: () => import('../pages/goods-received-note/goods-received-note.page.module').then(m => m.GoodsReceivedNotePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Goods Received Note here] off begin
					// % protected region % [Add any additional guards for Goods Received Note here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Goods Received Note here] off begin
						// % protected region % [Add additional roles to Goods Received Note here] end
					],
					// % protected region % [Customise your data passed to Goods Received Note here] off begin
					// % protected region % [Customise your data passed to Goods Received Note here] end
				},
				// % protected region % [Add additional route properties here for goods-received-note] off begin
				// % protected region % [Add additional route properties here for goods-received-note] end
			},
			{
				path: 'goods-received-note-detail',
				loadChildren: () => import('../pages/goods-received-note-detail/goods-received-note-detail.page.module').then(m => m.GoodsReceivedNoteDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Goods Received Note Detail here] off begin
					// % protected region % [Add any additional guards for Goods Received Note Detail here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Goods Received Note Detail here] off begin
						// % protected region % [Add additional roles to Goods Received Note Detail here] end
					],
					// % protected region % [Customise your data passed to Goods Received Note Detail here] off begin
					// % protected region % [Customise your data passed to Goods Received Note Detail here] end
				},
				// % protected region % [Add additional route properties here for goods-received-note-detail] off begin
				// % protected region % [Add additional route properties here for goods-received-note-detail] end
			},
			{
				path: 'goods-received-note-item',
				loadChildren: () => import('../pages/goods-received-note-item/goods-received-note-item.page.module').then(m => m.GoodsReceivedNoteItemPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Goods Received Note Item here] off begin
					// % protected region % [Add any additional guards for Goods Received Note Item here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Goods Received Note Item here] off begin
						// % protected region % [Add additional roles to Goods Received Note Item here] end
					],
					// % protected region % [Customise your data passed to Goods Received Note Item here] off begin
					// % protected region % [Customise your data passed to Goods Received Note Item here] end
				},
				// % protected region % [Add additional route properties here for goods-received-note-item] off begin
				// % protected region % [Add additional route properties here for goods-received-note-item] end
			},
			{
				path: 'health-fac',
				loadChildren: () => import('../pages/health-fac/health-fac.page.module').then(m => m.HealthFacPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Health Fac here] off begin
					// % protected region % [Add any additional guards for Health Fac here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Health Fac here] off begin
						// % protected region % [Add additional roles to Health Fac here] end
					],
					// % protected region % [Customise your data passed to Health Fac here] off begin
					// % protected region % [Customise your data passed to Health Fac here] end
				},
				// % protected region % [Add additional route properties here for health-fac] off begin
				// % protected region % [Add additional route properties here for health-fac] end
			},
			{
				path: 'health-insurance',
				loadChildren: () => import('../pages/health-insurance/health-insurance.page.module').then(m => m.HealthInsurancePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Health Insurance here] off begin
					// % protected region % [Add any additional guards for Health Insurance here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Health Insurance here] off begin
						// % protected region % [Add additional roles to Health Insurance here] end
					],
					// % protected region % [Customise your data passed to Health Insurance here] off begin
					// % protected region % [Customise your data passed to Health Insurance here] end
				},
				// % protected region % [Add additional route properties here for health-insurance] off begin
				// % protected region % [Add additional route properties here for health-insurance] end
			},
			{
				path: 'hospital-bed-information-report',
				loadChildren: () => import('../pages/hospital-bed-information-report/hospital-bed-information-report.page.module').then(m => m.HospitalBedInformationReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Hospital Bed Information Report here] off begin
					// % protected region % [Add any additional guards for Hospital Bed Information Report here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Hospital Bed Information Report here] off begin
						// % protected region % [Add additional roles to Hospital Bed Information Report here] end
					],
					// % protected region % [Customise your data passed to Hospital Bed Information Report here] off begin
					// % protected region % [Customise your data passed to Hospital Bed Information Report here] end
				},
				// % protected region % [Add additional route properties here for hospital-bed-information-report] off begin
				// % protected region % [Add additional route properties here for hospital-bed-information-report] end
			},
			{
				path: 'hospital-branch-information-config',
				loadChildren: () => import('../pages/hospital-branch-information-config/hospital-branch-information-config.page.module').then(m => m.HospitalBranchInformationConfigPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Hospital Branch Information Config here] off begin
					// % protected region % [Add any additional guards for Hospital Branch Information Config here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Hospital Branch Information Config here] off begin
						// % protected region % [Add additional roles to Hospital Branch Information Config here] end
					],
					// % protected region % [Customise your data passed to Hospital Branch Information Config here] off begin
					// % protected region % [Customise your data passed to Hospital Branch Information Config here] end
				},
				// % protected region % [Add additional route properties here for hospital-branch-information-config] off begin
				// % protected region % [Add additional route properties here for hospital-branch-information-config] end
			},
			{
				path: 'hospital-group-information-config',
				loadChildren: () => import('../pages/hospital-group-information-config/hospital-group-information-config.page.module').then(m => m.HospitalGroupInformationConfigPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Hospital Group Information Config here] off begin
					// % protected region % [Add any additional guards for Hospital Group Information Config here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Hospital Group Information Config here] off begin
						// % protected region % [Add additional roles to Hospital Group Information Config here] end
					],
					// % protected region % [Customise your data passed to Hospital Group Information Config here] off begin
					// % protected region % [Customise your data passed to Hospital Group Information Config here] end
				},
				// % protected region % [Add additional route properties here for hospital-group-information-config] off begin
				// % protected region % [Add additional route properties here for hospital-group-information-config] end
			},
			{
				path: 'hospital-information-report',
				loadChildren: () => import('../pages/hospital-information-report/hospital-information-report.page.module').then(m => m.HospitalInformationReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Hospital Information Report here] off begin
					// % protected region % [Add any additional guards for Hospital Information Report here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Hospital Information Report here] off begin
						// % protected region % [Add additional roles to Hospital Information Report here] end
					],
					// % protected region % [Customise your data passed to Hospital Information Report here] off begin
					// % protected region % [Customise your data passed to Hospital Information Report here] end
				},
				// % protected region % [Add additional route properties here for hospital-information-report] off begin
				// % protected region % [Add additional route properties here for hospital-information-report] end
			},
			{
				path: 'hospital-performance-indicators-report',
				loadChildren: () => import('../pages/hospital-performance-indicators-report/hospital-performance-indicators-report.page.module').then(m => m.HospitalPerformanceIndicatorsReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Hospital Performance Indicators Report here] off begin
					// % protected region % [Add any additional guards for Hospital Performance Indicators Report here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Hospital Performance Indicators Report here] off begin
						// % protected region % [Add additional roles to Hospital Performance Indicators Report here] end
					],
					// % protected region % [Customise your data passed to Hospital Performance Indicators Report here] off begin
					// % protected region % [Customise your data passed to Hospital Performance Indicators Report here] end
				},
				// % protected region % [Add additional route properties here for hospital-performance-indicators-report] off begin
				// % protected region % [Add additional route properties here for hospital-performance-indicators-report] end
			},
			{
				path: 'hospital-staff-information-report',
				loadChildren: () => import('../pages/hospital-staff-information-report/hospital-staff-information-report.page.module').then(m => m.HospitalStaffInformationReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Hospital Staff Information Report here] off begin
					// % protected region % [Add any additional guards for Hospital Staff Information Report here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Hospital Staff Information Report here] off begin
						// % protected region % [Add additional roles to Hospital Staff Information Report here] end
					],
					// % protected region % [Customise your data passed to Hospital Staff Information Report here] off begin
					// % protected region % [Customise your data passed to Hospital Staff Information Report here] end
				},
				// % protected region % [Add additional route properties here for hospital-staff-information-report] off begin
				// % protected region % [Add additional route properties here for hospital-staff-information-report] end
			},
			{
				path: 'hospital-visitor-report',
				loadChildren: () => import('../pages/hospital-visitor-report/hospital-visitor-report.page.module').then(m => m.HospitalVisitorReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Hospital Visitor Report here] off begin
					// % protected region % [Add any additional guards for Hospital Visitor Report here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Hospital Visitor Report here] off begin
						// % protected region % [Add additional roles to Hospital Visitor Report here] end
					],
					// % protected region % [Customise your data passed to Hospital Visitor Report here] off begin
					// % protected region % [Customise your data passed to Hospital Visitor Report here] end
				},
				// % protected region % [Add additional route properties here for hospital-visitor-report] off begin
				// % protected region % [Add additional route properties here for hospital-visitor-report] end
			},
			{
				path: 'icd10',
				loadChildren: () => import('../pages/icd10/icd10.page.module').then(m => m.Icd10PageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for ICD10 here] off begin
					// % protected region % [Add any additional guards for ICD10 here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to ICD10 here] off begin
						// % protected region % [Add additional roles to ICD10 here] end
					],
					// % protected region % [Customise your data passed to ICD10 here] off begin
					// % protected region % [Customise your data passed to ICD10 here] end
				},
				// % protected region % [Add additional route properties here for icd10] off begin
				// % protected region % [Add additional route properties here for icd10] end
			},
			{
				path: 'icd9',
				loadChildren: () => import('../pages/icd9/icd9.page.module').then(m => m.Icd9PageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for ICD9 here] off begin
					// % protected region % [Add any additional guards for ICD9 here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to ICD9 here] off begin
						// % protected region % [Add additional roles to ICD9 here] end
					],
					// % protected region % [Customise your data passed to ICD9 here] off begin
					// % protected region % [Customise your data passed to ICD9 here] end
				},
				// % protected region % [Add additional route properties here for icd9] off begin
				// % protected region % [Add additional route properties here for icd9] end
			},
			{
				path: 'income-report',
				loadChildren: () => import('../pages/income-report/income-report.page.module').then(m => m.IncomeReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Income Report here] off begin
					// % protected region % [Add any additional guards for Income Report here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Income Report here] off begin
						// % protected region % [Add additional roles to Income Report here] end
					],
					// % protected region % [Customise your data passed to Income Report here] off begin
					// % protected region % [Customise your data passed to Income Report here] end
				},
				// % protected region % [Add additional route properties here for income-report] off begin
				// % protected region % [Add additional route properties here for income-report] end
			},
			{
				path: 'inpatient',
				loadChildren: () => import('../pages/inpatient/inpatient.page.module').then(m => m.InpatientPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inpatient here] off begin
					// % protected region % [Add any additional guards for Inpatient here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Inpatient here] off begin
						// % protected region % [Add additional roles to Inpatient here] end
					],
					// % protected region % [Customise your data passed to Inpatient here] off begin
					// % protected region % [Customise your data passed to Inpatient here] end
				},
				// % protected region % [Add additional route properties here for inpatient] off begin
				// % protected region % [Add additional route properties here for inpatient] end
			},
			{
				path: 'inpatient-admission',
				loadChildren: () => import('../pages/inpatient-admission/inpatient-admission.page.module').then(m => m.InpatientAdmissionPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inpatient Admission here] off begin
					// % protected region % [Add any additional guards for Inpatient Admission here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Inpatient Admission here] off begin
						// % protected region % [Add additional roles to Inpatient Admission here] end
					],
					// % protected region % [Customise your data passed to Inpatient Admission here] off begin
					// % protected region % [Customise your data passed to Inpatient Admission here] end
				},
				// % protected region % [Add additional route properties here for inpatient-admission] off begin
				// % protected region % [Add additional route properties here for inpatient-admission] end
			},
			{
				path: 'inpatient-disease-report',
				loadChildren: () => import('../pages/inpatient-disease-report/inpatient-disease-report.page.module').then(m => m.InpatientDiseaseReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inpatient Disease Report here] off begin
					// % protected region % [Add any additional guards for Inpatient Disease Report here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'PHARMACY_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to Inpatient Disease Report here] off begin
						// % protected region % [Add additional roles to Inpatient Disease Report here] end
					],
					// % protected region % [Customise your data passed to Inpatient Disease Report here] off begin
					// % protected region % [Customise your data passed to Inpatient Disease Report here] end
				},
				// % protected region % [Add additional route properties here for inpatient-disease-report] off begin
				// % protected region % [Add additional route properties here for inpatient-disease-report] end
			},
			{
				path: 'inpatient-examination',
				loadChildren: () => import('../pages/inpatient-examination/inpatient-examination.page.module').then(m => m.InpatientExaminationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inpatient Examination here] off begin
					// % protected region % [Add any additional guards for Inpatient Examination here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Inpatient Examination here] off begin
						// % protected region % [Add additional roles to Inpatient Examination here] end
					],
					// % protected region % [Customise your data passed to Inpatient Examination here] off begin
					// % protected region % [Customise your data passed to Inpatient Examination here] end
				},
				// % protected region % [Add additional route properties here for inpatient-examination] off begin
				// % protected region % [Add additional route properties here for inpatient-examination] end
			},
			{
				path: 'inpatient-examination-detail',
				loadChildren: () => import('../pages/inpatient-examination-detail/inpatient-examination-detail.page.module').then(m => m.InpatientExaminationDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inpatient Examination Detail here] off begin
					// % protected region % [Add any additional guards for Inpatient Examination Detail here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Inpatient Examination Detail here] off begin
						// % protected region % [Add additional roles to Inpatient Examination Detail here] end
					],
					// % protected region % [Customise your data passed to Inpatient Examination Detail here] off begin
					// % protected region % [Customise your data passed to Inpatient Examination Detail here] end
				},
				// % protected region % [Add additional route properties here for inpatient-examination-detail] off begin
				// % protected region % [Add additional route properties here for inpatient-examination-detail] end
			},
			{
				path: 'inpatient-morbidity-data-4a2-report',
				loadChildren: () => import('../pages/inpatient-morbidity-data-4a2-report/inpatient-morbidity-data-4a2-report.page.module').then(m => m.InpatientMorbidityData4A2ReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inpatient Morbidity Data 4A2 Report here] off begin
					// % protected region % [Add any additional guards for Inpatient Morbidity Data 4A2 Report here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Inpatient Morbidity Data 4A2 Report here] off begin
						// % protected region % [Add additional roles to Inpatient Morbidity Data 4A2 Report here] end
					],
					// % protected region % [Customise your data passed to Inpatient Morbidity Data 4A2 Report here] off begin
					// % protected region % [Customise your data passed to Inpatient Morbidity Data 4A2 Report here] end
				},
				// % protected region % [Add additional route properties here for inpatient-morbidity-data-4a2-report] off begin
				// % protected region % [Add additional route properties here for inpatient-morbidity-data-4a2-report] end
			},
			{
				path: 'inpatient-morbidity-data-report',
				loadChildren: () => import('../pages/inpatient-morbidity-data-report/inpatient-morbidity-data-report.page.module').then(m => m.InpatientMorbidityDataReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inpatient Morbidity Data Report here] off begin
					// % protected region % [Add any additional guards for Inpatient Morbidity Data Report here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Inpatient Morbidity Data Report here] off begin
						// % protected region % [Add additional roles to Inpatient Morbidity Data Report here] end
					],
					// % protected region % [Customise your data passed to Inpatient Morbidity Data Report here] off begin
					// % protected region % [Customise your data passed to Inpatient Morbidity Data Report here] end
				},
				// % protected region % [Add additional route properties here for inpatient-morbidity-data-report] off begin
				// % protected region % [Add additional route properties here for inpatient-morbidity-data-report] end
			},
			{
				path: 'inpatient-order',
				loadChildren: () => import('../pages/inpatient-order/inpatient-order.page.module').then(m => m.InpatientOrderPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inpatient Order here] off begin
					// % protected region % [Add any additional guards for Inpatient Order here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Inpatient Order here] off begin
						// % protected region % [Add additional roles to Inpatient Order here] end
					],
					// % protected region % [Customise your data passed to Inpatient Order here] off begin
					// % protected region % [Customise your data passed to Inpatient Order here] end
				},
				// % protected region % [Add additional route properties here for inpatient-order] off begin
				// % protected region % [Add additional route properties here for inpatient-order] end
			},
			{
				path: 'inpatient-service-activity-report',
				loadChildren: () => import('../pages/inpatient-service-activity-report/inpatient-service-activity-report.page.module').then(m => m.InpatientServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inpatient Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Inpatient Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Inpatient Service Activity Report here] off begin
						// % protected region % [Add additional roles to Inpatient Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Inpatient Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Inpatient Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for inpatient-service-activity-report] off begin
				// % protected region % [Add additional route properties here for inpatient-service-activity-report] end
			},
			{
				path: 'internal-order',
				loadChildren: () => import('../pages/internal-order/internal-order.page.module').then(m => m.InternalOrderPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Internal Order here] off begin
					// % protected region % [Add any additional guards for Internal Order here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Internal Order here] off begin
						// % protected region % [Add additional roles to Internal Order here] end
					],
					// % protected region % [Customise your data passed to Internal Order here] off begin
					// % protected region % [Customise your data passed to Internal Order here] end
				},
				// % protected region % [Add additional route properties here for internal-order] off begin
				// % protected region % [Add additional route properties here for internal-order] end
			},
			{
				path: 'internal-order-stock-detail',
				loadChildren: () => import('../pages/internal-order-stock-detail/internal-order-stock-detail.page.module').then(m => m.InternalOrderStockDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Internal Order Stock Detail here] off begin
					// % protected region % [Add any additional guards for Internal Order Stock Detail here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Internal Order Stock Detail here] off begin
						// % protected region % [Add additional roles to Internal Order Stock Detail here] end
					],
					// % protected region % [Customise your data passed to Internal Order Stock Detail here] off begin
					// % protected region % [Customise your data passed to Internal Order Stock Detail here] end
				},
				// % protected region % [Add additional route properties here for internal-order-stock-detail] off begin
				// % protected region % [Add additional route properties here for internal-order-stock-detail] end
			},
			{
				path: 'intraoperative-records',
				loadChildren: () => import('../pages/intraoperative-records/intraoperative-records.page.module').then(m => m.IntraoperativeRecordsPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Intraoperative Records here] off begin
					// % protected region % [Add any additional guards for Intraoperative Records here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Intraoperative Records here] off begin
						// % protected region % [Add additional roles to Intraoperative Records here] end
					],
					// % protected region % [Customise your data passed to Intraoperative Records here] off begin
					// % protected region % [Customise your data passed to Intraoperative Records here] end
				},
				// % protected region % [Add additional route properties here for intraoperative-records] off begin
				// % protected region % [Add additional route properties here for intraoperative-records] end
			},
			{
				path: 'inventory',
				loadChildren: () => import('../pages/inventory/inventory.page.module').then(m => m.InventoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory here] off begin
					// % protected region % [Add any additional guards for Inventory here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Inventory here] off begin
						// % protected region % [Add additional roles to Inventory here] end
					],
					// % protected region % [Customise your data passed to Inventory here] off begin
					// % protected region % [Customise your data passed to Inventory here] end
				},
				// % protected region % [Add additional route properties here for inventory] off begin
				// % protected region % [Add additional route properties here for inventory] end
			},
			{
				path: 'inventory-adjusment-wrapper',
				loadChildren: () => import('../pages/inventory-adjusment-wrapper/inventory-adjusment-wrapper.page.module').then(m => m.InventoryAdjusmentWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Adjusment Wrapper here] off begin
					// % protected region % [Add any additional guards for Inventory Adjusment Wrapper here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Inventory Adjusment Wrapper here] off begin
						// % protected region % [Add additional roles to Inventory Adjusment Wrapper here] end
					],
					// % protected region % [Customise your data passed to Inventory Adjusment Wrapper here] off begin
					// % protected region % [Customise your data passed to Inventory Adjusment Wrapper here] end
				},
				// % protected region % [Add additional route properties here for inventory-adjusment-wrapper] off begin
				// % protected region % [Add additional route properties here for inventory-adjusment-wrapper] end
			},
			{
				path: 'inventory-adjustment',
				loadChildren: () => import('../pages/inventory-adjustment/inventory-adjustment.page.module').then(m => m.InventoryAdjustmentPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Adjustment here] off begin
					// % protected region % [Add any additional guards for Inventory Adjustment here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Inventory Adjustment here] off begin
						// % protected region % [Add additional roles to Inventory Adjustment here] end
					],
					// % protected region % [Customise your data passed to Inventory Adjustment here] off begin
					// % protected region % [Customise your data passed to Inventory Adjustment here] end
				},
				// % protected region % [Add additional route properties here for inventory-adjustment] off begin
				// % protected region % [Add additional route properties here for inventory-adjustment] end
			},
			{
				path: 'inventory-enquiry',
				loadChildren: () => import('../pages/inventory-enquiry/inventory-enquiry.page.module').then(m => m.InventoryEnquiryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Enquiry here] off begin
					// % protected region % [Add any additional guards for Inventory Enquiry here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Inventory Enquiry here] off begin
						// % protected region % [Add additional roles to Inventory Enquiry here] end
					],
					// % protected region % [Customise your data passed to Inventory Enquiry here] off begin
					// % protected region % [Customise your data passed to Inventory Enquiry here] end
				},
				// % protected region % [Add additional route properties here for inventory-enquiry] off begin
				// % protected region % [Add additional route properties here for inventory-enquiry] end
			},
			{
				path: 'inventory-enquiry-inventory-transaction',
				loadChildren: () => import('../pages/inventory-enquiry-inventory-transaction/inventory-enquiry-inventory-transaction.page.module').then(m => m.InventoryEnquiryInventoryTransactionPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Enquiry Inventory Transaction here] off begin
					// % protected region % [Add any additional guards for Inventory Enquiry Inventory Transaction here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Inventory Enquiry Inventory Transaction here] off begin
						// % protected region % [Add additional roles to Inventory Enquiry Inventory Transaction here] end
					],
					// % protected region % [Customise your data passed to Inventory Enquiry Inventory Transaction here] off begin
					// % protected region % [Customise your data passed to Inventory Enquiry Inventory Transaction here] end
				},
				// % protected region % [Add additional route properties here for inventory-enquiry-inventory-transaction] off begin
				// % protected region % [Add additional route properties here for inventory-enquiry-inventory-transaction] end
			},
			{
				path: 'inventory-enquiry-stock-expiration-balance',
				loadChildren: () => import('../pages/inventory-enquiry-stock-expiration-balance/inventory-enquiry-stock-expiration-balance.page.module').then(m => m.InventoryEnquiryStockExpirationBalancePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Expiration Balance here] off begin
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Expiration Balance here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Inventory Enquiry Stock Expiration Balance here] off begin
						// % protected region % [Add additional roles to Inventory Enquiry Stock Expiration Balance here] end
					],
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Expiration Balance here] off begin
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Expiration Balance here] end
				},
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-expiration-balance] off begin
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-expiration-balance] end
			},
			{
				path: 'inventory-enquiry-stock-expiration-detail',
				loadChildren: () => import('../pages/inventory-enquiry-stock-expiration-detail/inventory-enquiry-stock-expiration-detail.page.module').then(m => m.InventoryEnquiryStockExpirationDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Expiration Detail here] off begin
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Expiration Detail here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Inventory Enquiry Stock Expiration Detail here] off begin
						// % protected region % [Add additional roles to Inventory Enquiry Stock Expiration Detail here] end
					],
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Expiration Detail here] off begin
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Expiration Detail here] end
				},
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-expiration-detail] off begin
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-expiration-detail] end
			},
			{
				path: 'inventory-enquiry-stock-expiration-history',
				loadChildren: () => import('../pages/inventory-enquiry-stock-expiration-history/inventory-enquiry-stock-expiration-history.page.module').then(m => m.InventoryEnquiryStockExpirationHistoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Expiration History here] off begin
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Expiration History here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to Inventory Enquiry Stock Expiration History here] off begin
						// % protected region % [Add additional roles to Inventory Enquiry Stock Expiration History here] end
					],
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Expiration History here] off begin
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Expiration History here] end
				},
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-expiration-history] off begin
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-expiration-history] end
			},
			{
				path: 'inventory-enquiry-stock-mutation',
				loadChildren: () => import('../pages/inventory-enquiry-stock-mutation/inventory-enquiry-stock-mutation.page.module').then(m => m.InventoryEnquiryStockMutationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Mutation here] off begin
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Mutation here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Inventory Enquiry Stock Mutation here] off begin
						// % protected region % [Add additional roles to Inventory Enquiry Stock Mutation here] end
					],
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Mutation here] off begin
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Mutation here] end
				},
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-mutation] off begin
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-mutation] end
			},
			{
				path: 'inventory-enquiry-stock-summary',
				loadChildren: () => import('../pages/inventory-enquiry-stock-summary/inventory-enquiry-stock-summary.page.module').then(m => m.InventoryEnquiryStockSummaryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Summary here] off begin
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Summary here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Inventory Enquiry Stock Summary here] off begin
						// % protected region % [Add additional roles to Inventory Enquiry Stock Summary here] end
					],
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Summary here] off begin
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Summary here] end
				},
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-summary] off begin
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-summary] end
			},
			{
				path: 'inventory-enquiry-stock-transaction-detail',
				loadChildren: () => import('../pages/inventory-enquiry-stock-transaction-detail/inventory-enquiry-stock-transaction-detail.page.module').then(m => m.InventoryEnquiryStockTransactionDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Transaction Detail here] off begin
					// % protected region % [Add any additional guards for Inventory Enquiry Stock Transaction Detail here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Inventory Enquiry Stock Transaction Detail here] off begin
						// % protected region % [Add additional roles to Inventory Enquiry Stock Transaction Detail here] end
					],
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Transaction Detail here] off begin
					// % protected region % [Customise your data passed to Inventory Enquiry Stock Transaction Detail here] end
				},
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-transaction-detail] off begin
				// % protected region % [Add additional route properties here for inventory-enquiry-stock-transaction-detail] end
			},
			{
				path: 'invoice-component-report',
				loadChildren: () => import('../pages/invoice-component-report/invoice-component-report.page.module').then(m => m.InvoiceComponentReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Invoice Component Report here] off begin
					// % protected region % [Add any additional guards for Invoice Component Report here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Invoice Component Report here] off begin
						// % protected region % [Add additional roles to Invoice Component Report here] end
					],
					// % protected region % [Customise your data passed to Invoice Component Report here] off begin
					// % protected region % [Customise your data passed to Invoice Component Report here] end
				},
				// % protected region % [Add additional route properties here for invoice-component-report] off begin
				// % protected region % [Add additional route properties here for invoice-component-report] end
			},
			{
				path: 'invoice-item-report',
				loadChildren: () => import('../pages/invoice-item-report/invoice-item-report.page.module').then(m => m.InvoiceItemReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Invoice Item Report here] off begin
					// % protected region % [Add any additional guards for Invoice Item Report here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Invoice Item Report here] off begin
						// % protected region % [Add additional roles to Invoice Item Report here] end
					],
					// % protected region % [Customise your data passed to Invoice Item Report here] off begin
					// % protected region % [Customise your data passed to Invoice Item Report here] end
				},
				// % protected region % [Add additional route properties here for invoice-item-report] off begin
				// % protected region % [Add additional route properties here for invoice-item-report] end
			},
			{
				path: 'invoice-report',
				loadChildren: () => import('../pages/invoice-report/invoice-report.page.module').then(m => m.InvoiceReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Invoice Report here] off begin
					// % protected region % [Add any additional guards for Invoice Report here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Invoice Report here] off begin
						// % protected region % [Add additional roles to Invoice Report here] end
					],
					// % protected region % [Customise your data passed to Invoice Report here] off begin
					// % protected region % [Customise your data passed to Invoice Report here] end
				},
				// % protected region % [Add additional route properties here for invoice-report] off begin
				// % protected region % [Add additional route properties here for invoice-report] end
			},
			{
				path: 'journal',
				loadChildren: () => import('../pages/journal/journal.page.module').then(m => m.JournalPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Journal here] off begin
					// % protected region % [Add any additional guards for Journal here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Journal here] off begin
						// % protected region % [Add additional roles to Journal here] end
					],
					// % protected region % [Customise your data passed to Journal here] off begin
					// % protected region % [Customise your data passed to Journal here] end
				},
				// % protected region % [Add additional route properties here for journal] off begin
				// % protected region % [Add additional route properties here for journal] end
			},
			{
				path: 'kms-home',
				loadChildren: () => import('../pages/kms-home/kms-home.page.module').then(m => m.KmsHomePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for KMS Home here] off begin
					// % protected region % [Add any additional guards for KMS Home here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to KMS Home here] off begin
						// % protected region % [Add additional roles to KMS Home here] end
					],
					// % protected region % [Customise your data passed to KMS Home here] off begin
					// % protected region % [Customise your data passed to KMS Home here] end
				},
				// % protected region % [Add additional route properties here for kms-home] off begin
				// % protected region % [Add additional route properties here for kms-home] end
			},
			{
				path: 'laboratory-service-activity-report',
				loadChildren: () => import('../pages/laboratory-service-activity-report/laboratory-service-activity-report.page.module').then(m => m.LaboratoryServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Laboratory Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Laboratory Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Laboratory Service Activity Report here] off begin
						// % protected region % [Add additional roles to Laboratory Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Laboratory Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Laboratory Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for laboratory-service-activity-report] off begin
				// % protected region % [Add additional route properties here for laboratory-service-activity-report] end
			},
			{
				path: 'mcu-package',
				loadChildren: () => import('../pages/mcu-package/mcu-package.page.module').then(m => m.McuPackagePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for MCU Package here] off begin
					// % protected region % [Add any additional guards for MCU Package here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to MCU Package here] off begin
						// % protected region % [Add additional roles to MCU Package here] end
					],
					// % protected region % [Customise your data passed to MCU Package here] off begin
					// % protected region % [Customise your data passed to MCU Package here] end
				},
				// % protected region % [Add additional route properties here for mcu-package] off begin
				// % protected region % [Add additional route properties here for mcu-package] end
			},
			{
				path: 'mcu-package-detail',
				loadChildren: () => import('../pages/mcu-package-detail/mcu-package-detail.page.module').then(m => m.McuPackageDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for MCU Package Detail here] off begin
					// % protected region % [Add any additional guards for MCU Package Detail here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to MCU Package Detail here] off begin
						// % protected region % [Add additional roles to MCU Package Detail here] end
					],
					// % protected region % [Customise your data passed to MCU Package Detail here] off begin
					// % protected region % [Customise your data passed to MCU Package Detail here] end
				},
				// % protected region % [Add additional route properties here for mcu-package-detail] off begin
				// % protected region % [Add additional route properties here for mcu-package-detail] end
			},
			{
				path: 'mcu-package-item',
				loadChildren: () => import('../pages/mcu-package-item/mcu-package-item.page.module').then(m => m.McuPackageItemPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for MCU Package Item here] off begin
					// % protected region % [Add any additional guards for MCU Package Item here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to MCU Package Item here] off begin
						// % protected region % [Add additional roles to MCU Package Item here] end
					],
					// % protected region % [Customise your data passed to MCU Package Item here] off begin
					// % protected region % [Customise your data passed to MCU Package Item here] end
				},
				// % protected region % [Add additional route properties here for mcu-package-item] off begin
				// % protected region % [Add additional route properties here for mcu-package-item] end
			},
			{
				path: 'master-catalogue-report',
				loadChildren: () => import('../pages/master-catalogue-report/master-catalogue-report.page.module').then(m => m.MasterCatalogueReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Master Catalogue Report here] off begin
					// % protected region % [Add any additional guards for Master Catalogue Report here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Master Catalogue Report here] off begin
						// % protected region % [Add additional roles to Master Catalogue Report here] end
					],
					// % protected region % [Customise your data passed to Master Catalogue Report here] off begin
					// % protected region % [Customise your data passed to Master Catalogue Report here] end
				},
				// % protected region % [Add additional route properties here for master-catalogue-report] off begin
				// % protected region % [Add additional route properties here for master-catalogue-report] end
			},
			{
				path: 'master-patient-report',
				loadChildren: () => import('../pages/master-patient-report/master-patient-report.page.module').then(m => m.MasterPatientReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Master Patient Report here] off begin
					// % protected region % [Add any additional guards for Master Patient Report here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Master Patient Report here] off begin
						// % protected region % [Add additional roles to Master Patient Report here] end
					],
					// % protected region % [Customise your data passed to Master Patient Report here] off begin
					// % protected region % [Customise your data passed to Master Patient Report here] end
				},
				// % protected region % [Add additional route properties here for master-patient-report] off begin
				// % protected region % [Add additional route properties here for master-patient-report] end
			},
			{
				path: 'medical-examination-record',
				loadChildren: () => import('../pages/medical-examination-record/medical-examination-record.page.module').then(m => m.MedicalExaminationRecordPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medical Examination Record here] off begin
					// % protected region % [Add any additional guards for Medical Examination Record here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Medical Examination Record here] off begin
						// % protected region % [Add additional roles to Medical Examination Record here] end
					],
					// % protected region % [Customise your data passed to Medical Examination Record here] off begin
					// % protected region % [Customise your data passed to Medical Examination Record here] end
				},
				// % protected region % [Add additional route properties here for medical-examination-record] off begin
				// % protected region % [Add additional route properties here for medical-examination-record] end
			},
			{
				path: 'medical-fee',
				loadChildren: () => import('../pages/medical-fee/medical-fee.page.module').then(m => m.MedicalFeePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medical Fee here] off begin
					// % protected region % [Add any additional guards for Medical Fee here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Medical Fee here] off begin
						// % protected region % [Add additional roles to Medical Fee here] end
					],
					// % protected region % [Customise your data passed to Medical Fee here] off begin
					// % protected region % [Customise your data passed to Medical Fee here] end
				},
				// % protected region % [Add additional route properties here for medical-fee] off begin
				// % protected region % [Add additional route properties here for medical-fee] end
			},
			{
				path: 'medical-record-checklist',
				loadChildren: () => import('../pages/medical-record-checklist/medical-record-checklist.page.module').then(m => m.MedicalRecordChecklistPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medical Record Checklist here] off begin
					// % protected region % [Add any additional guards for Medical Record Checklist here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Medical Record Checklist here] off begin
						// % protected region % [Add additional roles to Medical Record Checklist here] end
					],
					// % protected region % [Customise your data passed to Medical Record Checklist here] off begin
					// % protected region % [Customise your data passed to Medical Record Checklist here] end
				},
				// % protected region % [Add additional route properties here for medical-record-checklist] off begin
				// % protected region % [Add additional route properties here for medical-record-checklist] end
			},
			{
				path: 'medical-record-report',
				loadChildren: () => import('../pages/medical-record-report/medical-record-report.page.module').then(m => m.MedicalRecordReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medical Record Report here] off begin
					// % protected region % [Add any additional guards for Medical Record Report here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Medical Record Report here] off begin
						// % protected region % [Add additional roles to Medical Record Report here] end
					],
					// % protected region % [Customise your data passed to Medical Record Report here] off begin
					// % protected region % [Customise your data passed to Medical Record Report here] end
				},
				// % protected region % [Add additional route properties here for medical-record-report] off begin
				// % protected region % [Add additional route properties here for medical-record-report] end
			},
			{
				path: 'medical-rehabilitation-service-activity-report',
				loadChildren: () => import('../pages/medical-rehabilitation-service-activity-report/medical-rehabilitation-service-activity-report.page.module').then(m => m.MedicalRehabilitationServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medical Rehabilitation Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Medical Rehabilitation Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Medical Rehabilitation Service Activity Report here] off begin
						// % protected region % [Add additional roles to Medical Rehabilitation Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Medical Rehabilitation Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Medical Rehabilitation Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for medical-rehabilitation-service-activity-report] off begin
				// % protected region % [Add additional route properties here for medical-rehabilitation-service-activity-report] end
			},
			{
				path: 'medication-administered-history',
				loadChildren: () => import('../pages/medication-administered-history/medication-administered-history.page.module').then(m => m.MedicationAdministeredHistoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medication Administered History here] off begin
					// % protected region % [Add any additional guards for Medication Administered History here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Medication Administered History here] off begin
						// % protected region % [Add additional roles to Medication Administered History here] end
					],
					// % protected region % [Customise your data passed to Medication Administered History here] off begin
					// % protected region % [Customise your data passed to Medication Administered History here] end
				},
				// % protected region % [Add additional route properties here for medication-administered-history] off begin
				// % protected region % [Add additional route properties here for medication-administered-history] end
			},
			{
				path: 'medication-compound',
				loadChildren: () => import('../pages/medication-compound/medication-compound.page.module').then(m => m.MedicationCompoundPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medication Compound here] off begin
					// % protected region % [Add any additional guards for Medication Compound here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Medication Compound here] off begin
						// % protected region % [Add additional roles to Medication Compound here] end
					],
					// % protected region % [Customise your data passed to Medication Compound here] off begin
					// % protected region % [Customise your data passed to Medication Compound here] end
				},
				// % protected region % [Add additional route properties here for medication-compound] off begin
				// % protected region % [Add additional route properties here for medication-compound] end
			},
			{
				path: 'medication-detail',
				loadChildren: () => import('../pages/medication-detail/medication-detail.page.module').then(m => m.MedicationDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medication Detail here] off begin
					// % protected region % [Add any additional guards for Medication Detail here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Medication Detail here] off begin
						// % protected region % [Add additional roles to Medication Detail here] end
					],
					// % protected region % [Customise your data passed to Medication Detail here] off begin
					// % protected region % [Customise your data passed to Medication Detail here] end
				},
				// % protected region % [Add additional route properties here for medication-detail] off begin
				// % protected region % [Add additional route properties here for medication-detail] end
			},
			{
				path: 'medication-dispensing',
				loadChildren: () => import('../pages/medication-dispensing/medication-dispensing.page.module').then(m => m.MedicationDispensingPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medication Dispensing here] off begin
					// % protected region % [Add any additional guards for Medication Dispensing here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to Medication Dispensing here] off begin
						// % protected region % [Add additional roles to Medication Dispensing here] end
					],
					// % protected region % [Customise your data passed to Medication Dispensing here] off begin
					// % protected region % [Customise your data passed to Medication Dispensing here] end
				},
				// % protected region % [Add additional route properties here for medication-dispensing] off begin
				// % protected region % [Add additional route properties here for medication-dispensing] end
			},
			{
				path: 'medication-item',
				loadChildren: () => import('../pages/medication-item/medication-item.page.module').then(m => m.MedicationItemPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Medication Item here] off begin
					// % protected region % [Add any additional guards for Medication Item here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Medication Item here] off begin
						// % protected region % [Add additional roles to Medication Item here] end
					],
					// % protected region % [Customise your data passed to Medication Item here] off begin
					// % protected region % [Customise your data passed to Medication Item here] end
				},
				// % protected region % [Add additional route properties here for medication-item] off begin
				// % protected region % [Add additional route properties here for medication-item] end
			},
			{
				path: 'merchant-bank',
				loadChildren: () => import('../pages/merchant-bank/merchant-bank.page.module').then(m => m.MerchantBankPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Merchant Bank here] off begin
					// % protected region % [Add any additional guards for Merchant Bank here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Merchant Bank here] off begin
						// % protected region % [Add additional roles to Merchant Bank here] end
					],
					// % protected region % [Customise your data passed to Merchant Bank here] off begin
					// % protected region % [Customise your data passed to Merchant Bank here] end
				},
				// % protected region % [Add additional route properties here for merchant-bank] off begin
				// % protected region % [Add additional route properties here for merchant-bank] end
			},
			{
				path: 'merchant-surcharge-fee',
				loadChildren: () => import('../pages/merchant-surcharge-fee/merchant-surcharge-fee.page.module').then(m => m.MerchantSurchargeFeePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Merchant Surcharge Fee here] off begin
					// % protected region % [Add any additional guards for Merchant Surcharge Fee here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Merchant Surcharge Fee here] off begin
						// % protected region % [Add additional roles to Merchant Surcharge Fee here] end
					],
					// % protected region % [Customise your data passed to Merchant Surcharge Fee here] off begin
					// % protected region % [Customise your data passed to Merchant Surcharge Fee here] end
				},
				// % protected region % [Add additional route properties here for merchant-surcharge-fee] off begin
				// % protected region % [Add additional route properties here for merchant-surcharge-fee] end
			},
			{
				path: 'newborn-detail',
				loadChildren: () => import('../pages/newborn-detail/newborn-detail.page.module').then(m => m.NewbornDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Newborn Detail here] off begin
					// % protected region % [Add any additional guards for Newborn Detail here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Newborn Detail here] off begin
						// % protected region % [Add additional roles to Newborn Detail here] end
					],
					// % protected region % [Customise your data passed to Newborn Detail here] off begin
					// % protected region % [Customise your data passed to Newborn Detail here] end
				},
				// % protected region % [Add additional route properties here for newborn-detail] off begin
				// % protected region % [Add additional route properties here for newborn-detail] end
			},
			{
				path: 'non-compound-drug',
				loadChildren: () => import('../pages/non-compound-drug/non-compound-drug.page.module').then(m => m.NonCompoundDrugPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Non Compound Drug here] off begin
					// % protected region % [Add any additional guards for Non Compound Drug here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Non Compound Drug here] off begin
						// % protected region % [Add additional roles to Non Compound Drug here] end
					],
					// % protected region % [Customise your data passed to Non Compound Drug here] off begin
					// % protected region % [Customise your data passed to Non Compound Drug here] end
				},
				// % protected region % [Add additional route properties here for non-compound-drug] off begin
				// % protected region % [Add additional route properties here for non-compound-drug] end
			},
			{
				path: 'numbering-setup',
				loadChildren: () => import('../pages/numbering-setup/numbering-setup.page.module').then(m => m.NumberingSetupPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Numbering Setup here] off begin
					// % protected region % [Add any additional guards for Numbering Setup here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Numbering Setup here] off begin
						// % protected region % [Add additional roles to Numbering Setup here] end
					],
					// % protected region % [Customise your data passed to Numbering Setup here] off begin
					// % protected region % [Customise your data passed to Numbering Setup here] end
				},
				// % protected region % [Add additional route properties here for numbering-setup] off begin
				// % protected region % [Add additional route properties here for numbering-setup] end
			},
			{
				path: 'nurse-vital-sign-measurement',
				loadChildren: () => import('../pages/nurse-vital-sign-measurement/nurse-vital-sign-measurement.page.module').then(m => m.NurseVitalSignMeasurementPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Nurse Vital Sign Measurement here] off begin
					// % protected region % [Add any additional guards for Nurse Vital Sign Measurement here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Nurse Vital Sign Measurement here] off begin
						// % protected region % [Add additional roles to Nurse Vital Sign Measurement here] end
					],
					// % protected region % [Customise your data passed to Nurse Vital Sign Measurement here] off begin
					// % protected region % [Customise your data passed to Nurse Vital Sign Measurement here] end
				},
				// % protected region % [Add additional route properties here for nurse-vital-sign-measurement] off begin
				// % protected region % [Add additional route properties here for nurse-vital-sign-measurement] end
			},
			{
				path: 'obstetric-and-gynecology-history',
				loadChildren: () => import('../pages/obstetric-and-gynecology-history/obstetric-and-gynecology-history.page.module').then(m => m.ObstetricAndGynecologyHistoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Obstetric And Gynecology History here] off begin
					// % protected region % [Add any additional guards for Obstetric And Gynecology History here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Obstetric And Gynecology History here] off begin
						// % protected region % [Add additional roles to Obstetric And Gynecology History here] end
					],
					// % protected region % [Customise your data passed to Obstetric And Gynecology History here] off begin
					// % protected region % [Customise your data passed to Obstetric And Gynecology History here] end
				},
				// % protected region % [Add additional route properties here for obstetric-and-gynecology-history] off begin
				// % protected region % [Add additional route properties here for obstetric-and-gynecology-history] end
			},
			{
				path: 'obstetric-service-activity-report',
				loadChildren: () => import('../pages/obstetric-service-activity-report/obstetric-service-activity-report.page.module').then(m => m.ObstetricServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Obstetric Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Obstetric Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Obstetric Service Activity Report here] off begin
						// % protected region % [Add additional roles to Obstetric Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Obstetric Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Obstetric Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for obstetric-service-activity-report] off begin
				// % protected region % [Add additional route properties here for obstetric-service-activity-report] end
			},
			{
				path: 'operating-theater-medical-examination-record',
				loadChildren: () => import('../pages/operating-theater-medical-examination-record/operating-theater-medical-examination-record.page.module').then(m => m.OperatingTheaterMedicalExaminationRecordPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Operating Theater Medical Examination Record here] off begin
					// % protected region % [Add any additional guards for Operating Theater Medical Examination Record here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Operating Theater Medical Examination Record here] off begin
						// % protected region % [Add additional roles to Operating Theater Medical Examination Record here] end
					],
					// % protected region % [Customise your data passed to Operating Theater Medical Examination Record here] off begin
					// % protected region % [Customise your data passed to Operating Theater Medical Examination Record here] end
				},
				// % protected region % [Add additional route properties here for operating-theater-medical-examination-record] off begin
				// % protected region % [Add additional route properties here for operating-theater-medical-examination-record] end
			},
			{
				path: 'operating-theater-service-activity-report',
				loadChildren: () => import('../pages/operating-theater-service-activity-report/operating-theater-service-activity-report.page.module').then(m => m.OperatingTheaterServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Operating Theater Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Operating Theater Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Operating Theater Service Activity Report here] off begin
						// % protected region % [Add additional roles to Operating Theater Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Operating Theater Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Operating Theater Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for operating-theater-service-activity-report] off begin
				// % protected region % [Add additional route properties here for operating-theater-service-activity-report] end
			},
			{
				path: 'operating-theatre',
				loadChildren: () => import('../pages/operating-theatre/operating-theatre.page.module').then(m => m.OperatingTheatrePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Operating Theatre here] off begin
					// % protected region % [Add any additional guards for Operating Theatre here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Operating Theatre here] off begin
						// % protected region % [Add additional roles to Operating Theatre here] end
					],
					// % protected region % [Customise your data passed to Operating Theatre here] off begin
					// % protected region % [Customise your data passed to Operating Theatre here] end
				},
				// % protected region % [Add additional route properties here for operating-theatre] off begin
				// % protected region % [Add additional route properties here for operating-theatre] end
			},
			{
				path: 'operational-dashboard',
				loadChildren: () => import('../pages/operational-dashboard/operational-dashboard.page.module').then(m => m.OperationalDashboardPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Operational Dashboard here] off begin
					// % protected region % [Add any additional guards for Operational Dashboard here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Operational Dashboard here] off begin
						// % protected region % [Add additional roles to Operational Dashboard here] end
					],
					// % protected region % [Customise your data passed to Operational Dashboard here] off begin
					// % protected region % [Customise your data passed to Operational Dashboard here] end
				},
				// % protected region % [Add additional route properties here for operational-dashboard] off begin
				// % protected region % [Add additional route properties here for operational-dashboard] end
			},
			{
				path: 'outpatient',
				loadChildren: () => import('../pages/outpatient/outpatient.page.module').then(m => m.OutpatientPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Outpatient here] off begin
					// % protected region % [Add any additional guards for Outpatient here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Outpatient here] off begin
						// % protected region % [Add additional roles to Outpatient here] end
					],
					// % protected region % [Customise your data passed to Outpatient here] off begin
					// % protected region % [Customise your data passed to Outpatient here] end
				},
				// % protected region % [Add additional route properties here for outpatient] off begin
				// % protected region % [Add additional route properties here for outpatient] end
			},
			{
				path: 'outpatient-disease-report',
				loadChildren: () => import('../pages/outpatient-disease-report/outpatient-disease-report.page.module').then(m => m.OutpatientDiseaseReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Outpatient Disease Report here] off begin
					// % protected region % [Add any additional guards for Outpatient Disease Report here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Outpatient Disease Report here] off begin
						// % protected region % [Add additional roles to Outpatient Disease Report here] end
					],
					// % protected region % [Customise your data passed to Outpatient Disease Report here] off begin
					// % protected region % [Customise your data passed to Outpatient Disease Report here] end
				},
				// % protected region % [Add additional route properties here for outpatient-disease-report] off begin
				// % protected region % [Add additional route properties here for outpatient-disease-report] end
			},
			{
				path: 'outpatient-examination',
				loadChildren: () => import('../pages/outpatient-examination/outpatient-examination.page.module').then(m => m.OutpatientExaminationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Outpatient Examination here] off begin
					// % protected region % [Add any additional guards for Outpatient Examination here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Outpatient Examination here] off begin
						// % protected region % [Add additional roles to Outpatient Examination here] end
					],
					// % protected region % [Customise your data passed to Outpatient Examination here] off begin
					// % protected region % [Customise your data passed to Outpatient Examination here] end
				},
				// % protected region % [Add additional route properties here for outpatient-examination] off begin
				// % protected region % [Add additional route properties here for outpatient-examination] end
			},
			{
				path: 'outpatient-examination-detail',
				loadChildren: () => import('../pages/outpatient-examination-detail/outpatient-examination-detail.page.module').then(m => m.OutpatientExaminationDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Outpatient Examination Detail here] off begin
					// % protected region % [Add any additional guards for Outpatient Examination Detail here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to Outpatient Examination Detail here] off begin
						// % protected region % [Add additional roles to Outpatient Examination Detail here] end
					],
					// % protected region % [Customise your data passed to Outpatient Examination Detail here] off begin
					// % protected region % [Customise your data passed to Outpatient Examination Detail here] end
				},
				// % protected region % [Add additional route properties here for outpatient-examination-detail] off begin
				// % protected region % [Add additional route properties here for outpatient-examination-detail] end
			},
			{
				path: 'outpatient-morbidity-data-4b-report',
				loadChildren: () => import('../pages/outpatient-morbidity-data-4b-report/outpatient-morbidity-data-4b-report.page.module').then(m => m.OutpatientMorbidityData4BReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Outpatient Morbidity Data 4B Report here] off begin
					// % protected region % [Add any additional guards for Outpatient Morbidity Data 4B Report here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Outpatient Morbidity Data 4B Report here] off begin
						// % protected region % [Add additional roles to Outpatient Morbidity Data 4B Report here] end
					],
					// % protected region % [Customise your data passed to Outpatient Morbidity Data 4B Report here] off begin
					// % protected region % [Customise your data passed to Outpatient Morbidity Data 4B Report here] end
				},
				// % protected region % [Add additional route properties here for outpatient-morbidity-data-4b-report] off begin
				// % protected region % [Add additional route properties here for outpatient-morbidity-data-4b-report] end
			},
			{
				path: 'outpatient-morbidity-data-4b2-report',
				loadChildren: () => import('../pages/outpatient-morbidity-data-4b2-report/outpatient-morbidity-data-4b2-report.page.module').then(m => m.OutpatientMorbidityData4B2ReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Outpatient Morbidity Data 4B2 Report here] off begin
					// % protected region % [Add any additional guards for Outpatient Morbidity Data 4B2 Report here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Outpatient Morbidity Data 4B2 Report here] off begin
						// % protected region % [Add additional roles to Outpatient Morbidity Data 4B2 Report here] end
					],
					// % protected region % [Customise your data passed to Outpatient Morbidity Data 4B2 Report here] off begin
					// % protected region % [Customise your data passed to Outpatient Morbidity Data 4B2 Report here] end
				},
				// % protected region % [Add additional route properties here for outpatient-morbidity-data-4b2-report] off begin
				// % protected region % [Add additional route properties here for outpatient-morbidity-data-4b2-report] end
			},
			{
				path: 'outpatient-visit-report',
				loadChildren: () => import('../pages/outpatient-visit-report/outpatient-visit-report.page.module').then(m => m.OutpatientVisitReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Outpatient Visit Report here] off begin
					// % protected region % [Add any additional guards for Outpatient Visit Report here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Outpatient Visit Report here] off begin
						// % protected region % [Add additional roles to Outpatient Visit Report here] end
					],
					// % protected region % [Customise your data passed to Outpatient Visit Report here] off begin
					// % protected region % [Customise your data passed to Outpatient Visit Report here] end
				},
				// % protected region % [Add additional route properties here for outpatient-visit-report] off begin
				// % protected region % [Add additional route properties here for outpatient-visit-report] end
			},
			{
				path: 'outpatient-visitor-information-report',
				loadChildren: () => import('../pages/outpatient-visitor-information-report/outpatient-visitor-information-report.page.module').then(m => m.OutpatientVisitorInformationReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Outpatient Visitor Information Report here] off begin
					// % protected region % [Add any additional guards for Outpatient Visitor Information Report here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Outpatient Visitor Information Report here] off begin
						// % protected region % [Add additional roles to Outpatient Visitor Information Report here] end
					],
					// % protected region % [Customise your data passed to Outpatient Visitor Information Report here] off begin
					// % protected region % [Customise your data passed to Outpatient Visitor Information Report here] end
				},
				// % protected region % [Add additional route properties here for outpatient-visitor-information-report] off begin
				// % protected region % [Add additional route properties here for outpatient-visitor-information-report] end
			},
			{
				path: 'pcare',
				loadChildren: () => import('../pages/pcare/pcare.page.module').then(m => m.PcarePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare here] off begin
					// % protected region % [Add any additional guards for PCare here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to PCare here] off begin
						// % protected region % [Add additional roles to PCare here] end
					],
					// % protected region % [Customise your data passed to PCare here] off begin
					// % protected region % [Customise your data passed to PCare here] end
				},
				// % protected region % [Add additional route properties here for pcare] off begin
				// % protected region % [Add additional route properties here for pcare] end
			},
			{
				path: 'pcare-club-prolanis',
				loadChildren: () => import('../pages/pcare-club-prolanis/pcare-club-prolanis.page.module').then(m => m.PcareClubProlanisPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Club Prolanis here] off begin
					// % protected region % [Add any additional guards for PCare Club Prolanis here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to PCare Club Prolanis here] off begin
						// % protected region % [Add additional roles to PCare Club Prolanis here] end
					],
					// % protected region % [Customise your data passed to PCare Club Prolanis here] off begin
					// % protected region % [Customise your data passed to PCare Club Prolanis here] end
				},
				// % protected region % [Add additional route properties here for pcare-club-prolanis] off begin
				// % protected region % [Add additional route properties here for pcare-club-prolanis] end
			},
			{
				path: 'pcare-configuration',
				loadChildren: () => import('../pages/pcare-configuration/pcare-configuration.page.module').then(m => m.PcareConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Configuration here] off begin
					// % protected region % [Add any additional guards for PCare Configuration here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to PCare Configuration here] off begin
						// % protected region % [Add additional roles to PCare Configuration here] end
					],
					// % protected region % [Customise your data passed to PCare Configuration here] off begin
					// % protected region % [Customise your data passed to PCare Configuration here] end
				},
				// % protected region % [Add additional route properties here for pcare-configuration] off begin
				// % protected region % [Add additional route properties here for pcare-configuration] end
			},
			{
				path: 'pcare-daftar-pendaftaran',
				loadChildren: () => import('../pages/pcare-daftar-pendaftaran/pcare-daftar-pendaftaran.page.module').then(m => m.PcareDaftarPendaftaranPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Daftar Pendaftaran here] off begin
					// % protected region % [Add any additional guards for PCare Daftar Pendaftaran here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						// % protected region % [Add additional roles to PCare Daftar Pendaftaran here] off begin
						// % protected region % [Add additional roles to PCare Daftar Pendaftaran here] end
					],
					// % protected region % [Customise your data passed to PCare Daftar Pendaftaran here] off begin
					// % protected region % [Customise your data passed to PCare Daftar Pendaftaran here] end
				},
				// % protected region % [Add additional route properties here for pcare-daftar-pendaftaran] off begin
				// % protected region % [Add additional route properties here for pcare-daftar-pendaftaran] end
			},
			{
				path: 'pcare-daftar-riwayat-kunjungan',
				loadChildren: () => import('../pages/pcare-daftar-riwayat-kunjungan/pcare-daftar-riwayat-kunjungan.page.module').then(m => m.PcareDaftarRiwayatKunjunganPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Daftar Riwayat Kunjungan here] off begin
					// % protected region % [Add any additional guards for PCare Daftar Riwayat Kunjungan here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to PCare Daftar Riwayat Kunjungan here] off begin
						// % protected region % [Add additional roles to PCare Daftar Riwayat Kunjungan here] end
					],
					// % protected region % [Customise your data passed to PCare Daftar Riwayat Kunjungan here] off begin
					// % protected region % [Customise your data passed to PCare Daftar Riwayat Kunjungan here] end
				},
				// % protected region % [Add additional route properties here for pcare-daftar-riwayat-kunjungan] off begin
				// % protected region % [Add additional route properties here for pcare-daftar-riwayat-kunjungan] end
			},
			{
				path: 'pcare-daftar-rujukan',
				loadChildren: () => import('../pages/pcare-daftar-rujukan/pcare-daftar-rujukan.page.module').then(m => m.PcareDaftarRujukanPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Daftar Rujukan here] off begin
					// % protected region % [Add any additional guards for PCare Daftar Rujukan here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to PCare Daftar Rujukan here] off begin
						// % protected region % [Add additional roles to PCare Daftar Rujukan here] end
					],
					// % protected region % [Customise your data passed to PCare Daftar Rujukan here] off begin
					// % protected region % [Customise your data passed to PCare Daftar Rujukan here] end
				},
				// % protected region % [Add additional route properties here for pcare-daftar-rujukan] off begin
				// % protected region % [Add additional route properties here for pcare-daftar-rujukan] end
			},
			{
				path: 'pcare-data-kegiatan',
				loadChildren: () => import('../pages/pcare-data-kegiatan/pcare-data-kegiatan.page.module').then(m => m.PcareDataKegiatanPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Data Kegiatan here] off begin
					// % protected region % [Add any additional guards for PCare Data Kegiatan here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to PCare Data Kegiatan here] off begin
						// % protected region % [Add additional roles to PCare Data Kegiatan here] end
					],
					// % protected region % [Customise your data passed to PCare Data Kegiatan here] off begin
					// % protected region % [Customise your data passed to PCare Data Kegiatan here] end
				},
				// % protected region % [Add additional route properties here for pcare-data-kegiatan] off begin
				// % protected region % [Add additional route properties here for pcare-data-kegiatan] end
			},
			{
				path: 'pcare-diagnosa',
				loadChildren: () => import('../pages/pcare-diagnosa/pcare-diagnosa.page.module').then(m => m.PcareDiagnosaPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Diagnosa here] off begin
					// % protected region % [Add any additional guards for PCare Diagnosa here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to PCare Diagnosa here] off begin
						// % protected region % [Add additional roles to PCare Diagnosa here] end
					],
					// % protected region % [Customise your data passed to PCare Diagnosa here] off begin
					// % protected region % [Customise your data passed to PCare Diagnosa here] end
				},
				// % protected region % [Add additional route properties here for pcare-diagnosa] off begin
				// % protected region % [Add additional route properties here for pcare-diagnosa] end
			},
			{
				path: 'pcare-dokter',
				loadChildren: () => import('../pages/pcare-dokter/pcare-dokter.page.module').then(m => m.PcareDokterPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Dokter here] off begin
					// % protected region % [Add any additional guards for PCare Dokter here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to PCare Dokter here] off begin
						// % protected region % [Add additional roles to PCare Dokter here] end
					],
					// % protected region % [Customise your data passed to PCare Dokter here] off begin
					// % protected region % [Customise your data passed to PCare Dokter here] end
				},
				// % protected region % [Add additional route properties here for pcare-dokter] off begin
				// % protected region % [Add additional route properties here for pcare-dokter] end
			},
			{
				path: 'pcare-kegiatan-kelompok',
				loadChildren: () => import('../pages/pcare-kegiatan-kelompok/pcare-kegiatan-kelompok.page.module').then(m => m.PcareKegiatanKelompokPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Kegiatan Kelompok here] off begin
					// % protected region % [Add any additional guards for PCare Kegiatan Kelompok here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to PCare Kegiatan Kelompok here] off begin
						// % protected region % [Add additional roles to PCare Kegiatan Kelompok here] end
					],
					// % protected region % [Customise your data passed to PCare Kegiatan Kelompok here] off begin
					// % protected region % [Customise your data passed to PCare Kegiatan Kelompok here] end
				},
				// % protected region % [Add additional route properties here for pcare-kegiatan-kelompok] off begin
				// % protected region % [Add additional route properties here for pcare-kegiatan-kelompok] end
			},
			{
				path: 'pcare-kegiatan-kelompok-wrapper',
				loadChildren: () => import('../pages/pcare-kegiatan-kelompok-wrapper/pcare-kegiatan-kelompok-wrapper.page.module').then(m => m.PcareKegiatanKelompokWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Kegiatan Kelompok Wrapper here] off begin
					// % protected region % [Add any additional guards for PCare Kegiatan Kelompok Wrapper here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to PCare Kegiatan Kelompok Wrapper here] off begin
						// % protected region % [Add additional roles to PCare Kegiatan Kelompok Wrapper here] end
					],
					// % protected region % [Customise your data passed to PCare Kegiatan Kelompok Wrapper here] off begin
					// % protected region % [Customise your data passed to PCare Kegiatan Kelompok Wrapper here] end
				},
				// % protected region % [Add additional route properties here for pcare-kegiatan-kelompok-wrapper] off begin
				// % protected region % [Add additional route properties here for pcare-kegiatan-kelompok-wrapper] end
			},
			{
				path: 'pcare-kesadaran',
				loadChildren: () => import('../pages/pcare-kesadaran/pcare-kesadaran.page.module').then(m => m.PcareKesadaranPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Kesadaran here] off begin
					// % protected region % [Add any additional guards for PCare Kesadaran here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to PCare Kesadaran here] off begin
						// % protected region % [Add additional roles to PCare Kesadaran here] end
					],
					// % protected region % [Customise your data passed to PCare Kesadaran here] off begin
					// % protected region % [Customise your data passed to PCare Kesadaran here] end
				},
				// % protected region % [Add additional route properties here for pcare-kesadaran] off begin
				// % protected region % [Add additional route properties here for pcare-kesadaran] end
			},
			{
				path: 'pcare-kunjungan-wrapper',
				loadChildren: () => import('../pages/pcare-kunjungan-wrapper/pcare-kunjungan-wrapper.page.module').then(m => m.PcareKunjunganWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Kunjungan Wrapper here] off begin
					// % protected region % [Add any additional guards for PCare Kunjungan Wrapper here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to PCare Kunjungan Wrapper here] off begin
						// % protected region % [Add additional roles to PCare Kunjungan Wrapper here] end
					],
					// % protected region % [Customise your data passed to PCare Kunjungan Wrapper here] off begin
					// % protected region % [Customise your data passed to PCare Kunjungan Wrapper here] end
				},
				// % protected region % [Add additional route properties here for pcare-kunjungan-wrapper] off begin
				// % protected region % [Add additional route properties here for pcare-kunjungan-wrapper] end
			},
			{
				path: 'pcare-mcu',
				loadChildren: () => import('../pages/pcare-mcu/pcare-mcu.page.module').then(m => m.PcareMCUPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare MCU here] off begin
					// % protected region % [Add any additional guards for PCare MCU here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to PCare MCU here] off begin
						// % protected region % [Add additional roles to PCare MCU here] end
					],
					// % protected region % [Customise your data passed to PCare MCU here] off begin
					// % protected region % [Customise your data passed to PCare MCU here] end
				},
				// % protected region % [Add additional route properties here for pcare-mcu] off begin
				// % protected region % [Add additional route properties here for pcare-mcu] end
			},
			{
				path: 'pcare-mcu-wrapper',
				loadChildren: () => import('../pages/pcare-mcu-wrapper/pcare-mcu-wrapper.page.module').then(m => m.PcareMCUWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare MCU Wrapper here] off begin
					// % protected region % [Add any additional guards for PCare MCU Wrapper here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to PCare MCU Wrapper here] off begin
						// % protected region % [Add additional roles to PCare MCU Wrapper here] end
					],
					// % protected region % [Customise your data passed to PCare MCU Wrapper here] off begin
					// % protected region % [Customise your data passed to PCare MCU Wrapper here] end
				},
				// % protected region % [Add additional route properties here for pcare-mcu-wrapper] off begin
				// % protected region % [Add additional route properties here for pcare-mcu-wrapper] end
			},
			{
				path: 'pcare-peserta-kegiatan-kelompok',
				loadChildren: () => import('../pages/pcare-peserta-kegiatan-kelompok/pcare-peserta-kegiatan-kelompok.page.module').then(m => m.PcarePesertaKegiatanKelompokPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Peserta Kegiatan Kelompok here] off begin
					// % protected region % [Add any additional guards for PCare Peserta Kegiatan Kelompok here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to PCare Peserta Kegiatan Kelompok here] off begin
						// % protected region % [Add additional roles to PCare Peserta Kegiatan Kelompok here] end
					],
					// % protected region % [Customise your data passed to PCare Peserta Kegiatan Kelompok here] off begin
					// % protected region % [Customise your data passed to PCare Peserta Kegiatan Kelompok here] end
				},
				// % protected region % [Add additional route properties here for pcare-peserta-kegiatan-kelompok] off begin
				// % protected region % [Add additional route properties here for pcare-peserta-kegiatan-kelompok] end
			},
			{
				path: 'pcare-provider-rayonisasi',
				loadChildren: () => import('../pages/pcare-provider-rayonisasi/pcare-provider-rayonisasi.page.module').then(m => m.PcareProviderRayonisasiPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Provider Rayonisasi here] off begin
					// % protected region % [Add any additional guards for PCare Provider Rayonisasi here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to PCare Provider Rayonisasi here] off begin
						// % protected region % [Add additional roles to PCare Provider Rayonisasi here] end
					],
					// % protected region % [Customise your data passed to PCare Provider Rayonisasi here] off begin
					// % protected region % [Customise your data passed to PCare Provider Rayonisasi here] end
				},
				// % protected region % [Add additional route properties here for pcare-provider-rayonisasi] off begin
				// % protected region % [Add additional route properties here for pcare-provider-rayonisasi] end
			},
			{
				path: 'pcare-status-pulang',
				loadChildren: () => import('../pages/pcare-status-pulang/pcare-status-pulang.page.module').then(m => m.PcareStatusPulangPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Status Pulang here] off begin
					// % protected region % [Add any additional guards for PCare Status Pulang here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'FACILITY_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to PCare Status Pulang here] off begin
						// % protected region % [Add additional roles to PCare Status Pulang here] end
					],
					// % protected region % [Customise your data passed to PCare Status Pulang here] off begin
					// % protected region % [Customise your data passed to PCare Status Pulang here] end
				},
				// % protected region % [Add additional route properties here for pcare-status-pulang] off begin
				// % protected region % [Add additional route properties here for pcare-status-pulang] end
			},
			{
				path: 'pcare-tindakan',
				loadChildren: () => import('../pages/pcare-tindakan/pcare-tindakan.page.module').then(m => m.PcareTindakanPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Tindakan here] off begin
					// % protected region % [Add any additional guards for PCare Tindakan here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to PCare Tindakan here] off begin
						// % protected region % [Add additional roles to PCare Tindakan here] end
					],
					// % protected region % [Customise your data passed to PCare Tindakan here] off begin
					// % protected region % [Customise your data passed to PCare Tindakan here] end
				},
				// % protected region % [Add additional route properties here for pcare-tindakan] off begin
				// % protected region % [Add additional route properties here for pcare-tindakan] end
			},
			{
				path: 'pcare-tindakan-kunjungan',
				loadChildren: () => import('../pages/pcare-tindakan-kunjungan/pcare-tindakan-kunjungan.page.module').then(m => m.PcareTindakanKunjunganPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Tindakan Kunjungan here] off begin
					// % protected region % [Add any additional guards for PCare Tindakan Kunjungan here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to PCare Tindakan Kunjungan here] off begin
						// % protected region % [Add additional roles to PCare Tindakan Kunjungan here] end
					],
					// % protected region % [Customise your data passed to PCare Tindakan Kunjungan here] off begin
					// % protected region % [Customise your data passed to PCare Tindakan Kunjungan here] end
				},
				// % protected region % [Add additional route properties here for pcare-tindakan-kunjungan] off begin
				// % protected region % [Add additional route properties here for pcare-tindakan-kunjungan] end
			},
			{
				path: 'pcare-umum',
				loadChildren: () => import('../pages/pcare-umum/pcare-umum.page.module').then(m => m.PcareUmumPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for PCare Umum here] off begin
					// % protected region % [Add any additional guards for PCare Umum here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to PCare Umum here] off begin
						// % protected region % [Add additional roles to PCare Umum here] end
					],
					// % protected region % [Customise your data passed to PCare Umum here] off begin
					// % protected region % [Customise your data passed to PCare Umum here] end
				},
				// % protected region % [Add additional route properties here for pcare-umum] off begin
				// % protected region % [Add additional route properties here for pcare-umum] end
			},
			{
				path: 'patient-billing',
				loadChildren: () => import('../pages/patient-billing/patient-billing.page.module').then(m => m.PatientBillingPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Billing here] off begin
					// % protected region % [Add any additional guards for Patient Billing here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Patient Billing here] off begin
						// % protected region % [Add additional roles to Patient Billing here] end
					],
					// % protected region % [Customise your data passed to Patient Billing here] off begin
					// % protected region % [Customise your data passed to Patient Billing here] end
				},
				// % protected region % [Add additional route properties here for patient-billing] off begin
				// % protected region % [Add additional route properties here for patient-billing] end
			},
			{
				path: 'patient-configuration',
				loadChildren: () => import('../pages/patient-configuration/patient-configuration.page.module').then(m => m.PatientConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Configuration here] off begin
					// % protected region % [Add any additional guards for Patient Configuration here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Patient Configuration here] off begin
						// % protected region % [Add additional roles to Patient Configuration here] end
					],
					// % protected region % [Customise your data passed to Patient Configuration here] off begin
					// % protected region % [Customise your data passed to Patient Configuration here] end
				},
				// % protected region % [Add additional route properties here for patient-configuration] off begin
				// % protected region % [Add additional route properties here for patient-configuration] end
			},
			{
				path: 'patient-detail',
				loadChildren: () => import('../pages/patient-detail/patient-detail.page.module').then(m => m.PatientDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Detail here] off begin
					// % protected region % [Add any additional guards for Patient Detail here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Patient Detail here] off begin
						// % protected region % [Add additional roles to Patient Detail here] end
					],
					// % protected region % [Customise your data passed to Patient Detail here] off begin
					// % protected region % [Customise your data passed to Patient Detail here] end
				},
				// % protected region % [Add additional route properties here for patient-detail] off begin
				// % protected region % [Add additional route properties here for patient-detail] end
			},
			{
				path: 'patient-invoice',
				loadChildren: () => import('../pages/patient-invoice/patient-invoice.page.module').then(m => m.PatientInvoicePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Invoice here] off begin
					// % protected region % [Add any additional guards for Patient Invoice here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Patient Invoice here] off begin
						// % protected region % [Add additional roles to Patient Invoice here] end
					],
					// % protected region % [Customise your data passed to Patient Invoice here] off begin
					// % protected region % [Customise your data passed to Patient Invoice here] end
				},
				// % protected region % [Add additional route properties here for patient-invoice] off begin
				// % protected region % [Add additional route properties here for patient-invoice] end
			},
			{
				path: 'patient-invoice-detail',
				loadChildren: () => import('../pages/patient-invoice-detail/patient-invoice-detail.page.module').then(m => m.PatientInvoiceDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Invoice Detail here] off begin
					// % protected region % [Add any additional guards for Patient Invoice Detail here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Patient Invoice Detail here] off begin
						// % protected region % [Add additional roles to Patient Invoice Detail here] end
					],
					// % protected region % [Customise your data passed to Patient Invoice Detail here] off begin
					// % protected region % [Customise your data passed to Patient Invoice Detail here] end
				},
				// % protected region % [Add additional route properties here for patient-invoice-detail] off begin
				// % protected region % [Add additional route properties here for patient-invoice-detail] end
			},
			{
				path: 'patient-invoice-item-detail',
				loadChildren: () => import('../pages/patient-invoice-item-detail/patient-invoice-item-detail.page.module').then(m => m.PatientInvoiceItemDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Invoice Item Detail here] off begin
					// % protected region % [Add any additional guards for Patient Invoice Item Detail here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Patient Invoice Item Detail here] off begin
						// % protected region % [Add additional roles to Patient Invoice Item Detail here] end
					],
					// % protected region % [Customise your data passed to Patient Invoice Item Detail here] off begin
					// % protected region % [Customise your data passed to Patient Invoice Item Detail here] end
				},
				// % protected region % [Add additional route properties here for patient-invoice-item-detail] off begin
				// % protected region % [Add additional route properties here for patient-invoice-item-detail] end
			},
			{
				path: 'patient-profile',
				loadChildren: () => import('../pages/patient-profile/patient-profile.page.module').then(m => m.PatientProfilePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Profile here] off begin
					// % protected region % [Add any additional guards for Patient Profile here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Patient Profile here] off begin
						// % protected region % [Add additional roles to Patient Profile here] end
					],
					// % protected region % [Customise your data passed to Patient Profile here] off begin
					// % protected region % [Customise your data passed to Patient Profile here] end
				},
				// % protected region % [Add additional route properties here for patient-profile] off begin
				// % protected region % [Add additional route properties here for patient-profile] end
			},
			{
				path: 'patient-receipt',
				loadChildren: () => import('../pages/patient-receipt/patient-receipt.page.module').then(m => m.PatientReceiptPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Receipt here] off begin
					// % protected region % [Add any additional guards for Patient Receipt here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Patient Receipt here] off begin
						// % protected region % [Add additional roles to Patient Receipt here] end
					],
					// % protected region % [Customise your data passed to Patient Receipt here] off begin
					// % protected region % [Customise your data passed to Patient Receipt here] end
				},
				// % protected region % [Add additional route properties here for patient-receipt] off begin
				// % protected region % [Add additional route properties here for patient-receipt] end
			},
			{
				path: 'patient-receipt-detail',
				loadChildren: () => import('../pages/patient-receipt-detail/patient-receipt-detail.page.module').then(m => m.PatientReceiptDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Receipt Detail here] off begin
					// % protected region % [Add any additional guards for Patient Receipt Detail here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Patient Receipt Detail here] off begin
						// % protected region % [Add additional roles to Patient Receipt Detail here] end
					],
					// % protected region % [Customise your data passed to Patient Receipt Detail here] off begin
					// % protected region % [Customise your data passed to Patient Receipt Detail here] end
				},
				// % protected region % [Add additional route properties here for patient-receipt-detail] off begin
				// % protected region % [Add additional route properties here for patient-receipt-detail] end
			},
			{
				path: 'patient-receipt-setup',
				loadChildren: () => import('../pages/patient-receipt-setup/patient-receipt-setup.page.module').then(m => m.PatientReceiptSetupPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Receipt Setup here] off begin
					// % protected region % [Add any additional guards for Patient Receipt Setup here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Patient Receipt Setup here] off begin
						// % protected region % [Add additional roles to Patient Receipt Setup here] end
					],
					// % protected region % [Customise your data passed to Patient Receipt Setup here] off begin
					// % protected region % [Customise your data passed to Patient Receipt Setup here] end
				},
				// % protected region % [Add additional route properties here for patient-receipt-setup] off begin
				// % protected region % [Add additional route properties here for patient-receipt-setup] end
			},
			{
				path: 'patient-refund',
				loadChildren: () => import('../pages/patient-refund/patient-refund.page.module').then(m => m.PatientRefundPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Refund here] off begin
					// % protected region % [Add any additional guards for Patient Refund here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Patient Refund here] off begin
						// % protected region % [Add additional roles to Patient Refund here] end
					],
					// % protected region % [Customise your data passed to Patient Refund here] off begin
					// % protected region % [Customise your data passed to Patient Refund here] end
				},
				// % protected region % [Add additional route properties here for patient-refund] off begin
				// % protected region % [Add additional route properties here for patient-refund] end
			},
			{
				path: 'patient-refund-setup',
				loadChildren: () => import('../pages/patient-refund-setup/patient-refund-setup.page.module').then(m => m.PatientRefundSetupPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Refund Setup here] off begin
					// % protected region % [Add any additional guards for Patient Refund Setup here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'CLAIM_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Patient Refund Setup here] off begin
						// % protected region % [Add additional roles to Patient Refund Setup here] end
					],
					// % protected region % [Customise your data passed to Patient Refund Setup here] off begin
					// % protected region % [Customise your data passed to Patient Refund Setup here] end
				},
				// % protected region % [Add additional route properties here for patient-refund-setup] off begin
				// % protected region % [Add additional route properties here for patient-refund-setup] end
			},
			{
				path: 'patient-vital-information',
				loadChildren: () => import('../pages/patient-vital-information/patient-vital-information.page.module').then(m => m.PatientVitalInformationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Patient Vital Information here] off begin
					// % protected region % [Add any additional guards for Patient Vital Information here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Patient Vital Information here] off begin
						// % protected region % [Add additional roles to Patient Vital Information here] end
					],
					// % protected region % [Customise your data passed to Patient Vital Information here] off begin
					// % protected region % [Customise your data passed to Patient Vital Information here] end
				},
				// % protected region % [Add additional route properties here for patient-vital-information] off begin
				// % protected region % [Add additional route properties here for patient-vital-information] end
			},
			{
				path: 'payment-method-report',
				loadChildren: () => import('../pages/payment-method-report/payment-method-report.page.module').then(m => m.PaymentMethodReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Payment Method Report here] off begin
					// % protected region % [Add any additional guards for Payment Method Report here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Payment Method Report here] off begin
						// % protected region % [Add additional roles to Payment Method Report here] end
					],
					// % protected region % [Customise your data passed to Payment Method Report here] off begin
					// % protected region % [Customise your data passed to Payment Method Report here] end
				},
				// % protected region % [Add additional route properties here for payment-method-report] off begin
				// % protected region % [Add additional route properties here for payment-method-report] end
			},
			{
				path: 'pcare-obat',
				loadChildren: () => import('../pages/pcare-obat/pcare-obat.page.module').then(m => m.PcareObatPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Pcare Obat here] off begin
					// % protected region % [Add any additional guards for Pcare Obat here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Pcare Obat here] off begin
						// % protected region % [Add additional roles to Pcare Obat here] end
					],
					// % protected region % [Customise your data passed to Pcare Obat here] off begin
					// % protected region % [Customise your data passed to Pcare Obat here] end
				},
				// % protected region % [Add additional route properties here for pcare-obat] off begin
				// % protected region % [Add additional route properties here for pcare-obat] end
			},
			{
				path: 'pcare-poli',
				loadChildren: () => import('../pages/pcare-poli/pcare-poli.page.module').then(m => m.PcarePoliPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Pcare Poli here] off begin
					// % protected region % [Add any additional guards for Pcare Poli here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Pcare Poli here] off begin
						// % protected region % [Add additional roles to Pcare Poli here] end
					],
					// % protected region % [Customise your data passed to Pcare Poli here] off begin
					// % protected region % [Customise your data passed to Pcare Poli here] end
				},
				// % protected region % [Add additional route properties here for pcare-poli] off begin
				// % protected region % [Add additional route properties here for pcare-poli] end
			},
			{
				path: 'pcare-referensi-sarana',
				loadChildren: () => import('../pages/pcare-referensi-sarana/pcare-referensi-sarana.page.module').then(m => m.PcareReferensiSaranaPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Pcare Referensi Sarana here] off begin
					// % protected region % [Add any additional guards for Pcare Referensi Sarana here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Pcare Referensi Sarana here] off begin
						// % protected region % [Add additional roles to Pcare Referensi Sarana here] end
					],
					// % protected region % [Customise your data passed to Pcare Referensi Sarana here] off begin
					// % protected region % [Customise your data passed to Pcare Referensi Sarana here] end
				},
				// % protected region % [Add additional route properties here for pcare-referensi-sarana] off begin
				// % protected region % [Add additional route properties here for pcare-referensi-sarana] end
			},
			{
				path: 'perinatology-service-activity-report',
				loadChildren: () => import('../pages/perinatology-service-activity-report/perinatology-service-activity-report.page.module').then(m => m.PerinatologyServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Perinatology Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Perinatology Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Perinatology Service Activity Report here] off begin
						// % protected region % [Add additional roles to Perinatology Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Perinatology Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Perinatology Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for perinatology-service-activity-report] off begin
				// % protected region % [Add additional route properties here for perinatology-service-activity-report] end
			},
			{
				path: 'personalization',
				loadChildren: () => import('../pages/personalization/personalization.page.module').then(m => m.PersonalizationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Personalization here] off begin
					// % protected region % [Add any additional guards for Personalization here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Personalization here] off begin
						// % protected region % [Add additional roles to Personalization here] end
					],
					// % protected region % [Customise your data passed to Personalization here] off begin
					// % protected region % [Customise your data passed to Personalization here] end
				},
				// % protected region % [Add additional route properties here for personalization] off begin
				// % protected region % [Add additional route properties here for personalization] end
			},
			{
				path: 'pharmacy',
				loadChildren: () => import('../pages/pharmacy/pharmacy.page.module').then(m => m.PharmacyPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Pharmacy here] off begin
					// % protected region % [Add any additional guards for Pharmacy here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Pharmacy here] off begin
						// % protected region % [Add additional roles to Pharmacy here] end
					],
					// % protected region % [Customise your data passed to Pharmacy here] off begin
					// % protected region % [Customise your data passed to Pharmacy here] end
				},
				// % protected region % [Add additional route properties here for pharmacy] off begin
				// % protected region % [Add additional route properties here for pharmacy] end
			},
			{
				path: 'pharmacy-configuration',
				loadChildren: () => import('../pages/pharmacy-configuration/pharmacy-configuration.page.module').then(m => m.PharmacyConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Pharmacy Configuration here] off begin
					// % protected region % [Add any additional guards for Pharmacy Configuration here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Pharmacy Configuration here] off begin
						// % protected region % [Add additional roles to Pharmacy Configuration here] end
					],
					// % protected region % [Customise your data passed to Pharmacy Configuration here] off begin
					// % protected region % [Customise your data passed to Pharmacy Configuration here] end
				},
				// % protected region % [Add additional route properties here for pharmacy-configuration] off begin
				// % protected region % [Add additional route properties here for pharmacy-configuration] end
			},
			{
				path: 'pharmacy-item-detail-report',
				loadChildren: () => import('../pages/pharmacy-item-detail-report/pharmacy-item-detail-report.page.module').then(m => m.PharmacyItemDetailReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Pharmacy Item Detail Report here] off begin
					// % protected region % [Add any additional guards for Pharmacy Item Detail Report here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Pharmacy Item Detail Report here] off begin
						// % protected region % [Add additional roles to Pharmacy Item Detail Report here] end
					],
					// % protected region % [Customise your data passed to Pharmacy Item Detail Report here] off begin
					// % protected region % [Customise your data passed to Pharmacy Item Detail Report here] end
				},
				// % protected region % [Add additional route properties here for pharmacy-item-detail-report] off begin
				// % protected region % [Add additional route properties here for pharmacy-item-detail-report] end
			},
			{
				path: 'pharmacy-report',
				loadChildren: () => import('../pages/pharmacy-report/pharmacy-report.page.module').then(m => m.PharmacyReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Pharmacy Report here] off begin
					// % protected region % [Add any additional guards for Pharmacy Report here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Pharmacy Report here] off begin
						// % protected region % [Add additional roles to Pharmacy Report here] end
					],
					// % protected region % [Customise your data passed to Pharmacy Report here] off begin
					// % protected region % [Customise your data passed to Pharmacy Report here] end
				},
				// % protected region % [Add additional route properties here for pharmacy-report] off begin
				// % protected region % [Add additional route properties here for pharmacy-report] end
			},
			{
				path: 'postoperative-details',
				loadChildren: () => import('../pages/postoperative-details/postoperative-details.page.module').then(m => m.PostoperativeDetailsPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Postoperative Details here] off begin
					// % protected region % [Add any additional guards for Postoperative Details here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Postoperative Details here] off begin
						// % protected region % [Add additional roles to Postoperative Details here] end
					],
					// % protected region % [Customise your data passed to Postoperative Details here] off begin
					// % protected region % [Customise your data passed to Postoperative Details here] end
				},
				// % protected region % [Add additional route properties here for postoperative-details] off begin
				// % protected region % [Add additional route properties here for postoperative-details] end
			},
			{
				path: 'preoperative-records',
				loadChildren: () => import('../pages/preoperative-records/preoperative-records.page.module').then(m => m.PreoperativeRecordsPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Preoperative Records here] off begin
					// % protected region % [Add any additional guards for Preoperative Records here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Preoperative Records here] off begin
						// % protected region % [Add additional roles to Preoperative Records here] end
					],
					// % protected region % [Customise your data passed to Preoperative Records here] off begin
					// % protected region % [Customise your data passed to Preoperative Records here] end
				},
				// % protected region % [Add additional route properties here for preoperative-records] off begin
				// % protected region % [Add additional route properties here for preoperative-records] end
			},
			{
				path: 'prescription-detail',
				loadChildren: () => import('../pages/prescription-detail/prescription-detail.page.module').then(m => m.PrescriptionDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Prescription Detail here] off begin
					// % protected region % [Add any additional guards for Prescription Detail here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Prescription Detail here] off begin
						// % protected region % [Add additional roles to Prescription Detail here] end
					],
					// % protected region % [Customise your data passed to Prescription Detail here] off begin
					// % protected region % [Customise your data passed to Prescription Detail here] end
				},
				// % protected region % [Add additional route properties here for prescription-detail] off begin
				// % protected region % [Add additional route properties here for prescription-detail] end
			},
			{
				path: 'prescription-dispensing',
				loadChildren: () => import('../pages/prescription-dispensing/prescription-dispensing.page.module').then(m => m.PrescriptionDispensingPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Prescription Dispensing here] off begin
					// % protected region % [Add any additional guards for Prescription Dispensing here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Prescription Dispensing here] off begin
						// % protected region % [Add additional roles to Prescription Dispensing here] end
					],
					// % protected region % [Customise your data passed to Prescription Dispensing here] off begin
					// % protected region % [Customise your data passed to Prescription Dispensing here] end
				},
				// % protected region % [Add additional route properties here for prescription-dispensing] off begin
				// % protected region % [Add additional route properties here for prescription-dispensing] end
			},
			{
				path: 'price-component',
				loadChildren: () => import('../pages/price-component/price-component.page.module').then(m => m.PriceComponentPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Price Component here] off begin
					// % protected region % [Add any additional guards for Price Component here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Price Component here] off begin
						// % protected region % [Add additional roles to Price Component here] end
					],
					// % protected region % [Customise your data passed to Price Component here] off begin
					// % protected region % [Customise your data passed to Price Component here] end
				},
				// % protected region % [Add additional route properties here for price-component] off begin
				// % protected region % [Add additional route properties here for price-component] end
			},
			{
				path: 'process-workflow',
				loadChildren: () => import('../pages/process-workflow/process-workflow.page.module').then(m => m.ProcessWorkflowPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Process Workflow here] off begin
					// % protected region % [Add any additional guards for Process Workflow here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Process Workflow here] off begin
						// % protected region % [Add additional roles to Process Workflow here] end
					],
					// % protected region % [Customise your data passed to Process Workflow here] off begin
					// % protected region % [Customise your data passed to Process Workflow here] end
				},
				// % protected region % [Add additional route properties here for process-workflow] off begin
				// % protected region % [Add additional route properties here for process-workflow] end
			},
			{
				path: 'psychiatry-service-activity-report',
				loadChildren: () => import('../pages/psychiatry-service-activity-report/psychiatry-service-activity-report.page.module').then(m => m.PsychiatryServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Psychiatry Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Psychiatry Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Psychiatry Service Activity Report here] off begin
						// % protected region % [Add additional roles to Psychiatry Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Psychiatry Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Psychiatry Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for psychiatry-service-activity-report] off begin
				// % protected region % [Add additional route properties here for psychiatry-service-activity-report] end
			},
			{
				path: 'purchase-order',
				loadChildren: () => import('../pages/purchase-order/purchase-order.page.module').then(m => m.PurchaseOrderPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Purchase Order here] off begin
					// % protected region % [Add any additional guards for Purchase Order here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Purchase Order here] off begin
						// % protected region % [Add additional roles to Purchase Order here] end
					],
					// % protected region % [Customise your data passed to Purchase Order here] off begin
					// % protected region % [Customise your data passed to Purchase Order here] end
				},
				// % protected region % [Add additional route properties here for purchase-order] off begin
				// % protected region % [Add additional route properties here for purchase-order] end
			},
			{
				path: 'purchase-order-stock-detail',
				loadChildren: () => import('../pages/purchase-order-stock-detail/purchase-order-stock-detail.page.module').then(m => m.PurchaseOrderStockDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Purchase Order Stock Detail here] off begin
					// % protected region % [Add any additional guards for Purchase Order Stock Detail here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						// % protected region % [Add additional roles to Purchase Order Stock Detail here] off begin
						// % protected region % [Add additional roles to Purchase Order Stock Detail here] end
					],
					// % protected region % [Customise your data passed to Purchase Order Stock Detail here] off begin
					// % protected region % [Customise your data passed to Purchase Order Stock Detail here] end
				},
				// % protected region % [Add additional route properties here for purchase-order-stock-detail] off begin
				// % protected region % [Add additional route properties here for purchase-order-stock-detail] end
			},
			{
				path: 'purchase-requisition',
				loadChildren: () => import('../pages/purchase-requisition/purchase-requisition.page.module').then(m => m.PurchaseRequisitionPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Purchase Requisition here] off begin
					// % protected region % [Add any additional guards for Purchase Requisition here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Purchase Requisition here] off begin
						// % protected region % [Add additional roles to Purchase Requisition here] end
					],
					// % protected region % [Customise your data passed to Purchase Requisition here] off begin
					// % protected region % [Customise your data passed to Purchase Requisition here] end
				},
				// % protected region % [Add additional route properties here for purchase-requisition] off begin
				// % protected region % [Add additional route properties here for purchase-requisition] end
			},
			{
				path: 'purchase-requisition-stock-detail',
				loadChildren: () => import('../pages/purchase-requisition-stock-detail/purchase-requisition-stock-detail.page.module').then(m => m.PurchaseRequisitionStockDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Purchase Requisition Stock Detail here] off begin
					// % protected region % [Add any additional guards for Purchase Requisition Stock Detail here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Purchase Requisition Stock Detail here] off begin
						// % protected region % [Add additional roles to Purchase Requisition Stock Detail here] end
					],
					// % protected region % [Customise your data passed to Purchase Requisition Stock Detail here] off begin
					// % protected region % [Customise your data passed to Purchase Requisition Stock Detail here] end
				},
				// % protected region % [Add additional route properties here for purchase-requisition-stock-detail] off begin
				// % protected region % [Add additional route properties here for purchase-requisition-stock-detail] end
			},
			{
				path: 'purchasing',
				loadChildren: () => import('../pages/purchasing/purchasing.page.module').then(m => m.PurchasingPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Purchasing here] off begin
					// % protected region % [Add any additional guards for Purchasing here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Purchasing here] off begin
						// % protected region % [Add additional roles to Purchasing here] end
					],
					// % protected region % [Customise your data passed to Purchasing here] off begin
					// % protected region % [Customise your data passed to Purchasing here] end
				},
				// % protected region % [Add additional route properties here for purchasing] off begin
				// % protected region % [Add additional route properties here for purchasing] end
			},
			{
				path: 'radiology-service-activity-report',
				loadChildren: () => import('../pages/radiology-service-activity-report/radiology-service-activity-report.page.module').then(m => m.RadiologyServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Radiology Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Radiology Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Radiology Service Activity Report here] off begin
						// % protected region % [Add additional roles to Radiology Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Radiology Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Radiology Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for radiology-service-activity-report] off begin
				// % protected region % [Add additional route properties here for radiology-service-activity-report] end
			},
			{
				path: 'reference',
				loadChildren: () => import('../pages/reference/reference.page.module').then(m => m.ReferencePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Reference here] off begin
					// % protected region % [Add any additional guards for Reference here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Reference here] off begin
						// % protected region % [Add additional roles to Reference here] end
					],
					// % protected region % [Customise your data passed to Reference here] off begin
					// % protected region % [Customise your data passed to Reference here] end
				},
				// % protected region % [Add additional route properties here for reference] off begin
				// % protected region % [Add additional route properties here for reference] end
			},
			{
				path: 'reference-data',
				loadChildren: () => import('../pages/reference-data/reference-data.page.module').then(m => m.ReferenceDataPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Reference Data here] off begin
					// % protected region % [Add any additional guards for Reference Data here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Reference Data here] off begin
						// % protected region % [Add additional roles to Reference Data here] end
					],
					// % protected region % [Customise your data passed to Reference Data here] off begin
					// % protected region % [Customise your data passed to Reference Data here] end
				},
				// % protected region % [Add additional route properties here for reference-data] off begin
				// % protected region % [Add additional route properties here for reference-data] end
			},
			{
				path: 'reference-data-detail',
				loadChildren: () => import('../pages/reference-data-detail/reference-data-detail.page.module').then(m => m.ReferenceDataDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Reference Data Detail here] off begin
					// % protected region % [Add any additional guards for Reference Data Detail here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Reference Data Detail here] off begin
						// % protected region % [Add additional roles to Reference Data Detail here] end
					],
					// % protected region % [Customise your data passed to Reference Data Detail here] off begin
					// % protected region % [Customise your data passed to Reference Data Detail here] end
				},
				// % protected region % [Add additional route properties here for reference-data-detail] off begin
				// % protected region % [Add additional route properties here for reference-data-detail] end
			},
			{
				path: 'reference-header',
				loadChildren: () => import('../pages/reference-header/reference-header.page.module').then(m => m.ReferenceHeaderPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Reference Header here] off begin
					// % protected region % [Add any additional guards for Reference Header here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Reference Header here] off begin
						// % protected region % [Add additional roles to Reference Header here] end
					],
					// % protected region % [Customise your data passed to Reference Header here] off begin
					// % protected region % [Customise your data passed to Reference Header here] end
				},
				// % protected region % [Add additional route properties here for reference-header] off begin
				// % protected region % [Add additional route properties here for reference-header] end
			},
			{
				path: 'reference-header-detail',
				loadChildren: () => import('../pages/reference-header-detail/reference-header-detail.page.module').then(m => m.ReferenceHeaderDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Reference Header Detail here] off begin
					// % protected region % [Add any additional guards for Reference Header Detail here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Reference Header Detail here] off begin
						// % protected region % [Add additional roles to Reference Header Detail here] end
					],
					// % protected region % [Customise your data passed to Reference Header Detail here] off begin
					// % protected region % [Customise your data passed to Reference Header Detail here] end
				},
				// % protected region % [Add additional route properties here for reference-header-detail] off begin
				// % protected region % [Add additional route properties here for reference-header-detail] end
			},
			{
				path: 'referral-activity-report',
				loadChildren: () => import('../pages/referral-activity-report/referral-activity-report.page.module').then(m => m.ReferralActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Referral Activity Report here] off begin
					// % protected region % [Add any additional guards for Referral Activity Report here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Referral Activity Report here] off begin
						// % protected region % [Add additional roles to Referral Activity Report here] end
					],
					// % protected region % [Customise your data passed to Referral Activity Report here] off begin
					// % protected region % [Customise your data passed to Referral Activity Report here] end
				},
				// % protected region % [Add additional route properties here for referral-activity-report] off begin
				// % protected region % [Add additional route properties here for referral-activity-report] end
			},
			{
				path: 'refund-detail-report',
				loadChildren: () => import('../pages/refund-detail-report/refund-detail-report.page.module').then(m => m.RefundDetailReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Refund Detail Report here] off begin
					// % protected region % [Add any additional guards for Refund Detail Report here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Refund Detail Report here] off begin
						// % protected region % [Add additional roles to Refund Detail Report here] end
					],
					// % protected region % [Customise your data passed to Refund Detail Report here] off begin
					// % protected region % [Customise your data passed to Refund Detail Report here] end
				},
				// % protected region % [Add additional route properties here for refund-detail-report] off begin
				// % protected region % [Add additional route properties here for refund-detail-report] end
			},
			{
				path: 'registration',
				loadChildren: () => import('../pages/registration/registration.page.module').then(m => m.RegistrationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Registration here] off begin
					// % protected region % [Add any additional guards for Registration here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Registration here] off begin
						// % protected region % [Add additional roles to Registration here] end
					],
					// % protected region % [Customise your data passed to Registration here] off begin
					// % protected region % [Customise your data passed to Registration here] end
				},
				// % protected region % [Add additional route properties here for registration] off begin
				// % protected region % [Add additional route properties here for registration] end
			},
			{
				path: 'registration-configuration',
				loadChildren: () => import('../pages/registration-configuration/registration-configuration.page.module').then(m => m.RegistrationConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Registration Configuration here] off begin
					// % protected region % [Add any additional guards for Registration Configuration here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Registration Configuration here] off begin
						// % protected region % [Add additional roles to Registration Configuration here] end
					],
					// % protected region % [Customise your data passed to Registration Configuration here] off begin
					// % protected region % [Customise your data passed to Registration Configuration here] end
				},
				// % protected region % [Add additional route properties here for registration-configuration] off begin
				// % protected region % [Add additional route properties here for registration-configuration] end
			},
			{
				path: 'registration-report',
				loadChildren: () => import('../pages/registration-report/registration-report.page.module').then(m => m.RegistrationReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Registration Report here] off begin
					// % protected region % [Add any additional guards for Registration Report here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Registration Report here] off begin
						// % protected region % [Add additional roles to Registration Report here] end
					],
					// % protected region % [Customise your data passed to Registration Report here] off begin
					// % protected region % [Customise your data passed to Registration Report here] end
				},
				// % protected region % [Add additional route properties here for registration-report] off begin
				// % protected region % [Add additional route properties here for registration-report] end
			},
			{
				path: 'report-logo',
				loadChildren: () => import('../pages/report-logo/report-logo.page.module').then(m => m.ReportLogoPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Report Logo here] off begin
					// % protected region % [Add any additional guards for Report Logo here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Report Logo here] off begin
						// % protected region % [Add additional roles to Report Logo here] end
					],
					// % protected region % [Customise your data passed to Report Logo here] off begin
					// % protected region % [Customise your data passed to Report Logo here] end
				},
				// % protected region % [Add additional route properties here for report-logo] off begin
				// % protected region % [Add additional route properties here for report-logo] end
			},
			{
				path: 'request-order',
				loadChildren: () => import('../pages/request-order/request-order.page.module').then(m => m.RequestOrderPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Request Order here] off begin
					// % protected region % [Add any additional guards for Request Order here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Request Order here] off begin
						// % protected region % [Add additional roles to Request Order here] end
					],
					// % protected region % [Customise your data passed to Request Order here] off begin
					// % protected region % [Customise your data passed to Request Order here] end
				},
				// % protected region % [Add additional route properties here for request-order] off begin
				// % protected region % [Add additional route properties here for request-order] end
			},
			{
				path: 'retail-pharmacy',
				loadChildren: () => import('../pages/retail-pharmacy/retail-pharmacy.page.module').then(m => m.RetailPharmacyPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Retail Pharmacy here] off begin
					// % protected region % [Add any additional guards for Retail Pharmacy here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Retail Pharmacy here] off begin
						// % protected region % [Add additional roles to Retail Pharmacy here] end
					],
					// % protected region % [Customise your data passed to Retail Pharmacy here] off begin
					// % protected region % [Customise your data passed to Retail Pharmacy here] end
				},
				// % protected region % [Add additional route properties here for retail-pharmacy] off begin
				// % protected region % [Add additional route properties here for retail-pharmacy] end
			},
			{
				path: 'retail-pharmacy-invoice',
				loadChildren: () => import('../pages/retail-pharmacy-invoice/retail-pharmacy-invoice.page.module').then(m => m.RetailPharmacyInvoicePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Retail Pharmacy Invoice here] off begin
					// % protected region % [Add any additional guards for Retail Pharmacy Invoice here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Retail Pharmacy Invoice here] off begin
						// % protected region % [Add additional roles to Retail Pharmacy Invoice here] end
					],
					// % protected region % [Customise your data passed to Retail Pharmacy Invoice here] off begin
					// % protected region % [Customise your data passed to Retail Pharmacy Invoice here] end
				},
				// % protected region % [Add additional route properties here for retail-pharmacy-invoice] off begin
				// % protected region % [Add additional route properties here for retail-pharmacy-invoice] end
			},
			{
				path: 'retail-pharmacy-stock-detail',
				loadChildren: () => import('../pages/retail-pharmacy-stock-detail/retail-pharmacy-stock-detail.page.module').then(m => m.RetailPharmacyStockDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Retail Pharmacy Stock Detail here] off begin
					// % protected region % [Add any additional guards for Retail Pharmacy Stock Detail here] end
				],
				data: {
					expectedRoles: [
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Retail Pharmacy Stock Detail here] off begin
						// % protected region % [Add additional roles to Retail Pharmacy Stock Detail here] end
					],
					// % protected region % [Customise your data passed to Retail Pharmacy Stock Detail here] off begin
					// % protected region % [Customise your data passed to Retail Pharmacy Stock Detail here] end
				},
				// % protected region % [Add additional route properties here for retail-pharmacy-stock-detail] off begin
				// % protected region % [Add additional route properties here for retail-pharmacy-stock-detail] end
			},
			{
				path: 'return-supplier',
				loadChildren: () => import('../pages/return-supplier/return-supplier.page.module').then(m => m.ReturnSupplierPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Return Supplier here] off begin
					// % protected region % [Add any additional guards for Return Supplier here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'PURCHASING_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Return Supplier here] off begin
						// % protected region % [Add additional roles to Return Supplier here] end
					],
					// % protected region % [Customise your data passed to Return Supplier here] off begin
					// % protected region % [Customise your data passed to Return Supplier here] end
				},
				// % protected region % [Add additional route properties here for return-supplier] off begin
				// % protected region % [Add additional route properties here for return-supplier] end
			},
			{
				path: 'return-supplier-stock-detail',
				loadChildren: () => import('../pages/return-supplier-stock-detail/return-supplier-stock-detail.page.module').then(m => m.ReturnSupplierStockDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Return Supplier Stock Detail here] off begin
					// % protected region % [Add any additional guards for Return Supplier Stock Detail here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Return Supplier Stock Detail here] off begin
						// % protected region % [Add additional roles to Return Supplier Stock Detail here] end
					],
					// % protected region % [Customise your data passed to Return Supplier Stock Detail here] off begin
					// % protected region % [Customise your data passed to Return Supplier Stock Detail here] end
				},
				// % protected region % [Add additional route properties here for return-supplier-stock-detail] off begin
				// % protected region % [Add additional route properties here for return-supplier-stock-detail] end
			},
			{
				path: 'room',
				loadChildren: () => import('../pages/room/room.page.module').then(m => m.RoomPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Room here] off begin
					// % protected region % [Add any additional guards for Room here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Room here] off begin
						// % protected region % [Add additional roles to Room here] end
					],
					// % protected region % [Customise your data passed to Room here] off begin
					// % protected region % [Customise your data passed to Room here] end
				},
				// % protected region % [Add additional route properties here for room] off begin
				// % protected region % [Add additional route properties here for room] end
			},
			{
				path: 'sample-collection-information',
				loadChildren: () => import('../pages/sample-collection-information/sample-collection-information.page.module').then(m => m.SampleCollectionInformationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Sample Collection Information here] off begin
					// % protected region % [Add any additional guards for Sample Collection Information here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Sample Collection Information here] off begin
						// % protected region % [Add additional roles to Sample Collection Information here] end
					],
					// % protected region % [Customise your data passed to Sample Collection Information here] off begin
					// % protected region % [Customise your data passed to Sample Collection Information here] end
				},
				// % protected region % [Add additional route properties here for sample-collection-information] off begin
				// % protected region % [Add additional route properties here for sample-collection-information] end
			},
			{
				path: 'sample-collection-items',
				loadChildren: () => import('../pages/sample-collection-items/sample-collection-items.page.module').then(m => m.SampleCollectionItemsPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Sample Collection Items here] off begin
					// % protected region % [Add any additional guards for Sample Collection Items here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Sample Collection Items here] off begin
						// % protected region % [Add additional roles to Sample Collection Items here] end
					],
					// % protected region % [Customise your data passed to Sample Collection Items here] off begin
					// % protected region % [Customise your data passed to Sample Collection Items here] end
				},
				// % protected region % [Add additional route properties here for sample-collection-items] off begin
				// % protected region % [Add additional route properties here for sample-collection-items] end
			},
			{
				path: 'satu-sehat',
				loadChildren: () => import('../pages/satu-sehat/satu-sehat.page.module').then(m => m.SatuSehatPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Satu Sehat here] off begin
					// % protected region % [Add any additional guards for Satu Sehat here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Satu Sehat here] off begin
						// % protected region % [Add additional roles to Satu Sehat here] end
					],
					// % protected region % [Customise your data passed to Satu Sehat here] off begin
					// % protected region % [Customise your data passed to Satu Sehat here] end
				},
				// % protected region % [Add additional route properties here for satu-sehat] off begin
				// % protected region % [Add additional route properties here for satu-sehat] end
			},
			{
				path: 'satu-sehat-configuration',
				loadChildren: () => import('../pages/satu-sehat-configuration/satu-sehat-configuration.page.module').then(m => m.SatuSehatConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Satu Sehat Configuration here] off begin
					// % protected region % [Add any additional guards for Satu Sehat Configuration here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Satu Sehat Configuration here] off begin
						// % protected region % [Add additional roles to Satu Sehat Configuration here] end
					],
					// % protected region % [Customise your data passed to Satu Sehat Configuration here] off begin
					// % protected region % [Customise your data passed to Satu Sehat Configuration here] end
				},
				// % protected region % [Add additional route properties here for satu-sehat-configuration] off begin
				// % protected region % [Add additional route properties here for satu-sehat-configuration] end
			},
			{
				path: 'satu-sehat-general',
				loadChildren: () => import('../pages/satu-sehat-general/satu-sehat-general.page.module').then(m => m.SatuSehatGeneralPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Satu Sehat General here] off begin
					// % protected region % [Add any additional guards for Satu Sehat General here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Satu Sehat General here] off begin
						// % protected region % [Add additional roles to Satu Sehat General here] end
					],
					// % protected region % [Customise your data passed to Satu Sehat General here] off begin
					// % protected region % [Customise your data passed to Satu Sehat General here] end
				},
				// % protected region % [Add additional route properties here for satu-sehat-general] off begin
				// % protected region % [Add additional route properties here for satu-sehat-general] end
			},
			{
				path: 'service',
				loadChildren: () => import('../pages/service/service.page.module').then(m => m.ServicePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Service here] off begin
					// % protected region % [Add any additional guards for Service here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Service here] off begin
						// % protected region % [Add additional roles to Service here] end
					],
					// % protected region % [Customise your data passed to Service here] off begin
					// % protected region % [Customise your data passed to Service here] end
				},
				// % protected region % [Add additional route properties here for service] off begin
				// % protected region % [Add additional route properties here for service] end
			},
			{
				path: 'service-detail',
				loadChildren: () => import('../pages/service-detail/service-detail.page.module').then(m => m.ServiceDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Service Detail here] off begin
					// % protected region % [Add any additional guards for Service Detail here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Service Detail here] off begin
						// % protected region % [Add additional roles to Service Detail here] end
					],
					// % protected region % [Customise your data passed to Service Detail here] off begin
					// % protected region % [Customise your data passed to Service Detail here] end
				},
				// % protected region % [Add additional route properties here for service-detail] off begin
				// % protected region % [Add additional route properties here for service-detail] end
			},
			{
				path: 'service-facility-category',
				loadChildren: () => import('../pages/service-facility-category/service-facility-category.page.module').then(m => m.ServiceFacilityCategoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Service Facility Category here] off begin
					// % protected region % [Add any additional guards for Service Facility Category here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Service Facility Category here] off begin
						// % protected region % [Add additional roles to Service Facility Category here] end
					],
					// % protected region % [Customise your data passed to Service Facility Category here] off begin
					// % protected region % [Customise your data passed to Service Facility Category here] end
				},
				// % protected region % [Add additional route properties here for service-facility-category] off begin
				// % protected region % [Add additional route properties here for service-facility-category] end
			},
			{
				path: 'service-item',
				loadChildren: () => import('../pages/service-item/service-item.page.module').then(m => m.ServiceItemPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Service Item here] off begin
					// % protected region % [Add any additional guards for Service Item here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'ADMINISTRATION_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						// % protected region % [Add additional roles to Service Item here] off begin
						// % protected region % [Add additional roles to Service Item here] end
					],
					// % protected region % [Customise your data passed to Service Item here] off begin
					// % protected region % [Customise your data passed to Service Item here] end
				},
				// % protected region % [Add additional route properties here for service-item] off begin
				// % protected region % [Add additional route properties here for service-item] end
			},
			{
				path: 'service-item-assignment',
				loadChildren: () => import('../pages/service-item-assignment/service-item-assignment.page.module').then(m => m.ServiceItemAssignmentPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Service Item Assignment here] off begin
					// % protected region % [Add any additional guards for Service Item Assignment here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_TRANSCRIBER_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Service Item Assignment here] off begin
						// % protected region % [Add additional roles to Service Item Assignment here] end
					],
					// % protected region % [Customise your data passed to Service Item Assignment here] off begin
					// % protected region % [Customise your data passed to Service Item Assignment here] end
				},
				// % protected region % [Add additional route properties here for service-item-assignment] off begin
				// % protected region % [Add additional route properties here for service-item-assignment] end
			},
			{
				path: 'service-item-wrapper',
				loadChildren: () => import('../pages/service-item-wrapper/service-item-wrapper.page.module').then(m => m.ServiceItemWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Service Item Wrapper here] off begin
					// % protected region % [Add any additional guards for Service Item Wrapper here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Service Item Wrapper here] off begin
						// % protected region % [Add additional roles to Service Item Wrapper here] end
					],
					// % protected region % [Customise your data passed to Service Item Wrapper here] off begin
					// % protected region % [Customise your data passed to Service Item Wrapper here] end
				},
				// % protected region % [Add additional route properties here for service-item-wrapper] off begin
				// % protected region % [Add additional route properties here for service-item-wrapper] end
			},
			{
				path: 'settlement-report',
				loadChildren: () => import('../pages/settlement-report/settlement-report.page.module').then(m => m.SettlementReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Settlement Report here] off begin
					// % protected region % [Add any additional guards for Settlement Report here] end
				],
				data: {
					expectedRoles: [
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATOR',
						'DOCTOR_USER',
						'CASHIER_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Settlement Report here] off begin
						// % protected region % [Add additional roles to Settlement Report here] end
					],
					// % protected region % [Customise your data passed to Settlement Report here] off begin
					// % protected region % [Customise your data passed to Settlement Report here] end
				},
				// % protected region % [Add additional route properties here for settlement-report] off begin
				// % protected region % [Add additional route properties here for settlement-report] end
			},
			{
				path: 'special-service-activity-report',
				loadChildren: () => import('../pages/special-service-activity-report/special-service-activity-report.page.module').then(m => m.SpecialServiceActivityReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Special Service Activity Report here] off begin
					// % protected region % [Add any additional guards for Special Service Activity Report here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'CLAIM_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Special Service Activity Report here] off begin
						// % protected region % [Add additional roles to Special Service Activity Report here] end
					],
					// % protected region % [Customise your data passed to Special Service Activity Report here] off begin
					// % protected region % [Customise your data passed to Special Service Activity Report here] end
				},
				// % protected region % [Add additional route properties here for special-service-activity-report] off begin
				// % protected region % [Add additional route properties here for special-service-activity-report] end
			},
			{
				path: 'staff-schedule',
				loadChildren: () => import('../pages/staff-schedule/staff-schedule.page.module').then(m => m.StaffSchedulePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Staff Schedule here] off begin
					// % protected region % [Add any additional guards for Staff Schedule here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Staff Schedule here] off begin
						// % protected region % [Add additional roles to Staff Schedule here] end
					],
					// % protected region % [Customise your data passed to Staff Schedule here] off begin
					// % protected region % [Customise your data passed to Staff Schedule here] end
				},
				// % protected region % [Add additional route properties here for staff-schedule] off begin
				// % protected region % [Add additional route properties here for staff-schedule] end
			},
			{
				path: 'staff-and-user',
				loadChildren: () => import('../pages/staff-and-user/staff-and-user.page.module').then(m => m.StaffAndUserPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Staff and User here] off begin
					// % protected region % [Add any additional guards for Staff and User here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'MEDICAL_RECORD_USER',
						// % protected region % [Add additional roles to Staff and User here] off begin
						// % protected region % [Add additional roles to Staff and User here] end
					],
					// % protected region % [Customise your data passed to Staff and User here] off begin
					// % protected region % [Customise your data passed to Staff and User here] end
				},
				// % protected region % [Add additional route properties here for staff-and-user] off begin
				// % protected region % [Add additional route properties here for staff-and-user] end
			},
			{
				path: 'stock-expiration-balance-report',
				loadChildren: () => import('../pages/stock-expiration-balance-report/stock-expiration-balance-report.page.module').then(m => m.StockExpirationBalanceReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Stock Expiration Balance Report here] off begin
					// % protected region % [Add any additional guards for Stock Expiration Balance Report here] end
				],
				data: {
					expectedRoles: [
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						// % protected region % [Add additional roles to Stock Expiration Balance Report here] off begin
						// % protected region % [Add additional roles to Stock Expiration Balance Report here] end
					],
					// % protected region % [Customise your data passed to Stock Expiration Balance Report here] off begin
					// % protected region % [Customise your data passed to Stock Expiration Balance Report here] end
				},
				// % protected region % [Add additional route properties here for stock-expiration-balance-report] off begin
				// % protected region % [Add additional route properties here for stock-expiration-balance-report] end
			},
			{
				path: 'stock-expiration-transaction-detail-report',
				loadChildren: () => import('../pages/stock-expiration-transaction-detail-report/stock-expiration-transaction-detail-report.page.module').then(m => m.StockExpirationTransactionDetailReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Stock Expiration Transaction Detail Report here] off begin
					// % protected region % [Add any additional guards for Stock Expiration Transaction Detail Report here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Stock Expiration Transaction Detail Report here] off begin
						// % protected region % [Add additional roles to Stock Expiration Transaction Detail Report here] end
					],
					// % protected region % [Customise your data passed to Stock Expiration Transaction Detail Report here] off begin
					// % protected region % [Customise your data passed to Stock Expiration Transaction Detail Report here] end
				},
				// % protected region % [Add additional route properties here for stock-expiration-transaction-detail-report] off begin
				// % protected region % [Add additional route properties here for stock-expiration-transaction-detail-report] end
			},
			{
				path: 'stock-mutation-report',
				loadChildren: () => import('../pages/stock-mutation-report/stock-mutation-report.page.module').then(m => m.StockMutationReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Stock Mutation Report here] off begin
					// % protected region % [Add any additional guards for Stock Mutation Report here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'REGISTRATION_USER',
						'NURSE_USER',
						'WAREHOUSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'DIAGNOSTIC_SUPPORT_USER',
						'DOCTOR_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'FACILITY_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Stock Mutation Report here] off begin
						// % protected region % [Add additional roles to Stock Mutation Report here] end
					],
					// % protected region % [Customise your data passed to Stock Mutation Report here] off begin
					// % protected region % [Customise your data passed to Stock Mutation Report here] end
				},
				// % protected region % [Add additional route properties here for stock-mutation-report] off begin
				// % protected region % [Add additional route properties here for stock-mutation-report] end
			},
			{
				path: 'stock-summary-report',
				loadChildren: () => import('../pages/stock-summary-report/stock-summary-report.page.module').then(m => m.StockSummaryReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Stock Summary Report here] off begin
					// % protected region % [Add any additional guards for Stock Summary Report here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'NURSE_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Stock Summary Report here] off begin
						// % protected region % [Add additional roles to Stock Summary Report here] end
					],
					// % protected region % [Customise your data passed to Stock Summary Report here] off begin
					// % protected region % [Customise your data passed to Stock Summary Report here] end
				},
				// % protected region % [Add additional route properties here for stock-summary-report] off begin
				// % protected region % [Add additional route properties here for stock-summary-report] end
			},
			{
				path: 'stock-transaction-detail-report',
				loadChildren: () => import('../pages/stock-transaction-detail-report/stock-transaction-detail-report.page.module').then(m => m.StockTransactionDetailReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Stock Transaction Detail Report here] off begin
					// % protected region % [Add any additional guards for Stock Transaction Detail Report here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'REGISTRATION_USER',
						'DOCTOR_USER',
						'WAREHOUSE_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Stock Transaction Detail Report here] off begin
						// % protected region % [Add additional roles to Stock Transaction Detail Report here] end
					],
					// % protected region % [Customise your data passed to Stock Transaction Detail Report here] off begin
					// % protected region % [Customise your data passed to Stock Transaction Detail Report here] end
				},
				// % protected region % [Add additional route properties here for stock-transaction-detail-report] off begin
				// % protected region % [Add additional route properties here for stock-transaction-detail-report] end
			},
			{
				path: 'supplier',
				loadChildren: () => import('../pages/supplier/supplier.page.module').then(m => m.SupplierPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Supplier here] off begin
					// % protected region % [Add any additional guards for Supplier here] end
				],
				data: {
					expectedRoles: [
						'CASHIER_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'ADMINISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Supplier here] off begin
						// % protected region % [Add additional roles to Supplier here] end
					],
					// % protected region % [Customise your data passed to Supplier here] off begin
					// % protected region % [Customise your data passed to Supplier here] end
				},
				// % protected region % [Add additional route properties here for supplier] off begin
				// % protected region % [Add additional route properties here for supplier] end
			},
			{
				path: 'supplier-product-detail',
				loadChildren: () => import('../pages/supplier-product-detail/supplier-product-detail.page.module').then(m => m.SupplierProductDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Supplier Product Detail here] off begin
					// % protected region % [Add any additional guards for Supplier Product Detail here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'MANAGEMENT_USER',
						'FACILITY_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PHARMACY_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Supplier Product Detail here] off begin
						// % protected region % [Add additional roles to Supplier Product Detail here] end
					],
					// % protected region % [Customise your data passed to Supplier Product Detail here] off begin
					// % protected region % [Customise your data passed to Supplier Product Detail here] end
				},
				// % protected region % [Add additional route properties here for supplier-product-detail] off begin
				// % protected region % [Add additional route properties here for supplier-product-detail] end
			},
			{
				path: 'supplier-wrapper',
				loadChildren: () => import('../pages/supplier-wrapper/supplier-wrapper.page.module').then(m => m.SupplierWrapperPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Supplier Wrapper here] off begin
					// % protected region % [Add any additional guards for Supplier Wrapper here] end
				],
				data: {
					expectedRoles: [
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'DOCTOR_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Supplier Wrapper here] off begin
						// % protected region % [Add additional roles to Supplier Wrapper here] end
					],
					// % protected region % [Customise your data passed to Supplier Wrapper here] off begin
					// % protected region % [Customise your data passed to Supplier Wrapper here] end
				},
				// % protected region % [Add additional route properties here for supplier-wrapper] off begin
				// % protected region % [Add additional route properties here for supplier-wrapper] end
			},
			{
				path: 'system-configuration',
				loadChildren: () => import('../pages/system-configuration/system-configuration.page.module').then(m => m.SystemConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for System Configuration here] off begin
					// % protected region % [Add any additional guards for System Configuration here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CASHIER_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'REGISTRATION_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to System Configuration here] off begin
						// % protected region % [Add additional roles to System Configuration here] end
					],
					// % protected region % [Customise your data passed to System Configuration here] off begin
					// % protected region % [Customise your data passed to System Configuration here] end
				},
				// % protected region % [Add additional route properties here for system-configuration] off begin
				// % protected region % [Add additional route properties here for system-configuration] end
			},
			{
				path: 'tariff-billing-configuration',
				loadChildren: () => import('../pages/tariff-billing-configuration/tariff-billing-configuration.page.module').then(m => m.TariffBillingConfigurationPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Tariff Billing Configuration here] off begin
					// % protected region % [Add any additional guards for Tariff Billing Configuration here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATOR',
						'CASHIER_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'PHARMACY_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						// % protected region % [Add additional roles to Tariff Billing Configuration here] off begin
						// % protected region % [Add additional roles to Tariff Billing Configuration here] end
					],
					// % protected region % [Customise your data passed to Tariff Billing Configuration here] off begin
					// % protected region % [Customise your data passed to Tariff Billing Configuration here] end
				},
				// % protected region % [Add additional route properties here for tariff-billing-configuration] off begin
				// % protected region % [Add additional route properties here for tariff-billing-configuration] end
			},
			{
				path: 'tariff-definition',
				loadChildren: () => import('../pages/tariff-definition/tariff-definition.page.module').then(m => m.TariffDefinitionPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Tariff Definition here] off begin
					// % protected region % [Add any additional guards for Tariff Definition here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'NURSE_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'WAREHOUSE_USER',
						'DOCTOR_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATOR',
						'MANAGEMENT_USER',
						'CLAIM_USER',
						// % protected region % [Add additional roles to Tariff Definition here] off begin
						// % protected region % [Add additional roles to Tariff Definition here] end
					],
					// % protected region % [Customise your data passed to Tariff Definition here] off begin
					// % protected region % [Customise your data passed to Tariff Definition here] end
				},
				// % protected region % [Add additional route properties here for tariff-definition] off begin
				// % protected region % [Add additional route properties here for tariff-definition] end
			},
			{
				path: 'tariff-formula',
				loadChildren: () => import('../pages/tariff-formula/tariff-formula.page.module').then(m => m.TariffFormulaPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Tariff Formula here] off begin
					// % protected region % [Add any additional guards for Tariff Formula here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'CLAIM_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'WAREHOUSE_USER',
						'ADMINISTRATION_USER',
						'NURSE_USER',
						'PURCHASING_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'PHARMACY_USER',
						// % protected region % [Add additional roles to Tariff Formula here] off begin
						// % protected region % [Add additional roles to Tariff Formula here] end
					],
					// % protected region % [Customise your data passed to Tariff Formula here] off begin
					// % protected region % [Customise your data passed to Tariff Formula here] end
				},
				// % protected region % [Add additional route properties here for tariff-formula] off begin
				// % protected region % [Add additional route properties here for tariff-formula] end
			},
			{
				path: 'tariff-management',
				loadChildren: () => import('../pages/tariff-management/tariff-management.page.module').then(m => m.TariffManagementPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Tariff Management here] off begin
					// % protected region % [Add any additional guards for Tariff Management here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'DOCTOR_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'FACILITY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						'ADMINISTRATOR',
						'REGISTRATION_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Tariff Management here] off begin
						// % protected region % [Add additional roles to Tariff Management here] end
					],
					// % protected region % [Customise your data passed to Tariff Management here] off begin
					// % protected region % [Customise your data passed to Tariff Management here] end
				},
				// % protected region % [Add additional route properties here for tariff-management] off begin
				// % protected region % [Add additional route properties here for tariff-management] end
			},
			{
				path: 'tariff-scheme',
				loadChildren: () => import('../pages/tariff-scheme/tariff-scheme.page.module').then(m => m.TariffSchemePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Tariff Scheme here] off begin
					// % protected region % [Add any additional guards for Tariff Scheme here] end
				],
				data: {
					expectedRoles: [
						'WAREHOUSE_USER',
						'CASHIER_USER',
						'REGISTRATION_USER',
						'ADMINISTRATOR',
						'MEDICAL_RECORD_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'MANAGEMENT_USER',
						'NURSE_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'SYSTEM_ADMIN_USER',
						'CLAIM_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Tariff Scheme here] off begin
						// % protected region % [Add additional roles to Tariff Scheme here] end
					],
					// % protected region % [Customise your data passed to Tariff Scheme here] off begin
					// % protected region % [Customise your data passed to Tariff Scheme here] end
				},
				// % protected region % [Add additional route properties here for tariff-scheme] off begin
				// % protected region % [Add additional route properties here for tariff-scheme] end
			},
			{
				path: 'task-dashboard',
				loadChildren: () => import('../pages/task-dashboard/task-dashboard.page.module').then(m => m.TaskDashboardPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Task Dashboard here] off begin
					// % protected region % [Add any additional guards for Task Dashboard here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						'PURCHASING_USER',
						'NURSE_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'MANAGEMENT_USER',
						'ADMINISTRATOR',
						// % protected region % [Add additional roles to Task Dashboard here] off begin
						// % protected region % [Add additional roles to Task Dashboard here] end
					],
					// % protected region % [Customise your data passed to Task Dashboard here] off begin
					// % protected region % [Customise your data passed to Task Dashboard here] end
				},
				// % protected region % [Add additional route properties here for task-dashboard] off begin
				// % protected region % [Add additional route properties here for task-dashboard] end
			},
			{
				path: 'top-disease-report',
				loadChildren: () => import('../pages/top-disease-report/top-disease-report.page.module').then(m => m.TopDiseaseReportPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Top Disease Report here] off begin
					// % protected region % [Add any additional guards for Top Disease Report here] end
				],
				data: {
					expectedRoles: [
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'PHARMACY_USER',
						'PURCHASING_USER',
						'SYSTEM_ADMIN_USER',
						'FACILITY_USER',
						'ADMINISTRATOR',
						'MEDICAL_TRANSCRIBER_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'CASHIER_USER',
						// % protected region % [Add additional roles to Top Disease Report here] off begin
						// % protected region % [Add additional roles to Top Disease Report here] end
					],
					// % protected region % [Customise your data passed to Top Disease Report here] off begin
					// % protected region % [Customise your data passed to Top Disease Report here] end
				},
				// % protected region % [Add additional route properties here for top-disease-report] off begin
				// % protected region % [Add additional route properties here for top-disease-report] end
			},
			{
				path: 'transaction-detail-type',
				loadChildren: () => import('../pages/transaction-detail-type/transaction-detail-type.page.module').then(m => m.TransactionDetailTypePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Transaction Detail Type here] off begin
					// % protected region % [Add any additional guards for Transaction Detail Type here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'ADMINISTRATOR',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'CASHIER_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'SYSTEM_ADMIN_USER',
						'ADMINISTRATION_USER',
						'CLAIM_USER',
						'DOCTOR_USER',
						// % protected region % [Add additional roles to Transaction Detail Type here] off begin
						// % protected region % [Add additional roles to Transaction Detail Type here] end
					],
					// % protected region % [Customise your data passed to Transaction Detail Type here] off begin
					// % protected region % [Customise your data passed to Transaction Detail Type here] end
				},
				// % protected region % [Add additional route properties here for transaction-detail-type] off begin
				// % protected region % [Add additional route properties here for transaction-detail-type] end
			},
			{
				path: 'transfer-order',
				loadChildren: () => import('../pages/transfer-order/transfer-order.page.module').then(m => m.TransferOrderPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Transfer Order here] off begin
					// % protected region % [Add any additional guards for Transfer Order here] end
				],
				data: {
					expectedRoles: [
						'NURSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'PHARMACY_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Transfer Order here] off begin
						// % protected region % [Add additional roles to Transfer Order here] end
					],
					// % protected region % [Customise your data passed to Transfer Order here] off begin
					// % protected region % [Customise your data passed to Transfer Order here] end
				},
				// % protected region % [Add additional route properties here for transfer-order] off begin
				// % protected region % [Add additional route properties here for transfer-order] end
			},
			{
				path: 'transfer-order-stock-detail',
				loadChildren: () => import('../pages/transfer-order-stock-detail/transfer-order-stock-detail.page.module').then(m => m.TransferOrderStockDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Transfer Order Stock Detail here] off begin
					// % protected region % [Add any additional guards for Transfer Order Stock Detail here] end
				],
				data: {
					expectedRoles: [
						'MANAGEMENT_USER',
						'CLAIM_USER',
						'PHARMACY_USER',
						'FACILITY_USER',
						'ADMINISTRATION_USER',
						'DOCTOR_USER',
						'REGISTRATION_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'PURCHASING_USER',
						'ADMINISTRATOR',
						'SYSTEM_ADMIN_USER',
						'CASHIER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'NURSE_USER',
						// % protected region % [Add additional roles to Transfer Order Stock Detail here] off begin
						// % protected region % [Add additional roles to Transfer Order Stock Detail here] end
					],
					// % protected region % [Customise your data passed to Transfer Order Stock Detail here] off begin
					// % protected region % [Customise your data passed to Transfer Order Stock Detail here] end
				},
				// % protected region % [Add additional route properties here for transfer-order-stock-detail] off begin
				// % protected region % [Add additional route properties here for transfer-order-stock-detail] end
			},
			{
				path: 'vaccination-order',
				loadChildren: () => import('../pages/vaccination-order/vaccination-order.page.module').then(m => m.VaccinationOrderPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Vaccination Order here] off begin
					// % protected region % [Add any additional guards for Vaccination Order here] end
				],
				data: {
					expectedRoles: [
						'DOCTOR_USER',
						'PHARMACY_USER',
						'ADMINISTRATOR',
						'NURSE_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'MANAGEMENT_USER',
						'WAREHOUSE_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'MEDICAL_RECORD_USER',
						'CASHIER_USER',
						'SYSTEM_ADMIN_USER',
						'REGISTRATION_USER',
						'CLAIM_USER',
						'PURCHASING_USER',
						'ADMINISTRATION_USER',
						'FACILITY_USER',
						// % protected region % [Add additional roles to Vaccination Order here] off begin
						// % protected region % [Add additional roles to Vaccination Order here] end
					],
					// % protected region % [Customise your data passed to Vaccination Order here] off begin
					// % protected region % [Customise your data passed to Vaccination Order here] end
				},
				// % protected region % [Add additional route properties here for vaccination-order] off begin
				// % protected region % [Add additional route properties here for vaccination-order] end
			},
			{
				path: 'vaccination-order-detail',
				loadChildren: () => import('../pages/vaccination-order-detail/vaccination-order-detail.page.module').then(m => m.VaccinationOrderDetailPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Vaccination Order Detail here] off begin
					// % protected region % [Add any additional guards for Vaccination Order Detail here] end
				],
				data: {
					expectedRoles: [
						'REGISTRATION_USER',
						'MANAGEMENT_USER',
						'DOCTOR_USER',
						'CASHIER_USER',
						'FACILITY_USER',
						'PURCHASING_USER',
						'MEDICAL_RECORD_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'WAREHOUSE_USER',
						'PHARMACY_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'CLAIM_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						// % protected region % [Add additional roles to Vaccination Order Detail here] off begin
						// % protected region % [Add additional roles to Vaccination Order Detail here] end
					],
					// % protected region % [Customise your data passed to Vaccination Order Detail here] off begin
					// % protected region % [Customise your data passed to Vaccination Order Detail here] end
				},
				// % protected region % [Add additional route properties here for vaccination-order-detail] off begin
				// % protected region % [Add additional route properties here for vaccination-order-detail] end
			},
			{
				path: 'vital-signs',
				loadChildren: () => import('../pages/vital-signs/vital-signs.page.module').then(m => m.VitalSignsPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Vital Signs here] off begin
					// % protected region % [Add any additional guards for Vital Signs here] end
				],
				data: {
					expectedRoles: [
						'CLAIM_USER',
						'DOCTOR_USER',
						'ADMINISTRATOR',
						'ADMINISTRATION_USER',
						'PHARMACY_USER',
						'CASHIER_USER',
						'PURCHASING_USER',
						'MANAGEMENT_USER',
						'MEDICAL_RECORD_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'REGISTRATION_USER',
						'SYSTEM_ADMIN_USER',
						'NURSE_USER',
						'FACILITY_USER',
						'WAREHOUSE_USER',
						// % protected region % [Add additional roles to Vital Signs here] off begin
						// % protected region % [Add additional roles to Vital Signs here] end
					],
					// % protected region % [Customise your data passed to Vital Signs here] off begin
					// % protected region % [Customise your data passed to Vital Signs here] end
				},
				// % protected region % [Add additional route properties here for vital-signs] off begin
				// % protected region % [Add additional route properties here for vital-signs] end
			},
			{
				path: 'warehouse',
				loadChildren: () => import('../pages/warehouse/warehouse.page.module').then(m => m.WarehousePageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Warehouse here] off begin
					// % protected region % [Add any additional guards for Warehouse here] end
				],
				data: {
					expectedRoles: [
						'FACILITY_USER',
						'PHARMACY_USER',
						'MANAGEMENT_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'PURCHASING_USER',
						'DOCTOR_USER',
						'NURSE_USER',
						'CLAIM_USER',
						'SYSTEM_ADMIN_USER',
						'MEDICAL_TRANSCRIBER_USER',
						'WAREHOUSE_USER',
						'MEDICAL_RECORD_USER',
						'REGISTRATION_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'ADMINISTRATION_USER',
						// % protected region % [Add additional roles to Warehouse here] off begin
						// % protected region % [Add additional roles to Warehouse here] end
					],
					// % protected region % [Customise your data passed to Warehouse here] off begin
					// % protected region % [Customise your data passed to Warehouse here] end
				},
				// % protected region % [Add additional route properties here for warehouse] off begin
				// % protected region % [Add additional route properties here for warehouse] end
			},
			{
				path: 'warehouse-inventory',
				loadChildren: () => import('../pages/warehouse-inventory/warehouse-inventory.page.module').then(m => m.WarehouseInventoryPageModule),
				canActivate: [
					RoleGuard,
					// % protected region % [Add any additional guards for Warehouse Inventory here] off begin
					// % protected region % [Add any additional guards for Warehouse Inventory here] end
				],
				data: {
					expectedRoles: [
						'MEDICAL_RECORD_USER',
						'WAREHOUSE_USER',
						'NURSE_USER',
						'SYSTEM_ADMIN_USER',
						'PHARMACY_USER',
						'DIAGNOSTIC_SUPPORT_USER',
						'FACILITY_USER',
						'DOCTOR_USER',
						'ADMINISTRATION_USER',
						'REGISTRATION_USER',
						'CASHIER_USER',
						'ADMINISTRATOR',
						'CLAIM_USER',
						'MANAGEMENT_USER',
						'PURCHASING_USER',
						'MEDICAL_TRANSCRIBER_USER',
						// % protected region % [Add additional roles to Warehouse Inventory here] off begin
						// % protected region % [Add additional roles to Warehouse Inventory here] end
					],
					// % protected region % [Customise your data passed to Warehouse Inventory here] off begin
					// % protected region % [Customise your data passed to Warehouse Inventory here] end
				},
				// % protected region % [Add additional route properties here for warehouse-inventory] off begin
				// % protected region % [Add additional route properties here for warehouse-inventory] end
			},
			// % protected region % [Add any additional frontend routes here] off begin
			// % protected region % [Add any additional frontend routes here] end
		]
	}

];

@NgModule({
	declarations: [
		// % protected region % [Add any additional declarations here] off begin
		// % protected region % [Add any additional declarations here] end
	],
	imports: [
		RouterModule.forChild(frontendRoutes),
		// % protected region % [Add any additional imports] off begin
		// % protected region % [Add any additional imports] end
	],
	exports: [
		RouterModule,
		// % protected region % [Add any additional exports] off begin
		// % protected region % [Add any additional exports] end
	],
	// % protected region % [Add any additional module data] off begin
	// % protected region % [Add any additional module data] end
})
export class FrontendRoutingModule { }
