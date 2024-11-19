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

import {Action, ActionReducerMap} from '@ngrx/store';
import {routerReducer} from '@ngrx/router-store';
import {modelReducer as administrationUserReducer} from './administrationUser/administration_user.model.reducer';
import {isAdministrationUserModelAction} from './administrationUser/administration_user.model.action';
import {modelReducer as administratorReducer} from './administrator/administrator.model.reducer';
import {isAdministratorModelAction} from './administrator/administrator.model.action';
import {modelReducer as amendmentDetailReducer} from './amendmentDetail/amendment_detail.model.reducer';
import {isAmendmentDetailModelAction} from './amendmentDetail/amendment_detail.model.action';
import {modelReducer as bpjsAccidentMasterReducer} from './bpjsAccidentMaster/bpjs_accident_master.model.reducer';
import {isBpjsAccidentMasterModelAction} from './bpjsAccidentMaster/bpjs_accident_master.model.action';
import {modelReducer as bpjsBedAvailabilityReducer} from './bpjsBedAvailability/bpjs_bed_availability.model.reducer';
import {isBpjsBedAvailabilityModelAction} from './bpjsBedAvailability/bpjs_bed_availability.model.action';
import {modelReducer as bpjsClaimDataReducer} from './bpjsClaimData/bpjs_claim_data.model.reducer';
import {isBpjsClaimDataModelAction} from './bpjsClaimData/bpjs_claim_data.model.action';
import {modelReducer as bpjsClaimSubmissionReducer} from './bpjsClaimSubmission/bpjs_claim_submission.model.reducer';
import {isBpjsClaimSubmissionModelAction} from './bpjsClaimSubmission/bpjs_claim_submission.model.action';
import {modelReducer as bpjsControlPlanReducer} from './bpjsControlPlan/bpjs_control_plan.model.reducer';
import {isBpjsControlPlanModelAction} from './bpjsControlPlan/bpjs_control_plan.model.action';
import {modelReducer as bpjsControlSpecialistReducer} from './bpjsControlSpecialist/bpjs_control_specialist.model.reducer';
import {isBpjsControlSpecialistModelAction} from './bpjsControlSpecialist/bpjs_control_specialist.model.action';
import {modelReducer as bpjsDiagnoseReducer} from './bpjsDiagnose/bpjs_diagnose.model.reducer';
import {isBpjsDiagnoseModelAction} from './bpjsDiagnose/bpjs_diagnose.model.action';
import {modelReducer as bpjsDiagnosePRBReducer} from './bpjsDiagnosePRB/bpjs_diagnose_prb.model.reducer';
import {isBpjsDiagnosePRBModelAction} from './bpjsDiagnosePRB/bpjs_diagnose_prb.model.action';
import {modelReducer as bpjsDismissalConditionReducer} from './bpjsDismissalCondition/bpjs_dismissal_condition.model.reducer';
import {isBpjsDismissalConditionModelAction} from './bpjsDismissalCondition/bpjs_dismissal_condition.model.action';
import {modelReducer as bpjsDismissalMappingReducer} from './bpjsDismissalMapping/bpjs_dismissal_mapping.model.reducer';
import {isBpjsDismissalMappingModelAction} from './bpjsDismissalMapping/bpjs_dismissal_mapping.model.action';
import {modelReducer as bpjsDoctorMappingReducer} from './bpjsDoctorMapping/bpjs_doctor_mapping.model.reducer';
import {isBpjsDoctorMappingModelAction} from './bpjsDoctorMapping/bpjs_doctor_mapping.model.action';
import {modelReducer as bpjsDoctorScheduleReducer} from './bpjsDoctorSchedule/bpjs_doctor_schedule.model.reducer';
import {isBpjsDoctorScheduleModelAction} from './bpjsDoctorSchedule/bpjs_doctor_schedule.model.action';
import {modelReducer as bpjsDrugGenericPRBReducer} from './bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.reducer';
import {isBpjsDrugGenericPRBModelAction} from './bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.action';
import {modelReducer as bpjsFacilityListReducer} from './bpjsFacilityList/bpjs_facility_list.model.reducer';
import {isBpjsFacilityListModelAction} from './bpjsFacilityList/bpjs_facility_list.model.action';
import {modelReducer as bpjsFingerPrintReducer} from './bpjsFingerPrint/bpjs_finger_print.model.reducer';
import {isBpjsFingerPrintModelAction} from './bpjsFingerPrint/bpjs_finger_print.model.action';
import {modelReducer as bpjsGeneralReducer} from './bpjsGeneral/bpjs_general.model.reducer';
import {isBpjsGeneralModelAction} from './bpjsGeneral/bpjs_general.model.action';
import {modelReducer as bpjsHealthFacilityReducer} from './bpjsHealthFacility/bpjs_health_facility.model.reducer';
import {isBpjsHealthFacilityModelAction} from './bpjsHealthFacility/bpjs_health_facility.model.action';
import {modelReducer as bpjsHospitalizationPlanReducer} from './bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.reducer';
import {isBpjsHospitalizationPlanModelAction} from './bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.action';
import {modelReducer as bpjsINACBGReducer} from './bpjsINACBG/bpjs_inacbg.model.reducer';
import {isBpjsINACBGModelAction} from './bpjsINACBG/bpjs_inacbg.model.action';
import {modelReducer as bpjsINACBGClaimReducer} from './bpjsINACBGClaim/bpjs_inacbg_claim.model.reducer';
import {isBpjsINACBGClaimModelAction} from './bpjsINACBGClaim/bpjs_inacbg_claim.model.action';
import {modelReducer as bpjsINACBGVariableReducer} from './bpjsINACBGVariable/bpjs_inacbg_variable.model.reducer';
import {isBpjsINACBGVariableModelAction} from './bpjsINACBGVariable/bpjs_inacbg_variable.model.action';
import {modelReducer as bpjsJasaRaharjaReducer} from './bpjsJasaRaharja/bpjs_jasa_raharja.model.reducer';
import {isBpjsJasaRaharjaModelAction} from './bpjsJasaRaharja/bpjs_jasa_raharja.model.action';
import {modelReducer as bpjsJasaRaharjaClaimReducer} from './bpjsJasaRaharjaClaim/bpjs_jasa_raharja_claim.model.reducer';
import {isBpjsJasaRaharjaClaimModelAction} from './bpjsJasaRaharjaClaim/bpjs_jasa_raharja_claim.model.action';
import {modelReducer as bpjsListFingerPrintReducer} from './bpjsListFingerPrint/bpjs_list_finger_print.model.reducer';
import {isBpjsListFingerPrintModelAction} from './bpjsListFingerPrint/bpjs_list_finger_print.model.action';
import {modelReducer as bpjsListTaskReducer} from './bpjsListTask/bpjs_list_task.model.reducer';
import {isBpjsListTaskModelAction} from './bpjsListTask/bpjs_list_task.model.action';
import {modelReducer as bpjsOutsideFacilityReferralReducer} from './bpjsOutsideFacilityReferral/bpjs_outside_facility_referral.model.reducer';
import {isBpjsOutsideFacilityReferralModelAction} from './bpjsOutsideFacilityReferral/bpjs_outside_facility_referral.model.action';
import {modelReducer as bpjsPRBReducer} from './bpjsPRB/bpjs_prb.model.reducer';
import {isBpjsPRBModelAction} from './bpjsPRB/bpjs_prb.model.action';
import {modelReducer as bpjsPRBDetailReducer} from './bpjsPRBDetail/bpjs_prb_detail.model.reducer';
import {isBpjsPRBDetailModelAction} from './bpjsPRBDetail/bpjs_prb_detail.model.action';
import {modelReducer as bpjsPatientReferralReducer} from './bpjsPatientReferral/bpjs_patient_referral.model.reducer';
import {isBpjsPatientReferralModelAction} from './bpjsPatientReferral/bpjs_patient_referral.model.action';
import {modelReducer as bpjsPcareDPHOReducer} from './bpjsPcareDPHO/bpjs_pcare_dpho.model.reducer';
import {isBpjsPcareDPHOModelAction} from './bpjsPcareDPHO/bpjs_pcare_dpho.model.action';
import {modelReducer as bpjsPcareKegiatanKelompokReducer} from './bpjsPcareKegiatanKelompok/bpjs_pcare_kegiatan_kelompok.model.reducer';
import {isBpjsPcareKegiatanKelompokModelAction} from './bpjsPcareKegiatanKelompok/bpjs_pcare_kegiatan_kelompok.model.action';
import {modelReducer as bpjsPcareKesadaranReducer} from './bpjsPcareKesadaran/bpjs_pcare_kesadaran.model.reducer';
import {isBpjsPcareKesadaranModelAction} from './bpjsPcareKesadaran/bpjs_pcare_kesadaran.model.action';
import {modelReducer as bpjsPcarePesertaKegiatanKelompokReducer} from './bpjsPcarePesertaKegiatanKelompok/bpjs_pcare_peserta_kegiatan_kelompok.model.reducer';
import {isBpjsPcarePesertaKegiatanKelompokModelAction} from './bpjsPcarePesertaKegiatanKelompok/bpjs_pcare_peserta_kegiatan_kelompok.model.action';
import {modelReducer as bpjsPcarePoliReducer} from './bpjsPcarePoli/bpjs_pcare_poli.model.reducer';
import {isBpjsPcarePoliModelAction} from './bpjsPcarePoli/bpjs_pcare_poli.model.action';
import {modelReducer as bpjsPcareProviderRayonisasiReducer} from './bpjsPcareProviderRayonisasi/bpjs_pcare_provider_rayonisasi.model.reducer';
import {isBpjsPcareProviderRayonisasiModelAction} from './bpjsPcareProviderRayonisasi/bpjs_pcare_provider_rayonisasi.model.action';
import {modelReducer as bpjsPcareRegistrationsReducer} from './bpjsPcareRegistrations/bpjs_pcare_registrations.model.reducer';
import {isBpjsPcareRegistrationsModelAction} from './bpjsPcareRegistrations/bpjs_pcare_registrations.model.action';
import {modelReducer as bpjsProcedureReducer} from './bpjsProcedure/bpjs_procedure.model.reducer';
import {isBpjsProcedureModelAction} from './bpjsProcedure/bpjs_procedure.model.action';
import {modelReducer as bpjsReferralSpecialistReducer} from './bpjsReferralSpecialist/bpjs_referral_specialist.model.reducer';
import {isBpjsReferralSpecialistModelAction} from './bpjsReferralSpecialist/bpjs_referral_specialist.model.action';
import {modelReducer as bpjsSEPReducer} from './bpjsSEP/bpjs_sep.model.reducer';
import {isBpjsSEPModelAction} from './bpjsSEP/bpjs_sep.model.action';
import {modelReducer as bpjsSEPINACBGIntegrationReducer} from './bpjsSEPINACBGIntegration/bpjs_sep_inacbg_integration.model.reducer';
import {isBpjsSEPINACBGIntegrationModelAction} from './bpjsSEPINACBGIntegration/bpjs_sep_inacbg_integration.model.action';
import {modelReducer as bpjsSEPInternalDataReducer} from './bpjsSEPInternalData/bpjs_sep_internal_data.model.reducer';
import {isBpjsSEPInternalDataModelAction} from './bpjsSEPInternalData/bpjs_sep_internal_data.model.action';
import {modelReducer as bpjsSEPSubmissionReducer} from './bpjsSEPSubmission/bpjs_sep_submission.model.reducer';
import {isBpjsSEPSubmissionModelAction} from './bpjsSEPSubmission/bpjs_sep_submission.model.action';
import {modelReducer as bpjsSearchControlLetterReducer} from './bpjsSearchControlLetter/bpjs_search_control_letter.model.reducer';
import {isBpjsSearchControlLetterModelAction} from './bpjsSearchControlLetter/bpjs_search_control_letter.model.action';
import {modelReducer as bpjsSearchSEPReducer} from './bpjsSearchSEP/bpjs_search_sep.model.reducer';
import {isBpjsSearchSEPModelAction} from './bpjsSearchSEP/bpjs_search_sep.model.action';
import {modelReducer as bpjsServiceMappingReducer} from './bpjsServiceMapping/bpjs_service_mapping.model.reducer';
import {isBpjsServiceMappingModelAction} from './bpjsServiceMapping/bpjs_service_mapping.model.action';
import {modelReducer as bpjsSpecialReferralReducer} from './bpjsSpecialReferral/bpjs_special_referral.model.reducer';
import {isBpjsSpecialReferralModelAction} from './bpjsSpecialReferral/bpjs_special_referral.model.action';
import {modelReducer as bpjsTotalReferralSEPReducer} from './bpjsTotalReferralSEP/bpjs_total_referral_sep.model.reducer';
import {isBpjsTotalReferralSEPModelAction} from './bpjsTotalReferralSEP/bpjs_total_referral_sep.model.action';
import {modelReducer as bpjsTreatmentClassMappingReducer} from './bpjsTreatmentClassMapping/bpjs_treatment_class_mapping.model.reducer';
import {isBpjsTreatmentClassMappingModelAction} from './bpjsTreatmentClassMapping/bpjs_treatment_class_mapping.model.action';
import {modelReducer as bpjsTreatmentHistoryReducer} from './bpjsTreatmentHistory/bpjs_treatment_history.model.reducer';
import {isBpjsTreatmentHistoryModelAction} from './bpjsTreatmentHistory/bpjs_treatment_history.model.action';
import {modelReducer as bpjsTreatmentRoomReducer} from './bpjsTreatmentRoom/bpjs_treatment_room.model.reducer';
import {isBpjsTreatmentRoomModelAction} from './bpjsTreatmentRoom/bpjs_treatment_room.model.action';
import {modelReducer as bpjsUpdateDismissalDateReducer} from './bpjsUpdateDismissalDate/bpjs_update_dismissal_date.model.reducer';
import {isBpjsUpdateDismissalDateModelAction} from './bpjsUpdateDismissalDate/bpjs_update_dismissal_date.model.action';
import {modelReducer as bpjsVisitDataReducer} from './bpjsVisitData/bpjs_visit_data.model.reducer';
import {isBpjsVisitDataModelAction} from './bpjsVisitData/bpjs_visit_data.model.action';
import {modelReducer as batchStockBalanceReducer} from './batchStockBalance/batch_stock_balance.model.reducer';
import {isBatchStockBalanceModelAction} from './batchStockBalance/batch_stock_balance.model.action';
import {modelReducer as batchStockBalancePerDateReducer} from './batchStockBalancePerDate/batch_stock_balance_per_date.model.reducer';
import {isBatchStockBalancePerDateModelAction} from './batchStockBalancePerDate/batch_stock_balance_per_date.model.action';
import {modelReducer as batchStockTransactionDetailReducer} from './batchStockTransactionDetail/batch_stock_transaction_detail.model.reducer';
import {isBatchStockTransactionDetailModelAction} from './batchStockTransactionDetail/batch_stock_transaction_detail.model.action';
import {modelReducer as bedFacilityReducer} from './bedFacility/bed_facility.model.reducer';
import {isBedFacilityModelAction} from './bedFacility/bed_facility.model.action';
import {modelReducer as bedReserveReducer} from './bedReserve/bed_reserve.model.reducer';
import {isBedReserveModelAction} from './bedReserve/bed_reserve.model.action';
import {modelReducer as birthHistoryReducer} from './birthHistory/birth_history.model.reducer';
import {isBirthHistoryModelAction} from './birthHistory/birth_history.model.action';
import {modelReducer as bodyChartExaminationReducer} from './bodyChartExamination/body_chart_examination.model.reducer';
import {isBodyChartExaminationModelAction} from './bodyChartExamination/body_chart_examination.model.action';
import {modelReducer as bpjsPcareKunjunganRujukanReducer} from './bpjsPcareKunjunganRujukan/bpjs_pcare_kunjungan_rujukan.model.reducer';
import {isBpjsPcareKunjunganRujukanModelAction} from './bpjsPcareKunjunganRujukan/bpjs_pcare_kunjungan_rujukan.model.action';
import {modelReducer as bpjsPcarePendaftaranReducer} from './bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.reducer';
import {isBpjsPcarePendaftaranModelAction} from './bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.action';
import {modelReducer as bpjsPcareRiwayatKunjunganReducer} from './bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.model.reducer';
import {isBpjsPcareRiwayatKunjunganModelAction} from './bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.model.action';
import {modelReducer as cashAllocationReducer} from './cashAllocation/cash_allocation.model.reducer';
import {isCashAllocationModelAction} from './cashAllocation/cash_allocation.model.action';
import {modelReducer as cashReceiptReducer} from './cashReceipt/cash_receipt.model.reducer';
import {isCashReceiptModelAction} from './cashReceipt/cash_receipt.model.action';
import {modelReducer as cashRefundReducer} from './cashRefund/cash_refund.model.reducer';
import {isCashRefundModelAction} from './cashRefund/cash_refund.model.action';
import {modelReducer as cashierUserReducer} from './cashierUser/cashier_user.model.reducer';
import {isCashierUserModelAction} from './cashierUser/cashier_user.model.action';
import {modelReducer as catalogueMedicalReducer} from './catalogueMedical/catalogue_medical.model.reducer';
import {isCatalogueMedicalModelAction} from './catalogueMedical/catalogue_medical.model.action';
import {modelReducer as catalogueNonMedicalReducer} from './catalogueNonMedical/catalogue_non_medical.model.reducer';
import {isCatalogueNonMedicalModelAction} from './catalogueNonMedical/catalogue_non_medical.model.action';
import {modelReducer as catalogueUOMReducer} from './catalogueUOM/catalogue_uom.model.reducer';
import {isCatalogueUOMModelAction} from './catalogueUOM/catalogue_uom.model.action';
import {modelReducer as chartOfAccountReducer} from './chartOfAccount/chart_of_account.model.reducer';
import {isChartOfAccountModelAction} from './chartOfAccount/chart_of_account.model.action';
import {modelReducer as chartOfAccountMappingReducer} from './chartOfAccountMapping/chart_of_account_mapping.model.reducer';
import {isChartOfAccountMappingModelAction} from './chartOfAccountMapping/chart_of_account_mapping.model.action';
import {modelReducer as claimUserReducer} from './claimUser/claim_user.model.reducer';
import {isClaimUserModelAction} from './claimUser/claim_user.model.action';
import {modelReducer as coTreatingDoctorReducer} from './coTreatingDoctor/co_treating_doctor.model.reducer';
import {isCoTreatingDoctorModelAction} from './coTreatingDoctor/co_treating_doctor.model.action';
import {modelReducer as compoundPrescriptionDetailReducer} from './compoundPrescriptionDetail/compound_prescription_detail.model.reducer';
import {isCompoundPrescriptionDetailModelAction} from './compoundPrescriptionDetail/compound_prescription_detail.model.action';
import {modelReducer as compoundPrescriptionItemReducer} from './compoundPrescriptionItem/compound_prescription_item.model.reducer';
import {isCompoundPrescriptionItemModelAction} from './compoundPrescriptionItem/compound_prescription_item.model.action';
import {modelReducer as dailyCareCPPTReducer} from './dailyCareCPPT/daily_care_cppt.model.reducer';
import {isDailyCareCPPTModelAction} from './dailyCareCPPT/daily_care_cppt.model.action';
import {modelReducer as deliveryMedicalExaminationRecordReducer} from './deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.reducer';
import {isDeliveryMedicalExaminationRecordModelAction} from './deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.action';
import {modelReducer as deliveryProgressReducer} from './deliveryProgress/delivery_progress.model.reducer';
import {isDeliveryProgressModelAction} from './deliveryProgress/delivery_progress.model.action';
import {modelReducer as diagnosesAndProceduresReducer} from './diagnosesAndProcedures/diagnoses_and_procedures.model.reducer';
import {isDiagnosesAndProceduresModelAction} from './diagnosesAndProcedures/diagnoses_and_procedures.model.action';
import {modelReducer as diagnosisExaminationRecordReducer} from './diagnosisExaminationRecord/diagnosis_examination_record.model.reducer';
import {isDiagnosisExaminationRecordModelAction} from './diagnosisExaminationRecord/diagnosis_examination_record.model.action';
import {modelReducer as diagnosisNandaReducer} from './diagnosisNanda/diagnosis_nanda.model.reducer';
import {isDiagnosisNandaModelAction} from './diagnosisNanda/diagnosis_nanda.model.action';
import {modelReducer as diagnosticExaminationResultsReducer} from './diagnosticExaminationResults/diagnostic_examination_results.model.reducer';
import {isDiagnosticExaminationResultsModelAction} from './diagnosticExaminationResults/diagnostic_examination_results.model.action';
import {modelReducer as diagnosticStaffExaminationSummaryReducer} from './diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.reducer';
import {isDiagnosticStaffExaminationSummaryModelAction} from './diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.action';
import {modelReducer as diagnosticSupportGeneralConfigurationReducer} from './diagnosticSupportGeneralConfiguration/diagnostic_support_general_configuration.model.reducer';
import {isDiagnosticSupportGeneralConfigurationModelAction} from './diagnosticSupportGeneralConfiguration/diagnostic_support_general_configuration.model.action';
import {modelReducer as diagnosticSupportUserReducer} from './diagnosticSupportUser/diagnostic_support_user.model.reducer';
import {isDiagnosticSupportUserModelAction} from './diagnosticSupportUser/diagnostic_support_user.model.action';
import {modelReducer as doctorScheduleReducer} from './doctorSchedule/doctor_schedule.model.reducer';
import {isDoctorScheduleModelAction} from './doctorSchedule/doctor_schedule.model.action';
import {modelReducer as doctorUserReducer} from './doctorUser/doctor_user.model.reducer';
import {isDoctorUserModelAction} from './doctorUser/doctor_user.model.action';
import {modelReducer as entExaminationReducer} from './entExamination/ent_examination.model.reducer';
import {isEntExaminationModelAction} from './entExamination/ent_examination.model.action';
import {modelReducer as emergencyMedicalExaminationRecordReducer} from './emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.reducer';
import {isEmergencyMedicalExaminationRecordModelAction} from './emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.action';
import {modelReducer as examinationGroupReducer} from './examinationGroup/examination_group.model.reducer';
import {isExaminationGroupModelAction} from './examinationGroup/examination_group.model.action';
import {modelReducer as examinationItemReducer} from './examinationItem/examination_item.model.reducer';
import {isExaminationItemModelAction} from './examinationItem/examination_item.model.action';
import {modelReducer as examinationItemDetailReducer} from './examinationItemDetail/examination_item_detail.model.reducer';
import {isExaminationItemDetailModelAction} from './examinationItemDetail/examination_item_detail.model.action';
import {modelReducer as facilityHistoryReducer} from './facilityHistory/facility_history.model.reducer';
import {isFacilityHistoryModelAction} from './facilityHistory/facility_history.model.action';
import {modelReducer as facilityUserReducer} from './facilityUser/facility_user.model.reducer';
import {isFacilityUserModelAction} from './facilityUser/facility_user.model.action';
import {modelReducer as fluidBalanceDetailReducer} from './fluidBalanceDetail/fluid_balance_detail.model.reducer';
import {isFluidBalanceDetailModelAction} from './fluidBalanceDetail/fluid_balance_detail.model.action';
import {modelReducer as formulirKonselingTesHivReducer} from './formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.reducer';
import {isFormulirKonselingTesHivModelAction} from './formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.action';
import {modelReducer as goodsReceiveNoteReducer} from './goodsReceiveNote/goods_receive_note.model.reducer';
import {isGoodsReceiveNoteModelAction} from './goodsReceiveNote/goods_receive_note.model.action';
import {modelReducer as goodsReceiveNoteBatchReducer} from './goodsReceiveNoteBatch/goods_receive_note_batch.model.reducer';
import {isGoodsReceiveNoteBatchModelAction} from './goodsReceiveNoteBatch/goods_receive_note_batch.model.action';
import {modelReducer as goodsReceiveNoteItemReducer} from './goodsReceiveNoteItem/goods_receive_note_item.model.reducer';
import {isGoodsReceiveNoteItemModelAction} from './goodsReceiveNoteItem/goods_receive_note_item.model.action';
import {modelReducer as healthFacilityReducer} from './healthFacility/health_facility.model.reducer';
import {isHealthFacilityModelAction} from './healthFacility/health_facility.model.action';
import {modelReducer as hemodialysisExaminationReducer} from './hemodialysisExamination/hemodialysis_examination.model.reducer';
import {isHemodialysisExaminationModelAction} from './hemodialysisExamination/hemodialysis_examination.model.action';
import {modelReducer as hemodialysisMonitoringReducer} from './hemodialysisMonitoring/hemodialysis_monitoring.model.reducer';
import {isHemodialysisMonitoringModelAction} from './hemodialysisMonitoring/hemodialysis_monitoring.model.action';
import {modelReducer as hospitalBranchInformationReducer} from './hospitalBranchInformation/hospital_branch_information.model.reducer';
import {isHospitalBranchInformationModelAction} from './hospitalBranchInformation/hospital_branch_information.model.action';
import {modelReducer as hospitalGroupInformationReducer} from './hospitalGroupInformation/hospital_group_information.model.reducer';
import {isHospitalGroupInformationModelAction} from './hospitalGroupInformation/hospital_group_information.model.action';
import {modelReducer as icd10Reducer} from './icd10/icd_10.model.reducer';
import {isIcd10ModelAction} from './icd10/icd_10.model.action';
import {modelReducer as icd9CMReducer} from './icd9CM/icd_9_cm.model.reducer';
import {isIcd9CMModelAction} from './icd9CM/icd_9_cm.model.action';
import {modelReducer as informedConsentReducer} from './informedConsent/informed_consent.model.reducer';
import {isInformedConsentModelAction} from './informedConsent/informed_consent.model.action';
import {modelReducer as inpatientMedicalExaminationRecordReducer} from './inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.reducer';
import {isInpatientMedicalExaminationRecordModelAction} from './inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.action';
import {modelReducer as insuranceBenefitPlanReducer} from './insuranceBenefitPlan/insurance_benefit_plan.model.reducer';
import {isInsuranceBenefitPlanModelAction} from './insuranceBenefitPlan/insurance_benefit_plan.model.action';
import {modelReducer as insuranceProviderReducer} from './insuranceProvider/insurance_provider.model.reducer';
import {isInsuranceProviderModelAction} from './insuranceProvider/insurance_provider.model.action';
import {modelReducer as internalOrderReducer} from './internalOrder/internal_order.model.reducer';
import {isInternalOrderModelAction} from './internalOrder/internal_order.model.action';
import {modelReducer as internalOrderStockDetailReducer} from './internalOrderStockDetail/internal_order_stock_detail.model.reducer';
import {isInternalOrderStockDetailModelAction} from './internalOrderStockDetail/internal_order_stock_detail.model.action';
import {modelReducer as intraoperativeRecordsReducer} from './intraoperativeRecords/intraoperative_records.model.reducer';
import {isIntraoperativeRecordsModelAction} from './intraoperativeRecords/intraoperative_records.model.action';
import {modelReducer as inventoryAdjusmentBatchReducer} from './inventoryAdjusmentBatch/inventory_adjusment_batch.model.reducer';
import {isInventoryAdjusmentBatchModelAction} from './inventoryAdjusmentBatch/inventory_adjusment_batch.model.action';
import {modelReducer as inventoryAdjustmentReducer} from './inventoryAdjustment/inventory_adjustment.model.reducer';
import {isInventoryAdjustmentModelAction} from './inventoryAdjustment/inventory_adjustment.model.action';
import {modelReducer as inventoryAdjustmentItemReducer} from './inventoryAdjustmentItem/inventory_adjustment_item.model.reducer';
import {isInventoryAdjustmentItemModelAction} from './inventoryAdjustmentItem/inventory_adjustment_item.model.action';
import {modelReducer as inventoryBatchCorrectionReducer} from './inventoryBatchCorrection/inventory_batch_correction.model.reducer';
import {isInventoryBatchCorrectionModelAction} from './inventoryBatchCorrection/inventory_batch_correction.model.action';
import {modelReducer as inventoryBatchCorrectionItemReducer} from './inventoryBatchCorrectionItem/inventory_batch_correction_item.model.reducer';
import {isInventoryBatchCorrectionItemModelAction} from './inventoryBatchCorrectionItem/inventory_batch_correction_item.model.action';
import {modelReducer as invoiceReducer} from './invoice/invoice.model.reducer';
import {isInvoiceModelAction} from './invoice/invoice.model.action';
import {modelReducer as invoiceItemReducer} from './invoiceItem/invoice_item.model.reducer';
import {isInvoiceItemModelAction} from './invoiceItem/invoice_item.model.action';
import {modelReducer as invoiceItemComponentReducer} from './invoiceItemComponent/invoice_item_component.model.reducer';
import {isInvoiceItemComponentModelAction} from './invoiceItemComponent/invoice_item_component.model.action';
import {modelReducer as invoicePaymentInsuranceReducer} from './invoicePaymentInsurance/invoice_payment_insurance.model.reducer';
import {isInvoicePaymentInsuranceModelAction} from './invoicePaymentInsurance/invoice_payment_insurance.model.action';
import {modelReducer as invoicePaymentOtherReducer} from './invoicePaymentOther/invoice_payment_other.model.reducer';
import {isInvoicePaymentOtherModelAction} from './invoicePaymentOther/invoice_payment_other.model.action';
import {modelReducer as invoicePaymentSelfPayingReducer} from './invoicePaymentSelfPaying/invoice_payment_self_paying.model.reducer';
import {isInvoicePaymentSelfPayingModelAction} from './invoicePaymentSelfPaying/invoice_payment_self_paying.model.action';
import {modelReducer as invoiceSummaryReducer} from './invoiceSummary/invoice_summary.model.reducer';
import {isInvoiceSummaryModelAction} from './invoiceSummary/invoice_summary.model.action';
import {modelReducer as journalReducer} from './journal/journal.model.reducer';
import {isJournalModelAction} from './journal/journal.model.action';
import {modelReducer as libraryReducer} from './library/library.model.reducer';
import {isLibraryModelAction} from './library/library.model.action';
import {modelReducer as locationReducer} from './location/location.model.reducer';
import {isLocationModelAction} from './location/location.model.action';
import {modelReducer as mcuPackageReducer} from './mcuPackage/mcu_package.model.reducer';
import {isMcuPackageModelAction} from './mcuPackage/mcu_package.model.action';
import {modelReducer as mcuPackageItemReducer} from './mcuPackageItem/mcu_package_item.model.reducer';
import {isMcuPackageItemModelAction} from './mcuPackageItem/mcu_package_item.model.action';
import {modelReducer as managementUserReducer} from './managementUser/management_user.model.reducer';
import {isManagementUserModelAction} from './managementUser/management_user.model.action';
import {modelReducer as medicalCertificateDischargeResumeReducer} from './medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.reducer';
import {isMedicalCertificateDischargeResumeModelAction} from './medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.action';
import {modelReducer as medicalCertificateBirthReducer} from './medicalCertificateBirth/medical_certificate_birth.model.reducer';
import {isMedicalCertificateBirthModelAction} from './medicalCertificateBirth/medical_certificate_birth.model.action';
import {modelReducer as medicalCertificateHospitalizationReducer} from './medicalCertificateHospitalization/medical_certificate_hospitalization.model.reducer';
import {isMedicalCertificateHospitalizationModelAction} from './medicalCertificateHospitalization/medical_certificate_hospitalization.model.action';
import {modelReducer as medicalCertificateMedicalAttendanceReducer} from './medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.reducer';
import {isMedicalCertificateMedicalAttendanceModelAction} from './medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.action';
import {modelReducer as medicalCertificateMentalHealthReducer} from './medicalCertificateMentalHealth/medical_certificate_mental_health.model.reducer';
import {isMedicalCertificateMentalHealthModelAction} from './medicalCertificateMentalHealth/medical_certificate_mental_health.model.action';
import {modelReducer as medicalCertificatePhysicalHealthReducer} from './medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.reducer';
import {isMedicalCertificatePhysicalHealthModelAction} from './medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.action';
import {modelReducer as medicalCertificateRestrictedWorkReducer} from './medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.reducer';
import {isMedicalCertificateRestrictedWorkModelAction} from './medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.action';
import {modelReducer as medicalCertificateSickLeaveReducer} from './medicalCertificateSickLeave/medical_certificate_sick_leave.model.reducer';
import {isMedicalCertificateSickLeaveModelAction} from './medicalCertificateSickLeave/medical_certificate_sick_leave.model.action';
import {modelReducer as medicalExaminationRecordReducer} from './medicalExaminationRecord/medical_examination_record.model.reducer';
import {isMedicalExaminationRecordModelAction} from './medicalExaminationRecord/medical_examination_record.model.action';
import {modelReducer as medicalExaminationRecordDischargeSummaryReducer} from './medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.reducer';
import {isMedicalExaminationRecordDischargeSummaryModelAction} from './medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.action';
import {modelReducer as medicalFeeReducer} from './medicalFee/medical_fee.model.reducer';
import {isMedicalFeeModelAction} from './medicalFee/medical_fee.model.action';
import {modelReducer as medicalFeeItemComponentReducer} from './medicalFeeItemComponent/medical_fee_item_component.model.reducer';
import {isMedicalFeeItemComponentModelAction} from './medicalFeeItemComponent/medical_fee_item_component.model.action';
import {modelReducer as medicalRecordInitialChecklistReducer} from './medicalRecordInitialChecklist/medical_record_initial_checklist.model.reducer';
import {isMedicalRecordInitialChecklistModelAction} from './medicalRecordInitialChecklist/medical_record_initial_checklist.model.action';
import {modelReducer as medicalRecordNextVerificationChecklistReducer} from './medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.reducer';
import {isMedicalRecordNextVerificationChecklistModelAction} from './medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.action';
import {modelReducer as medicalRecordUserReducer} from './medicalRecordUser/medical_record_user.model.reducer';
import {isMedicalRecordUserModelAction} from './medicalRecordUser/medical_record_user.model.action';
import {modelReducer as medicalTranscriberUserReducer} from './medicalTranscriberUser/medical_transcriber_user.model.reducer';
import {isMedicalTranscriberUserModelAction} from './medicalTranscriberUser/medical_transcriber_user.model.action';
import {modelReducer as medicationAdministeredHistoryReducer} from './medicationAdministeredHistory/medication_administered_history.model.reducer';
import {isMedicationAdministeredHistoryModelAction} from './medicationAdministeredHistory/medication_administered_history.model.action';
import {modelReducer as medicationCompoundReducer} from './medicationCompound/medication_compound.model.reducer';
import {isMedicationCompoundModelAction} from './medicationCompound/medication_compound.model.action';
import {modelReducer as medicationHeaderReducer} from './medicationHeader/medication_header.model.reducer';
import {isMedicationHeaderModelAction} from './medicationHeader/medication_header.model.action';
import {modelReducer as medicationItemReducer} from './medicationItem/medication_item.model.reducer';
import {isMedicationItemModelAction} from './medicationItem/medication_item.model.action';
import {modelReducer as merchantReducer} from './merchant/merchant.model.reducer';
import {isMerchantModelAction} from './merchant/merchant.model.action';
import {modelReducer as merchantSurchargeAndFeeReducer} from './merchantSurchargeAndFee/merchant_surcharge_and_fee.model.reducer';
import {isMerchantSurchargeAndFeeModelAction} from './merchantSurchargeAndFee/merchant_surcharge_and_fee.model.action';
import {modelReducer as nhisClaimReducer} from './nhisClaim/nhis_claim.model.reducer';
import {isNhisClaimModelAction} from './nhisClaim/nhis_claim.model.action';
import {modelReducer as nhisClaimGDRGDetailReducer} from './nhisClaimGDRGDetail/nhis_claim_gdrg_detail.model.reducer';
import {isNhisClaimGDRGDetailModelAction} from './nhisClaimGDRGDetail/nhis_claim_gdrg_detail.model.action';
import {modelReducer as nhisClaimInvestigationDetailReducer} from './nhisClaimInvestigationDetail/nhis_claim_investigation_detail.model.reducer';
import {isNhisClaimInvestigationDetailModelAction} from './nhisClaimInvestigationDetail/nhis_claim_investigation_detail.model.action';
import {modelReducer as nhisGDRGReducer} from './nhisGDRG/nhis_gdrg.model.reducer';
import {isNhisGDRGModelAction} from './nhisGDRG/nhis_gdrg.model.action';
import {modelReducer as nhisInvestigationReducer} from './nhisInvestigation/nhis_investigation.model.reducer';
import {isNhisInvestigationModelAction} from './nhisInvestigation/nhis_investigation.model.action';
import {modelReducer as nhisMedicineReducer} from './nhisMedicine/nhis_medicine.model.reducer';
import {isNhisMedicineModelAction} from './nhisMedicine/nhis_medicine.model.action';
import {modelReducer as nhisServiceOutcomeReducer} from './nhisServiceOutcome/nhis_service_outcome.model.reducer';
import {isNhisServiceOutcomeModelAction} from './nhisServiceOutcome/nhis_service_outcome.model.action';
import {modelReducer as nhisSpecialtyAttendedReducer} from './nhisSpecialtyAttended/nhis_specialty_attended.model.reducer';
import {isNhisSpecialtyAttendedModelAction} from './nhisSpecialtyAttended/nhis_specialty_attended.model.action';
import {modelReducer as nhisTypeOfServiceReducer} from './nhisTypeOfService/nhis_type_of_service.model.reducer';
import {isNhisTypeOfServiceModelAction} from './nhisTypeOfService/nhis_type_of_service.model.action';
import {modelReducer as newbornDetailReducer} from './newbornDetail/newborn_detail.model.reducer';
import {isNewbornDetailModelAction} from './newbornDetail/newborn_detail.model.action';
import {modelReducer as numberingSetupReducer} from './numberingSetup/numbering_setup.model.reducer';
import {isNumberingSetupModelAction} from './numberingSetup/numbering_setup.model.action';
import {modelReducer as nurseUserReducer} from './nurseUser/nurse_user.model.reducer';
import {isNurseUserModelAction} from './nurseUser/nurse_user.model.action';
import {modelReducer as nurseVitalSignMeasurementReducer} from './nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.reducer';
import {isNurseVitalSignMeasurementModelAction} from './nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.action';
import {modelReducer as obstetricAndGynecologyHistoryReducer} from './obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.reducer';
import {isObstetricAndGynecologyHistoryModelAction} from './obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.action';
import {modelReducer as odontogramExaminationReducer} from './odontogramExamination/odontogram_examination.model.reducer';
import {isOdontogramExaminationModelAction} from './odontogramExamination/odontogram_examination.model.action';
import {modelReducer as operatingTheaterMedicalExaminationRecordReducer} from './operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.reducer';
import {isOperatingTheaterMedicalExaminationRecordModelAction} from './operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.action';
import {modelReducer as ophthalmologyExaminationReducer} from './ophthalmologyExamination/ophthalmology_examination.model.reducer';
import {isOphthalmologyExaminationModelAction} from './ophthalmologyExamination/ophthalmology_examination.model.action';
import {modelReducer as pcareActionExaminationReducer} from './pcareActionExamination/pcare_action_examination.model.reducer';
import {isPcareActionExaminationModelAction} from './pcareActionExamination/pcare_action_examination.model.action';
import {modelReducer as pcareClubProlanisReducer} from './pcareClubProlanis/pcare_club_prolanis.model.reducer';
import {isPcareClubProlanisModelAction} from './pcareClubProlanis/pcare_club_prolanis.model.action';
import {modelReducer as pcareCompoundDrugReducer} from './pcareCompoundDrug/pcare_compound_drug.model.reducer';
import {isPcareCompoundDrugModelAction} from './pcareCompoundDrug/pcare_compound_drug.model.action';
import {modelReducer as pcareCompoundDrugItemReducer} from './pcareCompoundDrugItem/pcare_compound_drug_item.model.reducer';
import {isPcareCompoundDrugItemModelAction} from './pcareCompoundDrugItem/pcare_compound_drug_item.model.action';
import {modelReducer as pcareDiagnosaReducer} from './pcareDiagnosa/pcare_diagnosa.model.reducer';
import {isPcareDiagnosaModelAction} from './pcareDiagnosa/pcare_diagnosa.model.action';
import {modelReducer as pcareDokterReducer} from './pcareDokter/pcare_dokter.model.reducer';
import {isPcareDokterModelAction} from './pcareDokter/pcare_dokter.model.action';
import {modelReducer as pcareExaminationReducer} from './pcareExamination/pcare_examination.model.reducer';
import {isPcareExaminationModelAction} from './pcareExamination/pcare_examination.model.action';
import {modelReducer as pcareMCUReducer} from './pcareMCU/pcare_mcu.model.reducer';
import {isPcareMCUModelAction} from './pcareMCU/pcare_mcu.model.action';
import {modelReducer as pcareNonCompoundDrugReducer} from './pcareNonCompoundDrug/pcare_noncompound_drug.model.reducer';
import {isPcareNonCompoundDrugModelAction} from './pcareNonCompoundDrug/pcare_noncompound_drug.model.action';
import {modelReducer as pcareReferensiSaranaReducer} from './pcareReferensiSarana/pcare_referensi_sarana.model.reducer';
import {isPcareReferensiSaranaModelAction} from './pcareReferensiSarana/pcare_referensi_sarana.model.action';
import {modelReducer as pcareStatusPulangReducer} from './pcareStatusPulang/pcare_status_pulang.model.reducer';
import {isPcareStatusPulangModelAction} from './pcareStatusPulang/pcare_status_pulang.model.action';
import {modelReducer as pcareTindakanReducer} from './pcareTindakan/pcare_tindakan.model.reducer';
import {isPcareTindakanModelAction} from './pcareTindakan/pcare_tindakan.model.action';
import {modelReducer as pcareUmumReducer} from './pcareUmum/pcare_umum.model.reducer';
import {isPcareUmumModelAction} from './pcareUmum/pcare_umum.model.action';
import {modelReducer as patientCaseHistoryReducer} from './patientCaseHistory/patient_case_history.model.reducer';
import {isPatientCaseHistoryModelAction} from './patientCaseHistory/patient_case_history.model.action';
import {modelReducer as patientConsentReducer} from './patientConsent/patient_consent.model.reducer';
import {isPatientConsentModelAction} from './patientConsent/patient_consent.model.action';
import {modelReducer as patientContactInfoReducer} from './patientContactInfo/patient_contact_info.model.reducer';
import {isPatientContactInfoModelAction} from './patientContactInfo/patient_contact_info.model.action';
import {modelReducer as patientDetailReducer} from './patientDetail/patient_detail.model.reducer';
import {isPatientDetailModelAction} from './patientDetail/patient_detail.model.action';
import {modelReducer as patientDetailAddressReducer} from './patientDetailAddress/patient_detail_address.model.reducer';
import {isPatientDetailAddressModelAction} from './patientDetailAddress/patient_detail_address.model.action';
import {modelReducer as patientEmergencyContactDetailReducer} from './patientEmergencyContactDetail/patient_emergency_contact_detail.model.reducer';
import {isPatientEmergencyContactDetailModelAction} from './patientEmergencyContactDetail/patient_emergency_contact_detail.model.action';
import {modelReducer as patientEmploymentDetailReducer} from './patientEmploymentDetail/patient_employment_detail.model.reducer';
import {isPatientEmploymentDetailModelAction} from './patientEmploymentDetail/patient_employment_detail.model.action';
import {modelReducer as patientGeneralInfoReducer} from './patientGeneralInfo/patient_general_info.model.reducer';
import {isPatientGeneralInfoModelAction} from './patientGeneralInfo/patient_general_info.model.action';
import {modelReducer as patientPaymentSelfPayingReducer} from './patientPaymentSelfPaying/patient_payment_self_paying.model.reducer';
import {isPatientPaymentSelfPayingModelAction} from './patientPaymentSelfPaying/patient_payment_self_paying.model.action';
import {modelReducer as patientPaymentBPJSReducer} from './patientPaymentBPJS/patient_payment_bpjs.model.reducer';
import {isPatientPaymentBPJSModelAction} from './patientPaymentBPJS/patient_payment_bpjs.model.action';
import {modelReducer as patientPaymentInsuranceReducer} from './patientPaymentInsurance/patient_payment_insurance.model.reducer';
import {isPatientPaymentInsuranceModelAction} from './patientPaymentInsurance/patient_payment_insurance.model.action';
import {modelReducer as patientPaymentOthersReducer} from './patientPaymentOthers/patient_payment_others.model.reducer';
import {isPatientPaymentOthersModelAction} from './patientPaymentOthers/patient_payment_others.model.action';
import {modelReducer as patientPersonalInfoReducer} from './patientPersonalInfo/patient_personal_info.model.reducer';
import {isPatientPersonalInfoModelAction} from './patientPersonalInfo/patient_personal_info.model.action';
import {modelReducer as patientSupportingDocumentReducer} from './patientSupportingDocument/patient_supporting_document.model.reducer';
import {isPatientSupportingDocumentModelAction} from './patientSupportingDocument/patient_supporting_document.model.action';
import {modelReducer as patientVisitReducer} from './patientVisit/patient_visit.model.reducer';
import {isPatientVisitModelAction} from './patientVisit/patient_visit.model.action';
import {modelReducer as patientVisitPatientPaymentInsuranceReducer} from './patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.reducer';
import {isPatientVisitPatientPaymentInsuranceModelAction} from './patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.action';
import {modelReducer as patientVisitPatientPaymentOthersReducer} from './patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.reducer';
import {isPatientVisitPatientPaymentOthersModelAction} from './patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.action';
import {modelReducer as patientVisitPaymentSelfPayingReducer} from './patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.reducer';
import {isPatientVisitPaymentSelfPayingModelAction} from './patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.action';
import {modelReducer as patientVitalInformationReducer} from './patientVitalInformation/patient_vital_information.model.reducer';
import {isPatientVitalInformationModelAction} from './patientVitalInformation/patient_vital_information.model.action';
import {modelReducer as pharmacySetupReducer} from './pharmacySetup/pharmacy_setup.model.reducer';
import {isPharmacySetupModelAction} from './pharmacySetup/pharmacy_setup.model.action';
import {modelReducer as pharmacyUserReducer} from './pharmacyUser/pharmacy_user.model.reducer';
import {isPharmacyUserModelAction} from './pharmacyUser/pharmacy_user.model.action';
import {modelReducer as postOperativeDetailsReducer} from './postOperativeDetails/post_operative_details.model.reducer';
import {isPostOperativeDetailsModelAction} from './postOperativeDetails/post_operative_details.model.action';
import {modelReducer as preoperativeRecordsReducer} from './preoperativeRecords/preoperative_records.model.reducer';
import {isPreoperativeRecordsModelAction} from './preoperativeRecords/preoperative_records.model.action';
import {modelReducer as prescriptionCompoundReducer} from './prescriptionCompound/prescription_compound.model.reducer';
import {isPrescriptionCompoundModelAction} from './prescriptionCompound/prescription_compound.model.action';
import {modelReducer as prescriptionHeaderReducer} from './prescriptionHeader/prescription_header.model.reducer';
import {isPrescriptionHeaderModelAction} from './prescriptionHeader/prescription_header.model.action';
import {modelReducer as prescriptionItemReducer} from './prescriptionItem/prescription_item.model.reducer';
import {isPrescriptionItemModelAction} from './prescriptionItem/prescription_item.model.action';
import {modelReducer as priceComponentReducer} from './priceComponent/price_component.model.reducer';
import {isPriceComponentModelAction} from './priceComponent/price_component.model.action';
import {modelReducer as privilegeReducer} from './privilege/privilege.model.reducer';
import {isPrivilegeModelAction} from './privilege/privilege.model.action';
import {modelReducer as processWorkflowReducer} from './processWorkflow/process_workflow.model.reducer';
import {isProcessWorkflowModelAction} from './processWorkflow/process_workflow.model.action';
import {modelReducer as purchaseOrderReducer} from './purchaseOrder/purchase_order.model.reducer';
import {isPurchaseOrderModelAction} from './purchaseOrder/purchase_order.model.action';
import {modelReducer as purchaseOrderStockDetailReducer} from './purchaseOrderStockDetail/purchase_order_stock_detail.model.reducer';
import {isPurchaseOrderStockDetailModelAction} from './purchaseOrderStockDetail/purchase_order_stock_detail.model.action';
import {modelReducer as purchaseRequisitionReducer} from './purchaseRequisition/purchase_requisition.model.reducer';
import {isPurchaseRequisitionModelAction} from './purchaseRequisition/purchase_requisition.model.action';
import {modelReducer as purchaseRequisitionStockDetailReducer} from './purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.reducer';
import {isPurchaseRequisitionStockDetailModelAction} from './purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.action';
import {modelReducer as purchasingUserReducer} from './purchasingUser/purchasing_user.model.reducer';
import {isPurchasingUserModelAction} from './purchasingUser/purchasing_user.model.action';
import {modelReducer as referenceDataReducer} from './referenceData/reference_data.model.reducer';
import {isReferenceDataModelAction} from './referenceData/reference_data.model.action';
import {modelReducer as referenceHeaderReducer} from './referenceHeader/reference_header.model.reducer';
import {isReferenceHeaderModelAction} from './referenceHeader/reference_header.model.action';
import {modelReducer as registrationReducer} from './registration/registration.model.reducer';
import {isRegistrationModelAction} from './registration/registration.model.action';
import {modelReducer as registrationUserReducer} from './registrationUser/registration_user.model.reducer';
import {isRegistrationUserModelAction} from './registrationUser/registration_user.model.action';
import {modelReducer as retailPharmacyReducer} from './retailPharmacy/retail_pharmacy.model.reducer';
import {isRetailPharmacyModelAction} from './retailPharmacy/retail_pharmacy.model.action';
import {modelReducer as retailPharmacyInvoiceReducer} from './retailPharmacyInvoice/retail_pharmacy_invoice.model.reducer';
import {isRetailPharmacyInvoiceModelAction} from './retailPharmacyInvoice/retail_pharmacy_invoice.model.action';
import {modelReducer as retailPharmacyStockDetailReducer} from './retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.reducer';
import {isRetailPharmacyStockDetailModelAction} from './retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.action';
import {modelReducer as returnSupplierReducer} from './returnSupplier/return_supplier.model.reducer';
import {isReturnSupplierModelAction} from './returnSupplier/return_supplier.model.action';
import {modelReducer as returnSupplierStockDetailReducer} from './returnSupplierStockDetail/return_supplier_stock_detail.model.reducer';
import {isReturnSupplierStockDetailModelAction} from './returnSupplierStockDetail/return_supplier_stock_detail.model.action';
import {modelReducer as roleReducer} from './role/role.model.reducer';
import {isRoleModelAction} from './role/role.model.action';
import {modelReducer as roomFacilityReducer} from './roomFacility/room_facility.model.reducer';
import {isRoomFacilityModelAction} from './roomFacility/room_facility.model.action';
import {modelReducer as roomTransferReducer} from './roomTransfer/room_transfer.model.reducer';
import {isRoomTransferModelAction} from './roomTransfer/room_transfer.model.action';
import {modelReducer as sepReducer} from './sep/sep.model.reducer';
import {isSepModelAction} from './sep/sep.model.action';
import {modelReducer as sampleCollectionInformationReducer} from './sampleCollectionInformation/sample_collection_information.model.reducer';
import {isSampleCollectionInformationModelAction} from './sampleCollectionInformation/sample_collection_information.model.action';
import {modelReducer as sampleCollectionItemsReducer} from './sampleCollectionItems/sample_collection_items.model.reducer';
import {isSampleCollectionItemsModelAction} from './sampleCollectionItems/sample_collection_items.model.action';
import {modelReducer as satuSehatConfigurationReducer} from './satuSehatConfiguration/satu_sehat_configuration.model.reducer';
import {isSatuSehatConfigurationModelAction} from './satuSehatConfiguration/satu_sehat_configuration.model.action';
import {modelReducer as serviceReducer} from './service/service.model.reducer';
import {isServiceModelAction} from './service/service.model.action';
import {modelReducer as serviceFacilityCategoryReducer} from './serviceFacilityCategory/service_facility_category.model.reducer';
import {isServiceFacilityCategoryModelAction} from './serviceFacilityCategory/service_facility_category.model.action';
import {modelReducer as serviceItemReducer} from './serviceItem/service_item.model.reducer';
import {isServiceItemModelAction} from './serviceItem/service_item.model.action';
import {modelReducer as serviceItemAssignmentReducer} from './serviceItemAssignment/service_item_assignment.model.reducer';
import {isServiceItemAssignmentModelAction} from './serviceItemAssignment/service_item_assignment.model.action';
import {modelReducer as staffReducer} from './staff/staff.model.reducer';
import {isStaffModelAction} from './staff/staff.model.action';
import {modelReducer as stockCatalogueReducer} from './stockCatalogue/stock_catalogue.model.reducer';
import {isStockCatalogueModelAction} from './stockCatalogue/stock_catalogue.model.action';
import {modelReducer as stockControlReducer} from './stockControl/stock_control.model.reducer';
import {isStockControlModelAction} from './stockControl/stock_control.model.action';
import {modelReducer as stockTransactionDetailReducer} from './stockTransactionDetail/stock_transaction_detail.model.reducer';
import {isStockTransactionDetailModelAction} from './stockTransactionDetail/stock_transaction_detail.model.action';
import {modelReducer as stockTransactionPerDateReducer} from './stockTransactionPerDate/stock_transaction_per_date.model.reducer';
import {isStockTransactionPerDateModelAction} from './stockTransactionPerDate/stock_transaction_per_date.model.action';
import {modelReducer as stockTransactionPerDateTypeReducer} from './stockTransactionPerDateType/stock_transaction_per_date_type.model.reducer';
import {isStockTransactionPerDateTypeModelAction} from './stockTransactionPerDateType/stock_transaction_per_date_type.model.action';
import {modelReducer as supplierReducer} from './supplier/supplier.model.reducer';
import {isSupplierModelAction} from './supplier/supplier.model.action';
import {modelReducer as supplierBankAccountReducer} from './supplierBankAccount/supplier_bank_account.model.reducer';
import {isSupplierBankAccountModelAction} from './supplierBankAccount/supplier_bank_account.model.action';
import {modelReducer as supplierContactDetailReducer} from './supplierContactDetail/supplier_contact_detail.model.reducer';
import {isSupplierContactDetailModelAction} from './supplierContactDetail/supplier_contact_detail.model.action';
import {modelReducer as supplierProductDetailReducer} from './supplierProductDetail/supplier_product_detail.model.reducer';
import {isSupplierProductDetailModelAction} from './supplierProductDetail/supplier_product_detail.model.action';
import {modelReducer as systemAdminUserReducer} from './systemAdminUser/system_admin_user.model.reducer';
import {isSystemAdminUserModelAction} from './systemAdminUser/system_admin_user.model.action';
import {modelReducer as tariffDefinitionReducer} from './tariffDefinition/tariff_definition.model.reducer';
import {isTariffDefinitionModelAction} from './tariffDefinition/tariff_definition.model.action';
import {modelReducer as tariffDefinitionOtherComponentReducer} from './tariffDefinitionOtherComponent/tariff_definition_other_component.model.reducer';
import {isTariffDefinitionOtherComponentModelAction} from './tariffDefinitionOtherComponent/tariff_definition_other_component.model.action';
import {modelReducer as tariffFormulaReducer} from './tariffFormula/tariff_formula.model.reducer';
import {isTariffFormulaModelAction} from './tariffFormula/tariff_formula.model.action';
import {modelReducer as tariffPackageReducer} from './tariffPackage/tariff_package.model.reducer';
import {isTariffPackageModelAction} from './tariffPackage/tariff_package.model.action';
import {modelReducer as tariffPackageItemReducer} from './tariffPackageItem/tariff_package_item.model.reducer';
import {isTariffPackageItemModelAction} from './tariffPackageItem/tariff_package_item.model.action';
import {modelReducer as tariffPackageServiceAssignmentReducer} from './tariffPackageServiceAssignment/tariff_package_service_assignment.model.reducer';
import {isTariffPackageServiceAssignmentModelAction} from './tariffPackageServiceAssignment/tariff_package_service_assignment.model.action';
import {modelReducer as tariffSchemaReducer} from './tariffSchema/tariff_schema.model.reducer';
import {isTariffSchemaModelAction} from './tariffSchema/tariff_schema.model.action';
import {modelReducer as taskDashboardReducer} from './taskDashboard/task_dashboard.model.reducer';
import {isTaskDashboardModelAction} from './taskDashboard/task_dashboard.model.action';
import {modelReducer as transactionDetailTypeReducer} from './transactionDetailType/transaction_detail_type.model.reducer';
import {isTransactionDetailTypeModelAction} from './transactionDetailType/transaction_detail_type.model.action';
import {modelReducer as transactionDetailTypeMappingReducer} from './transactionDetailTypeMapping/transaction_detail_type_mapping.model.reducer';
import {isTransactionDetailTypeMappingModelAction} from './transactionDetailTypeMapping/transaction_detail_type_mapping.model.action';
import {modelReducer as transferOrderReducer} from './transferOrder/transfer_order.model.reducer';
import {isTransferOrderModelAction} from './transferOrder/transfer_order.model.action';
import {modelReducer as transferOrderStockDetailReducer} from './transferOrderStockDetail/transfer_order_stock_detail.model.reducer';
import {isTransferOrderStockDetailModelAction} from './transferOrderStockDetail/transfer_order_stock_detail.model.action';
import {modelReducer as unitOfMeasurementReducer} from './unitOfMeasurement/unit_of_measurement.model.reducer';
import {isUnitOfMeasurementModelAction} from './unitOfMeasurement/unit_of_measurement.model.action';
import {modelReducer as userReducer} from './user/user.model.reducer';
import {isUserModelAction} from './user/user.model.action';
import {modelReducer as vaccinationOrderReducer} from './vaccinationOrder/vaccination_order.model.reducer';
import {isVaccinationOrderModelAction} from './vaccinationOrder/vaccination_order.model.action';
import {modelReducer as vaccinationOrderDetailReducer} from './vaccinationOrderDetail/vaccination_order_detail.model.reducer';
import {isVaccinationOrderDetailModelAction} from './vaccinationOrderDetail/vaccination_order_detail.model.action';
import {modelReducer as vitalSignsReducer} from './vitalSigns/vital_signs.model.reducer';
import {isVitalSignsModelAction} from './vitalSigns/vital_signs.model.action';
import {modelReducer as warehouseReducer} from './warehouse/warehouse.model.reducer';
import {isWarehouseModelAction} from './warehouse/warehouse.model.action';
import {modelReducer as warehouseInitialStockReducer} from './warehouseInitialStock/warehouse_initial_stock.model.reducer';
import {isWarehouseInitialStockModelAction} from './warehouseInitialStock/warehouse_initial_stock.model.action';
import {modelReducer as warehouseInventoryReducer} from './warehouseInventory/warehouse_inventory.model.reducer';
import {isWarehouseInventoryModelAction} from './warehouseInventory/warehouse_inventory.model.action';
import {modelReducer as warehouseUserReducer} from './warehouseUser/warehouse_user.model.reducer';
import {isWarehouseUserModelAction} from './warehouseUser/warehouse_user.model.action';
import {AppState, initialModelState, initialRouterState, ModelState} from './model.state';
import {ActionTypes} from './model.action';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Main reducer for the model state.
 */
