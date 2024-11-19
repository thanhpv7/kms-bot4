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
	getStaffCollectionModels,
	getCountStaffModels,
	getStaffModelWithId
} from 'src/app/models/staff/staff.model.selector';
import { StaffCrudModule } from '../staff-crud.module';
import { StaffCrudEditComponent } from './staff-crud-edit.component';
import {
	StaffModelState,
	initialState as initialStaffModelState
} from 'src/app/models/staff/staff.model.state';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { CrudTileMode } from '../staff-crud.component';
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
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getBpjsControlPlanModelWithId } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import { getBpjsControlPlanCollectionModels } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import { BpjsControlPlanModel } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model';
import { BpjsControlPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-control-plan-data-factory';
import { getBpjsDoctorMappingModelWithId } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-doctor-mapping-data-factory';
import { getBpjsHospitalizationPlanModelWithId } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { getBpjsHospitalizationPlanCollectionModels } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { BpjsHospitalizationPlanModel } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import { BpjsHospitalizationPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-hospitalization-plan-data-factory';
import { getBpjsPRBModelWithId } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { getBpjsPRBCollectionModels } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { BpjsPRBModel } from 'src/app/models/bpjsPRB/bpjs_prb.model';
import { BpjsPRBDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-data-factory';
import { getBpjsPRBDetailModelWithId } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { getBpjsPRBDetailCollectionModels } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { BpjsPRBDetailModel } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model';
import { BpjsPRBDetailDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-detail-data-factory';
import { getBpjsPcarePoliModelWithId } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.selector';
import { getBpjsPcarePoliCollectionModels } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.selector';
import { BpjsPcarePoliModel } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model';
import { BpjsPcarePoliDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-poli-data-factory';
import { getBpjsPcareRegistrationsModelWithId } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { getBpjsPcareRegistrationsCollectionModels } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { BpjsPcareRegistrationsModel } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import { BpjsPcareRegistrationsDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-registrations-data-factory';
import { getBpjsSEPModelWithId } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { getBpjsSEPCollectionModels } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { BpjsSEPModel } from 'src/app/models/bpjsSEP/bpjs_sep.model';
import { BpjsSEPDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-data-factory';
import { getBpjsServiceMappingModelWithId } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { getBpjsServiceMappingCollectionModels } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { BpjsServiceMappingModel } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import { BpjsServiceMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-service-mapping-data-factory';
import { getBedFacilityModelWithId } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { getBedFacilityCollectionModels } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { BedFacilityModel } from 'src/app/models/bedFacility/bed_facility.model';
import { BedFacilityDataFactory } from 'src/app/lib/utils/factories/bed-facility-data-factory';
import { getBedReserveModelWithId } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { getBedReserveCollectionModels } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { BedReserveModel } from 'src/app/models/bedReserve/bed_reserve.model';
import { BedReserveDataFactory } from 'src/app/lib/utils/factories/bed-reserve-data-factory';
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
import { getEntExaminationModelWithId } from 'src/app/models/entExamination/ent_examination.model.selector';
import { getEntExaminationCollectionModels } from 'src/app/models/entExamination/ent_examination.model.selector';
import { EntExaminationModel } from 'src/app/models/entExamination/ent_examination.model';
import { EntExaminationDataFactory } from 'src/app/lib/utils/factories/ent-examination-data-factory';
import { getEmergencyMedicalExaminationRecordModelWithId } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.selector';
import { getEmergencyMedicalExaminationRecordCollectionModels } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.selector';
import { EmergencyMedicalExaminationRecordModel } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model';
import { EmergencyMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/emergency-medical-examination-record-data-factory';
import { getExaminationGroupModelWithId } from 'src/app/models/examinationGroup/examination_group.model.selector';
import { getExaminationGroupCollectionModels } from 'src/app/models/examinationGroup/examination_group.model.selector';
import { ExaminationGroupModel } from 'src/app/models/examinationGroup/examination_group.model';
import { ExaminationGroupDataFactory } from 'src/app/lib/utils/factories/examination-group-data-factory';
import { getExaminationItemModelWithId } from 'src/app/models/examinationItem/examination_item.model.selector';
import { getExaminationItemCollectionModels } from 'src/app/models/examinationItem/examination_item.model.selector';
import { ExaminationItemModel } from 'src/app/models/examinationItem/examination_item.model';
import { ExaminationItemDataFactory } from 'src/app/lib/utils/factories/examination-item-data-factory';
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
import { getHealthFacilityModelWithId } from 'src/app/models/healthFacility/health_facility.model.selector';
import { getHealthFacilityCollectionModels } from 'src/app/models/healthFacility/health_facility.model.selector';
import { HealthFacilityModel } from 'src/app/models/healthFacility/health_facility.model';
import { HealthFacilityDataFactory } from 'src/app/lib/utils/factories/health-facility-data-factory';
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
import { getHospitalGroupInformationModelWithId } from 'src/app/models/hospitalGroupInformation/hospital_group_information.model.selector';
import { getHospitalGroupInformationCollectionModels } from 'src/app/models/hospitalGroupInformation/hospital_group_information.model.selector';
import { HospitalGroupInformationModel } from 'src/app/models/hospitalGroupInformation/hospital_group_information.model';
import { HospitalGroupInformationDataFactory } from 'src/app/lib/utils/factories/hospital-group-information-data-factory';
import { getInformedConsentModelWithId } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { getInformedConsentCollectionModels } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { InformedConsentModel } from 'src/app/models/informedConsent/informed_consent.model';
import { InformedConsentDataFactory } from 'src/app/lib/utils/factories/informed-consent-data-factory';
import { getInpatientMedicalExaminationRecordModelWithId } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { getInpatientMedicalExaminationRecordCollectionModels } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { InpatientMedicalExaminationRecordModel } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import { InpatientMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/inpatient-medical-examination-record-data-factory';
import { getIntraoperativeRecordsModelWithId } from 'src/app/models/intraoperativeRecords/intraoperative_records.model.selector';
import { getIntraoperativeRecordsCollectionModels } from 'src/app/models/intraoperativeRecords/intraoperative_records.model.selector';
import { IntraoperativeRecordsModel } from 'src/app/models/intraoperativeRecords/intraoperative_records.model';
import { IntraoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/intraoperative-records-data-factory';
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
import { getMcuPackageModelWithId } from 'src/app/models/mcuPackage/mcu_package.model.selector';
import { getMcuPackageCollectionModels } from 'src/app/models/mcuPackage/mcu_package.model.selector';
import { McuPackageModel } from 'src/app/models/mcuPackage/mcu_package.model';
import { McuPackageDataFactory } from 'src/app/lib/utils/factories/mcu-package-data-factory';
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
import { getMerchantModelWithId } from 'src/app/models/merchant/merchant.model.selector';
import { getMerchantCollectionModels } from 'src/app/models/merchant/merchant.model.selector';
import { MerchantModel } from 'src/app/models/merchant/merchant.model';
import { MerchantDataFactory } from 'src/app/lib/utils/factories/merchant-data-factory';
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
import { getPcareExaminationModelWithId } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { getPcareExaminationCollectionModels } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { PcareExaminationModel } from 'src/app/models/pcareExamination/pcare_examination.model';
import { PcareExaminationDataFactory } from 'src/app/lib/utils/factories/pcare-examination-data-factory';
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
import { getServiceFacilityCategoryModelWithId } from 'src/app/models/serviceFacilityCategory/service_facility_category.model.selector';
import { getServiceFacilityCategoryCollectionModels } from 'src/app/models/serviceFacilityCategory/service_facility_category.model.selector';
import { ServiceFacilityCategoryModel } from 'src/app/models/serviceFacilityCategory/service_facility_category.model';
import { ServiceFacilityCategoryDataFactory } from 'src/app/lib/utils/factories/service-facility-category-data-factory';
import { getServiceItemModelWithId } from 'src/app/models/serviceItem/service_item.model.selector';
import { getServiceItemCollectionModels } from 'src/app/models/serviceItem/service_item.model.selector';
import { ServiceItemModel } from 'src/app/models/serviceItem/service_item.model';
import { ServiceItemDataFactory } from 'src/app/lib/utils/factories/service-item-data-factory';
import { getStockCatalogueModelWithId } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { getStockCatalogueCollectionModels } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { StockCatalogueModel } from 'src/app/models/stockCatalogue/stock_catalogue.model';
import { StockCatalogueDataFactory } from 'src/app/lib/utils/factories/stock-catalogue-data-factory';
import { getSystemAdminUserModelWithId } from 'src/app/models/systemAdminUser/system_admin_user.model.selector';
import { getSystemAdminUserCollectionModels } from 'src/app/models/systemAdminUser/system_admin_user.model.selector';
import { SystemAdminUserModel } from 'src/app/models/systemAdminUser/system_admin_user.model';
import { SystemAdminUserDataFactory } from 'src/app/lib/utils/factories/system-admin-user-data-factory';
import { getTariffSchemaModelWithId } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { getTariffSchemaCollectionModels } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { TariffSchemaModel } from 'src/app/models/tariffSchema/tariff_schema.model';
import { TariffSchemaDataFactory } from 'src/app/lib/utils/factories/tariff-schema-data-factory';
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
import { getVitalSignsModelWithId } from 'src/app/models/vitalSigns/vital_signs.model.selector';
import { getVitalSignsCollectionModels } from 'src/app/models/vitalSigns/vital_signs.model.selector';
import { VitalSignsModel } from 'src/app/models/vitalSigns/vital_signs.model';
import { VitalSignsDataFactory } from 'src/app/lib/utils/factories/vital-signs-data-factory';
import { getWarehouseModelWithId } from 'src/app/models/warehouse/warehouse.model.selector';
import { getWarehouseCollectionModels } from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { WarehouseDataFactory } from 'src/app/lib/utils/factories/warehouse-data-factory';
import { getWarehouseUserModelWithId } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { getWarehouseUserCollectionModels } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { WarehouseUserModel } from 'src/app/models/warehouseUser/warehouse_user.model';
import { WarehouseUserDataFactory } from 'src/app/lib/utils/factories/warehouse-user-data-factory';

describe('Staff CRUD Edit component tests', () => {
	let fixture: ComponentFixture<StaffCrudEditComponent>
	let component: StaffCrudEditComponent;

	let staffModelState: StaffModelState;

	let store: MockStore<{ model: StaffModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let staffCountBehaviorSubject: BehaviorSubject<number>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let administrationUserModelsBehaviorSubject: BehaviorSubject<AdministrationUserModel[]>;
	let administratorModelsBehaviorSubject: BehaviorSubject<AdministratorModel[]>;
	let amendmentDetailModelsBehaviorSubject: BehaviorSubject<AmendmentDetailModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsControlPlanModelsBehaviorSubject: BehaviorSubject<BpjsControlPlanModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsHospitalizationPlanModelsBehaviorSubject: BehaviorSubject<BpjsHospitalizationPlanModel[]>;
	let bpjsPRBModelsBehaviorSubject: BehaviorSubject<BpjsPRBModel[]>;
	let bpjsPRBDetailModelsBehaviorSubject: BehaviorSubject<BpjsPRBDetailModel[]>;
	let bpjsPcarePoliModelsBehaviorSubject: BehaviorSubject<BpjsPcarePoliModel[]>;
	let bpjsPcareRegistrationsModelsBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel[]>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let bedFacilityModelsBehaviorSubject: BehaviorSubject<BedFacilityModel[]>;
	let bedReserveModelsBehaviorSubject: BehaviorSubject<BedReserveModel[]>;
	let birthHistoryModelsBehaviorSubject: BehaviorSubject<BirthHistoryModel[]>;
	let bodyChartExaminationModelsBehaviorSubject: BehaviorSubject<BodyChartExaminationModel[]>;
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
	let diagnosticExaminationResultsModelsBehaviorSubject: BehaviorSubject<DiagnosticExaminationResultsModel[]>;
	let diagnosticStaffExaminationSummaryModelsBehaviorSubject: BehaviorSubject<DiagnosticStaffExaminationSummaryModel[]>;
	let diagnosticSupportUserModelsBehaviorSubject: BehaviorSubject<DiagnosticSupportUserModel[]>;
	let doctorScheduleModelsBehaviorSubject: BehaviorSubject<DoctorScheduleModel[]>;
	let doctorUserModelsBehaviorSubject: BehaviorSubject<DoctorUserModel[]>;
	let entExaminationModelsBehaviorSubject: BehaviorSubject<EntExaminationModel[]>;
	let emergencyMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<EmergencyMedicalExaminationRecordModel[]>;
	let examinationGroupModelsBehaviorSubject: BehaviorSubject<ExaminationGroupModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let facilityUserModelsBehaviorSubject: BehaviorSubject<FacilityUserModel[]>;
	let fluidBalanceDetailModelsBehaviorSubject: BehaviorSubject<FluidBalanceDetailModel[]>;
	let formulirKonselingTesHivModelsBehaviorSubject: BehaviorSubject<FormulirKonselingTesHivModel[]>;
	let healthFacilityModelsBehaviorSubject: BehaviorSubject<HealthFacilityModel[]>;
	let hemodialysisExaminationModelsBehaviorSubject: BehaviorSubject<HemodialysisExaminationModel[]>;
	let hemodialysisMonitoringModelsBehaviorSubject: BehaviorSubject<HemodialysisMonitoringModel[]>;
	let hospitalBranchInformationModelsBehaviorSubject: BehaviorSubject<HospitalBranchInformationModel[]>;
	let hospitalGroupInformationModelsBehaviorSubject: BehaviorSubject<HospitalGroupInformationModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let inpatientMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<InpatientMedicalExaminationRecordModel[]>;
	let intraoperativeRecordsModelsBehaviorSubject: BehaviorSubject<IntraoperativeRecordsModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let invoicePaymentInsuranceModelsBehaviorSubject: BehaviorSubject<InvoicePaymentInsuranceModel[]>;
	let invoicePaymentOtherModelsBehaviorSubject: BehaviorSubject<InvoicePaymentOtherModel[]>;
	let invoicePaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<InvoicePaymentSelfPayingModel[]>;
	let invoiceSummaryModelsBehaviorSubject: BehaviorSubject<InvoiceSummaryModel[]>;
	let mcuPackageModelsBehaviorSubject: BehaviorSubject<McuPackageModel[]>;
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
	let medicalRecordInitialChecklistModelsBehaviorSubject: BehaviorSubject<MedicalRecordInitialChecklistModel[]>;
	let medicalRecordNextVerificationChecklistModelsBehaviorSubject: BehaviorSubject<MedicalRecordNextVerificationChecklistModel[]>;
	let medicalRecordUserModelsBehaviorSubject: BehaviorSubject<MedicalRecordUserModel[]>;
	let medicalTranscriberUserModelsBehaviorSubject: BehaviorSubject<MedicalTranscriberUserModel[]>;
	let medicationAdministeredHistoryModelsBehaviorSubject: BehaviorSubject<MedicationAdministeredHistoryModel[]>;
	let medicationCompoundModelsBehaviorSubject: BehaviorSubject<MedicationCompoundModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let medicationItemModelsBehaviorSubject: BehaviorSubject<MedicationItemModel[]>;
	let merchantModelsBehaviorSubject: BehaviorSubject<MerchantModel[]>;
	let newbornDetailModelsBehaviorSubject: BehaviorSubject<NewbornDetailModel[]>;
	let nurseUserModelsBehaviorSubject: BehaviorSubject<NurseUserModel[]>;
	let nurseVitalSignMeasurementModelsBehaviorSubject: BehaviorSubject<NurseVitalSignMeasurementModel[]>;
	let obstetricAndGynecologyHistoryModelsBehaviorSubject: BehaviorSubject<ObstetricAndGynecologyHistoryModel[]>;
	let odontogramExaminationModelsBehaviorSubject: BehaviorSubject<OdontogramExaminationModel[]>;
	let operatingTheaterMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel[]>;
	let ophthalmologyExaminationModelsBehaviorSubject: BehaviorSubject<OphthalmologyExaminationModel[]>;
	let pcareDokterModelsBehaviorSubject: BehaviorSubject<PcareDokterModel[]>;
	let pcareExaminationModelsBehaviorSubject: BehaviorSubject<PcareExaminationModel[]>;
	let patientConsentModelsBehaviorSubject: BehaviorSubject<PatientConsentModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
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
	let sepModelsBehaviorSubject: BehaviorSubject<SepModel[]>;
	let sampleCollectionInformationModelsBehaviorSubject: BehaviorSubject<SampleCollectionInformationModel[]>;
	let sampleCollectionItemsModelsBehaviorSubject: BehaviorSubject<SampleCollectionItemsModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let serviceFacilityCategoryModelsBehaviorSubject: BehaviorSubject<ServiceFacilityCategoryModel[]>;
	let serviceItemModelsBehaviorSubject: BehaviorSubject<ServiceItemModel[]>;
	let stockCatalogueModelsBehaviorSubject: BehaviorSubject<StockCatalogueModel[]>;
	let systemAdminUserModelsBehaviorSubject: BehaviorSubject<SystemAdminUserModel[]>;
	let tariffSchemaModelsBehaviorSubject: BehaviorSubject<TariffSchemaModel[]>;
	let transferOrderModelsBehaviorSubject: BehaviorSubject<TransferOrderModel[]>;
	let transferOrderStockDetailModelsBehaviorSubject: BehaviorSubject<TransferOrderStockDetailModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;
	let vaccinationOrderDetailModelsBehaviorSubject: BehaviorSubject<VaccinationOrderDetailModel[]>;
	let vitalSignsModelsBehaviorSubject: BehaviorSubject<VitalSignsModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;
	let warehouseUserModelsBehaviorSubject: BehaviorSubject<WarehouseUserModel[]>;

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const administrationUserFactory: AdministrationUserDataFactory = new AdministrationUserDataFactory();
	const defaultAdministrationUserCount: number = 10;
	const defaultAdministrationUserEntities: AdministrationUserModel[] = administrationUserFactory.createAll(defaultAdministrationUserCount);

	const administratorFactory: AdministratorDataFactory = new AdministratorDataFactory();
	const defaultAdministratorCount: number = 10;
	const defaultAdministratorEntities: AdministratorModel[] = administratorFactory.createAll(defaultAdministratorCount);

	const amendmentDetailFactory: AmendmentDetailDataFactory = new AmendmentDetailDataFactory();
	const defaultAmendmentDetailCount: number = 10;
	const defaultAmendmentDetailEntities: AmendmentDetailModel[] = amendmentDetailFactory.createAll(defaultAmendmentDetailCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsControlPlanFactory: BpjsControlPlanDataFactory = new BpjsControlPlanDataFactory();
	const defaultBpjsControlPlanCount: number = 10;
	const defaultBpjsControlPlanEntities: BpjsControlPlanModel[] = bpjsControlPlanFactory.createAll(defaultBpjsControlPlanCount);

	const bpjsDoctorMappingFactory: BpjsDoctorMappingDataFactory = new BpjsDoctorMappingDataFactory();
	const defaultBpjsDoctorMappingCount: number = 10;
	const defaultBpjsDoctorMappingEntities: BpjsDoctorMappingModel[] = bpjsDoctorMappingFactory.createAll(defaultBpjsDoctorMappingCount);

	const bpjsHospitalizationPlanFactory: BpjsHospitalizationPlanDataFactory = new BpjsHospitalizationPlanDataFactory();
	const defaultBpjsHospitalizationPlanCount: number = 10;
	const defaultBpjsHospitalizationPlanEntities: BpjsHospitalizationPlanModel[] = bpjsHospitalizationPlanFactory.createAll(defaultBpjsHospitalizationPlanCount);

	const bpjsPRBFactory: BpjsPRBDataFactory = new BpjsPRBDataFactory();
	const defaultBpjsPRBCount: number = 10;
	const defaultBpjsPRBEntities: BpjsPRBModel[] = bpjsPRBFactory.createAll(defaultBpjsPRBCount);

	const bpjsPRBDetailFactory: BpjsPRBDetailDataFactory = new BpjsPRBDetailDataFactory();
	const defaultBpjsPRBDetailCount: number = 10;
	const defaultBpjsPRBDetailEntities: BpjsPRBDetailModel[] = bpjsPRBDetailFactory.createAll(defaultBpjsPRBDetailCount);

	const bpjsPcarePoliFactory: BpjsPcarePoliDataFactory = new BpjsPcarePoliDataFactory();
	const defaultBpjsPcarePoliCount: number = 10;
	const defaultBpjsPcarePoliEntities: BpjsPcarePoliModel[] = bpjsPcarePoliFactory.createAll(defaultBpjsPcarePoliCount);

	const bpjsPcareRegistrationsFactory: BpjsPcareRegistrationsDataFactory = new BpjsPcareRegistrationsDataFactory();
	const defaultBpjsPcareRegistrationsCount: number = 10;
	const defaultBpjsPcareRegistrationsEntities: BpjsPcareRegistrationsModel[] = bpjsPcareRegistrationsFactory.createAll(defaultBpjsPcareRegistrationsCount);

	const bpjsSEPFactory: BpjsSEPDataFactory = new BpjsSEPDataFactory();
	const defaultBpjsSEPCount: number = 10;
	const defaultBpjsSEPEntities: BpjsSEPModel[] = bpjsSEPFactory.createAll(defaultBpjsSEPCount);

	const bpjsServiceMappingFactory: BpjsServiceMappingDataFactory = new BpjsServiceMappingDataFactory();
	const defaultBpjsServiceMappingCount: number = 10;
	const defaultBpjsServiceMappingEntities: BpjsServiceMappingModel[] = bpjsServiceMappingFactory.createAll(defaultBpjsServiceMappingCount);

	const bedFacilityFactory: BedFacilityDataFactory = new BedFacilityDataFactory();
	const defaultBedFacilityCount: number = 10;
	const defaultBedFacilityEntities: BedFacilityModel[] = bedFacilityFactory.createAll(defaultBedFacilityCount);

	const bedReserveFactory: BedReserveDataFactory = new BedReserveDataFactory();
	const defaultBedReserveCount: number = 10;
	const defaultBedReserveEntities: BedReserveModel[] = bedReserveFactory.createAll(defaultBedReserveCount);

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

	const entExaminationFactory: EntExaminationDataFactory = new EntExaminationDataFactory();
	const defaultEntExaminationCount: number = 10;
	const defaultEntExaminationEntities: EntExaminationModel[] = entExaminationFactory.createAll(defaultEntExaminationCount);

	const emergencyMedicalExaminationRecordFactory: EmergencyMedicalExaminationRecordDataFactory = new EmergencyMedicalExaminationRecordDataFactory();
	const defaultEmergencyMedicalExaminationRecordCount: number = 10;
	const defaultEmergencyMedicalExaminationRecordEntities: EmergencyMedicalExaminationRecordModel[] = emergencyMedicalExaminationRecordFactory.createAll(defaultEmergencyMedicalExaminationRecordCount);

	const examinationGroupFactory: ExaminationGroupDataFactory = new ExaminationGroupDataFactory();
	const defaultExaminationGroupCount: number = 10;
	const defaultExaminationGroupEntities: ExaminationGroupModel[] = examinationGroupFactory.createAll(defaultExaminationGroupCount);

	const examinationItemFactory: ExaminationItemDataFactory = new ExaminationItemDataFactory();
	const defaultExaminationItemCount: number = 10;
	const defaultExaminationItemEntities: ExaminationItemModel[] = examinationItemFactory.createAll(defaultExaminationItemCount);

	const facilityUserFactory: FacilityUserDataFactory = new FacilityUserDataFactory();
	const defaultFacilityUserCount: number = 10;
	const defaultFacilityUserEntities: FacilityUserModel[] = facilityUserFactory.createAll(defaultFacilityUserCount);

	const fluidBalanceDetailFactory: FluidBalanceDetailDataFactory = new FluidBalanceDetailDataFactory();
	const defaultFluidBalanceDetailCount: number = 10;
	const defaultFluidBalanceDetailEntities: FluidBalanceDetailModel[] = fluidBalanceDetailFactory.createAll(defaultFluidBalanceDetailCount);

	const formulirKonselingTesHivFactory: FormulirKonselingTesHivDataFactory = new FormulirKonselingTesHivDataFactory();
	const defaultFormulirKonselingTesHivCount: number = 10;
	const defaultFormulirKonselingTesHivEntities: FormulirKonselingTesHivModel[] = formulirKonselingTesHivFactory.createAll(defaultFormulirKonselingTesHivCount);

	const healthFacilityFactory: HealthFacilityDataFactory = new HealthFacilityDataFactory();
	const defaultHealthFacilityCount: number = 10;
	const defaultHealthFacilityEntities: HealthFacilityModel[] = healthFacilityFactory.createAll(defaultHealthFacilityCount);

	const hemodialysisExaminationFactory: HemodialysisExaminationDataFactory = new HemodialysisExaminationDataFactory();
	const defaultHemodialysisExaminationCount: number = 10;
	const defaultHemodialysisExaminationEntities: HemodialysisExaminationModel[] = hemodialysisExaminationFactory.createAll(defaultHemodialysisExaminationCount);

	const hemodialysisMonitoringFactory: HemodialysisMonitoringDataFactory = new HemodialysisMonitoringDataFactory();
	const defaultHemodialysisMonitoringCount: number = 10;
	const defaultHemodialysisMonitoringEntities: HemodialysisMonitoringModel[] = hemodialysisMonitoringFactory.createAll(defaultHemodialysisMonitoringCount);

	const hospitalBranchInformationFactory: HospitalBranchInformationDataFactory = new HospitalBranchInformationDataFactory();
	const defaultHospitalBranchInformationCount: number = 10;
	const defaultHospitalBranchInformationEntities: HospitalBranchInformationModel[] = hospitalBranchInformationFactory.createAll(defaultHospitalBranchInformationCount);

	const hospitalGroupInformationFactory: HospitalGroupInformationDataFactory = new HospitalGroupInformationDataFactory();
	const defaultHospitalGroupInformationCount: number = 10;
	const defaultHospitalGroupInformationEntities: HospitalGroupInformationModel[] = hospitalGroupInformationFactory.createAll(defaultHospitalGroupInformationCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const inpatientMedicalExaminationRecordFactory: InpatientMedicalExaminationRecordDataFactory = new InpatientMedicalExaminationRecordDataFactory();
	const defaultInpatientMedicalExaminationRecordCount: number = 10;
	const defaultInpatientMedicalExaminationRecordEntities: InpatientMedicalExaminationRecordModel[] = inpatientMedicalExaminationRecordFactory.createAll(defaultInpatientMedicalExaminationRecordCount);

	const intraoperativeRecordsFactory: IntraoperativeRecordsDataFactory = new IntraoperativeRecordsDataFactory();
	const defaultIntraoperativeRecordsCount: number = 10;
	const defaultIntraoperativeRecordsEntities: IntraoperativeRecordsModel[] = intraoperativeRecordsFactory.createAll(defaultIntraoperativeRecordsCount);

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

	const mcuPackageFactory: McuPackageDataFactory = new McuPackageDataFactory();
	const defaultMcuPackageCount: number = 10;
	const defaultMcuPackageEntities: McuPackageModel[] = mcuPackageFactory.createAll(defaultMcuPackageCount);

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

	const medicationCompoundFactory: MedicationCompoundDataFactory = new MedicationCompoundDataFactory();
	const defaultMedicationCompoundCount: number = 10;
	const defaultMedicationCompoundEntities: MedicationCompoundModel[] = medicationCompoundFactory.createAll(defaultMedicationCompoundCount);

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const medicationItemFactory: MedicationItemDataFactory = new MedicationItemDataFactory();
	const defaultMedicationItemCount: number = 10;
	const defaultMedicationItemEntities: MedicationItemModel[] = medicationItemFactory.createAll(defaultMedicationItemCount);

	const merchantFactory: MerchantDataFactory = new MerchantDataFactory();
	const defaultMerchantCount: number = 10;
	const defaultMerchantEntities: MerchantModel[] = merchantFactory.createAll(defaultMerchantCount);

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

	const pcareExaminationFactory: PcareExaminationDataFactory = new PcareExaminationDataFactory();
	const defaultPcareExaminationCount: number = 10;
	const defaultPcareExaminationEntities: PcareExaminationModel[] = pcareExaminationFactory.createAll(defaultPcareExaminationCount);

	const patientConsentFactory: PatientConsentDataFactory = new PatientConsentDataFactory();
	const defaultPatientConsentCount: number = 10;
	const defaultPatientConsentEntities: PatientConsentModel[] = patientConsentFactory.createAll(defaultPatientConsentCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

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

	const serviceFacilityCategoryFactory: ServiceFacilityCategoryDataFactory = new ServiceFacilityCategoryDataFactory();
	const defaultServiceFacilityCategoryCount: number = 10;
	const defaultServiceFacilityCategoryEntities: ServiceFacilityCategoryModel[] = serviceFacilityCategoryFactory.createAll(defaultServiceFacilityCategoryCount);

	const serviceItemFactory: ServiceItemDataFactory = new ServiceItemDataFactory();
	const defaultServiceItemCount: number = 10;
	const defaultServiceItemEntities: ServiceItemModel[] = serviceItemFactory.createAll(defaultServiceItemCount);

	const stockCatalogueFactory: StockCatalogueDataFactory = new StockCatalogueDataFactory();
	const defaultStockCatalogueCount: number = 10;
	const defaultStockCatalogueEntities: StockCatalogueModel[] = stockCatalogueFactory.createAll(defaultStockCatalogueCount);

	const systemAdminUserFactory: SystemAdminUserDataFactory = new SystemAdminUserDataFactory();
	const defaultSystemAdminUserCount: number = 10;
	const defaultSystemAdminUserEntities: SystemAdminUserModel[] = systemAdminUserFactory.createAll(defaultSystemAdminUserCount);

	const tariffSchemaFactory: TariffSchemaDataFactory = new TariffSchemaDataFactory();
	const defaultTariffSchemaCount: number = 10;
	const defaultTariffSchemaEntities: TariffSchemaModel[] = tariffSchemaFactory.createAll(defaultTariffSchemaCount);

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

	const vitalSignsFactory: VitalSignsDataFactory = new VitalSignsDataFactory();
	const defaultVitalSignsCount: number = 10;
	const defaultVitalSignsEntities: VitalSignsModel[] = vitalSignsFactory.createAll(defaultVitalSignsCount);

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);

	const warehouseUserFactory: WarehouseUserDataFactory = new WarehouseUserDataFactory();
	const defaultWarehouseUserCount: number = 10;
	const defaultWarehouseUserEntities: WarehouseUserModel[] = warehouseUserFactory.createAll(defaultWarehouseUserCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let staffWithId: StaffModel = defaultStaffEntities[0];
	let staffModelWithIdBehaviorSubject: BehaviorSubject<StaffModel>;

	staffWithId.administrator = defaultAdministratorEntities[0];
	staffWithId.administratorId = staffWithId.administrator.id;
	let administratorWithIdBehaviorSubject: BehaviorSubject<AdministratorModel>;

	staffWithId.bpjsDoctorMapping = defaultBpjsDoctorMappingEntities[0];
	staffWithId.bpjsDoctorMappingId = staffWithId.bpjsDoctorMapping.id;
	let bpjsDoctorMappingWithIdBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel>;

	staffWithId.pcareDokter = defaultPcareDokterEntities[0];
	staffWithId.pcareDokterId = staffWithId.pcareDokter.id;
	let pcareDokterWithIdBehaviorSubject: BehaviorSubject<PcareDokterModel>;

	staffWithId.service = defaultServiceEntities[0];
	staffWithId.serviceId = staffWithId.service.id;
	let serviceWithIdBehaviorSubject: BehaviorSubject<ServiceModel>;

	staffWithId.administrationUser = defaultAdministrationUserEntities[0];
	staffWithId.administrationUserId = staffWithId.administrationUser.id;
	let administrationUserWithIdBehaviorSubject: BehaviorSubject<AdministrationUserModel>;

	staffWithId.cashierUser = defaultCashierUserEntities[0];
	staffWithId.cashierUserId = staffWithId.cashierUser.id;
	let cashierUserWithIdBehaviorSubject: BehaviorSubject<CashierUserModel>;

	staffWithId.claimUser = defaultClaimUserEntities[0];
	staffWithId.claimUserId = staffWithId.claimUser.id;
	let claimUserWithIdBehaviorSubject: BehaviorSubject<ClaimUserModel>;

	staffWithId.diagnosticSupportUser = defaultDiagnosticSupportUserEntities[0];
	staffWithId.diagnosticSupportUserId = staffWithId.diagnosticSupportUser.id;
	let diagnosticSupportUserWithIdBehaviorSubject: BehaviorSubject<DiagnosticSupportUserModel>;

	staffWithId.doctorUser = defaultDoctorUserEntities[0];
	staffWithId.doctorUserId = staffWithId.doctorUser.id;
	let doctorUserWithIdBehaviorSubject: BehaviorSubject<DoctorUserModel>;

	staffWithId.facilityUser = defaultFacilityUserEntities[0];
	staffWithId.facilityUserId = staffWithId.facilityUser.id;
	let facilityUserWithIdBehaviorSubject: BehaviorSubject<FacilityUserModel>;

	staffWithId.managementUser = defaultManagementUserEntities[0];
	staffWithId.managementUserId = staffWithId.managementUser.id;
	let managementUserWithIdBehaviorSubject: BehaviorSubject<ManagementUserModel>;

	staffWithId.medicalRecordUser = defaultMedicalRecordUserEntities[0];
	staffWithId.medicalRecordUserId = staffWithId.medicalRecordUser.id;
	let medicalRecordUserWithIdBehaviorSubject: BehaviorSubject<MedicalRecordUserModel>;

	staffWithId.medicalTranscriberUser = defaultMedicalTranscriberUserEntities[0];
	staffWithId.medicalTranscriberUserId = staffWithId.medicalTranscriberUser.id;
	let medicalTranscriberUserWithIdBehaviorSubject: BehaviorSubject<MedicalTranscriberUserModel>;

	staffWithId.nurseUser = defaultNurseUserEntities[0];
	staffWithId.nurseUserId = staffWithId.nurseUser.id;
	let nurseUserWithIdBehaviorSubject: BehaviorSubject<NurseUserModel>;

	staffWithId.pharmacyUser = defaultPharmacyUserEntities[0];
	staffWithId.pharmacyUserId = staffWithId.pharmacyUser.id;
	let pharmacyUserWithIdBehaviorSubject: BehaviorSubject<PharmacyUserModel>;

	staffWithId.purchasingUser = defaultPurchasingUserEntities[0];
	staffWithId.purchasingUserId = staffWithId.purchasingUser.id;
	let purchasingUserWithIdBehaviorSubject: BehaviorSubject<PurchasingUserModel>;

	staffWithId.registrationUser = defaultRegistrationUserEntities[0];
	staffWithId.registrationUserId = staffWithId.registrationUser.id;
	let registrationUserWithIdBehaviorSubject: BehaviorSubject<RegistrationUserModel>;

	staffWithId.systemAdminUser = defaultSystemAdminUserEntities[0];
	staffWithId.systemAdminUserId = staffWithId.systemAdminUser.id;
	let systemAdminUserWithIdBehaviorSubject: BehaviorSubject<SystemAdminUserModel>;

	staffWithId.warehouseUser = defaultWarehouseUserEntities[0];
	staffWithId.warehouseUserId = staffWithId.warehouseUser.id;
	let warehouseUserWithIdBehaviorSubject: BehaviorSubject<WarehouseUserModel>;

	staffWithId.accompanyingConsents = defaultInformedConsentEntities;
	staffWithId.accompanyingConsentsIds = staffWithId.accompanyingConsents.map(accompanyingConsents => accompanyingConsents.id);

	staffWithId.amendmentDetails = defaultAmendmentDetailEntities;
	staffWithId.amendmentDetailsIds = staffWithId.amendmentDetails.map(amendmentDetails => amendmentDetails.id);

	staffWithId.anesthesiaMedicalTranscriber = defaultPreoperativeRecordsEntities;
	staffWithId.anesthesiaMedicalTranscriberIds = staffWithId.anesthesiaMedicalTranscriber.map(anesthesiaMedicalTranscriber => anesthesiaMedicalTranscriber.id);

	staffWithId.anesthesiologist = defaultPreoperativeRecordsEntities;
	staffWithId.anesthesiologistIds = staffWithId.anesthesiologist.map(anesthesiologist => anesthesiologist.id);

	staffWithId.anesthesiologyNurse = defaultPreoperativeRecordsEntities;
	staffWithId.anesthesiologyNurseIds = staffWithId.anesthesiologyNurse.map(anesthesiologyNurse => anesthesiologyNurse.id);

	staffWithId.cashierStaff = defaultCashReceiptEntities;
	staffWithId.cashierStaffIds = staffWithId.cashierStaff.map(cashierStaff => cashierStaff.id);

	staffWithId.coTreatingDoctors = defaultCoTreatingDoctorEntities;
	staffWithId.coTreatingDoctorsIds = staffWithId.coTreatingDoctors.map(coTreatingDoctors => coTreatingDoctors.id);

	staffWithId.dailyCareCPPTsCreatedByStaff = defaultDailyCareCPPTEntities;
	staffWithId.dailyCareCPPTsCreatedByStaffIds = staffWithId.dailyCareCPPTsCreatedByStaff.map(dailyCareCPPTsCreatedByStaff => dailyCareCPPTsCreatedByStaff.id);

	staffWithId.dailyCareCPPTsDoctorInCharge = defaultDailyCareCPPTEntities;
	staffWithId.dailyCareCPPTsDoctorInChargeIds = staffWithId.dailyCareCPPTsDoctorInCharge.map(dailyCareCPPTsDoctorInCharge => dailyCareCPPTsDoctorInCharge.id);

	staffWithId.dailyCareCPPTsMedicalTranscriber = defaultDailyCareCPPTEntities;
	staffWithId.dailyCareCPPTsMedicalTranscriberIds = staffWithId.dailyCareCPPTsMedicalTranscriber.map(dailyCareCPPTsMedicalTranscriber => dailyCareCPPTsMedicalTranscriber.id);

	staffWithId.deliveryProgresses = defaultDeliveryProgressEntities;
	staffWithId.deliveryProgressesIds = staffWithId.deliveryProgresses.map(deliveryProgresses => deliveryProgresses.id);

	staffWithId.diagnosticStaffExaminationSummaries = defaultDiagnosticStaffExaminationSummaryEntities;
	staffWithId.diagnosticStaffExaminationSummariesIds = staffWithId.diagnosticStaffExaminationSummaries.map(diagnosticStaffExaminationSummaries => diagnosticStaffExaminationSummaries.id);

	staffWithId.dismissalReferringStaff = defaultRegistrationEntities;
	staffWithId.dismissalReferringStaffIds = staffWithId.dismissalReferringStaff.map(dismissalReferringStaff => dismissalReferringStaff.id);

	staffWithId.doctorSchedules = defaultDoctorScheduleEntities;
	staffWithId.doctorSchedulesIds = staffWithId.doctorSchedules.map(doctorSchedules => doctorSchedules.id);

	staffWithId.doctorOnExamination = defaultMedicalExaminationRecordEntities;
	staffWithId.doctorOnExaminationIds = staffWithId.doctorOnExamination.map(doctorOnExamination => doctorOnExamination.id);

	staffWithId.fluidBalanceDetails = defaultFluidBalanceDetailEntities;
	staffWithId.fluidBalanceDetailsIds = staffWithId.fluidBalanceDetails.map(fluidBalanceDetails => fluidBalanceDetails.id);

	staffWithId.hemodialysisMonitorings = defaultHemodialysisMonitoringEntities;
	staffWithId.hemodialysisMonitoringsIds = staffWithId.hemodialysisMonitorings.map(hemodialysisMonitorings => hemodialysisMonitorings.id);

	staffWithId.hospitalBranchInformations = defaultHospitalBranchInformationEntities;
	staffWithId.hospitalBranchInformationsIds = staffWithId.hospitalBranchInformations.map(hospitalBranchInformations => hospitalBranchInformations.id);

	staffWithId.informingConsents = defaultInformedConsentEntities;
	staffWithId.informingConsentsIds = staffWithId.informingConsents.map(informingConsents => informingConsents.id);

	staffWithId.invoices = defaultInvoiceEntities;
	staffWithId.invoicesIds = staffWithId.invoices.map(invoices => invoices.id);

	staffWithId.mcuPackageItems = defaultMcuPackageItemEntities;
	staffWithId.mcuPackageItemsIds = staffWithId.mcuPackageItems.map(mcuPackageItems => mcuPackageItems.id);

	staffWithId.medicalCertificateDischargeResumes = defaultMedicalCertificateDischargeResumeEntities;
	staffWithId.medicalCertificateDischargeResumesIds = staffWithId.medicalCertificateDischargeResumes.map(medicalCertificateDischargeResumes => medicalCertificateDischargeResumes.id);

	staffWithId.medicalCertificateBirths = defaultMedicalCertificateBirthEntities;
	staffWithId.medicalCertificateBirthsIds = staffWithId.medicalCertificateBirths.map(medicalCertificateBirths => medicalCertificateBirths.id);

	staffWithId.medicalCertificateHospitalizations = defaultMedicalCertificateHospitalizationEntities;
	staffWithId.medicalCertificateHospitalizationsIds = staffWithId.medicalCertificateHospitalizations.map(medicalCertificateHospitalizations => medicalCertificateHospitalizations.id);

	staffWithId.medicalExaminationRecordDischargeSummarys = defaultMedicalExaminationRecordDischargeSummaryEntities;
	staffWithId.medicalExaminationRecordDischargeSummarysIds = staffWithId.medicalExaminationRecordDischargeSummarys.map(medicalExaminationRecordDischargeSummarys => medicalExaminationRecordDischargeSummarys.id);

	staffWithId.medicalRecordTranscriber = defaultMedicalExaminationRecordEntities;
	staffWithId.medicalRecordTranscriberIds = staffWithId.medicalRecordTranscriber.map(medicalRecordTranscriber => medicalRecordTranscriber.id);

	staffWithId.medicalStaffOfMedicalAttendancesCertificate = defaultMedicalCertificateMedicalAttendanceEntities;
	staffWithId.medicalStaffOfMedicalAttendancesCertificateIds = staffWithId.medicalStaffOfMedicalAttendancesCertificate.map(medicalStaffOfMedicalAttendancesCertificate => medicalStaffOfMedicalAttendancesCertificate.id);

	staffWithId.medicalStaffOfMentalHealths = defaultMedicalCertificateMentalHealthEntities;
	staffWithId.medicalStaffOfMentalHealthsIds = staffWithId.medicalStaffOfMentalHealths.map(medicalStaffOfMentalHealths => medicalStaffOfMentalHealths.id);

	staffWithId.medicalStaffOfPhysicalHealths = defaultMedicalCertificatePhysicalHealthEntities;
	staffWithId.medicalStaffOfPhysicalHealthsIds = staffWithId.medicalStaffOfPhysicalHealths.map(medicalStaffOfPhysicalHealths => medicalStaffOfPhysicalHealths.id);

	staffWithId.medicalStaffOfRestrictedWorksCertificate = defaultMedicalCertificateRestrictedWorkEntities;
	staffWithId.medicalStaffOfRestrictedWorksCertificateIds = staffWithId.medicalStaffOfRestrictedWorksCertificate.map(medicalStaffOfRestrictedWorksCertificate => medicalStaffOfRestrictedWorksCertificate.id);

	staffWithId.medicalStaffOfSickLeavesCertificate = defaultMedicalCertificateSickLeaveEntities;
	staffWithId.medicalStaffOfSickLeavesCertificateIds = staffWithId.medicalStaffOfSickLeavesCertificate.map(medicalStaffOfSickLeavesCertificate => medicalStaffOfSickLeavesCertificate.id);

	staffWithId.medicationAdministeredHisotries = defaultMedicationAdministeredHistoryEntities;
	staffWithId.medicationAdministeredHisotriesIds = staffWithId.medicationAdministeredHisotries.map(medicationAdministeredHisotries => medicationAdministeredHisotries.id);

	staffWithId.medicationHeaders = defaultMedicationHeaderEntities;
	staffWithId.medicationHeadersIds = staffWithId.medicationHeaders.map(medicationHeaders => medicationHeaders.id);

	staffWithId.midwives = defaultDeliveryMedicalExaminationRecordEntities;
	staffWithId.midwivesIds = staffWithId.midwives.map(midwives => midwives.id);

	staffWithId.nurse = defaultMedicalExaminationRecordEntities;
	staffWithId.nurseIds = staffWithId.nurse.map(nurse => nurse.id);

	staffWithId.nursingDetailSurgicalNursing = defaultOperatingTheaterMedicalExaminationRecordEntities;
	staffWithId.nursingDetailSurgicalNursingIds = staffWithId.nursingDetailSurgicalNursing.map(nursingDetailSurgicalNursing => nursingDetailSurgicalNursing.id);

	staffWithId.nursingDetailsAnesthesiaNursing = defaultOperatingTheaterMedicalExaminationRecordEntities;
	staffWithId.nursingDetailsAnesthesiaNursingIds = staffWithId.nursingDetailsAnesthesiaNursing.map(nursingDetailsAnesthesiaNursing => nursingDetailsAnesthesiaNursing.id);

	staffWithId.patientConsents = defaultPatientConsentEntities;
	staffWithId.patientConsentsIds = staffWithId.patientConsents.map(patientConsents => patientConsents.id);

	staffWithId.patientVitalInformations = defaultPatientVitalInformationEntities;
	staffWithId.patientVitalInformationsIds = staffWithId.patientVitalInformations.map(patientVitalInformations => patientVitalInformations.id);

	staffWithId.pediatricianInCharge = defaultNewbornDetailEntities;
	staffWithId.pediatricianInChargeIds = staffWithId.pediatricianInCharge.map(pediatricianInCharge => pediatricianInCharge.id);

	staffWithId.prescriptionHeaders = defaultPrescriptionHeaderEntities;
	staffWithId.prescriptionHeadersIds = staffWithId.prescriptionHeaders.map(prescriptionHeaders => prescriptionHeaders.id);

	staffWithId.processWorkflowLogs = defaultProcessWorkflowEntities;
	staffWithId.processWorkflowLogsIds = staffWithId.processWorkflowLogs.map(processWorkflowLogs => processWorkflowLogs.id);

	staffWithId.registrations = defaultRegistrationEntities;
	staffWithId.registrationsIds = staffWithId.registrations.map(registrations => registrations.id);

	staffWithId.requestedBy = defaultRegistrationEntities;
	staffWithId.requestedByIds = staffWithId.requestedBy.map(requestedBy => requestedBy.id);

	staffWithId.roomTransfers = defaultRoomTransferEntities;
	staffWithId.roomTransfersIds = staffWithId.roomTransfers.map(roomTransfers => roomTransfers.id);

	staffWithId.sampleCollectionStaffs = defaultSampleCollectionItemsEntities;
	staffWithId.sampleCollectionStaffsIds = staffWithId.sampleCollectionStaffs.map(sampleCollectionStaffs => sampleCollectionStaffs.id);

	staffWithId.sampleDeliveryStaffs = defaultSampleCollectionItemsEntities;
	staffWithId.sampleDeliveryStaffsIds = staffWithId.sampleDeliveryStaffs.map(sampleDeliveryStaffs => sampleDeliveryStaffs.id);

	staffWithId.sampleProcessingStaffs = defaultSampleCollectionItemsEntities;
	staffWithId.sampleProcessingStaffsIds = staffWithId.sampleProcessingStaffs.map(sampleProcessingStaffs => sampleProcessingStaffs.id);

	staffWithId.surgeon = defaultPreoperativeRecordsEntities;
	staffWithId.surgeonIds = staffWithId.surgeon.map(surgeon => surgeon.id);

	staffWithId.surgicalMedicalTranscriber = defaultPreoperativeRecordsEntities;
	staffWithId.surgicalMedicalTranscriberIds = staffWithId.surgicalMedicalTranscriber.map(surgicalMedicalTranscriber => surgicalMedicalTranscriber.id);

	staffWithId.surgicalNurse = defaultPreoperativeRecordsEntities;
	staffWithId.surgicalNurseIds = staffWithId.surgicalNurse.map(surgicalNurse => surgicalNurse.id);

	staffWithId.transferOrderStockDetails = defaultTransferOrderStockDetailEntities;
	staffWithId.transferOrderStockDetailsIds = staffWithId.transferOrderStockDetails.map(transferOrderStockDetails => transferOrderStockDetails.id);

	staffWithId.vaccinationOrders = defaultVaccinationOrderEntities;
	staffWithId.vaccinationOrdersIds = staffWithId.vaccinationOrders.map(vaccinationOrders => vaccinationOrders.id);

	staffWithId.services = defaultServiceEntities;
	staffWithId.servicesIds = staffWithId.services.map(services => services.id);


	const routerState: RouterState = {
		url: 'staff-crud',
		urls: ['staff-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: StaffModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		staffModelState = initialStaffModelState;
		store.setState({model: staffModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		staffCountBehaviorSubject = new BehaviorSubject(defaultStaffCount);

		// selectors for all references
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		administrationUserModelsBehaviorSubject = new BehaviorSubject(defaultAdministrationUserEntities);
		administratorModelsBehaviorSubject = new BehaviorSubject(defaultAdministratorEntities);
		amendmentDetailModelsBehaviorSubject = new BehaviorSubject(defaultAmendmentDetailEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsControlPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsControlPlanEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsHospitalizationPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHospitalizationPlanEntities);
		bpjsPRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBEntities);
		bpjsPRBDetailModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBDetailEntities);
		bpjsPcarePoliModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcarePoliEntities);
		bpjsPcareRegistrationsModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareRegistrationsEntities);
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		bedFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBedFacilityEntities);
		bedReserveModelsBehaviorSubject = new BehaviorSubject(defaultBedReserveEntities);
		birthHistoryModelsBehaviorSubject = new BehaviorSubject(defaultBirthHistoryEntities);
		bodyChartExaminationModelsBehaviorSubject = new BehaviorSubject(defaultBodyChartExaminationEntities);
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
		diagnosticExaminationResultsModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticExaminationResultsEntities);
		diagnosticStaffExaminationSummaryModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticStaffExaminationSummaryEntities);
		diagnosticSupportUserModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticSupportUserEntities);
		doctorScheduleModelsBehaviorSubject = new BehaviorSubject(defaultDoctorScheduleEntities);
		doctorUserModelsBehaviorSubject = new BehaviorSubject(defaultDoctorUserEntities);
		entExaminationModelsBehaviorSubject = new BehaviorSubject(defaultEntExaminationEntities);
		emergencyMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultEmergencyMedicalExaminationRecordEntities);
		examinationGroupModelsBehaviorSubject = new BehaviorSubject(defaultExaminationGroupEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		facilityUserModelsBehaviorSubject = new BehaviorSubject(defaultFacilityUserEntities);
		fluidBalanceDetailModelsBehaviorSubject = new BehaviorSubject(defaultFluidBalanceDetailEntities);
		formulirKonselingTesHivModelsBehaviorSubject = new BehaviorSubject(defaultFormulirKonselingTesHivEntities);
		healthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultHealthFacilityEntities);
		hemodialysisExaminationModelsBehaviorSubject = new BehaviorSubject(defaultHemodialysisExaminationEntities);
		hemodialysisMonitoringModelsBehaviorSubject = new BehaviorSubject(defaultHemodialysisMonitoringEntities);
		hospitalBranchInformationModelsBehaviorSubject = new BehaviorSubject(defaultHospitalBranchInformationEntities);
		hospitalGroupInformationModelsBehaviorSubject = new BehaviorSubject(defaultHospitalGroupInformationEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		inpatientMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultInpatientMedicalExaminationRecordEntities);
		intraoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultIntraoperativeRecordsEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		invoicePaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentInsuranceEntities);
		invoicePaymentOtherModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentOtherEntities);
		invoicePaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentSelfPayingEntities);
		invoiceSummaryModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceSummaryEntities);
		mcuPackageModelsBehaviorSubject = new BehaviorSubject(defaultMcuPackageEntities);
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
		medicalRecordInitialChecklistModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordInitialChecklistEntities);
		medicalRecordNextVerificationChecklistModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordNextVerificationChecklistEntities);
		medicalRecordUserModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordUserEntities);
		medicalTranscriberUserModelsBehaviorSubject = new BehaviorSubject(defaultMedicalTranscriberUserEntities);
		medicationAdministeredHistoryModelsBehaviorSubject = new BehaviorSubject(defaultMedicationAdministeredHistoryEntities);
		medicationCompoundModelsBehaviorSubject = new BehaviorSubject(defaultMedicationCompoundEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		medicationItemModelsBehaviorSubject = new BehaviorSubject(defaultMedicationItemEntities);
		merchantModelsBehaviorSubject = new BehaviorSubject(defaultMerchantEntities);
		newbornDetailModelsBehaviorSubject = new BehaviorSubject(defaultNewbornDetailEntities);
		nurseUserModelsBehaviorSubject = new BehaviorSubject(defaultNurseUserEntities);
		nurseVitalSignMeasurementModelsBehaviorSubject = new BehaviorSubject(defaultNurseVitalSignMeasurementEntities);
		obstetricAndGynecologyHistoryModelsBehaviorSubject = new BehaviorSubject(defaultObstetricAndGynecologyHistoryEntities);
		odontogramExaminationModelsBehaviorSubject = new BehaviorSubject(defaultOdontogramExaminationEntities);
		operatingTheaterMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultOperatingTheaterMedicalExaminationRecordEntities);
		ophthalmologyExaminationModelsBehaviorSubject = new BehaviorSubject(defaultOphthalmologyExaminationEntities);
		pcareDokterModelsBehaviorSubject = new BehaviorSubject(defaultPcareDokterEntities);
		pcareExaminationModelsBehaviorSubject = new BehaviorSubject(defaultPcareExaminationEntities);
		patientConsentModelsBehaviorSubject = new BehaviorSubject(defaultPatientConsentEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
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
		sepModelsBehaviorSubject = new BehaviorSubject(defaultSepEntities);
		sampleCollectionInformationModelsBehaviorSubject = new BehaviorSubject(defaultSampleCollectionInformationEntities);
		sampleCollectionItemsModelsBehaviorSubject = new BehaviorSubject(defaultSampleCollectionItemsEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		serviceFacilityCategoryModelsBehaviorSubject = new BehaviorSubject(defaultServiceFacilityCategoryEntities);
		serviceItemModelsBehaviorSubject = new BehaviorSubject(defaultServiceItemEntities);
		stockCatalogueModelsBehaviorSubject = new BehaviorSubject(defaultStockCatalogueEntities);
		systemAdminUserModelsBehaviorSubject = new BehaviorSubject(defaultSystemAdminUserEntities);
		tariffSchemaModelsBehaviorSubject = new BehaviorSubject(defaultTariffSchemaEntities);
		transferOrderModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderEntities);
		transferOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderStockDetailEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);
		vaccinationOrderDetailModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderDetailEntities);
		vitalSignsModelsBehaviorSubject = new BehaviorSubject(defaultVitalSignsEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);
		warehouseUserModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseUserEntities);

		// selectors for target entity and its related entity
		staffModelWithIdBehaviorSubject = new BehaviorSubject(staffWithId);
		administratorWithIdBehaviorSubject = new BehaviorSubject(staffWithId.administrator);
		bpjsDoctorMappingWithIdBehaviorSubject = new BehaviorSubject(staffWithId.bpjsDoctorMapping);
		pcareDokterWithIdBehaviorSubject = new BehaviorSubject(staffWithId.pcareDokter);
		serviceWithIdBehaviorSubject = new BehaviorSubject(staffWithId.service);
		administrationUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.administrationUser);
		cashierUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.cashierUser);
		claimUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.claimUser);
		diagnosticSupportUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.diagnosticSupportUser);
		doctorUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.doctorUser);
		facilityUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.facilityUser);
		managementUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.managementUser);
		medicalRecordUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.medicalRecordUser);
		medicalTranscriberUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.medicalTranscriberUser);
		nurseUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.nurseUser);
		pharmacyUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.pharmacyUser);
		purchasingUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.purchasingUser);
		registrationUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.registrationUser);
		systemAdminUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.systemAdminUser);
		warehouseUserWithIdBehaviorSubject = new BehaviorSubject(staffWithId.warehouseUser);

		spyOn(store, 'select')
			.withArgs(getCountStaffModels).and.returnValue(staffCountBehaviorSubject)
			.withArgs(getStaffModelWithId, staffWithId.id).and.returnValue(staffModelWithIdBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getAdministrationUserCollectionModels, jasmine.any(String)).and.returnValue(administrationUserModelsBehaviorSubject)
			.withArgs(getAdministratorCollectionModels, jasmine.any(String)).and.returnValue(administratorModelsBehaviorSubject)
			.withArgs(getAmendmentDetailCollectionModels, jasmine.any(String)).and.returnValue(amendmentDetailModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsControlPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsControlPlanModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsHospitalizationPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsHospitalizationPlanModelsBehaviorSubject)
			.withArgs(getBpjsPRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBModelsBehaviorSubject)
			.withArgs(getBpjsPRBDetailCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBDetailModelsBehaviorSubject)
			.withArgs(getBpjsPcarePoliCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcarePoliModelsBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareRegistrationsModelsBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getBedFacilityCollectionModels, jasmine.any(String)).and.returnValue(bedFacilityModelsBehaviorSubject)
			.withArgs(getBedReserveCollectionModels, jasmine.any(String)).and.returnValue(bedReserveModelsBehaviorSubject)
			.withArgs(getBirthHistoryCollectionModels, jasmine.any(String)).and.returnValue(birthHistoryModelsBehaviorSubject)
			.withArgs(getBodyChartExaminationCollectionModels, jasmine.any(String)).and.returnValue(bodyChartExaminationModelsBehaviorSubject)
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
			.withArgs(getDiagnosticExaminationResultsCollectionModels, jasmine.any(String)).and.returnValue(diagnosticExaminationResultsModelsBehaviorSubject)
			.withArgs(getDiagnosticStaffExaminationSummaryCollectionModels, jasmine.any(String)).and.returnValue(diagnosticStaffExaminationSummaryModelsBehaviorSubject)
			.withArgs(getDiagnosticSupportUserCollectionModels, jasmine.any(String)).and.returnValue(diagnosticSupportUserModelsBehaviorSubject)
			.withArgs(getDoctorScheduleCollectionModels, jasmine.any(String)).and.returnValue(doctorScheduleModelsBehaviorSubject)
			.withArgs(getDoctorUserCollectionModels, jasmine.any(String)).and.returnValue(doctorUserModelsBehaviorSubject)
			.withArgs(getEntExaminationCollectionModels, jasmine.any(String)).and.returnValue(entExaminationModelsBehaviorSubject)
			.withArgs(getEmergencyMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(emergencyMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getExaminationGroupCollectionModels, jasmine.any(String)).and.returnValue(examinationGroupModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getFacilityUserCollectionModels, jasmine.any(String)).and.returnValue(facilityUserModelsBehaviorSubject)
			.withArgs(getFluidBalanceDetailCollectionModels, jasmine.any(String)).and.returnValue(fluidBalanceDetailModelsBehaviorSubject)
			.withArgs(getFormulirKonselingTesHivCollectionModels, jasmine.any(String)).and.returnValue(formulirKonselingTesHivModelsBehaviorSubject)
			.withArgs(getHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(healthFacilityModelsBehaviorSubject)
			.withArgs(getHemodialysisExaminationCollectionModels, jasmine.any(String)).and.returnValue(hemodialysisExaminationModelsBehaviorSubject)
			.withArgs(getHemodialysisMonitoringCollectionModels, jasmine.any(String)).and.returnValue(hemodialysisMonitoringModelsBehaviorSubject)
			.withArgs(getHospitalBranchInformationCollectionModels, jasmine.any(String)).and.returnValue(hospitalBranchInformationModelsBehaviorSubject)
			.withArgs(getHospitalGroupInformationCollectionModels, jasmine.any(String)).and.returnValue(hospitalGroupInformationModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInpatientMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(inpatientMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getIntraoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(intraoperativeRecordsModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getInvoicePaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentInsuranceModelsBehaviorSubject)
			.withArgs(getInvoicePaymentOtherCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentOtherModelsBehaviorSubject)
			.withArgs(getInvoicePaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getInvoiceSummaryCollectionModels, jasmine.any(String)).and.returnValue(invoiceSummaryModelsBehaviorSubject)
			.withArgs(getMcuPackageCollectionModels, jasmine.any(String)).and.returnValue(mcuPackageModelsBehaviorSubject)
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
			.withArgs(getMedicalRecordInitialChecklistCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordInitialChecklistModelsBehaviorSubject)
			.withArgs(getMedicalRecordNextVerificationChecklistCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordNextVerificationChecklistModelsBehaviorSubject)
			.withArgs(getMedicalRecordUserCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordUserModelsBehaviorSubject)
			.withArgs(getMedicalTranscriberUserCollectionModels, jasmine.any(String)).and.returnValue(medicalTranscriberUserModelsBehaviorSubject)
			.withArgs(getMedicationAdministeredHistoryCollectionModels, jasmine.any(String)).and.returnValue(medicationAdministeredHistoryModelsBehaviorSubject)
			.withArgs(getMedicationCompoundCollectionModels, jasmine.any(String)).and.returnValue(medicationCompoundModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getMedicationItemCollectionModels, jasmine.any(String)).and.returnValue(medicationItemModelsBehaviorSubject)
			.withArgs(getMerchantCollectionModels, jasmine.any(String)).and.returnValue(merchantModelsBehaviorSubject)
			.withArgs(getNewbornDetailCollectionModels, jasmine.any(String)).and.returnValue(newbornDetailModelsBehaviorSubject)
			.withArgs(getNurseUserCollectionModels, jasmine.any(String)).and.returnValue(nurseUserModelsBehaviorSubject)
			.withArgs(getNurseVitalSignMeasurementCollectionModels, jasmine.any(String)).and.returnValue(nurseVitalSignMeasurementModelsBehaviorSubject)
			.withArgs(getObstetricAndGynecologyHistoryCollectionModels, jasmine.any(String)).and.returnValue(obstetricAndGynecologyHistoryModelsBehaviorSubject)
			.withArgs(getOdontogramExaminationCollectionModels, jasmine.any(String)).and.returnValue(odontogramExaminationModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(operatingTheaterMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getOphthalmologyExaminationCollectionModels, jasmine.any(String)).and.returnValue(ophthalmologyExaminationModelsBehaviorSubject)
			.withArgs(getPcareDokterCollectionModels, jasmine.any(String)).and.returnValue(pcareDokterModelsBehaviorSubject)
			.withArgs(getPcareExaminationCollectionModels, jasmine.any(String)).and.returnValue(pcareExaminationModelsBehaviorSubject)
			.withArgs(getPatientConsentCollectionModels, jasmine.any(String)).and.returnValue(patientConsentModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
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
			.withArgs(getSepCollectionModels, jasmine.any(String)).and.returnValue(sepModelsBehaviorSubject)
			.withArgs(getSampleCollectionInformationCollectionModels, jasmine.any(String)).and.returnValue(sampleCollectionInformationModelsBehaviorSubject)
			.withArgs(getSampleCollectionItemsCollectionModels, jasmine.any(String)).and.returnValue(sampleCollectionItemsModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getServiceFacilityCategoryCollectionModels, jasmine.any(String)).and.returnValue(serviceFacilityCategoryModelsBehaviorSubject)
			.withArgs(getServiceItemCollectionModels, jasmine.any(String)).and.returnValue(serviceItemModelsBehaviorSubject)
			.withArgs(getStockCatalogueCollectionModels, jasmine.any(String)).and.returnValue(stockCatalogueModelsBehaviorSubject)
			.withArgs(getSystemAdminUserCollectionModels, jasmine.any(String)).and.returnValue(systemAdminUserModelsBehaviorSubject)
			.withArgs(getTariffSchemaCollectionModels, jasmine.any(String)).and.returnValue(tariffSchemaModelsBehaviorSubject)
			.withArgs(getTransferOrderCollectionModels, jasmine.any(String)).and.returnValue(transferOrderModelsBehaviorSubject)
			.withArgs(getTransferOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(transferOrderStockDetailModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getVaccinationOrderDetailCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderDetailModelsBehaviorSubject)
			.withArgs(getVitalSignsCollectionModels, jasmine.any(String)).and.returnValue(vitalSignsModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getWarehouseUserCollectionModels, jasmine.any(String)).and.returnValue(warehouseUserModelsBehaviorSubject)
			.withArgs(getAdministratorModelWithId, staffWithId.administratorId).and.returnValue(administratorWithIdBehaviorSubject)
			.withArgs(getBpjsDoctorMappingModelWithId, staffWithId.bpjsDoctorMappingId).and.returnValue(bpjsDoctorMappingWithIdBehaviorSubject)
			.withArgs(getPcareDokterModelWithId, staffWithId.pcareDokterId).and.returnValue(pcareDokterWithIdBehaviorSubject)
			.withArgs(getServiceModelWithId, staffWithId.serviceId).and.returnValue(serviceWithIdBehaviorSubject)
			.withArgs(getAdministrationUserModelWithId, staffWithId.administrationUserId).and.returnValue(administrationUserWithIdBehaviorSubject)
			.withArgs(getCashierUserModelWithId, staffWithId.cashierUserId).and.returnValue(cashierUserWithIdBehaviorSubject)
			.withArgs(getClaimUserModelWithId, staffWithId.claimUserId).and.returnValue(claimUserWithIdBehaviorSubject)
			.withArgs(getDiagnosticSupportUserModelWithId, staffWithId.diagnosticSupportUserId).and.returnValue(diagnosticSupportUserWithIdBehaviorSubject)
			.withArgs(getDoctorUserModelWithId, staffWithId.doctorUserId).and.returnValue(doctorUserWithIdBehaviorSubject)
			.withArgs(getFacilityUserModelWithId, staffWithId.facilityUserId).and.returnValue(facilityUserWithIdBehaviorSubject)
			.withArgs(getManagementUserModelWithId, staffWithId.managementUserId).and.returnValue(managementUserWithIdBehaviorSubject)
			.withArgs(getMedicalRecordUserModelWithId, staffWithId.medicalRecordUserId).and.returnValue(medicalRecordUserWithIdBehaviorSubject)
			.withArgs(getMedicalTranscriberUserModelWithId, staffWithId.medicalTranscriberUserId).and.returnValue(medicalTranscriberUserWithIdBehaviorSubject)
			.withArgs(getNurseUserModelWithId, staffWithId.nurseUserId).and.returnValue(nurseUserWithIdBehaviorSubject)
			.withArgs(getPharmacyUserModelWithId, staffWithId.pharmacyUserId).and.returnValue(pharmacyUserWithIdBehaviorSubject)
			.withArgs(getPurchasingUserModelWithId, staffWithId.purchasingUserId).and.returnValue(purchasingUserWithIdBehaviorSubject)
			.withArgs(getRegistrationUserModelWithId, staffWithId.registrationUserId).and.returnValue(registrationUserWithIdBehaviorSubject)
			.withArgs(getSystemAdminUserModelWithId, staffWithId.systemAdminUserId).and.returnValue(systemAdminUserWithIdBehaviorSubject)
			.withArgs(getWarehouseUserModelWithId, staffWithId.warehouseUserId).and.returnValue(warehouseUserWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				StaffCrudModule,
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

			fixture = TestBed.createComponent(StaffCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new StaffModel();
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
	it ('Renders the Staff CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Administrator relation.
	*
	* The button should only exist if administratorMultiCrudActive is true
	*/
	it ('Renders Administrator Add Entity button in create mode', fakeAsync(() => {
		const administratorButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.administratorDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!administratorButton).toEqual(component.administratorMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Administrator', fakeAsync(() => {
		const administratorButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.administratorDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!administratorButton).toEqual(component.administratorMultiCrudActive);

		if (component.administratorMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAdministratorRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administratorDisplayName + ' from Model')).length;

			administratorButton.nativeElement.click();
			fixture.detectChanges();

			const actualAdministratorRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administratorDisplayName + ' from Model')).length;

			expect(actualAdministratorRemoveButtonCount).toEqual(initialAdministratorRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Administrator button', () => {
		const administratorButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.administratorDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!administratorButton).toEqual(component.administratorMultiCrudActive);

		if (component.administratorMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			administratorButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAdministratorRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administratorDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAdministratorRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAdministratorRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administratorDisplayName + ' from Model'));

			expect(actualAdministratorRemoveButtons.length).toEqual(initialAdministratorRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Administrator button when one has already been added', () => {

		const administratorButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.administratorDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!administratorButton).toEqual(component.administratorMultiCrudActive);

		if (component.administratorMultiCrudActive) {
			administratorButton.nativeElement.click();
			fixture.detectChanges();

			const updatedadministratorButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.administratorDisplayName + ' to Model'));

			expect(updatedadministratorButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Administrator entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.administratorMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const administratorRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administratorDisplayName + ' from Model')).length;

			expect(administratorRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Doctor Mapping relation.
	*
	* The button should only exist if bpjsDoctorMappingMultiCrudActive is true
	*/
	it ('Renders BPJS Doctor Mapping Add Entity button in create mode', fakeAsync(() => {
		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Doctor Mapping', fakeAsync(() => {
		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);

		if (component.bpjsDoctorMappingMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDoctorMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model')).length;

			bpjsDoctorMappingButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDoctorMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model')).length;

			expect(actualBpjsDoctorMappingRemoveButtonCount).toEqual(initialBpjsDoctorMappingRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Doctor Mapping button', () => {
		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);

		if (component.bpjsDoctorMappingMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDoctorMappingButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDoctorMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDoctorMappingRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDoctorMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model'));

			expect(actualBpjsDoctorMappingRemoveButtons.length).toEqual(initialBpjsDoctorMappingRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Doctor Mapping button when one has already been added', () => {

		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);

		if (component.bpjsDoctorMappingMultiCrudActive) {
			bpjsDoctorMappingButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDoctorMappingButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

			expect(updatedbpjsDoctorMappingButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Doctor Mapping entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDoctorMappingMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDoctorMappingRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model')).length;

			expect(bpjsDoctorMappingRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the PCare Dokter relation.
	*
	* The button should only exist if pcareDokterMultiCrudActive is true
	*/
	it ('Renders PCare Dokter Add Entity button in create mode', fakeAsync(() => {
		const pcareDokterButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareDokterDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!pcareDokterButton).toEqual(component.pcareDokterMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new PCare Dokter', fakeAsync(() => {
		const pcareDokterButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareDokterDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pcareDokterButton).toEqual(component.pcareDokterMultiCrudActive);

		if (component.pcareDokterMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPcareDokterRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareDokterDisplayName + ' from Model')).length;

			pcareDokterButton.nativeElement.click();
			fixture.detectChanges();

			const actualPcareDokterRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareDokterDisplayName + ' from Model')).length;

			expect(actualPcareDokterRemoveButtonCount).toEqual(initialPcareDokterRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove PCare Dokter button', () => {
		const pcareDokterButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareDokterDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pcareDokterButton).toEqual(component.pcareDokterMultiCrudActive);

		if (component.pcareDokterMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			pcareDokterButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPcareDokterRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareDokterDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPcareDokterRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPcareDokterRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareDokterDisplayName + ' from Model'));

			expect(actualPcareDokterRemoveButtons.length).toEqual(initialPcareDokterRemoveButtons.length - 1);
		}
	});

	it ('should disable the add PCare Dokter button when one has already been added', () => {

		const pcareDokterButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareDokterDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pcareDokterButton).toEqual(component.pcareDokterMultiCrudActive);

		if (component.pcareDokterMultiCrudActive) {
			pcareDokterButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpcareDokterButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareDokterDisplayName + ' to Model'));

			expect(updatedpcareDokterButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related PCare Dokter entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.pcareDokterMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const pcareDokterRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareDokterDisplayName + ' from Model')).length;

			expect(pcareDokterRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Service relation.
	*
	* The button should only exist if serviceMultiCrudActive is true
	*/
	it ('Renders Service Add Entity button in create mode', fakeAsync(() => {
		const serviceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!serviceButton).toEqual(component.serviceMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Service', fakeAsync(() => {
		const serviceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceButton).toEqual(component.serviceMultiCrudActive);

		if (component.serviceMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialServiceRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model')).length;

			serviceButton.nativeElement.click();
			fixture.detectChanges();

			const actualServiceRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model')).length;

			expect(actualServiceRemoveButtonCount).toEqual(initialServiceRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Service button', () => {
		const serviceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceButton).toEqual(component.serviceMultiCrudActive);

		if (component.serviceMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			serviceButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialServiceRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialServiceRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualServiceRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model'));

			expect(actualServiceRemoveButtons.length).toEqual(initialServiceRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Service button when one has already been added', () => {

		const serviceButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceButton).toEqual(component.serviceMultiCrudActive);

		if (component.serviceMultiCrudActive) {
			serviceButton.nativeElement.click();
			fixture.detectChanges();

			const updatedserviceButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

			expect(updatedserviceButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Service entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.serviceMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const serviceRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model')).length;

			expect(serviceRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Administration User relation.
	*
	* The button should only exist if administrationUserMultiCrudActive is true
	*/
	it ('Renders Administration User Add Entity button in create mode', fakeAsync(() => {
		const administrationUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.administrationUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!administrationUserButton).toEqual(component.administrationUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Administration User', fakeAsync(() => {
		const administrationUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.administrationUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!administrationUserButton).toEqual(component.administrationUserMultiCrudActive);

		if (component.administrationUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAdministrationUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administrationUserDisplayName + ' from Model')).length;

			administrationUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualAdministrationUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administrationUserDisplayName + ' from Model')).length;

			expect(actualAdministrationUserRemoveButtonCount).toEqual(initialAdministrationUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Administration User button', () => {
		const administrationUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.administrationUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!administrationUserButton).toEqual(component.administrationUserMultiCrudActive);

		if (component.administrationUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			administrationUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAdministrationUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administrationUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAdministrationUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAdministrationUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administrationUserDisplayName + ' from Model'));

			expect(actualAdministrationUserRemoveButtons.length).toEqual(initialAdministrationUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Administration User button when one has already been added', () => {

		const administrationUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.administrationUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!administrationUserButton).toEqual(component.administrationUserMultiCrudActive);

		if (component.administrationUserMultiCrudActive) {
			administrationUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedadministrationUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.administrationUserDisplayName + ' to Model'));

			expect(updatedadministrationUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Administration User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.administrationUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const administrationUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.administrationUserDisplayName + ' from Model')).length;

			expect(administrationUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Cashier User relation.
	*
	* The button should only exist if cashierUserMultiCrudActive is true
	*/
	it ('Renders Cashier User Add Entity button in create mode', fakeAsync(() => {
		const cashierUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!cashierUserButton).toEqual(component.cashierUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Cashier User', fakeAsync(() => {
		const cashierUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashierUserButton).toEqual(component.cashierUserMultiCrudActive);

		if (component.cashierUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCashierUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierUserDisplayName + ' from Model')).length;

			cashierUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualCashierUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierUserDisplayName + ' from Model')).length;

			expect(actualCashierUserRemoveButtonCount).toEqual(initialCashierUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Cashier User button', () => {
		const cashierUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashierUserButton).toEqual(component.cashierUserMultiCrudActive);

		if (component.cashierUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			cashierUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCashierUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCashierUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCashierUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierUserDisplayName + ' from Model'));

			expect(actualCashierUserRemoveButtons.length).toEqual(initialCashierUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Cashier User button when one has already been added', () => {

		const cashierUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashierUserButton).toEqual(component.cashierUserMultiCrudActive);

		if (component.cashierUserMultiCrudActive) {
			cashierUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcashierUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierUserDisplayName + ' to Model'));

			expect(updatedcashierUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Cashier User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.cashierUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const cashierUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierUserDisplayName + ' from Model')).length;

			expect(cashierUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Claim User relation.
	*
	* The button should only exist if claimUserMultiCrudActive is true
	*/
	it ('Renders Claim User Add Entity button in create mode', fakeAsync(() => {
		const claimUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.claimUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!claimUserButton).toEqual(component.claimUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Claim User', fakeAsync(() => {
		const claimUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.claimUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!claimUserButton).toEqual(component.claimUserMultiCrudActive);

		if (component.claimUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialClaimUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.claimUserDisplayName + ' from Model')).length;

			claimUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualClaimUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.claimUserDisplayName + ' from Model')).length;

			expect(actualClaimUserRemoveButtonCount).toEqual(initialClaimUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Claim User button', () => {
		const claimUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.claimUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!claimUserButton).toEqual(component.claimUserMultiCrudActive);

		if (component.claimUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			claimUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialClaimUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.claimUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialClaimUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualClaimUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.claimUserDisplayName + ' from Model'));

			expect(actualClaimUserRemoveButtons.length).toEqual(initialClaimUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Claim User button when one has already been added', () => {

		const claimUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.claimUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!claimUserButton).toEqual(component.claimUserMultiCrudActive);

		if (component.claimUserMultiCrudActive) {
			claimUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedclaimUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.claimUserDisplayName + ' to Model'));

			expect(updatedclaimUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Claim User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.claimUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const claimUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.claimUserDisplayName + ' from Model')).length;

			expect(claimUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Diagnostic Support User relation.
	*
	* The button should only exist if diagnosticSupportUserMultiCrudActive is true
	*/
	it ('Renders Diagnostic Support User Add Entity button in create mode', fakeAsync(() => {
		const diagnosticSupportUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticSupportUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!diagnosticSupportUserButton).toEqual(component.diagnosticSupportUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Diagnostic Support User', fakeAsync(() => {
		const diagnosticSupportUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticSupportUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticSupportUserButton).toEqual(component.diagnosticSupportUserMultiCrudActive);

		if (component.diagnosticSupportUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDiagnosticSupportUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticSupportUserDisplayName + ' from Model')).length;

			diagnosticSupportUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosticSupportUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticSupportUserDisplayName + ' from Model')).length;

			expect(actualDiagnosticSupportUserRemoveButtonCount).toEqual(initialDiagnosticSupportUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Diagnostic Support User button', () => {
		const diagnosticSupportUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticSupportUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticSupportUserButton).toEqual(component.diagnosticSupportUserMultiCrudActive);

		if (component.diagnosticSupportUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			diagnosticSupportUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDiagnosticSupportUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticSupportUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDiagnosticSupportUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosticSupportUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticSupportUserDisplayName + ' from Model'));

			expect(actualDiagnosticSupportUserRemoveButtons.length).toEqual(initialDiagnosticSupportUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Diagnostic Support User button when one has already been added', () => {

		const diagnosticSupportUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticSupportUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticSupportUserButton).toEqual(component.diagnosticSupportUserMultiCrudActive);

		if (component.diagnosticSupportUserMultiCrudActive) {
			diagnosticSupportUserButton.nativeElement.click();
			fixture.detectChanges();

			const updateddiagnosticSupportUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticSupportUserDisplayName + ' to Model'));

			expect(updateddiagnosticSupportUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Diagnostic Support User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.diagnosticSupportUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const diagnosticSupportUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticSupportUserDisplayName + ' from Model')).length;

			expect(diagnosticSupportUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Doctor User relation.
	*
	* The button should only exist if doctorUserMultiCrudActive is true
	*/
	it ('Renders Doctor User Add Entity button in create mode', fakeAsync(() => {
		const doctorUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!doctorUserButton).toEqual(component.doctorUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Doctor User', fakeAsync(() => {
		const doctorUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!doctorUserButton).toEqual(component.doctorUserMultiCrudActive);

		if (component.doctorUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDoctorUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorUserDisplayName + ' from Model')).length;

			doctorUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualDoctorUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorUserDisplayName + ' from Model')).length;

			expect(actualDoctorUserRemoveButtonCount).toEqual(initialDoctorUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Doctor User button', () => {
		const doctorUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!doctorUserButton).toEqual(component.doctorUserMultiCrudActive);

		if (component.doctorUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			doctorUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDoctorUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDoctorUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDoctorUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorUserDisplayName + ' from Model'));

			expect(actualDoctorUserRemoveButtons.length).toEqual(initialDoctorUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Doctor User button when one has already been added', () => {

		const doctorUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!doctorUserButton).toEqual(component.doctorUserMultiCrudActive);

		if (component.doctorUserMultiCrudActive) {
			doctorUserButton.nativeElement.click();
			fixture.detectChanges();

			const updateddoctorUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorUserDisplayName + ' to Model'));

			expect(updateddoctorUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Doctor User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.doctorUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const doctorUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorUserDisplayName + ' from Model')).length;

			expect(doctorUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Facility User relation.
	*
	* The button should only exist if facilityUserMultiCrudActive is true
	*/
	it ('Renders Facility User Add Entity button in create mode', fakeAsync(() => {
		const facilityUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.facilityUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!facilityUserButton).toEqual(component.facilityUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Facility User', fakeAsync(() => {
		const facilityUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.facilityUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!facilityUserButton).toEqual(component.facilityUserMultiCrudActive);

		if (component.facilityUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialFacilityUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.facilityUserDisplayName + ' from Model')).length;

			facilityUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualFacilityUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.facilityUserDisplayName + ' from Model')).length;

			expect(actualFacilityUserRemoveButtonCount).toEqual(initialFacilityUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Facility User button', () => {
		const facilityUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.facilityUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!facilityUserButton).toEqual(component.facilityUserMultiCrudActive);

		if (component.facilityUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			facilityUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialFacilityUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.facilityUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialFacilityUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualFacilityUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.facilityUserDisplayName + ' from Model'));

			expect(actualFacilityUserRemoveButtons.length).toEqual(initialFacilityUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Facility User button when one has already been added', () => {

		const facilityUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.facilityUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!facilityUserButton).toEqual(component.facilityUserMultiCrudActive);

		if (component.facilityUserMultiCrudActive) {
			facilityUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedfacilityUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.facilityUserDisplayName + ' to Model'));

			expect(updatedfacilityUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Facility User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.facilityUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const facilityUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.facilityUserDisplayName + ' from Model')).length;

			expect(facilityUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Management User relation.
	*
	* The button should only exist if managementUserMultiCrudActive is true
	*/
	it ('Renders Management User Add Entity button in create mode', fakeAsync(() => {
		const managementUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.managementUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!managementUserButton).toEqual(component.managementUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Management User', fakeAsync(() => {
		const managementUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.managementUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!managementUserButton).toEqual(component.managementUserMultiCrudActive);

		if (component.managementUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialManagementUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.managementUserDisplayName + ' from Model')).length;

			managementUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualManagementUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.managementUserDisplayName + ' from Model')).length;

			expect(actualManagementUserRemoveButtonCount).toEqual(initialManagementUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Management User button', () => {
		const managementUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.managementUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!managementUserButton).toEqual(component.managementUserMultiCrudActive);

		if (component.managementUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			managementUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialManagementUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.managementUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialManagementUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualManagementUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.managementUserDisplayName + ' from Model'));

			expect(actualManagementUserRemoveButtons.length).toEqual(initialManagementUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Management User button when one has already been added', () => {

		const managementUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.managementUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!managementUserButton).toEqual(component.managementUserMultiCrudActive);

		if (component.managementUserMultiCrudActive) {
			managementUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmanagementUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.managementUserDisplayName + ' to Model'));

			expect(updatedmanagementUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Management User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.managementUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const managementUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.managementUserDisplayName + ' from Model')).length;

			expect(managementUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Record user relation.
	*
	* The button should only exist if medicalRecordUserMultiCrudActive is true
	*/
	it ('Renders Medical Record user Add Entity button in create mode', fakeAsync(() => {
		const medicalRecordUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalRecordUserButton).toEqual(component.medicalRecordUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Record user', fakeAsync(() => {
		const medicalRecordUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalRecordUserButton).toEqual(component.medicalRecordUserMultiCrudActive);

		if (component.medicalRecordUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalRecordUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordUserDisplayName + ' from Model')).length;

			medicalRecordUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalRecordUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordUserDisplayName + ' from Model')).length;

			expect(actualMedicalRecordUserRemoveButtonCount).toEqual(initialMedicalRecordUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Record user button', () => {
		const medicalRecordUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalRecordUserButton).toEqual(component.medicalRecordUserMultiCrudActive);

		if (component.medicalRecordUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalRecordUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalRecordUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalRecordUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalRecordUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordUserDisplayName + ' from Model'));

			expect(actualMedicalRecordUserRemoveButtons.length).toEqual(initialMedicalRecordUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Record user button when one has already been added', () => {

		const medicalRecordUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalRecordUserButton).toEqual(component.medicalRecordUserMultiCrudActive);

		if (component.medicalRecordUserMultiCrudActive) {
			medicalRecordUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalRecordUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordUserDisplayName + ' to Model'));

			expect(updatedmedicalRecordUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Record user entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalRecordUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalRecordUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordUserDisplayName + ' from Model')).length;

			expect(medicalRecordUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Transcriber User relation.
	*
	* The button should only exist if medicalTranscriberUserMultiCrudActive is true
	*/
	it ('Renders Medical Transcriber User Add Entity button in create mode', fakeAsync(() => {
		const medicalTranscriberUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalTranscriberUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalTranscriberUserButton).toEqual(component.medicalTranscriberUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Transcriber User', fakeAsync(() => {
		const medicalTranscriberUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalTranscriberUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalTranscriberUserButton).toEqual(component.medicalTranscriberUserMultiCrudActive);

		if (component.medicalTranscriberUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalTranscriberUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalTranscriberUserDisplayName + ' from Model')).length;

			medicalTranscriberUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalTranscriberUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalTranscriberUserDisplayName + ' from Model')).length;

			expect(actualMedicalTranscriberUserRemoveButtonCount).toEqual(initialMedicalTranscriberUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Transcriber User button', () => {
		const medicalTranscriberUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalTranscriberUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalTranscriberUserButton).toEqual(component.medicalTranscriberUserMultiCrudActive);

		if (component.medicalTranscriberUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalTranscriberUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalTranscriberUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalTranscriberUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalTranscriberUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalTranscriberUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalTranscriberUserDisplayName + ' from Model'));

			expect(actualMedicalTranscriberUserRemoveButtons.length).toEqual(initialMedicalTranscriberUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Transcriber User button when one has already been added', () => {

		const medicalTranscriberUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalTranscriberUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalTranscriberUserButton).toEqual(component.medicalTranscriberUserMultiCrudActive);

		if (component.medicalTranscriberUserMultiCrudActive) {
			medicalTranscriberUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalTranscriberUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalTranscriberUserDisplayName + ' to Model'));

			expect(updatedmedicalTranscriberUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Transcriber User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalTranscriberUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalTranscriberUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalTranscriberUserDisplayName + ' from Model')).length;

			expect(medicalTranscriberUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Nurse User relation.
	*
	* The button should only exist if nurseUserMultiCrudActive is true
	*/
	it ('Renders Nurse User Add Entity button in create mode', fakeAsync(() => {
		const nurseUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!nurseUserButton).toEqual(component.nurseUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Nurse User', fakeAsync(() => {
		const nurseUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nurseUserButton).toEqual(component.nurseUserMultiCrudActive);

		if (component.nurseUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialNurseUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseUserDisplayName + ' from Model')).length;

			nurseUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualNurseUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseUserDisplayName + ' from Model')).length;

			expect(actualNurseUserRemoveButtonCount).toEqual(initialNurseUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Nurse User button', () => {
		const nurseUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nurseUserButton).toEqual(component.nurseUserMultiCrudActive);

		if (component.nurseUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			nurseUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialNurseUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialNurseUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualNurseUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseUserDisplayName + ' from Model'));

			expect(actualNurseUserRemoveButtons.length).toEqual(initialNurseUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Nurse User button when one has already been added', () => {

		const nurseUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nurseUserButton).toEqual(component.nurseUserMultiCrudActive);

		if (component.nurseUserMultiCrudActive) {
			nurseUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatednurseUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseUserDisplayName + ' to Model'));

			expect(updatednurseUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Nurse User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.nurseUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const nurseUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseUserDisplayName + ' from Model')).length;

			expect(nurseUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Pharmacy User relation.
	*
	* The button should only exist if pharmacyUserMultiCrudActive is true
	*/
	it ('Renders Pharmacy User Add Entity button in create mode', fakeAsync(() => {
		const pharmacyUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pharmacyUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!pharmacyUserButton).toEqual(component.pharmacyUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Pharmacy User', fakeAsync(() => {
		const pharmacyUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pharmacyUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pharmacyUserButton).toEqual(component.pharmacyUserMultiCrudActive);

		if (component.pharmacyUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPharmacyUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pharmacyUserDisplayName + ' from Model')).length;

			pharmacyUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualPharmacyUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pharmacyUserDisplayName + ' from Model')).length;

			expect(actualPharmacyUserRemoveButtonCount).toEqual(initialPharmacyUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Pharmacy User button', () => {
		const pharmacyUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pharmacyUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pharmacyUserButton).toEqual(component.pharmacyUserMultiCrudActive);

		if (component.pharmacyUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			pharmacyUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPharmacyUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pharmacyUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPharmacyUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPharmacyUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pharmacyUserDisplayName + ' from Model'));

			expect(actualPharmacyUserRemoveButtons.length).toEqual(initialPharmacyUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Pharmacy User button when one has already been added', () => {

		const pharmacyUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.pharmacyUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pharmacyUserButton).toEqual(component.pharmacyUserMultiCrudActive);

		if (component.pharmacyUserMultiCrudActive) {
			pharmacyUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpharmacyUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.pharmacyUserDisplayName + ' to Model'));

			expect(updatedpharmacyUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Pharmacy User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.pharmacyUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const pharmacyUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pharmacyUserDisplayName + ' from Model')).length;

			expect(pharmacyUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Purchasing User relation.
	*
	* The button should only exist if purchasingUserMultiCrudActive is true
	*/
	it ('Renders Purchasing User Add Entity button in create mode', fakeAsync(() => {
		const purchasingUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchasingUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!purchasingUserButton).toEqual(component.purchasingUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Purchasing User', fakeAsync(() => {
		const purchasingUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchasingUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchasingUserButton).toEqual(component.purchasingUserMultiCrudActive);

		if (component.purchasingUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPurchasingUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchasingUserDisplayName + ' from Model')).length;

			purchasingUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualPurchasingUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchasingUserDisplayName + ' from Model')).length;

			expect(actualPurchasingUserRemoveButtonCount).toEqual(initialPurchasingUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Purchasing User button', () => {
		const purchasingUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchasingUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchasingUserButton).toEqual(component.purchasingUserMultiCrudActive);

		if (component.purchasingUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			purchasingUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPurchasingUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchasingUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPurchasingUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPurchasingUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchasingUserDisplayName + ' from Model'));

			expect(actualPurchasingUserRemoveButtons.length).toEqual(initialPurchasingUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Purchasing User button when one has already been added', () => {

		const purchasingUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchasingUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchasingUserButton).toEqual(component.purchasingUserMultiCrudActive);

		if (component.purchasingUserMultiCrudActive) {
			purchasingUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpurchasingUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchasingUserDisplayName + ' to Model'));

			expect(updatedpurchasingUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Purchasing User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.purchasingUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const purchasingUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchasingUserDisplayName + ' from Model')).length;

			expect(purchasingUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Registration User relation.
	*
	* The button should only exist if registrationUserMultiCrudActive is true
	*/
	it ('Renders Registration User Add Entity button in create mode', fakeAsync(() => {
		const registrationUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!registrationUserButton).toEqual(component.registrationUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Registration User', fakeAsync(() => {
		const registrationUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationUserButton).toEqual(component.registrationUserMultiCrudActive);

		if (component.registrationUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRegistrationUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationUserDisplayName + ' from Model')).length;

			registrationUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationUserDisplayName + ' from Model')).length;

			expect(actualRegistrationUserRemoveButtonCount).toEqual(initialRegistrationUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Registration User button', () => {
		const registrationUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationUserButton).toEqual(component.registrationUserMultiCrudActive);

		if (component.registrationUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			registrationUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRegistrationUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRegistrationUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationUserDisplayName + ' from Model'));

			expect(actualRegistrationUserRemoveButtons.length).toEqual(initialRegistrationUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Registration User button when one has already been added', () => {

		const registrationUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationUserButton).toEqual(component.registrationUserMultiCrudActive);

		if (component.registrationUserMultiCrudActive) {
			registrationUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedregistrationUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationUserDisplayName + ' to Model'));

			expect(updatedregistrationUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Registration User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.registrationUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const registrationUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationUserDisplayName + ' from Model')).length;

			expect(registrationUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the System Admin User relation.
	*
	* The button should only exist if systemAdminUserMultiCrudActive is true
	*/
	it ('Renders System Admin User Add Entity button in create mode', fakeAsync(() => {
		const systemAdminUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.systemAdminUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!systemAdminUserButton).toEqual(component.systemAdminUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new System Admin User', fakeAsync(() => {
		const systemAdminUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.systemAdminUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!systemAdminUserButton).toEqual(component.systemAdminUserMultiCrudActive);

		if (component.systemAdminUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSystemAdminUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.systemAdminUserDisplayName + ' from Model')).length;

			systemAdminUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualSystemAdminUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.systemAdminUserDisplayName + ' from Model')).length;

			expect(actualSystemAdminUserRemoveButtonCount).toEqual(initialSystemAdminUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove System Admin User button', () => {
		const systemAdminUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.systemAdminUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!systemAdminUserButton).toEqual(component.systemAdminUserMultiCrudActive);

		if (component.systemAdminUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			systemAdminUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSystemAdminUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.systemAdminUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSystemAdminUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSystemAdminUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.systemAdminUserDisplayName + ' from Model'));

			expect(actualSystemAdminUserRemoveButtons.length).toEqual(initialSystemAdminUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add System Admin User button when one has already been added', () => {

		const systemAdminUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.systemAdminUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!systemAdminUserButton).toEqual(component.systemAdminUserMultiCrudActive);

		if (component.systemAdminUserMultiCrudActive) {
			systemAdminUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsystemAdminUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.systemAdminUserDisplayName + ' to Model'));

			expect(updatedsystemAdminUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related System Admin User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.systemAdminUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const systemAdminUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.systemAdminUserDisplayName + ' from Model')).length;

			expect(systemAdminUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Warehouse User relation.
	*
	* The button should only exist if warehouseUserMultiCrudActive is true
	*/
	it ('Renders Warehouse User Add Entity button in create mode', fakeAsync(() => {
		const warehouseUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseUserDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!warehouseUserButton).toEqual(component.warehouseUserMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Warehouse User', fakeAsync(() => {
		const warehouseUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseUserButton).toEqual(component.warehouseUserMultiCrudActive);

		if (component.warehouseUserMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialWarehouseUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseUserDisplayName + ' from Model')).length;

			warehouseUserButton.nativeElement.click();
			fixture.detectChanges();

			const actualWarehouseUserRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseUserDisplayName + ' from Model')).length;

			expect(actualWarehouseUserRemoveButtonCount).toEqual(initialWarehouseUserRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Warehouse User button', () => {
		const warehouseUserButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseUserButton).toEqual(component.warehouseUserMultiCrudActive);

		if (component.warehouseUserMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			warehouseUserButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialWarehouseUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseUserDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialWarehouseUserRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualWarehouseUserRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseUserDisplayName + ' from Model'));

			expect(actualWarehouseUserRemoveButtons.length).toEqual(initialWarehouseUserRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Warehouse User button when one has already been added', () => {

		const warehouseUserButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseUserDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!warehouseUserButton).toEqual(component.warehouseUserMultiCrudActive);

		if (component.warehouseUserMultiCrudActive) {
			warehouseUserButton.nativeElement.click();
			fixture.detectChanges();

			const updatedwarehouseUserButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.warehouseUserDisplayName + ' to Model'));

			expect(updatedwarehouseUserButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Warehouse User entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.warehouseUserMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const warehouseUserRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.warehouseUserDisplayName + ' from Model')).length;

			expect(warehouseUserRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Accompanying Consents relation.
	*
	* The button should only exist if accompanyingConsentsMultiCrudActive is true
	*/
	it ('Renders Accompanying Consents Add Entity button in create mode', fakeAsync(() => {
		const accompanyingConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.accompanyingConsentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!accompanyingConsentsButton).toEqual(component.accompanyingConsentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Accompanying Consents', fakeAsync(() => {
		const accompanyingConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.accompanyingConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!accompanyingConsentsButton).toEqual(component.accompanyingConsentsMultiCrudActive);

		if (component.accompanyingConsentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAccompanyingConsentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.accompanyingConsentsDisplayName + ' from Model')).length;

			accompanyingConsentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualAccompanyingConsentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.accompanyingConsentsDisplayName + ' from Model')).length;

			expect(actualAccompanyingConsentsRemoveButtonCount).toEqual(initialAccompanyingConsentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Accompanying Consents button', () => {
		const accompanyingConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.accompanyingConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!accompanyingConsentsButton).toEqual(component.accompanyingConsentsMultiCrudActive);

		if (component.accompanyingConsentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			accompanyingConsentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAccompanyingConsentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.accompanyingConsentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAccompanyingConsentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAccompanyingConsentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.accompanyingConsentsDisplayName + ' from Model'));

			expect(actualAccompanyingConsentsRemoveButtons.length).toEqual(initialAccompanyingConsentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Accompanying Consents button when one has already been added', () => {

		const accompanyingConsentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.accompanyingConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!accompanyingConsentsButton).toEqual(component.accompanyingConsentsMultiCrudActive);

		if (component.accompanyingConsentsMultiCrudActive) {
			accompanyingConsentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedaccompanyingConsentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.accompanyingConsentsDisplayName + ' to Model'));

			expect(updatedaccompanyingConsentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Accompanying Consents entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.accompanyingConsentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const accompanyingConsentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.accompanyingConsentsDisplayName + ' from Model')).length;

			expect(accompanyingConsentsRemoveButtonCount).toEqual(staffWithId.accompanyingConsents.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Amendment Details relation.
	*
	* The button should only exist if amendmentDetailsMultiCrudActive is true
	*/
	it ('Renders Amendment Details Add Entity button in create mode', fakeAsync(() => {
		const amendmentDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.amendmentDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!amendmentDetailsButton).toEqual(component.amendmentDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Amendment Details', fakeAsync(() => {
		const amendmentDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.amendmentDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!amendmentDetailsButton).toEqual(component.amendmentDetailsMultiCrudActive);

		if (component.amendmentDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAmendmentDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.amendmentDetailsDisplayName + ' from Model')).length;

			amendmentDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualAmendmentDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.amendmentDetailsDisplayName + ' from Model')).length;

			expect(actualAmendmentDetailsRemoveButtonCount).toEqual(initialAmendmentDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Amendment Details button', () => {
		const amendmentDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.amendmentDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!amendmentDetailsButton).toEqual(component.amendmentDetailsMultiCrudActive);

		if (component.amendmentDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			amendmentDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAmendmentDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.amendmentDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAmendmentDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAmendmentDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.amendmentDetailsDisplayName + ' from Model'));

			expect(actualAmendmentDetailsRemoveButtons.length).toEqual(initialAmendmentDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Amendment Details button when one has already been added', () => {

		const amendmentDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.amendmentDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!amendmentDetailsButton).toEqual(component.amendmentDetailsMultiCrudActive);

		if (component.amendmentDetailsMultiCrudActive) {
			amendmentDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedamendmentDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.amendmentDetailsDisplayName + ' to Model'));

			expect(updatedamendmentDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Amendment Details entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.amendmentDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const amendmentDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.amendmentDetailsDisplayName + ' from Model')).length;

			expect(amendmentDetailsRemoveButtonCount).toEqual(staffWithId.amendmentDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Anesthesia Medical Transcriber relation.
	*
	* The button should only exist if anesthesiaMedicalTranscriberMultiCrudActive is true
	*/
	it ('Renders Anesthesia Medical Transcriber Add Entity button in create mode', fakeAsync(() => {
		const anesthesiaMedicalTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiaMedicalTranscriberDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!anesthesiaMedicalTranscriberButton).toEqual(component.anesthesiaMedicalTranscriberMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Anesthesia Medical Transcriber', fakeAsync(() => {
		const anesthesiaMedicalTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiaMedicalTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!anesthesiaMedicalTranscriberButton).toEqual(component.anesthesiaMedicalTranscriberMultiCrudActive);

		if (component.anesthesiaMedicalTranscriberMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAnesthesiaMedicalTranscriberRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiaMedicalTranscriberDisplayName + ' from Model')).length;

			anesthesiaMedicalTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			const actualAnesthesiaMedicalTranscriberRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiaMedicalTranscriberDisplayName + ' from Model')).length;

			expect(actualAnesthesiaMedicalTranscriberRemoveButtonCount).toEqual(initialAnesthesiaMedicalTranscriberRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Anesthesia Medical Transcriber button', () => {
		const anesthesiaMedicalTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiaMedicalTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!anesthesiaMedicalTranscriberButton).toEqual(component.anesthesiaMedicalTranscriberMultiCrudActive);

		if (component.anesthesiaMedicalTranscriberMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			anesthesiaMedicalTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAnesthesiaMedicalTranscriberRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiaMedicalTranscriberDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAnesthesiaMedicalTranscriberRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAnesthesiaMedicalTranscriberRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiaMedicalTranscriberDisplayName + ' from Model'));

			expect(actualAnesthesiaMedicalTranscriberRemoveButtons.length).toEqual(initialAnesthesiaMedicalTranscriberRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Anesthesia Medical Transcriber button when one has already been added', () => {

		const anesthesiaMedicalTranscriberButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiaMedicalTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!anesthesiaMedicalTranscriberButton).toEqual(component.anesthesiaMedicalTranscriberMultiCrudActive);

		if (component.anesthesiaMedicalTranscriberMultiCrudActive) {
			anesthesiaMedicalTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			const updatedanesthesiaMedicalTranscriberButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiaMedicalTranscriberDisplayName + ' to Model'));

			expect(updatedanesthesiaMedicalTranscriberButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Anesthesia Medical Transcriber entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.anesthesiaMedicalTranscriberMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const anesthesiaMedicalTranscriberRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiaMedicalTranscriberDisplayName + ' from Model')).length;

			expect(anesthesiaMedicalTranscriberRemoveButtonCount).toEqual(staffWithId.anesthesiaMedicalTranscriber.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Anesthesiologist relation.
	*
	* The button should only exist if anesthesiologistMultiCrudActive is true
	*/
	it ('Renders Anesthesiologist Add Entity button in create mode', fakeAsync(() => {
		const anesthesiologistButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologistDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!anesthesiologistButton).toEqual(component.anesthesiologistMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Anesthesiologist', fakeAsync(() => {
		const anesthesiologistButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologistDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!anesthesiologistButton).toEqual(component.anesthesiologistMultiCrudActive);

		if (component.anesthesiologistMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAnesthesiologistRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologistDisplayName + ' from Model')).length;

			anesthesiologistButton.nativeElement.click();
			fixture.detectChanges();

			const actualAnesthesiologistRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologistDisplayName + ' from Model')).length;

			expect(actualAnesthesiologistRemoveButtonCount).toEqual(initialAnesthesiologistRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Anesthesiologist button', () => {
		const anesthesiologistButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologistDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!anesthesiologistButton).toEqual(component.anesthesiologistMultiCrudActive);

		if (component.anesthesiologistMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			anesthesiologistButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAnesthesiologistRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologistDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAnesthesiologistRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAnesthesiologistRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologistDisplayName + ' from Model'));

			expect(actualAnesthesiologistRemoveButtons.length).toEqual(initialAnesthesiologistRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Anesthesiologist button when one has already been added', () => {

		const anesthesiologistButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologistDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!anesthesiologistButton).toEqual(component.anesthesiologistMultiCrudActive);

		if (component.anesthesiologistMultiCrudActive) {
			anesthesiologistButton.nativeElement.click();
			fixture.detectChanges();

			const updatedanesthesiologistButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologistDisplayName + ' to Model'));

			expect(updatedanesthesiologistButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Anesthesiologist entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.anesthesiologistMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const anesthesiologistRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologistDisplayName + ' from Model')).length;

			expect(anesthesiologistRemoveButtonCount).toEqual(staffWithId.anesthesiologist.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Anesthesiology Nurse relation.
	*
	* The button should only exist if anesthesiologyNurseMultiCrudActive is true
	*/
	it ('Renders Anesthesiology Nurse Add Entity button in create mode', fakeAsync(() => {
		const anesthesiologyNurseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologyNurseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!anesthesiologyNurseButton).toEqual(component.anesthesiologyNurseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Anesthesiology Nurse', fakeAsync(() => {
		const anesthesiologyNurseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologyNurseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!anesthesiologyNurseButton).toEqual(component.anesthesiologyNurseMultiCrudActive);

		if (component.anesthesiologyNurseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAnesthesiologyNurseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologyNurseDisplayName + ' from Model')).length;

			anesthesiologyNurseButton.nativeElement.click();
			fixture.detectChanges();

			const actualAnesthesiologyNurseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologyNurseDisplayName + ' from Model')).length;

			expect(actualAnesthesiologyNurseRemoveButtonCount).toEqual(initialAnesthesiologyNurseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Anesthesiology Nurse button', () => {
		const anesthesiologyNurseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologyNurseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!anesthesiologyNurseButton).toEqual(component.anesthesiologyNurseMultiCrudActive);

		if (component.anesthesiologyNurseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			anesthesiologyNurseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAnesthesiologyNurseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologyNurseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAnesthesiologyNurseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAnesthesiologyNurseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologyNurseDisplayName + ' from Model'));

			expect(actualAnesthesiologyNurseRemoveButtons.length).toEqual(initialAnesthesiologyNurseRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Anesthesiology Nurse button when one has already been added', () => {

		const anesthesiologyNurseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologyNurseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!anesthesiologyNurseButton).toEqual(component.anesthesiologyNurseMultiCrudActive);

		if (component.anesthesiologyNurseMultiCrudActive) {
			anesthesiologyNurseButton.nativeElement.click();
			fixture.detectChanges();

			const updatedanesthesiologyNurseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.anesthesiologyNurseDisplayName + ' to Model'));

			expect(updatedanesthesiologyNurseButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Anesthesiology Nurse entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.anesthesiologyNurseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const anesthesiologyNurseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.anesthesiologyNurseDisplayName + ' from Model')).length;

			expect(anesthesiologyNurseRemoveButtonCount).toEqual(staffWithId.anesthesiologyNurse.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Cashier Staff relation.
	*
	* The button should only exist if cashierStaffMultiCrudActive is true
	*/
	it ('Renders Cashier Staff Add Entity button in create mode', fakeAsync(() => {
		const cashierStaffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierStaffDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!cashierStaffButton).toEqual(component.cashierStaffMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Cashier Staff', fakeAsync(() => {
		const cashierStaffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierStaffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashierStaffButton).toEqual(component.cashierStaffMultiCrudActive);

		if (component.cashierStaffMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCashierStaffRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierStaffDisplayName + ' from Model')).length;

			cashierStaffButton.nativeElement.click();
			fixture.detectChanges();

			const actualCashierStaffRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierStaffDisplayName + ' from Model')).length;

			expect(actualCashierStaffRemoveButtonCount).toEqual(initialCashierStaffRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Cashier Staff button', () => {
		const cashierStaffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierStaffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashierStaffButton).toEqual(component.cashierStaffMultiCrudActive);

		if (component.cashierStaffMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			cashierStaffButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCashierStaffRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierStaffDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCashierStaffRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCashierStaffRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierStaffDisplayName + ' from Model'));

			expect(actualCashierStaffRemoveButtons.length).toEqual(initialCashierStaffRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Cashier Staff button when one has already been added', () => {

		const cashierStaffButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierStaffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashierStaffButton).toEqual(component.cashierStaffMultiCrudActive);

		if (component.cashierStaffMultiCrudActive) {
			cashierStaffButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcashierStaffButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashierStaffDisplayName + ' to Model'));

			expect(updatedcashierStaffButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Cashier Staff entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.cashierStaffMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const cashierStaffRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashierStaffDisplayName + ' from Model')).length;

			expect(cashierStaffRemoveButtonCount).toEqual(staffWithId.cashierStaff.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Co Treating Doctors relation.
	*
	* The button should only exist if coTreatingDoctorsMultiCrudActive is true
	*/
	it ('Renders Co Treating Doctors Add Entity button in create mode', fakeAsync(() => {
		const coTreatingDoctorsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.coTreatingDoctorsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!coTreatingDoctorsButton).toEqual(component.coTreatingDoctorsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Co Treating Doctors', fakeAsync(() => {
		const coTreatingDoctorsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.coTreatingDoctorsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!coTreatingDoctorsButton).toEqual(component.coTreatingDoctorsMultiCrudActive);

		if (component.coTreatingDoctorsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCoTreatingDoctorsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.coTreatingDoctorsDisplayName + ' from Model')).length;

			coTreatingDoctorsButton.nativeElement.click();
			fixture.detectChanges();

			const actualCoTreatingDoctorsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.coTreatingDoctorsDisplayName + ' from Model')).length;

			expect(actualCoTreatingDoctorsRemoveButtonCount).toEqual(initialCoTreatingDoctorsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Co Treating Doctors button', () => {
		const coTreatingDoctorsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.coTreatingDoctorsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!coTreatingDoctorsButton).toEqual(component.coTreatingDoctorsMultiCrudActive);

		if (component.coTreatingDoctorsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			coTreatingDoctorsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCoTreatingDoctorsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.coTreatingDoctorsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCoTreatingDoctorsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCoTreatingDoctorsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.coTreatingDoctorsDisplayName + ' from Model'));

			expect(actualCoTreatingDoctorsRemoveButtons.length).toEqual(initialCoTreatingDoctorsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Co Treating Doctors button when one has already been added', () => {

		const coTreatingDoctorsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.coTreatingDoctorsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!coTreatingDoctorsButton).toEqual(component.coTreatingDoctorsMultiCrudActive);

		if (component.coTreatingDoctorsMultiCrudActive) {
			coTreatingDoctorsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcoTreatingDoctorsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.coTreatingDoctorsDisplayName + ' to Model'));

			expect(updatedcoTreatingDoctorsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Co Treating Doctors entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.coTreatingDoctorsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const coTreatingDoctorsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.coTreatingDoctorsDisplayName + ' from Model')).length;

			expect(coTreatingDoctorsRemoveButtonCount).toEqual(staffWithId.coTreatingDoctors.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Daily Care CPPTs Created By Staff relation.
	*
	* The button should only exist if dailyCareCPPTsCreatedByStaffMultiCrudActive is true
	*/
	it ('Renders Daily Care CPPTs Created By Staff Add Entity button in create mode', fakeAsync(() => {
		const dailyCareCPPTsCreatedByStaffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!dailyCareCPPTsCreatedByStaffButton).toEqual(component.dailyCareCPPTsCreatedByStaffMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Daily Care CPPTs Created By Staff', fakeAsync(() => {
		const dailyCareCPPTsCreatedByStaffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dailyCareCPPTsCreatedByStaffButton).toEqual(component.dailyCareCPPTsCreatedByStaffMultiCrudActive);

		if (component.dailyCareCPPTsCreatedByStaffMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDailyCareCPPTsCreatedByStaffRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' from Model')).length;

			dailyCareCPPTsCreatedByStaffButton.nativeElement.click();
			fixture.detectChanges();

			const actualDailyCareCPPTsCreatedByStaffRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' from Model')).length;

			expect(actualDailyCareCPPTsCreatedByStaffRemoveButtonCount).toEqual(initialDailyCareCPPTsCreatedByStaffRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Daily Care CPPTs Created By Staff button', () => {
		const dailyCareCPPTsCreatedByStaffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dailyCareCPPTsCreatedByStaffButton).toEqual(component.dailyCareCPPTsCreatedByStaffMultiCrudActive);

		if (component.dailyCareCPPTsCreatedByStaffMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			dailyCareCPPTsCreatedByStaffButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDailyCareCPPTsCreatedByStaffRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDailyCareCPPTsCreatedByStaffRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDailyCareCPPTsCreatedByStaffRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' from Model'));

			expect(actualDailyCareCPPTsCreatedByStaffRemoveButtons.length).toEqual(initialDailyCareCPPTsCreatedByStaffRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Daily Care CPPTs Created By Staff button when one has already been added', () => {

		const dailyCareCPPTsCreatedByStaffButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dailyCareCPPTsCreatedByStaffButton).toEqual(component.dailyCareCPPTsCreatedByStaffMultiCrudActive);

		if (component.dailyCareCPPTsCreatedByStaffMultiCrudActive) {
			dailyCareCPPTsCreatedByStaffButton.nativeElement.click();
			fixture.detectChanges();

			const updateddailyCareCPPTsCreatedByStaffButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' to Model'));

			expect(updateddailyCareCPPTsCreatedByStaffButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Daily Care CPPTs Created By Staff entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.dailyCareCPPTsCreatedByStaffMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const dailyCareCPPTsCreatedByStaffRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsCreatedByStaffDisplayName + ' from Model')).length;

			expect(dailyCareCPPTsCreatedByStaffRemoveButtonCount).toEqual(staffWithId.dailyCareCPPTsCreatedByStaff.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Daily Care CPPTs Doctor in Charge relation.
	*
	* The button should only exist if dailyCareCPPTsDoctorInChargeMultiCrudActive is true
	*/
	it ('Renders Daily Care CPPTs Doctor in Charge Add Entity button in create mode', fakeAsync(() => {
		const dailyCareCPPTsDoctorInChargeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!dailyCareCPPTsDoctorInChargeButton).toEqual(component.dailyCareCPPTsDoctorInChargeMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Daily Care CPPTs Doctor in Charge', fakeAsync(() => {
		const dailyCareCPPTsDoctorInChargeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dailyCareCPPTsDoctorInChargeButton).toEqual(component.dailyCareCPPTsDoctorInChargeMultiCrudActive);

		if (component.dailyCareCPPTsDoctorInChargeMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDailyCareCPPTsDoctorInChargeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' from Model')).length;

			dailyCareCPPTsDoctorInChargeButton.nativeElement.click();
			fixture.detectChanges();

			const actualDailyCareCPPTsDoctorInChargeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' from Model')).length;

			expect(actualDailyCareCPPTsDoctorInChargeRemoveButtonCount).toEqual(initialDailyCareCPPTsDoctorInChargeRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Daily Care CPPTs Doctor in Charge button', () => {
		const dailyCareCPPTsDoctorInChargeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dailyCareCPPTsDoctorInChargeButton).toEqual(component.dailyCareCPPTsDoctorInChargeMultiCrudActive);

		if (component.dailyCareCPPTsDoctorInChargeMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			dailyCareCPPTsDoctorInChargeButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDailyCareCPPTsDoctorInChargeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDailyCareCPPTsDoctorInChargeRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDailyCareCPPTsDoctorInChargeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' from Model'));

			expect(actualDailyCareCPPTsDoctorInChargeRemoveButtons.length).toEqual(initialDailyCareCPPTsDoctorInChargeRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Daily Care CPPTs Doctor in Charge button when one has already been added', () => {

		const dailyCareCPPTsDoctorInChargeButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dailyCareCPPTsDoctorInChargeButton).toEqual(component.dailyCareCPPTsDoctorInChargeMultiCrudActive);

		if (component.dailyCareCPPTsDoctorInChargeMultiCrudActive) {
			dailyCareCPPTsDoctorInChargeButton.nativeElement.click();
			fixture.detectChanges();

			const updateddailyCareCPPTsDoctorInChargeButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' to Model'));

			expect(updateddailyCareCPPTsDoctorInChargeButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Daily Care CPPTs Doctor in Charge entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.dailyCareCPPTsDoctorInChargeMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const dailyCareCPPTsDoctorInChargeRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsDoctorInChargeDisplayName + ' from Model')).length;

			expect(dailyCareCPPTsDoctorInChargeRemoveButtonCount).toEqual(staffWithId.dailyCareCPPTsDoctorInCharge.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Daily Care CPPTs Medical Transcriber relation.
	*
	* The button should only exist if dailyCareCPPTsMedicalTranscriberMultiCrudActive is true
	*/
	it ('Renders Daily Care CPPTs Medical Transcriber Add Entity button in create mode', fakeAsync(() => {
		const dailyCareCPPTsMedicalTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!dailyCareCPPTsMedicalTranscriberButton).toEqual(component.dailyCareCPPTsMedicalTranscriberMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Daily Care CPPTs Medical Transcriber', fakeAsync(() => {
		const dailyCareCPPTsMedicalTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dailyCareCPPTsMedicalTranscriberButton).toEqual(component.dailyCareCPPTsMedicalTranscriberMultiCrudActive);

		if (component.dailyCareCPPTsMedicalTranscriberMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDailyCareCPPTsMedicalTranscriberRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' from Model')).length;

			dailyCareCPPTsMedicalTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			const actualDailyCareCPPTsMedicalTranscriberRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' from Model')).length;

			expect(actualDailyCareCPPTsMedicalTranscriberRemoveButtonCount).toEqual(initialDailyCareCPPTsMedicalTranscriberRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Daily Care CPPTs Medical Transcriber button', () => {
		const dailyCareCPPTsMedicalTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dailyCareCPPTsMedicalTranscriberButton).toEqual(component.dailyCareCPPTsMedicalTranscriberMultiCrudActive);

		if (component.dailyCareCPPTsMedicalTranscriberMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			dailyCareCPPTsMedicalTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDailyCareCPPTsMedicalTranscriberRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDailyCareCPPTsMedicalTranscriberRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDailyCareCPPTsMedicalTranscriberRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' from Model'));

			expect(actualDailyCareCPPTsMedicalTranscriberRemoveButtons.length).toEqual(initialDailyCareCPPTsMedicalTranscriberRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Daily Care CPPTs Medical Transcriber button when one has already been added', () => {

		const dailyCareCPPTsMedicalTranscriberButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dailyCareCPPTsMedicalTranscriberButton).toEqual(component.dailyCareCPPTsMedicalTranscriberMultiCrudActive);

		if (component.dailyCareCPPTsMedicalTranscriberMultiCrudActive) {
			dailyCareCPPTsMedicalTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			const updateddailyCareCPPTsMedicalTranscriberButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' to Model'));

			expect(updateddailyCareCPPTsMedicalTranscriberButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Daily Care CPPTs Medical Transcriber entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.dailyCareCPPTsMedicalTranscriberMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const dailyCareCPPTsMedicalTranscriberRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dailyCareCPPTsMedicalTranscriberDisplayName + ' from Model')).length;

			expect(dailyCareCPPTsMedicalTranscriberRemoveButtonCount).toEqual(staffWithId.dailyCareCPPTsMedicalTranscriber.length);
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
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
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

			expect(deliveryProgressesRemoveButtonCount).toEqual(staffWithId.deliveryProgresses.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Diagnostic Staff Examination Summaries relation.
	*
	* The button should only exist if diagnosticStaffExaminationSummariesMultiCrudActive is true
	*/
	it ('Renders Diagnostic Staff Examination Summaries Add Entity button in create mode', fakeAsync(() => {
		const diagnosticStaffExaminationSummariesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummariesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!diagnosticStaffExaminationSummariesButton).toEqual(component.diagnosticStaffExaminationSummariesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Diagnostic Staff Examination Summaries', fakeAsync(() => {
		const diagnosticStaffExaminationSummariesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummariesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticStaffExaminationSummariesButton).toEqual(component.diagnosticStaffExaminationSummariesMultiCrudActive);

		if (component.diagnosticStaffExaminationSummariesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDiagnosticStaffExaminationSummariesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummariesDisplayName + ' from Model')).length;

			diagnosticStaffExaminationSummariesButton.nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosticStaffExaminationSummariesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummariesDisplayName + ' from Model')).length;

			expect(actualDiagnosticStaffExaminationSummariesRemoveButtonCount).toEqual(initialDiagnosticStaffExaminationSummariesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Diagnostic Staff Examination Summaries button', () => {
		const diagnosticStaffExaminationSummariesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummariesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticStaffExaminationSummariesButton).toEqual(component.diagnosticStaffExaminationSummariesMultiCrudActive);

		if (component.diagnosticStaffExaminationSummariesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			diagnosticStaffExaminationSummariesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDiagnosticStaffExaminationSummariesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummariesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDiagnosticStaffExaminationSummariesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosticStaffExaminationSummariesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummariesDisplayName + ' from Model'));

			expect(actualDiagnosticStaffExaminationSummariesRemoveButtons.length).toEqual(initialDiagnosticStaffExaminationSummariesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Diagnostic Staff Examination Summaries button when one has already been added', () => {

		const diagnosticStaffExaminationSummariesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummariesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticStaffExaminationSummariesButton).toEqual(component.diagnosticStaffExaminationSummariesMultiCrudActive);

		if (component.diagnosticStaffExaminationSummariesMultiCrudActive) {
			diagnosticStaffExaminationSummariesButton.nativeElement.click();
			fixture.detectChanges();

			const updateddiagnosticStaffExaminationSummariesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummariesDisplayName + ' to Model'));

			expect(updateddiagnosticStaffExaminationSummariesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Diagnostic Staff Examination Summaries entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.diagnosticStaffExaminationSummariesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const diagnosticStaffExaminationSummariesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummariesDisplayName + ' from Model')).length;

			expect(diagnosticStaffExaminationSummariesRemoveButtonCount).toEqual(staffWithId.diagnosticStaffExaminationSummaries.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Dismissal Referring Staff relation.
	*
	* The button should only exist if dismissalReferringStaffMultiCrudActive is true
	*/
	it ('Renders Dismissal Referring Staff Add Entity button in create mode', fakeAsync(() => {
		const dismissalReferringStaffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringStaffDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!dismissalReferringStaffButton).toEqual(component.dismissalReferringStaffMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Dismissal Referring Staff', fakeAsync(() => {
		const dismissalReferringStaffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringStaffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dismissalReferringStaffButton).toEqual(component.dismissalReferringStaffMultiCrudActive);

		if (component.dismissalReferringStaffMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDismissalReferringStaffRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringStaffDisplayName + ' from Model')).length;

			dismissalReferringStaffButton.nativeElement.click();
			fixture.detectChanges();

			const actualDismissalReferringStaffRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringStaffDisplayName + ' from Model')).length;

			expect(actualDismissalReferringStaffRemoveButtonCount).toEqual(initialDismissalReferringStaffRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Dismissal Referring Staff button', () => {
		const dismissalReferringStaffButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringStaffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dismissalReferringStaffButton).toEqual(component.dismissalReferringStaffMultiCrudActive);

		if (component.dismissalReferringStaffMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			dismissalReferringStaffButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDismissalReferringStaffRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringStaffDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDismissalReferringStaffRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDismissalReferringStaffRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringStaffDisplayName + ' from Model'));

			expect(actualDismissalReferringStaffRemoveButtons.length).toEqual(initialDismissalReferringStaffRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Dismissal Referring Staff button when one has already been added', () => {

		const dismissalReferringStaffButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringStaffDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dismissalReferringStaffButton).toEqual(component.dismissalReferringStaffMultiCrudActive);

		if (component.dismissalReferringStaffMultiCrudActive) {
			dismissalReferringStaffButton.nativeElement.click();
			fixture.detectChanges();

			const updateddismissalReferringStaffButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringStaffDisplayName + ' to Model'));

			expect(updateddismissalReferringStaffButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Dismissal Referring Staff entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.dismissalReferringStaffMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const dismissalReferringStaffRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringStaffDisplayName + ' from Model')).length;

			expect(dismissalReferringStaffRemoveButtonCount).toEqual(staffWithId.dismissalReferringStaff.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Doctor Schedules relation.
	*
	* The button should only exist if doctorSchedulesMultiCrudActive is true
	*/
	it ('Renders Doctor Schedules Add Entity button in create mode', fakeAsync(() => {
		const doctorSchedulesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorSchedulesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!doctorSchedulesButton).toEqual(component.doctorSchedulesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Doctor Schedules', fakeAsync(() => {
		const doctorSchedulesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorSchedulesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!doctorSchedulesButton).toEqual(component.doctorSchedulesMultiCrudActive);

		if (component.doctorSchedulesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDoctorSchedulesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorSchedulesDisplayName + ' from Model')).length;

			doctorSchedulesButton.nativeElement.click();
			fixture.detectChanges();

			const actualDoctorSchedulesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorSchedulesDisplayName + ' from Model')).length;

			expect(actualDoctorSchedulesRemoveButtonCount).toEqual(initialDoctorSchedulesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Doctor Schedules button', () => {
		const doctorSchedulesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorSchedulesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!doctorSchedulesButton).toEqual(component.doctorSchedulesMultiCrudActive);

		if (component.doctorSchedulesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			doctorSchedulesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDoctorSchedulesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorSchedulesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDoctorSchedulesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDoctorSchedulesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorSchedulesDisplayName + ' from Model'));

			expect(actualDoctorSchedulesRemoveButtons.length).toEqual(initialDoctorSchedulesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Doctor Schedules button when one has already been added', () => {

		const doctorSchedulesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorSchedulesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!doctorSchedulesButton).toEqual(component.doctorSchedulesMultiCrudActive);

		if (component.doctorSchedulesMultiCrudActive) {
			doctorSchedulesButton.nativeElement.click();
			fixture.detectChanges();

			const updateddoctorSchedulesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorSchedulesDisplayName + ' to Model'));

			expect(updateddoctorSchedulesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Doctor Schedules entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.doctorSchedulesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const doctorSchedulesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorSchedulesDisplayName + ' from Model')).length;

			expect(doctorSchedulesRemoveButtonCount).toEqual(staffWithId.doctorSchedules.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Doctor on examination relation.
	*
	* The button should only exist if doctorOnExaminationMultiCrudActive is true
	*/
	it ('Renders Doctor on examination Add Entity button in create mode', fakeAsync(() => {
		const doctorOnExaminationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorOnExaminationDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!doctorOnExaminationButton).toEqual(component.doctorOnExaminationMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Doctor on examination', fakeAsync(() => {
		const doctorOnExaminationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorOnExaminationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!doctorOnExaminationButton).toEqual(component.doctorOnExaminationMultiCrudActive);

		if (component.doctorOnExaminationMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDoctorOnExaminationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorOnExaminationDisplayName + ' from Model')).length;

			doctorOnExaminationButton.nativeElement.click();
			fixture.detectChanges();

			const actualDoctorOnExaminationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorOnExaminationDisplayName + ' from Model')).length;

			expect(actualDoctorOnExaminationRemoveButtonCount).toEqual(initialDoctorOnExaminationRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Doctor on examination button', () => {
		const doctorOnExaminationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorOnExaminationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!doctorOnExaminationButton).toEqual(component.doctorOnExaminationMultiCrudActive);

		if (component.doctorOnExaminationMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			doctorOnExaminationButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDoctorOnExaminationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorOnExaminationDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDoctorOnExaminationRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDoctorOnExaminationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorOnExaminationDisplayName + ' from Model'));

			expect(actualDoctorOnExaminationRemoveButtons.length).toEqual(initialDoctorOnExaminationRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Doctor on examination button when one has already been added', () => {

		const doctorOnExaminationButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorOnExaminationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!doctorOnExaminationButton).toEqual(component.doctorOnExaminationMultiCrudActive);

		if (component.doctorOnExaminationMultiCrudActive) {
			doctorOnExaminationButton.nativeElement.click();
			fixture.detectChanges();

			const updateddoctorOnExaminationButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.doctorOnExaminationDisplayName + ' to Model'));

			expect(updateddoctorOnExaminationButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Doctor on examination entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.doctorOnExaminationMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const doctorOnExaminationRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.doctorOnExaminationDisplayName + ' from Model')).length;

			expect(doctorOnExaminationRemoveButtonCount).toEqual(staffWithId.doctorOnExamination.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Fluid Balance Details relation.
	*
	* The button should only exist if fluidBalanceDetailsMultiCrudActive is true
	*/
	it ('Renders Fluid Balance Details Add Entity button in create mode', fakeAsync(() => {
		const fluidBalanceDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.fluidBalanceDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!fluidBalanceDetailsButton).toEqual(component.fluidBalanceDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Fluid Balance Details', fakeAsync(() => {
		const fluidBalanceDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.fluidBalanceDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!fluidBalanceDetailsButton).toEqual(component.fluidBalanceDetailsMultiCrudActive);

		if (component.fluidBalanceDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialFluidBalanceDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.fluidBalanceDetailsDisplayName + ' from Model')).length;

			fluidBalanceDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualFluidBalanceDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.fluidBalanceDetailsDisplayName + ' from Model')).length;

			expect(actualFluidBalanceDetailsRemoveButtonCount).toEqual(initialFluidBalanceDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Fluid Balance Details button', () => {
		const fluidBalanceDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.fluidBalanceDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!fluidBalanceDetailsButton).toEqual(component.fluidBalanceDetailsMultiCrudActive);

		if (component.fluidBalanceDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			fluidBalanceDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialFluidBalanceDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.fluidBalanceDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialFluidBalanceDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualFluidBalanceDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.fluidBalanceDetailsDisplayName + ' from Model'));

			expect(actualFluidBalanceDetailsRemoveButtons.length).toEqual(initialFluidBalanceDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Fluid Balance Details button when one has already been added', () => {

		const fluidBalanceDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.fluidBalanceDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!fluidBalanceDetailsButton).toEqual(component.fluidBalanceDetailsMultiCrudActive);

		if (component.fluidBalanceDetailsMultiCrudActive) {
			fluidBalanceDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedfluidBalanceDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.fluidBalanceDetailsDisplayName + ' to Model'));

			expect(updatedfluidBalanceDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Fluid Balance Details entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.fluidBalanceDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const fluidBalanceDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.fluidBalanceDetailsDisplayName + ' from Model')).length;

			expect(fluidBalanceDetailsRemoveButtonCount).toEqual(staffWithId.fluidBalanceDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Hemodialysis Monitorings relation.
	*
	* The button should only exist if hemodialysisMonitoringsMultiCrudActive is true
	*/
	it ('Renders Hemodialysis Monitorings Add Entity button in create mode', fakeAsync(() => {
		const hemodialysisMonitoringsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.hemodialysisMonitoringsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!hemodialysisMonitoringsButton).toEqual(component.hemodialysisMonitoringsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Hemodialysis Monitorings', fakeAsync(() => {
		const hemodialysisMonitoringsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.hemodialysisMonitoringsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!hemodialysisMonitoringsButton).toEqual(component.hemodialysisMonitoringsMultiCrudActive);

		if (component.hemodialysisMonitoringsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialHemodialysisMonitoringsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hemodialysisMonitoringsDisplayName + ' from Model')).length;

			hemodialysisMonitoringsButton.nativeElement.click();
			fixture.detectChanges();

			const actualHemodialysisMonitoringsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hemodialysisMonitoringsDisplayName + ' from Model')).length;

			expect(actualHemodialysisMonitoringsRemoveButtonCount).toEqual(initialHemodialysisMonitoringsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Hemodialysis Monitorings button', () => {
		const hemodialysisMonitoringsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.hemodialysisMonitoringsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!hemodialysisMonitoringsButton).toEqual(component.hemodialysisMonitoringsMultiCrudActive);

		if (component.hemodialysisMonitoringsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			hemodialysisMonitoringsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialHemodialysisMonitoringsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hemodialysisMonitoringsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialHemodialysisMonitoringsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualHemodialysisMonitoringsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hemodialysisMonitoringsDisplayName + ' from Model'));

			expect(actualHemodialysisMonitoringsRemoveButtons.length).toEqual(initialHemodialysisMonitoringsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Hemodialysis Monitorings button when one has already been added', () => {

		const hemodialysisMonitoringsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.hemodialysisMonitoringsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!hemodialysisMonitoringsButton).toEqual(component.hemodialysisMonitoringsMultiCrudActive);

		if (component.hemodialysisMonitoringsMultiCrudActive) {
			hemodialysisMonitoringsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedhemodialysisMonitoringsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.hemodialysisMonitoringsDisplayName + ' to Model'));

			expect(updatedhemodialysisMonitoringsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Hemodialysis Monitorings entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.hemodialysisMonitoringsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const hemodialysisMonitoringsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hemodialysisMonitoringsDisplayName + ' from Model')).length;

			expect(hemodialysisMonitoringsRemoveButtonCount).toEqual(staffWithId.hemodialysisMonitorings.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Hospital Branch Informations relation.
	*
	* The button should only exist if hospitalBranchInformationsMultiCrudActive is true
	*/
	it ('Renders Hospital Branch Informations Add Entity button in create mode', fakeAsync(() => {
		const hospitalBranchInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!hospitalBranchInformationsButton).toEqual(component.hospitalBranchInformationsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Hospital Branch Informations', fakeAsync(() => {
		const hospitalBranchInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!hospitalBranchInformationsButton).toEqual(component.hospitalBranchInformationsMultiCrudActive);

		if (component.hospitalBranchInformationsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialHospitalBranchInformationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model')).length;

			hospitalBranchInformationsButton.nativeElement.click();
			fixture.detectChanges();

			const actualHospitalBranchInformationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model')).length;

			expect(actualHospitalBranchInformationsRemoveButtonCount).toEqual(initialHospitalBranchInformationsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Hospital Branch Informations button', () => {
		const hospitalBranchInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!hospitalBranchInformationsButton).toEqual(component.hospitalBranchInformationsMultiCrudActive);

		if (component.hospitalBranchInformationsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			hospitalBranchInformationsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialHospitalBranchInformationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialHospitalBranchInformationsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualHospitalBranchInformationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model'));

			expect(actualHospitalBranchInformationsRemoveButtons.length).toEqual(initialHospitalBranchInformationsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Hospital Branch Informations button when one has already been added', () => {

		const hospitalBranchInformationsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!hospitalBranchInformationsButton).toEqual(component.hospitalBranchInformationsMultiCrudActive);

		if (component.hospitalBranchInformationsMultiCrudActive) {
			hospitalBranchInformationsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedhospitalBranchInformationsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

			expect(updatedhospitalBranchInformationsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Hospital Branch Informations entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.hospitalBranchInformationsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const hospitalBranchInformationsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model')).length;

			expect(hospitalBranchInformationsRemoveButtonCount).toEqual(staffWithId.hospitalBranchInformations.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Informing Consents relation.
	*
	* The button should only exist if informingConsentsMultiCrudActive is true
	*/
	it ('Renders Informing Consents Add Entity button in create mode', fakeAsync(() => {
		const informingConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.informingConsentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!informingConsentsButton).toEqual(component.informingConsentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Informing Consents', fakeAsync(() => {
		const informingConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.informingConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!informingConsentsButton).toEqual(component.informingConsentsMultiCrudActive);

		if (component.informingConsentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInformingConsentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informingConsentsDisplayName + ' from Model')).length;

			informingConsentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInformingConsentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informingConsentsDisplayName + ' from Model')).length;

			expect(actualInformingConsentsRemoveButtonCount).toEqual(initialInformingConsentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Informing Consents button', () => {
		const informingConsentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.informingConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!informingConsentsButton).toEqual(component.informingConsentsMultiCrudActive);

		if (component.informingConsentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			informingConsentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInformingConsentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informingConsentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInformingConsentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInformingConsentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informingConsentsDisplayName + ' from Model'));

			expect(actualInformingConsentsRemoveButtons.length).toEqual(initialInformingConsentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Informing Consents button when one has already been added', () => {

		const informingConsentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.informingConsentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!informingConsentsButton).toEqual(component.informingConsentsMultiCrudActive);

		if (component.informingConsentsMultiCrudActive) {
			informingConsentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinformingConsentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.informingConsentsDisplayName + ' to Model'));

			expect(updatedinformingConsentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Informing Consents entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.informingConsentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const informingConsentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.informingConsentsDisplayName + ' from Model')).length;

			expect(informingConsentsRemoveButtonCount).toEqual(staffWithId.informingConsents.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoices relation.
	*
	* The button should only exist if invoicesMultiCrudActive is true
	*/
	it ('Renders Invoices Add Entity button in create mode', fakeAsync(() => {
		const invoicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoicesButton).toEqual(component.invoicesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoices', fakeAsync(() => {
		const invoicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesButton).toEqual(component.invoicesMultiCrudActive);

		if (component.invoicesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model')).length;

			invoicesButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model')).length;

			expect(actualInvoicesRemoveButtonCount).toEqual(initialInvoicesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoices button', () => {
		const invoicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesButton).toEqual(component.invoicesMultiCrudActive);

		if (component.invoicesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoicesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoicesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model'));

			expect(actualInvoicesRemoveButtons.length).toEqual(initialInvoicesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoices button when one has already been added', () => {

		const invoicesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesButton).toEqual(component.invoicesMultiCrudActive);

		if (component.invoicesMultiCrudActive) {
			invoicesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoicesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

			expect(updatedinvoicesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoices entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoicesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoicesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model')).length;

			expect(invoicesRemoveButtonCount).toEqual(staffWithId.invoices.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the MCU Package Items relation.
	*
	* The button should only exist if mcuPackageItemsMultiCrudActive is true
	*/
	it ('Renders MCU Package Items Add Entity button in create mode', fakeAsync(() => {
		const mcuPackageItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!mcuPackageItemsButton).toEqual(component.mcuPackageItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new MCU Package Items', fakeAsync(() => {
		const mcuPackageItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!mcuPackageItemsButton).toEqual(component.mcuPackageItemsMultiCrudActive);

		if (component.mcuPackageItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMcuPackageItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model')).length;

			mcuPackageItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualMcuPackageItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model')).length;

			expect(actualMcuPackageItemsRemoveButtonCount).toEqual(initialMcuPackageItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove MCU Package Items button', () => {
		const mcuPackageItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!mcuPackageItemsButton).toEqual(component.mcuPackageItemsMultiCrudActive);

		if (component.mcuPackageItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			mcuPackageItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMcuPackageItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMcuPackageItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMcuPackageItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model'));

			expect(actualMcuPackageItemsRemoveButtons.length).toEqual(initialMcuPackageItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add MCU Package Items button when one has already been added', () => {

		const mcuPackageItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!mcuPackageItemsButton).toEqual(component.mcuPackageItemsMultiCrudActive);

		if (component.mcuPackageItemsMultiCrudActive) {
			mcuPackageItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmcuPackageItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

			expect(updatedmcuPackageItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related MCU Package Items entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.mcuPackageItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const mcuPackageItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model')).length;

			expect(mcuPackageItemsRemoveButtonCount).toEqual(staffWithId.mcuPackageItems.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate  Discharge Resumes relation.
	*
	* The button should only exist if medicalCertificateDischargeResumesMultiCrudActive is true
	*/
	it ('Renders Medical Certificate  Discharge Resumes Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateDischargeResumesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateDischargeResumesButton).toEqual(component.medicalCertificateDischargeResumesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate  Discharge Resumes', fakeAsync(() => {
		const medicalCertificateDischargeResumesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateDischargeResumesButton).toEqual(component.medicalCertificateDischargeResumesMultiCrudActive);

		if (component.medicalCertificateDischargeResumesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateDischargeResumesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumesDisplayName + ' from Model')).length;

			medicalCertificateDischargeResumesButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateDischargeResumesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumesDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateDischargeResumesRemoveButtonCount).toEqual(initialMedicalCertificateDischargeResumesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate  Discharge Resumes button', () => {
		const medicalCertificateDischargeResumesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateDischargeResumesButton).toEqual(component.medicalCertificateDischargeResumesMultiCrudActive);

		if (component.medicalCertificateDischargeResumesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateDischargeResumesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateDischargeResumesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateDischargeResumesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateDischargeResumesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumesDisplayName + ' from Model'));

			expect(actualMedicalCertificateDischargeResumesRemoveButtons.length).toEqual(initialMedicalCertificateDischargeResumesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Certificate  Discharge Resumes button when one has already been added', () => {

		const medicalCertificateDischargeResumesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateDischargeResumesButton).toEqual(component.medicalCertificateDischargeResumesMultiCrudActive);

		if (component.medicalCertificateDischargeResumesMultiCrudActive) {
			medicalCertificateDischargeResumesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateDischargeResumesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumesDisplayName + ' to Model'));

			expect(updatedmedicalCertificateDischargeResumesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Certificate  Discharge Resumes entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateDischargeResumesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateDischargeResumesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumesDisplayName + ' from Model')).length;

			expect(medicalCertificateDischargeResumesRemoveButtonCount).toEqual(staffWithId.medicalCertificateDischargeResumes.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate Births relation.
	*
	* The button should only exist if medicalCertificateBirthsMultiCrudActive is true
	*/
	it ('Renders Medical Certificate Births Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateBirthsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateBirthsButton).toEqual(component.medicalCertificateBirthsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate Births', fakeAsync(() => {
		const medicalCertificateBirthsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateBirthsButton).toEqual(component.medicalCertificateBirthsMultiCrudActive);

		if (component.medicalCertificateBirthsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateBirthsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthsDisplayName + ' from Model')).length;

			medicalCertificateBirthsButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateBirthsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthsDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateBirthsRemoveButtonCount).toEqual(initialMedicalCertificateBirthsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate Births button', () => {
		const medicalCertificateBirthsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateBirthsButton).toEqual(component.medicalCertificateBirthsMultiCrudActive);

		if (component.medicalCertificateBirthsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateBirthsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateBirthsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateBirthsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateBirthsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthsDisplayName + ' from Model'));

			expect(actualMedicalCertificateBirthsRemoveButtons.length).toEqual(initialMedicalCertificateBirthsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Certificate Births button when one has already been added', () => {

		const medicalCertificateBirthsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateBirthsButton).toEqual(component.medicalCertificateBirthsMultiCrudActive);

		if (component.medicalCertificateBirthsMultiCrudActive) {
			medicalCertificateBirthsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateBirthsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthsDisplayName + ' to Model'));

			expect(updatedmedicalCertificateBirthsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Certificate Births entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateBirthsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateBirthsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthsDisplayName + ' from Model')).length;

			expect(medicalCertificateBirthsRemoveButtonCount).toEqual(staffWithId.medicalCertificateBirths.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate Hospitalizations relation.
	*
	* The button should only exist if medicalCertificateHospitalizationsMultiCrudActive is true
	*/
	it ('Renders Medical Certificate Hospitalizations Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateHospitalizationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateHospitalizationsButton).toEqual(component.medicalCertificateHospitalizationsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate Hospitalizations', fakeAsync(() => {
		const medicalCertificateHospitalizationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateHospitalizationsButton).toEqual(component.medicalCertificateHospitalizationsMultiCrudActive);

		if (component.medicalCertificateHospitalizationsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateHospitalizationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationsDisplayName + ' from Model')).length;

			medicalCertificateHospitalizationsButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateHospitalizationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationsDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateHospitalizationsRemoveButtonCount).toEqual(initialMedicalCertificateHospitalizationsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate Hospitalizations button', () => {
		const medicalCertificateHospitalizationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateHospitalizationsButton).toEqual(component.medicalCertificateHospitalizationsMultiCrudActive);

		if (component.medicalCertificateHospitalizationsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateHospitalizationsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateHospitalizationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateHospitalizationsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateHospitalizationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationsDisplayName + ' from Model'));

			expect(actualMedicalCertificateHospitalizationsRemoveButtons.length).toEqual(initialMedicalCertificateHospitalizationsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Certificate Hospitalizations button when one has already been added', () => {

		const medicalCertificateHospitalizationsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateHospitalizationsButton).toEqual(component.medicalCertificateHospitalizationsMultiCrudActive);

		if (component.medicalCertificateHospitalizationsMultiCrudActive) {
			medicalCertificateHospitalizationsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateHospitalizationsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationsDisplayName + ' to Model'));

			expect(updatedmedicalCertificateHospitalizationsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Certificate Hospitalizations entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateHospitalizationsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateHospitalizationsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationsDisplayName + ' from Model')).length;

			expect(medicalCertificateHospitalizationsRemoveButtonCount).toEqual(staffWithId.medicalCertificateHospitalizations.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Examination Record Discharge Summarys relation.
	*
	* The button should only exist if medicalExaminationRecordDischargeSummarysMultiCrudActive is true
	*/
	it ('Renders Medical Examination Record Discharge Summarys Add Entity button in create mode', fakeAsync(() => {
		const medicalExaminationRecordDischargeSummarysButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalExaminationRecordDischargeSummarysButton).toEqual(component.medicalExaminationRecordDischargeSummarysMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Examination Record Discharge Summarys', fakeAsync(() => {
		const medicalExaminationRecordDischargeSummarysButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalExaminationRecordDischargeSummarysButton).toEqual(component.medicalExaminationRecordDischargeSummarysMultiCrudActive);

		if (component.medicalExaminationRecordDischargeSummarysMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalExaminationRecordDischargeSummarysRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' from Model')).length;

			medicalExaminationRecordDischargeSummarysButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalExaminationRecordDischargeSummarysRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' from Model')).length;

			expect(actualMedicalExaminationRecordDischargeSummarysRemoveButtonCount).toEqual(initialMedicalExaminationRecordDischargeSummarysRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Examination Record Discharge Summarys button', () => {
		const medicalExaminationRecordDischargeSummarysButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalExaminationRecordDischargeSummarysButton).toEqual(component.medicalExaminationRecordDischargeSummarysMultiCrudActive);

		if (component.medicalExaminationRecordDischargeSummarysMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalExaminationRecordDischargeSummarysButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalExaminationRecordDischargeSummarysRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalExaminationRecordDischargeSummarysRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalExaminationRecordDischargeSummarysRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' from Model'));

			expect(actualMedicalExaminationRecordDischargeSummarysRemoveButtons.length).toEqual(initialMedicalExaminationRecordDischargeSummarysRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Examination Record Discharge Summarys button when one has already been added', () => {

		const medicalExaminationRecordDischargeSummarysButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalExaminationRecordDischargeSummarysButton).toEqual(component.medicalExaminationRecordDischargeSummarysMultiCrudActive);

		if (component.medicalExaminationRecordDischargeSummarysMultiCrudActive) {
			medicalExaminationRecordDischargeSummarysButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalExaminationRecordDischargeSummarysButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' to Model'));

			expect(updatedmedicalExaminationRecordDischargeSummarysButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Examination Record Discharge Summarys entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalExaminationRecordDischargeSummarysMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalExaminationRecordDischargeSummarysRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalExaminationRecordDischargeSummarysDisplayName + ' from Model')).length;

			expect(medicalExaminationRecordDischargeSummarysRemoveButtonCount).toEqual(staffWithId.medicalExaminationRecordDischargeSummarys.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Record Transcriber relation.
	*
	* The button should only exist if medicalRecordTranscriberMultiCrudActive is true
	*/
	it ('Renders Medical Record Transcriber Add Entity button in create mode', fakeAsync(() => {
		const medicalRecordTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordTranscriberDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalRecordTranscriberButton).toEqual(component.medicalRecordTranscriberMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Record Transcriber', fakeAsync(() => {
		const medicalRecordTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalRecordTranscriberButton).toEqual(component.medicalRecordTranscriberMultiCrudActive);

		if (component.medicalRecordTranscriberMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalRecordTranscriberRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordTranscriberDisplayName + ' from Model')).length;

			medicalRecordTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalRecordTranscriberRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordTranscriberDisplayName + ' from Model')).length;

			expect(actualMedicalRecordTranscriberRemoveButtonCount).toEqual(initialMedicalRecordTranscriberRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Record Transcriber button', () => {
		const medicalRecordTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalRecordTranscriberButton).toEqual(component.medicalRecordTranscriberMultiCrudActive);

		if (component.medicalRecordTranscriberMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalRecordTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalRecordTranscriberRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordTranscriberDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalRecordTranscriberRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalRecordTranscriberRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordTranscriberDisplayName + ' from Model'));

			expect(actualMedicalRecordTranscriberRemoveButtons.length).toEqual(initialMedicalRecordTranscriberRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Record Transcriber button when one has already been added', () => {

		const medicalRecordTranscriberButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalRecordTranscriberButton).toEqual(component.medicalRecordTranscriberMultiCrudActive);

		if (component.medicalRecordTranscriberMultiCrudActive) {
			medicalRecordTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalRecordTranscriberButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalRecordTranscriberDisplayName + ' to Model'));

			expect(updatedmedicalRecordTranscriberButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Record Transcriber entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalRecordTranscriberMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalRecordTranscriberRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalRecordTranscriberDisplayName + ' from Model')).length;

			expect(medicalRecordTranscriberRemoveButtonCount).toEqual(staffWithId.medicalRecordTranscriber.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Staff of Medical Attendances certificate relation.
	*
	* The button should only exist if medicalStaffOfMedicalAttendancesCertificateMultiCrudActive is true
	*/
	it ('Renders Medical Staff of Medical Attendances certificate Add Entity button in create mode', fakeAsync(() => {
		const medicalStaffOfMedicalAttendancesCertificateButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalStaffOfMedicalAttendancesCertificateButton).toEqual(component.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Staff of Medical Attendances certificate', fakeAsync(() => {
		const medicalStaffOfMedicalAttendancesCertificateButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfMedicalAttendancesCertificateButton).toEqual(component.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive);

		if (component.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalStaffOfMedicalAttendancesCertificateRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' from Model')).length;

			medicalStaffOfMedicalAttendancesCertificateButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfMedicalAttendancesCertificateRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' from Model')).length;

			expect(actualMedicalStaffOfMedicalAttendancesCertificateRemoveButtonCount).toEqual(initialMedicalStaffOfMedicalAttendancesCertificateRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Staff of Medical Attendances certificate button', () => {
		const medicalStaffOfMedicalAttendancesCertificateButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfMedicalAttendancesCertificateButton).toEqual(component.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive);

		if (component.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalStaffOfMedicalAttendancesCertificateButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalStaffOfMedicalAttendancesCertificateRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalStaffOfMedicalAttendancesCertificateRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfMedicalAttendancesCertificateRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' from Model'));

			expect(actualMedicalStaffOfMedicalAttendancesCertificateRemoveButtons.length).toEqual(initialMedicalStaffOfMedicalAttendancesCertificateRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Staff of Medical Attendances certificate button when one has already been added', () => {

		const medicalStaffOfMedicalAttendancesCertificateButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfMedicalAttendancesCertificateButton).toEqual(component.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive);

		if (component.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive) {
			medicalStaffOfMedicalAttendancesCertificateButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalStaffOfMedicalAttendancesCertificateButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' to Model'));

			expect(updatedmedicalStaffOfMedicalAttendancesCertificateButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Staff of Medical Attendances certificate entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalStaffOfMedicalAttendancesCertificateRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMedicalAttendancesCertificateDisplayName + ' from Model')).length;

			expect(medicalStaffOfMedicalAttendancesCertificateRemoveButtonCount).toEqual(staffWithId.medicalStaffOfMedicalAttendancesCertificate.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Staff of Mental Healths relation.
	*
	* The button should only exist if medicalStaffOfMentalHealthsMultiCrudActive is true
	*/
	it ('Renders Medical Staff of Mental Healths Add Entity button in create mode', fakeAsync(() => {
		const medicalStaffOfMentalHealthsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMentalHealthsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalStaffOfMentalHealthsButton).toEqual(component.medicalStaffOfMentalHealthsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Staff of Mental Healths', fakeAsync(() => {
		const medicalStaffOfMentalHealthsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMentalHealthsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfMentalHealthsButton).toEqual(component.medicalStaffOfMentalHealthsMultiCrudActive);

		if (component.medicalStaffOfMentalHealthsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalStaffOfMentalHealthsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMentalHealthsDisplayName + ' from Model')).length;

			medicalStaffOfMentalHealthsButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfMentalHealthsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMentalHealthsDisplayName + ' from Model')).length;

			expect(actualMedicalStaffOfMentalHealthsRemoveButtonCount).toEqual(initialMedicalStaffOfMentalHealthsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Staff of Mental Healths button', () => {
		const medicalStaffOfMentalHealthsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMentalHealthsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfMentalHealthsButton).toEqual(component.medicalStaffOfMentalHealthsMultiCrudActive);

		if (component.medicalStaffOfMentalHealthsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalStaffOfMentalHealthsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalStaffOfMentalHealthsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMentalHealthsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalStaffOfMentalHealthsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfMentalHealthsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMentalHealthsDisplayName + ' from Model'));

			expect(actualMedicalStaffOfMentalHealthsRemoveButtons.length).toEqual(initialMedicalStaffOfMentalHealthsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Staff of Mental Healths button when one has already been added', () => {

		const medicalStaffOfMentalHealthsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMentalHealthsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfMentalHealthsButton).toEqual(component.medicalStaffOfMentalHealthsMultiCrudActive);

		if (component.medicalStaffOfMentalHealthsMultiCrudActive) {
			medicalStaffOfMentalHealthsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalStaffOfMentalHealthsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfMentalHealthsDisplayName + ' to Model'));

			expect(updatedmedicalStaffOfMentalHealthsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Staff of Mental Healths entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalStaffOfMentalHealthsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalStaffOfMentalHealthsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfMentalHealthsDisplayName + ' from Model')).length;

			expect(medicalStaffOfMentalHealthsRemoveButtonCount).toEqual(staffWithId.medicalStaffOfMentalHealths.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Staff of Physical Healths relation.
	*
	* The button should only exist if medicalStaffOfPhysicalHealthsMultiCrudActive is true
	*/
	it ('Renders Medical Staff of Physical Healths Add Entity button in create mode', fakeAsync(() => {
		const medicalStaffOfPhysicalHealthsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalStaffOfPhysicalHealthsButton).toEqual(component.medicalStaffOfPhysicalHealthsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Staff of Physical Healths', fakeAsync(() => {
		const medicalStaffOfPhysicalHealthsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfPhysicalHealthsButton).toEqual(component.medicalStaffOfPhysicalHealthsMultiCrudActive);

		if (component.medicalStaffOfPhysicalHealthsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalStaffOfPhysicalHealthsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' from Model')).length;

			medicalStaffOfPhysicalHealthsButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfPhysicalHealthsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' from Model')).length;

			expect(actualMedicalStaffOfPhysicalHealthsRemoveButtonCount).toEqual(initialMedicalStaffOfPhysicalHealthsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Staff of Physical Healths button', () => {
		const medicalStaffOfPhysicalHealthsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfPhysicalHealthsButton).toEqual(component.medicalStaffOfPhysicalHealthsMultiCrudActive);

		if (component.medicalStaffOfPhysicalHealthsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalStaffOfPhysicalHealthsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalStaffOfPhysicalHealthsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalStaffOfPhysicalHealthsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfPhysicalHealthsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' from Model'));

			expect(actualMedicalStaffOfPhysicalHealthsRemoveButtons.length).toEqual(initialMedicalStaffOfPhysicalHealthsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Staff of Physical Healths button when one has already been added', () => {

		const medicalStaffOfPhysicalHealthsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfPhysicalHealthsButton).toEqual(component.medicalStaffOfPhysicalHealthsMultiCrudActive);

		if (component.medicalStaffOfPhysicalHealthsMultiCrudActive) {
			medicalStaffOfPhysicalHealthsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalStaffOfPhysicalHealthsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' to Model'));

			expect(updatedmedicalStaffOfPhysicalHealthsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Staff of Physical Healths entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalStaffOfPhysicalHealthsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalStaffOfPhysicalHealthsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfPhysicalHealthsDisplayName + ' from Model')).length;

			expect(medicalStaffOfPhysicalHealthsRemoveButtonCount).toEqual(staffWithId.medicalStaffOfPhysicalHealths.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Staff of Restricted Works certificate relation.
	*
	* The button should only exist if medicalStaffOfRestrictedWorksCertificateMultiCrudActive is true
	*/
	it ('Renders Medical Staff of Restricted Works certificate Add Entity button in create mode', fakeAsync(() => {
		const medicalStaffOfRestrictedWorksCertificateButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalStaffOfRestrictedWorksCertificateButton).toEqual(component.medicalStaffOfRestrictedWorksCertificateMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Staff of Restricted Works certificate', fakeAsync(() => {
		const medicalStaffOfRestrictedWorksCertificateButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfRestrictedWorksCertificateButton).toEqual(component.medicalStaffOfRestrictedWorksCertificateMultiCrudActive);

		if (component.medicalStaffOfRestrictedWorksCertificateMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalStaffOfRestrictedWorksCertificateRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' from Model')).length;

			medicalStaffOfRestrictedWorksCertificateButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfRestrictedWorksCertificateRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' from Model')).length;

			expect(actualMedicalStaffOfRestrictedWorksCertificateRemoveButtonCount).toEqual(initialMedicalStaffOfRestrictedWorksCertificateRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Staff of Restricted Works certificate button', () => {
		const medicalStaffOfRestrictedWorksCertificateButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfRestrictedWorksCertificateButton).toEqual(component.medicalStaffOfRestrictedWorksCertificateMultiCrudActive);

		if (component.medicalStaffOfRestrictedWorksCertificateMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalStaffOfRestrictedWorksCertificateButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalStaffOfRestrictedWorksCertificateRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalStaffOfRestrictedWorksCertificateRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfRestrictedWorksCertificateRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' from Model'));

			expect(actualMedicalStaffOfRestrictedWorksCertificateRemoveButtons.length).toEqual(initialMedicalStaffOfRestrictedWorksCertificateRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Staff of Restricted Works certificate button when one has already been added', () => {

		const medicalStaffOfRestrictedWorksCertificateButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfRestrictedWorksCertificateButton).toEqual(component.medicalStaffOfRestrictedWorksCertificateMultiCrudActive);

		if (component.medicalStaffOfRestrictedWorksCertificateMultiCrudActive) {
			medicalStaffOfRestrictedWorksCertificateButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalStaffOfRestrictedWorksCertificateButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' to Model'));

			expect(updatedmedicalStaffOfRestrictedWorksCertificateButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Staff of Restricted Works certificate entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalStaffOfRestrictedWorksCertificateMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalStaffOfRestrictedWorksCertificateRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfRestrictedWorksCertificateDisplayName + ' from Model')).length;

			expect(medicalStaffOfRestrictedWorksCertificateRemoveButtonCount).toEqual(staffWithId.medicalStaffOfRestrictedWorksCertificate.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Staff of Sick Leaves certificate relation.
	*
	* The button should only exist if medicalStaffOfSickLeavesCertificateMultiCrudActive is true
	*/
	it ('Renders Medical Staff of Sick Leaves certificate Add Entity button in create mode', fakeAsync(() => {
		const medicalStaffOfSickLeavesCertificateButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalStaffOfSickLeavesCertificateButton).toEqual(component.medicalStaffOfSickLeavesCertificateMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Staff of Sick Leaves certificate', fakeAsync(() => {
		const medicalStaffOfSickLeavesCertificateButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfSickLeavesCertificateButton).toEqual(component.medicalStaffOfSickLeavesCertificateMultiCrudActive);

		if (component.medicalStaffOfSickLeavesCertificateMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalStaffOfSickLeavesCertificateRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' from Model')).length;

			medicalStaffOfSickLeavesCertificateButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfSickLeavesCertificateRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' from Model')).length;

			expect(actualMedicalStaffOfSickLeavesCertificateRemoveButtonCount).toEqual(initialMedicalStaffOfSickLeavesCertificateRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Staff of Sick Leaves certificate button', () => {
		const medicalStaffOfSickLeavesCertificateButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfSickLeavesCertificateButton).toEqual(component.medicalStaffOfSickLeavesCertificateMultiCrudActive);

		if (component.medicalStaffOfSickLeavesCertificateMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalStaffOfSickLeavesCertificateButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalStaffOfSickLeavesCertificateRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalStaffOfSickLeavesCertificateRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalStaffOfSickLeavesCertificateRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' from Model'));

			expect(actualMedicalStaffOfSickLeavesCertificateRemoveButtons.length).toEqual(initialMedicalStaffOfSickLeavesCertificateRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Staff of Sick Leaves certificate button when one has already been added', () => {

		const medicalStaffOfSickLeavesCertificateButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalStaffOfSickLeavesCertificateButton).toEqual(component.medicalStaffOfSickLeavesCertificateMultiCrudActive);

		if (component.medicalStaffOfSickLeavesCertificateMultiCrudActive) {
			medicalStaffOfSickLeavesCertificateButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalStaffOfSickLeavesCertificateButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' to Model'));

			expect(updatedmedicalStaffOfSickLeavesCertificateButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Staff of Sick Leaves certificate entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalStaffOfSickLeavesCertificateMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalStaffOfSickLeavesCertificateRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalStaffOfSickLeavesCertificateDisplayName + ' from Model')).length;

			expect(medicalStaffOfSickLeavesCertificateRemoveButtonCount).toEqual(staffWithId.medicalStaffOfSickLeavesCertificate.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medication Administered Hisotries relation.
	*
	* The button should only exist if medicationAdministeredHisotriesMultiCrudActive is true
	*/
	it ('Renders Medication Administered Hisotries Add Entity button in create mode', fakeAsync(() => {
		const medicationAdministeredHisotriesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationAdministeredHisotriesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicationAdministeredHisotriesButton).toEqual(component.medicationAdministeredHisotriesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medication Administered Hisotries', fakeAsync(() => {
		const medicationAdministeredHisotriesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationAdministeredHisotriesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationAdministeredHisotriesButton).toEqual(component.medicationAdministeredHisotriesMultiCrudActive);

		if (component.medicationAdministeredHisotriesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicationAdministeredHisotriesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationAdministeredHisotriesDisplayName + ' from Model')).length;

			medicationAdministeredHisotriesButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicationAdministeredHisotriesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationAdministeredHisotriesDisplayName + ' from Model')).length;

			expect(actualMedicationAdministeredHisotriesRemoveButtonCount).toEqual(initialMedicationAdministeredHisotriesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medication Administered Hisotries button', () => {
		const medicationAdministeredHisotriesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationAdministeredHisotriesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationAdministeredHisotriesButton).toEqual(component.medicationAdministeredHisotriesMultiCrudActive);

		if (component.medicationAdministeredHisotriesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicationAdministeredHisotriesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicationAdministeredHisotriesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationAdministeredHisotriesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicationAdministeredHisotriesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicationAdministeredHisotriesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationAdministeredHisotriesDisplayName + ' from Model'));

			expect(actualMedicationAdministeredHisotriesRemoveButtons.length).toEqual(initialMedicationAdministeredHisotriesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medication Administered Hisotries button when one has already been added', () => {

		const medicationAdministeredHisotriesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationAdministeredHisotriesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicationAdministeredHisotriesButton).toEqual(component.medicationAdministeredHisotriesMultiCrudActive);

		if (component.medicationAdministeredHisotriesMultiCrudActive) {
			medicationAdministeredHisotriesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicationAdministeredHisotriesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicationAdministeredHisotriesDisplayName + ' to Model'));

			expect(updatedmedicationAdministeredHisotriesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medication Administered Hisotries entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicationAdministeredHisotriesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicationAdministeredHisotriesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicationAdministeredHisotriesDisplayName + ' from Model')).length;

			expect(medicationAdministeredHisotriesRemoveButtonCount).toEqual(staffWithId.medicationAdministeredHisotries.length);
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
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
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

			expect(medicationHeadersRemoveButtonCount).toEqual(staffWithId.medicationHeaders.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Midwives relation.
	*
	* The button should only exist if midwivesMultiCrudActive is true
	*/
	it ('Renders Midwives Add Entity button in create mode', fakeAsync(() => {
		const midwivesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwivesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!midwivesButton).toEqual(component.midwivesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Midwives', fakeAsync(() => {
		const midwivesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwivesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!midwivesButton).toEqual(component.midwivesMultiCrudActive);

		if (component.midwivesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMidwivesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwivesDisplayName + ' from Model')).length;

			midwivesButton.nativeElement.click();
			fixture.detectChanges();

			const actualMidwivesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwivesDisplayName + ' from Model')).length;

			expect(actualMidwivesRemoveButtonCount).toEqual(initialMidwivesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Midwives button', () => {
		const midwivesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwivesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!midwivesButton).toEqual(component.midwivesMultiCrudActive);

		if (component.midwivesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			midwivesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMidwivesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwivesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMidwivesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMidwivesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwivesDisplayName + ' from Model'));

			expect(actualMidwivesRemoveButtons.length).toEqual(initialMidwivesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Midwives button when one has already been added', () => {

		const midwivesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwivesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!midwivesButton).toEqual(component.midwivesMultiCrudActive);

		if (component.midwivesMultiCrudActive) {
			midwivesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmidwivesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.midwivesDisplayName + ' to Model'));

			expect(updatedmidwivesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Midwives entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.midwivesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const midwivesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.midwivesDisplayName + ' from Model')).length;

			expect(midwivesRemoveButtonCount).toEqual(staffWithId.midwives.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Nurse relation.
	*
	* The button should only exist if nurseMultiCrudActive is true
	*/
	it ('Renders Nurse Add Entity button in create mode', fakeAsync(() => {
		const nurseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!nurseButton).toEqual(component.nurseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Nurse', fakeAsync(() => {
		const nurseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nurseButton).toEqual(component.nurseMultiCrudActive);

		if (component.nurseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialNurseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseDisplayName + ' from Model')).length;

			nurseButton.nativeElement.click();
			fixture.detectChanges();

			const actualNurseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseDisplayName + ' from Model')).length;

			expect(actualNurseRemoveButtonCount).toEqual(initialNurseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Nurse button', () => {
		const nurseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nurseButton).toEqual(component.nurseMultiCrudActive);

		if (component.nurseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			nurseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialNurseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialNurseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualNurseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseDisplayName + ' from Model'));

			expect(actualNurseRemoveButtons.length).toEqual(initialNurseRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Nurse button when one has already been added', () => {

		const nurseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nurseButton).toEqual(component.nurseMultiCrudActive);

		if (component.nurseMultiCrudActive) {
			nurseButton.nativeElement.click();
			fixture.detectChanges();

			const updatednurseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.nurseDisplayName + ' to Model'));

			expect(updatednurseButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Nurse entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.nurseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const nurseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nurseDisplayName + ' from Model')).length;

			expect(nurseRemoveButtonCount).toEqual(staffWithId.nurse.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Nursing Detail Surgical Nursing relation.
	*
	* The button should only exist if nursingDetailSurgicalNursingMultiCrudActive is true
	*/
	it ('Renders Nursing Detail Surgical Nursing Add Entity button in create mode', fakeAsync(() => {
		const nursingDetailSurgicalNursingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailSurgicalNursingDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!nursingDetailSurgicalNursingButton).toEqual(component.nursingDetailSurgicalNursingMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Nursing Detail Surgical Nursing', fakeAsync(() => {
		const nursingDetailSurgicalNursingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailSurgicalNursingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nursingDetailSurgicalNursingButton).toEqual(component.nursingDetailSurgicalNursingMultiCrudActive);

		if (component.nursingDetailSurgicalNursingMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialNursingDetailSurgicalNursingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailSurgicalNursingDisplayName + ' from Model')).length;

			nursingDetailSurgicalNursingButton.nativeElement.click();
			fixture.detectChanges();

			const actualNursingDetailSurgicalNursingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailSurgicalNursingDisplayName + ' from Model')).length;

			expect(actualNursingDetailSurgicalNursingRemoveButtonCount).toEqual(initialNursingDetailSurgicalNursingRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Nursing Detail Surgical Nursing button', () => {
		const nursingDetailSurgicalNursingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailSurgicalNursingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nursingDetailSurgicalNursingButton).toEqual(component.nursingDetailSurgicalNursingMultiCrudActive);

		if (component.nursingDetailSurgicalNursingMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			nursingDetailSurgicalNursingButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialNursingDetailSurgicalNursingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailSurgicalNursingDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialNursingDetailSurgicalNursingRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualNursingDetailSurgicalNursingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailSurgicalNursingDisplayName + ' from Model'));

			expect(actualNursingDetailSurgicalNursingRemoveButtons.length).toEqual(initialNursingDetailSurgicalNursingRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Nursing Detail Surgical Nursing button when one has already been added', () => {

		const nursingDetailSurgicalNursingButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailSurgicalNursingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nursingDetailSurgicalNursingButton).toEqual(component.nursingDetailSurgicalNursingMultiCrudActive);

		if (component.nursingDetailSurgicalNursingMultiCrudActive) {
			nursingDetailSurgicalNursingButton.nativeElement.click();
			fixture.detectChanges();

			const updatednursingDetailSurgicalNursingButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailSurgicalNursingDisplayName + ' to Model'));

			expect(updatednursingDetailSurgicalNursingButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Nursing Detail Surgical Nursing entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.nursingDetailSurgicalNursingMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const nursingDetailSurgicalNursingRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailSurgicalNursingDisplayName + ' from Model')).length;

			expect(nursingDetailSurgicalNursingRemoveButtonCount).toEqual(staffWithId.nursingDetailSurgicalNursing.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Nursing Details Anesthesia Nursing relation.
	*
	* The button should only exist if nursingDetailsAnesthesiaNursingMultiCrudActive is true
	*/
	it ('Renders Nursing Details Anesthesia Nursing Add Entity button in create mode', fakeAsync(() => {
		const nursingDetailsAnesthesiaNursingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!nursingDetailsAnesthesiaNursingButton).toEqual(component.nursingDetailsAnesthesiaNursingMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Nursing Details Anesthesia Nursing', fakeAsync(() => {
		const nursingDetailsAnesthesiaNursingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nursingDetailsAnesthesiaNursingButton).toEqual(component.nursingDetailsAnesthesiaNursingMultiCrudActive);

		if (component.nursingDetailsAnesthesiaNursingMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialNursingDetailsAnesthesiaNursingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' from Model')).length;

			nursingDetailsAnesthesiaNursingButton.nativeElement.click();
			fixture.detectChanges();

			const actualNursingDetailsAnesthesiaNursingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' from Model')).length;

			expect(actualNursingDetailsAnesthesiaNursingRemoveButtonCount).toEqual(initialNursingDetailsAnesthesiaNursingRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Nursing Details Anesthesia Nursing button', () => {
		const nursingDetailsAnesthesiaNursingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nursingDetailsAnesthesiaNursingButton).toEqual(component.nursingDetailsAnesthesiaNursingMultiCrudActive);

		if (component.nursingDetailsAnesthesiaNursingMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			nursingDetailsAnesthesiaNursingButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialNursingDetailsAnesthesiaNursingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialNursingDetailsAnesthesiaNursingRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualNursingDetailsAnesthesiaNursingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' from Model'));

			expect(actualNursingDetailsAnesthesiaNursingRemoveButtons.length).toEqual(initialNursingDetailsAnesthesiaNursingRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Nursing Details Anesthesia Nursing button when one has already been added', () => {

		const nursingDetailsAnesthesiaNursingButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!nursingDetailsAnesthesiaNursingButton).toEqual(component.nursingDetailsAnesthesiaNursingMultiCrudActive);

		if (component.nursingDetailsAnesthesiaNursingMultiCrudActive) {
			nursingDetailsAnesthesiaNursingButton.nativeElement.click();
			fixture.detectChanges();

			const updatednursingDetailsAnesthesiaNursingButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' to Model'));

			expect(updatednursingDetailsAnesthesiaNursingButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Nursing Details Anesthesia Nursing entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.nursingDetailsAnesthesiaNursingMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const nursingDetailsAnesthesiaNursingRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.nursingDetailsAnesthesiaNursingDisplayName + ' from Model')).length;

			expect(nursingDetailsAnesthesiaNursingRemoveButtonCount).toEqual(staffWithId.nursingDetailsAnesthesiaNursing.length);
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
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
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

			expect(patientConsentsRemoveButtonCount).toEqual(staffWithId.patientConsents.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Vital Informations relation.
	*
	* The button should only exist if patientVitalInformationsMultiCrudActive is true
	*/
	it ('Renders Patient Vital Informations Add Entity button in create mode', fakeAsync(() => {
		const patientVitalInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVitalInformationsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientVitalInformationsButton).toEqual(component.patientVitalInformationsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Vital Informations', fakeAsync(() => {
		const patientVitalInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVitalInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVitalInformationsButton).toEqual(component.patientVitalInformationsMultiCrudActive);

		if (component.patientVitalInformationsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientVitalInformationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVitalInformationsDisplayName + ' from Model')).length;

			patientVitalInformationsButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientVitalInformationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVitalInformationsDisplayName + ' from Model')).length;

			expect(actualPatientVitalInformationsRemoveButtonCount).toEqual(initialPatientVitalInformationsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Vital Informations button', () => {
		const patientVitalInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVitalInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVitalInformationsButton).toEqual(component.patientVitalInformationsMultiCrudActive);

		if (component.patientVitalInformationsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientVitalInformationsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientVitalInformationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVitalInformationsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientVitalInformationsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientVitalInformationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVitalInformationsDisplayName + ' from Model'));

			expect(actualPatientVitalInformationsRemoveButtons.length).toEqual(initialPatientVitalInformationsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Patient Vital Informations button when one has already been added', () => {

		const patientVitalInformationsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVitalInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientVitalInformationsButton).toEqual(component.patientVitalInformationsMultiCrudActive);

		if (component.patientVitalInformationsMultiCrudActive) {
			patientVitalInformationsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientVitalInformationsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientVitalInformationsDisplayName + ' to Model'));

			expect(updatedpatientVitalInformationsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Patient Vital Informations entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientVitalInformationsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientVitalInformationsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientVitalInformationsDisplayName + ' from Model')).length;

			expect(patientVitalInformationsRemoveButtonCount).toEqual(staffWithId.patientVitalInformations.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Pediatrician In Charge relation.
	*
	* The button should only exist if pediatricianInChargeMultiCrudActive is true
	*/
	it ('Renders Pediatrician In Charge Add Entity button in create mode', fakeAsync(() => {
		const pediatricianInChargeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pediatricianInChargeDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!pediatricianInChargeButton).toEqual(component.pediatricianInChargeMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Pediatrician In Charge', fakeAsync(() => {
		const pediatricianInChargeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pediatricianInChargeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pediatricianInChargeButton).toEqual(component.pediatricianInChargeMultiCrudActive);

		if (component.pediatricianInChargeMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPediatricianInChargeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pediatricianInChargeDisplayName + ' from Model')).length;

			pediatricianInChargeButton.nativeElement.click();
			fixture.detectChanges();

			const actualPediatricianInChargeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pediatricianInChargeDisplayName + ' from Model')).length;

			expect(actualPediatricianInChargeRemoveButtonCount).toEqual(initialPediatricianInChargeRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Pediatrician In Charge button', () => {
		const pediatricianInChargeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pediatricianInChargeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pediatricianInChargeButton).toEqual(component.pediatricianInChargeMultiCrudActive);

		if (component.pediatricianInChargeMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			pediatricianInChargeButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPediatricianInChargeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pediatricianInChargeDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPediatricianInChargeRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPediatricianInChargeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pediatricianInChargeDisplayName + ' from Model'));

			expect(actualPediatricianInChargeRemoveButtons.length).toEqual(initialPediatricianInChargeRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Pediatrician In Charge button when one has already been added', () => {

		const pediatricianInChargeButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.pediatricianInChargeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pediatricianInChargeButton).toEqual(component.pediatricianInChargeMultiCrudActive);

		if (component.pediatricianInChargeMultiCrudActive) {
			pediatricianInChargeButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpediatricianInChargeButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.pediatricianInChargeDisplayName + ' to Model'));

			expect(updatedpediatricianInChargeButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Pediatrician In Charge entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.pediatricianInChargeMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const pediatricianInChargeRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pediatricianInChargeDisplayName + ' from Model')).length;

			expect(pediatricianInChargeRemoveButtonCount).toEqual(staffWithId.pediatricianInCharge.length);
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
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
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

			expect(prescriptionHeadersRemoveButtonCount).toEqual(staffWithId.prescriptionHeaders.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Process Workflow Logs relation.
	*
	* The button should only exist if processWorkflowLogsMultiCrudActive is true
	*/
	it ('Renders Process Workflow Logs Add Entity button in create mode', fakeAsync(() => {
		const processWorkflowLogsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.processWorkflowLogsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!processWorkflowLogsButton).toEqual(component.processWorkflowLogsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Process Workflow Logs', fakeAsync(() => {
		const processWorkflowLogsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.processWorkflowLogsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!processWorkflowLogsButton).toEqual(component.processWorkflowLogsMultiCrudActive);

		if (component.processWorkflowLogsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialProcessWorkflowLogsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.processWorkflowLogsDisplayName + ' from Model')).length;

			processWorkflowLogsButton.nativeElement.click();
			fixture.detectChanges();

			const actualProcessWorkflowLogsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.processWorkflowLogsDisplayName + ' from Model')).length;

			expect(actualProcessWorkflowLogsRemoveButtonCount).toEqual(initialProcessWorkflowLogsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Process Workflow Logs button', () => {
		const processWorkflowLogsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.processWorkflowLogsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!processWorkflowLogsButton).toEqual(component.processWorkflowLogsMultiCrudActive);

		if (component.processWorkflowLogsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			processWorkflowLogsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialProcessWorkflowLogsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.processWorkflowLogsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialProcessWorkflowLogsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualProcessWorkflowLogsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.processWorkflowLogsDisplayName + ' from Model'));

			expect(actualProcessWorkflowLogsRemoveButtons.length).toEqual(initialProcessWorkflowLogsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Process Workflow Logs button when one has already been added', () => {

		const processWorkflowLogsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.processWorkflowLogsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!processWorkflowLogsButton).toEqual(component.processWorkflowLogsMultiCrudActive);

		if (component.processWorkflowLogsMultiCrudActive) {
			processWorkflowLogsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedprocessWorkflowLogsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.processWorkflowLogsDisplayName + ' to Model'));

			expect(updatedprocessWorkflowLogsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Process Workflow Logs entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.processWorkflowLogsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const processWorkflowLogsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.processWorkflowLogsDisplayName + ' from Model')).length;

			expect(processWorkflowLogsRemoveButtonCount).toEqual(staffWithId.processWorkflowLogs.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Registrations relation.
	*
	* The button should only exist if registrationsMultiCrudActive is true
	*/
	it ('Renders Registrations Add Entity button in create mode', fakeAsync(() => {
		const registrationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!registrationsButton).toEqual(component.registrationsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Registrations', fakeAsync(() => {
		const registrationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationsButton).toEqual(component.registrationsMultiCrudActive);

		if (component.registrationsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRegistrationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model')).length;

			registrationsButton.nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model')).length;

			expect(actualRegistrationsRemoveButtonCount).toEqual(initialRegistrationsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Registrations button', () => {
		const registrationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationsButton).toEqual(component.registrationsMultiCrudActive);

		if (component.registrationsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			registrationsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRegistrationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRegistrationsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model'));

			expect(actualRegistrationsRemoveButtons.length).toEqual(initialRegistrationsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Registrations button when one has already been added', () => {

		const registrationsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationsButton).toEqual(component.registrationsMultiCrudActive);

		if (component.registrationsMultiCrudActive) {
			registrationsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedregistrationsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

			expect(updatedregistrationsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Registrations entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.registrationsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const registrationsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model')).length;

			expect(registrationsRemoveButtonCount).toEqual(staffWithId.registrations.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Requested By relation.
	*
	* The button should only exist if requestedByMultiCrudActive is true
	*/
	it ('Renders Requested By Add Entity button in create mode', fakeAsync(() => {
		const requestedByButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.requestedByDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!requestedByButton).toEqual(component.requestedByMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Requested By', fakeAsync(() => {
		const requestedByButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.requestedByDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!requestedByButton).toEqual(component.requestedByMultiCrudActive);

		if (component.requestedByMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRequestedByRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.requestedByDisplayName + ' from Model')).length;

			requestedByButton.nativeElement.click();
			fixture.detectChanges();

			const actualRequestedByRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.requestedByDisplayName + ' from Model')).length;

			expect(actualRequestedByRemoveButtonCount).toEqual(initialRequestedByRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Requested By button', () => {
		const requestedByButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.requestedByDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!requestedByButton).toEqual(component.requestedByMultiCrudActive);

		if (component.requestedByMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			requestedByButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRequestedByRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.requestedByDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRequestedByRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRequestedByRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.requestedByDisplayName + ' from Model'));

			expect(actualRequestedByRemoveButtons.length).toEqual(initialRequestedByRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Requested By button when one has already been added', () => {

		const requestedByButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.requestedByDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!requestedByButton).toEqual(component.requestedByMultiCrudActive);

		if (component.requestedByMultiCrudActive) {
			requestedByButton.nativeElement.click();
			fixture.detectChanges();

			const updatedrequestedByButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.requestedByDisplayName + ' to Model'));

			expect(updatedrequestedByButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Requested By entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.requestedByMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const requestedByRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.requestedByDisplayName + ' from Model')).length;

			expect(requestedByRemoveButtonCount).toEqual(staffWithId.requestedBy.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Room Transfers relation.
	*
	* The button should only exist if roomTransfersMultiCrudActive is true
	*/
	it ('Renders Room Transfers Add Entity button in create mode', fakeAsync(() => {
		const roomTransfersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!roomTransfersButton).toEqual(component.roomTransfersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Room Transfers', fakeAsync(() => {
		const roomTransfersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!roomTransfersButton).toEqual(component.roomTransfersMultiCrudActive);

		if (component.roomTransfersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRoomTransfersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model')).length;

			roomTransfersButton.nativeElement.click();
			fixture.detectChanges();

			const actualRoomTransfersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model')).length;

			expect(actualRoomTransfersRemoveButtonCount).toEqual(initialRoomTransfersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Room Transfers button', () => {
		const roomTransfersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!roomTransfersButton).toEqual(component.roomTransfersMultiCrudActive);

		if (component.roomTransfersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			roomTransfersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRoomTransfersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRoomTransfersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRoomTransfersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model'));

			expect(actualRoomTransfersRemoveButtons.length).toEqual(initialRoomTransfersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Room Transfers button when one has already been added', () => {

		const roomTransfersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!roomTransfersButton).toEqual(component.roomTransfersMultiCrudActive);

		if (component.roomTransfersMultiCrudActive) {
			roomTransfersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedroomTransfersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

			expect(updatedroomTransfersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Room Transfers entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.roomTransfersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const roomTransfersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model')).length;

			expect(roomTransfersRemoveButtonCount).toEqual(staffWithId.roomTransfers.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Sample Collection Staffs relation.
	*
	* The button should only exist if sampleCollectionStaffsMultiCrudActive is true
	*/
	it ('Renders Sample Collection Staffs Add Entity button in create mode', fakeAsync(() => {
		const sampleCollectionStaffsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionStaffsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!sampleCollectionStaffsButton).toEqual(component.sampleCollectionStaffsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Sample Collection Staffs', fakeAsync(() => {
		const sampleCollectionStaffsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionStaffsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleCollectionStaffsButton).toEqual(component.sampleCollectionStaffsMultiCrudActive);

		if (component.sampleCollectionStaffsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSampleCollectionStaffsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionStaffsDisplayName + ' from Model')).length;

			sampleCollectionStaffsButton.nativeElement.click();
			fixture.detectChanges();

			const actualSampleCollectionStaffsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionStaffsDisplayName + ' from Model')).length;

			expect(actualSampleCollectionStaffsRemoveButtonCount).toEqual(initialSampleCollectionStaffsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Sample Collection Staffs button', () => {
		const sampleCollectionStaffsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionStaffsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleCollectionStaffsButton).toEqual(component.sampleCollectionStaffsMultiCrudActive);

		if (component.sampleCollectionStaffsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			sampleCollectionStaffsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSampleCollectionStaffsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionStaffsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSampleCollectionStaffsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSampleCollectionStaffsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionStaffsDisplayName + ' from Model'));

			expect(actualSampleCollectionStaffsRemoveButtons.length).toEqual(initialSampleCollectionStaffsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Sample Collection Staffs button when one has already been added', () => {

		const sampleCollectionStaffsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionStaffsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleCollectionStaffsButton).toEqual(component.sampleCollectionStaffsMultiCrudActive);

		if (component.sampleCollectionStaffsMultiCrudActive) {
			sampleCollectionStaffsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsampleCollectionStaffsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionStaffsDisplayName + ' to Model'));

			expect(updatedsampleCollectionStaffsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Sample Collection Staffs entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.sampleCollectionStaffsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const sampleCollectionStaffsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionStaffsDisplayName + ' from Model')).length;

			expect(sampleCollectionStaffsRemoveButtonCount).toEqual(staffWithId.sampleCollectionStaffs.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Sample Delivery Staffs relation.
	*
	* The button should only exist if sampleDeliveryStaffsMultiCrudActive is true
	*/
	it ('Renders Sample Delivery Staffs Add Entity button in create mode', fakeAsync(() => {
		const sampleDeliveryStaffsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleDeliveryStaffsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!sampleDeliveryStaffsButton).toEqual(component.sampleDeliveryStaffsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Sample Delivery Staffs', fakeAsync(() => {
		const sampleDeliveryStaffsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleDeliveryStaffsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleDeliveryStaffsButton).toEqual(component.sampleDeliveryStaffsMultiCrudActive);

		if (component.sampleDeliveryStaffsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSampleDeliveryStaffsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleDeliveryStaffsDisplayName + ' from Model')).length;

			sampleDeliveryStaffsButton.nativeElement.click();
			fixture.detectChanges();

			const actualSampleDeliveryStaffsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleDeliveryStaffsDisplayName + ' from Model')).length;

			expect(actualSampleDeliveryStaffsRemoveButtonCount).toEqual(initialSampleDeliveryStaffsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Sample Delivery Staffs button', () => {
		const sampleDeliveryStaffsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleDeliveryStaffsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleDeliveryStaffsButton).toEqual(component.sampleDeliveryStaffsMultiCrudActive);

		if (component.sampleDeliveryStaffsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			sampleDeliveryStaffsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSampleDeliveryStaffsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleDeliveryStaffsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSampleDeliveryStaffsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSampleDeliveryStaffsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleDeliveryStaffsDisplayName + ' from Model'));

			expect(actualSampleDeliveryStaffsRemoveButtons.length).toEqual(initialSampleDeliveryStaffsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Sample Delivery Staffs button when one has already been added', () => {

		const sampleDeliveryStaffsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleDeliveryStaffsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleDeliveryStaffsButton).toEqual(component.sampleDeliveryStaffsMultiCrudActive);

		if (component.sampleDeliveryStaffsMultiCrudActive) {
			sampleDeliveryStaffsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsampleDeliveryStaffsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleDeliveryStaffsDisplayName + ' to Model'));

			expect(updatedsampleDeliveryStaffsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Sample Delivery Staffs entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.sampleDeliveryStaffsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const sampleDeliveryStaffsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleDeliveryStaffsDisplayName + ' from Model')).length;

			expect(sampleDeliveryStaffsRemoveButtonCount).toEqual(staffWithId.sampleDeliveryStaffs.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Sample Processing Staffs relation.
	*
	* The button should only exist if sampleProcessingStaffsMultiCrudActive is true
	*/
	it ('Renders Sample Processing Staffs Add Entity button in create mode', fakeAsync(() => {
		const sampleProcessingStaffsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleProcessingStaffsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!sampleProcessingStaffsButton).toEqual(component.sampleProcessingStaffsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Sample Processing Staffs', fakeAsync(() => {
		const sampleProcessingStaffsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleProcessingStaffsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleProcessingStaffsButton).toEqual(component.sampleProcessingStaffsMultiCrudActive);

		if (component.sampleProcessingStaffsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSampleProcessingStaffsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleProcessingStaffsDisplayName + ' from Model')).length;

			sampleProcessingStaffsButton.nativeElement.click();
			fixture.detectChanges();

			const actualSampleProcessingStaffsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleProcessingStaffsDisplayName + ' from Model')).length;

			expect(actualSampleProcessingStaffsRemoveButtonCount).toEqual(initialSampleProcessingStaffsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Sample Processing Staffs button', () => {
		const sampleProcessingStaffsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleProcessingStaffsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleProcessingStaffsButton).toEqual(component.sampleProcessingStaffsMultiCrudActive);

		if (component.sampleProcessingStaffsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			sampleProcessingStaffsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSampleProcessingStaffsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleProcessingStaffsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSampleProcessingStaffsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSampleProcessingStaffsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleProcessingStaffsDisplayName + ' from Model'));

			expect(actualSampleProcessingStaffsRemoveButtons.length).toEqual(initialSampleProcessingStaffsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Sample Processing Staffs button when one has already been added', () => {

		const sampleProcessingStaffsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleProcessingStaffsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleProcessingStaffsButton).toEqual(component.sampleProcessingStaffsMultiCrudActive);

		if (component.sampleProcessingStaffsMultiCrudActive) {
			sampleProcessingStaffsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsampleProcessingStaffsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleProcessingStaffsDisplayName + ' to Model'));

			expect(updatedsampleProcessingStaffsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Sample Processing Staffs entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.sampleProcessingStaffsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const sampleProcessingStaffsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleProcessingStaffsDisplayName + ' from Model')).length;

			expect(sampleProcessingStaffsRemoveButtonCount).toEqual(staffWithId.sampleProcessingStaffs.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Surgeon relation.
	*
	* The button should only exist if surgeonMultiCrudActive is true
	*/
	it ('Renders Surgeon Add Entity button in create mode', fakeAsync(() => {
		const surgeonButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgeonDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!surgeonButton).toEqual(component.surgeonMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Surgeon', fakeAsync(() => {
		const surgeonButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgeonDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!surgeonButton).toEqual(component.surgeonMultiCrudActive);

		if (component.surgeonMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSurgeonRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgeonDisplayName + ' from Model')).length;

			surgeonButton.nativeElement.click();
			fixture.detectChanges();

			const actualSurgeonRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgeonDisplayName + ' from Model')).length;

			expect(actualSurgeonRemoveButtonCount).toEqual(initialSurgeonRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Surgeon button', () => {
		const surgeonButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgeonDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!surgeonButton).toEqual(component.surgeonMultiCrudActive);

		if (component.surgeonMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			surgeonButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSurgeonRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgeonDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSurgeonRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSurgeonRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgeonDisplayName + ' from Model'));

			expect(actualSurgeonRemoveButtons.length).toEqual(initialSurgeonRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Surgeon button when one has already been added', () => {

		const surgeonButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgeonDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!surgeonButton).toEqual(component.surgeonMultiCrudActive);

		if (component.surgeonMultiCrudActive) {
			surgeonButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsurgeonButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgeonDisplayName + ' to Model'));

			expect(updatedsurgeonButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Surgeon entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.surgeonMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const surgeonRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgeonDisplayName + ' from Model')).length;

			expect(surgeonRemoveButtonCount).toEqual(staffWithId.surgeon.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Surgical Medical Transcriber relation.
	*
	* The button should only exist if surgicalMedicalTranscriberMultiCrudActive is true
	*/
	it ('Renders Surgical Medical Transcriber Add Entity button in create mode', fakeAsync(() => {
		const surgicalMedicalTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalMedicalTranscriberDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!surgicalMedicalTranscriberButton).toEqual(component.surgicalMedicalTranscriberMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Surgical Medical Transcriber', fakeAsync(() => {
		const surgicalMedicalTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalMedicalTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!surgicalMedicalTranscriberButton).toEqual(component.surgicalMedicalTranscriberMultiCrudActive);

		if (component.surgicalMedicalTranscriberMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSurgicalMedicalTranscriberRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalMedicalTranscriberDisplayName + ' from Model')).length;

			surgicalMedicalTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			const actualSurgicalMedicalTranscriberRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalMedicalTranscriberDisplayName + ' from Model')).length;

			expect(actualSurgicalMedicalTranscriberRemoveButtonCount).toEqual(initialSurgicalMedicalTranscriberRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Surgical Medical Transcriber button', () => {
		const surgicalMedicalTranscriberButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalMedicalTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!surgicalMedicalTranscriberButton).toEqual(component.surgicalMedicalTranscriberMultiCrudActive);

		if (component.surgicalMedicalTranscriberMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			surgicalMedicalTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSurgicalMedicalTranscriberRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalMedicalTranscriberDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSurgicalMedicalTranscriberRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSurgicalMedicalTranscriberRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalMedicalTranscriberDisplayName + ' from Model'));

			expect(actualSurgicalMedicalTranscriberRemoveButtons.length).toEqual(initialSurgicalMedicalTranscriberRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Surgical Medical Transcriber button when one has already been added', () => {

		const surgicalMedicalTranscriberButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalMedicalTranscriberDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!surgicalMedicalTranscriberButton).toEqual(component.surgicalMedicalTranscriberMultiCrudActive);

		if (component.surgicalMedicalTranscriberMultiCrudActive) {
			surgicalMedicalTranscriberButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsurgicalMedicalTranscriberButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalMedicalTranscriberDisplayName + ' to Model'));

			expect(updatedsurgicalMedicalTranscriberButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Surgical Medical Transcriber entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.surgicalMedicalTranscriberMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const surgicalMedicalTranscriberRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalMedicalTranscriberDisplayName + ' from Model')).length;

			expect(surgicalMedicalTranscriberRemoveButtonCount).toEqual(staffWithId.surgicalMedicalTranscriber.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Surgical Nurse relation.
	*
	* The button should only exist if surgicalNurseMultiCrudActive is true
	*/
	it ('Renders Surgical Nurse Add Entity button in create mode', fakeAsync(() => {
		const surgicalNurseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalNurseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!surgicalNurseButton).toEqual(component.surgicalNurseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Surgical Nurse', fakeAsync(() => {
		const surgicalNurseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalNurseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!surgicalNurseButton).toEqual(component.surgicalNurseMultiCrudActive);

		if (component.surgicalNurseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSurgicalNurseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalNurseDisplayName + ' from Model')).length;

			surgicalNurseButton.nativeElement.click();
			fixture.detectChanges();

			const actualSurgicalNurseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalNurseDisplayName + ' from Model')).length;

			expect(actualSurgicalNurseRemoveButtonCount).toEqual(initialSurgicalNurseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Surgical Nurse button', () => {
		const surgicalNurseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalNurseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!surgicalNurseButton).toEqual(component.surgicalNurseMultiCrudActive);

		if (component.surgicalNurseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			surgicalNurseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSurgicalNurseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalNurseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSurgicalNurseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSurgicalNurseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalNurseDisplayName + ' from Model'));

			expect(actualSurgicalNurseRemoveButtons.length).toEqual(initialSurgicalNurseRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Surgical Nurse button when one has already been added', () => {

		const surgicalNurseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalNurseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!surgicalNurseButton).toEqual(component.surgicalNurseMultiCrudActive);

		if (component.surgicalNurseMultiCrudActive) {
			surgicalNurseButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsurgicalNurseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.surgicalNurseDisplayName + ' to Model'));

			expect(updatedsurgicalNurseButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Surgical Nurse entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.surgicalNurseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const surgicalNurseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.surgicalNurseDisplayName + ' from Model')).length;

			expect(surgicalNurseRemoveButtonCount).toEqual(staffWithId.surgicalNurse.length);
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
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
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

			expect(transferOrderStockDetailsRemoveButtonCount).toEqual(staffWithId.transferOrderStockDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Vaccination Orders relation.
	*
	* The button should only exist if vaccinationOrdersMultiCrudActive is true
	*/
	it ('Renders Vaccination Orders Add Entity button in create mode', fakeAsync(() => {
		const vaccinationOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrdersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!vaccinationOrdersButton).toEqual(component.vaccinationOrdersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Vaccination Orders', fakeAsync(() => {
		const vaccinationOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!vaccinationOrdersButton).toEqual(component.vaccinationOrdersMultiCrudActive);

		if (component.vaccinationOrdersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialVaccinationOrdersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrdersDisplayName + ' from Model')).length;

			vaccinationOrdersButton.nativeElement.click();
			fixture.detectChanges();

			const actualVaccinationOrdersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrdersDisplayName + ' from Model')).length;

			expect(actualVaccinationOrdersRemoveButtonCount).toEqual(initialVaccinationOrdersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Vaccination Orders button', () => {
		const vaccinationOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!vaccinationOrdersButton).toEqual(component.vaccinationOrdersMultiCrudActive);

		if (component.vaccinationOrdersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			vaccinationOrdersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialVaccinationOrdersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrdersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialVaccinationOrdersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualVaccinationOrdersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrdersDisplayName + ' from Model'));

			expect(actualVaccinationOrdersRemoveButtons.length).toEqual(initialVaccinationOrdersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Vaccination Orders button when one has already been added', () => {

		const vaccinationOrdersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!vaccinationOrdersButton).toEqual(component.vaccinationOrdersMultiCrudActive);

		if (component.vaccinationOrdersMultiCrudActive) {
			vaccinationOrdersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedvaccinationOrdersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.vaccinationOrdersDisplayName + ' to Model'));

			expect(updatedvaccinationOrdersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Vaccination Orders entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.vaccinationOrdersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const vaccinationOrdersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.vaccinationOrdersDisplayName + ' from Model')).length;

			expect(vaccinationOrdersRemoveButtonCount).toEqual(staffWithId.vaccinationOrders.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Services relation.
	*
	* The button should only exist if servicesMultiCrudActive is true
	*/
	it ('Renders Services Add Entity button in create mode', fakeAsync(() => {
		const servicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!servicesButton).toEqual(component.servicesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Services', fakeAsync(() => {
		const servicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!servicesButton).toEqual(component.servicesMultiCrudActive);

		if (component.servicesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialServicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model')).length;

			servicesButton.nativeElement.click();
			fixture.detectChanges();

			const actualServicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model')).length;

			expect(actualServicesRemoveButtonCount).toEqual(initialServicesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Services button', () => {
		const servicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!servicesButton).toEqual(component.servicesMultiCrudActive);

		if (component.servicesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			servicesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialServicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialServicesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualServicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model'));

			expect(actualServicesRemoveButtons.length).toEqual(initialServicesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Services button when one has already been added', () => {

		const servicesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!servicesButton).toEqual(component.servicesMultiCrudActive);

		if (component.servicesMultiCrudActive) {
			servicesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedservicesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

			expect(updatedservicesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Services entities from model when loading in edit mode', () => {
		component.targetModel = staffWithId;
		component.targetModelId = staffWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.servicesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const servicesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model')).length;

			expect(servicesRemoveButtonCount).toEqual(staffWithId.services.length);
		}
	});

});
