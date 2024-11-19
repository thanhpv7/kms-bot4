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
	getDeliveryMedicalExaminationRecordCollectionModels,
	getCountDeliveryMedicalExaminationRecordModels,
	getDeliveryMedicalExaminationRecordModelWithId
} from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import { DeliveryMedicalExaminationRecordCrudModule } from '../delivery-medical-examination-record-crud.module';
import { DeliveryMedicalExaminationRecordCrudEditComponent } from './delivery-medical-examination-record-crud-edit.component';
import {
	DeliveryMedicalExaminationRecordModelState,
	initialState as initialDeliveryMedicalExaminationRecordModelState
} from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.state';
import { DeliveryMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/delivery-medical-examination-record-data-factory';
import { DeliveryMedicalExaminationRecordModel } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import { CrudTileMode } from '../delivery-medical-examination-record-crud.component';
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
import { getBpjsDoctorMappingModelWithId } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-doctor-mapping-data-factory';
import { getBirthHistoryModelWithId } from 'src/app/models/birthHistory/birth_history.model.selector';
import { getBirthHistoryCollectionModels } from 'src/app/models/birthHistory/birth_history.model.selector';
import { BirthHistoryModel } from 'src/app/models/birthHistory/birth_history.model';
import { BirthHistoryDataFactory } from 'src/app/lib/utils/factories/birth-history-data-factory';
import { getBodyChartExaminationModelWithId } from 'src/app/models/bodyChartExamination/body_chart_examination.model.selector';
import { getBodyChartExaminationCollectionModels } from 'src/app/models/bodyChartExamination/body_chart_examination.model.selector';
import { BodyChartExaminationModel } from 'src/app/models/bodyChartExamination/body_chart_examination.model';
import { BodyChartExaminationDataFactory } from 'src/app/lib/utils/factories/body-chart-examination-data-factory';
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
import { getDeliveryProgressModelWithId } from 'src/app/models/deliveryProgress/delivery_progress.model.selector';
import { getDeliveryProgressCollectionModels } from 'src/app/models/deliveryProgress/delivery_progress.model.selector';
import { DeliveryProgressModel } from 'src/app/models/deliveryProgress/delivery_progress.model';
import { DeliveryProgressDataFactory } from 'src/app/lib/utils/factories/delivery-progress-data-factory';
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
import { getEntExaminationModelWithId } from 'src/app/models/entExamination/ent_examination.model.selector';
import { getEntExaminationCollectionModels } from 'src/app/models/entExamination/ent_examination.model.selector';
import { EntExaminationModel } from 'src/app/models/entExamination/ent_examination.model';
import { EntExaminationDataFactory } from 'src/app/lib/utils/factories/ent-examination-data-factory';
import { getEmergencyMedicalExaminationRecordModelWithId } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.selector';
import { getEmergencyMedicalExaminationRecordCollectionModels } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.selector';
import { EmergencyMedicalExaminationRecordModel } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model';
import { EmergencyMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/emergency-medical-examination-record-data-factory';
import { getFacilityUserModelWithId } from 'src/app/models/facilityUser/facility_user.model.selector';
import { getFacilityUserCollectionModels } from 'src/app/models/facilityUser/facility_user.model.selector';
import { FacilityUserModel } from 'src/app/models/facilityUser/facility_user.model';
import { FacilityUserDataFactory } from 'src/app/lib/utils/factories/facility-user-data-factory';
import { getFluidBalanceDetailModelWithId } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { getFluidBalanceDetailCollectionModels } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { FluidBalanceDetailModel } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import { FluidBalanceDetailDataFactory } from 'src/app/lib/utils/factories/fluid-balance-detail-data-factory';
import { getFormulirKonselingTesHivModelWithId } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.selector';
import { getFormulirKonselingTesHivCollectionModels } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.selector';
import { FormulirKonselingTesHivModel } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model';
import { FormulirKonselingTesHivDataFactory } from 'src/app/lib/utils/factories/formulir-konseling-tes-hiv-data-factory';
import { getHemodialysisExaminationModelWithId } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model.selector';
import { getHemodialysisExaminationCollectionModels } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model.selector';
import { HemodialysisExaminationModel } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model';
import { HemodialysisExaminationDataFactory } from 'src/app/lib/utils/factories/hemodialysis-examination-data-factory';
import { getHemodialysisMonitoringModelWithId } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model.selector';
import { getHemodialysisMonitoringCollectionModels } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model.selector';
import { HemodialysisMonitoringModel } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model';
import { HemodialysisMonitoringDataFactory } from 'src/app/lib/utils/factories/hemodialysis-monitoring-data-factory';
import { getHospitalBranchInformationModelWithId } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.selector';
import { getHospitalBranchInformationCollectionModels } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.selector';
import { HospitalBranchInformationModel } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model';
import { HospitalBranchInformationDataFactory } from 'src/app/lib/utils/factories/hospital-branch-information-data-factory';
import { getInformedConsentModelWithId } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { getInformedConsentCollectionModels } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { InformedConsentModel } from 'src/app/models/informedConsent/informed_consent.model';
import { InformedConsentDataFactory } from 'src/app/lib/utils/factories/informed-consent-data-factory';
import { getInpatientMedicalExaminationRecordModelWithId } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { getInpatientMedicalExaminationRecordCollectionModels } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { InpatientMedicalExaminationRecordModel } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import { InpatientMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/inpatient-medical-examination-record-data-factory';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
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
import { getMedicalRecordInitialChecklistModelWithId } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model.selector';
import { getMedicalRecordInitialChecklistCollectionModels } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model.selector';
import { MedicalRecordInitialChecklistModel } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model';
import { MedicalRecordInitialChecklistDataFactory } from 'src/app/lib/utils/factories/medical-record-initial-checklist-data-factory';
import { getMedicalRecordNextVerificationChecklistModelWithId } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.selector';
import { getMedicalRecordNextVerificationChecklistCollectionModels } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.selector';
import { MedicalRecordNextVerificationChecklistModel } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model';
import { MedicalRecordNextVerificationChecklistDataFactory } from 'src/app/lib/utils/factories/medical-record-next-verification-checklist-data-factory';
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
import { getMedicationHeaderModelWithId } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { getMedicationHeaderCollectionModels } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { MedicationHeaderModel } from 'src/app/models/medicationHeader/medication_header.model';
import { MedicationHeaderDataFactory } from 'src/app/lib/utils/factories/medication-header-data-factory';
import { getNewbornDetailModelWithId } from 'src/app/models/newbornDetail/newborn_detail.model.selector';
import { getNewbornDetailCollectionModels } from 'src/app/models/newbornDetail/newborn_detail.model.selector';
import { NewbornDetailModel } from 'src/app/models/newbornDetail/newborn_detail.model';
import { NewbornDetailDataFactory } from 'src/app/lib/utils/factories/newborn-detail-data-factory';
import { getNurseUserModelWithId } from 'src/app/models/nurseUser/nurse_user.model.selector';
import { getNurseUserCollectionModels } from 'src/app/models/nurseUser/nurse_user.model.selector';
import { NurseUserModel } from 'src/app/models/nurseUser/nurse_user.model';
import { NurseUserDataFactory } from 'src/app/lib/utils/factories/nurse-user-data-factory';
import { getNurseVitalSignMeasurementModelWithId } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.selector';
import { getNurseVitalSignMeasurementCollectionModels } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.selector';
import { NurseVitalSignMeasurementModel } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model';
import { NurseVitalSignMeasurementDataFactory } from 'src/app/lib/utils/factories/nurse-vital-sign-measurement-data-factory';
import { getObstetricAndGynecologyHistoryModelWithId } from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.selector';
import { getObstetricAndGynecologyHistoryCollectionModels } from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.selector';
import { ObstetricAndGynecologyHistoryModel } from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model';
import { ObstetricAndGynecologyHistoryDataFactory } from 'src/app/lib/utils/factories/obstetric-and-gynecology-history-data-factory';
import { getOdontogramExaminationModelWithId } from 'src/app/models/odontogramExamination/odontogram_examination.model.selector';
import { getOdontogramExaminationCollectionModels } from 'src/app/models/odontogramExamination/odontogram_examination.model.selector';
import { OdontogramExaminationModel } from 'src/app/models/odontogramExamination/odontogram_examination.model';
import { OdontogramExaminationDataFactory } from 'src/app/lib/utils/factories/odontogram-examination-data-factory';
import { getOperatingTheaterMedicalExaminationRecordModelWithId } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { getOperatingTheaterMedicalExaminationRecordCollectionModels } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { OperatingTheaterMedicalExaminationRecordModel } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import { OperatingTheaterMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/operating-theater-medical-examination-record-data-factory';
import { getOphthalmologyExaminationModelWithId } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model.selector';
import { getOphthalmologyExaminationCollectionModels } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model.selector';
import { OphthalmologyExaminationModel } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model';
import { OphthalmologyExaminationDataFactory } from 'src/app/lib/utils/factories/ophthalmology-examination-data-factory';
import { getPcareDokterModelWithId } from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import { getPcareDokterCollectionModels } from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import { PcareDokterModel } from 'src/app/models/pcareDokter/pcare_dokter.model';
import { PcareDokterDataFactory } from 'src/app/lib/utils/factories/pcare-dokter-data-factory';
import { getPatientConsentModelWithId } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { getPatientConsentCollectionModels } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { PatientConsentModel } from 'src/app/models/patientConsent/patient_consent.model';
import { PatientConsentDataFactory } from 'src/app/lib/utils/factories/patient-consent-data-factory';
import { getPatientVitalInformationModelWithId } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { getPatientVitalInformationCollectionModels } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { PatientVitalInformationModel } from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import { PatientVitalInformationDataFactory } from 'src/app/lib/utils/factories/patient-vital-information-data-factory';
import { getPharmacyUserModelWithId } from 'src/app/models/pharmacyUser/pharmacy_user.model.selector';
import { getPharmacyUserCollectionModels } from 'src/app/models/pharmacyUser/pharmacy_user.model.selector';
import { PharmacyUserModel } from 'src/app/models/pharmacyUser/pharmacy_user.model';
import { PharmacyUserDataFactory } from 'src/app/lib/utils/factories/pharmacy-user-data-factory';
import { getPreoperativeRecordsModelWithId } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { getPreoperativeRecordsCollectionModels } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { PreoperativeRecordsModel } from 'src/app/models/preoperativeRecords/preoperative_records.model';
import { PreoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/preoperative-records-data-factory';
import { getPrescriptionHeaderModelWithId } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderDataFactory } from 'src/app/lib/utils/factories/prescription-header-data-factory';
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
import { getTransferOrderStockDetailModelWithId } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.selector';
import { getTransferOrderStockDetailCollectionModels } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.selector';
import { TransferOrderStockDetailModel } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model';
import { TransferOrderStockDetailDataFactory } from 'src/app/lib/utils/factories/transfer-order-stock-detail-data-factory';
import { getVaccinationOrderModelWithId } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { getVaccinationOrderCollectionModels } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { VaccinationOrderModel } from 'src/app/models/vaccinationOrder/vaccination_order.model';
import { VaccinationOrderDataFactory } from 'src/app/lib/utils/factories/vaccination-order-data-factory';
import { getVitalSignsModelWithId } from 'src/app/models/vitalSigns/vital_signs.model.selector';
import { getVitalSignsCollectionModels } from 'src/app/models/vitalSigns/vital_signs.model.selector';
import { VitalSignsModel } from 'src/app/models/vitalSigns/vital_signs.model';
import { VitalSignsDataFactory } from 'src/app/lib/utils/factories/vital-signs-data-factory';
import { getWarehouseUserModelWithId } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { getWarehouseUserCollectionModels } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { WarehouseUserModel } from 'src/app/models/warehouseUser/warehouse_user.model';
import { WarehouseUserDataFactory } from 'src/app/lib/utils/factories/warehouse-user-data-factory';

describe('Delivery Medical Examination Record CRUD Edit component tests', () => {
	let fixture: ComponentFixture<DeliveryMedicalExaminationRecordCrudEditComponent>
	let component: DeliveryMedicalExaminationRecordCrudEditComponent;

	let deliveryMedicalExaminationRecordModelState: DeliveryMedicalExaminationRecordModelState;

	let store: MockStore<{ model: DeliveryMedicalExaminationRecordModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let deliveryMedicalExaminationRecordCountBehaviorSubject: BehaviorSubject<number>;
	let deliveryMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<DeliveryMedicalExaminationRecordModel[]>;
	let administrationUserModelsBehaviorSubject: BehaviorSubject<AdministrationUserModel[]>;
	let administratorModelsBehaviorSubject: BehaviorSubject<AdministratorModel[]>;
	let amendmentDetailModelsBehaviorSubject: BehaviorSubject<AmendmentDetailModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let birthHistoryModelsBehaviorSubject: BehaviorSubject<BirthHistoryModel[]>;
	let bodyChartExaminationModelsBehaviorSubject: BehaviorSubject<BodyChartExaminationModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let cashierUserModelsBehaviorSubject: BehaviorSubject<CashierUserModel[]>;
	let claimUserModelsBehaviorSubject: BehaviorSubject<ClaimUserModel[]>;
	let coTreatingDoctorModelsBehaviorSubject: BehaviorSubject<CoTreatingDoctorModel[]>;
	let dailyCareCPPTModelsBehaviorSubject: BehaviorSubject<DailyCareCPPTModel[]>;
	let deliveryProgressModelsBehaviorSubject: BehaviorSubject<DeliveryProgressModel[]>;
	let diagnosisExaminationRecordModelsBehaviorSubject: BehaviorSubject<DiagnosisExaminationRecordModel[]>;
	let diagnosisNandaModelsBehaviorSubject: BehaviorSubject<DiagnosisNandaModel[]>;
	let diagnosticStaffExaminationSummaryModelsBehaviorSubject: BehaviorSubject<DiagnosticStaffExaminationSummaryModel[]>;
	let diagnosticSupportUserModelsBehaviorSubject: BehaviorSubject<DiagnosticSupportUserModel[]>;
	let doctorScheduleModelsBehaviorSubject: BehaviorSubject<DoctorScheduleModel[]>;
	let doctorUserModelsBehaviorSubject: BehaviorSubject<DoctorUserModel[]>;
	let entExaminationModelsBehaviorSubject: BehaviorSubject<EntExaminationModel[]>;
	let emergencyMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<EmergencyMedicalExaminationRecordModel[]>;
	let facilityUserModelsBehaviorSubject: BehaviorSubject<FacilityUserModel[]>;
	let fluidBalanceDetailModelsBehaviorSubject: BehaviorSubject<FluidBalanceDetailModel[]>;
	let formulirKonselingTesHivModelsBehaviorSubject: BehaviorSubject<FormulirKonselingTesHivModel[]>;
	let hemodialysisExaminationModelsBehaviorSubject: BehaviorSubject<HemodialysisExaminationModel[]>;
	let hemodialysisMonitoringModelsBehaviorSubject: BehaviorSubject<HemodialysisMonitoringModel[]>;
	let hospitalBranchInformationModelsBehaviorSubject: BehaviorSubject<HospitalBranchInformationModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let inpatientMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<InpatientMedicalExaminationRecordModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
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
	let medicalRecordInitialChecklistModelsBehaviorSubject: BehaviorSubject<MedicalRecordInitialChecklistModel[]>;
	let medicalRecordNextVerificationChecklistModelsBehaviorSubject: BehaviorSubject<MedicalRecordNextVerificationChecklistModel[]>;
	let medicalRecordUserModelsBehaviorSubject: BehaviorSubject<MedicalRecordUserModel[]>;
	let medicalTranscriberUserModelsBehaviorSubject: BehaviorSubject<MedicalTranscriberUserModel[]>;
	let medicationAdministeredHistoryModelsBehaviorSubject: BehaviorSubject<MedicationAdministeredHistoryModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let newbornDetailModelsBehaviorSubject: BehaviorSubject<NewbornDetailModel[]>;
	let nurseUserModelsBehaviorSubject: BehaviorSubject<NurseUserModel[]>;
	let nurseVitalSignMeasurementModelsBehaviorSubject: BehaviorSubject<NurseVitalSignMeasurementModel[]>;
	let obstetricAndGynecologyHistoryModelsBehaviorSubject: BehaviorSubject<ObstetricAndGynecologyHistoryModel[]>;
	let odontogramExaminationModelsBehaviorSubject: BehaviorSubject<OdontogramExaminationModel[]>;
	let operatingTheaterMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel[]>;
	let ophthalmologyExaminationModelsBehaviorSubject: BehaviorSubject<OphthalmologyExaminationModel[]>;
	let pcareDokterModelsBehaviorSubject: BehaviorSubject<PcareDokterModel[]>;
	let patientConsentModelsBehaviorSubject: BehaviorSubject<PatientConsentModel[]>;
	let patientVitalInformationModelsBehaviorSubject: BehaviorSubject<PatientVitalInformationModel[]>;
	let pharmacyUserModelsBehaviorSubject: BehaviorSubject<PharmacyUserModel[]>;
	let preoperativeRecordsModelsBehaviorSubject: BehaviorSubject<PreoperativeRecordsModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let processWorkflowModelsBehaviorSubject: BehaviorSubject<ProcessWorkflowModel[]>;
	let purchasingUserModelsBehaviorSubject: BehaviorSubject<PurchasingUserModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let registrationUserModelsBehaviorSubject: BehaviorSubject<RegistrationUserModel[]>;
	let roomTransferModelsBehaviorSubject: BehaviorSubject<RoomTransferModel[]>;
	let sampleCollectionItemsModelsBehaviorSubject: BehaviorSubject<SampleCollectionItemsModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let systemAdminUserModelsBehaviorSubject: BehaviorSubject<SystemAdminUserModel[]>;
	let transferOrderStockDetailModelsBehaviorSubject: BehaviorSubject<TransferOrderStockDetailModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;
	let vitalSignsModelsBehaviorSubject: BehaviorSubject<VitalSignsModel[]>;
	let warehouseUserModelsBehaviorSubject: BehaviorSubject<WarehouseUserModel[]>;

	const deliveryMedicalExaminationRecordFactory: DeliveryMedicalExaminationRecordDataFactory = new DeliveryMedicalExaminationRecordDataFactory();
	const defaultDeliveryMedicalExaminationRecordCount: number = 10;
	const defaultDeliveryMedicalExaminationRecordEntities: DeliveryMedicalExaminationRecordModel[] = deliveryMedicalExaminationRecordFactory.createAll(defaultDeliveryMedicalExaminationRecordCount);

	const administrationUserFactory: AdministrationUserDataFactory = new AdministrationUserDataFactory();
	const defaultAdministrationUserCount: number = 10;
	const defaultAdministrationUserEntities: AdministrationUserModel[] = administrationUserFactory.createAll(defaultAdministrationUserCount);

	const administratorFactory: AdministratorDataFactory = new AdministratorDataFactory();
	const defaultAdministratorCount: number = 10;
	const defaultAdministratorEntities: AdministratorModel[] = administratorFactory.createAll(defaultAdministratorCount);

	const amendmentDetailFactory: AmendmentDetailDataFactory = new AmendmentDetailDataFactory();
	const defaultAmendmentDetailCount: number = 10;
	const defaultAmendmentDetailEntities: AmendmentDetailModel[] = amendmentDetailFactory.createAll(defaultAmendmentDetailCount);

	const bpjsDoctorMappingFactory: BpjsDoctorMappingDataFactory = new BpjsDoctorMappingDataFactory();
	const defaultBpjsDoctorMappingCount: number = 10;
	const defaultBpjsDoctorMappingEntities: BpjsDoctorMappingModel[] = bpjsDoctorMappingFactory.createAll(defaultBpjsDoctorMappingCount);

	const birthHistoryFactory: BirthHistoryDataFactory = new BirthHistoryDataFactory();
	const defaultBirthHistoryCount: number = 10;
	const defaultBirthHistoryEntities: BirthHistoryModel[] = birthHistoryFactory.createAll(defaultBirthHistoryCount);

	const bodyChartExaminationFactory: BodyChartExaminationDataFactory = new BodyChartExaminationDataFactory();
	const defaultBodyChartExaminationCount: number = 10;
	const defaultBodyChartExaminationEntities: BodyChartExaminationModel[] = bodyChartExaminationFactory.createAll(defaultBodyChartExaminationCount);

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

	const deliveryProgressFactory: DeliveryProgressDataFactory = new DeliveryProgressDataFactory();
	const defaultDeliveryProgressCount: number = 10;
	const defaultDeliveryProgressEntities: DeliveryProgressModel[] = deliveryProgressFactory.createAll(defaultDeliveryProgressCount);

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

	const entExaminationFactory: EntExaminationDataFactory = new EntExaminationDataFactory();
	const defaultEntExaminationCount: number = 10;
	const defaultEntExaminationEntities: EntExaminationModel[] = entExaminationFactory.createAll(defaultEntExaminationCount);

	const emergencyMedicalExaminationRecordFactory: EmergencyMedicalExaminationRecordDataFactory = new EmergencyMedicalExaminationRecordDataFactory();
	const defaultEmergencyMedicalExaminationRecordCount: number = 10;
	const defaultEmergencyMedicalExaminationRecordEntities: EmergencyMedicalExaminationRecordModel[] = emergencyMedicalExaminationRecordFactory.createAll(defaultEmergencyMedicalExaminationRecordCount);

	const facilityUserFactory: FacilityUserDataFactory = new FacilityUserDataFactory();
	const defaultFacilityUserCount: number = 10;
	const defaultFacilityUserEntities: FacilityUserModel[] = facilityUserFactory.createAll(defaultFacilityUserCount);

	const fluidBalanceDetailFactory: FluidBalanceDetailDataFactory = new FluidBalanceDetailDataFactory();
	const defaultFluidBalanceDetailCount: number = 10;
	const defaultFluidBalanceDetailEntities: FluidBalanceDetailModel[] = fluidBalanceDetailFactory.createAll(defaultFluidBalanceDetailCount);

	const formulirKonselingTesHivFactory: FormulirKonselingTesHivDataFactory = new FormulirKonselingTesHivDataFactory();
	const defaultFormulirKonselingTesHivCount: number = 10;
	const defaultFormulirKonselingTesHivEntities: FormulirKonselingTesHivModel[] = formulirKonselingTesHivFactory.createAll(defaultFormulirKonselingTesHivCount);

	const hemodialysisExaminationFactory: HemodialysisExaminationDataFactory = new HemodialysisExaminationDataFactory();
	const defaultHemodialysisExaminationCount: number = 10;
	const defaultHemodialysisExaminationEntities: HemodialysisExaminationModel[] = hemodialysisExaminationFactory.createAll(defaultHemodialysisExaminationCount);

	const hemodialysisMonitoringFactory: HemodialysisMonitoringDataFactory = new HemodialysisMonitoringDataFactory();
	const defaultHemodialysisMonitoringCount: number = 10;
	const defaultHemodialysisMonitoringEntities: HemodialysisMonitoringModel[] = hemodialysisMonitoringFactory.createAll(defaultHemodialysisMonitoringCount);

	const hospitalBranchInformationFactory: HospitalBranchInformationDataFactory = new HospitalBranchInformationDataFactory();
	const defaultHospitalBranchInformationCount: number = 10;
	const defaultHospitalBranchInformationEntities: HospitalBranchInformationModel[] = hospitalBranchInformationFactory.createAll(defaultHospitalBranchInformationCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const inpatientMedicalExaminationRecordFactory: InpatientMedicalExaminationRecordDataFactory = new InpatientMedicalExaminationRecordDataFactory();
	const defaultInpatientMedicalExaminationRecordCount: number = 10;
	const defaultInpatientMedicalExaminationRecordEntities: InpatientMedicalExaminationRecordModel[] = inpatientMedicalExaminationRecordFactory.createAll(defaultInpatientMedicalExaminationRecordCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

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

	const medicalRecordInitialChecklistFactory: MedicalRecordInitialChecklistDataFactory = new MedicalRecordInitialChecklistDataFactory();
	const defaultMedicalRecordInitialChecklistCount: number = 10;
	const defaultMedicalRecordInitialChecklistEntities: MedicalRecordInitialChecklistModel[] = medicalRecordInitialChecklistFactory.createAll(defaultMedicalRecordInitialChecklistCount);

	const medicalRecordNextVerificationChecklistFactory: MedicalRecordNextVerificationChecklistDataFactory = new MedicalRecordNextVerificationChecklistDataFactory();
	const defaultMedicalRecordNextVerificationChecklistCount: number = 10;
	const defaultMedicalRecordNextVerificationChecklistEntities: MedicalRecordNextVerificationChecklistModel[] = medicalRecordNextVerificationChecklistFactory.createAll(defaultMedicalRecordNextVerificationChecklistCount);

	const medicalRecordUserFactory: MedicalRecordUserDataFactory = new MedicalRecordUserDataFactory();
	const defaultMedicalRecordUserCount: number = 10;
	const defaultMedicalRecordUserEntities: MedicalRecordUserModel[] = medicalRecordUserFactory.createAll(defaultMedicalRecordUserCount);

	const medicalTranscriberUserFactory: MedicalTranscriberUserDataFactory = new MedicalTranscriberUserDataFactory();
	const defaultMedicalTranscriberUserCount: number = 10;
	const defaultMedicalTranscriberUserEntities: MedicalTranscriberUserModel[] = medicalTranscriberUserFactory.createAll(defaultMedicalTranscriberUserCount);

	const medicationAdministeredHistoryFactory: MedicationAdministeredHistoryDataFactory = new MedicationAdministeredHistoryDataFactory();
	const defaultMedicationAdministeredHistoryCount: number = 10;
	const defaultMedicationAdministeredHistoryEntities: MedicationAdministeredHistoryModel[] = medicationAdministeredHistoryFactory.createAll(defaultMedicationAdministeredHistoryCount);

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const newbornDetailFactory: NewbornDetailDataFactory = new NewbornDetailDataFactory();
	const defaultNewbornDetailCount: number = 10;
	const defaultNewbornDetailEntities: NewbornDetailModel[] = newbornDetailFactory.createAll(defaultNewbornDetailCount);

	const nurseUserFactory: NurseUserDataFactory = new NurseUserDataFactory();
	const defaultNurseUserCount: number = 10;
	const defaultNurseUserEntities: NurseUserModel[] = nurseUserFactory.createAll(defaultNurseUserCount);

	const nurseVitalSignMeasurementFactory: NurseVitalSignMeasurementDataFactory = new NurseVitalSignMeasurementDataFactory();
	const defaultNurseVitalSignMeasurementCount: number = 10;
	const defaultNurseVitalSignMeasurementEntities: NurseVitalSignMeasurementModel[] = nurseVitalSignMeasurementFactory.createAll(defaultNurseVitalSignMeasurementCount);

	const obstetricAndGynecologyHistoryFactory: ObstetricAndGynecologyHistoryDataFactory = new ObstetricAndGynecologyHistoryDataFactory();
	const defaultObstetricAndGynecologyHistoryCount: number = 10;
	const defaultObstetricAndGynecologyHistoryEntities: ObstetricAndGynecologyHistoryModel[] = obstetricAndGynecologyHistoryFactory.createAll(defaultObstetricAndGynecologyHistoryCount);

	const odontogramExaminationFactory: OdontogramExaminationDataFactory = new OdontogramExaminationDataFactory();
	const defaultOdontogramExaminationCount: number = 10;
	const defaultOdontogramExaminationEntities: OdontogramExaminationModel[] = odontogramExaminationFactory.createAll(defaultOdontogramExaminationCount);

	const operatingTheaterMedicalExaminationRecordFactory: OperatingTheaterMedicalExaminationRecordDataFactory = new OperatingTheaterMedicalExaminationRecordDataFactory();
	const defaultOperatingTheaterMedicalExaminationRecordCount: number = 10;
	const defaultOperatingTheaterMedicalExaminationRecordEntities: OperatingTheaterMedicalExaminationRecordModel[] = operatingTheaterMedicalExaminationRecordFactory.createAll(defaultOperatingTheaterMedicalExaminationRecordCount);

	const ophthalmologyExaminationFactory: OphthalmologyExaminationDataFactory = new OphthalmologyExaminationDataFactory();
	const defaultOphthalmologyExaminationCount: number = 10;
	const defaultOphthalmologyExaminationEntities: OphthalmologyExaminationModel[] = ophthalmologyExaminationFactory.createAll(defaultOphthalmologyExaminationCount);

	const pcareDokterFactory: PcareDokterDataFactory = new PcareDokterDataFactory();
	const defaultPcareDokterCount: number = 10;
	const defaultPcareDokterEntities: PcareDokterModel[] = pcareDokterFactory.createAll(defaultPcareDokterCount);

	const patientConsentFactory: PatientConsentDataFactory = new PatientConsentDataFactory();
	const defaultPatientConsentCount: number = 10;
	const defaultPatientConsentEntities: PatientConsentModel[] = patientConsentFactory.createAll(defaultPatientConsentCount);

	const patientVitalInformationFactory: PatientVitalInformationDataFactory = new PatientVitalInformationDataFactory();
	const defaultPatientVitalInformationCount: number = 10;
	const defaultPatientVitalInformationEntities: PatientVitalInformationModel[] = patientVitalInformationFactory.createAll(defaultPatientVitalInformationCount);

	const pharmacyUserFactory: PharmacyUserDataFactory = new PharmacyUserDataFactory();
	const defaultPharmacyUserCount: number = 10;
	const defaultPharmacyUserEntities: PharmacyUserModel[] = pharmacyUserFactory.createAll(defaultPharmacyUserCount);

	const preoperativeRecordsFactory: PreoperativeRecordsDataFactory = new PreoperativeRecordsDataFactory();
	const defaultPreoperativeRecordsCount: number = 10;
	const defaultPreoperativeRecordsEntities: PreoperativeRecordsModel[] = preoperativeRecordsFactory.createAll(defaultPreoperativeRecordsCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

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

	const transferOrderStockDetailFactory: TransferOrderStockDetailDataFactory = new TransferOrderStockDetailDataFactory();
	const defaultTransferOrderStockDetailCount: number = 10;
	const defaultTransferOrderStockDetailEntities: TransferOrderStockDetailModel[] = transferOrderStockDetailFactory.createAll(defaultTransferOrderStockDetailCount);

	const vaccinationOrderFactory: VaccinationOrderDataFactory = new VaccinationOrderDataFactory();
	const defaultVaccinationOrderCount: number = 10;
	const defaultVaccinationOrderEntities: VaccinationOrderModel[] = vaccinationOrderFactory.createAll(defaultVaccinationOrderCount);

	const vitalSignsFactory: VitalSignsDataFactory = new VitalSignsDataFactory();
	const defaultVitalSignsCount: number = 10;
	const defaultVitalSignsEntities: VitalSignsModel[] = vitalSignsFactory.createAll(defaultVitalSignsCount);

	const warehouseUserFactory: WarehouseUserDataFactory = new WarehouseUserDataFactory();
	const defaultWarehouseUserCount: number = 10;
	const defaultWarehouseUserEntities: WarehouseUserModel[] = warehouseUserFactory.createAll(defaultWarehouseUserCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let deliveryMedicalExaminationRecordWithId: DeliveryMedicalExaminationRecordModel = defaultDeliveryMedicalExaminationRecordEntities[0];
	let deliveryMedicalExaminationRecordModelWithIdBehaviorSubject: BehaviorSubject<DeliveryMedicalExaminationRecordModel>;

	deliveryMedicalExaminationRecordWithId.medicalExaminationRecord = defaultMedicalExaminationRecordEntities[0];
	deliveryMedicalExaminationRecordWithId.medicalExaminationRecordId = deliveryMedicalExaminationRecordWithId.medicalExaminationRecord.id;
	let medicalExaminationRecordWithIdBehaviorSubject: BehaviorSubject<MedicalExaminationRecordModel>;

	deliveryMedicalExaminationRecordWithId.midwife = defaultStaffEntities[0];
	deliveryMedicalExaminationRecordWithId.midwifeId = deliveryMedicalExaminationRecordWithId.midwife.id;
	let midwifeWithIdBehaviorSubject: BehaviorSubject<StaffModel>;

	deliveryMedicalExaminationRecordWithId.additionalMidwives = defaultCoTreatingDoctorEntities;
	deliveryMedicalExaminationRecordWithId.additionalMidwivesIds = deliveryMedicalExaminationRecordWithId.additionalMidwives.map(additionalMidwives => additionalMidwives.id);

	deliveryMedicalExaminationRecordWithId.deliveryProgresses = defaultDeliveryProgressEntities;
	deliveryMedicalExaminationRecordWithId.deliveryProgressesIds = deliveryMedicalExaminationRecordWithId.deliveryProgresses.map(deliveryProgresses => deliveryProgresses.id);

	deliveryMedicalExaminationRecordWithId.newbornDetails = defaultNewbornDetailEntities;
	deliveryMedicalExaminationRecordWithId.newbornDetailsIds = deliveryMedicalExaminationRecordWithId.newbornDetails.map(newbornDetails => newbornDetails.id);


	const routerState: RouterState = {
		url: 'delivery-medical-examination-record-crud',
		urls: ['delivery-medical-examination-record-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: DeliveryMedicalExaminationRecordModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		deliveryMedicalExaminationRecordModelState = initialDeliveryMedicalExaminationRecordModelState;
		store.setState({model: deliveryMedicalExaminationRecordModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		deliveryMedicalExaminationRecordCountBehaviorSubject = new BehaviorSubject(defaultDeliveryMedicalExaminationRecordCount);

		// selectors for all references
		deliveryMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDeliveryMedicalExaminationRecordEntities);
		administrationUserModelsBehaviorSubject = new BehaviorSubject(defaultAdministrationUserEntities);
		administratorModelsBehaviorSubject = new BehaviorSubject(defaultAdministratorEntities);
		amendmentDetailModelsBehaviorSubject = new BehaviorSubject(defaultAmendmentDetailEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		birthHistoryModelsBehaviorSubject = new BehaviorSubject(defaultBirthHistoryEntities);
		bodyChartExaminationModelsBehaviorSubject = new BehaviorSubject(defaultBodyChartExaminationEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		cashierUserModelsBehaviorSubject = new BehaviorSubject(defaultCashierUserEntities);
		claimUserModelsBehaviorSubject = new BehaviorSubject(defaultClaimUserEntities);
		coTreatingDoctorModelsBehaviorSubject = new BehaviorSubject(defaultCoTreatingDoctorEntities);
		dailyCareCPPTModelsBehaviorSubject = new BehaviorSubject(defaultDailyCareCPPTEntities);
		deliveryProgressModelsBehaviorSubject = new BehaviorSubject(defaultDeliveryProgressEntities);
		diagnosisExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisExaminationRecordEntities);
		diagnosisNandaModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisNandaEntities);
		diagnosticStaffExaminationSummaryModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticStaffExaminationSummaryEntities);
		diagnosticSupportUserModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticSupportUserEntities);
		doctorScheduleModelsBehaviorSubject = new BehaviorSubject(defaultDoctorScheduleEntities);
		doctorUserModelsBehaviorSubject = new BehaviorSubject(defaultDoctorUserEntities);
		entExaminationModelsBehaviorSubject = new BehaviorSubject(defaultEntExaminationEntities);
		emergencyMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultEmergencyMedicalExaminationRecordEntities);
		facilityUserModelsBehaviorSubject = new BehaviorSubject(defaultFacilityUserEntities);
		fluidBalanceDetailModelsBehaviorSubject = new BehaviorSubject(defaultFluidBalanceDetailEntities);
		formulirKonselingTesHivModelsBehaviorSubject = new BehaviorSubject(defaultFormulirKonselingTesHivEntities);
		hemodialysisExaminationModelsBehaviorSubject = new BehaviorSubject(defaultHemodialysisExaminationEntities);
		hemodialysisMonitoringModelsBehaviorSubject = new BehaviorSubject(defaultHemodialysisMonitoringEntities);
		hospitalBranchInformationModelsBehaviorSubject = new BehaviorSubject(defaultHospitalBranchInformationEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		inpatientMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultInpatientMedicalExaminationRecordEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
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
		medicalRecordInitialChecklistModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordInitialChecklistEntities);
		medicalRecordNextVerificationChecklistModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordNextVerificationChecklistEntities);
		medicalRecordUserModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordUserEntities);
		medicalTranscriberUserModelsBehaviorSubject = new BehaviorSubject(defaultMedicalTranscriberUserEntities);
		medicationAdministeredHistoryModelsBehaviorSubject = new BehaviorSubject(defaultMedicationAdministeredHistoryEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		newbornDetailModelsBehaviorSubject = new BehaviorSubject(defaultNewbornDetailEntities);
		nurseUserModelsBehaviorSubject = new BehaviorSubject(defaultNurseUserEntities);
		nurseVitalSignMeasurementModelsBehaviorSubject = new BehaviorSubject(defaultNurseVitalSignMeasurementEntities);
		obstetricAndGynecologyHistoryModelsBehaviorSubject = new BehaviorSubject(defaultObstetricAndGynecologyHistoryEntities);
		odontogramExaminationModelsBehaviorSubject = new BehaviorSubject(defaultOdontogramExaminationEntities);
		operatingTheaterMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultOperatingTheaterMedicalExaminationRecordEntities);
		ophthalmologyExaminationModelsBehaviorSubject = new BehaviorSubject(defaultOphthalmologyExaminationEntities);
		pcareDokterModelsBehaviorSubject = new BehaviorSubject(defaultPcareDokterEntities);
		patientConsentModelsBehaviorSubject = new BehaviorSubject(defaultPatientConsentEntities);
		patientVitalInformationModelsBehaviorSubject = new BehaviorSubject(defaultPatientVitalInformationEntities);
		pharmacyUserModelsBehaviorSubject = new BehaviorSubject(defaultPharmacyUserEntities);
		preoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultPreoperativeRecordsEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		processWorkflowModelsBehaviorSubject = new BehaviorSubject(defaultProcessWorkflowEntities);
		purchasingUserModelsBehaviorSubject = new BehaviorSubject(defaultPurchasingUserEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		registrationUserModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationUserEntities);
		roomTransferModelsBehaviorSubject = new BehaviorSubject(defaultRoomTransferEntities);
		sampleCollectionItemsModelsBehaviorSubject = new BehaviorSubject(defaultSampleCollectionItemsEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		systemAdminUserModelsBehaviorSubject = new BehaviorSubject(defaultSystemAdminUserEntities);
		transferOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderStockDetailEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);
		vitalSignsModelsBehaviorSubject = new BehaviorSubject(defaultVitalSignsEntities);
		warehouseUserModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseUserEntities);

		// selectors for target entity and its related entity
		deliveryMedicalExaminationRecordModelWithIdBehaviorSubject = new BehaviorSubject(deliveryMedicalExaminationRecordWithId);
		medicalExaminationRecordWithIdBehaviorSubject = new BehaviorSubject(deliveryMedicalExaminationRecordWithId.medicalExaminationRecord);
		midwifeWithIdBehaviorSubject = new BehaviorSubject(deliveryMedicalExaminationRecordWithId.midwife);

		spyOn(store, 'select')
			.withArgs(getCountDeliveryMedicalExaminationRecordModels).and.returnValue(deliveryMedicalExaminationRecordCountBehaviorSubject)
			.withArgs(getDeliveryMedicalExaminationRecordModelWithId, deliveryMedicalExaminationRecordWithId.id).and.returnValue(deliveryMedicalExaminationRecordModelWithIdBehaviorSubject)
			.withArgs(getDeliveryMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(deliveryMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getAdministrationUserCollectionModels, jasmine.any(String)).and.returnValue(administrationUserModelsBehaviorSubject)
			.withArgs(getAdministratorCollectionModels, jasmine.any(String)).and.returnValue(administratorModelsBehaviorSubject)
			.withArgs(getAmendmentDetailCollectionModels, jasmine.any(String)).and.returnValue(amendmentDetailModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBirthHistoryCollectionModels, jasmine.any(String)).and.returnValue(birthHistoryModelsBehaviorSubject)
			.withArgs(getBodyChartExaminationCollectionModels, jasmine.any(String)).and.returnValue(bodyChartExaminationModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getCashierUserCollectionModels, jasmine.any(String)).and.returnValue(cashierUserModelsBehaviorSubject)
			.withArgs(getClaimUserCollectionModels, jasmine.any(String)).and.returnValue(claimUserModelsBehaviorSubject)
			.withArgs(getCoTreatingDoctorCollectionModels, jasmine.any(String)).and.returnValue(coTreatingDoctorModelsBehaviorSubject)
			.withArgs(getDailyCareCPPTCollectionModels, jasmine.any(String)).and.returnValue(dailyCareCPPTModelsBehaviorSubject)
			.withArgs(getDeliveryProgressCollectionModels, jasmine.any(String)).and.returnValue(deliveryProgressModelsBehaviorSubject)
			.withArgs(getDiagnosisExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(diagnosisExaminationRecordModelsBehaviorSubject)
			.withArgs(getDiagnosisNandaCollectionModels, jasmine.any(String)).and.returnValue(diagnosisNandaModelsBehaviorSubject)
			.withArgs(getDiagnosticStaffExaminationSummaryCollectionModels, jasmine.any(String)).and.returnValue(diagnosticStaffExaminationSummaryModelsBehaviorSubject)
			.withArgs(getDiagnosticSupportUserCollectionModels, jasmine.any(String)).and.returnValue(diagnosticSupportUserModelsBehaviorSubject)
			.withArgs(getDoctorScheduleCollectionModels, jasmine.any(String)).and.returnValue(doctorScheduleModelsBehaviorSubject)
			.withArgs(getDoctorUserCollectionModels, jasmine.any(String)).and.returnValue(doctorUserModelsBehaviorSubject)
			.withArgs(getEntExaminationCollectionModels, jasmine.any(String)).and.returnValue(entExaminationModelsBehaviorSubject)
			.withArgs(getEmergencyMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(emergencyMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getFacilityUserCollectionModels, jasmine.any(String)).and.returnValue(facilityUserModelsBehaviorSubject)
			.withArgs(getFluidBalanceDetailCollectionModels, jasmine.any(String)).and.returnValue(fluidBalanceDetailModelsBehaviorSubject)
			.withArgs(getFormulirKonselingTesHivCollectionModels, jasmine.any(String)).and.returnValue(formulirKonselingTesHivModelsBehaviorSubject)
			.withArgs(getHemodialysisExaminationCollectionModels, jasmine.any(String)).and.returnValue(hemodialysisExaminationModelsBehaviorSubject)
			.withArgs(getHemodialysisMonitoringCollectionModels, jasmine.any(String)).and.returnValue(hemodialysisMonitoringModelsBehaviorSubject)
			.withArgs(getHospitalBranchInformationCollectionModels, jasmine.any(String)).and.returnValue(hospitalBranchInformationModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInpatientMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(inpatientMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
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
			.withArgs(getMedicalRecordInitialChecklistCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordInitialChecklistModelsBehaviorSubject)
			.withArgs(getMedicalRecordNextVerificationChecklistCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordNextVerificationChecklistModelsBehaviorSubject)
			.withArgs(getMedicalRecordUserCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordUserModelsBehaviorSubject)
			.withArgs(getMedicalTranscriberUserCollectionModels, jasmine.any(String)).and.returnValue(medicalTranscriberUserModelsBehaviorSubject)
			.withArgs(getMedicationAdministeredHistoryCollectionModels, jasmine.any(String)).and.returnValue(medicationAdministeredHistoryModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getNewbornDetailCollectionModels, jasmine.any(String)).and.returnValue(newbornDetailModelsBehaviorSubject)
			.withArgs(getNurseUserCollectionModels, jasmine.any(String)).and.returnValue(nurseUserModelsBehaviorSubject)
			.withArgs(getNurseVitalSignMeasurementCollectionModels, jasmine.any(String)).and.returnValue(nurseVitalSignMeasurementModelsBehaviorSubject)
			.withArgs(getObstetricAndGynecologyHistoryCollectionModels, jasmine.any(String)).and.returnValue(obstetricAndGynecologyHistoryModelsBehaviorSubject)
			.withArgs(getOdontogramExaminationCollectionModels, jasmine.any(String)).and.returnValue(odontogramExaminationModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(operatingTheaterMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getOphthalmologyExaminationCollectionModels, jasmine.any(String)).and.returnValue(ophthalmologyExaminationModelsBehaviorSubject)
			.withArgs(getPcareDokterCollectionModels, jasmine.any(String)).and.returnValue(pcareDokterModelsBehaviorSubject)
			.withArgs(getPatientConsentCollectionModels, jasmine.any(String)).and.returnValue(patientConsentModelsBehaviorSubject)
			.withArgs(getPatientVitalInformationCollectionModels, jasmine.any(String)).and.returnValue(patientVitalInformationModelsBehaviorSubject)
			.withArgs(getPharmacyUserCollectionModels, jasmine.any(String)).and.returnValue(pharmacyUserModelsBehaviorSubject)
			.withArgs(getPreoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(preoperativeRecordsModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getProcessWorkflowCollectionModels, jasmine.any(String)).and.returnValue(processWorkflowModelsBehaviorSubject)
			.withArgs(getPurchasingUserCollectionModels, jasmine.any(String)).and.returnValue(purchasingUserModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRegistrationUserCollectionModels, jasmine.any(String)).and.returnValue(registrationUserModelsBehaviorSubject)
			.withArgs(getRoomTransferCollectionModels, jasmine.any(String)).and.returnValue(roomTransferModelsBehaviorSubject)
			.withArgs(getSampleCollectionItemsCollectionModels, jasmine.any(String)).and.returnValue(sampleCollectionItemsModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getSystemAdminUserCollectionModels, jasmine.any(String)).and.returnValue(systemAdminUserModelsBehaviorSubject)
			.withArgs(getTransferOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(transferOrderStockDetailModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getVitalSignsCollectionModels, jasmine.any(String)).and.returnValue(vitalSignsModelsBehaviorSubject)
			.withArgs(getWarehouseUserCollectionModels, jasmine.any(String)).and.returnValue(warehouseUserModelsBehaviorSubject)
			.withArgs(getMedicalExaminationRecordModelWithId, deliveryMedicalExaminationRecordWithId.medicalExaminationRecordId).and.returnValue(medicalExaminationRecordWithIdBehaviorSubject)
			.withArgs(getStaffModelWithId, deliveryMedicalExaminationRecordWithId.midwifeId).and.returnValue(midwifeWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				DeliveryMedicalExaminationRecordCrudModule,
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

			fixture = TestBed.createComponent(DeliveryMedicalExaminationRecordCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new DeliveryMedicalExaminationRecordModel();
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
	it ('Renders the Delivery Medical Examination Record CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Medical Examination Record relation.
	*
	* The button should only exist if medicalExaminationRecordMultiCrudActive is true
	*/
	it ('Renders Medical Examination Record Add Entity button in create mode', fakeAsync(() => {
		const medicalExaminationRecordButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalExaminationRecordButton).toEqual(component.medicalExaminationRecordMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Examination Record', fakeAsync(() => {
		const medicalExaminationRecordButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalExaminationRecordButton).toEqual(component.medicalExaminationRecordMultiCrudActive);

		if (component.medicalExaminationRecordMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalExaminationRecordRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model')).length;

			medicalExaminationRecordButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalExaminationRecordRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model')).length;

			expect(actualMedicalExaminationRecordRemoveButtonCount).toEqual(initialMedicalExaminationRecordRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Examination Record button', () => {
		const medicalExaminationRecordButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalExaminationRecordButton).toEqual(component.medicalExaminationRecordMultiCrudActive);

		if (component.medicalExaminationRecordMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalExaminationRecordButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalExaminationRecordRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalExaminationRecordRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalExaminationRecordRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model'));

			expect(actualMedicalExaminationRecordRemoveButtons.length).toEqual(initialMedicalExaminationRecordRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Examination Record button when one has already been added', () => {

		const medicalExaminationRecordButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalExaminationRecordButton).toEqual(component.medicalExaminationRecordMultiCrudActive);

		if (component.medicalExaminationRecordMultiCrudActive) {
			medicalExaminationRecordButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalExaminationRecordButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDisplayName + ' to Model'));

			expect(updatedmedicalExaminationRecordButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Examination Record entities from model when loading in edit mode', () => {
		component.targetModel = deliveryMedicalExaminationRecordWithId;
		component.targetModelId = deliveryMedicalExaminationRecordWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalExaminationRecordMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalExaminationRecordRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDisplayName + ' from Model')).length;

			expect(medicalExaminationRecordRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Midwife relation.
	*
	* The button should only exist if midwifeMultiCrudActive is true
	*/
	it ('Renders Midwife Add Entity button in create mode', fakeAsync(() => {
		const midwifeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwifeDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!midwifeButton).toEqual(component.midwifeMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Midwife', fakeAsync(() => {
		const midwifeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwifeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!midwifeButton).toEqual(component.midwifeMultiCrudActive);

		if (component.midwifeMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMidwifeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwifeDisplayName + ' from Model')).length;

			midwifeButton.nativeElement.click();
			fixture.detectChanges();

			const actualMidwifeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwifeDisplayName + ' from Model')).length;

			expect(actualMidwifeRemoveButtonCount).toEqual(initialMidwifeRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Midwife button', () => {
		const midwifeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwifeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!midwifeButton).toEqual(component.midwifeMultiCrudActive);

		if (component.midwifeMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			midwifeButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMidwifeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwifeDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMidwifeRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMidwifeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwifeDisplayName + ' from Model'));

			expect(actualMidwifeRemoveButtons.length).toEqual(initialMidwifeRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Midwife button when one has already been added', () => {

		const midwifeButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwifeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!midwifeButton).toEqual(component.midwifeMultiCrudActive);

		if (component.midwifeMultiCrudActive) {
			midwifeButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmidwifeButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwifeDisplayName + ' to Model'));

			expect(updatedmidwifeButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Midwife entities from model when loading in edit mode', () => {
		component.targetModel = deliveryMedicalExaminationRecordWithId;
		component.targetModelId = deliveryMedicalExaminationRecordWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.midwifeMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const midwifeRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwifeDisplayName + ' from Model')).length;

			expect(midwifeRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Additional Midwives relation.
	*
	* The button should only exist if additionalMidwivesMultiCrudActive is true
	*/
	it ('Renders Additional Midwives Add Entity button in create mode', fakeAsync(() => {
		const additionalMidwivesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalMidwivesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!additionalMidwivesButton).toEqual(component.additionalMidwivesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Additional Midwives', fakeAsync(() => {
		const additionalMidwivesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalMidwivesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!additionalMidwivesButton).toEqual(component.additionalMidwivesMultiCrudActive);

		if (component.additionalMidwivesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAdditionalMidwivesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalMidwivesDisplayName + ' from Model')).length;

			additionalMidwivesButton.nativeElement.click();
			fixture.detectChanges();

			const actualAdditionalMidwivesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalMidwivesDisplayName + ' from Model')).length;

			expect(actualAdditionalMidwivesRemoveButtonCount).toEqual(initialAdditionalMidwivesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Additional Midwives button', () => {
		const additionalMidwivesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalMidwivesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!additionalMidwivesButton).toEqual(component.additionalMidwivesMultiCrudActive);

		if (component.additionalMidwivesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			additionalMidwivesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAdditionalMidwivesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalMidwivesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAdditionalMidwivesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAdditionalMidwivesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalMidwivesDisplayName + ' from Model'));

			expect(actualAdditionalMidwivesRemoveButtons.length).toEqual(initialAdditionalMidwivesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Additional Midwives button when one has already been added', () => {

		const additionalMidwivesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalMidwivesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!additionalMidwivesButton).toEqual(component.additionalMidwivesMultiCrudActive);

		if (component.additionalMidwivesMultiCrudActive) {
			additionalMidwivesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedadditionalMidwivesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalMidwivesDisplayName + ' to Model'));

			expect(updatedadditionalMidwivesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Additional Midwives entities from model when loading in edit mode', () => {
		component.targetModel = deliveryMedicalExaminationRecordWithId;
		component.targetModelId = deliveryMedicalExaminationRecordWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.additionalMidwivesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const additionalMidwivesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalMidwivesDisplayName + ' from Model')).length;

			expect(additionalMidwivesRemoveButtonCount).toEqual(deliveryMedicalExaminationRecordWithId.additionalMidwives.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Delivery Progresses relation.
	*
	* The button should only exist if deliveryProgressesMultiCrudActive is true
	*/
	it ('Renders Delivery Progresses Add Entity button in create mode', fakeAsync(() => {
		const deliveryProgressesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.deliveryProgressesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!deliveryProgressesButton).toEqual(component.deliveryProgressesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Delivery Progresses', fakeAsync(() => {
		const deliveryProgressesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.deliveryProgressesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!deliveryProgressesButton).toEqual(component.deliveryProgressesMultiCrudActive);

		if (component.deliveryProgressesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDeliveryProgressesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.deliveryProgressesDisplayName + ' from Model')).length;

			deliveryProgressesButton.nativeElement.click();
			fixture.detectChanges();

			const actualDeliveryProgressesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.deliveryProgressesDisplayName + ' from Model')).length;

			expect(actualDeliveryProgressesRemoveButtonCount).toEqual(initialDeliveryProgressesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Delivery Progresses button', () => {
		const deliveryProgressesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.deliveryProgressesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!deliveryProgressesButton).toEqual(component.deliveryProgressesMultiCrudActive);

		if (component.deliveryProgressesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			deliveryProgressesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDeliveryProgressesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.deliveryProgressesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDeliveryProgressesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDeliveryProgressesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.deliveryProgressesDisplayName + ' from Model'));

			expect(actualDeliveryProgressesRemoveButtons.length).toEqual(initialDeliveryProgressesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Delivery Progresses button when one has already been added', () => {

		const deliveryProgressesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.deliveryProgressesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!deliveryProgressesButton).toEqual(component.deliveryProgressesMultiCrudActive);

		if (component.deliveryProgressesMultiCrudActive) {
			deliveryProgressesButton.nativeElement.click();
			fixture.detectChanges();

			const updateddeliveryProgressesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.deliveryProgressesDisplayName + ' to Model'));

			expect(updateddeliveryProgressesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Delivery Progresses entities from model when loading in edit mode', () => {
		component.targetModel = deliveryMedicalExaminationRecordWithId;
		component.targetModelId = deliveryMedicalExaminationRecordWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.deliveryProgressesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const deliveryProgressesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.deliveryProgressesDisplayName + ' from Model')).length;

			expect(deliveryProgressesRemoveButtonCount).toEqual(deliveryMedicalExaminationRecordWithId.deliveryProgresses.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Newborn Details relation.
	*
	* The button should only exist if newbornDetailsMultiCrudActive is true
	*/
	it ('Renders Newborn Details Add Entity button in create mode', fakeAsync(() => {
		const newbornDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!newbornDetailsButton).toEqual(component.newbornDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Newborn Details', fakeAsync(() => {
		const newbornDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!newbornDetailsButton).toEqual(component.newbornDetailsMultiCrudActive);

		if (component.newbornDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialNewbornDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailsDisplayName + ' from Model')).length;

			newbornDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualNewbornDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailsDisplayName + ' from Model')).length;

			expect(actualNewbornDetailsRemoveButtonCount).toEqual(initialNewbornDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Newborn Details button', () => {
		const newbornDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!newbornDetailsButton).toEqual(component.newbornDetailsMultiCrudActive);

		if (component.newbornDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			newbornDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialNewbornDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialNewbornDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualNewbornDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailsDisplayName + ' from Model'));

			expect(actualNewbornDetailsRemoveButtons.length).toEqual(initialNewbornDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Newborn Details button when one has already been added', () => {

		const newbornDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!newbornDetailsButton).toEqual(component.newbornDetailsMultiCrudActive);

		if (component.newbornDetailsMultiCrudActive) {
			newbornDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatednewbornDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailsDisplayName + ' to Model'));

			expect(updatednewbornDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Newborn Details entities from model when loading in edit mode', () => {
		component.targetModel = deliveryMedicalExaminationRecordWithId;
		component.targetModelId = deliveryMedicalExaminationRecordWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.newbornDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const newbornDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailsDisplayName + ' from Model')).length;

			expect(newbornDetailsRemoveButtonCount).toEqual(deliveryMedicalExaminationRecordWithId.newbornDetails.length);
		}
	});

});