export function modelReducer(modelState: ModelState, action: Action): ModelState {
	if (isAdministrationUserModelAction(action.type)) {
		return administrationUserReducer(modelState, action);
	}
	if (isAdministratorModelAction(action.type)) {
		return administratorReducer(modelState, action);
	}
	if (isAmendmentDetailModelAction(action.type)) {
		return amendmentDetailReducer(modelState, action);
	}
	if (isBpjsAccidentMasterModelAction(action.type)) {
		return bpjsAccidentMasterReducer(modelState, action);
	}
	if (isBpjsBedAvailabilityModelAction(action.type)) {
		return bpjsBedAvailabilityReducer(modelState, action);
	}
	if (isBpjsClaimDataModelAction(action.type)) {
		return bpjsClaimDataReducer(modelState, action);
	}
	if (isBpjsClaimSubmissionModelAction(action.type)) {
		return bpjsClaimSubmissionReducer(modelState, action);
	}
	if (isBpjsControlPlanModelAction(action.type)) {
		return bpjsControlPlanReducer(modelState, action);
	}
	if (isBpjsControlSpecialistModelAction(action.type)) {
		return bpjsControlSpecialistReducer(modelState, action);
	}
	if (isBpjsDiagnoseModelAction(action.type)) {
		return bpjsDiagnoseReducer(modelState, action);
	}
	if (isBpjsDiagnosePRBModelAction(action.type)) {
		return bpjsDiagnosePRBReducer(modelState, action);
	}
	if (isBpjsDismissalConditionModelAction(action.type)) {
		return bpjsDismissalConditionReducer(modelState, action);
	}
	if (isBpjsDismissalMappingModelAction(action.type)) {
		return bpjsDismissalMappingReducer(modelState, action);
	}
	if (isBpjsDoctorMappingModelAction(action.type)) {
		return bpjsDoctorMappingReducer(modelState, action);
	}
	if (isBpjsDoctorScheduleModelAction(action.type)) {
		return bpjsDoctorScheduleReducer(modelState, action);
	}
	if (isBpjsDrugGenericPRBModelAction(action.type)) {
		return bpjsDrugGenericPRBReducer(modelState, action);
	}
	if (isBpjsFacilityListModelAction(action.type)) {
		return bpjsFacilityListReducer(modelState, action);
	}
	if (isBpjsFingerPrintModelAction(action.type)) {
		return bpjsFingerPrintReducer(modelState, action);
	}
	if (isBpjsGeneralModelAction(action.type)) {
		return bpjsGeneralReducer(modelState, action);
	}
	if (isBpjsHealthFacilityModelAction(action.type)) {
		return bpjsHealthFacilityReducer(modelState, action);
	}
	if (isBpjsHospitalizationPlanModelAction(action.type)) {
		return bpjsHospitalizationPlanReducer(modelState, action);
	}
	if (isBpjsINACBGModelAction(action.type)) {
		return bpjsINACBGReducer(modelState, action);
	}
	if (isBpjsINACBGClaimModelAction(action.type)) {
		return bpjsINACBGClaimReducer(modelState, action);
	}
	if (isBpjsINACBGVariableModelAction(action.type)) {
		return bpjsINACBGVariableReducer(modelState, action);
	}
	if (isBpjsJasaRaharjaModelAction(action.type)) {
		return bpjsJasaRaharjaReducer(modelState, action);
	}
	if (isBpjsJasaRaharjaClaimModelAction(action.type)) {
		return bpjsJasaRaharjaClaimReducer(modelState, action);
	}
	if (isBpjsListFingerPrintModelAction(action.type)) {
		return bpjsListFingerPrintReducer(modelState, action);
	}
	if (isBpjsListTaskModelAction(action.type)) {
		return bpjsListTaskReducer(modelState, action);
	}
	if (isBpjsOutsideFacilityReferralModelAction(action.type)) {
		return bpjsOutsideFacilityReferralReducer(modelState, action);
	}
	if (isBpjsPRBModelAction(action.type)) {
		return bpjsPRBReducer(modelState, action);
	}
	if (isBpjsPRBDetailModelAction(action.type)) {
		return bpjsPRBDetailReducer(modelState, action);
	}
	if (isBpjsPatientReferralModelAction(action.type)) {
		return bpjsPatientReferralReducer(modelState, action);
	}
	if (isBpjsPcareDPHOModelAction(action.type)) {
		return bpjsPcareDPHOReducer(modelState, action);
	}
	if (isBpjsPcareKegiatanKelompokModelAction(action.type)) {
		return bpjsPcareKegiatanKelompokReducer(modelState, action);
	}
	if (isBpjsPcareKesadaranModelAction(action.type)) {
		return bpjsPcareKesadaranReducer(modelState, action);
	}
	if (isBpjsPcarePesertaKegiatanKelompokModelAction(action.type)) {
		return bpjsPcarePesertaKegiatanKelompokReducer(modelState, action);
	}
	if (isBpjsPcarePoliModelAction(action.type)) {
		return bpjsPcarePoliReducer(modelState, action);
	}
	if (isBpjsPcareProviderRayonisasiModelAction(action.type)) {
		return bpjsPcareProviderRayonisasiReducer(modelState, action);
	}
	if (isBpjsPcareRegistrationsModelAction(action.type)) {
		return bpjsPcareRegistrationsReducer(modelState, action);
	}
	if (isBpjsProcedureModelAction(action.type)) {
		return bpjsProcedureReducer(modelState, action);
	}
	if (isBpjsReferralSpecialistModelAction(action.type)) {
		return bpjsReferralSpecialistReducer(modelState, action);
	}
	if (isBpjsSEPModelAction(action.type)) {
		return bpjsSEPReducer(modelState, action);
	}
	if (isBpjsSEPINACBGIntegrationModelAction(action.type)) {
		return bpjsSEPINACBGIntegrationReducer(modelState, action);
	}
	if (isBpjsSEPInternalDataModelAction(action.type)) {
		return bpjsSEPInternalDataReducer(modelState, action);
	}
	if (isBpjsSEPSubmissionModelAction(action.type)) {
		return bpjsSEPSubmissionReducer(modelState, action);
	}
	if (isBpjsSearchControlLetterModelAction(action.type)) {
		return bpjsSearchControlLetterReducer(modelState, action);
	}
	if (isBpjsSearchSEPModelAction(action.type)) {
		return bpjsSearchSEPReducer(modelState, action);
	}
	if (isBpjsServiceMappingModelAction(action.type)) {
		return bpjsServiceMappingReducer(modelState, action);
	}
	if (isBpjsSpecialReferralModelAction(action.type)) {
		return bpjsSpecialReferralReducer(modelState, action);
	}
	if (isBpjsTotalReferralSEPModelAction(action.type)) {
		return bpjsTotalReferralSEPReducer(modelState, action);
	}
	if (isBpjsTreatmentClassMappingModelAction(action.type)) {
		return bpjsTreatmentClassMappingReducer(modelState, action);
	}
	if (isBpjsTreatmentHistoryModelAction(action.type)) {
		return bpjsTreatmentHistoryReducer(modelState, action);
	}
	if (isBpjsTreatmentRoomModelAction(action.type)) {
		return bpjsTreatmentRoomReducer(modelState, action);
	}
	if (isBpjsUpdateDismissalDateModelAction(action.type)) {
		return bpjsUpdateDismissalDateReducer(modelState, action);
	}
	if (isBpjsVisitDataModelAction(action.type)) {
		return bpjsVisitDataReducer(modelState, action);
	}
	if (isBatchStockBalanceModelAction(action.type)) {
		return batchStockBalanceReducer(modelState, action);
	}
	if (isBatchStockBalancePerDateModelAction(action.type)) {
		return batchStockBalancePerDateReducer(modelState, action);
	}
	if (isBatchStockTransactionDetailModelAction(action.type)) {
		return batchStockTransactionDetailReducer(modelState, action);
	}
	if (isBedFacilityModelAction(action.type)) {
		return bedFacilityReducer(modelState, action);
	}
	if (isBedReserveModelAction(action.type)) {
		return bedReserveReducer(modelState, action);
	}
	if (isBirthHistoryModelAction(action.type)) {
		return birthHistoryReducer(modelState, action);
	}
	if (isBodyChartExaminationModelAction(action.type)) {
		return bodyChartExaminationReducer(modelState, action);
	}
	if (isBpjsPcareKunjunganRujukanModelAction(action.type)) {
		return bpjsPcareKunjunganRujukanReducer(modelState, action);
	}
	if (isBpjsPcarePendaftaranModelAction(action.type)) {
		return bpjsPcarePendaftaranReducer(modelState, action);
	}
	if (isBpjsPcareRiwayatKunjunganModelAction(action.type)) {
		return bpjsPcareRiwayatKunjunganReducer(modelState, action);
	}
	if (isCashAllocationModelAction(action.type)) {
		return cashAllocationReducer(modelState, action);
	}
	if (isCashReceiptModelAction(action.type)) {
		return cashReceiptReducer(modelState, action);
	}
	if (isCashRefundModelAction(action.type)) {
		return cashRefundReducer(modelState, action);
	}
	if (isCashierUserModelAction(action.type)) {
		return cashierUserReducer(modelState, action);
	}
	if (isCatalogueMedicalModelAction(action.type)) {
		return catalogueMedicalReducer(modelState, action);
	}
	if (isCatalogueNonMedicalModelAction(action.type)) {
		return catalogueNonMedicalReducer(modelState, action);
	}
	if (isCatalogueUOMModelAction(action.type)) {
		return catalogueUOMReducer(modelState, action);
	}
	if (isChartOfAccountModelAction(action.type)) {
		return chartOfAccountReducer(modelState, action);
	}
	if (isChartOfAccountMappingModelAction(action.type)) {
		return chartOfAccountMappingReducer(modelState, action);
	}
	if (isClaimUserModelAction(action.type)) {
		return claimUserReducer(modelState, action);
	}
	if (isCoTreatingDoctorModelAction(action.type)) {
		return coTreatingDoctorReducer(modelState, action);
	}
	if (isCompoundPrescriptionDetailModelAction(action.type)) {
		return compoundPrescriptionDetailReducer(modelState, action);
	}
	if (isCompoundPrescriptionItemModelAction(action.type)) {
		return compoundPrescriptionItemReducer(modelState, action);
	}
	if (isDailyCareCPPTModelAction(action.type)) {
		return dailyCareCPPTReducer(modelState, action);
	}
	if (isDeliveryMedicalExaminationRecordModelAction(action.type)) {
		return deliveryMedicalExaminationRecordReducer(modelState, action);
	}
	if (isDeliveryProgressModelAction(action.type)) {
		return deliveryProgressReducer(modelState, action);
	}
	if (isDiagnosesAndProceduresModelAction(action.type)) {
		return diagnosesAndProceduresReducer(modelState, action);
	}
	if (isDiagnosisExaminationRecordModelAction(action.type)) {
		return diagnosisExaminationRecordReducer(modelState, action);
	}
	if (isDiagnosisNandaModelAction(action.type)) {
		return diagnosisNandaReducer(modelState, action);
	}
	if (isDiagnosticExaminationResultsModelAction(action.type)) {
		return diagnosticExaminationResultsReducer(modelState, action);
	}
	if (isDiagnosticStaffExaminationSummaryModelAction(action.type)) {
		return diagnosticStaffExaminationSummaryReducer(modelState, action);
	}
	if (isDiagnosticSupportGeneralConfigurationModelAction(action.type)) {
		return diagnosticSupportGeneralConfigurationReducer(modelState, action);
	}
	if (isDiagnosticSupportUserModelAction(action.type)) {
		return diagnosticSupportUserReducer(modelState, action);
	}
	if (isDoctorScheduleModelAction(action.type)) {
		return doctorScheduleReducer(modelState, action);
	}
	if (isDoctorUserModelAction(action.type)) {
		return doctorUserReducer(modelState, action);
	}
	if (isEntExaminationModelAction(action.type)) {
		return entExaminationReducer(modelState, action);
	}
	if (isEmergencyMedicalExaminationRecordModelAction(action.type)) {
		return emergencyMedicalExaminationRecordReducer(modelState, action);
	}
	if (isExaminationGroupModelAction(action.type)) {
		return examinationGroupReducer(modelState, action);
	}
	if (isExaminationItemModelAction(action.type)) {
		return examinationItemReducer(modelState, action);
	}
	if (isExaminationItemDetailModelAction(action.type)) {
		return examinationItemDetailReducer(modelState, action);
	}
	if (isFacilityHistoryModelAction(action.type)) {
		return facilityHistoryReducer(modelState, action);
	}
	if (isFacilityUserModelAction(action.type)) {
		return facilityUserReducer(modelState, action);
	}
	if (isFluidBalanceDetailModelAction(action.type)) {
		return fluidBalanceDetailReducer(modelState, action);
	}
	if (isFormulirKonselingTesHivModelAction(action.type)) {
		return formulirKonselingTesHivReducer(modelState, action);
	}
	if (isGoodsReceiveNoteModelAction(action.type)) {
		return goodsReceiveNoteReducer(modelState, action);
	}
	if (isGoodsReceiveNoteBatchModelAction(action.type)) {
		return goodsReceiveNoteBatchReducer(modelState, action);
	}
	if (isGoodsReceiveNoteItemModelAction(action.type)) {
		return goodsReceiveNoteItemReducer(modelState, action);
	}
	if (isHealthFacilityModelAction(action.type)) {
		return healthFacilityReducer(modelState, action);
	}
	if (isHemodialysisExaminationModelAction(action.type)) {
		return hemodialysisExaminationReducer(modelState, action);
	}
	if (isHemodialysisMonitoringModelAction(action.type)) {
		return hemodialysisMonitoringReducer(modelState, action);
	}
	if (isHospitalBranchInformationModelAction(action.type)) {
		return hospitalBranchInformationReducer(modelState, action);
	}
	if (isHospitalGroupInformationModelAction(action.type)) {
		return hospitalGroupInformationReducer(modelState, action);
	}
	if (isIcd10ModelAction(action.type)) {
		return icd10Reducer(modelState, action);
	}
	if (isIcd9CMModelAction(action.type)) {
		return icd9CMReducer(modelState, action);
	}
	if (isInformedConsentModelAction(action.type)) {
		return informedConsentReducer(modelState, action);
	}
	if (isInpatientMedicalExaminationRecordModelAction(action.type)) {
		return inpatientMedicalExaminationRecordReducer(modelState, action);
	}
	if (isInsuranceBenefitPlanModelAction(action.type)) {
		return insuranceBenefitPlanReducer(modelState, action);
	}
	if (isInsuranceProviderModelAction(action.type)) {
		return insuranceProviderReducer(modelState, action);
	}
	if (isInternalOrderModelAction(action.type)) {
		return internalOrderReducer(modelState, action);
	}
	if (isInternalOrderStockDetailModelAction(action.type)) {
		return internalOrderStockDetailReducer(modelState, action);
	}
	if (isIntraoperativeRecordsModelAction(action.type)) {
		return intraoperativeRecordsReducer(modelState, action);
	}
	if (isInventoryAdjusmentBatchModelAction(action.type)) {
		return inventoryAdjusmentBatchReducer(modelState, action);
	}
	if (isInventoryAdjustmentModelAction(action.type)) {
		return inventoryAdjustmentReducer(modelState, action);
	}
	if (isInventoryAdjustmentItemModelAction(action.type)) {
		return inventoryAdjustmentItemReducer(modelState, action);
	}
	if (isInventoryBatchCorrectionModelAction(action.type)) {
		return inventoryBatchCorrectionReducer(modelState, action);
	}
	if (isInventoryBatchCorrectionItemModelAction(action.type)) {
		return inventoryBatchCorrectionItemReducer(modelState, action);
	}
	if (isInvoiceModelAction(action.type)) {
		return invoiceReducer(modelState, action);
	}
	if (isInvoiceItemModelAction(action.type)) {
		return invoiceItemReducer(modelState, action);
	}
	if (isInvoiceItemComponentModelAction(action.type)) {
		return invoiceItemComponentReducer(modelState, action);
	}
	if (isInvoicePaymentInsuranceModelAction(action.type)) {
		return invoicePaymentInsuranceReducer(modelState, action);
	}
	if (isInvoicePaymentOtherModelAction(action.type)) {
		return invoicePaymentOtherReducer(modelState, action);
	}
	if (isInvoicePaymentSelfPayingModelAction(action.type)) {
		return invoicePaymentSelfPayingReducer(modelState, action);
	}
	if (isInvoiceSummaryModelAction(action.type)) {
		return invoiceSummaryReducer(modelState, action);
	}
	if (isJournalModelAction(action.type)) {
		return journalReducer(modelState, action);
	}
	if (isLibraryModelAction(action.type)) {
		return libraryReducer(modelState, action);
	}
	if (isLocationModelAction(action.type)) {
		return locationReducer(modelState, action);
	}
	if (isMcuPackageModelAction(action.type)) {
		return mcuPackageReducer(modelState, action);
	}
	if (isMcuPackageItemModelAction(action.type)) {
		return mcuPackageItemReducer(modelState, action);
	}
	if (isManagementUserModelAction(action.type)) {
		return managementUserReducer(modelState, action);
	}
	if (isMedicalCertificateDischargeResumeModelAction(action.type)) {
		return medicalCertificateDischargeResumeReducer(modelState, action);
	}
	if (isMedicalCertificateBirthModelAction(action.type)) {
		return medicalCertificateBirthReducer(modelState, action);
	}
	if (isMedicalCertificateHospitalizationModelAction(action.type)) {
		return medicalCertificateHospitalizationReducer(modelState, action);
	}
	if (isMedicalCertificateMedicalAttendanceModelAction(action.type)) {
		return medicalCertificateMedicalAttendanceReducer(modelState, action);
	}
	if (isMedicalCertificateMentalHealthModelAction(action.type)) {
		return medicalCertificateMentalHealthReducer(modelState, action);
	}
	if (isMedicalCertificatePhysicalHealthModelAction(action.type)) {
		return medicalCertificatePhysicalHealthReducer(modelState, action);
	}
	if (isMedicalCertificateRestrictedWorkModelAction(action.type)) {
		return medicalCertificateRestrictedWorkReducer(modelState, action);
	}
	if (isMedicalCertificateSickLeaveModelAction(action.type)) {
		return medicalCertificateSickLeaveReducer(modelState, action);
	}
	if (isMedicalExaminationRecordModelAction(action.type)) {
		return medicalExaminationRecordReducer(modelState, action);
	}
	if (isMedicalExaminationRecordDischargeSummaryModelAction(action.type)) {
		return medicalExaminationRecordDischargeSummaryReducer(modelState, action);
	}
	if (isMedicalFeeModelAction(action.type)) {
		return medicalFeeReducer(modelState, action);
	}
	if (isMedicalFeeItemComponentModelAction(action.type)) {
		return medicalFeeItemComponentReducer(modelState, action);
	}
	if (isMedicalRecordInitialChecklistModelAction(action.type)) {
		return medicalRecordInitialChecklistReducer(modelState, action);
	}
	if (isMedicalRecordNextVerificationChecklistModelAction(action.type)) {
		return medicalRecordNextVerificationChecklistReducer(modelState, action);
	}
	if (isMedicalRecordUserModelAction(action.type)) {
		return medicalRecordUserReducer(modelState, action);
	}
	if (isMedicalTranscriberUserModelAction(action.type)) {
		return medicalTranscriberUserReducer(modelState, action);
	}
	if (isMedicationAdministeredHistoryModelAction(action.type)) {
		return medicationAdministeredHistoryReducer(modelState, action);
	}
	if (isMedicationCompoundModelAction(action.type)) {
		return medicationCompoundReducer(modelState, action);
	}
	if (isMedicationHeaderModelAction(action.type)) {
		return medicationHeaderReducer(modelState, action);
	}
	if (isMedicationItemModelAction(action.type)) {
		return medicationItemReducer(modelState, action);
	}
	if (isMerchantModelAction(action.type)) {
		return merchantReducer(modelState, action);
	}
	if (isMerchantSurchargeAndFeeModelAction(action.type)) {
		return merchantSurchargeAndFeeReducer(modelState, action);
	}
	if (isNhisClaimModelAction(action.type)) {
		return nhisClaimReducer(modelState, action);
	}
	if (isNhisClaimGDRGDetailModelAction(action.type)) {
		return nhisClaimGDRGDetailReducer(modelState, action);
	}
	if (isNhisClaimInvestigationDetailModelAction(action.type)) {
		return nhisClaimInvestigationDetailReducer(modelState, action);
	}
	if (isNhisGDRGModelAction(action.type)) {
		return nhisGDRGReducer(modelState, action);
	}
	if (isNhisInvestigationModelAction(action.type)) {
		return nhisInvestigationReducer(modelState, action);
	}
	if (isNhisMedicineModelAction(action.type)) {
		return nhisMedicineReducer(modelState, action);
	}
	if (isNhisServiceOutcomeModelAction(action.type)) {
		return nhisServiceOutcomeReducer(modelState, action);
	}
	if (isNhisSpecialtyAttendedModelAction(action.type)) {
		return nhisSpecialtyAttendedReducer(modelState, action);
	}
	if (isNhisTypeOfServiceModelAction(action.type)) {
		return nhisTypeOfServiceReducer(modelState, action);
	}
	if (isNewbornDetailModelAction(action.type)) {
		return newbornDetailReducer(modelState, action);
	}
	if (isNumberingSetupModelAction(action.type)) {
		return numberingSetupReducer(modelState, action);
	}
	if (isNurseUserModelAction(action.type)) {
		return nurseUserReducer(modelState, action);
	}
	if (isNurseVitalSignMeasurementModelAction(action.type)) {
		return nurseVitalSignMeasurementReducer(modelState, action);
	}
	if (isObstetricAndGynecologyHistoryModelAction(action.type)) {
		return obstetricAndGynecologyHistoryReducer(modelState, action);
	}
	if (isOdontogramExaminationModelAction(action.type)) {
		return odontogramExaminationReducer(modelState, action);
	}
	if (isOperatingTheaterMedicalExaminationRecordModelAction(action.type)) {
		return operatingTheaterMedicalExaminationRecordReducer(modelState, action);
	}
	if (isOphthalmologyExaminationModelAction(action.type)) {
		return ophthalmologyExaminationReducer(modelState, action);
	}
	if (isPcareActionExaminationModelAction(action.type)) {
		return pcareActionExaminationReducer(modelState, action);
	}
	if (isPcareClubProlanisModelAction(action.type)) {
		return pcareClubProlanisReducer(modelState, action);
	}
	if (isPcareCompoundDrugModelAction(action.type)) {
		return pcareCompoundDrugReducer(modelState, action);
	}
	if (isPcareCompoundDrugItemModelAction(action.type)) {
		return pcareCompoundDrugItemReducer(modelState, action);
	}
	if (isPcareDiagnosaModelAction(action.type)) {
		return pcareDiagnosaReducer(modelState, action);
	}
	if (isPcareDokterModelAction(action.type)) {
		return pcareDokterReducer(modelState, action);
	}
	if (isPcareExaminationModelAction(action.type)) {
		return pcareExaminationReducer(modelState, action);
	}
	if (isPcareMCUModelAction(action.type)) {
		return pcareMCUReducer(modelState, action);
	}
	if (isPcareNonCompoundDrugModelAction(action.type)) {
		return pcareNonCompoundDrugReducer(modelState, action);
	}
	if (isPcareReferensiSaranaModelAction(action.type)) {
		return pcareReferensiSaranaReducer(modelState, action);
	}
	if (isPcareStatusPulangModelAction(action.type)) {
		return pcareStatusPulangReducer(modelState, action);
	}
	if (isPcareTindakanModelAction(action.type)) {
		return pcareTindakanReducer(modelState, action);
	}
	if (isPcareUmumModelAction(action.type)) {
		return pcareUmumReducer(modelState, action);
	}
	if (isPatientCaseHistoryModelAction(action.type)) {
		return patientCaseHistoryReducer(modelState, action);
	}
	if (isPatientConsentModelAction(action.type)) {
		return patientConsentReducer(modelState, action);
	}
	if (isPatientContactInfoModelAction(action.type)) {
		return patientContactInfoReducer(modelState, action);
	}
	if (isPatientDetailModelAction(action.type)) {
		return patientDetailReducer(modelState, action);
	}
	if (isPatientDetailAddressModelAction(action.type)) {
		return patientDetailAddressReducer(modelState, action);
	}
	if (isPatientEmergencyContactDetailModelAction(action.type)) {
		return patientEmergencyContactDetailReducer(modelState, action);
	}
	if (isPatientEmploymentDetailModelAction(action.type)) {
		return patientEmploymentDetailReducer(modelState, action);
	}
	if (isPatientGeneralInfoModelAction(action.type)) {
		return patientGeneralInfoReducer(modelState, action);
	}
	if (isPatientPaymentSelfPayingModelAction(action.type)) {
		return patientPaymentSelfPayingReducer(modelState, action);
	}
	if (isPatientPaymentBPJSModelAction(action.type)) {
		return patientPaymentBPJSReducer(modelState, action);
	}
	if (isPatientPaymentInsuranceModelAction(action.type)) {
		return patientPaymentInsuranceReducer(modelState, action);
	}
	if (isPatientPaymentOthersModelAction(action.type)) {
		return patientPaymentOthersReducer(modelState, action);
	}
	if (isPatientPersonalInfoModelAction(action.type)) {
		return patientPersonalInfoReducer(modelState, action);
	}
	if (isPatientSupportingDocumentModelAction(action.type)) {
		return patientSupportingDocumentReducer(modelState, action);
	}
	if (isPatientVisitModelAction(action.type)) {
		return patientVisitReducer(modelState, action);
	}
	if (isPatientVisitPatientPaymentInsuranceModelAction(action.type)) {
		return patientVisitPatientPaymentInsuranceReducer(modelState, action);
	}
	if (isPatientVisitPatientPaymentOthersModelAction(action.type)) {
		return patientVisitPatientPaymentOthersReducer(modelState, action);
	}
	if (isPatientVisitPaymentSelfPayingModelAction(action.type)) {
		return patientVisitPaymentSelfPayingReducer(modelState, action);
	}
	if (isPatientVitalInformationModelAction(action.type)) {
		return patientVitalInformationReducer(modelState, action);
	}
	if (isPharmacySetupModelAction(action.type)) {
		return pharmacySetupReducer(modelState, action);
	}
	if (isPharmacyUserModelAction(action.type)) {
		return pharmacyUserReducer(modelState, action);
	}
	if (isPostOperativeDetailsModelAction(action.type)) {
		return postOperativeDetailsReducer(modelState, action);
	}
	if (isPreoperativeRecordsModelAction(action.type)) {
		return preoperativeRecordsReducer(modelState, action);
	}
	if (isPrescriptionCompoundModelAction(action.type)) {
		return prescriptionCompoundReducer(modelState, action);
	}
	if (isPrescriptionHeaderModelAction(action.type)) {
		return prescriptionHeaderReducer(modelState, action);
	}
	if (isPrescriptionItemModelAction(action.type)) {
		return prescriptionItemReducer(modelState, action);
	}
	if (isPriceComponentModelAction(action.type)) {
		return priceComponentReducer(modelState, action);
	}
	if (isPrivilegeModelAction(action.type)) {
		return privilegeReducer(modelState, action);
	}
	if (isProcessWorkflowModelAction(action.type)) {
		return processWorkflowReducer(modelState, action);
	}
	if (isPurchaseOrderModelAction(action.type)) {
		return purchaseOrderReducer(modelState, action);
	}
	if (isPurchaseOrderStockDetailModelAction(action.type)) {
		return purchaseOrderStockDetailReducer(modelState, action);
	}
	if (isPurchaseRequisitionModelAction(action.type)) {
		return purchaseRequisitionReducer(modelState, action);
	}
	if (isPurchaseRequisitionStockDetailModelAction(action.type)) {
		return purchaseRequisitionStockDetailReducer(modelState, action);
	}
	if (isPurchasingUserModelAction(action.type)) {
		return purchasingUserReducer(modelState, action);
	}
	if (isReferenceDataModelAction(action.type)) {
		return referenceDataReducer(modelState, action);
	}
	if (isReferenceHeaderModelAction(action.type)) {
		return referenceHeaderReducer(modelState, action);
	}
	if (isRegistrationModelAction(action.type)) {
		return registrationReducer(modelState, action);
	}
	if (isRegistrationUserModelAction(action.type)) {
		return registrationUserReducer(modelState, action);
	}
	if (isRetailPharmacyModelAction(action.type)) {
		return retailPharmacyReducer(modelState, action);
	}
	if (isRetailPharmacyInvoiceModelAction(action.type)) {
		return retailPharmacyInvoiceReducer(modelState, action);
	}
	if (isRetailPharmacyStockDetailModelAction(action.type)) {
		return retailPharmacyStockDetailReducer(modelState, action);
	}
	if (isReturnSupplierModelAction(action.type)) {
		return returnSupplierReducer(modelState, action);
	}
	if (isReturnSupplierStockDetailModelAction(action.type)) {
		return returnSupplierStockDetailReducer(modelState, action);
	}
	if (isRoleModelAction(action.type)) {
		return roleReducer(modelState, action);
	}
	if (isRoomFacilityModelAction(action.type)) {
		return roomFacilityReducer(modelState, action);
	}
	if (isRoomTransferModelAction(action.type)) {
		return roomTransferReducer(modelState, action);
	}
	if (isSepModelAction(action.type)) {
		return sepReducer(modelState, action);
	}
	if (isSampleCollectionInformationModelAction(action.type)) {
		return sampleCollectionInformationReducer(modelState, action);
	}
	if (isSampleCollectionItemsModelAction(action.type)) {
		return sampleCollectionItemsReducer(modelState, action);
	}
	if (isSatuSehatConfigurationModelAction(action.type)) {
		return satuSehatConfigurationReducer(modelState, action);
	}
	if (isServiceModelAction(action.type)) {
		return serviceReducer(modelState, action);
	}
	if (isServiceFacilityCategoryModelAction(action.type)) {
		return serviceFacilityCategoryReducer(modelState, action);
	}
	if (isServiceItemModelAction(action.type)) {
		return serviceItemReducer(modelState, action);
	}
	if (isServiceItemAssignmentModelAction(action.type)) {
		return serviceItemAssignmentReducer(modelState, action);
	}
	if (isStaffModelAction(action.type)) {
		return staffReducer(modelState, action);
	}
	if (isStockCatalogueModelAction(action.type)) {
		return stockCatalogueReducer(modelState, action);
	}
	if (isStockControlModelAction(action.type)) {
		return stockControlReducer(modelState, action);
	}
	if (isStockTransactionDetailModelAction(action.type)) {
		return stockTransactionDetailReducer(modelState, action);
	}
	if (isStockTransactionPerDateModelAction(action.type)) {
		return stockTransactionPerDateReducer(modelState, action);
	}
	if (isStockTransactionPerDateTypeModelAction(action.type)) {
		return stockTransactionPerDateTypeReducer(modelState, action);
	}
	if (isSupplierModelAction(action.type)) {
		return supplierReducer(modelState, action);
	}
	if (isSupplierBankAccountModelAction(action.type)) {
		return supplierBankAccountReducer(modelState, action);
	}
	if (isSupplierContactDetailModelAction(action.type)) {
		return supplierContactDetailReducer(modelState, action);
	}
	if (isSupplierProductDetailModelAction(action.type)) {
		return supplierProductDetailReducer(modelState, action);
	}
	if (isSystemAdminUserModelAction(action.type)) {
		return systemAdminUserReducer(modelState, action);
	}
	if (isTariffDefinitionModelAction(action.type)) {
		return tariffDefinitionReducer(modelState, action);
	}
	if (isTariffDefinitionOtherComponentModelAction(action.type)) {
		return tariffDefinitionOtherComponentReducer(modelState, action);
	}
	if (isTariffFormulaModelAction(action.type)) {
		return tariffFormulaReducer(modelState, action);
	}
	if (isTariffPackageModelAction(action.type)) {
		return tariffPackageReducer(modelState, action);
	}
	if (isTariffPackageItemModelAction(action.type)) {
		return tariffPackageItemReducer(modelState, action);
	}
	if (isTariffPackageServiceAssignmentModelAction(action.type)) {
		return tariffPackageServiceAssignmentReducer(modelState, action);
	}
	if (isTariffSchemaModelAction(action.type)) {
		return tariffSchemaReducer(modelState, action);
	}
	if (isTaskDashboardModelAction(action.type)) {
		return taskDashboardReducer(modelState, action);
	}
	if (isTransactionDetailTypeModelAction(action.type)) {
		return transactionDetailTypeReducer(modelState, action);
	}
	if (isTransactionDetailTypeMappingModelAction(action.type)) {
		return transactionDetailTypeMappingReducer(modelState, action);
	}
	if (isTransferOrderModelAction(action.type)) {
		return transferOrderReducer(modelState, action);
	}
	if (isTransferOrderStockDetailModelAction(action.type)) {
		return transferOrderStockDetailReducer(modelState, action);
	}
	if (isUnitOfMeasurementModelAction(action.type)) {
		return unitOfMeasurementReducer(modelState, action);
	}
	if (isUserModelAction(action.type)) {
		return userReducer(modelState, action);
	}
	if (isVaccinationOrderModelAction(action.type)) {
		return vaccinationOrderReducer(modelState, action);
	}
	if (isVaccinationOrderDetailModelAction(action.type)) {
		return vaccinationOrderDetailReducer(modelState, action);
	}
	if (isVitalSignsModelAction(action.type)) {
		return vitalSignsReducer(modelState, action);
	}
	if (isWarehouseModelAction(action.type)) {
		return warehouseReducer(modelState, action);
	}
	if (isWarehouseInitialStockModelAction(action.type)) {
		return warehouseInitialStockReducer(modelState, action);
	}
	if (isWarehouseInventoryModelAction(action.type)) {
		return warehouseInventoryReducer(modelState, action);
	}
	if (isWarehouseUserModelAction(action.type)) {
		return warehouseUserReducer(modelState, action);
	}

	return modelState;
}

/**
 * All the reducers available in the application.
 */
export const reducers: ActionReducerMap<AppState> = {
	router: routerReducer,
	models: modelReducer,
	// % protected region % [Add any additional reducers here] off begin
	// % protected region % [Add any additional reducers here] end
};

/**
 * Meta-reducer used to clear out store when log out.
 */
export function clearState(reducer: (AppState, Action) => AppState): (AppState, Action) => AppState {
	return (state: AppState, action: Action) => {
		// % protected region % [Add any additional logic for clearState before the main body here] off begin
		// % protected region % [Add any additional logic for clearState before the main body here] end

		if (action.type === ActionTypes.LOGOUT) {
			state = {
				router: initialRouterState,
				models: initialModelState
			};
		}

		// % protected region % [Add any additional logic for clearState after the main body here] off begin
		// % protected region % [Add any additional logic for clearState after the main body here] end

		return reducer(state, action);
	};
}

// % protected region % [Add any additional stuffs here] off begin
// % protected region % [Add any additional stuffs here] end
