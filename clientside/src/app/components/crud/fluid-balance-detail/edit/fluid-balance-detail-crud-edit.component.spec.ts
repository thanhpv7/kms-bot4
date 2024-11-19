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
	getFluidBalanceDetailCollectionModels,
	getCountFluidBalanceDetailModels,
	getFluidBalanceDetailModelWithId
} from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { FluidBalanceDetailCrudModule } from '../fluid-balance-detail-crud.module';
import { FluidBalanceDetailCrudEditComponent } from './fluid-balance-detail-crud-edit.component';
import {
	FluidBalanceDetailModelState,
	initialState as initialFluidBalanceDetailModelState
} from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.state';
import { FluidBalanceDetailDataFactory } from 'src/app/lib/utils/factories/fluid-balance-detail-data-factory';
import { FluidBalanceDetailModel } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import { CrudTileMode } from '../fluid-balance-detail-crud.component';
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
import { getBpjsPRBDetailModelWithId } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { getBpjsPRBDetailCollectionModels } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { BpjsPRBDetailModel } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model';
import { BpjsPRBDetailDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-detail-data-factory';
import { getBpjsPcareRegistrationsModelWithId } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { getBpjsPcareRegistrationsCollectionModels } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { BpjsPcareRegistrationsModel } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import { BpjsPcareRegistrationsDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-registrations-data-factory';
import { getBpjsSEPModelWithId } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { getBpjsSEPCollectionModels } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { BpjsSEPModel } from 'src/app/models/bpjsSEP/bpjs_sep.model';
import { BpjsSEPDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-data-factory';
import { getBedFacilityModelWithId } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { getBedFacilityCollectionModels } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { BedFacilityModel } from 'src/app/models/bedFacility/bed_facility.model';
import { BedFacilityDataFactory } from 'src/app/lib/utils/factories/bed-facility-data-factory';
import { getBedReserveModelWithId } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { getBedReserveCollectionModels } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { BedReserveModel } from 'src/app/models/bedReserve/bed_reserve.model';
import { BedReserveDataFactory } from 'src/app/lib/utils/factories/bed-reserve-data-factory';
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
import { getDiagnosticExaminationResultsModelWithId } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { getDiagnosticExaminationResultsCollectionModels } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { DiagnosticExaminationResultsModel } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model';
import { DiagnosticExaminationResultsDataFactory } from 'src/app/lib/utils/factories/diagnostic-examination-results-data-factory';
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
import { getExaminationItemModelWithId } from 'src/app/models/examinationItem/examination_item.model.selector';
import { getExaminationItemCollectionModels } from 'src/app/models/examinationItem/examination_item.model.selector';
import { ExaminationItemModel } from 'src/app/models/examinationItem/examination_item.model';
import { ExaminationItemDataFactory } from 'src/app/lib/utils/factories/examination-item-data-factory';
import { getFacilityUserModelWithId } from 'src/app/models/facilityUser/facility_user.model.selector';
import { getFacilityUserCollectionModels } from 'src/app/models/facilityUser/facility_user.model.selector';
import { FacilityUserModel } from 'src/app/models/facilityUser/facility_user.model';
import { FacilityUserDataFactory } from 'src/app/lib/utils/factories/facility-user-data-factory';
import { getHealthFacilityModelWithId } from 'src/app/models/healthFacility/health_facility.model.selector';
import { getHealthFacilityCollectionModels } from 'src/app/models/healthFacility/health_facility.model.selector';
import { HealthFacilityModel } from 'src/app/models/healthFacility/health_facility.model';
import { HealthFacilityDataFactory } from 'src/app/lib/utils/factories/health-facility-data-factory';
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
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
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
import { getOperatingTheaterMedicalExaminationRecordModelWithId } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { getOperatingTheaterMedicalExaminationRecordCollectionModels } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { OperatingTheaterMedicalExaminationRecordModel } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import { OperatingTheaterMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/operating-theater-medical-examination-record-data-factory';
import { getPcareDokterModelWithId } from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import { getPcareDokterCollectionModels } from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import { PcareDokterModel } from 'src/app/models/pcareDokter/pcare_dokter.model';
import { PcareDokterDataFactory } from 'src/app/lib/utils/factories/pcare-dokter-data-factory';
import { getPcareExaminationModelWithId } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { getPcareExaminationCollectionModels } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { PcareExaminationModel } from 'src/app/models/pcareExamination/pcare_examination.model';
import { PcareExaminationDataFactory } from 'src/app/lib/utils/factories/pcare-examination-data-factory';
import { getPatientConsentModelWithId } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { getPatientConsentCollectionModels } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { PatientConsentModel } from 'src/app/models/patientConsent/patient_consent.model';
import { PatientConsentDataFactory } from 'src/app/lib/utils/factories/patient-consent-data-factory';
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
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
import { getSepModelWithId } from 'src/app/models/sep/sep.model.selector';
import { getSepCollectionModels } from 'src/app/models/sep/sep.model.selector';
import { SepModel } from 'src/app/models/sep/sep.model';
import { SepDataFactory } from 'src/app/lib/utils/factories/sep-data-factory';
import { getSampleCollectionInformationModelWithId } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.selector';
import { getSampleCollectionInformationCollectionModels } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.selector';
import { SampleCollectionInformationModel } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model';
import { SampleCollectionInformationDataFactory } from 'src/app/lib/utils/factories/sample-collection-information-data-factory';
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
import { getWarehouseUserModelWithId } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { getWarehouseUserCollectionModels } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { WarehouseUserModel } from 'src/app/models/warehouseUser/warehouse_user.model';
import { WarehouseUserDataFactory } from 'src/app/lib/utils/factories/warehouse-user-data-factory';

describe('Fluid Balance Detail CRUD Edit component tests', () => {
	let fixture: ComponentFixture<FluidBalanceDetailCrudEditComponent>
	let component: FluidBalanceDetailCrudEditComponent;

	let fluidBalanceDetailModelState: FluidBalanceDetailModelState;

	let store: MockStore<{ model: FluidBalanceDetailModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let fluidBalanceDetailCountBehaviorSubject: BehaviorSubject<number>;
	let fluidBalanceDetailModelsBehaviorSubject: BehaviorSubject<FluidBalanceDetailModel[]>;
	let administrationUserModelsBehaviorSubject: BehaviorSubject<AdministrationUserModel[]>;
	let administratorModelsBehaviorSubject: BehaviorSubject<AdministratorModel[]>;
	let amendmentDetailModelsBehaviorSubject: BehaviorSubject<AmendmentDetailModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsPRBDetailModelsBehaviorSubject: BehaviorSubject<BpjsPRBDetailModel[]>;
	let bpjsPcareRegistrationsModelsBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel[]>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bedFacilityModelsBehaviorSubject: BehaviorSubject<BedFacilityModel[]>;
	let bedReserveModelsBehaviorSubject: BehaviorSubject<BedReserveModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let cashierUserModelsBehaviorSubject: BehaviorSubject<CashierUserModel[]>;
	let claimUserModelsBehaviorSubject: BehaviorSubject<ClaimUserModel[]>;
	let coTreatingDoctorModelsBehaviorSubject: BehaviorSubject<CoTreatingDoctorModel[]>;
	let dailyCareCPPTModelsBehaviorSubject: BehaviorSubject<DailyCareCPPTModel[]>;
	let deliveryMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<DeliveryMedicalExaminationRecordModel[]>;
	let deliveryProgressModelsBehaviorSubject: BehaviorSubject<DeliveryProgressModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let diagnosticExaminationResultsModelsBehaviorSubject: BehaviorSubject<DiagnosticExaminationResultsModel[]>;
	let diagnosticStaffExaminationSummaryModelsBehaviorSubject: BehaviorSubject<DiagnosticStaffExaminationSummaryModel[]>;
	let diagnosticSupportUserModelsBehaviorSubject: BehaviorSubject<DiagnosticSupportUserModel[]>;
	let doctorScheduleModelsBehaviorSubject: BehaviorSubject<DoctorScheduleModel[]>;
	let doctorUserModelsBehaviorSubject: BehaviorSubject<DoctorUserModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let facilityUserModelsBehaviorSubject: BehaviorSubject<FacilityUserModel[]>;
	let healthFacilityModelsBehaviorSubject: BehaviorSubject<HealthFacilityModel[]>;
	let hemodialysisMonitoringModelsBehaviorSubject: BehaviorSubject<HemodialysisMonitoringModel[]>;
	let hospitalBranchInformationModelsBehaviorSubject: BehaviorSubject<HospitalBranchInformationModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
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
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let newbornDetailModelsBehaviorSubject: BehaviorSubject<NewbornDetailModel[]>;
	let nurseUserModelsBehaviorSubject: BehaviorSubject<NurseUserModel[]>;
	let operatingTheaterMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel[]>;
	let pcareDokterModelsBehaviorSubject: BehaviorSubject<PcareDokterModel[]>;
	let pcareExaminationModelsBehaviorSubject: BehaviorSubject<PcareExaminationModel[]>;
	let patientConsentModelsBehaviorSubject: BehaviorSubject<PatientConsentModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let patientVitalInformationModelsBehaviorSubject: BehaviorSubject<PatientVitalInformationModel[]>;
	let pharmacyUserModelsBehaviorSubject: BehaviorSubject<PharmacyUserModel[]>;
	let preoperativeRecordsModelsBehaviorSubject: BehaviorSubject<PreoperativeRecordsModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let processWorkflowModelsBehaviorSubject: BehaviorSubject<ProcessWorkflowModel[]>;
	let purchasingUserModelsBehaviorSubject: BehaviorSubject<PurchasingUserModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let registrationUserModelsBehaviorSubject: BehaviorSubject<RegistrationUserModel[]>;
	let roomTransferModelsBehaviorSubject: BehaviorSubject<RoomTransferModel[]>;
	let sepModelsBehaviorSubject: BehaviorSubject<SepModel[]>;
	let sampleCollectionInformationModelsBehaviorSubject: BehaviorSubject<SampleCollectionInformationModel[]>;
	let sampleCollectionItemsModelsBehaviorSubject: BehaviorSubject<SampleCollectionItemsModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let systemAdminUserModelsBehaviorSubject: BehaviorSubject<SystemAdminUserModel[]>;
	let transferOrderStockDetailModelsBehaviorSubject: BehaviorSubject<TransferOrderStockDetailModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;
	let warehouseUserModelsBehaviorSubject: BehaviorSubject<WarehouseUserModel[]>;

	const fluidBalanceDetailFactory: FluidBalanceDetailDataFactory = new FluidBalanceDetailDataFactory();
	const defaultFluidBalanceDetailCount: number = 10;
	const defaultFluidBalanceDetailEntities: FluidBalanceDetailModel[] = fluidBalanceDetailFactory.createAll(defaultFluidBalanceDetailCount);

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

	const bpjsPRBDetailFactory: BpjsPRBDetailDataFactory = new BpjsPRBDetailDataFactory();
	const defaultBpjsPRBDetailCount: number = 10;
	const defaultBpjsPRBDetailEntities: BpjsPRBDetailModel[] = bpjsPRBDetailFactory.createAll(defaultBpjsPRBDetailCount);

	const bpjsPcareRegistrationsFactory: BpjsPcareRegistrationsDataFactory = new BpjsPcareRegistrationsDataFactory();
	const defaultBpjsPcareRegistrationsCount: number = 10;
	const defaultBpjsPcareRegistrationsEntities: BpjsPcareRegistrationsModel[] = bpjsPcareRegistrationsFactory.createAll(defaultBpjsPcareRegistrationsCount);

	const bpjsSEPFactory: BpjsSEPDataFactory = new BpjsSEPDataFactory();
	const defaultBpjsSEPCount: number = 10;
	const defaultBpjsSEPEntities: BpjsSEPModel[] = bpjsSEPFactory.createAll(defaultBpjsSEPCount);

	const bedFacilityFactory: BedFacilityDataFactory = new BedFacilityDataFactory();
	const defaultBedFacilityCount: number = 10;
	const defaultBedFacilityEntities: BedFacilityModel[] = bedFacilityFactory.createAll(defaultBedFacilityCount);

	const bedReserveFactory: BedReserveDataFactory = new BedReserveDataFactory();
	const defaultBedReserveCount: number = 10;
	const defaultBedReserveEntities: BedReserveModel[] = bedReserveFactory.createAll(defaultBedReserveCount);

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

	const diagnosticExaminationResultsFactory: DiagnosticExaminationResultsDataFactory = new DiagnosticExaminationResultsDataFactory();
	const defaultDiagnosticExaminationResultsCount: number = 10;
	const defaultDiagnosticExaminationResultsEntities: DiagnosticExaminationResultsModel[] = diagnosticExaminationResultsFactory.createAll(defaultDiagnosticExaminationResultsCount);

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

	const examinationItemFactory: ExaminationItemDataFactory = new ExaminationItemDataFactory();
	const defaultExaminationItemCount: number = 10;
	const defaultExaminationItemEntities: ExaminationItemModel[] = examinationItemFactory.createAll(defaultExaminationItemCount);

	const facilityUserFactory: FacilityUserDataFactory = new FacilityUserDataFactory();
	const defaultFacilityUserCount: number = 10;
	const defaultFacilityUserEntities: FacilityUserModel[] = facilityUserFactory.createAll(defaultFacilityUserCount);

	const healthFacilityFactory: HealthFacilityDataFactory = new HealthFacilityDataFactory();
	const defaultHealthFacilityCount: number = 10;
	const defaultHealthFacilityEntities: HealthFacilityModel[] = healthFacilityFactory.createAll(defaultHealthFacilityCount);

	const hemodialysisMonitoringFactory: HemodialysisMonitoringDataFactory = new HemodialysisMonitoringDataFactory();
	const defaultHemodialysisMonitoringCount: number = 10;
	const defaultHemodialysisMonitoringEntities: HemodialysisMonitoringModel[] = hemodialysisMonitoringFactory.createAll(defaultHemodialysisMonitoringCount);

	const hospitalBranchInformationFactory: HospitalBranchInformationDataFactory = new HospitalBranchInformationDataFactory();
	const defaultHospitalBranchInformationCount: number = 10;
	const defaultHospitalBranchInformationEntities: HospitalBranchInformationModel[] = hospitalBranchInformationFactory.createAll(defaultHospitalBranchInformationCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

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

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

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

	const pcareExaminationFactory: PcareExaminationDataFactory = new PcareExaminationDataFactory();
	const defaultPcareExaminationCount: number = 10;
	const defaultPcareExaminationEntities: PcareExaminationModel[] = pcareExaminationFactory.createAll(defaultPcareExaminationCount);

	const patientConsentFactory: PatientConsentDataFactory = new PatientConsentDataFactory();
	const defaultPatientConsentCount: number = 10;
	const defaultPatientConsentEntities: PatientConsentModel[] = patientConsentFactory.createAll(defaultPatientConsentCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

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

	const sepFactory: SepDataFactory = new SepDataFactory();
	const defaultSepCount: number = 10;
	const defaultSepEntities: SepModel[] = sepFactory.createAll(defaultSepCount);

	const sampleCollectionInformationFactory: SampleCollectionInformationDataFactory = new SampleCollectionInformationDataFactory();
	const defaultSampleCollectionInformationCount: number = 10;
	const defaultSampleCollectionInformationEntities: SampleCollectionInformationModel[] = sampleCollectionInformationFactory.createAll(defaultSampleCollectionInformationCount);

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

	const warehouseUserFactory: WarehouseUserDataFactory = new WarehouseUserDataFactory();
	const defaultWarehouseUserCount: number = 10;
	const defaultWarehouseUserEntities: WarehouseUserModel[] = warehouseUserFactory.createAll(defaultWarehouseUserCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let fluidBalanceDetailWithId: FluidBalanceDetailModel = defaultFluidBalanceDetailEntities[0];
	let fluidBalanceDetailModelWithIdBehaviorSubject: BehaviorSubject<FluidBalanceDetailModel>;

	fluidBalanceDetailWithId.registration = defaultRegistrationEntities[0];
	fluidBalanceDetailWithId.registrationId = fluidBalanceDetailWithId.registration.id;
	let registrationWithIdBehaviorSubject: BehaviorSubject<RegistrationModel>;

	fluidBalanceDetailWithId.staff = defaultStaffEntities[0];
	fluidBalanceDetailWithId.staffId = fluidBalanceDetailWithId.staff.id;
	let staffWithIdBehaviorSubject: BehaviorSubject<StaffModel>;


	const routerState: RouterState = {
		url: 'fluid-balance-detail-crud',
		urls: ['fluid-balance-detail-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: FluidBalanceDetailModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		fluidBalanceDetailModelState = initialFluidBalanceDetailModelState;
		store.setState({model: fluidBalanceDetailModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		fluidBalanceDetailCountBehaviorSubject = new BehaviorSubject(defaultFluidBalanceDetailCount);

		// selectors for all references
		fluidBalanceDetailModelsBehaviorSubject = new BehaviorSubject(defaultFluidBalanceDetailEntities);
		administrationUserModelsBehaviorSubject = new BehaviorSubject(defaultAdministrationUserEntities);
		administratorModelsBehaviorSubject = new BehaviorSubject(defaultAdministratorEntities);
		amendmentDetailModelsBehaviorSubject = new BehaviorSubject(defaultAmendmentDetailEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsPRBDetailModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBDetailEntities);
		bpjsPcareRegistrationsModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareRegistrationsEntities);
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bedFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBedFacilityEntities);
		bedReserveModelsBehaviorSubject = new BehaviorSubject(defaultBedReserveEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		cashierUserModelsBehaviorSubject = new BehaviorSubject(defaultCashierUserEntities);
		claimUserModelsBehaviorSubject = new BehaviorSubject(defaultClaimUserEntities);
		coTreatingDoctorModelsBehaviorSubject = new BehaviorSubject(defaultCoTreatingDoctorEntities);
		dailyCareCPPTModelsBehaviorSubject = new BehaviorSubject(defaultDailyCareCPPTEntities);
		deliveryMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDeliveryMedicalExaminationRecordEntities);
		deliveryProgressModelsBehaviorSubject = new BehaviorSubject(defaultDeliveryProgressEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		diagnosticExaminationResultsModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticExaminationResultsEntities);
		diagnosticStaffExaminationSummaryModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticStaffExaminationSummaryEntities);
		diagnosticSupportUserModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticSupportUserEntities);
		doctorScheduleModelsBehaviorSubject = new BehaviorSubject(defaultDoctorScheduleEntities);
		doctorUserModelsBehaviorSubject = new BehaviorSubject(defaultDoctorUserEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		facilityUserModelsBehaviorSubject = new BehaviorSubject(defaultFacilityUserEntities);
		healthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultHealthFacilityEntities);
		hemodialysisMonitoringModelsBehaviorSubject = new BehaviorSubject(defaultHemodialysisMonitoringEntities);
		hospitalBranchInformationModelsBehaviorSubject = new BehaviorSubject(defaultHospitalBranchInformationEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
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
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		newbornDetailModelsBehaviorSubject = new BehaviorSubject(defaultNewbornDetailEntities);
		nurseUserModelsBehaviorSubject = new BehaviorSubject(defaultNurseUserEntities);
		operatingTheaterMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultOperatingTheaterMedicalExaminationRecordEntities);
		pcareDokterModelsBehaviorSubject = new BehaviorSubject(defaultPcareDokterEntities);
		pcareExaminationModelsBehaviorSubject = new BehaviorSubject(defaultPcareExaminationEntities);
		patientConsentModelsBehaviorSubject = new BehaviorSubject(defaultPatientConsentEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		patientVitalInformationModelsBehaviorSubject = new BehaviorSubject(defaultPatientVitalInformationEntities);
		pharmacyUserModelsBehaviorSubject = new BehaviorSubject(defaultPharmacyUserEntities);
		preoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultPreoperativeRecordsEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		processWorkflowModelsBehaviorSubject = new BehaviorSubject(defaultProcessWorkflowEntities);
		purchasingUserModelsBehaviorSubject = new BehaviorSubject(defaultPurchasingUserEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		registrationUserModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationUserEntities);
		roomTransferModelsBehaviorSubject = new BehaviorSubject(defaultRoomTransferEntities);
		sepModelsBehaviorSubject = new BehaviorSubject(defaultSepEntities);
		sampleCollectionInformationModelsBehaviorSubject = new BehaviorSubject(defaultSampleCollectionInformationEntities);
		sampleCollectionItemsModelsBehaviorSubject = new BehaviorSubject(defaultSampleCollectionItemsEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		systemAdminUserModelsBehaviorSubject = new BehaviorSubject(defaultSystemAdminUserEntities);
		transferOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderStockDetailEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);
		warehouseUserModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseUserEntities);

		// selectors for target entity and its related entity
		fluidBalanceDetailModelWithIdBehaviorSubject = new BehaviorSubject(fluidBalanceDetailWithId);
		registrationWithIdBehaviorSubject = new BehaviorSubject(fluidBalanceDetailWithId.registration);
		staffWithIdBehaviorSubject = new BehaviorSubject(fluidBalanceDetailWithId.staff);

		spyOn(store, 'select')
			.withArgs(getCountFluidBalanceDetailModels).and.returnValue(fluidBalanceDetailCountBehaviorSubject)
			.withArgs(getFluidBalanceDetailModelWithId, fluidBalanceDetailWithId.id).and.returnValue(fluidBalanceDetailModelWithIdBehaviorSubject)
			.withArgs(getFluidBalanceDetailCollectionModels, jasmine.any(String)).and.returnValue(fluidBalanceDetailModelsBehaviorSubject)
			.withArgs(getAdministrationUserCollectionModels, jasmine.any(String)).and.returnValue(administrationUserModelsBehaviorSubject)
			.withArgs(getAdministratorCollectionModels, jasmine.any(String)).and.returnValue(administratorModelsBehaviorSubject)
			.withArgs(getAmendmentDetailCollectionModels, jasmine.any(String)).and.returnValue(amendmentDetailModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsPRBDetailCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBDetailModelsBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareRegistrationsModelsBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBedFacilityCollectionModels, jasmine.any(String)).and.returnValue(bedFacilityModelsBehaviorSubject)
			.withArgs(getBedReserveCollectionModels, jasmine.any(String)).and.returnValue(bedReserveModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getCashierUserCollectionModels, jasmine.any(String)).and.returnValue(cashierUserModelsBehaviorSubject)
			.withArgs(getClaimUserCollectionModels, jasmine.any(String)).and.returnValue(claimUserModelsBehaviorSubject)
			.withArgs(getCoTreatingDoctorCollectionModels, jasmine.any(String)).and.returnValue(coTreatingDoctorModelsBehaviorSubject)
			.withArgs(getDailyCareCPPTCollectionModels, jasmine.any(String)).and.returnValue(dailyCareCPPTModelsBehaviorSubject)
			.withArgs(getDeliveryMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(deliveryMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getDeliveryProgressCollectionModels, jasmine.any(String)).and.returnValue(deliveryProgressModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getDiagnosticExaminationResultsCollectionModels, jasmine.any(String)).and.returnValue(diagnosticExaminationResultsModelsBehaviorSubject)
			.withArgs(getDiagnosticStaffExaminationSummaryCollectionModels, jasmine.any(String)).and.returnValue(diagnosticStaffExaminationSummaryModelsBehaviorSubject)
			.withArgs(getDiagnosticSupportUserCollectionModels, jasmine.any(String)).and.returnValue(diagnosticSupportUserModelsBehaviorSubject)
			.withArgs(getDoctorScheduleCollectionModels, jasmine.any(String)).and.returnValue(doctorScheduleModelsBehaviorSubject)
			.withArgs(getDoctorUserCollectionModels, jasmine.any(String)).and.returnValue(doctorUserModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getFacilityUserCollectionModels, jasmine.any(String)).and.returnValue(facilityUserModelsBehaviorSubject)
			.withArgs(getHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(healthFacilityModelsBehaviorSubject)
			.withArgs(getHemodialysisMonitoringCollectionModels, jasmine.any(String)).and.returnValue(hemodialysisMonitoringModelsBehaviorSubject)
			.withArgs(getHospitalBranchInformationCollectionModels, jasmine.any(String)).and.returnValue(hospitalBranchInformationModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
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
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getNewbornDetailCollectionModels, jasmine.any(String)).and.returnValue(newbornDetailModelsBehaviorSubject)
			.withArgs(getNurseUserCollectionModels, jasmine.any(String)).and.returnValue(nurseUserModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(operatingTheaterMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getPcareDokterCollectionModels, jasmine.any(String)).and.returnValue(pcareDokterModelsBehaviorSubject)
			.withArgs(getPcareExaminationCollectionModels, jasmine.any(String)).and.returnValue(pcareExaminationModelsBehaviorSubject)
			.withArgs(getPatientConsentCollectionModels, jasmine.any(String)).and.returnValue(patientConsentModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPatientVitalInformationCollectionModels, jasmine.any(String)).and.returnValue(patientVitalInformationModelsBehaviorSubject)
			.withArgs(getPharmacyUserCollectionModels, jasmine.any(String)).and.returnValue(pharmacyUserModelsBehaviorSubject)
			.withArgs(getPreoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(preoperativeRecordsModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getProcessWorkflowCollectionModels, jasmine.any(String)).and.returnValue(processWorkflowModelsBehaviorSubject)
			.withArgs(getPurchasingUserCollectionModels, jasmine.any(String)).and.returnValue(purchasingUserModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRegistrationUserCollectionModels, jasmine.any(String)).and.returnValue(registrationUserModelsBehaviorSubject)
			.withArgs(getRoomTransferCollectionModels, jasmine.any(String)).and.returnValue(roomTransferModelsBehaviorSubject)
			.withArgs(getSepCollectionModels, jasmine.any(String)).and.returnValue(sepModelsBehaviorSubject)
			.withArgs(getSampleCollectionInformationCollectionModels, jasmine.any(String)).and.returnValue(sampleCollectionInformationModelsBehaviorSubject)
			.withArgs(getSampleCollectionItemsCollectionModels, jasmine.any(String)).and.returnValue(sampleCollectionItemsModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getSystemAdminUserCollectionModels, jasmine.any(String)).and.returnValue(systemAdminUserModelsBehaviorSubject)
			.withArgs(getTransferOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(transferOrderStockDetailModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getWarehouseUserCollectionModels, jasmine.any(String)).and.returnValue(warehouseUserModelsBehaviorSubject)
			.withArgs(getRegistrationModelWithId, fluidBalanceDetailWithId.registrationId).and.returnValue(registrationWithIdBehaviorSubject)
			.withArgs(getStaffModelWithId, fluidBalanceDetailWithId.staffId).and.returnValue(staffWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				FluidBalanceDetailCrudModule,
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

			fixture = TestBed.createComponent(FluidBalanceDetailCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new FluidBalanceDetailModel();
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
	it ('Renders the Fluid Balance Detail CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Registration relation.
	*
	* The button should only exist if registrationMultiCrudActive is true
	*/
	it ('Renders Registration Add Entity button in create mode', fakeAsync(() => {
		const registrationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!registrationButton).toEqual(component.registrationMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Registration', fakeAsync(() => {
		const registrationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationButton).toEqual(component.registrationMultiCrudActive);

		if (component.registrationMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRegistrationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model')).length;

			registrationButton.nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model')).length;

			expect(actualRegistrationRemoveButtonCount).toEqual(initialRegistrationRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Registration button', () => {
		const registrationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationButton).toEqual(component.registrationMultiCrudActive);

		if (component.registrationMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			registrationButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRegistrationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRegistrationRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model'));

			expect(actualRegistrationRemoveButtons.length).toEqual(initialRegistrationRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Registration button when one has already been added', () => {

		const registrationButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationButton).toEqual(component.registrationMultiCrudActive);

		if (component.registrationMultiCrudActive) {
			registrationButton.nativeElement.click();
			fixture.detectChanges();

			const updatedregistrationButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

			expect(updatedregistrationButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Registration entities from model when loading in edit mode', () => {
		component.targetModel = fluidBalanceDetailWithId;
		component.targetModelId = fluidBalanceDetailWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.registrationMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const registrationRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model')).length;

			expect(registrationRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Staff relation.
	*
	* The button should only exist if staffMultiCrudActive is true
	*/
	it ('Renders Staff Add Entity button in create mode', fakeAsync(() => {
		const staffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.staffDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!staffButton).toEqual(component.staffMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Staff', fakeAsync(() => {
		const staffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.staffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!staffButton).toEqual(component.staffMultiCrudActive);

		if (component.staffMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStaffRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.staffDisplayName + ' from Model')).length;

			staffButton.nativeElement.click();
			fixture.detectChanges();

			const actualStaffRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.staffDisplayName + ' from Model')).length;

			expect(actualStaffRemoveButtonCount).toEqual(initialStaffRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Staff button', () => {
		const staffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.staffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!staffButton).toEqual(component.staffMultiCrudActive);

		if (component.staffMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			staffButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStaffRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.staffDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStaffRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStaffRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.staffDisplayName + ' from Model'));

			expect(actualStaffRemoveButtons.length).toEqual(initialStaffRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Staff button when one has already been added', () => {

		const staffButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.staffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!staffButton).toEqual(component.staffMultiCrudActive);

		if (component.staffMultiCrudActive) {
			staffButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstaffButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.staffDisplayName + ' to Model'));

			expect(updatedstaffButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Staff entities from model when loading in edit mode', () => {
		component.targetModel = fluidBalanceDetailWithId;
		component.targetModelId = fluidBalanceDetailWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.staffMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const staffRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.staffDisplayName + ' from Model')).length;

			expect(staffRemoveButtonCount).toEqual(1);
		}
	});

});
