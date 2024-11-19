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
	getRegistrationCollectionModels,
	getCountRegistrationModels,
	getRegistrationModelWithId
} from 'src/app/models/registration/registration.model.selector';
import { RegistrationCrudModule } from '../registration-crud.module';
import { RegistrationCrudEditComponent } from './registration-crud-edit.component';
import {
	RegistrationModelState,
	initialState as initialRegistrationModelState
} from 'src/app/models/registration/registration.model.state';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { CrudTileMode } from '../registration-crud.component';
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
import { getBpjsDrugGenericPRBModelWithId } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.selector';
import { getBpjsDrugGenericPRBCollectionModels } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.selector';
import { BpjsDrugGenericPRBModel } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model';
import { BpjsDrugGenericPRBDataFactory } from 'src/app/lib/utils/factories/bpjs-drug-generic-prb-data-factory';
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
import { getBirthHistoryModelWithId } from 'src/app/models/birthHistory/birth_history.model.selector';
import { getBirthHistoryCollectionModels } from 'src/app/models/birthHistory/birth_history.model.selector';
import { BirthHistoryModel } from 'src/app/models/birthHistory/birth_history.model';
import { BirthHistoryDataFactory } from 'src/app/lib/utils/factories/birth-history-data-factory';
import { getBodyChartExaminationModelWithId } from 'src/app/models/bodyChartExamination/body_chart_examination.model.selector';
import { getBodyChartExaminationCollectionModels } from 'src/app/models/bodyChartExamination/body_chart_examination.model.selector';
import { BodyChartExaminationModel } from 'src/app/models/bodyChartExamination/body_chart_examination.model';
import { BodyChartExaminationDataFactory } from 'src/app/lib/utils/factories/body-chart-examination-data-factory';
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
import { getExaminationItemDetailModelWithId } from 'src/app/models/examinationItemDetail/examination_item_detail.model.selector';
import { getExaminationItemDetailCollectionModels } from 'src/app/models/examinationItemDetail/examination_item_detail.model.selector';
import { ExaminationItemDetailModel } from 'src/app/models/examinationItemDetail/examination_item_detail.model';
import { ExaminationItemDetailDataFactory } from 'src/app/lib/utils/factories/examination-item-detail-data-factory';
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
import { getInvoiceItemComponentModelWithId } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.selector';
import { getInvoiceItemComponentCollectionModels } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.selector';
import { InvoiceItemComponentModel } from 'src/app/models/invoiceItemComponent/invoice_item_component.model';
import { InvoiceItemComponentDataFactory } from 'src/app/lib/utils/factories/invoice-item-component-data-factory';
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
import { getMedicalFeeItemComponentModelWithId } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model.selector';
import { getMedicalFeeItemComponentCollectionModels } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model.selector';
import { MedicalFeeItemComponentModel } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model';
import { MedicalFeeItemComponentDataFactory } from 'src/app/lib/utils/factories/medical-fee-item-component-data-factory';
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
import { getPcareActionExaminationModelWithId } from 'src/app/models/pcareActionExamination/pcare_action_examination.model.selector';
import { getPcareActionExaminationCollectionModels } from 'src/app/models/pcareActionExamination/pcare_action_examination.model.selector';
import { PcareActionExaminationModel } from 'src/app/models/pcareActionExamination/pcare_action_examination.model';
import { PcareActionExaminationDataFactory } from 'src/app/lib/utils/factories/pcare-action-examination-data-factory';
import { getPcareCompoundDrugModelWithId } from 'src/app/models/pcareCompoundDrug/pcare_compound_drug.model.selector';
import { getPcareCompoundDrugCollectionModels } from 'src/app/models/pcareCompoundDrug/pcare_compound_drug.model.selector';
import { PcareCompoundDrugModel } from 'src/app/models/pcareCompoundDrug/pcare_compound_drug.model';
import { PcareCompoundDrugDataFactory } from 'src/app/lib/utils/factories/pcare-compound-drug-data-factory';
import { getPcareDokterModelWithId } from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import { getPcareDokterCollectionModels } from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import { PcareDokterModel } from 'src/app/models/pcareDokter/pcare_dokter.model';
import { PcareDokterDataFactory } from 'src/app/lib/utils/factories/pcare-dokter-data-factory';
import { getPcareExaminationModelWithId } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { getPcareExaminationCollectionModels } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { PcareExaminationModel } from 'src/app/models/pcareExamination/pcare_examination.model';
import { PcareExaminationDataFactory } from 'src/app/lib/utils/factories/pcare-examination-data-factory';
import { getPcareNonCompoundDrugModelWithId } from 'src/app/models/pcareNonCompoundDrug/pcare_noncompound_drug.model.selector';
import { getPcareNonCompoundDrugCollectionModels } from 'src/app/models/pcareNonCompoundDrug/pcare_noncompound_drug.model.selector';
import { PcareNonCompoundDrugModel } from 'src/app/models/pcareNonCompoundDrug/pcare_noncompound_drug.model';
import { PcareNonCompoundDrugDataFactory } from 'src/app/lib/utils/factories/pcare-noncompound-drug-data-factory';
import { getPatientConsentModelWithId } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { getPatientConsentCollectionModels } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { PatientConsentModel } from 'src/app/models/patientConsent/patient_consent.model';
import { PatientConsentDataFactory } from 'src/app/lib/utils/factories/patient-consent-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPatientPaymentBPJSModelWithId } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { getPatientPaymentBPJSCollectionModels } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { PatientPaymentBPJSModel } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import { PatientPaymentBPJSDataFactory } from 'src/app/lib/utils/factories/patient-payment-bpjs-data-factory';
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
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { getSystemAdminUserModelWithId } from 'src/app/models/systemAdminUser/system_admin_user.model.selector';
import { getSystemAdminUserCollectionModels } from 'src/app/models/systemAdminUser/system_admin_user.model.selector';
import { SystemAdminUserModel } from 'src/app/models/systemAdminUser/system_admin_user.model';
import { SystemAdminUserDataFactory } from 'src/app/lib/utils/factories/system-admin-user-data-factory';
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
import { getVaccinationOrderDetailModelWithId } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import { getVaccinationOrderDetailCollectionModels } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import { VaccinationOrderDetailModel } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model';
import { VaccinationOrderDetailDataFactory } from 'src/app/lib/utils/factories/vaccination-order-detail-data-factory';
import { getWarehouseModelWithId } from 'src/app/models/warehouse/warehouse.model.selector';
import { getWarehouseCollectionModels } from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { WarehouseDataFactory } from 'src/app/lib/utils/factories/warehouse-data-factory';
import { getWarehouseUserModelWithId } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { getWarehouseUserCollectionModels } from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import { WarehouseUserModel } from 'src/app/models/warehouseUser/warehouse_user.model';
import { WarehouseUserDataFactory } from 'src/app/lib/utils/factories/warehouse-user-data-factory';

describe('Registration CRUD Edit component tests', () => {
	let fixture: ComponentFixture<RegistrationCrudEditComponent>
	let component: RegistrationCrudEditComponent;

	let registrationModelState: RegistrationModelState;

	let store: MockStore<{ model: RegistrationModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let registrationCountBehaviorSubject: BehaviorSubject<number>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let administrationUserModelsBehaviorSubject: BehaviorSubject<AdministrationUserModel[]>;
	let administratorModelsBehaviorSubject: BehaviorSubject<AdministratorModel[]>;
	let amendmentDetailModelsBehaviorSubject: BehaviorSubject<AmendmentDetailModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsDiagnosePRBModelsBehaviorSubject: BehaviorSubject<BpjsDiagnosePRBModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsDrugGenericPRBModelsBehaviorSubject: BehaviorSubject<BpjsDrugGenericPRBModel[]>;
	let bpjsPRBDetailModelsBehaviorSubject: BehaviorSubject<BpjsPRBDetailModel[]>;
	let bpjsPcarePoliModelsBehaviorSubject: BehaviorSubject<BpjsPcarePoliModel[]>;
	let bpjsPcareRegistrationsModelsBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel[]>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let bpjsVisitDataModelsBehaviorSubject: BehaviorSubject<BpjsVisitDataModel[]>;
	let bedFacilityModelsBehaviorSubject: BehaviorSubject<BedFacilityModel[]>;
	let bedReserveModelsBehaviorSubject: BehaviorSubject<BedReserveModel[]>;
	let birthHistoryModelsBehaviorSubject: BehaviorSubject<BirthHistoryModel[]>;
	let bodyChartExaminationModelsBehaviorSubject: BehaviorSubject<BodyChartExaminationModel[]>;
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
	let diagnosticExaminationResultsModelsBehaviorSubject: BehaviorSubject<DiagnosticExaminationResultsModel[]>;
	let diagnosticStaffExaminationSummaryModelsBehaviorSubject: BehaviorSubject<DiagnosticStaffExaminationSummaryModel[]>;
	let diagnosticSupportUserModelsBehaviorSubject: BehaviorSubject<DiagnosticSupportUserModel[]>;
	let doctorScheduleModelsBehaviorSubject: BehaviorSubject<DoctorScheduleModel[]>;
	let doctorUserModelsBehaviorSubject: BehaviorSubject<DoctorUserModel[]>;
	let entExaminationModelsBehaviorSubject: BehaviorSubject<EntExaminationModel[]>;
	let emergencyMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<EmergencyMedicalExaminationRecordModel[]>;
	let examinationGroupModelsBehaviorSubject: BehaviorSubject<ExaminationGroupModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let examinationItemDetailModelsBehaviorSubject: BehaviorSubject<ExaminationItemDetailModel[]>;
	let facilityUserModelsBehaviorSubject: BehaviorSubject<FacilityUserModel[]>;
	let fluidBalanceDetailModelsBehaviorSubject: BehaviorSubject<FluidBalanceDetailModel[]>;
	let formulirKonselingTesHivModelsBehaviorSubject: BehaviorSubject<FormulirKonselingTesHivModel[]>;
	let healthFacilityModelsBehaviorSubject: BehaviorSubject<HealthFacilityModel[]>;
	let hemodialysisExaminationModelsBehaviorSubject: BehaviorSubject<HemodialysisExaminationModel[]>;
	let hemodialysisMonitoringModelsBehaviorSubject: BehaviorSubject<HemodialysisMonitoringModel[]>;
	let hospitalBranchInformationModelsBehaviorSubject: BehaviorSubject<HospitalBranchInformationModel[]>;
	let icd10ModelsBehaviorSubject: BehaviorSubject<Icd10Model[]>;
	let icd9CMModelsBehaviorSubject: BehaviorSubject<Icd9CMModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let inpatientMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<InpatientMedicalExaminationRecordModel[]>;
	let intraoperativeRecordsModelsBehaviorSubject: BehaviorSubject<IntraoperativeRecordsModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let invoiceItemComponentModelsBehaviorSubject: BehaviorSubject<InvoiceItemComponentModel[]>;
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
	let medicalFeeItemComponentModelsBehaviorSubject: BehaviorSubject<MedicalFeeItemComponentModel[]>;
	let medicalRecordInitialChecklistModelsBehaviorSubject: BehaviorSubject<MedicalRecordInitialChecklistModel[]>;
	let medicalRecordNextVerificationChecklistModelsBehaviorSubject: BehaviorSubject<MedicalRecordNextVerificationChecklistModel[]>;
	let medicalRecordUserModelsBehaviorSubject: BehaviorSubject<MedicalRecordUserModel[]>;
	let medicalTranscriberUserModelsBehaviorSubject: BehaviorSubject<MedicalTranscriberUserModel[]>;
	let medicationAdministeredHistoryModelsBehaviorSubject: BehaviorSubject<MedicationAdministeredHistoryModel[]>;
	let medicationCompoundModelsBehaviorSubject: BehaviorSubject<MedicationCompoundModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let medicationItemModelsBehaviorSubject: BehaviorSubject<MedicationItemModel[]>;
	let newbornDetailModelsBehaviorSubject: BehaviorSubject<NewbornDetailModel[]>;
	let nurseUserModelsBehaviorSubject: BehaviorSubject<NurseUserModel[]>;
	let nurseVitalSignMeasurementModelsBehaviorSubject: BehaviorSubject<NurseVitalSignMeasurementModel[]>;
	let obstetricAndGynecologyHistoryModelsBehaviorSubject: BehaviorSubject<ObstetricAndGynecologyHistoryModel[]>;
	let odontogramExaminationModelsBehaviorSubject: BehaviorSubject<OdontogramExaminationModel[]>;
	let operatingTheaterMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel[]>;
	let ophthalmologyExaminationModelsBehaviorSubject: BehaviorSubject<OphthalmologyExaminationModel[]>;
	let pcareActionExaminationModelsBehaviorSubject: BehaviorSubject<PcareActionExaminationModel[]>;
	let pcareCompoundDrugModelsBehaviorSubject: BehaviorSubject<PcareCompoundDrugModel[]>;
	let pcareDokterModelsBehaviorSubject: BehaviorSubject<PcareDokterModel[]>;
	let pcareExaminationModelsBehaviorSubject: BehaviorSubject<PcareExaminationModel[]>;
	let pcareNonCompoundDrugModelsBehaviorSubject: BehaviorSubject<PcareNonCompoundDrugModel[]>;
	let patientConsentModelsBehaviorSubject: BehaviorSubject<PatientConsentModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;
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
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let systemAdminUserModelsBehaviorSubject: BehaviorSubject<SystemAdminUserModel[]>;
	let tariffSchemaModelsBehaviorSubject: BehaviorSubject<TariffSchemaModel[]>;
	let transferOrderStockDetailModelsBehaviorSubject: BehaviorSubject<TransferOrderStockDetailModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;
	let vaccinationOrderDetailModelsBehaviorSubject: BehaviorSubject<VaccinationOrderDetailModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;
	let warehouseUserModelsBehaviorSubject: BehaviorSubject<WarehouseUserModel[]>;

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

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

	const bpjsDrugGenericPRBFactory: BpjsDrugGenericPRBDataFactory = new BpjsDrugGenericPRBDataFactory();
	const defaultBpjsDrugGenericPRBCount: number = 10;
	const defaultBpjsDrugGenericPRBEntities: BpjsDrugGenericPRBModel[] = bpjsDrugGenericPRBFactory.createAll(defaultBpjsDrugGenericPRBCount);

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

	const bpjsVisitDataFactory: BpjsVisitDataDataFactory = new BpjsVisitDataDataFactory();
	const defaultBpjsVisitDataCount: number = 10;
	const defaultBpjsVisitDataEntities: BpjsVisitDataModel[] = bpjsVisitDataFactory.createAll(defaultBpjsVisitDataCount);

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

	const examinationItemDetailFactory: ExaminationItemDetailDataFactory = new ExaminationItemDetailDataFactory();
	const defaultExaminationItemDetailCount: number = 10;
	const defaultExaminationItemDetailEntities: ExaminationItemDetailModel[] = examinationItemDetailFactory.createAll(defaultExaminationItemDetailCount);

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

	const intraoperativeRecordsFactory: IntraoperativeRecordsDataFactory = new IntraoperativeRecordsDataFactory();
	const defaultIntraoperativeRecordsCount: number = 10;
	const defaultIntraoperativeRecordsEntities: IntraoperativeRecordsModel[] = intraoperativeRecordsFactory.createAll(defaultIntraoperativeRecordsCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const invoiceItemComponentFactory: InvoiceItemComponentDataFactory = new InvoiceItemComponentDataFactory();
	const defaultInvoiceItemComponentCount: number = 10;
	const defaultInvoiceItemComponentEntities: InvoiceItemComponentModel[] = invoiceItemComponentFactory.createAll(defaultInvoiceItemComponentCount);

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

	const medicalFeeItemComponentFactory: MedicalFeeItemComponentDataFactory = new MedicalFeeItemComponentDataFactory();
	const defaultMedicalFeeItemComponentCount: number = 10;
	const defaultMedicalFeeItemComponentEntities: MedicalFeeItemComponentModel[] = medicalFeeItemComponentFactory.createAll(defaultMedicalFeeItemComponentCount);

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

	const pcareActionExaminationFactory: PcareActionExaminationDataFactory = new PcareActionExaminationDataFactory();
	const defaultPcareActionExaminationCount: number = 10;
	const defaultPcareActionExaminationEntities: PcareActionExaminationModel[] = pcareActionExaminationFactory.createAll(defaultPcareActionExaminationCount);

	const pcareCompoundDrugFactory: PcareCompoundDrugDataFactory = new PcareCompoundDrugDataFactory();
	const defaultPcareCompoundDrugCount: number = 10;
	const defaultPcareCompoundDrugEntities: PcareCompoundDrugModel[] = pcareCompoundDrugFactory.createAll(defaultPcareCompoundDrugCount);

	const pcareDokterFactory: PcareDokterDataFactory = new PcareDokterDataFactory();
	const defaultPcareDokterCount: number = 10;
	const defaultPcareDokterEntities: PcareDokterModel[] = pcareDokterFactory.createAll(defaultPcareDokterCount);

	const pcareExaminationFactory: PcareExaminationDataFactory = new PcareExaminationDataFactory();
	const defaultPcareExaminationCount: number = 10;
	const defaultPcareExaminationEntities: PcareExaminationModel[] = pcareExaminationFactory.createAll(defaultPcareExaminationCount);

	const pcareNonCompoundDrugFactory: PcareNonCompoundDrugDataFactory = new PcareNonCompoundDrugDataFactory();
	const defaultPcareNonCompoundDrugCount: number = 10;
	const defaultPcareNonCompoundDrugEntities: PcareNonCompoundDrugModel[] = pcareNonCompoundDrugFactory.createAll(defaultPcareNonCompoundDrugCount);

	const patientConsentFactory: PatientConsentDataFactory = new PatientConsentDataFactory();
	const defaultPatientConsentCount: number = 10;
	const defaultPatientConsentEntities: PatientConsentModel[] = patientConsentFactory.createAll(defaultPatientConsentCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentBPJSFactory: PatientPaymentBPJSDataFactory = new PatientPaymentBPJSDataFactory();
	const defaultPatientPaymentBPJSCount: number = 10;
	const defaultPatientPaymentBPJSEntities: PatientPaymentBPJSModel[] = patientPaymentBPJSFactory.createAll(defaultPatientPaymentBPJSCount);

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

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const systemAdminUserFactory: SystemAdminUserDataFactory = new SystemAdminUserDataFactory();
	const defaultSystemAdminUserCount: number = 10;
	const defaultSystemAdminUserEntities: SystemAdminUserModel[] = systemAdminUserFactory.createAll(defaultSystemAdminUserCount);

	const tariffSchemaFactory: TariffSchemaDataFactory = new TariffSchemaDataFactory();
	const defaultTariffSchemaCount: number = 10;
	const defaultTariffSchemaEntities: TariffSchemaModel[] = tariffSchemaFactory.createAll(defaultTariffSchemaCount);

	const transferOrderStockDetailFactory: TransferOrderStockDetailDataFactory = new TransferOrderStockDetailDataFactory();
	const defaultTransferOrderStockDetailCount: number = 10;
	const defaultTransferOrderStockDetailEntities: TransferOrderStockDetailModel[] = transferOrderStockDetailFactory.createAll(defaultTransferOrderStockDetailCount);

	const vaccinationOrderFactory: VaccinationOrderDataFactory = new VaccinationOrderDataFactory();
	const defaultVaccinationOrderCount: number = 10;
	const defaultVaccinationOrderEntities: VaccinationOrderModel[] = vaccinationOrderFactory.createAll(defaultVaccinationOrderCount);

	const vaccinationOrderDetailFactory: VaccinationOrderDetailDataFactory = new VaccinationOrderDetailDataFactory();
	const defaultVaccinationOrderDetailCount: number = 10;
	const defaultVaccinationOrderDetailEntities: VaccinationOrderDetailModel[] = vaccinationOrderDetailFactory.createAll(defaultVaccinationOrderDetailCount);

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);

	const warehouseUserFactory: WarehouseUserDataFactory = new WarehouseUserDataFactory();
	const defaultWarehouseUserCount: number = 10;
	const defaultWarehouseUserEntities: WarehouseUserModel[] = warehouseUserFactory.createAll(defaultWarehouseUserCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let registrationWithId: RegistrationModel = defaultRegistrationEntities[0];
	let registrationModelWithIdBehaviorSubject: BehaviorSubject<RegistrationModel>;

	registrationWithId.bpjsPRBDetail = defaultBpjsPRBDetailEntities[0];
	registrationWithId.bpjsPRBDetailId = registrationWithId.bpjsPRBDetail.id;
	let bpjsPRBDetailWithIdBehaviorSubject: BehaviorSubject<BpjsPRBDetailModel>;

	registrationWithId.bpjsPcareRegistrations = defaultBpjsPcareRegistrationsEntities[0];
	registrationWithId.bpjsPcareRegistrationsId = registrationWithId.bpjsPcareRegistrations.id;
	let bpjsPcareRegistrationsWithIdBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel>;

	registrationWithId.bpjsSEP = defaultBpjsSEPEntities[0];
	registrationWithId.bpjsSEPId = registrationWithId.bpjsSEP.id;
	let bpjsSEPWithIdBehaviorSubject: BehaviorSubject<BpjsSEPModel>;

	registrationWithId.medicalCertificateDischargeResume = defaultMedicalCertificateDischargeResumeEntities[0];
	registrationWithId.medicalCertificateDischargeResumeId = registrationWithId.medicalCertificateDischargeResume.id;
	let medicalCertificateDischargeResumeWithIdBehaviorSubject: BehaviorSubject<MedicalCertificateDischargeResumeModel>;

	registrationWithId.medicalCertificateBirth = defaultMedicalCertificateBirthEntities[0];
	registrationWithId.medicalCertificateBirthId = registrationWithId.medicalCertificateBirth.id;
	let medicalCertificateBirthWithIdBehaviorSubject: BehaviorSubject<MedicalCertificateBirthModel>;

	registrationWithId.medicalCertificateHospitalization = defaultMedicalCertificateHospitalizationEntities[0];
	registrationWithId.medicalCertificateHospitalizationId = registrationWithId.medicalCertificateHospitalization.id;
	let medicalCertificateHospitalizationWithIdBehaviorSubject: BehaviorSubject<MedicalCertificateHospitalizationModel>;

	registrationWithId.medicalCertificateMedicalAttendance = defaultMedicalCertificateMedicalAttendanceEntities[0];
	registrationWithId.medicalCertificateMedicalAttendanceId = registrationWithId.medicalCertificateMedicalAttendance.id;
	let medicalCertificateMedicalAttendanceWithIdBehaviorSubject: BehaviorSubject<MedicalCertificateMedicalAttendanceModel>;

	registrationWithId.medicalCertificateMentalHealth = defaultMedicalCertificateMentalHealthEntities[0];
	registrationWithId.medicalCertificateMentalHealthId = registrationWithId.medicalCertificateMentalHealth.id;
	let medicalCertificateMentalHealthWithIdBehaviorSubject: BehaviorSubject<MedicalCertificateMentalHealthModel>;

	registrationWithId.medicalCertificatePhysicalHealth = defaultMedicalCertificatePhysicalHealthEntities[0];
	registrationWithId.medicalCertificatePhysicalHealthId = registrationWithId.medicalCertificatePhysicalHealth.id;
	let medicalCertificatePhysicalHealthWithIdBehaviorSubject: BehaviorSubject<MedicalCertificatePhysicalHealthModel>;

	registrationWithId.medicalCertificateRestrictedWork = defaultMedicalCertificateRestrictedWorkEntities[0];
	registrationWithId.medicalCertificateRestrictedWorkId = registrationWithId.medicalCertificateRestrictedWork.id;
	let medicalCertificateRestrictedWorkWithIdBehaviorSubject: BehaviorSubject<MedicalCertificateRestrictedWorkModel>;

	registrationWithId.medicalCertificateSickLeave = defaultMedicalCertificateSickLeaveEntities[0];
	registrationWithId.medicalCertificateSickLeaveId = registrationWithId.medicalCertificateSickLeave.id;
	let medicalCertificateSickLeaveWithIdBehaviorSubject: BehaviorSubject<MedicalCertificateSickLeaveModel>;

	registrationWithId.medicalExaminationRecord = defaultMedicalExaminationRecordEntities[0];
	registrationWithId.medicalExaminationRecordId = registrationWithId.medicalExaminationRecord.id;
	let medicalExaminationRecordWithIdBehaviorSubject: BehaviorSubject<MedicalExaminationRecordModel>;

	registrationWithId.pcareExamination = defaultPcareExaminationEntities[0];
	registrationWithId.pcareExaminationId = registrationWithId.pcareExamination.id;
	let pcareExaminationWithIdBehaviorSubject: BehaviorSubject<PcareExaminationModel>;

	registrationWithId.sep = defaultSepEntities[0];
	registrationWithId.sepId = registrationWithId.sep.id;
	let sepWithIdBehaviorSubject: BehaviorSubject<SepModel>;

	registrationWithId.diagnosticStaffExaminationSummary = defaultDiagnosticStaffExaminationSummaryEntities[0];
	registrationWithId.diagnosticStaffExaminationSummaryId = registrationWithId.diagnosticStaffExaminationSummary.id;
	let diagnosticStaffExaminationSummaryWithIdBehaviorSubject: BehaviorSubject<DiagnosticStaffExaminationSummaryModel>;

	registrationWithId.admissionICD10 = defaultDiagnosesAndProceduresEntities[0];
	registrationWithId.admissionICD10Id = registrationWithId.admissionICD10.id;
	let admissionICD10WithIdBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel>;

	registrationWithId.admissionICD9CM = defaultDiagnosesAndProceduresEntities[0];
	registrationWithId.admissionICD9CMId = registrationWithId.admissionICD9CM.id;
	let admissionICD9CMWithIdBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel>;

	registrationWithId.dismissalReferringFacility = defaultHealthFacilityEntities[0];
	registrationWithId.dismissalReferringFacilityId = registrationWithId.dismissalReferringFacility.id;
	let dismissalReferringFacilityWithIdBehaviorSubject: BehaviorSubject<HealthFacilityModel>;

	registrationWithId.dismissalReferringStaff = defaultStaffEntities[0];
	registrationWithId.dismissalReferringStaffId = registrationWithId.dismissalReferringStaff.id;
	let dismissalReferringStaffWithIdBehaviorSubject: BehaviorSubject<StaffModel>;

	registrationWithId.referringUnit = defaultServiceEntities[0];
	registrationWithId.referringUnitId = registrationWithId.referringUnit.id;
	let referringUnitWithIdBehaviorSubject: BehaviorSubject<ServiceModel>;

	registrationWithId.referringFacility = defaultHealthFacilityEntities[0];
	registrationWithId.referringFacilityId = registrationWithId.referringFacility.id;
	let referringFacilityWithIdBehaviorSubject: BehaviorSubject<HealthFacilityModel>;

	registrationWithId.bedFacility = defaultBedFacilityEntities[0];
	registrationWithId.bedFacilityId = registrationWithId.bedFacility.id;
	let bedFacilityWithIdBehaviorSubject: BehaviorSubject<BedFacilityModel>;

	registrationWithId.patientVisit = defaultPatientVisitEntities[0];
	registrationWithId.patientVisitId = registrationWithId.patientVisit.id;
	let patientVisitWithIdBehaviorSubject: BehaviorSubject<PatientVisitModel>;

	registrationWithId.service = defaultServiceEntities[0];
	registrationWithId.serviceId = registrationWithId.service.id;
	let serviceWithIdBehaviorSubject: BehaviorSubject<ServiceModel>;

	registrationWithId.staff = defaultStaffEntities[0];
	registrationWithId.staffId = registrationWithId.staff.id;
	let staffWithIdBehaviorSubject: BehaviorSubject<StaffModel>;

	registrationWithId.requestedBy = defaultStaffEntities[0];
	registrationWithId.requestedById = registrationWithId.requestedBy.id;
	let requestedByWithIdBehaviorSubject: BehaviorSubject<StaffModel>;

	registrationWithId.bedReserves = defaultBedReserveEntities;
	registrationWithId.bedReservesIds = registrationWithId.bedReserves.map(bedReserves => bedReserves.id);

	registrationWithId.diagnosticExaminationResults = defaultDiagnosticExaminationResultsEntities;
	registrationWithId.diagnosticExaminationResultsIds = registrationWithId.diagnosticExaminationResults.map(diagnosticExaminationResults => diagnosticExaminationResults.id);

	registrationWithId.fluidBalanceDetails = defaultFluidBalanceDetailEntities;
	registrationWithId.fluidBalanceDetailsIds = registrationWithId.fluidBalanceDetails.map(fluidBalanceDetails => fluidBalanceDetails.id);

	registrationWithId.informedConsents = defaultInformedConsentEntities;
	registrationWithId.informedConsentsIds = registrationWithId.informedConsents.map(informedConsents => informedConsents.id);

	registrationWithId.invoiceItems = defaultInvoiceItemEntities;
	registrationWithId.invoiceItemsIds = registrationWithId.invoiceItems.map(invoiceItems => invoiceItems.id);

	registrationWithId.medicalFees = defaultMedicalFeeEntities;
	registrationWithId.medicalFeesIds = registrationWithId.medicalFees.map(medicalFees => medicalFees.id);

	registrationWithId.medicationHeaders = defaultMedicationHeaderEntities;
	registrationWithId.medicationHeadersIds = registrationWithId.medicationHeaders.map(medicationHeaders => medicationHeaders.id);

	registrationWithId.patientVitalInformations = defaultPatientVitalInformationEntities;
	registrationWithId.patientVitalInformationsIds = registrationWithId.patientVitalInformations.map(patientVitalInformations => patientVitalInformations.id);

	registrationWithId.prescriptionHeaders = defaultPrescriptionHeaderEntities;
	registrationWithId.prescriptionHeadersIds = registrationWithId.prescriptionHeaders.map(prescriptionHeaders => prescriptionHeaders.id);

	registrationWithId.sampleCollectionInformations = defaultSampleCollectionInformationEntities;
	registrationWithId.sampleCollectionInformationsIds = registrationWithId.sampleCollectionInformations.map(sampleCollectionInformations => sampleCollectionInformations.id);

	registrationWithId.vaccinationOrders = defaultVaccinationOrderEntities;
	registrationWithId.vaccinationOrdersIds = registrationWithId.vaccinationOrders.map(vaccinationOrders => vaccinationOrders.id);

	registrationWithId.examinationItems = defaultExaminationItemEntities;
	registrationWithId.examinationItemsIds = registrationWithId.examinationItems.map(examinationItems => examinationItems.id);


	const routerState: RouterState = {
		url: 'registration-crud',
		urls: ['registration-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: RegistrationModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		registrationModelState = initialRegistrationModelState;
		store.setState({model: registrationModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		registrationCountBehaviorSubject = new BehaviorSubject(defaultRegistrationCount);

		// selectors for all references
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		administrationUserModelsBehaviorSubject = new BehaviorSubject(defaultAdministrationUserEntities);
		administratorModelsBehaviorSubject = new BehaviorSubject(defaultAdministratorEntities);
		amendmentDetailModelsBehaviorSubject = new BehaviorSubject(defaultAmendmentDetailEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsDiagnosePRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnosePRBEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsDrugGenericPRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDrugGenericPRBEntities);
		bpjsPRBDetailModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBDetailEntities);
		bpjsPcarePoliModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcarePoliEntities);
		bpjsPcareRegistrationsModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareRegistrationsEntities);
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		bpjsVisitDataModelsBehaviorSubject = new BehaviorSubject(defaultBpjsVisitDataEntities);
		bedFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBedFacilityEntities);
		bedReserveModelsBehaviorSubject = new BehaviorSubject(defaultBedReserveEntities);
		birthHistoryModelsBehaviorSubject = new BehaviorSubject(defaultBirthHistoryEntities);
		bodyChartExaminationModelsBehaviorSubject = new BehaviorSubject(defaultBodyChartExaminationEntities);
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
		diagnosticExaminationResultsModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticExaminationResultsEntities);
		diagnosticStaffExaminationSummaryModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticStaffExaminationSummaryEntities);
		diagnosticSupportUserModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticSupportUserEntities);
		doctorScheduleModelsBehaviorSubject = new BehaviorSubject(defaultDoctorScheduleEntities);
		doctorUserModelsBehaviorSubject = new BehaviorSubject(defaultDoctorUserEntities);
		entExaminationModelsBehaviorSubject = new BehaviorSubject(defaultEntExaminationEntities);
		emergencyMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultEmergencyMedicalExaminationRecordEntities);
		examinationGroupModelsBehaviorSubject = new BehaviorSubject(defaultExaminationGroupEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		examinationItemDetailModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemDetailEntities);
		facilityUserModelsBehaviorSubject = new BehaviorSubject(defaultFacilityUserEntities);
		fluidBalanceDetailModelsBehaviorSubject = new BehaviorSubject(defaultFluidBalanceDetailEntities);
		formulirKonselingTesHivModelsBehaviorSubject = new BehaviorSubject(defaultFormulirKonselingTesHivEntities);
		healthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultHealthFacilityEntities);
		hemodialysisExaminationModelsBehaviorSubject = new BehaviorSubject(defaultHemodialysisExaminationEntities);
		hemodialysisMonitoringModelsBehaviorSubject = new BehaviorSubject(defaultHemodialysisMonitoringEntities);
		hospitalBranchInformationModelsBehaviorSubject = new BehaviorSubject(defaultHospitalBranchInformationEntities);
		icd10ModelsBehaviorSubject = new BehaviorSubject(defaultIcd10Entities);
		icd9CMModelsBehaviorSubject = new BehaviorSubject(defaultIcd9CMEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		inpatientMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultInpatientMedicalExaminationRecordEntities);
		intraoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultIntraoperativeRecordsEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		invoiceItemComponentModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemComponentEntities);
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
		medicalFeeItemComponentModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeItemComponentEntities);
		medicalRecordInitialChecklistModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordInitialChecklistEntities);
		medicalRecordNextVerificationChecklistModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordNextVerificationChecklistEntities);
		medicalRecordUserModelsBehaviorSubject = new BehaviorSubject(defaultMedicalRecordUserEntities);
		medicalTranscriberUserModelsBehaviorSubject = new BehaviorSubject(defaultMedicalTranscriberUserEntities);
		medicationAdministeredHistoryModelsBehaviorSubject = new BehaviorSubject(defaultMedicationAdministeredHistoryEntities);
		medicationCompoundModelsBehaviorSubject = new BehaviorSubject(defaultMedicationCompoundEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		medicationItemModelsBehaviorSubject = new BehaviorSubject(defaultMedicationItemEntities);
		newbornDetailModelsBehaviorSubject = new BehaviorSubject(defaultNewbornDetailEntities);
		nurseUserModelsBehaviorSubject = new BehaviorSubject(defaultNurseUserEntities);
		nurseVitalSignMeasurementModelsBehaviorSubject = new BehaviorSubject(defaultNurseVitalSignMeasurementEntities);
		obstetricAndGynecologyHistoryModelsBehaviorSubject = new BehaviorSubject(defaultObstetricAndGynecologyHistoryEntities);
		odontogramExaminationModelsBehaviorSubject = new BehaviorSubject(defaultOdontogramExaminationEntities);
		operatingTheaterMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultOperatingTheaterMedicalExaminationRecordEntities);
		ophthalmologyExaminationModelsBehaviorSubject = new BehaviorSubject(defaultOphthalmologyExaminationEntities);
		pcareActionExaminationModelsBehaviorSubject = new BehaviorSubject(defaultPcareActionExaminationEntities);
		pcareCompoundDrugModelsBehaviorSubject = new BehaviorSubject(defaultPcareCompoundDrugEntities);
		pcareDokterModelsBehaviorSubject = new BehaviorSubject(defaultPcareDokterEntities);
		pcareExaminationModelsBehaviorSubject = new BehaviorSubject(defaultPcareExaminationEntities);
		pcareNonCompoundDrugModelsBehaviorSubject = new BehaviorSubject(defaultPcareNonCompoundDrugEntities);
		patientConsentModelsBehaviorSubject = new BehaviorSubject(defaultPatientConsentEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);
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
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		systemAdminUserModelsBehaviorSubject = new BehaviorSubject(defaultSystemAdminUserEntities);
		tariffSchemaModelsBehaviorSubject = new BehaviorSubject(defaultTariffSchemaEntities);
		transferOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultTransferOrderStockDetailEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);
		vaccinationOrderDetailModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderDetailEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);
		warehouseUserModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseUserEntities);

		// selectors for target entity and its related entity
		registrationModelWithIdBehaviorSubject = new BehaviorSubject(registrationWithId);
		bpjsPRBDetailWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.bpjsPRBDetail);
		bpjsPcareRegistrationsWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.bpjsPcareRegistrations);
		bpjsSEPWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.bpjsSEP);
		medicalCertificateDischargeResumeWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.medicalCertificateDischargeResume);
		medicalCertificateBirthWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.medicalCertificateBirth);
		medicalCertificateHospitalizationWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.medicalCertificateHospitalization);
		medicalCertificateMedicalAttendanceWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.medicalCertificateMedicalAttendance);
		medicalCertificateMentalHealthWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.medicalCertificateMentalHealth);
		medicalCertificatePhysicalHealthWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.medicalCertificatePhysicalHealth);
		medicalCertificateRestrictedWorkWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.medicalCertificateRestrictedWork);
		medicalCertificateSickLeaveWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.medicalCertificateSickLeave);
		medicalExaminationRecordWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.medicalExaminationRecord);
		pcareExaminationWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.pcareExamination);
		sepWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.sep);
		diagnosticStaffExaminationSummaryWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.diagnosticStaffExaminationSummary);
		admissionICD10WithIdBehaviorSubject = new BehaviorSubject(registrationWithId.admissionICD10);
		admissionICD9CMWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.admissionICD9CM);
		dismissalReferringFacilityWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.dismissalReferringFacility);
		dismissalReferringStaffWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.dismissalReferringStaff);
		referringUnitWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.referringUnit);
		referringFacilityWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.referringFacility);
		bedFacilityWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.bedFacility);
		patientVisitWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.patientVisit);
		serviceWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.service);
		staffWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.staff);
		requestedByWithIdBehaviorSubject = new BehaviorSubject(registrationWithId.requestedBy);

		spyOn(store, 'select')
			.withArgs(getCountRegistrationModels).and.returnValue(registrationCountBehaviorSubject)
			.withArgs(getRegistrationModelWithId, registrationWithId.id).and.returnValue(registrationModelWithIdBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getAdministrationUserCollectionModels, jasmine.any(String)).and.returnValue(administrationUserModelsBehaviorSubject)
			.withArgs(getAdministratorCollectionModels, jasmine.any(String)).and.returnValue(administratorModelsBehaviorSubject)
			.withArgs(getAmendmentDetailCollectionModels, jasmine.any(String)).and.returnValue(amendmentDetailModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsDiagnosePRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnosePRBModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsDrugGenericPRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsDrugGenericPRBModelsBehaviorSubject)
			.withArgs(getBpjsPRBDetailCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBDetailModelsBehaviorSubject)
			.withArgs(getBpjsPcarePoliCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcarePoliModelsBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareRegistrationsModelsBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getBpjsVisitDataCollectionModels, jasmine.any(String)).and.returnValue(bpjsVisitDataModelsBehaviorSubject)
			.withArgs(getBedFacilityCollectionModels, jasmine.any(String)).and.returnValue(bedFacilityModelsBehaviorSubject)
			.withArgs(getBedReserveCollectionModels, jasmine.any(String)).and.returnValue(bedReserveModelsBehaviorSubject)
			.withArgs(getBirthHistoryCollectionModels, jasmine.any(String)).and.returnValue(birthHistoryModelsBehaviorSubject)
			.withArgs(getBodyChartExaminationCollectionModels, jasmine.any(String)).and.returnValue(bodyChartExaminationModelsBehaviorSubject)
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
			.withArgs(getDiagnosticExaminationResultsCollectionModels, jasmine.any(String)).and.returnValue(diagnosticExaminationResultsModelsBehaviorSubject)
			.withArgs(getDiagnosticStaffExaminationSummaryCollectionModels, jasmine.any(String)).and.returnValue(diagnosticStaffExaminationSummaryModelsBehaviorSubject)
			.withArgs(getDiagnosticSupportUserCollectionModels, jasmine.any(String)).and.returnValue(diagnosticSupportUserModelsBehaviorSubject)
			.withArgs(getDoctorScheduleCollectionModels, jasmine.any(String)).and.returnValue(doctorScheduleModelsBehaviorSubject)
			.withArgs(getDoctorUserCollectionModels, jasmine.any(String)).and.returnValue(doctorUserModelsBehaviorSubject)
			.withArgs(getEntExaminationCollectionModels, jasmine.any(String)).and.returnValue(entExaminationModelsBehaviorSubject)
			.withArgs(getEmergencyMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(emergencyMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getExaminationGroupCollectionModels, jasmine.any(String)).and.returnValue(examinationGroupModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getExaminationItemDetailCollectionModels, jasmine.any(String)).and.returnValue(examinationItemDetailModelsBehaviorSubject)
			.withArgs(getFacilityUserCollectionModels, jasmine.any(String)).and.returnValue(facilityUserModelsBehaviorSubject)
			.withArgs(getFluidBalanceDetailCollectionModels, jasmine.any(String)).and.returnValue(fluidBalanceDetailModelsBehaviorSubject)
			.withArgs(getFormulirKonselingTesHivCollectionModels, jasmine.any(String)).and.returnValue(formulirKonselingTesHivModelsBehaviorSubject)
			.withArgs(getHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(healthFacilityModelsBehaviorSubject)
			.withArgs(getHemodialysisExaminationCollectionModels, jasmine.any(String)).and.returnValue(hemodialysisExaminationModelsBehaviorSubject)
			.withArgs(getHemodialysisMonitoringCollectionModels, jasmine.any(String)).and.returnValue(hemodialysisMonitoringModelsBehaviorSubject)
			.withArgs(getHospitalBranchInformationCollectionModels, jasmine.any(String)).and.returnValue(hospitalBranchInformationModelsBehaviorSubject)
			.withArgs(getIcd10CollectionModels, jasmine.any(String)).and.returnValue(icd10ModelsBehaviorSubject)
			.withArgs(getIcd9CMCollectionModels, jasmine.any(String)).and.returnValue(icd9CMModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInpatientMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(inpatientMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getIntraoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(intraoperativeRecordsModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getInvoiceItemComponentCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemComponentModelsBehaviorSubject)
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
			.withArgs(getMedicalFeeItemComponentCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeItemComponentModelsBehaviorSubject)
			.withArgs(getMedicalRecordInitialChecklistCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordInitialChecklistModelsBehaviorSubject)
			.withArgs(getMedicalRecordNextVerificationChecklistCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordNextVerificationChecklistModelsBehaviorSubject)
			.withArgs(getMedicalRecordUserCollectionModels, jasmine.any(String)).and.returnValue(medicalRecordUserModelsBehaviorSubject)
			.withArgs(getMedicalTranscriberUserCollectionModels, jasmine.any(String)).and.returnValue(medicalTranscriberUserModelsBehaviorSubject)
			.withArgs(getMedicationAdministeredHistoryCollectionModels, jasmine.any(String)).and.returnValue(medicationAdministeredHistoryModelsBehaviorSubject)
			.withArgs(getMedicationCompoundCollectionModels, jasmine.any(String)).and.returnValue(medicationCompoundModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getMedicationItemCollectionModels, jasmine.any(String)).and.returnValue(medicationItemModelsBehaviorSubject)
			.withArgs(getNewbornDetailCollectionModels, jasmine.any(String)).and.returnValue(newbornDetailModelsBehaviorSubject)
			.withArgs(getNurseUserCollectionModels, jasmine.any(String)).and.returnValue(nurseUserModelsBehaviorSubject)
			.withArgs(getNurseVitalSignMeasurementCollectionModels, jasmine.any(String)).and.returnValue(nurseVitalSignMeasurementModelsBehaviorSubject)
			.withArgs(getObstetricAndGynecologyHistoryCollectionModels, jasmine.any(String)).and.returnValue(obstetricAndGynecologyHistoryModelsBehaviorSubject)
			.withArgs(getOdontogramExaminationCollectionModels, jasmine.any(String)).and.returnValue(odontogramExaminationModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(operatingTheaterMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getOphthalmologyExaminationCollectionModels, jasmine.any(String)).and.returnValue(ophthalmologyExaminationModelsBehaviorSubject)
			.withArgs(getPcareActionExaminationCollectionModels, jasmine.any(String)).and.returnValue(pcareActionExaminationModelsBehaviorSubject)
			.withArgs(getPcareCompoundDrugCollectionModels, jasmine.any(String)).and.returnValue(pcareCompoundDrugModelsBehaviorSubject)
			.withArgs(getPcareDokterCollectionModels, jasmine.any(String)).and.returnValue(pcareDokterModelsBehaviorSubject)
			.withArgs(getPcareExaminationCollectionModels, jasmine.any(String)).and.returnValue(pcareExaminationModelsBehaviorSubject)
			.withArgs(getPcareNonCompoundDrugCollectionModels, jasmine.any(String)).and.returnValue(pcareNonCompoundDrugModelsBehaviorSubject)
			.withArgs(getPatientConsentCollectionModels, jasmine.any(String)).and.returnValue(patientConsentModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
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
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getSystemAdminUserCollectionModels, jasmine.any(String)).and.returnValue(systemAdminUserModelsBehaviorSubject)
			.withArgs(getTariffSchemaCollectionModels, jasmine.any(String)).and.returnValue(tariffSchemaModelsBehaviorSubject)
			.withArgs(getTransferOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(transferOrderStockDetailModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getVaccinationOrderDetailCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderDetailModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getWarehouseUserCollectionModels, jasmine.any(String)).and.returnValue(warehouseUserModelsBehaviorSubject)
			.withArgs(getBpjsPRBDetailModelWithId, registrationWithId.bpjsPRBDetailId).and.returnValue(bpjsPRBDetailWithIdBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsModelWithId, registrationWithId.bpjsPcareRegistrationsId).and.returnValue(bpjsPcareRegistrationsWithIdBehaviorSubject)
			.withArgs(getBpjsSEPModelWithId, registrationWithId.bpjsSEPId).and.returnValue(bpjsSEPWithIdBehaviorSubject)
			.withArgs(getMedicalCertificateDischargeResumeModelWithId, registrationWithId.medicalCertificateDischargeResumeId).and.returnValue(medicalCertificateDischargeResumeWithIdBehaviorSubject)
			.withArgs(getMedicalCertificateBirthModelWithId, registrationWithId.medicalCertificateBirthId).and.returnValue(medicalCertificateBirthWithIdBehaviorSubject)
			.withArgs(getMedicalCertificateHospitalizationModelWithId, registrationWithId.medicalCertificateHospitalizationId).and.returnValue(medicalCertificateHospitalizationWithIdBehaviorSubject)
			.withArgs(getMedicalCertificateMedicalAttendanceModelWithId, registrationWithId.medicalCertificateMedicalAttendanceId).and.returnValue(medicalCertificateMedicalAttendanceWithIdBehaviorSubject)
			.withArgs(getMedicalCertificateMentalHealthModelWithId, registrationWithId.medicalCertificateMentalHealthId).and.returnValue(medicalCertificateMentalHealthWithIdBehaviorSubject)
			.withArgs(getMedicalCertificatePhysicalHealthModelWithId, registrationWithId.medicalCertificatePhysicalHealthId).and.returnValue(medicalCertificatePhysicalHealthWithIdBehaviorSubject)
			.withArgs(getMedicalCertificateRestrictedWorkModelWithId, registrationWithId.medicalCertificateRestrictedWorkId).and.returnValue(medicalCertificateRestrictedWorkWithIdBehaviorSubject)
			.withArgs(getMedicalCertificateSickLeaveModelWithId, registrationWithId.medicalCertificateSickLeaveId).and.returnValue(medicalCertificateSickLeaveWithIdBehaviorSubject)
			.withArgs(getMedicalExaminationRecordModelWithId, registrationWithId.medicalExaminationRecordId).and.returnValue(medicalExaminationRecordWithIdBehaviorSubject)
			.withArgs(getPcareExaminationModelWithId, registrationWithId.pcareExaminationId).and.returnValue(pcareExaminationWithIdBehaviorSubject)
			.withArgs(getSepModelWithId, registrationWithId.sepId).and.returnValue(sepWithIdBehaviorSubject)
			.withArgs(getDiagnosticStaffExaminationSummaryModelWithId, registrationWithId.diagnosticStaffExaminationSummaryId).and.returnValue(diagnosticStaffExaminationSummaryWithIdBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresModelWithId, registrationWithId.admissionICD10Id).and.returnValue(admissionICD10WithIdBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresModelWithId, registrationWithId.admissionICD9CMId).and.returnValue(admissionICD9CMWithIdBehaviorSubject)
			.withArgs(getHealthFacilityModelWithId, registrationWithId.dismissalReferringFacilityId).and.returnValue(dismissalReferringFacilityWithIdBehaviorSubject)
			.withArgs(getStaffModelWithId, registrationWithId.dismissalReferringStaffId).and.returnValue(dismissalReferringStaffWithIdBehaviorSubject)
			.withArgs(getServiceModelWithId, registrationWithId.referringUnitId).and.returnValue(referringUnitWithIdBehaviorSubject)
			.withArgs(getHealthFacilityModelWithId, registrationWithId.referringFacilityId).and.returnValue(referringFacilityWithIdBehaviorSubject)
			.withArgs(getBedFacilityModelWithId, registrationWithId.bedFacilityId).and.returnValue(bedFacilityWithIdBehaviorSubject)
			.withArgs(getPatientVisitModelWithId, registrationWithId.patientVisitId).and.returnValue(patientVisitWithIdBehaviorSubject)
			.withArgs(getServiceModelWithId, registrationWithId.serviceId).and.returnValue(serviceWithIdBehaviorSubject)
			.withArgs(getStaffModelWithId, registrationWithId.staffId).and.returnValue(staffWithIdBehaviorSubject)
			.withArgs(getStaffModelWithId, registrationWithId.requestedById).and.returnValue(requestedByWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				RegistrationCrudModule,
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

			fixture = TestBed.createComponent(RegistrationCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new RegistrationModel();
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
	it ('Renders the Registration CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the BPJS PRB Detail relation.
	*
	* The button should only exist if bpjsPRBDetailMultiCrudActive is true
	*/
	it ('Renders BPJS PRB Detail Add Entity button in create mode', fakeAsync(() => {
		const bpjsPRBDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBDetailDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsPRBDetailButton).toEqual(component.bpjsPRBDetailMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS PRB Detail', fakeAsync(() => {
		const bpjsPRBDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPRBDetailButton).toEqual(component.bpjsPRBDetailMultiCrudActive);

		if (component.bpjsPRBDetailMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsPRBDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBDetailDisplayName + ' from Model')).length;

			bpjsPRBDetailButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPRBDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBDetailDisplayName + ' from Model')).length;

			expect(actualBpjsPRBDetailRemoveButtonCount).toEqual(initialBpjsPRBDetailRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS PRB Detail button', () => {
		const bpjsPRBDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPRBDetailButton).toEqual(component.bpjsPRBDetailMultiCrudActive);

		if (component.bpjsPRBDetailMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsPRBDetailButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsPRBDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBDetailDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsPRBDetailRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPRBDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBDetailDisplayName + ' from Model'));

			expect(actualBpjsPRBDetailRemoveButtons.length).toEqual(initialBpjsPRBDetailRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS PRB Detail button when one has already been added', () => {

		const bpjsPRBDetailButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPRBDetailButton).toEqual(component.bpjsPRBDetailMultiCrudActive);

		if (component.bpjsPRBDetailMultiCrudActive) {
			bpjsPRBDetailButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsPRBDetailButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBDetailDisplayName + ' to Model'));

			expect(updatedbpjsPRBDetailButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS PRB Detail entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsPRBDetailMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsPRBDetailRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBDetailDisplayName + ' from Model')).length;

			expect(bpjsPRBDetailRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Pcare Registrations relation.
	*
	* The button should only exist if bpjsPcareRegistrationsMultiCrudActive is true
	*/
	it ('Renders BPJS Pcare Registrations Add Entity button in create mode', fakeAsync(() => {
		const bpjsPcareRegistrationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareRegistrationsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsPcareRegistrationsButton).toEqual(component.bpjsPcareRegistrationsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Pcare Registrations', fakeAsync(() => {
		const bpjsPcareRegistrationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareRegistrationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPcareRegistrationsButton).toEqual(component.bpjsPcareRegistrationsMultiCrudActive);

		if (component.bpjsPcareRegistrationsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsPcareRegistrationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareRegistrationsDisplayName + ' from Model')).length;

			bpjsPcareRegistrationsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPcareRegistrationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareRegistrationsDisplayName + ' from Model')).length;

			expect(actualBpjsPcareRegistrationsRemoveButtonCount).toEqual(initialBpjsPcareRegistrationsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Pcare Registrations button', () => {
		const bpjsPcareRegistrationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareRegistrationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPcareRegistrationsButton).toEqual(component.bpjsPcareRegistrationsMultiCrudActive);

		if (component.bpjsPcareRegistrationsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsPcareRegistrationsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsPcareRegistrationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareRegistrationsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsPcareRegistrationsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPcareRegistrationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareRegistrationsDisplayName + ' from Model'));

			expect(actualBpjsPcareRegistrationsRemoveButtons.length).toEqual(initialBpjsPcareRegistrationsRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Pcare Registrations button when one has already been added', () => {

		const bpjsPcareRegistrationsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareRegistrationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPcareRegistrationsButton).toEqual(component.bpjsPcareRegistrationsMultiCrudActive);

		if (component.bpjsPcareRegistrationsMultiCrudActive) {
			bpjsPcareRegistrationsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsPcareRegistrationsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPcareRegistrationsDisplayName + ' to Model'));

			expect(updatedbpjsPcareRegistrationsButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Pcare Registrations entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsPcareRegistrationsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsPcareRegistrationsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPcareRegistrationsDisplayName + ' from Model')).length;

			expect(bpjsPcareRegistrationsRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS SEP relation.
	*
	* The button should only exist if bpjsSEPMultiCrudActive is true
	*/
	it ('Renders BPJS SEP Add Entity button in create mode', fakeAsync(() => {
		const bpjsSEPButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsSEPDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsSEPButton).toEqual(component.bpjsSEPMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS SEP', fakeAsync(() => {
		const bpjsSEPButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsSEPDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsSEPButton).toEqual(component.bpjsSEPMultiCrudActive);

		if (component.bpjsSEPMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsSEPRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsSEPDisplayName + ' from Model')).length;

			bpjsSEPButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsSEPRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsSEPDisplayName + ' from Model')).length;

			expect(actualBpjsSEPRemoveButtonCount).toEqual(initialBpjsSEPRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS SEP button', () => {
		const bpjsSEPButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsSEPDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsSEPButton).toEqual(component.bpjsSEPMultiCrudActive);

		if (component.bpjsSEPMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsSEPButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsSEPRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsSEPDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsSEPRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsSEPRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsSEPDisplayName + ' from Model'));

			expect(actualBpjsSEPRemoveButtons.length).toEqual(initialBpjsSEPRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS SEP button when one has already been added', () => {

		const bpjsSEPButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsSEPDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsSEPButton).toEqual(component.bpjsSEPMultiCrudActive);

		if (component.bpjsSEPMultiCrudActive) {
			bpjsSEPButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsSEPButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsSEPDisplayName + ' to Model'));

			expect(updatedbpjsSEPButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS SEP entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsSEPMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsSEPRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsSEPDisplayName + ' from Model')).length;

			expect(bpjsSEPRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate  Discharge Resume relation.
	*
	* The button should only exist if medicalCertificateDischargeResumeMultiCrudActive is true
	*/
	it ('Renders Medical Certificate  Discharge Resume Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateDischargeResumeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumeDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateDischargeResumeButton).toEqual(component.medicalCertificateDischargeResumeMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate  Discharge Resume', fakeAsync(() => {
		const medicalCertificateDischargeResumeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateDischargeResumeButton).toEqual(component.medicalCertificateDischargeResumeMultiCrudActive);

		if (component.medicalCertificateDischargeResumeMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateDischargeResumeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumeDisplayName + ' from Model')).length;

			medicalCertificateDischargeResumeButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateDischargeResumeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumeDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateDischargeResumeRemoveButtonCount).toEqual(initialMedicalCertificateDischargeResumeRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate  Discharge Resume button', () => {
		const medicalCertificateDischargeResumeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateDischargeResumeButton).toEqual(component.medicalCertificateDischargeResumeMultiCrudActive);

		if (component.medicalCertificateDischargeResumeMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateDischargeResumeButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateDischargeResumeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumeDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateDischargeResumeRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateDischargeResumeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumeDisplayName + ' from Model'));

			expect(actualMedicalCertificateDischargeResumeRemoveButtons.length).toEqual(initialMedicalCertificateDischargeResumeRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Certificate  Discharge Resume button when one has already been added', () => {

		const medicalCertificateDischargeResumeButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateDischargeResumeButton).toEqual(component.medicalCertificateDischargeResumeMultiCrudActive);

		if (component.medicalCertificateDischargeResumeMultiCrudActive) {
			medicalCertificateDischargeResumeButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateDischargeResumeButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateDischargeResumeDisplayName + ' to Model'));

			expect(updatedmedicalCertificateDischargeResumeButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Certificate  Discharge Resume entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateDischargeResumeMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateDischargeResumeRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateDischargeResumeDisplayName + ' from Model')).length;

			expect(medicalCertificateDischargeResumeRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate Birth relation.
	*
	* The button should only exist if medicalCertificateBirthMultiCrudActive is true
	*/
	it ('Renders Medical Certificate Birth Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateBirthButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateBirthButton).toEqual(component.medicalCertificateBirthMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate Birth', fakeAsync(() => {
		const medicalCertificateBirthButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateBirthButton).toEqual(component.medicalCertificateBirthMultiCrudActive);

		if (component.medicalCertificateBirthMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateBirthRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthDisplayName + ' from Model')).length;

			medicalCertificateBirthButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateBirthRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateBirthRemoveButtonCount).toEqual(initialMedicalCertificateBirthRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate Birth button', () => {
		const medicalCertificateBirthButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateBirthButton).toEqual(component.medicalCertificateBirthMultiCrudActive);

		if (component.medicalCertificateBirthMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateBirthButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateBirthRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateBirthRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateBirthRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthDisplayName + ' from Model'));

			expect(actualMedicalCertificateBirthRemoveButtons.length).toEqual(initialMedicalCertificateBirthRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Certificate Birth button when one has already been added', () => {

		const medicalCertificateBirthButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateBirthButton).toEqual(component.medicalCertificateBirthMultiCrudActive);

		if (component.medicalCertificateBirthMultiCrudActive) {
			medicalCertificateBirthButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateBirthButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateBirthDisplayName + ' to Model'));

			expect(updatedmedicalCertificateBirthButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Certificate Birth entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateBirthMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateBirthRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateBirthDisplayName + ' from Model')).length;

			expect(medicalCertificateBirthRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate Hospitalization relation.
	*
	* The button should only exist if medicalCertificateHospitalizationMultiCrudActive is true
	*/
	it ('Renders Medical Certificate Hospitalization Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateHospitalizationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateHospitalizationButton).toEqual(component.medicalCertificateHospitalizationMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate Hospitalization', fakeAsync(() => {
		const medicalCertificateHospitalizationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateHospitalizationButton).toEqual(component.medicalCertificateHospitalizationMultiCrudActive);

		if (component.medicalCertificateHospitalizationMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateHospitalizationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationDisplayName + ' from Model')).length;

			medicalCertificateHospitalizationButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateHospitalizationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateHospitalizationRemoveButtonCount).toEqual(initialMedicalCertificateHospitalizationRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate Hospitalization button', () => {
		const medicalCertificateHospitalizationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateHospitalizationButton).toEqual(component.medicalCertificateHospitalizationMultiCrudActive);

		if (component.medicalCertificateHospitalizationMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateHospitalizationButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateHospitalizationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateHospitalizationRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateHospitalizationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationDisplayName + ' from Model'));

			expect(actualMedicalCertificateHospitalizationRemoveButtons.length).toEqual(initialMedicalCertificateHospitalizationRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Certificate Hospitalization button when one has already been added', () => {

		const medicalCertificateHospitalizationButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateHospitalizationButton).toEqual(component.medicalCertificateHospitalizationMultiCrudActive);

		if (component.medicalCertificateHospitalizationMultiCrudActive) {
			medicalCertificateHospitalizationButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateHospitalizationButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateHospitalizationDisplayName + ' to Model'));

			expect(updatedmedicalCertificateHospitalizationButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Certificate Hospitalization entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateHospitalizationMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateHospitalizationRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateHospitalizationDisplayName + ' from Model')).length;

			expect(medicalCertificateHospitalizationRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate Medical Attendance relation.
	*
	* The button should only exist if medicalCertificateMedicalAttendanceMultiCrudActive is true
	*/
	it ('Renders Medical Certificate Medical Attendance Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateMedicalAttendanceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMedicalAttendanceDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateMedicalAttendanceButton).toEqual(component.medicalCertificateMedicalAttendanceMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate Medical Attendance', fakeAsync(() => {
		const medicalCertificateMedicalAttendanceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMedicalAttendanceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateMedicalAttendanceButton).toEqual(component.medicalCertificateMedicalAttendanceMultiCrudActive);

		if (component.medicalCertificateMedicalAttendanceMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateMedicalAttendanceRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMedicalAttendanceDisplayName + ' from Model')).length;

			medicalCertificateMedicalAttendanceButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateMedicalAttendanceRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMedicalAttendanceDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateMedicalAttendanceRemoveButtonCount).toEqual(initialMedicalCertificateMedicalAttendanceRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate Medical Attendance button', () => {
		const medicalCertificateMedicalAttendanceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMedicalAttendanceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateMedicalAttendanceButton).toEqual(component.medicalCertificateMedicalAttendanceMultiCrudActive);

		if (component.medicalCertificateMedicalAttendanceMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateMedicalAttendanceButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateMedicalAttendanceRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMedicalAttendanceDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateMedicalAttendanceRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateMedicalAttendanceRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMedicalAttendanceDisplayName + ' from Model'));

			expect(actualMedicalCertificateMedicalAttendanceRemoveButtons.length).toEqual(initialMedicalCertificateMedicalAttendanceRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Certificate Medical Attendance button when one has already been added', () => {

		const medicalCertificateMedicalAttendanceButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMedicalAttendanceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateMedicalAttendanceButton).toEqual(component.medicalCertificateMedicalAttendanceMultiCrudActive);

		if (component.medicalCertificateMedicalAttendanceMultiCrudActive) {
			medicalCertificateMedicalAttendanceButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateMedicalAttendanceButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMedicalAttendanceDisplayName + ' to Model'));

			expect(updatedmedicalCertificateMedicalAttendanceButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Certificate Medical Attendance entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateMedicalAttendanceMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateMedicalAttendanceRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMedicalAttendanceDisplayName + ' from Model')).length;

			expect(medicalCertificateMedicalAttendanceRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate Mental Health relation.
	*
	* The button should only exist if medicalCertificateMentalHealthMultiCrudActive is true
	*/
	it ('Renders Medical Certificate Mental Health Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateMentalHealthButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMentalHealthDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateMentalHealthButton).toEqual(component.medicalCertificateMentalHealthMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate Mental Health', fakeAsync(() => {
		const medicalCertificateMentalHealthButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMentalHealthDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateMentalHealthButton).toEqual(component.medicalCertificateMentalHealthMultiCrudActive);

		if (component.medicalCertificateMentalHealthMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateMentalHealthRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMentalHealthDisplayName + ' from Model')).length;

			medicalCertificateMentalHealthButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateMentalHealthRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMentalHealthDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateMentalHealthRemoveButtonCount).toEqual(initialMedicalCertificateMentalHealthRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate Mental Health button', () => {
		const medicalCertificateMentalHealthButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMentalHealthDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateMentalHealthButton).toEqual(component.medicalCertificateMentalHealthMultiCrudActive);

		if (component.medicalCertificateMentalHealthMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateMentalHealthButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateMentalHealthRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMentalHealthDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateMentalHealthRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateMentalHealthRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMentalHealthDisplayName + ' from Model'));

			expect(actualMedicalCertificateMentalHealthRemoveButtons.length).toEqual(initialMedicalCertificateMentalHealthRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Certificate Mental Health button when one has already been added', () => {

		const medicalCertificateMentalHealthButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMentalHealthDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateMentalHealthButton).toEqual(component.medicalCertificateMentalHealthMultiCrudActive);

		if (component.medicalCertificateMentalHealthMultiCrudActive) {
			medicalCertificateMentalHealthButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateMentalHealthButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateMentalHealthDisplayName + ' to Model'));

			expect(updatedmedicalCertificateMentalHealthButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Certificate Mental Health entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateMentalHealthMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateMentalHealthRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateMentalHealthDisplayName + ' from Model')).length;

			expect(medicalCertificateMentalHealthRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate Physical Health relation.
	*
	* The button should only exist if medicalCertificatePhysicalHealthMultiCrudActive is true
	*/
	it ('Renders Medical Certificate Physical Health Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificatePhysicalHealthButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificatePhysicalHealthDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificatePhysicalHealthButton).toEqual(component.medicalCertificatePhysicalHealthMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate Physical Health', fakeAsync(() => {
		const medicalCertificatePhysicalHealthButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificatePhysicalHealthDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificatePhysicalHealthButton).toEqual(component.medicalCertificatePhysicalHealthMultiCrudActive);

		if (component.medicalCertificatePhysicalHealthMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificatePhysicalHealthRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificatePhysicalHealthDisplayName + ' from Model')).length;

			medicalCertificatePhysicalHealthButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificatePhysicalHealthRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificatePhysicalHealthDisplayName + ' from Model')).length;

			expect(actualMedicalCertificatePhysicalHealthRemoveButtonCount).toEqual(initialMedicalCertificatePhysicalHealthRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate Physical Health button', () => {
		const medicalCertificatePhysicalHealthButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificatePhysicalHealthDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificatePhysicalHealthButton).toEqual(component.medicalCertificatePhysicalHealthMultiCrudActive);

		if (component.medicalCertificatePhysicalHealthMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificatePhysicalHealthButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificatePhysicalHealthRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificatePhysicalHealthDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificatePhysicalHealthRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificatePhysicalHealthRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificatePhysicalHealthDisplayName + ' from Model'));

			expect(actualMedicalCertificatePhysicalHealthRemoveButtons.length).toEqual(initialMedicalCertificatePhysicalHealthRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Certificate Physical Health button when one has already been added', () => {

		const medicalCertificatePhysicalHealthButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificatePhysicalHealthDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificatePhysicalHealthButton).toEqual(component.medicalCertificatePhysicalHealthMultiCrudActive);

		if (component.medicalCertificatePhysicalHealthMultiCrudActive) {
			medicalCertificatePhysicalHealthButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificatePhysicalHealthButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificatePhysicalHealthDisplayName + ' to Model'));

			expect(updatedmedicalCertificatePhysicalHealthButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Certificate Physical Health entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificatePhysicalHealthMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificatePhysicalHealthRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificatePhysicalHealthDisplayName + ' from Model')).length;

			expect(medicalCertificatePhysicalHealthRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate Restricted Work relation.
	*
	* The button should only exist if medicalCertificateRestrictedWorkMultiCrudActive is true
	*/
	it ('Renders Medical Certificate Restricted Work Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateRestrictedWorkButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateRestrictedWorkDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateRestrictedWorkButton).toEqual(component.medicalCertificateRestrictedWorkMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate Restricted Work', fakeAsync(() => {
		const medicalCertificateRestrictedWorkButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateRestrictedWorkDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateRestrictedWorkButton).toEqual(component.medicalCertificateRestrictedWorkMultiCrudActive);

		if (component.medicalCertificateRestrictedWorkMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateRestrictedWorkRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateRestrictedWorkDisplayName + ' from Model')).length;

			medicalCertificateRestrictedWorkButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateRestrictedWorkRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateRestrictedWorkDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateRestrictedWorkRemoveButtonCount).toEqual(initialMedicalCertificateRestrictedWorkRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate Restricted Work button', () => {
		const medicalCertificateRestrictedWorkButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateRestrictedWorkDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateRestrictedWorkButton).toEqual(component.medicalCertificateRestrictedWorkMultiCrudActive);

		if (component.medicalCertificateRestrictedWorkMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateRestrictedWorkButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateRestrictedWorkRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateRestrictedWorkDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateRestrictedWorkRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateRestrictedWorkRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateRestrictedWorkDisplayName + ' from Model'));

			expect(actualMedicalCertificateRestrictedWorkRemoveButtons.length).toEqual(initialMedicalCertificateRestrictedWorkRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Certificate Restricted Work button when one has already been added', () => {

		const medicalCertificateRestrictedWorkButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateRestrictedWorkDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateRestrictedWorkButton).toEqual(component.medicalCertificateRestrictedWorkMultiCrudActive);

		if (component.medicalCertificateRestrictedWorkMultiCrudActive) {
			medicalCertificateRestrictedWorkButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateRestrictedWorkButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateRestrictedWorkDisplayName + ' to Model'));

			expect(updatedmedicalCertificateRestrictedWorkButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Certificate Restricted Work entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateRestrictedWorkMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateRestrictedWorkRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateRestrictedWorkDisplayName + ' from Model')).length;

			expect(medicalCertificateRestrictedWorkRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Certificate Sick Leave relation.
	*
	* The button should only exist if medicalCertificateSickLeaveMultiCrudActive is true
	*/
	it ('Renders Medical Certificate Sick Leave Add Entity button in create mode', fakeAsync(() => {
		const medicalCertificateSickLeaveButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateSickLeaveDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalCertificateSickLeaveButton).toEqual(component.medicalCertificateSickLeaveMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Certificate Sick Leave', fakeAsync(() => {
		const medicalCertificateSickLeaveButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateSickLeaveDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateSickLeaveButton).toEqual(component.medicalCertificateSickLeaveMultiCrudActive);

		if (component.medicalCertificateSickLeaveMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalCertificateSickLeaveRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateSickLeaveDisplayName + ' from Model')).length;

			medicalCertificateSickLeaveButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateSickLeaveRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateSickLeaveDisplayName + ' from Model')).length;

			expect(actualMedicalCertificateSickLeaveRemoveButtonCount).toEqual(initialMedicalCertificateSickLeaveRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Certificate Sick Leave button', () => {
		const medicalCertificateSickLeaveButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateSickLeaveDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateSickLeaveButton).toEqual(component.medicalCertificateSickLeaveMultiCrudActive);

		if (component.medicalCertificateSickLeaveMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalCertificateSickLeaveButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalCertificateSickLeaveRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateSickLeaveDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalCertificateSickLeaveRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalCertificateSickLeaveRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateSickLeaveDisplayName + ' from Model'));

			expect(actualMedicalCertificateSickLeaveRemoveButtons.length).toEqual(initialMedicalCertificateSickLeaveRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Medical Certificate Sick Leave button when one has already been added', () => {

		const medicalCertificateSickLeaveButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateSickLeaveDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalCertificateSickLeaveButton).toEqual(component.medicalCertificateSickLeaveMultiCrudActive);

		if (component.medicalCertificateSickLeaveMultiCrudActive) {
			medicalCertificateSickLeaveButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalCertificateSickLeaveButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalCertificateSickLeaveDisplayName + ' to Model'));

			expect(updatedmedicalCertificateSickLeaveButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Medical Certificate Sick Leave entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalCertificateSickLeaveMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalCertificateSickLeaveRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalCertificateSickLeaveDisplayName + ' from Model')).length;

			expect(medicalCertificateSickLeaveRemoveButtonCount).toEqual(1);
		}
	});

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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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
	* Checks that the status of the add model button matches the multi entity status for the PCare Examination relation.
	*
	* The button should only exist if pcareExaminationMultiCrudActive is true
	*/
	it ('Renders PCare Examination Add Entity button in create mode', fakeAsync(() => {
		const pcareExaminationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareExaminationDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!pcareExaminationButton).toEqual(component.pcareExaminationMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new PCare Examination', fakeAsync(() => {
		const pcareExaminationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareExaminationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pcareExaminationButton).toEqual(component.pcareExaminationMultiCrudActive);

		if (component.pcareExaminationMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPcareExaminationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareExaminationDisplayName + ' from Model')).length;

			pcareExaminationButton.nativeElement.click();
			fixture.detectChanges();

			const actualPcareExaminationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareExaminationDisplayName + ' from Model')).length;

			expect(actualPcareExaminationRemoveButtonCount).toEqual(initialPcareExaminationRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove PCare Examination button', () => {
		const pcareExaminationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareExaminationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pcareExaminationButton).toEqual(component.pcareExaminationMultiCrudActive);

		if (component.pcareExaminationMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			pcareExaminationButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPcareExaminationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareExaminationDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPcareExaminationRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPcareExaminationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareExaminationDisplayName + ' from Model'));

			expect(actualPcareExaminationRemoveButtons.length).toEqual(initialPcareExaminationRemoveButtons.length - 1);
		}
	});

	it ('should disable the add PCare Examination button when one has already been added', () => {

		const pcareExaminationButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareExaminationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!pcareExaminationButton).toEqual(component.pcareExaminationMultiCrudActive);

		if (component.pcareExaminationMultiCrudActive) {
			pcareExaminationButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpcareExaminationButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.pcareExaminationDisplayName + ' to Model'));

			expect(updatedpcareExaminationButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related PCare Examination entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.pcareExaminationMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const pcareExaminationRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.pcareExaminationDisplayName + ' from Model')).length;

			expect(pcareExaminationRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the SEP relation.
	*
	* The button should only exist if sepMultiCrudActive is true
	*/
	it ('Renders SEP Add Entity button in create mode', fakeAsync(() => {
		const sepButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sepDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!sepButton).toEqual(component.sepMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new SEP', fakeAsync(() => {
		const sepButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sepDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sepButton).toEqual(component.sepMultiCrudActive);

		if (component.sepMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSepRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sepDisplayName + ' from Model')).length;

			sepButton.nativeElement.click();
			fixture.detectChanges();

			const actualSepRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sepDisplayName + ' from Model')).length;

			expect(actualSepRemoveButtonCount).toEqual(initialSepRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove SEP button', () => {
		const sepButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sepDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sepButton).toEqual(component.sepMultiCrudActive);

		if (component.sepMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			sepButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSepRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sepDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSepRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSepRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sepDisplayName + ' from Model'));

			expect(actualSepRemoveButtons.length).toEqual(initialSepRemoveButtons.length - 1);
		}
	});

	it ('should disable the add SEP button when one has already been added', () => {

		const sepButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.sepDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sepButton).toEqual(component.sepMultiCrudActive);

		if (component.sepMultiCrudActive) {
			sepButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsepButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.sepDisplayName + ' to Model'));

			expect(updatedsepButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related SEP entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.sepMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const sepRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sepDisplayName + ' from Model')).length;

			expect(sepRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Diagnostic Staff Examination Summary relation.
	*
	* The button should only exist if diagnosticStaffExaminationSummaryMultiCrudActive is true
	*/
	it ('Renders Diagnostic Staff Examination Summary Add Entity button in create mode', fakeAsync(() => {
		const diagnosticStaffExaminationSummaryButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummaryDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!diagnosticStaffExaminationSummaryButton).toEqual(component.diagnosticStaffExaminationSummaryMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Diagnostic Staff Examination Summary', fakeAsync(() => {
		const diagnosticStaffExaminationSummaryButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummaryDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticStaffExaminationSummaryButton).toEqual(component.diagnosticStaffExaminationSummaryMultiCrudActive);

		if (component.diagnosticStaffExaminationSummaryMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDiagnosticStaffExaminationSummaryRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummaryDisplayName + ' from Model')).length;

			diagnosticStaffExaminationSummaryButton.nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosticStaffExaminationSummaryRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummaryDisplayName + ' from Model')).length;

			expect(actualDiagnosticStaffExaminationSummaryRemoveButtonCount).toEqual(initialDiagnosticStaffExaminationSummaryRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Diagnostic Staff Examination Summary button', () => {
		const diagnosticStaffExaminationSummaryButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummaryDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticStaffExaminationSummaryButton).toEqual(component.diagnosticStaffExaminationSummaryMultiCrudActive);

		if (component.diagnosticStaffExaminationSummaryMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			diagnosticStaffExaminationSummaryButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDiagnosticStaffExaminationSummaryRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummaryDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDiagnosticStaffExaminationSummaryRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosticStaffExaminationSummaryRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummaryDisplayName + ' from Model'));

			expect(actualDiagnosticStaffExaminationSummaryRemoveButtons.length).toEqual(initialDiagnosticStaffExaminationSummaryRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Diagnostic Staff Examination Summary button when one has already been added', () => {

		const diagnosticStaffExaminationSummaryButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummaryDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticStaffExaminationSummaryButton).toEqual(component.diagnosticStaffExaminationSummaryMultiCrudActive);

		if (component.diagnosticStaffExaminationSummaryMultiCrudActive) {
			diagnosticStaffExaminationSummaryButton.nativeElement.click();
			fixture.detectChanges();

			const updateddiagnosticStaffExaminationSummaryButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticStaffExaminationSummaryDisplayName + ' to Model'));

			expect(updateddiagnosticStaffExaminationSummaryButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Diagnostic Staff Examination Summary entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.diagnosticStaffExaminationSummaryMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const diagnosticStaffExaminationSummaryRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticStaffExaminationSummaryDisplayName + ' from Model')).length;

			expect(diagnosticStaffExaminationSummaryRemoveButtonCount).toEqual(1);
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

	it ('should disable the add Admission ICD 10 button when one has already been added', () => {

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

			expect(updatedadmissionICD10Button.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Admission ICD 10 entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(admissionICD10RemoveButtonCount).toEqual(1);
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

	it ('should disable the add Admission ICD 9 CM button when one has already been added', () => {

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

			expect(updatedadmissionICD9CMButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Admission ICD 9 CM entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(admissionICD9CMRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Dismissal Referring Facility relation.
	*
	* The button should only exist if dismissalReferringFacilityMultiCrudActive is true
	*/
	it ('Renders Dismissal Referring Facility Add Entity button in create mode', fakeAsync(() => {
		const dismissalReferringFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringFacilityDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!dismissalReferringFacilityButton).toEqual(component.dismissalReferringFacilityMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Dismissal Referring Facility', fakeAsync(() => {
		const dismissalReferringFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dismissalReferringFacilityButton).toEqual(component.dismissalReferringFacilityMultiCrudActive);

		if (component.dismissalReferringFacilityMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDismissalReferringFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringFacilityDisplayName + ' from Model')).length;

			dismissalReferringFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const actualDismissalReferringFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringFacilityDisplayName + ' from Model')).length;

			expect(actualDismissalReferringFacilityRemoveButtonCount).toEqual(initialDismissalReferringFacilityRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Dismissal Referring Facility button', () => {
		const dismissalReferringFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dismissalReferringFacilityButton).toEqual(component.dismissalReferringFacilityMultiCrudActive);

		if (component.dismissalReferringFacilityMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			dismissalReferringFacilityButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDismissalReferringFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringFacilityDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDismissalReferringFacilityRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDismissalReferringFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringFacilityDisplayName + ' from Model'));

			expect(actualDismissalReferringFacilityRemoveButtons.length).toEqual(initialDismissalReferringFacilityRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Dismissal Referring Facility button when one has already been added', () => {

		const dismissalReferringFacilityButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!dismissalReferringFacilityButton).toEqual(component.dismissalReferringFacilityMultiCrudActive);

		if (component.dismissalReferringFacilityMultiCrudActive) {
			dismissalReferringFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const updateddismissalReferringFacilityButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.dismissalReferringFacilityDisplayName + ' to Model'));

			expect(updateddismissalReferringFacilityButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Dismissal Referring Facility entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.dismissalReferringFacilityMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const dismissalReferringFacilityRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.dismissalReferringFacilityDisplayName + ' from Model')).length;

			expect(dismissalReferringFacilityRemoveButtonCount).toEqual(1);
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

	it ('should disable the add Dismissal Referring Staff button when one has already been added', () => {

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

			expect(updateddismissalReferringStaffButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Dismissal Referring Staff entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(dismissalReferringStaffRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Referring Unit relation.
	*
	* The button should only exist if referringUnitMultiCrudActive is true
	*/
	it ('Renders Referring Unit Add Entity button in create mode', fakeAsync(() => {
		const referringUnitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringUnitDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!referringUnitButton).toEqual(component.referringUnitMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Referring Unit', fakeAsync(() => {
		const referringUnitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringUnitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!referringUnitButton).toEqual(component.referringUnitMultiCrudActive);

		if (component.referringUnitMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialReferringUnitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringUnitDisplayName + ' from Model')).length;

			referringUnitButton.nativeElement.click();
			fixture.detectChanges();

			const actualReferringUnitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringUnitDisplayName + ' from Model')).length;

			expect(actualReferringUnitRemoveButtonCount).toEqual(initialReferringUnitRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Referring Unit button', () => {
		const referringUnitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringUnitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!referringUnitButton).toEqual(component.referringUnitMultiCrudActive);

		if (component.referringUnitMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			referringUnitButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialReferringUnitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringUnitDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialReferringUnitRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualReferringUnitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringUnitDisplayName + ' from Model'));

			expect(actualReferringUnitRemoveButtons.length).toEqual(initialReferringUnitRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Referring Unit button when one has already been added', () => {

		const referringUnitButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringUnitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!referringUnitButton).toEqual(component.referringUnitMultiCrudActive);

		if (component.referringUnitMultiCrudActive) {
			referringUnitButton.nativeElement.click();
			fixture.detectChanges();

			const updatedreferringUnitButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringUnitDisplayName + ' to Model'));

			expect(updatedreferringUnitButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Referring Unit entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.referringUnitMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const referringUnitRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringUnitDisplayName + ' from Model')).length;

			expect(referringUnitRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Referring facility relation.
	*
	* The button should only exist if referringFacilityMultiCrudActive is true
	*/
	it ('Renders Referring facility Add Entity button in create mode', fakeAsync(() => {
		const referringFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringFacilityDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!referringFacilityButton).toEqual(component.referringFacilityMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Referring facility', fakeAsync(() => {
		const referringFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!referringFacilityButton).toEqual(component.referringFacilityMultiCrudActive);

		if (component.referringFacilityMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialReferringFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringFacilityDisplayName + ' from Model')).length;

			referringFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const actualReferringFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringFacilityDisplayName + ' from Model')).length;

			expect(actualReferringFacilityRemoveButtonCount).toEqual(initialReferringFacilityRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Referring facility button', () => {
		const referringFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!referringFacilityButton).toEqual(component.referringFacilityMultiCrudActive);

		if (component.referringFacilityMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			referringFacilityButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialReferringFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringFacilityDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialReferringFacilityRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualReferringFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringFacilityDisplayName + ' from Model'));

			expect(actualReferringFacilityRemoveButtons.length).toEqual(initialReferringFacilityRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Referring facility button when one has already been added', () => {

		const referringFacilityButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!referringFacilityButton).toEqual(component.referringFacilityMultiCrudActive);

		if (component.referringFacilityMultiCrudActive) {
			referringFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const updatedreferringFacilityButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.referringFacilityDisplayName + ' to Model'));

			expect(updatedreferringFacilityButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Referring facility entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.referringFacilityMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const referringFacilityRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.referringFacilityDisplayName + ' from Model')).length;

			expect(referringFacilityRemoveButtonCount).toEqual(1);
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

	it ('should disable the add Requested By button when one has already been added', () => {

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

			expect(updatedrequestedByButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Requested By entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(requestedByRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Bed Reserves relation.
	*
	* The button should only exist if bedReservesMultiCrudActive is true
	*/
	it ('Renders Bed Reserves Add Entity button in create mode', fakeAsync(() => {
		const bedReservesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bedReservesButton).toEqual(component.bedReservesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Bed Reserves', fakeAsync(() => {
		const bedReservesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedReservesButton).toEqual(component.bedReservesMultiCrudActive);

		if (component.bedReservesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBedReservesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model')).length;

			bedReservesButton.nativeElement.click();
			fixture.detectChanges();

			const actualBedReservesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model')).length;

			expect(actualBedReservesRemoveButtonCount).toEqual(initialBedReservesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Bed Reserves button', () => {
		const bedReservesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedReservesButton).toEqual(component.bedReservesMultiCrudActive);

		if (component.bedReservesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bedReservesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBedReservesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBedReservesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBedReservesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model'));

			expect(actualBedReservesRemoveButtons.length).toEqual(initialBedReservesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Bed Reserves button when one has already been added', () => {

		const bedReservesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedReservesButton).toEqual(component.bedReservesMultiCrudActive);

		if (component.bedReservesMultiCrudActive) {
			bedReservesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbedReservesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

			expect(updatedbedReservesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Bed Reserves entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bedReservesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bedReservesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model')).length;

			expect(bedReservesRemoveButtonCount).toEqual(registrationWithId.bedReserves.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Diagnostic Examination Results relation.
	*
	* The button should only exist if diagnosticExaminationResultsMultiCrudActive is true
	*/
	it ('Renders Diagnostic Examination Results Add Entity button in create mode', fakeAsync(() => {
		const diagnosticExaminationResultsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticExaminationResultsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!diagnosticExaminationResultsButton).toEqual(component.diagnosticExaminationResultsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Diagnostic Examination Results', fakeAsync(() => {
		const diagnosticExaminationResultsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticExaminationResultsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticExaminationResultsButton).toEqual(component.diagnosticExaminationResultsMultiCrudActive);

		if (component.diagnosticExaminationResultsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDiagnosticExaminationResultsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticExaminationResultsDisplayName + ' from Model')).length;

			diagnosticExaminationResultsButton.nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosticExaminationResultsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticExaminationResultsDisplayName + ' from Model')).length;

			expect(actualDiagnosticExaminationResultsRemoveButtonCount).toEqual(initialDiagnosticExaminationResultsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Diagnostic Examination Results button', () => {
		const diagnosticExaminationResultsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticExaminationResultsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticExaminationResultsButton).toEqual(component.diagnosticExaminationResultsMultiCrudActive);

		if (component.diagnosticExaminationResultsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			diagnosticExaminationResultsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDiagnosticExaminationResultsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticExaminationResultsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDiagnosticExaminationResultsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosticExaminationResultsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticExaminationResultsDisplayName + ' from Model'));

			expect(actualDiagnosticExaminationResultsRemoveButtons.length).toEqual(initialDiagnosticExaminationResultsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Diagnostic Examination Results button when one has already been added', () => {

		const diagnosticExaminationResultsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticExaminationResultsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosticExaminationResultsButton).toEqual(component.diagnosticExaminationResultsMultiCrudActive);

		if (component.diagnosticExaminationResultsMultiCrudActive) {
			diagnosticExaminationResultsButton.nativeElement.click();
			fixture.detectChanges();

			const updateddiagnosticExaminationResultsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosticExaminationResultsDisplayName + ' to Model'));

			expect(updateddiagnosticExaminationResultsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Diagnostic Examination Results entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.diagnosticExaminationResultsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const diagnosticExaminationResultsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosticExaminationResultsDisplayName + ' from Model')).length;

			expect(diagnosticExaminationResultsRemoveButtonCount).toEqual(registrationWithId.diagnosticExaminationResults.length);
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(fluidBalanceDetailsRemoveButtonCount).toEqual(registrationWithId.fluidBalanceDetails.length);
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(informedConsentsRemoveButtonCount).toEqual(registrationWithId.informedConsents.length);
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(invoiceItemsRemoveButtonCount).toEqual(registrationWithId.invoiceItems.length);
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(medicalFeesRemoveButtonCount).toEqual(registrationWithId.medicalFees.length);
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(medicationHeadersRemoveButtonCount).toEqual(registrationWithId.medicationHeaders.length);
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(patientVitalInformationsRemoveButtonCount).toEqual(registrationWithId.patientVitalInformations.length);
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(prescriptionHeadersRemoveButtonCount).toEqual(registrationWithId.prescriptionHeaders.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Sample Collection Informations relation.
	*
	* The button should only exist if sampleCollectionInformationsMultiCrudActive is true
	*/
	it ('Renders Sample Collection Informations Add Entity button in create mode', fakeAsync(() => {
		const sampleCollectionInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionInformationsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!sampleCollectionInformationsButton).toEqual(component.sampleCollectionInformationsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Sample Collection Informations', fakeAsync(() => {
		const sampleCollectionInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleCollectionInformationsButton).toEqual(component.sampleCollectionInformationsMultiCrudActive);

		if (component.sampleCollectionInformationsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSampleCollectionInformationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionInformationsDisplayName + ' from Model')).length;

			sampleCollectionInformationsButton.nativeElement.click();
			fixture.detectChanges();

			const actualSampleCollectionInformationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionInformationsDisplayName + ' from Model')).length;

			expect(actualSampleCollectionInformationsRemoveButtonCount).toEqual(initialSampleCollectionInformationsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Sample Collection Informations button', () => {
		const sampleCollectionInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleCollectionInformationsButton).toEqual(component.sampleCollectionInformationsMultiCrudActive);

		if (component.sampleCollectionInformationsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			sampleCollectionInformationsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSampleCollectionInformationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionInformationsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSampleCollectionInformationsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSampleCollectionInformationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionInformationsDisplayName + ' from Model'));

			expect(actualSampleCollectionInformationsRemoveButtons.length).toEqual(initialSampleCollectionInformationsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Sample Collection Informations button when one has already been added', () => {

		const sampleCollectionInformationsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!sampleCollectionInformationsButton).toEqual(component.sampleCollectionInformationsMultiCrudActive);

		if (component.sampleCollectionInformationsMultiCrudActive) {
			sampleCollectionInformationsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsampleCollectionInformationsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.sampleCollectionInformationsDisplayName + ' to Model'));

			expect(updatedsampleCollectionInformationsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Sample Collection Informations entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.sampleCollectionInformationsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const sampleCollectionInformationsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.sampleCollectionInformationsDisplayName + ' from Model')).length;

			expect(sampleCollectionInformationsRemoveButtonCount).toEqual(registrationWithId.sampleCollectionInformations.length);
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
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
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

			expect(vaccinationOrdersRemoveButtonCount).toEqual(registrationWithId.vaccinationOrders.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Examination Items relation.
	*
	* The button should only exist if examinationItemsMultiCrudActive is true
	*/
	it ('Renders Examination Items Add Entity button in create mode', fakeAsync(() => {
		const examinationItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!examinationItemsButton).toEqual(component.examinationItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Examination Items', fakeAsync(() => {
		const examinationItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!examinationItemsButton).toEqual(component.examinationItemsMultiCrudActive);

		if (component.examinationItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialExaminationItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model')).length;

			examinationItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualExaminationItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model')).length;

			expect(actualExaminationItemsRemoveButtonCount).toEqual(initialExaminationItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Examination Items button', () => {
		const examinationItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!examinationItemsButton).toEqual(component.examinationItemsMultiCrudActive);

		if (component.examinationItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			examinationItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialExaminationItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialExaminationItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualExaminationItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model'));

			expect(actualExaminationItemsRemoveButtons.length).toEqual(initialExaminationItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Examination Items button when one has already been added', () => {

		const examinationItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!examinationItemsButton).toEqual(component.examinationItemsMultiCrudActive);

		if (component.examinationItemsMultiCrudActive) {
			examinationItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedexaminationItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

			expect(updatedexaminationItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Examination Items entities from model when loading in edit mode', () => {
		component.targetModel = registrationWithId;
		component.targetModelId = registrationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.examinationItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const examinationItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model')).length;

			expect(examinationItemsRemoveButtonCount).toEqual(registrationWithId.examinationItems.length);
		}
	});

});
